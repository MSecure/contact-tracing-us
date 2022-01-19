package org.threeten.bp.chrono;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.horcrux.svg.PathParser;
import java.io.DataInput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.util.Iterator;
import java.util.Locale;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalQueries;

public abstract class Chronology implements Comparable<Chronology> {
    public static final ConcurrentHashMap<String, Chronology> CHRONOS_BY_ID = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, Chronology> CHRONOS_BY_TYPE = new ConcurrentHashMap<>();

    static {
        try {
            Locale.class.getMethod("getUnicodeLocaleType", String.class);
        } catch (Throwable unused) {
        }
    }

    public static Chronology from(TemporalAccessor temporalAccessor) {
        PathParser.requireNonNull(temporalAccessor, "temporal");
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.CHRONO);
        return chronology != null ? chronology : IsoChronology.INSTANCE;
    }

    public static Chronology readExternal(DataInput dataInput) throws IOException {
        String readUTF = dataInput.readUTF();
        if (CHRONOS_BY_ID.isEmpty()) {
            register(IsoChronology.INSTANCE);
            register(ThaiBuddhistChronology.INSTANCE);
            register(MinguoChronology.INSTANCE);
            register(JapaneseChronology.INSTANCE);
            register(HijrahChronology.INSTANCE);
            CHRONOS_BY_ID.putIfAbsent("Hijrah", HijrahChronology.INSTANCE);
            CHRONOS_BY_TYPE.putIfAbsent("islamic", HijrahChronology.INSTANCE);
            Iterator it = ServiceLoader.load(Chronology.class, Chronology.class.getClassLoader()).iterator();
            while (it.hasNext()) {
                Chronology chronology = (Chronology) it.next();
                CHRONOS_BY_ID.putIfAbsent(chronology.getId(), chronology);
                String calendarType = chronology.getCalendarType();
                if (calendarType != null) {
                    CHRONOS_BY_TYPE.putIfAbsent(calendarType, chronology);
                }
            }
        }
        Chronology chronology2 = CHRONOS_BY_ID.get(readUTF);
        if (chronology2 != null || (chronology2 = CHRONOS_BY_TYPE.get(readUTF)) != null) {
            return chronology2;
        }
        throw new DateTimeException(GeneratedOutlineSupport.outline8("Unknown chronology: ", readUTF));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static void register(Chronology chronology) {
        CHRONOS_BY_ID.putIfAbsent(chronology.getId(), chronology);
        String calendarType = chronology.getCalendarType();
        if (calendarType != null) {
            CHRONOS_BY_TYPE.putIfAbsent(calendarType, chronology);
        }
    }

    private Object writeReplace() {
        return new Ser((byte) 11, this);
    }

    public abstract ChronoLocalDate date(TemporalAccessor temporalAccessor);

    public <D extends ChronoLocalDate> D ensureChronoLocalDate(Temporal temporal) {
        D d = (D) ((ChronoLocalDate) temporal);
        if (equals(d.getChronology())) {
            return d;
        }
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Chrono mismatch, expected: ");
        outline15.append(getId());
        outline15.append(", actual: ");
        outline15.append(d.getChronology().getId());
        throw new ClassCastException(outline15.toString());
    }

    public <D extends ChronoLocalDate> ChronoLocalDateTimeImpl<D> ensureChronoLocalDateTime(Temporal temporal) {
        ChronoLocalDateTimeImpl<D> chronoLocalDateTimeImpl = (ChronoLocalDateTimeImpl) temporal;
        if (equals(chronoLocalDateTimeImpl.date.getChronology())) {
            return chronoLocalDateTimeImpl;
        }
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Chrono mismatch, required: ");
        outline15.append(getId());
        outline15.append(", supplied: ");
        outline15.append(chronoLocalDateTimeImpl.date.getChronology().getId());
        throw new ClassCastException(outline15.toString());
    }

    public <D extends ChronoLocalDate> ChronoZonedDateTimeImpl<D> ensureChronoZonedDateTime(Temporal temporal) {
        ChronoZonedDateTimeImpl<D> chronoZonedDateTimeImpl = (ChronoZonedDateTimeImpl) temporal;
        if (equals(chronoZonedDateTimeImpl.toLocalDate().getChronology())) {
            return chronoZonedDateTimeImpl;
        }
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Chrono mismatch, required: ");
        outline15.append(getId());
        outline15.append(", supplied: ");
        outline15.append(chronoZonedDateTimeImpl.toLocalDate().getChronology().getId());
        throw new ClassCastException(outline15.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Chronology) {
            return compareTo((Chronology) obj) == 0;
        }
        return false;
    }

    public abstract Era eraOf(int i);

    public abstract String getCalendarType();

    public abstract String getId();

    public int hashCode() {
        return getClass().hashCode() ^ getId().hashCode();
    }

    public ChronoLocalDateTime<?> localDateTime(TemporalAccessor temporalAccessor) {
        try {
            return date(temporalAccessor).atTime(LocalTime.from(temporalAccessor));
        } catch (DateTimeException e) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Unable to obtain ChronoLocalDateTime from TemporalAccessor: ");
            outline15.append(temporalAccessor.getClass());
            throw new DateTimeException(outline15.toString(), e);
        }
    }

    public String toString() {
        return getId();
    }

    public ChronoZonedDateTime<?> zonedDateTime(Instant instant, ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofInstant(this, instant, zoneId);
    }

    public int compareTo(Chronology chronology) {
        return getId().compareTo(chronology.getId());
    }
}
