/*
 * Copyright (c) 2015-2017 Dzikoysk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.panda.language.structure.prototype.scope;

import org.panda_lang.panda.framework.language.structure.Statement;
import org.panda_lang.panda.language.structure.prototype.scope.ClassScope;
import org.panda_lang.panda.language.structure.prototype.structure.ClassPrototype;

public class ClassReference implements Statement {

    private final ClassPrototype classPrototype;
    private final ClassScope classScope;

    public ClassReference(ClassPrototype classPrototype, ClassScope classScope) {
        this.classPrototype = classPrototype;
        this.classScope = classScope;
    }

    public ClassScope getClassScope() {
        return classScope;
    }

    public ClassPrototype getClassPrototype() {
        return classPrototype;
    }

    @Override
    public String toString() {
        return "'class-reference': '" + classPrototype.getClassName() + "': { " + classPrototype.toString() + " }";
    }

}
