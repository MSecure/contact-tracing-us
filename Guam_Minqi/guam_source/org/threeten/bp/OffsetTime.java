package org.threeten.bp;

import androidx.recyclerview.widget.RecyclerView;
import com.horcrux.svg.PathParser;
import java.io.DataInput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;

public final class OffsetTime extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<OffsetTime>, Serializable {
    public final ZoneOffset offset;
    public final LocalTime time;

    static {
        LocalTime localTime = LocalTime.MIN;
        ZoneOffset zoneOffset = ZoneOffset.MAX;
        if (localTime != null) {
            new OffsetTime(localTime, zoneOffset);
            LocalTime localTime2 = LocalTime.MAX;
            ZoneOffset zoneOffset2 = ZoneOffset.MIN;
            if (localTime2 != null) {
                new OffsetTime(localTime2, zoneOffset2);
                return;
            }
            throw null;
        }
        throw null;
    }

    public OffsetTime(LocalTime localTime, ZoneOffset zoneOffset) {
        PathParser.requireNonNull(localTime, "time");
        this.time = localTime;
        PathParser.requireNonNull(zoneOffset, "offset");
        this.offset = zoneOffset;
    }

    public static OffsetTime readExternal(DataInput dataInput) throws IOException {
        return new OffsetTime(LocalTime.readExternal(dataInput), ZoneOffset.readExternal(dataInput));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 66, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.NANO_OF_DAY, this.time.toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, (long) this.offset.totalSeconds);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(OffsetTime offsetTime) {
        OffsetTime offsetTime2 = offsetTime;
        if (this.offset.equals(offsetTime2.offset)) {
            return this.time.compareTo(offsetTime2.time);
        }
        int compareLongs = PathParser.compareLongs(this.time.toNanoOfDay() - (((long) this.offset.totalSeconds) * 1000000000), offsetTime2.time.toNanoOfDay() - (((long) offsetTime2.offset.totalSeconds) * 1000000000));
        return compareLongs == 0 ? this.time.compareTo(offsetTime2.time) : compareLongs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetTime)) {
            return false;
        }
        OffsetTime offsetTime = (OffsetTime) obj;
        return this.time.equals(offsetTime.time) && this.offset.equals(offsetTime.offset);
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
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return (long) this.offset.totalSeconds;
        }
        return this.time.getLong(temporalField);
    }

    public int hashCode() {
        return this.time.hashCode() ^ this.offset.totalSeconds;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() || temporalField == ChronoField.OFFSET_SECONDS : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(RecyclerView.FOREVER_NS, temporalUnit).plus(1L, temporalUnit) : plus(-j, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.PRECISION) {
            return (R) ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.OFFSET || temporalQuery == TemporalQueries.ZONE) {
            return (R) this.offset;
        }
        if (temporalQuery == TemporalQueries.LOCAL_TIME) {
            return (R) this.time;
        }
        if (temporalQuery == TemporalQueries.CHRONO || temporalQuery == TemporalQueries.LOCAL_DATE || temporalQuery == TemporalQueries.ZONE_ID) {
            return null;
        }
        return (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return temporalField.range();
        }
        return this.time.range(temporalField);
    }

    public String toString() {
        return this.time.toString() + this.offset.id;
    }

    public final OffsetTime with(LocalTime localTime, ZoneOffset zoneOffset) {
        if (this.time != localTime || !this.offset.equals(zoneOffset)) {
            return new OffsetTime(localTime, zoneOffset);
        }
        return this;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return with(this.time.plus(j, temporalUnit), this.offset);
        }
        return (OffsetTime) temporalUnit.addTo(this, j);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalTime) {
            return with((LocalTime) temporalAdjuster, this.offset);
        }
        if (temporalAdjuster instanceof ZoneOffset) {
            return with(this.time, (ZoneOffset) temporalAdjuster);
        }
        if (temporalAdjuster instanceof OffsetTime) {
            return (OffsetTime) temporalAdjuster;
        }
        return (OffsetTime) ((LocalDate) temporalAdjuster).adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (OffsetTime) temporalField.adjustInto(this, j);
        }
        if (temporalField != ChronoField.OFFSET_SECONDS) {
            return with(this.time.with(temporalField, j), this.offset);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        return with(this.time, ZoneOffset.ofTotalSeconds(chronoField.range.checkValidIntValue(j, chronoField)));
    }
}
