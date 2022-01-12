package org.threeten.bp.chrono;

import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.Serializable;
import okhttp3.internal.http2.Http2Connection;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;

public final class ChronoLocalDateTimeImpl<D extends ChronoLocalDate> extends ChronoLocalDateTime<D> implements Temporal, TemporalAdjuster, Serializable {
    public final D date;
    public final LocalTime time;

    public ChronoLocalDateTimeImpl(D d, LocalTime localTime) {
        MoreExecutors.requireNonNull(d, DatePickerDialogModule.ARG_DATE);
        MoreExecutors.requireNonNull(localTime, "time");
        this.date = d;
        this.time = localTime;
    }

    private Object writeReplace() {
        return new Ser((byte) 12, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public ChronoZonedDateTime<D> atZone(ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofBest(this, zoneId, null);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public int get(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.isTimeBased() ? this.time.get(temporalField) : this.date.get(temporalField);
        }
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.isTimeBased() ? this.time.getLong(temporalField) : this.date.getLong(temporalField);
        }
        return temporalField.getFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isDateBased() || temporalField.isTimeBased() : temporalField != null && temporalField.isSupportedBy(this);
    }

    public final ChronoLocalDateTimeImpl<D> plusDays(long j) {
        return with(this.date.plus(j, ChronoUnit.DAYS), this.time);
    }

    public final ChronoLocalDateTimeImpl<D> plusNanos(long j) {
        return plusWithOverflow(this.date, 0, 0, 0, j);
    }

    public final ChronoLocalDateTimeImpl<D> plusWithOverflow(D d, long j, long j2, long j3, long j4) {
        if ((j | j2 | j3 | j4) == 0) {
            return with(d, this.time);
        }
        long j5 = j / 24;
        long j6 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * Http2Connection.DEGRADED_PONG_TIMEOUT_NS) + (j4 % 86400000000000L);
        long nanoOfDay = this.time.toNanoOfDay();
        long j7 = j6 + nanoOfDay;
        long floorDiv = MoreExecutors.floorDiv(j7, 86400000000000L) + j5 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
        long floorMod = MoreExecutors.floorMod(j7, 86400000000000L);
        return with(d.plus(floorDiv, ChronoUnit.DAYS), floorMod == nanoOfDay ? this.time : LocalTime.ofNanoOfDay(floorMod));
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.isTimeBased() ? this.time.range(temporalField) : this.date.range(temporalField);
        }
        return temporalField.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public D toLocalDate() {
        return this.date;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime
    public ChronoLocalDateTimeImpl<D> plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return this.date.getChronology().ensureChronoLocalDateTime(temporalUnit.addTo(this, j));
        }
        switch (((ChronoUnit) temporalUnit).ordinal()) {
            case 0:
                return plusNanos(j);
            case 1:
                return plusDays(j / 86400000000L).plusNanos((j % 86400000000L) * 1000);
            case 2:
                return plusDays(j / 86400000).plusNanos((j % 86400000) * 1000000);
            case 3:
                return plusWithOverflow(this.date, 0, 0, j, 0);
            case 4:
                return plusWithOverflow(this.date, 0, j, 0, 0);
            case 5:
                return plusWithOverflow(this.date, j, 0, 0, 0);
            case 6:
                ChronoLocalDateTimeImpl<D> plusDays = plusDays(j / 256);
                return plusDays.plusWithOverflow(plusDays.date, (j % 256) * 12, 0, 0, 0);
            default:
                return with(this.date.plus(j, temporalUnit), this.time);
        }
    }

    public final ChronoLocalDateTimeImpl<D> with(Temporal temporal, LocalTime localTime) {
        if (this.date == temporal && this.time == localTime) {
            return this;
        }
        return new ChronoLocalDateTimeImpl<>(this.date.getChronology().ensureChronoLocalDate(temporal), localTime);
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime
    public ChronoLocalDateTimeImpl<D> with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof ChronoLocalDate) {
            return with((ChronoLocalDate) temporalAdjuster, this.time);
        }
        if (temporalAdjuster instanceof LocalTime) {
            return with(this.date, (LocalTime) temporalAdjuster);
        }
        if (temporalAdjuster instanceof ChronoLocalDateTimeImpl) {
            return this.date.getChronology().ensureChronoLocalDateTime((ChronoLocalDateTimeImpl) temporalAdjuster);
        }
        return this.date.getChronology().ensureChronoLocalDateTime((ChronoLocalDateTimeImpl) temporalAdjuster.adjustInto(this));
    }

    @Override // org.threeten.bp.temporal.Temporal, org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime
    public ChronoLocalDateTimeImpl<D> with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return this.date.getChronology().ensureChronoLocalDateTime(temporalField.adjustInto(this, j));
        }
        if (temporalField.isTimeBased()) {
            return with(this.date, this.time.with(temporalField, j));
        }
        return with(this.date.with(temporalField, j), this.time);
    }
}
