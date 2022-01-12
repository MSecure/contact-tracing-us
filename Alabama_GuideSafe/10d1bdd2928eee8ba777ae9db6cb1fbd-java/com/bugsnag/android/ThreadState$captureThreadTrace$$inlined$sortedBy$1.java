package com.bugsnag.android;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
public final class ThreadState$captureThreadTrace$$inlined$sortedBy$1<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return MoreExecutors.compareValues(Long.valueOf(t.getId()), Long.valueOf(t2.getId()));
    }
}
