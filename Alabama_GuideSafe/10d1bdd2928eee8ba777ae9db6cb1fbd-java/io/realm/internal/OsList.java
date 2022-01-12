package io.realm.internal;

import io.realm.internal.ObservableCollection;

public class OsList implements NativeObject, ObservableCollection {
    public static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    public final NativeContext context;
    public final long nativePtr;
    public final ObserverPairList<ObservableCollection.CollectionObserverPair> observerPairs = new ObserverPairList<>();
    public final Table targetTable;

    public OsList(UncheckedRow uncheckedRow, long j) {
        OsSharedRealm osSharedRealm = uncheckedRow.parent.sharedRealm;
        long[] nativeCreate = nativeCreate(osSharedRealm.getNativePtr(), uncheckedRow.nativePtr, j);
        this.nativePtr = nativeCreate[0];
        NativeContext nativeContext = osSharedRealm.context;
        this.context = nativeContext;
        nativeContext.addReference(this);
        if (nativeCreate[1] != 0) {
            this.targetTable = new Table(osSharedRealm, nativeCreate[1]);
        } else {
            this.targetTable = null;
        }
    }

    public static native void nativeAddBinary(long j, byte[] bArr);

    public static native void nativeAddBoolean(long j, boolean z);

    public static native void nativeAddDate(long j, long j2);

    public static native void nativeAddDouble(long j, double d);

    public static native void nativeAddFloat(long j, float f);

    public static native void nativeAddLong(long j, long j2);

    public static native void nativeAddNull(long j);

    public static native void nativeAddRow(long j, long j2);

    public static native void nativeAddString(long j, String str);

    public static native long[] nativeCreate(long j, long j2, long j3);

    public static native void nativeDelete(long j, long j2);

    public static native void nativeDeleteAll(long j);

    public static native long nativeFreeze(long j, long j2);

    public static native long nativeGetFinalizerPtr();

    public static native long nativeGetQuery(long j);

    public static native long nativeGetRow(long j, long j2);

    public static native Object nativeGetValue(long j, long j2);

    public static native void nativeInsertBinary(long j, long j2, byte[] bArr);

    public static native void nativeInsertBoolean(long j, long j2, boolean z);

    public static native void nativeInsertDate(long j, long j2, long j3);

    public static native void nativeInsertDouble(long j, long j2, double d);

    public static native void nativeInsertFloat(long j, long j2, float f);

    public static native void nativeInsertLong(long j, long j2, long j3);

    public static native void nativeInsertNull(long j, long j2);

    public static native void nativeInsertRow(long j, long j2, long j3);

    public static native void nativeInsertString(long j, long j2, String str);

    public static native boolean nativeIsValid(long j);

    public static native void nativeMove(long j, long j2, long j3);

    public static native void nativeRemove(long j, long j2);

    public static native void nativeRemoveAll(long j);

    public static native void nativeSetBinary(long j, long j2, byte[] bArr);

    public static native void nativeSetBoolean(long j, long j2, boolean z);

    public static native void nativeSetDate(long j, long j2, long j3);

    public static native void nativeSetDouble(long j, long j2, double d);

    public static native void nativeSetFloat(long j, long j2, float f);

    public static native void nativeSetLong(long j, long j2, long j3);

    public static native void nativeSetNull(long j, long j2);

    public static native void nativeSetRow(long j, long j2, long j3);

    public static native void nativeSetString(long j, long j2, String str);

    public static native long nativeSize(long j);

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    public Object getValue(long j) {
        return nativeGetValue(this.nativePtr, j);
    }

    @Override // io.realm.internal.ObservableCollection
    public void notifyChangeListeners(long j) {
        OsCollectionChangeSet osCollectionChangeSet = new OsCollectionChangeSet(j, false, null, false);
        if (!osCollectionChangeSet.isEmpty()) {
            this.observerPairs.foreach(new ObservableCollection.Callback(osCollectionChangeSet));
        }
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }
}
