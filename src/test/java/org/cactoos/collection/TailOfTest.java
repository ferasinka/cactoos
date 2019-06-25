/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2019 Yegor Bugayenko
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
package org.cactoos.collection;

import org.cactoos.iterable.IterableOf;
import org.hamcrest.core.AllOf;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.llorllale.cactoos.matchers.Assertion;

/**
 * Test case for {@link TailOf}.
 *
 * @since 0.31
 * @checkstyle JavadocMethodCheck (500 lines)
 */
public final class TailOfTest {

    @Test
    @SuppressWarnings("PMD.AvoidDuplicateLiterals")
    public void tailCollection() {
        new Assertion<>(
            "Can't get tail portion of collection",
            new TailOf<>(
                2,
                "one", "two", "three", "four"
            ),
            new AllOf<>(
                new IterableOf<org.hamcrest.Matcher<? super TailOf<String>>>(
                    new IsCollectionContaining<>(new IsEqual<>("three")),
                    new IsCollectionContaining<>(new IsEqual<>("four"))
                )
            )
        ).affirm();
    }
}
