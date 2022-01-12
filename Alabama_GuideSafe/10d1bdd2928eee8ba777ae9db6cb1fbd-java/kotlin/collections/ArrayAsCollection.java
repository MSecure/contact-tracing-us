package kotlin.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Collections.kt */
public final class ArrayAsCollection<T> implements Collection<T>, KMappedMarker {
    public final boolean isVarargs;
    public final T[] values;

    public ArrayAsCollection(T[] tArr, boolean z) {
        Intrinsics.checkNotNullParameter(tArr, "values");
        this.values = tArr;
        this.isVarargs = z;
    }

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    public boolean contains(Object obj) {
        int i;
        T[] tArr = this.values;
        Intrinsics.checkNotNullParameter(tArr, "$this$contains");
        Intrinsics.checkNotNullParameter(tArr, "$this$indexOf");
        if (obj != null) {
            int length = tArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (Intrinsics.areEqual(obj, tArr[i2])) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            int length2 = tArr.length;
            i = 0;
            while (true) {
                if (i >= length2) {
                    break;
                } else if (tArr[i] == null) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return true;
            }
            return false;
        }
        i = -1;
        if (i < 0) {
        }
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.values.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        T[] tArr = this.values;
        Intrinsics.checkNotNullParameter(tArr, "array");
        return new ArrayIterator(tArr);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return this.values.length;
    }

    public final Object[] toArray() {
        Object[] objArr = this.values;
        boolean z = this.isVarargs;
        Intrinsics.checkNotNullParameter(objArr, "$this$copyToArrayOfAny");
        if (!z || !Intrinsics.areEqual(objArr.getClass(), Object[].class)) {
            objArr = Arrays.copyOf(objArr, objArr.length, Object[].class);
        }
        Intrinsics.checkNotNullExpressionValue(objArr, "if (isVarargs && this.ja… Array<Any?>::class.java)");
        return objArr;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }
}
