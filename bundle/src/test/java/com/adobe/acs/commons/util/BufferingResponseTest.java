/*
 * #%L
 * ACS AEM Commons Bundle
 * %%
 * Copyright (C) 2014 Adobe
 * %%
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
 * #L%
 */
package com.adobe.acs.commons.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("deprecation")
public class BufferingResponseTest {

    @Mock
    private HttpServletResponse wrappedResponse;

    @Test
    public void testGetOuputStreamFails() throws IOException {
        BufferingResponse response = new BufferingResponse(wrappedResponse);
        response.getWriter();
        boolean thrown = false;
        try {
            response.getOutputStream();
        } catch (IllegalStateException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testGetWriterFails() throws IOException {
        BufferingResponse response = new BufferingResponse(wrappedResponse);
        response.getOutputStream();
        boolean thrown = false;
        try {
            response.getWriter();
        } catch (IllegalStateException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}
