package c.b.b.e.a;

import b.x.t;
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
    public static final boolean f4713e;

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f4714f = Logger.getLogger(b.class.getName());

    /* renamed from: g  reason: collision with root package name */
    public static final AbstractC0090b f4715g;
    public static final Object h = new Object();

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f4716b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f4717c;

    /* renamed from: d  reason: collision with root package name */
    public volatile l f4718d;

    /* renamed from: c.b.b.e.a.b$b  reason: collision with other inner class name */
    public static abstract class AbstractC0090b {
        public AbstractC0090b(a aVar) {
        }

        public abstract boolean a(b<?> bVar, e eVar, e eVar2);

        public abstract boolean b(b<?> bVar, Object obj, Object obj2);

        public abstract boolean c(b<?> bVar, l lVar, l lVar2);

        public abstract void d(l lVar, l lVar2);

        public abstract void e(l lVar, Thread thread);
    }

    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        public static final c f4719c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f4720d;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f4721a;

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f4722b;

        static {
            if (b.f4713e) {
                f4720d = null;
                f4719c = null;
                return;
            }
            f4720d = new c(false, null);
            f4719c = new c(true, null);
        }

        public c(boolean z, Throwable th) {
            this.f4721a = z;
            this.f4722b = th;
        }
    }

    public static final class d {

        /* renamed from: b  reason: collision with root package name */
        public static final d f4723b = new d(new a("Failure occurred while trying to finish a future."));

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f4724a;

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
                this.f4724a = th;
                return;
            }
            throw null;
        }
    }

    public static final class e {

        /* renamed from: d  reason: collision with root package name */
        public static final e f4725d = new e(null, null);

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f4726a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f4727b;

        /* renamed from: c  reason: collision with root package name */
        public e f4728c;

        public e(Runnable runnable, Executor executor) {
            this.f4726a = runnable;
            this.f4727b = executor;
        }
    }

    public static final class f extends AbstractC0090b {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<l, Thread> f4729a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<l, l> f4730b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<b, l> f4731c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<b, e> f4732d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<b, Object> f4733e;

        public f(AtomicReferenceFieldUpdater<l, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<l, l> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<b, l> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<b, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<b, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.f4729a = atomicReferenceFieldUpdater;
            this.f4730b = atomicReferenceFieldUpdater2;
            this.f4731c = atomicReferenceFieldUpdater3;
            this.f4732d = atomicReferenceFieldUpdater4;
            this.f4733e = atomicReferenceFieldUpdater5;
        }

        @Override // c.b.b.e.a.b.AbstractC0090b
        public boolean a(b<?> bVar, e eVar, e eVar2) {
            return this.f4732d.compareAndSet(bVar, eVar, eVar2);
        }

        @Override // c.b.b.e.a.b.AbstractC0090b
        public boolean b(b<?> bVar, Object obj, Object obj2) {
            return this.f4733e.compareAndSet(bVar, obj, obj2);
        }

        @Override // c.b.b.e.a.b.AbstractC0090b
        public boolean c(b<?> bVar, l lVar, l lVar2) {
            return this.f4731c.compareAndSet(bVar, lVar, lVar2);
        }

        @Override // c.b.b.e.a.b.AbstractC0090b
        public void d(l lVar, l lVar2) {
            this.f4730b.lazySet(lVar, lVar2);
        }

        @Override // c.b.b.e.a.b.AbstractC0090b
        public void e(l lVar, Thread thread) {
            this.f4729a.lazySet(lVar, thread);
        }
    }

    public static final class g<V> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final b<V> f4734b;

        /* renamed from: c  reason: collision with root package name */
        public final u<? extends V> f4735c;

        public g(b<V> bVar, u<? extends V> uVar) {
            this.f4734b = bVar;
            this.f4735c = uVar;
        }

        public void run() {
            if (this.f4734b.f4716b == this) {
                if (b.f4715g.b(this.f4734b, this, b.h(this.f4735c))) {
                    b.e(this.f4734b);
                }
            }
        }
    }

    public static final class h extends AbstractC0090b {
        public h(a aVar) {
            super(null);
        }

        @Override // c.b.b.e.a.b.AbstractC0090b
        public boolean a(b<?> bVar, e eVar, e eVar2) {
            synchronized (bVar) {
                if (bVar.f4717c != eVar) {
                    return false;
                }
                bVar.f4717c = eVar2;
                return true;
            }
        }

        @Override // c.b.b.e.a.b.AbstractC0090b
        public boolean b(b<?> bVar, Object obj, Object obj2) {
            synchronized (bVar) {
                if (bVar.f4716b != obj) {
                    return false;
                }
                bVar.f4716b = obj2;
                return true;
            }
        }

        @Override // c.b.b.e.a.b.AbstractC0090b
        public boolean c(b<?> bVar, l lVar, l lVar2) {
            synchronized (bVar) {
                if (bVar.f4718d != lVar) {
                    return false;
                }
                bVar.f4718d = lVar2;
                return true;
            }
        }

        @Override // c.b.b.e.a.b.AbstractC0090b
        public void d(l lVar, l lVar2) {
            lVar.f4744b = lVar2;
        }

        @Override // c.b.b.e.a.b.AbstractC0090b
        public void e(l lVar, Thread thread) {
            lVar.f4743a = thread;
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
            return this.f4716b instanceof c;
        }

        @Override // c.b.b.e.a.b
        public final boolean isDone() {
            return b.super.isDone();
        }
    }

    public static final class k extends AbstractC0090b {

        /* renamed from: a  reason: collision with root package name */
        public static final Unsafe f4736a;

        /* renamed from: b  reason: collision with root package name */
        public static final long f4737b;

        /* renamed from: c  reason: collision with root package name */
        public static final long f4738c;

        /* renamed from: d  reason: collision with root package name */
        public static final long f4739d;

        /* renamed from: e  reason: collision with root package name */
        public static final long f4740e;

        /* renamed from: f  reason: collision with root package name */
        public static final long f4741f;

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
                    f4738c = unsafe.objectFieldOffset(b.class.getDeclaredField("d"));
                    f4737b = unsafe.objectFieldOffset(b.class.getDeclaredField("c"));
                    f4739d = unsafe.objectFieldOffset(b.class.getDeclaredField("b"));
                    f4740e = unsafe.objectFieldOffset(l.class.getDeclaredField("a"));
                    f4741f = unsafe.objectFieldOffset(l.class.getDeclaredField("b"));
                    f4736a = unsafe;
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

        @Override // c.b.b.e.a.b.AbstractC0090b
        public boolean a(b<?> bVar, e eVar, e eVar2) {
            return f4736a.compareAndSwapObject(bVar, f4737b, eVar, eVar2);
        }

        @Override // c.b.b.e.a.b.AbstractC0090b
        public boolean b(b<?> bVar, Object obj, Object obj2) {
            return f4736a.compareAndSwapObject(bVar, f4739d, obj, obj2);
        }

        @Override // c.b.b.e.a.b.AbstractC0090b
        public boolean c(b<?> bVar, l lVar, l lVar2) {
            return f4736a.compareAndSwapObject(bVar, f4738c, lVar, lVar2);
        }

        @Override // c.b.b.e.a.b.AbstractC0090b
        public void d(l lVar, l lVar2) {
            f4736a.putObject(lVar, f4741f, lVar2);
        }

        @Override // c.b.b.e.a.b.AbstractC0090b
        public void e(l lVar, Thread thread) {
            f4736a.putObject(lVar, f4740e, thread);
        }
    }

    public static final class l {

        /* renamed from: c  reason: collision with root package name */
        public static final l f4742c = new l(false);

        /* renamed from: a  reason: collision with root package name */
        public volatile Thread f4743a;

        /* renamed from: b  reason: collision with root package name */
        public volatile l f4744b;

        public l() {
            b.f4715g.e(this, Thread.currentThread());
        }

        public l(boolean z) {
        }
    }

    static {
        boolean z;
        AbstractC0090b bVar;
        Throwable th;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        f4713e = z;
        Throwable th2 = null;
        try {
            bVar = new k(null);
            th = null;
        } catch (Throwable th3) {
            bVar = new h(null);
            th2 = th3;
        }
        f4715g = bVar;
        if (th2 != null) {
            f4714f.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", th);
            f4714f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th2);
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
            l lVar = ((b) bVar).f4718d;
            if (f4715g.c((b) bVar, lVar, l.f4742c)) {
                while (lVar != null) {
                    Thread thread = lVar.f4743a;
                    if (thread != null) {
                        lVar.f4743a = null;
                        LockSupport.unpark(thread);
                    }
                    lVar = lVar.f4744b;
                }
                ((b) bVar).c();
                do {
                    eVar = ((b) bVar).f4717c;
                } while (!f4715g.a((b) bVar, eVar, e.f4725d));
                while (true) {
                    eVar2 = eVar3;
                    eVar3 = eVar;
                    if (eVar3 == null) {
                        break;
                    }
                    eVar = eVar3.f4728c;
                    eVar3.f4728c = eVar2;
                }
                while (eVar2 != null) {
                    eVar3 = eVar2.f4728c;
                    Runnable runnable = eVar2.f4726a;
                    if (runnable instanceof g) {
                        g gVar = (g) runnable;
                        bVar = gVar.f4734b;
                        if (bVar.f4716b == gVar) {
                            if (f4715g.b(bVar, gVar, h(gVar.f4735c))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        f(runnable, eVar2.f4727b);
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
            Logger logger = f4714f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object h(u<?> uVar) {
        Throwable b3;
        if (uVar instanceof i) {
            Object obj = ((b) uVar).f4716b;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f4721a ? cVar.f4722b != null ? new c(false, cVar.f4722b) : c.f4720d : obj;
        } else if ((uVar instanceof c.b.b.e.a.d0.a) && (b3 = t.b3((c.b.b.e.a.d0.a) uVar)) != null) {
            return new d(b3);
        } else {
            boolean isCancelled = uVar.isCancelled();
            if ((!f4713e) && isCancelled) {
                return c.f4720d;
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
        t.F(runnable, "Runnable was null.");
        t.F(executor, "Executor was null.");
        if (isDone() || (eVar = this.f4717c) == e.f4725d) {
            f(runnable, executor);
        }
        e eVar2 = new e(runnable, executor);
        do {
            eVar2.f4728c = eVar;
            if (!f4715g.a(this, eVar, eVar2)) {
                eVar = this.f4717c;
            } else {
                return;
            }
        } while (eVar != e.f4725d);
        f(runnable, executor);
    }

    public void c() {
    }

    public boolean cancel(boolean z) {
        Object obj = this.f4716b;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f4713e ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.f4719c : c.f4720d;
        b<V> bVar = this;
        boolean z2 = false;
        while (true) {
            if (f4715g.b(bVar, obj, cVar)) {
                e(bVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                u<? extends V> uVar = ((g) obj).f4735c;
                if (uVar instanceof i) {
                    bVar = (b) uVar;
                    obj = bVar.f4716b;
                    if (!(obj == null) && !(obj instanceof g)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    uVar.cancel(z);
                    return true;
                }
            } else {
                obj = bVar.f4716b;
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
            Throwable th = ((c) obj).f4722b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f4724a);
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
            Object obj2 = this.f4716b;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return g(obj2);
            }
            l lVar = this.f4718d;
            if (lVar != l.f4742c) {
                l lVar2 = new l();
                do {
                    f4715g.d(lVar2, lVar);
                    if (f4715g.c(this, lVar, lVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f4716b;
                            } else {
                                l(lVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return g(obj);
                    }
                    lVar = this.f4718d;
                } while (lVar != l.f4742c);
            }
            return g(this.f4716b);
        }
        throw new InterruptedException();
    }

    public boolean isCancelled() {
        return this.f4716b instanceof c;
    }

    public boolean isDone() {
        Object obj = this.f4716b;
        return (!(obj instanceof g)) & (obj != null);
    }

    public final void j(Future<?> future) {
        if ((future != null) && (((l.a) this).f4716b instanceof c)) {
            future.cancel(p());
        }
    }

    public String k() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        StringBuilder h2 = c.a.a.a.a.h("remaining delay=[");
        h2.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
        h2.append(" ms]");
        return h2.toString();
    }

    public final void l(l lVar) {
        lVar.f4743a = null;
        while (true) {
            l lVar2 = this.f4718d;
            if (lVar2 != l.f4742c) {
                l lVar3 = null;
                while (lVar2 != null) {
                    l lVar4 = lVar2.f4744b;
                    if (lVar2.f4743a != null) {
                        lVar3 = lVar2;
                    } else if (lVar3 != null) {
                        lVar3.f4744b = lVar4;
                        if (lVar3.f4743a == null) {
                        }
                    } else if (!f4715g.c(this, lVar2, lVar4)) {
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
        if (!f4715g.b(this, null, v)) {
            return false;
        }
        e(this);
        return true;
    }

    public boolean n(Throwable th) {
        if (th != null) {
            if (!f4715g.b(this, null, new d(th))) {
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
            Object obj = this.f4716b;
            if (obj == null) {
                if (uVar.isDone()) {
                    if (!f4715g.b(this, null, h(uVar))) {
                        return false;
                    }
                    e(this);
                    return true;
                }
                gVar = new g(this, uVar);
                if (f4715g.b(this, null, gVar)) {
                    try {
                        uVar.b(gVar, k.INSTANCE);
                    } catch (Throwable unused) {
                        dVar = d.f4723b;
                    }
                    return true;
                }
                obj = this.f4716b;
            }
            if (obj instanceof c) {
                uVar.cancel(((c) obj).f4721a);
            }
            return false;
        }
        throw null;
        f4715g.b(this, gVar, dVar);
        return true;
    }

    public final boolean p() {
        Object obj = this.f4716b;
        return (obj instanceof c) && ((c) obj).f4721a;
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
            Object obj = this.f4716b;
            if (obj instanceof g) {
                sb.append(", setFuture=[");
                d(sb, ((g) obj).f4735c);
            } else {
                try {
                    str = c.b.b.a.k.b(k());
                } catch (RuntimeException | StackOverflowError e2) {
                    StringBuilder h2 = c.a.a.a.a.h("Exception thrown from implementation: ");
                    h2.append(e2.getClass());
                    str = h2.toString();
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
            Object obj = this.f4716b;
            boolean z = true;
            if ((obj != null) && (!(obj instanceof g))) {
                return g(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                l lVar = this.f4718d;
                if (lVar != l.f4742c) {
                    l lVar2 = new l();
                    do {
                        f4715g.d(lVar2, lVar);
                        if (f4715g.c(this, lVar, lVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f4716b;
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
                            lVar = this.f4718d;
                        }
                    } while (lVar != l.f4742c);
                }
                return g(this.f4716b);
            }
            while (nanos > 0) {
                Object obj3 = this.f4716b;
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
                String q = c.a.a.a.a.q(str, " (plus ");
                long j3 = -nanos;
                long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit.toNanos(convert);
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
            throw new TimeoutException(c.a.a.a.a.c(str, " for ", bVar));
        }
        throw new InterruptedException();
    }
}
