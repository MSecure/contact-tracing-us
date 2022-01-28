package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.d.k.e;
import c.b.a.a.d.k.f;
import c.b.a.a.d.k.g;
import c.b.a.a.d.k.i;
import c.b.a.a.d.k.j;
import c.b.a.a.d.k.l;
import c.b.a.a.d.k.m;
import c.b.a.a.d.k.o.c1;
import c.b.a.a.d.k.o.p0;
import c.b.a.a.d.k.o.r0;
import c.b.a.a.g.a.d;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends i> extends f<R> {
    public static final ThreadLocal<Boolean> zaa = new c1();
    @KeepName
    public b mResultGuardian;
    public final Object zab;
    public final a<R> zac;
    public final WeakReference<e> zad;
    public final CountDownLatch zae;
    public final ArrayList<f.a> zaf;
    public j<? super R> zag;
    public final AtomicReference<r0> zah;
    public R zai;
    public Status zaj;
    public volatile boolean zak;
    public boolean zal;
    public boolean zam;
    public c.b.a.a.d.m.i zan;
    public volatile p0<R> zao;
    public boolean zap;

    public static class a<R extends i> extends d {
        public a() {
            super(Looper.getMainLooper());
        }

        public a(@RecentlyNonNull Looper looper) {
            super(looper);
        }

        public final void a(@RecentlyNonNull j<? super R> jVar, @RecentlyNonNull R r) {
            j zab = BasePendingResult.zab(jVar);
            t.C(zab);
            sendMessage(obtainMessage(1, new Pair(zab, r)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: c.b.a.a.d.k.j */
        /* JADX WARN: Multi-variable type inference failed */
        public void handleMessage(@RecentlyNonNull Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                j jVar = (j) pair.first;
                i iVar = (i) pair.second;
                try {
                    jVar.a(iVar);
                } catch (RuntimeException e2) {
                    BasePendingResult.zaa(iVar);
                    throw e2;
                }
            } else if (i != 2) {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.i);
            }
        }
    }

    public final class b {
        public b(c1 c1Var) {
        }

        public final void finalize() {
            BasePendingResult.zaa(BasePendingResult.this.zai);
            super.finalize();
        }
    }

    @Deprecated
    public BasePendingResult() {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = new a<>(Looper.getMainLooper());
        this.zad = new WeakReference<>(null);
    }

    @Deprecated
    public BasePendingResult(@RecentlyNonNull Looper looper) {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = new a<>(looper);
        this.zad = new WeakReference<>(null);
    }

    public BasePendingResult(e eVar) {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = new a<>(eVar != null ? eVar.b() : Looper.getMainLooper());
        this.zad = new WeakReference<>(eVar);
    }

    public BasePendingResult(@RecentlyNonNull a<R> aVar) {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        t.D(aVar, "CallbackHandler must not be null");
        this.zac = aVar;
        this.zad = new WeakReference<>(null);
    }

    public static void zaa(i iVar) {
        if (iVar instanceof g) {
            try {
                ((g) iVar).a();
            } catch (RuntimeException unused) {
                String.valueOf(iVar).length();
            }
        }
    }

    public static <R extends i> j<R> zab(j<R> jVar) {
        return jVar;
    }

    private final void zab(R r) {
        this.zai = r;
        this.zaj = r.getStatus();
        this.zan = null;
        this.zae.countDown();
        if (this.zal) {
            this.zag = null;
        } else {
            j<? super R> jVar = this.zag;
            if (jVar != null) {
                this.zac.removeMessages(2);
                this.zac.a(jVar, zac());
            } else if (this.zai instanceof g) {
                this.mResultGuardian = new b(null);
            }
        }
        ArrayList<f.a> arrayList = this.zaf;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            f.a aVar = arrayList.get(i);
            i++;
            aVar.a(this.zaj);
        }
        this.zaf.clear();
    }

    private final R zac() {
        R r;
        synchronized (this.zab) {
            t.I(!this.zak, "Result has already been consumed.");
            t.I(isReady(), "Result is not ready.");
            r = this.zai;
            this.zai = null;
            this.zag = null;
            this.zak = true;
        }
        r0 andSet = this.zah.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        t.C(r);
        return r;
    }

    @Override // c.b.a.a.d.k.f
    public final void addStatusListener(@RecentlyNonNull f.a aVar) {
        t.r(aVar != null, "Callback cannot be null.");
        synchronized (this.zab) {
            if (isReady()) {
                aVar.a(this.zaj);
            } else {
                this.zaf.add(aVar);
            }
        }
    }

    @Override // c.b.a.a.d.k.f
    @RecentlyNonNull
    public final R await() {
        t.B("await must not be called on the UI thread");
        boolean z = true;
        t.I(!this.zak, "Result has already been consumed");
        if (this.zao != null) {
            z = false;
        }
        t.I(z, "Cannot await if then() has been called.");
        try {
            this.zae.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.h);
        }
        t.I(isReady(), "Result is not ready.");
        return zac();
    }

    @Override // c.b.a.a.d.k.f
    @RecentlyNonNull
    public final R await(@RecentlyNonNull long j, @RecentlyNonNull TimeUnit timeUnit) {
        if (j > 0) {
            t.B("await must not be called on the UI thread when time is greater than zero.");
        }
        boolean z = true;
        t.I(!this.zak, "Result has already been consumed.");
        if (this.zao != null) {
            z = false;
        }
        t.I(z, "Cannot await if then() has been called.");
        try {
            if (!this.zae.await(j, timeUnit)) {
                forceFailureUnlessReady(Status.i);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.h);
        }
        t.I(isReady(), "Result is not ready.");
        return zac();
    }

    @Override // c.b.a.a.d.k.f
    public void cancel() {
        synchronized (this.zab) {
            if (!this.zal) {
                if (!this.zak) {
                    if (this.zan != null) {
                        try {
                            this.zan.cancel();
                        } catch (RemoteException unused) {
                        }
                    }
                    zaa(this.zai);
                    this.zal = true;
                    zab(createFailedResult(Status.j));
                }
            }
        }
    }

    public abstract R createFailedResult(@RecentlyNonNull Status status);

    @Deprecated
    public final void forceFailureUnlessReady(@RecentlyNonNull Status status) {
        synchronized (this.zab) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.zam = true;
            }
        }
    }

    @Override // c.b.a.a.d.k.f
    @RecentlyNonNull
    public boolean isCanceled() {
        boolean z;
        synchronized (this.zab) {
            z = this.zal;
        }
        return z;
    }

    @RecentlyNonNull
    public final boolean isReady() {
        return this.zae.getCount() == 0;
    }

    public final void setCancelToken(@RecentlyNonNull c.b.a.a.d.m.i iVar) {
        synchronized (this.zab) {
            this.zan = iVar;
        }
    }

    public final void setResult(@RecentlyNonNull R r) {
        synchronized (this.zab) {
            if (this.zam || this.zal) {
                zaa(r);
                return;
            }
            isReady();
            boolean z = true;
            t.I(!isReady(), "Results have already been set");
            if (this.zak) {
                z = false;
            }
            t.I(z, "Result has already been consumed");
            zab(r);
        }
    }

    @Override // c.b.a.a.d.k.f
    public final void setResultCallback(j<? super R> jVar) {
        synchronized (this.zab) {
            if (jVar == null) {
                this.zag = null;
                return;
            }
            boolean z = true;
            t.I(!this.zak, "Result has already been consumed.");
            if (this.zao != null) {
                z = false;
            }
            t.I(z, "Cannot set callbacks if then() has been called.");
            if (!isCanceled()) {
                if (isReady()) {
                    this.zac.a(jVar, zac());
                } else {
                    this.zag = jVar;
                }
            }
        }
    }

    @Override // c.b.a.a.d.k.f
    public final void setResultCallback(@RecentlyNonNull j<? super R> jVar, @RecentlyNonNull long j, @RecentlyNonNull TimeUnit timeUnit) {
        synchronized (this.zab) {
            if (jVar == null) {
                this.zag = null;
                return;
            }
            boolean z = true;
            t.I(!this.zak, "Result has already been consumed.");
            if (this.zao != null) {
                z = false;
            }
            t.I(z, "Cannot set callbacks if then() has been called.");
            if (!isCanceled()) {
                if (isReady()) {
                    this.zac.a(jVar, zac());
                } else {
                    this.zag = jVar;
                    a<R> aVar = this.zac;
                    aVar.sendMessageDelayed(aVar.obtainMessage(2, this), timeUnit.toMillis(j));
                }
            }
        }
    }

    @Override // c.b.a.a.d.k.f
    @RecentlyNonNull
    public <S extends i> m<S> then(@RecentlyNonNull l<? super R, ? extends S> lVar) {
        m<S> b2;
        t.I(!this.zak, "Result has already been consumed.");
        synchronized (this.zab) {
            boolean z = false;
            t.I(this.zao == null, "Cannot call then() twice.");
            t.I(this.zag == null, "Cannot call then() if callbacks are set.");
            if (!this.zal) {
                z = true;
            }
            t.I(z, "Cannot call then() if result was canceled.");
            this.zap = true;
            this.zao = new p0<>(this.zad);
            b2 = this.zao.b(lVar);
            if (isReady()) {
                this.zac.a(this.zao, zac());
            } else {
                this.zag = this.zao;
            }
        }
        return b2;
    }

    public final void zaa(r0 r0Var) {
        this.zah.set(r0Var);
    }

    @RecentlyNonNull
    public final boolean zaa() {
        boolean isCanceled;
        synchronized (this.zab) {
            if (this.zad.get() == null || !this.zap) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public final void zab() {
        this.zap = this.zap || zaa.get().booleanValue();
    }
}
