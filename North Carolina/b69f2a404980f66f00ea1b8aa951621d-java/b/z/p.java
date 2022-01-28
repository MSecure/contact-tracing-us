package b.z;

import android.annotation.SuppressLint;

public interface p {
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: a  reason: collision with root package name */
    public static final b.c f1929a = new b.c(null);
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: b  reason: collision with root package name */
    public static final b.C0051b f1930b = new b.C0051b(null);

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            public final Throwable f1931a;

            public a(Throwable th) {
                this.f1931a = th;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.f1931a.getMessage());
            }
        }

        /* renamed from: b.z.p$b$b  reason: collision with other inner class name */
        public static final class C0051b extends b {
            public C0051b(a aVar) {
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
