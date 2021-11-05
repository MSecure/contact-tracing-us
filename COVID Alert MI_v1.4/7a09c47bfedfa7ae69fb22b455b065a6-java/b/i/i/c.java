package b.i.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1798a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public HandlerThread f1799b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f1800c;

    /* renamed from: d  reason: collision with root package name */
    public int f1801d;

    /* renamed from: e  reason: collision with root package name */
    public Handler.Callback f1802e = new a();

    /* renamed from: f  reason: collision with root package name */
    public final int f1803f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1804g;
    public final String h;

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c cVar = c.this;
                synchronized (cVar.f1798a) {
                    if (!cVar.f1800c.hasMessages(1)) {
                        cVar.f1799b.quit();
                        cVar.f1799b = null;
                        cVar.f1800c = null;
                    }
                }
                return true;
            } else if (i != 1) {
                return true;
            } else {
                c cVar2 = c.this;
                Runnable runnable = (Runnable) message.obj;
                if (cVar2 != null) {
                    runnable.run();
                    synchronized (cVar2.f1798a) {
                        cVar2.f1800c.removeMessages(0);
                        cVar2.f1800c.sendMessageDelayed(cVar2.f1800c.obtainMessage(0), (long) cVar2.f1803f);
                    }
                    return true;
                }
                throw null;
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f1806b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Callable f1807c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ReentrantLock f1808d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f1809e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Condition f1810f;

        public b(c cVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f1806b = atomicReference;
            this.f1807c = callable;
            this.f1808d = reentrantLock;
            this.f1809e = atomicBoolean;
            this.f1810f = condition;
        }

        public void run() {
            try {
                this.f1806b.set(this.f1807c.call());
            } catch (Exception unused) {
            }
            this.f1808d.lock();
            try {
                this.f1809e.set(false);
                this.f1810f.signal();
            } finally {
                this.f1808d.unlock();
            }
        }
    }

    /* renamed from: b.i.i.c$c  reason: collision with other inner class name */
    public interface AbstractC0032c<T> {
        void a(T t);
    }

    public c(String str, int i, int i2) {
        this.h = str;
        this.f1804g = i;
        this.f1803f = i2;
        this.f1801d = 0;
    }

    public final void a(Runnable runnable) {
        synchronized (this.f1798a) {
            if (this.f1799b == null) {
                HandlerThread handlerThread = new HandlerThread(this.h, this.f1804g);
                this.f1799b = handlerThread;
                handlerThread.start();
                this.f1800c = new Handler(this.f1799b.getLooper(), this.f1802e);
                this.f1801d++;
            }
            this.f1800c.removeMessages(0);
            this.f1800c.sendMessage(this.f1800c.obtainMessage(1, runnable));
        }
    }

    public <T> T b(Callable<T> callable, int i) {
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
            long nanos = TimeUnit.MILLISECONDS.toNanos((long) i);
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
