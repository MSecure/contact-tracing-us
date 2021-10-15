package g.b.a;

import b.x.t;
import java.io.DataInput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

public final class m implements Externalizable {

    /* renamed from: b  reason: collision with root package name */
    public byte f6438b;

    /* renamed from: c  reason: collision with root package name */
    public Object f6439c;

    public m() {
    }

    public m(byte b2, Object obj) {
        this.f6438b = b2;
        this.f6439c = obj;
    }

    public static Object a(byte b2, DataInput dataInput) {
        if (b2 == 64) {
            return i.B(dataInput);
        }
        switch (b2) {
            case 1:
                return c.p(dataInput);
            case 2:
                return d.Q(dataInput);
            case 3:
                return e.p0(dataInput);
            case 4:
                return f.f0(dataInput);
            case 5:
                return g.X(dataInput);
            case 6:
                f f0 = f.f0(dataInput);
                q T = q.T(dataInput);
                p pVar = (p) a(dataInput.readByte(), dataInput);
                t.y2(f0, "localDateTime");
                t.y2(T, "offset");
                t.y2(pVar, "zone");
                if (!(pVar instanceof q) || T.equals(pVar)) {
                    return new s(f0, T, pVar);
                }
                throw new IllegalArgumentException("ZoneId must match ZoneOffset");
            case 7:
                return r.P(dataInput);
            case 8:
                return q.T(dataInput);
            default:
                switch (b2) {
                    case 66:
                        return k.D(dataInput);
                    case 67:
                        return n.H(dataInput);
                    case 68:
                        return o.L(dataInput);
                    case 69:
                        return j.G(dataInput);
                    default:
                        throw new StreamCorruptedException("Unknown serialized type");
                }
        }
    }

    private Object readResolve() {
        return this.f6439c;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.f6438b = readByte;
        this.f6439c = a(readByte, objectInput);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        byte b2 = this.f6438b;
        Object obj = this.f6439c;
        objectOutput.writeByte(b2);
        if (b2 != 64) {
            switch (b2) {
                case 1:
                    c cVar = (c) obj;
                    objectOutput.writeLong(cVar.f6401b);
                    objectOutput.writeInt(cVar.f6402c);
                    return;
                case 2:
                    d dVar = (d) obj;
                    objectOutput.writeLong(dVar.f6404b);
                    objectOutput.writeInt(dVar.f6405c);
                    return;
                case 3:
                    e eVar = (e) obj;
                    objectOutput.writeInt(eVar.f6409b);
                    objectOutput.writeByte(eVar.f6410c);
                    objectOutput.writeByte(eVar.f6411d);
                    return;
                case 4:
                    ((f) obj).j0(objectOutput);
                    return;
                case 5:
                    ((g) obj).d0(objectOutput);
                    return;
                case 6:
                    s sVar = (s) obj;
                    sVar.f6453b.j0(objectOutput);
                    sVar.f6454c.U(objectOutput);
                    sVar.f6455d.H(objectOutput);
                    return;
                case 7:
                    objectOutput.writeUTF(((r) obj).f6450c);
                    return;
                case 8:
                    ((q) obj).U(objectOutput);
                    return;
                default:
                    switch (b2) {
                        case 66:
                            k kVar = (k) obj;
                            kVar.f6432b.d0(objectOutput);
                            kVar.f6433c.U(objectOutput);
                            return;
                        case 67:
                            objectOutput.writeInt(((n) obj).f6440b);
                            return;
                        case 68:
                            o oVar = (o) obj;
                            objectOutput.writeInt(oVar.f6441b);
                            objectOutput.writeByte(oVar.f6442c);
                            return;
                        case 69:
                            j jVar = (j) obj;
                            jVar.f6430b.j0(objectOutput);
                            jVar.f6431c.U(objectOutput);
                            return;
                        default:
                            throw new InvalidClassException("Unknown serialized type");
                    }
            }
        } else {
            i iVar = (i) obj;
            objectOutput.writeByte(iVar.f6428b);
            objectOutput.writeByte(iVar.f6429c);
        }
    }
}
