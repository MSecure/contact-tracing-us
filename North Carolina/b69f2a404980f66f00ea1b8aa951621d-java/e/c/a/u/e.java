package e.c.a.u;

import e.c.a.l;
import e.c.a.p;
import e.c.a.t.h;
import e.c.a.t.m;
import e.c.a.v.c;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public Locale f5110a;

    /* renamed from: b  reason: collision with root package name */
    public j f5111b;

    /* renamed from: c  reason: collision with root package name */
    public h f5112c;

    /* renamed from: d  reason: collision with root package name */
    public p f5113d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5114e = true;
    public boolean f = true;
    public final ArrayList<a> g;

    public final class a extends c {

        /* renamed from: b  reason: collision with root package name */
        public h f5115b = null;

        /* renamed from: c  reason: collision with root package name */
        public p f5116c = null;

        /* renamed from: d  reason: collision with root package name */
        public final Map<j, Long> f5117d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        public boolean f5118e;
        public l f = l.f4991e;
        public List<Object[]> g;

        public a() {
        }

        @Override // e.c.a.v.c, e.c.a.w.e
        public int d(j jVar) {
            if (this.f5117d.containsKey(jVar)) {
                return c.b.a.a.c.n.c.d2(this.f5117d.get(jVar).longValue());
            }
            throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
        }

        @Override // e.c.a.v.c, e.c.a.w.e
        public <R> R f(e.c.a.w.l<R> lVar) {
            return lVar == k.f5178b ? (R) this.f5115b : (lVar == k.f5177a || lVar == k.f5180d) ? (R) this.f5116c : (R) super.f(lVar);
        }

        @Override // e.c.a.w.e
        public boolean i(j jVar) {
            return this.f5117d.containsKey(jVar);
        }

        @Override // e.c.a.w.e
        public long l(j jVar) {
            if (this.f5117d.containsKey(jVar)) {
                return this.f5117d.get(jVar).longValue();
            }
            throw new n(c.a.a.a.a.c("Unsupported field: ", jVar));
        }

        public String toString() {
            return this.f5117d.toString() + "," + this.f5115b + "," + this.f5116c;
        }
    }

    public e(c cVar) {
        ArrayList<a> arrayList = new ArrayList<>();
        this.g = arrayList;
        this.f5110a = cVar.f5059b;
        this.f5111b = cVar.f5060c;
        this.f5112c = cVar.f;
        this.f5113d = cVar.g;
        arrayList.add(new a());
    }

    public boolean a(char c2, char c3) {
        return this.f5114e ? c2 == c3 : c2 == c3 || Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3);
    }

    public final a b() {
        ArrayList<a> arrayList = this.g;
        return arrayList.get(arrayList.size() - 1);
    }

    public void c(boolean z) {
        ArrayList<a> arrayList;
        int i;
        if (z) {
            arrayList = this.g;
            i = arrayList.size() - 2;
        } else {
            arrayList = this.g;
            i = arrayList.size() - 1;
        }
        arrayList.remove(i);
    }

    public h d() {
        h hVar = b().f5115b;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = this.f5112c;
        return hVar2 == null ? m.f5027d : hVar2;
    }

    public Long e(j jVar) {
        return b().f5117d.get(jVar);
    }

    public void f(p pVar) {
        c.b.a.a.c.n.c.T1(pVar, "zone");
        b().f5116c = pVar;
    }

    public int g(j jVar, long j, int i, int i2) {
        c.b.a.a.c.n.c.T1(jVar, "field");
        Long put = b().f5117d.put(jVar, Long.valueOf(j));
        return (put == null || put.longValue() == j) ? i2 : ~i;
    }

    public boolean h(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3) {
        if (i + i3 > charSequence.length() || i2 + i3 > charSequence2.length()) {
            return false;
        }
        if (this.f5114e) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (charSequence.charAt(i + i4) != charSequence2.charAt(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            char charAt = charSequence.charAt(i + i5);
            char charAt2 = charSequence2.charAt(i2 + i5);
            if (!(charAt == charAt2 || Character.toUpperCase(charAt) == Character.toUpperCase(charAt2) || Character.toLowerCase(charAt) == Character.toLowerCase(charAt2))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return b().toString();
    }

    public e(e eVar) {
        ArrayList<a> arrayList = new ArrayList<>();
        this.g = arrayList;
        this.f5110a = eVar.f5110a;
        this.f5111b = eVar.f5111b;
        this.f5112c = eVar.f5112c;
        this.f5113d = eVar.f5113d;
        this.f5114e = eVar.f5114e;
        this.f = eVar.f;
        arrayList.add(new a());
    }
}
