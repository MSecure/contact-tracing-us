package e.c.a;

import c.a.a.a.a;
import c.b.a.a.c.n.c;
import e.c.a.x.f;
import e.c.a.x.g;
import e.c.a.x.i;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.regex.Pattern;

public final class r extends p implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f5004d = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");

    /* renamed from: b  reason: collision with root package name */
    public final String f5005b;

    /* renamed from: c  reason: collision with root package name */
    public final transient f f5006c;

    public r(String str, f fVar) {
        this.f5005b = str;
        this.f5006c = fVar;
    }

    public static p A(DataInput dataInput) {
        r rVar;
        r rVar2;
        String readUTF = dataInput.readUTF();
        if (readUTF.equals("Z") || readUTF.startsWith("+") || readUTF.startsWith("-")) {
            throw new a(a.o("Invalid ID for region-based ZoneId, invalid format: ", readUTF));
        } else if (readUTF.equals("UTC") || readUTF.equals("GMT") || readUTF.equals("UT")) {
            return new r(readUTF, q.f.v());
        } else {
            if (readUTF.startsWith("UTC+") || readUTF.startsWith("GMT+") || readUTF.startsWith("UTC-") || readUTF.startsWith("GMT-")) {
                q A = q.A(readUTF.substring(3));
                if (A.f5002b == 0) {
                    rVar = new r(readUTF.substring(0, 3), A.v());
                } else {
                    rVar = new r(readUTF.substring(0, 3) + A.f5003c, A.v());
                }
                return rVar;
            } else if (!readUTF.startsWith("UT+") && !readUTF.startsWith("UT-")) {
                return z(readUTF, false);
            } else {
                q A2 = q.A(readUTF.substring(2));
                if (A2.f5002b == 0) {
                    rVar2 = new r("UT", A2.v());
                } else {
                    StringBuilder g = a.g("UT");
                    g.append(A2.f5003c);
                    rVar2 = new r(g.toString(), A2.v());
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

    public static r z(String str, boolean z) {
        c.T1(str, "zoneId");
        if (str.length() < 2 || !f5004d.matcher(str).matches()) {
            throw new a(a.o("Invalid ID for region-based ZoneId, invalid format: ", str));
        }
        f fVar = null;
        try {
            fVar = i.a(str, true);
        } catch (g e2) {
            if (str.equals("GMT0")) {
                fVar = q.f.v();
            } else if (z) {
                throw e2;
            }
        }
        return new r(str, fVar);
    }

    @Override // e.c.a.p
    public String u() {
        return this.f5005b;
    }

    @Override // e.c.a.p
    public f v() {
        f fVar = this.f5006c;
        return fVar != null ? fVar : i.a(this.f5005b, false);
    }

    @Override // e.c.a.p
    public void y(DataOutput dataOutput) {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.f5005b);
    }
}
