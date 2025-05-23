package l.b.a.t;

import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.Iterator;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import l.b.a.a;
import l.b.a.e;
import l.b.a.g;
import l.b.a.p;
import l.b.a.q;

public final class u implements Externalizable {
    public byte b;
    public Object c;

    public u() {
    }

    public u(byte b2, Object obj) {
        this.b = b2;
        this.c = obj;
    }

    private Object readResolve() {
        return this.c;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        Object obj;
        Object obj2;
        byte readByte = objectInput.readByte();
        this.b = readByte;
        switch (readByte) {
            case 1:
                e eVar = p.f4091e;
                int readInt = objectInput.readInt();
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                Objects.requireNonNull(o.f4087e);
                obj2 = new p(e.P(readInt, readByte2, readByte3));
                obj = obj2;
                break;
            case 2:
                q qVar = q.f4093e;
                obj = q.s(objectInput.readByte());
                break;
            case 3:
                int[] iArr = k.f4074i;
                int readInt2 = objectInput.readInt();
                byte readByte4 = objectInput.readByte();
                byte readByte5 = objectInput.readByte();
                j jVar = j.f4070d;
                obj = k.N(readInt2, readByte4, readByte5);
                break;
            case 4:
                obj = l.q(objectInput.readByte());
                break;
            case 5:
                int readInt3 = objectInput.readInt();
                byte readByte6 = objectInput.readByte();
                byte readByte7 = objectInput.readByte();
                r rVar = r.f4100d;
                obj2 = new s(e.P(readInt3 + 1911, readByte6, readByte7));
                obj = obj2;
                break;
            case 6:
                obj = t.q(objectInput.readByte());
                break;
            case 7:
                int readInt4 = objectInput.readInt();
                byte readByte8 = objectInput.readByte();
                byte readByte9 = objectInput.readByte();
                v vVar = v.f4102d;
                obj2 = new w(e.P(readInt4 - 543, readByte8, readByte9));
                obj = obj2;
                break;
            case 8:
                obj = x.q(objectInput.readByte());
                break;
            case 9:
            case 10:
            default:
                throw new StreamCorruptedException("Unknown serialized type");
            case 11:
                ConcurrentHashMap<String, h> concurrentHashMap = h.b;
                String readUTF = objectInput.readUTF();
                ConcurrentHashMap<String, h> concurrentHashMap2 = h.b;
                if (concurrentHashMap2.isEmpty()) {
                    h.q(m.f4084d);
                    h.q(v.f4102d);
                    h.q(r.f4100d);
                    h.q(o.f4087e);
                    j jVar2 = j.f4070d;
                    h.q(jVar2);
                    concurrentHashMap2.putIfAbsent("Hijrah", jVar2);
                    h.c.putIfAbsent("islamic", jVar2);
                    Iterator it = ServiceLoader.load(h.class, h.class.getClassLoader()).iterator();
                    while (it.hasNext()) {
                        h hVar = (h) it.next();
                        h.b.putIfAbsent(hVar.n(), hVar);
                        String m = hVar.m();
                        if (m != null) {
                            h.c.putIfAbsent(m, hVar);
                        }
                    }
                }
                h hVar2 = h.b.get(readUTF);
                if (hVar2 != null || (hVar2 = h.c.get(readUTF)) != null) {
                    obj = hVar2;
                    break;
                } else {
                    throw new a(f.a.a.a.a.t("Unknown chronology: ", readUTF));
                }
                break;
            case 12:
                obj = ((b) objectInput.readObject()).q((g) objectInput.readObject());
                break;
            case 13:
                obj = ((c) objectInput.readObject()).q((q) objectInput.readObject()).D((p) objectInput.readObject());
                break;
        }
        this.c = obj;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        byte b2 = this.b;
        Object obj = this.c;
        objectOutput.writeByte(b2);
        switch (b2) {
            case 1:
                p pVar = (p) obj;
                Objects.requireNonNull(pVar);
                objectOutput.writeInt(pVar.b(l.b.a.w.a.YEAR));
                objectOutput.writeByte(pVar.b(l.b.a.w.a.MONTH_OF_YEAR));
                objectOutput.writeByte(pVar.b(l.b.a.w.a.DAY_OF_MONTH));
                return;
            case 2:
                objectOutput.writeByte(((q) obj).b);
                return;
            case 3:
                k kVar = (k) obj;
                Objects.requireNonNull(kVar);
                objectOutput.writeInt(kVar.b(l.b.a.w.a.YEAR));
                objectOutput.writeByte(kVar.b(l.b.a.w.a.MONTH_OF_YEAR));
                objectOutput.writeByte(kVar.b(l.b.a.w.a.DAY_OF_MONTH));
                return;
            case 4:
                objectOutput.writeByte(((l) obj).ordinal());
                return;
            case 5:
                s sVar = (s) obj;
                Objects.requireNonNull(sVar);
                objectOutput.writeInt(sVar.b(l.b.a.w.a.YEAR));
                objectOutput.writeByte(sVar.b(l.b.a.w.a.MONTH_OF_YEAR));
                objectOutput.writeByte(sVar.b(l.b.a.w.a.DAY_OF_MONTH));
                return;
            case 6:
                objectOutput.writeByte(((t) obj).ordinal());
                return;
            case 7:
                w wVar = (w) obj;
                Objects.requireNonNull(wVar);
                objectOutput.writeInt(wVar.b(l.b.a.w.a.YEAR));
                objectOutput.writeByte(wVar.b(l.b.a.w.a.MONTH_OF_YEAR));
                objectOutput.writeByte(wVar.b(l.b.a.w.a.DAY_OF_MONTH));
                return;
            case 8:
                objectOutput.writeByte(((x) obj).ordinal());
                return;
            case 9:
            case 10:
            default:
                throw new InvalidClassException("Unknown serialized type");
            case 11:
                objectOutput.writeUTF(((h) obj).n());
                return;
            case 12:
                d dVar = (d) obj;
                objectOutput.writeObject(dVar.b);
                objectOutput.writeObject(dVar.c);
                return;
            case 13:
                g gVar = (g) obj;
                objectOutput.writeObject(gVar.b);
                objectOutput.writeObject(gVar.c);
                objectOutput.writeObject(gVar.f4069d);
                return;
        }
    }
}
