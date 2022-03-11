package e.g.a;

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
/* loaded from: classes.dex */
public abstract class a<V> implements u<V> {

    /* renamed from: e */
    public static final boolean f1320e = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: f */
    public static final Logger f1321f = Logger.getLogger(a.class.getName());

    /* renamed from: g */
    public static final b f1322g;

    /* renamed from: h */
    public static final Object f1323h;
    public volatile Object b;
    public volatile e c;

    /* renamed from: d */
    public volatile i f1324d;

    /* loaded from: classes.dex */
    public static abstract class b {
        public b(C0029a aVar) {
        }

        public abstract boolean a(a<?> aVar, e eVar, e eVar2);

        public abstract boolean b(a<?> aVar, Object obj, Object obj2);

        public abstract boolean c(a<?> aVar, i iVar, i iVar2);

        public abstract void d(i iVar, i iVar2);

        public abstract void e(i iVar, Thread thread);
    }

    /* loaded from: classes.dex */
    public static final class c {
        public static final c c;

        /* renamed from: d */
        public static final c f1325d;
        public final boolean a;
        public final Throwable b;

        static {
            if (a.f1320e) {
                f1325d = null;
                c = null;
                return;
            }
            f1325d = new c(false, null);
            c = new c(true, null);
        }

        public c(boolean z, Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public final Throwable a;

        /* renamed from: e.g.a.a$d$a */
        /* loaded from: classes.dex */
        public class C0030a extends Throwable {
            public C0030a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        static {
            C0030a aVar = new C0030a("Failure occurred while trying to finish a future.");
            boolean z = a.f1320e;
            Objects.requireNonNull(aVar);
        }

        public d(Throwable th) {
            boolean z = a.f1320e;
            Objects.requireNonNull(th);
            this.a = th;
        }
    }

    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: d */
        public static final e f1326d = new e(null, null);
        public final Runnable a;
        public final Executor b;
        public e c;

        public e(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends b {
        public final AtomicReferenceFieldUpdater<i, Thread> a;
        public final AtomicReferenceFieldUpdater<i, i> b;
        public final AtomicReferenceFieldUpdater<a, i> c;

        /* renamed from: d */
        public final AtomicReferenceFieldUpdater<a, e> f1327d;

        /* renamed from: e */
        public final AtomicReferenceFieldUpdater<a, Object> f1328e;

        public f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.f1327d = atomicReferenceFieldUpdater4;
            this.f1328e = atomicReferenceFieldUpdater5;
        }

        @Override // e.g.a.a.b
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            return this.f1327d.compareAndSet(aVar, eVar, eVar2);
        }

        @Override // e.g.a.a.b
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            return this.f1328e.compareAndSet(aVar, obj, obj2);
        }

        @Override // e.g.a.a.b
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            return this.c.compareAndSet(aVar, iVar, iVar2);
        }

        @Override // e.g.a.a.b
        public void d(i iVar, i iVar2) {
            this.b.lazySet(iVar, iVar2);
        }

