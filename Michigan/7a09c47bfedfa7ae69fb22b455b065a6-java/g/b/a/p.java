package g.b.a;

import b.x.t;
import c.a.a.a.a;
import g.b.a.w.e;
import g.b.a.w.k;
import g.b.a.x.f;
import g.b.a.x.i;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public abstract class p implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, String> f6443b;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("ACT", "Australia/Darwin");
        hashMap.put("AET", "Australia/Sydney");
        hashMap.put("AGT", "America/Argentina/Buenos_Aires");
        hashMap.put("ART", "Africa/Cairo");
        hashMap.put("AST", "America/Anchorage");
        hashMap.put("BET", "America/Sao_Paulo");
        hashMap.put("BST", "Asia/Dhaka");
        hashMap.put("CAT", "Africa/Harare");
        hashMap.put("CNT", "America/St_Johns");
        hashMap.put("CST", "America/Chicago");
        hashMap.put("CTT", "Asia/Shanghai");
        hashMap.put("EAT", "Africa/Addis_Ababa");
        hashMap.put("ECT", "Europe/Paris");
        hashMap.put("IET", "America/Indiana/Indianapolis");
        hashMap.put("IST", "Asia/Kolkata");
        hashMap.put("JST", "Asia/Tokyo");
        hashMap.put("MIT", "Pacific/Apia");
        hashMap.put("NET", "Asia/Yerevan");
        hashMap.put("NST", "Pacific/Auckland");
        hashMap.put("PLT", "Asia/Karachi");
        hashMap.put("PNT", "America/Phoenix");
        hashMap.put("PRT", "America/Puerto_Rico");
        hashMap.put("PST", "America/Los_Angeles");
        hashMap.put("SST", "Pacific/Guadalcanal");
        hashMap.put("VST", "Asia/Ho_Chi_Minh");
        hashMap.put("EST", "-05:00");
        hashMap.put("MST", "-07:00");
        hashMap.put("HST", "-10:00");
        f6443b = Collections.unmodifiableMap(hashMap);
    }

    public p() {
        if (getClass() != q.class && getClass() != r.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static p D(String str) {
        t.y2(str, "zoneId");
        if (str.equals("Z")) {
            return q.f6446g;
        }
        if (str.length() == 1) {
            throw new a(a.q("Invalid zone: ", str));
        } else if (str.startsWith("+") || str.startsWith("-")) {
            return q.P(str);
        } else {
            if (str.equals("UTC") || str.equals("GMT") || str.equals("UT")) {
                return new r(str, q.f6446g.B());
            }
            if (str.startsWith("UTC+") || str.startsWith("GMT+") || str.startsWith("UTC-") || str.startsWith("GMT-")) {
                q P = q.P(str.substring(3));
                if (P.f6447c == 0) {
                    return new r(str.substring(0, 3), P.B());
                }
                return new r(str.substring(0, 3) + P.f6448d, P.B());
            } else if (!str.startsWith("UT+") && !str.startsWith("UT-")) {
                return r.L(str, true);
            } else {
                q P2 = q.P(str.substring(2));
                if (P2.f6447c == 0) {
                    return new r("UT", P2.B());
                }
                StringBuilder h = a.h("UT");
                h.append(P2.f6448d);
                return new r(h.toString(), P2.B());
            }
        }
    }

    public static p F(String str, q qVar) {
        t.y2(str, "prefix");
        t.y2(qVar, "offset");
        if (str.length() == 0) {
            return qVar;
        }
        if (!str.equals("GMT") && !str.equals("UTC") && !str.equals("UT")) {
            throw new IllegalArgumentException(a.q("Invalid prefix, must be GMT, UTC or UT: ", str));
        } else if (qVar.f6447c == 0) {
            return new r(str, qVar.B());
        } else {
            StringBuilder h = a.h(str);
            h.append(qVar.f6448d);
            return new r(h.toString(), qVar.B());
        }
    }

    public static p G() {
        String id = TimeZone.getDefault().getID();
        Map<String, String> map = f6443b;
        t.y2(id, "zoneId");
        t.y2(map, "aliasMap");
        String str = map.get(id);
        if (str != null) {
            id = str;
        }
        return D(id);
    }

    public static p p(e eVar) {
        p pVar = (p) eVar.f(k.f6659d);
        if (pVar != null) {
            return pVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to obtain ZoneId from TemporalAccessor: ");
        sb.append(eVar);
        sb.append(", type ");
        throw new a(a.e(eVar, sb));
    }

    public static Set<String> x() {
        return new HashSet(Collections.unmodifiableSet(i.f6710b.keySet()));
    }

    public abstract String A();

    public abstract f B();

    public abstract void H(DataOutput dataOutput);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return A().equals(((p) obj).A());
        }
        return false;
    }

    public int hashCode() {
        return A().hashCode();
    }

    public String toString() {
        return A();
    }
}
