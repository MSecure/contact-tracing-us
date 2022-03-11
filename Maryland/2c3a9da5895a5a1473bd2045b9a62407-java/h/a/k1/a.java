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
    public final q2 f3902d;

    /* renamed from: e  reason: collision with root package name */
    public final b.a f3903e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3904f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3905g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3906h = false;

    /* renamed from: i  reason: collision with root package name */
    public r f3907i;

    /* renamed from: j  reason: collision with root package name */
    public Socket f3908j;

    /* renamed from: h.a.k1.a$a  reason: collision with other inner class name */
    public class C0149a extends d {
        public final h.b.b c = h.b.a.b;

        public C0149a() {
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
                    aVar.f3904f = false;
                }
                aVar.f3907i.h(eVar, eVar.c);
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
                    aVar.f3905g = false;
                }
                aVar.f3907i.h(eVar, eVar.c);
                a.this.f3907i.flush();
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
                r rVar = a.this.f3907i;
                if (rVar != null) {
                    rVar.close();
                }
            } catch (IOException e2) {
                a.this.f3903e.b(e2);
            }
            try {
                Socket socket = a.this.f3908j;
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e3) {
                a.this.f3903e.b(e3);
            }
        }
    }

    public abstract class d implements Runnable {
        public d(C0149a aVar) {
        }

        public abstract void a();

        public final void run() {
            try {
                if (a.this.f3907i != null) {
                    a();
                    return;
                }
                throw new IOException("Unable to perform write due to unavailable sink.");
            } catch (Exception e2) {
                a.this.f3903e.b(e2);
            }
        }
    }

    public a(q2 q2Var, b.a aVar) {
        f.b.a.c.b.o.b.A(q2Var, "executor");
        this.f3902d = q2Var;
        f.b.a.c.b.o.b.A(aVar, "exceptionHandler");
        this.f3903e = aVar;
    }

    public void c(r rVar, Socket socket) {
        f.b.a.c.b.o.b.G(this.f3907i == null, "AsyncSink's becomeConnected should only be called once.");
        f.b.a.c.b.o.b.A(rVar, "sink");
        this.f3907i = rVar;
        f.b.a.c.b.o.b.A(socket, "socket");
        this.f3908j = socket;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, k.r
    public void close() {
        if (!this.f3906h) {
            this.f3906h = true;
            q2 q2Var = this.f3902d;
            c cVar = new c();
            Queue<Runnable> queue = q2Var.c;
            f.b.a.c.b.o.b.A(cVar, "'r' must not be null.");
            queue.add(cVar);
            q2Var.c(cVar);
        }
    }

    @Override // k.r, java.io.Flushable
    public void flush() {
        if (!this.f3906h) {
            h.b.a aVar = h.b.c.a;
            Objects.requireNonNull(aVar);
            try {
                synchronized (this.b) {
                    if (this.f3905g) {
                        Objects.requireNonNull(aVar);
                        return;
                    }
                    this.f3905g = true;
                    q2 q2Var = this.f3902d;
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
        if (!this.f3906h) {
            h.b.a aVar = h.b.c.a;
            Objects.requireNonNull(aVar);
            try {
                synchronized (this.b) {
                    this.c.h(eVar, j2);
                    if (!this.f3904f && !this.f3905g) {
                        if (this.c.d() > 0) {
                            this.f3904f = true;
                            q2 q2Var = this.f3902d;
                            C0149a aVar2 = new C0149a();
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
