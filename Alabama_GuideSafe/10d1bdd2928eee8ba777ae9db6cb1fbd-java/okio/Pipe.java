package okio;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;

public final class Pipe {
    public final Buffer buffer = new Buffer();
    public Sink foldedSink;
    public final long maxBufferSize;
    public final Sink sink = new PipeSink();
    public boolean sinkClosed;
    public final Source source = new PipeSource();
    public boolean sourceClosed;

    public final class PipeSink implements Sink {
        public final PushableTimeout timeout = new PushableTimeout();

        public PipeSink() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
            if (r1 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
            r5.timeout.push(r1.timeout());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
            r5.timeout.pop();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
        public void close() throws IOException {
            Sink sink;
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sinkClosed) {
                    if (Pipe.this.foldedSink != null) {
                        sink = Pipe.this.foldedSink;
                    } else {
                        if (Pipe.this.sourceClosed) {
                            if (Pipe.this.buffer.size > 0) {
                                throw new IOException("source is closed");
                            }
                        }
                        Pipe.this.sinkClosed = true;
                        Pipe.this.buffer.notifyAll();
                        sink = null;
                    }
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Sink sink;
            synchronized (Pipe.this.buffer) {
                if (Pipe.this.sinkClosed) {
                    throw new IllegalStateException("closed");
                } else if (Pipe.this.foldedSink != null) {
                    sink = Pipe.this.foldedSink;
                } else {
                    if (Pipe.this.sourceClosed) {
                        if (Pipe.this.buffer.size > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                    sink = null;
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.flush();
                } finally {
                    this.timeout.pop();
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            Sink sink;
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sinkClosed) {
                    while (true) {
                        if (j <= 0) {
                            sink = null;
                            break;
                        } else if (Pipe.this.foldedSink != null) {
                            sink = Pipe.this.foldedSink;
                            break;
                        } else if (!Pipe.this.sourceClosed) {
                            long j2 = Pipe.this.maxBufferSize - Pipe.this.buffer.size;
                            if (j2 == 0) {
                                this.timeout.waitUntilNotified(Pipe.this.buffer);
                            } else {
                                long min = Math.min(j2, j);
                                Pipe.this.buffer.write(buffer, min);
                                j -= min;
                                Pipe.this.buffer.notifyAll();
                            }
                        } else {
                            throw new IOException("source is closed");
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.write(buffer, j);
                } finally {
                    this.timeout.pop();
                }
            }
        }
    }

    public final class PipeSource implements Source {
        public final Timeout timeout = new Timeout();

        public PipeSource() {
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Pipe.this.buffer) {
                Pipe.this.sourceClosed = true;
                Pipe.this.buffer.notifyAll();
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sourceClosed) {
                    while (Pipe.this.buffer.size == 0) {
                        if (Pipe.this.sinkClosed) {
                            return -1;
                        }
                        this.timeout.waitUntilNotified(Pipe.this.buffer);
                    }
                    long read = Pipe.this.buffer.read(buffer, j);
                    Pipe.this.buffer.notifyAll();
                    return read;
                }
                throw new IllegalStateException("closed");
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    public Pipe(long j) {
        if (j >= 1) {
            this.maxBufferSize = j;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline7("maxBufferSize < 1: ", j));
    }
}
