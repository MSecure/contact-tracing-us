package c.b.d;

import c.b.d.f0;
import c.b.d.f1;
import c.b.d.i1;
import c.b.d.j2;
import c.b.d.n0;
import c.b.d.r;
import c.b.d.x2;
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
    public static final Logger f5787a = Logger.getLogger(s.class.getName());

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final Set<h> f5795a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        public boolean f5796b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, i> f5797c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        public final Map<a, g> f5798d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        public final Map<a, f> f5799e = new HashMap();

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public final i f5800a;

            /* renamed from: b  reason: collision with root package name */
            public final int f5801b;

            public a(i iVar, int i) {
                this.f5800a = iVar;
                this.f5801b = i;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.f5800a == aVar.f5800a && this.f5801b == aVar.f5801b;
            }

            public int hashCode() {
                return (this.f5800a.hashCode() * 65535) + this.f5801b;
            }
        }

        public static final class b extends i {

            /* renamed from: a  reason: collision with root package name */
            public final String f5802a;

            /* renamed from: b  reason: collision with root package name */
            public final String f5803b;

            /* renamed from: c  reason: collision with root package name */
            public final h f5804c;

            public b(String str, String str2, h hVar) {
                super(null);
                this.f5804c = hVar;
                this.f5803b = str2;
                this.f5802a = str;
            }

            @Override // c.b.d.s.i
            public h b() {
                return this.f5804c;
            }

            @Override // c.b.d.s.i
            public String d() {
                return this.f5803b;
            }

            @Override // c.b.d.s.i
            public String f() {
                return this.f5802a;
            }

            @Override // c.b.d.s.i
            public f1 i() {
                return this.f5804c.f5836a;
            }
        }

        /* renamed from: c.b.d.s$c$c  reason: collision with other inner class name */
        public enum EnumC0116c {
            TYPES_ONLY,
            AGGREGATES_ONLY,
            ALL_SYMBOLS
        }

        public c(h[] hVarArr, boolean z) {
            this.f5796b = z;
            for (int i = 0; i < hVarArr.length; i++) {
                this.f5795a.add(hVarArr[i]);
                d(hVarArr[i]);
            }
            for (h hVar : this.f5795a) {
                try {
                    a(hVar.n(), hVar);
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
            i put = this.f5797c.put(str, new b(str2, str, hVar));
            if (put != null) {
                this.f5797c.put(str, put);
                if (!(put instanceof b)) {
                    throw new d(hVar, '\"' + str2 + "\" is already defined (as something other than a package) in file \"" + put.b().f() + "\".", null);
                }
            }
        }

        public void b(i iVar) {
            String f2 = iVar.f();
            if (f2.length() != 0) {
                for (int i = 0; i < f2.length(); i++) {
                    char charAt = f2.charAt(i);
                    if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && charAt != '_' && ('0' > charAt || charAt > '9' || i <= 0))) {
                        throw new d(iVar, '\"' + f2 + "\" is not a valid identifier.");
                    }
                }
                String d2 = iVar.d();
                i put = this.f5797c.put(d2, iVar);
                if (put != null) {
                    this.f5797c.put(d2, put);
                    if (iVar.b() == put.b()) {
                        int lastIndexOf = d2.lastIndexOf(46);
                        if (lastIndexOf == -1) {
                            throw new d(iVar, '\"' + d2 + "\" is already defined.");
                        }
                        StringBuilder g2 = c.a.a.a.a.g('\"');
                        g2.append(d2.substring(lastIndexOf + 1));
                        g2.append("\" is already defined in \"");
                        g2.append(d2.substring(0, lastIndexOf));
                        g2.append("\".");
                        throw new d(iVar, g2.toString());
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
        public i c(String str, EnumC0116c cVar) {
            EnumC0116c cVar2 = EnumC0116c.AGGREGATES_ONLY;
            EnumC0116c cVar3 = EnumC0116c.TYPES_ONLY;
            EnumC0116c cVar4 = EnumC0116c.ALL_SYMBOLS;
            i iVar = this.f5797c.get(str);
            if (iVar != null) {
                if (cVar != cVar4) {
                    if (cVar == cVar3) {
                    }
                    if (cVar == cVar2) {
                    }
                }
                return iVar;
            }
            for (h hVar : this.f5795a) {
                i iVar2 = hVar.f5842g.f5797c.get(str);
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
            for (h hVar2 : Collections.unmodifiableList(Arrays.asList(hVar.f5841f))) {
                if (this.f5795a.add(hVar2)) {
                    d(hVar2);
                }
            }
        }

        public boolean e(i iVar) {
            return (iVar instanceof b) || (iVar instanceof e) || (iVar instanceof b) || (iVar instanceof l);
        }

        public i f(String str, i iVar, EnumC0116c cVar) {
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
                    i c2 = c(sb.toString(), EnumC0116c.AGGREGATES_ONLY);
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
            if (!this.f5796b || cVar != EnumC0116c.TYPES_ONLY) {
                throw new d(iVar, '\"' + str + "\" is not defined.");
            }
            Logger logger = s.f5787a;
            logger.warning("The descriptor for message type \"" + str + "\" can not be found and a placeholder is created for it");
            b bVar = new b(str2);
            this.f5795a.add(bVar.f5790c);
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
            iVar.i();
        }
    }

    public static final class e extends i {

        /* renamed from: a  reason: collision with root package name */
        public r.c f5809a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5810b;

        /* renamed from: c  reason: collision with root package name */
        public final h f5811c;

        /* renamed from: d  reason: collision with root package name */
        public f[] f5812d;

        /* renamed from: e  reason: collision with root package name */
        public final WeakHashMap<Integer, WeakReference<f>> f5813e = new WeakHashMap<>();

        public e(r.c cVar, h hVar, b bVar, int i, a aVar) {
            super(null);
            this.f5809a = cVar;
            this.f5810b = s.a(hVar, bVar, cVar.a());
            this.f5811c = hVar;
            if (cVar.c() != 0) {
                this.f5812d = new f[cVar.c()];
                for (int i2 = 0; i2 < cVar.c(); i2++) {
                    this.f5812d[i2] = new f(cVar.f5536d.get(i2), hVar, this, i2, null);
                }
                hVar.f5842g.b(this);
                return;
            }
            throw new d(this, "Enums must contain at least one value.");
        }

        @Override // c.b.d.s.i
        public h b() {
            return this.f5811c;
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f5810b;
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f5809a.a();
        }

        @Override // c.b.d.s.i
        public f1 i() {
            return this.f5809a;
        }

        public f k(int i) {
            return this.f5811c.f5842g.f5799e.get(new c.a(this, i));
        }

        public f m(int i) {
            f k = k(i);
            if (k != null) {
                return k;
            }
            synchronized (this) {
                Integer num = new Integer(i);
                WeakReference<f> weakReference = this.f5813e.get(num);
                if (weakReference != null) {
                    k = weakReference.get();
                }
                if (k == null) {
                    k = new f(this.f5811c, this, num, null);
                    this.f5813e.put(num, new WeakReference<>(k));
                }
            }
            return k;
        }
    }

    public static final class g extends i implements Comparable<g>, f0.c<g> {
        public static final x2.b[] m = x2.b.values();

        /* renamed from: b  reason: collision with root package name */
        public final int f5818b;

        /* renamed from: c  reason: collision with root package name */
        public r.h f5819c;

        /* renamed from: d  reason: collision with root package name */
        public final String f5820d;

        /* renamed from: e  reason: collision with root package name */
        public final h f5821e;

        /* renamed from: f  reason: collision with root package name */
        public final b f5822f;

        /* renamed from: g  reason: collision with root package name */
        public b f5823g;
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
            BYTE_STRING(j.f5320c),
            ENUM(null),
            MESSAGE(null);
            

            /* renamed from: b  reason: collision with root package name */
            public final Object f5829b;

            /* access modifiers changed from: public */
            a(Object obj) {
                this.f5829b = obj;
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
            public a f5835b;

            /* access modifiers changed from: public */
            b(a aVar) {
                this.f5835b = aVar;
            }
        }

        static {
            if (b.values().length != r.h.d.values().length) {
                throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
            }
        }

        public g(r.h hVar, h hVar2, b bVar, int i2, boolean z, a aVar) {
            super(null);
            this.f5818b = i2;
            this.f5819c = hVar;
            this.f5820d = s.a(hVar2, bVar, hVar.e());
            this.f5821e = hVar2;
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
                r.h.d b2 = r.h.d.b(hVar.f5596f);
                this.f5823g = b.values()[(b2 == null ? r.h.d.TYPE_DOUBLE : b2).f5614b - 1];
            }
            if (this.f5819c.f5594d > 0) {
                boolean i4 = hVar.i();
                if (z) {
                    if (i4) {
                        this.h = null;
                        if (bVar != null) {
                            this.f5822f = bVar;
                        } else {
                            this.f5822f = null;
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
                        if (i5 < 0 || i5 >= bVar.f5788a.f()) {
                            StringBuilder h2 = c.a.a.a.a.h("FieldDescriptorProto.oneof_index is out of range for type ");
                            h2.append(bVar.f());
                            throw new d(this, h2.toString());
                        }
                        k kVar = (k) Collections.unmodifiableList(Arrays.asList(bVar.h)).get(hVar.j);
                        this.j = kVar;
                        kVar.f5856f++;
                    } else {
                        this.j = null;
                    }
                    this.f5822f = null;
                } else {
                    throw new d(this, "FieldDescriptorProto.extendee set for non-extension field.");
                }
                hVar2.f5842g.b(this);
                return;
            }
            throw new d(this, "Field numbers must be positive integers.");
        }

        public static void k(g gVar) {
            Object obj;
            Object obj2;
            long j2;
            long j3;
            b bVar;
            c.EnumC0116c cVar = c.EnumC0116c.TYPES_ONLY;
            if (gVar.f5819c.i()) {
                i f2 = gVar.f5821e.f5842g.f(gVar.f5819c.b(), gVar, cVar);
                if (f2 instanceof b) {
                    b bVar2 = (b) f2;
                    gVar.h = bVar2;
                    if (!bVar2.t(gVar.f5819c.f5594d)) {
                        StringBuilder g2 = c.a.a.a.a.g('\"');
                        g2.append(gVar.h.f5789b);
                        g2.append("\" does not declare ");
                        g2.append(gVar.f5819c.f5594d);
                        g2.append(" as an extension number.");
                        throw new d(gVar, g2.toString());
                    }
                } else {
                    StringBuilder g3 = c.a.a.a.a.g('\"');
                    g3.append(gVar.f5819c.b());
                    g3.append("\" is not a message type.");
                    throw new d(gVar, g3.toString());
                }
            }
            if (gVar.f5819c.q()) {
                i f3 = gVar.f5821e.f5842g.f(gVar.f5819c.g(), gVar, cVar);
                if (!gVar.f5819c.p()) {
                    if (f3 instanceof b) {
                        bVar = b.MESSAGE;
                    } else if (f3 instanceof e) {
                        bVar = b.ENUM;
                    } else {
                        StringBuilder g4 = c.a.a.a.a.g('\"');
                        g4.append(gVar.f5819c.g());
                        g4.append("\" is not a type.");
                        throw new d(gVar, g4.toString());
                    }
                    gVar.f5823g = bVar;
                }
                a aVar = gVar.f5823g.f5835b;
                if (aVar == a.MESSAGE) {
                    if (f3 instanceof b) {
                        gVar.i = (b) f3;
                        if (gVar.f5819c.h()) {
                            throw new d(gVar, "Messages can't have default values.");
                        }
                    } else {
                        StringBuilder g5 = c.a.a.a.a.g('\"');
                        g5.append(gVar.f5819c.g());
                        g5.append("\" is not a message type.");
                        throw new d(gVar, g5.toString());
                    }
                } else if (aVar != a.ENUM) {
                    throw new d(gVar, "Field with primitive type has type_name.");
                } else if (f3 instanceof e) {
                    gVar.k = (e) f3;
                } else {
                    StringBuilder g6 = c.a.a.a.a.g('\"');
                    g6.append(gVar.f5819c.g());
                    g6.append("\" is not an enum type.");
                    throw new d(gVar, g6.toString());
                }
            } else {
                a aVar2 = gVar.f5823g.f5835b;
                if (aVar2 == a.MESSAGE || aVar2 == a.ENUM) {
                    throw new d(gVar, "Field with message or enum type missing type_name.");
                }
            }
            if (!gVar.f5819c.f().f5617e || gVar.x()) {
                boolean z = true;
                if (!gVar.f5819c.h()) {
                    if (gVar.e()) {
                        obj = Collections.emptyList();
                    } else {
                        int ordinal = gVar.f5823g.f5835b.ordinal();
                        if (ordinal == 7) {
                            obj = Collections.unmodifiableList(Arrays.asList(gVar.k.f5812d)).get(0);
                        } else if (ordinal != 8) {
                            obj = gVar.f5823g.f5835b.f5829b;
                        } else {
                            gVar.l = null;
                        }
                    }
                    gVar.l = obj;
                } else if (!gVar.e()) {
                    try {
                        switch (gVar.f5823g.ordinal()) {
                            case 0:
                                obj2 = gVar.f5819c.a().equals("inf") ? Double.valueOf(Double.POSITIVE_INFINITY) : gVar.f5819c.a().equals("-inf") ? Double.valueOf(Double.NEGATIVE_INFINITY) : gVar.f5819c.a().equals("nan") ? Double.valueOf(Double.NaN) : Double.valueOf(gVar.f5819c.a());
                                gVar.l = obj2;
                                break;
                            case 1:
                                obj2 = gVar.f5819c.a().equals("inf") ? Float.valueOf(Float.POSITIVE_INFINITY) : gVar.f5819c.a().equals("-inf") ? Float.valueOf(Float.NEGATIVE_INFINITY) : gVar.f5819c.a().equals("nan") ? Float.valueOf(Float.NaN) : Float.valueOf(gVar.f5819c.a());
                                gVar.l = obj2;
                                break;
                            case 2:
                            case 15:
                            case 17:
                                j2 = j2.h(gVar.f5819c.a(), true, true);
                                obj2 = Long.valueOf(j2);
                                gVar.l = obj2;
                                break;
                            case 3:
                            case 5:
                                j2 = j2.h(gVar.f5819c.a(), false, true);
                                obj2 = Long.valueOf(j2);
                                gVar.l = obj2;
                                break;
                            case 4:
                            case 14:
                            case 16:
                                j3 = j2.h(gVar.f5819c.a(), true, false);
                                obj2 = Integer.valueOf((int) j3);
                                gVar.l = obj2;
                                break;
                            case 6:
                            case 12:
                                j3 = j2.h(gVar.f5819c.a(), false, false);
                                obj2 = Integer.valueOf((int) j3);
                                gVar.l = obj2;
                                break;
                            case 7:
                                obj2 = Boolean.valueOf(gVar.f5819c.a());
                                gVar.l = obj2;
                                break;
                            case 8:
                                obj2 = gVar.f5819c.a();
                                gVar.l = obj2;
                                break;
                            case 9:
                            case 10:
                                throw new d(gVar, "Message type had default value.");
                            case 11:
                                try {
                                    gVar.l = j2.j(gVar.f5819c.a());
                                    break;
                                } catch (j2.b e2) {
                                    d dVar = new d(gVar, "Couldn't parse default value: " + e2.getMessage());
                                    dVar.initCause(e2);
                                    throw dVar;
                                }
                            case 13:
                                e eVar = gVar.k;
                                String a2 = gVar.f5819c.a();
                                i c2 = eVar.f5811c.f5842g.c(eVar.f5810b + '.' + a2, c.EnumC0116c.ALL_SYMBOLS);
                                f fVar = (c2 == null || !(c2 instanceof f)) ? null : (f) c2;
                                gVar.l = fVar;
                                if (fVar == null) {
                                    throw new d(gVar, "Unknown enum default value: \"" + gVar.f5819c.a() + '\"');
                                }
                                break;
                        }
                    } catch (NumberFormatException e3) {
                        StringBuilder h2 = c.a.a.a.a.h("Could not parse default value: \"");
                        h2.append(gVar.f5819c.a());
                        h2.append('\"');
                        d dVar2 = new d(gVar, h2.toString());
                        dVar2.initCause(e3);
                        throw dVar2;
                    }
                } else {
                    throw new d(gVar, "Repeated fields cannot have default values.");
                }
                if (!gVar.s()) {
                    c cVar2 = gVar.f5821e.f5842g;
                    if (cVar2 != null) {
                        c.a aVar3 = new c.a(gVar.h, gVar.f5819c.f5594d);
                        g put = cVar2.f5798d.put(aVar3, gVar);
                        if (put != null) {
                            cVar2.f5798d.put(aVar3, put);
                            StringBuilder h3 = c.a.a.a.a.h("Field number ");
                            h3.append(gVar.f5819c.f5594d);
                            h3.append(" has already been used in \"");
                            h3.append(gVar.h.f5789b);
                            h3.append("\" by field \"");
                            h3.append(put.f());
                            h3.append("\".");
                            throw new d(gVar, h3.toString());
                        }
                    } else {
                        throw null;
                    }
                }
                b bVar3 = gVar.h;
                if (bVar3 != null && bVar3.s().f5663d) {
                    if (gVar.s()) {
                        if (gVar.f5819c.d() != r.h.c.LABEL_OPTIONAL) {
                            z = false;
                        }
                        if (!z || gVar.f5823g != b.MESSAGE) {
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

        public boolean A() {
            if (this.f5823g != b.STRING) {
                return false;
            }
            if (!this.h.s().f5666g && this.f5821e.p() != h.a.PROTO3) {
                return this.f5821e.f5836a.e().h;
            }
            return true;
        }

        @Override // c.b.d.f0.c
        public i1.a O(i1.a aVar, i1 i1Var) {
            return ((f1.a) aVar).mergeFrom((f1) i1Var);
        }

        @Override // c.b.d.f0.c
        public int a() {
            return this.f5819c.f5594d;
        }

        @Override // c.b.d.s.i
        public h b() {
            return this.f5821e;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            g gVar = (g) obj;
            if (gVar.h == this.h) {
                return this.f5819c.f5594d - gVar.f5819c.f5594d;
            }
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f5820d;
        }

        @Override // c.b.d.f0.c
        public boolean e() {
            return this.f5819c.d() == r.h.c.LABEL_REPEATED;
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f5819c.e();
        }

        @Override // c.b.d.f0.c
        public x2.b g() {
            return m[this.f5823g.ordinal()];
        }

        @Override // c.b.d.s.i
        public f1 i() {
            return this.f5819c;
        }

        @Override // c.b.d.f0.c
        public x2.c j() {
            return g().f5925b;
        }

        @Override // c.b.d.f0.c
        public boolean l() {
            if (!x()) {
                return false;
            }
            if (this.f5821e.p() == h.a.PROTO2) {
                return r().f5617e;
            }
            if (!r().j() || r().f5617e) {
                return true;
            }
            return false;
        }

        public Object m() {
            if (this.f5823g.f5835b != a.MESSAGE) {
                return this.l;
            }
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }

        public e n() {
            if (this.f5823g.f5835b == a.ENUM) {
                return this.k;
            }
            throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", this.f5820d));
        }

        public b p() {
            if (this.f5823g.f5835b == a.MESSAGE) {
                return this.i;
            }
            throw new UnsupportedOperationException(String.format("This field is not of message type. (%s)", this.f5820d));
        }

        public r.i r() {
            return this.f5819c.f();
        }

        public boolean s() {
            return this.f5819c.i();
        }

        public boolean t() {
            return this.f5823g == b.MESSAGE && e() && p().s().f5666g;
        }

        public String toString() {
            return this.f5820d;
        }

        public boolean x() {
            return e() && g().b();
        }

        public boolean y() {
            return this.f5819c.d() == r.h.c.LABEL_REQUIRED;
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

        public abstract f1 i();
    }

    public static final class j extends i {

        /* renamed from: a  reason: collision with root package name */
        public r.m f5848a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5849b;

        /* renamed from: c  reason: collision with root package name */
        public final h f5850c;

        public j(r.m mVar, h hVar, l lVar, int i, a aVar) {
            super(null);
            this.f5848a = mVar;
            this.f5850c = hVar;
            this.f5849b = lVar.f5859b + '.' + mVar.b();
            hVar.f5842g.b(this);
        }

        @Override // c.b.d.s.i
        public h b() {
            return this.f5850c;
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f5849b;
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f5848a.b();
        }

        @Override // c.b.d.s.i
        public f1 i() {
            return this.f5848a;
        }
    }

    public static final class k extends i {

        /* renamed from: a  reason: collision with root package name */
        public final int f5851a;

        /* renamed from: b  reason: collision with root package name */
        public r.o f5852b;

        /* renamed from: c  reason: collision with root package name */
        public final String f5853c;

        /* renamed from: d  reason: collision with root package name */
        public final h f5854d;

        /* renamed from: e  reason: collision with root package name */
        public b f5855e;

        /* renamed from: f  reason: collision with root package name */
        public int f5856f = 0;

        /* renamed from: g  reason: collision with root package name */
        public g[] f5857g;

        public k(r.o oVar, h hVar, b bVar, int i, a aVar) {
            super(null);
            this.f5852b = oVar;
            this.f5853c = s.a(hVar, bVar, oVar.a());
            this.f5854d = hVar;
            this.f5851a = i;
            this.f5855e = bVar;
        }

        @Override // c.b.d.s.i
        public h b() {
            return this.f5854d;
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f5853c;
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f5852b.a();
        }

        @Override // c.b.d.s.i
        public f1 i() {
            return this.f5852b;
        }
    }

    public static final class l extends i {

        /* renamed from: a  reason: collision with root package name */
        public r.q f5858a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5859b;

        /* renamed from: c  reason: collision with root package name */
        public final h f5860c;

        /* renamed from: d  reason: collision with root package name */
        public j[] f5861d;

        public l(r.q qVar, h hVar, int i, a aVar) {
            super(null);
            this.f5858a = qVar;
            this.f5859b = s.a(hVar, null, qVar.b());
            this.f5860c = hVar;
            this.f5861d = new j[qVar.a()];
            for (int i2 = 0; i2 < qVar.a(); i2++) {
                this.f5861d[i2] = new j(qVar.f5719d.get(i2), hVar, this, i2, null);
            }
            hVar.f5842g.b(this);
        }

        @Override // c.b.d.s.i
        public h b() {
            return this.f5860c;
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f5859b;
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f5858a.b();
        }

        @Override // c.b.d.s.i
        public f1 i() {
            return this.f5858a;
        }
    }

    public static String a(h hVar, b bVar, String str) {
        if (bVar != null) {
            return bVar.f5789b + '.' + str;
        }
        String n = hVar.n();
        if (n.isEmpty()) {
            return str;
        }
        return n + '.' + str;
    }

    public static final class f extends i implements n0.c {

        /* renamed from: b  reason: collision with root package name */
        public r.e f5814b;

        /* renamed from: c  reason: collision with root package name */
        public final String f5815c;

        /* renamed from: d  reason: collision with root package name */
        public final h f5816d;

        /* renamed from: e  reason: collision with root package name */
        public final e f5817e;

        public f(r.e eVar, h hVar, e eVar2, int i, a aVar) {
            super(null);
            this.f5814b = eVar;
            this.f5816d = hVar;
            this.f5817e = eVar2;
            this.f5815c = eVar2.f5810b + '.' + eVar.a();
            hVar.f5842g.b(this);
            c cVar = hVar.f5842g;
            if (cVar != null) {
                c.a aVar2 = new c.a(this.f5817e, this.f5814b.f5568d);
                f put = cVar.f5799e.put(aVar2, this);
                if (put != null) {
                    cVar.f5799e.put(aVar2, put);
                    return;
                }
                return;
            }
            throw null;
        }

        @Override // c.b.d.n0.c
        public int a() {
            return this.f5814b.f5568d;
        }

        @Override // c.b.d.s.i
        public h b() {
            return this.f5816d;
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f5815c;
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f5814b.a();
        }

        @Override // c.b.d.s.i
        public f1 i() {
            return this.f5814b;
        }

        public String toString() {
            return this.f5814b.a();
        }

        public f(h hVar, e eVar, Integer num, a aVar) {
            super(null);
            StringBuilder h = c.a.a.a.a.h("UNKNOWN_ENUM_VALUE_");
            h.append(eVar.f5809a.a());
            h.append("_");
            h.append(num);
            String sb = h.toString();
            r.e.b f2 = r.e.f5565g.toBuilder();
            if (sb != null) {
                f2.f5571b |= 1;
                f2.f5572c = sb;
                f2.onChanged();
                int intValue = num.intValue();
                f2.f5571b |= 2;
                f2.f5573d = intValue;
                f2.onChanged();
                r.e a2 = f2.build();
                this.f5814b = a2;
                this.f5816d = hVar;
                this.f5817e = eVar;
                this.f5815c = eVar.f5810b + '.' + a2.a();
                return;
            }
            throw null;
        }
    }

    public static final class h extends i {

        /* renamed from: a  reason: collision with root package name */
        public r.j f5836a;

        /* renamed from: b  reason: collision with root package name */
        public final b[] f5837b;

        /* renamed from: c  reason: collision with root package name */
        public final e[] f5838c;

        /* renamed from: d  reason: collision with root package name */
        public final l[] f5839d;

        /* renamed from: e  reason: collision with root package name */
        public final g[] f5840e;

        /* renamed from: f  reason: collision with root package name */
        public final h[] f5841f;

        /* renamed from: g  reason: collision with root package name */
        public final c f5842g;

        public enum a {
            UNKNOWN("unknown"),
            PROTO2("proto2"),
            PROTO3("proto3");
            

            /* renamed from: b  reason: collision with root package name */
            public final String f5847b;

            /* access modifiers changed from: public */
            a(String str) {
                this.f5847b = str;
            }
        }

        public h(r.j jVar, h[] hVarArr, c cVar, boolean z) {
            super(null);
            this.f5842g = cVar;
            this.f5836a = jVar;
            h[] hVarArr2 = (h[]) hVarArr.clone();
            HashMap hashMap = new HashMap();
            for (h hVar : hVarArr) {
                hashMap.put(hVar.f(), hVar);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jVar.f5639f.size(); i++) {
                m0 m0Var = (m0) jVar.f5639f;
                m0Var.e(i);
                int i2 = m0Var.f5434c[i];
                if (i2 < 0 || i2 >= jVar.f5638e.size()) {
                    throw new d(this, "Invalid public dependency index.", null);
                }
                String str = (String) jVar.f5638e.get(i2);
                h hVar2 = (h) hashMap.get(str);
                if (hVar2 != null) {
                    arrayList.add(hVar2);
                } else if (!z) {
                    throw new d(this, c.a.a.a.a.q("Invalid public dependency: ", str), null);
                }
            }
            h[] hVarArr3 = new h[arrayList.size()];
            this.f5841f = hVarArr3;
            arrayList.toArray(hVarArr3);
            cVar.a(n(), this);
            this.f5837b = new b[jVar.c()];
            for (int i3 = 0; i3 < jVar.c(); i3++) {
                this.f5837b[i3] = new b(jVar.h.get(i3), this, null, i3);
            }
            this.f5838c = new e[jVar.a()];
            for (int i4 = 0; i4 < jVar.a(); i4++) {
                this.f5838c[i4] = new e(jVar.i.get(i4), this, null, i4, null);
            }
            this.f5839d = new l[jVar.g()];
            for (int i5 = 0; i5 < jVar.g(); i5++) {
                this.f5839d[i5] = new l(jVar.j.get(i5), this, i5, null);
            }
            this.f5840e = new g[jVar.b()];
            for (int i6 = 0; i6 < jVar.b(); i6++) {
                this.f5840e[i6] = new g(jVar.k.get(i6), this, null, i6, true, null);
            }
        }

        public static h k(r.j jVar, h[] hVarArr, boolean z) {
            h hVar = new h(jVar, hVarArr, new c(hVarArr, z), z);
            for (b bVar : hVar.f5837b) {
                bVar.k();
            }
            for (l lVar : hVar.f5839d) {
                j[] jVarArr = lVar.f5861d;
                for (j jVar2 : jVarArr) {
                    c.EnumC0116c cVar = c.EnumC0116c.TYPES_ONLY;
                    i f2 = jVar2.f5850c.f5842g.f(jVar2.f5848a.a(), jVar2, cVar);
                    if (f2 instanceof b) {
                        b bVar2 = (b) f2;
                        i f3 = jVar2.f5850c.f5842g.f(jVar2.f5848a.d(), jVar2, cVar);
                        if (f3 instanceof b) {
                            b bVar3 = (b) f3;
                        } else {
                            StringBuilder g2 = c.a.a.a.a.g('\"');
                            g2.append(jVar2.f5848a.d());
                            g2.append("\" is not a message type.");
                            throw new d(jVar2, g2.toString());
                        }
                    } else {
                        StringBuilder g3 = c.a.a.a.a.g('\"');
                        g3.append(jVar2.f5848a.a());
                        g3.append("\" is not a message type.");
                        throw new d(jVar2, g3.toString());
                    }
                }
            }
            for (g gVar : hVar.f5840e) {
                g.k(gVar);
            }
            return hVar;
        }

        public static h r(String[] strArr, h[] hVarArr) {
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
                    return k(r.j.q.parseFrom(str.getBytes(n0.f5439b)), hVarArr, true);
                } catch (d e2) {
                    StringBuilder h = c.a.a.a.a.h("Invalid embedded descriptor for \"");
                    h.append(jVar.d());
                    h.append("\".");
                    throw new IllegalArgumentException(h.toString(), e2);
                }
            } catch (o0 e3) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e3);
            }
        }

        @Override // c.b.d.s.i
        public h b() {
            return this;
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f5836a.d();
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f5836a.d();
        }

        @Override // c.b.d.s.i
        public f1 i() {
            return this.f5836a;
        }

        public List<b> m() {
            return Collections.unmodifiableList(Arrays.asList(this.f5837b));
        }

        public String n() {
            return this.f5836a.f();
        }

        public a p() {
            a aVar = a.PROTO3;
            return aVar.f5847b.equals(this.f5836a.i()) ? aVar : a.PROTO2;
        }

        public boolean s() {
            return p() == a.PROTO3;
        }

        public h(String str, b bVar) {
            super(null);
            this.f5842g = new c(new h[0], true);
            r.j.b o = r.j.p.toBuilder();
            String str2 = bVar.f5789b + ".placeholder.proto";
            if (str2 != null) {
                o.f5641b |= 1;
                o.f5642c = str2;
                o.onChanged();
                if (str != null) {
                    o.f5641b |= 2;
                    o.f5643d = str;
                    o.onChanged();
                    r.b bVar2 = bVar.f5788a;
                    c2<r.b, r.b.C0111b, Object> c2Var = o.i;
                    if (c2Var != null) {
                        c2Var.f(bVar2);
                    } else if (bVar2 != null) {
                        o.e();
                        o.h.add(bVar2);
                        o.onChanged();
                    } else {
                        throw null;
                    }
                    this.f5836a = o.build();
                    this.f5841f = new h[0];
                    this.f5837b = new b[]{bVar};
                    this.f5838c = new e[0];
                    this.f5839d = new l[0];
                    this.f5840e = new g[0];
                    this.f5842g.a(str, this);
                    this.f5842g.b(bVar);
                    return;
                }
                throw null;
            }
            throw null;
        }
    }

    public static final class b extends i {

        /* renamed from: a  reason: collision with root package name */
        public r.b f5788a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5789b;

        /* renamed from: c  reason: collision with root package name */
        public final h f5790c;

        /* renamed from: d  reason: collision with root package name */
        public final b[] f5791d;

        /* renamed from: e  reason: collision with root package name */
        public final e[] f5792e;

        /* renamed from: f  reason: collision with root package name */
        public final g[] f5793f;

        /* renamed from: g  reason: collision with root package name */
        public final g[] f5794g;
        public final k[] h;

        public b(r.b bVar, h hVar, b bVar2, int i) {
            super(null);
            this.f5788a = bVar;
            this.f5789b = s.a(hVar, bVar2, bVar.d());
            this.f5790c = hVar;
            this.h = new k[bVar.f()];
            for (int i2 = 0; i2 < bVar.f(); i2++) {
                this.h[i2] = new k(bVar.i.get(i2), hVar, this, i2, null);
            }
            this.f5791d = new b[bVar.e()];
            for (int i3 = 0; i3 < bVar.e(); i3++) {
                this.f5791d[i3] = new b(bVar.f5506f.get(i3), hVar, this, i3);
            }
            this.f5792e = new e[bVar.a()];
            for (int i4 = 0; i4 < bVar.a(); i4++) {
                this.f5792e[i4] = new e(bVar.f5507g.get(i4), hVar, this, i4, null);
            }
            this.f5793f = new g[bVar.c()];
            for (int i5 = 0; i5 < bVar.c(); i5++) {
                this.f5793f[i5] = new g(bVar.f5504d.get(i5), hVar, this, i5, false, null);
            }
            this.f5794g = new g[bVar.b()];
            for (int i6 = 0; i6 < bVar.b(); i6++) {
                this.f5794g[i6] = new g(bVar.f5505e.get(i6), hVar, this, i6, true, null);
            }
            for (int i7 = 0; i7 < bVar.f(); i7++) {
                k[] kVarArr = this.h;
                kVarArr[i7].f5857g = new g[kVarArr[i7].f5856f];
                kVarArr[i7].f5856f = 0;
            }
            for (int i8 = 0; i8 < bVar.c(); i8++) {
                g[] gVarArr = this.f5793f;
                k kVar = gVarArr[i8].j;
                if (kVar != null) {
                    g[] gVarArr2 = kVar.f5857g;
                    int i9 = kVar.f5856f;
                    kVar.f5856f = i9 + 1;
                    gVarArr2[i9] = gVarArr[i8];
                }
            }
            hVar.f5842g.b(this);
        }

        @Override // c.b.d.s.i
        public h b() {
            return this.f5790c;
        }

        @Override // c.b.d.s.i
        public String d() {
            return this.f5789b;
        }

        @Override // c.b.d.s.i
        public String f() {
            return this.f5788a.d();
        }

        @Override // c.b.d.s.i
        public f1 i() {
            return this.f5788a;
        }

        public final void k() {
            for (b bVar : this.f5791d) {
                bVar.k();
            }
            for (g gVar : this.f5793f) {
                g.k(gVar);
            }
            for (g gVar2 : this.f5794g) {
                g.k(gVar2);
            }
        }

        public g m(String str) {
            c cVar = this.f5790c.f5842g;
            i c2 = cVar.c(this.f5789b + '.' + str, c.EnumC0116c.ALL_SYMBOLS);
            if (c2 == null || !(c2 instanceof g)) {
                return null;
            }
            return (g) c2;
        }

        public g n(int i) {
            return this.f5790c.f5842g.f5798d.get(new c.a(this, i));
        }

        public List<g> p() {
            return Collections.unmodifiableList(Arrays.asList(this.f5793f));
        }

        public List<b> r() {
            return Collections.unmodifiableList(Arrays.asList(this.f5791d));
        }

        public r.l s() {
            return this.f5788a.g();
        }

        public boolean t(int i) {
            for (r.b.c cVar : this.f5788a.h) {
                if (cVar.f5516c <= i && i < cVar.f5517d) {
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
            r.b.C0111b j = r.b.n.toBuilder();
            if (str2 != null) {
                j.f5508b |= 1;
                j.f5509c = str2;
                j.onChanged();
                r.b.c.C0112b e2 = r.b.c.f5514g.toBuilder();
                e2.f5520b |= 1;
                e2.f5521c = 1;
                e2.onChanged();
                e2.f5520b |= 2;
                e2.f5522d = 536870912;
                e2.onChanged();
                r.b.c a2 = e2.build();
                c2<r.b.c, r.b.c.C0112b, Object> c2Var = j.m;
                if (c2Var == null) {
                    j.e();
                    j.l.add(a2);
                    j.onChanged();
                } else {
                    c2Var.f(a2);
                }
                this.f5788a = j.build();
                this.f5789b = str;
                this.f5791d = new b[0];
                this.f5792e = new e[0];
                this.f5793f = new g[0];
                this.f5794g = new g[0];
                this.h = new k[0];
                this.f5790c = new h(str3, this);
                return;
            }
            throw null;
        }
    }
}
