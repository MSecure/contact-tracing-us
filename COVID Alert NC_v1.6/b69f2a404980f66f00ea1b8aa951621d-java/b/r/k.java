package b.r;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import b.r.f;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public class k<T> extends LiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    public final h f1656a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f1657b;

    /* renamed from: c  reason: collision with root package name */
    public final Callable<T> f1658c;

    /* renamed from: d  reason: collision with root package name */
    public final e f1659d;

    /* renamed from: e  reason: collision with root package name */
    public final f.c f1660e;
    public final AtomicBoolean f = new AtomicBoolean(true);
    public final AtomicBoolean g = new AtomicBoolean(false);
    public final AtomicBoolean h = new AtomicBoolean(false);
    public final Runnable i = new a();
    public final Runnable j = new b();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            boolean z;
            if (k.this.h.compareAndSet(false, true)) {
                f invalidationTracker = k.this.f1656a.getInvalidationTracker();
                f.c cVar = k.this.f1660e;
                if (invalidationTracker != null) {
                    invalidationTracker.a(new f.e(invalidationTracker, cVar));
                } else {
                    throw null;
                }
            }
            do {
                if (k.this.g.compareAndSet(false, true)) {
                    z = false;
                    T t = null;
                    while (k.this.f.compareAndSet(true, false)) {
                        try {
                            try {
                                t = k.this.f1658c.call();
                                z = true;
                            } catch (Exception e2) {
                                throw new RuntimeException("Exception while computing database live data.", e2);
                            }
                        } finally {
                            k.this.g.set(false);
                        }
                    }
                    if (z) {
                        k.this.postValue(t);
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    return;
                }
            } while (k.this.f.get());
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            boolean hasActiveObservers = k.this.hasActiveObservers();
            if (k.this.f.compareAndSet(false, true) && hasActiveObservers) {
                k kVar = k.this;
                boolean z = kVar.f1657b;
                h hVar = kVar.f1656a;
                (z ? hVar.getTransactionExecutor() : hVar.getQueryExecutor()).execute(k.this.i);
            }
        }
    }

    public class c extends f.c {
        public c(String[] strArr) {
            super(strArr);
        }

        @Override // b.r.f.c
        public void b(Set<String> set) {
            b.c.a.a.a d2 = b.c.a.a.a.d();
            Runnable runnable = k.this.j;
            if (d2.b()) {
                runnable.run();
            } else {
                d2.c(runnable);
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    public k(h hVar, e eVar, boolean z, Callable<T> callable, String[] strArr) {
        this.f1656a = hVar;
        this.f1657b = z;
        this.f1658c = callable;
        this.f1659d = eVar;
        this.f1660e = new c(strArr);
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        this.f1659d.f1603a.add(this);
        (this.f1657b ? this.f1656a.getTransactionExecutor() : this.f1656a.getQueryExecutor()).execute(this.i);
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.f1659d.f1603a.remove(this);
    }
}
