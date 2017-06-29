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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.cactoos.Input;
import org.cactoos.Scalar;
import org.cactoos.func.UncheckedScalar;

/**
 * File as Input.
 *
 * <p>There is no thread-safety guarantee.
 *
 * @author Yegor Bugayenko (yegor256@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class FileAsInput implements Input {

    /**
     * The file.
     */
    private final UncheckedScalar<File> file;

    /**
     * Ctor.
     * @param src The file
     */
    public FileAsInput(final File src) {
        this(() -> src);
    }

    /**
     * Ctor.
     * @param src The file
     * @since 0.8
     */
    public FileAsInput(final Scalar<File> src) {
        this(new UncheckedScalar<>(src));
    }

    /**
     * Ctor.
     * @param src The file
     * @since 0.8
     */
    public FileAsInput(final UncheckedScalar<File> src) {
        this.file = src;
    }

    @Override
    public InputStream stream() throws FileNotFoundException {
        return new FileInputStream(this.file.value());
    }

}
