package org.threeten.bp;

import com.horcrux.svg.PathParser;
import java.io.DataInput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

public final class Ser implements Externalizable {
    public Object object;
    public byte type;

    public Ser() {
    }

    public static Object readInternal(byte b, DataInput dataInput) throws IOException {
        if (b == 64) {
            return MonthDay.readExternal(dataInput);
        }
        switch (b) {
            case 1:
                return Duration.readExternal(dataInput);
            case 2:
                return Instant.readExternal(dataInput);
            case 3:
                return LocalDate.readExternal(dataInput);
            case 4:
                return LocalDateTime.readExternal(dataInput);
            case 5:
                return LocalTime.readExternal(dataInput);
            case 6:
                LocalDateTime readExternal = LocalDateTime.readExternal(dataInput);
                ZoneOffset readExternal2 = ZoneOffset.readExternal(dataInput);
                ZoneId zoneId = (ZoneId) readInternal(dataInput.readByte(), dataInput);
                PathParser.requireNonNull(readExternal, "localDateTime");
                PathParser.requireNonNull(readExternal2, "offset");
                PathParser.requireNonNull(zoneId, "zone");
                if (!(zoneId instanceof ZoneOffset) || readExternal2.equals(zoneId)) {
                    return new ZonedDateTime(readExternal, readExternal2, zoneId);
                }
                throw new IllegalArgumentException("ZoneId must match ZoneOffset");
            case 7:
                return ZoneRegion.readExternal(dataInput);
            case 8:
                return ZoneOffset.readExternal(dataInput);
            default:
                switch (b) {
                    case 66:
                        return OffsetTime.readExternal(dataInput);
                    case 67:
                        return Year.readExternal(dataInput);
                    case 68:
                        return YearMonth.readExternal(dataInput);
                    case 69:
                        return OffsetDateTime.readExternal(dataInput);
                    default:
                        throw new StreamCorruptedException("Unknown serialized type");
                }
        }
    }

    private Object readResolve() {
        return this.object;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        byte readByte = objectInput.readByte();
        this.type = readByte;
        this.object = readInternal(readByte, objectInput);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b = this.type;
        Object obj = this.object;
        objectOutput.writeByte(b);
        if (b != 64) {
            switch (b) {
                case 1:
                    Duration duration = (Duration) obj;
                    objectOutput.writeLong(duration.seconds);
                    objectOutput.writeInt(duration.nanos);
                    return;
                case 2:
                    Instant instant = (Instant) obj;
                    objectOutput.writeLong(instant.seconds);
                    objectOutput.writeInt(instant.nanos);
                    return;
                case 3:
                    LocalDate localDate = (LocalDate) obj;
                    objectOutput.writeInt(localDate.year);
                    objectOutput.writeByte(localDate.month);
                    objectOutput.writeByte(localDate.day);
                    return;
                case 4:
                    ((LocalDateTime) obj).writeExternal(objectOutput);
                    return;
                case 5:
                    ((LocalTime) obj).writeExternal(objectOutput);
                    return;
                case 6:
                    ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
                    zonedDateTime.dateTime.writeExternal(objectOutput);
                    zonedDateTime.offset.writeExternal(objectOutput);
                    zonedDateTime.zone.write(objectOutput);
                    return;
                case 7:
                    objectOutput.writeUTF(((ZoneRegion) obj).id);
                    return;
                case 8:
                    ((ZoneOffset) obj).writeExternal(objectOutput);
                    return;
                default:
                    switch (b) {
                        case 66:
                            OffsetTime offsetTime = (OffsetTime) obj;
                            offsetTime.time.writeExternal(objectOutput);
                            offsetTime.offset.writeExternal(objectOutput);
                            return;
                        case 67:
                            objectOutput.writeInt(((Year) obj).year);
                            return;
                        case 68:
                            YearMonth yearMonth = (YearMonth) obj;
                            objectOutput.writeInt(yearMonth.year);
                            objectOutput.writeByte(yearMonth.month);
                            return;
                        case 69:
                            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
                            offsetDateTime.dateTime.writeExternal(objectOutput);
                            offsetDateTime.offset.writeExternal(objectOutput);
                            return;
                        default:
                            throw new InvalidClassException("Unknown serialized type");
                    }
            }
        } else {
            MonthDay monthDay = (MonthDay) obj;
            objectOutput.writeByte(monthDay.month);
            objectOutput.writeByte(monthDay.day);
        }
    }

    public Ser(byte b, Object obj) {
        this.type = b;
        this.object = obj;
    }
}
