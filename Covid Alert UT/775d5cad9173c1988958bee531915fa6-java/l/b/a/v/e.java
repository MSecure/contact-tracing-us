package l.b.a.v;

import g.b.a.c.c.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import l.b.a.m;
import l.b.a.q;
import l.b.a.u.h;
import l.b.a.w.c;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.x.n;

public final class e {
    public Locale a;
    public j b;
    public h c;

    /* renamed from: d  reason: collision with root package name */
    public q f4470d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4471e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4472f = true;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<a> f4473g;

    public final class a extends c {
        public h b = null;
        public q c = null;

        /* renamed from: d  reason: collision with root package name */
        public final Map<j, Long> f4474d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        public boolean f4475e;

        /* renamed from: f  reason: collision with root package name */
        public m f4476f = m.f4381e;

        /* renamed from: g  reason: collision with root package name */
        public List<Object[]> f4477g;

        public a() {
        }

        @Override // l.b.a.x.e, l.b.a.w.c
        public int b(j jVar) {
            if (this.f4474d.containsKey(jVar)) {
                return d.B(this.f4474d.get(jVar).longValue());
            }
            throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }

        @Override // l.b.a.x.e, l.b.a.w.c
        public <R> R c(l<R> lVar) {
            return lVar == k.b ? (R) this.b : (lVar == k.a || lVar == k.f4522d) ? (R) this.c : (R) super.c(lVar);
        }

        @Override // l.b.a.x.e
        public boolean f(j jVar) {
            return this.f4474d.containsKey(jVar);
        }

        @Override // l.b.a.x.e
        public long i(j jVar) {
            if (this.f4474d.containsKey(jVar)) {
                return this.f4474d.get(jVar).longValue();
            }
            throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
        }

        public String toString() {
            return this.f4474d.toString() + "," + this.b + "," + this.c;
        }
    }

    public e(c cVar) {
        ArrayList<a> arrayList = new ArrayList<>();
        this.f4473g = arrayList;
        this.a = cVar.b;
        this.b = cVar.c;
        this.c = cVar.f4443f;
        this.f4470d = cVar.f4444g;
        arrayList.add(new a());
    }

    public boolean a(char c2, char c3) {
        if (this.f4471e) {
            return c2 == c3;
        }
        if (c2 == c3 || Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3)) {
            return true;
        }
        return false;
    }

    public final a b() {
        ArrayList<a> arrayList = this.f4473g;
        return arrayList.get(arrayList.size() - 1);
    }

    public void c(boolean z) {
        ArrayList<a> arrayList;
        int i2;
        if (z) {
            arrayList = this.f4473g;
            i2 = arrayList.size() - 2;
        } else {
            arrayList = this.f4473g;
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
        return hVar2 == null ? l.b.a.u.m.f4408d : hVar2;
    }

    public Long e(j jVar) {
        return b().f4474d.get(jVar);
    }

    public void f(q qVar) {
        d.u(qVar, "zone");
        b().c = qVar;
    }

    public int g(j jVar, long j2, int i2, int i3) {
        d.u(jVar, "field");
        Long put = b().f4474d.put(jVar, Long.valueOf(j2));
        return (put == null || put.longValue() == j2) ? i3 : ~i2;
    }

    public boolean h(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4) {
        if (i2 + i4 > charSequence.length() || i3 + i4 > charSequence2.length()) {
            return false;
        }
        if (this.f4471e) {
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
        this.f4473g = arrayList;
        this.a = eVar.a;
        this.b = eVar.b;
        this.c = eVar.c;
        this.f4470d = eVar.f4470d;
        this.f4471e = eVar.f4471e;
        this.f4472f = eVar.f4472f;
        arrayList.add(new a());
    }
}
