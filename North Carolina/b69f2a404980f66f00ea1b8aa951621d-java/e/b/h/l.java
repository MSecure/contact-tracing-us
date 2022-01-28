package e.b.h;

import c.b.a.a.c.n.c;
import java.util.Collections;
import java.util.List;

public abstract class l extends m {

    /* renamed from: e  reason: collision with root package name */
    public static final List<m> f4859e = Collections.emptyList();

    /* renamed from: d  reason: collision with root package name */
    public Object f4860d;

    public String B() {
        return c(s());
    }

    public final void C() {
        Object obj = this.f4860d;
        if (!(obj instanceof b)) {
            b bVar = new b();
            this.f4860d = bVar;
            if (obj != null) {
                bVar.v(s(), (String) obj);
            }
        }
    }

    @Override // e.b.h.m
    public String a(String str) {
        C();
        return super.a(str);
    }

    @Override // e.b.h.m
    public String c(String str) {
        c.J1(str);
        if (!(this.f4860d instanceof b)) {
            return str.equals(s()) ? (String) this.f4860d : "";
        }
        return super.c(str);
    }

    @Override // e.b.h.m
    public m d(String str, String str2) {
        if ((this.f4860d instanceof b) || !str.equals(s())) {
            C();
            super.d(str, str2);
        } else {
            this.f4860d = str2;
        }
        return this;
    }

    @Override // e.b.h.m
    public final b e() {
        C();
        return (b) this.f4860d;
    }

    @Override // e.b.h.m
    public String f() {
        return this.f4861b != null ? this.f4861b.f() : "";
    }

    @Override // e.b.h.m
    public int h() {
        return 0;
    }

    @Override // e.b.h.m
    public m k(m mVar) {
        l lVar = (l) super.k(mVar);
        Object obj = this.f4860d;
        if (obj instanceof b) {
            lVar.f4860d = ((b) obj).clone();
        }
        return lVar;
    }

    @Override // e.b.h.m
    public void l(String str) {
    }

    @Override // e.b.h.m
    public m m() {
        return this;
    }

    @Override // e.b.h.m
    public List<m> n() {
        return f4859e;
    }

    @Override // e.b.h.m
    public boolean o(String str) {
        C();
        return super.o(str);
    }

    @Override // e.b.h.m
    public final boolean p() {
        return this.f4860d instanceof b;
    }
}
