package l.b.a;

import f.a.a.a.a;
import g.b.a.c.c.c;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.regex.Pattern;
import l.b.a.y.f;
import l.b.a.y.g;
import l.b.a.y.i;

public final class s extends q implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f4325e = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final transient f f4326d;

    public s(String str, f fVar) {
        this.c = str;
        this.f4326d = fVar;
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static s w(String str, boolean z) {
        c.u(str, "zoneId");
        if (str.length() < 2 || !f4325e.matcher(str).matches()) {
            throw new b(a.c("Invalid ID for region-based ZoneId, invalid format: ", str));
        }
        f fVar = null;
        try {
            fVar = i.a(str, true);
        } catch (g e2) {
            if (str.equals("GMT0")) {
                fVar = r.f4321g.s();
            } else if (z) {
                throw e2;
            }
        }
        return new s(str, fVar);
    }

    private Object writeReplace() {
        return new n((byte) 7, this);
    }

    @Override // l.b.a.q
    public String r() {
        return this.c;
    }

    @Override // l.b.a.q
    public f s() {
        f fVar = this.f4326d;
        return fVar != null ? fVar : i.a(this.c, false);
    }

    @Override // l.b.a.q
    public void v(DataOutput dataOutput) {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.c);
    }
}
