package org.threeten.bp.chrono;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.DataInput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class JapaneseDate extends ChronoDateImpl<JapaneseDate> implements Serializable {
    public static final LocalDate MIN_DATE = LocalDate.of(1873, 1, 1);
    public transient JapaneseEra era;
    public final LocalDate isoDate;
    public transient int yearOfEra;

    public JapaneseDate(LocalDate localDate) {
        if (!localDate.isBefore(MIN_DATE)) {
            JapaneseEra from = JapaneseEra.from(localDate);
            this.era = from;
            this.yearOfEra = localDate.year - (from.since.year - 1);
            this.isoDate = localDate;
            return;
        }
        throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
    }

    public static ChronoLocalDate readExternal(DataInput dataInput) throws IOException {
        int readInt = dataInput.readInt();
        byte readByte = dataInput.readByte();
        byte readByte2 = dataInput.readByte();
        if (JapaneseChronology.INSTANCE != null) {
            return new JapaneseDate(LocalDate.of(readInt, readByte, readByte2));
        }
        throw null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        JapaneseEra from = JapaneseEra.from(this.isoDate);
        this.era = from;
        this.yearOfEra = this.isoDate.year - (from.since.year - 1);
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public final ValueRange actualRange(int i) {
        Calendar instance = Calendar.getInstance(JapaneseChronology.LOCALE);
        instance.set(0, this.era.eraValue + 2);
        int i2 = this.yearOfEra;
        LocalDate localDate = this.isoDate;
        instance.set(i2, localDate.month - 1, localDate.day);
        return ValueRange.of((long) instance.getActualMinimum(i), (long) instance.getActualMaximum(i));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl
    public final ChronoLocalDateTime<JapaneseDate> atTime(LocalTime localTime) {
        return new ChronoLocalDateTimeImpl(this, localTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JapaneseDate) {
            return this.isoDate.equals(((JapaneseDate) obj).isoDate);
        }
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Chronology getChronology() {
        return JapaneseChronology.INSTANCE;
    }

    public final long getDayOfYear() {
        int dayOfYear;
        if (this.yearOfEra == 1) {
            dayOfYear = (this.isoDate.getDayOfYear() - this.era.since.getDayOfYear()) + 1;
        } else {
            dayOfYear = this.isoDate.getDayOfYear();
        }
        return (long) dayOfYear;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Era getEra() {
        return this.era;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int ordinal = ((ChronoField) temporalField).ordinal();
        if (!(ordinal == 16 || ordinal == 17)) {
            if (ordinal == 19) {
                return getDayOfYear();
            }
            if (ordinal == 25) {
                return (long) this.yearOfEra;
            }
            if (ordinal == 27) {
                return (long) this.era.eraValue;
            }
            if (!(ordinal == 21 || ordinal == 22)) {
                return this.isoDate.getLong(temporalField);
            }
        }
        throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline10("Unsupported field: ", temporalField));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int hashCode() {
        if (JapaneseChronology.INSTANCE != null) {
            return -688086063 ^ this.isoDate.hashCode();
        }
        throw null;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        if (temporalField == ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH || temporalField == ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR || temporalField == ChronoField.ALIGNED_WEEK_OF_MONTH || temporalField == ChronoField.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return super.isSupported(temporalField);
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public ChronoLocalDate minus(long j, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.minus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<JapaneseDate> plus(long j, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.plus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<JapaneseDate> plusDays(long j) {
        return with(this.isoDate.plusDays(j));
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<JapaneseDate> plusMonths(long j) {
        return with(this.isoDate.plusMonths(j));
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoDateImpl' to match base method */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<JapaneseDate> plusYears(long j) {
        return with(this.isoDate.plusYears(j));
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (isSupported(temporalField)) {
            ChronoField chronoField = (ChronoField) temporalField;
            int ordinal = chronoField.ordinal();
            if (ordinal == 19) {
                return actualRange(6);
            }
            if (ordinal != 25) {
                return JapaneseChronology.INSTANCE.range(chronoField);
            }
            return actualRange(1);
        }
        throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline10("Unsupported field: ", temporalField));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    public final JapaneseDate withYear(JapaneseEra japaneseEra, int i) {
        if (JapaneseChronology.INSTANCE == null) {
            throw null;
        } else if (japaneseEra instanceof JapaneseEra) {
            ValueRange.of(1, (long) ((japaneseEra.endDate().year - japaneseEra.since.year) + 1)).checkValidValue((long) i, ChronoField.YEAR_OF_ERA);
            return with(this.isoDate.withYear((japaneseEra.since.year + i) - 1));
        } else {
            throw new ClassCastException("Era must be JapaneseEra");
        }
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    /* renamed from: minus  reason: collision with other method in class */
    public Temporal m18minus(long j, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.minus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoLocalDate' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl
    /* renamed from: plus  reason: collision with other method in class */
    public ChronoDateImpl<JapaneseDate> m19plus(long j, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.plus(j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.temporal.Temporal' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoDateImpl
    /* renamed from: plus  reason: collision with other method in class */
    public ChronoDateImpl<JapaneseDate> m20plus(long j, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.plus(j, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public ChronoLocalDate with(TemporalAdjuster temporalAdjuster) {
        return (JapaneseDate) JapaneseChronology.INSTANCE.ensureChronoLocalDate(temporalAdjuster.adjustInto(this));
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    /* renamed from: with  reason: collision with other method in class */
    public Temporal m21with(TemporalAdjuster temporalAdjuster) {
        return (JapaneseDate) JapaneseChronology.INSTANCE.ensureChronoLocalDate(((LocalDate) temporalAdjuster).adjustInto(this));
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public JapaneseDate with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (JapaneseDate) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (getLong(chronoField) == j) {
            return this;
        }
        int ordinal = chronoField.ordinal();
        if (ordinal == 19 || ordinal == 25 || ordinal == 27) {
            int checkValidIntValue = JapaneseChronology.INSTANCE.range(chronoField).checkValidIntValue(j, chronoField);
            int ordinal2 = chronoField.ordinal();
            if (ordinal2 == 19) {
                return with(this.isoDate.plusDays(((long) checkValidIntValue) - getDayOfYear()));
            }
            if (ordinal2 == 25) {
                return withYear(this.era, checkValidIntValue);
            }
            if (ordinal2 == 27) {
                return withYear(JapaneseEra.of(checkValidIntValue), this.yearOfEra);
            }
        }
        return with(this.isoDate.with(temporalField, j));
    }

    public final JapaneseDate with(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new JapaneseDate(localDate);
    }
}
