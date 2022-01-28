package c.b.a.a.d.k;

import androidx.annotation.RecentlyNonNull;
import c.b.a.a.d.k.i;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;

public abstract class f<R extends i> {

    public interface a {
        void a(@RecentlyNonNull Status status);
    }

    public void addStatusListener(@RecentlyNonNull a aVar) {
        throw new UnsupportedOperationException();
    }

    public abstract R await();

    public abstract R await(@RecentlyNonNull long j, @RecentlyNonNull TimeUnit timeUnit);

    public abstract void cancel();

    @RecentlyNonNull
    public abstract boolean isCanceled();

    public abstract void setResultCallback(@RecentlyNonNull j<? super R> jVar);

    public abstract void setResultCallback(@RecentlyNonNull j<? super R> jVar, @RecentlyNonNull long j, @RecentlyNonNull TimeUnit timeUnit);

    public <S extends i> m<S> then(@RecentlyNonNull l<? super R, ? extends S> lVar) {
        throw new UnsupportedOperationException();
    }
}
