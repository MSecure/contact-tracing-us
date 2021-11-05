package e.b.h;

import c.b.a.a.c.n.c;
import e.b.g.b;
import e.b.h.f;
import e.b.i.h;
import e.b.j.d;
import e.b.j.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class i extends m {
    public static final List<m> h = Collections.emptyList();
    public static final String i = "/baseUri";

    /* renamed from: d  reason: collision with root package name */
    public h f4846d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<List<i>> f4847e;
    public List<m> f = h;
    public b g;

    public static final class a extends e.b.f.a<m> {

        /* renamed from: b  reason: collision with root package name */
        public final i f4848b;

        public a(i iVar, int i) {
            super(i);
            this.f4848b = iVar;
        }

        @Override // e.b.f.a
        public void a() {
            this.f4848b.f4847e = null;
        }
    }

    static {
        Pattern.compile("\\s+");
    }

    public i(h hVar, String str, b bVar) {
        c.J1(hVar);
        this.g = bVar;
        this.f4846d = hVar;
        if (str != null) {
            c.J1(str);
            e().v(i, str);
        }
    }

    public static void C(StringBuilder sb, o oVar) {
        String B = oVar.B();
        if (L(oVar.f4861b) || (oVar instanceof c)) {
            sb.append(B);
        } else {
            b.a(sb, B, o.E(sb));
        }
    }

    public static <E extends i> int J(i iVar, List<E> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) == iVar) {
                return i2;
            }
        }
        return 0;
    }

    public static boolean L(m mVar) {
        if (mVar instanceof i) {
            i iVar = (i) mVar;
            int i2 = 0;
            while (!iVar.f4846d.h) {
                iVar = (i) iVar.f4861b;
                i2++;
                if (i2 < 6) {
                    if (iVar == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [e.b.h.m] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // e.b.h.m
    public m A() {
        i iVar = this;
        while (true) {
            ?? r1 = iVar.f4861b;
            if (r1 == 0) {
                return iVar;
            }
            iVar = r1;
        }
    }

    public i B(m mVar) {
        c.J1(mVar);
        c.J1(this);
        m mVar2 = mVar.f4861b;
        if (mVar2 != null) {
            mVar2.z(mVar);
        }
        mVar.f4861b = this;
        n();
        this.f.add(mVar);
        mVar.f4862c = this.f.size() - 1;
        return this;
    }

    public i D(String str, String str2) {
        super.d(str, str2);
        return this;
    }

    public final List<i> E() {
        List<i> list;
        WeakReference<List<i>> weakReference = this.f4847e;
        if (!(weakReference == null || (list = weakReference.get()) == null)) {
            return list;
        }
        int size = this.f.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = this.f.get(i2);
            if (mVar instanceof i) {
                arrayList.add((i) mVar);
            }
        }
        this.f4847e = new WeakReference<>(arrayList);
        return arrayList;
    }

    public e.b.j.c F() {
        return new e.b.j.c(E());
    }

    /* renamed from: G */
    public i j() {
        return (i) super.clone();
    }

    public String H() {
        String str;
        StringBuilder b2 = b.b();
        for (m mVar : this.f) {
            if (mVar instanceof e) {
                str = ((e) mVar).B();
            } else if (mVar instanceof d) {
                str = ((d) mVar).B();
            } else if (mVar instanceof i) {
                str = ((i) mVar).H();
            } else if (mVar instanceof c) {
                str = ((c) mVar).B();
            }
            b2.append(str);
        }
        return b.j(b2);
    }

    public int I() {
        m mVar = this.f4861b;
        if (((i) mVar) == null) {
            return 0;
        }
        return J(this, ((i) mVar).E());
    }

    public String K() {
        StringBuilder b2 = b.b();
        for (m mVar : this.f) {
            if (mVar instanceof o) {
                C(b2, (o) mVar);
            } else if ((mVar instanceof i) && ((i) mVar).f4846d.f4889b.equals("br") && !o.E(b2)) {
                b2.append(" ");
            }
        }
        return b.j(b2).trim();
    }

    public i M() {
        List<i> E;
        int J;
        m mVar = this.f4861b;
        if (mVar != null && (J = J(this, (E = ((i) mVar).E()))) > 0) {
            return E.get(J - 1);
        }
        return null;
    }

    public e.b.j.c N(String str) {
        c.H1(str);
        d h2 = g.h(str);
        c.J1(h2);
        c.J1(this);
        e.b.j.c cVar = new e.b.j.c();
        c.s2(new e.b.j.a(this, cVar, h2), this);
        return cVar;
    }

    @Override // e.b.h.m
    public b e() {
        if (!p()) {
            this.g = new b();
        }
        return this.g;
    }

    @Override // e.b.h.m
    public String f() {
        String str = i;
        for (i iVar = this; iVar != null; iVar = (i) iVar.f4861b) {
            if (iVar.p() && iVar.g.q(str)) {
                return iVar.g.o(str);
            }
        }
        return "";
    }

    @Override // e.b.h.m
    public int h() {
        return this.f.size();
    }

    @Override // e.b.h.m
    public m k(m mVar) {
        i iVar = (i) super.k(mVar);
        b bVar = this.g;
        iVar.g = bVar != null ? bVar.clone() : null;
        a aVar = new a(iVar, this.f.size());
        iVar.f = aVar;
        aVar.addAll(this.f);
        String f2 = f();
        c.J1(f2);
        iVar.l(f2);
        return iVar;
    }

    @Override // e.b.h.m
    public void l(String str) {
        e().v(i, str);
    }

    @Override // e.b.h.m
    public m m() {
        this.f.clear();
        return this;
    }

    @Override // e.b.h.m
    public List<m> n() {
        if (this.f == h) {
            this.f = new a(this, 4);
        }
        return this.f;
    }

    @Override // e.b.h.m
    public boolean p() {
        return this.g != null;
    }

    @Override // e.b.h.m
    public String s() {
        return this.f4846d.f4889b;
    }

    @Override // e.b.h.m
    public void u(Appendable appendable, int i2, f.a aVar) {
        boolean z;
        i iVar;
        boolean z2 = false;
        if (aVar.f) {
            if (this.f4846d.f4892e || ((iVar = (i) this.f4861b) != null && iVar.f4846d.f4892e) || aVar.g) {
                h hVar = this.f4846d;
                if ((!hVar.f4891d) && !hVar.f) {
                    m mVar = this.f4861b;
                    if (((i) mVar).f4846d.f4891d) {
                        m mVar2 = null;
                        if (mVar != null && this.f4862c > 0) {
                            mVar2 = mVar.n().get(this.f4862c - 1);
                        }
                        if (mVar2 != null && !aVar.g) {
                            z = true;
                            if (!z && (!(appendable instanceof StringBuilder) || ((StringBuilder) appendable).length() > 0)) {
                                q(appendable, i2, aVar);
                            }
                        }
                    }
                }
                z = false;
                q(appendable, i2, aVar);
            }
        }
        appendable.append('<').append(this.f4846d.f4889b);
        b bVar = this.g;
        if (bVar != null) {
            bVar.r(appendable, aVar);
        }
        if (this.f.isEmpty()) {
            h hVar2 = this.f4846d;
            if (hVar2.f || hVar2.g) {
                z2 = true;
            }
            if (z2 && (aVar.i != f.a.EnumC0115a.html || !this.f4846d.f)) {
                appendable.append(" />");
                return;
            }
        }
        appendable.append('>');
    }

    @Override // e.b.h.m
    public void v(Appendable appendable, int i2, f.a aVar) {
        if (this.f.isEmpty()) {
            h hVar = this.f4846d;
            if (hVar.f || hVar.g) {
                return;
            }
        }
        if (aVar.f && !this.f.isEmpty() && (this.f4846d.f4892e || (aVar.g && (this.f.size() > 1 || (this.f.size() == 1 && !(this.f.get(0) instanceof o)))))) {
            q(appendable, i2, aVar);
        }
        appendable.append("</").append(this.f4846d.f4889b).append('>');
    }

    @Override // e.b.h.m
    public m w() {
        return (i) this.f4861b;
    }
}
