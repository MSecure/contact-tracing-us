package androidx.arch.core.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {
    public Entry<K, V> mEnd;
    public WeakHashMap<SupportRemove<K, V>, Boolean> mIterators = new WeakHashMap<>();
    public int mSize = 0;
    public Entry<K, V> mStart;

    public static class AscendingIterator<K, V> extends ListIterator<K, V> {
        public AscendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> backward(Entry<K, V> entry) {
            return entry.mPrevious;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> forward(Entry<K, V> entry) {
            return entry.mNext;
        }
    }

    public static class DescendingIterator<K, V> extends ListIterator<K, V> {
        public DescendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> backward(Entry<K, V> entry) {
            return entry.mNext;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> forward(Entry<K, V> entry) {
            return entry.mPrevious;
        }
    }

    public static class Entry<K, V> implements Map.Entry<K, V> {
        public final K mKey;
        public Entry<K, V> mNext;
        public Entry<K, V> mPrevious;
        public final V mValue;

        public Entry(K k, V v) {
            this.mKey = k;
            this.mValue = v;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.mKey.equals(entry.mKey) && this.mValue.equals(entry.mValue);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.mKey;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.mValue;
        }

        public int hashCode() {
            return this.mKey.hashCode() ^ this.mValue.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return ((Object) this.mKey) + "=" + ((Object) this.mValue);
        }
    }

    public class IteratorWithAdditions implements Iterator<Map.Entry<K, V>>, SupportRemove<K, V> {
        public boolean mBeforeStart = true;
        public Entry<K, V> mCurrent;

        public IteratorWithAdditions() {
        }

        public boolean hasNext() {
            if (this.mBeforeStart) {
                return SafeIterableMap.this.mStart != null;
            }
            Entry<K, V> entry = this.mCurrent;
            return (entry == null || entry.mNext == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.mBeforeStart) {
                this.mBeforeStart = false;
                this.mCurrent = SafeIterableMap.this.mStart;
            } else {
                Entry<K, V> entry = this.mCurrent;
                this.mCurrent = entry != null ? entry.mNext : null;
            }
            return this.mCurrent;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(Entry<K, V> entry) {
            Entry<K, V> entry2 = this.mCurrent;
            if (entry == entry2) {
                Entry<K, V> entry3 = entry2.mPrevious;
                this.mCurrent = entry3;
                this.mBeforeStart = entry3 == null;
            }
        }
    }

    public static abstract class ListIterator<K, V> implements Iterator<Map.Entry<K, V>>, SupportRemove<K, V> {
        public Entry<K, V> mExpectedEnd;
        public Entry<K, V> mNext;

        public ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            this.mExpectedEnd = entry2;
            this.mNext = entry;
        }

        public abstract Entry<K, V> backward(Entry<K, V> entry);

        public abstract Entry<K, V> forward(Entry<K, V> entry);

        public boolean hasNext() {
            return this.mNext != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            Entry<K, V> entry = this.mNext;
            Entry<K, V> entry2 = this.mExpectedEnd;
            this.mNext = (entry == entry2 || entry2 == null) ? null : forward(entry);
            return entry;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(Entry<K, V> entry) {
            Entry<K, V> entry2 = null;
            if (this.mExpectedEnd == entry && entry == this.mNext) {
                this.mNext = null;
                this.mExpectedEnd = null;
            }
            Entry<K, V> entry3 = this.mExpectedEnd;
            if (entry3 == entry) {
                this.mExpectedEnd = backward(entry3);
            }
            Entry<K, V> entry4 = this.mNext;
            if (entry4 == entry) {
                Entry<K, V> entry5 = this.mExpectedEnd;
                if (!(entry4 == entry5 || entry5 == null)) {
                    entry2 = forward(entry4);
                }
                this.mNext = entry2;
            }
        }
    }

    public interface SupportRemove<K, V> {
        void supportRemove(Entry<K, V> entry);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (r3.hasNext() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (((androidx.arch.core.internal.SafeIterableMap.ListIterator) r7).hasNext() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return true;
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (this.mSize != safeIterableMap.mSize) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = safeIterableMap.iterator();
        while (true) {
            ListIterator listIterator = (ListIterator) it;
            if (!listIterator.hasNext()) {
                break;
            }
            ListIterator listIterator2 = (ListIterator) it2;
            if (!listIterator2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) listIterator.next();
            Object next = listIterator2.next();
            if ((entry != null || next == null) && (entry == null || entry.equals(next))) {
            }
        }
        return false;
    }

    public Entry<K, V> get(K k) {
        Entry<K, V> entry = this.mStart;
        while (entry != null && !entry.mKey.equals(k)) {
            entry = entry.mNext;
        }
        return entry;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (true) {
            ListIterator listIterator = (ListIterator) it;
            if (!listIterator.hasNext()) {
                return i;
            }
            i += ((Map.Entry) listIterator.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions() {
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions();
        this.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
        return iteratorWithAdditions;
    }

    public Entry<K, V> put(K k, V v) {
        Entry<K, V> entry = new Entry<>(k, v);
        this.mSize++;
        Entry<K, V> entry2 = this.mEnd;
        if (entry2 == null) {
            this.mStart = entry;
            this.mEnd = entry;
            return entry;
        }
        entry2.mNext = entry;
        entry.mPrevious = entry2;
        this.mEnd = entry;
        return entry;
    }

    public V putIfAbsent(K k, V v) {
        Entry<K, V> entry = get(k);
        if (entry != null) {
            return entry.mValue;
        }
        put(k, v);
        return null;
    }

    public V remove(K k) {
        Entry<K, V> entry = get(k);
        if (entry == null) {
            return null;
        }
        this.mSize--;
        if (!this.mIterators.isEmpty()) {
            for (SupportRemove<K, V> supportRemove : this.mIterators.keySet()) {
                supportRemove.supportRemove(entry);
            }
        }
        Entry<K, V> entry2 = entry.mPrevious;
        if (entry2 != null) {
            entry2.mNext = entry.mNext;
        } else {
            this.mStart = entry.mNext;
        }
        Entry<K, V> entry3 = entry.mNext;
        if (entry3 != null) {
            entry3.mPrevious = entry.mPrevious;
        } else {
            this.mEnd = entry.mPrevious;
        }
        entry.mNext = null;
        entry.mPrevious = null;
        return entry.mValue;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (true) {
            ListIterator listIterator = (ListIterator) it;
            if (listIterator.hasNext()) {
                outline17.append(((Map.Entry) listIterator.next()).toString());
                if (listIterator.hasNext()) {
                    outline17.append(", ");
                }
            } else {
                outline17.append("]");
                return outline17.toString();
            }
        }
    }
}
