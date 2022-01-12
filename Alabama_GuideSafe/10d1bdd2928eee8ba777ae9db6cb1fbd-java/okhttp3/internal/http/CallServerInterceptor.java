package okhttp3.internal.http;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okio.BufferedSink;
import okio.Okio;
import okio.RealBufferedSink;

public final class CallServerInterceptor implements Interceptor {
    public final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        Response response;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange = realInterceptorChain.exchange();
        Request request = realInterceptorChain.request();
        long currentTimeMillis = System.currentTimeMillis();
        exchange.writeRequestHeaders(request);
        Response.Builder builder = null;
        if (!HttpMethod.permitsRequestBody(request.method()) || request.body() == null) {
            exchange.noRequestBody();
            z = false;
        } else {
            if ("100-continue".equalsIgnoreCase(request.header("Expect"))) {
                exchange.flushRequest();
                exchange.responseHeadersStart();
                builder = exchange.readResponseHeaders(true);
                z = true;
            } else {
                z = false;
            }
            if (builder != null) {
                exchange.noRequestBody();
                if (!exchange.connection().isMultiplexed()) {
                    exchange.noNewExchangesOnConnection();
                }
            } else if (request.body().isDuplex()) {
                exchange.flushRequest();
                request.body().writeTo(Okio.buffer(exchange.createRequestBody(request, true)));
            } else {
                BufferedSink buffer = Okio.buffer(exchange.createRequestBody(request, false));
                request.body().writeTo(buffer);
                ((RealBufferedSink) buffer).close();
            }
        }
        if (request.body() == null || !request.body().isDuplex()) {
            exchange.finishRequest();
        }
        if (!z) {
            exchange.responseHeadersStart();
        }
        if (builder == null) {
            builder = exchange.readResponseHeaders(false);
        }
        Response build = builder.request(request).handshake(exchange.connection().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int code = build.code();
        if (code == 100) {
            build = exchange.readResponseHeaders(false).request(request).handshake(exchange.connection().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = build.code();
        }
        exchange.responseHeadersEnd(build);
        if (!this.forWebSocket || code != 101) {
            response = build.newBuilder().body(exchange.openResponseBody(build)).build();
        } else {
            response = build.newBuilder().body(Util.EMPTY_RESPONSE).build();
        }
        if ("close".equalsIgnoreCase(response.request().header("Connection")) || "close".equalsIgnoreCase(response.header("Connection"))) {
            exchange.noNewExchangesOnConnection();
        }
        if ((code != 204 && code != 205) || response.body().contentLength() <= 0) {
            return response;
        }
        StringBuilder outline18 = GeneratedOutlineSupport.outline18("HTTP ", code, " had non-zero Content-Length: ");
        outline18.append(response.body().contentLength());
        throw new ProtocolException(outline18.toString());
    }
}
