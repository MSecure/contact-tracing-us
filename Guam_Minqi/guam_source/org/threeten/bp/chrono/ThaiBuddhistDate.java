package org.threeten.bp.chrono;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.horcrux.svg.PathParser;
import java.io.Serializable;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class ThaiBuddhistDate extends ChronoDateImpl<ThaiBuddhistDate> implements Serializable {
    public final LocalDate isoDate;

    public ThaiBuddhistDate(LocalDate localDate) {
        PathParser.requireNonNull(localDate, DatePickerDialogModule.ARG_DATE);
        this.isoDate = localDate;
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl
    public final ChronoLocalDateTime<ThaiBuddhistDate> atTime(LocalTime localTime) {
        return new ChronoLocalDateTimeImpl(this, localTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ThaiBuddhistDate) {
            return this.isoDate.equals(((ThaiBuddhistDate) obj).isoDate);
        }
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Chronology getChronology() {
        return ThaiBuddhistChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Era getEra() {
        return (ThaiBuddhistEra) super.getEra();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i = 1;
        switch (((ChronoField) temporalField).ordinal()) {
            case 24:
                return getProlepticMonth();
            case 25:
                int prolepticYear = getProlepticYear();
                if (prolepticYear < 1) {
                    prolepticYear = 1 - prolepticYear;
                }
                return (long) prolepticYear;
            case 26:
                return (long) getProlepticYear();
            case 27:
                if (getProlepticYear() < 1) {
                    i = 0;
                }
                return (long) i;
            default:
                return this.isoDate.getLong(temporalField);
        }
    }

    public final long getProlepticMonth() {
        return ((((long) getProlepticYear()) * 12) + ((long) this.isoDate.month)) - 1;
    }

    public final int getProlepticYear() {
        return this.isoDate.year + 543;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int hashCode() {
        ThaiBuddhistChronology thaiBuddhistChronology = ThaiBuddhistChronology.INSTANCE;
        return 146118545 ^ this.isoDate.hashCode();
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public ChronoLocalDate minus(long j, TemporalUnit temporalUnit) {
        return (ThaiBuddhistDate) super.minus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<ThaiBuddhistDate> plus(long j, TemporalUnit temporalUnit) {
        return (ThaiBuddhistDate) super.plus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<ThaiBuddhistDate> plusDays(long j) {
        return with(this.isoDate.plusDays(j));
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<ThaiBuddhistDate> plusMonths(long j) {
        return with(this.isoDate.plusMonths(j));
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<ThaiBuddhistDate> plusYears(long j) {
        return with(this.isoDate.plusYears(j));
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        long j;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (isSupported(temporalField)) {
            ChronoField chronoField = (ChronoField) temporalField;
            int ordinal = chronoField.ordinal();
            if (ordinal == 18 || ordinal == 19 || ordinal == 21) {
                return this.isoDate.range(temporalField);
            }
            if (ordinal != 25) {
                return ThaiBuddhistChronology.INSTANCE.range(chronoField);
            }
            ValueRange valueRange = ChronoField.YEAR.range;
            if (getProlepticYear() <= 0) {
                j = (-(valueRange.minSmallest + 543)) + 1;
            } else {
                j = 543 + valueRange.maxLargest;
            }
            return ValueRange.of(1, j);
        }
        throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline10("Unsupported field: ", temporalField));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    /* renamed from: minus  reason: collision with other method in class */
    public Temporal m26minus(long j, TemporalUnit temporalUnit) {
        return (ThaiBuddhistDate) super.minus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoLocalDate' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl
    /* renamed from: plus  reason: collision with other method in class */
    public ChronoDateImpl<ThaiBuddhistDate> m27plus(long j, TemporalUnit temporalUnit) {
        return (ThaiBuddhistDate) super.plus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.temporal.Temporal' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl
    /* renamed from: plus  reason: collision with other method in class */
    public ChronoDateImpl<ThaiBuddhistDate> m28plus(long j, TemporalUnit temporalUnit) {
        return (ThaiBuddhistDate) super.plus(j, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public ChronoLocalDate with(TemporalAdjuster temporalAdjuster) {
        return (ThaiBuddhistDate) ThaiBuddhistChronology.INSTANCE.ensureChronoLocalDate(temporalAdjuster.adjustInto(this));
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    /* renamed from: with  reason: collision with other method in class */
    public Temporal m29with(TemporalAdjuster temporalAdjuster) {
        return (ThaiBuddhistDate) ThaiBuddhistChronology.INSTANCE.ensureChronoLocalDate(((LocalDate) temporalAdjuster).adjustInto(this));
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public ThaiBuddhistDate with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (ThaiBuddhistDate) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (getLong(chronoField) == j) {
            return this;
        }
        switch (chronoField.ordinal()) {
            case 24:
                ThaiBuddhistChronology.INSTANCE.range(chronoField).checkValidValue(j, chronoField);
                return with(this.isoDate.plusMonths(j - getProlepticMonth()));
            case 25:
            case 26:
            case 27:
                int checkValidIntValue = ThaiBuddhistChronology.INSTANCE.range(chronoField).checkValidIntValue(j, chronoField);
                switch (chronoField.ordinal()) {
                    case 25:
                        LocalDate localDate = this.isoDate;
                        if (getProlepticYear() < 1) {
                            checkValidIntValue = 1 - checkValidIntValue;
                        }
                        return with(localDate.withYear(checkValidIntValue - 543));
                    case 26:
                        return with(this.isoDate.withYear(checkValidIntValue - 543));
                    case 27:
                        return with(this.isoDate.withYear((1 - getProlepticYear()) - 543));
                }
        }
        return with(this.isoDate.with(temporalField, j));
    }

    public final ThaiBuddhistDate with(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new ThaiBuddhistDate(localDate);
    }
}
