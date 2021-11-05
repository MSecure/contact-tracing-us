package e.b.h;

import c.b.a.a.c.n.c;
import e.b.h.b;
import e.b.h.f;

public class p extends l {
    public final boolean f;

    public p(String str, boolean z) {
        c.J1(str);
        this.f4860d = str;
        this.f = z;
    }

    @Override // java.lang.Object, e.b.h.m
    public Object clone() {
        return (p) super.clone();
    }

    @Override // e.b.h.m
    public m j() {
        return (p) super.clone();
    }

    @Override // e.b.h.m
    public String s() {
        return "#declaration";
    }

    @Override // e.b.h.m
    public String toString() {
        return t();
    }

    @Override // e.b.h.m
    public void u(Appendable appendable, int i, f.a aVar) {
        String str = "!";
        appendable.append("<").append(this.f ? str : "?").append(B());
        b e2 = e();
        if (e2 != null) {
            b.a aVar2 = new b.a();
            while (aVar2.hasNext()) {
                a aVar3 = (a) aVar2.next();
                if (!aVar3.f4825b.equals("#declaration")) {
                    appendable.append(' ');
                    aVar3.a(appendable, aVar);
                }
            }
            if (!this.f) {
                str = "?";
            }
            appendable.append(str).append(">");
            return;
        }
        throw null;
    }

    @Override // e.b.h.m
    public void v(Appendable appendable, int i, f.a aVar) {
    }
}
