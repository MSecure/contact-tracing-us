package c.b.d;

import c.b.d.g0;
import c.b.d.m0;
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

public final class q implements g1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f4039a = new HashSet(Arrays.asList("cached_size", "serialized_size", "class"));

    /* renamed from: b  reason: collision with root package name */
    public static a f4040b = new a();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<s.b, Boolean> f4041a = new ConcurrentHashMap();

        /* renamed from: b  reason: collision with root package name */
        public int f4042b = 0;

        /* renamed from: c  reason: collision with root package name */
        public final Stack<C0101a> f4043c = new Stack<>();

        /* renamed from: d  reason: collision with root package name */
        public final Map<s.b, C0101a> f4044d = new HashMap();

        /* renamed from: c.b.d.q$a$a  reason: collision with other inner class name */
        public static class C0101a {

            /* renamed from: a  reason: collision with root package name */
            public final s.b f4045a;

            /* renamed from: b  reason: collision with root package name */
            public final int f4046b;

            /* renamed from: c  reason: collision with root package name */
            public int f4047c;

            /* renamed from: d  reason: collision with root package name */
            public b f4048d = null;

            public C0101a(s.b bVar, int i) {
                this.f4045a = bVar;
                this.f4046b = i;
                this.f4047c = i;
            }
        }

        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public final List<s.b> f4049a = new ArrayList();

            /* renamed from: b  reason: collision with root package name */
            public boolean f4050b = false;

            public b(o oVar) {
            }
        }

        public final C0101a a(s.b bVar) {
            C0101a pop;
            boolean z;
            b bVar2;
            int min;
            int i = this.f4042b;
            this.f4042b = i + 1;
            C0101a aVar = new C0101a(bVar, i);
            this.f4043c.push(aVar);
            this.f4044d.put(bVar, aVar);
            for (s.g gVar : bVar.n()) {
                if (gVar.g.f4303b == s.g.a.MESSAGE) {
                    C0101a aVar2 = this.f4044d.get(gVar.n());
                    if (aVar2 == null) {
                        min = Math.min(aVar.f4047c, a(gVar.n()).f4047c);
                    } else if (aVar2.f4048d == null) {
                        min = Math.min(aVar.f4047c, aVar2.f4047c);
                    }
                    aVar.f4047c = min;
                }
            }
            if (aVar.f4046b == aVar.f4047c) {
                b bVar3 = new b(null);
                do {
                    pop = this.f4043c.pop();
                    pop.f4048d = bVar3;
                    bVar3.f4049a.add(pop.f4045a);
                } while (pop != aVar);
                Iterator<s.b> it = bVar3.f4049a.iterator();
                loop2:
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    s.b next = it.next();
                    if (next.f4264a.h.size() != 0) {
                        z = true;
                    }
                    if (z) {
                        break;
                    }
                    Iterator<s.g> it2 = next.n().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            s.g next2 = it2.next();
                            if (next2.t() || (next2.g.f4303b == s.g.a.MESSAGE && (bVar2 = this.f4044d.get(next2.n()).f4048d) != bVar3 && bVar2.f4050b)) {
                                break loop2;
                            }
                        }
                    }
                }
                z = true;
                bVar3.f4050b = z;
                for (s.b bVar4 : bVar3.f4049a) {
                    this.f4041a.put(bVar4, Boolean.valueOf(bVar3.f4050b));
                }
            }
            return aVar;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public u1[] f4051a = new u1[2];

        public b(o oVar) {
        }
    }

    public static e0 c(Class<?> cls, s.g gVar, b bVar, boolean z, m0.d dVar) {
        Class<?> cls2;
        s.k kVar = gVar.j;
        int i = kVar.f4316a;
        u1[] u1VarArr = bVar.f4051a;
        if (i >= u1VarArr.length) {
            bVar.f4051a = (u1[]) Arrays.copyOf(u1VarArr, i * 2);
        }
        u1 u1Var = bVar.f4051a[i];
        if (u1Var == null) {
            String k = k(kVar.f4317b.a());
            u1 u1Var2 = new u1(kVar.f4316a, f(cls, c.a.a.a.a.o(k, "Case_")), f(cls, c.a.a.a.a.o(k, "_")));
            bVar.f4051a[i] = u1Var2;
            u1Var = u1Var2;
        }
        g0 h = h(gVar);
        boolean z2 = false;
        switch (h.f3874b.ordinal()) {
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
                    cls2 = cls.getDeclaredMethod(j(gVar.g == s.g.b.GROUP ? gVar.n().f() : gVar.f()), new Class[0]).getReturnType();
                    break;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            default:
                throw new IllegalArgumentException("Invalid type for oneof: " + h);
        }
        int i2 = gVar.f4293c.f4132d;
        e0.b(i2);
        m0.b(h, "fieldType");
        m0.b(u1Var, "oneof");
        m0.b(cls2, "oneofStoredType");
        if (h.f3876d == g0.a.SCALAR) {
            z2 = true;
        }
        if (z2) {
            return new e0(null, i2, h, null, null, 0, false, z, u1Var, cls2, null, dVar, null);
        }
        throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + i2 + " is of type " + h);
    }

    public static Field d(Class<?> cls, s.g gVar) {
        return f(cls, k(gVar.f()) + "MemoizedSerializedSize");
    }

    public static Field e(Class<?> cls, s.g gVar) {
        String f = gVar.g == s.g.b.GROUP ? gVar.n().f() : gVar.f();
        String str = f4039a.contains(f) ? "__" : "_";
        return f(cls, k(f) + str);
    }

    public static Field f(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unable to find field " + str + " in message class " + cls.getName());
        }
    }

    public static e1 g(Class<?> cls) {
        try {
            return (e1) cls.getDeclaredMethod("getDefaultInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            StringBuilder g = c.a.a.a.a.g("Unable to get default instance for message class ");
            g.append(cls.getName());
            throw new IllegalArgumentException(g.toString(), e2);
        }
    }

    public static g0 h(s.g gVar) {
        switch (gVar.g.ordinal()) {
            case 0:
                if (!gVar.c()) {
                    return g0.DOUBLE;
                }
                return gVar.j() ? g0.DOUBLE_LIST_PACKED : g0.DOUBLE_LIST;
            case 1:
                if (!gVar.c()) {
                    return g0.FLOAT;
                }
                return gVar.j() ? g0.FLOAT_LIST_PACKED : g0.FLOAT_LIST;
            case 2:
                if (!gVar.c()) {
                    return g0.INT64;
                }
                return gVar.j() ? g0.INT64_LIST_PACKED : g0.INT64_LIST;
            case 3:
                if (!gVar.c()) {
                    return g0.UINT64;
                }
                return gVar.j() ? g0.UINT64_LIST_PACKED : g0.UINT64_LIST;
            case 4:
                if (!gVar.c()) {
                    return g0.INT32;
                }
                return gVar.j() ? g0.INT32_LIST_PACKED : g0.INT32_LIST;
            case 5:
                if (!gVar.c()) {
                    return g0.FIXED64;
                }
                return gVar.j() ? g0.FIXED64_LIST_PACKED : g0.FIXED64_LIST;
            case 6:
                if (!gVar.c()) {
                    return g0.FIXED32;
                }
                return gVar.j() ? g0.FIXED32_LIST_PACKED : g0.FIXED32_LIST;
            case 7:
                if (!gVar.c()) {
                    return g0.BOOL;
                }
                return gVar.j() ? g0.BOOL_LIST_PACKED : g0.BOOL_LIST;
            case 8:
                return gVar.c() ? g0.STRING_LIST : g0.STRING;
            case 9:
                return gVar.c() ? g0.GROUP_LIST : g0.GROUP;
            case 10:
                if (gVar.q()) {
                    return g0.MAP;
                }
                return gVar.c() ? g0.MESSAGE_LIST : g0.MESSAGE;
            case 11:
                return gVar.c() ? g0.BYTES_LIST : g0.BYTES;
            case 12:
                if (!gVar.c()) {
                    return g0.UINT32;
                }
                return gVar.j() ? g0.UINT32_LIST_PACKED : g0.UINT32_LIST;
            case 13:
                if (!gVar.c()) {
                    return g0.ENUM;
                }
                return gVar.j() ? g0.ENUM_LIST_PACKED : g0.ENUM_LIST;
            case 14:
                if (!gVar.c()) {
                    return g0.SFIXED32;
                }
                return gVar.j() ? g0.SFIXED32_LIST_PACKED : g0.SFIXED32_LIST;
            case 15:
                if (!gVar.c()) {
                    return g0.SFIXED64;
                }
                return gVar.j() ? g0.SFIXED64_LIST_PACKED : g0.SFIXED64_LIST;
            case 16:
                if (!gVar.c()) {
                    return g0.SINT32;
                }
                return gVar.j() ? g0.SINT32_LIST_PACKED : g0.SINT32_LIST;
            case 17:
                if (!gVar.c()) {
                    return g0.SINT64;
                }
                return gVar.j() ? g0.SINT64_LIST_PACKED : g0.SINT64_LIST;
            default:
                StringBuilder g = c.a.a.a.a.g("Unsupported field type: ");
                g.append(gVar.g);
                throw new IllegalArgumentException(g.toString());
        }
    }

    public static Class<?> i(Class<?> cls, s.g gVar) {
        try {
            return cls.getDeclaredMethod(j(gVar.g == s.g.b.GROUP ? gVar.n().f() : gVar.f()), Integer.TYPE).getReturnType();
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

    @Override // c.b.d.g1
    public boolean a(Class<?> cls) {
        return k0.class.isAssignableFrom(cls);
    }

    @Override // c.b.d.g1
    public f1 b(Class<?> cls) {
        boolean z;
        e1 e1Var;
        b bVar;
        e0 e0Var;
        e0 e0Var2;
        e0 e0Var3;
        e0 e0Var4;
        if (k0.class.isAssignableFrom(cls)) {
            s.b descriptorForType = g(cls).getDescriptorForType();
            int ordinal = descriptorForType.f4266c.n().ordinal();
            Field field = null;
            int i = 0;
            int i2 = 1;
            if (ordinal == 1) {
                List<s.g> n = descriptorForType.n();
                ArrayList arrayList = new ArrayList(n.size());
                e1 g = g(cls);
                x1 x1Var = x1.PROTO2;
                m0.b(x1Var, "syntax");
                boolean z2 = descriptorForType.p().f4179d;
                b bVar2 = new b(null);
                int i3 = 0;
                while (i < n.size()) {
                    s.g gVar = n.get(i);
                    boolean z3 = gVar.f4295e.f4304a.e().h;
                    m0.d oVar = gVar.g.f4303b == s.g.a.ENUM ? new o(gVar) : null;
                    if (gVar.j != null) {
                        arrayList.add(c(cls, gVar, bVar2, z3, oVar));
                        bVar = bVar2;
                        e1Var = g;
                    } else {
                        Field e2 = e(cls, gVar);
                        int i4 = gVar.f4293c.f4132d;
                        bVar = bVar2;
                        g0 h = h(gVar);
                        if (gVar.q()) {
                            s.g l = gVar.n().l(2);
                            e1Var = g;
                            if (l.g.f4303b == s.g.a.ENUM) {
                                oVar = new p(l);
                            }
                            e0Var = e0.f(e2, i4, e2.A(cls, gVar.f()), oVar);
                        } else {
                            e1Var = g;
                            if (!gVar.c()) {
                                if (field == null) {
                                    field = f(cls, "bitField" + i3 + "_");
                                }
                                if (gVar.t()) {
                                    e0.b(i4);
                                    m0.b(e2, "field");
                                    m0.b(h, "fieldType");
                                    m0.b(field, "presenceField");
                                    if (i2 != 0 && ((i2 + -1) & i2) == 0) {
                                        e0Var2 = new e0(e2, i4, h, null, field, i2, true, z3, null, null, null, oVar, null);
                                    } else {
                                        throw new IllegalArgumentException(c.a.a.a.a.l("presenceMask must have exactly one bit set: ", i2));
                                    }
                                } else {
                                    e0.b(i4);
                                    m0.b(e2, "field");
                                    m0.b(h, "fieldType");
                                    m0.b(field, "presenceField");
                                    if (i2 != 0 && ((i2 + -1) & i2) == 0) {
                                        e0Var2 = new e0(e2, i4, h, null, field, i2, false, z3, null, null, null, oVar, null);
                                    } else {
                                        throw new IllegalArgumentException(c.a.a.a.a.l("presenceMask must have exactly one bit set: ", i2));
                                    }
                                }
                                arrayList.add(e0Var2);
                            } else if (oVar != null) {
                                if (gVar.j()) {
                                    Field d2 = d(cls, gVar);
                                    e0.b(i4);
                                    m0.b(e2, "field");
                                    e0Var3 = new e0(e2, i4, h, null, null, 0, false, false, null, null, null, oVar, d2);
                                } else {
                                    e0.b(i4);
                                    m0.b(e2, "field");
                                    e0Var3 = new e0(e2, i4, h, null, null, 0, false, false, null, null, null, oVar, null);
                                }
                                e0Var = e0Var3;
                            } else {
                                e0Var = gVar.g.f4303b == s.g.a.MESSAGE ? e0.i(e2, i4, h, i(cls, gVar)) : gVar.j() ? e0.g(e2, i4, h, d(cls, gVar)) : e0.d(e2, i4, h, z3);
                            }
                        }
                        arrayList.add(e0Var);
                        i++;
                        bVar2 = bVar;
                        g = e1Var;
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
                    g = e1Var;
                }
                ArrayList arrayList2 = new ArrayList();
                for (int i6 = 0; i6 < n.size(); i6++) {
                    s.g gVar2 = n.get(i6);
                    if (!gVar2.t()) {
                        if (gVar2.g.f4303b == s.g.a.MESSAGE) {
                            s.b n2 = gVar2.n();
                            a aVar = f4040b;
                            Boolean bool = aVar.f4041a.get(n2);
                            if (bool != null) {
                                z = bool.booleanValue();
                            } else {
                                synchronized (aVar) {
                                    Boolean bool2 = aVar.f4041a.get(n2);
                                    z = bool2 != null ? bool2.booleanValue() : aVar.a(n2).f4048d.f4050b;
                                }
                            }
                            if (z) {
                            }
                        } else {
                            continue;
                        }
                    }
                    arrayList2.add(Integer.valueOf(gVar2.f4293c.f4132d));
                }
                int[] iArr = new int[arrayList2.size()];
                for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                    iArr[i7] = ((Integer) arrayList2.get(i7)).intValue();
                }
                Collections.sort(arrayList);
                return new h2(x1Var, z2, iArr, (e0[]) arrayList.toArray(new e0[0]), g);
            } else if (ordinal == 2) {
                List<s.g> n3 = descriptorForType.n();
                ArrayList arrayList3 = new ArrayList(n3.size());
                e1 g2 = g(cls);
                x1 x1Var2 = x1.PROTO3;
                m0.b(x1Var2, "syntax");
                b bVar3 = new b(null);
                for (int i8 = 0; i8 < n3.size(); i8++) {
                    s.g gVar3 = n3.get(i8);
                    if (gVar3.j != null) {
                        e0Var4 = c(cls, gVar3, bVar3, true, null);
                    } else if (gVar3.q()) {
                        e0Var4 = e0.f(e(cls, gVar3), gVar3.f4293c.f4132d, e2.A(cls, gVar3.f()), null);
                    } else if (gVar3.c() && gVar3.g.f4303b == s.g.a.MESSAGE) {
                        e0Var4 = e0.i(e(cls, gVar3), gVar3.f4293c.f4132d, h(gVar3), i(cls, gVar3));
                    } else if (gVar3.j()) {
                        e0Var4 = e0.g(e(cls, gVar3), gVar3.f4293c.f4132d, h(gVar3), d(cls, gVar3));
                    } else {
                        e0Var4 = e0.d(e(cls, gVar3), gVar3.f4293c.f4132d, h(gVar3), true);
                    }
                    arrayList3.add(e0Var4);
                }
                Collections.sort(arrayList3);
                return new h2(x1Var2, false, null, (e0[]) arrayList3.toArray(new e0[0]), g2);
            } else {
                StringBuilder g3 = c.a.a.a.a.g("Unsupported syntax: ");
                g3.append(descriptorForType.f4266c.n());
                throw new IllegalArgumentException(g3.toString());
            }
        } else {
            StringBuilder g4 = c.a.a.a.a.g("Unsupported message type: ");
            g4.append(cls.getName());
            throw new IllegalArgumentException(g4.toString());
        }
    }
}
