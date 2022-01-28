package c.b.d;

import c.b.d.h1;
import c.b.d.i2;
import c.b.d.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class p2 implements h1 {

    /* renamed from: d  reason: collision with root package name */
    public static final p2 f4026d = new p2(Collections.emptyMap(), Collections.emptyMap());

    /* renamed from: e  reason: collision with root package name */
    public static final d f4027e = new d();

    /* renamed from: b  reason: collision with root package name */
    public final Map<Integer, c> f4028b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, c> f4029c;

    public static final class b implements h1.a {

        /* renamed from: b  reason: collision with root package name */
        public Map<Integer, c> f4030b;

        /* renamed from: c  reason: collision with root package name */
        public int f4031c;

        /* renamed from: d  reason: collision with root package name */
        public c.a f4032d;

        public b a(int i, c cVar) {
            if (i != 0) {
                if (this.f4032d != null && this.f4031c == i) {
                    this.f4032d = null;
                    this.f4031c = 0;
                }
                if (this.f4030b.isEmpty()) {
                    this.f4030b = new TreeMap();
                }
                this.f4030b.put(Integer.valueOf(i), cVar);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        /* renamed from: b */
        public p2 build() {
            p2 p2Var;
            c(0);
            if (this.f4030b.isEmpty()) {
                p2Var = p2.f4026d;
            } else {
                p2Var = new p2(Collections.unmodifiableMap(this.f4030b), Collections.unmodifiableMap(((TreeMap) this.f4030b).descendingMap()));
            }
            this.f4030b = null;
            return p2Var;
        }

        @Override // c.b.d.h1.a
        public h1 buildPartial() {
            return build();
        }

        public final c.a c(int i) {
            c.a aVar = this.f4032d;
            if (aVar != null) {
                int i2 = this.f4031c;
                if (i == i2) {
                    return aVar;
                }
                a(i2, aVar.e());
            }
            if (i == 0) {
                return null;
            }
            c cVar = this.f4030b.get(Integer.valueOf(i));
            this.f4031c = i;
            c.a c2 = c.c();
            this.f4032d = c2;
            if (cVar != null) {
                c2.f(cVar);
            }
            return this.f4032d;
        }

        @Override // java.lang.Object
        public Object clone() {
            c(0);
            Map unmodifiableMap = Collections.unmodifiableMap(((TreeMap) this.f4030b).descendingMap());
            b b2 = p2.b();
            b2.g(new p2(this.f4030b, unmodifiableMap));
            return b2;
        }

        public b d(int i, c cVar) {
            if (i == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            } else if (i != 0) {
                if (i == this.f4031c || this.f4030b.containsKey(Integer.valueOf(i))) {
                    c(i).f(cVar);
                } else {
                    a(i, cVar);
                }
                return this;
            } else {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
        }

        public boolean e(int i, k kVar) {
            int i2 = i >>> 3;
            int i3 = i & 7;
            if (i3 == 0) {
                c(i2).d(kVar.v());
                return true;
            } else if (i3 == 1) {
                c(i2).b(kVar.r());
                return true;
            } else if (i3 == 2) {
                c(i2).c(kVar.n());
                return true;
            } else if (i3 == 3) {
                b b2 = p2.b();
                kVar.t(i2, b2, x.f4383e);
                c.a c2 = c(i2);
                p2 b3 = b2.build();
                c cVar = c2.f4038a;
                if (cVar.f4037e == null) {
                    cVar.f4037e = new ArrayList();
                }
                c2.f4038a.f4037e.add(b3);
                return true;
            } else if (i3 == 4) {
                return false;
            } else {
                if (i3 == 5) {
                    c(i2).a(kVar.q());
                    return true;
                }
                throw n0.d();
            }
        }

        public b f(k kVar) {
            int G;
            do {
                G = kVar.G();
                if (G == 0) {
                    break;
                }
            } while (e(G, kVar));
            return this;
        }

        public b g(p2 p2Var) {
            if (p2Var != p2.f4026d) {
                for (Map.Entry<Integer, c> entry : p2Var.f4028b.entrySet()) {
                    d(entry.getKey().intValue(), entry.getValue());
                }
            }
            return this;
        }

        @Override // c.b.d.i1
        public h1 getDefaultInstanceForType() {
            return p2.f4026d;
        }

        public b h(int i, int i2) {
            if (i != 0) {
                c(i).d((long) i2);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        @Override // c.b.d.i1
        public boolean isInitialized() {
            return true;
        }

        @Override // c.b.d.h1.a
        public h1.a mergeFrom(k kVar, z zVar) {
            f(kVar);
            return this;
        }

        @Override // c.b.d.h1.a
        public h1.a mergeFrom(h1 h1Var) {
            if (h1Var instanceof p2) {
                g((p2) h1Var);
                return this;
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public List<Long> f4033a;

        /* renamed from: b  reason: collision with root package name */
        public List<Integer> f4034b;

        /* renamed from: c  reason: collision with root package name */
        public List<Long> f4035c;

        /* renamed from: d  reason: collision with root package name */
        public List<j> f4036d;

        /* renamed from: e  reason: collision with root package name */
        public List<p2> f4037e;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public c f4038a;

            public a a(int i) {
                c cVar = this.f4038a;
                if (cVar.f4034b == null) {
                    cVar.f4034b = new ArrayList();
                }
                this.f4038a.f4034b.add(Integer.valueOf(i));
                return this;
            }

            public a b(long j) {
                c cVar = this.f4038a;
                if (cVar.f4035c == null) {
                    cVar.f4035c = new ArrayList();
                }
                this.f4038a.f4035c.add(Long.valueOf(j));
                return this;
            }

            public a c(j jVar) {
                c cVar = this.f4038a;
                if (cVar.f4036d == null) {
                    cVar.f4036d = new ArrayList();
                }
                this.f4038a.f4036d.add(jVar);
                return this;
            }

            public a d(long j) {
                c cVar = this.f4038a;
                if (cVar.f4033a == null) {
                    cVar.f4033a = new ArrayList();
                }
                this.f4038a.f4033a.add(Long.valueOf(j));
                return this;
            }

            public c e() {
                List<Long> unmodifiableList;
                List<Integer> unmodifiableList2;
                List<Long> unmodifiableList3;
                List<j> unmodifiableList4;
                List<p2> unmodifiableList5;
                c cVar = this.f4038a;
                List<Long> list = cVar.f4033a;
                if (list == null) {
                    unmodifiableList = Collections.emptyList();
                } else {
                    unmodifiableList = Collections.unmodifiableList(list);
                }
                cVar.f4033a = unmodifiableList;
                c cVar2 = this.f4038a;
                List<Integer> list2 = cVar2.f4034b;
                if (list2 == null) {
                    unmodifiableList2 = Collections.emptyList();
                } else {
                    unmodifiableList2 = Collections.unmodifiableList(list2);
                }
                cVar2.f4034b = unmodifiableList2;
                c cVar3 = this.f4038a;
                List<Long> list3 = cVar3.f4035c;
                if (list3 == null) {
                    unmodifiableList3 = Collections.emptyList();
                } else {
                    unmodifiableList3 = Collections.unmodifiableList(list3);
                }
                cVar3.f4035c = unmodifiableList3;
                c cVar4 = this.f4038a;
                List<j> list4 = cVar4.f4036d;
                if (list4 == null) {
                    unmodifiableList4 = Collections.emptyList();
                } else {
                    unmodifiableList4 = Collections.unmodifiableList(list4);
                }
                cVar4.f4036d = unmodifiableList4;
                c cVar5 = this.f4038a;
                List<p2> list5 = cVar5.f4037e;
                if (list5 == null) {
                    unmodifiableList5 = Collections.emptyList();
                } else {
                    unmodifiableList5 = Collections.unmodifiableList(list5);
                }
                cVar5.f4037e = unmodifiableList5;
                c cVar6 = this.f4038a;
                this.f4038a = null;
                return cVar6;
            }

            public a f(c cVar) {
                if (!cVar.f4033a.isEmpty()) {
                    c cVar2 = this.f4038a;
                    if (cVar2.f4033a == null) {
                        cVar2.f4033a = new ArrayList();
                    }
                    this.f4038a.f4033a.addAll(cVar.f4033a);
                }
                if (!cVar.f4034b.isEmpty()) {
                    c cVar3 = this.f4038a;
                    if (cVar3.f4034b == null) {
                        cVar3.f4034b = new ArrayList();
                    }
                    this.f4038a.f4034b.addAll(cVar.f4034b);
                }
                if (!cVar.f4035c.isEmpty()) {
                    c cVar4 = this.f4038a;
                    if (cVar4.f4035c == null) {
                        cVar4.f4035c = new ArrayList();
                    }
                    this.f4038a.f4035c.addAll(cVar.f4035c);
                }
                if (!cVar.f4036d.isEmpty()) {
                    c cVar5 = this.f4038a;
                    if (cVar5.f4036d == null) {
                        cVar5.f4036d = new ArrayList();
                    }
                    this.f4038a.f4036d.addAll(cVar.f4036d);
                }
                if (!cVar.f4037e.isEmpty()) {
                    c cVar6 = this.f4038a;
                    if (cVar6.f4037e == null) {
                        cVar6.f4037e = new ArrayList();
                    }
                    this.f4038a.f4037e.addAll(cVar.f4037e);
                }
                return this;
            }
        }

        static {
            c().e();
        }

        public c() {
        }

        public c(a aVar) {
        }

        public static void a(c cVar, int i, x2 x2Var) {
            if (cVar != null) {
                n nVar = (n) x2Var;
                if (nVar != null) {
                    for (j jVar : cVar.f4036d) {
                        nVar.i(i, jVar);
                    }
                    return;
                }
                throw null;
            }
            throw null;
        }

        public static a c() {
            a aVar = new a();
            aVar.f4038a = new c(null);
            return aVar;
        }

        public final Object[] b() {
            return new Object[]{this.f4033a, this.f4034b, this.f4035c, this.f4036d, this.f4037e};
        }

        public void d(int i, x2 x2Var) {
            n nVar = (n) x2Var;
            nVar.g(i, this.f4033a, false);
            nVar.c(i, this.f4034b, false);
            nVar.d(i, this.f4035c, false);
            nVar.a(i, this.f4036d);
            for (int i2 = 0; i2 < this.f4037e.size(); i2++) {
                nVar.f4006a.r0(i, 3);
                this.f4037e.get(i2).f(nVar);
                nVar.f4006a.r0(i, 4);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            return Arrays.equals(b(), ((c) obj).b());
        }

        public int hashCode() {
            return Arrays.hashCode(b());
        }
    }

    public static final class d extends c<p2> {
        @Override // c.b.d.v1
        public Object parsePartialFrom(k kVar, z zVar) {
            b b2 = p2.b();
            try {
                b2.f(kVar);
                return b2.build();
            } catch (n0 e2) {
                e2.f4007b = b2.build();
                throw e2;
            } catch (IOException e3) {
                n0 n0Var = new n0(e3);
                n0Var.f4007b = b2.build();
                throw n0Var;
            }
        }
    }

    public p2() {
        this.f4028b = null;
        this.f4029c = null;
    }

    public p2(Map<Integer, c> map, Map<Integer, c> map2) {
        this.f4028b = map;
        this.f4029c = map2;
    }

    public static b b() {
        b bVar = new b();
        bVar.f4030b = Collections.emptyMap();
        bVar.f4031c = 0;
        bVar.f4032d = null;
        return bVar;
    }

    public static b c(p2 p2Var) {
        b b2 = b();
        b2.g(p2Var);
        return b2;
    }

    public int a() {
        int i = 0;
        for (Map.Entry<Integer, c> entry : this.f4028b.entrySet()) {
            int intValue = entry.getKey().intValue();
            int i2 = 0;
            for (j jVar : entry.getValue().f4036d) {
                i2 += m.C(intValue, jVar);
            }
            i += i2;
        }
        return i;
    }

    /* renamed from: d */
    public b toBuilder() {
        b b2 = b();
        b2.g(this);
        return b2;
    }

    public void e(m mVar) {
        for (Map.Entry<Integer, c> entry : this.f4028b.entrySet()) {
            int intValue = entry.getKey().intValue();
            for (j jVar : entry.getValue().f4036d) {
                mVar.o0(intValue, jVar);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p2) && this.f4028b.equals(((p2) obj).f4028b);
    }

    public void f(x2 x2Var) {
        if (((n) x2Var) != null) {
            for (Map.Entry<Integer, c> entry : this.f4028b.entrySet()) {
                entry.getValue().d(entry.getKey().intValue(), x2Var);
            }
            return;
        }
        throw null;
    }

    @Override // c.b.d.i1
    public h1 getDefaultInstanceForType() {
        return f4026d;
    }

    @Override // c.b.d.h1
    public v1 getParserForType() {
        return f4027e;
    }

    @Override // c.b.d.h1
    public int getSerializedSize() {
        int i = 0;
        for (Map.Entry<Integer, c> entry : this.f4028b.entrySet()) {
            c value = entry.getValue();
            int intValue = entry.getKey().intValue();
            int i2 = 0;
            for (Long l : value.f4033a) {
                i2 += m.Q(intValue, l.longValue());
            }
            for (Integer num : value.f4034b) {
                i2 += m.k(intValue, num.intValue());
            }
            for (Long l2 : value.f4035c) {
                i2 += m.m(intValue, l2.longValue());
            }
            for (j jVar : value.f4036d) {
                i2 += m.f(intValue, jVar);
            }
            for (p2 p2Var : value.f4037e) {
                i2 += m.r(p2Var) + (m.N(intValue) * 2);
            }
            i += i2;
        }
        return i;
    }

    public int hashCode() {
        return this.f4028b.hashCode();
    }

    @Override // c.b.d.i1
    public boolean isInitialized() {
        return true;
    }

    @Override // c.b.d.h1
    public h1.a newBuilderForType() {
        return b();
    }

    @Override // c.b.d.h1
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            m V = m.V(bArr);
            writeTo(V);
            V.b();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    @Override // c.b.d.h1
    public j toByteString() {
        try {
            j.e p = j.p(getSerializedSize());
            writeTo(p.f3917a);
            return p.a();
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e2);
        }
    }

    public String toString() {
        if (i2.i() != null) {
            try {
                StringBuilder sb = new StringBuilder();
                i2.c.e(this, i2.a(sb));
                return sb.toString();
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            throw null;
        }
    }

    @Override // c.b.d.h1
    public void writeTo(m mVar) {
        for (Map.Entry<Integer, c> entry : this.f4028b.entrySet()) {
            c value = entry.getValue();
            int intValue = entry.getKey().intValue();
            for (Long l : value.f4033a) {
                mVar.u0(intValue, l.longValue());
            }
            for (Integer num : value.f4034b) {
                mVar.d0(intValue, num.intValue());
            }
            for (Long l2 : value.f4035c) {
                mVar.f0(intValue, l2.longValue());
            }
            for (j jVar : value.f4036d) {
                mVar.a0(intValue, jVar);
            }
            for (p2 p2Var : value.f4037e) {
                mVar.h0(intValue, p2Var);
            }
        }
    }
}
