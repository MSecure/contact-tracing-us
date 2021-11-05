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
    public final Object f1094a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public HandlerThread f1095b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f1096c;

    /* renamed from: d  reason: collision with root package name */
    public int f1097d;

    /* renamed from: e  reason: collision with root package name */
    public Handler.Callback f1098e = new a();
    public final int f;
    public final int g;
    public final String h;

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c cVar = c.this;
                synchronized (cVar.f1094a) {
                    if (!cVar.f1096c.hasMessages(1)) {
                        cVar.f1095b.quit();
                        cVar.f1095b = null;
                        cVar.f1096c = null;
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
                    synchronized (cVar2.f1094a) {
                        cVar2.f1096c.removeMessages(0);
                        cVar2.f1096c.sendMessageDelayed(cVar2.f1096c.obtainMessage(0), (long) cVar2.f);
                    }
                    return true;
                }
                throw null;
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f1100b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Callable f1101c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ReentrantLock f1102d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f1103e;
        public final /* synthetic */ Condition f;

        public b(c cVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f1100b = atomicReference;
            this.f1101c = callable;
            this.f1102d = reentrantLock;
            this.f1103e = atomicBoolean;
            this.f = condition;
        }

        public void run() {
            try {
                this.f1100b.set(this.f1101c.call());
            } catch (Exception unused) {
            }
            this.f1102d.lock();
            try {
                this.f1103e.set(false);
                this.f.signal();
            } finally {
                this.f1102d.unlock();
            }
        }
    }

    /* renamed from: b.i.i.c$c  reason: collision with other inner class name */
    public interface AbstractC0022c<T> {
        void a(T t);
    }

    public c(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
        this.f1097d = 0;
    }

    public final void a(Runnable runnable) {
        synchronized (this.f1094a) {
            if (this.f1095b == null) {
                HandlerThread handlerThread = new HandlerThread(this.h, this.g);
                this.f1095b = handlerThread;
                handlerThread.start();
                this.f1096c = new Handler(this.f1095b.getLooper(), this.f1098e);
                this.f1097d++;
            }
            this.f1096c.removeMessages(0);
            this.f1096c.sendMessage(this.f1096c.obtainMessage(1, runnable));
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
