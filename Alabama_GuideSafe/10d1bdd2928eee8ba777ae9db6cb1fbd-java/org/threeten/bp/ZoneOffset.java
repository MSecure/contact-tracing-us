package org.threeten.bp;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneRules;

public final class ZoneOffset extends ZoneId implements TemporalAccessor, TemporalAdjuster, Comparable<ZoneOffset>, Serializable {
    public static final ConcurrentMap<String, ZoneOffset> ID_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset MAX = ofTotalSeconds(64800);
    public static final ZoneOffset MIN = ofTotalSeconds(-64800);
    public static final ConcurrentMap<Integer, ZoneOffset> SECONDS_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = ofTotalSeconds(0);
    public final transient String id;
    public final int totalSeconds;

    public ZoneOffset(int i) {
        String str;
        this.totalSeconds = i;
        if (i == 0) {
            str = "Z";
        } else {
            int abs = Math.abs(i);
            StringBuilder sb = new StringBuilder();
            int i2 = abs / 3600;
            int i3 = (abs / 60) % 60;
            sb.append(i < 0 ? "-" : "+");
            sb.append(i2 < 10 ? "0" : "");
            sb.append(i2);
            String str2 = ":0";
            sb.append(i3 < 10 ? str2 : ColorPropConverter.PACKAGE_DELIMITER);
            sb.append(i3);
            int i4 = abs % 60;
            if (i4 != 0) {
                sb.append(i4 >= 10 ? ColorPropConverter.PACKAGE_DELIMITER : str2);
                sb.append(i4);
            }
            str = sb.toString();
        }
        this.id = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8  */
    public static ZoneOffset of(String str) {
        int i;
        int i2;
        int i3;
        char charAt;
        MoreExecutors.requireNonNull(str, "offsetId");
        ZoneOffset zoneOffset = ID_CACHE.get(str);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        int length = str.length();
        if (length == 2) {
            str = str.charAt(0) + "0" + str.charAt(1);
        } else if (length != 3) {
            if (length == 5) {
                i3 = parseNumber(str, 1, false);
                i2 = parseNumber(str, 3, false);
            } else if (length != 6) {
                if (length == 7) {
                    i3 = parseNumber(str, 1, false);
                    i2 = parseNumber(str, 3, false);
                    i = parseNumber(str, 5, false);
                } else if (length == 9) {
                    i3 = parseNumber(str, 1, false);
                    i2 = parseNumber(str, 4, true);
                    i = parseNumber(str, 7, true);
                } else {
                    throw new DateTimeException(GeneratedOutlineSupport.outline10("Invalid ID for ZoneOffset, invalid format: ", str));
                }
                charAt = str.charAt(0);
                if (charAt == '+' && charAt != '-') {
                    throw new DateTimeException(GeneratedOutlineSupport.outline10("Invalid ID for ZoneOffset, plus/minus not found when expected: ", str));
                } else if (charAt == '-') {
                    return ofHoursMinutesSeconds(-i3, -i2, -i);
                } else {
                    return ofHoursMinutesSeconds(i3, i2, i);
                }
            } else {
                i3 = parseNumber(str, 1, false);
                i2 = parseNumber(str, 4, true);
            }
            i = 0;
            charAt = str.charAt(0);
            if (charAt == '+') {
            }
            if (charAt == '-') {
            }
        }
        i3 = parseNumber(str, 1, false);
        i2 = 0;
        i = 0;
        charAt = str.charAt(0);
        if (charAt == '+') {
        }
        if (charAt == '-') {
        }
    }

    public static ZoneOffset ofHoursMinutesSeconds(int i, int i2, int i3) {
        if (i < -18 || i > 18) {
            throw new DateTimeException(GeneratedOutlineSupport.outline6("Zone offset hours not in valid range: value ", i, " is not in the range -18 to 18"));
        }
        if (i > 0) {
            if (i2 < 0 || i3 < 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i < 0) {
            if (i2 > 0 || i3 > 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i2 > 0 && i3 < 0) || (i2 < 0 && i3 > 0)) {
            throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (Math.abs(i2) > 59) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Zone offset minutes not in valid range: abs(value) ");
            outline17.append(Math.abs(i2));
            outline17.append(" is not in the range 0 to 59");
            throw new DateTimeException(outline17.toString());
        } else if (Math.abs(i3) > 59) {
            StringBuilder outline172 = GeneratedOutlineSupport.outline17("Zone offset seconds not in valid range: abs(value) ");
            outline172.append(Math.abs(i3));
            outline172.append(" is not in the range 0 to 59");
            throw new DateTimeException(outline172.toString());
        } else if (Math.abs(i) != 18 || (Math.abs(i2) <= 0 && Math.abs(i3) <= 0)) {
            return ofTotalSeconds((i2 * 60) + (i * 3600) + i3);
        } else {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
    }

    public static ZoneOffset ofTotalSeconds(int i) {
        if (Math.abs(i) > 64800) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i % 900 != 0) {
            return new ZoneOffset(i);
        } else {
            Integer valueOf = Integer.valueOf(i);
            ZoneOffset zoneOffset = SECONDS_CACHE.get(valueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            SECONDS_CACHE.putIfAbsent(valueOf, new ZoneOffset(i));
            ZoneOffset zoneOffset2 = SECONDS_CACHE.get(valueOf);
            ID_CACHE.putIfAbsent(zoneOffset2.id, zoneOffset2);
            return zoneOffset2;
        }
    }

    public static int parseNumber(CharSequence charSequence, int i, boolean z) {
        if (!z || charSequence.charAt(i - 1) == ':') {
            char charAt = charSequence.charAt(i);
            char charAt2 = charSequence.charAt(i + 1);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9') {
                throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) charSequence));
            }
            return (charAt2 - '0') + ((charAt - '0') * 10);
        }
        throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) charSequence));
    }

    public static ZoneOffset readExternal(DataInput dataInput) throws IOException {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ofTotalSeconds(dataInput.readInt()) : ofTotalSeconds(readByte * 900);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.OFFSET_SECONDS, (long) this.totalSeconds);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.totalSeconds - this.totalSeconds;
    }

    @Override // org.threeten.bp.ZoneId
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneOffset) {
            return this.totalSeconds == ((ZoneOffset) obj).totalSeconds;
        }
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (!(temporalField instanceof ChronoField)) {
            return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
        }
        throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline12("Unsupported field: ", temporalField));
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.id;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return (long) this.totalSeconds;
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        throw new DateTimeException(GeneratedOutlineSupport.outline12("Unsupported field: ", temporalField));
    }

    @Override // org.threeten.bp.ZoneId
    public ZoneRules getRules() {
        MoreExecutors.requireNonNull(this, "offset");
        return new ZoneRules.Fixed(this);
    }

    @Override // org.threeten.bp.ZoneId
    public int hashCode() {
        return this.totalSeconds;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.OFFSET_SECONDS : temporalField != null && temporalField.isSupportedBy(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: org.threeten.bp.ZoneOffset */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.OFFSET || temporalQuery == TemporalQueries.ZONE) {
            return this;
        }
        if (temporalQuery == TemporalQueries.LOCAL_DATE || temporalQuery == TemporalQueries.LOCAL_TIME || temporalQuery == TemporalQueries.PRECISION || temporalQuery == TemporalQueries.CHRONO || temporalQuery == TemporalQueries.ZONE_ID) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return temporalField.range();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        throw new UnsupportedTemporalTypeException(GeneratedOutlineSupport.outline12("Unsupported field: ", temporalField));
    }

    @Override // org.threeten.bp.ZoneId
    public String toString() {
        return this.id;
    }

    @Override // org.threeten.bp.ZoneId
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(8);
        writeExternal(dataOutput);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        int i = this.totalSeconds;
        int i2 = i % 900 == 0 ? i / 900 : 127;
        dataOutput.writeByte(i2);
        if (i2 == 127) {
            dataOutput.writeInt(i);
        }
    }
}
