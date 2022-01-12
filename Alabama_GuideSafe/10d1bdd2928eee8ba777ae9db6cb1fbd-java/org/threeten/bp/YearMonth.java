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
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.SignStyle;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class YearMonth extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<YearMonth>, Serializable {
    public final int month;
    public final int year;

    static {
        DateTimeFormatterBuilder appendValue = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD);
        appendValue.appendLiteral('-');
        appendValue.appendValue(ChronoField.MONTH_OF_YEAR, 2);
        appendValue.toFormatter();
    }

    public YearMonth(int i, int i2) {
        this.year = i;
        this.month = i2;
    }

    public static YearMonth of(int i, int i2) {
        ChronoField chronoField = ChronoField.YEAR;
        chronoField.range.checkValidValue((long) i, chronoField);
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        chronoField2.range.checkValidValue((long) i2, chronoField2);
        return new YearMonth(i, i2);
    }

    public static YearMonth readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readInt(), dataInput.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 68, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        if (Chronology.from(temporal).equals(IsoChronology.INSTANCE)) {
            return temporal.with(ChronoField.PROLEPTIC_MONTH, (((long) this.year) * 12) + ((long) (this.month - 1)));
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(YearMonth yearMonth) {
        YearMonth yearMonth2 = yearMonth;
        int i = this.year - yearMonth2.year;
        return i == 0 ? this.month - yearMonth2.month : i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YearMonth)) {
            return false;
        }
        YearMonth yearMonth = (YearMonth) obj;
        return this.year == yearMonth.year && this.month == yearMonth.month;
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
        int i2 = 1;
        switch (((ChronoField) temporalField).ordinal()) {
            case 23:
                i = this.month;
                break;
            case 24:
                return (((long) this.year) * 12) + ((long) (this.month - 1));
            case 25:
                int i3 = this.year;
                if (i3 < 1) {
                    i3 = 1 - i3;
                }
                return (long) i3;
            case 26:
                i = this.year;
                break;
            case 27:
                if (this.year < 1) {
                    i2 = 0;
                }
                return (long) i2;
            default:
                throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline12("Unsupported field: ", temporalField));
        }
        return (long) i;
    }

    public int hashCode() {
        return this.year ^ (this.month << 27);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.YEAR || temporalField == ChronoField.MONTH_OF_YEAR || temporalField == ChronoField.PROLEPTIC_MONTH || temporalField == ChronoField.YEAR_OF_ERA || temporalField == ChronoField.ERA : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(RecyclerView.FOREVER_NS, temporalUnit).plus(1L, temporalUnit) : plus(-j, temporalUnit);
    }

    public YearMonth plusMonths(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.year) * 12) + ((long) (this.month - 1)) + j;
        return with(ChronoField.YEAR.checkValidIntValue(MoreExecutors.floorDiv(j2, 12)), MoreExecutors.floorMod(j2, 12) + 1);
    }

    public YearMonth plusYears(long j) {
        if (j == 0) {
            return this;
        }
        return with(ChronoField.YEAR.checkValidIntValue(((long) this.year) + j), this.month);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.CHRONO) {
            return (R) IsoChronology.INSTANCE;
        }
        if (temporalQuery == TemporalQueries.PRECISION) {
            return (R) ChronoUnit.MONTHS;
        }
        if (temporalQuery == TemporalQueries.LOCAL_DATE || temporalQuery == TemporalQueries.LOCAL_TIME || temporalQuery == TemporalQueries.ZONE || temporalQuery == TemporalQueries.ZONE_ID || temporalQuery == TemporalQueries.OFFSET) {
            return null;
        }
        return (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField != ChronoField.YEAR_OF_ERA) {
            return super.range(temporalField);
        }
        return ValueRange.of(1, this.year <= 0 ? Http2Connection.DEGRADED_PONG_TIMEOUT_NS : 999999999);
    }

    public String toString() {
        int abs = Math.abs(this.year);
        StringBuilder sb = new StringBuilder(9);
        if (abs < 1000) {
            int i = this.year;
            if (i < 0) {
                sb.append(i - 10000);
                sb.deleteCharAt(1);
            } else {
                sb.append(i + 10000);
                sb.deleteCharAt(0);
            }
        } else {
            sb.append(this.year);
        }
        sb.append(this.month < 10 ? "-0" : "-");
        sb.append(this.month);
        return sb.toString();
    }

    public YearMonth withYear(int i) {
        ChronoField chronoField = ChronoField.YEAR;
        chronoField.range.checkValidValue((long) i, chronoField);
        return with(i, this.month);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (YearMonth) temporalUnit.addTo(this, j);
        }
        switch (((ChronoUnit) temporalUnit).ordinal()) {
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

    public final YearMonth with(int i, int i2) {
        if (this.year == i && this.month == i2) {
            return this;
        }
        return new YearMonth(i, i2);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal with(TemporalAdjuster temporalAdjuster) {
        return (YearMonth) ((LocalDate) temporalAdjuster).adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (YearMonth) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.range.checkValidValue(j, chronoField);
        switch (chronoField.ordinal()) {
            case 23:
                int i = (int) j;
                ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
                chronoField2.range.checkValidValue((long) i, chronoField2);
                return with(this.year, i);
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
}
