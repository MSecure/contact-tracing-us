package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SelfDestructiveThread {
    public Handler.Callback mCallback = new Handler.Callback() {
        /* class androidx.core.provider.SelfDestructiveThread.AnonymousClass1 */

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                SelfDestructiveThread selfDestructiveThread = SelfDestructiveThread.this;
                synchronized (selfDestructiveThread.mLock) {
                    if (!selfDestructiveThread.mHandler.hasMessages(1)) {
                        selfDestructiveThread.mThread.quit();
                        selfDestructiveThread.mThread = null;
                        selfDestructiveThread.mHandler = null;
                    }
                }
                return true;
            } else if (i != 1) {
                return true;
            } else {
                SelfDestructiveThread selfDestructiveThread2 = SelfDestructiveThread.this;
                Runnable runnable = (Runnable) message.obj;
                if (selfDestructiveThread2 != null) {
                    runnable.run();
                    synchronized (selfDestructiveThread2.mLock) {
                        selfDestructiveThread2.mHandler.removeMessages(0);
                        selfDestructiveThread2.mHandler.sendMessageDelayed(selfDestructiveThread2.mHandler.obtainMessage(0), (long) selfDestructiveThread2.mDestructAfterMillisec);
                    }
                    return true;
                }
                throw null;
            }
        }
    };
    public final int mDestructAfterMillisec;
    public int mGeneration;
    public Handler mHandler;
    public final Object mLock = new Object();
    public final int mPriority;
    public HandlerThread mThread;
    public final String mThreadName;

    public interface ReplyCallback<T> {
        void onReply(T t);
    }

    public SelfDestructiveThread(String str, int i, int i2) {
        this.mThreadName = str;
        this.mPriority = i;
        this.mDestructAfterMillisec = i2;
        this.mGeneration = 0;
    }

    public final void post(Runnable runnable) {
        synchronized (this.mLock) {
            if (this.mThread == null) {
                HandlerThread handlerThread = new HandlerThread(this.mThreadName, this.mPriority);
                this.mThread = handlerThread;
                handlerThread.start();
                this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);
                this.mGeneration++;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, runnable));
        }
    }

    public <T> T postAndWait(final Callable<T> callable, int i) throws InterruptedException {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition newCondition = reentrantLock.newCondition();
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        post(new Runnable(this) {
            /* class androidx.core.provider.SelfDestructiveThread.AnonymousClass3 */

            public void run() {
                try {
                    atomicReference.set(callable.call());
                } catch (Exception unused) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    newCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
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
