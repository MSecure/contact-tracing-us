package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class TimeoutFuture<V> extends FluentFuture.TrustedFuture<V> {
    public ListenableFuture<V> delegateRef;
    public ScheduledFuture<?> timer;

    public static final class Fire<V> implements Runnable {
        public TimeoutFuture<V> timeoutFutureRef;

        public Fire(TimeoutFuture<V> timeoutFuture) {
            this.timeoutFutureRef = timeoutFuture;
        }

        public void run() {
            ListenableFuture<V> listenableFuture;
            TimeoutFuture<V> timeoutFuture = this.timeoutFutureRef;
            if (timeoutFuture != null && (listenableFuture = timeoutFuture.delegateRef) != null) {
                this.timeoutFutureRef = null;
                if (listenableFuture.isDone()) {
                    timeoutFuture.setFuture(listenableFuture);
                    return;
                }
                try {
                    ScheduledFuture<?> scheduledFuture = timeoutFuture.timer;
                    timeoutFuture.timer = null;
                    String str = "Timed out";
                    if (scheduledFuture != null) {
                        try {
                            long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                            if (abs > 10) {
                                str = str + " (timeout delayed by " + abs + " ms after scheduled time)";
                            }
                        } catch (Throwable th) {
                            timeoutFuture.setException(new TimeoutFutureException(str, null));
                            throw th;
                        }
                    }
                    timeoutFuture.setException(new TimeoutFutureException(str + ": " + listenableFuture, null));
                } finally {
                    listenableFuture.cancel(true);
                }
            }
        }
    }

    public static final class TimeoutFutureException extends TimeoutException {
        public TimeoutFutureException(String str, AnonymousClass1 r2) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }
    }

    public TimeoutFuture(ListenableFuture<V> listenableFuture) {
        if (listenableFuture != null) {
            this.delegateRef = listenableFuture;
            return;
        }
        throw null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        maybePropagateCancellationTo(this.delegateRef);
        ScheduledFuture<?> scheduledFuture = this.timer;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.delegateRef = null;
        this.timer = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        ListenableFuture<V> listenableFuture = this.delegateRef;
        ScheduledFuture<?> scheduledFuture = this.timer;
        if (listenableFuture == null) {
            return null;
        }
        String str = "inputFuture=[" + listenableFuture + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }
}
