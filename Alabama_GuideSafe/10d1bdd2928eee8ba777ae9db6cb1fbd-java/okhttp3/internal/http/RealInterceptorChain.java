package okhttp3.internal.http;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.Transmitter;

public final class RealInterceptorChain implements Interceptor.Chain {
    public final Call call;
    public int calls;
    public final int connectTimeout;
    public final Exchange exchange;
    public final int index;
    public final List<Interceptor> interceptors;
    public final int readTimeout;
    public final Request request;
    public final Transmitter transmitter;
    public final int writeTimeout;

    public RealInterceptorChain(List<Interceptor> list, Transmitter transmitter2, Exchange exchange2, int i, Request request2, Call call2, int i2, int i3, int i4) {
        this.interceptors = list;
        this.transmitter = transmitter2;
        this.exchange = exchange2;
        this.index = i;
        this.request = request2;
        this.call = call2;
        this.connectTimeout = i2;
        this.readTimeout = i3;
        this.writeTimeout = i4;
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        Exchange exchange2 = this.exchange;
        if (exchange2 != null) {
            return exchange2.connection();
        }
        return null;
    }

    public Exchange exchange() {
        Exchange exchange2 = this.exchange;
        if (exchange2 != null) {
            return exchange2;
        }
        throw new IllegalStateException();
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request request2) throws IOException {
        return proceed(request2, this.transmitter, this.exchange);
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    public Transmitter transmitter() {
        return this.transmitter;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, Util.checkDuration("timeout", (long) i, timeUnit), this.readTimeout, this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, this.connectTimeout, Util.checkDuration("timeout", (long) i, timeUnit), this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, this.connectTimeout, this.readTimeout, Util.checkDuration("timeout", (long) i, timeUnit));
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public Response proceed(Request request2, Transmitter transmitter2, Exchange exchange2) throws IOException {
        if (this.index < this.interceptors.size()) {
            this.calls++;
            Exchange exchange3 = this.exchange;
            if (exchange3 != null && !exchange3.connection().supportsUrl(request2.url())) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("network interceptor ");
                outline17.append(this.interceptors.get(this.index - 1));
                outline17.append(" must retain the same host and port");
                throw new IllegalStateException(outline17.toString());
            } else if (this.exchange == null || this.calls <= 1) {
                RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, transmitter2, exchange2, this.index + 1, request2, this.call, this.connectTimeout, this.readTimeout, this.writeTimeout);
                Interceptor interceptor = this.interceptors.get(this.index);
                Response intercept = interceptor.intercept(realInterceptorChain);
                if (exchange2 != null && this.index + 1 < this.interceptors.size() && realInterceptorChain.calls != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (intercept == null) {
                    throw new NullPointerException("interceptor " + interceptor + " returned null");
                } else if (intercept.body() != null) {
                    return intercept;
                } else {
                    throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
                }
            } else {
                StringBuilder outline172 = GeneratedOutlineSupport.outline17("network interceptor ");
                outline172.append(this.interceptors.get(this.index - 1));
                outline172.append(" must call proceed() exactly once");
                throw new IllegalStateException(outline172.toString());
            }
        } else {
            throw new AssertionError();
        }
    }
}
