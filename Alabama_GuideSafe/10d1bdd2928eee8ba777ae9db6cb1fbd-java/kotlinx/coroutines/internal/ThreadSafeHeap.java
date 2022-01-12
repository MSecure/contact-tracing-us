package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* compiled from: ThreadSafeHeap.kt */
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    public volatile int _size = 0;
    public T[] a;

    public final void addImpl(T t) {
        if (DebugKt.ASSERTIONS_ENABLED) {
            if (!(t.getHeap() == null)) {
                throw new AssertionError();
            }
        }
        t.setHeap(this);
        T[] tArr = this.a;
        if (tArr == null) {
            tArr = (T[]) new ThreadSafeHeapNode[4];
            this.a = tArr;
        } else if (this._size >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, this._size * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            tArr = (T[]) ((ThreadSafeHeapNode[]) copyOf);
            this.a = tArr;
        }
        int i = this._size;
        this._size = i + 1;
        tArr[i] = t;
        t.setIndex(i);
        siftUpFrom(i);
    }

    public final T firstImpl() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final T removeAtImpl(int i) {
        boolean z = true;
        if (DebugKt.ASSERTIONS_ENABLED) {
            if (!(this._size > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        this._size--;
        if (i < this._size) {
            swap(i, this._size);
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                Intrinsics.checkNotNull(t);
                T t2 = tArr[i2];
                Intrinsics.checkNotNull(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    swap(i, i2);
                    siftUpFrom(i2);
                }
            }
            while (true) {
                int i3 = (i * 2) + 1;
                if (i3 >= this._size) {
                    break;
                }
                T[] tArr2 = this.a;
                Intrinsics.checkNotNull(tArr2);
                int i4 = i3 + 1;
                if (i4 < this._size) {
                    T t3 = tArr2[i4];
                    Intrinsics.checkNotNull(t3);
                    T t4 = tArr2[i3];
                    Intrinsics.checkNotNull(t4);
                    if (((Comparable) t3).compareTo(t4) < 0) {
                        i3 = i4;
                    }
                }
                T t5 = tArr2[i];
                Intrinsics.checkNotNull(t5);
                T t6 = tArr2[i3];
                Intrinsics.checkNotNull(t6);
                if (((Comparable) t5).compareTo(t6) <= 0) {
                    break;
                }
                swap(i, i3);
                i = i3;
            }
        }
        T t7 = tArr[this._size];
        Intrinsics.checkNotNull(t7);
        if (DebugKt.ASSERTIONS_ENABLED) {
            if (t7.getHeap() != this) {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        t7.setHeap(null);
        t7.setIndex(-1);
        tArr[this._size] = null;
        return t7;
    }

    public final void siftUpFrom(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            Intrinsics.checkNotNull(t);
            T t2 = tArr[i];
            Intrinsics.checkNotNull(t2);
            if (((Comparable) t).compareTo(t2) > 0) {
                swap(i, i2);
                i = i2;
            } else {
                return;
            }
        }
    }

    public final void swap(int i, int i2) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        T t = tArr[i2];
        Intrinsics.checkNotNull(t);
        T t2 = tArr[i];
        Intrinsics.checkNotNull(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.setIndex(i);
        t2.setIndex(i2);
    }
}
