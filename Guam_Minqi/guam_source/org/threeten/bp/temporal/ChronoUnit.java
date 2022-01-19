package org.threeten.bp.temporal;

import androidx.recyclerview.widget.RecyclerView;
import org.threeten.bp.Duration;

public enum ChronoUnit implements TemporalUnit {
    NANOS("Nanos", Duration.ofNanos(1)),
    MICROS("Micros", Duration.ofNanos(1000)),
    MILLIS("Millis", Duration.ofNanos(1000000)),
    SECONDS("Seconds", Duration.ofSeconds(1)),
    MINUTES("Minutes", Duration.ofSeconds(60)),
    HOURS("Hours", Duration.ofSeconds(3600)),
    HALF_DAYS("HalfDays", Duration.ofSeconds(43200)),
    DAYS("Days", Duration.ofSeconds(86400)),
    WEEKS("Weeks", Duration.ofSeconds(604800)),
    MONTHS("Months", Duration.ofSeconds(2629746)),
    YEARS("Years", Duration.ofSeconds(31556952)),
    DECADES("Decades", Duration.ofSeconds(315569520)),
    CENTURIES("Centuries", Duration.ofSeconds(3155695200L)),
    MILLENNIA("Millennia", Duration.ofSeconds(31556952000L)),
    ERAS("Eras", Duration.ofSeconds(31556952000000000L)),
    FOREVER("Forever", Duration.ofSeconds(RecyclerView.FOREVER_NS, 999999999));
    
    public final String name;

    /* access modifiers changed from: public */
    ChronoUnit(String str, Duration duration) {
        this.name = str;
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public <R extends Temporal> R addTo(R r, long j) {
        return (R) r.plus(j, this);
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public boolean isDateBased() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    public String toString() {
        return this.name;
    }
}
