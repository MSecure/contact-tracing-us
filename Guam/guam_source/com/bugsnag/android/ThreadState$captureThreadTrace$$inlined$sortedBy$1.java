package com.bugsnag.android;

import java.util.Comparator;

/* compiled from: Comparisons.kt */
public final class ThreadState$captureThreadTrace$$inlined$sortedBy$1<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Long valueOf = Long.valueOf(t.getId());
        Long valueOf2 = Long.valueOf(t2.getId());
        if (valueOf == valueOf2) {
            return 0;
        }
        if (valueOf == null) {
            return -1;
        }
        if (valueOf2 == null) {
            return 1;
        }
        return valueOf.compareTo((Object) valueOf2);
    }
}
