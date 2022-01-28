package e.b.i;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public j f4893a;

    public static final class b extends c {
        public b(String str) {
            this.f4894b = str;
        }

        @Override // e.b.i.i.c
        public String toString() {
            StringBuilder g = c.a.a.a.a.g("<![CDATA[");
            g.append(this.f4894b);
            g.append("]]>");
            return g.toString();
        }
    }

    public static class c extends i {

        /* renamed from: b  reason: collision with root package name */
        public String f4894b;

        public c() {
            super(null);
            this.f4893a = j.Character;
        }

        @Override // e.b.i.i
        public i g() {
            this.f4894b = null;
            return this;
        }

        public String toString() {
            return this.f4894b;
        }
    }

    public static final class d extends i {

        /* renamed from: b  reason: collision with root package name */
        public final StringBuilder f4895b = new StringBuilder();

        /* renamed from: c  reason: collision with root package name */
        public String f4896c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4897d = false;

        public d() {
            super(null);
            this.f4893a = j.Comment;
        }

        @Override // e.b.i.i
        public i g() {
            i.h(this.f4895b);
            this.f4896c = null;
            this.f4897d = false;
            return this;
        }

        public final d i(char c2) {
            String str = this.f4896c;
            if (str != null) {
                this.f4895b.append(str);
                this.f4896c = null;
            }
            this.f4895b.append(c2);
            return this;
        }

        public final d j(String str) {
            String str2 = this.f4896c;
            if (str2 != null) {
                this.f4895b.append(str2);
                this.f4896c = null;
            }
            if (this.f4895b.length() == 0) {
                this.f4896c = str;
            } else {
                this.f4895b.append(str);
            }
            return this;
        }

        public String k() {
            String str = this.f4896c;
            return str != null ? str : this.f4895b.toString();
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("<!--");
            g.append(k());
            g.append("-->");
            return g.toString();
        }
    }

    public static final class e extends i {

        /* renamed from: b  reason: collision with root package name */
        public final StringBuilder f4898b = new StringBuilder();

        /* renamed from: c  reason: collision with root package name */
        public String f4899c = null;

        /* renamed from: d  reason: collision with root package name */
        public final StringBuilder f4900d = new StringBuilder();

        /* renamed from: e  reason: collision with root package name */
        public final StringBuilder f4901e = new StringBuilder();
        public boolean f = false;

        public e() {
            super(null);
            this.f4893a = j.Doctype;
        }

        @Override // e.b.i.i
        public i g() {
            i.h(this.f4898b);
            this.f4899c = null;
            i.h(this.f4900d);
            i.h(this.f4901e);
            this.f = false;
            return this;
        }
    }

    public static final class f extends i {
        public f() {
            super(null);
            this.f4893a = j.EOF;
        }

        @Override // e.b.i.i
        public i g() {
            return this;
        }
    }

    public static final class g extends AbstractC0117i {
        public g() {
            this.f4893a = j.EndTag;
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("</");
            String str = this.f4902b;
            if (str == null) {
                str = "(unset)";
            }
            g.append(str);
            g.append(">");
            return g.toString();
        }
    }

    public static final class h extends AbstractC0117i {
        public h() {
            this.f4893a = j.StartTag;
        }

        @Override // e.b.i.i, e.b.i.i.AbstractC0117i
        public /* bridge */ /* synthetic */ i g() {
            s();
            return this;
        }

        @Override // e.b.i.i.AbstractC0117i
        public AbstractC0117i s() {
            super.g();
            this.j = null;
            return this;
        }

        public String toString() {
            String str;
            StringBuilder sb;
            e.b.h.b bVar = this.j;
            if (bVar == null || bVar.size() <= 0) {
                sb = c.a.a.a.a.g("<");
                str = p();
            } else {
                sb = c.a.a.a.a.g("<");
                sb.append(p());
                sb.append(" ");
                str = this.j.toString();
            }
            sb.append(str);
            sb.append(">");
            return sb.toString();
        }
    }

    /* renamed from: e.b.i.i$i  reason: collision with other inner class name */
    public static abstract class AbstractC0117i extends i {

        /* renamed from: b  reason: collision with root package name */
        public String f4902b;

        /* renamed from: c  reason: collision with root package name */
        public String f4903c;

        /* renamed from: d  reason: collision with root package name */
        public String f4904d;

        /* renamed from: e  reason: collision with root package name */
        public StringBuilder f4905e = new StringBuilder();
        public String f;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public e.b.h.b j;

        public AbstractC0117i() {
            super(null);
        }

        public final void i(char c2) {
            String valueOf = String.valueOf(c2);
            String str = this.f4904d;
            if (str != null) {
                valueOf = str.concat(valueOf);
            }
            this.f4904d = valueOf;
        }

        public final void j(char c2) {
            o();
            this.f4905e.append(c2);
        }

        public final void k(String str) {
            o();
            if (this.f4905e.length() == 0) {
                this.f = str;
            } else {
                this.f4905e.append(str);
            }
        }

        public final void l(int[] iArr) {
            o();
            for (int i2 : iArr) {
                this.f4905e.appendCodePoint(i2);
            }
        }

        public final void m(char c2) {
            n(String.valueOf(c2));
        }

        public final void n(String str) {
            String str2 = this.f4902b;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f4902b = str;
            this.f4903c = c.b.a.a.c.n.c.C1(str);
        }

        public final void o() {
            this.h = true;
            String str = this.f;
            if (str != null) {
                this.f4905e.append(str);
                this.f = null;
            }
        }

        public final String p() {
            String str = this.f4902b;
            c.b.a.a.c.n.c.o1(str == null || str.length() == 0);
            return this.f4902b;
        }

        public final AbstractC0117i q(String str) {
            this.f4902b = str;
            this.f4903c = c.b.a.a.c.n.c.C1(str);
            return this;
        }

        public final void r() {
            if (this.j == null) {
                this.j = new e.b.h.b();
            }
            String str = this.f4904d;
            if (str != null) {
                String trim = str.trim();
                this.f4904d = trim;
                if (trim.length() > 0) {
                    this.j.a(this.f4904d, this.h ? this.f4905e.length() > 0 ? this.f4905e.toString() : this.f : this.g ? "" : null);
                }
            }
            this.f4904d = null;
            this.g = false;
            this.h = false;
            i.h(this.f4905e);
            this.f = null;
        }

        /* renamed from: s */
        public AbstractC0117i g() {
            this.f4902b = null;
            this.f4903c = null;
            this.f4904d = null;
            i.h(this.f4905e);
            this.f = null;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = null;
            return this;
        }
    }

    public enum j {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    public i(a aVar) {
    }

    public static void h(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    public final boolean a() {
        return this.f4893a == j.Character;
    }

    public final boolean b() {
        return this.f4893a == j.Comment;
    }

    public final boolean c() {
        return this.f4893a == j.Doctype;
    }

    public final boolean d() {
        return this.f4893a == j.EOF;
    }

    public final boolean e() {
        return this.f4893a == j.EndTag;
    }

    public final boolean f() {
        return this.f4893a == j.StartTag;
    }

    public abstract i g();
}
