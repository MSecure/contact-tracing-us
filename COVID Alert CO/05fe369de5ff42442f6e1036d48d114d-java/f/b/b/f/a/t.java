package f.b.b.f.a;

import f.b.b.f.a.d0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public abstract class t<T> extends AtomicReference<Runnable> implements Runnable {
    public static final Runnable b = new b(null);
    public static final Runnable c = new b(null);

    /* renamed from: d  reason: collision with root package name */
    public static final Runnable f3141d = new b(null);

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
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !d0.this.isDone();
            if (z) {
                try {
                    obj = ((d0.a) this).f3131e.call();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, b)) {
                        Runnable runnable = (Runnable) get();
                        boolean z2 = false;
                        int i2 = 0;
                        while (true) {
                            Runnable runnable2 = c;
                            if (runnable != runnable2 && runnable != f3141d) {
                                break;
                            }
                            i2++;
                            if (i2 > 1000) {
                                Runnable runnable3 = f3141d;
                                if (runnable == runnable3 || compareAndSet(runnable2, runnable3)) {
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
            if (!compareAndSet(currentThread, b)) {
                Runnable runnable4 = (Runnable) get();
                boolean z3 = false;
                int i3 = 0;
                while (true) {
                    Runnable runnable5 = c;
                    if (runnable4 != runnable5 && runnable4 != f3141d) {
                        break;
                    }
                    i3++;
                    if (i3 > 1000) {
                        Runnable runnable6 = f3141d;
                        if (runnable4 == runnable6 || compareAndSet(runnable5, runnable6)) {
                            z3 = Thread.interrupted() || z3;
                            LockSupport.park(this);
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable4 = (Runnable) get();
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
            StringBuilder i2 = f.a.a.a.a.i("running=[RUNNING ON ");
            i2.append(((Thread) runnable).getName());
            i2.append("]");
            str = i2.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        StringBuilder j2 = f.a.a.a.a.j(str, ", ");
        j2.append(((d0.a) this).f3131e.toString());
        return j2.toString();
    }
}
