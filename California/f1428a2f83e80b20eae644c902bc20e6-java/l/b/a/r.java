package l.b.a;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.regex.Pattern;
import l.b.a.x.f;
import l.b.a.x.g;
import l.b.a.x.i;

public final class r extends p implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f4066e = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final transient f f4067d;

    public r(String str, f fVar) {
        this.c = str;
        this.f4067d = fVar;
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static r w(String str, boolean z) {
        b.B1(str, "zoneId");
        if (str.length() < 2 || !f4066e.matcher(str).matches()) {
            throw new a(a.t("Invalid ID for region-based ZoneId, invalid format: ", str));
        }
        f fVar = null;
        try {
            fVar = i.a(str, true);
        } catch (g e2) {
            if (str.equals("GMT0")) {
                fVar = q.f4062g.s();
            } else if (z) {
                throw e2;
            }
        }
        return new r(str, fVar);
    }

    private Object writeReplace() {
        return new m((byte) 7, this);
    }

    @Override // l.b.a.p
    public String r() {
        return this.c;
    }

    @Override // l.b.a.p
    public f s() {
        f fVar = this.f4067d;
        return fVar != null ? fVar : i.a(this.c, false);
    }

    @Override // l.b.a.p
    public void v(DataOutput dataOutput) {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.c);
    }
}
