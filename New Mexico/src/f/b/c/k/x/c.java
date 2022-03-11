package f.b.c.k.x;

import android.os.Handler;
import android.os.Looper;
import f.b.a.c.i.i;
import f.b.c.k.x.c;
import f.b.c.k.x.m;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Callable;
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
/* loaded from: classes.dex */
public class c {
    public final ArrayList<d> c = new ArrayList<>();
    public final ArrayList<b> b = new ArrayList<>();
    public final ExecutorC0122c a = new ExecutorC0122c();

    /* loaded from: classes.dex */
    public class b {
        public final Runnable a;
        public ScheduledFuture b;

        public b(d dVar, long j2, Runnable runnable, a aVar) {
            c.this = r1;
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
            f.b.a.c.b.o.b.P0(this.b != null, "Caller should have verified scheduledFuture is non-null.", new Object[0]);
            this.b = null;
            f.b.a.c.b.o.b.P0(c.this.b.remove(this), "Delayed task not found.", new Object[0]);
        }
    }

    /* renamed from: f.b.c.k.x.c$c */
    /* loaded from: classes.dex */
    public class ExecutorC0122c implements Executor {
        public final ScheduledThreadPoolExecutor b;
        public final Thread c;

        /* renamed from: f.b.c.k.x.c$c$a */
        /* loaded from: classes.dex */
        public class a extends ScheduledThreadPoolExecutor {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(int i2, ThreadFactory threadFactory, c cVar) {
                super(i2, threadFactory);
                ExecutorC0122c.this = r1;
            }

            @Override // java.util.concurrent.ThreadPoolExecutor
            public void afterExecute(Runnable runnable, Throwable th) {
                super.afterExecute(runnable, th);
                if (th == null && (runnable instanceof Future)) {
                    Future future = (Future) runnable;
                    try {
                        if (future.isDone()) {
                            future.get();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    } catch (CancellationException unused2) {
                    } catch (ExecutionException e2) {
                        th = e2.getCause();
                    }
                }
                if (th != null) {
                    c.this.c(th);
                }
            }
        }

        /* renamed from: f.b.c.k.x.c$c$b */
        /* loaded from: classes.dex */
        public class b implements Runnable, ThreadFactory {
            public final CountDownLatch b = new CountDownLatch(1);
            public Runnable c;

            public b(a aVar) {
                ExecutorC0122c.this = r1;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                f.b.a.c.b.o.b.P0(this.c == null, "Only one thread may be created in an AsyncQueue.", new Object[0]);
                this.c = runnable;
                this.b.countDown();
                return ExecutorC0122c.this.c;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.b.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                this.c.run();
            }
        }

        public ExecutorC0122c() {
            c.this = r5;
            b bVar = new b(null);
            Thread newThread = Executors.defaultThreadFactory().newThread(bVar);
            this.c = newThread;
            newThread.setName("FirestoreWorker");
            newThread.setDaemon(true);
            newThread.setUncaughtExceptionHandler(new e(this));
            a aVar = new a(1, bVar, r5);
            this.b = aVar;
            aVar.setKeepAliveTime(3, TimeUnit.SECONDS);
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.b.execute(runnable);
        }
    }

    /* loaded from: classes.dex */
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
        ExecutorC0122c cVar = this.a;
        d dVar2 = new Runnable(bVar) { // from class: f.b.c.k.x.d
            public final c.b b;

            {
                this.b = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.b bVar2 = this.b;
                c.this.d();
                if (bVar2.b != null) {
                    bVar2.b();
                    bVar2.a.run();
                }
            }
        };
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        synchronized (cVar) {
            schedule = cVar.b.schedule(dVar2, j2, timeUnit);
        }
        bVar.b = schedule;
        this.b.add(bVar);
        return bVar;
    }

    public void b(Runnable runnable) {
        a aVar = new Callable(runnable) { // from class: f.b.c.k.x.a
            public final Runnable a;

            {
                this.a = r1;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                this.a.run();
                return null;
            }
        };
        ExecutorC0122c cVar = this.a;
        Objects.requireNonNull(cVar);
        try {
            cVar.execute(new Runnable(new i(), aVar) { // from class: f.b.c.k.x.f
                public final i b;
                public final Callable c;

                {
                    this.b = r1;
                    this.c = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    i iVar = this.b;
                    try {
                        iVar.a.r(this.c.call());
                    } catch (Exception e2) {
                        iVar.a.q(e2);
                        throw new RuntimeException(e2);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            m.a(m.a.WARN, c.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
        }
    }

    public void c(Throwable th) {
        this.a.b.shutdownNow();
        new Handler(Looper.getMainLooper()).post(new Runnable(th) { // from class: f.b.c.k.x.b
            public final Throwable b;

            {
                this.b = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                Throwable th2 = this.b;
                if (th2 instanceof OutOfMemoryError) {
                    OutOfMemoryError outOfMemoryError = new OutOfMemoryError("Firestore (21.6.0) ran out of memory. Check your queries to make sure they are not loading an excessive amount of data.");
                    outOfMemoryError.initCause(th2);
                    throw outOfMemoryError;
                }
                throw new RuntimeException("Internal error in Cloud Firestore (21.6.0).", th2);
            }
        });
    }

    public void d() {
        Thread currentThread = Thread.currentThread();
        Thread thread = this.a.c;
        if (thread != currentThread) {
            f.b.a.c.b.o.b.r0("We are running on the wrong thread. Expected to be on the AsyncQueue thread %s/%d but was %s/%d", thread.getName(), Long.valueOf(this.a.c.getId()), currentThread.getName(), Long.valueOf(currentThread.getId()));
            throw null;
        }
    }
}
