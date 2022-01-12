package org.threeten.bp;

import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.DataInput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import okhttp3.internal.http2.Http2Connection;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.Era;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class LocalDate extends ChronoLocalDate implements Temporal, TemporalAdjuster, Serializable {
    public static final LocalDate MAX = of(999999999, 12, 31);
    public static final LocalDate MIN = of(-999999999, 1, 1);
    public final short day;
    public final short month;
    public final int year;

    public LocalDate(int i, int i2, int i3) {
        this.year = i;
        this.month = (short) i2;
        this.day = (short) i3;
    }

    public static LocalDate create(int i, Month month2, int i2) {
        if (i2 <= 28 || i2 <= month2.length(IsoChronology.INSTANCE.isLeapYear((long) i))) {
            return new LocalDate(i, month2.getValue(), i2);
        }
        if (i2 == 29) {
            throw new DateTimeException(GeneratedOutlineSupport.outline6("Invalid date 'February 29' as '", i, "' is not a leap year"));
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Invalid date '");
        outline17.append(month2.name());
        outline17.append(" ");
        outline17.append(i2);
        outline17.append("'");
        throw new DateTimeException(outline17.toString());
    }

    public static LocalDate from(TemporalAccessor temporalAccessor) {
        LocalDate localDate = (LocalDate) temporalAccessor.query(TemporalQueries.LOCAL_DATE);
        if (localDate != null) {
            return localDate;
        }
        throw new DateTimeException(GeneratedOutlineSupport.outline15(temporalAccessor, GeneratedOutlineSupport.outline21("Unable to obtain LocalDate from TemporalAccessor: ", temporalAccessor, ", type ")));
    }

    public static LocalDate of(int i, Month month2, int i2) {
        ChronoField chronoField = ChronoField.YEAR;
        chronoField.range.checkValidValue((long) i, chronoField);
        MoreExecutors.requireNonNull(month2, "month");
        ChronoField chronoField2 = ChronoField.DAY_OF_MONTH;
        chronoField2.range.checkValidValue((long) i2, chronoField2);
        return create(i, month2, i2);
    }

    public static LocalDate ofEpochDay(long j) {
        long j2;
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        chronoField.range.checkValidValue(j, chronoField);
        long j3 = (j + 719528) - 60;
        if (j3 < 0) {
            long j4 = ((j3 + 1) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((j5 / 400) + (((j5 / 4) + (j5 * 365)) - (j5 / 100)));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((j5 / 400) + (((j5 / 4) + (365 * j5)) - (j5 / 100)));
        }
        int i = (int) j6;
        int i2 = ((i * 5) + 2) / 153;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue(j5 + j2 + ((long) (i2 / 10))), ((i2 + 2) % 12) + 1, (i - (((i2 * 306) + 5) / 10)) + 1);
    }

    public static LocalDate readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static LocalDate resolvePreviousValid(int i, int i2, int i3) {
        if (i2 == 2) {
            i3 = Math.min(i3, IsoChronology.INSTANCE.isLeapYear((long) i) ? 29 : 28);
        } else if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
            i3 = Math.min(i3, 30);
        }
        return of(i, i2, i3);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster, org.threeten.bp.chrono.ChronoLocalDate
    public Temporal adjustInto(Temporal temporal) {
        return super.adjustInto(temporal);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public ChronoLocalDateTime atTime(LocalTime localTime) {
        return LocalDateTime.of(this, localTime);
    }

    public int compareTo0(LocalDate localDate) {
        int i = this.year - localDate.year;
        if (i != 0) {
            return i;
        }
        int i2 = this.month - localDate.month;
        return i2 == 0 ? this.day - localDate.day : i2;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDate) {
            return compareTo0((LocalDate) obj) == 0;
        }
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public int get(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return get0(temporalField);
        }
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    public final int get0(TemporalField temporalField) {
        switch (((ChronoField) temporalField).ordinal()) {
            case 15:
                return getDayOfWeek().getValue();
            case 16:
                return ((this.day - 1) % 7) + 1;
            case 17:
                return ((getDayOfYear() - 1) % 7) + 1;
            case 18:
                return this.day;
            case 19:
                return getDayOfYear();
            case 20:
                throw new DateTimeException(GeneratedOutlineSupport.outline12("Field too large for an int: ", temporalField));
            case 21:
                return ((this.day - 1) / 7) + 1;
            case 22:
                return ((getDayOfYear() - 1) / 7) + 1;
            case 23:
                return this.month;
            case 24:
                throw new DateTimeException(GeneratedOutlineSupport.outline12("Field too large for an int: ", temporalField));
            case 25:
                int i = this.year;
                return i >= 1 ? i : 1 - i;
            case 26:
                return this.year;
            case 27:
                if (this.year >= 1) {
                    return 1;
                }
                return 0;
            default:
                throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline12("Unsupported field: ", temporalField));
        }
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Chronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.of(MoreExecutors.floorMod(toEpochDay() + 3, 7) + 1);
    }

    public int getDayOfYear() {
        return (Month.of(this.month).firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Era getEra() {
        return super.getEra();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        if (temporalField == ChronoField.EPOCH_DAY) {
            return toEpochDay();
        }
        if (temporalField == ChronoField.PROLEPTIC_MONTH) {
            return (((long) this.year) * 12) + ((long) (this.month - 1));
        }
        return (long) get0(temporalField);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int hashCode() {
        int i = this.year;
        return (((i << 11) + (this.month << 6)) + this.day) ^ (i & -2048);
    }

    public boolean isBefore(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? compareTo0((LocalDate) chronoLocalDate) < 0 : toEpochDay() < chronoLocalDate.toEpochDay();
    }

    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear((long) this.year);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return super.isSupported(temporalField);
    }

    public LocalDate plusDays(long j) {
        if (j == 0) {
            return this;
        }
        return ofEpochDay(MoreExecutors.safeAdd(toEpochDay(), j));
    }

    public LocalDate plusMonths(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.year) * 12) + ((long) (this.month - 1)) + j;
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(MoreExecutors.floorDiv(j2, 12)), MoreExecutors.floorMod(j2, 12) + 1, this.day);
    }

    public LocalDate plusWeeks(long j) {
        return plusDays(MoreExecutors.safeMultiply(j, 7));
    }

    public LocalDate plusYears(long j) {
        if (j == 0) {
            return this;
        }
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(((long) this.year) + j), this.month, this.day);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: org.threeten.bp.LocalDate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.LOCAL_DATE ? this : (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        int i;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (chronoField.isDateBased()) {
            int ordinal = chronoField.ordinal();
            if (ordinal == 18) {
                short s = this.month;
                if (s != 2) {
                    i = (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31;
                } else {
                    i = isLeapYear() ? 29 : 28;
                }
                return ValueRange.of(1, (long) i);
            } else if (ordinal == 19) {
                return ValueRange.of(1, (long) (isLeapYear() ? 366 : 365));
            } else if (ordinal == 21) {
                return ValueRange.of(1, (Month.of(this.month) != Month.FEBRUARY || isLeapYear()) ? 5 : 4);
            } else if (ordinal != 25) {
                return temporalField.range();
            } else {
                return ValueRange.of(1, this.year <= 0 ? Http2Connection.DEGRADED_PONG_TIMEOUT_NS : 999999999);
            }
        } else {
            throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline12("Unsupported field: ", temporalField));
        }
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        long j;
        long j2 = (long) this.year;
        long j3 = (long) this.month;
        long j4 = (365 * j2) + 0;
        if (j2 >= 0) {
            j = ((j2 + 399) / 400) + (((3 + j2) / 4) - ((99 + j2) / 100)) + j4;
        } else {
            j = j4 - ((j2 / -400) + ((j2 / -4) - (j2 / -100)));
        }
        long j5 = (((367 * j3) - 362) / 12) + j + ((long) (this.day - 1));
        if (j3 > 2) {
            j5--;
            if (!isLeapYear()) {
                j5--;
            }
        }
        return j5 - 719528;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public String toString() {
        int i = this.year;
        short s = this.month;
        short s2 = this.day;
        int abs = Math.abs(i);
        StringBuilder sb = new StringBuilder(10);
        if (abs >= 1000) {
            if (i > 9999) {
                sb.append('+');
            }
            sb.append(i);
        } else if (i < 0) {
            sb.append(i - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i + 10000);
            sb.deleteCharAt(0);
        }
        String str = "-0";
        sb.append(s < 10 ? str : "-");
        sb.append((int) s);
        if (s2 >= 10) {
            str = "-";
        }
        sb.append(str);
        sb.append((int) s2);
        return sb.toString();
    }

    public LocalDate withDayOfYear(int i) {
        if (getDayOfYear() == i) {
            return this;
        }
        int i2 = this.year;
        ChronoField chronoField = ChronoField.YEAR;
        long j = (long) i2;
        chronoField.range.checkValidValue(j, chronoField);
        ChronoField chronoField2 = ChronoField.DAY_OF_YEAR;
        chronoField2.range.checkValidValue((long) i, chronoField2);
        boolean isLeapYear = IsoChronology.INSTANCE.isLeapYear(j);
        if (i != 366 || isLeapYear) {
            Month of = Month.of(((i - 1) / 31) + 1);
            if (i > (of.length(isLeapYear) + of.firstDayOfYear(isLeapYear)) - 1) {
                of = Month.ENUMS[((((int) 1) + 12) + of.ordinal()) % 12];
            }
            return create(i2, of, (i - of.firstDayOfYear(isLeapYear)) + 1);
        }
        throw new DateTimeException(GeneratedOutlineSupport.outline6("Invalid date 'DayOfYear 366' as '", i2, "' is not a leap year"));
    }

    public LocalDate withYear(int i) {
        if (this.year == i) {
            return this;
        }
        ChronoField chronoField = ChronoField.YEAR;
        chronoField.range.checkValidValue((long) i, chronoField);
        return resolvePreviousValid(i, this.month, this.day);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int compareTo(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return compareTo0((LocalDate) chronoLocalDate);
        }
        return super.compareTo(chronoLocalDate);
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public LocalDate minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(RecyclerView.FOREVER_NS, temporalUnit).plus(1L, temporalUnit) : plus(-j, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public LocalDate plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDate) temporalUnit.addTo(this, j);
        }
        switch (((ChronoUnit) temporalUnit).ordinal()) {
            case 7:
                return plusDays(j);
            case 8:
                return plusWeeks(j);
            case 9:
                return plusMonths(j);
            case 10:
                return plusYears(j);
            case 11:
                return plusYears(MoreExecutors.safeMultiply(j, 10));
            case 12:
                return plusYears(MoreExecutors.safeMultiply(j, 100));
            case 13:
                return plusYears(MoreExecutors.safeMultiply(j, (int) RNCWebViewManager.COMMAND_CLEAR_FORM_DATA));
            case 14:
                ChronoField chronoField = ChronoField.ERA;
                return with((TemporalField) chronoField, MoreExecutors.safeAdd(getLong(chronoField), j));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public LocalDate with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return (LocalDate) temporalAdjuster;
        }
        return (LocalDate) temporalAdjuster.adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public LocalDate with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalDate) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.range.checkValidValue(j, chronoField);
        switch (chronoField.ordinal()) {
            case 15:
                return plusDays(j - ((long) getDayOfWeek().getValue()));
            case 16:
                return plusDays(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 17:
                return plusDays(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 18:
                int i = (int) j;
                return this.day == i ? this : of(this.year, this.month, i);
            case 19:
                return withDayOfYear((int) j);
            case 20:
                return ofEpochDay(j);
            case 21:
                return plusWeeks(j - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
            case 22:
                return plusWeeks(j - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
            case 23:
                int i2 = (int) j;
                if (this.month == i2) {
                    return this;
                }
                ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
                chronoField2.range.checkValidValue((long) i2, chronoField2);
                return resolvePreviousValid(this.year, i2, this.day);
            case 24:
                return plusMonths(j - getLong(ChronoField.PROLEPTIC_MONTH));
            case 25:
                if (this.year < 1) {
                    j = 1 - j;
                }
                return withYear((int) j);
            case 26:
                return withYear((int) j);
            case 27:
                return getLong(ChronoField.ERA) == j ? this : withYear(1 - this.year);
            default:
                throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline12("Unsupported field: ", temporalField));
        }
    }

    public static LocalDate of(int i, int i2, int i3) {
        ChronoField chronoField = ChronoField.YEAR;
        chronoField.range.checkValidValue((long) i, chronoField);
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        chronoField2.range.checkValidValue((long) i2, chronoField2);
        ChronoField chronoField3 = ChronoField.DAY_OF_MONTH;
        chronoField3.range.checkValidValue((long) i3, chronoField3);
        return create(i, Month.of(i2), i3);
    }
}
