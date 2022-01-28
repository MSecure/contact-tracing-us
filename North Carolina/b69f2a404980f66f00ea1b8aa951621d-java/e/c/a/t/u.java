package e.c.a.t;

import e.c.a.e;
import e.c.a.g;
import e.c.a.p;
import e.c.a.q;
import e.c.a.w.a;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

public final class u implements Externalizable {

    /* renamed from: b  reason: collision with root package name */
    public byte f5046b;

    /* renamed from: c  reason: collision with root package name */
    public Object f5047c;

    public u() {
    }

    public u(byte b2, Object obj) {
        this.f5046b = b2;
        this.f5047c = obj;
    }

    private Object readResolve() {
        return this.f5047c;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        Object obj;
        Object obj2;
        byte readByte = objectInput.readByte();
        this.f5046b = readByte;
        switch (readByte) {
            case 1:
                obj = p.I(objectInput);
                break;
            case 2:
                obj = q.v(objectInput);
                break;
            case 3:
                obj = k.U(objectInput);
                break;
            case 4:
                obj = l.s(objectInput.readByte());
                break;
            case 5:
                int readInt = objectInput.readInt();
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                r rVar = r.f5041d;
                obj2 = new s(e.P(readInt + 1911, readByte2, readByte3));
                obj = obj2;
                break;
            case 6:
                obj = t.s(objectInput.readByte());
                break;
            case 7:
                int readInt2 = objectInput.readInt();
                byte readByte4 = objectInput.readByte();
                byte readByte5 = objectInput.readByte();
                v vVar = v.f5048d;
                obj2 = new w(e.P(readInt2 - 543, readByte4, readByte5));
                obj = obj2;
                break;
            case 8:
                obj = x.s(objectInput.readByte());
                break;
            case 9:
            case 10:
            default:
                throw new StreamCorruptedException("Unknown serialized type");
            case 11:
                obj = h.s(objectInput);
                break;
            case 12:
                obj = ((b) objectInput.readObject()).s((g) objectInput.readObject());
                break;
            case 13:
                obj = ((c) objectInput.readObject()).s((q) objectInput.readObject()).E((p) objectInput.readObject());
                break;
        }
        this.f5047c = obj;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        byte b2 = this.f5046b;
        Object obj = this.f5047c;
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
                objectOutput.writeByte(((q) obj).f5038b);
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
                objectOutput.writeUTF(((h) obj).p());
                return;
            case 12:
                d dVar = (d) obj;
                objectOutput.writeObject(dVar.f5011b);
                objectOutput.writeObject(dVar.f5012c);
                return;
            case 13:
                g gVar = (g) obj;
                objectOutput.writeObject(gVar.f5013b);
                objectOutput.writeObject(gVar.f5014c);
                objectOutput.writeObject(gVar.f5015d);
                return;
        }
    }
}
