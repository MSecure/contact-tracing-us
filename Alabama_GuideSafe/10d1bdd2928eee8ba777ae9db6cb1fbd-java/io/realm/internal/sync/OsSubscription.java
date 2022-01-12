package io.realm.internal.sync;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.RealmChangeListener;
import io.realm.internal.KeepMember;
import io.realm.internal.NativeObject;
import io.realm.internal.ObserverPairList;
import io.realm.internal.OsResults;

@KeepMember
public class OsSubscription implements NativeObject {
    public static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    public final long nativePtr;
    public final ObserverPairList<SubscriptionObserverPair> observerPairs = new ObserverPairList<>();

    public static class Callback implements ObserverPairList.Callback<SubscriptionObserverPair> {
        public Callback(AnonymousClass1 r1) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.realm.internal.ObserverPairList$ObserverPair, java.lang.Object] */
        @Override // io.realm.internal.ObserverPairList.Callback
        public void onCalled(SubscriptionObserverPair subscriptionObserverPair, Object obj) {
            subscriptionObserverPair.listener.onChange((OsSubscription) obj);
        }
    }

    public static class SubscriptionObserverPair extends ObserverPairList.ObserverPair<OsSubscription, RealmChangeListener<OsSubscription>> {
        public SubscriptionObserverPair(OsSubscription osSubscription, RealmChangeListener<OsSubscription> realmChangeListener) {
            super(osSubscription, realmChangeListener);
        }
    }

    public enum SubscriptionState {
        ERROR(-1),
        CREATING(2),
        PENDING(0),
        COMPLETE(1),
        INVALIDATED(3);
        
        public final int val;

        /* access modifiers changed from: public */
        SubscriptionState(int i) {
            this.val = i;
        }
    }

    public OsSubscription(OsResults osResults, SubscriptionAction subscriptionAction) {
        this.nativePtr = nativeCreateOrUpdate(osResults.nativePtr, subscriptionAction.subscriptionName, subscriptionAction.timeToLiveMs, subscriptionAction.update);
    }

    public static native long nativeCreateOrUpdate(long j, String str, long j2, boolean z);

    public static native Object nativeGetError(long j);

    public static native long nativeGetFinalizerPtr();

    public static native int nativeGetState(long j);

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    @KeepMember
    private void notifyChangeListeners() {
        this.observerPairs.foreach(new Callback(null));
    }

    public void addChangeListener(RealmChangeListener<OsSubscription> realmChangeListener) {
        if (this.observerPairs.isEmpty()) {
            nativeStartListening(this.nativePtr);
        }
        this.observerPairs.add(new SubscriptionObserverPair(this, realmChangeListener));
    }

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    public SubscriptionState getState() {
        int nativeGetState = nativeGetState(this.nativePtr);
        SubscriptionState[] values = SubscriptionState.values();
        for (SubscriptionState subscriptionState : values) {
            if (subscriptionState.val == nativeGetState) {
                return subscriptionState;
            }
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline5("Unknown value: ", nativeGetState));
    }
}
