package l.b.a;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import java.io.DataInput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.regex.Pattern;

public final class m implements Externalizable {
    public byte b;
    public Object c;

    public m() {
    }

    public m(byte b2, Object obj) {
        this.b = b2;
        this.c = obj;
    }

    public static Object a(byte b2, DataInput dataInput) {
        r rVar;
        r rVar2;
        if (b2 != 64) {
            switch (b2) {
                case 1:
                    c cVar = c.f4039d;
                    return c.m(dataInput.readLong(), (long) dataInput.readInt());
                case 2:
                    d dVar = d.f4040d;
                    return d.y(dataInput.readLong(), (long) dataInput.readInt());
                case 3:
                    e eVar = e.f4041e;
                    return e.P(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
                case 4:
                    return f.M(dataInput);
                case 5:
                    return g.D(dataInput);
                case 6:
                    f M = f.M(dataInput);
                    q B = q.B(dataInput);
                    p pVar = (p) a(dataInput.readByte(), dataInput);
                    b.B1(M, "localDateTime");
                    b.B1(B, "offset");
                    b.B1(pVar, "zone");
                    if (!(pVar instanceof q) || B.equals(pVar)) {
                        return new s(M, B, pVar);
                    }
                    throw new IllegalArgumentException("ZoneId must match ZoneOffset");
                case 7:
                    Pattern pattern = r.f4074e;
                    String readUTF = dataInput.readUTF();
                    if (readUTF.equals("Z") || readUTF.startsWith("+") || readUTF.startsWith("-")) {
                        throw new a(a.t("Invalid ID for region-based ZoneId, invalid format: ", readUTF));
                    } else if (readUTF.equals("UTC") || readUTF.equals("GMT") || readUTF.equals("UT")) {
                        return new r(readUTF, q.f4070g.s());
                    } else {
                        if (readUTF.startsWith("UTC+") || readUTF.startsWith("GMT+") || readUTF.startsWith("UTC-") || readUTF.startsWith("GMT-")) {
                            q x = q.x(readUTF.substring(3));
                            if (x.c == 0) {
                                rVar = new r(readUTF.substring(0, 3), x.s());
                            } else {
                                rVar = new r(readUTF.substring(0, 3) + x.f4073d, x.s());
                            }
                            return rVar;
                        } else if (!readUTF.startsWith("UT+") && !readUTF.startsWith("UT-")) {
                            return r.w(readUTF, false);
                        } else {
                            q x2 = q.x(readUTF.substring(2));
                            if (x2.c == 0) {
                                rVar2 = new r("UT", x2.s());
                            } else {
                                StringBuilder h2 = a.h("UT");
                                h2.append(x2.f4073d);
                                rVar2 = new r(h2.toString(), x2.s());
                            }
                            return rVar2;
                        }
                    }
                case 8:
                    return q.B(dataInput);
                default:
                    switch (b2) {
                        case 66:
                            int i2 = k.f4064d;
                            return new k(g.D(dataInput), q.B(dataInput));
                        case 67:
                            int i3 = n.c;
                            return n.s(dataInput.readInt());
                        case 68:
                            int i4 = o.f4067d;
                            return o.s(dataInput.readInt(), dataInput.readByte());
                        case 69:
                            int i5 = j.f4063d;
                            return new j(f.M(dataInput), q.B(dataInput));
                        default:
                            throw new StreamCorruptedException("Unknown serialized type");
                    }
            }
        } else {
            int i6 = i.f4062d;
            return i.q(dataInput.readByte(), dataInput.readByte());
        }
    }

    private Object readResolve() {
        return this.c;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.b = readByte;
        this.c = a(readByte, objectInput);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        byte b2 = this.b;
        Object obj = this.c;
        objectOutput.writeByte(b2);
        if (b2 != 64) {
            switch (b2) {
                case 1:
                    c cVar = (c) obj;
                    objectOutput.writeLong(cVar.b);
                    objectOutput.writeInt(cVar.c);
                    return;
                case 2:
                    d dVar = (d) obj;
                    objectOutput.writeLong(dVar.b);
                    objectOutput.writeInt(dVar.c);
                    return;
                case 3:
                    e eVar = (e) obj;
                    objectOutput.writeInt(eVar.b);
                    objectOutput.writeByte(eVar.c);
                    objectOutput.writeByte(eVar.f4044d);
                    return;
                case 4:
                    ((f) obj).Q(objectOutput);
                    return;
                case 5:
                    ((g) obj).J(objectOutput);
                    return;
                case 6:
                    s sVar = (s) obj;
                    sVar.b.Q(objectOutput);
                    sVar.c.C(objectOutput);
                    sVar.f4076d.v(objectOutput);
                    return;
                case 7:
                    objectOutput.writeUTF(((r) obj).c);
                    return;
                case 8:
                    ((q) obj).C(objectOutput);
                    return;
                default:
                    switch (b2) {
                        case 66:
                            k kVar = (k) obj;
                            kVar.b.J(objectOutput);
                            kVar.c.C(objectOutput);
                            return;
                        case 67:
                            objectOutput.writeInt(((n) obj).b);
                            return;
                        case 68:
                            o oVar = (o) obj;
                            objectOutput.writeInt(oVar.b);
                            objectOutput.writeByte(oVar.c);
                            return;
                        case 69:
                            j jVar = (j) obj;
                            jVar.b.Q(objectOutput);
                            jVar.c.C(objectOutput);
                            return;
                        default:
                            throw new InvalidClassException("Unknown serialized type");
                    }
            }
        } else {
            i iVar = (i) obj;
            objectOutput.writeByte(iVar.b);
            objectOutput.writeByte(iVar.c);
        }
    }
}
