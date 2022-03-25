package l.b.a.w;

import l.b.a.c;

public enum b implements m {
    NANOS("Nanos", c.l(1)),
    MICROS("Micros", c.l(1000)),
    MILLIS("Millis", c.l(1000000)),
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
    
    public final String b;

    /* access modifiers changed from: public */
    b(String str, c cVar) {
        this.b = str;
    }

    @Override // l.b.a.w.m
    public boolean a() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    @Override // l.b.a.w.m
    public long b(d dVar, d dVar2) {
        return dVar.o(dVar2, this);
    }

    @Override // l.b.a.w.m
    public <R extends d> R c(R r, long j2) {
        return (R) r.m(j2, this);
    }

    public String toString() {
        return this.b;
    }
}
