package l.b.a.u;

import f.b.a.c.b.o.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import l.b.a.l;
import l.b.a.p;
import l.b.a.t.h;
import l.b.a.t.m;
import l.b.a.v.c;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.n;

public final class e {
    public Locale a;
    public j b;
    public h c;

    /* renamed from: d  reason: collision with root package name */
    public p f4146d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4147e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4148f = true;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<a> f4149g;

    public final class a extends c {
        public h b = null;
        public p c = null;

        /* renamed from: d  reason: collision with root package name */
        public final Map<j, Long> f4150d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        public boolean f4151e;

        /* renamed from: f  reason: collision with root package name */
        public l f4152f = l.f4057e;

        /* renamed from: g  reason: collision with root package name */
        public List<Object[]> f4153g;

        public a() {
        }

        @Override // l.b.a.v.c, l.b.a.w.e
        public int b(j jVar) {
            if (this.f4150d.containsKey(jVar)) {
                return b.M1(this.f4150d.get(jVar).longValue());
            }
            throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }

        @Override // l.b.a.v.c, l.b.a.w.e
        public <R> R c(l.b.a.w.l<R> lVar) {
            return lVar == k.b ? (R) this.b : (lVar == k.a || lVar == k.f4198d) ? (R) this.c : (R) super.c(lVar);
        }

        @Override // l.b.a.w.e
        public boolean f(j jVar) {
            return this.f4150d.containsKey(jVar);
        }

        @Override // l.b.a.w.e
        public long i(j jVar) {
            if (this.f4150d.containsKey(jVar)) {
                return this.f4150d.get(jVar).longValue();
            }
            throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }

        public String toString() {
            return this.f4150d.toString() + "," + this.b + "," + this.c;
        }
    }

    public e(c cVar) {
        ArrayList<a> arrayList = new ArrayList<>();
        this.f4149g = arrayList;
        this.a = cVar.b;
        this.b = cVar.c;
        this.c = cVar.f4119f;
        this.f4146d = cVar.f4120g;
        arrayList.add(new a());
    }

    public boolean a(char c2, char c3) {
        if (this.f4147e) {
            return c2 == c3;
        }
        if (c2 == c3 || Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3)) {
            return true;
        }
        return false;
    }

    public final a b() {
        ArrayList<a> arrayList = this.f4149g;
        return arrayList.get(arrayList.size() - 1);
    }

    public void c(boolean z) {
        ArrayList<a> arrayList;
        int i2;
        if (z) {
            arrayList = this.f4149g;
            i2 = arrayList.size() - 2;
        } else {
            arrayList = this.f4149g;
            i2 = arrayList.size() - 1;
        }
        arrayList.remove(i2);
    }

    public h d() {
        h hVar = b().b;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = this.c;
        return hVar2 == null ? m.f4084d : hVar2;
    }

    public Long e(j jVar) {
        return b().f4150d.get(jVar);
    }

    public void f(p pVar) {
        b.B1(pVar, "zone");
        b().c = pVar;
    }

    public int g(j jVar, long j2, int i2, int i3) {
        b.B1(jVar, "field");
        Long put = b().f4150d.put(jVar, Long.valueOf(j2));
        return (put == null || put.longValue() == j2) ? i3 : ~i2;
    }

    public boolean h(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4) {
        if (i2 + i4 > charSequence.length() || i3 + i4 > charSequence2.length()) {
            return false;
        }
        if (this.f4147e) {
            for (int i5 = 0; i5 < i4; i5++) {
                if (charSequence.charAt(i2 + i5) != charSequence2.charAt(i3 + i5)) {
                    return false;
                }
            }
            return true;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            char charAt = charSequence.charAt(i2 + i6);
            char charAt2 = charSequence2.charAt(i3 + i6);
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
        this.f4149g = arrayList;
        this.a = eVar.a;
        this.b = eVar.b;
        this.c = eVar.c;
        this.f4146d = eVar.f4146d;
        this.f4147e = eVar.f4147e;
        this.f4148f = eVar.f4148f;
        arrayList.add(new a());
    }
}
