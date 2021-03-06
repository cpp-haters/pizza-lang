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

package org.panda_lang.panda.core.structure;

import org.panda_lang.panda.core.structure.util.AbstractScript;
import org.panda_lang.panda.language.structure.overall.imports.ImportRegistry;
import org.panda_lang.panda.language.structure.overall.module.Module;

public class PandaScript extends AbstractScript {

    protected final ImportRegistry importRegistry;
    protected Module module;

    public PandaScript(String scriptName) {
        super(scriptName);
        this.importRegistry = new ImportRegistry();
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }

    public ImportRegistry getImportRegistry() {
        return importRegistry;
    }

}
