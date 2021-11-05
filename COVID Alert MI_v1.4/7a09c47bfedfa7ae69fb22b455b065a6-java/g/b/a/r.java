package g.b.a;

import b.x.t;
import c.a.a.a.a;
import g.b.a.x.f;
import g.b.a.x.g;
import g.b.a.x.i;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.regex.Pattern;

public final class r extends p implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f6449e = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");

    /* renamed from: c  reason: collision with root package name */
    public final String f6450c;

    /* renamed from: d  reason: collision with root package name */
    public final transient f f6451d;

    public r(String str, f fVar) {
        this.f6450c = str;
        this.f6451d = fVar;
    }

    public static r L(String str, boolean z) {
        t.y2(str, "zoneId");
        if (str.length() < 2 || !f6449e.matcher(str).matches()) {
            throw new a(a.q("Invalid ID for region-based ZoneId, invalid format: ", str));
        }
        f fVar = null;
        try {
            fVar = i.a(str, true);
        } catch (g e2) {
            if (str.equals("GMT0")) {
                fVar = q.f6446g.B();
            } else if (z) {
                throw e2;
            }
        }
        return new r(str, fVar);
    }

    public static p P(DataInput dataInput) {
        r rVar;
        r rVar2;
        String readUTF = dataInput.readUTF();
        if (readUTF.equals("Z") || readUTF.startsWith("+") || readUTF.startsWith("-")) {
            throw new a(a.q("Invalid ID for region-based ZoneId, invalid format: ", readUTF));
        } else if (readUTF.equals("UTC") || readUTF.equals("GMT") || readUTF.equals("UT")) {
            return new r(readUTF, q.f6446g.B());
        } else {
            if (readUTF.startsWith("UTC+") || readUTF.startsWith("GMT+") || readUTF.startsWith("UTC-") || readUTF.startsWith("GMT-")) {
                q P = q.P(readUTF.substring(3));
                if (P.f6447c == 0) {
                    rVar = new r(readUTF.substring(0, 3), P.B());
                } else {
                    rVar = new r(readUTF.substring(0, 3) + P.f6448d, P.B());
                }
                return rVar;
            } else if (!readUTF.startsWith("UT+") && !readUTF.startsWith("UT-")) {
                return L(readUTF, false);
            } else {
                q P2 = q.P(readUTF.substring(2));
                if (P2.f6447c == 0) {
                    rVar2 = new r("UT", P2.B());
                } else {
                    StringBuilder h = a.h("UT");
                    h.append(P2.f6448d);
                    rVar2 = new r(h.toString(), P2.B());
                }
                return rVar2;
            }
        }
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new m((byte) 7, this);
    }

    @Override // g.b.a.p
    public String A() {
        return this.f6450c;
    }

    @Override // g.b.a.p
    public f B() {
        f fVar = this.f6451d;
        return fVar != null ? fVar : i.a(this.f6450c, false);
    }

    @Override // g.b.a.p
    public void H(DataOutput dataOutput) {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.f6450c);
    }
}
