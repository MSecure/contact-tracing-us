package b.f.a;

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
    public static final boolean f834e = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger f = Logger.getLogger(a.class.getName());
    public static final b g;
    public static final Object h = new Object();

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f835b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f836c;

    /* renamed from: d  reason: collision with root package name */
    public volatile i f837d;

    public static abstract class b {
        public b(C0016a aVar) {
        }

        public abstract boolean a(a<?> aVar, e eVar, e eVar2);

        public abstract boolean b(a<?> aVar, Object obj, Object obj2);

        public abstract boolean c(a<?> aVar, i iVar, i iVar2);

        public abstract void d(i iVar, i iVar2);

        public abstract void e(i iVar, Thread thread);
    }

    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        public static final c f838c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f839d;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f840a;

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f841b;

        static {
            if (a.f834e) {
                f839d = null;
                f838c = null;
                return;
            }
            f839d = new c(false, null);
            f838c = new c(true, null);
        }

        public c(boolean z, Throwable th) {
            this.f840a = z;
            this.f841b = th;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f842a;

        /* renamed from: b.f.a.a$d$a  reason: collision with other inner class name */
        public static class C0017a extends Throwable {
            public C0017a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        static {
            a.c(new C0017a("Failure occurred while trying to finish a future."));
        }

        public d(Throwable th) {
            a.c(th);
            this.f842a = th;
        }
    }

    public static final class e {

        /* renamed from: d  reason: collision with root package name */
        public static final e f843d = new e(null, null);

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f844a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f845b;

        /* renamed from: c  reason: collision with root package name */
        public e f846c;

        public e(Runnable runnable, Executor executor) {
            this.f844a = runnable;
            this.f845b = executor;
        }
    }

    public static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<i, Thread> f847a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<i, i> f848b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, i> f849c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, e> f850d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, Object> f851e;

        public f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.f847a = atomicReferenceFieldUpdater;
            this.f848b = atomicReferenceFieldUpdater2;
            this.f849c = atomicReferenceFieldUpdater3;
            this.f850d = atomicReferenceFieldUpdater4;
            this.f851e = atomicReferenceFieldUpdater5;
        }

        @Override // b.f.a.a.b
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            return this.f850d.compareAndSet(aVar, eVar, eVar2);
        }

        @Override // b.f.a.a.b
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            return this.f851e.compareAndSet(aVar, obj, obj2);
        }

        @Override // b.f.a.a.b
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            return this.f849c.compareAndSet(aVar, iVar, iVar2);
        }

        @Override // b.f.a.a.b
        public void d(i iVar, i iVar2) {
            this.f848b.lazySet(iVar, iVar2);
        }

        @Override // b.f.a.a.b
        public void e(i iVar, Thread thread) {
            this.f847a.lazySet(iVar, thread);
        }
    }

    public static final class g<V> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final a<V> f852b;

        /* renamed from: c  reason: collision with root package name */
        public final u<? extends V> f853c;

        public void run() {
            throw null;
        }
    }

    public static final class h extends b {
        public h() {
            super(null);
        }

        @Override // b.f.a.a.b
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.f836c != eVar) {
                    return false;
                }
                aVar.f836c = eVar2;
                return true;
            }
        }

        @Override // b.f.a.a.b
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f835b != obj) {
                    return false;
                }
                aVar.f835b = obj2;
                return true;
            }
        }

        @Override // b.f.a.a.b
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f837d != iVar) {
                    return false;
                }
                aVar.f837d = iVar2;
                return true;
            }
        }

        @Override // b.f.a.a.b
        public void d(i iVar, i iVar2) {
            iVar.f856b = iVar2;
        }

        @Override // b.f.a.a.b
        public void e(i iVar, Thread thread) {
            iVar.f855a = thread;
        }
    }

    public static final class i {

        /* renamed from: c  reason: collision with root package name */
        public static final i f854c = new i(false);

        /* renamed from: a  reason: collision with root package name */
        public volatile Thread f855a;

        /* renamed from: b  reason: collision with root package name */
        public volatile i f856b;

        public i() {
            a.g.e(this, Thread.currentThread());
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
        g = bVar;
        if (th != null) {
            f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    public static <T> T c(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [b.f.a.a, b.f.a.a<V>] */
    /* JADX WARN: Type inference failed for: r4v2, types: [b.f.a.a$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static void d(a<?> aVar) {
        e eVar;
        e eVar2 = null;
        while (true) {
            i iVar = aVar.f837d;
            if (g.c(aVar, iVar, i.f854c)) {
                while (iVar != null) {
                    Thread thread = iVar.f855a;
                    if (thread != null) {
                        iVar.f855a = null;
                        LockSupport.unpark(thread);
                    }
                    iVar = iVar.f856b;
                }
                do {
                    eVar = aVar.f836c;
                } while (!g.a(aVar, eVar, e.f843d));
                while (eVar != null) {
                    e eVar3 = eVar.f846c;
                    eVar.f846c = eVar2;
                    eVar2 = eVar;
                    eVar = eVar3;
                }
                while (eVar2 != null) {
                    e eVar4 = eVar2.f846c;
                    Runnable runnable = eVar2.f844a;
                    if (runnable instanceof g) {
                        g gVar = (g) runnable;
                        a<V> aVar2 = gVar.f852b;
                        if (aVar2.f835b == gVar) {
                            if (g.b(aVar2, gVar, g(gVar.f853c))) {
                                eVar2 = eVar4;
                                aVar = aVar2;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        e(runnable, eVar2.f845b);
                    }
                    eVar2 = eVar4;
                }
                return;
            }
        }
    }

    public static void e(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object g(u<?> uVar) {
        if (uVar instanceof a) {
            Object obj = ((a) uVar).f835b;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f840a ? cVar.f841b != null ? new c(false, cVar.f841b) : c.f839d : obj;
        }
        boolean isCancelled = uVar.isCancelled();
        if ((!f834e) && isCancelled) {
            return c.f839d;
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
            e eVar = this.f836c;
            if (eVar != e.f843d) {
                e eVar2 = new e(runnable, executor);
                do {
                    eVar2.f846c = eVar;
                    if (!g.a(this, eVar, eVar2)) {
                        eVar = this.f836c;
                    } else {
                        return;
                    }
                } while (eVar != e.f843d);
            }
            e(runnable, executor);
        } else {
            throw null;
        }
    }

    public final boolean cancel(boolean z) {
        Object obj = this.f835b;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f834e ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.f838c : c.f839d;
        a<V> aVar = this;
        boolean z2 = false;
        while (true) {
            if (g.b(aVar, obj, cVar)) {
                d(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                u<? extends V> uVar = ((g) obj).f853c;
                if (uVar instanceof a) {
                    aVar = (a) uVar;
                    obj = aVar.f835b;
                    if (!(obj == null) && !(obj instanceof g)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    uVar.cancel(z);
                    return true;
                }
            } else {
                obj = aVar.f835b;
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
            Throwable th = ((c) obj).f841b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f842a);
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
            Object obj2 = this.f835b;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return f(obj2);
            }
            i iVar = this.f837d;
            if (iVar != i.f854c) {
                i iVar2 = new i();
                do {
                    g.d(iVar2, iVar);
                    if (g.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f835b;
                            } else {
                                j(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return f(obj);
                    }
                    iVar = this.f837d;
                } while (iVar != i.f854c);
            }
            return f(this.f835b);
        }
        throw new InterruptedException();
    }

    public String i() {
        Object obj = this.f835b;
        if (obj instanceof g) {
            StringBuilder g2 = c.a.a.a.a.g("setFuture=[");
            u<? extends V> uVar = ((g) obj).f853c;
            g2.append(uVar == this ? "this future" : String.valueOf(uVar));
            g2.append("]");
            return g2.toString();
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            StringBuilder g3 = c.a.a.a.a.g("remaining delay=[");
            g3.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
            g3.append(" ms]");
            return g3.toString();
        }
    }

    public final boolean isCancelled() {
        return this.f835b instanceof c;
    }

    public final boolean isDone() {
        Object obj = this.f835b;
        return (!(obj instanceof g)) & (obj != null);
    }

    public final void j(i iVar) {
        iVar.f855a = null;
        while (true) {
            i iVar2 = this.f837d;
            if (iVar2 != i.f854c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.f856b;
                    if (iVar2.f855a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.f856b = iVar4;
                        if (iVar3.f855a == null) {
                        }
                    } else if (!g.c(this, iVar2, iVar4)) {
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    public boolean k(V v) {
        if (v == null) {
            v = (V) h;
        }
        if (!g.b(this, null, v)) {
            return false;
        }
        d(this);
        return true;
    }

    public boolean l(Throwable th) {
        if (th != null) {
            if (!g.b(this, null, new d(th))) {
                return false;
            }
            d(this);
            return true;
        }
        throw null;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f835b instanceof c) {
            str = "CANCELLED";
        } else {
            if (!isDone()) {
                try {
                    str2 = i();
                } catch (RuntimeException e2) {
                    StringBuilder g2 = c.a.a.a.a.g("Exception thrown from implementation: ");
                    g2.append(e2.getClass());
                    str2 = g2.toString();
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
            Object obj = this.f835b;
            boolean z = true;
            if ((obj != null) && (!(obj instanceof g))) {
                return f(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                i iVar = this.f837d;
                if (iVar != i.f854c) {
                    i iVar2 = new i();
                    do {
                        g.d(iVar2, iVar);
                        if (g.c(this, iVar, iVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f835b;
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
                            iVar = this.f837d;
                        }
                    } while (iVar != i.f854c);
                }
                return f(this.f835b);
            }
            while (nanos > 0) {
                Object obj3 = this.f835b;
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
                String o = c.a.a.a.a.o(str, " (plus ");
                long j2 = -nanos;
                long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(convert);
                int i2 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                if (i2 != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (i2 > 0) {
                    String str2 = o + convert + " " + lowerCase;
                    if (z) {
                        str2 = c.a.a.a.a.o(str2, ",");
                    }
                    o = c.a.a.a.a.o(str2, " ");
                }
                if (z) {
                    o = o + nanos2 + " nanoseconds ";
                }
                str = c.a.a.a.a.o(o, "delay)");
            }
            if (isDone()) {
                throw new TimeoutException(c.a.a.a.a.o(str, " but future completed as timeout expired"));
            }
            throw new TimeoutException(c.a.a.a.a.p(str, " for ", aVar));
        }
        throw new InterruptedException();
    }
}
