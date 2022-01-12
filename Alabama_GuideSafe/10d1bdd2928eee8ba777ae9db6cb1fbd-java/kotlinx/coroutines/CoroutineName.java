package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineName.kt */
public final class CoroutineName extends AbstractCoroutineContextElement {
    public static final Key Key = new Key(null);
    public final String name;

    /* compiled from: CoroutineName.kt */
    public static final class Key implements CoroutineContext.Key<CoroutineName> {
        public Key(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CoroutineName) && Intrinsics.areEqual(null, ((CoroutineName) obj).name);
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "CoroutineName(null)";
    }
}
