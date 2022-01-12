package org.threeten.bp;

import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

public final class ZonedDateTime extends ChronoZonedDateTime<LocalDate> implements Temporal, Serializable {
    public final LocalDateTime dateTime;
    public final ZoneOffset offset;
    public final ZoneId zone;

    public ZonedDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.dateTime = localDateTime;
        this.offset = zoneOffset;
        this.zone = zoneId;
    }

    public static ZonedDateTime create(long j, int i, ZoneId zoneId) {
        ZoneOffset offset2 = zoneId.getRules().getOffset(Instant.ofEpochSecond(j, (long) i));
        return new ZonedDateTime(LocalDateTime.ofEpochSecond(j, i, offset2), offset2, zoneId);
    }

    public static ZonedDateTime ofLocal(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        MoreExecutors.requireNonNull(localDateTime, "localDateTime");
        MoreExecutors.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, (ZoneOffset) zoneId, zoneId);
        }
        ZoneRules rules = zoneId.getRules();
        List<ZoneOffset> validOffsets = rules.getValidOffsets(localDateTime);
        if (validOffsets.size() == 1) {
            zoneOffset = validOffsets.get(0);
        } else if (validOffsets.size() == 0) {
            ZoneOffsetTransition transition = rules.getTransition(localDateTime);
            localDateTime = localDateTime.plusSeconds(Duration.ofSeconds((long) (transition.offsetAfter.totalSeconds - transition.offsetBefore.totalSeconds)).seconds);
            zoneOffset = transition.offsetAfter;
        } else if (zoneOffset == null || !validOffsets.contains(zoneOffset)) {
            ZoneOffset zoneOffset2 = validOffsets.get(0);
            MoreExecutors.requireNonNull(zoneOffset2, "offset");
            zoneOffset = zoneOffset2;
        }
        return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedDateTime)) {
            return false;
        }
        ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
        return this.dateTime.equals(zonedDateTime.dateTime) && this.offset.equals(zonedDateTime.offset) && this.zone.equals(zonedDateTime.zone);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.get(temporalField);
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

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.TemporalAccessor
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

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZoneOffset getOffset() {
        return this.offset;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZoneId getZone() {
        return this.zone;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public int hashCode() {
        return (this.dateTime.hashCode() ^ this.offset.totalSeconds) ^ Integer.rotateLeft(this.zone.hashCode(), 3);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return (temporalField instanceof ChronoField) || (temporalField != null && temporalField.isSupportedBy(this));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.LOCAL_DATE ? (R) this.dateTime.date : (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) {
            return temporalField.range();
        }
        return this.dateTime.range(temporalField);
    }

    public final ZonedDateTime resolveLocal(LocalDateTime localDateTime) {
        return ofLocal(localDateTime, this.zone, this.offset);
    }

    public final ZonedDateTime resolveOffset(ZoneOffset zoneOffset) {
        return (zoneOffset.equals(this.offset) || !this.zone.getRules().isValidOffset(this.dateTime, zoneOffset)) ? this : new ZonedDateTime(this.dateTime, zoneOffset, this.zone);
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoLocalDate' to match base method */
    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public LocalDate toLocalDate() {
        return this.dateTime.date;
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoLocalDateTime' to match base method */
    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoLocalDateTime<LocalDate> toLocalDateTime() {
        return this.dateTime;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public LocalTime toLocalTime() {
        return this.dateTime.time;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public String toString() {
        String str = this.dateTime.toString() + this.offset.id;
        if (this.offset == this.zone) {
            return str;
        }
        return str + '[' + this.zone.toString() + ']';
    }

    /* Return type fixed from 'org.threeten.bp.chrono.ChronoZonedDateTime' to match base method */
    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoZonedDateTime<LocalDate> withZoneSameLocal(ZoneId zoneId) {
        MoreExecutors.requireNonNull(zoneId, "zone");
        return this.zone.equals(zoneId) ? this : ofLocal(this.dateTime, zoneId, this.offset);
    }

    /* Return type fixed from 'org.threeten.bp.ZonedDateTime' to match base method */
    /* JADX WARN: Type inference failed for: r3v2, types: [org.threeten.bp.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r3v4, types: [org.threeten.bp.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r3v5, types: [org.threeten.bp.ZonedDateTime] */
    /* JADX WARNING: Unknown variable types count: 3 */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public ChronoZonedDateTime<LocalDate> minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(RecyclerView.FOREVER_NS, temporalUnit).plus(1, temporalUnit) : plus(-j, temporalUnit);
    }

    /* Return type fixed from 'org.threeten.bp.ZonedDateTime' to match base method */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: org.threeten.bp.ZonedDateTime */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.LocalDateTime, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7, types: [org.threeten.bp.LocalDateTime] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoZonedDateTime<LocalDate> plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (ZonedDateTime) temporalUnit.addTo(this, j);
        }
        if (temporalUnit.isDateBased()) {
            return resolveLocal(this.dateTime.plus(j, temporalUnit));
        }
        ?? plus = this.dateTime.plus(j, temporalUnit);
        ZoneOffset zoneOffset = this.offset;
        ZoneId zoneId = this.zone;
        MoreExecutors.requireNonNull(plus, "localDateTime");
        MoreExecutors.requireNonNull(zoneOffset, "offset");
        MoreExecutors.requireNonNull(zoneId, "zone");
        return create(plus.toEpochSecond(zoneOffset), plus.time.nano, zoneId);
    }

    /* Return type fixed from 'org.threeten.bp.ZonedDateTime' to match base method */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoZonedDateTime<LocalDate> with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return ofLocal(LocalDateTime.of((LocalDate) temporalAdjuster, this.dateTime.time), this.zone, this.offset);
        }
        if (temporalAdjuster instanceof LocalTime) {
            return ofLocal(LocalDateTime.of(this.dateTime.date, (LocalTime) temporalAdjuster), this.zone, this.offset);
        }
        if (temporalAdjuster instanceof LocalDateTime) {
            return resolveLocal((LocalDateTime) temporalAdjuster);
        }
        if (temporalAdjuster instanceof Instant) {
            Instant instant = (Instant) temporalAdjuster;
            return create(instant.seconds, instant.nanos, this.zone);
        } else if (temporalAdjuster instanceof ZoneOffset) {
            return resolveOffset((ZoneOffset) temporalAdjuster);
        } else {
            return (ZonedDateTime) temporalAdjuster.adjustInto(this);
        }
    }

    /* Return type fixed from 'org.threeten.bp.ZonedDateTime' to match base method */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: org.threeten.bp.ZonedDateTime */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [org.threeten.bp.LocalDateTime] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoZonedDateTime<LocalDate> with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (ZonedDateTime) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int ordinal = chronoField.ordinal();
        if (ordinal == 28) {
            return create(j, this.dateTime.time.nano, this.zone);
        }
        if (ordinal != 29) {
            return resolveLocal(this.dateTime.with(temporalField, j));
        }
        return resolveOffset(ZoneOffset.ofTotalSeconds(chronoField.range.checkValidIntValue(j, chronoField)));
    }
}
