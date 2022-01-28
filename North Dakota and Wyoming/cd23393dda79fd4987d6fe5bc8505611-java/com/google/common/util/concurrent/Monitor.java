package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Monitor {
    private Guard activeGuards;
    private final boolean fair;
    private final ReentrantLock lock;

    public static abstract class Guard {
        final Condition condition;
        final Monitor monitor;
        @NullableDecl
        Guard next;
        int waiterCount = 0;

        public abstract boolean isSatisfied();

        protected Guard(Monitor monitor2) {
            this.monitor = (Monitor) Preconditions.checkNotNull(monitor2, "monitor");
            this.condition = monitor2.lock.newCondition();
        }
    }

    public Monitor() {
        this(false);
    }

    public Monitor(boolean z) {
        this.activeGuards = null;
        this.fair = z;
        this.lock = new ReentrantLock(z);
    }

    public void enter() {
        this.lock.lock();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:9:0x001b */
    /* JADX DEBUG: Multi-variable search result rejected for r8v4, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r8v9, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r8v10, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:9|10|14|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0037  */
    public boolean enter(long j, TimeUnit timeUnit) {
        long safeNanos = toSafeNanos(j, timeUnit);
        ReentrantLock reentrantLock = this.lock;
        boolean z = true;
        if (!this.fair && reentrantLock.tryLock()) {
            return true;
        }
        boolean interrupted = Thread.interrupted();
        try {
            long nanoTime = System.nanoTime();
            long j2 = safeNanos;
            boolean z2 = safeNanos;
            while (true) {
                z2 = reentrantLock.tryLock(j2, TimeUnit.NANOSECONDS);
                j2 = remainingNanos(nanoTime, z2 == true ? 1 : 0);
                interrupted = true;
                z2 = z2;
            }
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
            return z2;
        } catch (Throwable th) {
            Throwable th2 = th;
            z = interrupted;
            if (z) {
            }
            throw th2;
        }
    }

    public void enterInterruptibly() throws InterruptedException {
        this.lock.lockInterruptibly();
    }

    public boolean enterInterruptibly(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.lock.tryLock(j, timeUnit);
    }

    public boolean tryEnter() {
        return this.lock.tryLock();
    }

    public void enterWhen(Guard guard) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lockInterruptibly();
            try {
                if (!guard.isSatisfied()) {
                    await(guard, isHeldByCurrentThread);
                }
            } catch (Throwable th) {
                leave();
                throw th;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (awaitNanos(r11, r0, r3) != false) goto L_0x0049;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[Catch:{ all -> 0x0050, all -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[DONT_GENERATE] */
    public boolean enterWhen(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        long j2;
        long safeNanos = toSafeNanos(j, timeUnit);
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            boolean z = false;
            if (!this.fair) {
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                } else if (reentrantLock.tryLock()) {
                    j2 = 0;
                    if (!guard.isSatisfied()) {
                        if (j2 != 0) {
                            safeNanos = remainingNanos(j2, safeNanos);
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                    return z;
                }
            }
            j2 = initNanoTime(safeNanos);
            if (!reentrantLock.tryLock(j, timeUnit)) {
                return false;
            }
            try {
                if (!guard.isSatisfied()) {
                }
                z = true;
                if (!z) {
                }
                return z;
            } catch (Throwable th) {
                if (!isHeldByCurrentThread) {
                    signalNextWaiter();
                }
                throw th;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public void enterWhenUninterruptibly(Guard guard) {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lock();
            try {
                if (!guard.isSatisfied()) {
                    awaitUninterruptibly(guard, isHeldByCurrentThread);
                }
            } catch (Throwable th) {
                leave();
                throw th;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:12|13|37|38|39) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0070, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0071, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0076, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x006a */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[Catch:{ InterruptedException -> 0x005d, all -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0076  */
    public boolean enterWhenUninterruptibly(Guard guard, long j, TimeUnit timeUnit) {
        long j2;
        long j3;
        long safeNanos = toSafeNanos(j, timeUnit);
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            boolean interrupted = Thread.interrupted();
            boolean z = true;
            try {
                if (!this.fair) {
                    if (reentrantLock.tryLock()) {
                        j2 = 0;
                        while (true) {
                            try {
                                break;
                            } catch (InterruptedException unused) {
                                interrupted = true;
                                isHeldByCurrentThread = false;
                            } catch (Throwable th) {
                                reentrantLock.unlock();
                                throw th;
                            }
                        }
                        if (guard.isSatisfied()) {
                            if (j2 == 0) {
                                initNanoTime(safeNanos);
                                j3 = safeNanos;
                            } else {
                                j3 = remainingNanos(j2, safeNanos);
                            }
                            z = awaitNanos(guard, j3, isHeldByCurrentThread);
                        }
                        if (!z) {
                            reentrantLock.unlock();
                        }
                        if (interrupted) {
                            Thread.currentThread().interrupt();
                        }
                        return z;
                    }
                }
                j2 = initNanoTime(safeNanos);
                long j4 = safeNanos;
                while (true) {
                    j4 = remainingNanos(j2, safeNanos);
                    interrupted = true;
                }
                if (!reentrantLock.tryLock(j4, TimeUnit.NANOSECONDS)) {
                    if (interrupted) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                }
                while (true) {
                    break;
                    break;
                }
                if (guard.isSatisfied()) {
                }
                if (!z) {
                }
                if (interrupted) {
                }
                return z;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                if (interrupted) {
                }
                throw th3;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean enterIf(Guard guard) {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean enterIf(Guard guard, long j, TimeUnit timeUnit) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        } else if (!enter(j, timeUnit)) {
            return false;
        } else {
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                this.lock.unlock();
            }
        }
    }

    public boolean enterIfInterruptibly(Guard guard) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean enterIfInterruptibly(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            if (!reentrantLock.tryLock(j, timeUnit)) {
                return false;
            }
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean tryEnterIf(Guard guard) {
        if (guard.monitor == this) {
            ReentrantLock reentrantLock = this.lock;
            if (!reentrantLock.tryLock()) {
                return false;
            }
            try {
                boolean isSatisfied = guard.isSatisfied();
                if (!isSatisfied) {
                }
                return isSatisfied;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public void waitFor(Guard guard) throws InterruptedException {
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (!guard.isSatisfied()) {
            await(guard, true);
        }
    }

    public boolean waitFor(Guard guard, long j, TimeUnit timeUnit) throws InterruptedException {
        long safeNanos = toSafeNanos(j, timeUnit);
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (guard.isSatisfied()) {
            return true;
        } else {
            if (!Thread.interrupted()) {
                return awaitNanos(guard, safeNanos, true);
            }
            throw new InterruptedException();
        }
    }

    public void waitForUninterruptibly(Guard guard) {
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (!guard.isSatisfied()) {
            awaitUninterruptibly(guard, true);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0027 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.google.common.util.concurrent.Monitor$Guard] */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.google.common.util.concurrent.Monitor$Guard] */
    /* JADX WARN: Type inference failed for: r8v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r11 == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        return r8;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0038 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046 A[LOOP:0: B:10:0x0027->B:22:0x0046, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x003e A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public boolean waitForUninterruptibly(Guard guard, long j, TimeUnit timeUnit) {
        ?? r8;
        Throwable th;
        long safeNanos = toSafeNanos(j, timeUnit);
        boolean z = true;
        if (!(guard.monitor == this) || !this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (guard.isSatisfied()) {
            return true;
        } else {
            long initNanoTime = initNanoTime(safeNanos);
            boolean interrupted = Thread.interrupted();
            long j2 = safeNanos;
            boolean z2 = true;
            r8 = guard;
            while (true) {
                try {
                    r8 = awaitNanos(r8, j2, z2);
                    try {
                        if (!r8.isSatisfied()) {
                            Thread.currentThread().interrupt();
                            return true;
                        }
                        j2 = remainingNanos(initNanoTime, safeNanos);
                        z2 = false;
                        interrupted = true;
                        r8 = r8;
                    } catch (Throwable th2) {
                        th = th2;
                        if (z) {
                        }
                        throw th;
                    }
                } catch (InterruptedException unknown) {
                    if (!r8.isSatisfied()) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z = interrupted;
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
        }
    }

    public void leave() {
        ReentrantLock reentrantLock = this.lock;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                signalNextWaiter();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean isFair() {
        return this.fair;
    }

    public boolean isOccupied() {
        return this.lock.isLocked();
    }

    public boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }

    public int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }

    public int getQueueLength() {
        return this.lock.getQueueLength();
    }

    public boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }

    public boolean hasQueuedThread(Thread thread) {
        return this.lock.hasQueuedThread(thread);
    }

    public boolean hasWaiters(Guard guard) {
        return getWaitQueueLength(guard) > 0;
    }

    public int getWaitQueueLength(Guard guard) {
        if (guard.monitor == this) {
            this.lock.lock();
            try {
                return guard.waiterCount;
            } finally {
                this.lock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    private static long toSafeNanos(long j, TimeUnit timeUnit) {
        return Longs.constrainToRange(timeUnit.toNanos(j), 0, 6917529027641081853L);
    }

    private static long initNanoTime(long j) {
        if (j <= 0) {
            return 0;
        }
        long nanoTime = System.nanoTime();
        if (nanoTime == 0) {
            return 1;
        }
        return nanoTime;
    }

    private static long remainingNanos(long j, long j2) {
        if (j2 <= 0) {
            return 0;
        }
        return j2 - (System.nanoTime() - j);
    }

    private void signalNextWaiter() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            if (isSatisfied(guard)) {
                guard.condition.signal();
                return;
            }
        }
    }

    private boolean isSatisfied(Guard guard) {
        try {
            return guard.isSatisfied();
        } catch (Throwable th) {
            signalAllWaiters();
            throw th;
        }
    }

    private void signalAllWaiters() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            guard.condition.signalAll();
        }
    }

    private void beginWaitingFor(Guard guard) {
        int i = guard.waiterCount;
        guard.waiterCount = i + 1;
        if (i == 0) {
            guard.next = this.activeGuards;
            this.activeGuards = guard;
        }
    }

    private void endWaitingFor(Guard guard) {
        int i = guard.waiterCount - 1;
        guard.waiterCount = i;
        if (i == 0) {
            Guard guard2 = this.activeGuards;
            Guard guard3 = null;
            while (guard2 != guard) {
                guard3 = guard2;
                guard2 = guard2.next;
            }
            if (guard3 == null) {
                this.activeGuards = guard2.next;
            } else {
                guard3.next = guard2.next;
            }
            guard2.next = null;
        }
    }

    private void await(Guard guard, boolean z) throws InterruptedException {
        if (z) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.await();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    private void awaitUninterruptibly(Guard guard, boolean z) {
        if (z) {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do {
            try {
                guard.condition.awaitUninterruptibly();
            } finally {
                endWaitingFor(guard);
            }
        } while (!guard.isSatisfied());
    }

    private boolean awaitNanos(Guard guard, long j, boolean z) throws InterruptedException {
        boolean z2 = true;
        while (j > 0) {
            if (z2) {
                if (z) {
                    try {
                        signalNextWaiter();
                    } catch (Throwable th) {
                        if (!z2) {
                            endWaitingFor(guard);
                        }
                        throw th;
                    }
                }
                beginWaitingFor(guard);
                z2 = false;
            }
            j = guard.condition.awaitNanos(j);
            if (guard.isSatisfied()) {
                if (!z2) {
                    endWaitingFor(guard);
                }
                return true;
            }
        }
        if (!z2) {
            endWaitingFor(guard);
        }
        return false;
    }
}
