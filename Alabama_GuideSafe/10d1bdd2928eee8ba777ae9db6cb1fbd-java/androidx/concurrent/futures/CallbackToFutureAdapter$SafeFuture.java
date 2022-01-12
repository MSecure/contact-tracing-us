package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class CallbackToFutureAdapter$SafeFuture<T> implements ListenableFuture<T> {
    public final WeakReference<CallbackToFutureAdapter$Completer<T>> completerWeakReference;
    public final AbstractResolvableFuture<T> delegate = new AbstractResolvableFuture<T>() {
        /* class androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture.AnonymousClass1 */

        @Override // androidx.concurrent.futures.AbstractResolvableFuture
        public String pendingToString() {
            CallbackToFutureAdapter$Completer<T> callbackToFutureAdapter$Completer = CallbackToFutureAdapter$SafeFuture.this.completerWeakReference.get();
            if (callbackToFutureAdapter$Completer == null) {
                return "Completer object has been garbage collected, future will fail soon";
            }
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("tag=[");
            outline17.append(callbackToFutureAdapter$Completer.tag);
            outline17.append("]");
            return outline17.toString();
        }
    };

    public CallbackToFutureAdapter$SafeFuture(CallbackToFutureAdapter$Completer<T> callbackToFutureAdapter$Completer) {
        this.completerWeakReference = new WeakReference<>(callbackToFutureAdapter$Completer);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.delegate.addListener(runnable, executor);
    }

    public boolean cancel(boolean z) {
        CallbackToFutureAdapter$Completer<T> callbackToFutureAdapter$Completer = this.completerWeakReference.get();
        boolean cancel = this.delegate.cancel(z);
        if (cancel && callbackToFutureAdapter$Completer != null) {
            callbackToFutureAdapter$Completer.tag = null;
            callbackToFutureAdapter$Completer.future = null;
            callbackToFutureAdapter$Completer.cancellationFuture.set(null);
        }
        return cancel;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        return this.delegate.get();
    }

    public boolean isCancelled() {
        return this.delegate.value instanceof AbstractResolvableFuture.Cancellation;
    }

    public boolean isDone() {
        return this.delegate.isDone();
    }

    public String toString() {
        return this.delegate.toString();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.delegate.get(j, timeUnit);
    }
}
