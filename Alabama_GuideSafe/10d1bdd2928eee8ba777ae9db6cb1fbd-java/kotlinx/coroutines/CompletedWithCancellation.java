package kotlinx.coroutines;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompletionState.kt */
public final class CompletedWithCancellation {
    public final Function1<Throwable, Unit> onCancellation;
    public final Object result;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public CompletedWithCancellation(Object obj, Function1<? super Throwable, Unit> function1) {
        this.result = obj;
        this.onCancellation = function1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedWithCancellation)) {
            return false;
        }
        CompletedWithCancellation completedWithCancellation = (CompletedWithCancellation) obj;
        return Intrinsics.areEqual(this.result, completedWithCancellation.result) && Intrinsics.areEqual(this.onCancellation, completedWithCancellation.onCancellation);
    }

    public int hashCode() {
        Object obj = this.result;
        int i = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Function1<Throwable, Unit> function1 = this.onCancellation;
        if (function1 != null) {
            i = function1.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("CompletedWithCancellation(result=");
        outline17.append(this.result);
        outline17.append(", onCancellation=");
        outline17.append(this.onCancellation);
        outline17.append(")");
        return outline17.toString();
    }
}
