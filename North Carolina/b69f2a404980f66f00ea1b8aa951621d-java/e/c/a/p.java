package e.c.a;

import c.a.a.a.a;
import c.b.a.a.c.n.c;
import e.c.a.w.e;
import e.c.a.w.k;
import e.c.a.x.f;
import e.c.a.x.i;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class p implements Serializable {
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
        Collections.unmodifiableMap(hashMap);
    }

    public p() {
        if (getClass() != q.class && getClass() != r.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static p s(e eVar) {
        p pVar = (p) eVar.f(k.f5180d);
        if (pVar != null) {
            return pVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to obtain ZoneId from TemporalAccessor: ");
        sb.append(eVar);
        sb.append(", type ");
        throw new a(a.d(eVar, sb));
    }

    public static Set<String> t() {
        return new HashSet(Collections.unmodifiableSet(i.f5221b.keySet()));
    }

    public static p w(String str) {
        c.T1(str, "zoneId");
        if (str.equals("Z")) {
            return q.f;
        }
        if (str.length() == 1) {
            throw new a(a.o("Invalid zone: ", str));
        } else if (str.startsWith("+") || str.startsWith("-")) {
            return q.A(str);
        } else {
            if (str.equals("UTC") || str.equals("GMT") || str.equals("UT")) {
                return new r(str, q.f.v());
            }
            if (str.startsWith("UTC+") || str.startsWith("GMT+") || str.startsWith("UTC-") || str.startsWith("GMT-")) {
                q A = q.A(str.substring(3));
                if (A.f5002b == 0) {
                    return new r(str.substring(0, 3), A.v());
                }
                return new r(str.substring(0, 3) + A.f5003c, A.v());
            } else if (!str.startsWith("UT+") && !str.startsWith("UT-")) {
                return r.z(str, true);
            } else {
                q A2 = q.A(str.substring(2));
                if (A2.f5002b == 0) {
                    return new r("UT", A2.v());
                }
                StringBuilder g = a.g("UT");
                g.append(A2.f5003c);
                return new r(g.toString(), A2.v());
            }
        }
    }

    public static p x(String str, q qVar) {
        c.T1(str, "prefix");
        c.T1(qVar, "offset");
        if (str.length() == 0) {
            return qVar;
        }
        if (!str.equals("GMT") && !str.equals("UTC") && !str.equals("UT")) {
            throw new IllegalArgumentException(a.o("Invalid prefix, must be GMT, UTC or UT: ", str));
        } else if (qVar.f5002b == 0) {
            return new r(str, qVar.v());
        } else {
            StringBuilder g = a.g(str);
            g.append(qVar.f5003c);
            return new r(g.toString(), qVar.v());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return u().equals(((p) obj).u());
        }
        return false;
    }

    public int hashCode() {
        return u().hashCode();
    }

    public String toString() {
        return u();
    }

    public abstract String u();

    public abstract f v();

    public abstract void y(DataOutput dataOutput);
}
