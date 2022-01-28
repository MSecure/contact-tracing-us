package e.b.h;

import c.a.a.a.a;
import c.b.a.a.c.n.c;
import e.b.h.f;
import e.b.i.g;
import e.b.i.n;
import java.io.StringReader;

public class d extends l {
    public d(String str) {
        this.f4860d = str;
    }

    public p D() {
        String B = B();
        StringBuilder g = a.g("<");
        g.append(B.substring(1, B.length() - 1));
        g.append(">");
        String sb = g.toString();
        String f = f();
        g gVar = new g(new n());
        f d2 = gVar.f4886a.d(new StringReader(sb), f, gVar);
        if (d2.F().size() <= 0) {
            return null;
        }
        i iVar = d2.E().get(0);
        p pVar = new p(c.N1(d2).f4888c.b(iVar.f4846d.f4889b), B.startsWith("!"));
        pVar.e().c(iVar.e());
        return pVar;
    }

    public boolean E() {
        String B = B();
        return B.length() > 1 && (B.startsWith("!") || B.startsWith("?"));
    }

    @Override // java.lang.Object, e.b.h.m
    public Object clone() {
        return (d) super.clone();
    }

    @Override // e.b.h.m
    public m j() {
        return (d) super.clone();
    }

    @Override // e.b.h.m
    public String s() {
        return "#comment";
    }

    @Override // e.b.h.m
    public String toString() {
        return t();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        q(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (((e.b.h.i) r0).f4846d.f4892e != false) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r5.g != false) goto L_0x001a;
     */
    @Override // e.b.h.m
    public void u(Appendable appendable, int i, f.a aVar) {
        if (aVar.f) {
            if (this.f4862c == 0) {
                m mVar = this.f4861b;
                if (mVar instanceof i) {
                }
            }
        }
        appendable.append("<!--").append(B()).append("-->");
    }

    @Override // e.b.h.m
    public void v(Appendable appendable, int i, f.a aVar) {
    }
}
