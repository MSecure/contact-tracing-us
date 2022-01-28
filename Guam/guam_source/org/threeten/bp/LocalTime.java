package org.threeten.bp;

import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.horcrux.svg.PathParser;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
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

public final class LocalTime extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<LocalTime>, Serializable {
    public static final LocalTime[] HOURS = new LocalTime[24];
    public static final LocalTime MAX = new LocalTime(23, 59, 59, 999999999);
    public static final LocalTime MIN;
    public final byte hour;
    public final byte minute;
    public final int nano;
    public final byte second;

    static {
        int i = 0;
        while (true) {
            LocalTime[] localTimeArr = HOURS;
            if (i < localTimeArr.length) {
                localTimeArr[i] = new LocalTime(i, 0, 0, 0);
                i++;
            } else {
                LocalTime localTime = localTimeArr[0];
                LocalTime localTime2 = localTimeArr[12];
                MIN = localTimeArr[0];
                return;
            }
        }
    }

    public LocalTime(int i, int i2, int i3, int i4) {
        this.hour = (byte) i;
        this.minute = (byte) i2;
        this.second = (byte) i3;
        this.nano = i4;
    }

    public static LocalTime create(int i, int i2, int i3, int i4) {
        if ((i2 | i3 | i4) == 0) {
            return HOURS[i];
        }
        return new LocalTime(i, i2, i3, i4);
    }

    public static LocalTime from(TemporalAccessor temporalAccessor) {
        LocalTime localTime = (LocalTime) temporalAccessor.query(TemporalQueries.LOCAL_TIME);
        if (localTime != null) {
            return localTime;
        }
        throw new DateTimeException(GeneratedOutlineSupport.outline13(temporalAccessor, GeneratedOutlineSupport.outline18("Unable to obtain LocalTime from TemporalAccessor: ", temporalAccessor, ", type ")));
    }

    public static LocalTime ofNanoOfDay(long j) {
        ChronoField chronoField = ChronoField.NANO_OF_DAY;
        chronoField.range.checkValidValue(j, chronoField);
        int i = (int) (j / 3600000000000L);
        long j2 = j - (((long) i) * 3600000000000L);
        int i2 = (int) (j2 / 60000000000L);
        long j3 = j2 - (((long) i2) * 60000000000L);
        int i3 = (int) (j3 / 1000000000);
        return create(i, i2, i3, (int) (j3 - (((long) i3) * 1000000000)));
    }

    public static LocalTime ofSecondOfDay(long j) {
        ChronoField chronoField = ChronoField.SECOND_OF_DAY;
        chronoField.range.checkValidValue(j, chronoField);
        int i = (int) (j / 3600);
        long j2 = j - ((long) (i * 3600));
        int i2 = (int) (j2 / 60);
        return create(i, i2, (int) (j2 - ((long) (i2 * 60))), 0);
    }

