package io.realm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.OrderedCollectionChangeSet;
import io.realm.internal.sync.OsSubscription;
import java.util.Arrays;

public class OsCollectionChangeSet implements OrderedCollectionChangeSet, NativeObject {
    public static long finalizerPtr = nativeGetFinalizerPtr();
    public final boolean firstAsyncCallback;
    public final boolean isPartialRealm;
    public final long nativePtr;
    public final OsSubscription subscription;

    public OsCollectionChangeSet(long j, boolean z, OsSubscription osSubscription, boolean z2) {
        this.nativePtr = j;
        this.firstAsyncCallback = z;
        this.subscription = osSubscription;
        this.isPartialRealm = z2;
        NativeContext.dummyContext.addReference(this);
    }

    public static native long nativeGetFinalizerPtr();

    public static native int[] nativeGetIndices(long j, int i);

    public static native int[] nativeGetRanges(long j, int i);

    public OrderedCollectionChangeSet.Range[] getChangeRanges() {
        return longArrayToRangeArray(nativeGetRanges(this.nativePtr, 2));
    }

    public OrderedCollectionChangeSet.Range[] getDeletionRanges() {
        return longArrayToRangeArray(nativeGetRanges(this.nativePtr, 0));
    }

    public Throwable getError() {
        OsSubscription osSubscription = this.subscription;
        if (osSubscription == null || osSubscription.getState() != OsSubscription.SubscriptionState.ERROR) {
            return null;
        }
        return (Throwable) OsSubscription.nativeGetError(this.subscription.nativePtr);
    }

    public OrderedCollectionChangeSet.Range[] getInsertionRanges() {
        return longArrayToRangeArray(nativeGetRanges(this.nativePtr, 1));
    }

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return finalizerPtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    public boolean isEmpty() {
        return this.nativePtr == 0;
    }

    public boolean isFirstAsyncCallback() {
        return this.firstAsyncCallback;
    }

    public boolean isRemoteDataLoaded() {
        if (!this.isPartialRealm) {
            return true;
        }
        OsSubscription osSubscription = this.subscription;
        if (osSubscription == null) {
            return false;
        }
        if (osSubscription.getState() == OsSubscription.SubscriptionState.COMPLETE) {
            return true;
        }
        return false;
    }

    public final OrderedCollectionChangeSet.Range[] longArrayToRangeArray(int[] iArr) {
        if (iArr == null) {
            return new OrderedCollectionChangeSet.Range[0];
        }
        int length = iArr.length / 2;
        OrderedCollectionChangeSet.Range[] rangeArr = new OrderedCollectionChangeSet.Range[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            rangeArr[i] = new OrderedCollectionChangeSet.Range(iArr[i2], iArr[i2 + 1]);
        }
        return rangeArr;
    }

    public String toString() {
        if (this.nativePtr == 0) {
            return "Change set is empty.";
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Deletion Ranges: ");
        outline17.append(Arrays.toString(getDeletionRanges()));
        outline17.append("\nInsertion Ranges: ");
        outline17.append(Arrays.toString(getInsertionRanges()));
        outline17.append("\nChange Ranges: ");
        outline17.append(Arrays.toString(getChangeRanges()));
        return outline17.toString();
    }
}
