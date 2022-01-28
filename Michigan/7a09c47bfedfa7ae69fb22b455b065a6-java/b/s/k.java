package b.s;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import b.s.f;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public class k<T> extends LiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    public final h f2522a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f2523b;

    /* renamed from: c  reason: collision with root package name */
    public final Callable<T> f2524c;

    /* renamed from: d  reason: collision with root package name */
    public final e f2525d;

    /* renamed from: e  reason: collision with root package name */
    public final f.c f2526e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f2527f = new AtomicBoolean(true);

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f2528g = new AtomicBoolean(false);
    public final AtomicBoolean h = new AtomicBoolean(false);
    public final Runnable i = new a();
    public final Runnable j = new b();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            boolean z;
            if (k.this.h.compareAndSet(false, true)) {
                f invalidationTracker = k.this.f2522a.getInvalidationTracker();
                f.c cVar = k.this.f2526e;
                if (invalidationTracker != null) {
                    invalidationTracker.a(new f.e(invalidationTracker, cVar));
                } else {
                    throw null;
                }
            }
            do {
                if (k.this.f2528g.compareAndSet(false, true)) {
                    z = false;
                    T t = null;
                    while (k.this.f2527f.compareAndSet(true, false)) {
                        try {
                            try {
                                t = k.this.f2524c.call();
                                z = true;
                            } catch (Exception e2) {
                                throw new RuntimeException("Exception while computing database live data.", e2);
                            }
                        } finally {
                            k.this.f2528g.set(false);
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
            } while (k.this.f2527f.get());
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            boolean hasActiveObservers = k.this.hasActiveObservers();
            if (k.this.f2527f.compareAndSet(false, true) && hasActiveObservers) {
                k kVar = k.this;
                boolean z = kVar.f2523b;
                h hVar = kVar.f2522a;
                (z ? hVar.getTransactionExecutor() : hVar.getQueryExecutor()).execute(k.this.i);
            }
        }
    }

    public class c extends f.c {
        public c(String[] strArr) {
            super(strArr);
        }

        @Override // b.s.f.c
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
        this.f2522a = hVar;
        this.f2523b = z;
        this.f2524c = callable;
        this.f2525d = eVar;
        this.f2526e = new c(strArr);
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        this.f2525d.f2461a.add(this);
        (this.f2523b ? this.f2522a.getTransactionExecutor() : this.f2522a.getQueryExecutor()).execute(this.i);
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.f2525d.f2461a.remove(this);
    }
}
