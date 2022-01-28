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
    public final q2 f4121d;

    /* renamed from: e  reason: collision with root package name */
    public final b.a f4122e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4123f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4124g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4125h = false;

    /* renamed from: i  reason: collision with root package name */
    public r f4126i;

    /* renamed from: j  reason: collision with root package name */
    public Socket f4127j;

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
                    aVar.f4123f = false;
                }
                aVar.f4126i.h(eVar, eVar.c);
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
                    aVar.f4124g = false;
                }
                aVar.f4126i.h(eVar, eVar.c);
                a.this.f4126i.flush();
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
                r rVar = a.this.f4126i;
                if (rVar != null) {
                    rVar.close();
                }
            } catch (IOException e2) {
                a.this.f4122e.b(e2);
            }
            try {
                Socket socket = a.this.f4127j;
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e3) {
                a.this.f4122e.b(e3);
            }
        }
    }

    public abstract class d implements Runnable {
        public d(C0149a aVar) {
        }

        public abstract void a();

        public final void run() {
            try {
                if (a.this.f4126i != null) {
                    a();
                    return;
                }
                throw new IOException("Unable to perform write due to unavailable sink.");
            } catch (Exception e2) {
                a.this.f4122e.b(e2);
            }
        }
    }

    public a(q2 q2Var, b.a aVar) {
        f.b.a.c.b.o.b.z(q2Var, "executor");
        this.f4121d = q2Var;
        f.b.a.c.b.o.b.z(aVar, "exceptionHandler");
        this.f4122e = aVar;
    }

    public void c(r rVar, Socket socket) {
        f.b.a.c.b.o.b.F(this.f4126i == null, "AsyncSink's becomeConnected should only be called once.");
        f.b.a.c.b.o.b.z(rVar, "sink");
        this.f4126i = rVar;
        f.b.a.c.b.o.b.z(socket, "socket");
        this.f4127j = socket;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, k.r
    public void close() {
        if (!this.f4125h) {
            this.f4125h = true;
            q2 q2Var = this.f4121d;
            c cVar = new c();
            Queue<Runnable> queue = q2Var.c;
            f.b.a.c.b.o.b.z(cVar, "'r' must not be null.");
            queue.add(cVar);
            q2Var.c(cVar);
        }
    }

    @Override // k.r, java.io.Flushable
    public void flush() {
        if (!this.f4125h) {
            h.b.a aVar = h.b.c.a;
            Objects.requireNonNull(aVar);
            try {
                synchronized (this.b) {
                    if (this.f4124g) {
                        Objects.requireNonNull(aVar);
                        return;
                    }
                    this.f4124g = true;
                    q2 q2Var = this.f4121d;
                    b bVar = new b();
                    Queue<Runnable> queue = q2Var.c;
                    f.b.a.c.b.o.b.z(bVar, "'r' must not be null.");
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
        f.b.a.c.b.o.b.z(eVar, "source");
        if (!this.f4125h) {
            h.b.a aVar = h.b.c.a;
            Objects.requireNonNull(aVar);
            try {
                synchronized (this.b) {
                    this.c.h(eVar, j2);
                    if (!this.f4123f && !this.f4124g) {
                        if (this.c.d() > 0) {
                            this.f4123f = true;
                            q2 q2Var = this.f4121d;
                            C0149a aVar2 = new C0149a();
                            Queue<Runnable> queue = q2Var.c;
                            f.b.a.c.b.o.b.z(aVar2, "'r' must not be null.");
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
