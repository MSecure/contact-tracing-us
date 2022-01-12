package okhttp3.logging;

import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

public final class HttpLoggingInterceptor implements Interceptor {
    public static final Charset UTF8 = Charset.forName(RNCWebViewManager.HTML_ENCODING);
    public volatile Set<String> headersToRedact;
    public volatile Level level;
    public final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = $$Lambda$HttpLoggingInterceptor$Logger$smmbr_QNvGsDM4WCreZZz8uMHLQ.INSTANCE;

        /* renamed from: okhttp3.logging.HttpLoggingInterceptor$Logger$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static /* synthetic */ void lambda$static$0(String str) {
                Platform.get().log(4, str, null);
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public static boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return str != null && !str.equalsIgnoreCase("identity") && !str.equalsIgnoreCase("gzip");
    }

    public static boolean isPlaintext(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, buffer.size < 64 ? buffer.size : 64);
            for (int i = 0; i < 16; i++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    private void logHeader(Headers headers, int i) {
        String value = this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i);
        Logger logger2 = this.logger;
        logger2.log(headers.name(i) + ": " + value);
    }

    public Level getLevel() {
        return this.level;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02e0, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02d4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        r2.inflaterSource.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02dc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02dd, code lost:
        r0.addSuppressed(r0);
     */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        long j;
        char c;
        String str2;
        String str3;
        Level level2 = this.level;
        Request request = chain.request();
        if (level2 == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z = true;
        boolean z2 = level2 == Level.BODY;
        boolean z3 = z2 || level2 == Level.HEADERS;
        RequestBody body = request.body();
        if (body == null) {
            z = false;
        }
        Connection connection = chain.connection();
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("--> ");
        outline17.append(request.method());
        outline17.append(' ');
        outline17.append(request.url());
        if (connection != null) {
            StringBuilder outline172 = GeneratedOutlineSupport.outline17(" ");
            outline172.append(connection.protocol());
            str = outline172.toString();
        } else {
            str = "";
        }
        outline17.append(str);
        String sb = outline17.toString();
        if (!z3 && z) {
            StringBuilder outline19 = GeneratedOutlineSupport.outline19(sb, " (");
            outline19.append(body.contentLength());
            outline19.append("-byte body)");
            sb = outline19.toString();
        }
        this.logger.log(sb);
        if (z3) {
            if (z) {
                if (body.contentType() != null) {
                    Logger logger2 = this.logger;
                    StringBuilder outline173 = GeneratedOutlineSupport.outline17("Content-Type: ");
                    outline173.append(body.contentType());
                    logger2.log(outline173.toString());
                }
                if (body.contentLength() != -1) {
                    Logger logger3 = this.logger;
                    StringBuilder outline174 = GeneratedOutlineSupport.outline17("Content-Length: ");
                    outline174.append(body.contentLength());
                    logger3.log(outline174.toString());
                }
            }
            Headers headers = request.headers();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                    logHeader(headers, i);
                }
            }
            if (!z2 || !z) {
                Logger logger4 = this.logger;
                StringBuilder outline175 = GeneratedOutlineSupport.outline17("--> END ");
                outline175.append(request.method());
                logger4.log(outline175.toString());
            } else if (bodyHasUnknownEncoding(request.headers())) {
                Logger logger5 = this.logger;
                StringBuilder outline176 = GeneratedOutlineSupport.outline17("--> END ");
                outline176.append(request.method());
                outline176.append(" (encoded body omitted)");
                logger5.log(outline176.toString());
            } else if (body.isDuplex()) {
                Logger logger6 = this.logger;
                StringBuilder outline177 = GeneratedOutlineSupport.outline17("--> END ");
                outline177.append(request.method());
                outline177.append(" (duplex request body omitted)");
                logger6.log(outline177.toString());
            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                Charset charset = UTF8;
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    charset = contentType.charset(UTF8);
                }
                this.logger.log("");
                if (isPlaintext(buffer)) {
                    this.logger.log(buffer.readString(charset));
                    Logger logger7 = this.logger;
                    StringBuilder outline178 = GeneratedOutlineSupport.outline17("--> END ");
                    outline178.append(request.method());
                    outline178.append(" (");
                    outline178.append(body.contentLength());
                    outline178.append("-byte body)");
                    logger7.log(outline178.toString());
                } else {
                    Logger logger8 = this.logger;
                    StringBuilder outline179 = GeneratedOutlineSupport.outline17("--> END ");
                    outline179.append(request.method());
                    outline179.append(" (binary ");
                    outline179.append(body.contentLength());
                    outline179.append("-byte body omitted)");
                    logger8.log(outline179.toString());
                }
            }
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            long contentLength = body2.contentLength();
            String str4 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            Logger logger9 = this.logger;
            StringBuilder outline1710 = GeneratedOutlineSupport.outline17("<-- ");
            outline1710.append(proceed.code());
            if (proceed.message().isEmpty()) {
                j = contentLength;
                c = ' ';
                str2 = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                j = contentLength;
                c = ' ';
                sb2.append(' ');
                sb2.append(proceed.message());
                str2 = sb2.toString();
            }
            outline1710.append(str2);
            outline1710.append(c);
            outline1710.append(proceed.request().url());
            outline1710.append(" (");
            outline1710.append(millis);
            outline1710.append("ms");
            if (!z3) {
                str3 = GeneratedOutlineSupport.outline11(", ", str4, " body");
            } else {
                str3 = "";
            }
            outline1710.append(str3);
            outline1710.append(')');
            logger9.log(outline1710.toString());
            if (z3) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    logHeader(headers2, i2);
                }
                if (!z2 || !HttpHeaders.hasBody(proceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyHasUnknownEncoding(proceed.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource source = body2.source();
                    source.request(RecyclerView.FOREVER_NS);
                    Buffer buffer2 = source.getBuffer();
                    Long l = null;
                    if ("gzip".equalsIgnoreCase(headers2.get("Content-Encoding"))) {
                        l = Long.valueOf(buffer2.size);
                        GzipSource gzipSource = new GzipSource(buffer2.clone());
                        buffer2 = new Buffer();
                        buffer2.writeAll(gzipSource);
                        gzipSource.inflaterSource.close();
                    }
                    Charset charset2 = UTF8;
                    MediaType contentType2 = body2.contentType();
                    if (contentType2 != null) {
                        charset2 = contentType2.charset(UTF8);
                    }
                    if (!isPlaintext(buffer2)) {
                        this.logger.log("");
                        Logger logger10 = this.logger;
                        StringBuilder outline1711 = GeneratedOutlineSupport.outline17("<-- END HTTP (binary ");
                        outline1711.append(buffer2.size);
                        outline1711.append("-byte body omitted)");
                        logger10.log(outline1711.toString());
                        return proceed;
                    }
                    if (j != 0) {
                        this.logger.log("");
                        this.logger.log(buffer2.clone().readString(charset2));
                    }
                    if (l != null) {
                        Logger logger11 = this.logger;
                        StringBuilder outline1712 = GeneratedOutlineSupport.outline17("<-- END HTTP (");
                        outline1712.append(buffer2.size);
                        outline1712.append("-byte, ");
                        outline1712.append(l);
                        outline1712.append("-gzipped-byte body)");
                        logger11.log(outline1712.toString());
                    } else {
                        Logger logger12 = this.logger;
                        StringBuilder outline1713 = GeneratedOutlineSupport.outline17("<-- END HTTP (");
                        outline1713.append(buffer2.size);
                        outline1713.append("-byte body)");
                        logger12.log(outline1713.toString());
                    }
                }
            }
            return proceed;
        } catch (Exception e) {
            this.logger.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    public void redactHeader(String str) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        treeSet.addAll(this.headersToRedact);
        treeSet.add(str);
        this.headersToRedact = treeSet;
    }

    public HttpLoggingInterceptor setLevel(Level level2) {
        if (level2 != null) {
            this.level = level2;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    public HttpLoggingInterceptor(Logger logger2) {
        this.headersToRedact = Collections.emptySet();
        this.level = Level.NONE;
        this.logger = logger2;
    }
}
