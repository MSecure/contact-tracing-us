package l.b.a;

import f.a.a.a.a;
import g.b.a.c.c.d;
import java.io.DataInput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class n implements Externalizable {
    public byte b;
    public Object c;

    public n() {
    }

    public n(byte b, Object obj) {
        this.b = b;
        this.c = obj;
    }

    public static Object a(byte b, DataInput dataInput) {
        s sVar;
        s sVar2;
        if (b != 64) {
            switch (b) {
                case 1:
                    d dVar = d.f4610d;
                    return d.o(dataInput.readLong(), (long) dataInput.readInt());
                case 2:
                    e eVar = e.f4611d;
                    return e.B(dataInput.readLong(), (long) dataInput.readInt());
                case 3:
                    f fVar = f.f4612e;
                    return f.P(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
                case 4:
                    return g.M(dataInput);
                case 5:
                    return h.D(dataInput);
                case 6:
                    g M = g.M(dataInput);
                    r B = r.B(dataInput);
                    q qVar = (q) a(dataInput.readByte(), dataInput);
                    d.u(M, "localDateTime");
                    d.u(B, "offset");
                    d.u(qVar, "zone");
                    if (!(qVar instanceof r) || B.equals(qVar)) {
                        return new t(M, B, qVar);
                    }
                    throw new IllegalArgumentException("ZoneId must match ZoneOffset");
                case 7:
                    Pattern pattern = s.f4645e;
                    String readUTF = dataInput.readUTF();
                    if (readUTF.equals("Z") || readUTF.startsWith("+") || readUTF.startsWith("-")) {
                        throw new b(a.x("Invalid ID for region-based ZoneId, invalid format: ", readUTF));
                    } else if (readUTF.equals("UTC") || readUTF.equals("GMT") || readUTF.equals("UT")) {
                        return new s(readUTF, r.f4641g.s());
                    } else {
                        if (readUTF.startsWith("UTC+") || readUTF.startsWith("GMT+") || readUTF.startsWith("UTC-") || readUTF.startsWith("GMT-")) {
                            r x = r.x(readUTF.substring(3));
                            if (x.c == 0) {
                                sVar = new s(readUTF.substring(0, 3), x.s());
                            } else {
                                sVar = new s(readUTF.substring(0, 3) + x.f4644d, x.s());
                            }
                            return sVar;
                        } else if (!readUTF.startsWith("UT+") && !readUTF.startsWith("UT-")) {
                            return s.w(readUTF, false);
                        } else {
                            r x2 = r.x(readUTF.substring(2));
                            if (x2.c == 0) {
                                sVar2 = new s("UT", x2.s());
                            } else {
                                StringBuilder h2 = a.h("UT");
                                h2.append(x2.f4644d);
                                sVar2 = new s(h2.toString(), x2.s());
                            }
                            return sVar2;
                        }
                    }
                case 8:
                    return r.B(dataInput);
                default:
                    switch (b) {
                        case 66:
                            int i2 = l.f4635d;
                            return new l(h.D(dataInput), r.B(dataInput));
                        case 67:
                            int i3 = o.c;
                            return o.s(dataInput.readInt());
                        case 68:
                            int i4 = p.f4638d;
                            return p.s(dataInput.readInt(), dataInput.readByte());
                        case 69:
                            int i5 = k.f4634d;
                            return new k(g.M(dataInput), r.B(dataInput));
                        default:
                            throw new StreamCorruptedException("Unknown serialized type");
                    }
            }
        } else {
            int i6 = j.f4633d;
            return j.q(dataInput.readByte(), dataInput.readByte());
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
        byte b = this.b;
        Object obj = this.c;
        objectOutput.writeByte(b);
        if (b != 64) {
            switch (b) {
                case 1:
                    d dVar = (d) obj;
                    objectOutput.writeLong(dVar.b);
                    objectOutput.writeInt(dVar.c);
                    return;
                case 2:
                    e eVar = (e) obj;
                    objectOutput.writeLong(eVar.b);
                    objectOutput.writeInt(eVar.c);
                    return;
                case 3:
                    f fVar = (f) obj;
                    objectOutput.writeInt(fVar.b);
                    objectOutput.writeByte(fVar.c);
                    objectOutput.writeByte(fVar.f4615d);
                    return;
                case 4:
                    ((g) obj).Q(objectOutput);
                    return;
                case 5:
                    ((h) obj).J(objectOutput);
                    return;
                case 6:
                    t tVar = (t) obj;
                    tVar.b.Q(objectOutput);
                    tVar.c.C(objectOutput);
                    tVar.f4647d.v(objectOutput);
                    return;
                case 7:
                    objectOutput.writeUTF(((s) obj).c);
                    return;
                case 8:
                    ((r) obj).C(objectOutput);
                    return;
                default:
                    switch (b) {
                        case 66:
                            l lVar = (l) obj;
                            lVar.b.J(objectOutput);
                            lVar.c.C(objectOutput);
                            return;
                        case 67:
                            objectOutput.writeInt(((o) obj).b);
                            return;
                        case 68:
                            p pVar = (p) obj;
                            objectOutput.writeInt(pVar.b);
                            objectOutput.writeByte(pVar.c);
                            return;
                        case 69:
                            k kVar = (k) obj;
                            kVar.b.Q(objectOutput);
                            kVar.c.C(objectOutput);
                            return;
                        default:
                            throw new InvalidClassException("Unknown serialized type");
                    }
            }
        } else {
            j jVar = (j) obj;
            objectOutput.writeByte(jVar.b);
            objectOutput.writeByte(jVar.c);
        }
    }
}
