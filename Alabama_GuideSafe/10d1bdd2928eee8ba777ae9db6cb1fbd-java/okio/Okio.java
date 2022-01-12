package okio;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Okio {
    public static final Logger logger = Logger.getLogger(Okio.class.getName());

    public static Sink appendingSink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink blackhole() {
        return new Sink() {
            /* class okio.Okio.AnonymousClass3 */

            @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
            public void close() throws IOException {
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() throws IOException {
            }

            @Override // okio.Sink
            public Timeout timeout() {
                return Timeout.NONE;
            }

            @Override // okio.Sink
            public void write(Buffer buffer, long j) throws IOException {
                buffer.skip(j);
            }
        };
    }

    public static BufferedSource buffer(Source source) {
        return new RealBufferedSource(source);
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink sink(OutputStream outputStream) {
        return sink(outputStream, new Timeout());
    }

    public static Source source(InputStream inputStream) {
        return source(inputStream, new Timeout());
    }

    public static BufferedSink buffer(Sink sink) {
        return new RealBufferedSink(sink);
    }

    public static Sink sink(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream != null) {
            return new Sink() {
                /* class okio.Okio.AnonymousClass1 */

                @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
                public void close() throws IOException {
                    outputStream.close();
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() throws IOException {
                    outputStream.flush();
                }

                @Override // okio.Sink
                public Timeout timeout() {
                    return Timeout.this;
                }

                public String toString() {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("sink(");
                    outline17.append(outputStream);
                    outline17.append(")");
                    return outline17.toString();
                }

                @Override // okio.Sink
                public void write(Buffer buffer, long j) throws IOException {
                    Util.checkOffsetAndCount(buffer.size, 0, j);
                    while (j > 0) {
                        Timeout.this.throwIfReached();
                        Segment segment = buffer.head;
                        int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
                        outputStream.write(segment.data, segment.pos, min);
                        int i = segment.pos + min;
                        segment.pos = i;
                        long j2 = (long) min;
                        j -= j2;
                        buffer.size -= j2;
                        if (i == segment.limit) {
                            buffer.head = segment.pop();
                            SegmentPool.recycle(segment);
                        }
                    }
                }
            };
        }
        throw new IllegalArgumentException("out == null");
    }

    public static Source source(final InputStream inputStream, final Timeout timeout) {
        if (inputStream != null) {
            return new Source() {
                /* class okio.Okio.AnonymousClass2 */

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    inputStream.close();
                }

                @Override // okio.Source
                public long read(Buffer buffer, long j) throws IOException {
                    int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                    if (i < 0) {
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline7("byteCount < 0: ", j));
                    } else if (i == 0) {
                        return 0;
                    } else {
                        try {
                            Timeout.this.throwIfReached();
                            Segment writableSegment = buffer.writableSegment(1);
                            int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j, (long) (8192 - writableSegment.limit)));
                            if (read == -1) {
                                return -1;
                            }
                            writableSegment.limit += read;
                            long j2 = (long) read;
                            buffer.size += j2;
                            return j2;
                        } catch (AssertionError e) {
                            if (Okio.isAndroidGetsocknameError(e)) {
                                throw new IOException(e);
                            }
                            throw e;
                        }
                    }
                }

                @Override // okio.Source
                public Timeout timeout() {
                    return Timeout.this;
                }

                public String toString() {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("source(");
                    outline17.append(inputStream);
                    outline17.append(")");
                    return outline17.toString();
                }
            };
        }
        throw new IllegalArgumentException("in == null");
    }

    public static Sink sink(final Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            AnonymousClass4 r0 = new AsyncTimeout() {
                /* class okio.Okio.AnonymousClass4 */

                @Override // okio.AsyncTimeout
                public IOException newTimeoutException(IOException iOException) {
                    SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                    if (iOException != null) {
                        socketTimeoutException.initCause(iOException);
                    }
                    return socketTimeoutException;
                }

                @Override // okio.AsyncTimeout
                public void timedOut() {
                    try {
                        r1.close();
                    } catch (Exception e) {
                        Logger logger = Okio.logger;
                        Level level = Level.WARNING;
                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Failed to close timed out socket ");
                        outline17.append(r1);
                        logger.log(level, outline17.toString(), (Throwable) e);
                    } catch (AssertionError e2) {
                        if (Okio.isAndroidGetsocknameError(e2)) {
                            Logger logger2 = Okio.logger;
                            Level level2 = Level.WARNING;
                            StringBuilder outline172 = GeneratedOutlineSupport.outline17("Failed to close timed out socket ");
                            outline172.append(r1);
                            logger2.log(level2, outline172.toString(), (Throwable) e2);
                            return;
                        }
                        throw e2;
                    }
                }
            };
            return r0.sink(sink(socket.getOutputStream(), r0));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static Source source(File file) throws FileNotFoundException {
        if (file != null) {
            return source(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source source(final Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            AnonymousClass4 r0 = new AsyncTimeout() {
                /* class okio.Okio.AnonymousClass4 */

                @Override // okio.AsyncTimeout
                public IOException newTimeoutException(IOException iOException) {
                    SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                    if (iOException != null) {
                        socketTimeoutException.initCause(iOException);
                    }
                    return socketTimeoutException;
                }

                @Override // okio.AsyncTimeout
                public void timedOut() {
                    try {
                        socket.close();
                    } catch (Exception e) {
                        Logger logger = Okio.logger;
                        Level level = Level.WARNING;
                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Failed to close timed out socket ");
                        outline17.append(socket);
                        logger.log(level, outline17.toString(), (Throwable) e);
                    } catch (AssertionError e2) {
                        if (Okio.isAndroidGetsocknameError(e2)) {
                            Logger logger2 = Okio.logger;
                            Level level2 = Level.WARNING;
                            StringBuilder outline172 = GeneratedOutlineSupport.outline17("Failed to close timed out socket ");
                            outline172.append(socket);
                            logger2.log(level2, outline172.toString(), (Throwable) e2);
                            return;
                        }
                        throw e2;
                    }
                }
            };
            return r0.source(source(socket.getInputStream(), r0));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    public static Sink sink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }
}
