package org.threeten.bp.chrono;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.google.common.util.concurrent.MoreExecutors;
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

public final class MinguoDate extends ChronoDateImpl<MinguoDate> implements Serializable {
    public final LocalDate isoDate;

    public MinguoDate(LocalDate localDate) {
        MoreExecutors.requireNonNull(localDate, DatePickerDialogModule.ARG_DATE);
        this.isoDate = localDate;
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl
    public final ChronoLocalDateTime<MinguoDate> atTime(LocalTime localTime) {
        return new ChronoLocalDateTimeImpl(this, localTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MinguoDate) {
            return this.isoDate.equals(((MinguoDate) obj).isoDate);
        }
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Chronology getChronology() {
        return MinguoChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Era getEra() {
        return (MinguoEra) super.getEra();
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
        return this.isoDate.year - 1911;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int hashCode() {
        MinguoChronology minguoChronology = MinguoChronology.INSTANCE;
        return -1990173233 ^ this.isoDate.hashCode();
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public ChronoLocalDate minus(long j, TemporalUnit temporalUnit) {
        return (MinguoDate) super.minus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<MinguoDate> plus(long j, TemporalUnit temporalUnit) {
        return (MinguoDate) super.plus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<MinguoDate> plusDays(long j) {
        return with(this.isoDate.plusDays(j));
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<MinguoDate> plusMonths(long j) {
        return with(this.isoDate.plusMonths(j));
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<MinguoDate> plusYears(long j) {
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
                return MinguoChronology.INSTANCE.range(chronoField);
            }
            ValueRange valueRange = ChronoField.YEAR.range;
            if (getProlepticYear() <= 0) {
                j = (-valueRange.minSmallest) + 1 + 1911;
            } else {
                j = valueRange.maxLargest - 1911;
            }
            return ValueRange.of(1, j);
        }
        throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline12("Unsupported field: ", temporalField));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    /* renamed from: minus  reason: collision with other method in class */
    public Temporal m23minus(long j, TemporalUnit temporalUnit) {
        return (MinguoDate) super.minus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoLocalDate' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl
    /* renamed from: plus  reason: collision with other method in class */
    public ChronoDateImpl<MinguoDate> m24plus(long j, TemporalUnit temporalUnit) {
        return (MinguoDate) super.plus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.temporal.Temporal' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl
    /* renamed from: plus  reason: collision with other method in class */
    public ChronoDateImpl<MinguoDate> m25plus(long j, TemporalUnit temporalUnit) {
        return (MinguoDate) super.plus(j, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public ChronoLocalDate with(TemporalAdjuster temporalAdjuster) {
        return (MinguoDate) MinguoChronology.INSTANCE.ensureChronoLocalDate(temporalAdjuster.adjustInto(this));
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    /* renamed from: with  reason: collision with other method in class */
    public Temporal m26with(TemporalAdjuster temporalAdjuster) {
        return (MinguoDate) MinguoChronology.INSTANCE.ensureChronoLocalDate(((LocalDate) temporalAdjuster).adjustInto(this));
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public MinguoDate with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (MinguoDate) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (getLong(chronoField) == j) {
            return this;
        }
        switch (chronoField.ordinal()) {
            case 24:
                MinguoChronology.INSTANCE.range(chronoField).checkValidValue(j, chronoField);
                return with(this.isoDate.plusMonths(j - getProlepticMonth()));
            case 25:
            case 26:
            case 27:
                int checkValidIntValue = MinguoChronology.INSTANCE.range(chronoField).checkValidIntValue(j, chronoField);
                switch (chronoField.ordinal()) {
                    case 25:
                        return with(this.isoDate.withYear(getProlepticYear() >= 1 ? checkValidIntValue + 1911 : (1 - checkValidIntValue) + 1911));
                    case 26:
                        return with(this.isoDate.withYear(checkValidIntValue + 1911));
                    case 27:
                        return with(this.isoDate.withYear((1 - getProlepticYear()) + 1911));
                }
        }
        return with(this.isoDate.with(temporalField, j));
    }

    public final MinguoDate with(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new MinguoDate(localDate);
    }
}
