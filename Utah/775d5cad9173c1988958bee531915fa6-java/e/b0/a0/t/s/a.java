package e.b0.a0.t.s;

import f.b.b.f.a.u;
import java.util.Locale;
import java.util.Objects;
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
    public static final boolean f1147e = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f1148f = Logger.getLogger(a.class.getName());

    /* renamed from: g  reason: collision with root package name */
    public static final b f1149g;

    /* renamed from: h  reason: collision with root package name */
    public static final Object f1150h = new Object();
    public volatile Object b;
    public volatile e c;

    /* renamed from: d  reason: collision with root package name */
    public volatile i f1151d;

    public static abstract class b {
        public b(C0019a aVar) {
        }

        public abstract boolean a(a<?> aVar, e eVar, e eVar2);

        public abstract boolean b(a<?> aVar, Object obj, Object obj2);

        public abstract boolean c(a<?> aVar, i iVar, i iVar2);

        public abstract void d(i iVar, i iVar2);

        public abstract void e(i iVar, Thread thread);
    }

    public static final class c {
        public static final c c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f1152d;
        public final boolean a;
        public final Throwable b;

        static {
            if (a.f1147e) {
                f1152d = null;
                c = null;
                return;
            }
            f1152d = new c(false, null);
            c = new c(true, null);
        }

        public c(boolean z, Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    public static final class d {
        public static final d b = new d(new C0020a("Failure occurred while trying to finish a future."));
        public final Throwable a;

        /* renamed from: e.b0.a0.t.s.a$d$a  reason: collision with other inner class name */
        public class C0020a extends Throwable {
            public C0020a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            boolean z = a.f1147e;
            Objects.requireNonNull(th);
            this.a = th;
        }
    }

    public static final class e {

        /* renamed from: d  reason: collision with root package name */
        public static final e f1153d = new e(null, null);
        public final Runnable a;
        public final Executor b;
        public e c;

        public e(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    public static final class f extends b {
        public final AtomicReferenceFieldUpdater<i, Thread> a;
        public final AtomicReferenceFieldUpdater<i, i> b;
        public final AtomicReferenceFieldUpdater<a, i> c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, e> f1154d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, Object> f1155e;

        public f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.f1154d = atomicReferenceFieldUpdater4;
            this.f1155e = atomicReferenceFieldUpdater5;
        }

        @Override // e.b0.a0.t.s.a.b
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            return this.f1154d.compareAndSet(aVar, eVar, eVar2);
        }

        @Override // e.b0.a0.t.s.a.b
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            return this.f1155e.compareAndSet(aVar, obj, obj2);
        }

        @Override // e.b0.a0.t.s.a.b
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            return this.c.compareAndSet(aVar, iVar, iVar2);
        }

        @Override // e.b0.a0.t.s.a.b
        public void d(i iVar, i iVar2) {
            this.b.lazySet(iVar, iVar2);
        }

        @Override // e.b0.a0.t.s.a.b
        public void e(i iVar, Thread thread) {
            this.a.lazySet(iVar, thread);
        }
    }

    public static final class g<V> implements Runnable {
        public final a<V> b;
        public final u<? extends V> c;

        public g(a<V> aVar, u<? extends V> uVar) {
            this.b = aVar;
            this.c = uVar;
        }

        public void run() {
            if (this.b.b == this) {
                if (a.f1149g.b(this.b, this, a.f(this.c))) {
                    a.c(this.b);
                }
            }
        }
    }

    public static final class h extends b {
        public h() {
            super(null);
        }

        @Override // e.b0.a0.t.s.a.b
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.c != eVar) {
                    return false;
                }
                aVar.c = eVar2;
                return true;
            }
        }

        @Override // e.b0.a0.t.s.a.b
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.b != obj) {
                    return false;
                }
                aVar.b = obj2;
                return true;
            }
        }

        @Override // e.b0.a0.t.s.a.b
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f1151d != iVar) {
                    return false;
                }
                aVar.f1151d = iVar2;
                return true;
            }
        }

        @Override // e.b0.a0.t.s.a.b
        public void d(i iVar, i iVar2) {
            iVar.b = iVar2;
        }

        @Override // e.b0.a0.t.s.a.b
        public void e(i iVar, Thread thread) {
            iVar.a = thread;
        }
    }

    public static final class i {
        public static final i c = new i(false);
        public volatile Thread a;
        public volatile i b;

        public i() {
            a.f1149g.e(this, Thread.currentThread());
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
        f1149g = bVar;
        if (th != null) {
            f1148f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0002 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [e.b0.a0.t.s.a<?>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [e.b0.a0.t.s.a] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [e.b0.a0.t.s.a, e.b0.a0.t.s.a<V>] */
    /* JADX WARN: Type inference failed for: r4v2, types: [e.b0.a0.t.s.a$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static void c(a<?> aVar) {
        e eVar;
        e eVar2;
        e eVar3 = null;
        while (true) {
            i iVar = ((a) aVar).f1151d;
            if (f1149g.c((a) aVar, iVar, i.c)) {
                while (iVar != null) {
                    Thread thread = iVar.a;
                    if (thread != null) {
                        iVar.a = null;
                        LockSupport.unpark(thread);
                    }
                    iVar = iVar.b;
                }
                do {
                    eVar = ((a) aVar).c;
                } while (!f1149g.a((a) aVar, eVar, e.f1153d));
                while (true) {
                    eVar2 = eVar3;
                    eVar3 = eVar;
                    if (eVar3 == null) {
                        break;
                    }
                    eVar = eVar3.c;
                    eVar3.c = eVar2;
                }
                while (eVar2 != null) {
                    eVar3 = eVar2.c;
                    Runnable runnable = eVar2.a;
                    if (runnable instanceof g) {
                        g gVar = (g) runnable;
                        aVar = gVar.b;
                        if (aVar.b == gVar) {
                            if (f1149g.b(aVar, gVar, f(gVar.c))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        d(runnable, eVar2.b);
                    }
                    eVar2 = eVar3;
                }
                return;
            }
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f1148f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object f(u<?> uVar) {
        if (uVar instanceof a) {
            Object obj = ((a) uVar).b;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.a ? cVar.b != null ? new c(false, cVar.b) : c.f1152d : obj;
        }
        boolean isCancelled = uVar.isCancelled();
        if ((!f1147e) && isCancelled) {
            return c.f1152d;
        }
        try {
            Object g2 = g(uVar);
            return g2 == null ? f1150h : g2;
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

    public static <V> V g(Future<V> future) {
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

    @Override // f.b.b.f.a.u
    public final void a(Runnable runnable, Executor executor) {
        Objects.requireNonNull(runnable);
        Objects.requireNonNull(executor);
        e eVar = this.c;
        if (eVar != e.f1153d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.c = eVar;
                if (!f1149g.a(this, eVar, eVar2)) {
                    eVar = this.c;
                } else {
                    return;
                }
            } while (eVar != e.f1153d);
        }
        d(runnable, executor);
    }

    public final void b(StringBuilder sb) {
        String str = "]";
        try {
            Object g2 = g(this);
            sb.append("SUCCESS, result=[");
            sb.append(g2 == this ? "this future" : String.valueOf(g2));
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

    public final boolean cancel(boolean z) {
        Object obj = this.b;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f1147e ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.c : c.f1152d;
        boolean z2 = false;
        a<V> aVar = this;
        while (true) {
            if (f1149g.b(aVar, obj, cVar)) {
                c(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                u<? extends V> uVar = ((g) obj).c;
                if (uVar instanceof a) {
                    aVar = (a) uVar;
                    obj = aVar.b;
                    if (!(obj == null) && !(obj instanceof g)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    uVar.cancel(z);
                    return true;
                }
            } else {
                obj = aVar.b;
                if (!(obj instanceof g)) {
                    return z2;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public final V e(Object obj) {
        if (obj instanceof c) {
            Throwable th = ((c) obj).b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).a);
        } else if (obj == f1150h) {
            return null;
        } else {
            return obj;
        }
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.b;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return e(obj2);
            }
            i iVar = this.f1151d;
            if (iVar != i.c) {
                i iVar2 = new i();
                do {
                    b bVar = f1149g;
                    bVar.d(iVar2, iVar);
                    if (bVar.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.b;
                            } else {
                                i(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return e(obj);
                    }
                    iVar = this.f1151d;
                } while (iVar != i.c);
            }
            return e(this.b);
        }
        throw new InterruptedException();
    }

    public String h() {
        Object obj = this.b;
        if (obj instanceof g) {
            StringBuilder h2 = f.a.a.a.a.h("setFuture=[");
            u<? extends V> uVar = ((g) obj).c;
            return f.a.a.a.a.e(h2, uVar == this ? "this future" : String.valueOf(uVar), "]");
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            StringBuilder h3 = f.a.a.a.a.h("remaining delay=[");
            h3.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
            h3.append(" ms]");
            return h3.toString();
        }
    }

    public final void i(i iVar) {
        iVar.a = null;
        while (true) {
            i iVar2 = this.f1151d;
            if (iVar2 != i.c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.b;
                    if (iVar2.a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.b = iVar4;
                        if (iVar3.a == null) {
                        }
                    } else if (!f1149g.c(this, iVar2, iVar4)) {
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    public final boolean isCancelled() {
        return this.b instanceof c;
    }

    public final boolean isDone() {
        Object obj = this.b;
        return (!(obj instanceof g)) & (obj != null);
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.b instanceof c) {
            str = "CANCELLED";
        } else {
            if (!isDone()) {
                try {
                    str2 = h();
                } catch (RuntimeException e2) {
                    StringBuilder h2 = f.a.a.a.a.h("Exception thrown from implementation: ");
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
            b(sb);
            sb.append("]");
            return sb.toString();
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final V get(long j2, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.b;
            if ((obj != null) && (!(obj instanceof g))) {
                return e(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                i iVar = this.f1151d;
                if (iVar != i.c) {
                    i iVar2 = new i();
                    do {
                        b bVar = f1149g;
                        bVar.d(iVar2, iVar);
                        if (bVar.c(this, iVar, iVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.b;
                                    if ((obj2 != null) && (!(obj2 instanceof g))) {
                                        return e(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    i(iVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            i(iVar2);
                        } else {
                            iVar = this.f1151d;
                        }
                    } while (iVar != i.c);
                }
                return e(this.b);
            }
            while (nanos > 0) {
                Object obj3 = this.b;
                if ((obj3 != null) && (!(obj3 instanceof g))) {
                    return e(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String aVar = toString();
            String timeUnit2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = timeUnit2.toLowerCase(locale);
            String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String w = f.a.a.a.a.w(str, " (plus ");
                long j3 = -nanos;
                long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit.toNanos(convert);
                int i2 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z = i2 == 0 || nanos2 > 1000;
                if (i2 > 0) {
                    String str2 = w + convert + " " + lowerCase;
                    if (z) {
                        str2 = f.a.a.a.a.w(str2, ",");
                    }
                    w = f.a.a.a.a.w(str2, " ");
                }
                if (z) {
                    w = w + nanos2 + " nanoseconds ";
                }
                str = f.a.a.a.a.w(w, "delay)");
            }
            if (isDone()) {
                throw new TimeoutException(f.a.a.a.a.w(str, " but future completed as timeout expired"));
            }
            throw new TimeoutException(f.a.a.a.a.c(str, " for ", aVar));
        }
        throw new InterruptedException();
    }
}
