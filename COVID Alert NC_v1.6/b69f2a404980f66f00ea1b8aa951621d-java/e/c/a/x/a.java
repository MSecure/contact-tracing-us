package e.c.a.x;

import e.c.a.q;
import gov.nc.dhhs.exposurenotification.BuildConfig;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

public final class a implements Externalizable {

    /* renamed from: b  reason: collision with root package name */
    public byte f5194b;

    /* renamed from: c  reason: collision with root package name */
    public Object f5195c;

    public a() {
    }

    public a(byte b2, Object obj) {
        this.f5194b = b2;
        this.f5195c = obj;
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
            for (int i = 0; i < readInt; i++) {
                jArr[i] = a(dataInput);
            }
            int i2 = readInt + 1;
            q[] qVarArr = new q[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                qVarArr[i3] = c(dataInput);
            }
            int readInt2 = dataInput.readInt();
            long[] jArr2 = new long[readInt2];
            for (int i4 = 0; i4 < readInt2; i4++) {
                jArr2[i4] = a(dataInput);
            }
            int i5 = readInt2 + 1;
            q[] qVarArr2 = new q[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                qVarArr2[i6] = c(dataInput);
            }
            int readByte = dataInput.readByte();
            e[] eVarArr = new e[readByte];
            for (int i7 = 0; i7 < readByte; i7++) {
                eVarArr[i7] = e.a(dataInput);
            }
            return new b(jArr, qVarArr, jArr2, qVarArr2, eVarArr);
        } else if (b2 == 2) {
            long a2 = a(dataInput);
            q c2 = c(dataInput);
            q c3 = c(dataInput);
            if (!c2.equals(c3)) {
                return new d(a2, c2, c3);
            }
            throw new IllegalArgumentException("Offsets must not be equal");
        } else if (b2 == 3) {
            return e.a(dataInput);
        } else {
            throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    public static q c(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? q.C(dataInput.readInt()) : q.C(readByte * 900);
    }

    public static void d(long j, DataOutput dataOutput) {
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

    public static void e(q qVar, DataOutput dataOutput) {
        int i = qVar.f5002b;
        int i2 = i % BuildConfig.ATTENUATION_THRESHOLD == 0 ? i / BuildConfig.ATTENUATION_THRESHOLD : 127;
        dataOutput.writeByte(i2);
        if (i2 == 127) {
            dataOutput.writeInt(i);
        }
    }

    private Object readResolve() {
        return this.f5195c;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.f5194b = readByte;
        this.f5195c = b(readByte, objectInput);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        byte b2 = this.f5194b;
        Object obj = this.f5195c;
        objectOutput.writeByte(b2);
        if (b2 == 1) {
            b bVar = (b) obj;
            objectOutput.writeInt(bVar.f5196b.length);
            for (long j : bVar.f5196b) {
                d(j, objectOutput);
            }
            for (q qVar : bVar.f5197c) {
                e(qVar, objectOutput);
            }
            objectOutput.writeInt(bVar.f5198d.length);
            for (long j2 : bVar.f5198d) {
                d(j2, objectOutput);
            }
            for (q qVar2 : bVar.f) {
                e(qVar2, objectOutput);
            }
            objectOutput.writeByte(bVar.g.length);
            for (e eVar : bVar.g) {
                eVar.b(objectOutput);
            }
        } else if (b2 == 2) {
            d dVar = (d) obj;
            d(dVar.f5206b.x(dVar.f5207c), objectOutput);
            e(dVar.f5207c, objectOutput);
            e(dVar.f5208d, objectOutput);
        } else if (b2 == 3) {
            ((e) obj).b(objectOutput);
        } else {
            throw new InvalidClassException("Unknown serialized type");
        }
    }
}
