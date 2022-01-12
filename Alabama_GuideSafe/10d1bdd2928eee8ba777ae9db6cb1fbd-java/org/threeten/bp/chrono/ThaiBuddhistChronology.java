package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.HashMap;
import org.pathcheck.covidsafepaths.BuildConfig;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.ValueRange;

public final class ThaiBuddhistChronology extends Chronology implements Serializable {
    public static final HashMap<String, String[]> ERA_FULL_NAMES = new HashMap<>();
    public static final HashMap<String, String[]> ERA_NARROW_NAMES = new HashMap<>();
    public static final HashMap<String, String[]> ERA_SHORT_NAMES = new HashMap<>();
    public static final ThaiBuddhistChronology INSTANCE = new ThaiBuddhistChronology();

    static {
        ERA_NARROW_NAMES.put(BuildConfig.SUPPORTED_LOCALES, new String[]{"BB", "BE"});
        ERA_NARROW_NAMES.put("th", new String[]{"BB", "BE"});
        ERA_SHORT_NAMES.put(BuildConfig.SUPPORTED_LOCALES, new String[]{"B.B.", "B.E."});
        ERA_SHORT_NAMES.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        ERA_FULL_NAMES.put(BuildConfig.SUPPORTED_LOCALES, new String[]{"Before Buddhist", "Budhhist Era"});
        ERA_FULL_NAMES.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDate date(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof ThaiBuddhistDate) {
            return (ThaiBuddhistDate) temporalAccessor;
        }
        return new ThaiBuddhistDate(LocalDate.from(temporalAccessor));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public Era eraOf(int i) {
        return ThaiBuddhistEra.of(i);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "buddhist";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "ThaiBuddhist";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: org.threeten.bp.chrono.ChronoLocalDateTime<?>, org.threeten.bp.chrono.ChronoLocalDateTime<org.threeten.bp.chrono.ThaiBuddhistDate> */
    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDateTime<ThaiBuddhistDate> localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    public ValueRange range(ChronoField chronoField) {
        switch (chronoField.ordinal()) {
            case 24:
                ValueRange valueRange = ChronoField.PROLEPTIC_MONTH.range;
                return ValueRange.of(valueRange.minSmallest + 6516, valueRange.maxLargest + 6516);
            case 25:
                ValueRange valueRange2 = ChronoField.YEAR.range;
                return ValueRange.of(1, (-(valueRange2.minSmallest + 543)) + 1, valueRange2.maxLargest + 543);
            case 26:
                ValueRange valueRange3 = ChronoField.YEAR.range;
                return ValueRange.of(valueRange3.minSmallest + 543, valueRange3.maxLargest + 543);
            default:
                return chronoField.range;
        }
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime<ThaiBuddhistDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofInstant(this, instant, zoneId);
    }
}
