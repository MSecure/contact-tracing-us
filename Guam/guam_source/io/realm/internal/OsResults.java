package io.realm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.OrderedRealmCollectionImpl;
import io.realm.internal.ObservableCollection;
import io.realm.internal.core.DescriptorOrdering;
import io.realm.internal.core.QueryDescriptor;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class OsResults implements NativeObject, ObservableCollection {
    public static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    public final NativeContext context;
    public boolean isSnapshot = false;
    public boolean loaded;
    public final long nativePtr;
    public final ObserverPairList<ObservableCollection.CollectionObserverPair> observerPairs = new ObserverPairList<>();
    public final OsSharedRealm sharedRealm;
    public final Table table;

    public static abstract class Iterator<T> implements java.util.Iterator<T> {
        public OsResults iteratorOsResults;
        public int pos = -1;

        public Iterator(OsResults osResults) {
            if (!osResults.sharedRealm.isClosed()) {
                this.iteratorOsResults = osResults;
                if (!osResults.isSnapshot) {
                    if (osResults.sharedRealm.isInTransaction()) {
                        this.iteratorOsResults = this.iteratorOsResults.createSnapshot();
                    } else {
                        this.iteratorOsResults.sharedRealm.addIterator(this);
                    }
                }
            } else {
                throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
            }
        }

        public void checkValid() {
            if (this.iteratorOsResults == null) {
                throw new ConcurrentModificationException("No outside changes to a Realm is allowed while iterating a living Realm collection.");
            }
        }

        public abstract T convertRowToObject(UncheckedRow uncheckedRow);

        public boolean hasNext() {
            checkValid();
            return ((long) (this.pos + 1)) < this.iteratorOsResults.size();
        }

        @Override // java.util.Iterator
        public T next() {
            checkValid();
            int i = this.pos + 1;
            this.pos = i;
            if (((long) i) < this.iteratorOsResults.size()) {
                int i2 = this.pos;
                OsResults osResults = this.iteratorOsResults;
                return convertRowToObject(osResults.table.getUncheckedRowByPointer(OsResults.nativeGetRow(osResults.nativePtr, i2)));
            }
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Cannot access index ");
            outline15.append(this.pos);
            outline15.append(" when size is ");
            outline15.append(this.iteratorOsResults.size());
            outline15.append(". Remember to check hasNext() before using next().");
            throw new NoSuchElementException(outline15.toString());
        }

        @Deprecated
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported by RealmResults iterators.");
        }
    }

    public static abstract class ListIterator<T> extends Iterator<T> implements java.util.ListIterator<T> {
        public ListIterator(OsResults osResults, int i) {
            super(osResults);
            if (i < 0 || ((long) i) > this.iteratorOsResults.size()) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Starting location must be a valid index: [0, ");
                outline15.append(this.iteratorOsResults.size() - 1);
                outline15.append("]. Yours was ");
                outline15.append(i);
                throw new IndexOutOfBoundsException(outline15.toString());
            }
            this.pos = i - 1;
        }

        @Override // java.util.ListIterator
        @Deprecated
        public void add(T t) {
            throw new UnsupportedOperationException("Adding an element is not supported. Use Realm.createObject() instead.");
        }

        public boolean hasPrevious() {
            checkValid();
            return this.pos >= 0;
        }

        public int nextIndex() {
            checkValid();
            return this.pos + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            checkValid();
            try {
                int i = this.pos;
                OsResults osResults = this.iteratorOsResults;
                UncheckedRow uncheckedRowByPointer = osResults.table.getUncheckedRowByPointer(OsResults.nativeGetRow(osResults.nativePtr, i));
                OrderedRealmCollectionImpl orderedRealmCollectionImpl = OrderedRealmCollectionImpl.this;
                this.pos--;
                return (T) orderedRealmCollectionImpl.realm.get(orderedRealmCollectionImpl.classSpec, orderedRealmCollectionImpl.className, uncheckedRowByPointer);
            } catch (IndexOutOfBoundsException unused) {
                throw new NoSuchElementException(GeneratedOutlineSupport.outline11(GeneratedOutlineSupport.outline15("Cannot access index less than zero. This was "), this.pos, ". Remember to check hasPrevious() before using previous()."));
            }
        }

        public int previousIndex() {
            checkValid();
            return this.pos;
        }

        @Override // java.util.ListIterator
        @Deprecated
        public void set(T t) {
            throw new UnsupportedOperationException("Replacing an element is not supported.");
        }
    }

    public enum Mode {
        EMPTY,
        TABLE,
        PRIMITIVE_LIST,
        QUERY,
        LINK_LIST,
        TABLEVIEW
    }

    public OsResults(OsSharedRealm osSharedRealm, Table table2, long j) {
        Mode mode;
        Mode mode2 = Mode.QUERY;
        boolean z = false;
        this.sharedRealm = osSharedRealm;
        NativeContext nativeContext = osSharedRealm.context;
        this.context = nativeContext;
        this.table = table2;
        this.nativePtr = j;
        nativeContext.addReference(this);
        byte nativeGetMode = nativeGetMode(this.nativePtr);
        if (nativeGetMode == 0) {
            mode = Mode.EMPTY;
        } else if (nativeGetMode == 1) {
            mode = Mode.TABLE;
        } else if (nativeGetMode == 2) {
            mode = Mode.PRIMITIVE_LIST;
        } else if (nativeGetMode == 3) {
            mode = mode2;
        } else if (nativeGetMode == 4) {
            mode = Mode.LINK_LIST;
        } else if (nativeGetMode == 5) {
            mode = Mode.TABLEVIEW;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline4("Invalid value: ", nativeGetMode));
        }
        this.loaded = mode != mode2 ? true : z;
    }

    public static OsResults createFromQuery(OsSharedRealm osSharedRealm, TableQuery tableQuery, DescriptorOrdering descriptorOrdering) {
        tableQuery.validateQuery();
        return new OsResults(osSharedRealm, tableQuery.table, nativeCreateResults(osSharedRealm.getNativePtr(), tableQuery.nativePtr, descriptorOrdering.nativePtr));
    }

    public static native Object nativeAggregate(long j, long j2, byte b);

    public static native void nativeClear(long j);

    public static native boolean nativeContains(long j, long j2);

    public static native long nativeCreateResults(long j, long j2, long j3);

    public static native long nativeCreateResultsFromBacklinks(long j, long j2, long j3, long j4);

    public static native long nativeCreateSnapshot(long j);

    public static native void nativeDelete(long j, long j2);

    public static native boolean nativeDeleteFirst(long j);

    public static native boolean nativeDeleteLast(long j);

    public static native long nativeDistinct(long j, QueryDescriptor queryDescriptor);

    public static native void nativeEvaluateQueryIfNeeded(long j, boolean z);

    public static native long nativeFirstRow(long j);

    public static native long nativeFreeze(long j, long j2);

    public static native long nativeGetFinalizerPtr();

    public static native byte nativeGetMode(long j);

    public static native long nativeGetRow(long j, int i);

    public static native long nativeIndexOf(long j, long j2);

    public static native boolean nativeIsValid(long j);

    public static native long nativeLastRow(long j);

    public static native void nativeSetBinary(long j, String str, byte[] bArr);

    public static native void nativeSetBoolean(long j, String str, boolean z);

    public static native void nativeSetDouble(long j, String str, double d);

    public static native void nativeSetFloat(long j, String str, float f);

    public static native void nativeSetInt(long j, String str, long j2);

    public static native void nativeSetList(long j, String str, long j2);

    public static native void nativeSetNull(long j, String str);

    public static native void nativeSetObject(long j, String str, long j2);

    public static native void nativeSetString(long j, String str, String str2);

    public static native void nativeSetTimestamp(long j, String str, long j2);

    public static native long nativeSize(long j);

    public static native long nativeSort(long j, QueryDescriptor queryDescriptor);

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    public static native long nativeWhere(long j);

    public static native String toJSON(long j, int i);

    public OsResults createSnapshot() {
        if (this.isSnapshot) {
            return this;
        }
        OsResults osResults = new OsResults(this.sharedRealm, this.table, nativeCreateSnapshot(this.nativePtr));
        osResults.isSnapshot = true;
        return osResults;
    }

    public UncheckedRow firstUncheckedRow() {
        long nativeFirstRow = nativeFirstRow(this.nativePtr);
        if (nativeFirstRow != 0) {
            return this.table.getUncheckedRowByPointer(nativeFirstRow);
        }
        return null;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    public UncheckedRow getUncheckedRow(int i) {
        return this.table.getUncheckedRowByPointer(nativeGetRow(this.nativePtr, i));
    }

    @Override // io.realm.internal.ObservableCollection
    public void notifyChangeListeners(long j) {
        OsCollectionChangeSet osCollectionChangeSet;
        if (j == 0) {
            osCollectionChangeSet = new EmptyLoadChangeSet(null, this.sharedRealm.isPartial());
        } else {
            osCollectionChangeSet = new OsCollectionChangeSet(j, !this.loaded, null, this.sharedRealm.isPartial());
        }
        if (!osCollectionChangeSet.isEmpty() || !this.loaded) {
            this.loaded = true;
            this.observerPairs.foreach(new ObservableCollection.Callback(osCollectionChangeSet));
        }
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }
}
