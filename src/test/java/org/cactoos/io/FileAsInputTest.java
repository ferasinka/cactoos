/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.cactoos.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.cactoos.text.BytesAsText;
import org.cactoos.text.StringAsText;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Test case for {@link FileAsInput}.
 *
 * @author Yegor Bugayenko (yegor256@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class FileAsInputTest {

    /**
     * FileAsInput can read file content.
     *
     * @throws IOException If some problem inside
     */
    @Test
    public void readsFileContent() throws IOException {
        final File temp = File.createTempFile("cactoos", "txt");
        temp.deleteOnExit();
        MatcherAssert.assertThat(
            new BytesAsText(
                new InputAsBytes(
                    new TeeInput(
                        new TextAsInput(
                            new StringAsText("Hello, друг!"),
                            StandardCharsets.UTF_8
                        ),
                        new FileAsOutput(temp)
                    )
                )
            ).asString(),
            Matchers.allOf(
                Matchers.equalTo(
                    new BytesAsText(
                        new InputAsBytes(
                            new FileAsInput(temp)
                        )
                    ).asString()
                ),
                Matchers.startsWith("Hello, "),
                Matchers.endsWith("друг!")
            )
        );
    }
}
