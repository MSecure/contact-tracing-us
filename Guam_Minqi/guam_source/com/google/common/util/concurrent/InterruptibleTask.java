package com.google.common.util.concurrent;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.TrustedListenableFutureTask;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    public static final Runnable DONE = new DoNothingRunnable(null);
    public static final Runnable INTERRUPTING = new DoNothingRunnable(null);
    public static final Runnable PARKED = new DoNothingRunnable(null);

    public static final class DoNothingRunnable implements Runnable {
        public DoNothingRunnable(AnonymousClass1 r1) {
        }

        public void run() {
        }
    }

    public abstract void afterRanInterruptibly(T t, Throwable th);

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: com.google.common.util.concurrent.InterruptibleTask<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void run() {
        Object obj;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !TrustedListenableFutureTask.this.isDone();
            if (z) {
                try {
                    obj = ((TrustedListenableFutureTask.TrustedFutureInterruptibleTask) this).callable.call();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, DONE)) {
                        Runnable runnable = (Runnable) get();
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            if (runnable != INTERRUPTING && runnable != PARKED) {
                                break;
                            }
                            i++;
                            if (i > 1000) {
                                Runnable runnable2 = PARKED;
                                if (runnable == runnable2 || compareAndSet(INTERRUPTING, runnable2)) {
                                    z2 = Thread.interrupted() || z2;
                                    LockSupport.park(this);
                                }
                            } else {
                                Thread.yield();
                            }
                            runnable = (Runnable) get();
                        }
                        if (z2) {
                            currentThread.interrupt();
                        }
                    }
                    if (z) {
                        afterRanInterruptibly(null, th);
                        return;
                    }
                    return;
                }
            } else {
                obj = null;
            }
            if (!compareAndSet(currentThread, DONE)) {
                Runnable runnable3 = (Runnable) get();
                boolean z3 = false;
                int i2 = 0;
                while (true) {
                    if (runnable3 != INTERRUPTING && runnable3 != PARKED) {
                        break;
                    }
                    i2++;
                    if (i2 > 1000) {
                        Runnable runnable4 = PARKED;
                        if (runnable3 == runnable4 || compareAndSet(INTERRUPTING, runnable4)) {
                            z3 = Thread.interrupted() || z3;
                            LockSupport.park(this);
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable3 = (Runnable) get();
                }
                if (z3) {
                    currentThread.interrupt();
                }
            }
            if (z) {
                afterRanInterruptibly(obj, null);
            }
        }
    }

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == DONE) {
            str = "running=[DONE]";
        } else if (runnable == INTERRUPTING) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("running=[RUNNING ON ");
            outline15.append(((Thread) runnable).getName());
            outline15.append("]");
            str = outline15.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + ((TrustedListenableFutureTask.TrustedFutureInterruptibleTask) this).callable.toString();
    }
}
