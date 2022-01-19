package org.threeten.bp;

import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.horcrux.svg.PathParser;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;

public final class LocalDateTime extends ChronoLocalDateTime<LocalDate> implements Temporal, TemporalAdjuster, Serializable {
    public static final LocalDateTime MAX = of(LocalDate.MAX, LocalTime.MAX);
    public static final LocalDateTime MIN = of(LocalDate.MIN, LocalTime.MIN);
    public final LocalDate date;
    public final LocalTime time;

    public LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.date = localDate;
        this.time = localTime;
    }

    public static LocalDateTime from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).dateTime;
        }
        try {
            return new LocalDateTime(LocalDate.from(temporalAccessor), LocalTime.from(temporalAccessor));
        } catch (DateTimeException unused) {
            throw new DateTimeException(GeneratedOutlineSupport.outline13(temporalAccessor, GeneratedOutlineSupport.outline18("Unable to obtain LocalDateTime from TemporalAccessor: ", temporalAccessor, ", type ")));
        }
    }

    public static LocalDateTime of(LocalDate localDate, LocalTime localTime) {
        PathParser.requireNonNull(localDate, DatePickerDialogModule.ARG_DATE);
        PathParser.requireNonNull(localTime, "time");
        return new LocalDateTime(localDate, localTime);
    }

    public static LocalDateTime ofEpochSecond(long j, int i, ZoneOffset zoneOffset) {
        PathParser.requireNonNull(zoneOffset, "offset");
        long j2 = j + ((long) zoneOffset.totalSeconds);
        return new LocalDateTime(LocalDate.ofEpochDay(PathParser.floorDiv(j2, 86400)), LocalTime.ofSecondOfDay((long) PathParser.floorMod(j2, 86400), i));
    }

    public static LocalDateTime readExternal(DataInput dataInput) throws IOException {
        return of(LocalDate.readExternal(dataInput), LocalTime.readExternal(dataInput));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return super.adjustInto(temporal);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoZonedDateTime' to match base method */
    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public ChronoZonedDateTime<LocalDate> atZone(ZoneId zoneId) {
        return ZonedDateTime.ofLocal(this, zoneId, null);
    }

    public final int compareTo0(LocalDateTime localDateTime) {
        int compareTo0 = this.date.compareTo0(localDateTime.date);
        return compareTo0 == 0 ? this.time.compareTo(localDateTime.time) : compareTo0;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.date.equals(localDateTime.date) && this.time.equals(localDateTime.time);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public int get(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.isTimeBased() ? this.time.get(temporalField) : this.date.get(temporalField);
        }
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.isTimeBased() ? this.time.getLong(temporalField) : this.date.getLong(temporalField);
        }
        return temporalField.getFrom(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public int hashCode() {
        return this.date.hashCode() ^ this.time.hashCode();
    }

    public boolean isBefore(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return compareTo0((LocalDateTime) chronoLocalDateTime) < 0;
        }
        int i = (this.date.toEpochDay() > ((LocalDateTime) chronoLocalDateTime).date.toEpochDay() ? 1 : (this.date.toEpochDay() == ((LocalDateTime) chronoLocalDateTime).date.toEpochDay() ? 0 : -1));
        return i < 0 || (i == 0 && this.time.toNanoOfDay() < ((LocalDateTime) chronoLocalDateTime).time.toNanoOfDay());
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isDateBased() || temporalField.isTimeBased() : temporalField != null && temporalField.isSupportedBy(this);
    }

    public LocalDateTime plusDays(long j) {
        return with(this.date.plusDays(j), this.time);
    }

    public LocalDateTime plusNanos(long j) {
        return plusWithOverflow(this.date, 0, 0, 0, j, 1);
    }

    public LocalDateTime plusSeconds(long j) {
        return plusWithOverflow(this.date, 0, 0, j, 0, 1);
    }

    public final LocalDateTime plusWithOverflow(LocalDate localDate, long j, long j2, long j3, long j4, int i) {
        if ((j | j2 | j3 | j4) == 0) {
            return with(localDate, this.time);
        }
        long j5 = j / 24;
        long j6 = j5 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
        long j7 = (long) i;
        long j8 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L);
        long nanoOfDay = this.time.toNanoOfDay();
        long j9 = (j8 * j7) + nanoOfDay;
        long floorDiv = PathParser.floorDiv(j9, 86400000000000L) + (j6 * j7);
        long floorMod = PathParser.floorMod(j9, 86400000000000L);
        return with(localDate.plusDays(floorDiv), floorMod == nanoOfDay ? this.time : LocalTime.ofNanoOfDay(floorMod));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.LOCAL_DATE ? (R) this.date : (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.isTimeBased() ? this.time.range(temporalField) : this.date.range(temporalField);
        }
        return temporalField.rangeRefinedBy(this);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoLocalDate' to match base method */
    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public LocalDate toLocalDate() {
        return this.date;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public String toString() {
        return this.date.toString() + 'T' + this.time.toString();
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        LocalDate localDate = this.date;
        dataOutput.writeInt(localDate.year);
        dataOutput.writeByte(localDate.month);
        dataOutput.writeByte(localDate.day);
        this.time.writeExternal(dataOutput);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public int compareTo(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return compareTo0((LocalDateTime) chronoLocalDateTime);
        }
        return super.compareTo(chronoLocalDateTime);
    }

    /* Return type fixed from 'org.threeten.bp.LocalDateTime' to match base method */
    /* JADX WARN: Type inference failed for: r3v2, types: [org.threeten.bp.LocalDateTime] */
    /* JADX WARN: Type inference failed for: r3v4, types: [org.threeten.bp.LocalDateTime] */
    /* JADX WARN: Type inference failed for: r3v5, types: [org.threeten.bp.LocalDateTime] */
    /* JADX WARNING: Unknown variable types count: 3 */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public ChronoLocalDateTime<LocalDate> minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(RecyclerView.FOREVER_NS, temporalUnit).plus(1, temporalUnit) : plus(-j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.LocalDateTime' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime
    public ChronoLocalDateTime<LocalDate> plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDateTime) temporalUnit.addTo(this, j);
        }
        switch (((ChronoUnit) temporalUnit).ordinal()) {
            case 0:
                return plusNanos(j);
            case 1:
                return plusDays(j / 86400000000L).plusNanos((j % 86400000000L) * 1000);
            case 2:
                return plusDays(j / 86400000).plusNanos((j % 86400000) * 1000000);
            case 3:
                return plusSeconds(j);
            case 4:
                return plusWithOverflow(this.date, 0, j, 0, 0, 1);
            case 5:
                return plusWithOverflow(this.date, j, 0, 0, 0, 1);
            case 6:
                LocalDateTime plusDays = plusDays(j / 256);
                return plusDays.plusWithOverflow(plusDays.date, (j % 256) * 12, 0, 0, 0, 1);
            default:
                return with(this.date.plus(j, temporalUnit), this.time);
        }
    }

    public final LocalDateTime with(LocalDate localDate, LocalTime localTime) {
        if (this.date == localDate && this.time == localTime) {
            return this;
        }
        return new LocalDateTime(localDate, localTime);
    }

    /* Return type fixed from 'org.threeten.bp.LocalDateTime' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime
    public ChronoLocalDateTime<LocalDate> with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return with((LocalDate) temporalAdjuster, this.time);
        }
        if (temporalAdjuster instanceof LocalTime) {
            return with(this.date, (LocalTime) temporalAdjuster);
        }
        if (temporalAdjuster instanceof LocalDateTime) {
            return (LocalDateTime) temporalAdjuster;
        }
        return (LocalDateTime) temporalAdjuster.adjustInto(this);
    }

    /* Return type fixed from 'org.threeten.bp.LocalDateTime' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime
    public ChronoLocalDateTime<LocalDate> with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalDateTime) temporalField.adjustInto(this, j);
        }
        if (temporalField.isTimeBased()) {
            return with(this.date, this.time.with(temporalField, j));
        }
        return with(this.date.with(temporalField, j), this.time);
    }
}
