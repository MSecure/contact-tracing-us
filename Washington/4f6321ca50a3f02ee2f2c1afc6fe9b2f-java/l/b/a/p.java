package l.b.a;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import l.b.a.w.e;
import l.b.a.w.k;
import l.b.a.x.f;

public abstract class p implements Serializable {
    public static final /* synthetic */ int b = 0;

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

    public static p q(e eVar) {
        p pVar = (p) eVar.c(k.f4206d);
        if (pVar != null) {
            return pVar;
        }
        throw new a(a.f(eVar, a.k("Unable to obtain ZoneId from TemporalAccessor: ", eVar, ", type ")));
    }

    public static p t(String str) {
        b.B1(str, "zoneId");
        if (str.equals("Z")) {
            return q.f4070g;
        }
        if (str.length() == 1) {
            throw new a(a.t("Invalid zone: ", str));
        } else if (str.startsWith("+") || str.startsWith("-")) {
            return q.x(str);
        } else {
            if (str.equals("UTC") || str.equals("GMT") || str.equals("UT")) {
                return new r(str, q.f4070g.s());
            }
            if (str.startsWith("UTC+") || str.startsWith("GMT+") || str.startsWith("UTC-") || str.startsWith("GMT-")) {
                q x = q.x(str.substring(3));
                if (x.c == 0) {
                    return new r(str.substring(0, 3), x.s());
                }
                return new r(str.substring(0, 3) + x.f4073d, x.s());
            } else if (!str.startsWith("UT+") && !str.startsWith("UT-")) {
                return r.w(str, true);
            } else {
                q x2 = q.x(str.substring(2));
                if (x2.c == 0) {
                    return new r("UT", x2.s());
                }
                StringBuilder h2 = a.h("UT");
                h2.append(x2.f4073d);
                return new r(h2.toString(), x2.s());
            }
        }
    }

    public static p u(String str, q qVar) {
        b.B1(str, "prefix");
        b.B1(qVar, "offset");
        if (str.length() == 0) {
            return qVar;
        }
        if (!str.equals("GMT") && !str.equals("UTC") && !str.equals("UT")) {
            throw new IllegalArgumentException(a.t("Invalid prefix, must be GMT, UTC or UT: ", str));
        } else if (qVar.c == 0) {
            return new r(str, qVar.s());
        } else {
            StringBuilder h2 = a.h(str);
            h2.append(qVar.f4073d);
            return new r(h2.toString(), qVar.s());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return r().equals(((p) obj).r());
        }
        return false;
    }

    public int hashCode() {
        return r().hashCode();
    }

    public abstract String r();

    public abstract f s();

    public String toString() {
        return r();
    }

    public abstract void v(DataOutput dataOutput);
}
