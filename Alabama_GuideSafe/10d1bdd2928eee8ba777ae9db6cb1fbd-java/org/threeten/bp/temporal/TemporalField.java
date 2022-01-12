package org.threeten.bp.temporal;

public interface TemporalField {
    <R extends Temporal> R adjustInto(R r, long j);

    long getFrom(TemporalAccessor temporalAccessor);

    boolean isDateBased();

    boolean isSupportedBy(TemporalAccessor temporalAccessor);

    boolean isTimeBased();

    ValueRange range();

    ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor);
}
