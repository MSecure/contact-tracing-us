package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgressionIterator;

/* compiled from: Iterators.kt */
public abstract class IntIterator implements Iterator<Integer>, KMappedMarker {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public Integer next() {
        IntProgressionIterator intProgressionIterator = (IntProgressionIterator) this;
        int i = intProgressionIterator.next;
        if (i != intProgressionIterator.finalElement) {
            intProgressionIterator.next = intProgressionIterator.step + i;
        } else if (intProgressionIterator.hasNext) {
            intProgressionIterator.hasNext = false;
        } else {
            throw new NoSuchElementException();
        }
        return Integer.valueOf(i);
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
