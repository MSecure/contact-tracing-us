package f.b.b.a;
/* loaded from: classes.dex */
public abstract class c {

    /* loaded from: classes.dex */
    public static abstract class a extends c {
    }

    /* loaded from: classes.dex */
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
    /* loaded from: classes.dex */
    public static final class C0104c extends b {
        public static final C0104c b = new C0104c();

        public C0104c() {
            super("CharMatcher.none()");
        }

        @Override // f.b.b.a.c
        public boolean a(char c) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends b {
        public static final int b = Integer.numberOfLeadingZeros(31);
        public static final d c = new d();

        public d() {
            super("CharMatcher.whitespace()");
        }

        @Override // f.b.b.a.c
        public boolean a(char c2) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c2) >>> b) == c2;
        }
    }

    public abstract boolean a(char c);
}
