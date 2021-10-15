package b.b0.y.s.r;

import c.b.b.e.a.u;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class a<V> implements u<V> {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f1306e = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f1307f = Logger.getLogger(a.class.getName());

    /* renamed from: g  reason: collision with root package name */
    public static final b f1308g;
    public static final Object h = new Object();

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f1309b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f1310c;

    /* renamed from: d  reason: collision with root package name */
    public volatile i f1311d;

    public static abstract class b {
        public b(C0018a aVar) {
        }

        public abstract boolean a(a<?> aVar, e eVar, e eVar2);

        public abstract boolean b(a<?> aVar, Object obj, Object obj2);

        public abstract boolean c(a<?> aVar, i iVar, i iVar2);

        public abstract void d(i iVar, i iVar2);

        public abstract void e(i iVar, Thread thread);
    }

    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        public static final c f1312c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f1313d;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f1314a;

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f1315b;

        static {
            if (a.f1306e) {
                f1313d = null;
                f1312c = null;
                return;
            }
            f1313d = new c(false, null);
            f1312c = new c(true, null);
        }

        public c(boolean z, Throwable th) {
            this.f1314a = z;
            this.f1315b = th;
        }
    }

    public static final class d {

        /* renamed from: b  reason: collision with root package name */
        public static final d f1316b = new d(new C0019a("Failure occurred while trying to finish a future."));

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f1317a;

        /* renamed from: b.b0.y.s.r.a$d$a  reason: collision with other inner class name */
        public class C0019a extends Throwable {
            public C0019a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            a.c(th);
            this.f1317a = th;
        }
    }

    public static final class e {

        /* renamed from: d  reason: collision with root package name */
        public static final e f1318d = new e(null, null);

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f1319a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f1320b;

        /* renamed from: c  reason: collision with root package name */
        public e f1321c;

        public e(Runnable runnable, Executor executor) {
            this.f1319a = runnable;
            this.f1320b = executor;
        }
    }

    public static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<i, Thread> f1322a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<i, i> f1323b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, i> f1324c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, e> f1325d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, Object> f1326e;

        public f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.f1322a = atomicReferenceFieldUpdater;
            this.f1323b = atomicReferenceFieldUpdater2;
            this.f1324c = atomicReferenceFieldUpdater3;
            this.f1325d = atomicReferenceFieldUpdater4;
            this.f1326e = atomicReferenceFieldUpdater5;
        }

        @Override // b.b0.y.s.r.a.b
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            return this.f1325d.compareAndSet(aVar, eVar, eVar2);
        }

        @Override // b.b0.y.s.r.a.b
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            return this.f1326e.compareAndSet(aVar, obj, obj2);
        }

        @Override // b.b0.y.s.r.a.b
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            return this.f1324c.compareAndSet(aVar, iVar, iVar2);
        }

        @Override // b.b0.y.s.r.a.b
        public void d(i iVar, i iVar2) {
            this.f1323b.lazySet(iVar, iVar2);
        }

        @Override // b.b0.y.s.r.a.b
        public void e(i iVar, Thread thread) {
            this.f1322a.lazySet(iVar, thread);
        }
    }

    public static final class g<V> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final a<V> f1327b;

        /* renamed from: c  reason: collision with root package name */
        public final u<? extends V> f1328c;

        public g(a<V> aVar, u<? extends V> uVar) {
            this.f1327b = aVar;
            this.f1328c = uVar;
        }

        public void run() {
            if (this.f1327b.f1309b == this) {
                if (a.f1308g.b(this.f1327b, this, a.g(this.f1328c))) {
                    a.d(this.f1327b);
                }
            }
        }
    }

    public static final class h extends b {
        public h() {
            super(null);
        }

        @Override // b.b0.y.s.r.a.b
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.f1310c != eVar) {
                    return false;
                }
                aVar.f1310c = eVar2;
                return true;
            }
        }

        @Override // b.b0.y.s.r.a.b
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f1309b != obj) {
                    return false;
                }
                aVar.f1309b = obj2;
                return true;
            }
        }

        @Override // b.b0.y.s.r.a.b
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f1311d != iVar) {
                    return false;
                }
                aVar.f1311d = iVar2;
                return true;
            }
        }

        @Override // b.b0.y.s.r.a.b
        public void d(i iVar, i iVar2) {
            iVar.f1331b = iVar2;
        }

        @Override // b.b0.y.s.r.a.b
        public void e(i iVar, Thread thread) {
            iVar.f1330a = thread;
        }
    }

    public static final class i {

        /* renamed from: c  reason: collision with root package name */
        public static final i f1329c = new i(false);

        /* renamed from: a  reason: collision with root package name */
        public volatile Thread f1330a;

        /* renamed from: b  reason: collision with root package name */
        public volatile i f1331b;

        public i() {
            a.f1308g.e(this, Thread.currentThread());
        }

        public i(boolean z) {
        }
    }

    static {
        b bVar;
        Throwable th;
        try {
            bVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "d"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "b"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            bVar = new h();
        }
        f1308g = bVar;
        if (th != null) {
            f1307f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    public static <T> T c(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0002 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [b.b0.y.s.r.a<?>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [b.b0.y.s.r.a] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [b.b0.y.s.r.a<V>, b.b0.y.s.r.a] */
    /* JADX WARN: Type inference failed for: r4v2, types: [b.b0.y.s.r.a$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static void d(a<?> aVar) {
        e eVar;
        e eVar2;
        e eVar3 = null;
        while (true) {
            i iVar = ((a) aVar).f1311d;
            if (f1308g.c((a) aVar, iVar, i.f1329c)) {
                while (iVar != null) {
                    Thread thread = iVar.f1330a;
                    if (thread != null) {
                        iVar.f1330a = null;
                        LockSupport.unpark(thread);
                    }
                    iVar = iVar.f1331b;
                }
                do {
                    eVar = ((a) aVar).f1310c;
                } while (!f1308g.a((a) aVar, eVar, e.f1318d));
                while (true) {
                    eVar2 = eVar3;
                    eVar3 = eVar;
                    if (eVar3 == null) {
                        break;
                    }
                    eVar = eVar3.f1321c;
                    eVar3.f1321c = eVar2;
                }
                while (eVar2 != null) {
                    eVar3 = eVar2.f1321c;
                    Runnable runnable = eVar2.f1319a;
                    if (runnable instanceof g) {
                        g gVar = (g) runnable;
                        aVar = gVar.f1327b;
                        if (aVar.f1309b == gVar) {
                            if (f1308g.b(aVar, gVar, g(gVar.f1328c))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        e(runnable, eVar2.f1320b);
                    }
                    eVar2 = eVar3;
                }
                return;
            }
        }
    }

    public static void e(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f1307f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object g(u<?> uVar) {
        if (uVar instanceof a) {
            Object obj = ((a) uVar).f1309b;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f1314a ? cVar.f1315b != null ? new c(false, cVar.f1315b) : c.f1313d : obj;
        }
        boolean isCancelled = uVar.isCancelled();
        if ((!f1306e) && isCancelled) {
            return c.f1313d;
        }
        try {
            Object h2 = h(uVar);
            return h2 == null ? h : h2;
        } catch (ExecutionException e2) {
            return new d(e2.getCause());
        } catch (CancellationException e3) {
            if (isCancelled) {
                return new c(false, e3);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + uVar, e3));
        } catch (Throwable th) {
            return new d(th);
        }
    }

    public static <V> V h(Future<V> future) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    public final void a(StringBuilder sb) {
        String str = "]";
        try {
            Object h2 = h(this);
            sb.append("SUCCESS, result=[");
            sb.append(h2 == this ? "this future" : String.valueOf(h2));
            sb.append(str);
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append(str);
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            str = " thrown from get()]";
            sb.append(str);
        }
    }

    @Override // c.b.b.e.a.u
    public final void b(Runnable runnable, Executor executor) {
        if (runnable == null) {
            throw null;
        } else if (executor != null) {
            e eVar = this.f1310c;
            if (eVar != e.f1318d) {
                e eVar2 = new e(runnable, executor);
                do {
                    eVar2.f1321c = eVar;
                    if (!f1308g.a(this, eVar, eVar2)) {
                        eVar = this.f1310c;
                    } else {
                        return;
                    }
                } while (eVar != e.f1318d);
            }
            e(runnable, executor);
        } else {
            throw null;
        }
    }

    public final boolean cancel(boolean z) {
        Object obj = this.f1309b;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f1306e ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.f1312c : c.f1313d;
        a<V> aVar = this;
        boolean z2 = false;
        while (true) {
            if (f1308g.b(aVar, obj, cVar)) {
                d(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                u<? extends V> uVar = ((g) obj).f1328c;
                if (uVar instanceof a) {
                    aVar = (a) uVar;
                    obj = aVar.f1309b;
                    if (!(obj == null) && !(obj instanceof g)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    uVar.cancel(z);
                    return true;
                }
            } else {
                obj = aVar.f1309b;
                if (!(obj instanceof g)) {
                    return z2;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public final V f(Object obj) {
        if (obj instanceof c) {
            Throwable th = ((c) obj).f1315b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f1317a);
        } else if (obj == h) {
            return null;
        } else {
            return obj;
        }
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f1309b;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return f(obj2);
            }
            i iVar = this.f1311d;
            if (iVar != i.f1329c) {
                i iVar2 = new i();
                do {
                    f1308g.d(iVar2, iVar);
                    if (f1308g.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f1309b;
                            } else {
                                j(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return f(obj);
                    }
                    iVar = this.f1311d;
                } while (iVar != i.f1329c);
            }
            return f(this.f1309b);
        }
        throw new InterruptedException();
    }

    public String i() {
        Object obj = this.f1309b;
        if (obj instanceof g) {
            StringBuilder h2 = c.a.a.a.a.h("setFuture=[");
            u<? extends V> uVar = ((g) obj).f1328c;
            h2.append(uVar == this ? "this future" : String.valueOf(uVar));
            h2.append("]");
            return h2.toString();
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            StringBuilder h3 = c.a.a.a.a.h("remaining delay=[");
            h3.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
            h3.append(" ms]");
            return h3.toString();
        }
    }

    public final boolean isCancelled() {
        return this.f1309b instanceof c;
    }

    public final boolean isDone() {
        Object obj = this.f1309b;
        return (!(obj instanceof g)) & (obj != null);
    }

    public final void j(i iVar) {
        iVar.f1330a = null;
        while (true) {
            i iVar2 = this.f1311d;
            if (iVar2 != i.f1329c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.f1331b;
                    if (iVar2.f1330a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.f1331b = iVar4;
                        if (iVar3.f1330a == null) {
                        }
                    } else if (!f1308g.c(this, iVar2, iVar4)) {
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f1309b instanceof c) {
            str = "CANCELLED";
        } else {
            if (!isDone()) {
                try {
                    str2 = i();
                } catch (RuntimeException e2) {
                    StringBuilder h2 = c.a.a.a.a.h("Exception thrown from implementation: ");
                    h2.append(e2.getClass());
                    str2 = h2.toString();
                }
                if (str2 != null && !str2.isEmpty()) {
                    sb.append("PENDING, info=[");
                    sb.append(str2);
                    sb.append("]");
                    sb.append("]");
                    return sb.toString();
                } else if (!isDone()) {
                    str = "PENDING";
                }
            }
            a(sb);
            sb.append("]");
            return sb.toString();
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.f1309b;
            boolean z = true;
            if ((obj != null) && (!(obj instanceof g))) {
                return f(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                i iVar = this.f1311d;
                if (iVar != i.f1329c) {
                    i iVar2 = new i();
                    do {
                        f1308g.d(iVar2, iVar);
                        if (f1308g.c(this, iVar, iVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f1309b;
                                    if ((obj2 != null) && (!(obj2 instanceof g))) {
                                        return f(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    j(iVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            j(iVar2);
                        } else {
                            iVar = this.f1311d;
                        }
                    } while (iVar != i.f1329c);
                }
                return f(this.f1309b);
            }
            while (nanos > 0) {
                Object obj3 = this.f1309b;
                if ((obj3 != null) && (!(obj3 instanceof g))) {
                    return f(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String aVar = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String q = c.a.a.a.a.q(str, " (plus ");
                long j2 = -nanos;
                long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(convert);
                int i2 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                if (i2 != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (i2 > 0) {
                    String str2 = q + convert + " " + lowerCase;
                    if (z) {
                        str2 = c.a.a.a.a.q(str2, ",");
                    }
                    q = c.a.a.a.a.q(str2, " ");
                }
                if (z) {
                    q = q + nanos2 + " nanoseconds ";
                }
                str = c.a.a.a.a.q(q, "delay)");
            }
            if (isDone()) {
                throw new TimeoutException(c.a.a.a.a.q(str, " but future completed as timeout expired"));
            }
            throw new TimeoutException(c.a.a.a.a.c(str, " for ", aVar));
        }
        throw new InterruptedException();
    }
}
