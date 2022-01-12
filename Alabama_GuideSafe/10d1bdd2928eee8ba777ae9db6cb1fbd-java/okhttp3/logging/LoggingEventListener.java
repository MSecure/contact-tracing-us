package okhttp3.logging;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public final class LoggingEventListener extends EventListener {
    public final HttpLoggingInterceptor.Logger logger;
    public long startNs;

    public static class Factory implements EventListener.Factory {
        public final HttpLoggingInterceptor.Logger logger;

        public Factory() {
            this(HttpLoggingInterceptor.Logger.DEFAULT);
        }

        @Override // okhttp3.EventListener.Factory
        public EventListener create(Call call) {
            return new LoggingEventListener(this.logger);
        }

        public Factory(HttpLoggingInterceptor.Logger logger2) {
            this.logger = logger2;
        }
    }

    private void logWithTime(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
        HttpLoggingInterceptor.Logger logger2 = this.logger;
        logger2.log("[" + millis + " ms] " + str);
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        logWithTime("callEnd");
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        logWithTime("callFailed: " + iOException);
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        this.startNs = System.nanoTime();
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("callStart: ");
        outline17.append(call.request());
        logWithTime(outline17.toString());
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        logWithTime("connectEnd: " + protocol);
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        logWithTime("connectFailed: " + protocol + " " + iOException);
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        logWithTime("connectStart: " + inetSocketAddress + " " + proxy);
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        logWithTime("connectionAcquired: " + connection);
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        logWithTime("connectionReleased");
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        logWithTime("dnsEnd: " + list);
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        logWithTime(GeneratedOutlineSupport.outline10("dnsStart: ", str));
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        logWithTime(GeneratedOutlineSupport.outline7("requestBodyEnd: byteCount=", j));
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        logWithTime("requestBodyStart");
    }

    @Override // okhttp3.EventListener
    public void requestFailed(Call call, IOException iOException) {
        logWithTime("requestFailed: " + iOException);
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        logWithTime("requestHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        logWithTime("requestHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        logWithTime(GeneratedOutlineSupport.outline7("responseBodyEnd: byteCount=", j));
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        logWithTime("responseBodyStart");
    }

    @Override // okhttp3.EventListener
    public void responseFailed(Call call, IOException iOException) {
        logWithTime("responseFailed: " + iOException);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        logWithTime("responseHeadersEnd: " + response);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        logWithTime("responseHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        logWithTime("secureConnectEnd: " + handshake);
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        logWithTime("secureConnectStart");
    }

    public LoggingEventListener(HttpLoggingInterceptor.Logger logger2) {
        this.logger = logger2;
    }
}
