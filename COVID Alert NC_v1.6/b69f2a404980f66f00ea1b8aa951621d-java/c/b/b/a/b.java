package c.b.b.a;

public abstract class b {

    public static abstract class a extends b {
    }

    /* renamed from: c.b.b.a.b$b  reason: collision with other inner class name */
    public static abstract class AbstractC0075b extends a {

        /* renamed from: a  reason: collision with root package name */
        public final String f3316a;

        public AbstractC0075b(String str) {
            this.f3316a = str;
        }

        public final String toString() {
            return this.f3316a;
        }
    }

    public static final class c extends AbstractC0075b {

        /* renamed from: b  reason: collision with root package name */
        public static final c f3317b = new c();

        public c() {
            super("CharMatcher.none()");
        }

        @Override // c.b.b.a.b
        public boolean a(char c2) {
            return false;
        }
    }

    public static final class d extends AbstractC0075b {

        /* renamed from: b  reason: collision with root package name */
        public static final int f3318b = Integer.numberOfLeadingZeros(31);

        /* renamed from: c  reason: collision with root package name */
        public static final d f3319c = new d();

        public d() {
            super("CharMatcher.whitespace()");
        }

        @Override // c.b.b.a.b
        public boolean a(char c2) {
            return " 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　".charAt((48906 * c2) >>> f3318b) == c2;
        }
    }

    public abstract boolean a(char c2);
}
