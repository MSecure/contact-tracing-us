package com.google.android.gms.internal.nearby;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public abstract class zzlh<E> extends zzli<E> implements List<E>, RandomAccess {
    private static final zzln<Object> zza = new zzlk(zzlm.zza, 0);

    public static <E> zzlh<E> zza() {
        return (zzlh<E>) zzlm.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzli
    public final zzlh<E> zzc() {
        return this;
    }

    public static <E> zzlh<E> zza(Collection<? extends E> collection) {
        if (collection instanceof zzli) {
            zzlh<E> zzc = ((zzli) collection).zzc();
            if (!zzc.zzg()) {
                return zzc;
            }
            Object[] array = zzc.toArray();
            int length = array.length;
            return length == 0 ? (zzlh<E>) zzlm.zza : new zzlm(array, length);
        }
        Object[] array2 = collection.toArray();
        int length2 = array2.length;
        for (int i = 0; i < length2; i++) {
            if (array2[i] == null) {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i);
                throw new NullPointerException(sb.toString());
            }
        }
        int length3 = array2.length;
        return length3 == 0 ? (zzlh<E>) zzlm.zza : new zzlm(array2, length3);
    }

    static <E> zzlh<E> zza(Object[] objArr) {
        int length = objArr.length;
        return length == 0 ? (zzlh<E>) zzlm.zza : new zzlm(objArr, length);
    }

    zzlh() {
    }

    @Override // com.google.android.gms.internal.nearby.zzli
    public final zzll<E> zzb() {
        return (zzln) listIterator();
    }

    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            int size = size();
            int i = 0;
            if (obj == null) {
                while (i < size) {
                    if (get(i) == null) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < size) {
                    if (obj.equals(get(i))) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }
        ListIterator<E> listIterator = listIterator();
        while (listIterator.hasNext()) {
            if (zzle.zza(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            if (obj == null) {
                for (int size = size() - 1; size >= 0; size--) {
                    if (get(size) == null) {
                        return size;
                    }
                }
            } else {
                for (int size2 = size() - 1; size2 >= 0; size2--) {
                    if (obj.equals(get(size2))) {
                        return size2;
                    }
                }
            }
            return -1;
        }
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (zzle.zza(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    /* renamed from: zza */
    public zzlh<E> subList(int i, int i2) {
        zzld.zza(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? (zzlh<E>) zzlm.zza : new zzlj(this, i, i3);
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zzli
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzld.zza(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (!(this instanceof RandomAccess) || !(list instanceof RandomAccess)) {
                    zzlh<E> zzlh = this;
                    int size2 = zzlh.size();
                    Iterator<E> it = list.iterator();
                    int i = 0;
                    while (true) {
                        if (i < size2) {
                            if (!it.hasNext()) {
                                break;
                            }
                            E e = zzlh.get(i);
                            i++;
                            if (!zzle.zza(e, it.next())) {
                                break;
                            }
                        } else if (!it.hasNext()) {
                            return true;
                        }
                    }
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        if (zzle.zza(get(i2), list.get(i2))) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.nearby.zzli, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i) {
        zzld.zzb(i, size());
        if (isEmpty()) {
            return zza;
        }
        return new zzlk(this, i);
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (zzln) listIterator(0);
    }
}
