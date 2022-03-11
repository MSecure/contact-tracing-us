package h.a.j1;

import h.a.j1.y2;
import h.a.j1.z1;
import h.a.s;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes.dex */
public class f implements c0, z1.b {
    public final z1.b b;
    public final z1 c;

    /* renamed from: d  reason: collision with root package name */
    public final i f4183d;

    /* renamed from: e  reason: collision with root package name */
    public final Queue<InputStream> f4184e = new ArrayDeque();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ int b;

        public a(int i2) {
            this.b = i2;
        }

        @Override // java.lang.Runnable
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

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ j2 b;

        public b(j2 j2Var) {
            this.b = j2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.c.L(this.b);
            } catch (Throwable th) {
                f fVar = f.this;
                fVar.f4183d.c(new g(th));
                f.this.c.close();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.c.t();
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.c.close();
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public final /* synthetic */ int b;

        public e(int i2) {
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.f(this.b);
        }
    }

    /* renamed from: h.a.j1.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0148f implements Runnable {
        public final /* synthetic */ boolean b;

        public RunnableC0148f(boolean z) {
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.e(this.b);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public final /* synthetic */ Throwable b;

        public g(Throwable th) {
            this.b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.b(this.b);
        }
    }

    /* loaded from: classes.dex */
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
            return f.this.f4184e.poll();
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void c(Runnable runnable);
    }

    public f(z1.b bVar, i iVar, z1 z1Var) {
        f.b.a.c.b.o.b.A(bVar, "listener");
        this.b = bVar;
        f.b.a.c.b.o.b.A(iVar, "transportExecutor");
        this.f4183d = iVar;
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
                this.f4184e.add(next);
            } else {
                return;
            }
        }
    }

    @Override // h.a.j1.z1.b
    public void b(Throwable th) {
        this.f4183d.c(new g(th));
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
        this.f4183d.c(new RunnableC0148f(z));
    }

    @Override // h.a.j1.z1.b
    public void f(int i2) {
        this.f4183d.c(new e(i2));
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
