package g.b.a.u;

import b.x.t;
import g.b.a.p;
import g.b.a.t.h;
import g.b.a.t.m;
import g.b.a.u.d;
import g.b.a.u.e;
import g.b.a.w.a;
import g.b.a.w.e;
import g.b.a.w.j;
import g.b.a.w.l;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

public final class c {
    public static final c h;
    public static final c i;
    public static final c j;
    public static final c k;
    public static final c l;
    public static final c m;

    /* renamed from: a  reason: collision with root package name */
    public final d.e f6515a;

    /* renamed from: b  reason: collision with root package name */
    public final Locale f6516b;

    /* renamed from: c  reason: collision with root package name */
    public final j f6517c;

    /* renamed from: d  reason: collision with root package name */
    public final l f6518d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<j> f6519e;

    /* renamed from: f  reason: collision with root package name */
    public final h f6520f;

    /* renamed from: g  reason: collision with root package name */
    public final p f6521g;

    static {
        d.o oVar = d.o.SENSITIVE;
        m mVar = m.EXCEEDS_PAD;
        d.o oVar2 = d.o.INSENSITIVE;
        l lVar = l.STRICT;
        d n = new d().n(a.YEAR, 4, 10, mVar);
        n.d('-');
        n.m(a.MONTH_OF_YEAR, 2);
        n.d('-');
        n.m(a.DAY_OF_MONTH, 2);
        h = n.s(lVar).f(m.f6476d);
        d dVar = new d();
        dVar.c(oVar2);
        dVar.a(h);
        dVar.c(d.l.f6548e);
        dVar.s(lVar).f(m.f6476d);
        d dVar2 = new d();
        dVar2.c(oVar2);
        dVar2.a(h);
        dVar2.p();
        dVar2.c(d.l.f6548e);
        dVar2.s(lVar).f(m.f6476d);
        d dVar3 = new d();
        dVar3.m(a.HOUR_OF_DAY, 2);
        dVar3.d(':');
        dVar3.m(a.MINUTE_OF_HOUR, 2);
        dVar3.p();
        dVar3.d(':');
        dVar3.m(a.SECOND_OF_MINUTE, 2);
        dVar3.p();
        dVar3.b(a.NANO_OF_SECOND, 0, 9, true);
        i = dVar3.s(lVar);
        d dVar4 = new d();
        dVar4.c(oVar2);
        dVar4.a(i);
        dVar4.c(d.l.f6548e);
        dVar4.s(lVar);
        d dVar5 = new d();
        dVar5.c(oVar2);
        dVar5.a(i);
        dVar5.p();
        dVar5.c(d.l.f6548e);
        dVar5.s(lVar);
        d dVar6 = new d();
        dVar6.c(oVar2);
        dVar6.a(h);
        dVar6.d('T');
        dVar6.a(i);
        j = dVar6.s(lVar).f(m.f6476d);
        d dVar7 = new d();
        dVar7.c(oVar2);
        dVar7.a(j);
        dVar7.c(d.l.f6548e);
        k = dVar7.s(lVar).f(m.f6476d);
        d dVar8 = new d();
        dVar8.a(k);
        dVar8.p();
        dVar8.d('[');
        dVar8.c(oVar);
        dVar8.c(new d.s(d.h, "ZoneRegionId()"));
        dVar8.d(']');
        l = dVar8.s(lVar).f(m.f6476d);
        d dVar9 = new d();
        dVar9.a(j);
        dVar9.p();
        dVar9.c(d.l.f6548e);
        dVar9.p();
        dVar9.d('[');
        dVar9.c(oVar);
        dVar9.c(new d.s(d.h, "ZoneRegionId()"));
        dVar9.d(']');
        dVar9.s(lVar).f(m.f6476d);
        d dVar10 = new d();
        dVar10.c(oVar2);
        d n2 = dVar10.n(a.YEAR, 4, 10, mVar);
        n2.d('-');
        n2.m(a.DAY_OF_YEAR, 3);
        n2.p();
        n2.c(d.l.f6548e);
        n2.s(lVar).f(m.f6476d);
        d dVar11 = new d();
        dVar11.c(oVar2);
        d n3 = dVar11.n(g.b.a.w.c.f6642c, 4, 10, mVar);
        n3.e("-W");
        n3.m(g.b.a.w.c.f6641b, 2);
        n3.d('-');
        n3.m(a.DAY_OF_WEEK, 1);
        n3.p();
        n3.c(d.l.f6548e);
        n3.s(lVar).f(m.f6476d);
        d dVar12 = new d();
        dVar12.c(oVar2);
        dVar12.c(new d.h(-2));
        m = dVar12.s(lVar);
        d dVar13 = new d();
        dVar13.c(oVar2);
        dVar13.m(a.YEAR, 4);
        dVar13.m(a.MONTH_OF_YEAR, 2);
        dVar13.m(a.DAY_OF_MONTH, 2);
        dVar13.p();
        dVar13.g("+HHMMss", "Z");
        dVar13.s(lVar).f(m.f6476d);
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
        d dVar14 = new d();
        dVar14.c(oVar2);
        dVar14.c(d.o.LENIENT);
        dVar14.p();
        dVar14.i(a.DAY_OF_WEEK, hashMap);
        dVar14.e(", ");
        dVar14.o();
        d n4 = dVar14.n(a.DAY_OF_MONTH, 1, 2, m.NOT_NEGATIVE);
        n4.d(' ');
        n4.i(a.MONTH_OF_YEAR, hashMap2);
        n4.d(' ');
        n4.m(a.YEAR, 4);
        n4.d(' ');
        n4.m(a.HOUR_OF_DAY, 2);
        n4.d(':');
        n4.m(a.MINUTE_OF_HOUR, 2);
        n4.p();
        n4.d(':');
        n4.m(a.SECOND_OF_MINUTE, 2);
        n4.o();
        n4.d(' ');
        n4.g("+HHMM", "GMT");
        n4.s(l.SMART).f(m.f6476d);
    }

