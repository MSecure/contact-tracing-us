package f.b.c.k.u;

import f.b.a.c.b.o.b;
import f.b.c.k.x.r;
import f.b.d.a.n;
import f.b.d.a.s;
import f.b.f.a1;
import f.b.f.p1;
import f.b.h.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class o {
    public static final s a;
    public static final s b;

    static {
        s.b z = s.z();
        z.c(Double.NaN);
        a = (s) z.build();
        s.b z2 = s.z();
        a1 a1Var = a1.NULL_VALUE;
        z2.copyOnWrite();
        s.j((s) z2.instance, a1Var);
        b = (s) z2.build();
    }

    public static void a(StringBuilder sb, s sVar) {
        String str;
        boolean z = true;
        switch (sVar.y().ordinal()) {
            case 0:
                str = "null";
                break;
            case 1:
                sb.append(sVar.o());
                return;
            case 2:
                sb.append(sVar.t());
                return;
            case 3:
                sb.append(sVar.r());
                return;
            case 4:
                p1 x = sVar.x();
                sb.append(String.format("time(%s,%s)", Long.valueOf(x.g()), Integer.valueOf(x.f())));
                return;
            case 5:
                str = sVar.w();
                break;
            case 6:
                str = r.c(sVar.p());
                break;
            case 7:
                b.a1(i(sVar), "Value should be a ReferenceValue", new Object[0]);
                sb.append(f.b(sVar.v()));
                return;
            case 8:
                a s = sVar.s();
                sb.append(String.format("geo(%s,%s)", Double.valueOf(s.f()), Double.valueOf(s.g())));
                return;
            case 9:
                f.b.d.a.a n = sVar.n();
                sb.append("[");
                for (int i2 = 0; i2 < n.i(); i2++) {
                    a(sb, n.h(i2));
                    if (i2 != n.i() - 1) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                return;
            case 10:
                n u = sVar.u();
                ArrayList arrayList = new ArrayList(u.f().keySet());
                Collections.sort(arrayList);
                sb.append("{");
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (!z) {
                        sb.append(",");
                    } else {
                        z = false;
                    }
                    sb.append(str2);
                    sb.append(":");
                    a(sb, u.h(str2));
                }
                sb.append("}");
                return;
            default:
                StringBuilder h2 = f.a.a.a.a.h("Invalid value type: ");
                h2.append(sVar.y());
                b.z0(h2.toString(), new Object[0]);
                throw null;
        }
        sb.append(str);
    }

    public static boolean b(f.b.d.a.b bVar, s sVar) {
        for (s sVar2 : bVar.a()) {
            if (c(sVar2, sVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(s sVar, s sVar2) {
        int j2;
        boolean z = true;
        if (sVar == null && sVar2 == null) {
            return true;
        }
        if (sVar == null || sVar2 == null || (j2 = j(sVar)) != j(sVar2)) {
            return false;
        }
        if (j2 == 2) {
            s.c y = sVar.y();
            s.c cVar = s.c.INTEGER_VALUE;
            if (y == cVar && sVar2.y() == cVar) {
                return sVar.equals(sVar2);
            }
            s.c y2 = sVar.y();
            s.c cVar2 = s.c.DOUBLE_VALUE;
            if (!(y2 == cVar2 && sVar2.y() == cVar2 && Double.doubleToLongBits(sVar.r()) == Double.doubleToLongBits(sVar2.r()))) {
                z = false;
            }
            return z;
        } else if (j2 == 4) {
            return b.T0(sVar).equals(b.T0(sVar2));
        } else {
            if (j2 == 9) {
                f.b.d.a.a n = sVar.n();
                f.b.d.a.a n2 = sVar2.n();
                if (n.i() == n2.i()) {
                    for (int i2 = 0; i2 < n.i(); i2++) {
                        if (c(n.h(i2), n2.h(i2))) {
                        }
                    }
                    return true;
                }
                return false;
            } else if (j2 != 10) {
                return sVar.equals(sVar2);
            } else {
                n u = sVar.u();
                n u2 = sVar2.u();
                if (u.e() != u2.e()) {
                    return false;
                }
                for (Map.Entry<String, s> entry : u.f().entrySet()) {
                    if (!entry.getValue().equals(u2.f().get(entry.getKey()))) {
                    }
                }
                return true;
                return false;
            }
        }
    }

    public static boolean d(s sVar) {
        return sVar != null && sVar.y() == s.c.ARRAY_VALUE;
    }

    public static boolean e(s sVar) {
        return sVar != null && sVar.y() == s.c.DOUBLE_VALUE;
    }

    public static boolean f(s sVar) {
        return sVar != null && sVar.y() == s.c.INTEGER_VALUE;
    }

    public static boolean g(s sVar) {
        return sVar != null && sVar.y() == s.c.MAP_VALUE;
    }

    public static boolean h(s sVar) {
        return f(sVar) || e(sVar);
    }

    public static boolean i(s sVar) {
        return sVar != null && sVar.y() == s.c.REFERENCE_VALUE;
    }

    public static int j(s sVar) {
        switch (sVar.y().ordinal()) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return b.j1(sVar) ? 4 : 10;
            default:
                StringBuilder h2 = f.a.a.a.a.h("Invalid value type: ");
                h2.append(sVar.y());
                b.z0(h2.toString(), new Object[0]);
                throw null;
        }
    }
}
