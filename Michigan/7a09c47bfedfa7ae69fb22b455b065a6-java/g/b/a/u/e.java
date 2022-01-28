package g.b.a.u;

import b.x.t;
import g.b.a.l;
import g.b.a.p;
import g.b.a.t.h;
import g.b.a.t.m;
import g.b.a.v.c;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public Locale f6574a;

    /* renamed from: b  reason: collision with root package name */
    public j f6575b;

    /* renamed from: c  reason: collision with root package name */
    public h f6576c;

    /* renamed from: d  reason: collision with root package name */
    public p f6577d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6578e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6579f = true;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<a> f6580g;

    public final class a extends c {

        /* renamed from: b  reason: collision with root package name */
        public h f6581b = null;

        /* renamed from: c  reason: collision with root package name */
        public p f6582c = null;

        /* renamed from: d  reason: collision with root package name */
        public final Map<j, Long> f6583d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        public boolean f6584e;

        /* renamed from: f  reason: collision with root package name */
        public l f6585f = l.f6434e;

        /* renamed from: g  reason: collision with root package name */
        public List<Object[]> f6586g;

        public a() {
        }

        @Override // g.b.a.w.e, g.b.a.v.c
        public int d(j jVar) {
            if (this.f6583d.containsKey(jVar)) {
                return t.I2(this.f6583d.get(jVar).longValue());
            }
            throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
        }

        @Override // g.b.a.w.e, g.b.a.v.c
        public <R> R f(g.b.a.w.l<R> lVar) {
            return lVar == k.f6657b ? (R) this.f6581b : (lVar == k.f6656a || lVar == k.f6659d) ? (R) this.f6582c : (R) super.f(lVar);
        }

        @Override // g.b.a.w.e
        public boolean k(j jVar) {
            return this.f6583d.containsKey(jVar);
        }

        @Override // g.b.a.w.e
        public long n(j jVar) {
            if (this.f6583d.containsKey(jVar)) {
                return this.f6583d.get(jVar).longValue();
            }
            throw new n(c.a.a.a.a.d("Unsupported field: ", jVar));
        }

        public String toString() {
            return this.f6583d.toString() + "," + this.f6581b + "," + this.f6582c;
        }
    }

    public e(c cVar) {
        ArrayList<a> arrayList = new ArrayList<>();
        this.f6580g = arrayList;
        this.f6574a = cVar.f6516b;
        this.f6575b = cVar.f6517c;
        this.f6576c = cVar.f6520f;
        this.f6577d = cVar.f6521g;
        arrayList.add(new a());
    }

    public boolean a(char c2, char c3) {
        return this.f6578e ? c2 == c3 : c2 == c3 || Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3);
    }

    public final a b() {
        ArrayList<a> arrayList = this.f6580g;
        return arrayList.get(arrayList.size() - 1);
    }

    public void c(boolean z) {
        ArrayList<a> arrayList;
        int i;
        if (z) {
            arrayList = this.f6580g;
            i = arrayList.size() - 2;
        } else {
            arrayList = this.f6580g;
            i = arrayList.size() - 1;
        }
        arrayList.remove(i);
    }

    public h d() {
        h hVar = b().f6581b;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = this.f6576c;
        return hVar2 == null ? m.f6476d : hVar2;
    }

    public Long e(j jVar) {
        return b().f6583d.get(jVar);
    }

    public void f(p pVar) {
        t.y2(pVar, "zone");
        b().f6582c = pVar;
    }

    public int g(j jVar, long j, int i, int i2) {
        t.y2(jVar, "field");
        Long put = b().f6583d.put(jVar, Long.valueOf(j));
        return (put == null || put.longValue() == j) ? i2 : ~i;
    }

    public boolean h(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3) {
        if (i + i3 > charSequence.length() || i2 + i3 > charSequence2.length()) {
            return false;
        }
        if (this.f6578e) {
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
        this.f6580g = arrayList;
        this.f6574a = eVar.f6574a;
        this.f6575b = eVar.f6575b;
        this.f6576c = eVar.f6576c;
        this.f6577d = eVar.f6577d;
        this.f6578e = eVar.f6578e;
        this.f6579f = eVar.f6579f;
        arrayList.add(new a());
    }
}
