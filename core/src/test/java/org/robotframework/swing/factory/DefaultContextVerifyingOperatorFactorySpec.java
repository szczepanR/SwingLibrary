/*
 * Copyright 2008 Nokia Siemens Networks Oyj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.robotframework.swing.factory;

import jdave.junit4.JDaveRunner;

import org.jmock.Expectations;
import org.junit.runner.RunWith;
import org.robotframework.swing.context.DefaultContextVerifier;
import org.robotframework.swing.keyword.MockSupportSpecification;

/**
 * @author Heikki Hulkko
 */
@RunWith(JDaveRunner.class)
public class DefaultContextVerifyingOperatorFactorySpec extends MockSupportSpecification<DefaultContextVerifyingOperatorFactory<Object>> {
    public class Any {
        public DefaultContextVerifyingOperatorFactory<Object> create() {
            return new DefaultContextVerifyingOperatorFactory<Object>() {
                public Object createOperatorByIndex(int index) {
                    return null;
                }

                public Object createOperatorByName(String name) {
                    return null;
                }
            };
        }
        
        public void verifiesContext() {
            final DefaultContextVerifier contextVerifier = injectMockToContext("contextVerifier", DefaultContextVerifier.class);
            checking(new Expectations() {{
                one(contextVerifier).verifyContext();
            }});
            
            context.createOperator("someComponent");
        }
    }
}