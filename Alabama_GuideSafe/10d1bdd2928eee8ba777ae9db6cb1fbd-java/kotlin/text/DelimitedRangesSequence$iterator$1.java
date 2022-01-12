package kotlin.text;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;

/* compiled from: Strings.kt */
public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker {
    public int counter;
    public int currentStartIndex;
    public IntRange nextItem;
    public int nextSearchIndex;
    public int nextState = -1;
    public final /* synthetic */ DelimitedRangesSequence this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public DelimitedRangesSequence$iterator$1(DelimitedRangesSequence delimitedRangesSequence) {
        this.this$0 = delimitedRangesSequence;
        int coerceIn = MoreExecutors.coerceIn(delimitedRangesSequence.startIndex, 0, delimitedRangesSequence.input.length());
        this.currentStartIndex = coerceIn;
        this.nextSearchIndex = coerceIn;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (r4 < r0) goto L_0x001b;
     */
    public final void calcNext() {
        IntRange intRange;
        int i = 0;
        if (this.nextSearchIndex < 0) {
            this.nextState = 0;
            this.nextItem = null;
            return;
        }
        int i2 = this.this$0.limit;
        if (i2 > 0) {
            int i3 = this.counter + 1;
            this.counter = i3;
        }
        if (this.nextSearchIndex <= this.this$0.input.length()) {
            DelimitedRangesSequence delimitedRangesSequence = this.this$0;
            Pair<Integer, Integer> invoke = delimitedRangesSequence.getNextMatch.invoke(delimitedRangesSequence.input, Integer.valueOf(this.nextSearchIndex));
            if (invoke == null) {
                this.nextItem = new IntRange(this.currentStartIndex, StringsKt__StringNumberConversionsKt.getLastIndex(this.this$0.input));
                this.nextSearchIndex = -1;
            } else {
                int intValue = invoke.first.intValue();
                int intValue2 = invoke.second.intValue();
                int i4 = this.currentStartIndex;
                if (intValue <= Integer.MIN_VALUE) {
                    IntRange intRange2 = IntRange.Companion;
                    intRange = IntRange.EMPTY;
                } else {
                    intRange = new IntRange(i4, intValue - 1);
                }
                this.nextItem = intRange;
                int i5 = intValue + intValue2;
                this.currentStartIndex = i5;
                if (intValue2 == 0) {
                    i = 1;
                }
                this.nextSearchIndex = i5 + i;
            }
            this.nextState = 1;
        }
        this.nextItem = new IntRange(this.currentStartIndex, StringsKt__StringNumberConversionsKt.getLastIndex(this.this$0.input));
        this.nextSearchIndex = -1;
        this.nextState = 1;
    }

    public boolean hasNext() {
        if (this.nextState == -1) {
            calcNext();
        }
        return this.nextState == 1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public IntRange next() {
        if (this.nextState == -1) {
            calcNext();
        }
        if (this.nextState != 0) {
            IntRange intRange = this.nextItem;
            if (intRange != null) {
                this.nextItem = null;
                this.nextState = -1;
                return intRange;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
