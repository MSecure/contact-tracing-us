package l.b.a.w;

import java.util.Map;
import l.b.a.u.l;

/* JADX WARN: Init of enum f can be incorrect */
/* JADX WARN: Init of enum g can be incorrect */
/* JADX WARN: Init of enum h can be incorrect */
/* JADX WARN: Init of enum i can be incorrect */
/* JADX WARN: Init of enum j can be incorrect */
/* JADX WARN: Init of enum k can be incorrect */
/* JADX WARN: Init of enum l can be incorrect */
/* JADX WARN: Init of enum m can be incorrect */
/* JADX WARN: Init of enum n can be incorrect */
/* JADX WARN: Init of enum o can be incorrect */
/* JADX WARN: Init of enum p can be incorrect */
/* JADX WARN: Init of enum q can be incorrect */
/* JADX WARN: Init of enum r can be incorrect */
/* JADX WARN: Init of enum s can be incorrect */
/* JADX WARN: Init of enum t can be incorrect */
/* JADX WARN: Init of enum u can be incorrect */
/* JADX WARN: Init of enum v can be incorrect */
/* JADX WARN: Init of enum w can be incorrect */
/* JADX WARN: Init of enum x can be incorrect */
/* JADX WARN: Init of enum y can be incorrect */
/* JADX WARN: Init of enum z can be incorrect */
/* JADX WARN: Init of enum A can be incorrect */
/* JADX WARN: Init of enum B can be incorrect */
/* JADX WARN: Init of enum C can be incorrect */
/* JADX WARN: Init of enum D can be incorrect */
/* JADX WARN: Init of enum E can be incorrect */
/* JADX WARN: Init of enum F can be incorrect */
/* JADX WARN: Init of enum G can be incorrect */
/* JADX WARN: Init of enum H can be incorrect */
/* JADX WARN: Init of enum I can be incorrect */
public enum a implements j {
    NANO_OF_SECOND("NanoOfSecond", r8, r9, o.d(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", r8, r15, o.d(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", r16, r9, o.d(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", r16, r15, o.d(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", r18, r9, o.d(0, 999)),
    MILLI_OF_DAY("MilliOfDay", r18, r15, o.d(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", r9, r20, o.d(0, 59)),
    SECOND_OF_DAY("SecondOfDay", r9, r15, o.d(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", r20, r25, o.d(0, 59)),
    MINUTE_OF_DAY("MinuteOfDay", r20, r15, o.d(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", r25, r20, o.d(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", r25, r20, o.d(1, 12)),
    HOUR_OF_DAY("HourOfDay", r25, r15, o.d(0, 23)),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", r25, r15, o.d(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", r20, r15, o.d(0, 1)),
    DAY_OF_WEEK("DayOfWeek", r15, r31, o.d(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", r15, r31, o.d(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_YEAR("AlignedDayOfWeekInYear", r15, r31, o.d(1, 7)),
    DAY_OF_MONTH("DayOfMonth", r15, r11, o.e(1, 28, 31)),
    DAY_OF_YEAR("DayOfYear", r15, r36, o.e(1, 365, 366)),
    EPOCH_DAY("EpochDay", r15, r38, o.d(-365243219162L, 365241780471L)),
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", r31, r11, o.e(1, 4, 5)),
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", r31, r36, o.d(1, 53)),
    MONTH_OF_YEAR("MonthOfYear", r11, r36, o.d(1, 12)),
    PROLEPTIC_MONTH("ProlepticMonth", r11, r38, o.d(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", r36, r38, o.e(1, 999999999, 1000000000)),
    YEAR("Year", r36, r38, o.d(-999999999, 999999999)),
    ERA("Era", b.ERAS, r38, o.d(0, 1)),
    INSTANT_SECONDS("InstantSeconds", r9, r38, o.d(Long.MIN_VALUE, Long.MAX_VALUE)),
    OFFSET_SECONDS("OffsetSeconds", r9, r38, o.d(-64800, 64800));
    
    public final String b;
    public final m c;

    /* renamed from: d  reason: collision with root package name */
    public final m f4285d;

    /* renamed from: e  reason: collision with root package name */
    public final o f4286e;

    /* access modifiers changed from: public */
    static {
        b bVar = b.NANOS;
        b bVar2 = b.SECONDS;
        b bVar3 = b.DAYS;
        b bVar4 = b.MICROS;
        b bVar5 = b.MILLIS;
        b bVar6 = b.MINUTES;
        b bVar7 = b.HOURS;
        b bVar8 = b.HALF_DAYS;
        b bVar9 = b.WEEKS;
        b bVar10 = b.MONTHS;
        b bVar11 = b.YEARS;
        b bVar12 = b.FOREVER;
    }

    /* access modifiers changed from: public */
    a(String str, m mVar, m mVar2, o oVar) {
        this.b = str;
        this.c = mVar;
        this.f4285d = mVar2;
        this.f4286e = oVar;
    }

    @Override // l.b.a.w.j
    public boolean a() {
        return ordinal() >= 15 && ordinal() <= 27;
    }

    @Override // l.b.a.w.j
    public boolean b(e eVar) {
        return eVar.f(this);
    }

    @Override // l.b.a.w.j
    public <R extends d> R c(R r, long j2) {
        return (R) r.l(this, j2);
    }

    @Override // l.b.a.w.j
    public e e(Map<j, Long> map, e eVar, l lVar) {
        return null;
    }

    @Override // l.b.a.w.j
    public long f(e eVar) {
        return eVar.i(this);
    }

    @Override // l.b.a.w.j
    public o h() {
        return this.f4286e;
    }

    @Override // l.b.a.w.j
    public boolean i() {
        return ordinal() < 15;
    }

    @Override // l.b.a.w.j
    public o l(e eVar) {
        return eVar.a(this);
    }

    public int m(long j2) {
        return this.f4286e.a(j2, this);
    }

    public String toString() {
        return this.b;
    }
}
