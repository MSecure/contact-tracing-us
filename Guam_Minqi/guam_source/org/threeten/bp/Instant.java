package org.threeten.bp;

import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.horcrux.svg.PathParser;
import java.io.DataInput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimePrintContext;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class Instant extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<Instant>, Serializable {
    public static final Instant EPOCH = new Instant(0, 0);
    public final int nanos;
    public final long seconds;

    static {
        ofEpochSecond(-31557014167219200L, 0);
        ofEpochSecond(31556889864403199L, 999999999);
    }

    public Instant(long j, int i) {
        this.seconds = j;
        this.nanos = i;
    }

    public static Instant create(long j, int i) {
        if ((((long) i) | j) == 0) {
            return EPOCH;
        }
        if (j >= -31557014167219200L && j <= 31556889864403199L) {
            return new Instant(j, i);
        }
        throw new DateTimeException("Instant exceeds minimum or maximum instant");
    }

    public static Instant from(TemporalAccessor temporalAccessor) {
        try {
            return ofEpochSecond(temporalAccessor.getLong(ChronoField.INSTANT_SECONDS), (long) temporalAccessor.get(ChronoField.NANO_OF_SECOND));
        } catch (DateTimeException e) {
            throw new DateTimeException(GeneratedOutlineSupport.outline13(temporalAccessor, GeneratedOutlineSupport.outline18("Unable to obtain Instant from TemporalAccessor: ", temporalAccessor, ", type ")), e);
        }
    }

    public static Instant now() {
        ZoneOffset zoneOffset = ZoneOffset.UTC;
        return ofEpochMilli(System.currentTimeMillis());
    }

    public static Instant ofEpochMilli(long j) {
        return create(PathParser.floorDiv(j, 1000), PathParser.floorMod(j, 1000) * 1000000);
    }

    public static Instant ofEpochSecond(long j, long j2) {
        return create(PathParser.safeAdd(j, PathParser.floorDiv(j2, 1000000000)), PathParser.floorMod(j2, 1000000000));
    }

    public static Instant readExternal(DataInput dataInput) throws IOException {
        return ofEpochSecond(dataInput.readLong(), (long) dataInput.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.INSTANT_SECONDS, this.seconds).with(ChronoField.NANO_OF_SECOND, (long) this.nanos);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(Instant instant) {
        Instant instant2 = instant;
        int compareLongs = PathParser.compareLongs(this.seconds, instant2.seconds);
        return compareLongs != 0 ? compareLongs : this.nanos - instant2.nanos;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.seconds == instant.seconds && this.nanos == instant.nanos;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.range(temporalField).checkValidIntValue(temporalField.getFrom(this), temporalField);
        }
        int ordinal = ((ChronoField) temporalField).ordinal();
        if (ordinal == 0) {
            return this.nanos;
        }
        if (ordinal == 2) {
            return this.nanos / 1000;
        }
        if (ordinal == 4) {
            return this.nanos / 1000000;
        }
        throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline10("Unsupported field: ", temporalField));
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        int i;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int ordinal = ((ChronoField) temporalField).ordinal();
        if (ordinal == 0) {
            i = this.nanos;
        } else if (ordinal == 2) {
            i = this.nanos / 1000;
        } else if (ordinal == 4) {
            i = this.nanos / 1000000;
        } else if (ordinal == 28) {
            return this.seconds;
        } else {
            throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline10("Unsupported field: ", temporalField));
        }
        return (long) i;
    }

    public int hashCode() {
        long j = this.seconds;
        return (this.nanos * 51) + ((int) (j ^ (j >>> 32)));
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.NANO_OF_SECOND || temporalField == ChronoField.MICRO_OF_SECOND || temporalField == ChronoField.MILLI_OF_SECOND : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(RecyclerView.FOREVER_NS, temporalUnit).plus(1L, temporalUnit) : plus(-j, temporalUnit);
    }

    public Instant plusSeconds(long j) {
        return plus(j, 0);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.PRECISION) {
            return (R) ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.LOCAL_DATE || temporalQuery == TemporalQueries.LOCAL_TIME || temporalQuery == TemporalQueries.CHRONO || temporalQuery == TemporalQueries.ZONE_ID || temporalQuery == TemporalQueries.ZONE || temporalQuery == TemporalQueries.OFFSET) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return super.range(temporalField);
    }

    public long toEpochMilli() {
        long j = this.seconds;
        if (j >= 0) {
            return PathParser.safeAdd(PathParser.safeMultiply(j, 1000L), (long) (this.nanos / 1000000));
        }
        return PathParser.safeSubtract(PathParser.safeMultiply(j + 1, 1000L), 1000 - ((long) (this.nanos / 1000000)));
    }

    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_INSTANT;
        if (dateTimeFormatter != null) {
            StringBuilder sb = new StringBuilder(32);
            PathParser.requireNonNull(this, "temporal");
            PathParser.requireNonNull(sb, "appendable");
            try {
                dateTimeFormatter.printerParser.print(new DateTimePrintContext(this, dateTimeFormatter), sb);
                return sb.toString();
            } catch (IOException e) {
                throw new DateTimeException(e.getMessage(), e);
            }
        } else {
            throw null;
        }
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal with(TemporalAdjuster temporalAdjuster) {
        return (Instant) ((LocalDate) temporalAdjuster).adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Instant) temporalUnit.addTo(this, j);
        }
        switch (((ChronoUnit) temporalUnit).ordinal()) {
            case 0:
                return plus(0, j);
            case 1:
                return plus(j / 1000000, (j % 1000000) * 1000);
            case 2:
                return plus(j / 1000, (j % 1000) * 1000000);
            case 3:
                return plus(j, 0);
            case 4:
                return plusSeconds(PathParser.safeMultiply(j, 60));
            case 5:
                return plusSeconds(PathParser.safeMultiply(j, 3600));
            case 6:
                return plusSeconds(PathParser.safeMultiply(j, 43200));
            case 7:
                return plusSeconds(PathParser.safeMultiply(j, 86400));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (Instant) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.range.checkValidValue(j, chronoField);
        int ordinal = chronoField.ordinal();
        if (ordinal != 0) {
            if (ordinal == 2) {
                int i = ((int) j) * 1000;
                if (i != this.nanos) {
                    return create(this.seconds, i);
                }
            } else if (ordinal == 4) {
                int i2 = ((int) j) * 1000000;
                if (i2 != this.nanos) {
                    return create(this.seconds, i2);
                }
            } else if (ordinal != 28) {
                throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline10("Unsupported field: ", temporalField));
            } else if (j != this.seconds) {
                return create(j, this.nanos);
            }
        } else if (j != ((long) this.nanos)) {
            return create(this.seconds, (int) j);
        }
        return this;
    }

    public final Instant plus(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return ofEpochSecond(PathParser.safeAdd(PathParser.safeAdd(this.seconds, j), j2 / 1000000000), ((long) this.nanos) + (j2 % 1000000000));
    }
}
