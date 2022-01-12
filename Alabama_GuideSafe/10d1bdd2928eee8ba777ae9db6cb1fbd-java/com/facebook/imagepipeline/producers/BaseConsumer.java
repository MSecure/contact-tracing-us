package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;

public abstract class BaseConsumer<T> implements Consumer<T> {
    public boolean mIsFinished = false;

    public static boolean isLast(int i) {
        return (i & 1) == 1;
    }

    public static boolean isNotLast(int i) {
        return !isLast(i);
    }

    public static boolean statusHasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onCancellation() {
        if (!this.mIsFinished) {
            this.mIsFinished = true;
            try {
                onCancellationImpl();
            } catch (Exception e) {
                onUnhandledException(e);
            }
        }
    }

    public abstract void onCancellationImpl();

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onFailure(Throwable th) {
        if (!this.mIsFinished) {
            this.mIsFinished = true;
            try {
                onFailureImpl(th);
            } catch (Exception e) {
                onUnhandledException(e);
            }
        }
    }

    public abstract void onFailureImpl(Throwable th);

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onNewResult(T t, int i) {
        if (!this.mIsFinished) {
            this.mIsFinished = isLast(i);
            try {
                onNewResultImpl(t, i);
            } catch (Exception e) {
                onUnhandledException(e);
            }
        }
    }

    public abstract void onNewResultImpl(T t, int i);

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onProgressUpdate(float f) {
        if (!this.mIsFinished) {
            try {
                onProgressUpdateImpl(f);
            } catch (Exception e) {
                onUnhandledException(e);
            }
        }
    }

    public abstract void onProgressUpdateImpl(float f);

    public void onUnhandledException(Exception exc) {
        Class<?> cls = getClass();
        if (((FLogDefaultLoggingDelegate) FLog.sHandler).isLoggable(6)) {
            ((FLogDefaultLoggingDelegate) FLog.sHandler).println(6, cls.getSimpleName(), "unhandled exception", exc);
        }
    }
}
