package g.b.a.t;

import g.b.a.e;
import g.b.a.g;
import g.b.a.p;
import g.b.a.q;
import g.b.a.w.a;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

public final class u implements Externalizable {

    /* renamed from: b  reason: collision with root package name */
    public byte f6499b;

    /* renamed from: c  reason: collision with root package name */
    public Object f6500c;

    public u() {
    }

    public u(byte b2, Object obj) {
        this.f6499b = b2;
        this.f6500c = obj;
    }

    private Object readResolve() {
        return this.f6500c;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        Object obj;
        Object obj2;
        byte readByte = objectInput.readByte();
        this.f6499b = readByte;
        switch (readByte) {
            case 1:
                obj = p.Y(objectInput);
                break;
            case 2:
                obj = q.F(objectInput);
                break;
            case 3:
                obj = k.k0(objectInput);
                break;
            case 4:
                obj = l.p(objectInput.readByte());
                break;
            case 5:
                int readInt = objectInput.readInt();
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                r rVar = r.f6494d;
                obj2 = new s(e.f0(readInt + 1911, readByte2, readByte3));
                obj = obj2;
                break;
            case 6:
                obj = t.p(objectInput.readByte());
                break;
            case 7:
                int readInt2 = objectInput.readInt();
                byte readByte4 = objectInput.readByte();
                byte readByte5 = objectInput.readByte();
                v vVar = v.f6501d;
                obj2 = new w(e.f0(readInt2 - 543, readByte4, readByte5));
                obj = obj2;
                break;
            case 8:
                obj = x.p(objectInput.readByte());
                break;
            case 9:
            case 10:
            default:
                throw new StreamCorruptedException("Unknown serialized type");
            case 11:
                obj = h.x(objectInput);
                break;
            case 12:
                obj = ((b) objectInput.readObject()).A((g) objectInput.readObject());
                break;
            case 13:
                obj = ((c) objectInput.readObject()).A((q) objectInput.readObject()).U((p) objectInput.readObject());
                break;
        }
        this.f6500c = obj;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        byte b2 = this.f6499b;
        Object obj = this.f6500c;
        objectOutput.writeByte(b2);
        switch (b2) {
            case 1:
                p pVar = (p) obj;
                if (pVar != null) {
                    objectOutput.writeInt(pVar.d(a.YEAR));
                    objectOutput.writeByte(pVar.d(a.MONTH_OF_YEAR));
                    objectOutput.writeByte(pVar.d(a.DAY_OF_MONTH));
                    return;
                }
                throw null;
            case 2:
                objectOutput.writeByte(((q) obj).f6491b);
                return;
            case 3:
                k kVar = (k) obj;
                if (kVar != null) {
                    objectOutput.writeInt(kVar.d(a.YEAR));
                    objectOutput.writeByte(kVar.d(a.MONTH_OF_YEAR));
                    objectOutput.writeByte(kVar.d(a.DAY_OF_MONTH));
                    return;
                }
                throw null;
            case 4:
                objectOutput.writeByte(((l) obj).ordinal());
                return;
            case 5:
                s sVar = (s) obj;
                if (sVar != null) {
                    objectOutput.writeInt(sVar.d(a.YEAR));
                    objectOutput.writeByte(sVar.d(a.MONTH_OF_YEAR));
                    objectOutput.writeByte(sVar.d(a.DAY_OF_MONTH));
                    return;
                }
                throw null;
            case 6:
                objectOutput.writeByte(((t) obj).ordinal());
                return;
            case 7:
                w wVar = (w) obj;
                if (wVar != null) {
                    objectOutput.writeInt(wVar.d(a.YEAR));
                    objectOutput.writeByte(wVar.d(a.MONTH_OF_YEAR));
                    objectOutput.writeByte(wVar.d(a.DAY_OF_MONTH));
                    return;
                }
                throw null;
            case 8:
                objectOutput.writeByte(((x) obj).ordinal());
                return;
            case 9:
            case 10:
            default:
                throw new InvalidClassException("Unknown serialized type");
            case 11:
                objectOutput.writeUTF(((h) obj).s());
                return;
            case 12:
                d dVar = (d) obj;
                objectOutput.writeObject(dVar.f6456b);
                objectOutput.writeObject(dVar.f6457c);
                return;
            case 13:
                g gVar = (g) obj;
                objectOutput.writeObject(gVar.f6458b);
                objectOutput.writeObject(gVar.f6459c);
                objectOutput.writeObject(gVar.f6460d);
                return;
        }
    }
}
