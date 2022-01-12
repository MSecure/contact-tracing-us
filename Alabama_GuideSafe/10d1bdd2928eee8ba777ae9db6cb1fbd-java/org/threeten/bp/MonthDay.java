package org.threeten.bp;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.DataInput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class MonthDay extends DefaultInterfaceTemporalAccessor implements TemporalAccessor, TemporalAdjuster, Comparable<MonthDay>, Serializable {
    public final int day;
    public final int month;

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendLiteral("--");
        dateTimeFormatterBuilder.appendValue(ChronoField.MONTH_OF_YEAR, 2);
        dateTimeFormatterBuilder.appendLiteral('-');
        dateTimeFormatterBuilder.appendValue(ChronoField.DAY_OF_MONTH, 2);
        dateTimeFormatterBuilder.toFormatter();
    }

    public MonthDay(int i, int i2) {
        this.month = i;
        this.day = i2;
    }

    public static MonthDay of(int i, int i2) {
        Month of = Month.of(i);
        MoreExecutors.requireNonNull(of, "month");
        ChronoField chronoField = ChronoField.DAY_OF_MONTH;
        chronoField.range.checkValidValue((long) i2, chronoField);
        if (i2 <= of.maxLength()) {
            return new MonthDay(of.getValue(), i2);
        }
        StringBuilder outline18 = GeneratedOutlineSupport.outline18("Illegal value for DayOfMonth field, value ", i2, " is not valid for month ");
        outline18.append(of.name());
        throw new DateTimeException(outline18.toString());
    }

    public static MonthDay readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readByte(), dataInput.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 64, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        if (Chronology.from(temporal).equals(IsoChronology.INSTANCE)) {
            Temporal with = temporal.with(ChronoField.MONTH_OF_YEAR, (long) this.month);
            ChronoField chronoField = ChronoField.DAY_OF_MONTH;
            return with.with(chronoField, Math.min(with.range(chronoField).maxLargest, (long) this.day));
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(MonthDay monthDay) {
        MonthDay monthDay2 = monthDay;
        int i = this.month - monthDay2.month;
        return i == 0 ? this.day - monthDay2.day : i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MonthDay)) {
            return false;
        }
        MonthDay monthDay = (MonthDay) obj;
        return this.month == monthDay.month && this.day == monthDay.day;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public int get(TemporalField temporalField) {
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        int i;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int ordinal = ((ChronoField) temporalField).ordinal();
        if (ordinal == 18) {
            i = this.day;
        } else if (ordinal == 23) {
            i = this.month;
        } else {
            throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline12("Unsupported field: ", temporalField));
        }
        return (long) i;
    }

    public int hashCode() {
        return (this.month << 6) + this.day;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.MONTH_OF_YEAR || temporalField == ChronoField.DAY_OF_MONTH : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.CHRONO ? (R) IsoChronology.INSTANCE : (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.MONTH_OF_YEAR) {
            return temporalField.range();
        }
        if (temporalField != ChronoField.DAY_OF_MONTH) {
            return super.range(temporalField);
        }
        int ordinal = Month.of(this.month).ordinal();
        return ValueRange.of(1, (long) (ordinal != 1 ? (ordinal == 3 || ordinal == 5 || ordinal == 8 || ordinal == 10) ? 30 : 31 : 28), (long) Month.of(this.month).maxLength());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.month < 10 ? "0" : "");
        sb.append(this.month);
        sb.append(this.day < 10 ? "-0" : "-");
        sb.append(this.day);
        return sb.toString();
    }
}
