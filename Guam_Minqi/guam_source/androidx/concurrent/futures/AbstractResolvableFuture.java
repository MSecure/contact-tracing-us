package androidx.concurrent.futures;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.ListenableFuture;
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

public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {
    public static final AtomicHelper ATOMIC_HELPER;
    public static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Object NULL = new Object();
    public static final Logger log = Logger.getLogger(AbstractResolvableFuture.class.getName());
    public volatile Listener listeners;
    public volatile Object value;
    public volatile Waiter waiters;

    public static abstract class AtomicHelper {
        public AtomicHelper(AnonymousClass1 r1) {
        }

        public abstract boolean casListeners(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2);

        public abstract boolean casValue(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        public abstract boolean casWaiters(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2);

        public abstract void putNext(Waiter waiter, Waiter waiter2);

        public abstract void putThread(Waiter waiter, Thread thread);
    }

    public static final class Cancellation {
        public static final Cancellation CAUSELESS_CANCELLED;
        public static final Cancellation CAUSELESS_INTERRUPTED;
        public final Throwable cause;
        public final boolean wasInterrupted;

        static {
            if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
                CAUSELESS_CANCELLED = null;
                CAUSELESS_INTERRUPTED = null;
                return;
            }
            CAUSELESS_CANCELLED = new Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new Cancellation(true, null);
        }

        public Cancellation(boolean z, Throwable th) {
            this.wasInterrupted = z;
            this.cause = th;
        }
    }

    public static final class Failure {
        public final Throwable exception;

        static {
            AbstractResolvableFuture.checkNotNull(new Throwable("Failure occurred while trying to finish a future.") {
                /* class androidx.concurrent.futures.AbstractResolvableFuture.Failure.AnonymousClass1 */

                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            });
        }

        public Failure(Throwable th) {
            AbstractResolvableFuture.checkNotNull(th);
            this.exception = th;
        }
    }

    public static final class Listener {
        public static final Listener TOMBSTONE = new Listener(null, null);
        public final Executor executor;
        public Listener next;
        public final Runnable task;

        public Listener(Runnable runnable, Executor executor2) {
            this.task = runnable;
            this.executor = executor2;
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> listenersUpdater;
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> valueUpdater;
        public final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        public final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> waitersUpdater;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casListeners(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            return this.listenersUpdater.compareAndSet(abstractResolvableFuture, listener, listener2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casValue(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            return this.valueUpdater.compareAndSet(abstractResolvableFuture, obj, obj2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casWaiters(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            return this.waitersUpdater.compareAndSet(abstractResolvableFuture, waiter, waiter2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putNext(Waiter waiter, Waiter waiter2) {
            this.waiterNextUpdater.lazySet(waiter, waiter2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putThread(Waiter waiter, Thread thread) {
            this.waiterThreadUpdater.lazySet(waiter, thread);
        }
    }

    public static final class SetFuture<V> implements Runnable {
        public final ListenableFuture<? extends V> future;
        public final AbstractResolvableFuture<V> owner;

        public void run() {
            throw null;
        }
    }

    public static final class SynchronizedHelper extends AtomicHelper {
        public SynchronizedHelper() {
            super(null);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casListeners(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.listeners != listener) {
                    return false;
                }
                abstractResolvableFuture.listeners = listener2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casValue(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.value != obj) {
                    return false;
                }
                abstractResolvableFuture.value = obj2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casWaiters(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.waiters != waiter) {
                    return false;
                }
                abstractResolvableFuture.waiters = waiter2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putNext(Waiter waiter, Waiter waiter2) {
            waiter.next = waiter2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putThread(Waiter waiter, Thread thread) {
            waiter.thread = thread;
        }
    }

    public static final class Waiter {
        public static final Waiter TOMBSTONE = new Waiter(false);
        public volatile Waiter next;
        public volatile Thread thread;

        public Waiter(boolean z) {
        }

        public Waiter() {
            AbstractResolvableFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }
    }

    static {
        AtomicHelper atomicHelper;
        Throwable th;
        try {
            atomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "value"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            atomicHelper = new SynchronizedHelper();
        }
        ATOMIC_HELPER = atomicHelper;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.concurrent.futures.AbstractResolvableFuture, androidx.concurrent.futures.AbstractResolvableFuture<V>] */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static void complete(AbstractResolvableFuture<?> abstractResolvableFuture) {
        Listener listener;
        Listener listener2 = null;
        while (true) {
            Waiter waiter = abstractResolvableFuture.waiters;
            if (ATOMIC_HELPER.casWaiters(abstractResolvableFuture, waiter, Waiter.TOMBSTONE)) {
                while (waiter != null) {
                    Thread thread = waiter.thread;
                    if (thread != null) {
                        waiter.thread = null;
                        LockSupport.unpark(thread);
                    }
                    waiter = waiter.next;
                }
                do {
                    listener = abstractResolvableFuture.listeners;
                } while (!ATOMIC_HELPER.casListeners(abstractResolvableFuture, listener, Listener.TOMBSTONE));
                while (listener != null) {
                    Listener listener3 = listener.next;
                    listener.next = listener2;
                    listener2 = listener;
                    listener = listener3;
                }
                while (listener2 != null) {
                    Listener listener4 = listener2.next;
                    Runnable runnable = listener2.task;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        AbstractResolvableFuture<V> abstractResolvableFuture2 = setFuture.owner;
                        if (abstractResolvableFuture2.value == setFuture) {
                            if (ATOMIC_HELPER.casValue(abstractResolvableFuture2, setFuture, getFutureValue(setFuture.future))) {
                                listener2 = listener4;
                                abstractResolvableFuture = abstractResolvableFuture2;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        executeListener(runnable, listener2.executor);
                    }
                    listener2 = listener4;
                }
                return;
            }
        }
    }

    public static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    public static Object getFutureValue(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) listenableFuture).value;
            if (!(obj instanceof Cancellation)) {
                return obj;
            }
            Cancellation cancellation = (Cancellation) obj;
            if (!cancellation.wasInterrupted) {
                return obj;
            }
            if (cancellation.cause != null) {
                return new Cancellation(false, cancellation.cause);
            }
            return Cancellation.CAUSELESS_CANCELLED;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
            return Cancellation.CAUSELESS_CANCELLED;
        }
        try {
            Object uninterruptibly = getUninterruptibly(listenableFuture);
            return uninterruptibly == null ? NULL : uninterruptibly;
        } catch (ExecutionException e) {
            return new Failure(e.getCause());
        } catch (CancellationException e2) {
            if (isCancelled) {
                return new Cancellation(false, e2);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e2));
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
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

    public final void addDoneString(StringBuilder sb) {
        String str;
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            if (uninterruptibly == this) {
                str = "this future";
            } else {
                str = String.valueOf(uninterruptibly);
            }
            sb.append(str);
            sb.append("]");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        if (runnable == null) {
            throw null;
        } else if (executor != null) {
            Listener listener = this.listeners;
            if (listener != Listener.TOMBSTONE) {
                Listener listener2 = new Listener(runnable, executor);
                do {
                    listener2.next = listener;
                    if (!ATOMIC_HELPER.casListeners(this, listener, listener2)) {
                        listener = this.listeners;
                    } else {
                        return;
                    }
                } while (listener != Listener.TOMBSTONE);
            }
            executeListener(runnable, executor);
        } else {
            throw null;
        }
    }

    public final boolean cancel(boolean z) {
        Cancellation cancellation;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            cancellation = new Cancellation(z, new CancellationException("Future.cancel() was called."));
        } else if (z) {
            cancellation = Cancellation.CAUSELESS_INTERRUPTED;
        } else {
            cancellation = Cancellation.CAUSELESS_CANCELLED;
        }
        AbstractResolvableFuture<V> abstractResolvableFuture = this;
        boolean z2 = false;
        while (true) {
            if (ATOMIC_HELPER.casValue(abstractResolvableFuture, obj, cancellation)) {
                complete(abstractResolvableFuture);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).future;
                if (listenableFuture instanceof AbstractResolvableFuture) {
                    abstractResolvableFuture = (AbstractResolvableFuture) listenableFuture;
                    obj = abstractResolvableFuture.value;
                    if (!(obj == null) && !(obj instanceof SetFuture)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    listenableFuture.cancel(z);
                    return true;
                }
            } else {
                obj = abstractResolvableFuture.value;
                if (!(obj instanceof SetFuture)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z = true;
            if ((obj != null) && (!(obj instanceof SetFuture))) {
                return getDoneValue(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                Waiter waiter = this.waiters;
                if (waiter != Waiter.TOMBSTONE) {
                    Waiter waiter2 = new Waiter();
                    do {
                        ATOMIC_HELPER.putNext(waiter2, waiter);
                        if (ATOMIC_HELPER.casWaiters(this, waiter, waiter2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                        return getDoneValue(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    removeWaiter(waiter2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            removeWaiter(waiter2);
                        } else {
                            waiter = this.waiters;
                        }
                    } while (waiter != Waiter.TOMBSTONE);
                }
                return getDoneValue(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                    return getDoneValue(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractResolvableFuture = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String outline8 = GeneratedOutlineSupport.outline8(str, " (plus ");
                long j2 = -nanos;
                long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(convert);
                int i = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                if (i != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (i > 0) {
                    String str2 = outline8 + convert + " " + lowerCase;
                    if (z) {
                        str2 = GeneratedOutlineSupport.outline8(str2, ",");
                    }
                    outline8 = GeneratedOutlineSupport.outline8(str2, " ");
                }
                if (z) {
                    outline8 = outline8 + nanos2 + " nanoseconds ";
                }
                str = GeneratedOutlineSupport.outline8(outline8, "delay)");
            }
            if (isDone()) {
                throw new TimeoutException(GeneratedOutlineSupport.outline8(str, " but future completed as timeout expired"));
            }
            throw new TimeoutException(GeneratedOutlineSupport.outline9(str, " for ", abstractResolvableFuture));
        }
        throw new InterruptedException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public final V getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            Throwable th = ((Cancellation) obj).cause;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).exception);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    public final boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    public final boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof SetFuture)) & (obj != null);
    }

    public String pendingToString() {
        String str;
        Object obj = this.value;
        if (obj instanceof SetFuture) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("setFuture=[");
            ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).future;
            if (listenableFuture == this) {
                str = "this future";
            } else {
                str = String.valueOf(listenableFuture);
            }
            return GeneratedOutlineSupport.outline12(outline15, str, "]");
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            StringBuilder outline152 = GeneratedOutlineSupport.outline15("remaining delay=[");
            outline152.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
            outline152.append(" ms]");
            return outline152.toString();
        }
    }

    public final void removeWaiter(Waiter waiter) {
        waiter.thread = null;
        while (true) {
            Waiter waiter2 = this.waiters;
            if (waiter2 != Waiter.TOMBSTONE) {
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.next;
                    if (waiter2.thread != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.next = waiter4;
                        if (waiter3.thread == null) {
                        }
                    } else if (!ATOMIC_HELPER.casWaiters(this, waiter2, waiter4)) {
                    }
                    waiter2 = waiter4;
                }
                return;
            }
            return;
        }
    }

    public boolean set(V v) {
        if (v == null) {
            v = (V) NULL;
        }
        if (!ATOMIC_HELPER.casValue(this, null, v)) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setException(Throwable th) {
        if (th != null) {
            if (!ATOMIC_HELPER.casValue(this, null, new Failure(th))) {
                return false;
            }
            complete(this);
            return true;
        }
        throw null;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.value instanceof Cancellation) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Exception thrown from implementation: ");
                outline15.append(e.getClass());
                str = outline15.toString();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                addDoneString(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                return getDoneValue(obj2);
            }
            Waiter waiter = this.waiters;
            if (waiter != Waiter.TOMBSTONE) {
                Waiter waiter2 = new Waiter();
                do {
                    ATOMIC_HELPER.putNext(waiter2, waiter);
                    if (ATOMIC_HELPER.casWaiters(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return getDoneValue(obj);
                    }
                    waiter = this.waiters;
                } while (waiter != Waiter.TOMBSTONE);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
