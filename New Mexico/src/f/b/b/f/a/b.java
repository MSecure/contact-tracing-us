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
/* loaded from: classes.dex */
public abstract class b<V> extends f.b.b.f.a.e0.a implements u<V> {

    /* renamed from: e */
    public static final boolean f3429e;

    /* renamed from: f */
    public static final Logger f3430f;

    /* renamed from: g */
    public static final AbstractC0111b f3431g;

    /* renamed from: h */
    public static final Object f3432h;
    private volatile Object b;
    private volatile e c;

    /* renamed from: d */
    private volatile l f3433d;

    /* renamed from: f.b.b.f.a.b$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0111b {
        public AbstractC0111b(a aVar) {
        }

        public abstract boolean a(b<?> bVar, e eVar, e eVar2);

        public abstract boolean b(b<?> bVar, Object obj, Object obj2);

        public abstract boolean c(b<?> bVar, l lVar, l lVar2);

        public abstract void d(l lVar, l lVar2);

        public abstract void e(l lVar, Thread thread);
    }

    /* loaded from: classes.dex */
    public static final class c {
        public static final c c;

        /* renamed from: d */
        public static final c f3434d;
        public final boolean a;
        public final Throwable b;

        static {
            if (b.f3429e) {
                f3434d = null;
                c = null;
                return;
            }
            f3434d = new c(false, null);
            c = new c(true, null);
        }

        public c(boolean z, Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public static final d b = new d(new a("Failure occurred while trying to finish a future."));
        public final Throwable a;

        /* loaded from: classes.dex */
        public static class a extends Throwable {
            public a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            Objects.requireNonNull(th);
            this.a = th;
        }
    }

    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: d */
        public static final e f3435d = new e(null, null);
        public final Runnable a;
        public final Executor b;
        public e c;

