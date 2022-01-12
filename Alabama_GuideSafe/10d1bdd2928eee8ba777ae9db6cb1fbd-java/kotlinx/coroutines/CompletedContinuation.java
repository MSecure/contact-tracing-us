package kotlinx.coroutines;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CancellableContinuationImpl.kt */
public final class CompletedContinuation {
    public final Throwable cancelCause;
    public final CancelHandler cancelHandler;
    public final Object idempotentResume;
    public final Function1<Throwable, Unit> onCancellation;
    public final Object result;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public CompletedContinuation(Object obj, CancelHandler cancelHandler2, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        this.result = obj;
        this.cancelHandler = cancelHandler2;
        this.onCancellation = function1;
        this.idempotentResume = obj2;
        this.cancelCause = th;
    }

    public static CompletedContinuation copy$default(CompletedContinuation completedContinuation, Object obj, CancelHandler cancelHandler2, Function1 function1, Object obj2, Throwable th, int i) {
        Object obj3 = (i & 1) != 0 ? completedContinuation.result : null;
        if ((i & 2) != 0) {
            cancelHandler2 = completedContinuation.cancelHandler;
        }
        Function1<Throwable, Unit> function12 = (i & 4) != 0 ? completedContinuation.onCancellation : null;
        Object obj4 = (i & 8) != 0 ? completedContinuation.idempotentResume : null;
        if ((i & 16) != 0) {
            th = completedContinuation.cancelCause;
        }
        if (completedContinuation != null) {
            return new CompletedContinuation(obj3, cancelHandler2, function12, obj4, th);
        }
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) obj;
        return Intrinsics.areEqual(this.result, completedContinuation.result) && Intrinsics.areEqual(this.cancelHandler, completedContinuation.cancelHandler) && Intrinsics.areEqual(this.onCancellation, completedContinuation.onCancellation) && Intrinsics.areEqual(this.idempotentResume, completedContinuation.idempotentResume) && Intrinsics.areEqual(this.cancelCause, completedContinuation.cancelCause);
    }

    public int hashCode() {
        Object obj = this.result;
        int i = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        CancelHandler cancelHandler2 = this.cancelHandler;
        int hashCode2 = (hashCode + (cancelHandler2 != null ? cancelHandler2.hashCode() : 0)) * 31;
        Function1<Throwable, Unit> function1 = this.onCancellation;
        int hashCode3 = (hashCode2 + (function1 != null ? function1.hashCode() : 0)) * 31;
        Object obj2 = this.idempotentResume;
        int hashCode4 = (hashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Throwable th = this.cancelCause;
        if (th != null) {
            i = th.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("CompletedContinuation(result=");
        outline17.append(this.result);
        outline17.append(", cancelHandler=");
        outline17.append(this.cancelHandler);
        outline17.append(", onCancellation=");
        outline17.append(this.onCancellation);
        outline17.append(", idempotentResume=");
        outline17.append(this.idempotentResume);
        outline17.append(", cancelCause=");
        outline17.append(this.cancelCause);
        outline17.append(")");
        return outline17.toString();
    }

    public CompletedContinuation(Object obj, CancelHandler cancelHandler2, Function1 function1, Object obj2, Throwable th, int i) {
        cancelHandler2 = (i & 2) != 0 ? null : cancelHandler2;
        function1 = (i & 4) != 0 ? null : function1;
        obj2 = (i & 8) != 0 ? null : obj2;
        th = (i & 16) != 0 ? null : th;
        this.result = obj;
        this.cancelHandler = cancelHandler2;
        this.onCancellation = function1;
        this.idempotentResume = obj2;
        this.cancelCause = th;
    }
}
