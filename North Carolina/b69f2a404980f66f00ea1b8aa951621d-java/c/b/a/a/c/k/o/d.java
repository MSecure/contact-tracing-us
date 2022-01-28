package c.b.a.a.c.k.o;

import android.os.DeadObjectException;
import android.os.RemoteException;
import b.b.k.i;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.a.b;
import c.b.a.a.c.k.e;
import c.b.a.a.c.k.i;
import c.b.a.a.c.l.r;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

public abstract class d<R extends i, A extends a.b> extends BasePendingResult<R> implements e<R> {
    public final a<?> mApi;
    public final a.c<A> mClientKey;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated
    public d(a.c<A> cVar, e eVar) {
        super(eVar);
        i.j.t(eVar, "GoogleApiClient must not be null");
        i.j.s(cVar);
        this.mClientKey = cVar;
        this.mApi = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(a<?> aVar, e eVar) {
        super(eVar);
        i.j.t(eVar, "GoogleApiClient must not be null");
        i.j.t(aVar, "Api must not be null");
        a.g<?> gVar = aVar.f2302b;
        if (gVar != null) {
            this.mClientKey = gVar;
            this.mApi = aVar;
            return;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public d(BasePendingResult.a<R> aVar) {
        super(aVar);
        this.mClientKey = null;
        this.mApi = null;
    }

    private void setFailedResult(RemoteException remoteException) {
        setFailedResult(new Status(1, 8, remoteException.getLocalizedMessage(), null));
    }

    public abstract void doExecute(A a2);

    public final a<?> getApi() {
        return this.mApi;
    }

    public final a.c<A> getClientKey() {
        return this.mClientKey;
    }

    public void onSetFailedResult(R r) {
    }

    public final void run(A a2) {
        if (a2 instanceof r) {
            if (((r) a2) != null) {
                a2 = null;
            } else {
                throw null;
            }
        }
        try {
            doExecute(a2);
        } catch (DeadObjectException e2) {
            setFailedResult(e2);
            throw e2;
        } catch (RemoteException e3) {
            setFailedResult(e3);
        }
    }

    @Override // c.b.a.a.c.k.o.e
    public final void setFailedResult(Status status) {
        i.j.k(!status.p(), "Failed result must not be success");
        R createFailedResult = createFailedResult(status);
        setResult((c.b.a.a.c.k.i) createFailedResult);
        onSetFailedResult(createFailedResult);
    }

    @Override // c.b.a.a.c.k.o.e
    public abstract /* bridge */ /* synthetic */ void setResult(Object obj);
}
