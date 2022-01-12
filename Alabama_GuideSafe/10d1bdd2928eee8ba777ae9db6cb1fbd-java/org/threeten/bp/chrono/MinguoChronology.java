package org.threeten.bp.chrono;

import java.io.Serializable;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.ValueRange;

public final class MinguoChronology extends Chronology implements Serializable {
    public static final MinguoChronology INSTANCE = new MinguoChronology();

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDate date(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof MinguoDate) {
            return (MinguoDate) temporalAccessor;
        }
        return new MinguoDate(LocalDate.from(temporalAccessor));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public Era eraOf(int i) {
        return MinguoEra.of(i);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "roc";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "Minguo";
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: org.threeten.bp.chrono.ChronoLocalDateTime<?>, org.threeten.bp.chrono.ChronoLocalDateTime<org.threeten.bp.chrono.MinguoDate> */
    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDateTime<MinguoDate> localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    public ValueRange range(ChronoField chronoField) {
        switch (chronoField.ordinal()) {
            case 24:
                ValueRange valueRange = ChronoField.PROLEPTIC_MONTH.range;
                return ValueRange.of(valueRange.minSmallest - 22932, valueRange.maxLargest - 22932);
            case 25:
                ValueRange valueRange2 = ChronoField.YEAR.range;
                return ValueRange.of(1, valueRange2.maxLargest - 1911, (-valueRange2.minSmallest) + 1 + 1911);
            case 26:
                ValueRange valueRange3 = ChronoField.YEAR.range;
                return ValueRange.of(valueRange3.minSmallest - 1911, valueRange3.maxLargest - 1911);
            default:
                return chronoField.range;
        }
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime<MinguoDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofInstant(this, instant, zoneId);
    }
}
