package l.b.a.x;

import l.b.a.d;

public enum b implements m {
    NANOS("Nanos", d.m(1)),
    MICROS("Micros", d.m(1000)),
    MILLIS("Millis", d.m(1000000)),
    SECONDS("Seconds", d.n(1)),
    MINUTES("Minutes", d.n(60)),
    HOURS("Hours", d.n(3600)),
    HALF_DAYS("HalfDays", d.n(43200)),
    DAYS("Days", d.n(86400)),
    WEEKS("Weeks", d.n(604800)),
    MONTHS("Months", d.n(2629746)),
    YEARS("Years", d.n(31556952)),
    DECADES("Decades", d.n(315569520)),
    CENTURIES("Centuries", d.n(3155695200L)),
    MILLENNIA("Millennia", d.n(31556952000L)),
    ERAS("Eras", d.n(31556952000000000L)),
    FOREVER("Forever", d.o(Long.MAX_VALUE, 999999999));
    
    public final String b;

    /* access modifiers changed from: public */
    b(String str, d dVar) {
        this.b = str;
    }

    @Override // l.b.a.x.m
    public boolean a() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    @Override // l.b.a.x.m
    public long b(d dVar, d dVar2) {
        return dVar.o(dVar2, this);
    }

    @Override // l.b.a.x.m
    public <R extends d> R c(R r, long j2) {
        return (R) r.m(j2, this);
    }

    public String toString() {
        return this.b;
    }
}
