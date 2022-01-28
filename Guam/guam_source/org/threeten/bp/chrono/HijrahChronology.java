package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.HashMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;

public final class HijrahChronology extends Chronology implements Serializable {
    public static final HashMap<String, String[]> ERA_FULL_NAMES = new HashMap<>();
    public static final HashMap<String, String[]> ERA_NARROW_NAMES = new HashMap<>();
    public static final HashMap<String, String[]> ERA_SHORT_NAMES = new HashMap<>();
    public static final HijrahChronology INSTANCE = new HijrahChronology();

    static {
        ERA_NARROW_NAMES.put("en", new String[]{"BH", "HE"});
        ERA_SHORT_NAMES.put("en", new String[]{"B.H.", "H.E."});
        ERA_FULL_NAMES.put("en", new String[]{"Before Hijrah", "Hijrah Era"});
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDate date(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof HijrahDate) {
            return (HijrahDate) temporalAccessor;
        }
        return new HijrahDate(temporalAccessor.getLong(ChronoField.EPOCH_DAY));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public Era eraOf(int i) {
        if (i == 0) {
            return HijrahEra.BEFORE_AH;
        }
        if (i == 1) {
            return HijrahEra.AH;
        }
        throw new DateTimeException("invalid Hijrah era");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "islamic-umalqura";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "Hijrah-umalqura";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: org.threeten.bp.chrono.ChronoLocalDateTime<?>, org.threeten.bp.chrono.ChronoLocalDateTime<org.threeten.bp.chrono.HijrahDate> */
    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDateTime<HijrahDate> localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime<HijrahDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofInstant(this, instant, zoneId);
    }
}
