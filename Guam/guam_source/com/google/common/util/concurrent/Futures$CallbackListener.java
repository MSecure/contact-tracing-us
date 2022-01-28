package com.google.common.util.concurrent;

import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class Futures$CallbackListener<V> implements Runnable {
    public final FutureCallback<? super V> callback;
    public final Future<V> future;

    public Futures$CallbackListener(Future<V> future2, FutureCallback<? super V> futureCallback) {
        this.future = future2;
        this.callback = futureCallback;
    }

    public void run() {
        Throwable tryInternalFastPathGetFailure;
        Future<V> future2 = this.future;
        if (!(future2 instanceof InternalFutureFailureAccess) || (tryInternalFastPathGetFailure = ReactYogaConfigProvider.tryInternalFastPathGetFailure((InternalFutureFailureAccess) future2)) == null) {
            try {
                this.callback.onSuccess(ReactYogaConfigProvider.getDone(this.future));
            } catch (ExecutionException e) {
                this.callback.onFailure(e.getCause());
            } catch (Error | RuntimeException e2) {
                this.callback.onFailure(e2);
            }
        } else {
            this.callback.onFailure(tryInternalFastPathGetFailure);
        }
    }

    public String toString() {
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = new MoreObjects$ToStringHelper(Futures$CallbackListener.class.getSimpleName(), null);
        FutureCallback<? super V> futureCallback = this.callback;
        MoreObjects$ToStringHelper.ValueHolder valueHolder = new MoreObjects$ToStringHelper.ValueHolder(null);
        moreObjects$ToStringHelper.holderTail.next = valueHolder;
        moreObjects$ToStringHelper.holderTail = valueHolder;
        valueHolder.value = futureCallback;
        return moreObjects$ToStringHelper.toString();
    }
}
