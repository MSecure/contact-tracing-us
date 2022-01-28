package org.threeten.bp.chrono;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.horcrux.svg.PathParser;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
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

public abstract class ChronoZonedDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Temporal, Comparable<ChronoZonedDateTime<?>> {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChronoZonedDateTime) {
            return compareTo((ChronoZonedDateTime) obj) == 0;
        }
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
        }
        int ordinal = ((ChronoField) temporalField).ordinal();
        if (ordinal == 28) {
            throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline10("Field too large for an int: ", temporalField));
        } else if (ordinal != 29) {
            return toLocalDateTime().get(temporalField);
        } else {
            return getOffset().totalSeconds;
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
            return toLocalDateTime().getLong(temporalField);
        }
        return (long) getOffset().totalSeconds;
    }

    public abstract ZoneOffset getOffset();

    public abstract ZoneId getZone();

    public int hashCode() {
        return (toLocalDateTime().hashCode() ^ getOffset().totalSeconds) ^ Integer.rotateLeft(getZone().hashCode(), 3);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public abstract ChronoZonedDateTime<D> plus(long j, TemporalUnit temporalUnit);

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return (temporalQuery == TemporalQueries.ZONE_ID || temporalQuery == TemporalQueries.ZONE) ? (R) getZone() : temporalQuery == TemporalQueries.CHRONO ? (R) toLocalDate().getChronology() : temporalQuery == TemporalQueries.PRECISION ? (R) ChronoUnit.NANOS : temporalQuery == TemporalQueries.OFFSET ? (R) getOffset() : temporalQuery == TemporalQueries.LOCAL_DATE ? (R) LocalDate.ofEpochDay(toLocalDate().toEpochDay()) : temporalQuery == TemporalQueries.LOCAL_TIME ? (R) toLocalTime() : (R) super.query(temporalQuery);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) {
            return temporalField.range();
        }
        return toLocalDateTime().range(temporalField);
    }

    public long toEpochSecond() {
        return ((toLocalDate().toEpochDay() * 86400) + ((long) toLocalTime().toSecondOfDay())) - ((long) getOffset().totalSeconds);
    }

    public D toLocalDate() {
        return toLocalDateTime().toLocalDate();
    }

    public abstract ChronoLocalDateTime<D> toLocalDateTime();

    public LocalTime toLocalTime() {
        return toLocalDateTime().toLocalTime();
    }

    public String toString() {
        String str = toLocalDateTime().toString() + getOffset().id;
        if (getOffset() == getZone()) {
            return str;
        }
        return str + '[' + getZone().toString() + ']';
    }

    @Override // org.threeten.bp.temporal.Temporal
    public abstract ChronoZonedDateTime<D> with(TemporalField temporalField, long j);

    public abstract ChronoZonedDateTime<D> withZoneSameLocal(ZoneId zoneId);

    public int compareTo(ChronoZonedDateTime<?> chronoZonedDateTime) {
        int compareLongs = PathParser.compareLongs(toEpochSecond(), chronoZonedDateTime.toEpochSecond());
        if (compareLongs != 0) {
            return compareLongs;
        }
        int i = toLocalTime().nano - chronoZonedDateTime.toLocalTime().nano;
        if (i != 0) {
            return i;
        }
        int compareTo = toLocalDateTime().compareTo(chronoZonedDateTime.toLocalDateTime());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = getZone().getId().compareTo(chronoZonedDateTime.getZone().getId());
        return compareTo2 == 0 ? toLocalDate().getChronology().compareTo(chronoZonedDateTime.toLocalDate().getChronology()) : compareTo2;
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public ChronoZonedDateTime<D> minus(long j, TemporalUnit temporalUnit) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.minus(j, temporalUnit));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime<D> with(TemporalAdjuster temporalAdjuster) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(temporalAdjuster.adjustInto(this));
    }
}
