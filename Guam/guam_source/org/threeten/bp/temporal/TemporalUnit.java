package org.threeten.bp.temporal;

public interface TemporalUnit {
    <R extends Temporal> R addTo(R r, long j);

    boolean isDateBased();
}
