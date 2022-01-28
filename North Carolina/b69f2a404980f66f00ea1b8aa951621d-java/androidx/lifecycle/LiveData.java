package androidx.lifecycle;

import b.c.a.b.b;
import b.n.f;
import b.n.g;
import b.n.i;
import b.n.j;
import b.n.q;
import java.util.Iterator;
import java.util.Map;

public abstract class LiveData<T> {
    public static final Object NOT_SET = new Object();
    public static final int START_VERSION = -1;
    public int mActiveCount;
    public volatile Object mData;
    public final Object mDataLock;
    public boolean mDispatchInvalidated;
    public boolean mDispatchingValue;
    public b.c.a.b.b<q<? super T>, LiveData<T>.c> mObservers;
    public volatile Object mPendingData;
    public final Runnable mPostValueRunnable;
    public int mVersion;

    public class LifecycleBoundObserver extends LiveData<T>.c implements g {

        /* renamed from: e  reason: collision with root package name */
        public final i f160e;

        public LifecycleBoundObserver(i iVar, q<? super T> qVar) {
            super(qVar);
            this.f160e = iVar;
        }

        @Override // b.n.g
        public void d(i iVar, f.a aVar) {
            if (((j) this.f160e.getLifecycle()).f1392b == f.b.DESTROYED) {
                LiveData.this.removeObserver(this.f162a);
            } else {
                h(k());
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        public void i() {
            ((j) this.f160e.getLifecycle()).f1391a.j(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean j(i iVar) {
            return this.f160e == iVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean k() {
            return ((j) this.f160e.getLifecycle()).f1392b.compareTo(f.b.STARTED) >= 0;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.LiveData */
        /* JADX WARN: Multi-variable type inference failed */
        public void run() {
            Object obj;
            synchronized (LiveData.this.mDataLock) {
                obj = LiveData.this.mPendingData;
                LiveData.this.mPendingData = LiveData.NOT_SET;
            }
            LiveData.this.setValue(obj);
        }
    }

    public class b extends LiveData<T>.c {
        public b(LiveData liveData, q<? super T> qVar) {
            super(qVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean k() {
            return true;
        }
    }

    public abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public final q<? super T> f162a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f163b;

        /* renamed from: c  reason: collision with root package name */
        public int f164c = -1;

        public c(q<? super T> qVar) {
            this.f162a = qVar;
        }

        public void h(boolean z) {
            if (z != this.f163b) {
                this.f163b = z;
                int i = 1;
                boolean z2 = LiveData.this.mActiveCount == 0;
                LiveData liveData = LiveData.this;
                int i2 = liveData.mActiveCount;
                if (!this.f163b) {
                    i = -1;
                }
                liveData.mActiveCount = i2 + i;
                if (z2 && this.f163b) {
                    LiveData.this.onActive();
                }
                LiveData liveData2 = LiveData.this;
                if (liveData2.mActiveCount == 0 && !this.f163b) {
                    liveData2.onInactive();
                }
                if (this.f163b) {
                    LiveData.this.dispatchingValue(this);
                }
            }
        }

        public void i() {
        }

        public boolean j(i iVar) {
            return false;
        }

        public abstract boolean k();
    }

    public LiveData() {
        this.mDataLock = new Object();
        this.mObservers = new b.c.a.b.b<>();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new a();
        this.mData = NOT_SET;
        this.mVersion = -1;
    }

    public LiveData(T t) {
        this.mDataLock = new Object();
        this.mObservers = new b.c.a.b.b<>();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new a();
        this.mData = t;
        this.mVersion = 0;
    }

    public static void assertMainThread(String str) {
        if (!b.c.a.a.a.d().b()) {
            throw new IllegalStateException(c.a.a.a.a.p("Cannot invoke ", str, " on a background thread"));
        }
    }

    private void considerNotify(LiveData<T>.c cVar) {
        if (cVar.f163b) {
            if (!cVar.k()) {
                cVar.h(false);
                return;
            }
            int i = cVar.f164c;
            int i2 = this.mVersion;
            if (i < i2) {
                cVar.f164c = i2;
                cVar.f162a.a((Object) this.mData);
            }
        }
    }

    public void dispatchingValue(LiveData<T>.c cVar) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (cVar == null) {
                b.c.a.b.b<K, V>.d c2 = this.mObservers.c();
                while (c2.hasNext()) {
                    considerNotify((c) ((Map.Entry) c2.next()).getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            } else {
                considerNotify(cVar);
                cVar = null;
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public T getValue() {
        T t = (T) this.mData;
        if (t != NOT_SET) {
            return t;
        }
        return null;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    public boolean hasObservers() {
        return this.mObservers.f778e > 0;
    }

    public void observe(i iVar, q<? super T> qVar) {
        assertMainThread("observe");
        if (((j) iVar.getLifecycle()).f1392b != f.b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(iVar, qVar);
            LiveData<T>.c h = this.mObservers.h(qVar, lifecycleBoundObserver);
            if (h != null && !h.j(iVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (h == null) {
                iVar.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void observeForever(q<? super T> qVar) {
        assertMainThread("observeForever");
        b bVar = new b(this, qVar);
        LiveData<T>.c h = this.mObservers.h(qVar, bVar);
        if (h instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (h == null) {
            bVar.h(true);
        }
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    public void postValue(T t) {
        boolean z;
        synchronized (this.mDataLock) {
            z = this.mPendingData == NOT_SET;
            this.mPendingData = t;
        }
        if (z) {
            b.c.a.a.a.d().f769a.c(this.mPostValueRunnable);
        }
    }

    public void removeObserver(q<? super T> qVar) {
        assertMainThread("removeObserver");
        LiveData<T>.c j = this.mObservers.j(qVar);
        if (j != null) {
            j.i();
            j.h(false);
        }
    }

    public void removeObservers(i iVar) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<q<? super T>, LiveData<T>.c>> it = this.mObservers.iterator();
        while (true) {
            b.e eVar = (b.e) it;
            if (eVar.hasNext()) {
                Map.Entry entry = (Map.Entry) eVar.next();
                if (((c) entry.getValue()).j(iVar)) {
                    removeObserver((q) entry.getKey());
                }
            } else {
                return;
            }
        }
    }

    public void setValue(T t) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t;
        dispatchingValue(null);
    }
}
