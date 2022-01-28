package e.c.a.u;

import e.c.a.p;
import e.c.a.t.h;
import e.c.a.t.m;
import e.c.a.u.d;
import e.c.a.u.e;
import e.c.a.w.a;
import e.c.a.w.e;
import e.c.a.w.j;
import e.c.a.w.l;
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
    public final d.e f5058a;

    /* renamed from: b  reason: collision with root package name */
    public final Locale f5059b;

    /* renamed from: c  reason: collision with root package name */
    public final j f5060c;

    /* renamed from: d  reason: collision with root package name */
    public final l f5061d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<j> f5062e;
    public final h f;
    public final p g;

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
        h = n.s(lVar).f(m.f5027d);
        d dVar = new d();
        dVar.c(oVar2);
        dVar.a(h);
        dVar.c(d.l.f5085e);
        dVar.s(lVar).f(m.f5027d);
        d dVar2 = new d();
        dVar2.c(oVar2);
        dVar2.a(h);
        dVar2.p();
        dVar2.c(d.l.f5085e);
        dVar2.s(lVar).f(m.f5027d);
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
        dVar4.c(d.l.f5085e);
        dVar4.s(lVar);
        d dVar5 = new d();
        dVar5.c(oVar2);
        dVar5.a(i);
        dVar5.p();
        dVar5.c(d.l.f5085e);
        dVar5.s(lVar);
        d dVar6 = new d();
        dVar6.c(oVar2);
        dVar6.a(h);
        dVar6.d('T');
        dVar6.a(i);
        j = dVar6.s(lVar).f(m.f5027d);
        d dVar7 = new d();
        dVar7.c(oVar2);
        dVar7.a(j);
        dVar7.c(d.l.f5085e);
        k = dVar7.s(lVar).f(m.f5027d);
        d dVar8 = new d();
        dVar8.a(k);
        dVar8.p();
        dVar8.d('[');
        dVar8.c(oVar);
        dVar8.c(new d.s(d.h, "ZoneRegionId()"));
        dVar8.d(']');
        l = dVar8.s(lVar).f(m.f5027d);
        d dVar9 = new d();
        dVar9.a(j);
        dVar9.p();
        dVar9.c(d.l.f5085e);
        dVar9.p();
        dVar9.d('[');
        dVar9.c(oVar);
        dVar9.c(new d.s(d.h, "ZoneRegionId()"));
        dVar9.d(']');
        dVar9.s(lVar).f(m.f5027d);
        d dVar10 = new d();
        dVar10.c(oVar2);
        d n2 = dVar10.n(a.YEAR, 4, 10, mVar);
        n2.d('-');
        n2.m(a.DAY_OF_YEAR, 3);
        n2.p();
        n2.c(d.l.f5085e);
        n2.s(lVar).f(m.f5027d);
        d dVar11 = new d();
        dVar11.c(oVar2);
        d n3 = dVar11.n(e.c.a.w.c.f5165c, 4, 10, mVar);
        n3.e("-W");
        n3.m(e.c.a.w.c.f5164b, 2);
        n3.d('-');
        n3.m(a.DAY_OF_WEEK, 1);
        n3.p();
        n3.c(d.l.f5085e);
        n3.s(lVar).f(m.f5027d);
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
        dVar13.s(lVar).f(m.f5027d);
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
        n4.s(l.SMART).f(m.f5027d);
    }

    public c(d.e eVar, Locale locale, j jVar, l lVar, Set<j> set, h hVar, p pVar) {
        c.b.a.a.c.n.c.T1(eVar, "printerParser");
        this.f5058a = eVar;
        c.b.a.a.c.n.c.T1(locale, "locale");
        this.f5059b = locale;
        c.b.a.a.c.n.c.T1(jVar, "decimalStyle");
        this.f5060c = jVar;
        c.b.a.a.c.n.c.T1(lVar, "resolverStyle");
        this.f5061d = lVar;
        this.f5062e = set;
        this.f = hVar;
        this.g = pVar;
    }

    public static c b(k kVar) {
        c.b.a.a.c.n.c.T1(kVar, "dateStyle");
        d dVar = new d();
        dVar.c(new d.j(kVar, null));
        return dVar.q().f(m.f5027d);
    }

    public String a(e eVar) {
        StringBuilder sb = new StringBuilder(32);
        c.b.a.a.c.n.c.T1(eVar, "temporal");
        c.b.a.a.c.n.c.T1(sb, "appendable");
        try {
            this.f5058a.b(new h(eVar, this), sb);
            return sb.toString();
        } catch (IOException e2) {
            throw new e.c.a.a(e2.getMessage(), e2);
        }
    }

    public <T> T c(CharSequence charSequence, l<T> lVar) {
        String str;
        c.b.a.a.c.n.c.T1(charSequence, "text");
        c.b.a.a.c.n.c.T1(lVar, "type");
        try {
            a d2 = d(charSequence, null);
            d2.z(this.f5061d, this.f5062e);
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
        c.b.a.a.c.n.c.T1(charSequence, "text");
        c.b.a.a.c.n.c.T1(parsePosition2, "position");
        e eVar = new e(this);
        int d2 = this.f5058a.d(eVar, charSequence, parsePosition2.getIndex());
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
        aVar2.f5054b.putAll(aVar.f5117d);
        aVar2.f5055c = e.this.d();
        p pVar = aVar.f5116c;
        if (pVar == null) {
            pVar = e.this.f5113d;
        }
        aVar2.f5056d = pVar;
        aVar2.g = aVar.f5118e;
        aVar2.h = aVar.f;
        return aVar2;
    }

    public d.e e(boolean z) {
        d.e eVar = this.f5058a;
        return z == eVar.f5071c ? eVar : new d.e(eVar.f5070b, z);
    }

    public c f(h hVar) {
        return c.b.a.a.c.n.c.L0(this.f, hVar) ? this : new c(this.f5058a, this.f5059b, this.f5060c, this.f5061d, this.f5062e, hVar, this.g);
    }

    public c g(Locale locale) {
        return this.f5059b.equals(locale) ? this : new c(this.f5058a, locale, this.f5060c, this.f5061d, this.f5062e, this.f, this.g);
    }

    public c h(p pVar) {
        return c.b.a.a.c.n.c.L0(this.g, pVar) ? this : new c(this.f5058a, this.f5059b, this.f5060c, this.f5061d, this.f5062e, this.f, pVar);
    }

    public String toString() {
        String eVar = this.f5058a.toString();
        return eVar.startsWith("[") ? eVar : eVar.substring(1, eVar.length() - 1);
    }
}
