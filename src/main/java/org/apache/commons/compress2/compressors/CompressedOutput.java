/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.commons.compress2.compressors;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

public interface CompressedOutput extends AutoCloseable {

    /**
     * Prepares for writing a new compressed channel.
     *
     * <p>The caller must then write the content to the channel and
     * close it to complete the process.</p>
     *
     * @return a channel to write the content to be compressed to
     * @throws IOException
     */
    WritableByteChannel startCompressing() throws IOException;

    /**
     * Finishes the addition of compressed channels to this output, without closing it.
     *
     * <p>Additional data can be written, if the format supports it.<p>
     *
     * @throws IOException
     */
    default void finish() throws IOException { }

    /**
     * Returns the current number of bytes written to this output.
     * @return the number of written bytes
     */
    long getBytesWritten();
}
