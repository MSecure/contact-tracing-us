package gov.nc.dhhs.exposurenotification.common;

import b.n.i;
import b.n.p;
import b.n.q;
import d.a.a.a.c.c;
import java.util.concurrent.atomic.AtomicBoolean;

public class SingleLiveEvent<T> extends p<T> {
    public static final String TAG = "SingleLiveEvent";
    public final AtomicBoolean mPending = new AtomicBoolean(false);

    public /* synthetic */ void a(q qVar, Object obj) {
        if (this.mPending.compareAndSet(true, false)) {
            qVar.a(obj);
        }
    }

    public void call() {
        setValue(null);
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(i iVar, q<? super T> qVar) {
        hasActiveObservers();
        super.observe(iVar, new c(this, qVar));
    }

    public void postCall() {
        postValue(null);
    }

    @Override // androidx.lifecycle.LiveData, b.n.p
    public void postValue(T t) {
        this.mPending.set(true);
        super.postValue(t);
    }

    @Override // androidx.lifecycle.LiveData, b.n.p
    public void setValue(T t) {
        this.mPending.set(true);
        super.setValue(t);
    }
}
