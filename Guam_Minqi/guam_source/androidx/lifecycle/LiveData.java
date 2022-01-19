package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Map;

public abstract class LiveData<T> {
    public static final Object NOT_SET = new Object();
    public int mActiveCount = 0;
    public volatile Object mData = NOT_SET;
    public final Object mDataLock = new Object();
    public boolean mDispatchInvalidated;
    public boolean mDispatchingValue;
    public SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> mObservers = new SafeIterableMap<>();
    public volatile Object mPendingData = NOT_SET;
    public final Runnable mPostValueRunnable = new Runnable() {
        /* class androidx.lifecycle.LiveData.AnonymousClass1 */

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
    };
    public int mVersion = -1;

    public class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {
        public final LifecycleOwner mOwner;
        public final /* synthetic */ LiveData this$0;

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (((LifecycleRegistry) this.mOwner.getLifecycle()).mState == Lifecycle.State.DESTROYED) {
                this.this$0.removeObserver(this.mObserver);
            } else {
                activeStateChanged(shouldBeActive());
            }
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            return ((LifecycleRegistry) this.mOwner.getLifecycle()).mState.compareTo(Lifecycle.State.STARTED) >= 0;
        }
    }

    public abstract class ObserverWrapper {
        public boolean mActive;
        public int mLastVersion;
        public final Observer<? super T> mObserver;
        public final /* synthetic */ LiveData this$0;

        public void activeStateChanged(boolean z) {
            if (z != this.mActive) {
                this.mActive = z;
                int i = 1;
                boolean z2 = this.this$0.mActiveCount == 0;
                LiveData liveData = this.this$0;
                int i2 = liveData.mActiveCount;
                if (!this.mActive) {
                    i = -1;
                }
                liveData.mActiveCount = i2 + i;
                if (z2 && this.mActive) {
                    this.this$0.onActive();
                }
                LiveData liveData2 = this.this$0;
                if (liveData2.mActiveCount == 0 && !this.mActive) {
                    liveData2.onInactive();
                }
                if (this.mActive) {
                    this.this$0.dispatchingValue(this);
                }
            }
        }

        public abstract boolean shouldBeActive();
    }

    public static void assertMainThread(String str) {
        if (!ArchTaskExecutor.getInstance().mDelegate.isMainThread()) {
            throw new IllegalStateException(GeneratedOutlineSupport.outline9("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void considerNotify(LiveData<T>.ObserverWrapper observerWrapper) {
        if (observerWrapper.mActive) {
            if (!observerWrapper.shouldBeActive()) {
                observerWrapper.activeStateChanged(false);
                return;
            }
            int i = observerWrapper.mLastVersion;
            int i2 = this.mVersion;
            if (i < i2) {
                observerWrapper.mLastVersion = i2;
                observerWrapper.mObserver.onChanged((Object) this.mData);
            }
        }
    }

    public void dispatchingValue(LiveData<T>.ObserverWrapper observerWrapper) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (observerWrapper == null) {
                SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = this.mObservers.iteratorWithAdditions();
                while (iteratorWithAdditions.hasNext()) {
                    considerNotify((ObserverWrapper) ((Map.Entry) iteratorWithAdditions.next()).getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            } else {
                considerNotify(observerWrapper);
                observerWrapper = null;
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    public void removeObserver(Observer<? super T> observer) {
        assertMainThread("removeObserver");
        LiveData<T>.ObserverWrapper remove = this.mObservers.remove(observer);
        if (remove != null) {
            LifecycleBoundObserver lifecycleBoundObserver = (LifecycleBoundObserver) remove;
            ((LifecycleRegistry) lifecycleBoundObserver.mOwner.getLifecycle()).mObserverMap.remove(lifecycleBoundObserver);
            remove.activeStateChanged(false);
        }
    }

    public abstract void setValue(T t);
}
