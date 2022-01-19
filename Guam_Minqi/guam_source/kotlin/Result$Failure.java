package kotlin;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Result.kt */
public final class Result$Failure implements Serializable {
    public final Throwable exception;

    public Result$Failure(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "exception");
        this.exception = th;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Result$Failure) && Intrinsics.areEqual(this.exception, ((Result$Failure) obj).exception);
    }

    public int hashCode() {
        return this.exception.hashCode();
    }

    public String toString() {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Failure(");
        outline15.append(this.exception);
        outline15.append(')');
        return outline15.toString();
    }
}
