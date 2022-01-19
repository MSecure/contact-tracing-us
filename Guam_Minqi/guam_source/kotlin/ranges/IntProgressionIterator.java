package kotlin.ranges;

import kotlin.collections.IntIterator;

/* compiled from: ProgressionIterators.kt */
public final class IntProgressionIterator extends IntIterator {
    public final int finalElement;
    public boolean hasNext;
    public int next;
    public final int step;

    public IntProgressionIterator(int i, int i2, int i3) {
        this.step = i3;
        this.finalElement = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.hasNext = z;
        this.next = !z ? this.finalElement : i;
    }

    public boolean hasNext() {
        return this.hasNext;
    }
}
