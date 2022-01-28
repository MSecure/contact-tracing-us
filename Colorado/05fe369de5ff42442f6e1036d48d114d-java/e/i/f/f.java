package e.i.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class f {
    public final Object a = new Object();
    public HandlerThread b;
    public Handler c;

    /* renamed from: d  reason: collision with root package name */
    public int f1273d = 0;

    /* renamed from: e  reason: collision with root package name */
    public Handler.Callback f1274e = new a();

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                f fVar = f.this;
                synchronized (fVar.a) {
                    if (!fVar.c.hasMessages(1)) {
                        fVar.b.quit();
                        fVar.b = null;
                        fVar.c = null;
                    }
                }
                return true;
            } else if (i2 != 1) {
                return true;
            } else {
                f fVar2 = f.this;
                Objects.requireNonNull(fVar2);
                ((Runnable) message.obj).run();
                synchronized (fVar2.a) {
                    fVar2.c.removeMessages(0);
                    Handler handler = fVar2.c;
                    handler.sendMessageDelayed(handler.obtainMessage(0), (long) 10000);
                }
                return true;
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ AtomicReference b;
        public final /* synthetic */ Callable c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ReentrantLock f1275d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f1276e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Condition f1277f;

        public b(f fVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.b = atomicReference;
            this.c = callable;
            this.f1275d = reentrantLock;
            this.f1276e = atomicBoolean;
            this.f1277f = condition;
        }

        public void run() {
            try {
                this.b.set(this.c.call());
            } catch (Exception unused) {
            }
            this.f1275d.lock();
            try {
                this.f1276e.set(false);
                this.f1277f.signal();
            } finally {
                this.f1275d.unlock();
            }
        }
    }

    public interface c<T> {
        void a(T t);
    }

    public f(String str, int i2, int i3) {
    }

    public final void a(Runnable runnable) {
        synchronized (this.a) {
            if (this.b == null) {
                HandlerThread handlerThread = new HandlerThread("fonts", 10);
                this.b = handlerThread;
                handlerThread.start();
                this.c = new Handler(this.b.getLooper(), this.f1274e);
                this.f1273d++;
            }
            this.c.removeMessages(0);
            Handler handler = this.c;
            handler.sendMessage(handler.obtainMessage(1, runnable));
        }
    }

    public <T> T b(Callable<T> callable, int i2) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        a(new b(this, atomicReference, callable, reentrantLock, atomicBoolean, newCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos((long) i2);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    T t = (T) atomicReference.get();
                    reentrantLock.unlock();
                    return t;
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
