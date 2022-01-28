package b.b0;

import android.annotation.SuppressLint;

public interface p {
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: a  reason: collision with root package name */
    public static final b.c f1047a = new b.c(null);
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: b  reason: collision with root package name */
    public static final b.C0017b f1048b = new b.C0017b(null);

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            public final Throwable f1049a;

            public a(Throwable th) {
                this.f1049a = th;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.f1049a.getMessage());
            }
        }

        /* renamed from: b.b0.p$b$b  reason: collision with other inner class name */
        public static final class C0017b extends b {
            public C0017b(a aVar) {
            }

            public String toString() {
                return "IN_PROGRESS";
            }
        }

        public static final class c extends b {
            public c() {
            }

            public c(a aVar) {
            }

            public String toString() {
                return "SUCCESS";
            }
        }
    }
}
