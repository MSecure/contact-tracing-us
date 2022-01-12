package org.threeten.bp.chrono;

import com.google.common.util.concurrent.MoreExecutors;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

public final class ChronoZonedDateTimeImpl<D extends ChronoLocalDate> extends ChronoZonedDateTime<D> implements Serializable {
    public final ChronoLocalDateTimeImpl<D> dateTime;
    public final ZoneOffset offset;
    public final ZoneId zone;

    public ChronoZonedDateTimeImpl(ChronoLocalDateTimeImpl<D> chronoLocalDateTimeImpl, ZoneOffset zoneOffset, ZoneId zoneId) {
        MoreExecutors.requireNonNull(chronoLocalDateTimeImpl, "dateTime");
        this.dateTime = chronoLocalDateTimeImpl;
        MoreExecutors.requireNonNull(zoneOffset, "offset");
        this.offset = zoneOffset;
        MoreExecutors.requireNonNull(zoneId, "zone");
        this.zone = zoneId;
    }

    public static <R extends ChronoLocalDate> ChronoZonedDateTime<R> ofBest(ChronoLocalDateTimeImpl<R> chronoLocalDateTimeImpl, ZoneId zoneId, ZoneOffset zoneOffset) {
        MoreExecutors.requireNonNull(chronoLocalDateTimeImpl, "localDateTime");
        MoreExecutors.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ChronoZonedDateTimeImpl(chronoLocalDateTimeImpl, (ZoneOffset) zoneId, zoneId);
        }
        ZoneRules rules = zoneId.getRules();
        LocalDateTime from = LocalDateTime.from(chronoLocalDateTimeImpl);
        List<ZoneOffset> validOffsets = rules.getValidOffsets(from);
        if (validOffsets.size() == 1) {
            zoneOffset = validOffsets.get(0);
        } else if (validOffsets.size() == 0) {
            ZoneOffsetTransition transition = rules.getTransition(from);
            chronoLocalDateTimeImpl = chronoLocalDateTimeImpl.plusWithOverflow(chronoLocalDateTimeImpl.date, 0, 0, Duration.ofSeconds((long) (transition.offsetAfter.totalSeconds - transition.offsetBefore.totalSeconds)).seconds, 0);
            zoneOffset = transition.offsetAfter;
        } else if (zoneOffset == null || !validOffsets.contains(zoneOffset)) {
            zoneOffset = validOffsets.get(0);
        }
        MoreExecutors.requireNonNull(zoneOffset, "offset");
        return new ChronoZonedDateTimeImpl(chronoLocalDateTimeImpl, zoneOffset, zoneId);
    }

    public static <R extends ChronoLocalDate> ChronoZonedDateTimeImpl<R> ofInstant(Chronology chronology, Instant instant, ZoneId zoneId) {
        ZoneOffset offset2 = zoneId.getRules().getOffset(instant);
        MoreExecutors.requireNonNull(offset2, "offset");
        return new ChronoZonedDateTimeImpl<>((ChronoLocalDateTimeImpl) chronology.localDateTime(LocalDateTime.ofEpochSecond(instant.seconds, instant.nanos, offset2)), offset2, zoneId);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 13, this);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChronoZonedDateTime) {
            return compareTo((ChronoZonedDateTime) obj) == 0;
        }
        return false;
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

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoLocalDateTime<D> toLocalDateTime() {
        return this.dateTime;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public String toString() {
        String str = this.dateTime.toString() + this.offset.id;
        if (this.offset == this.zone) {
            return str;
        }
        return str + '[' + this.zone.toString() + ']';
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoZonedDateTime<D> withZoneSameLocal(ZoneId zoneId) {
        return ofBest(this.dateTime, zoneId, this.offset);
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoZonedDateTime<D> plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return toLocalDate().getChronology().ensureChronoZonedDateTime(temporalUnit.addTo(this, j));
        }
        return toLocalDate().getChronology().ensureChronoZonedDateTime(this.dateTime.plus(j, temporalUnit).adjustInto(this));
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoZonedDateTime<D> with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return toLocalDate().getChronology().ensureChronoZonedDateTime(temporalField.adjustInto(this, j));
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int ordinal = chronoField.ordinal();
        if (ordinal == 28) {
            return plus(j - toEpochSecond(), (TemporalUnit) ChronoUnit.SECONDS);
        }
        if (ordinal != 29) {
            return ofBest(this.dateTime.with(temporalField, j), this.zone, this.offset);
        }
        ZoneOffset ofTotalSeconds = ZoneOffset.ofTotalSeconds(chronoField.range.checkValidIntValue(j, chronoField));
        ChronoLocalDateTimeImpl<D> chronoLocalDateTimeImpl = this.dateTime;
        return ofInstant(toLocalDate().getChronology(), Instant.ofEpochSecond(chronoLocalDateTimeImpl.toEpochSecond(ofTotalSeconds), (long) chronoLocalDateTimeImpl.time.nano), this.zone);
    }
}
