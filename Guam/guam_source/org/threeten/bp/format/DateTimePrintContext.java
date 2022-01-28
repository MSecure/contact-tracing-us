package org.threeten.bp.format;

import com.horcrux.svg.PathParser;
import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;

public final class DateTimePrintContext {
    public Locale locale;
    public int optional;
    public DecimalStyle symbols;
    public TemporalAccessor temporal;

    public DateTimePrintContext(final TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        ZoneOffset zoneOffset;
        Chronology chronology = dateTimeFormatter.chrono;
        ZoneId zoneId = dateTimeFormatter.zone;
        if (!(chronology == null && zoneId == null)) {
            Chronology chronology2 = (Chronology) temporalAccessor.query(TemporalQueries.CHRONO);
            final ZoneId zoneId2 = (ZoneId) temporalAccessor.query(TemporalQueries.ZONE_ID);
            final ChronoLocalDate chronoLocalDate = null;
            chronology = PathParser.equals1(chronology2, chronology) ? null : chronology;
            zoneId = PathParser.equals1(zoneId2, zoneId) ? null : zoneId;
            if (!(chronology == null && zoneId == null)) {
                final Chronology chronology3 = chronology != null ? chronology : chronology2;
                zoneId2 = zoneId != null ? zoneId : zoneId2;
                if (zoneId != null) {
                    if (temporalAccessor.isSupported(ChronoField.INSTANT_SECONDS)) {
                        temporalAccessor = (chronology3 == null ? IsoChronology.INSTANCE : chronology3).zonedDateTime(Instant.from(temporalAccessor), zoneId);
                    } else {
                        try {
                            ZoneRules rules = zoneId.getRules();
                            if (rules.isFixedOffset()) {
                                zoneOffset = rules.getOffset(Instant.EPOCH);
                                ZoneOffset zoneOffset2 = (ZoneOffset) temporalAccessor.query(TemporalQueries.OFFSET);
                                if ((zoneOffset instanceof ZoneOffset) && zoneOffset2 != null && !zoneOffset.equals(zoneOffset2)) {
                                    throw new DateTimeException("Invalid override zone for temporal: " + zoneId + " " + temporalAccessor);
                                }
                            }
                        } catch (ZoneRulesException unused) {
                        }
                        zoneOffset = zoneId;
                        ZoneOffset zoneOffset22 = (ZoneOffset) temporalAccessor.query(TemporalQueries.OFFSET);
                        throw new DateTimeException("Invalid override zone for temporal: " + zoneId + " " + temporalAccessor);
                    }
                }
                if (chronology != null) {
                    if (temporalAccessor.isSupported(ChronoField.EPOCH_DAY)) {
                        chronoLocalDate = chronology3.date(temporalAccessor);
                    } else if (!(chronology == IsoChronology.INSTANCE && chronology2 == null)) {
                        ChronoField[] values = ChronoField.values();
                        for (ChronoField chronoField : values) {
                            if (chronoField.isDateBased() && temporalAccessor.isSupported(chronoField)) {
                                throw new DateTimeException("Invalid override chronology for temporal: " + chronology + " " + temporalAccessor);
                            }
                        }
                    }
                }
                temporalAccessor = new DefaultInterfaceTemporalAccessor() {
                    /* class org.threeten.bp.format.DateTimePrintContext.AnonymousClass1 */

                    @Override // org.threeten.bp.temporal.TemporalAccessor
                    public long getLong(TemporalField temporalField) {
                        if (ChronoLocalDate.this == null || !temporalField.isDateBased()) {
                            return temporalAccessor.getLong(temporalField);
                        }
                        return ChronoLocalDate.this.getLong(temporalField);
                    }

                    @Override // org.threeten.bp.temporal.TemporalAccessor
                    public boolean isSupported(TemporalField temporalField) {
                        if (ChronoLocalDate.this == null || !temporalField.isDateBased()) {
                            return temporalAccessor.isSupported(temporalField);
                        }
                        return ChronoLocalDate.this.isSupported(temporalField);
                    }

                    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
                    public <R> R query(TemporalQuery<R> temporalQuery) {
                        return temporalQuery == TemporalQueries.CHRONO ? (R) chronology3 : temporalQuery == TemporalQueries.ZONE_ID ? (R) zoneId2 : temporalQuery == TemporalQueries.PRECISION ? (R) temporalAccessor.query(temporalQuery) : temporalQuery.queryFrom(this);
                    }

                    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
                    public ValueRange range(TemporalField temporalField) {
                        if (ChronoLocalDate.this == null || !temporalField.isDateBased()) {
                            return temporalAccessor.range(temporalField);
                        }
                        return ChronoLocalDate.this.range(temporalField);
                    }
                };
            }
        }
        this.temporal = temporalAccessor;
        this.locale = dateTimeFormatter.locale;
        this.symbols = dateTimeFormatter.decimalStyle;
    }

    public void endOptional() {
        this.optional--;
    }

    public Long getValue(TemporalField temporalField) {
        try {
            return Long.valueOf(this.temporal.getLong(temporalField));
        } catch (DateTimeException e) {
            if (this.optional > 0) {
                return null;
            }
            throw e;
        }
    }

    public String toString() {
        return this.temporal.toString();
    }
}
