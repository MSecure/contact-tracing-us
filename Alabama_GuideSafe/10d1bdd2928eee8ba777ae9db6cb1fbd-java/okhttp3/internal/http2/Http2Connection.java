package okhttp3.internal.http2;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.RealBufferedSink;
import okio.RealBufferedSource;

public final class Http2Connection implements Closeable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int AWAIT_PING = 3;
    public static final int DEGRADED_PING = 2;
    public static final long DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    public static final ExecutorService listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    public long awaitPingsSent = 0;
    public long awaitPongsReceived = 0;
    public long bytesLeftInWriteWindow;
    public final boolean client;
    public final String connectionName;
    public final Set<Integer> currentPushRequests = new LinkedHashSet();
    public long degradedPingsSent = 0;
    public long degradedPongDeadlineNs = 0;
    public long degradedPongsReceived = 0;
    public long intervalPingsSent = 0;
    public long intervalPongsReceived = 0;
    public int lastGoodStreamId;
    public final Listener listener;
    public int nextStreamId;
    public Settings okHttpSettings = new Settings();
    public final Settings peerSettings = new Settings();
    public final ExecutorService pushExecutor;
    public final PushObserver pushObserver;
    public final ReaderRunnable readerRunnable;
    public boolean shutdown;
    public final Socket socket;
    public final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    public long unacknowledgedBytesRead = 0;
    public final Http2Writer writer;
    public final ScheduledExecutorService writerExecutor;

    public final class IntervalPingRunnable extends NamedRunnable {
        public IntervalPingRunnable() {
            super("OkHttp %s ping", Http2Connection.this.connectionName);
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            boolean z;
            synchronized (Http2Connection.this) {
                if (Http2Connection.this.intervalPongsReceived < Http2Connection.this.intervalPingsSent) {
                    z = true;
                } else {
                    Http2Connection.access$208(Http2Connection.this);
                    z = false;
                }
            }
            if (z) {
                Http2Connection.this.failConnection(null);
            } else {
                Http2Connection.this.writePing(false, 1, 0);
            }
        }
    }

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
            /* class okhttp3.internal.http2.Http2Connection.Listener.AnonymousClass1 */

            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(Http2Stream http2Stream) throws IOException {
                http2Stream.close(ErrorCode.REFUSED_STREAM, null);
            }
        };

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    public final class PingRunnable extends NamedRunnable {
        public final int payload1;
        public final int payload2;
        public final boolean reply;

        public PingRunnable(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.connectionName, Integer.valueOf(i), Integer.valueOf(i2));
            this.reply = z;
            this.payload1 = i;
            this.payload2 = i2;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            Http2Connection.this.writePing(this.reply, this.payload1, this.payload2);
        }
    }

    public class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        public final Http2Reader reader;

        public ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.connectionName);
            this.reader = http2Reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        public void applyAndAckSettings(boolean z, Settings settings) {
            Http2Stream[] http2StreamArr;
            long j;
            synchronized (Http2Connection.this.writer) {
                synchronized (Http2Connection.this) {
                    int initialWindowSize = Http2Connection.this.peerSettings.getInitialWindowSize();
                    if (z) {
                        Http2Connection.this.peerSettings.clear();
                    }
                    Http2Connection.this.peerSettings.merge(settings);
                    int initialWindowSize2 = Http2Connection.this.peerSettings.getInitialWindowSize();
                    http2StreamArr = null;
                    if (initialWindowSize2 == -1 || initialWindowSize2 == initialWindowSize) {
                        j = 0;
                    } else {
                        j = (long) (initialWindowSize2 - initialWindowSize);
                        if (!Http2Connection.this.streams.isEmpty()) {
                            http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                        }
                    }
                }
                try {
                    Http2Connection.this.writer.applyAndAckSettings(Http2Connection.this.peerSettings);
                } catch (IOException e) {
                    Http2Connection.this.failConnection(e);
                }
            }
            if (http2StreamArr != null) {
                for (Http2Stream http2Stream : http2StreamArr) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(j);
                    }
                }
            }
            Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.connectionName) {
                /* class okhttp3.internal.http2.Http2Connection.ReaderRunnable.AnonymousClass3 */

                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.listener.onSettings(http2Connection);
                }
            });
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (Http2Connection.this.pushedStream(i)) {
                Http2Connection.this.pushDataLater(i, bufferedSource, i2, z);
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                long j = (long) i2;
                Http2Connection.this.updateConnectionFlowControl(j);
                bufferedSource.skip(j);
                return;
            }
            stream.receiveData(bufferedSource, i2);
            if (z) {
                stream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            Throwable th;
            ErrorCode errorCode;
            ErrorCode errorCode2;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            try {
                this.reader.readConnectionPreface(this);
                while (this.reader.nextFrame(false, this)) {
                }
                errorCode = ErrorCode.NO_ERROR;
                try {
                    errorCode2 = ErrorCode.CANCEL;
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException e3) {
                e = e3;
                errorCode = errorCode3;
                try {
                    errorCode = ErrorCode.PROTOCOL_ERROR;
                    errorCode2 = ErrorCode.PROTOCOL_ERROR;
                    Http2Connection.this.close(errorCode, errorCode2, e);
                    Util.closeQuietly(this.reader);
                } catch (Throwable th2) {
                    th = th2;
                    Http2Connection.this.close(errorCode, errorCode3, e);
                    Util.closeQuietly(this.reader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                errorCode = errorCode3;
                Http2Connection.this.close(errorCode, errorCode3, e);
                Util.closeQuietly(this.reader);
                throw th;
            }
            Http2Connection.this.close(errorCode, errorCode2, e);
            Util.closeQuietly(this.reader);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                Http2Connection.this.shutdown = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z, int i, int i2, List<Header> list) {
            if (Http2Connection.this.pushedStream(i)) {
                Http2Connection.this.pushHeadersLater(i, list, z);
                return;
            }
            synchronized (Http2Connection.this) {
                Http2Stream stream = Http2Connection.this.getStream(i);
                if (stream != null) {
                    stream.receiveHeaders(Util.toHeaders(list), z);
                } else if (!Http2Connection.this.shutdown) {
                    if (i > Http2Connection.this.lastGoodStreamId) {
                        if (i % 2 != Http2Connection.this.nextStreamId % 2) {
                            final Http2Stream http2Stream = new Http2Stream(i, Http2Connection.this, false, z, Util.toHeaders(list));
                            Http2Connection.this.lastGoodStreamId = i;
                            Http2Connection.this.streams.put(Integer.valueOf(i), http2Stream);
                            Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{Http2Connection.this.connectionName, Integer.valueOf(i)}) {
                                /* class okhttp3.internal.http2.Http2Connection.ReaderRunnable.AnonymousClass1 */

                                @Override // okhttp3.internal.NamedRunnable
                                public void execute() {
                                    try {
                                        Http2Connection.this.listener.onStream(http2Stream);
                                    } catch (IOException e) {
                                        Platform platform = Platform.get();
                                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Http2Connection.Listener failure for ");
                                        outline17.append(Http2Connection.this.connectionName);
                                        platform.log(4, outline17.toString(), e);
                                        try {
                                            http2Stream.close(ErrorCode.PROTOCOL_ERROR, e);
                                        } catch (IOException unused) {
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z, int i, int i2) {
            if (z) {
                synchronized (Http2Connection.this) {
                    if (i == 1) {
                        try {
                            Http2Connection.access$108(Http2Connection.this);
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else if (i == 2) {
                        Http2Connection.access$608(Http2Connection.this);
                    } else if (i == 3) {
                        Http2Connection.access$708(Http2Connection.this);
                        Http2Connection.this.notifyAll();
                    }
                }
                return;
            }
            try {
                Http2Connection.this.writerExecutor.execute(new PingRunnable(true, i, i2));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i, int i2, List<Header> list) {
            Http2Connection.this.pushRequestLater(i2, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            if (Http2Connection.this.pushedStream(i)) {
                Http2Connection.this.pushResetLater(i, errorCode);
                return;
            }
            Http2Stream removeStream = Http2Connection.this.removeStream(i);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean z, final Settings settings) {
            try {
                Http2Connection.this.writerExecutor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.connectionName}) {
                    /* class okhttp3.internal.http2.Http2Connection.ReaderRunnable.AnonymousClass2 */

                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        ReaderRunnable.this.applyAndAckSettings(z, settings);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.bytesLeftInWriteWindow += j;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                }
            }
        }
    }

    public Http2Connection(Builder builder) {
        this.pushObserver = builder.pushObserver;
        boolean z = builder.client;
        this.client = z;
        this.listener = builder.listener;
        int i = z ? 1 : 2;
        this.nextStreamId = i;
        if (builder.client) {
            this.nextStreamId = i + 2;
        }
        if (builder.client) {
            this.okHttpSettings.set(7, OKHTTP_CLIENT_WINDOW_SIZE);
        }
        this.connectionName = builder.connectionName;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", this.connectionName), false));
        this.writerExecutor = scheduledThreadPoolExecutor;
        if (builder.pingIntervalMillis != 0) {
            IntervalPingRunnable intervalPingRunnable = new IntervalPingRunnable();
            int i2 = builder.pingIntervalMillis;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(intervalPingRunnable, (long) i2, (long) i2, TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", this.connectionName), true));
        this.peerSettings.set(7, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        this.peerSettings.set(5, 16384);
        this.bytesLeftInWriteWindow = (long) this.peerSettings.getInitialWindowSize();
        this.socket = builder.socket;
        this.writer = new Http2Writer(builder.sink, this.client);
        this.readerRunnable = new ReaderRunnable(new Http2Reader(builder.source, this.client));
    }

    public static /* synthetic */ long access$108(Http2Connection http2Connection) {
        long j = http2Connection.intervalPongsReceived;
        http2Connection.intervalPongsReceived = 1 + j;
        return j;
    }

    public static /* synthetic */ long access$208(Http2Connection http2Connection) {
        long j = http2Connection.intervalPingsSent;
        http2Connection.intervalPingsSent = 1 + j;
        return j;
    }

    public static /* synthetic */ long access$608(Http2Connection http2Connection) {
        long j = http2Connection.degradedPongsReceived;
        http2Connection.degradedPongsReceived = 1 + j;
        return j;
    }

    public static /* synthetic */ long access$708(Http2Connection http2Connection) {
        long j = http2Connection.awaitPongsReceived;
        http2Connection.awaitPongsReceived = 1 + j;
        return j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void failConnection(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        close(errorCode, errorCode, iOException);
    }

    private synchronized void pushExecutorExecute(NamedRunnable namedRunnable) {
        if (!this.shutdown) {
            this.pushExecutor.execute(namedRunnable);
        }
    }

    public synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public synchronized Http2Stream getStream(int i) {
        return this.streams.get(Integer.valueOf(i));
    }

    public synchronized boolean isHealthy(long j) {
        if (this.shutdown) {
            return false;
        }
        if (this.degradedPongsReceived >= this.degradedPingsSent || j < this.degradedPongDeadlineNs) {
            return true;
        }
        return false;
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    public Http2Stream newStream(List<Header> list, boolean z) throws IOException {
        return newStream(0, list, z);
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    public void pushDataLater(final int i, BufferedSource bufferedSource, final int i2, final boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        long j = (long) i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size == j) {
            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.connectionName, Integer.valueOf(i)}) {
                /* class okhttp3.internal.http2.Http2Connection.AnonymousClass6 */

                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean onData = Http2Connection.this.pushObserver.onData(i, buffer, i2, z);
                        if (onData) {
                            Http2Connection.this.writer.rstStream(i, ErrorCode.CANCEL);
                        }
                        if (onData || z) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size + " != " + i2);
    }

    public void pushHeadersLater(final int i, final List<Header> list, final boolean z) {
        try {
            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.connectionName, Integer.valueOf(i)}) {
                /* class okhttp3.internal.http2.Http2Connection.AnonymousClass5 */

                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    boolean onHeaders = Http2Connection.this.pushObserver.onHeaders(i, list, z);
                    if (onHeaders) {
                        try {
                            Http2Connection.this.writer.rstStream(i, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (onHeaders || z) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    public void pushRequestLater(final int i, final List<Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i));
            try {
                pushExecutorExecute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.connectionName, Integer.valueOf(i)}) {
                    /* class okhttp3.internal.http2.Http2Connection.AnonymousClass4 */

                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        if (Http2Connection.this.pushObserver.onRequest(i, list)) {
                            try {
                                Http2Connection.this.writer.rstStream(i, ErrorCode.CANCEL);
                                synchronized (Http2Connection.this) {
                                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public void pushResetLater(final int i, final ErrorCode errorCode) {
        pushExecutorExecute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.connectionName, Integer.valueOf(i)}) {
            /* class okhttp3.internal.http2.Http2Connection.AnonymousClass7 */

            @Override // okhttp3.internal.NamedRunnable
            public void execute() {
                Http2Connection.this.pushObserver.onReset(i, errorCode);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i));
                }
            }
        });
    }

    public Http2Stream pushStream(int i, List<Header> list, boolean z) throws IOException {
        if (!this.client) {
            return newStream(i, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    public boolean pushedStream(int i) {
        return i != 0 && (i & 1) == 0;
    }

    public synchronized Http2Stream removeStream(int i) {
        Http2Stream remove;
        remove = this.streams.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public void sendDegradedPingLater() {
        synchronized (this) {
            if (this.degradedPongsReceived >= this.degradedPingsSent) {
                this.degradedPingsSent++;
                this.degradedPongDeadlineNs = System.nanoTime() + DEGRADED_PONG_TIMEOUT_NS;
                try {
                    this.writerExecutor.execute(new NamedRunnable("OkHttp %s ping", this.connectionName) {
                        /* class okhttp3.internal.http2.Http2Connection.AnonymousClass3 */

                        @Override // okhttp3.internal.NamedRunnable
                        public void execute() {
                            Http2Connection.this.writePing(false, 2, 0);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                }
            }
        }
    }

    public void setSettings(Settings settings) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.okHttpSettings.merge(settings);
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.writer.settings(settings);
        }
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.shutdown = true;
                    this.writer.goAway(this.lastGoodStreamId, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public void start() throws IOException {
        start(true);
    }

    public synchronized void updateConnectionFlowControl(long j) {
        long j2 = this.unacknowledgedBytesRead + j;
        this.unacknowledgedBytesRead = j2;
        if (j2 >= ((long) (this.okHttpSettings.getInitialWindowSize() / 2))) {
            writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
            this.unacknowledgedBytesRead = 0;
        }
    }

    public void writeData(int i, boolean z, Buffer buffer, long j) throws IOException {
        int min;
        long j2;
        if (j == 0) {
            this.writer.data(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.bytesLeftInWriteWindow <= 0) {
                    try {
                        if (this.streams.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.bytesLeftInWriteWindow), this.writer.maxDataLength());
                j2 = (long) min;
                this.bytesLeftInWriteWindow -= j2;
            }
            j -= j2;
            this.writer.data(z && j == 0, i, buffer, min);
        }
    }

    public void writeHeaders(int i, boolean z, List<Header> list) throws IOException {
        this.writer.headers(z, i, list);
    }

    public void writePing(boolean z, int i, int i2) {
        try {
            this.writer.ping(z, i, i2);
        } catch (IOException e) {
            failConnection(e);
        }
    }

    public void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public void writeSynReset(int i, ErrorCode errorCode) throws IOException {
        this.writer.rstStream(i, errorCode);
    }

    public void writeSynResetLater(final int i, final ErrorCode errorCode) {
        try {
            this.writerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.connectionName, Integer.valueOf(i)}) {
                /* class okhttp3.internal.http2.Http2Connection.AnonymousClass1 */

                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.writeSynReset(i, errorCode);
                    } catch (IOException e) {
                        Http2Connection.this.failConnection(e);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    public void writeWindowUpdateLater(final int i, final long j) {
        try {
            this.writerExecutor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.connectionName, Integer.valueOf(i)}) {
                /* class okhttp3.internal.http2.Http2Connection.AnonymousClass2 */

                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.writer.windowUpdate(i, j);
                    } catch (IOException e) {
                        Http2Connection.this.failConnection(e);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    private Http2Stream newStream(int i, List<Header> list, boolean z) throws IOException {
        int i2;
        Http2Stream http2Stream;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.writer) {
            synchronized (this) {
                if (this.nextStreamId > 1073741823) {
                    shutdown(ErrorCode.REFUSED_STREAM);
                }
                if (!this.shutdown) {
                    i2 = this.nextStreamId;
                    this.nextStreamId += 2;
                    http2Stream = new Http2Stream(i2, this, z3, false, null);
                    if (z && this.bytesLeftInWriteWindow != 0) {
                        if (http2Stream.bytesLeftInWriteWindow != 0) {
                            z2 = false;
                            if (http2Stream.isOpen()) {
                                this.streams.put(Integer.valueOf(i2), http2Stream);
                            }
                        }
                    }
                    z2 = true;
                    if (http2Stream.isOpen()) {
                    }
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            if (i == 0) {
                this.writer.headers(z3, i2, list);
            } else if (!this.client) {
                this.writer.pushPromise(i, i2, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (z2) {
            this.writer.flush();
        }
        return http2Stream;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003a */
    public void close(ErrorCode errorCode, ErrorCode errorCode2, IOException iOException) {
        try {
            shutdown(errorCode);
        } catch (IOException unused) {
        }
        Http2Stream[] http2StreamArr = null;
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                http2StreamArr = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);
                this.streams.clear();
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(errorCode2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        this.writer.close();
        try {
            this.socket.close();
        } catch (IOException unused3) {
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
    }

    public void start(boolean z) throws IOException {
        if (z) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.windowUpdate(0, (long) (initialWindowSize - Settings.DEFAULT_INITIAL_WINDOW_SIZE));
            }
        }
        new Thread(this.readerRunnable).start();
    }

    public void writePing() {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }

    public static class Builder {
        public boolean client;
        public String connectionName;
        public Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        public int pingIntervalMillis;
        public PushObserver pushObserver = PushObserver.CANCEL;
        public BufferedSink sink;
        public Socket socket;
        public BufferedSource source;

        public Builder(boolean z) {
            this.client = z;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }

        public Builder listener(Listener listener2) {
            this.listener = listener2;
            return this;
        }

        public Builder pingIntervalMillis(int i) {
            this.pingIntervalMillis = i;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public Builder socket(Socket socket2) throws IOException {
            String str;
            SocketAddress remoteSocketAddress = socket2.getRemoteSocketAddress();
            if (remoteSocketAddress instanceof InetSocketAddress) {
                str = ((InetSocketAddress) remoteSocketAddress).getHostName();
            } else {
                str = remoteSocketAddress.toString();
            }
            return socket(socket2, str, new RealBufferedSource(Okio.source(socket2)), new RealBufferedSink(Okio.sink(socket2)));
        }

        public Builder socket(Socket socket2, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket2;
            this.connectionName = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }
    }
}
