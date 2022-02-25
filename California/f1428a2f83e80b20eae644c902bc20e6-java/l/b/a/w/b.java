package l.b.a.w;

import l.b.a.c;

public enum b implements m {
    NANOS("Nanos", c.i(1)),
    MICROS("Micros", c.i(1000)),
    MILLIS("Millis", c.i(1000000)),
    SECONDS("Seconds", c.l(1)),
    MINUTES("Minutes", c.l(60)),
    HOURS("Hours", c.l(3600)),
    HALF_DAYS("HalfDays", c.l(43200)),
    DAYS("Days", c.l(86400)),
    WEEKS("Weeks", c.l(604800)),
    MONTHS("Months", c.l(2629746)),
    YEARS("Years", c.l(31556952)),
    DECADES("Decades", c.l(315569520)),
    CENTURIES("Centuries", c.l(3155695200L)),
    MILLENNIA("Millennia", c.l(31556952000L)),
    ERAS("Eras", c.l(31556952000000000L)),
    FOREVER("Forever", c.m(Long.MAX_VALUE, 999999999));
    
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
