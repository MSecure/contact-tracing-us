package com.google.common.base;

import com.google.common.base.JdkPattern;
import com.google.common.base.Splitter;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractIterator<T> implements Iterator<T> {
    public T next;
    public State state = State.NOT_READY;

    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009d, code lost:
        if (r7 != 1) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009f, code lost:
        r5 = r0.toSplit.length();
        r0.offset = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a7, code lost:
        if (r5 <= r4) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a9, code lost:
        r8 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b7, code lost:
        if (r0.trimmer.matches(r0.toSplit.charAt(r8)) == false) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b9, code lost:
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bb, code lost:
        r0.limit = r7 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00be, code lost:
        r0 = (T) r0.toSplit.subSequence(r4, r5).toString();
     */
    public final boolean hasNext() {
        T t;
        State state2 = State.FAILED;
        if (this.state != state2) {
            int ordinal = this.state.ordinal();
            if (ordinal == 0) {
                return true;
            }
            if (ordinal == 2) {
                return false;
            }
            State state3 = State.DONE;
            this.state = state2;
            Splitter.SplittingIterator splittingIterator = (Splitter.SplittingIterator) this;
            int i = splittingIterator.offset;
            while (true) {
                int i2 = splittingIterator.offset;
                if (i2 == -1) {
                    splittingIterator.state = state3;
                    t = null;
                    break;
                }
                Splitter.AnonymousClass3.AnonymousClass1 r7 = (Splitter.AnonymousClass3.AnonymousClass1) splittingIterator;
                int start = ((JdkPattern.JdkMatcher) r7.val$matcher).matcher.find(i2) ? ((JdkPattern.JdkMatcher) r7.val$matcher).matcher.start() : -1;
                if (start == -1) {
                    start = splittingIterator.toSplit.length();
                    splittingIterator.offset = -1;
                } else {
                    splittingIterator.offset = ((JdkPattern.JdkMatcher) r7.val$matcher).matcher.end();
                }
                int i3 = splittingIterator.offset;
                if (i3 == i) {
                    int i4 = i3 + 1;
                    splittingIterator.offset = i4;
                    if (i4 > splittingIterator.toSplit.length()) {
                        splittingIterator.offset = -1;
                    }
                } else {
                    while (i < start && splittingIterator.trimmer.matches(splittingIterator.toSplit.charAt(i))) {
                        i++;
                    }
                    while (start > i) {
                        int i5 = start - 1;
                        if (!splittingIterator.trimmer.matches(splittingIterator.toSplit.charAt(i5))) {
                            break;
                        }
                        start = i5;
                    }
                    if (!splittingIterator.omitEmptyStrings || i != start) {
                        int i6 = splittingIterator.limit;
                    } else {
                        i = splittingIterator.offset;
                    }
                }
            }
            this.next = t;
            if (this.state == state3) {
                return false;
            }
            this.state = State.READY;
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.state = State.NOT_READY;
            T t = this.next;
            this.next = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
