package org.panda_lang.panda.core.syntax;

import org.panda_lang.panda.core.Particle;
import org.panda_lang.panda.core.parser.essential.GroupCenter;
import org.panda_lang.panda.core.syntax.block.VialBlock;

import java.util.HashMap;
import java.util.Map;

public class Vial {

    private final String vialName;
    private final Map<String, Method> methods;
    private final Map<String, Field> fields;
    private Executable constructor;
    private VialBlock vialBlock;
    private String extension;
    private Group group;

    public Vial(String vialName) {
        this.vialName = vialName;
        this.methods = new HashMap<>();
        this.fields = new HashMap<>();
        this.extension = "Object";
    }

    public Vial group(String groupName) {
        return group(GroupCenter.getGroup(groupName));
    }

    public Vial group(Group group) {
        this.group = group;
        this.group.registerVial(this);
        return this;
    }

    public Vial constructor(Executable executable) {
        this.constructor = executable;
        return this;
    }

    public Vial method(final Method method) {
        if (constructor == null && method.getName().equals(vialName)) {
            this.constructor(new Constructor() {
                @Override
                public Essence run(Particle particle) {
                    return method.run(particle);
                }
            });
        } else {
            methods.put(method.getName(), method);
        }
        return this;
    }

    public Vial extension(String s) {
        this.extension = s;
        return this;
    }

    public Essence call(String name, Particle particle) {
        Method method = getMethod(name);
        if (method == null) {
            System.out.println("Method '" + name + "' not found in instance of " + vialName);
            return null;
        }
        return method.run(particle);
    }

    public Essence initializeInstance(Particle particle) {
        Essence essence = new Essence(this);
        essence.initializeParticle(particle);
        if (constructor != null) {
            Essence instance = constructor.run(particle);
            if (instance != null) {
                essence = instance;
            }
        }
        return essence;
    }

    public void setVialBlock(VialBlock vialBlock) {
        this.vialBlock = vialBlock;
    }

    public Method getMethod(String name) {
        Method method = methods.get(name);
        if (method == null && extension != null) {
            /* TODO: extension
            Vial vial = VialCenter.getVial(extension);
            if (vial != null) {
                method = vial.getMethod(name);
                if (method == null) {
                    extension = null;
                }
            }
            */
        }
        return method;
    }

    public Map<String, Field> getFields() {
        return fields;
    }

    public Map<String, Method> getMethods() {
        return methods;
    }

    public VialBlock getVialBlock() {
        return vialBlock;
    }

    public Group getGroup() {
        return group;
    }

    public String getName() {
        return vialName;
    }

}
