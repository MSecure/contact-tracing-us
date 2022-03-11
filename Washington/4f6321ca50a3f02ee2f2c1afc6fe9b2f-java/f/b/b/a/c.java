package f.b.b.a;

public abstract class c {

    public static abstract class a extends c {
    }

    public static abstract class b extends a {
        public final String a;

        public b(String str) {
            this.a = str;
        }

        public final String toString() {
            return this.a;
        }
    }

    /* renamed from: f.b.b.a.c$c  reason: collision with other inner class name */
    public static final class C0099c extends b {
        public static final C0099c b = new C0099c();

        public C0099c() {
            super("CharMatcher.none()");
        }

        @Override // f.b.b.a.c
        public boolean a(char c) {
            return false;
        }
    }

    public static final class d extends b {
        public static final int b = Integer.numberOfLeadingZeros(31);
        public static final d c = new d();

        public d() {
            super("CharMatcher.whitespace()");
        }

        @Override // f.b.b.a.c
        public boolean a(char c2) {
            return " 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　".charAt((48906 * c2) >>> b) == c2;
        }
    }

    public abstract boolean a(char c);
}
