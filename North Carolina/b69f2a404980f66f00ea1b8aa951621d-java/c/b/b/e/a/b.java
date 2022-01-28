package c.b.b.e.a;

import c.b.b.a.o;
import c.b.b.e.a.l;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
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
import sun.misc.Unsafe;

public abstract class b<V> extends c.b.b.e.a.d0.a implements u<V> {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f3367e;
    public static final Logger f = Logger.getLogger(b.class.getName());
    public static final AbstractC0081b g;
    public static final Object h = new Object();

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f3368b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f3369c;

    /* renamed from: d  reason: collision with root package name */
    public volatile l f3370d;

    /* renamed from: c.b.b.e.a.b$b  reason: collision with other inner class name */
    public static abstract class AbstractC0081b {
        public AbstractC0081b(a aVar) {
        }

        public abstract boolean a(b<?> bVar, e eVar, e eVar2);

        public abstract boolean b(b<?> bVar, Object obj, Object obj2);

        public abstract boolean c(b<?> bVar, l lVar, l lVar2);

        public abstract void d(l lVar, l lVar2);

        public abstract void e(l lVar, Thread thread);
    }

    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        public static final c f3371c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f3372d;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f3373a;

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f3374b;

        static {
            if (b.f3367e) {
                f3372d = null;
                f3371c = null;
                return;
            }
            f3372d = new c(false, null);
            f3371c = new c(true, null);
        }

