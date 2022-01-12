package org.threeten.bp.chrono;

import com.google.common.util.concurrent.MoreExecutors;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;

public abstract class ChronoLocalDate extends DefaultInterfaceTemporal implements Temporal, TemporalAdjuster, Comparable<ChronoLocalDate> {
    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, toEpochDay());
    }

    public ChronoLocalDateTime<?> atTime(LocalTime localTime) {
        return new ChronoLocalDateTimeImpl(this, localTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChronoLocalDate) {
            return compareTo((ChronoLocalDate) obj) == 0;
        }
        return false;
    }

    public abstract Chronology getChronology();

    public Era getEra() {
        return getChronology().eraOf(get(ChronoField.ERA));
    }

    public int hashCode() {
        long epochDay = toEpochDay();
        return ((int) (epochDay ^ (epochDay >>> 32))) ^ getChronology().hashCode();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.isDateBased();
        }
        return temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public abstract ChronoLocalDate plus(long j, TemporalUnit temporalUnit);

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.CHRONO) {
            return (R) getChronology();
        }
        if (temporalQuery == TemporalQueries.PRECISION) {
            return (R) ChronoUnit.DAYS;
        }
        if (temporalQuery == TemporalQueries.LOCAL_DATE) {
            return (R) LocalDate.ofEpochDay(toEpochDay());
        }
        if (temporalQuery == TemporalQueries.LOCAL_TIME || temporalQuery == TemporalQueries.ZONE || temporalQuery == TemporalQueries.ZONE_ID || temporalQuery == TemporalQueries.OFFSET) {
            return null;
        }
        return (R) super.query(temporalQuery);
    }

    public long toEpochDay() {
        return getLong(ChronoField.EPOCH_DAY);
    }

    public String toString() {
        long j = getLong(ChronoField.YEAR_OF_ERA);
        long j2 = getLong(ChronoField.MONTH_OF_YEAR);
        long j3 = getLong(ChronoField.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(getChronology().toString());
        sb.append(" ");
        sb.append(getEra());
        sb.append(" ");
        sb.append(j);
        String str = "-0";
        sb.append(j2 < 10 ? str : "-");
        sb.append(j2);
        if (j3 >= 10) {
            str = "-";
        }
        sb.append(str);
        sb.append(j3);
        return sb.toString();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public abstract ChronoLocalDate with(TemporalField temporalField, long j);

    public int compareTo(ChronoLocalDate chronoLocalDate) {
        int compareLongs = MoreExecutors.compareLongs(toEpochDay(), chronoLocalDate.toEpochDay());
        return compareLongs == 0 ? getChronology().compareTo(chronoLocalDate.getChronology()) : compareLongs;
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.jdk8.DefaultInterfaceTemporal
    public ChronoLocalDate minus(long j, TemporalUnit temporalUnit) {
        return getChronology().ensureChronoLocalDate(super.minus(j, temporalUnit));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public ChronoLocalDate with(TemporalAdjuster temporalAdjuster) {
        return getChronology().ensureChronoLocalDate(temporalAdjuster.adjustInto(this));
    }
}