    public c(d.e eVar, Locale locale, j jVar, l lVar, Set<j> set, h hVar, p pVar) {
        t.y2(eVar, "printerParser");
        this.f6515a = eVar;
        t.y2(locale, "locale");
        this.f6516b = locale;
        t.y2(jVar, "decimalStyle");
        this.f6517c = jVar;
        t.y2(lVar, "resolverStyle");
        this.f6518d = lVar;
        this.f6519e = set;
        this.f6520f = hVar;
        this.f6521g = pVar;
    }

    public static c b(k kVar) {
        t.y2(kVar, "dateStyle");
        d dVar = new d();
        dVar.c(new d.j(kVar, null));
        return dVar.q().f(m.f6476d);
    }

    public String a(e eVar) {
        StringBuilder sb = new StringBuilder(32);
        t.y2(eVar, "temporal");
        t.y2(sb, "appendable");
        try {
            this.f6515a.b(new h(eVar, this), sb);
            return sb.toString();
        } catch (IOException e2) {
            throw new g.b.a.a(e2.getMessage(), e2);
        }
    }

    public <T> T c(CharSequence charSequence, l<T> lVar) {
        String str;
        t.y2(charSequence, "text");
        t.y2(lVar, "type");
        try {
            a d2 = d(charSequence, null);
            d2.P(this.f6518d, this.f6519e);
            return lVar.a(d2);
        } catch (f e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (charSequence.length() > 64) {
                str = charSequence.subSequence(0, 64).toString() + "...";
            } else {
                str = charSequence.toString();
            }
            throw new f("Text '" + str + "' could not be parsed: " + e3.getMessage(), charSequence, 0, e3);
        }
    }

    public final a d(CharSequence charSequence, ParsePosition parsePosition) {
        e.a aVar;
        String str;
        ParsePosition parsePosition2 = new ParsePosition(0);
        t.y2(charSequence, "text");
        t.y2(parsePosition2, "position");
        e eVar = new e(this);
        int d2 = this.f6515a.d(eVar, charSequence, parsePosition2.getIndex());
        if (d2 < 0) {
            parsePosition2.setErrorIndex(~d2);
            aVar = null;
        } else {
            parsePosition2.setIndex(d2);
            aVar = eVar.b();
        }
        if (aVar == null || parsePosition2.getErrorIndex() >= 0 || parsePosition2.getIndex() < charSequence.length()) {
            if (charSequence.length() > 64) {
                str = charSequence.subSequence(0, 64).toString() + "...";
            } else {
                str = charSequence.toString();
            }
            if (parsePosition2.getErrorIndex() >= 0) {
                throw new f("Text '" + str + "' could not be parsed at index " + parsePosition2.getErrorIndex(), charSequence, parsePosition2.getErrorIndex());
            }
            throw new f("Text '" + str + "' could not be parsed, unparsed text found at index " + parsePosition2.getIndex(), charSequence, parsePosition2.getIndex());
        }
        a aVar2 = new a();
        aVar2.f6509b.putAll(aVar.f6583d);
        aVar2.f6510c = e.this.d();
        p pVar = aVar.f6582c;
        if (pVar == null) {
            pVar = e.this.f6577d;
        }
        aVar2.f6511d = pVar;
        aVar2.f6514g = aVar.f6584e;
        aVar2.h = aVar.f6585f;
        return aVar2;
    }

    public d.e e(boolean z) {
        d.e eVar = this.f6515a;
        return z == eVar.f6532c ? eVar : new d.e(eVar.f6531b, z);
    }

    public c f(h hVar) {
        return t.n1(this.f6520f, hVar) ? this : new c(this.f6515a, this.f6516b, this.f6517c, this.f6518d, this.f6519e, hVar, this.f6521g);
    }

    public c g(Locale locale) {
        return this.f6516b.equals(locale) ? this : new c(this.f6515a, locale, this.f6517c, this.f6518d, this.f6519e, this.f6520f, this.f6521g);
    }

    public c h(p pVar) {
        return t.n1(this.f6521g, pVar) ? this : new c(this.f6515a, this.f6516b, this.f6517c, this.f6518d, this.f6519e, this.f6520f, pVar);
    }

    public String toString() {
        String eVar = this.f6515a.toString();
        return eVar.startsWith("[") ? eVar : eVar.substring(1, eVar.length() - 1);
    }
}
