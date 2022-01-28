package e.c.a.w;

import androidx.recyclerview.widget.RecyclerView;
import e.c.a.c;

public enum b implements m {
    NANOS("Nanos", c.i(1)),
    MICROS("Micros", c.i(1000)),
    MILLIS("Millis", c.i(1000000)),
    SECONDS("Seconds", c.k(1)),
    MINUTES("Minutes", c.k(60)),
    HOURS("Hours", c.k(3600)),
    HALF_DAYS("HalfDays", c.k(43200)),
    DAYS("Days", c.k(86400)),
    WEEKS("Weeks", c.k(604800)),
    MONTHS("Months", c.k(2629746)),
    YEARS("Years", c.k(31556952)),
    DECADES("Decades", c.k(315569520)),
    CENTURIES("Centuries", c.k(3155695200L)),
    MILLENNIA("Millennia", c.k(31556952000L)),
    ERAS("Eras", c.k(31556952000000000L)),
    FOREVER("Forever", c.l(RecyclerView.FOREVER_NS, 999999999));
    

    /* renamed from: b  reason: collision with root package name */
    public final String f5162b;

    /* access modifiers changed from: public */
    b(String str, c cVar) {
        this.f5162b = str;
    }

    @Override // e.c.a.w.m
    public boolean b() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    @Override // e.c.a.w.m
    public long d(d dVar, d dVar2) {
        return dVar.q(dVar2, this);
    }

    @Override // e.c.a.w.m
    public <R extends d> R f(R r, long j) {
        return (R) r.o(j, this);
    }

    public String toString() {
        return this.f5162b;
    }
}
