package org.threeten.bp.chrono;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.horcrux.svg.PathParser;
import java.io.Serializable;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.temporal.TemporalAccessor;

public final class IsoChronology extends Chronology implements Serializable {
    public static final IsoChronology INSTANCE = new IsoChronology();

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDate date(TemporalAccessor temporalAccessor) {
        return LocalDate.from(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public Era eraOf(int i) {
        if (i == 0) {
            return IsoEra.BCE;
        }
        if (i == 1) {
            return IsoEra.CE;
        }
        throw new DateTimeException(GeneratedOutlineSupport.outline4("Invalid era: ", i));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "iso8601";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "ISO";
    }

    public boolean isLeapYear(long j) {
        return (3 & j) == 0 && (j % 100 != 0 || j % 400 == 0);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDateTime localDateTime(TemporalAccessor temporalAccessor) {
        return LocalDateTime.from(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime zonedDateTime(Instant instant, ZoneId zoneId) {
        PathParser.requireNonNull(instant, "instant");
        PathParser.requireNonNull(zoneId, "zone");
        return ZonedDateTime.create(instant.seconds, instant.nanos, zoneId);
    }
}
