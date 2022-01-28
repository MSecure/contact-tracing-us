package l.b.a.y;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import l.b.a.r;

public final class a implements Externalizable {
    public byte b;
    public Object c;

    public a() {
    }

    public a(byte b2, Object obj) {
        this.b = b2;
        this.c = obj;
    }

    public static long a(DataInput dataInput) {
        int readByte = dataInput.readByte() & 255;
        if (readByte == 255) {
            return dataInput.readLong();
        }
        return (((long) (((readByte << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255))) * 900) - 4575744000L;
    }

    public static Object b(byte b2, DataInput dataInput) {
        if (b2 == 1) {
            int readInt = dataInput.readInt();
            long[] jArr = new long[readInt];
            for (int i2 = 0; i2 < readInt; i2++) {
                jArr[i2] = a(dataInput);
            }
            int i3 = readInt + 1;
            r[] rVarArr = new r[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                rVarArr[i4] = c(dataInput);
            }
            int readInt2 = dataInput.readInt();
            long[] jArr2 = new long[readInt2];
            for (int i5 = 0; i5 < readInt2; i5++) {
                jArr2[i5] = a(dataInput);
            }
            int i6 = readInt2 + 1;
            r[] rVarArr2 = new r[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                rVarArr2[i7] = c(dataInput);
            }
            int readByte = dataInput.readByte();
            e[] eVarArr = new e[readByte];
            for (int i8 = 0; i8 < readByte; i8++) {
                eVarArr[i8] = e.a(dataInput);
            }
            return new b(jArr, rVarArr, jArr2, rVarArr2, eVarArr);
        } else if (b2 == 2) {
            long a = a(dataInput);
            r c2 = c(dataInput);
            r c3 = c(dataInput);
            if (!c2.equals(c3)) {
                return new d(a, c2, c3);
            }
            throw new IllegalArgumentException("Offsets must not be equal");
        } else if (b2 == 3) {
            return e.a(dataInput);
        } else {
            throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    public static r c(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? r.z(dataInput.readInt()) : r.z(readByte * 900);
    }

    public static void d(long j2, DataOutput dataOutput) {
        if (j2 < -4575744000L || j2 >= 10413792000L || j2 % 900 != 0) {
            dataOutput.writeByte(255);
            dataOutput.writeLong(j2);
            return;
        }
        int i2 = (int) ((j2 + 4575744000L) / 900);
        dataOutput.writeByte((i2 >>> 16) & 255);
        dataOutput.writeByte((i2 >>> 8) & 255);
        dataOutput.writeByte(i2 & 255);
    }

    public static void e(r rVar, DataOutput dataOutput) {
        int i2 = rVar.c;
        int i3 = i2 % 900 == 0 ? i2 / 900 : 127;
        dataOutput.writeByte(i3);
        if (i3 == 127) {
            dataOutput.writeInt(i2);
        }
    }

    private Object readResolve() {
        return this.c;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.b = readByte;
        this.c = b(readByte, objectInput);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        byte b2 = this.b;
        Object obj = this.c;
        objectOutput.writeByte(b2);
        if (b2 == 1) {
            b bVar = (b) obj;
            objectOutput.writeInt(bVar.b.length);
            for (long j2 : bVar.b) {
                d(j2, objectOutput);
            }
            for (r rVar : bVar.c) {
                e(rVar, objectOutput);
            }
            objectOutput.writeInt(bVar.f4541d.length);
            for (long j3 : bVar.f4541d) {
                d(j3, objectOutput);
            }
            for (r rVar2 : bVar.f4543f) {
                e(rVar2, objectOutput);
            }
            objectOutput.writeByte(bVar.f4544g.length);
            for (e eVar : bVar.f4544g) {
                eVar.b(objectOutput);
            }
        } else if (b2 == 2) {
            d dVar = (d) obj;
            d(dVar.b.v(dVar.c), objectOutput);
            e(dVar.c, objectOutput);
            e(dVar.f4548d, objectOutput);
        } else if (b2 == 3) {
            ((e) obj).b(objectOutput);
        } else {
            throw new InvalidClassException("Unknown serialized type");
        }
    }
}
