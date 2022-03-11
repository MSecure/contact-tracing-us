package l.b.a;

import f.a.a.a.a;
import g.b.a.c.c.d;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import l.b.a.x.e;
import l.b.a.x.k;
import l.b.a.y.f;
/* loaded from: classes.dex */
public abstract class q implements Serializable {
    public static final Map<String, String> b;

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
        b = Collections.unmodifiableMap(hashMap);
    }

    public q() {
        if (getClass() != r.class && getClass() != s.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static q q(e eVar) {
        q qVar = (q) eVar.c(k.f4777d);
        if (qVar != null) {
            return qVar;
        }
        throw new b(a.f(eVar, a.k("Unable to obtain ZoneId from TemporalAccessor: ", eVar, ", type ")));
    }

    public static q t(String str) {
        d.u(str, "zoneId");
        if (str.equals("Z")) {
            return r.f4641g;
        }
        if (str.length() == 1) {
            throw new b(a.x("Invalid zone: ", str));
        } else if (str.startsWith("+") || str.startsWith("-")) {
            return r.x(str);
        } else {
            if (str.equals("UTC") || str.equals("GMT") || str.equals("UT")) {
                return new s(str, r.f4641g.s());
            }
            if (str.startsWith("UTC+") || str.startsWith("GMT+") || str.startsWith("UTC-") || str.startsWith("GMT-")) {
                r x = r.x(str.substring(3));
                if (x.c == 0) {
                    return new s(str.substring(0, 3), x.s());
                }
                return new s(str.substring(0, 3) + x.f4644d, x.s());
            } else if (!str.startsWith("UT+") && !str.startsWith("UT-")) {
                return s.w(str, true);
            } else {
                r x2 = r.x(str.substring(2));
                if (x2.c == 0) {
                    return new s("UT", x2.s());
                }
                StringBuilder h2 = a.h("UT");
                h2.append(x2.f4644d);
                return new s(h2.toString(), x2.s());
            }
        }
    }

    public static q u(String str, r rVar) {
        d.u(str, "prefix");
        d.u(rVar, "offset");
        if (str.length() == 0) {
            return rVar;
        }
        if (!str.equals("GMT") && !str.equals("UTC") && !str.equals("UT")) {
            throw new IllegalArgumentException(a.x("Invalid prefix, must be GMT, UTC or UT: ", str));
        } else if (rVar.c == 0) {
            return new s(str, rVar.s());
        } else {
            StringBuilder h2 = a.h(str);
            h2.append(rVar.f4644d);
            return new s(h2.toString(), rVar.s());
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return r().equals(((q) obj).r());
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return r().hashCode();
    }

    public abstract String r();

    public abstract f s();

    @Override // java.lang.Object
    public String toString() {
        return r();
    }

    public abstract void v(DataOutput dataOutput);
}
