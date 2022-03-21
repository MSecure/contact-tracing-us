package h.a.j1;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class q2 implements Executor, Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final Logger f3735e = Logger.getLogger(q2.class.getName());

    /* renamed from: f  reason: collision with root package name */
    public static final b f3736f;
    public final Executor b;
    public final Queue<Runnable> c = new ConcurrentLinkedQueue();

    /* renamed from: d  reason: collision with root package name */
    private volatile int f3737d = 0;

    public static abstract class b {
        public b(a aVar) {
        }

        public abstract boolean a(q2 q2Var, int i2, int i3);

        public abstract void b(q2 q2Var, int i2);
    }

    public static final class c extends b {
        public final AtomicIntegerFieldUpdater<q2> a;

        public c(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, a aVar) {
            super(null);
            this.a = atomicIntegerFieldUpdater;
        }

        @Override // h.a.j1.q2.b
        public boolean a(q2 q2Var, int i2, int i3) {
            return this.a.compareAndSet(q2Var, i2, i3);
        }

        @Override // h.a.j1.q2.b
        public void b(q2 q2Var, int i2) {
            this.a.set(q2Var, i2);
        }
    }

    public static final class d extends b {
        public d(a aVar) {
            super(null);
        }

        @Override // h.a.j1.q2.b
        public boolean a(q2 q2Var, int i2, int i3) {
            synchronized (q2Var) {
                if (q2Var.f3737d != i2) {
                    return false;
                }
                q2Var.f3737d = i3;
                return true;
            }
        }

        @Override // h.a.j1.q2.b
        public void b(q2 q2Var, int i2) {
            synchronized (q2Var) {
                q2Var.f3737d = i2;
            }
        }
    }

    static {
        b bVar;
        try {
            bVar = new c(AtomicIntegerFieldUpdater.newUpdater(q2.class, "d"), null);
        } catch (Throwable th) {
            f3735e.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th);
            bVar = new d(null);
        }
        f3736f = bVar;
    }

    public q2(Executor executor) {
        f.b.a.c.b.o.b.A(executor, "'executor' must not be null.");
        this.b = executor;
    }

    public final void c(Runnable runnable) {
        if (f3736f.a(this, 0, -1)) {
            try {
                this.b.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.c.remove(runnable);
                }
                f3736f.b(this, 0);
                throw th;
            }
        }
    }

    public void execute(Runnable runnable) {
        Queue<Runnable> queue = this.c;
        f.b.a.c.b.o.b.A(runnable, "'r' must not be null.");
        queue.add(runnable);
        c(runnable);
    }

    /* JADX INFO: finally extract failed */
    public void run() {
        while (true) {
            try {
                Runnable poll = this.c.poll();
                if (poll == null) {
                    break;
                }
                try {
                    poll.run();
                } catch (RuntimeException e2) {
                    Logger logger = f3735e;
                    Level level = Level.SEVERE;
                    logger.log(level, "Exception while executing runnable " + poll, (Throwable) e2);
                }
            } catch (Throwable th) {
                f3736f.b(this, 0);
                throw th;
            }
        }
        f3736f.b(this, 0);
        if (!this.c.isEmpty()) {
            c(null);
        }
    }
}
