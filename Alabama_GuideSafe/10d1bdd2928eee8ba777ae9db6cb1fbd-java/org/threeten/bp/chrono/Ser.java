package org.threeten.bp.chrono;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.temporal.ChronoField;

public final class Ser implements Externalizable {
    public Object object;
    public byte type;

    public Ser() {
    }

    private Object readResolve() {
        return this.object;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        Object obj;
        Object obj2;
        byte readByte = objectInput.readByte();
        this.type = readByte;
        switch (readByte) {
            case 1:
                obj = JapaneseDate.readExternal(objectInput);
                break;
            case 2:
                obj = JapaneseEra.readExternal(objectInput);
                break;
            case 3:
                obj = HijrahDate.readExternal(objectInput);
                break;
            case 4:
                obj = HijrahEra.of(objectInput.readByte());
                break;
            case 5:
                int readInt = objectInput.readInt();
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                MinguoChronology minguoChronology = MinguoChronology.INSTANCE;
                obj2 = new MinguoDate(LocalDate.of(readInt + 1911, readByte2, readByte3));
                obj = obj2;
                break;
            case 6:
                obj = MinguoEra.of(objectInput.readByte());
                break;
            case 7:
                int readInt2 = objectInput.readInt();
                byte readByte4 = objectInput.readByte();
                byte readByte5 = objectInput.readByte();
                ThaiBuddhistChronology thaiBuddhistChronology = ThaiBuddhistChronology.INSTANCE;
                obj2 = new ThaiBuddhistDate(LocalDate.of(readInt2 - 543, readByte4, readByte5));
                obj = obj2;
                break;
            case 8:
                obj = ThaiBuddhistEra.of(objectInput.readByte());
                break;
            case 9:
            case 10:
            default:
                throw new StreamCorruptedException("Unknown serialized type");
            case 11:
                obj = Chronology.readExternal(objectInput);
                break;
            case 12:
                obj = ((ChronoLocalDate) objectInput.readObject()).atTime((LocalTime) objectInput.readObject());
                break;
            case 13:
                obj = ((ChronoLocalDateTime) objectInput.readObject()).atZone((ZoneOffset) objectInput.readObject()).withZoneSameLocal((ZoneId) objectInput.readObject());
                break;
        }
        this.object = obj;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b = this.type;
        Object obj = this.object;
        objectOutput.writeByte(b);
        switch (b) {
            case 1:
                JapaneseDate japaneseDate = (JapaneseDate) obj;
                if (japaneseDate != null) {
                    objectOutput.writeInt(japaneseDate.get(ChronoField.YEAR));
                    objectOutput.writeByte(japaneseDate.get(ChronoField.MONTH_OF_YEAR));
                    objectOutput.writeByte(japaneseDate.get(ChronoField.DAY_OF_MONTH));
                    return;
                }
                throw null;
            case 2:
                objectOutput.writeByte(((JapaneseEra) obj).eraValue);
                return;
            case 3:
                HijrahDate hijrahDate = (HijrahDate) obj;
                if (hijrahDate != null) {
                    objectOutput.writeInt(hijrahDate.get(ChronoField.YEAR));
                    objectOutput.writeByte(hijrahDate.get(ChronoField.MONTH_OF_YEAR));
                    objectOutput.writeByte(hijrahDate.get(ChronoField.DAY_OF_MONTH));
                    return;
                }
                throw null;
            case 4:
                objectOutput.writeByte(((HijrahEra) obj).ordinal());
                return;
            case 5:
                MinguoDate minguoDate = (MinguoDate) obj;
                if (minguoDate != null) {
                    objectOutput.writeInt(minguoDate.get(ChronoField.YEAR));
                    objectOutput.writeByte(minguoDate.get(ChronoField.MONTH_OF_YEAR));
                    objectOutput.writeByte(minguoDate.get(ChronoField.DAY_OF_MONTH));
                    return;
                }
                throw null;
            case 6:
                objectOutput.writeByte(((MinguoEra) obj).ordinal());
                return;
            case 7:
                ThaiBuddhistDate thaiBuddhistDate = (ThaiBuddhistDate) obj;
                if (thaiBuddhistDate != null) {
                    objectOutput.writeInt(thaiBuddhistDate.get(ChronoField.YEAR));
                    objectOutput.writeByte(thaiBuddhistDate.get(ChronoField.MONTH_OF_YEAR));
                    objectOutput.writeByte(thaiBuddhistDate.get(ChronoField.DAY_OF_MONTH));
                    return;
                }
                throw null;
            case 8:
                objectOutput.writeByte(((ThaiBuddhistEra) obj).ordinal());
                return;
            case 9:
            case 10:
            default:
                throw new InvalidClassException("Unknown serialized type");
            case 11:
                objectOutput.writeUTF(((Chronology) obj).getId());
                return;
            case 12:
                ChronoLocalDateTimeImpl chronoLocalDateTimeImpl = (ChronoLocalDateTimeImpl) obj;
                objectOutput.writeObject(chronoLocalDateTimeImpl.date);
                objectOutput.writeObject(chronoLocalDateTimeImpl.time);
                return;
            case 13:
                ChronoZonedDateTimeImpl chronoZonedDateTimeImpl = (ChronoZonedDateTimeImpl) obj;
                objectOutput.writeObject(chronoZonedDateTimeImpl.dateTime);
                objectOutput.writeObject(chronoZonedDateTimeImpl.offset);
                objectOutput.writeObject(chronoZonedDateTimeImpl.zone);
                return;
        }
    }

    public Ser(byte b, Object obj) {
        this.type = b;
        this.object = obj;
    }
}
