package io.realm.internal;

import io.realm.ObjectChangeSet;
import io.realm.RealmFieldType;
import io.realm.RealmModel;
import io.realm.RealmObjectChangeListener;
import io.realm.exceptions.RealmException;
import io.realm.internal.ObserverPairList;

@Keep
public class OsObject implements NativeObject {
    public static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    public final long nativePtr;
    public ObserverPairList<ObjectObserverPair> observerPairs = new ObserverPairList<>();

    public static class Callback implements ObserverPairList.Callback<ObjectObserverPair> {
        public final String[] changedFields;

        public Callback(String[] strArr) {
            this.changedFields = strArr;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.realm.internal.ObserverPairList$ObserverPair, java.lang.Object] */
        @Override // io.realm.internal.ObserverPairList.Callback
        public void onCalled(ObjectObserverPair objectObserverPair, Object obj) {
            ObjectObserverPair objectObserverPair2 = objectObserverPair;
            RealmModel realmModel = (RealmModel) obj;
            boolean z = this.changedFields == null;
            objectObserverPair2.listener.onChange(realmModel, new OsObjectChangeSet(z ? new String[0] : this.changedFields, z));
        }
    }

    public static class ObjectObserverPair<T extends RealmModel> extends ObserverPairList.ObserverPair<T, RealmObjectChangeListener<T>> {
        public ObjectObserverPair(T t, RealmObjectChangeListener<T> realmObjectChangeListener) {
            super(t, realmObjectChangeListener);
        }
    }

    public static class OsObjectChangeSet implements ObjectChangeSet {
        public OsObjectChangeSet(String[] strArr, boolean z) {
        }
    }

    public OsObject(OsSharedRealm osSharedRealm, UncheckedRow uncheckedRow) {
        this.nativePtr = nativeCreate(osSharedRealm.getNativePtr(), uncheckedRow.nativePtr);
        osSharedRealm.context.addReference(this);
    }

    public static UncheckedRow create(Table table) {
        return new UncheckedRow(table.sharedRealm.context, table, nativeCreateNewObject(table.nativeTableRefPtr));
    }

    public static long createRow(Table table) {
        return nativeCreateRow(table.nativeTableRefPtr);
    }

    public static long createRowWithPrimaryKey(Table table, long j, Object obj) {
        long j2;
        RealmFieldType columnType = table.getColumnType(j);
        OsSharedRealm osSharedRealm = table.sharedRealm;
        if (columnType == RealmFieldType.STRING) {
            if (obj == null || (obj instanceof String)) {
                return nativeCreateRowWithStringPrimaryKey(osSharedRealm.getNativePtr(), table.nativeTableRefPtr, j, (String) obj);
            }
            throw new IllegalArgumentException("Primary key value is not a String: " + obj);
        } else if (columnType == RealmFieldType.INTEGER) {
            if (obj == null) {
                j2 = 0;
            } else {
                j2 = Long.parseLong(obj.toString());
            }
            return nativeCreateRowWithLongPrimaryKey(osSharedRealm.getNativePtr(), table.nativeTableRefPtr, j, j2, obj == null);
        } else {
            throw new RealmException("Cannot check for duplicate rows for unsupported primary key type: " + columnType);
        }
    }

    public static UncheckedRow createWithPrimaryKey(Table table, Object obj) {
        long j;
        long andVerifyPrimaryKeyColumnIndex = getAndVerifyPrimaryKeyColumnIndex(table);
        RealmFieldType columnType = table.getColumnType(andVerifyPrimaryKeyColumnIndex);
        OsSharedRealm osSharedRealm = table.sharedRealm;
        if (columnType == RealmFieldType.STRING) {
            if (obj == null || (obj instanceof String)) {
                return new UncheckedRow(osSharedRealm.context, table, nativeCreateNewObjectWithStringPrimaryKey(osSharedRealm.getNativePtr(), table.nativeTableRefPtr, andVerifyPrimaryKeyColumnIndex, (String) obj));
            }
            throw new IllegalArgumentException("Primary key value is not a String: " + obj);
        } else if (columnType == RealmFieldType.INTEGER) {
            if (obj == null) {
                j = 0;
            } else {
                j = Long.parseLong(obj.toString());
            }
            return new UncheckedRow(osSharedRealm.context, table, nativeCreateNewObjectWithLongPrimaryKey(osSharedRealm.getNativePtr(), table.nativeTableRefPtr, andVerifyPrimaryKeyColumnIndex, j, obj == null));
        } else {
            throw new RealmException("Cannot check for duplicate rows for unsupported primary key type: " + columnType);
        }
    }

    public static long getAndVerifyPrimaryKeyColumnIndex(Table table) {
        String primaryKeyForObject = OsObjectStore.getPrimaryKeyForObject(table.sharedRealm, table.getClassName());
        if (primaryKeyForObject != null) {
            return table.getColumnKey(primaryKeyForObject);
        }
        throw new IllegalStateException(table.getName() + " has no primary key defined.");
    }

    public static native long nativeCreate(long j, long j2);

    public static native long nativeCreateNewObject(long j);

    public static native long nativeCreateNewObjectWithLongPrimaryKey(long j, long j2, long j3, long j4, boolean z);

    public static native long nativeCreateNewObjectWithStringPrimaryKey(long j, long j2, long j3, String str);

    public static native long nativeCreateRow(long j);

    public static native long nativeCreateRowWithLongPrimaryKey(long j, long j2, long j3, long j4, boolean z);

    public static native long nativeCreateRowWithStringPrimaryKey(long j, long j2, long j3, String str);

    public static native long nativeGetFinalizerPtr();

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    private void notifyChangeListeners(String[] strArr) {
        this.observerPairs.foreach(new Callback(strArr));
    }

    public <T extends RealmModel> void addListener(T t, RealmObjectChangeListener<T> realmObjectChangeListener) {
        if (this.observerPairs.isEmpty()) {
            nativeStartListening(this.nativePtr);
        }
        this.observerPairs.add(new ObjectObserverPair(t, realmObjectChangeListener));
    }

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    public <T extends RealmModel> void removeListener(T t) {
        this.observerPairs.removeByObserver(t);
        if (this.observerPairs.isEmpty()) {
            nativeStopListening(this.nativePtr);
        }
    }

    public void setObserverPairs(ObserverPairList<ObjectObserverPair> observerPairList) {
        if (this.observerPairs.isEmpty()) {
            this.observerPairs = observerPairList;
            if (!observerPairList.isEmpty()) {
                nativeStartListening(this.nativePtr);
                return;
            }
            return;
        }
        throw new IllegalStateException("'observerPairs' is not empty. Listeners have been added before.");
    }

    public <T extends RealmModel> void removeListener(T t, RealmObjectChangeListener<T> realmObjectChangeListener) {
        this.observerPairs.remove(t, realmObjectChangeListener);
        if (this.observerPairs.isEmpty()) {
            nativeStopListening(this.nativePtr);
        }
    }
}
