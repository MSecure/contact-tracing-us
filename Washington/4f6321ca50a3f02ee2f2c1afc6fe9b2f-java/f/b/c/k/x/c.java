package f.b.c.k.x;

import android.os.Handler;
import android.os.Looper;
import f.b.a.c.i.i;
import f.b.c.k.x.m;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class c {
    public final ExecutorC0117c a = new ExecutorC0117c();
    public final ArrayList<b> b = new ArrayList<>();
    public final ArrayList<d> c = new ArrayList<>();

    public class b {
        public final Runnable a;
        public ScheduledFuture b;

        public b(d dVar, long j2, Runnable runnable, a aVar) {
            this.a = runnable;
        }

        public void a() {
            c.this.d();
            ScheduledFuture scheduledFuture = this.b;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                b();
            }
        }

        public final void b() {
            f.b.a.c.b.o.b.a1(this.b != null, "Caller should have verified scheduledFuture is non-null.", new Object[0]);
            this.b = null;
            f.b.a.c.b.o.b.a1(c.this.b.remove(this), "Delayed task not found.", new Object[0]);
        }
    }

    /* renamed from: f.b.c.k.x.c$c  reason: collision with other inner class name */
    public class ExecutorC0117c implements Executor {
        public final ScheduledThreadPoolExecutor b;
        public final Thread c;

        /* renamed from: f.b.c.k.x.c$c$a */
        public class a extends ScheduledThreadPoolExecutor {
            public a(int i2, ThreadFactory threadFactory, c cVar) {
                super(i2, threadFactory);
            }

            public void afterExecute(Runnable runnable, Throwable th) {
                super.afterExecute(runnable, th);
                if (th == null && (runnable instanceof Future)) {
                    Future future = (Future) runnable;
                    try {
                        if (future.isDone()) {
                            future.get();
                        }
                    } catch (CancellationException unused) {
                    } catch (ExecutionException e2) {
                        th = e2.getCause();
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (th != null) {
                    c.this.c(th);
                }
            }
        }

        /* renamed from: f.b.c.k.x.c$c$b */
        public class b implements Runnable, ThreadFactory {
            public final CountDownLatch b = new CountDownLatch(1);
            public Runnable c;

            public b(a aVar) {
            }

            public Thread newThread(Runnable runnable) {
                f.b.a.c.b.o.b.a1(this.c == null, "Only one thread may be created in an AsyncQueue.", new Object[0]);
                this.c = runnable;
                this.b.countDown();
                return ExecutorC0117c.this.c;
            }

            public void run() {
                try {
                    this.b.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                this.c.run();
            }
        }

        public ExecutorC0117c() {
            b bVar = new b(null);
            Thread newThread = Executors.defaultThreadFactory().newThread(bVar);
            this.c = newThread;
            newThread.setName("FirestoreWorker");
            newThread.setDaemon(true);
            newThread.setUncaughtExceptionHandler(new e(this));
            a aVar = new a(1, bVar, c.this);
            this.b = aVar;
            aVar.setKeepAliveTime(3, TimeUnit.SECONDS);
        }

        public synchronized void execute(Runnable runnable) {
            this.b.execute(runnable);
        }
    }

    public enum d {
        ALL,
        LISTEN_STREAM_IDLE,
        LISTEN_STREAM_CONNECTION_BACKOFF,
        WRITE_STREAM_IDLE,
        WRITE_STREAM_CONNECTION_BACKOFF,
        ONLINE_STATE_TIMEOUT,
        GARBAGE_COLLECTION,
        RETRY_TRANSACTION,
        CONNECTIVITY_ATTEMPT_TIMER
    }

    public b a(d dVar, long j2, Runnable runnable) {
        ScheduledFuture<?> schedule;
        if (this.c.contains(dVar)) {
            j2 = 0;
        }
        b bVar = new b(dVar, System.currentTimeMillis() + j2, runnable, null);
        ExecutorC0117c cVar = this.a;
        d dVar2 = new d(bVar);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        synchronized (cVar) {
            schedule = cVar.b.schedule(dVar2, j2, timeUnit);
        }
        bVar.b = schedule;
        this.b.add(bVar);
        return bVar;
    }

    public void b(Runnable runnable) {
        a aVar = new a(runnable);
        ExecutorC0117c cVar = this.a;
        Objects.requireNonNull(cVar);
        try {
            cVar.execute(new f(new i(), aVar));
        } catch (RejectedExecutionException unused) {
            m.a(m.a.WARN, c.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
        }
    }

    public void c(Throwable th) {
        this.a.b.shutdownNow();
        new Handler(Looper.getMainLooper()).post(new b(th));
    }

    public void d() {
        Thread currentThread = Thread.currentThread();
        Thread thread = this.a.c;
        if (thread != currentThread) {
            f.b.a.c.b.o.b.z0("We are running on the wrong thread. Expected to be on the AsyncQueue thread %s/%d but was %s/%d", thread.getName(), Long.valueOf(this.a.c.getId()), currentThread.getName(), Long.valueOf(currentThread.getId()));
            throw null;
        }
    }
}
