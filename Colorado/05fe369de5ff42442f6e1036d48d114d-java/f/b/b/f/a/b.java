package f.b.b.f.a;

import f.b.b.a.m;
import f.b.b.a.n;
import f.b.b.a.v;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
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
import sun.misc.Unsafe;

public abstract class b<V> extends f.b.b.f.a.e0.a implements u<V> {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f3111e;

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f3112f = Logger.getLogger(b.class.getName());

    /* renamed from: g  reason: collision with root package name */
    public static final AbstractC0109b f3113g;

    /* renamed from: h  reason: collision with root package name */
    public static final Object f3114h = new Object();
    private volatile Object b;
    private volatile e c;

    /* renamed from: d  reason: collision with root package name */
    private volatile l f3115d;

    /* renamed from: f.b.b.f.a.b$b  reason: collision with other inner class name */
    public static abstract class AbstractC0109b {
        public AbstractC0109b(a aVar) {
        }

        public abstract boolean a(b<?> bVar, e eVar, e eVar2);

        public abstract boolean b(b<?> bVar, Object obj, Object obj2);

        public abstract boolean c(b<?> bVar, l lVar, l lVar2);

        public abstract void d(l lVar, l lVar2);

        public abstract void e(l lVar, Thread thread);
    }

    public static final class c {
        public static final c c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f3116d;
        public final boolean a;
        public final Throwable b;

        static {
            if (b.f3111e) {
                f3116d = null;
                c = null;
                return;
            }
            f3116d = new c(false, null);
            c = new c(true, null);
        }

