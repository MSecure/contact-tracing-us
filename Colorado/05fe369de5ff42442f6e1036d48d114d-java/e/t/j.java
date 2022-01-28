package e.t;

import androidx.lifecycle.LiveData;
import e.t.f;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class j<T> extends LiveData<T> {

    /* renamed from: l  reason: collision with root package name */
    public final g f1728l;
    public final boolean m;
    public final Callable<T> n;
    public final e o;
    public final f.c p;
    public final AtomicBoolean q = new AtomicBoolean(true);
    public final AtomicBoolean r = new AtomicBoolean(false);
    public final AtomicBoolean s = new AtomicBoolean(false);
    public final Runnable t = new a();
    public final Runnable u = new b();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            boolean z;
            if (j.this.s.compareAndSet(false, true)) {
                j jVar = j.this;
                f fVar = jVar.f1728l.f1702e;
                f.c cVar = jVar.p;
                Objects.requireNonNull(fVar);
                fVar.a(new f.e(fVar, cVar));
            }
            do {
                if (j.this.r.compareAndSet(false, true)) {
                    T t = null;
                    z = false;
                    while (j.this.q.compareAndSet(true, false)) {
                        try {
                            try {
                                t = j.this.n.call();
                                z = true;
                            } catch (Exception e2) {
                                throw new RuntimeException("Exception while computing database live data.", e2);
                            }
                        } finally {
                            j.this.r.set(false);
                        }
                    }
                    if (z) {
                        j.this.j(t);
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    return;
                }
            } while (j.this.q.get());
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            Executor executor;
            boolean e2 = j.this.e();
            if (j.this.q.compareAndSet(false, true) && e2) {
                j jVar = j.this;
                if (jVar.m) {
                    executor = jVar.f1728l.c;
                } else {
                    executor = jVar.f1728l.b;
                }
                executor.execute(jVar.t);
            }
        }
    }

    public class c extends f.c {
        public c(String[] strArr) {
            super(strArr);
        }

        @Override // e.t.f.c
        public void a(Set<String> set) {
            e.c.a.a.a d2 = e.c.a.a.a.d();
            Runnable runnable = j.this.u;
            if (d2.b()) {
                runnable.run();
            } else {
                d2.c(runnable);
            }
        }
    }

    public j(g gVar, e eVar, boolean z, Callable<T> callable, String[] strArr) {
        this.f1728l = gVar;
        this.m = z;
        this.n = callable;
        this.o = eVar;
        this.p = new c(strArr);
    }

    @Override // androidx.lifecycle.LiveData
    public void h() {
        Executor executor;
        this.o.a.add(this);
        if (this.m) {
            executor = this.f1728l.c;
        } else {
            executor = this.f1728l.b;
        }
        executor.execute(this.t);
    }

    @Override // androidx.lifecycle.LiveData
    public void i() {
        this.o.a.remove(this);
    }
}
