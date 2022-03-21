package e.f.a;

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
    public static final boolean f1202e = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f1203f = Logger.getLogger(a.class.getName());

    /* renamed from: g  reason: collision with root package name */
    public static final b f1204g;

    /* renamed from: h  reason: collision with root package name */
    public static final Object f1205h = new Object();
    public volatile Object b;
    public volatile e c;

    /* renamed from: d  reason: collision with root package name */
    public volatile i f1206d;

    public static abstract class b {
        public b(C0026a aVar) {
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
        public static final c f1207d;
        public final boolean a;
        public final Throwable b;

        static {
            if (a.f1202e) {
                f1207d = null;
                c = null;
                return;
            }
            f1207d = new c(false, null);
            c = new c(true, null);
        }

        public c(boolean z, Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    public static final class d {
        public final Throwable a;

        /* renamed from: e.f.a.a$d$a  reason: collision with other inner class name */
        public class C0027a extends Throwable {
            public C0027a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        static {
            C0027a aVar = new C0027a("Failure occurred while trying to finish a future.");
            boolean z = a.f1202e;
            Objects.requireNonNull(aVar);
        }

        public d(Throwable th) {
            boolean z = a.f1202e;
            Objects.requireNonNull(th);
            this.a = th;
        }
    }

    public static final class e {

        /* renamed from: d  reason: collision with root package name */
        public static final e f1208d = new e(null, null);
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
        public final AtomicReferenceFieldUpdater<a, e> f1209d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, Object> f1210e;

        public f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.f1209d = atomicReferenceFieldUpdater4;
            this.f1210e = atomicReferenceFieldUpdater5;
        }

        @Override // e.f.a.a.b
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            return this.f1209d.compareAndSet(aVar, eVar, eVar2);
        }

        @Override // e.f.a.a.b
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            return this.f1210e.compareAndSet(aVar, obj, obj2);
        }

        @Override // e.f.a.a.b
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            return this.c.compareAndSet(aVar, iVar, iVar2);
        }

        @Override // e.f.a.a.b
        public void d(i iVar, i iVar2) {
            this.b.lazySet(iVar, iVar2);
        }

        @Override // e.f.a.a.b
        public void e(i iVar, Thread thread) {
            this.a.lazySet(iVar, thread);
        }
    }

    public static final class g<V> implements Runnable {
        public void run() {
            throw null;
        }
    }

    public static final class h extends b {
        public h() {
            super(null);
        }

        @Override // e.f.a.a.b
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.c != eVar) {
                    return false;
                }
                aVar.c = eVar2;
                return true;
            }
        }

        @Override // e.f.a.a.b
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.b != obj) {
                    return false;
                }
                aVar.b = obj2;
                return true;
            }
        }

        @Override // e.f.a.a.b
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f1206d != iVar) {
                    return false;
                }
                aVar.f1206d = iVar2;
                return true;
            }
        }

        @Override // e.f.a.a.b
        public void d(i iVar, i iVar2) {
            iVar.b = iVar2;
        }

        @Override // e.f.a.a.b
        public void e(i iVar, Thread thread) {
            iVar.a = thread;
        }
    }

    public static final class i {
        public static final i c = new i(false);
        public volatile Thread a;
        public volatile i b;

        public i() {
            a.f1204g.e(this, Thread.currentThread());
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
        f1204g = bVar;
        if (th != null) {
            f1203f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    public static void c(a<?> aVar) {
        i iVar;
        e eVar;
        do {
            iVar = aVar.f1206d;
        } while (!f1204g.c(aVar, iVar, i.c));
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
        } while (!f1204g.a(aVar, eVar, e.f1208d));
        e eVar2 = null;
        while (eVar != null) {
            e eVar3 = eVar.c;
            eVar.c = eVar2;
            eVar2 = eVar;
            eVar = eVar3;
        }
        while (eVar2 != null) {
            e eVar4 = eVar2.c;
            Runnable runnable = eVar2.a;
            if (!(runnable instanceof g)) {
                d(runnable, eVar2.b);
                eVar2 = eVar4;
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
            Logger logger = f1203f;
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
        e eVar = e.f1208d;
        Objects.requireNonNull(runnable);
        Objects.requireNonNull(executor);
        e eVar2 = this.c;
        if (eVar2 != eVar) {
            e eVar3 = new e(runnable, executor);
            do {
                eVar3.c = eVar2;
                if (!f1204g.a(this, eVar2, eVar3)) {
                    eVar2 = this.c;
                } else {
                    return;
                }
            } while (eVar2 != eVar);
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
        c cVar = f1202e ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.c : c.f1207d;
        while (!f1204g.b(this, obj, cVar)) {
            obj = this.b;
            if (!(obj instanceof g)) {
            }
        }
        c(this);
        if (!(obj instanceof g)) {
            return true;
        }
        Objects.requireNonNull((g) obj);
        throw null;
        return false;
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
        } else if (obj == f1205h) {
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

    @Override // java.util.concurrent.Future
    public final V get() {
        Object obj;
        i iVar = i.c;
        if (!Thread.interrupted()) {
            Object obj2 = this.b;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return e(obj2);
            }
            i iVar2 = this.f1206d;
            if (iVar2 != iVar) {
                i iVar3 = new i();
                do {
                    b bVar = f1204g;
                    bVar.d(iVar3, iVar2);
                    if (bVar.c(this, iVar2, iVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.b;
                            } else {
                                h(iVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return e(obj);
                    }
                    iVar2 = this.f1206d;
                } while (iVar2 != iVar);
            }
            return e(this.b);
        }
        throw new InterruptedException();
    }

    public final void h(i iVar) {
        iVar.a = null;
        while (true) {
            i iVar2 = this.f1206d;
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
                    } else if (!f1204g.c(this, iVar2, iVar4)) {
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
            v = (V) f1205h;
        }
        if (!f1204g.b(this, null, v)) {
            return false;
        }
        c(this);
        return true;
    }

    public final boolean isCancelled() {
        return this.b instanceof c;
    }

    public final boolean isDone() {
        Object obj = this.b;
        return (!(obj instanceof g)) & (obj != null);
    }

    public boolean j(Throwable th) {
        Objects.requireNonNull(th);
        if (!f1204g.b(this, null, new d(th))) {
            return false;
        }
        c(this);
        return true;
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

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ba  */
    @Override // java.util.concurrent.Future
    public final V get(long j2, TimeUnit timeUnit) {
        a<V> aVar;
        a<V> aVar2;
        TimeUnit timeUnit2;
        i iVar = i.c;
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.b;
            if ((obj != null) && (!(obj instanceof g))) {
                return e(obj);
            }
            long j3 = 0;
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                i iVar2 = this.f1206d;
                if (iVar2 != iVar) {
                    i iVar3 = new i();
                    do {
                        b bVar = f1204g;
                        bVar.d(iVar3, iVar2);
                        if (bVar.c(this, iVar2, iVar3)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.b;
                                    if ((obj2 != null) && (!(obj2 instanceof g))) {
                                        return e(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    h(iVar3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            h(iVar3);
                            aVar2 = this;
                            aVar = aVar2;
                            timeUnit2 = timeUnit;
                            j3 = 0;
                        } else {
                            iVar2 = this.f1206d;
                        }
                    } while (iVar2 != iVar);
                }
                return e(this.b);
            }
            aVar2 = this;
            aVar = aVar2;
            timeUnit2 = timeUnit;
            if (nanos <= j3) {
                String aVar3 = aVar2.toString();
                String timeUnit3 = timeUnit.toString();
                Locale locale = Locale.ROOT;
                String lowerCase = timeUnit3.toLowerCase(locale);
                String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
            } else {
                Object obj3 = aVar.b;
                if (!(obj3 != null) || !(!(obj3 instanceof g))) {
                    if (!Thread.interrupted()) {
                        nanos = nanoTime - System.nanoTime();
                        j3 = 0;
                        if (nanos <= j3) {
                        }
                    }
                    throw new InterruptedException();
                }
                return aVar.e(obj3);
            }
            String aVar32 = aVar2.toString();
            String timeUnit32 = timeUnit.toString();
            Locale locale2 = Locale.ROOT;
            String lowerCase2 = timeUnit32.toLowerCase(locale2);
            String str2 = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale2);
            if (nanos + 1000 < 0) {
                String t = f.a.a.a.a.t(str2, " (plus ");
                long j4 = -nanos;
                long convert = timeUnit2.convert(j4, TimeUnit.NANOSECONDS);
                long nanos2 = j4 - timeUnit2.toNanos(convert);
                int i2 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z = i2 == 0 || nanos2 > 1000;
                if (i2 > 0) {
                    String str3 = t + convert + " " + lowerCase2;
                    if (z) {
                        str3 = f.a.a.a.a.t(str3, ",");
                    }
                    t = f.a.a.a.a.t(str3, " ");
                }
                if (z) {
                    t = t + nanos2 + " nanoseconds ";
                }
                str2 = f.a.a.a.a.t(t, "delay)");
            }
            if (aVar2.isDone()) {
                throw new TimeoutException(f.a.a.a.a.t(str2, " but future completed as timeout expired"));
            }
            throw new TimeoutException(f.a.a.a.a.c(str2, " for ", aVar32));
        }
        throw new InterruptedException();
    }
}
