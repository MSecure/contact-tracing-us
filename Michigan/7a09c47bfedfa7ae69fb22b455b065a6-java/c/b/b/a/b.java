package c.b.b.a;

public abstract class b {

    public static abstract class a extends b {
    }

    /* renamed from: c.b.b.a.b$b  reason: collision with other inner class name */
    public static abstract class AbstractC0084b extends a {

        /* renamed from: a  reason: collision with root package name */
        public final String f4653a;

        public AbstractC0084b(String str) {
            this.f4653a = str;
        }

        public final String toString() {
            return this.f4653a;
        }
    }

    public static final class c extends AbstractC0084b {

        /* renamed from: b  reason: collision with root package name */
        public static final c f4654b = new c();

        public c() {
            super("CharMatcher.none()");
        }

        @Override // c.b.b.a.b
        public boolean a(char c2) {
            return false;
        }
    }

    public static final class d extends AbstractC0084b {

        /* renamed from: b  reason: collision with root package name */
        public static final int f4655b = Integer.numberOfLeadingZeros(31);

        /* renamed from: c  reason: collision with root package name */
        public static final d f4656c = new d();

        public d() {
            super("CharMatcher.whitespace()");
        }

        @Override // c.b.b.a.b
        public boolean a(char c2) {
            return " 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　".charAt((48906 * c2) >>> f4655b) == c2;
        }
    }

    public abstract boolean a(char c2);
}
