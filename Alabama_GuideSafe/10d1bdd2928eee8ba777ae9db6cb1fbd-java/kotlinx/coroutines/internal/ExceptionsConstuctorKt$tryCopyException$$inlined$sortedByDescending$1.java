package kotlinx.coroutines.internal;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
public final class ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return MoreExecutors.compareValues(Integer.valueOf(t2.getParameterTypes().length), Integer.valueOf(t.getParameterTypes().length));
    }
}
