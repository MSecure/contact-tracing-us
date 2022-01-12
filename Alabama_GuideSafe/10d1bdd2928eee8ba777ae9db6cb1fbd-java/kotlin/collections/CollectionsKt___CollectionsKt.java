package kotlin.collections;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: _Collections.kt */
public class CollectionsKt___CollectionsKt extends CollectionsKt__ReversedViewsKt {
    public static final <T, C extends Collection<? super T>> C toCollection(Iterable<? extends T> iterable, C c) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    public static final <T> List<T> toMutableList(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    public static final <T> Set<T> toSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toSet");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return EmptySet.INSTANCE;
            }
            if (size != 1) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(MoreExecutors.mapCapacity(collection.size()));
                toCollection(iterable, linkedHashSet);
                return linkedHashSet;
            }
            return MoreExecutors.setOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        toCollection(iterable, linkedHashSet2);
        Intrinsics.checkNotNullParameter(linkedHashSet2, "$this$optimizeReadOnlySet");
        int size2 = linkedHashSet2.size();
        if (size2 == 0) {
            return EmptySet.INSTANCE;
        }
        if (size2 != 1) {
            return linkedHashSet2;
        }
        return MoreExecutors.setOf(linkedHashSet2.iterator().next());
    }
}
