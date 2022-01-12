package kotlin;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Result.kt */
public final class Result<T> implements Serializable {

    /* compiled from: Result.kt */
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "exception");
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && Intrinsics.areEqual(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Failure(");
            outline17.append(this.exception);
            outline17.append(')');
            return outline17.toString();
        }
    }

    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m10exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }
}
