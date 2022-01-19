package com.google.android.gms.internal.nearby;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public abstract class zznw<E> extends AbstractCollection<E> implements Serializable {
    public static final Object[] zza = new Object[0];

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return (zzoj) ((zznx) this).listIterator();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(zza);
    }

    public int zza(Object[] objArr, int i) {
        zzok zzok = (zzok) iterator();
        while (zzok.hasNext()) {
            objArr[i] = zzok.next();
            i++;
        }
        return i;
    }

    public Object[] zzb() {
        return null;
    }

    public int zzc() {
        throw new UnsupportedOperationException();
    }

    public int zzd() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean zzf();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        if (tArr != null) {
            int size = size();
            if (tArr.length < size) {
                Object[] zzb = zzb();
                if (zzb != null) {
                    return (T[]) Arrays.copyOfRange(zzb, zzc(), zzd(), tArr.getClass());
                }
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            } else if (tArr.length > size) {
                tArr[size] = null;
            }
            zza(tArr, 0);
            return tArr;
        }
        throw null;
    }
}