        public e(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends AbstractC0111b {
        public final AtomicReferenceFieldUpdater<l, Thread> a;
        public final AtomicReferenceFieldUpdater<l, l> b;
        public final AtomicReferenceFieldUpdater<b, l> c;

        /* renamed from: d */
        public final AtomicReferenceFieldUpdater<b, e> f3436d;

        /* renamed from: e */
        public final AtomicReferenceFieldUpdater<b, Object> f3437e;

        public f(AtomicReferenceFieldUpdater<l, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<l, l> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<b, l> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<b, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<b, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.f3436d = atomicReferenceFieldUpdater4;
            this.f3437e = atomicReferenceFieldUpdater5;
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public boolean a(b<?> bVar, e eVar, e eVar2) {
            return this.f3436d.compareAndSet(bVar, eVar, eVar2);
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public boolean b(b<?> bVar, Object obj, Object obj2) {
            return this.f3437e.compareAndSet(bVar, obj, obj2);
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public boolean c(b<?> bVar, l lVar, l lVar2) {
            return this.c.compareAndSet(bVar, lVar, lVar2);
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public void d(l lVar, l lVar2) {
            this.b.lazySet(lVar, lVar2);
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public void e(l lVar, Thread thread) {
            this.a.lazySet(lVar, thread);
        }
    }

    /* loaded from: classes.dex */
    public static final class g<V> implements Runnable {
        public final b<V> b;
        public final u<? extends V> c;

        public g(b<V> bVar, u<? extends V> uVar) {
            this.b = bVar;
            this.c = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((b) this.b).b == this) {
                if (b.f3431g.b(this.b, this, b.o(this.c))) {
                    b.l(this.b);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class h extends AbstractC0111b {
        public h(a aVar) {
            super(null);
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public boolean a(b<?> bVar, e eVar, e eVar2) {
            synchronized (bVar) {
                if (((b) bVar).c != eVar) {
                    return false;
                }
                ((b) bVar).c = eVar2;
                return true;
            }
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public boolean b(b<?> bVar, Object obj, Object obj2) {
            synchronized (bVar) {
                if (((b) bVar).b != obj) {
                    return false;
                }
                ((b) bVar).b = obj2;
                return true;
            }
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public boolean c(b<?> bVar, l lVar, l lVar2) {
            synchronized (bVar) {
                if (((b) bVar).f3433d != lVar) {
                    return false;
                }
                ((b) bVar).f3433d = lVar2;
                return true;
            }
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public void d(l lVar, l lVar2) {
            lVar.b = lVar2;
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public void e(l lVar, Thread thread) {
            lVar.a = thread;
        }
    }

    /* loaded from: classes.dex */
    public interface i<V> extends u<V> {
    }

    /* loaded from: classes.dex */
    public static abstract class j<V> extends b<V> implements i<V> {
        @Override // f.b.b.f.a.b, f.b.b.f.a.u
        public final void a(Runnable runnable, Executor executor) {
            b.super.a(runnable, executor);
        }

        @Override // f.b.b.f.a.b, java.util.concurrent.Future
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

        @Override // f.b.b.f.a.b, java.util.concurrent.Future
        public final boolean isCancelled() {
            return b.super.isCancelled();
        }

        @Override // f.b.b.f.a.b, java.util.concurrent.Future
        public final boolean isDone() {
            return b.super.isDone();
        }
    }

    /* loaded from: classes.dex */
    public static final class k extends AbstractC0111b {
        public static final Unsafe a;
        public static final long b;
        public static final long c;

        /* renamed from: d */
        public static final long f3438d;

        /* renamed from: e */
        public static final long f3439e;

        /* renamed from: f */
        public static final long f3440f;

        /* loaded from: classes.dex */
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

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new a());
            }
            try {
                c = unsafe.objectFieldOffset(b.class.getDeclaredField("d"));
                b = unsafe.objectFieldOffset(b.class.getDeclaredField("c"));
                f3438d = unsafe.objectFieldOffset(b.class.getDeclaredField("b"));
                f3439e = unsafe.objectFieldOffset(l.class.getDeclaredField("a"));
                f3440f = unsafe.objectFieldOffset(l.class.getDeclaredField("b"));
                a = unsafe;
            } catch (Exception e3) {
                v.c(e3);
                throw new RuntimeException(e3);
            }
        }

        public k(a aVar) {
            super(null);
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public boolean a(b<?> bVar, e eVar, e eVar2) {
            return a.compareAndSwapObject(bVar, b, eVar, eVar2);
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public boolean b(b<?> bVar, Object obj, Object obj2) {
            return a.compareAndSwapObject(bVar, f3438d, obj, obj2);
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public boolean c(b<?> bVar, l lVar, l lVar2) {
            return a.compareAndSwapObject(bVar, c, lVar, lVar2);
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public void d(l lVar, l lVar2) {
            a.putObject(lVar, f3440f, lVar2);
        }

        @Override // f.b.b.f.a.b.AbstractC0111b
        public void e(l lVar, Thread thread) {
            a.putObject(lVar, f3439e, thread);
        }
    }

    /* loaded from: classes.dex */
    public static final class l {
        public static final l c = new l(false);
        public volatile Thread a;
        public volatile l b;

        public l() {
            b.f3431g.e(this, Thread.currentThread());
        }

        public l(boolean z) {
        }
    }

    static {
        boolean z;
        AbstractC0111b bVar;
        Throwable th;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        f3429e = z;
        f3430f = Logger.getLogger(b.class.getName());
        Throwable th2 = null;
        try {
            bVar = new k(null);
            th = null;
        } catch (Throwable th3) {
            th = th3;
            try {
                bVar = new f(AtomicReferenceFieldUpdater.newUpdater(l.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(l.class, l.class, "b"), AtomicReferenceFieldUpdater.newUpdater(b.class, l.class, "d"), AtomicReferenceFieldUpdater.newUpdater(b.class, e.class, "c"), AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "b"));
            } catch (Throwable th4) {
                th2 = th4;
                bVar = new h(null);
            }
        }
        f3431g = bVar;
        if (th2 != null) {
            Logger logger = f3430f;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", th);
            logger.log(level, "SafeAtomicHelper is broken!", th2);
        }
        f3432h = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [f.b.b.f.a.b$b] */
    /* JADX WARN: Type inference failed for: r5v0, types: [f.b.b.f.a.b<?>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [f.b.b.f.a.b] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [f.b.b.f.a.b, f.b.b.f.a.b<V>] */
    public static void l(b<?> bVar) {
        e eVar;
        e eVar2;
        e eVar3 = null;
        while (true) {
            l lVar = ((b) bVar).f3433d;
            if (f3431g.c((b) bVar, lVar, l.c)) {
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
                } while (!f3431g.a((b) bVar, eVar, e.f3435d));
                while (true) {
                    eVar2 = eVar3;
                    eVar3 = eVar;
                    if (eVar3 != null) {
                        eVar = eVar3.c;
                        eVar3.c = eVar2;
                    }
                }
                while (eVar2 != null) {
                    eVar3 = eVar2.c;
                    Runnable runnable = eVar2.a;
                    if (runnable instanceof g) {
                        g gVar = (g) runnable;
                        bVar = gVar.b;
                        if (((b) bVar).b == gVar) {
                            if (f3431g.b(bVar, gVar, o(gVar.c))) {
                                break;
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
            Logger logger = f3430f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object o(u<?> uVar) {
        Throwable b;
        if (uVar instanceof i) {
            Object obj = ((b) uVar).b;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (cVar.a) {
                return cVar.b != null ? new c(false, cVar.b) : c.f3434d;
            }
            return obj;
        } else if ((uVar instanceof f.b.b.f.a.e0.a) && (b = ((f.b.b.f.a.e0.a) uVar).b()) != null) {
            return new d(b);
        } else {
            boolean isCancelled = uVar.isCancelled();
            if ((!f3429e) && isCancelled) {
                return c.f3434d;
            }
            try {
                Object p = p(uVar);
                if (!isCancelled) {
                    return p == null ? f3432h : p;
                }
                return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + uVar));
            } catch (CancellationException e2) {
                if (isCancelled) {
                    return new c(false, e2);
                }
                return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + uVar, e2));
            } catch (ExecutionException e3) {
                if (!isCancelled) {
                    return new d(e3.getCause());
                }
                return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + uVar, e3));
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
        f.b.a.c.b.o.b.A(runnable, "Runnable was null.");
        f.b.a.c.b.o.b.A(executor, "Executor was null.");
        if (isDone() || (eVar = this.c) == e.f3435d) {
            m(runnable, executor);
        }
        e eVar2 = new e(runnable, executor);
        do {
            eVar2.c = eVar;
            if (!f3431g.a(this, eVar, eVar2)) {
                eVar = this.c;
            } else {
                return;
            }
        } while (eVar != e.f3435d);
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

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Object obj = this.b;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f3429e ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.c : c.f3434d;
        boolean z2 = false;
        b<V> bVar = this;
        while (true) {
            if (f3431g.b(bVar, obj, cVar)) {
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
        if ((r4 & (!(r0 instanceof f.b.b.f.a.b.g))) == false) goto L_0x0030;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
        return n(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
        s(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /* Code decompiled incorrectly, please refer to instructions dump */
    public V get() {
        if (!Thread.interrupted()) {
            Object obj = this.b;
            if ((obj != null) && (!(obj instanceof g))) {
                return n(obj);
            }
            l lVar = this.f3433d;
            if (lVar == l.c) {
                return n(this.b);
            }
            l lVar2 = new l();
            do {
                AbstractC0111b bVar = f3431g;
                bVar.d(lVar2, lVar);
                if (bVar.c(this, lVar, lVar2)) {
                    break;
                }
                lVar = this.f3433d;
            } while (lVar != l.c);
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
    public boolean isCancelled() {
        return this.b instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.b;
        return (!(obj instanceof g)) & (obj != null);
    }

    public void j() {
    }

    public final void k(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e2) {
            while (true) {
                sb.append("Exception thrown from implementation: ");
                sb.append(e2.getClass());
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V n(Object obj) {
        if (obj instanceof c) {
            Throwable th = ((c) obj).b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).a);
        } else if (obj == f3432h) {
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
        StringBuilder h2 = f.a.a.a.a.h("remaining delay=[");
        h2.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
        h2.append(" ms]");
        return h2.toString();
    }

    public final void s(l lVar) {
        lVar.a = null;
        while (true) {
            l lVar2 = this.f3433d;
            if (lVar2 != l.c) {
                l lVar3 = null;
                while (lVar2 != null) {
                    l lVar4 = lVar2.b;
                    if (lVar2.a != null) {
                        lVar3 = lVar2;
                    } else if (lVar3 != null) {
                        lVar3.b = lVar4;
                        if (lVar3.a == null) {
                            break;
                        }
                    } else if (!f3431g.c(this, lVar2, lVar4)) {
                        break;
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
            v = (V) f3432h;
        }
        if (!f3431g.b(this, null, v)) {
            return false;
        }
        l(this);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083  */
    @Override // java.lang.Object
    /* Code decompiled incorrectly, please refer to instructions dump */
    public String toString() {
        String str;
        boolean z;
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
                } catch (RuntimeException | StackOverflowError e2) {
                    StringBuilder h2 = f.a.a.a.a.h("Exception thrown from implementation: ");
                    h2.append(e2.getClass());
                    str = h2.toString();
                }
                if (str != null) {
                    if (!str.isEmpty()) {
                        z = false;
                        if (z) {
                            str = null;
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
                }
                z = true;
                if (z) {
                }
                if (str != null) {
                }
                if (isDone()) {
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
        if (!f3431g.b(this, null, new d(th))) {
            return false;
        }
        l(this);
        return true;
    }

    public boolean v(u<? extends V> uVar) {
        d dVar;
        Objects.requireNonNull(uVar);
        Object obj = this.b;
        if (obj == null) {
            if (uVar.isDone()) {
                if (!f3431g.b(this, null, o(uVar))) {
                    return false;
                }
                l(this);
                return true;
            }
            g gVar = new g(this, uVar);
            if (f3431g.b(this, null, gVar)) {
                try {
                    uVar.a(gVar, k.INSTANCE);
                } catch (Throwable th) {
                    try {
                        dVar = new d(th);
                    } catch (Throwable unused) {
                        dVar = d.b;
                    }
                    f3431g.b(this, gVar, dVar);
                }
                return true;
            }
            obj = this.b;
        }
        if (obj instanceof c) {
            uVar.cancel(((c) obj).a);
        }
        return false;
    }

    public final boolean w() {
        Object obj = this.b;
        return (obj instanceof c) && ((c) obj).a;
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
        if ((r1 & (!(r0 instanceof f.b.b.f.a.b.g))) == false) goto L_0x0062;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
        return n(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0062, code lost:
        r0 = r4 - java.lang.System.nanoTime();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006a, code lost:
        if (r0 >= 1000) goto L_0x0046;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
        s(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
        s(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0078, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /* Code decompiled incorrectly, please refer to instructions dump */
    public V get(long j2, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.b;
            if ((obj != null) && (!(obj instanceof g))) {
                return n(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                l lVar = this.f3433d;
                if (lVar == l.c) {
                    return n(this.b);
                }
                l lVar2 = new l();
                do {
                    AbstractC0111b bVar = f3431g;
                    bVar.d(lVar2, lVar);
                    if (bVar.c(this, lVar, lVar2)) {
                        break;
                    }
                    lVar = this.f3433d;
                } while (lVar != l.c);
                return n(this.b);
            }
            while (nanos > 0) {
                Object obj2 = this.b;
                if ((obj2 != null) && (!(obj2 instanceof g))) {
                    return n(obj2);
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
            throw new TimeoutException(f.a.a.a.a.c(str, " for ", bVar2));
        }
        throw new InterruptedException();
    }
}
