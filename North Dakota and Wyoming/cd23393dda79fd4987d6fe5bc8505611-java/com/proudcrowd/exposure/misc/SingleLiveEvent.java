package com.proudcrowd.exposure.misc;

import android.util.Log;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

public class SingleLiveEvent<T> extends MutableLiveData<T> {
    private static final String TAG = "SingleLiveEvent";
    private final AtomicBoolean mPending = new AtomicBoolean(false);

    @Override // androidx.lifecycle.LiveData
    public void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(lifecycleOwner, new Observer(observer) {
            /* class com.proudcrowd.exposure.misc.$$Lambda$SingleLiveEvent$xy5oyjPNG4crtcup0VpkhD0lNvY */
            public final /* synthetic */ Observer f$1;

            {
                this.f$1 = r2;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SingleLiveEvent.this.lambda$observe$0$SingleLiveEvent(this.f$1, obj);
            }
        });
    }

    public /* synthetic */ void lambda$observe$0$SingleLiveEvent(Observer observer, Object obj) {
        if (this.mPending.compareAndSet(true, false)) {
            observer.onChanged(obj);
        }
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T t) {
        this.mPending.set(true);
        super.setValue(t);
    }

    public void call() {
        setValue(null);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(T t) {
        this.mPending.set(true);
        super.postValue(t);
    }

    public void postCall() {
        postValue(null);
    }
}
