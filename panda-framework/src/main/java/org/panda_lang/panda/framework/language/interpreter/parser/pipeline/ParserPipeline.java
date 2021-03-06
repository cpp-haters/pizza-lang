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

package org.panda_lang.panda.framework.language.interpreter.parser.pipeline;

import org.panda_lang.panda.framework.language.interpreter.parser.UnifiedParser;
import org.panda_lang.panda.framework.language.interpreter.token.distributor.SourceStream;

import java.util.Collection;

public interface ParserPipeline {

    /**
     * @param sourceStream the source
     * @return parser which fits to the source
     */
    UnifiedParser handle(SourceStream sourceStream);

    /**
     * @param parserRepresentation specified parser representation which will be registered in the pipeline
     */
    void registerParserRepresentation(ParserRepresentation parserRepresentation);

    /**
     * @return a collection of registered parsers
     */
    Collection<ParserRepresentation> getRepresentations();

}
