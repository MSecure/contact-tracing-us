package e.b0;

public interface o {
    public static final b.c a = new b.c(null);
    public static final b.C0019b b = new b.C0019b(null);

    public static abstract class b {

        public static final class a extends b {
            public final Throwable a;

            public a(Throwable th) {
                this.a = th;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.a.getMessage());
            }
        }

        /* renamed from: e.b0.o$b$b  reason: collision with other inner class name */
        public static final class C0019b extends b {
            public C0019b(a aVar) {
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
