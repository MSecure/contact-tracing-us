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

public final class Year extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<Year>, Serializable {
    public final int year;

    static {
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).toFormatter();
    }

    public Year(int i) {
        this.year = i;
    }

    public static Year of(int i) {
        ChronoField chronoField = ChronoField.YEAR;
        chronoField.range.checkValidValue((long) i, chronoField);
        return new Year(i);
    }

    public static Year readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 67, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        if (Chronology.from(temporal).equals(IsoChronology.INSTANCE)) {
            return temporal.with(ChronoField.YEAR, (long) this.year);
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(Year year2) {
        return this.year - year2.year;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Year) {
            return this.year == ((Year) obj).year;
        }
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public int get(TemporalField temporalField) {
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i = 1;
        switch (((ChronoField) temporalField).ordinal()) {
            case 25:
                int i2 = this.year;
                if (i2 < 1) {
                    i2 = 1 - i2;
                }
                return (long) i2;
            case 26:
                return (long) this.year;
            case 27:
                if (this.year < 1) {
                    i = 0;
                }
                return (long) i;
            default:
                throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline12("Unsupported field: ", temporalField));
        }
    }

    public int hashCode() {
        return this.year;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.YEAR || temporalField == ChronoField.YEAR_OF_ERA || temporalField == ChronoField.ERA : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(RecyclerView.FOREVER_NS, temporalUnit).plus(1L, temporalUnit) : plus(-j, temporalUnit);
    }

    public Year plusYears(long j) {
        return j == 0 ? this : of(ChronoField.YEAR.checkValidIntValue(((long) this.year) + j));
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.CHRONO) {
            return (R) IsoChronology.INSTANCE;
        }
        if (temporalQuery == TemporalQueries.PRECISION) {
            return (R) ChronoUnit.YEARS;
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
        return Integer.toString(this.year);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Year) temporalUnit.addTo(this, j);
        }
        switch (((ChronoUnit) temporalUnit).ordinal()) {
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

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal with(TemporalAdjuster temporalAdjuster) {
        return (Year) ((LocalDate) temporalAdjuster).adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (Year) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.range.checkValidValue(j, chronoField);
        switch (chronoField.ordinal()) {
            case 25:
                if (this.year < 1) {
                    j = 1 - j;
                }
                return of((int) j);
            case 26:
                return of((int) j);
            case 27:
                return getLong(ChronoField.ERA) == j ? this : of(1 - this.year);
            default:
                throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline12("Unsupported field: ", temporalField));
        }
    }
}
