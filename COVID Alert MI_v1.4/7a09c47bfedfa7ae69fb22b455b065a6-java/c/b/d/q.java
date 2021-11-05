package c.b.d;

import c.b.d.g0;
import c.b.d.n0;
import c.b.d.s;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public final class q implements h1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f5466a = new HashSet(Arrays.asList("cached_size", "serialized_size", "class"));

    /* renamed from: b  reason: collision with root package name */
    public static a f5467b = new a();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<s.b, Boolean> f5468a = new ConcurrentHashMap();

        /* renamed from: b  reason: collision with root package name */
        public int f5469b = 0;

        /* renamed from: c  reason: collision with root package name */
        public final Stack<C0110a> f5470c = new Stack<>();

        /* renamed from: d  reason: collision with root package name */
        public final Map<s.b, C0110a> f5471d = new HashMap();

        /* renamed from: c.b.d.q$a$a  reason: collision with other inner class name */
        public static class C0110a {

            /* renamed from: a  reason: collision with root package name */
            public final s.b f5472a;

            /* renamed from: b  reason: collision with root package name */
            public final int f5473b;

            /* renamed from: c  reason: collision with root package name */
            public int f5474c;

            /* renamed from: d  reason: collision with root package name */
            public b f5475d = null;

            public C0110a(s.b bVar, int i) {
                this.f5472a = bVar;
                this.f5473b = i;
                this.f5474c = i;
            }
        }

        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public final List<s.b> f5476a = new ArrayList();

            /* renamed from: b  reason: collision with root package name */
            public boolean f5477b = false;

            public b(o oVar) {
            }
        }

        public final C0110a a(s.b bVar) {
            C0110a pop;
            boolean z;
            b bVar2;
            int min;
            int i = this.f5469b;
            this.f5469b = i + 1;
            C0110a aVar = new C0110a(bVar, i);
            this.f5470c.push(aVar);
            this.f5471d.put(bVar, aVar);
            for (s.g gVar : bVar.p()) {
                if (gVar.f5823g.f5835b == s.g.a.MESSAGE) {
                    C0110a aVar2 = this.f5471d.get(gVar.p());
                    if (aVar2 == null) {
                        min = Math.min(aVar.f5474c, a(gVar.p()).f5474c);
                    } else if (aVar2.f5475d == null) {
                        min = Math.min(aVar.f5474c, aVar2.f5474c);
                    }
                    aVar.f5474c = min;
                }
            }
            if (aVar.f5473b == aVar.f5474c) {
                b bVar3 = new b(null);
                do {
                    pop = this.f5470c.pop();
                    pop.f5475d = bVar3;
                    bVar3.f5476a.add(pop.f5472a);
                } while (pop != aVar);
                Iterator<s.b> it = bVar3.f5476a.iterator();
                loop2:
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    s.b next = it.next();
                    if (next.f5788a.h.size() != 0) {
                        z = true;
                    }
                    if (z) {
                        break;
                    }
                    Iterator<s.g> it2 = next.p().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            s.g next2 = it2.next();
                            if (next2.y() || (next2.f5823g.f5835b == s.g.a.MESSAGE && (bVar2 = this.f5471d.get(next2.p()).f5475d) != bVar3 && bVar2.f5477b)) {
                                break loop2;
                            }
                        }
                    }
                }
                z = true;
                bVar3.f5477b = z;
                for (s.b bVar4 : bVar3.f5476a) {
                    this.f5468a.put(bVar4, Boolean.valueOf(bVar3.f5477b));
                }
            }
            return aVar;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public v1[] f5478a = new v1[2];

        public b(o oVar) {
        }
    }

    public static e0 c(Class<?> cls, s.g gVar, b bVar, boolean z, n0.d dVar) {
        Class<?> cls2;
        s.k kVar = gVar.j;
        int i = kVar.f5851a;
        v1[] v1VarArr = bVar.f5478a;
        if (i >= v1VarArr.length) {
            bVar.f5478a = (v1[]) Arrays.copyOf(v1VarArr, i * 2);
        }
        v1 v1Var = bVar.f5478a[i];
        if (v1Var == null) {
            String k = k(kVar.f5852b.a());
            v1 v1Var2 = new v1(kVar.f5851a, f(cls, c.a.a.a.a.q(k, "Case_")), f(cls, c.a.a.a.a.q(k, "_")));
            bVar.f5478a[i] = v1Var2;
            v1Var = v1Var2;
        }
        g0 h = h(gVar);
        boolean z2 = false;
        switch (h.f5279b.ordinal()) {
            case 1:
            case 8:
                cls2 = Integer.class;
                break;
            case 2:
                cls2 = Long.class;
                break;
            case 3:
                cls2 = Float.class;
                break;
            case 4:
                cls2 = Double.class;
                break;
            case 5:
                cls2 = Boolean.class;
                break;
            case 6:
                cls2 = String.class;
                break;
            case 7:
                cls2 = j.class;
                break;
            case 9:
                try {
                    cls2 = cls.getDeclaredMethod(j(gVar.f5823g == s.g.b.GROUP ? gVar.p().f() : gVar.f()), new Class[0]).getReturnType();
                    break;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            default:
                throw new IllegalArgumentException("Invalid type for oneof: " + h);
        }
        int i2 = gVar.f5819c.f5594d;
        e0.b(i2);
        n0.b(h, "fieldType");
        n0.b(v1Var, "oneof");
        n0.b(cls2, "oneofStoredType");
        if (h.f5281d == g0.a.SCALAR) {
            z2 = true;
        }
        if (z2) {
            return new e0(null, i2, h, null, null, 0, false, z, v1Var, cls2, null, dVar, null);
        }
        throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + i2 + " is of type " + h);
    }

    public static Field d(Class<?> cls, s.g gVar) {
        return f(cls, k(gVar.f()) + "MemoizedSerializedSize");
    }

    public static Field e(Class<?> cls, s.g gVar) {
        String f2 = gVar.f5823g == s.g.b.GROUP ? gVar.p().f() : gVar.f();
        String str = f5466a.contains(f2) ? "__" : "_";
        return f(cls, k(f2) + str);
    }

    public static Field f(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unable to find field " + str + " in message class " + cls.getName());
        }
    }

    public static f1 g(Class<?> cls) {
        try {
            return (f1) cls.getDeclaredMethod("getDefaultInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            StringBuilder h = c.a.a.a.a.h("Unable to get default instance for message class ");
            h.append(cls.getName());
            throw new IllegalArgumentException(h.toString(), e2);
        }
    }

    public static g0 h(s.g gVar) {
        switch (gVar.f5823g.ordinal()) {
            case 0:
                if (!gVar.e()) {
                    return g0.DOUBLE;
                }
                return gVar.l() ? g0.DOUBLE_LIST_PACKED : g0.DOUBLE_LIST;
            case 1:
                if (!gVar.e()) {
                    return g0.FLOAT;
                }
                return gVar.l() ? g0.FLOAT_LIST_PACKED : g0.FLOAT_LIST;
            case 2:
                if (!gVar.e()) {
                    return g0.INT64;
                }
                return gVar.l() ? g0.INT64_LIST_PACKED : g0.INT64_LIST;
            case 3:
                if (!gVar.e()) {
                    return g0.UINT64;
                }
                return gVar.l() ? g0.UINT64_LIST_PACKED : g0.UINT64_LIST;
            case 4:
                if (!gVar.e()) {
                    return g0.INT32;
                }
                return gVar.l() ? g0.INT32_LIST_PACKED : g0.INT32_LIST;
            case 5:
                if (!gVar.e()) {
                    return g0.FIXED64;
                }
                return gVar.l() ? g0.FIXED64_LIST_PACKED : g0.FIXED64_LIST;
            case 6:
                if (!gVar.e()) {
                    return g0.FIXED32;
                }
                return gVar.l() ? g0.FIXED32_LIST_PACKED : g0.FIXED32_LIST;
            case 7:
                if (!gVar.e()) {
                    return g0.BOOL;
                }
                return gVar.l() ? g0.BOOL_LIST_PACKED : g0.BOOL_LIST;
            case 8:
                return gVar.e() ? g0.STRING_LIST : g0.STRING;
            case 9:
                return gVar.e() ? g0.GROUP_LIST : g0.GROUP;
            case 10:
                if (gVar.t()) {
                    return g0.MAP;
                }
                return gVar.e() ? g0.MESSAGE_LIST : g0.MESSAGE;
            case 11:
                return gVar.e() ? g0.BYTES_LIST : g0.BYTES;
            case 12:
                if (!gVar.e()) {
                    return g0.UINT32;
                }
                return gVar.l() ? g0.UINT32_LIST_PACKED : g0.UINT32_LIST;
            case 13:
                if (!gVar.e()) {
                    return g0.ENUM;
                }
                return gVar.l() ? g0.ENUM_LIST_PACKED : g0.ENUM_LIST;
            case 14:
                if (!gVar.e()) {
                    return g0.SFIXED32;
                }
                return gVar.l() ? g0.SFIXED32_LIST_PACKED : g0.SFIXED32_LIST;
            case 15:
                if (!gVar.e()) {
                    return g0.SFIXED64;
                }
                return gVar.l() ? g0.SFIXED64_LIST_PACKED : g0.SFIXED64_LIST;
            case 16:
                if (!gVar.e()) {
                    return g0.SINT32;
                }
                return gVar.l() ? g0.SINT32_LIST_PACKED : g0.SINT32_LIST;
            case 17:
                if (!gVar.e()) {
                    return g0.SINT64;
                }
                return gVar.l() ? g0.SINT64_LIST_PACKED : g0.SINT64_LIST;
            default:
                StringBuilder h = c.a.a.a.a.h("Unsupported field type: ");
                h.append(gVar.f5823g);
                throw new IllegalArgumentException(h.toString());
        }
    }

    public static Class<?> i(Class<?> cls, s.g gVar) {
        try {
            return cls.getDeclaredMethod(j(gVar.f5823g == s.g.b.GROUP ? gVar.p().f() : gVar.f()), Integer.TYPE).getReturnType();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String j(String str) {
        String k = k(str);
        return "get" + Character.toUpperCase(k.charAt(0)) + k.substring(1, k.length());
    }

    public static String k(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 1);
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '_') {
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                } else {
                    if (z) {
                        sb.append(Character.toUpperCase(charAt));
                        z = false;
                    } else {
                        if (i == 0) {
                            charAt = Character.toLowerCase(charAt);
                        }
                        sb.append(charAt);
                    }
                }
            }
            z = true;
        }
        return sb.toString();
    }

    @Override // c.b.d.h1
    public boolean a(Class<?> cls) {
        return l0.class.isAssignableFrom(cls);
    }

    @Override // c.b.d.h1
    public g1 b(Class<?> cls) {
        boolean z;
        f1 f1Var;
        b bVar;
        e0 e0Var;
        e0 e0Var2;
        e0 e0Var3;
        e0 e0Var4;
        if (l0.class.isAssignableFrom(cls)) {
            s.b descriptorForType = g(cls).getDescriptorForType();
            int ordinal = descriptorForType.f5790c.p().ordinal();
            Field field = null;
            int i = 0;
            int i2 = 1;
            if (ordinal == 1) {
                List<s.g> p = descriptorForType.p();
                ArrayList arrayList = new ArrayList(p.size());
                f1 g2 = g(cls);
                y1 y1Var = y1.PROTO2;
                n0.b(y1Var, "syntax");
                boolean z2 = descriptorForType.s().f5663d;
                b bVar2 = new b(null);
                int i3 = 0;
                while (i < p.size()) {
                    s.g gVar = p.get(i);
                    boolean z3 = gVar.f5821e.f5836a.e().h;
                    n0.d oVar = gVar.f5823g.f5835b == s.g.a.ENUM ? new o(gVar) : null;
                    if (gVar.j != null) {
                        arrayList.add(c(cls, gVar, bVar2, z3, oVar));
                        bVar = bVar2;
                        f1Var = g2;
                    } else {
                        Field e2 = e(cls, gVar);
                        int i4 = gVar.f5819c.f5594d;
                        bVar = bVar2;
                        g0 h = h(gVar);
                        if (gVar.t()) {
                            s.g n = gVar.p().n(2);
                            f1Var = g2;
                            if (n.f5823g.f5835b == s.g.a.ENUM) {
                                oVar = new p(n);
                            }
                            e0Var = e0.f(e2, i4, f2.A(cls, gVar.f()), oVar);
                        } else {
                            f1Var = g2;
                            if (!gVar.e()) {
                                if (field == null) {
                                    field = f(cls, "bitField" + i3 + "_");
                                }
                                if (gVar.y()) {
                                    e0.b(i4);
                                    n0.b(e2, "field");
                                    n0.b(h, "fieldType");
                                    n0.b(field, "presenceField");
                                    if (i2 != 0 && ((i2 + -1) & i2) == 0) {
                                        e0Var2 = new e0(e2, i4, h, null, field, i2, true, z3, null, null, null, oVar, null);
                                    } else {
                                        throw new IllegalArgumentException(c.a.a.a.a.n("presenceMask must have exactly one bit set: ", i2));
                                    }
                                } else {
                                    e0.b(i4);
                                    n0.b(e2, "field");
                                    n0.b(h, "fieldType");
                                    n0.b(field, "presenceField");
                                    if (i2 != 0 && ((i2 + -1) & i2) == 0) {
                                        e0Var2 = new e0(e2, i4, h, null, field, i2, false, z3, null, null, null, oVar, null);
                                    } else {
                                        throw new IllegalArgumentException(c.a.a.a.a.n("presenceMask must have exactly one bit set: ", i2));
                                    }
                                }
                                arrayList.add(e0Var2);
                            } else if (oVar != null) {
                                if (gVar.l()) {
                                    Field d2 = d(cls, gVar);
                                    e0.b(i4);
                                    n0.b(e2, "field");
                                    e0Var3 = new e0(e2, i4, h, null, null, 0, false, false, null, null, null, oVar, d2);
                                } else {
                                    e0.b(i4);
                                    n0.b(e2, "field");
                                    e0Var3 = new e0(e2, i4, h, null, null, 0, false, false, null, null, null, oVar, null);
                                }
                                e0Var = e0Var3;
                            } else {
                                e0Var = gVar.f5823g.f5835b == s.g.a.MESSAGE ? e0.k(e2, i4, h, i(cls, gVar)) : gVar.l() ? e0.i(e2, i4, h, d(cls, gVar)) : e0.d(e2, i4, h, z3);
                            }
                        }
                        arrayList.add(e0Var);
                        i++;
                        bVar2 = bVar;
                        g2 = f1Var;
                    }
                    int i5 = i2 << 1;
                    if (i5 == 0) {
                        i3++;
                        i5 = 1;
                        field = null;
                    }
                    i2 = i5;
                    i++;
                    bVar2 = bVar;
                    g2 = f1Var;
                }
                ArrayList arrayList2 = new ArrayList();
                for (int i6 = 0; i6 < p.size(); i6++) {
                    s.g gVar2 = p.get(i6);
                    if (!gVar2.y()) {
                        if (gVar2.f5823g.f5835b == s.g.a.MESSAGE) {
                            s.b p2 = gVar2.p();
                            a aVar = f5467b;
                            Boolean bool = aVar.f5468a.get(p2);
                            if (bool != null) {
                                z = bool.booleanValue();
                            } else {
                                synchronized (aVar) {
                                    Boolean bool2 = aVar.f5468a.get(p2);
                                    z = bool2 != null ? bool2.booleanValue() : aVar.a(p2).f5475d.f5477b;
                                }
                            }
                            if (z) {
                            }
                        } else {
                            continue;
                        }
                    }
                    arrayList2.add(Integer.valueOf(gVar2.f5819c.f5594d));
                }
                int[] iArr = new int[arrayList2.size()];
                for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                    iArr[i7] = ((Integer) arrayList2.get(i7)).intValue();
                }
                Collections.sort(arrayList);
                return new i2(y1Var, z2, iArr, (e0[]) arrayList.toArray(new e0[0]), g2);
            } else if (ordinal == 2) {
                List<s.g> p3 = descriptorForType.p();
                ArrayList arrayList3 = new ArrayList(p3.size());
                f1 g3 = g(cls);
                y1 y1Var2 = y1.PROTO3;
                n0.b(y1Var2, "syntax");
                b bVar3 = new b(null);
                for (int i8 = 0; i8 < p3.size(); i8++) {
                    s.g gVar3 = p3.get(i8);
                    if (gVar3.j != null) {
                        e0Var4 = c(cls, gVar3, bVar3, true, null);
                    } else if (gVar3.t()) {
                        e0Var4 = e0.f(e(cls, gVar3), gVar3.f5819c.f5594d, f2.A(cls, gVar3.f()), null);
                    } else if (gVar3.e() && gVar3.f5823g.f5835b == s.g.a.MESSAGE) {
                        e0Var4 = e0.k(e(cls, gVar3), gVar3.f5819c.f5594d, h(gVar3), i(cls, gVar3));
                    } else if (gVar3.l()) {
                        e0Var4 = e0.i(e(cls, gVar3), gVar3.f5819c.f5594d, h(gVar3), d(cls, gVar3));
                    } else {
                        e0Var4 = e0.d(e(cls, gVar3), gVar3.f5819c.f5594d, h(gVar3), true);
                    }
                    arrayList3.add(e0Var4);
                }
                Collections.sort(arrayList3);
                return new i2(y1Var2, false, null, (e0[]) arrayList3.toArray(new e0[0]), g3);
            } else {
                StringBuilder h2 = c.a.a.a.a.h("Unsupported syntax: ");
                h2.append(descriptorForType.f5790c.p());
                throw new IllegalArgumentException(h2.toString());
            }
        } else {
            StringBuilder h3 = c.a.a.a.a.h("Unsupported message type: ");
            h3.append(cls.getName());
            throw new IllegalArgumentException(h3.toString());
        }
    }
}
