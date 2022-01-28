package c.b.a.a.c.k;

import c.b.a.a.c.k.i;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;

public abstract class f<R extends i> {

    public interface a {
        void a(Status status);
    }

    public void addStatusListener(a aVar) {
        throw new UnsupportedOperationException();
    }

    public abstract R await();

    public abstract R await(long j, TimeUnit timeUnit);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(j<? super R> jVar);

    public abstract void setResultCallback(j<? super R> jVar, long j, TimeUnit timeUnit);

    public <S extends i> m<S> then(l<? super R, ? extends S> lVar) {
        throw new UnsupportedOperationException();
    }

    public Integer zal() {
        throw new UnsupportedOperationException();
    }
}
