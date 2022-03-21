package f.b.c.k;

import f.a.a.a.a;
import f.b.c.d;
import f.b.c.k.e;
import f.b.c.k.s.f0;
import f.b.c.k.s.g0;
import f.b.c.k.s.i0;
import f.b.c.k.u.b;
import f.b.c.k.u.k;
import f.b.c.k.u.p.a;
import f.b.c.k.u.p.i;
import f.b.c.k.u.p.l;
import f.b.c.k.u.p.o;
import f.b.c.k.x.h;
import f.b.c.k.x.r;
import f.b.d.a.a;
import f.b.d.a.n;
import f.b.d.a.s;
import f.b.f.a1;
import f.b.f.p1;
import f.b.f.z;
import f.b.h.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class q {
    public final b a;

    public q(b bVar) {
        this.a = bVar;
    }

    public final k a(Object obj, g0 g0Var) {
        if (!obj.getClass().isArray()) {
            s c = c(h.b(obj, h.b.f3189d), g0Var);
            if (c.y() == s.c.MAP_VALUE) {
                return new k(c);
            }
            StringBuilder i2 = a.i("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was ", "of type: ");
            i2.append(r.d(obj));
            throw new IllegalArgumentException(i2.toString());
        }
        throw new IllegalArgumentException(a.t("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was ", "an array"));
    }

    public final List<s> b(List<Object> list) {
        new HashSet();
        new ArrayList();
        throw null;
    }

    public final s c(Object obj, g0 g0Var) {
        z zVar;
        s.b bVar;
        s.b bVar2;
        long j2;
        double d2;
        o oVar;
        o oVar2;
        s.b bVar3;
        a1 a1Var = a1.NULL_VALUE;
        boolean z = true;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.isEmpty()) {
                f.b.c.k.u.h hVar = g0Var.b;
                if (hVar != null && !hVar.l()) {
                    g0Var.a(g0Var.b);
                }
                bVar3 = s.z();
                bVar3.f(n.d());
            } else {
                n.b i2 = n.i();
                for (Map.Entry entry : map.entrySet()) {
                    if (entry.getKey() instanceof String) {
                        String str = (String) entry.getKey();
                        Object value = entry.getValue();
                        f.b.c.k.u.h hVar2 = g0Var.b;
                        g0 g0Var2 = new g0(g0Var.a, hVar2 == null ? null : (f.b.c.k.u.h) hVar2.b(str), false);
                        if (str.isEmpty()) {
                            throw g0Var2.c("Document fields must not be empty");
                        } else if (!g0Var2.d() || !str.startsWith("__") || !str.endsWith("__")) {
                            s c = c(value, g0Var2);
                            if (c != null) {
                                i2.b(str, c);
                            }
                        } else {
                            throw g0Var2.c("Document fields cannot begin and end with \"__\"");
                        }
                    } else {
                        throw g0Var.c(String.format("Non-String Map key (%s) is not allowed", entry.getValue()));
                    }
                }
                bVar3 = s.z();
                bVar3.e(i2);
            }
            return (s) bVar3.build();
        } else if (obj instanceof e) {
            e eVar = (e) obj;
            if (g0Var.d()) {
                f.b.c.k.u.h hVar3 = g0Var.b;
                if (hVar3 != null) {
                    if (eVar instanceof e.c) {
                        i0 i0Var = g0Var.a.a;
                        if (i0Var == i0.MergeSet) {
                            g0Var.a(hVar3);
                        } else if (i0Var == i0.Update) {
                            if (hVar3.n() <= 0) {
                                z = false;
                            }
                            f.b.a.c.b.o.b.a1(z, "FieldValue.delete() at the top level should have already been handled.", new Object[0]);
                            throw g0Var.c("FieldValue.delete() can only appear at the top level of your update data");
                        } else {
                            throw g0Var.c("FieldValue.delete() can only be used with update() and set() with SetOptions.merge()");
                        }
                    } else {
                        if (eVar instanceof e.C0111e) {
                            oVar = l.a;
                        } else {
                            if (eVar instanceof e.b) {
                                Objects.requireNonNull((e.b) eVar);
                                oVar2 = new a.b(b(null));
                            } else if (eVar instanceof e.a) {
                                Objects.requireNonNull((e.a) eVar);
                                oVar2 = new a.C0112a(b(null));
                            } else if (eVar instanceof e.d) {
                                Objects.requireNonNull((e.d) eVar);
                                f0 f0Var = new f0(i0.Argument);
                                s c2 = c(h.b(null, h.b.f3189d), f0Var.a());
                                if (c2 == null) {
                                    z = false;
                                }
                                f.b.a.c.b.o.b.a1(z, "Parsed data should not be null.", new Object[0]);
                                f.b.a.c.b.o.b.a1(f0Var.c.isEmpty(), "Field transforms should have been disallowed.", new Object[0]);
                                oVar = new i(c2);
                                hVar3 = g0Var.b;
                            } else {
                                f.b.a.c.b.o.b.z0("Unknown FieldValue type: %s", r.d(eVar));
                                throw null;
                            }
                            g0Var.b(g0Var.b, oVar2);
                        }
                        g0Var.b(hVar3, oVar);
                    }
                    return null;
                }
                throw g0Var.c(String.format("%s() is not currently supported inside arrays", eVar.a()));
            }
            throw g0Var.c(String.format("%s() can only be used with set() and update()", eVar.a()));
        } else {
            f.b.c.k.u.h hVar4 = g0Var.b;
            if (hVar4 != null) {
                g0Var.a(hVar4);
            }
            if (!(obj instanceof List)) {
                if (obj == null) {
                    bVar = s.z();
                    bVar.copyOnWrite();
                    s.j((s) bVar.instance, a1Var);
                } else {
                    if (obj instanceof Integer) {
                        bVar2 = s.z();
                        j2 = (long) ((Integer) obj).intValue();
                    } else if (obj instanceof Long) {
                        bVar2 = s.z();
                        j2 = ((Long) obj).longValue();
                    } else {
                        if (obj instanceof Float) {
                            bVar2 = s.z();
                            d2 = ((Float) obj).doubleValue();
                        } else if (obj instanceof Double) {
                            bVar2 = s.z();
                            d2 = ((Double) obj).doubleValue();
                        } else {
                            if (obj instanceof Boolean) {
                                bVar2 = s.z();
                                boolean booleanValue = ((Boolean) obj).booleanValue();
                                bVar2.copyOnWrite();
                                s.k((s) bVar2.instance, booleanValue);
                            } else if (obj instanceof String) {
                                bVar2 = s.z();
                                bVar2.copyOnWrite();
                                s.d((s) bVar2.instance, (String) obj);
                            } else if (obj instanceof Date) {
                                return d(new d((Date) obj));
                            } else {
                                if (obj instanceof d) {
                                    return d((d) obj);
                                }
                                if (obj instanceof k) {
                                    k kVar = (k) obj;
                                    bVar = s.z();
                                    a.b h2 = f.b.h.a.h();
                                    h2.copyOnWrite();
                                    f.b.h.a.c((f.b.h.a) h2.instance, 0.0d);
                                    h2.copyOnWrite();
                                    f.b.h.a.d((f.b.h.a) h2.instance, 0.0d);
                                    bVar.copyOnWrite();
                                    s.g((s) bVar.instance, (f.b.h.a) h2.build());
                                } else if (obj instanceof a) {
                                    bVar2 = s.z();
                                    a aVar = (a) obj;
                                    bVar2.copyOnWrite();
                                    s.e((s) bVar2.instance, null);
                                } else if (obj instanceof c) {
                                    c cVar = (c) obj;
                                    f fVar = cVar.b;
                                    if (fVar != null) {
                                        b bVar4 = fVar.b;
                                        if (!bVar4.equals(this.a)) {
                                            b bVar5 = this.a;
                                            throw g0Var.c(String.format("Document reference is for database %s/%s but should be for database %s/%s", bVar4.b, bVar4.c, bVar5.b, bVar5.c));
                                        }
                                    }
                                    bVar2 = s.z();
                                    b bVar6 = this.a;
                                    String format = String.format("projects/%s/databases/%s/documents/%s", bVar6.b, bVar6.c, cVar.a.b.c());
                                    bVar2.copyOnWrite();
                                    s.f((s) bVar2.instance, format);
                                } else if (obj.getClass().isArray()) {
                                    throw g0Var.c("Arrays are not supported; use a List instead");
                                } else {
                                    StringBuilder h3 = f.a.a.a.a.h("Unsupported type: ");
                                    h3.append(r.d(obj));
                                    throw g0Var.c(h3.toString());
                                }
                            }
                            zVar = bVar2.build();
                            return (s) zVar;
                        }
                        bVar2.c(d2);
                        zVar = bVar2.build();
                        return (s) zVar;
                    }
                    bVar2.d(j2);
                    zVar = bVar2.build();
                    return (s) zVar;
                }
                zVar = bVar.build();
                return (s) zVar;
            } else if (!g0Var.c || g0Var.a.a == i0.ArrayArgument) {
                a.b j3 = f.b.d.a.a.j();
                for (Object obj2 : (List) obj) {
                    s c3 = c(obj2, new g0(g0Var.a, null, true));
                    if (c3 == null) {
                        s.b z2 = s.z();
                        z2.copyOnWrite();
                        s.j((s) z2.instance, a1Var);
                        c3 = (s) z2.build();
                    }
                    j3.copyOnWrite();
                    f.b.d.a.a.c((f.b.d.a.a) j3.instance, c3);
                }
                s.b z3 = s.z();
                z3.b(j3);
                return (s) z3.build();
            } else {
                throw g0Var.c("Nested arrays are not supported");
            }
        }
    }

    public final s d(d dVar) {
        s.b z = s.z();
        p1.b h2 = p1.h();
        h2.c(dVar.b);
        h2.b((dVar.c / 1000) * 1000);
        z.copyOnWrite();
        s.c((s) z.instance, (p1) h2.build());
        return (s) z.build();
    }
}
