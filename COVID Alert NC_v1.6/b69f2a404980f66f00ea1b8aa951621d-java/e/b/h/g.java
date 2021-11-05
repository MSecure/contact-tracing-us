package e.b.h;

import c.b.a.a.c.n.c;
import e.b.g.b;
import e.b.h.f;

public class g extends l {
    public g(String str, String str2, String str3) {
        String str4;
        c.J1(str);
        c.J1(str2);
        c.J1(str3);
        d("name", str);
        d("publicId", str2);
        d("systemId", str3);
        if (!b.e(c("publicId"))) {
            str4 = "PUBLIC";
        } else if (!b.e(c("systemId"))) {
            str4 = "SYSTEM";
        } else {
            return;
        }
        d("pubSysKey", str4);
    }

    @Override // e.b.h.m
    public String s() {
        return "#doctype";
    }

    @Override // e.b.h.m
    public void u(Appendable appendable, int i, f.a aVar) {
        appendable.append((aVar.i != f.a.EnumC0115a.html || (b.e(c("publicId")) ^ true) || (b.e(c("systemId")) ^ true)) ? "<!DOCTYPE" : "<!doctype");
        if (!b.e(c("name"))) {
            appendable.append(" ").append(c("name"));
        }
        if (!b.e(c("pubSysKey"))) {
            appendable.append(" ").append(c("pubSysKey"));
        }
        if (!b.e(c("publicId"))) {
            appendable.append(" \"").append(c("publicId")).append('\"');
        }
        if (!b.e(c("systemId"))) {
            appendable.append(" \"").append(c("systemId")).append('\"');
        }
        appendable.append('>');
    }

    @Override // e.b.h.m
    public void v(Appendable appendable, int i, f.a aVar) {
    }
}
