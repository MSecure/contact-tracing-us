package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public abstract class RequestBody {
    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = StandardCharsets.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        return create(mediaType, str.getBytes(charset));
    }

    public long contentLength() throws IOException {
        return -1;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static RequestBody create(final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() {
            /* class okhttp3.RequestBody.AnonymousClass1 */

            @Override // okhttp3.RequestBody
            public long contentLength() throws IOException {
                return (long) byteString.size();
            }

            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(byteString);
            }
        };
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            return new RequestBody() {
                /* class okhttp3.RequestBody.AnonymousClass2 */

                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return (long) i2;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    bufferedSink.write(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() {
                /* class okhttp3.RequestBody.AnonymousClass3 */

                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
                    ((okio.Okio.AnonymousClass2) r0).val$in.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
                    r3.addSuppressed(r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
                    throw r1;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
                    r1 = move-exception;
                 */
                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    Source source = Okio.source(file);
                    bufferedSink.writeAll(source);
                    r1.close();
                }
            };
        }
        throw new NullPointerException("file == null");
    }
}
