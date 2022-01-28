package g.b.a.w;

import g.b.a.c;

public enum b implements m {
    NANOS("Nanos", c.k(1)),
    MICROS("Micros", c.k(1000)),
    MILLIS("Millis", c.k(1000000)),
    SECONDS("Seconds", c.m(1)),
    MINUTES("Minutes", c.m(60)),
    HOURS("Hours", c.m(3600)),
    HALF_DAYS("HalfDays", c.m(43200)),
    DAYS("Days", c.m(86400)),
    WEEKS("Weeks", c.m(604800)),
    MONTHS("Months", c.m(2629746)),
    YEARS("Years", c.m(31556952)),
    DECADES("Decades", c.m(315569520)),
    CENTURIES("Centuries", c.m(3155695200L)),
    MILLENNIA("Millennia", c.m(31556952000L)),
    ERAS("Eras", c.m(31556952000000000L)),
    FOREVER("Forever", c.n(Long.MAX_VALUE, 999999999));
    

    /* renamed from: b  reason: collision with root package name */
    public final String f6639b;

    /* access modifiers changed from: public */
    b(String str, c cVar) {
        this.f6639b = str;
    }

    @Override // g.b.a.w.m
    public boolean b() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    @Override // g.b.a.w.m
    public long d(d dVar, d dVar2) {
        return dVar.y(dVar2, this);
    }

    @Override // g.b.a.w.m
    public <R extends d> R f(R r, long j) {
        return (R) r.s(j, this);
    }

    public String toString() {
        return this.f6639b;
    }
}
