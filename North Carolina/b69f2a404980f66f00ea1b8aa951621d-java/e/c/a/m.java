package e.c.a;

import c.b.a.a.c.n.c;
import java.io.DataInput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

public final class m implements Externalizable {

    /* renamed from: b  reason: collision with root package name */
    public byte f4995b;

    /* renamed from: c  reason: collision with root package name */
    public Object f4996c;

    public m() {
    }

    public m(byte b2, Object obj) {
        this.f4995b = b2;
        this.f4996c = obj;
    }

    public static Object a(byte b2, DataInput dataInput) {
        if (b2 == 64) {
            return i.t(dataInput);
        }
        switch (b2) {
            case 1:
                return c.n(dataInput);
            case 2:
                return d.A(dataInput);
            case 3:
                return e.Z(dataInput);
            case 4:
                return f.P(dataInput);
            case 5:
                return g.H(dataInput);
            case 6:
                f P = f.P(dataInput);
                q E = q.E(dataInput);
                p pVar = (p) a(dataInput.readByte(), dataInput);
                c.T1(P, "localDateTime");
                c.T1(E, "offset");
                c.T1(pVar, "zone");
                if (!(pVar instanceof q) || E.equals(pVar)) {
                    return new s(P, E, pVar);
                }
                throw new IllegalArgumentException("ZoneId must match ZoneOffset");
            case 7:
                return r.A(dataInput);
            case 8:
                return q.E(dataInput);
            default:
                switch (b2) {
                    case 66:
                        return k.u(dataInput);
                    case 67:
                        return n.x(dataInput);
                    case 68:
                        return o.y(dataInput);
                    case 69:
                        return j.w(dataInput);
                    default:
                        throw new StreamCorruptedException("Unknown serialized type");
                }
        }
    }

    private Object readResolve() {
        return this.f4996c;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.f4995b = readByte;
        this.f4996c = a(readByte, objectInput);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        byte b2 = this.f4995b;
        Object obj = this.f4996c;
        objectOutput.writeByte(b2);
        if (b2 != 64) {
            switch (b2) {
                case 1:
                    c cVar = (c) obj;
                    objectOutput.writeLong(cVar.f4964b);
                    objectOutput.writeInt(cVar.f4965c);
                    return;
                case 2:
                    d dVar = (d) obj;
                    objectOutput.writeLong(dVar.f4967b);
                    objectOutput.writeInt(dVar.f4968c);
                    return;
                case 3:
                    e eVar = (e) obj;
                    objectOutput.writeInt(eVar.f4970b);
                    objectOutput.writeByte(eVar.f4971c);
                    objectOutput.writeByte(eVar.f4972d);
                    return;
                case 4:
                    ((f) obj).T(objectOutput);
                    return;
                case 5:
                    ((g) obj).N(objectOutput);
                    return;
                case 6:
                    s sVar = (s) obj;
                    sVar.f5008b.T(objectOutput);
                    sVar.f5009c.F(objectOutput);
                    sVar.f5010d.y(objectOutput);
                    return;
                case 7:
                    objectOutput.writeUTF(((r) obj).f5005b);
                    return;
                case 8:
                    ((q) obj).F(objectOutput);
                    return;
                default:
                    switch (b2) {
                        case 66:
                            k kVar = (k) obj;
                            kVar.f4989b.N(objectOutput);
                            kVar.f4990c.F(objectOutput);
                            return;
                        case 67:
                            objectOutput.writeInt(((n) obj).f4997b);
                            return;
                        case 68:
                            o oVar = (o) obj;
                            objectOutput.writeInt(oVar.f4998b);
                            objectOutput.writeByte(oVar.f4999c);
                            return;
                        case 69:
                            j jVar = (j) obj;
                            jVar.f4987b.T(objectOutput);
                            jVar.f4988c.F(objectOutput);
                            return;
                        default:
                            throw new InvalidClassException("Unknown serialized type");
                    }
            }
        } else {
            i iVar = (i) obj;
            objectOutput.writeByte(iVar.f4985b);
            objectOutput.writeByte(iVar.f4986c);
        }
    }
}
