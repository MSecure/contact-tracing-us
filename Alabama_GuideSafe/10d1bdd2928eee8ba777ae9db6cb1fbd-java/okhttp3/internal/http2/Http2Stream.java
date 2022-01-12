package okhttp3.internal.http2;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Stream {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public long bytesLeftInWriteWindow;
    public final Http2Connection connection;
    public ErrorCode errorCode;
    public IOException errorException;
    public boolean hasResponseHeaders;
    public final Deque<Headers> headersQueue = new ArrayDeque();
    public final int id;
    public final StreamTimeout readTimeout = new StreamTimeout();
    public final FramingSink sink;
    public final FramingSource source;
    public long unacknowledgedBytesRead = 0;
    public final StreamTimeout writeTimeout = new StreamTimeout();

    public final class FramingSink implements Sink {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final long EMIT_BUFFER_SIZE = 16384;
        public boolean closed;
        public boolean finished;
        public final Buffer sendBuffer = new Buffer();
        public Headers trailers;

        public FramingSink() {
        }

        /* JADX INFO: finally extract failed */
        private void emitFrame(boolean z) throws IOException {
            long min;
            boolean z2;
            synchronized (Http2Stream.this) {
                Http2Stream.this.writeTimeout.enter();
                while (Http2Stream.this.bytesLeftInWriteWindow <= 0 && !this.finished && !this.closed && Http2Stream.this.errorCode == null) {
                    try {
                        Http2Stream.this.waitForIo();
                    } catch (Throwable th) {
                        Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                Http2Stream.this.checkOutNotClosed();
                min = Math.min(Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.size);
                Http2Stream.this.bytesLeftInWriteWindow -= min;
            }
            Http2Stream.this.writeTimeout.enter();
            if (z) {
                try {
                    if (min == this.sendBuffer.size) {
                        z2 = true;
                        Http2Stream.this.connection.writeData(Http2Stream.this.id, z2, this.sendBuffer, min);
                        Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                    }
                } catch (Throwable th2) {
                    Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                    throw th2;
                }
            }
            z2 = false;
            Http2Stream.this.connection.writeData(Http2Stream.this.id, z2, this.sendBuffer, min);
            Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            if (r8.sendBuffer.size <= 0) goto L_0x0020;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r8.trailers == null) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
            if (r3 == false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
            if (r8.sendBuffer.size <= 0) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
            emitFrame(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
            r0 = r8.this$0;
            r0.connection.writeHeaders(r0.id, true, okhttp3.internal.Util.toHeaderBlock(r8.trailers));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
            if (r0 == false) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
            if (r8.sendBuffer.size <= 0) goto L_0x0061;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
            emitFrame(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
            r0 = r8.this$0;
            r0.connection.writeData(r0.id, true, null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
            r2 = r8.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0063, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r8.closed = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0066, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0067, code lost:
            r8.this$0.connection.flush();
            r8.this$0.cancelStreamIfNecessary();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0073, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r8.this$0.sink.finished != false) goto L_0x0061;
         */
        @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
        public void close() throws IOException {
            synchronized (Http2Stream.this) {
                if (this.closed) {
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.size > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return Http2Stream.this.writeTimeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            this.sendBuffer.write(buffer, j);
            while (this.sendBuffer.size >= EMIT_BUFFER_SIZE) {
                emitFrame(false);
            }
        }
    }

    public final class FramingSource implements Source {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public boolean closed;
        public boolean finished;
        public final long maxByteCount;
        public final Buffer readBuffer = new Buffer();
        public final Buffer receiveBuffer = new Buffer();
        public Headers trailers;

        public FramingSource(long j) {
            this.maxByteCount = j;
        }

        private void updateConnectionFlowControl(long j) {
            Http2Stream.this.connection.updateConnectionFlowControl(j);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long j;
            synchronized (Http2Stream.this) {
                this.closed = true;
                j = this.readBuffer.size;
                this.readBuffer.clear();
                Http2Stream.this.notifyAll();
            }
            if (j > 0) {
                updateConnectionFlowControl(j);
            }
            Http2Stream.this.cancelStreamIfNecessary();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            Throwable th;
            long read;
            if (j >= 0) {
                while (true) {
                    th = null;
                    synchronized (Http2Stream.this) {
                        Http2Stream.this.readTimeout.enter();
                        try {
                            if (Http2Stream.this.errorCode != null) {
                                if (Http2Stream.this.errorException != null) {
                                    th = Http2Stream.this.errorException;
                                } else {
                                    th = new StreamResetException(Http2Stream.this.errorCode);
                                }
                            }
                            if (this.closed) {
                                throw new IOException("stream closed");
                            } else if (this.readBuffer.size > 0) {
                                read = this.readBuffer.read(buffer, Math.min(j, this.readBuffer.size));
                                Http2Stream.this.unacknowledgedBytesRead += read;
                                if (th == null && Http2Stream.this.unacknowledgedBytesRead >= ((long) (Http2Stream.this.connection.okHttpSettings.getInitialWindowSize() / 2))) {
                                    Http2Stream.this.connection.writeWindowUpdateLater(Http2Stream.this.id, Http2Stream.this.unacknowledgedBytesRead);
                                    Http2Stream.this.unacknowledgedBytesRead = 0;
                                }
                            } else if (this.finished || th != null) {
                                read = -1;
                            } else {
                                Http2Stream.this.waitForIo();
                            }
                        } finally {
                            Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                        }
                    }
                }
                read = -1;
                Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                if (read != -1) {
                    updateConnectionFlowControl(read);
                    return read;
                } else if (th == null) {
                    return -1;
                } else {
                    throw th;
                }
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline7("byteCount < 0: ", j));
            }
        }

        public void receive(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j2;
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.size + j > this.maxByteCount;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j);
                    return;
                } else {
                    long read = bufferedSource.read(this.receiveBuffer, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (Http2Stream.this) {
                            if (this.closed) {
                                j2 = this.receiveBuffer.size;
                                this.receiveBuffer.clear();
                            } else {
                                if (this.readBuffer.size != 0) {
                                    z2 = false;
                                }
                                this.readBuffer.writeAll(this.receiveBuffer);
                                if (z2) {
                                    Http2Stream.this.notifyAll();
                                }
                                j2 = 0;
                            }
                        }
                        if (j2 > 0) {
                            updateConnectionFlowControl(j2);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return Http2Stream.this.readTimeout;
        }
    }

    public class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

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
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.connection.sendDegradedPingLater();
        }
    }

    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, Headers headers) {
        if (http2Connection != null) {
            this.id = i;
            this.connection = http2Connection;
            this.bytesLeftInWriteWindow = (long) http2Connection.peerSettings.getInitialWindowSize();
            this.source = new FramingSource((long) http2Connection.okHttpSettings.getInitialWindowSize());
            FramingSink framingSink = new FramingSink();
            this.sink = framingSink;
            this.source.finished = z2;
            framingSink.finished = z;
            if (headers != null) {
                this.headersQueue.add(headers);
            }
            if (isLocallyInitiated() && headers != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!isLocallyInitiated() && headers == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    private boolean closeInternal(ErrorCode errorCode2, IOException iOException) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode2;
            this.errorException = iOException;
            notifyAll();
            this.connection.removeStream(this.id);
            return true;
        }
    }

    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void cancelStreamIfNecessary() throws IOException {
        boolean z;
        boolean isOpen;
        synchronized (this) {
            z = !this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed);
            isOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL, null);
        } else if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    public void checkOutNotClosed() throws IOException {
        FramingSink framingSink = this.sink;
        if (framingSink.closed) {
            throw new IOException("stream closed");
        } else if (framingSink.finished) {
            throw new IOException("stream finished");
        } else if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.errorCode);
        }
    }

    public void close(ErrorCode errorCode2, IOException iOException) throws IOException {
        if (closeInternal(errorCode2, iOException)) {
            this.connection.writeSynReset(this.id, errorCode2);
        }
    }

    public void closeLater(ErrorCode errorCode2) {
        if (closeInternal(errorCode2, null)) {
            this.connection.writeSynResetLater(this.id, errorCode2);
        }
    }

    public void enqueueTrailers(Headers headers) {
        synchronized (this) {
            if (this.sink.finished) {
                throw new IllegalStateException("already finished");
            } else if (headers.size() != 0) {
                this.sink.trailers = headers;
            } else {
                throw new IllegalArgumentException("trailers.size() == 0");
            }
        }
    }

    public Http2Connection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.id;
    }

    public Sink getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders) {
                if (!isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.sink;
    }

    public Source getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        return this.connection.client == ((this.id & 1) == 1);
    }

    public synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.finished || this.source.closed) && ((this.sink.finished || this.sink.closed) && this.hasResponseHeaders)) {
            return false;
        }
        return true;
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    public void receiveData(BufferedSource bufferedSource, int i) throws IOException {
        this.source.receive(bufferedSource, (long) i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    public void receiveHeaders(Headers headers, boolean z) {
        boolean isOpen;
        synchronized (this) {
            if (this.hasResponseHeaders) {
                if (z) {
                    this.source.trailers = headers;
                    if (z) {
                        this.source.finished = true;
                    }
                    isOpen = isOpen();
                    notifyAll();
                }
            }
            this.hasResponseHeaders = true;
            this.headersQueue.add(headers);
            if (z) {
            }
            isOpen = isOpen();
            notifyAll();
        }
        if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    public synchronized void receiveRstStream(ErrorCode errorCode2) {
        if (this.errorCode == null) {
            this.errorCode = errorCode2;
            notifyAll();
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized Headers takeHeaders() throws IOException {
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (!this.headersQueue.isEmpty()) {
        } else if (this.errorException != null) {
            throw this.errorException;
        } else {
            throw new StreamResetException(this.errorCode);
        }
        return this.headersQueue.removeFirst();
    }

    public synchronized Headers trailers() throws IOException {
        if (this.errorCode != null) {
            if (this.errorException != null) {
                throw this.errorException;
            }
            throw new StreamResetException(this.errorCode);
        } else if (!this.source.finished || !this.source.receiveBuffer.exhausted() || !this.source.readBuffer.exhausted()) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        return this.source.trailers != null ? this.source.trailers : Util.EMPTY_HEADERS;
    }

    public void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public void writeHeaders(List<Header> list, boolean z, boolean z2) throws IOException {
        if (list != null) {
            synchronized (this) {
                this.hasResponseHeaders = true;
                if (z) {
                    this.sink.finished = true;
                }
            }
            if (!z2) {
                synchronized (this.connection) {
                    z2 = this.connection.bytesLeftInWriteWindow == 0;
                }
            }
            this.connection.writeHeaders(this.id, z, list);
            if (z2) {
                this.connection.flush();
                return;
            }
            return;
        }
        throw new NullPointerException("headers == null");
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }
}
