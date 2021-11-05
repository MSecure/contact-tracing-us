package e.b.i;

import c.a.a.a.a;
import c.b.a.a.c.n.c;
import e.b.h.d;
import e.b.h.e;
import e.b.h.i;
import e.b.h.k;
import e.b.h.m;
import e.b.h.o;
import e.b.i.i;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class b extends m {
    public static final String[] A = {"html", "table"};
    public static final String[] B = {"optgroup", "option"};
    public static final String[] C = {"dd", "dt", "li", "optgroup", "option", "p", "rp", "rt"};
    public static final String[] D = {"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};
    public static final String[] x = {"applet", "caption", "html", "marquee", "object", "table", "td", "th"};
    public static final String[] y = {"ol", "ul"};
    public static final String[] z = {"button"};
    public c k;
    public c l;
    public boolean m;
    public i n;
    public k o;
    public i p;
    public ArrayList<i> q;
    public List<String> r;
    public i.g s;
    public boolean t;
    public boolean u;
    public boolean v;
    public String[] w = {null};

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    public void A(m mVar) {
        boolean z2;
        e.b.h.i iVar;
        e.b.h.i p2 = p("table");
        if (p2 != null) {
            m mVar2 = p2.f4861b;
            if (((e.b.h.i) mVar2) != null) {
                iVar = (e.b.h.i) mVar2;
                z2 = true;
                if (!z2) {
                    c.J1(p2);
                    c.J1(mVar);
                    c.J1(p2.f4861b);
                    p2.f4861b.b(p2.f4862c, mVar);
                    return;
                }
                iVar.B(mVar);
                return;
            }
            iVar = h(p2);
        } else {
            iVar = this.f4925e.get(0);
        }
        z2 = false;
        if (!z2) {
        }
    }

    public void B() {
        this.q.add(null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    public final void C(m mVar) {
        k kVar;
        e.b.h.i a2;
        if (this.f4925e.isEmpty()) {
            a2 = this.f4924d;
        } else if (this.u) {
            A(mVar);
            if (!(mVar instanceof e.b.h.i)) {
                e.b.h.i iVar = (e.b.h.i) mVar;
                if (iVar.f4846d.i && (kVar = this.o) != null) {
                    kVar.j.add(iVar);
                    return;
                }
                return;
            }
            return;
        } else {
            a2 = a();
        }
        a2.B(mVar);
        if (!(mVar instanceof e.b.h.i)) {
        }
    }

    public final boolean D(ArrayList<e.b.h.i> arrayList, e.b.h.i iVar) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == iVar) {
                return true;
            }
        }
        return false;
    }

    public boolean E(e.b.h.i iVar) {
        return e.b.g.b.d(iVar.f4846d.f4890c, D);
    }

    public boolean F(e.b.h.i iVar) {
        return D(this.f4925e, iVar);
    }

    public e.b.h.i G() {
        return this.f4925e.remove(this.f4925e.size() - 1);
    }

    public e.b.h.i H(String str) {
        for (int size = this.f4925e.size() - 1; size >= 0; size--) {
            e.b.h.i iVar = this.f4925e.get(size);
            this.f4925e.remove(size);
            if (iVar.f4846d.f4890c.equals(str)) {
                return iVar;
            }
        }
        return null;
    }

    public void I(e.b.h.i iVar) {
        int size = this.q.size() - 1;
        int i = 0;
        while (true) {
            if (size >= 0) {
                e.b.h.i iVar2 = this.q.get(size);
                if (iVar2 == null) {
                    break;
                }
                if (iVar.f4846d.f4890c.equals(iVar2.f4846d.f4890c) && iVar.e().equals(iVar2.e())) {
                    i++;
                }
                if (i == 3) {
                    this.q.remove(size);
                    break;
                }
                size--;
            } else {
                break;
            }
        }
        this.q.add(iVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0086  */
    public void J() {
        e.b.h.i iVar;
        b bVar;
        if (this.q.size() > 0) {
            ArrayList<e.b.h.i> arrayList = this.q;
            iVar = arrayList.get(arrayList.size() - 1);
        } else {
            iVar = null;
        }
        if (iVar != null && !D(this.f4925e, iVar)) {
            boolean z2 = true;
            int size = this.q.size() - 1;
            int i = size;
            while (i != 0) {
                i--;
                iVar = this.q.get(i);
                if (iVar == null || D(this.f4925e, iVar)) {
                    bVar = this;
                    break;
                }
                while (i != 0) {
                }
            }
            int i2 = i;
            b bVar2 = this;
            if (!z2) {
                i2++;
                iVar = bVar2.q.get(i2);
            }
            c.J1(iVar);
            e.b.h.i iVar2 = new e.b.h.i(h.a(iVar.f4846d.f4890c, bVar2.h), null, null);
            bVar2.C(iVar2);
            bVar2.f4925e.add(iVar2);
            iVar2.e().c(iVar.e());
            bVar2.q.set(i2, iVar2);
            if (i2 == size) {
                bVar = bVar2;
                i = i2;
                bVar2 = bVar;
                z2 = false;
                i2 = i;
                if (!z2) {
                }
                c.J1(iVar);
                e.b.h.i iVar22 = new e.b.h.i(h.a(iVar.f4846d.f4890c, bVar2.h), null, null);
                bVar2.C(iVar22);
                bVar2.f4925e.add(iVar22);
                iVar22.e().c(iVar.e());
                bVar2.q.set(i2, iVar22);
                if (i2 == size) {
                }
            }
        }
    }

    public void K(e.b.h.i iVar) {
        int size = this.q.size();
        do {
            size--;
            if (size < 0) {
                return;
            }
        } while (this.q.get(size) != iVar);
        this.q.remove(size);
    }

    public boolean L(e.b.h.i iVar) {
        for (int size = this.f4925e.size() - 1; size >= 0; size--) {
            if (this.f4925e.get(size) == iVar) {
                this.f4925e.remove(size);
                return true;
            }
        }
        return false;
    }

    public void M() {
        c cVar;
        boolean z2 = false;
        for (int size = this.f4925e.size() - 1; size >= 0; size--) {
            e.b.h.i iVar = this.f4925e.get(size);
            if (size == 0) {
                iVar = this.p;
                z2 = true;
            }
            String str = iVar.f4846d.f4890c;
            if ("select".equals(str)) {
                cVar = c.InSelect;
            } else if ("td".equals(str) || ("th".equals(str) && !z2)) {
                cVar = c.InCell;
            } else if ("tr".equals(str)) {
                cVar = c.InRow;
            } else if ("tbody".equals(str) || "thead".equals(str) || "tfoot".equals(str)) {
                cVar = c.InTableBody;
            } else if ("caption".equals(str)) {
                cVar = c.InCaption;
            } else if ("colgroup".equals(str)) {
                cVar = c.InColumnGroup;
            } else if ("table".equals(str)) {
                cVar = c.InTable;
            } else {
                if (!"head".equals(str) && !"body".equals(str)) {
                    if ("frameset".equals(str)) {
                        cVar = c.InFrameset;
                    } else if ("html".equals(str)) {
                        cVar = c.BeforeHead;
                    } else if (!z2) {
                    }
                }
                cVar = c.InBody;
            }
            this.k = cVar;
            return;
        }
    }

    @Override // e.b.i.m
    public f b() {
        return f.f4882c;
    }

    @Override // e.b.i.m
    public void c(Reader reader, String str, g gVar) {
        super.c(reader, str, gVar);
        this.k = c.Initial;
        this.l = null;
        this.m = false;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = new ArrayList<>();
        this.r = new ArrayList();
        this.s = new i.g();
        this.t = true;
        this.u = false;
        this.v = false;
    }

    @Override // e.b.i.m
    public boolean e(i iVar) {
        this.g = iVar;
        return this.k.f(iVar, this);
    }

    public e.b.h.i h(e.b.h.i iVar) {
        for (int size = this.f4925e.size() - 1; size >= 0; size--) {
            if (this.f4925e.get(size) == iVar) {
                return this.f4925e.get(size - 1);
            }
        }
        return null;
    }

    public void i() {
        e.b.h.i iVar;
        while (!this.q.isEmpty()) {
            int size = this.q.size();
            if (size > 0) {
                iVar = this.q.remove(size - 1);
                continue;
            } else {
                iVar = null;
                continue;
            }
            if (iVar == null) {
                return;
            }
        }
    }

    public final void j(String... strArr) {
        int size = this.f4925e.size();
        while (true) {
            size--;
            if (size >= 0) {
                e.b.h.i iVar = this.f4925e.get(size);
                if (!e.b.g.b.c(iVar.f4846d.f4890c, strArr) && !iVar.f4846d.f4890c.equals("html")) {
                    this.f4925e.remove(size);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void k() {
        j("tbody", "tfoot", "thead", "template");
    }

    public void l() {
        j("table");
    }

    public void m(c cVar) {
        if (this.f4921a.f4887b.a()) {
            this.f4921a.f4887b.add(new d(this.f4922b.t(), "Unexpected token [%s] when in state [%s]", this.g.getClass().getSimpleName(), cVar));
        }
    }

    public void n(String str) {
        while (str != null && !a().f4846d.f4890c.equals(str) && e.b.g.b.d(a().f4846d.f4890c, C)) {
            G();
        }
    }

    public e.b.h.i o(String str) {
        for (int size = this.q.size() - 1; size >= 0; size--) {
            e.b.h.i iVar = this.q.get(size);
            if (iVar == null) {
                return null;
            }
            if (iVar.f4846d.f4890c.equals(str)) {
                return iVar;
            }
        }
        return null;
    }

    public e.b.h.i p(String str) {
        e.b.h.i iVar;
        int size = this.f4925e.size();
        do {
            size--;
            if (size < 0) {
                return null;
            }
            iVar = this.f4925e.get(size);
        } while (!iVar.f4846d.f4890c.equals(str));
        return iVar;
    }

    public boolean q(String str) {
        String[] strArr = z;
        String[] strArr2 = x;
        String[] strArr3 = this.w;
        strArr3[0] = str;
        return t(strArr3, strArr2, strArr);
    }

    public boolean r(String str) {
        String[] strArr = x;
        String[] strArr2 = this.w;
        strArr2[0] = str;
        return t(strArr2, strArr, null);
    }

    public boolean s(String str) {
        for (int size = this.f4925e.size() - 1; size >= 0; size--) {
            String str2 = this.f4925e.get(size).f4846d.f4890c;
            if (str2.equals(str)) {
                return true;
            }
            if (!e.b.g.b.d(str2, B)) {
                return false;
            }
        }
        throw new IllegalArgumentException("Should not be reachable");
    }

    public final boolean t(String[] strArr, String[] strArr2, String[] strArr3) {
        int size = this.f4925e.size() - 1;
        int i = size > 100 ? size - 100 : 0;
        while (size >= i) {
            String str = this.f4925e.get(size).f4846d.f4890c;
            if (e.b.g.b.d(str, strArr)) {
                return true;
            }
            if (e.b.g.b.d(str, strArr2)) {
                return false;
            }
            if (strArr3 != null && e.b.g.b.d(str, strArr3)) {
                return false;
            }
            size--;
        }
        return false;
    }

    public String toString() {
        StringBuilder g = a.g("TreeBuilder{currentToken=");
        g.append(this.g);
        g.append(", state=");
        g.append(this.k);
        g.append(", currentElement=");
        g.append(a());
        g.append('}');
        return g.toString();
    }

    public boolean u(String str) {
        String[] strArr = A;
        String[] strArr2 = this.w;
        strArr2[0] = str;
        return t(strArr2, strArr, null);
    }

    public e.b.h.i v(i.h hVar) {
        e.b.h.b bVar = hVar.j;
        if (bVar != null) {
            if (!(bVar.f4829b == 0) && hVar.j.m(this.h) > 0) {
                e eVar = this.f4921a.f4887b;
                if (eVar.a()) {
                    eVar.add(new d(this.f4922b.t(), "Duplicate attribute"));
                }
            }
        }
        if (hVar.i) {
            e.b.h.i y2 = y(hVar);
            this.f4925e.add(y2);
            k kVar = this.f4923c;
            kVar.f4914c = l.Data;
            i.g gVar = this.s;
            gVar.g();
            gVar.q(y2.f4846d.f4889b);
            kVar.g(gVar);
            return y2;
        }
        h a2 = h.a(hVar.p(), this.h);
        f fVar = this.h;
        e.b.h.b bVar2 = hVar.j;
        fVar.a(bVar2);
        e.b.h.i iVar = new e.b.h.i(a2, null, bVar2);
        C(iVar);
        this.f4925e.add(iVar);
        return iVar;
    }

    public void w(i.c cVar) {
        e.b.h.i a2 = a();
        if (a2 == null) {
            a2 = this.f4924d;
        }
        String str = a2.f4846d.f4890c;
        String str2 = cVar.f4894b;
        a2.B(cVar instanceof i.b ? new e.b.h.c(str2) : (str.equals("script") || str.equals("style")) ? new e(str2) : new o(str2));
    }

    public void x(i.d dVar) {
        C(new d(dVar.k()));
    }

    public e.b.h.i y(i.h hVar) {
        h a2 = h.a(hVar.p(), this.h);
        f fVar = this.h;
        e.b.h.b bVar = hVar.j;
        fVar.a(bVar);
        e.b.h.i iVar = new e.b.h.i(a2, null, bVar);
        C(iVar);
        if (hVar.i) {
            if (!h.k.containsKey(a2.f4889b)) {
                a2.g = true;
            } else if (!a2.f) {
                this.f4923c.j("Tag cannot be self closing; not a void tag");
            }
        }
        return iVar;
    }

    public k z(i.h hVar, boolean z2) {
        h a2 = h.a(hVar.p(), this.h);
        f fVar = this.h;
        e.b.h.b bVar = hVar.j;
        fVar.a(bVar);
        k kVar = new k(a2, null, bVar);
        this.o = kVar;
        C(kVar);
        if (z2) {
            this.f4925e.add(kVar);
        }
        return kVar;
    }
}
