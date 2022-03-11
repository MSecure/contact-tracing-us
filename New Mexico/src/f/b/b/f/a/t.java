package f.b.b.f.a;

import f.b.b.f.a.d0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes.dex */
public abstract class t<T> extends AtomicReference<Runnable> implements Runnable {
    public static final Runnable b = new b(null);
    public static final Runnable c = new b(null);

    /* renamed from: d  reason: collision with root package name */
    public static final Runnable f3459d = new b(null);

    /* loaded from: classes.dex */
    public static final class b implements Runnable {
        public b(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public abstract void a(T t, Throwable th);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object call;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !d0.this.isDone();
            if (z) {
                try {
                    call = ((d0.a) this).f3449e.call();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, b)) {
                        Runnable runnable = (Runnable) get();
                        boolean z2 = false;
                        int i2 = 0;
                        while (true) {
                            Runnable runnable2 = c;
                            if (runnable != runnable2 && runnable != f3459d) {
                                break;
                            }
                            i2++;
                            if (i2 > 1000) {
                                Runnable runnable3 = f3459d;
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
                call = null;
            }
            if (!compareAndSet(currentThread, b)) {
                Runnable runnable4 = (Runnable) get();
                boolean z3 = false;
                int i3 = 0;
                while (true) {
                    Runnable runnable5 = c;
                    if (runnable4 != runnable5 && runnable4 != f3459d) {
                        break;
                    }
                    i3++;
                    if (i3 > 1000) {
                        Runnable runnable6 = f3459d;
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
                a(call, null);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference, java.lang.Object
    public final String toString() {
        String str;
        Runnable runnable = get();
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
        i2.append(((d0.a) this).f3449e.toString());
        return i2.toString();
    }
}
