package h.a;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public class q {

    /* renamed from: f */
    public static final Logger f4538f = Logger.getLogger(q.class.getName());

    /* renamed from: g */
    public static final w0<Object<?>, Object> f4539g;

    /* renamed from: h */
    public static final q f4540h;
    public ArrayList<d> b;
    public b c = new f(null);

    /* renamed from: d */
    public final a f4541d = null;

    /* renamed from: e */
    public final int f4542e = 0;

    /* loaded from: classes.dex */
    public static final class a extends q implements Closeable {

        /* renamed from: i */
        public boolean f4543i;

        /* renamed from: j */
        public Throwable f4544j;

        @Override // h.a.q
        public void Q(q qVar) {
            throw null;
        }

        @Override // h.a.q
        public r R() {
            return null;
        }

        @Override // h.a.q
        public boolean S() {
            synchronized (this) {
                if (this.f4543i) {
                    return true;
                }
                if (!q.super.S()) {
                    return false;
                }
                V(q.super.x());
                return true;
            }
        }

        public boolean V(Throwable th) {
            boolean z;
            synchronized (this) {
                z = true;
                if (!this.f4543i) {
                    this.f4543i = true;
                    this.f4544j = th;
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
                return this.f4544j;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(q qVar);
    }

    /* loaded from: classes.dex */
    public enum c implements Executor {
        INSTANCE;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Context.DirectExecutor";
        }
    }

    /* loaded from: classes.dex */
    public final class d implements Runnable {
        public final Executor b;
        public final b c;

        public d(Executor executor, b bVar) {
            q.this = r1;
            this.b = executor;
            this.c = bVar;
        }

        public void a() {
            try {
                this.b.execute(this);
            } catch (Throwable th) {
                q.f4538f.log(Level.INFO, "Exception notifying context listener", th);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.a(q.this);
        }
    }

    /* loaded from: classes.dex */
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
                q.f4538f.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class f implements b {
        public f(p pVar) {
            q.this = r1;
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

    /* loaded from: classes.dex */
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
        f4539g = w0Var;
        f4540h = new q(null, w0Var);
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
        return a2 == null ? f4540h : a2;
    }

    public void Q(q qVar) {
        J(qVar, "toAttach");
        e.a.b(this, qVar);
    }

    public r R() {
        a aVar = this.f4541d;
        if (aVar == null) {
            return null;
        }
        Objects.requireNonNull(aVar);
        return null;
    }

    public boolean S() {
        a aVar = this.f4541d;
        if (aVar == null) {
            return false;
        }
        return aVar.S();
    }

    public void T() {
        if (t()) {
            synchronized (this) {
                ArrayList<d> arrayList = this.b;
                if (arrayList != null) {
                    this.b = null;
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (!(arrayList.get(i2).c instanceof f)) {
                            arrayList.get(i2).a();
                        }
                    }
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (arrayList.get(i3).c instanceof f) {
                            arrayList.get(i3).a();
                        }
                    }
                    a aVar = this.f4541d;
                    if (aVar != null) {
                        aVar.U(this.c);
                    }
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
                        a aVar = this.f4541d;
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
                        a aVar = this.f4541d;
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
        return c2 == null ? f4540h : c2;
    }

    public boolean t() {
        return this.f4541d != null;
    }

    public Throwable x() {
        a aVar = this.f4541d;
        if (aVar == null) {
            return null;
        }
        return aVar.x();
    }
}
