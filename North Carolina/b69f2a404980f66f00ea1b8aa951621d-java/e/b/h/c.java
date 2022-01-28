package e.b.h;

import e.b.d;
import e.b.h.f;
import java.io.IOException;

public class c extends o {
    public c(String str) {
        super(str);
    }

    /* renamed from: F */
    public c j() {
        return (c) super.j();
    }

    @Override // e.b.h.o, e.b.h.m
    public String s() {
        return "#cdata";
    }

    @Override // e.b.h.o, e.b.h.m
    public void u(Appendable appendable, int i, f.a aVar) {
        appendable.append("<![CDATA[").append(B());
    }

    @Override // e.b.h.o, e.b.h.m
    public void v(Appendable appendable, int i, f.a aVar) {
        try {
            appendable.append("]]>");
        } catch (IOException e2) {
            throw new d(e2);
        }
    }
}