    public static LocalTime readExternal(DataInput dataInput) throws IOException {
        int i;
        int i2;
        int readByte = dataInput.readByte();
        int i3 = 0;
        if (readByte < 0) {
            readByte = ~readByte;
            i = 0;
            i2 = 0;
        } else {
            byte readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                int i4 = ~readByte2;
                i2 = 0;
                i3 = i4;
                i = 0;
            } else {
                byte readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    i = ~readByte3;
                } else {
                    i3 = dataInput.readInt();
                    i = readByte3;
                }
                i2 = i3;
                i3 = readByte2;
            }
        }
        ChronoField chronoField = ChronoField.HOUR_OF_DAY;
        chronoField.range.checkValidValue((long) readByte, chronoField);
        ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
        chronoField2.range.checkValidValue((long) i3, chronoField2);
        ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
        chronoField3.range.checkValidValue((long) i, chronoField3);
        ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
        chronoField4.range.checkValidValue((long) i2, chronoField4);
        return create(readByte, i3, i, i2);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.NANO_OF_DAY, toNanoOfDay());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalTime)) {
            return false;
        }
        LocalTime localTime = (LocalTime) obj;
        return this.hour == localTime.hour && this.minute == localTime.minute && this.second == localTime.second && this.nano == localTime.nano;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public int get(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return get0(temporalField);
        }
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    public final int get0(TemporalField temporalField) {
        switch (((ChronoField) temporalField).ordinal()) {
            case 0:
                return this.nano;
            case 1:
                throw new DateTimeException(GeneratedOutlineSupport.outline10("Field too large for an int: ", temporalField));
            case 2:
                return this.nano / 1000;
            case 3:
                throw new DateTimeException(GeneratedOutlineSupport.outline10("Field too large for an int: ", temporalField));
            case 4:
                return this.nano / 1000000;
            case 5:
                return (int) (toNanoOfDay() / 1000000);
            case 6:
                return this.second;
            case 7:
                return toSecondOfDay();
            case 8:
                return this.minute;
            case 9:
                return (this.hour * 60) + this.minute;
            case 10:
                return this.hour % 12;
            case 11:
                int i = this.hour % 12;
                if (i % 12 == 0) {
                    return 12;
                }
                return i;
            case 12:
                return this.hour;
            case 13:
                byte b = this.hour;
                if (b == 0) {
                    return 24;
                }
                return b;
            case 14:
                return this.hour / 12;
            default:
                throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline10("Unsupported field: ", temporalField));
        }
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        if (temporalField == ChronoField.NANO_OF_DAY) {
            return toNanoOfDay();
        }
        if (temporalField == ChronoField.MICRO_OF_DAY) {
            return toNanoOfDay() / 1000;
        }
        return (long) get0(temporalField);
    }

    public int hashCode() {
        long nanoOfDay = toNanoOfDay();
        return (int) (nanoOfDay ^ (nanoOfDay >>> 32));
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.isTimeBased();
        }
        return temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(RecyclerView.FOREVER_NS, temporalUnit).plus(1L, temporalUnit) : plus(-j, temporalUnit);
    }

    public LocalTime plusHours(long j) {
        if (j == 0) {
            return this;
        }
        return create(((((int) (j % 24)) + this.hour) + 24) % 24, this.minute, this.second, this.nano);
    }

    public LocalTime plusMinutes(long j) {
        if (j == 0) {
            return this;
        }
        int i = (this.hour * 60) + this.minute;
        int i2 = ((((int) (j % 1440)) + i) + 1440) % 1440;
        if (i == i2) {
            return this;
        }
        return create(i2 / 60, i2 % 60, this.second, this.nano);
    }

    public LocalTime plusNanos(long j) {
        if (j == 0) {
            return this;
        }
        long nanoOfDay = toNanoOfDay();
        long j2 = (((j % 86400000000000L) + nanoOfDay) + 86400000000000L) % 86400000000000L;
        if (nanoOfDay == j2) {
            return this;
        }
        return create((int) (j2 / 3600000000000L), (int) ((j2 / 60000000000L) % 60), (int) ((j2 / 1000000000) % 60), (int) (j2 % 1000000000));
    }

    public LocalTime plusSeconds(long j) {
        if (j == 0) {
            return this;
        }
        int i = (this.minute * 60) + (this.hour * 3600) + this.second;
        int i2 = ((((int) (j % 86400)) + i) + 86400) % 86400;
        if (i == i2) {
            return this;
        }
        return create(i2 / 3600, (i2 / 60) % 60, i2 % 60, this.nano);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: org.threeten.bp.LocalTime */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.PRECISION) {
            return (R) ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.LOCAL_TIME) {
            return this;
        }
        if (temporalQuery == TemporalQueries.CHRONO || temporalQuery == TemporalQueries.ZONE_ID || temporalQuery == TemporalQueries.ZONE || temporalQuery == TemporalQueries.OFFSET || temporalQuery == TemporalQueries.LOCAL_DATE) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return super.range(temporalField);
    }

    public long toNanoOfDay() {
        return (((long) this.second) * 1000000000) + (((long) this.minute) * 60000000000L) + (((long) this.hour) * 3600000000000L) + ((long) this.nano);
    }

    public int toSecondOfDay() {
        return (this.minute * 60) + (this.hour * 3600) + this.second;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b = this.hour;
        byte b2 = this.minute;
        byte b3 = this.second;
        int i = this.nano;
        sb.append(b < 10 ? "0" : "");
        sb.append((int) b);
        String str = ":0";
        sb.append(b2 < 10 ? str : ColorPropConverter.PACKAGE_DELIMITER);
        sb.append((int) b2);
        if (b3 > 0 || i > 0) {
            if (b3 >= 10) {
                str = ColorPropConverter.PACKAGE_DELIMITER;
            }
            sb.append(str);
            sb.append((int) b3);
            if (i > 0) {
                sb.append('.');
                if (i % 1000000 == 0) {
                    sb.append(Integer.toString((i / 1000000) + 1000).substring(1));
                } else if (i % 1000 == 0) {
                    sb.append(Integer.toString((i / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i + 1000000000).substring(1));
                }
            }
        }
        return sb.toString();
    }

    public LocalTime withHour(int i) {
        if (this.hour == i) {
            return this;
        }
        ChronoField chronoField = ChronoField.HOUR_OF_DAY;
        chronoField.range.checkValidValue((long) i, chronoField);
        return create(i, this.minute, this.second, this.nano);
    }

    public LocalTime withNano(int i) {
        if (this.nano == i) {
            return this;
        }
        ChronoField chronoField = ChronoField.NANO_OF_SECOND;
        chronoField.range.checkValidValue((long) i, chronoField);
        return create(this.hour, this.minute, this.second, i);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        if (this.nano != 0) {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute);
            dataOutput.writeByte(this.second);
            dataOutput.writeInt(this.nano);
        } else if (this.second != 0) {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute);
            dataOutput.writeByte(~this.second);
        } else if (this.minute == 0) {
            dataOutput.writeByte(~this.hour);
        } else {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(~this.minute);
        }
    }

    public int compareTo(LocalTime localTime) {
        int compareInts = PathParser.compareInts(this.hour, localTime.hour);
        if (compareInts != 0) {
            return compareInts;
        }
        int compareInts2 = PathParser.compareInts(this.minute, localTime.minute);
        if (compareInts2 != 0) {
            return compareInts2;
        }
        int compareInts3 = PathParser.compareInts(this.second, localTime.second);
        return compareInts3 == 0 ? PathParser.compareInts(this.nano, localTime.nano) : compareInts3;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalTime) temporalUnit.addTo(this, j);
        }
        switch (((ChronoUnit) temporalUnit).ordinal()) {
            case 0:
                return plusNanos(j);
            case 1:
                return plusNanos((j % 86400000000L) * 1000);
            case 2:
                return plusNanos((j % 86400000) * 1000000);
            case 3:
                return plusSeconds(j);
            case 4:
                return plusMinutes(j);
            case 5:
                return plusHours(j);
            case 6:
                return plusHours((j % 2) * 12);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Temporal with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalTime) {
            return (LocalTime) temporalAdjuster;
        }
        return (LocalTime) ((LocalDate) temporalAdjuster).adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalTime) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.range.checkValidValue(j, chronoField);
        switch (chronoField.ordinal()) {
            case 0:
                return withNano((int) j);
            case 1:
                return ofNanoOfDay(j);
            case 2:
                return withNano(((int) j) * 1000);
            case 3:
                return ofNanoOfDay(j * 1000);
            case 4:
                return withNano(((int) j) * 1000000);
            case 5:
                return ofNanoOfDay(j * 1000000);
            case 6:
                int i = (int) j;
                if (this.second == i) {
                    return this;
                }
                ChronoField chronoField2 = ChronoField.SECOND_OF_MINUTE;
                chronoField2.range.checkValidValue((long) i, chronoField2);
                return create(this.hour, this.minute, i, this.nano);
            case 7:
                return plusSeconds(j - ((long) toSecondOfDay()));
            case 8:
                int i2 = (int) j;
                if (this.minute == i2) {
                    return this;
                }
                ChronoField chronoField3 = ChronoField.MINUTE_OF_HOUR;
                chronoField3.range.checkValidValue((long) i2, chronoField3);
                return create(this.hour, i2, this.second, this.nano);
            case 9:
                return plusMinutes(j - ((long) ((this.hour * 60) + this.minute)));
            case 10:
                return plusHours(j - ((long) (this.hour % 12)));
            case 11:
                if (j == 12) {
                    j = 0;
                }
                return plusHours(j - ((long) (this.hour % 12)));
            case 12:
                return withHour((int) j);
            case 13:
                if (j == 24) {
                    j = 0;
                }
                return withHour((int) j);
            case 14:
                return plusHours((j - ((long) (this.hour / 12))) * 12);
            default:
                throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline10("Unsupported field: ", temporalField));
        }
    }

    public static LocalTime ofSecondOfDay(long j, int i) {
        ChronoField chronoField = ChronoField.SECOND_OF_DAY;
        chronoField.range.checkValidValue(j, chronoField);
        ChronoField chronoField2 = ChronoField.NANO_OF_SECOND;
        chronoField2.range.checkValidValue((long) i, chronoField2);
        int i2 = (int) (j / 3600);
        long j2 = j - ((long) (i2 * 3600));
        int i3 = (int) (j2 / 60);
        return create(i2, i3, (int) (j2 - ((long) (i3 * 60))), i);
    }
}
