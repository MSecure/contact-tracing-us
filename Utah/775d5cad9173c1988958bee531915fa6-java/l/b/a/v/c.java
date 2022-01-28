package l.b.a.v;

import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import l.b.a.b;
import l.b.a.q;
import l.b.a.u.h;
import l.b.a.u.m;
import l.b.a.v.d;
import l.b.a.v.e;
import l.b.a.x.a;
import l.b.a.x.c;
import l.b.a.x.e;
import l.b.a.x.j;
import l.b.a.x.l;

public final class c {

    /* renamed from: h  reason: collision with root package name */
    public static final c f4436h;

    /* renamed from: i  reason: collision with root package name */
    public static final c f4437i;

    /* renamed from: j  reason: collision with root package name */
    public static final c f4438j;

    /* renamed from: k  reason: collision with root package name */
    public static final c f4439k;

    /* renamed from: l  reason: collision with root package name */
    public static final c f4440l;
    public static final c m;
    public final d.e a;
    public final Locale b;
    public final j c;

    /* renamed from: d  reason: collision with root package name */
    public final l f4441d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<j> f4442e;

    /* renamed from: f  reason: collision with root package name */
    public final h f4443f;

    /* renamed from: g  reason: collision with root package name */
    public final q f4444g;

    static {
        d dVar = new d();
        a aVar = a.YEAR;
        m mVar = m.EXCEEDS_PAD;
        d n = dVar.n(aVar, 4, 10, mVar);
        n.d('-');
        a aVar2 = a.MONTH_OF_YEAR;
        n.m(aVar2, 2);
        n.d('-');
        a aVar3 = a.DAY_OF_MONTH;
        n.m(aVar3, 2);
        l lVar = l.STRICT;
        c s = n.s(lVar);
        m mVar2 = m.f4408d;
        c f2 = s.f(mVar2);
        f4436h = f2;
        d dVar2 = new d();
        d.o oVar = d.o.INSENSITIVE;
        dVar2.c(oVar);
        dVar2.a(f2);
        d.l lVar2 = d.l.f4459e;
        dVar2.c(lVar2);
        dVar2.s(lVar).f(mVar2);
        d dVar3 = new d();
        dVar3.c(oVar);
        dVar3.a(f2);
        dVar3.p();
        dVar3.c(lVar2);
        dVar3.s(lVar).f(mVar2);
        d dVar4 = new d();
        a aVar4 = a.HOUR_OF_DAY;
        dVar4.m(aVar4, 2);
        dVar4.d(':');
        a aVar5 = a.MINUTE_OF_HOUR;
        dVar4.m(aVar5, 2);
        dVar4.p();
        dVar4.d(':');
        a aVar6 = a.SECOND_OF_MINUTE;
        dVar4.m(aVar6, 2);
        dVar4.p();
        dVar4.b(a.NANO_OF_SECOND, 0, 9, true);
        c s2 = dVar4.s(lVar);
        f4437i = s2;
        d dVar5 = new d();
        dVar5.c(oVar);
        dVar5.a(s2);
        dVar5.c(lVar2);
        dVar5.s(lVar);
        d dVar6 = new d();
        dVar6.c(oVar);
        dVar6.a(s2);
        dVar6.p();
        dVar6.c(lVar2);
        dVar6.s(lVar);
        d dVar7 = new d();
        dVar7.c(oVar);
        dVar7.a(f2);
        dVar7.d('T');
        dVar7.a(s2);
        c f3 = dVar7.s(lVar).f(mVar2);
        f4438j = f3;
        d dVar8 = new d();
        dVar8.c(oVar);
        dVar8.a(f3);
        dVar8.c(lVar2);
        c f4 = dVar8.s(lVar).f(mVar2);
        f4439k = f4;
        d dVar9 = new d();
        dVar9.a(f4);
        dVar9.p();
        dVar9.d('[');
        d.o oVar2 = d.o.SENSITIVE;
        dVar9.c(oVar2);
        l<q> lVar3 = d.f4445h;
        dVar9.c(new d.s(lVar3, "ZoneRegionId()"));
        dVar9.d(']');
        dVar9.s(lVar).f(mVar2);
        d dVar10 = new d();
        dVar10.a(f3);
        dVar10.p();
        dVar10.c(lVar2);
        dVar10.p();
        dVar10.d('[');
        dVar10.c(oVar2);
        dVar10.c(new d.s(lVar3, "ZoneRegionId()"));
        dVar10.d(']');
        dVar10.s(lVar).f(mVar2);
        d dVar11 = new d();
        dVar11.c(oVar);
        d n2 = dVar11.n(aVar, 4, 10, mVar);
        n2.d('-');
        n2.m(a.DAY_OF_YEAR, 3);
        n2.p();
        n2.c(lVar2);
        n2.s(lVar).f(mVar2);
        d dVar12 = new d();
        dVar12.c(oVar);
        l.b.a.x.m mVar3 = l.b.a.x.c.a;
        d n3 = dVar12.n(c.b.WEEK_BASED_YEAR, 4, 10, mVar);
        n3.e("-W");
        n3.m(c.b.WEEK_OF_WEEK_BASED_YEAR, 2);
        n3.d('-');
        a aVar7 = a.DAY_OF_WEEK;
        n3.m(aVar7, 1);
        n3.p();
        n3.c(lVar2);
        n3.s(lVar).f(mVar2);
        d dVar13 = new d();
        dVar13.c(oVar);
        dVar13.c(new d.h(-2));
        f4440l = dVar13.s(lVar);
        d dVar14 = new d();
        dVar14.c(oVar);
        dVar14.m(aVar, 4);
        dVar14.m(aVar2, 2);
        dVar14.m(aVar3, 2);
        dVar14.p();
        dVar14.g("+HHMMss", "Z");
        dVar14.s(lVar).f(mVar2);
        HashMap hashMap = new HashMap();
        hashMap.put(1L, "Mon");
        hashMap.put(2L, "Tue");
        hashMap.put(3L, "Wed");
        hashMap.put(4L, "Thu");
        hashMap.put(5L, "Fri");
        hashMap.put(6L, "Sat");
        hashMap.put(7L, "Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(1L, "Jan");
        hashMap2.put(2L, "Feb");
        hashMap2.put(3L, "Mar");
        hashMap2.put(4L, "Apr");
        hashMap2.put(5L, "May");
        hashMap2.put(6L, "Jun");
        hashMap2.put(7L, "Jul");
        hashMap2.put(8L, "Aug");
        hashMap2.put(9L, "Sep");
        hashMap2.put(10L, "Oct");
        hashMap2.put(11L, "Nov");
        hashMap2.put(12L, "Dec");
        d dVar15 = new d();
        dVar15.c(oVar);
        dVar15.c(d.o.LENIENT);
        dVar15.p();
        dVar15.i(aVar7, hashMap);
        dVar15.e(", ");
        dVar15.o();
        d n4 = dVar15.n(aVar3, 1, 2, m.NOT_NEGATIVE);
        n4.d(' ');
        n4.i(aVar2, hashMap2);
        n4.d(' ');
        n4.m(aVar, 4);
        n4.d(' ');
        n4.m(aVar4, 2);
        n4.d(':');
        n4.m(aVar5, 2);
        n4.p();
        n4.d(':');
        n4.m(aVar6, 2);
        n4.o();
        n4.d(' ');
        n4.g("+HHMM", "GMT");
        m = n4.s(l.SMART).f(mVar2);
    }

    public c(d.e eVar, Locale locale, j jVar, l lVar, Set<j> set, h hVar, q qVar) {
        g.b.a.c.c.d.u(eVar, "printerParser");
        this.a = eVar;
        g.b.a.c.c.d.u(locale, "locale");
        this.b = locale;
        g.b.a.c.c.d.u(jVar, "decimalStyle");
        this.c = jVar;
        g.b.a.c.c.d.u(lVar, "resolverStyle");
        this.f4441d = lVar;
        this.f4442e = set;
        this.f4443f = hVar;
        this.f4444g = qVar;
    }

    public static c c(k kVar) {
        g.b.a.c.c.d.u(kVar, "dateStyle");
        d dVar = new d();
        dVar.c(new d.j(kVar, null));
        return dVar.q().f(m.f4408d);
    }

    public final f a(CharSequence charSequence, RuntimeException runtimeException) {
        String str;
        if (charSequence.length() > 64) {
            str = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            str = charSequence.toString();
        }
        StringBuilder j2 = f.a.a.a.a.j("Text '", str, "' could not be parsed: ");
        j2.append(runtimeException.getMessage());
        return new f(j2.toString(), charSequence, 0, runtimeException);
    }

    public String b(e eVar) {
        StringBuilder sb = new StringBuilder(32);
        g.b.a.c.c.d.u(eVar, "temporal");
        g.b.a.c.c.d.u(sb, "appendable");
        try {
            this.a.a(new h(eVar, this), sb);
            return sb.toString();
        } catch (IOException e2) {
            throw new b(e2.getMessage(), e2);
        }
    }

    public final a d(CharSequence charSequence, ParsePosition parsePosition) {
        e.a aVar;
        String str;
        ParsePosition parsePosition2 = new ParsePosition(0);
        g.b.a.c.c.d.u(charSequence, "text");
        g.b.a.c.c.d.u(parsePosition2, "position");
        e eVar = new e(this);
        int b2 = this.a.b(eVar, charSequence, parsePosition2.getIndex());
        if (b2 < 0) {
            parsePosition2.setErrorIndex(~b2);
            aVar = null;
        } else {
            parsePosition2.setIndex(b2);
            aVar = eVar.b();
        }
        if (aVar == null || parsePosition2.getErrorIndex() >= 0 || parsePosition2.getIndex() < charSequence.length()) {
            if (charSequence.length() > 64) {
                str = charSequence.subSequence(0, 64).toString() + "...";
            } else {
                str = charSequence.toString();
            }
            if (parsePosition2.getErrorIndex() >= 0) {
                StringBuilder j2 = f.a.a.a.a.j("Text '", str, "' could not be parsed at index ");
                j2.append(parsePosition2.getErrorIndex());
                throw new f(j2.toString(), charSequence, parsePosition2.getErrorIndex());
            }
            StringBuilder j3 = f.a.a.a.a.j("Text '", str, "' could not be parsed, unparsed text found at index ");
            j3.append(parsePosition2.getIndex());
            throw new f(j3.toString(), charSequence, parsePosition2.getIndex());
        }
        a aVar2 = new a();
        aVar2.b.putAll(aVar.f4474d);
        aVar2.c = e.this.d();
        q qVar = aVar.c;
        if (qVar == null) {
            qVar = e.this.f4470d;
        }
        aVar2.f4431d = qVar;
        aVar2.f4434g = aVar.f4475e;
        aVar2.f4435h = aVar.f4476f;
        return aVar2;
    }

    public d.e e(boolean z) {
        d.e eVar = this.a;
        return z == eVar.c ? eVar : new d.e(eVar.b, z);
    }

    public c f(h hVar) {
        return g.b.a.c.c.d.h(this.f4443f, hVar) ? this : new c(this.a, this.b, this.c, this.f4441d, this.f4442e, hVar, this.f4444g);
    }

    public c g(Locale locale) {
        return this.b.equals(locale) ? this : new c(this.a, locale, this.c, this.f4441d, this.f4442e, this.f4443f, this.f4444g);
    }

    public c h(q qVar) {
        return g.b.a.c.c.d.h(this.f4444g, qVar) ? this : new c(this.a, this.b, this.c, this.f4441d, this.f4442e, this.f4443f, qVar);
    }

    public String toString() {
        String eVar = this.a.toString();
        return eVar.startsWith("[") ? eVar : eVar.substring(1, eVar.length() - 1);
    }
}