        @Override // e.g.a.a.b
        public void e(i iVar, Thread thread) {
            this.a.lazySet(iVar, thread);
        }
    }

    /* loaded from: classes.dex */
    public static final class g<V> implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static final class h extends b {
        public h() {
            super(null);
        }

        @Override // e.g.a.a.b
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.c != eVar) {
                    return false;
                }
                aVar.c = eVar2;
                return true;
            }
        }

        @Override // e.g.a.a.b
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.b != obj) {
                    return false;
                }
                aVar.b = obj2;
                return true;
            }
        }

        @Override // e.g.a.a.b
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f1324d != iVar) {
                    return false;
                }
                aVar.f1324d = iVar2;
                return true;
            }
        }

        @Override // e.g.a.a.b
        public void d(i iVar, i iVar2) {
            iVar.b = iVar2;
        }

        @Override // e.g.a.a.b
        public void e(i iVar, Thread thread) {
            iVar.a = thread;
        }
    }

    /* loaded from: classes.dex */
    public static final class i {
        public static final i c = new i(false);
        public volatile Thread a;
        public volatile i b;

        public i() {
            a.f1322g.e(this, Thread.currentThread());
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
        f1322g = bVar;
        if (th != null) {
            f1321f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f1323h = new Object();
    }

    public static void c(a<?> aVar) {
        i iVar;
        e eVar;
        do {
            iVar = aVar.f1324d;
        } while (!f1322g.c(aVar, iVar, i.c));
        while (iVar != null) {
            Thread thread = iVar.a;
            if (thread != null) {
                iVar.a = null;
                LockSupport.unpark(thread);
            }
            iVar = iVar.b;
        }
        do {
            eVar = aVar.c;
        } while (!f1322g.a(aVar, eVar, e.f1326d));
        e eVar2 = null;
        while (eVar != null) {
            eVar = eVar.c;
            eVar.c = eVar2;
            eVar2 = eVar;
        }
        while (eVar2 != null) {
            eVar2 = eVar2.c;
            Runnable runnable = eVar2.a;
            if (!(runnable instanceof g)) {
                d(runnable, eVar2.b);
            } else {
                Objects.requireNonNull((g) runnable);
                throw null;
            }
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f1321f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static <V> V f(Future<V> future) {
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
        if (eVar != e.f1326d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.c = eVar;
                if (!f1322g.a(this, eVar, eVar2)) {
                    eVar = this.c;
                } else {
                    return;
                }
            } while (eVar != e.f1326d);
            d(runnable, executor);
        }
        d(runnable, executor);
    }

    public final void b(StringBuilder sb) {
        String str = "]";
        try {
            Object f2 = f(this);
            sb.append("SUCCESS, result=[");
            sb.append(f2 == this ? "this future" : String.valueOf(f2));
            sb.append(str);
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            str = " thrown from get()]";
            sb.append(str);
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append(str);
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.b;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f1320e ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.c : c.f1325d;
        while (!f1322g.b(this, obj, cVar)) {
            obj = this.b;
            if (!(obj instanceof g)) {
                return false;
            }
        }
        c(this);
        if (!(obj instanceof g)) {
            return true;
        }
        Objects.requireNonNull((g) obj);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V e(Object obj) {
        if (obj instanceof c) {
            Throwable th = ((c) obj).b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).a);
        } else if (obj == f1323h) {
            return null;
        } else {
            return obj;
        }
    }

    public String g() {
        Object obj = this.b;
        if (obj instanceof g) {
            Objects.requireNonNull((g) obj);
            return "setFuture=[null]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            StringBuilder h2 = f.a.a.a.a.h("remaining delay=[");
            h2.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
            h2.append(" ms]");
            return h2.toString();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
        java.util.concurrent.locks.LockSupport.park(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (java.lang.Thread.interrupted() != false) goto L_0x004b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
        r0 = r6.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r0 == null) goto L_0x003f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
        if ((r4 & (!(r0 instanceof e.g.a.a.g))) == false) goto L_0x0030;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
        return e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
        h(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final V get() {
        if (!Thread.interrupted()) {
            Object obj = this.b;
            if ((obj != null) && (!(obj instanceof g))) {
                return e(obj);
            }
            i iVar = this.f1324d;
            if (iVar == i.c) {
                return e(this.b);
            }
            i iVar2 = new i();
            do {
                b bVar = f1322g;
                bVar.d(iVar2, iVar);
                if (bVar.c(this, iVar, iVar2)) {
                    break;
                }
                iVar = this.f1324d;
            } while (iVar != i.c);
            return e(this.b);
        }
        throw new InterruptedException();
    }

    public final void h(i iVar) {
        iVar.a = null;
        while (true) {
            i iVar2 = this.f1324d;
            if (iVar2 != i.c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.b;
                    if (iVar2.a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.b = iVar4;
                        if (iVar3.a == null) {
                            break;
                        }
                    } else if (!f1322g.c(this, iVar2, iVar4)) {
                        break;
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    public boolean i(V v) {
        if (v == null) {
            v = (V) f1323h;
        }
        if (!f1322g.b(this, null, v)) {
            return false;
        }
        c(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.b instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.b;
        return (!(obj instanceof g)) & (obj != null);
    }

    public boolean j(Throwable th) {
        Objects.requireNonNull(th);
        if (!f1322g.b(this, null, new d(th))) {
            return false;
        }
        c(this);
        return true;
    }

    @Override // java.lang.Object
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
                    str2 = g();
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

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
        java.util.concurrent.locks.LockSupport.parkNanos(r12, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
        if (java.lang.Thread.interrupted() != false) goto L_0x0070;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
        r0 = r12.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
        if (r0 == null) goto L_0x0055;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005b, code lost:
        if ((r1 & (!(r0 instanceof e.g.a.a.g))) == false) goto L_0x0062;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
        return e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0062, code lost:
        r0 = r4 - java.lang.System.nanoTime();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006a, code lost:
        if (r0 >= 1000) goto L_0x0046;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
        h(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
        h(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0078, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final V get(long j2, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.b;
            if ((obj != null) && (!(obj instanceof g))) {
                return e(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                i iVar = this.f1324d;
                if (iVar == i.c) {
                    return e(this.b);
                }
                i iVar2 = new i();
                do {
                    b bVar = f1322g;
                    bVar.d(iVar2, iVar);
                    if (bVar.c(this, iVar, iVar2)) {
                        break;
                    }
                    iVar = this.f1324d;
                } while (iVar != i.c);
                return e(this.b);
            }
            while (nanos > 0) {
                Object obj2 = this.b;
                if ((obj2 != null) && (!(obj2 instanceof g))) {
                    return e(obj2);
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
                String x = f.a.a.a.a.x(str, " (plus ");
                long j3 = -nanos;
                long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit.toNanos(convert);
                int i2 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z = i2 == 0 || nanos2 > 1000;
                if (i2 > 0) {
                    String str2 = x + convert + " " + lowerCase;
                    if (z) {
                        str2 = f.a.a.a.a.x(str2, ",");
                    }
                    x = f.a.a.a.a.x(str2, " ");
                }
                if (z) {
                    x = x + nanos2 + " nanoseconds ";
                }
                str = f.a.a.a.a.x(x, "delay)");
            }
            if (isDone()) {
                throw new TimeoutException(f.a.a.a.a.x(str, " but future completed as timeout expired"));
            }
            throw new TimeoutException(f.a.a.a.a.c(str, " for ", aVar));
        }
        throw new InterruptedException();
    }
}
