package h.a.j1;

import h.a.j1.y2;
import h.a.j1.z1;
import h.a.s;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

public class f implements c0, z1.b {
    public final z1.b b;
    public final z1 c;

    /* renamed from: d  reason: collision with root package name */
    public final i f3928d;

    /* renamed from: e  reason: collision with root package name */
    public final Queue<InputStream> f3929e = new ArrayDeque();

    public class a implements Runnable {
        public final /* synthetic */ int b;

        public a(int i2) {
            this.b = i2;
        }

        public void run() {
            if (!f.this.c.R()) {
                try {
                    f.this.c.c(this.b);
                } catch (Throwable th) {
                    f.this.b.b(th);
                    f.this.c.close();
                }
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ j2 b;

        public b(j2 j2Var) {
            this.b = j2Var;
        }

        public void run() {
            try {
                f.this.c.L(this.b);
            } catch (Throwable th) {
                f fVar = f.this;
                fVar.f3928d.c(new g(th));
                f.this.c.close();
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            f.this.c.t();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            f.this.c.close();
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ int b;

        public e(int i2) {
            this.b = i2;
        }

        public void run() {
            f.this.b.f(this.b);
        }
    }

    /* renamed from: h.a.j1.f$f  reason: collision with other inner class name */
    public class RunnableC0146f implements Runnable {
        public final /* synthetic */ boolean b;

        public RunnableC0146f(boolean z) {
            this.b = z;
        }

        public void run() {
            f.this.b.e(this.b);
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ Throwable b;

        public g(Throwable th) {
            this.b = th;
        }

        public void run() {
            f.this.b.b(this.b);
        }
    }

    public class h implements y2.a {
        public final Runnable a;
        public boolean b = false;

        public h(Runnable runnable, a aVar) {
            this.a = runnable;
        }

        @Override // h.a.j1.y2.a
        public InputStream next() {
            if (!this.b) {
                this.a.run();
                this.b = true;
            }
            return f.this.f3929e.poll();
        }
    }

    public interface i {
        void c(Runnable runnable);
    }

    public f(z1.b bVar, i iVar, z1 z1Var) {
        f.b.a.c.b.o.b.z(bVar, "listener");
        this.b = bVar;
        f.b.a.c.b.o.b.z(iVar, "transportExecutor");
        this.f3928d = iVar;
        z1Var.b = this;
        this.c = z1Var;
    }

    @Override // h.a.j1.c0
    public void J(r0 r0Var) {
        this.c.J(r0Var);
    }

    @Override // h.a.j1.c0
    public void L(j2 j2Var) {
        this.b.a(new h(new b(j2Var), null));
    }

    @Override // h.a.j1.z1.b
    public void a(y2.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next != null) {
                this.f3929e.add(next);
            } else {
                return;
            }
        }
    }

    @Override // h.a.j1.z1.b
    public void b(Throwable th) {
        this.f3928d.c(new g(th));
    }

    @Override // h.a.j1.c0
    public void c(int i2) {
        this.b.a(new h(new a(i2), null));
    }

    @Override // h.a.j1.c0
    public void close() {
        this.c.t = true;
        this.b.a(new h(new d(), null));
    }

    @Override // h.a.j1.c0
    public void d(int i2) {
        this.c.c = i2;
    }

    @Override // h.a.j1.z1.b
    public void e(boolean z) {
        this.f3928d.c(new RunnableC0146f(z));
    }

    @Override // h.a.j1.z1.b
    public void f(int i2) {
        this.f3928d.c(new e(i2));
    }

    @Override // h.a.j1.c0
    public void t() {
        this.b.a(new h(new c(), null));
    }

    @Override // h.a.j1.c0
    public void x(s sVar) {
        this.c.x(sVar);
    }
}
