package org.threeten.bp.chrono;

import com.horcrux.svg.PathParser;
import java.io.Serializable;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalTime;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalUnit;

public abstract class ChronoDateImpl<D extends ChronoLocalDate> extends ChronoLocalDate implements Temporal, TemporalAdjuster, Serializable {
    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public ChronoLocalDateTime<?> atTime(LocalTime localTime) {
        return new ChronoLocalDateTimeImpl(this, localTime);
    }

    public abstract ChronoDateImpl<D> plusDays(long j);

    public abstract ChronoDateImpl<D> plusMonths(long j);

    public abstract ChronoDateImpl<D> plusYears(long j);

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.chrono.ChronoLocalDate
    public ChronoDateImpl<D> plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (ChronoDateImpl) getChronology().ensureChronoLocalDate(temporalUnit.addTo(this, j));
        }
        switch (((ChronoUnit) temporalUnit).ordinal()) {
            case 7:
                return plusDays(j);
            case 8:
                return plusDays(PathParser.safeMultiply(j, 7));
            case 9:
                return plusMonths(j);
            case 10:
                return plusYears(j);
            case 11:
                return plusYears(PathParser.safeMultiply(j, 10));
            case 12:
                return plusYears(PathParser.safeMultiply(j, 100));
            case 13:
                return plusYears(PathParser.safeMultiply(j, 1000));
            default:
                throw new DateTimeException(temporalUnit + " not valid for chronology " + getChronology().getId());
        }
    }
}
