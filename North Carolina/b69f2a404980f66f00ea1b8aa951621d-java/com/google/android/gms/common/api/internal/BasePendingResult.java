package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import b.b.k.i;
import c.b.a.a.c.k.e;
import c.b.a.a.c.k.f;
import c.b.a.a.c.k.g;
import c.b.a.a.c.k.i;
import c.b.a.a.c.k.j;
import c.b.a.a.c.k.l;
import c.b.a.a.c.k.m;
import c.b.a.a.c.k.o.f1;
import c.b.a.a.c.k.o.r0;
import c.b.a.a.c.k.o.u0;
import c.b.a.a.c.l.k;
import c.b.a.a.e.a.d;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends i> extends f<R> {
    public static final ThreadLocal<Boolean> zadr = new f1();
    @KeepName
    public b mResultGuardian;
    public Status mStatus;
    public R zacm;
    public final Object zads;
    public final a<R> zadt;
    public final WeakReference<e> zadu;
    public final CountDownLatch zadv;
    public final ArrayList<f.a> zadw;
    public j<? super R> zadx;
    public final AtomicReference<u0> zady;
    public volatile boolean zadz;
    public boolean zaea;
    public boolean zaeb;
    public k zaec;
    public volatile r0<R> zaed;
    public boolean zaee;

    public static class a<R extends i> extends d {
        public a() {
            super(Looper.getMainLooper());
        }

        public a(Looper looper) {
            super(looper);
        }

        public final void a(j<? super R> jVar, R r) {
            sendMessage(obtainMessage(1, new Pair(BasePendingResult.zaa(jVar), r)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: c.b.a.a.c.k.j */
        /* JADX WARN: Multi-variable type inference failed */
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                j jVar = (j) pair.first;
                i iVar = (i) pair.second;
                try {
                    jVar.a(iVar);
                } catch (RuntimeException e2) {
                    BasePendingResult.zab(iVar);
                    throw e2;
                }
            } else if (i != 2) {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).zab(Status.h);
            }
        }
    }

    public final class b {
        public b(f1 f1Var) {
        }

        public final void finalize() {
            BasePendingResult.zab(BasePendingResult.this.zacm);
            super.finalize();
        }
    }

    @Deprecated
    public BasePendingResult() {
        this.zads = new Object();
        this.zadv = new CountDownLatch(1);
        this.zadw = new ArrayList<>();
        this.zady = new AtomicReference<>();
        this.zaee = false;
        this.zadt = new a<>(Looper.getMainLooper());
        this.zadu = new WeakReference<>(null);
    }

    @Deprecated
    public BasePendingResult(Looper looper) {
        this.zads = new Object();
        this.zadv = new CountDownLatch(1);
        this.zadw = new ArrayList<>();
        this.zady = new AtomicReference<>();
        this.zaee = false;
        this.zadt = new a<>(looper);
        this.zadu = new WeakReference<>(null);
    }

    public BasePendingResult(e eVar) {
        this.zads = new Object();
        this.zadv = new CountDownLatch(1);
        this.zadw = new ArrayList<>();
        this.zady = new AtomicReference<>();
        this.zaee = false;
        this.zadt = new a<>(eVar != null ? eVar.b() : Looper.getMainLooper());
        this.zadu = new WeakReference<>(eVar);
    }

    public BasePendingResult(a<R> aVar) {
        this.zads = new Object();
        this.zadv = new CountDownLatch(1);
        this.zadw = new ArrayList<>();
        this.zady = new AtomicReference<>();
        this.zaee = false;
        i.j.t(aVar, "CallbackHandler must not be null");
        this.zadt = aVar;
        this.zadu = new WeakReference<>(null);
    }

    private final R get() {
        R r;
        synchronized (this.zads) {
            i.j.v(!this.zadz, "Result has already been consumed.");
            i.j.v(isReady(), "Result is not ready.");
            r = this.zacm;
            this.zacm = null;
            this.zadx = null;
            this.zadz = true;
        }
        u0 andSet = this.zady.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    public static <R extends c.b.a.a.c.k.i> j<R> zaa(j<R> jVar) {
        return jVar;
    }

    private final void zaa(R r) {
        this.zacm = r;
        this.zaec = null;
        this.zadv.countDown();
        this.mStatus = this.zacm.getStatus();
        if (this.zaea) {
            this.zadx = null;
        } else if (this.zadx != null) {
            this.zadt.removeMessages(2);
            this.zadt.a(this.zadx, get());
        } else if (this.zacm instanceof g) {
            this.mResultGuardian = new b(null);
        }
        ArrayList<f.a> arrayList = this.zadw;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            f.a aVar = arrayList.get(i);
            i++;
            aVar.a(this.mStatus);
        }
        this.zadw.clear();
    }

    public static void zab(c.b.a.a.c.k.i iVar) {
        if (iVar instanceof g) {
            try {
                ((g) iVar).a();
            } catch (RuntimeException unused) {
                String.valueOf(iVar).length();
            }
        }
    }

    @Override // c.b.a.a.c.k.f
    public final void addStatusListener(f.a aVar) {
        i.j.k(aVar != null, "Callback cannot be null.");
        synchronized (this.zads) {
            if (isReady()) {
                aVar.a(this.mStatus);
            } else {
                this.zadw.add(aVar);
            }
        }
    }

    @Override // c.b.a.a.c.k.f
    public final R await() {
        i.j.p("await must not be called on the UI thread");
        boolean z = true;
        i.j.v(!this.zadz, "Result has already been consumed");
        if (this.zaed != null) {
            z = false;
        }
        i.j.v(z, "Cannot await if then() has been called.");
        try {
            this.zadv.await();
        } catch (InterruptedException unused) {
            zab(Status.g);
        }
        i.j.v(isReady(), "Result is not ready.");
        return get();
    }

    @Override // c.b.a.a.c.k.f
    public final R await(long j, TimeUnit timeUnit) {
        if (j > 0) {
            i.j.p("await must not be called on the UI thread when time is greater than zero.");
        }
        boolean z = true;
        i.j.v(!this.zadz, "Result has already been consumed.");
        if (this.zaed != null) {
            z = false;
        }
        i.j.v(z, "Cannot await if then() has been called.");
        try {
            if (!this.zadv.await(j, timeUnit)) {
                zab(Status.h);
            }
        } catch (InterruptedException unused) {
            zab(Status.g);
        }
        i.j.v(isReady(), "Result is not ready.");
        return get();
    }

    @Override // c.b.a.a.c.k.f
    public void cancel() {
        synchronized (this.zads) {
            if (!this.zaea) {
                if (!this.zadz) {
                    if (this.zaec != null) {
                        try {
                            this.zaec.cancel();
                        } catch (RemoteException unused) {
                        }
                    }
                    zab(this.zacm);
                    this.zaea = true;
                    zaa(createFailedResult(Status.i));
                }
            }
        }
    }

    public abstract R createFailedResult(Status status);

    @Override // c.b.a.a.c.k.f
    public boolean isCanceled() {
        boolean z;
        synchronized (this.zads) {
            z = this.zaea;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zadv.getCount() == 0;
    }

    public final void setCancelToken(k kVar) {
        synchronized (this.zads) {
            this.zaec = kVar;
        }
    }

    public final void setResult(R r) {
        synchronized (this.zads) {
            if (this.zaeb || this.zaea) {
                zab(r);
                return;
            }
            isReady();
            boolean z = true;
            i.j.v(!isReady(), "Results have already been set");
            if (this.zadz) {
                z = false;
            }
            i.j.v(z, "Result has already been consumed");
            zaa(r);
        }
    }

    @Override // c.b.a.a.c.k.f
    public final void setResultCallback(j<? super R> jVar) {
        synchronized (this.zads) {
            if (jVar == null) {
                this.zadx = null;
                return;
            }
            boolean z = true;
            i.j.v(!this.zadz, "Result has already been consumed.");
            if (this.zaed != null) {
                z = false;
            }
            i.j.v(z, "Cannot set callbacks if then() has been called.");
            if (!isCanceled()) {
                if (isReady()) {
                    this.zadt.a(jVar, get());
                } else {
                    this.zadx = jVar;
                }
            }
        }
    }

    @Override // c.b.a.a.c.k.f
    public final void setResultCallback(j<? super R> jVar, long j, TimeUnit timeUnit) {
        synchronized (this.zads) {
            if (jVar == null) {
                this.zadx = null;
                return;
            }
            boolean z = true;
            i.j.v(!this.zadz, "Result has already been consumed.");
            if (this.zaed != null) {
                z = false;
            }
            i.j.v(z, "Cannot set callbacks if then() has been called.");
            if (!isCanceled()) {
                if (isReady()) {
                    this.zadt.a(jVar, get());
                } else {
                    this.zadx = jVar;
                    a<R> aVar = this.zadt;
                    aVar.sendMessageDelayed(aVar.obtainMessage(2, this), timeUnit.toMillis(j));
                }
            }
        }
    }

    @Override // c.b.a.a.c.k.f
    public <S extends c.b.a.a.c.k.i> m<S> then(l<? super R, ? extends S> lVar) {
        r0<? extends c.b.a.a.c.k.i> r0Var;
        i.j.v(!this.zadz, "Result has already been consumed.");
        synchronized (this.zads) {
            boolean z = false;
            i.j.v(this.zaed == null, "Cannot call then() twice.");
            i.j.v(this.zadx == null, "Cannot call then() if callbacks are set.");
            if (!this.zaea) {
                z = true;
            }
            i.j.v(z, "Cannot call then() if result was canceled.");
            this.zaee = true;
            this.zaed = new r0<>(this.zadu);
            r0<R> r0Var2 = this.zaed;
            synchronized (r0Var2.f2397e) {
                i.j.v(true, "Cannot call then() twice.");
                i.j.v(true, "Cannot call then() and andFinally() on the same TransformedResult.");
                r0Var2.f2393a = lVar;
                r0Var = new r0<>(r0Var2.g);
                r0Var2.f2394b = r0Var;
            }
            if (isReady()) {
                this.zadt.a(this.zaed, get());
            } else {
                this.zadx = this.zaed;
            }
        }
        return r0Var;
    }

    public final void zaa(u0 u0Var) {
        this.zady.set(u0Var);
    }

    public final void zab(Status status) {
        synchronized (this.zads) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.zaeb = true;
            }
        }
    }

    @Override // c.b.a.a.c.k.f
    public final Integer zal() {
        return null;
    }

    public final boolean zar() {
        boolean isCanceled;
        synchronized (this.zads) {
            if (this.zadu.get() == null || !this.zaee) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public final void zas() {
        this.zaee = this.zaee || zadr.get().booleanValue();
    }
}
