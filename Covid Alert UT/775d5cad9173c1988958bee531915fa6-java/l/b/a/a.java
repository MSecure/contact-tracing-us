package l.b.a;

import g.b.a.c.c.d;
import java.io.Serializable;
import java.util.Map;
import java.util.TimeZone;

public abstract class a {

    /* renamed from: l.b.a.a$a  reason: collision with other inner class name */
    public static final class C0154a extends a implements Serializable {
        public final q b;

        public C0154a(q qVar) {
            this.b = qVar;
        }

        @Override // l.b.a.a
        public e a() {
            return e.z(System.currentTimeMillis());
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0154a) {
                return this.b.equals(((C0154a) obj).b);
            }
            return false;
        }

        public int hashCode() {
            return this.b.hashCode() + 1;
        }

        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("SystemClock[");
            h2.append(this.b);
            h2.append("]");
            return h2.toString();
        }
    }

    public static a b() {
        Map<String, String> map = q.b;
        String id = TimeZone.getDefault().getID();
        Map<String, String> map2 = q.b;
        d.u(id, "zoneId");
        d.u(map2, "aliasMap");
        String str = map2.get(id);
        if (str != null) {
            id = str;
        }
        return new C0154a(q.t(id));
    }

    public abstract e a();
}
