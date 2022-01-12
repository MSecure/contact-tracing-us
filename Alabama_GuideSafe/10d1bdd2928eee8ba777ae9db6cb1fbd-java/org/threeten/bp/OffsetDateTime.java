package org.threeten.bp;

import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.DataInput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneRules;

public final class OffsetDateTime extends DefaultInterfaceTemporal implements Temporal, TemporalAdjuster, Comparable<OffsetDateTime>, Serializable {
    public final LocalDateTime dateTime;
    public final ZoneOffset offset;

    static {
        LocalDateTime localDateTime = LocalDateTime.MIN;
        ZoneOffset zoneOffset = ZoneOffset.MAX;
        if (localDateTime != null) {
            new OffsetDateTime(localDateTime, zoneOffset);
            LocalDateTime localDateTime2 = LocalDateTime.MAX;
            ZoneOffset zoneOffset2 = ZoneOffset.MIN;
            if (localDateTime2 != null) {
                new OffsetDateTime(localDateTime2, zoneOffset2);
                return;
            }
            throw null;
        }
        throw null;
    }

    public OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        MoreExecutors.requireNonNull(localDateTime, "dateTime");
        this.dateTime = localDateTime;
        MoreExecutors.requireNonNull(zoneOffset, "offset");
        this.offset = zoneOffset;
    }

    public static OffsetDateTime ofInstant(Instant instant, ZoneId zoneId) {
        MoreExecutors.requireNonNull(instant, "instant");
        MoreExecutors.requireNonNull(zoneId, "zone");
        ZoneOffset zoneOffset = ((ZoneRules.Fixed) zoneId.getRules()).offset;
        return new OffsetDateTime(LocalDateTime.ofEpochSecond(instant.seconds, instant.nanos, zoneOffset), zoneOffset);
    }

    public static OffsetDateTime readExternal(DataInput dataInput) throws IOException {
        return new OffsetDateTime(LocalDateTime.readExternal(dataInput), ZoneOffset.readExternal(dataInput));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 69, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, this.dateTime.date.toEpochDay()).with(ChronoField.NANO_OF_DAY, this.dateTime.time.toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, (long) this.offset.totalSeconds);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(OffsetDateTime offsetDateTime) {
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if (this.offset.equals(offsetDateTime2.offset)) {
            return this.dateTime.compareTo((ChronoLocalDateTime<?>) offsetDateTime2.dateTime);
        }
        int compareLongs = MoreExecutors.compareLongs(toEpochSecond(), offsetDateTime2.toEpochSecond());
        if (compareLongs != 0) {
            return compareLongs;
        }
        LocalDateTime localDateTime = this.dateTime;
        int i = localDateTime.time.nano;
        LocalDateTime localDateTime2 = offsetDateTime2.dateTime;
        int i2 = i - localDateTime2.time.nano;
        return i2 == 0 ? localDateTime.compareTo((ChronoLocalDateTime<?>) localDateTime2) : i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetDateTime)) {
            return false;
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        return this.dateTime.equals(offsetDateTime.dateTime) && this.offset.equals(offsetDateTime.offset);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
        }
        int ordinal = ((ChronoField) temporalField).ordinal();
        if (ordinal == 28) {
            throw new DateTimeException(GeneratedOutlineSupport.outline12("Field too large for an int: ", temporalField));
        } else if (ordinal != 29) {
            return this.dateTime.get(temporalField);
        } else {
            return this.offset.totalSeconds;
        }
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int ordinal = ((ChronoField) temporalField).ordinal();
        if (ordinal == 28) {
            return toEpochSecond();
        }
        if (ordinal != 29) {
            return this.dateTime.getLong(temporalField);
        }
        return (long) this.offset.totalSeconds;
    }

    public int getNano() {
        return this.dateTime.time.nano;
    }

    public int hashCode() {
        return this.dateTime.hashCode() ^ this.offset.totalSeconds;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return (temporalField instanceof ChronoField) || (temporalField != null && temporalField.isSupportedBy(this));
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public Temporal minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(RecyclerView.FOREVER_NS, temporalUnit).plus(1L, temporalUnit) : plus(-j, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.CHRONO) {
            return (R) IsoChronology.INSTANCE;
        }
        if (temporalQuery == TemporalQueries.PRECISION) {
            return (R) ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.OFFSET || temporalQuery == TemporalQueries.ZONE) {
            return (R) this.offset;
        }
        if (temporalQuery == TemporalQueries.LOCAL_DATE) {
            return (R) this.dateTime.date;
        }
        if (temporalQuery == TemporalQueries.LOCAL_TIME) {
            return (R) this.dateTime.time;
        }
        if (temporalQuery == TemporalQueries.ZONE_ID) {
            return null;
        }
        return (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) {
            return temporalField.range();
        }
        return this.dateTime.range(temporalField);
    }

    public long toEpochSecond() {
        return this.dateTime.toEpochSecond(this.offset);
    }

    public String toString() {
        return this.dateTime.toString() + this.offset.id;
    }

    public final OffsetDateTime with(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        if (this.dateTime != localDateTime || !this.offset.equals(zoneOffset)) {
            return new OffsetDateTime(localDateTime, zoneOffset);
        }
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: org.threeten.bp.OffsetDateTime */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [org.threeten.bp.LocalDateTime] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // org.threeten.bp.temporal.Temporal
    public OffsetDateTime plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return with((LocalDateTime) this.dateTime.plus(j, temporalUnit), this.offset);
        }
        return (OffsetDateTime) temporalUnit.addTo(this, j);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: org.threeten.bp.OffsetDateTime */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.threeten.bp.LocalDateTime] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // org.threeten.bp.temporal.Temporal
    public Temporal with(TemporalAdjuster temporalAdjuster) {
        return with((LocalDateTime) this.dateTime.with(temporalAdjuster), this.offset);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: org.threeten.bp.OffsetDateTime */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v8, types: [org.threeten.bp.LocalDateTime] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // org.threeten.bp.temporal.Temporal
    public Temporal with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (OffsetDateTime) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int ordinal = chronoField.ordinal();
        if (ordinal == 28) {
            return ofInstant(Instant.ofEpochSecond(j, (long) getNano()), this.offset);
        }
        if (ordinal != 29) {
            return with((LocalDateTime) this.dateTime.with(temporalField, j), this.offset);
        }
        return with(this.dateTime, ZoneOffset.ofTotalSeconds(chronoField.range.checkValidIntValue(j, chronoField)));
    }
}
