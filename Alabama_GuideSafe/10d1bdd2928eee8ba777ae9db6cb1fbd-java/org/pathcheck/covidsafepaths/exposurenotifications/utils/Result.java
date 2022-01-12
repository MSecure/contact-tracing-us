package org.pathcheck.covidsafepaths.exposurenotifications.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Result.kt */
public abstract class Result<R> {

    /* compiled from: Result.kt */
    public static final class Failure extends Result {
        public final Error error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failure(Error error2) {
            super(null);
            Intrinsics.checkNotNullParameter(error2, "error");
            this.error = error2;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Failure) && Intrinsics.areEqual(this.error, ((Failure) obj).error);
            }
            return true;
        }

        public int hashCode() {
            Error error2 = this.error;
            if (error2 != null) {
                return error2.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Failure(error=");
            outline17.append(this.error);
            outline17.append(")");
            return outline17.toString();
        }
    }

    /* compiled from: Result.kt */
    public static final class Success<T> extends Result<T> {
        public final T data;

        public Success(T t) {
            super(null);
            this.data = t;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Success) && Intrinsics.areEqual(this.data, ((Success) obj).data);
            }
            return true;
        }

        public int hashCode() {
            T t = this.data;
            if (t != null) {
                return t.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Success(data=");
            outline17.append((Object) this.data);
            outline17.append(")");
            return outline17.toString();
        }
    }

    public Result() {
    }

    public Result(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
