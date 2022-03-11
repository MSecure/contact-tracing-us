package l.b.a;

import g.b.a.c.c.d;
import java.io.Serializable;
import java.util.Map;
import java.util.TimeZone;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: l.b.a.a$a */
    /* loaded from: classes.dex */
    public static final class C0156a extends a implements Serializable {
        public final q b;

        public C0156a(q qVar) {
            this.b = qVar;
        }

        @Override // l.b.a.a
        public e a() {
            return e.z(System.currentTimeMillis());
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (obj instanceof C0156a) {
                return this.b.equals(((C0156a) obj).b);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.b.hashCode() + 1;
        }

        @Override // java.lang.Object
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
        return new C0156a(q.t(id));
    }

    public abstract e a();
}
