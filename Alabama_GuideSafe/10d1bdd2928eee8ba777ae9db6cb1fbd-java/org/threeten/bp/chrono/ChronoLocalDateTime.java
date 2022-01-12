package org.threeten.bp.chrono;

import com.google.common.util.concurrent.MoreExecutors;
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

public abstract class ChronoLocalDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Temporal, TemporalAdjuster, Comparable<ChronoLocalDateTime<?>> {
    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay());
    }

    public abstract ChronoZonedDateTime<D> atZone(ZoneId zoneId);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChronoLocalDateTime) {
            return compareTo((ChronoLocalDateTime) obj) == 0;
        }
        return false;
    }

    public Chronology getChronology() {
        return toLocalDate().getChronology();
    }

    public int hashCode() {
        return toLocalDate().hashCode() ^ toLocalTime().hashCode();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public abstract ChronoLocalDateTime<D> plus(long j, TemporalUnit temporalUnit);

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.CHRONO) {
            return (R) getChronology();
        }
        if (temporalQuery == TemporalQueries.PRECISION) {
            return (R) ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.LOCAL_DATE) {
            return (R) LocalDate.ofEpochDay(toLocalDate().toEpochDay());
        }
        if (temporalQuery == TemporalQueries.LOCAL_TIME) {
            return (R) toLocalTime();
        }
        if (temporalQuery == TemporalQueries.ZONE || temporalQuery == TemporalQueries.ZONE_ID || temporalQuery == TemporalQueries.OFFSET) {
            return null;
        }
        return (R) super.query(temporalQuery);
    }

    public long toEpochSecond(ZoneOffset zoneOffset) {
        MoreExecutors.requireNonNull(zoneOffset, "offset");
        return ((toLocalDate().toEpochDay() * 86400) + ((long) toLocalTime().toSecondOfDay())) - ((long) zoneOffset.totalSeconds);
    }

    public abstract D toLocalDate();

    public abstract LocalTime toLocalTime();

    public String toString() {
        return toLocalDate().toString() + 'T' + toLocalTime().toString();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public abstract ChronoLocalDateTime<D> with(TemporalField temporalField, long j);

    public int compareTo(ChronoLocalDateTime<?> chronoLocalDateTime) {
        int compareTo = toLocalDate().compareTo(chronoLocalDateTime.toLocalDate());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = toLocalTime().compareTo(chronoLocalDateTime.toLocalTime());
        return compareTo2 == 0 ? getChronology().compareTo(chronoLocalDateTime.getChronology()) : compareTo2;
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public ChronoLocalDateTime<D> minus(long j, TemporalUnit temporalUnit) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.minus(j, temporalUnit));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTime<D> with(TemporalAdjuster temporalAdjuster) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(temporalAdjuster.adjustInto(this));
    }
}
