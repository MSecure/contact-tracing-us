package okhttp3.internal.huc;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Timeout;

public abstract class OutputStreamRequestBody extends RequestBody {
    public boolean closed;
    public long expectedContentLength;
    public OutputStream outputStream;
    public Timeout timeout;

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.expectedContentLength;
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return null;
    }

    public void initOutputStream(final BufferedSink bufferedSink, final long j) {
        this.timeout = bufferedSink.timeout();
        this.expectedContentLength = j;
        this.outputStream = new OutputStream() {
            /* class okhttp3.internal.huc.OutputStreamRequestBody.AnonymousClass1 */
            public long bytesReceived;

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                OutputStreamRequestBody.this.closed = true;
                long j = j;
                if (j == -1 || this.bytesReceived >= j) {
                    bufferedSink.close();
                    return;
                }
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("expected ");
                outline17.append(j);
                outline17.append(" bytes but received ");
                outline17.append(this.bytesReceived);
                throw new ProtocolException(outline17.toString());
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                if (!OutputStreamRequestBody.this.closed) {
                    bufferedSink.flush();
                }
            }

            @Override // java.io.OutputStream
            public void write(int i) throws IOException {
                write(new byte[]{(byte) i}, 0, 1);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                if (!OutputStreamRequestBody.this.closed) {
                    long j = j;
                    if (j == -1 || this.bytesReceived + ((long) i2) <= j) {
                        this.bytesReceived += (long) i2;
                        try {
                            bufferedSink.write(bArr, i, i2);
                        } catch (InterruptedIOException e) {
                            throw new SocketTimeoutException(e.getMessage());
                        }
                    } else {
                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("expected ");
                        outline17.append(j);
                        outline17.append(" bytes but received ");
                        outline17.append(this.bytesReceived);
                        outline17.append(i2);
                        throw new ProtocolException(outline17.toString());
                    }
                } else {
                    throw new IOException("closed");
                }
            }
        };
    }

    public final boolean isClosed() {
        return this.closed;
    }

    public final OutputStream outputStream() {
        return this.outputStream;
    }

    public Request prepareToSendRequest(Request request) throws IOException {
        return request;
    }

    public final Timeout timeout() {
        return this.timeout;
    }
}
