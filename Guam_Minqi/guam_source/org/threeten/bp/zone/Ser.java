package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import org.threeten.bp.ZoneOffset;

public final class Ser implements Externalizable {
    public Object object;
    public byte type;

    public Ser() {
    }

    public static long readEpochSec(DataInput dataInput) throws IOException {
        int readByte = dataInput.readByte() & 255;
        if (readByte == 255) {
            return dataInput.readLong();
        }
        return (((long) (((readByte << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255))) * 900) - 4575744000L;
    }

    public static Object readInternal(byte b, DataInput dataInput) throws IOException, ClassNotFoundException {
        if (b == 1) {
            int readInt = dataInput.readInt();
            long[] jArr = new long[readInt];
            for (int i = 0; i < readInt; i++) {
                jArr[i] = readEpochSec(dataInput);
            }
            int i2 = readInt + 1;
            ZoneOffset[] zoneOffsetArr = new ZoneOffset[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                zoneOffsetArr[i3] = readOffset(dataInput);
            }
            int readInt2 = dataInput.readInt();
            long[] jArr2 = new long[readInt2];
            for (int i4 = 0; i4 < readInt2; i4++) {
                jArr2[i4] = readEpochSec(dataInput);
            }
            int i5 = readInt2 + 1;
            ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                zoneOffsetArr2[i6] = readOffset(dataInput);
            }
            int readByte = dataInput.readByte();
            ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = new ZoneOffsetTransitionRule[readByte];
            for (int i7 = 0; i7 < readByte; i7++) {
                zoneOffsetTransitionRuleArr[i7] = ZoneOffsetTransitionRule.readExternal(dataInput);
            }
            return new StandardZoneRules(jArr, zoneOffsetArr, jArr2, zoneOffsetArr2, zoneOffsetTransitionRuleArr);
        } else if (b == 2) {
            long readEpochSec = readEpochSec(dataInput);
            ZoneOffset readOffset = readOffset(dataInput);
            ZoneOffset readOffset2 = readOffset(dataInput);
            if (!readOffset.equals(readOffset2)) {
                return new ZoneOffsetTransition(readEpochSec, readOffset, readOffset2);
            }
            throw new IllegalArgumentException("Offsets must not be equal");
        } else if (b == 3) {
            return ZoneOffsetTransitionRule.readExternal(dataInput);
        } else {
            throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    public static ZoneOffset readOffset(DataInput dataInput) throws IOException {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ZoneOffset.ofTotalSeconds(dataInput.readInt()) : ZoneOffset.ofTotalSeconds(readByte * 900);
    }

    private Object readResolve() {
        return this.object;
    }

    public static void writeEpochSec(long j, DataOutput dataOutput) throws IOException {
        if (j < -4575744000L || j >= 10413792000L || j % 900 != 0) {
            dataOutput.writeByte(255);
            dataOutput.writeLong(j);
            return;
        }
        int i = (int) ((j + 4575744000L) / 900);
        dataOutput.writeByte((i >>> 16) & 255);
        dataOutput.writeByte((i >>> 8) & 255);
        dataOutput.writeByte(i & 255);
    }

    public static void writeOffset(ZoneOffset zoneOffset, DataOutput dataOutput) throws IOException {
        int i = zoneOffset.totalSeconds;
        int i2 = i % 900 == 0 ? i / 900 : 127;
        dataOutput.writeByte(i2);
        if (i2 == 127) {
            dataOutput.writeInt(i);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        byte readByte = objectInput.readByte();
        this.type = readByte;
        this.object = readInternal(readByte, objectInput);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b = this.type;
        Object obj = this.object;
        objectOutput.writeByte(b);
        if (b == 1) {
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            objectOutput.writeInt(standardZoneRules.standardTransitions.length);
            for (long j : standardZoneRules.standardTransitions) {
                writeEpochSec(j, objectOutput);
            }
            for (ZoneOffset zoneOffset : standardZoneRules.standardOffsets) {
                writeOffset(zoneOffset, objectOutput);
            }
            objectOutput.writeInt(standardZoneRules.savingsInstantTransitions.length);
            for (long j2 : standardZoneRules.savingsInstantTransitions) {
                writeEpochSec(j2, objectOutput);
            }
            for (ZoneOffset zoneOffset2 : standardZoneRules.wallOffsets) {
                writeOffset(zoneOffset2, objectOutput);
            }
            objectOutput.writeByte(standardZoneRules.lastRules.length);
            for (ZoneOffsetTransitionRule zoneOffsetTransitionRule : standardZoneRules.lastRules) {
                zoneOffsetTransitionRule.writeExternal(objectOutput);
            }
        } else if (b == 2) {
            ZoneOffsetTransition zoneOffsetTransition = (ZoneOffsetTransition) obj;
            writeEpochSec(zoneOffsetTransition.transition.toEpochSecond(zoneOffsetTransition.offsetBefore), objectOutput);
            writeOffset(zoneOffsetTransition.offsetBefore, objectOutput);
            writeOffset(zoneOffsetTransition.offsetAfter, objectOutput);
        } else if (b == 3) {
            ((ZoneOffsetTransitionRule) obj).writeExternal(objectOutput);
        } else {
            throw new InvalidClassException("Unknown serialized type");
        }
    }

    public Ser(byte b, Object obj) {
        this.type = b;
        this.object = obj;
    }
}
