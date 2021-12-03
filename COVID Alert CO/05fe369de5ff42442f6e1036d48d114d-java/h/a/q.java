package h.a;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

public class q {

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f4218f = Logger.getLogger(q.class.getName());

    /* renamed from: g  reason: collision with root package name */
    public static final w0<Object<?>, Object> f4219g;

    /* renamed from: h  reason: collision with root package name */
    public static final q f4220h;
    public ArrayList<d> b;
    public b c = new f(null);

    /* renamed from: d  reason: collision with root package name */
    public final a f4221d = null;

    /* renamed from: e  reason: collision with root package name */
    public final int f4222e = 0;

    public static final class a extends q implements Closeable {

        /* renamed from: i  reason: collision with root package name */
        public boolean f4223i;

        /* renamed from: j  reason: collision with root package name */
        public Throwable f4224j;

        @Override // h.a.q
        public void Q(q qVar) {
            throw null;
        }

        @Override // h.a.q
        public r R() {
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
            if (h.a.q.super.S() == false) goto L_0x0017;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
            V(h.a.q.super.x());
         */
        @Override // h.a.q
        public boolean S() {
            synchronized (this) {
                if (this.f4223i) {
                    return true;
                }
            }
        }

        public boolean V(Throwable th) {
            boolean z;
            synchronized (this) {
                z = true;
                if (!this.f4223i) {
                    this.f4223i = true;
                    this.f4224j = th;
                } else {
                    z = false;
                }
            }
            if (z) {
                T();
            }
            return z;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            V(null);
        }

        @Override // h.a.q
        public q d() {
            throw null;
        }

        @Override // h.a.q
        public boolean t() {
            return true;
        }

        @Override // h.a.q
        public Throwable x() {
            if (S()) {
                return this.f4224j;
            }
            return null;
        }
    }

    public interface b {
        void a(q qVar);
    }

    public enum c implements Executor {
        INSTANCE;

        public void execute(Runnable runnable) {
            runnable.run();
        }

        public String toString() {
            return "Context.DirectExecutor";
        }
    }

    public final class d implements Runnable {
        public final Executor b;
        public final b c;

        public d(Executor executor, b bVar) {
            this.b = executor;
            this.c = bVar;
        }

        public void a() {
            try {
                this.b.execute(this);
            } catch (Throwable th) {
                q.f4218f.log(Level.INFO, "Exception notifying context listener", th);
            }
        }

        public void run() {
            this.c.a(q.this);
        }
    }

    public static final class e {
        public static final g a;

        static {
            g gVar;
            AtomicReference atomicReference = new AtomicReference();
            try {
                gVar = (g) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(g.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e2) {
                atomicReference.set(e2);
                gVar = new h1();
            } catch (Exception e3) {
                throw new RuntimeException("Storage override failed to initialize", e3);
            }
            a = gVar;
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                q.f4218f.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }
    }

    public final class f implements b {
        public f(p pVar) {
        }

        @Override // h.a.q.b
        public void a(q qVar) {
            q qVar2 = q.this;
            if (qVar2 instanceof a) {
                ((a) qVar2).V(qVar.x());
            } else {
                qVar2.T();
            }
        }
    }

    public static abstract class g {
        public abstract q a();

        public abstract void b(q qVar, q qVar2);

        public q c(q qVar) {
            a();
            throw new UnsupportedOperationException("Deprecated. Do not call.");
        }
    }

    static {
        w0<Object<?>, Object> w0Var = new w0<>();
        f4219g = w0Var;
        f4220h = new q(null, w0Var);
    }

    public q(q qVar, w0<Object<?>, Object> w0Var) {
    }

    public static <T> T J(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static q L() {
        q a2 = e.a.a();
        return a2 == null ? f4220h : a2;
    }

    public void Q(q qVar) {
        J(qVar, "toAttach");
        e.a.b(this, qVar);
    }

    public r R() {
        a aVar = this.f4221d;
        if (aVar == null) {
            return null;
        }
        Objects.requireNonNull(aVar);
        return null;
    }

    public boolean S() {
        a aVar = this.f4221d;
        if (aVar == null) {
            return false;
        }
        return aVar.S();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        r1 = 0;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        if (r2 >= r0.size()) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        if ((r0.get(r2).c instanceof h.a.q.f) != false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        r0.get(r2).a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        if (r1 >= r0.size()) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        if ((r0.get(r1).c instanceof h.a.q.f) == false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r0.get(r1).a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        r0 = r4.f4221d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
        r0.U(r4.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    public void T() {
        if (t()) {
            synchronized (this) {
                ArrayList<d> arrayList = this.b;
                if (arrayList != null) {
                    this.b = null;
                }
            }
        }
    }

    public void U(b bVar) {
        if (t()) {
            synchronized (this) {
                ArrayList<d> arrayList = this.b;
                if (arrayList != null) {
                    int size = arrayList.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        } else if (this.b.get(size).c == bVar) {
                            this.b.remove(size);
                            break;
                        } else {
                            size--;
                        }
                    }
                    if (this.b.isEmpty()) {
                        a aVar = this.f4221d;
                        if (aVar != null) {
                            aVar.U(this.c);
                        }
                        this.b = null;
                    }
                }
            }
        }
    }

    public void c(b bVar, Executor executor) {
        J(bVar, "cancellationListener");
        J(executor, "executor");
        if (t()) {
            d dVar = new d(executor, bVar);
            synchronized (this) {
                if (S()) {
                    dVar.a();
                } else {
                    ArrayList<d> arrayList = this.b;
                    if (arrayList == null) {
                        ArrayList<d> arrayList2 = new ArrayList<>();
                        this.b = arrayList2;
                        arrayList2.add(dVar);
                        a aVar = this.f4221d;
                        if (aVar != null) {
                            aVar.c(this.c, c.INSTANCE);
                        }
                    } else {
                        arrayList.add(dVar);
                    }
                }
            }
        }
    }

    public q d() {
        q c2 = e.a.c(this);
        return c2 == null ? f4220h : c2;
    }

    public boolean t() {
        return this.f4221d != null;
    }

    public Throwable x() {
        a aVar = this.f4221d;
        if (aVar == null) {
            return null;
        }
        return aVar.x();
    }
}
