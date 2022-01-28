package e.c.a.w;

import androidx.recyclerview.widget.RecyclerView;
import e.c.a.u.l;
import java.util.Map;

public enum a implements j {
    NANO_OF_SECOND("NanoOfSecond", b.NANOS, b.SECONDS, o.d(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", b.NANOS, b.DAYS, o.d(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", b.MICROS, b.SECONDS, o.d(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", b.MICROS, b.DAYS, o.d(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", b.MILLIS, b.SECONDS, o.d(0, 999)),
    MILLI_OF_DAY("MilliOfDay", b.MILLIS, b.DAYS, o.d(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", b.SECONDS, b.MINUTES, o.d(0, 59)),
    SECOND_OF_DAY("SecondOfDay", b.SECONDS, b.DAYS, o.d(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", b.MINUTES, b.HOURS, o.d(0, 59)),
    MINUTE_OF_DAY("MinuteOfDay", b.MINUTES, b.DAYS, o.d(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", b.HOURS, b.HALF_DAYS, o.d(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", b.HOURS, b.HALF_DAYS, o.d(1, 12)),
    HOUR_OF_DAY("HourOfDay", b.HOURS, b.DAYS, o.d(0, 23)),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", b.HOURS, b.DAYS, o.d(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", b.HALF_DAYS, b.DAYS, o.d(0, 1)),
    DAY_OF_WEEK("DayOfWeek", b.DAYS, b.WEEKS, o.d(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", b.DAYS, b.WEEKS, o.d(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_YEAR("AlignedDayOfWeekInYear", b.DAYS, b.WEEKS, o.d(1, 7)),
    DAY_OF_MONTH("DayOfMonth", b.DAYS, b.MONTHS, o.e(1, 28, 31)),
    DAY_OF_YEAR("DayOfYear", b.DAYS, b.YEARS, o.e(1, 365, 366)),
    EPOCH_DAY("EpochDay", b.DAYS, b.FOREVER, o.d(-365243219162L, 365241780471L)),
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", b.WEEKS, b.MONTHS, o.e(1, 4, 5)),
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", b.WEEKS, b.YEARS, o.d(1, 53)),
    MONTH_OF_YEAR("MonthOfYear", b.MONTHS, b.YEARS, o.d(1, 12)),
    PROLEPTIC_MONTH("ProlepticMonth", b.MONTHS, b.FOREVER, o.d(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", b.YEARS, b.FOREVER, o.e(1, 999999999, 1000000000)),
    YEAR("Year", b.YEARS, b.FOREVER, o.d(-999999999, 999999999)),
    ERA("Era", b.ERAS, b.FOREVER, o.d(0, 1)),
    INSTANT_SECONDS("InstantSeconds", b.SECONDS, b.FOREVER, o.d(Long.MIN_VALUE, RecyclerView.FOREVER_NS)),
    OFFSET_SECONDS("OffsetSeconds", b.SECONDS, b.FOREVER, o.d(-64800, 64800));
    

    /* renamed from: b  reason: collision with root package name */
    public final String f5157b;

    /* renamed from: c  reason: collision with root package name */
    public final o f5158c;

    /* access modifiers changed from: public */
    a(String str, m mVar, m mVar2, o oVar) {
        this.f5157b = str;
        this.f5158c = oVar;
    }

    @Override // e.c.a.w.j
    public boolean b() {
        return ordinal() >= 15 && ordinal() <= 27;
    }

    @Override // e.c.a.w.j
    public boolean d(e eVar) {
        return eVar.i(this);
    }

    @Override // e.c.a.w.j
    public <R extends d> R f(R r, long j) {
        return (R) r.n(this, j);
    }

    @Override // e.c.a.w.j
    public e g(Map<j, Long> map, e eVar, l lVar) {
        return null;
    }

    @Override // e.c.a.w.j
    public long i(e eVar) {
        return eVar.l(this);
    }

    @Override // e.c.a.w.j
    public o k() {
        return this.f5158c;
    }

    @Override // e.c.a.w.j
    public boolean l() {
        return ordinal() < 15;
    }

    @Override // e.c.a.w.j
    public o n(e eVar) {
        return eVar.b(this);
    }

    public int o(long j) {
        return this.f5158c.a(j, this);
    }

    public String toString() {
        return this.f5157b;
    }
}
