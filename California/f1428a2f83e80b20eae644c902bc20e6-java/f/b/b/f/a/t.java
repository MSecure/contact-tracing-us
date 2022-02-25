package f.b.b.f.a;

import f.b.b.f.a.c0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public abstract class t<T> extends AtomicReference<Runnable> implements Runnable {
    public static final Runnable b = new b(null);
    public static final Runnable c = new b(null);

    /* renamed from: d  reason: collision with root package name */
    public static final Runnable f2941d = new b(null);

    public static final class b implements Runnable {
        public b(a aVar) {
        }

        public void run() {
        }
    }

    public abstract void a(T t, Throwable th);

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: f.b.b.f.a.t<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void run() {
        Object obj;
        Runnable runnable = c;
        Runnable runnable2 = b;
        Runnable runnable3 = f2941d;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !c0.this.isDone();
            if (z) {
                try {
                    obj = ((c0.a) this).f2929e.call();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, runnable2)) {
                        Runnable runnable4 = (Runnable) get();
                        boolean z2 = false;
                        int i2 = 0;
                        while (true) {
                            if (runnable4 != runnable && runnable4 != runnable3) {
                                break;
                            }
                            i2++;
                            if (i2 <= 1000) {
                                Thread.yield();
                            } else if (runnable4 == runnable3 || compareAndSet(runnable, runnable3)) {
                                z2 = Thread.interrupted() || z2;
                                LockSupport.park(this);
                            }
                            runnable4 = (Runnable) get();
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
            if (!compareAndSet(currentThread, runnable2)) {
                Runnable runnable5 = (Runnable) get();
                boolean z3 = false;
                int i3 = 0;
                while (true) {
                    if (runnable5 != runnable && runnable5 != runnable3) {
                        break;
                    }
                    i3++;
                    if (i3 <= 1000) {
                        Thread.yield();
                    } else if (runnable5 == runnable3 || compareAndSet(runnable, runnable3)) {
                        z3 = Thread.interrupted() || z3;
                        LockSupport.park(this);
                    }
                    runnable5 = (Runnable) get();
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
        if (runnable == b) {
            str = "running=[DONE]";
        } else if (runnable == c) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            StringBuilder h2 = f.a.a.a.a.h("running=[RUNNING ON ");
            h2.append(((Thread) runnable).getName());
            h2.append("]");
            str = h2.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        StringBuilder i2 = f.a.a.a.a.i(str, ", ");
        i2.append(((c0.a) this).f2929e.toString());
        return i2.toString();
    }
}
