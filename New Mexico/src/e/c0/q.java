package e.c0;
/* loaded from: classes.dex */
public interface q {
    public static final b.c a = new b.c(null);
    public static final b.C0025b b = new b.C0025b(null);

    /* loaded from: classes.dex */
    public static abstract class b {

        /* loaded from: classes.dex */
        public static final class a extends b {
            public final Throwable a;

            public a(Throwable th) {
                this.a = th;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.a.getMessage());
            }
        }

        /* renamed from: e.c0.q$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0025b extends b {
            public C0025b(a aVar) {
            }

            public String toString() {
                return "IN_PROGRESS";
            }
        }

        /* loaded from: classes.dex */
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
