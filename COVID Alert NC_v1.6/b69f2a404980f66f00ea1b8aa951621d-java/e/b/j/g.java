package e.b.j;

import c.a.a.a.a;
import c.b.a.a.c.n.c;
import e.b.i.j;
import e.b.j.b;
import e.b.j.d;
import e.b.j.i;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class g {

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f4953d = {",", ">", "+", "~", " "};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f4954e = {"=", "!=", "^=", "$=", "*=", "~="};
    public static final Pattern f = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);
    public static final Pattern g = Pattern.compile("([+-])?(\\d+)");

    /* renamed from: a  reason: collision with root package name */
    public j f4955a;

    /* renamed from: b  reason: collision with root package name */
    public String f4956b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f4957c = new ArrayList();

    public g(String str) {
        c.H1(str);
        String trim = str.trim();
        this.f4956b = trim;
        this.f4955a = new j(trim);
    }

    public static d h(String str) {
        try {
            return new g(str).g();
        } catch (IllegalArgumentException e2) {
            throw new h(e2.getMessage(), new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0121  */
    public final void a(char c2) {
        boolean z;
        d dVar;
        d dVar2;
        b.a aVar;
        b.C0119b bVar;
        String str;
        this.f4955a.f();
        StringBuilder b2 = e.b.g.b.b();
        while (!this.f4955a.g()) {
            if (this.f4955a.i("(")) {
                b2.append("(");
                b2.append(this.f4955a.a('(', ')'));
                str = ")";
            } else if (this.f4955a.i("[")) {
                b2.append("[");
                b2.append(this.f4955a.a('[', ']'));
                str = "]";
            } else if (this.f4955a.j(f4953d)) {
                break;
            } else {
                b2.append(this.f4955a.b());
            }
            b2.append(str);
        }
        d h = h(e.b.g.b.j(b2));
        if (this.f4957c.size() == 1) {
            dVar2 = this.f4957c.get(0);
            if ((dVar2 instanceof b.C0119b) && c2 != ',') {
                b.C0119b bVar2 = (b.C0119b) dVar2;
                int i = bVar2.f4930b;
                dVar = i > 0 ? bVar2.f4929a.get(i - 1) : null;
                z = true;
                this.f4957c.clear();
                if (c2 != '>') {
                    aVar = new b.a(h, new i.b(dVar));
                } else if (c2 == ' ') {
                    aVar = new b.a(h, new i.e(dVar));
                } else if (c2 == '+') {
                    aVar = new b.a(h, new i.c(dVar));
                } else if (c2 == '~') {
                    aVar = new b.a(h, new i.f(dVar));
                } else if (c2 == ',') {
                    if (dVar instanceof b.C0119b) {
                        bVar = (b.C0119b) dVar;
                    } else {
                        b.C0119b bVar3 = new b.C0119b();
                        bVar3.c(dVar);
                        bVar = bVar3;
                    }
                    bVar.c(h);
                    aVar = bVar;
                } else {
                    throw new h(a.k("Unknown combinator: ", c2), new Object[0]);
                }
                if (!z) {
                    b.C0119b bVar4 = (b.C0119b) dVar2;
                    bVar4.f4929a.set(bVar4.f4930b - 1, aVar);
                } else {
                    dVar2 = aVar;
                }
                this.f4957c.add(dVar2);
            }
        } else {
            dVar2 = new b.a(this.f4957c);
        }
        dVar = dVar2;
        z = false;
        this.f4957c.clear();
        if (c2 != '>') {
        }
        if (!z) {
        }
        this.f4957c.add(dVar2);
    }

    public final int b() {
        j jVar = this.f4955a;
        String e2 = jVar.e(")");
        jVar.h(")");
        String trim = e2.trim();
        c.u1(e.b.g.b.f(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    public final void c(boolean z) {
        List<d> list;
        d dVar;
        this.f4955a.c(z ? ":containsOwn" : ":contains");
        String m = j.m(this.f4955a.a('(', ')'));
        c.I1(m, ":contains(text) query must not be empty");
        if (z) {
            list = this.f4957c;
            dVar = new d.m(m);
        } else {
            list = this.f4957c;
            dVar = new d.n(m);
        }
        list.add(dVar);
    }

    public final void d(boolean z, boolean z2) {
        d dVar;
        List<d> list;
        j jVar = this.f4955a;
        String e2 = jVar.e(")");
        jVar.h(")");
        String G1 = c.G1(e2);
        Matcher matcher = f.matcher(G1);
        Matcher matcher2 = g.matcher(G1);
        int i = 2;
        int i2 = 0;
        if ("odd".equals(G1)) {
            i2 = 1;
        } else if (!"even".equals(G1)) {
            if (matcher.matches()) {
                int parseInt = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                if (matcher.group(4) != null) {
                    i2 = Integer.parseInt(matcher.group(4).replaceFirst("^\\+", ""));
                }
                i = parseInt;
            } else if (matcher2.matches()) {
                i = 0;
                i2 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
            } else {
                throw new h("Could not parse nth-index '%s': unexpected format", G1);
            }
        }
        if (z2) {
            if (z) {
                list = this.f4957c;
                dVar = new d.b0(i, i2);
            } else {
                list = this.f4957c;
                dVar = new d.c0(i, i2);
            }
        } else if (z) {
            list = this.f4957c;
            dVar = new d.a0(i, i2);
        } else {
            list = this.f4957c;
            dVar = new d.z(i, i2);
        }
        list.add(dVar);
    }

    public final void e() {
        List<d> list;
        d g0Var;
        d dVar;
        List<d> list2;
        d dVar2;
        List<d> list3;
        if (this.f4955a.h("#")) {
            String d2 = this.f4955a.d();
            c.H1(d2);
            this.f4957c.add(new d.p(d2));
        } else if (this.f4955a.h(".")) {
            String d3 = this.f4955a.d();
            c.H1(d3);
            this.f4957c.add(new d.k(d3.trim()));
        } else if (this.f4955a.k() || this.f4955a.i("*|")) {
            j jVar = this.f4955a;
            int i = jVar.f4911b;
            while (!jVar.g() && (jVar.k() || jVar.j("*|", "|", "_", "-"))) {
                jVar.f4911b++;
            }
            String G1 = c.G1(jVar.f4910a.substring(i, jVar.f4911b));
            c.H1(G1);
            if (G1.startsWith("*|")) {
                this.f4957c.add(new b.C0119b(new d.j0(G1), new d.k0(G1.replace("*|", ":"))));
                return;
            }
            if (G1.contains("|")) {
                G1 = G1.replace("|", ":");
            }
            this.f4957c.add(new d.j0(G1));
        } else if (this.f4955a.i("[")) {
            j jVar2 = new j(this.f4955a.a('[', ']'));
            String[] strArr = f4954e;
            int i2 = jVar2.f4911b;
            while (!jVar2.g() && !jVar2.j(strArr)) {
                jVar2.f4911b++;
            }
            String substring = jVar2.f4910a.substring(i2, jVar2.f4911b);
            c.H1(substring);
            jVar2.f();
            if (jVar2.g()) {
                if (substring.startsWith("^")) {
                    list3 = this.f4957c;
                    dVar2 = new d.C0120d(substring.substring(1));
                } else {
                    list3 = this.f4957c;
                    dVar2 = new d.b(substring);
                }
                list3.add(dVar2);
                return;
            }
            if (jVar2.h("=")) {
                list2 = this.f4957c;
                dVar = new d.e(substring, jVar2.l());
            } else if (jVar2.h("!=")) {
                list2 = this.f4957c;
                dVar = new d.i(substring, jVar2.l());
            } else if (jVar2.h("^=")) {
                list2 = this.f4957c;
                dVar = new d.j(substring, jVar2.l());
            } else if (jVar2.h("$=")) {
                list2 = this.f4957c;
                dVar = new d.g(substring, jVar2.l());
            } else if (jVar2.h("*=")) {
                list2 = this.f4957c;
                dVar = new d.f(substring, jVar2.l());
            } else if (jVar2.h("~=")) {
                list2 = this.f4957c;
                dVar = new d.h(substring, Pattern.compile(jVar2.l()));
            } else {
                throw new h("Could not parse attribute query '%s': unexpected token at '%s'", this.f4956b, jVar2.l());
            }
            list2.add(dVar);
        } else if (this.f4955a.h("*")) {
            this.f4957c.add(new d.a());
        } else if (this.f4955a.h(":lt(")) {
            this.f4957c.add(new d.t(b()));
        } else if (this.f4955a.h(":gt(")) {
            this.f4957c.add(new d.s(b()));
        } else if (this.f4955a.h(":eq(")) {
            this.f4957c.add(new d.q(b()));
        } else if (this.f4955a.i(":has(")) {
            this.f4955a.c(":has");
            String a2 = this.f4955a.a('(', ')');
            c.I1(a2, ":has(el) subselect must not be empty");
            this.f4957c.add(new i.a(h(a2)));
        } else if (this.f4955a.i(":contains(")) {
            c(false);
        } else if (this.f4955a.i(":containsOwn(")) {
            c(true);
        } else if (this.f4955a.i(":containsData(")) {
            this.f4955a.c(":containsData");
            String m = j.m(this.f4955a.a('(', ')'));
            c.I1(m, ":containsData(text) query must not be empty");
            this.f4957c.add(new d.l(m));
        } else if (this.f4955a.i(":matches(")) {
            f(false);
        } else if (this.f4955a.i(":matchesOwn(")) {
            f(true);
        } else if (this.f4955a.i(":not(")) {
            this.f4955a.c(":not");
            String a3 = this.f4955a.a('(', ')');
            c.I1(a3, ":not(selector) subselect must not be empty");
            this.f4957c.add(new i.d(h(a3)));
        } else if (this.f4955a.h(":nth-child(")) {
            d(false, false);
        } else if (this.f4955a.h(":nth-last-child(")) {
            d(true, false);
        } else if (this.f4955a.h(":nth-of-type(")) {
            d(false, true);
        } else if (this.f4955a.h(":nth-last-of-type(")) {
            d(true, true);
        } else {
            if (this.f4955a.h(":first-child")) {
                list = this.f4957c;
                g0Var = new d.v();
            } else if (this.f4955a.h(":last-child")) {
                list = this.f4957c;
                g0Var = new d.x();
            } else if (this.f4955a.h(":first-of-type")) {
                list = this.f4957c;
                g0Var = new d.w();
            } else if (this.f4955a.h(":last-of-type")) {
                list = this.f4957c;
                g0Var = new d.y();
            } else if (this.f4955a.h(":only-child")) {
                list = this.f4957c;
                g0Var = new d.d0();
            } else if (this.f4955a.h(":only-of-type")) {
                list = this.f4957c;
                g0Var = new d.e0();
            } else if (this.f4955a.h(":empty")) {
                list = this.f4957c;
                g0Var = new d.u();
            } else if (this.f4955a.h(":root")) {
                list = this.f4957c;
                g0Var = new d.f0();
            } else if (this.f4955a.h(":matchText")) {
                list = this.f4957c;
                g0Var = new d.g0();
            } else {
                throw new h("Could not parse query '%s': unexpected token at '%s'", this.f4956b, this.f4955a.l());
            }
            list.add(g0Var);
        }
    }

    public final void f(boolean z) {
        List<d> list;
        d dVar;
        this.f4955a.c(z ? ":matchesOwn" : ":matches");
        String a2 = this.f4955a.a('(', ')');
        c.I1(a2, ":matches(regex) query must not be empty");
        if (z) {
            list = this.f4957c;
            dVar = new d.i0(Pattern.compile(a2));
        } else {
            list = this.f4957c;
            dVar = new d.h0(Pattern.compile(a2));
        }
        list.add(dVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    public d g() {
        this.f4955a.f();
        if (this.f4955a.j(f4953d)) {
            this.f4957c.add(new i.g());
            char c2 = this.f4955a.b();
            a(c2);
            if (this.f4955a.g()) {
                boolean f2 = this.f4955a.f();
                if (!this.f4955a.j(f4953d)) {
                    if (f2) {
                        c2 = ' ';
                        a(c2);
                        if (this.f4955a.g()) {
                        }
                    }
                }
                char c22 = this.f4955a.b();
                a(c22);
                if (this.f4955a.g()) {
                }
            }
            return this.f4957c.size() != 1 ? this.f4957c.get(0) : new b.a(this.f4957c);
        }
        e();
        if (this.f4955a.g()) {
        }
        if (this.f4957c.size() != 1) {
        }
    }
}
