package io.realm.internal;

import io.realm.OrderedCollectionChangeSet;
import io.realm.internal.sync.OsSubscription;

public class EmptyLoadChangeSet extends OsCollectionChangeSet {
    public static final OrderedCollectionChangeSet.Range[] NO_RANGE_CHANGES = new OrderedCollectionChangeSet.Range[0];

    public EmptyLoadChangeSet(OsSubscription osSubscription, boolean z, boolean z2) {
        super(0, z, osSubscription, z2);
    }

    @Override // io.realm.internal.OsCollectionChangeSet
    public OrderedCollectionChangeSet.Range[] getChangeRanges() {
        return NO_RANGE_CHANGES;
    }

    @Override // io.realm.internal.OsCollectionChangeSet
    public OrderedCollectionChangeSet.Range[] getDeletionRanges() {
        return NO_RANGE_CHANGES;
    }

    @Override // io.realm.internal.OsCollectionChangeSet
    public Throwable getError() {
        OsSubscription osSubscription = this.subscription;
        if (osSubscription == null || osSubscription.getState() != OsSubscription.SubscriptionState.ERROR) {
            return null;
        }
        return (Throwable) OsSubscription.nativeGetError(this.subscription.nativePtr);
    }

    @Override // io.realm.internal.OsCollectionChangeSet
    public OrderedCollectionChangeSet.Range[] getInsertionRanges() {
        return NO_RANGE_CHANGES;
    }

    @Override // io.realm.internal.OsCollectionChangeSet, io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return OsCollectionChangeSet.finalizerPtr;
    }

    @Override // io.realm.internal.OsCollectionChangeSet, io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    @Override // io.realm.internal.OsCollectionChangeSet
    public boolean isEmpty() {
        return this.subscription == null;
    }

    @Override // io.realm.internal.OsCollectionChangeSet
    public boolean isFirstAsyncCallback() {
        return this.firstAsyncCallback;
    }

    @Override // io.realm.internal.OsCollectionChangeSet
    public boolean isRemoteDataLoaded() {
        return super.isRemoteDataLoaded();
    }

    @Override // io.realm.internal.OsCollectionChangeSet
    public String toString() {
        return super.toString();
    }

    public EmptyLoadChangeSet(OsSubscription osSubscription, boolean z) {
        super(0, true, null, z);
    }
}
