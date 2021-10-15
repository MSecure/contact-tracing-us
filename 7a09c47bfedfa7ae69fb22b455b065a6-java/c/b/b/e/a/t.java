package c.b.b.e.a;

import c.b.b.e.a.c0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public abstract class t<T> extends AtomicReference<Runnable> implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f4764b = new b(null);

    /* renamed from: c  reason: collision with root package name */
    public static final Runnable f4765c = new b(null);

    /* renamed from: d  reason: collision with root package name */
    public static final Runnable f4766d = new b(null);

    public static final class b implements Runnable {
        public b(a aVar) {
        }

        public void run() {
        }
    }

    public abstract void a(T t, Throwable th);

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: c.b.b.e.a.t<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void run() {
        Object obj;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !c0.this.isDone();
            if (z) {
                try {
                    obj = ((c0.a) this).f4746e.call();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, f4764b)) {
                        Runnable runnable = (Runnable) get();
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            if (runnable != f4765c && runnable != f4766d) {
                                break;
                            }
                            i++;
                            if (i > 1000) {
                                Runnable runnable2 = f4766d;
                                if (runnable == runnable2 || compareAndSet(f4765c, runnable2)) {
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
                        a(null, th);
                        return;
                    }
                    return;
                }
            } else {
                obj = null;
            }
            if (!compareAndSet(currentThread, f4764b)) {
                Runnable runnable3 = (Runnable) get();
                boolean z3 = false;
                int i2 = 0;
                while (true) {
                    if (runnable3 != f4765c && runnable3 != f4766d) {
                        break;
                    }
                    i2++;
                    if (i2 > 1000) {
                        Runnable runnable4 = f4766d;
                        if (runnable3 == runnable4 || compareAndSet(f4765c, runnable4)) {
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
                a(obj, null);
            }
        }
    }

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == f4764b) {
            str = "running=[DONE]";
        } else if (runnable == f4765c) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            StringBuilder h = c.a.a.a.a.h("running=[RUNNING ON ");
            h.append(((Thread) runnable).getName());
            h.append("]");
            str = h.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + ((c0.a) this).f4746e.toString();
    }
}
