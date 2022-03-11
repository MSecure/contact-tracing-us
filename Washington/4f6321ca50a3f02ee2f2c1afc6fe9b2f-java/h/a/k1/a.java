package h.a.k1;

import h.a.j1.q2;
import h.a.k1.b;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;
import java.util.Queue;
import k.e;
import k.r;

public final class a implements r {
    public final Object b = new Object();
    public final e c = new e();

    /* renamed from: d  reason: collision with root package name */
    public final q2 f3806d;

    /* renamed from: e  reason: collision with root package name */
    public final b.a f3807e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3808f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3809g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3810h = false;

    /* renamed from: i  reason: collision with root package name */
    public r f3811i;

    /* renamed from: j  reason: collision with root package name */
    public Socket f3812j;

    /* renamed from: h.a.k1.a$a  reason: collision with other inner class name */
    public class C0144a extends d {
        public final h.b.b c = h.b.a.b;

        public C0144a() {
            super(null);
            h.b.c.a();
        }

        @Override // h.a.k1.a.d
        public void a() {
            a aVar;
            Objects.requireNonNull(h.b.c.a);
            e eVar = new e();
            try {
                synchronized (a.this.b) {
                    e eVar2 = a.this.c;
                    eVar.h(eVar2, eVar2.d());
                    aVar = a.this;
                    aVar.f3808f = false;
                }
                aVar.f3811i.h(eVar, eVar.c);
            } catch (Throwable th) {
                Objects.requireNonNull(h.b.c.a);
                throw th;
            }
        }
    }

    public class b extends d {
        public final h.b.b c = h.b.a.b;

        public b() {
            super(null);
            h.b.c.a();
        }

        @Override // h.a.k1.a.d
        public void a() {
            a aVar;
            Objects.requireNonNull(h.b.c.a);
            e eVar = new e();
            try {
                synchronized (a.this.b) {
                    e eVar2 = a.this.c;
                    eVar.h(eVar2, eVar2.c);
                    aVar = a.this;
                    aVar.f3809g = false;
                }
                aVar.f3811i.h(eVar, eVar.c);
                a.this.f3811i.flush();
            } catch (Throwable th) {
                Objects.requireNonNull(h.b.c.a);
                throw th;
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            Objects.requireNonNull(a.this.c);
            try {
                r rVar = a.this.f3811i;
                if (rVar != null) {
                    rVar.close();
                }
            } catch (IOException e2) {
                a.this.f3807e.b(e2);
            }
            try {
                Socket socket = a.this.f3812j;
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e3) {
                a.this.f3807e.b(e3);
            }
        }
    }

    public abstract class d implements Runnable {
        public d(C0144a aVar) {
        }

        public abstract void a();

        public final void run() {
            try {
                if (a.this.f3811i != null) {
                    a();
                    return;
                }
                throw new IOException("Unable to perform write due to unavailable sink.");
            } catch (Exception e2) {
                a.this.f3807e.b(e2);
            }
        }
    }

    public a(q2 q2Var, b.a aVar) {
        f.b.a.c.b.o.b.A(q2Var, "executor");
        this.f3806d = q2Var;
        f.b.a.c.b.o.b.A(aVar, "exceptionHandler");
        this.f3807e = aVar;
    }

    public void c(r rVar, Socket socket) {
        f.b.a.c.b.o.b.G(this.f3811i == null, "AsyncSink's becomeConnected should only be called once.");
        f.b.a.c.b.o.b.A(rVar, "sink");
        this.f3811i = rVar;
        f.b.a.c.b.o.b.A(socket, "socket");
        this.f3812j = socket;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, k.r
    public void close() {
        if (!this.f3810h) {
            this.f3810h = true;
            q2 q2Var = this.f3806d;
            c cVar = new c();
            Queue<Runnable> queue = q2Var.c;
            f.b.a.c.b.o.b.A(cVar, "'r' must not be null.");
            queue.add(cVar);
            q2Var.c(cVar);
        }
    }

    @Override // k.r, java.io.Flushable
    public void flush() {
        if (!this.f3810h) {
            h.b.a aVar = h.b.c.a;
            Objects.requireNonNull(aVar);
            try {
                synchronized (this.b) {
                    if (this.f3809g) {
                        Objects.requireNonNull(aVar);
                        return;
                    }
                    this.f3809g = true;
                    q2 q2Var = this.f3806d;
                    b bVar = new b();
                    Queue<Runnable> queue = q2Var.c;
                    f.b.a.c.b.o.b.A(bVar, "'r' must not be null.");
                    queue.add(bVar);
                    q2Var.c(bVar);
                    Objects.requireNonNull(aVar);
                }
            } catch (Throwable th) {
                Objects.requireNonNull(h.b.c.a);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    @Override // k.r
    public void h(e eVar, long j2) {
        f.b.a.c.b.o.b.A(eVar, "source");
        if (!this.f3810h) {
            h.b.a aVar = h.b.c.a;
            Objects.requireNonNull(aVar);
            try {
                synchronized (this.b) {
                    this.c.h(eVar, j2);
                    if (!this.f3808f && !this.f3809g) {
                        if (this.c.d() > 0) {
                            this.f3808f = true;
                            q2 q2Var = this.f3806d;
                            C0144a aVar2 = new C0144a();
                            Queue<Runnable> queue = q2Var.c;
                            f.b.a.c.b.o.b.A(aVar2, "'r' must not be null.");
                            queue.add(aVar2);
                            q2Var.c(aVar2);
                            Objects.requireNonNull(aVar);
                            return;
                        }
                    }
                    Objects.requireNonNull(aVar);
                }
            } catch (Throwable th) {
                Objects.requireNonNull(h.b.c.a);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }
}
