package c.b.a.a.d.k.o;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b.x.t;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.a.b;
import c.b.a.a.d.k.e;
import c.b.a.a.d.k.i;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

public abstract class d<R extends i, A extends a.b> extends BasePendingResult<R> implements e<R> {
    public final a<?> mApi;
    public final a.c<A> mClientKey;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated
    public d(@RecentlyNonNull a.c<A> cVar, @RecentlyNonNull e eVar) {
        super(eVar);
        t.D(eVar, "GoogleApiClient must not be null");
        t.C(cVar);
        this.mClientKey = cVar;
        this.mApi = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(@RecentlyNonNull a<?> aVar, @RecentlyNonNull e eVar) {
        super(eVar);
        t.D(eVar, "GoogleApiClient must not be null");
        t.D(aVar, "Api must not be null");
        this.mClientKey = aVar.f2939b;
        this.mApi = aVar;
    }

    public d(@RecentlyNonNull BasePendingResult.a<R> aVar) {
        super(aVar);
        this.mClientKey = new a.c<>();
        this.mApi = null;
    }

    private void setFailedResult(RemoteException remoteException) {
        setFailedResult(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    public abstract void doExecute(@RecentlyNonNull A a2);

    @RecentlyNullable
    public final a<?> getApi() {
        return this.mApi;
    }

    @RecentlyNonNull
    public final a.c<A> getClientKey() {
        return this.mClientKey;
    }

    public void onSetFailedResult(@RecentlyNonNull R r) {
    }

    public final void run(@RecentlyNonNull A a2) {
        try {
            doExecute(a2);
        } catch (DeadObjectException e2) {
            setFailedResult(e2);
            throw e2;
        } catch (RemoteException e3) {
            setFailedResult(e3);
        }
    }

    @Override // c.b.a.a.d.k.o.e
    public final void setFailedResult(@RecentlyNonNull Status status) {
        t.r(!status.t(), "Failed result must not be success");
        R createFailedResult = createFailedResult(status);
        setResult((i) createFailedResult);
        onSetFailedResult(createFailedResult);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.b.a.a.d.k.o.d<R extends c.b.a.a.d.k.i, A extends c.b.a.a.d.k.a$b> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.a.a.d.k.o.e
    public /* bridge */ /* synthetic */ void setResult(@RecentlyNonNull Object obj) {
        super.setResult((i) obj);
    }
}