        public c(boolean z, Throwable th) {
            this.f3373a = z;
            this.f3374b = th;
        }
    }

    public static final class d {

        /* renamed from: b  reason: collision with root package name */
        public static final d f3375b = new d(new a("Failure occurred while trying to finish a future."));

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f3376a;

        public static class a extends Throwable {
            public a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            if (th != null) {
                this.f3376a = th;
                return;
            }
            throw null;
        }
    }

    public static final class e {

        /* renamed from: d  reason: collision with root package name */
        public static final e f3377d = new e(null, null);

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f3378a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f3379b;

        /* renamed from: c  reason: collision with root package name */
        public e f3380c;

        public e(Runnable runnable, Executor executor) {
            this.f3378a = runnable;
            this.f3379b = executor;
        }
    }

    public static final class f extends AbstractC0081b {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<l, Thread> f3381a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<l, l> f3382b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<b, l> f3383c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<b, e> f3384d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<b, Object> f3385e;

        public f(AtomicReferenceFieldUpdater<l, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<l, l> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<b, l> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<b, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<b, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.f3381a = atomicReferenceFieldUpdater;
            this.f3382b = atomicReferenceFieldUpdater2;
            this.f3383c = atomicReferenceFieldUpdater3;
            this.f3384d = atomicReferenceFieldUpdater4;
            this.f3385e = atomicReferenceFieldUpdater5;
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public boolean a(b<?> bVar, e eVar, e eVar2) {
            return this.f3384d.compareAndSet(bVar, eVar, eVar2);
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public boolean b(b<?> bVar, Object obj, Object obj2) {
            return this.f3385e.compareAndSet(bVar, obj, obj2);
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public boolean c(b<?> bVar, l lVar, l lVar2) {
            return this.f3383c.compareAndSet(bVar, lVar, lVar2);
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public void d(l lVar, l lVar2) {
            this.f3382b.lazySet(lVar, lVar2);
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public void e(l lVar, Thread thread) {
            this.f3381a.lazySet(lVar, thread);
        }
    }

    public static final class g<V> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final b<V> f3386b;

        /* renamed from: c  reason: collision with root package name */
        public final u<? extends V> f3387c;

        public g(b<V> bVar, u<? extends V> uVar) {
            this.f3386b = bVar;
            this.f3387c = uVar;
        }

        public void run() {
            if (this.f3386b.f3368b == this) {
                if (b.g.b(this.f3386b, this, b.h(this.f3387c))) {
                    b.e(this.f3386b);
                }
            }
        }
    }

    public static final class h extends AbstractC0081b {
        public h(a aVar) {
            super(null);
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public boolean a(b<?> bVar, e eVar, e eVar2) {
            synchronized (bVar) {
                if (bVar.f3369c != eVar) {
                    return false;
                }
                bVar.f3369c = eVar2;
                return true;
            }
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public boolean b(b<?> bVar, Object obj, Object obj2) {
            synchronized (bVar) {
                if (bVar.f3368b != obj) {
                    return false;
                }
                bVar.f3368b = obj2;
                return true;
            }
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public boolean c(b<?> bVar, l lVar, l lVar2) {
            synchronized (bVar) {
                if (bVar.f3370d != lVar) {
                    return false;
                }
                bVar.f3370d = lVar2;
                return true;
            }
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public void d(l lVar, l lVar2) {
            lVar.f3395b = lVar2;
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public void e(l lVar, Thread thread) {
            lVar.f3394a = thread;
        }
    }

    public interface i<V> extends u<V> {
    }

    public static abstract class j<V> extends b<V> implements i<V> {
        @Override // c.b.b.e.a.b, c.b.b.e.a.u
        public final void b(Runnable runnable, Executor executor) {
            b.super.b(runnable, executor);
        }

        @Override // c.b.b.e.a.b
        public final boolean cancel(boolean z) {
            return b.super.cancel(z);
        }

        @Override // java.util.concurrent.Future, c.b.b.e.a.b
        public final V get() {
            return (V) b.super.get();
        }

        @Override // java.util.concurrent.Future, c.b.b.e.a.b
        public final V get(long j, TimeUnit timeUnit) {
            return (V) b.super.get(j, timeUnit);
        }

        @Override // c.b.b.e.a.b
        public final boolean isCancelled() {
            return this.f3368b instanceof c;
        }

        @Override // c.b.b.e.a.b
        public final boolean isDone() {
            return b.super.isDone();
        }
    }

    public static final class k extends AbstractC0081b {

        /* renamed from: a  reason: collision with root package name */
        public static final Unsafe f3388a;

        /* renamed from: b  reason: collision with root package name */
        public static final long f3389b;

        /* renamed from: c  reason: collision with root package name */
        public static final long f3390c;

        /* renamed from: d  reason: collision with root package name */
        public static final long f3391d;

        /* renamed from: e  reason: collision with root package name */
        public static final long f3392e;
        public static final long f;

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
                    f3390c = unsafe.objectFieldOffset(b.class.getDeclaredField("d"));
                    f3389b = unsafe.objectFieldOffset(b.class.getDeclaredField("c"));
                    f3391d = unsafe.objectFieldOffset(b.class.getDeclaredField("b"));
                    f3392e = unsafe.objectFieldOffset(l.class.getDeclaredField("a"));
                    f = unsafe.objectFieldOffset(l.class.getDeclaredField("b"));
                    f3388a = unsafe;
                } catch (Exception e2) {
                    o.c(e2);
                    throw new RuntimeException(e2);
                }
            } catch (PrivilegedActionException e3) {
                throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
            }
        }

        public k(a aVar) {
            super(null);
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public boolean a(b<?> bVar, e eVar, e eVar2) {
            return f3388a.compareAndSwapObject(bVar, f3389b, eVar, eVar2);
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public boolean b(b<?> bVar, Object obj, Object obj2) {
            return f3388a.compareAndSwapObject(bVar, f3391d, obj, obj2);
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public boolean c(b<?> bVar, l lVar, l lVar2) {
            return f3388a.compareAndSwapObject(bVar, f3390c, lVar, lVar2);
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public void d(l lVar, l lVar2) {
            f3388a.putObject(lVar, f, lVar2);
        }

        @Override // c.b.b.e.a.b.AbstractC0081b
        public void e(l lVar, Thread thread) {
            f3388a.putObject(lVar, f3392e, thread);
        }
    }

    public static final class l {

        /* renamed from: c  reason: collision with root package name */
        public static final l f3393c = new l(false);

        /* renamed from: a  reason: collision with root package name */
        public volatile Thread f3394a;

        /* renamed from: b  reason: collision with root package name */
        public volatile l f3395b;

        public l() {
            b.g.e(this, Thread.currentThread());
        }

        public l(boolean z) {
        }
    }

    static {
        boolean z;
        AbstractC0081b bVar;
        Throwable th;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        f3367e = z;
        Throwable th2 = null;
        try {
            bVar = new k(null);
            th = null;
        } catch (Throwable th3) {
            bVar = new h(null);
            th2 = th3;
        }
        g = bVar;
        if (th2 != null) {
            f.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", th);
            f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th2);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0002 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [c.b.b.e.a.b<?>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [c.b.b.e.a.b] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [c.b.b.e.a.b<V>, c.b.b.e.a.b] */
    /* JADX WARN: Type inference failed for: r4v2, types: [c.b.b.e.a.b$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static void e(b<?> bVar) {
        e eVar;
        e eVar2;
        e eVar3 = null;
        while (true) {
            l lVar = ((b) bVar).f3370d;
            if (g.c((b) bVar, lVar, l.f3393c)) {
                while (lVar != null) {
                    Thread thread = lVar.f3394a;
                    if (thread != null) {
                        lVar.f3394a = null;
                        LockSupport.unpark(thread);
                    }
                    lVar = lVar.f3395b;
                }
                ((b) bVar).c();
                do {
                    eVar = ((b) bVar).f3369c;
                } while (!g.a((b) bVar, eVar, e.f3377d));
                while (true) {
                    eVar2 = eVar3;
                    eVar3 = eVar;
                    if (eVar3 == null) {
                        break;
                    }
                    eVar = eVar3.f3380c;
                    eVar3.f3380c = eVar2;
                }
                while (eVar2 != null) {
                    eVar3 = eVar2.f3380c;
                    Runnable runnable = eVar2.f3378a;
                    if (runnable instanceof g) {
                        g gVar = (g) runnable;
                        bVar = gVar.f3386b;
                        if (bVar.f3368b == gVar) {
                            if (g.b(bVar, gVar, h(gVar.f3387c))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        f(runnable, eVar2.f3379b);
                    }
                    eVar2 = eVar3;
                }
                return;
            }
        }
    }

    public static void f(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object h(u<?> uVar) {
        Throwable t2;
        if (uVar instanceof i) {
            Object obj = ((b) uVar).f3368b;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f3373a ? cVar.f3374b != null ? new c(false, cVar.f3374b) : c.f3372d : obj;
        } else if ((uVar instanceof c.b.b.e.a.d0.a) && (t2 = c.b.a.a.c.n.c.t2((c.b.b.e.a.d0.a) uVar)) != null) {
            return new d(t2);
        } else {
            boolean isCancelled = uVar.isCancelled();
            if ((!f3367e) && isCancelled) {
                return c.f3372d;
            }
            try {
                Object i2 = i(uVar);
                if (!isCancelled) {
                    return i2 == null ? h : i2;
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

    public static <V> V i(Future<V> future) {
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
            Object i2 = i(this);
            sb.append("SUCCESS, result=[");
            d(sb, i2);
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

    @Override // c.b.b.e.a.u
    public void b(Runnable runnable, Executor executor) {
        e eVar;
        c.b.a.a.c.n.c.t(runnable, "Runnable was null.");
        c.b.a.a.c.n.c.t(executor, "Executor was null.");
        if (isDone() || (eVar = this.f3369c) == e.f3377d) {
            f(runnable, executor);
        }
        e eVar2 = new e(runnable, executor);
        do {
            eVar2.f3380c = eVar;
            if (!g.a(this, eVar, eVar2)) {
                eVar = this.f3369c;
            } else {
                return;
            }
        } while (eVar != e.f3377d);
        f(runnable, executor);
    }

    public void c() {
    }

    public boolean cancel(boolean z) {
        Object obj = this.f3368b;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f3367e ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.f3371c : c.f3372d;
        b<V> bVar = this;
        boolean z2 = false;
        while (true) {
            if (g.b(bVar, obj, cVar)) {
                e(bVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                u<? extends V> uVar = ((g) obj).f3387c;
                if (uVar instanceof i) {
                    bVar = (b) uVar;
                    obj = bVar.f3368b;
                    if (!(obj == null) && !(obj instanceof g)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    uVar.cancel(z);
                    return true;
                }
            } else {
                obj = bVar.f3368b;
                if (!(obj instanceof g)) {
                    return z2;
                }
            }
        }
    }

    public final void d(StringBuilder sb, Object obj) {
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
    public final V g(Object obj) {
        if (obj instanceof c) {
            Throwable th = ((c) obj).f3374b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f3376a);
        } else if (obj == h) {
            return null;
        } else {
            return obj;
        }
    }

    @Override // java.util.concurrent.Future
    public V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f3368b;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return g(obj2);
            }
            l lVar = this.f3370d;
            if (lVar != l.f3393c) {
                l lVar2 = new l();
                do {
                    g.d(lVar2, lVar);
                    if (g.c(this, lVar, lVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f3368b;
                            } else {
                                l(lVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return g(obj);
                    }
                    lVar = this.f3370d;
                } while (lVar != l.f3393c);
            }
            return g(this.f3368b);
        }
        throw new InterruptedException();
    }

    public boolean isCancelled() {
        return this.f3368b instanceof c;
    }

    public boolean isDone() {
        Object obj = this.f3368b;
        return (!(obj instanceof g)) & (obj != null);
    }

    public final void j(Future<?> future) {
        if ((future != null) && (((l.a) this).f3368b instanceof c)) {
            future.cancel(p());
        }
    }

    public String k() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        StringBuilder g2 = c.a.a.a.a.g("remaining delay=[");
        g2.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
        g2.append(" ms]");
        return g2.toString();
    }

    public final void l(l lVar) {
        lVar.f3394a = null;
        while (true) {
            l lVar2 = this.f3370d;
            if (lVar2 != l.f3393c) {
                l lVar3 = null;
                while (lVar2 != null) {
                    l lVar4 = lVar2.f3395b;
                    if (lVar2.f3394a != null) {
                        lVar3 = lVar2;
                    } else if (lVar3 != null) {
                        lVar3.f3395b = lVar4;
                        if (lVar3.f3394a == null) {
                        }
                    } else if (!g.c(this, lVar2, lVar4)) {
                    }
                    lVar2 = lVar4;
                }
                return;
            }
            return;
        }
    }

    public boolean m(V v) {
        if (v == null) {
            v = (V) h;
        }
        if (!g.b(this, null, v)) {
            return false;
        }
        e(this);
        return true;
    }

    public boolean n(Throwable th) {
        if (th != null) {
            if (!g.b(this, null, new d(th))) {
                return false;
            }
            e(this);
            return true;
        }
        throw null;
    }

    public boolean o(u<? extends V> uVar) {
        g gVar;
        d dVar;
        if (uVar != null) {
            Object obj = this.f3368b;
            if (obj == null) {
                if (uVar.isDone()) {
                    if (!g.b(this, null, h(uVar))) {
                        return false;
                    }
                    e(this);
                    return true;
                }
                gVar = new g(this, uVar);
                if (g.b(this, null, gVar)) {
                    try {
                        uVar.b(gVar, k.INSTANCE);
                    } catch (Throwable unused) {
                        dVar = d.f3375b;
                    }
                    return true;
                }
                obj = this.f3368b;
            }
            if (obj instanceof c) {
                uVar.cancel(((c) obj).f3373a);
            }
            return false;
        }
        throw null;
        g.b(this, gVar, dVar);
        return true;
    }

    public final boolean p() {
        Object obj = this.f3368b;
        return (obj instanceof c) && ((c) obj).f3373a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0075  */
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.f3368b;
            if (obj instanceof g) {
                sb.append(", setFuture=[");
                d(sb, ((g) obj).f3387c);
            } else {
                try {
                    str = c.b.b.a.k.b(k());
                } catch (RuntimeException | StackOverflowError e2) {
                    StringBuilder g2 = c.a.a.a.a.g("Exception thrown from implementation: ");
                    g2.append(e2.getClass());
                    str = g2.toString();
                }
                if (str != null) {
                    sb.append(", info=[");
                    sb.append(str);
                }
                if (isDone()) {
                    sb.delete(length, sb.length());
                    a(sb);
                }
            }
            sb.append("]");
            if (isDone()) {
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.f3368b;
            boolean z = true;
            if ((obj != null) && (!(obj instanceof g))) {
                return g(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                l lVar = this.f3370d;
                if (lVar != l.f3393c) {
                    l lVar2 = new l();
                    do {
                        g.d(lVar2, lVar);
                        if (g.c(this, lVar, lVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f3368b;
                                    if ((obj2 != null) && (!(obj2 instanceof g))) {
                                        return g(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    l(lVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            l(lVar2);
                        } else {
                            lVar = this.f3370d;
                        }
                    } while (lVar != l.f3393c);
                }
                return g(this.f3368b);
            }
            while (nanos > 0) {
                Object obj3 = this.f3368b;
                if ((obj3 != null) && (!(obj3 instanceof g))) {
                    return g(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String bVar = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String o = c.a.a.a.a.o(str, " (plus ");
                long j3 = -nanos;
                long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit.toNanos(convert);
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
            throw new TimeoutException(c.a.a.a.a.p(str, " for ", bVar));
        }
        throw new InterruptedException();
    }
}