        public c(boolean z, Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    public static final class d {
        public static final d b = new d(new a("Failure occurred while trying to finish a future."));
        public final Throwable a;

        public static class a extends Throwable {
            public a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            Objects.requireNonNull(th);
            this.a = th;
        }
    }

    public static final class e {

        /* renamed from: d  reason: collision with root package name */
        public static final e f3117d = new e(null, null);
        public final Runnable a;
        public final Executor b;
        public e c;

        public e(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    public static final class f extends AbstractC0109b {
        public final AtomicReferenceFieldUpdater<l, Thread> a;
        public final AtomicReferenceFieldUpdater<l, l> b;
        public final AtomicReferenceFieldUpdater<b, l> c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<b, e> f3118d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<b, Object> f3119e;

        public f(AtomicReferenceFieldUpdater<l, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<l, l> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<b, l> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<b, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<b, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.f3118d = atomicReferenceFieldUpdater4;
            this.f3119e = atomicReferenceFieldUpdater5;
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public boolean a(b<?> bVar, e eVar, e eVar2) {
            return this.f3118d.compareAndSet(bVar, eVar, eVar2);
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public boolean b(b<?> bVar, Object obj, Object obj2) {
            return this.f3119e.compareAndSet(bVar, obj, obj2);
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public boolean c(b<?> bVar, l lVar, l lVar2) {
            return this.c.compareAndSet(bVar, lVar, lVar2);
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public void d(l lVar, l lVar2) {
            this.b.lazySet(lVar, lVar2);
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public void e(l lVar, Thread thread) {
            this.a.lazySet(lVar, thread);
        }
    }

    public static final class g<V> implements Runnable {
        public final b<V> b;
        public final u<? extends V> c;

        public g(b<V> bVar, u<? extends V> uVar) {
            this.b = bVar;
            this.c = uVar;
        }

        public void run() {
            if (((b) this.b).b == this) {
                if (b.f3113g.b(this.b, this, b.o(this.c))) {
                    b.l(this.b);
                }
            }
        }
    }

    public static final class h extends AbstractC0109b {
        public h(a aVar) {
            super(null);
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public boolean a(b<?> bVar, e eVar, e eVar2) {
            synchronized (bVar) {
                if (((b) bVar).c != eVar) {
                    return false;
                }
                ((b) bVar).c = eVar2;
                return true;
            }
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public boolean b(b<?> bVar, Object obj, Object obj2) {
            synchronized (bVar) {
                if (((b) bVar).b != obj) {
                    return false;
                }
                ((b) bVar).b = obj2;
                return true;
            }
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public boolean c(b<?> bVar, l lVar, l lVar2) {
            synchronized (bVar) {
                if (((b) bVar).f3115d != lVar) {
                    return false;
                }
                ((b) bVar).f3115d = lVar2;
                return true;
            }
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public void d(l lVar, l lVar2) {
            lVar.b = lVar2;
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public void e(l lVar, Thread thread) {
            lVar.a = thread;
        }
    }

    public interface i<V> extends u<V> {
    }

    public static abstract class j<V> extends b<V> implements i<V> {
        @Override // f.b.b.f.a.b, f.b.b.f.a.u
        public final void a(Runnable runnable, Executor executor) {
            b.super.a(runnable, executor);
        }

        @Override // f.b.b.f.a.b
        public final boolean cancel(boolean z) {
            return b.super.cancel(z);
        }

        @Override // f.b.b.f.a.b, java.util.concurrent.Future
        public final V get() {
            return (V) b.super.get();
        }

        @Override // f.b.b.f.a.b, java.util.concurrent.Future
        public final V get(long j2, TimeUnit timeUnit) {
            return (V) b.super.get(j2, timeUnit);
        }

        @Override // f.b.b.f.a.b
        public final boolean isCancelled() {
            return b.super.isCancelled();
        }

        @Override // f.b.b.f.a.b
        public final boolean isDone() {
            return b.super.isDone();
        }
    }

    public static final class k extends AbstractC0109b {
        public static final Unsafe a;
        public static final long b;
        public static final long c;

        /* renamed from: d  reason: collision with root package name */
        public static final long f3120d;

        /* renamed from: e  reason: collision with root package name */
        public static final long f3121e;

        /* renamed from: f  reason: collision with root package name */
        public static final long f3122f;

        public static class a implements PrivilegedExceptionAction<Unsafe> {
            /* renamed from: a */
            public Unsafe run() {
                Field[] declaredFields = Unsafe.class.getDeclaredFields();
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            Unsafe unsafe = Unsafe.getUnsafe();
            try {
                unsafe = (Unsafe) AccessController.doPrivileged(new a());
                try {
                    c = unsafe.objectFieldOffset(b.class.getDeclaredField("d"));
                    b = unsafe.objectFieldOffset(b.class.getDeclaredField("c"));
                    f3120d = unsafe.objectFieldOffset(b.class.getDeclaredField("b"));
                    f3121e = unsafe.objectFieldOffset(l.class.getDeclaredField("a"));
                    f3122f = unsafe.objectFieldOffset(l.class.getDeclaredField("b"));
                    a = unsafe;
                } catch (Exception e2) {
                    v.c(e2);
                    throw new RuntimeException(e2);
                }
            } catch (PrivilegedActionException e3) {
                throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
            }
        }

        public k(a aVar) {
            super(null);
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public boolean a(b<?> bVar, e eVar, e eVar2) {
            return a.compareAndSwapObject(bVar, b, eVar, eVar2);
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public boolean b(b<?> bVar, Object obj, Object obj2) {
            return a.compareAndSwapObject(bVar, f3120d, obj, obj2);
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public boolean c(b<?> bVar, l lVar, l lVar2) {
            return a.compareAndSwapObject(bVar, c, lVar, lVar2);
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public void d(l lVar, l lVar2) {
            a.putObject(lVar, f3122f, lVar2);
        }

        @Override // f.b.b.f.a.b.AbstractC0109b
        public void e(l lVar, Thread thread) {
            a.putObject(lVar, f3121e, thread);
        }
    }

    public static final class l {
        public static final l c = new l(false);
        public volatile Thread a;
        public volatile l b;

        public l() {
            b.f3113g.e(this, Thread.currentThread());
        }

        public l(boolean z) {
        }
    }

    static {
        boolean z;
        AbstractC0109b bVar;
        Throwable th;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        f3111e = z;
        Throwable th2 = null;
        try {
            bVar = new k(null);
            th = null;
        } catch (Throwable th3) {
            bVar = new h(null);
            th2 = th3;
        }
        f3113g = bVar;
        if (th2 != null) {
            Logger logger = f3112f;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", th);
            logger.log(level, "SafeAtomicHelper is broken!", th2);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0002 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [f.b.b.f.a.b<?>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [f.b.b.f.a.b] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [f.b.b.f.a.b, f.b.b.f.a.b<V>] */
    /* JADX WARN: Type inference failed for: r4v2, types: [f.b.b.f.a.b$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static void l(b<?> bVar) {
        e eVar;
        e eVar2;
        e eVar3 = null;
        while (true) {
            l lVar = ((b) bVar).f3115d;
            if (f3113g.c((b) bVar, lVar, l.c)) {
                while (lVar != null) {
                    Thread thread = lVar.a;
                    if (thread != null) {
                        lVar.a = null;
                        LockSupport.unpark(thread);
                    }
                    lVar = lVar.b;
                }
                ((b) bVar).j();
                do {
                    eVar = ((b) bVar).c;
                } while (!f3113g.a((b) bVar, eVar, e.f3117d));
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
                        bVar = gVar.b;
                        if (((b) bVar).b == gVar) {
                            if (f3113g.b(bVar, gVar, o(gVar.c))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        m(runnable, eVar2.b);
                    }
                    eVar2 = eVar3;
                }
                return;
            }
        }
    }

    public static void m(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f3112f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object o(u<?> uVar) {
        Throwable b2;
        if (uVar instanceof i) {
            Object obj = ((b) uVar).b;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (cVar.a) {
                return cVar.b != null ? new c(false, cVar.b) : c.f3116d;
            }
            return obj;
        } else if ((uVar instanceof f.b.b.f.a.e0.a) && (b2 = ((f.b.b.f.a.e0.a) uVar).b()) != null) {
            return new d(b2);
        } else {
            boolean isCancelled = uVar.isCancelled();
            if ((!f3111e) && isCancelled) {
                return c.f3116d;
            }
            try {
                Object p = p(uVar);
                if (!isCancelled) {
                    return p == null ? f3114h : p;
                }
                return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + uVar));
            } catch (ExecutionException e2) {
                if (!isCancelled) {
                    return new d(e2.getCause());
                }
                return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + uVar, e2));
            } catch (CancellationException e3) {
                if (isCancelled) {
                    return new c(false, e3);
                }
                return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + uVar, e3));
            } catch (Throwable th) {
                return new d(th);
            }
        }
    }

    public static <V> V p(Future<V> future) {
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
    public void a(Runnable runnable, Executor executor) {
        e eVar;
        f.b.a.c.b.o.b.z(runnable, "Runnable was null.");
        f.b.a.c.b.o.b.z(executor, "Executor was null.");
        if (isDone() || (eVar = this.c) == e.f3117d) {
            m(runnable, executor);
        }
        e eVar2 = new e(runnable, executor);
        do {
            eVar2.c = eVar;
            if (!f3113g.a(this, eVar, eVar2)) {
                eVar = this.c;
            } else {
                return;
            }
        } while (eVar != e.f3117d);
        m(runnable, executor);
    }

    @Override // f.b.b.f.a.e0.a
    public final Throwable b() {
        if (!(this instanceof i)) {
            return null;
        }
        Object obj = this.b;
        if (obj instanceof d) {
            return ((d) obj).a;
        }
        return null;
    }

    public boolean cancel(boolean z) {
        Object obj = this.b;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f3111e ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.c : c.f3116d;
        boolean z2 = false;
        b<V> bVar = this;
        while (true) {
            if (f3113g.b(bVar, obj, cVar)) {
                l(bVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                u<? extends V> uVar = ((g) obj).c;
                if (uVar instanceof i) {
                    bVar = (b) uVar;
                    obj = bVar.b;
                    if (!(obj == null) && !(obj instanceof g)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    uVar.cancel(z);
                    return true;
                }
            } else {
                obj = bVar.b;
                if (!(obj instanceof g)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.b;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return n(obj2);
            }
            l lVar = this.f3115d;
            if (lVar != l.c) {
                l lVar2 = new l();
                do {
                    AbstractC0109b bVar = f3113g;
                    bVar.d(lVar2, lVar);
                    if (bVar.c(this, lVar, lVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.b;
                            } else {
                                s(lVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return n(obj);
                    }
                    lVar = this.f3115d;
                } while (lVar != l.c);
            }
            return n(this.b);
        }
        throw new InterruptedException();
    }

    public final void i(StringBuilder sb) {
        String str = "]";
        try {
            Object p = p(this);
            sb.append("SUCCESS, result=[");
            k(sb, p);
            sb.append(str);
            return;
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
        } catch (CancellationException unused) {
            str = "CANCELLED";
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            str = " thrown from get()]";
        }
        sb.append(str);
    }

    public boolean isCancelled() {
        return this.b instanceof c;
    }

    public boolean isDone() {
        Object obj = this.b;
        return (!(obj instanceof g)) & (obj != null);
    }

    public void j() {
    }

    public final void k(StringBuilder sb, Object obj) {
        if (obj == this) {
            try {
                sb.append("this future");
            } catch (RuntimeException | StackOverflowError e2) {
                sb.append("Exception thrown from implementation: ");
                sb.append(e2.getClass());
            }
        } else {
            sb.append(obj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public final V n(Object obj) {
        if (obj instanceof c) {
            Throwable th = ((c) obj).b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).a);
        } else if (obj == f3114h) {
            return null;
        } else {
            return obj;
        }
    }

    public final void q(Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(w());
        }
    }

    public String r() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        StringBuilder i2 = f.a.a.a.a.i("remaining delay=[");
        i2.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
        i2.append(" ms]");
        return i2.toString();
    }

    public final void s(l lVar) {
        lVar.a = null;
        while (true) {
            l lVar2 = this.f3115d;
            if (lVar2 != l.c) {
                l lVar3 = null;
                while (lVar2 != null) {
                    l lVar4 = lVar2.b;
                    if (lVar2.a != null) {
                        lVar3 = lVar2;
                    } else if (lVar3 != null) {
                        lVar3.b = lVar4;
                        if (lVar3.a == null) {
                        }
                    } else if (!f3113g.c(this, lVar2, lVar4)) {
                    }
                    lVar2 = lVar4;
                }
                return;
            }
            return;
        }
    }

    public boolean t(V v) {
        if (v == null) {
            v = (V) f3114h;
        }
        if (!f3113g.b(this, null, v)) {
            return false;
        }
        l(this);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083  */
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            i(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.b;
            if (obj instanceof g) {
                sb.append(", setFuture=[");
                k(sb, ((g) obj).c);
            } else {
                try {
                    str = r();
                    m mVar = n.a;
                    if (str == null || str.isEmpty()) {
                        str = null;
                    }
                } catch (RuntimeException | StackOverflowError e2) {
                    StringBuilder i2 = f.a.a.a.a.i("Exception thrown from implementation: ");
                    i2.append(e2.getClass());
                    str = i2.toString();
                }
                if (str != null) {
                    sb.append(", info=[");
                    sb.append(str);
                }
                if (isDone()) {
                    sb.delete(length, sb.length());
                    i(sb);
                }
            }
            sb.append("]");
            if (isDone()) {
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean u(Throwable th) {
        Objects.requireNonNull(th);
        if (!f3113g.b(this, null, new d(th))) {
            return false;
        }
        l(this);
        return true;
    }

    public boolean v(u<? extends V> uVar) {
        g gVar;
        d dVar;
        Objects.requireNonNull(uVar);
        Object obj = this.b;
        if (obj == null) {
            if (uVar.isDone()) {
                if (!f3113g.b(this, null, o(uVar))) {
                    return false;
                }
                l(this);
                return true;
            }
            gVar = new g(this, uVar);
            if (f3113g.b(this, null, gVar)) {
                try {
                    uVar.a(gVar, k.INSTANCE);
                } catch (Throwable unused) {
                    dVar = d.b;
                }
                return true;
            }
            obj = this.b;
        }
        if (obj instanceof c) {
            uVar.cancel(((c) obj).a);
        }
        return false;
        f3113g.b(this, gVar, dVar);
        return true;
    }

    public final boolean w() {
        Object obj = this.b;
        return (obj instanceof c) && ((c) obj).a;
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.b;
            if ((obj != null) && (!(obj instanceof g))) {
                return n(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                l lVar = this.f3115d;
                if (lVar != l.c) {
                    l lVar2 = new l();
                    do {
                        AbstractC0109b bVar = f3113g;
                        bVar.d(lVar2, lVar);
                        if (bVar.c(this, lVar, lVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.b;
                                    if ((obj2 != null) && (!(obj2 instanceof g))) {
                                        return n(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    s(lVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            s(lVar2);
                        } else {
                            lVar = this.f3115d;
                        }
                    } while (lVar != l.c);
                }
                return n(this.b);
            }
            while (nanos > 0) {
                Object obj3 = this.b;
                if ((obj3 != null) && (!(obj3 instanceof g))) {
                    return n(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String bVar2 = toString();
            String timeUnit2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = timeUnit2.toLowerCase(locale);
            String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String c2 = f.a.a.a.a.c(str, " (plus ");
                long j3 = -nanos;
                long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit.toNanos(convert);
                int i2 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z = i2 == 0 || nanos2 > 1000;
                if (i2 > 0) {
                    String str2 = c2 + convert + " " + lowerCase;
                    if (z) {
                        str2 = f.a.a.a.a.c(str2, ",");
                    }
                    c2 = f.a.a.a.a.c(str2, " ");
                }
                if (z) {
                    c2 = c2 + nanos2 + " nanoseconds ";
                }
                str = f.a.a.a.a.c(c2, "delay)");
            }
            if (isDone()) {
                throw new TimeoutException(f.a.a.a.a.c(str, " but future completed as timeout expired"));
            }
            throw new TimeoutException(f.a.a.a.a.d(str, " for ", bVar2));
        }
        throw new InterruptedException();
    }
}
