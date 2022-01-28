package c.b.d;

import c.b.d.e1;
import c.b.d.f0;
import c.b.d.h1;
import c.b.d.i2;
import c.b.d.m0;
import c.b.d.r;
import c.b.d.w2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Logger;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f4263a = Logger.getLogger(s.class.getName());

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final Set<h> f4269a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        public boolean f4270b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, i> f4271c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        public final Map<a, g> f4272d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        public final Map<a, f> f4273e = new HashMap();

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public final i f4274a;

            /* renamed from: b  reason: collision with root package name */
            public final int f4275b;

            public a(i iVar, int i) {
                this.f4274a = iVar;
                this.f4275b = i;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.f4274a == aVar.f4274a && this.f4275b == aVar.f4275b;
            }

            public int hashCode() {
                return (this.f4274a.hashCode() * 65535) + this.f4275b;
            }
        }

        public static final class b extends i {

            /* renamed from: a  reason: collision with root package name */
            public final String f4276a;

            /* renamed from: b  reason: collision with root package name */
            public final String f4277b;

            /* renamed from: c  reason: collision with root package name */
            public final h f4278c;

            public b(String str, String str2, h hVar) {
                super(null);
                this.f4278c = hVar;
                this.f4277b = str2;
                this.f4276a = str;
            }

            @Override // c.b.d.s.i
            public h b() {
                return this.f4278c;
            }

            @Override // c.b.d.s.i
            public String d() {
                return this.f4277b;
            }

            @Override // c.b.d.s.i
            public String f() {
                return this.f4276a;
            }

            @Override // c.b.d.s.i
            public e1 g() {
                return this.f4278c.f4304a;
            }
        }

        /* renamed from: c.b.d.s$c$c  reason: collision with other inner class name */
        public enum EnumC0107c {
            TYPES_ONLY,
            AGGREGATES_ONLY,
            ALL_SYMBOLS
        }

        public c(h[] hVarArr, boolean z) {
            this.f4270b = z;
            for (int i = 0; i < hVarArr.length; i++) {
                this.f4269a.add(hVarArr[i]);
                d(hVarArr[i]);
            }
            for (h hVar : this.f4269a) {
                try {
                    a(hVar.l(), hVar);
                } catch (d e2) {
                    throw new AssertionError(e2);
                }
            }
        }

        public void a(String str, h hVar) {
            String str2;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf == -1) {
                str2 = str;
            } else {
                a(str.substring(0, lastIndexOf), hVar);
                str2 = str.substring(lastIndexOf + 1);
            }
            i put = this.f4271c.put(str, new b(str2, str, hVar));
            if (put != null) {
                this.f4271c.put(str, put);
                if (!(put instanceof b)) {
                    throw new d(hVar, '\"' + str2 + "\" is already defined (as something other than a package) in file \"" + put.b().f() + "\".", null);
                }
            }
        }

        public void b(i iVar) {
            String f = iVar.f();
            if (f.length() != 0) {
                for (int i = 0; i < f.length(); i++) {
                    char charAt = f.charAt(i);
                    if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && charAt != '_' && ('0' > charAt || charAt > '9' || i <= 0))) {
                        throw new d(iVar, '\"' + f + "\" is not a valid identifier.");
                    }
                }
                String d2 = iVar.d();
                i put = this.f4271c.put(d2, iVar);
                if (put != null) {
                    this.f4271c.put(d2, put);
                    if (iVar.b() == put.b()) {
                        int lastIndexOf = d2.lastIndexOf(46);
                        if (lastIndexOf == -1) {
                            throw new d(iVar, '\"' + d2 + "\" is already defined.");
                        }
                        StringBuilder f2 = c.a.a.a.a.f('\"');
                        f2.append(d2.substring(lastIndexOf + 1));
                        f2.append("\" is already defined in \"");
                        f2.append(d2.substring(0, lastIndexOf));
                        f2.append("\".");
                        throw new d(iVar, f2.toString());
                    }
                    throw new d(iVar, '\"' + d2 + "\" is already defined in file \"" + put.b().f() + "\".");
                }
                return;
            }
            throw new d(iVar, "Missing name.");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
            if (((r3 instanceof c.b.d.s.b) || (r3 instanceof c.b.d.s.e)) == false) goto L_0x0024;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
            if (e(r3) != false) goto L_0x002c;
         */
        public i c(String str, EnumC0107c cVar) {
            EnumC0107c cVar2 = EnumC0107c.AGGREGATES_ONLY;
            EnumC0107c cVar3 = EnumC0107c.TYPES_ONLY;
            EnumC0107c cVar4 = EnumC0107c.ALL_SYMBOLS;
            i iVar = this.f4271c.get(str);
            if (iVar != null) {
                if (cVar != cVar4) {
                    if (cVar == cVar3) {
                    }
                    if (cVar == cVar2) {
                    }
                }
                return iVar;
            }
            for (h hVar : this.f4269a) {
                i iVar2 = hVar.g.f4271c.get(str);
                if (iVar2 != null) {
                    if (cVar != cVar4) {
                        if (cVar == cVar3) {
                            if ((iVar2 instanceof b) || (iVar2 instanceof e)) {
                            }
                        }
                        if (cVar == cVar2 && e(iVar2)) {
                        }
                    }
                    return iVar2;
                }
            }
            return null;
        }

        public final void d(h hVar) {
            for (h hVar2 : Collections.unmodifiableList(Arrays.asList(hVar.f))) {
                if (this.f4269a.add(hVar2)) {
                    d(hVar2);
                }
            }
        }

        public boolean e(i iVar) {
            return (iVar instanceof b) || (iVar instanceof e) || (iVar instanceof b) || (iVar instanceof l);
        }

        public i f(String str, i iVar, EnumC0107c cVar) {
            i iVar2;
            String str2;
            if (str.startsWith(".")) {
                str2 = str.substring(1);
                iVar2 = c(str2, cVar);
            } else {
                int indexOf = str.indexOf(46);
                String substring = indexOf == -1 ? str : str.substring(0, indexOf);
                StringBuilder sb = new StringBuilder(iVar.d());
                while (true) {
                    int lastIndexOf = sb.lastIndexOf(".");
                    if (lastIndexOf == -1) {
                        iVar2 = c(str, cVar);
                        str2 = str;
                        break;
                    }
                    int i = lastIndexOf + 1;
                    sb.setLength(i);
                    sb.append(substring);
                    i c2 = c(sb.toString(), EnumC0107c.AGGREGATES_ONLY);
                    if (c2 != null) {
                        if (indexOf != -1) {
                            sb.setLength(i);
                            sb.append(str);
                            iVar2 = c(sb.toString(), cVar);
                        } else {
                            iVar2 = c2;
                        }
                        str2 = sb.toString();
                    } else {
                        sb.setLength(lastIndexOf);
                    }
                }
            }
            if (iVar2 != null) {
                return iVar2;
            }
            if (!this.f4270b || cVar != EnumC0107c.TYPES_ONLY) {
                throw new d(iVar, '\"' + str + "\" is not defined.");
            }
            Logger logger = s.f4263a;
            logger.warning("The descriptor for message type \"" + str + "\" can not be found and a placeholder is created for it");
            b bVar = new b(str2);
            this.f4269a.add(bVar.f4266c);
            return bVar;
        }
    }

    public static class d extends Exception {
        public d(h hVar, String str, a aVar) {
            super(hVar.f() + ": " + str);
            hVar.f();
        }

        public d(i iVar, String str) {
            super(iVar.d() + ": " + str);
            iVar.d();
            iVar.g();
        }
    }

    public static final class e extends i {

        /* renamed from: a  reason: collision with root package name */
        public r.c f4283a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4284b;

        /* renamed from: c  reason: collision with root package name */
        public final h f4285c;

        /* renamed from: d  reason: collision with root package name */
        public f[] f4286d;

        /* renamed from: e  reason: collision with root package name */
        public final WeakHashMap<Integer, WeakReference<f>> f4287e = new WeakHashMap<>();

        public e(r.c cVar, h hVar, b bVar, int i, a aVar) {
            super(null);
            this.f4283a = cVar;
            this.f4284b = s.a(hVar, bVar, cVar.a());
            this.f4285c = hVar;
            if (cVar.c() != 0) {
                this.f4286d = new f[cVar.c()];
                for (int i2 = 0; i2 < cVar.c(); i2++) {
                    this.f4286d[i2] = new f(cVar.f4091d.get(i2), hVar, this, i2, null);
                }
                hVar.g.b(this);
                return;
            }
            throw new d(this, "Enums must contain at least one value.");
        }

        @Override // c.b.d.s.i
        public h b() {
            return this.f4285c;
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f4284b;
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f4283a.a();
        }

        @Override // c.b.d.s.i
        public e1 g() {
            return this.f4283a;
        }

        public f i(int i) {
            return this.f4285c.g.f4273e.get(new c.a(this, i));
        }

        public f k(int i) {
            f i2 = i(i);
            if (i2 != null) {
                return i2;
            }
            synchronized (this) {
                Integer num = new Integer(i);
                WeakReference<f> weakReference = this.f4287e.get(num);
                if (weakReference != null) {
                    i2 = weakReference.get();
                }
                if (i2 == null) {
                    i2 = new f(this.f4285c, this, num, null);
                    this.f4287e.put(num, new WeakReference<>(i2));
                }
            }
            return i2;
        }
    }

    public static final class g extends i implements Comparable<g>, f0.c<g> {
        public static final w2.b[] m = w2.b.values();

        /* renamed from: b  reason: collision with root package name */
        public final int f4292b;

        /* renamed from: c  reason: collision with root package name */
        public r.h f4293c;

        /* renamed from: d  reason: collision with root package name */
        public final String f4294d;

        /* renamed from: e  reason: collision with root package name */
        public final h f4295e;
        public final b f;
        public b g;
        public b h;
        public b i;
        public k j;
        public e k;
        public Object l;

        public enum a {
            INT(0),
            LONG(0L),
            FLOAT(Float.valueOf(0.0f)),
            DOUBLE(Double.valueOf(0.0d)),
            BOOLEAN(Boolean.FALSE),
            STRING(""),
            BYTE_STRING(j.f3914c),
            ENUM(null),
            MESSAGE(null);
            

            /* renamed from: b  reason: collision with root package name */
            public final Object f4299b;

            /* access modifiers changed from: public */
            a(Object obj) {
                this.f4299b = obj;
            }
        }

        public enum b {
            DOUBLE(a.DOUBLE),
            FLOAT(a.FLOAT),
            INT64(a.LONG),
            UINT64(a.LONG),
            INT32(a.INT),
            FIXED64(a.LONG),
            FIXED32(a.INT),
            BOOL(a.BOOLEAN),
            STRING(a.STRING),
            GROUP(a.MESSAGE),
            MESSAGE(a.MESSAGE),
            BYTES(a.BYTE_STRING),
            UINT32(a.INT),
            ENUM(a.ENUM),
            SFIXED32(a.INT),
            SFIXED64(a.LONG),
            SINT32(a.INT),
            SINT64(a.LONG);
            

            /* renamed from: b  reason: collision with root package name */
            public a f4303b;

            /* access modifiers changed from: public */
            b(a aVar) {
                this.f4303b = aVar;
            }
        }

        static {
            if (b.values().length != r.h.d.values().length) {
                throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
            }
        }

        public g(r.h hVar, h hVar2, b bVar, int i2, boolean z, a aVar) {
            super(null);
            this.f4292b = i2;
            this.f4293c = hVar;
            this.f4294d = s.a(hVar2, bVar, hVar.e());
            this.f4295e = hVar2;
            if (hVar.j()) {
                hVar.c();
            } else {
                String e2 = hVar.e();
                int length = e2.length();
                boolean z2 = false;
                for (int i3 = 0; i3 < length; i3++) {
                    if (e2.charAt(i3) == '_') {
                        z2 = true;
                    } else if (z2) {
                        z2 = false;
                    }
                }
            }
            if (hVar.p()) {
                r.h.d b2 = r.h.d.b(hVar.f);
                this.g = b.values()[(b2 == null ? r.h.d.TYPE_DOUBLE : b2).f4145b - 1];
            }
            if (this.f4293c.f4132d > 0) {
                boolean i4 = hVar.i();
                if (z) {
                    if (i4) {
                        this.h = null;
                        if (bVar != null) {
                            this.f = bVar;
                        } else {
                            this.f = null;
                        }
                        if (!hVar.n()) {
                            this.j = null;
                        } else {
                            throw new d(this, "FieldDescriptorProto.oneof_index set for extension field.");
                        }
                    } else {
                        throw new d(this, "FieldDescriptorProto.extendee not set for extension field.");
                    }
                } else if (!i4) {
                    this.h = bVar;
                    if (hVar.n()) {
                        int i5 = hVar.j;
                        if (i5 < 0 || i5 >= bVar.f4264a.f()) {
                            StringBuilder g2 = c.a.a.a.a.g("FieldDescriptorProto.oneof_index is out of range for type ");
                            g2.append(bVar.f());
                            throw new d(this, g2.toString());
                        }
                        k kVar = (k) Collections.unmodifiableList(Arrays.asList(bVar.h)).get(hVar.j);
                        this.j = kVar;
                        kVar.f++;
                    } else {
                        this.j = null;
                    }
                    this.f = null;
                } else {
                    throw new d(this, "FieldDescriptorProto.extendee set for non-extension field.");
                }
                hVar2.g.b(this);
                return;
            }
            throw new d(this, "Field numbers must be positive integers.");
        }

        public static void i(g gVar) {
            Object obj;
            Object obj2;
            long j2;
            long j3;
            b bVar;
            c.EnumC0107c cVar = c.EnumC0107c.TYPES_ONLY;
            if (gVar.f4293c.i()) {
                i f2 = gVar.f4295e.g.f(gVar.f4293c.b(), gVar, cVar);
                if (f2 instanceof b) {
                    b bVar2 = (b) f2;
                    gVar.h = bVar2;
                    if (!bVar2.q(gVar.f4293c.f4132d)) {
                        StringBuilder f3 = c.a.a.a.a.f('\"');
                        f3.append(gVar.h.f4265b);
                        f3.append("\" does not declare ");
                        f3.append(gVar.f4293c.f4132d);
                        f3.append(" as an extension number.");
                        throw new d(gVar, f3.toString());
                    }
                } else {
                    StringBuilder f4 = c.a.a.a.a.f('\"');
                    f4.append(gVar.f4293c.b());
                    f4.append("\" is not a message type.");
                    throw new d(gVar, f4.toString());
                }
            }
            if (gVar.f4293c.q()) {
                i f5 = gVar.f4295e.g.f(gVar.f4293c.g(), gVar, cVar);
                if (!gVar.f4293c.p()) {
                    if (f5 instanceof b) {
                        bVar = b.MESSAGE;
                    } else if (f5 instanceof e) {
                        bVar = b.ENUM;
                    } else {
                        StringBuilder f6 = c.a.a.a.a.f('\"');
                        f6.append(gVar.f4293c.g());
                        f6.append("\" is not a type.");
                        throw new d(gVar, f6.toString());
                    }
                    gVar.g = bVar;
                }
                a aVar = gVar.g.f4303b;
                if (aVar == a.MESSAGE) {
                    if (f5 instanceof b) {
                        gVar.i = (b) f5;
                        if (gVar.f4293c.h()) {
                            throw new d(gVar, "Messages can't have default values.");
                        }
                    } else {
                        StringBuilder f7 = c.a.a.a.a.f('\"');
                        f7.append(gVar.f4293c.g());
                        f7.append("\" is not a message type.");
                        throw new d(gVar, f7.toString());
                    }
                } else if (aVar != a.ENUM) {
                    throw new d(gVar, "Field with primitive type has type_name.");
                } else if (f5 instanceof e) {
                    gVar.k = (e) f5;
                } else {
                    StringBuilder f8 = c.a.a.a.a.f('\"');
                    f8.append(gVar.f4293c.g());
                    f8.append("\" is not an enum type.");
                    throw new d(gVar, f8.toString());
                }
            } else {
                a aVar2 = gVar.g.f4303b;
                if (aVar2 == a.MESSAGE || aVar2 == a.ENUM) {
                    throw new d(gVar, "Field with message or enum type missing type_name.");
                }
            }
            if (!gVar.f4293c.f().f4148e || gVar.s()) {
                boolean z = true;
                if (!gVar.f4293c.h()) {
                    if (gVar.c()) {
                        obj = Collections.emptyList();
                    } else {
                        int ordinal = gVar.g.f4303b.ordinal();
                        if (ordinal == 7) {
                            obj = Collections.unmodifiableList(Arrays.asList(gVar.k.f4286d)).get(0);
                        } else if (ordinal != 8) {
                            obj = gVar.g.f4303b.f4299b;
                        } else {
                            gVar.l = null;
                        }
                    }
                    gVar.l = obj;
                } else if (!gVar.c()) {
                    try {
                        switch (gVar.g.ordinal()) {
                            case 0:
                                obj2 = gVar.f4293c.a().equals("inf") ? Double.valueOf(Double.POSITIVE_INFINITY) : gVar.f4293c.a().equals("-inf") ? Double.valueOf(Double.NEGATIVE_INFINITY) : gVar.f4293c.a().equals("nan") ? Double.valueOf(Double.NaN) : Double.valueOf(gVar.f4293c.a());
                                gVar.l = obj2;
                                break;
                            case 1:
                                obj2 = gVar.f4293c.a().equals("inf") ? Float.valueOf(Float.POSITIVE_INFINITY) : gVar.f4293c.a().equals("-inf") ? Float.valueOf(Float.NEGATIVE_INFINITY) : gVar.f4293c.a().equals("nan") ? Float.valueOf(Float.NaN) : Float.valueOf(gVar.f4293c.a());
                                gVar.l = obj2;
                                break;
                            case 2:
                            case 15:
                            case 17:
                                j2 = i2.h(gVar.f4293c.a(), true, true);
                                obj2 = Long.valueOf(j2);
                                gVar.l = obj2;
                                break;
                            case 3:
                            case 5:
                                j2 = i2.h(gVar.f4293c.a(), false, true);
                                obj2 = Long.valueOf(j2);
                                gVar.l = obj2;
                                break;
                            case 4:
                            case 14:
                            case 16:
                                j3 = i2.h(gVar.f4293c.a(), true, false);
                                obj2 = Integer.valueOf((int) j3);
                                gVar.l = obj2;
                                break;
                            case 6:
                            case 12:
                                j3 = i2.h(gVar.f4293c.a(), false, false);
                                obj2 = Integer.valueOf((int) j3);
                                gVar.l = obj2;
                                break;
                            case 7:
                                obj2 = Boolean.valueOf(gVar.f4293c.a());
                                gVar.l = obj2;
                                break;
                            case 8:
                                obj2 = gVar.f4293c.a();
                                gVar.l = obj2;
                                break;
                            case 9:
                            case 10:
                                throw new d(gVar, "Message type had default value.");
                            case 11:
                                try {
                                    gVar.l = i2.j(gVar.f4293c.a());
                                    break;
                                } catch (i2.b e2) {
                                    d dVar = new d(gVar, "Couldn't parse default value: " + e2.getMessage());
                                    dVar.initCause(e2);
                                    throw dVar;
                                }
                            case 13:
                                e eVar = gVar.k;
                                String a2 = gVar.f4293c.a();
                                i c2 = eVar.f4285c.g.c(eVar.f4284b + '.' + a2, c.EnumC0107c.ALL_SYMBOLS);
                                f fVar = (c2 == null || !(c2 instanceof f)) ? null : (f) c2;
                                gVar.l = fVar;
                                if (fVar == null) {
                                    throw new d(gVar, "Unknown enum default value: \"" + gVar.f4293c.a() + '\"');
                                }
                                break;
                        }
                    } catch (NumberFormatException e3) {
                        StringBuilder g2 = c.a.a.a.a.g("Could not parse default value: \"");
                        g2.append(gVar.f4293c.a());
                        g2.append('\"');
                        d dVar2 = new d(gVar, g2.toString());
                        dVar2.initCause(e3);
                        throw dVar2;
                    }
                } else {
                    throw new d(gVar, "Repeated fields cannot have default values.");
                }
                if (!gVar.p()) {
                    c cVar2 = gVar.f4295e.g;
                    if (cVar2 != null) {
                        c.a aVar3 = new c.a(gVar.h, gVar.f4293c.f4132d);
                        g put = cVar2.f4272d.put(aVar3, gVar);
                        if (put != null) {
                            cVar2.f4272d.put(aVar3, put);
                            StringBuilder g3 = c.a.a.a.a.g("Field number ");
                            g3.append(gVar.f4293c.f4132d);
                            g3.append(" has already been used in \"");
                            g3.append(gVar.h.f4265b);
                            g3.append("\" by field \"");
                            g3.append(put.f());
                            g3.append("\".");
                            throw new d(gVar, g3.toString());
                        }
                    } else {
                        throw null;
                    }
                }
                b bVar3 = gVar.h;
                if (bVar3 != null && bVar3.p().f4179d) {
                    if (gVar.p()) {
                        if (gVar.f4293c.d() != r.h.c.LABEL_OPTIONAL) {
                            z = false;
                        }
                        if (!z || gVar.g != b.MESSAGE) {
                            throw new d(gVar, "Extensions of MessageSets must be optional messages.");
                        }
                        return;
                    }
                    throw new d(gVar, "MessageSets cannot have fields, only extensions.");
                }
                return;
            }
            throw new d(gVar, "[packed = true] can only be specified for repeated primitive fields.");
        }

        @Override // c.b.d.f0.c
        public int a() {
            return this.f4293c.f4132d;
        }

        @Override // c.b.d.s.i
        public h b() {
            return this.f4295e;
        }

        @Override // c.b.d.f0.c
        public boolean c() {
            return this.f4293c.d() == r.h.c.LABEL_REPEATED;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            g gVar = (g) obj;
            if (gVar.h == this.h) {
                return this.f4293c.f4132d - gVar.f4293c.f4132d;
            }
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f4294d;
        }

        @Override // c.b.d.f0.c
        public w2.b e() {
            return m[this.g.ordinal()];
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f4293c.e();
        }

        @Override // c.b.d.s.i
        public e1 g() {
            return this.f4293c;
        }

        @Override // c.b.d.f0.c
        public w2.c h() {
            return e().f4373b;
        }

        @Override // c.b.d.f0.c
        public boolean j() {
            if (!s()) {
                return false;
            }
            if (this.f4295e.n() == h.a.PROTO2) {
                return o().f4148e;
            }
            if (!o().j() || o().f4148e) {
                return true;
            }
            return false;
        }

        public Object k() {
            if (this.g.f4303b != a.MESSAGE) {
                return this.l;
            }
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }

        public e l() {
            if (this.g.f4303b == a.ENUM) {
                return this.k;
            }
            throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", this.f4294d));
        }

        public b n() {
            if (this.g.f4303b == a.MESSAGE) {
                return this.i;
            }
            throw new UnsupportedOperationException(String.format("This field is not of message type. (%s)", this.f4294d));
        }

        public r.i o() {
            return this.f4293c.f();
        }

        public boolean p() {
            return this.f4293c.i();
        }

        public boolean q() {
            return this.g == b.MESSAGE && c() && n().p().g;
        }

        @Override // c.b.d.f0.c
        public h1.a r(h1.a aVar, h1 h1Var) {
            return ((e1.a) aVar).mergeFrom((e1) h1Var);
        }

        public boolean s() {
            return c() && e().b();
        }

        public boolean t() {
            return this.f4293c.d() == r.h.c.LABEL_REQUIRED;
        }

        public String toString() {
            return this.f4294d;
        }

        public boolean u() {
            if (this.g != b.STRING) {
                return false;
            }
            if (!this.h.p().g && this.f4295e.n() != h.a.PROTO3) {
                return this.f4295e.f4304a.e().h;
            }
            return true;
        }
    }

    public static abstract class i {
        public i() {
        }

        public i(a aVar) {
        }

        public abstract h b();

        public abstract String d();

        public abstract String f();

        public abstract e1 g();
    }

    public static final class j extends i {

        /* renamed from: a  reason: collision with root package name */
        public r.m f4313a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4314b;

        /* renamed from: c  reason: collision with root package name */
        public final h f4315c;

        public j(r.m mVar, h hVar, l lVar, int i, a aVar) {
            super(null);
            this.f4313a = mVar;
            this.f4315c = hVar;
            this.f4314b = lVar.f4322b + '.' + mVar.b();
            hVar.g.b(this);
        }

        @Override // c.b.d.s.i
        public h b() {
            return this.f4315c;
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f4314b;
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f4313a.b();
        }

        @Override // c.b.d.s.i
        public e1 g() {
            return this.f4313a;
        }
    }

    public static final class k extends i {

        /* renamed from: a  reason: collision with root package name */
        public final int f4316a;

        /* renamed from: b  reason: collision with root package name */
        public r.o f4317b;

        /* renamed from: c  reason: collision with root package name */
        public final String f4318c;

        /* renamed from: d  reason: collision with root package name */
        public final h f4319d;

        /* renamed from: e  reason: collision with root package name */
        public b f4320e;
        public int f = 0;
        public g[] g;

        public k(r.o oVar, h hVar, b bVar, int i, a aVar) {
            super(null);
            this.f4317b = oVar;
            this.f4318c = s.a(hVar, bVar, oVar.a());
            this.f4319d = hVar;
            this.f4316a = i;
            this.f4320e = bVar;
        }

        @Override // c.b.d.s.i
        public h b() {
            return this.f4319d;
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f4318c;
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f4317b.a();
        }

        @Override // c.b.d.s.i
        public e1 g() {
            return this.f4317b;
        }
    }

    public static final class l extends i {

        /* renamed from: a  reason: collision with root package name */
        public r.q f4321a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4322b;

        /* renamed from: c  reason: collision with root package name */
        public final h f4323c;

        /* renamed from: d  reason: collision with root package name */
        public j[] f4324d;

        public l(r.q qVar, h hVar, int i, a aVar) {
            super(null);
            this.f4321a = qVar;
            this.f4322b = s.a(hVar, null, qVar.b());
            this.f4323c = hVar;
            this.f4324d = new j[qVar.a()];
            for (int i2 = 0; i2 < qVar.a(); i2++) {
                this.f4324d[i2] = new j(qVar.f4218d.get(i2), hVar, this, i2, null);
            }
            hVar.g.b(this);
        }

        @Override // c.b.d.s.i
        public h b() {
            return this.f4323c;
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f4322b;
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f4321a.b();
        }

        @Override // c.b.d.s.i
        public e1 g() {
            return this.f4321a;
        }
    }

    public static String a(h hVar, b bVar, String str) {
        if (bVar != null) {
            return bVar.f4265b + '.' + str;
        }
        String l2 = hVar.l();
        if (l2.isEmpty()) {
            return str;
        }
        return l2 + '.' + str;
    }

    public static final class f extends i implements m0.c {

        /* renamed from: b  reason: collision with root package name */
        public r.e f4288b;

        /* renamed from: c  reason: collision with root package name */
        public final String f4289c;

        /* renamed from: d  reason: collision with root package name */
        public final h f4290d;

        /* renamed from: e  reason: collision with root package name */
        public final e f4291e;

        public f(r.e eVar, h hVar, e eVar2, int i, a aVar) {
            super(null);
            this.f4288b = eVar;
            this.f4290d = hVar;
            this.f4291e = eVar2;
            this.f4289c = eVar2.f4284b + '.' + eVar.a();
            hVar.g.b(this);
            c cVar = hVar.g;
            if (cVar != null) {
                c.a aVar2 = new c.a(this.f4291e, this.f4288b.f4112d);
                f put = cVar.f4273e.put(aVar2, this);
                if (put != null) {
                    cVar.f4273e.put(aVar2, put);
                    return;
                }
                return;
            }
            throw null;
        }

        @Override // c.b.d.m0.c
        public int a() {
            return this.f4288b.f4112d;
        }

        @Override // c.b.d.s.i
        public h b() {
            return this.f4290d;
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f4289c;
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f4288b.a();
        }

        @Override // c.b.d.s.i
        public e1 g() {
            return this.f4288b;
        }

        public String toString() {
            return this.f4288b.a();
        }

        public f(h hVar, e eVar, Integer num, a aVar) {
            super(null);
            StringBuilder g = c.a.a.a.a.g("UNKNOWN_ENUM_VALUE_");
            g.append(eVar.f4283a.a());
            g.append("_");
            g.append(num);
            String sb = g.toString();
            r.e.b f = r.e.g.toBuilder();
            if (sb != null) {
                f.f4114b |= 1;
                f.f4115c = sb;
                f.onChanged();
                int intValue = num.intValue();
                f.f4114b |= 2;
                f.f4116d = intValue;
                f.onChanged();
                r.e a2 = f.build();
                this.f4288b = a2;
                this.f4290d = hVar;
                this.f4291e = eVar;
                this.f4289c = eVar.f4284b + '.' + a2.a();
                return;
            }
            throw null;
        }
    }

    public static final class h extends i {

        /* renamed from: a  reason: collision with root package name */
        public r.j f4304a;

        /* renamed from: b  reason: collision with root package name */
        public final b[] f4305b;

        /* renamed from: c  reason: collision with root package name */
        public final e[] f4306c;

        /* renamed from: d  reason: collision with root package name */
        public final l[] f4307d;

        /* renamed from: e  reason: collision with root package name */
        public final g[] f4308e;
        public final h[] f;
        public final c g;

        public enum a {
            UNKNOWN("unknown"),
            PROTO2("proto2"),
            PROTO3("proto3");
            

            /* renamed from: b  reason: collision with root package name */
            public final String f4312b;

            /* access modifiers changed from: public */
            a(String str) {
                this.f4312b = str;
            }
        }

        public h(r.j jVar, h[] hVarArr, c cVar, boolean z) {
            super(null);
            this.g = cVar;
            this.f4304a = jVar;
            h[] hVarArr2 = (h[]) hVarArr.clone();
            HashMap hashMap = new HashMap();
            for (h hVar : hVarArr) {
                hashMap.put(hVar.f(), hVar);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jVar.f.size(); i++) {
                l0 l0Var = (l0) jVar.f;
                l0Var.e(i);
                int i2 = l0Var.f3988c[i];
                if (i2 < 0 || i2 >= jVar.f4163e.size()) {
                    throw new d(this, "Invalid public dependency index.", null);
                }
                String str = (String) jVar.f4163e.get(i2);
                h hVar2 = (h) hashMap.get(str);
                if (hVar2 != null) {
                    arrayList.add(hVar2);
                } else if (!z) {
                    throw new d(this, c.a.a.a.a.o("Invalid public dependency: ", str), null);
                }
            }
            h[] hVarArr3 = new h[arrayList.size()];
            this.f = hVarArr3;
            arrayList.toArray(hVarArr3);
            cVar.a(l(), this);
            this.f4305b = new b[jVar.c()];
            for (int i3 = 0; i3 < jVar.c(); i3++) {
                this.f4305b[i3] = new b(jVar.h.get(i3), this, null, i3);
            }
            this.f4306c = new e[jVar.a()];
            for (int i4 = 0; i4 < jVar.a(); i4++) {
                this.f4306c[i4] = new e(jVar.i.get(i4), this, null, i4, null);
            }
            this.f4307d = new l[jVar.g()];
            for (int i5 = 0; i5 < jVar.g(); i5++) {
                this.f4307d[i5] = new l(jVar.j.get(i5), this, i5, null);
            }
            this.f4308e = new g[jVar.b()];
            for (int i6 = 0; i6 < jVar.b(); i6++) {
                this.f4308e[i6] = new g(jVar.k.get(i6), this, null, i6, true, null);
            }
        }

        public static h i(r.j jVar, h[] hVarArr, boolean z) {
            h hVar = new h(jVar, hVarArr, new c(hVarArr, z), z);
            for (b bVar : hVar.f4305b) {
                bVar.i();
            }
            for (l lVar : hVar.f4307d) {
                j[] jVarArr = lVar.f4324d;
                for (j jVar2 : jVarArr) {
                    c.EnumC0107c cVar = c.EnumC0107c.TYPES_ONLY;
                    i f2 = jVar2.f4315c.g.f(jVar2.f4313a.a(), jVar2, cVar);
                    if (f2 instanceof b) {
                        b bVar2 = (b) f2;
                        i f3 = jVar2.f4315c.g.f(jVar2.f4313a.d(), jVar2, cVar);
                        if (f3 instanceof b) {
                            b bVar3 = (b) f3;
                        } else {
                            StringBuilder f4 = c.a.a.a.a.f('\"');
                            f4.append(jVar2.f4313a.d());
                            f4.append("\" is not a message type.");
                            throw new d(jVar2, f4.toString());
                        }
                    } else {
                        StringBuilder f5 = c.a.a.a.a.f('\"');
                        f5.append(jVar2.f4313a.a());
                        f5.append("\" is not a message type.");
                        throw new d(jVar2, f5.toString());
                    }
                }
            }
            for (g gVar : hVar.f4308e) {
                g.i(gVar);
            }
            return hVar;
        }

        public static h o(String[] strArr, h[] hVarArr) {
            String str;
            r.j jVar;
            if (strArr.length == 1) {
                str = strArr[0];
            } else {
                StringBuilder sb = new StringBuilder();
                for (String str2 : strArr) {
                    sb.append(str2);
                }
                str = sb.toString();
            }
            try {
                try {
                    return i(r.j.q.parseFrom(str.getBytes(m0.f3999b)), hVarArr, true);
                } catch (d e2) {
                    StringBuilder g2 = c.a.a.a.a.g("Invalid embedded descriptor for \"");
                    g2.append(jVar.d());
                    g2.append("\".");
                    throw new IllegalArgumentException(g2.toString(), e2);
                }
            } catch (n0 e3) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e3);
            }
        }

        @Override // c.b.d.s.i
        public h b() {
            return this;
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f4304a.d();
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f4304a.d();
        }

        @Override // c.b.d.s.i
        public e1 g() {
            return this.f4304a;
        }

        public List<b> k() {
            return Collections.unmodifiableList(Arrays.asList(this.f4305b));
        }

        public String l() {
            return this.f4304a.f();
        }

        public a n() {
            a aVar = a.PROTO3;
            return aVar.f4312b.equals(this.f4304a.i()) ? aVar : a.PROTO2;
        }

        public boolean p() {
            return n() == a.PROTO3;
        }

        public h(String str, b bVar) {
            super(null);
            this.g = new c(new h[0], true);
            r.j.b o = r.j.p.toBuilder();
            String str2 = bVar.f4265b + ".placeholder.proto";
            if (str2 != null) {
                o.f4164b |= 1;
                o.f4165c = str2;
                o.onChanged();
                if (str != null) {
                    o.f4164b |= 2;
                    o.f4166d = str;
                    o.onChanged();
                    r.b bVar2 = bVar.f4264a;
                    b2<r.b, r.b.C0102b, Object> b2Var = o.i;
                    if (b2Var != null) {
                        b2Var.f(bVar2);
                    } else if (bVar2 != null) {
                        o.e();
                        o.h.add(bVar2);
                        o.onChanged();
                    } else {
                        throw null;
                    }
                    this.f4304a = o.build();
                    this.f = new h[0];
                    this.f4305b = new b[]{bVar};
                    this.f4306c = new e[0];
                    this.f4307d = new l[0];
                    this.f4308e = new g[0];
                    this.g.a(str, this);
                    this.g.b(bVar);
                    return;
                }
                throw null;
            }
            throw null;
        }
    }

    public static final class b extends i {

        /* renamed from: a  reason: collision with root package name */
        public r.b f4264a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4265b;

        /* renamed from: c  reason: collision with root package name */
        public final h f4266c;

        /* renamed from: d  reason: collision with root package name */
        public final b[] f4267d;

        /* renamed from: e  reason: collision with root package name */
        public final e[] f4268e;
        public final g[] f;
        public final g[] g;
        public final k[] h;

        public b(r.b bVar, h hVar, b bVar2, int i) {
            super(null);
            this.f4264a = bVar;
            this.f4265b = s.a(hVar, bVar2, bVar.d());
            this.f4266c = hVar;
            this.h = new k[bVar.f()];
            for (int i2 = 0; i2 < bVar.f(); i2++) {
                this.h[i2] = new k(bVar.i.get(i2), hVar, this, i2, null);
            }
            this.f4267d = new b[bVar.e()];
            for (int i3 = 0; i3 < bVar.e(); i3++) {
                this.f4267d[i3] = new b(bVar.f.get(i3), hVar, this, i3);
            }
            this.f4268e = new e[bVar.a()];
            for (int i4 = 0; i4 < bVar.a(); i4++) {
                this.f4268e[i4] = new e(bVar.g.get(i4), hVar, this, i4, null);
            }
            this.f = new g[bVar.c()];
            for (int i5 = 0; i5 < bVar.c(); i5++) {
                this.f[i5] = new g(bVar.f4068d.get(i5), hVar, this, i5, false, null);
            }
            this.g = new g[bVar.b()];
            for (int i6 = 0; i6 < bVar.b(); i6++) {
                this.g[i6] = new g(bVar.f4069e.get(i6), hVar, this, i6, true, null);
            }
            for (int i7 = 0; i7 < bVar.f(); i7++) {
                k[] kVarArr = this.h;
                kVarArr[i7].g = new g[kVarArr[i7].f];
                kVarArr[i7].f = 0;
            }
            for (int i8 = 0; i8 < bVar.c(); i8++) {
                g[] gVarArr = this.f;
                k kVar = gVarArr[i8].j;
                if (kVar != null) {
                    g[] gVarArr2 = kVar.g;
                    int i9 = kVar.f;
                    kVar.f = i9 + 1;
                    gVarArr2[i9] = gVarArr[i8];
                }
            }
            hVar.g.b(this);
        }

        @Override // c.b.d.s.i
        public h b() {
            return this.f4266c;
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f4265b;
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f4264a.d();
        }

        @Override // c.b.d.s.i
        public e1 g() {
            return this.f4264a;
        }

        public final void i() {
            for (b bVar : this.f4267d) {
                bVar.i();
            }
            for (g gVar : this.f) {
                g.i(gVar);
            }
            for (g gVar2 : this.g) {
                g.i(gVar2);
            }
        }

        public g k(String str) {
            c cVar = this.f4266c.g;
            i c2 = cVar.c(this.f4265b + '.' + str, c.EnumC0107c.ALL_SYMBOLS);
            if (c2 == null || !(c2 instanceof g)) {
                return null;
            }
            return (g) c2;
        }

        public g l(int i) {
            return this.f4266c.g.f4272d.get(new c.a(this, i));
        }

        public List<g> n() {
            return Collections.unmodifiableList(Arrays.asList(this.f));
        }

        public List<b> o() {
            return Collections.unmodifiableList(Arrays.asList(this.f4267d));
        }

        public r.l p() {
            return this.f4264a.g();
        }

        public boolean q(int i) {
            for (r.b.c cVar : this.f4264a.h) {
                if (cVar.f4075c <= i && i < cVar.f4076d) {
                    return true;
                }
            }
            return false;
        }

        public b(String str) {
            super(null);
            String str2;
            String str3;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str2 = str.substring(lastIndexOf + 1);
                str3 = str.substring(0, lastIndexOf);
            } else {
                str3 = "";
                str2 = str;
            }
            r.b.C0102b j = r.b.n.toBuilder();
            if (str2 != null) {
                j.f4070b |= 1;
                j.f4071c = str2;
                j.onChanged();
                r.b.c.C0103b e2 = r.b.c.g.toBuilder();
                e2.f4078b |= 1;
                e2.f4079c = 1;
                e2.onChanged();
                e2.f4078b |= 2;
                e2.f4080d = 536870912;
                e2.onChanged();
                r.b.c a2 = e2.build();
                b2<r.b.c, r.b.c.C0103b, Object> b2Var = j.m;
                if (b2Var == null) {
                    j.e();
                    j.l.add(a2);
                    j.onChanged();
                } else {
                    b2Var.f(a2);
                }
                this.f4264a = j.build();
                this.f4265b = str;
                this.f4267d = new b[0];
                this.f4268e = new e[0];
                this.f = new g[0];
                this.g = new g[0];
                this.h = new k[0];
                this.f4266c = new h(str3, this);
                return;
            }
            throw null;
        }
    }
}
