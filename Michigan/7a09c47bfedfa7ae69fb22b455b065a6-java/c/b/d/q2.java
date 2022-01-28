package c.b.d;

import c.b.d.i1;
import c.b.d.j;
import c.b.d.j2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class q2 implements i1 {

    /* renamed from: d  reason: collision with root package name */
    public static final q2 f5482d = new q2(Collections.emptyMap(), Collections.emptyMap());

    /* renamed from: e  reason: collision with root package name */
    public static final d f5483e = new d();

    /* renamed from: b  reason: collision with root package name */
    public final Map<Integer, c> f5484b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, c> f5485c;

    public static final class b implements i1.a {

        /* renamed from: b  reason: collision with root package name */
        public Map<Integer, c> f5486b;

        /* renamed from: c  reason: collision with root package name */
        public int f5487c;

        /* renamed from: d  reason: collision with root package name */
        public c.a f5488d;

        public b a(int i, c cVar) {
            if (i != 0) {
                if (this.f5488d != null && this.f5487c == i) {
                    this.f5488d = null;
                    this.f5487c = 0;
                }
                if (this.f5486b.isEmpty()) {
                    this.f5486b = new TreeMap();
                }
                this.f5486b.put(Integer.valueOf(i), cVar);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        /* renamed from: b */
        public q2 build() {
            q2 q2Var;
            c(0);
            if (this.f5486b.isEmpty()) {
                q2Var = q2.f5482d;
            } else {
                q2Var = new q2(Collections.unmodifiableMap(this.f5486b), Collections.unmodifiableMap(((TreeMap) this.f5486b).descendingMap()));
            }
            this.f5486b = null;
            return q2Var;
        }

        @Override // c.b.d.i1.a
        public i1 buildPartial() {
            return build();
        }

        public final c.a c(int i) {
            c.a aVar = this.f5488d;
            if (aVar != null) {
                int i2 = this.f5487c;
                if (i == i2) {
                    return aVar;
                }
                a(i2, aVar.e());
            }
            if (i == 0) {
                return null;
            }
            c cVar = this.f5486b.get(Integer.valueOf(i));
            this.f5487c = i;
            c.a c2 = c.c();
            this.f5488d = c2;
            if (cVar != null) {
                c2.f(cVar);
            }
            return this.f5488d;
        }

        @Override // java.lang.Object
        public Object clone() {
            c(0);
            Map unmodifiableMap = Collections.unmodifiableMap(((TreeMap) this.f5486b).descendingMap());
            b b2 = q2.b();
            b2.g(new q2(this.f5486b, unmodifiableMap));
            return b2;
        }

        public b d(int i, c cVar) {
            if (i == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            } else if (i != 0) {
                if (i == this.f5487c || this.f5486b.containsKey(Integer.valueOf(i))) {
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
                b b2 = q2.b();
                kVar.t(i2, b2, x.f5906e);
                c.a c2 = c(i2);
                q2 b3 = b2.build();
                c cVar = c2.f5494a;
                if (cVar.f5493e == null) {
                    cVar.f5493e = new ArrayList();
                }
                c2.f5494a.f5493e.add(b3);
                return true;
            } else if (i3 == 4) {
                return false;
            } else {
                if (i3 == 5) {
                    c(i2).a(kVar.q());
                    return true;
                }
                throw o0.d();
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

        public b g(q2 q2Var) {
            if (q2Var != q2.f5482d) {
                for (Map.Entry<Integer, c> entry : q2Var.f5484b.entrySet()) {
                    d(entry.getKey().intValue(), entry.getValue());
                }
            }
            return this;
        }

        @Override // c.b.d.j1
        public i1 getDefaultInstanceForType() {
            return q2.f5482d;
        }

        public b h(int i, int i2) {
            if (i != 0) {
                c(i).d((long) i2);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        @Override // c.b.d.j1
        public boolean isInitialized() {
            return true;
        }

        @Override // c.b.d.i1.a
        public i1.a mergeFrom(k kVar, z zVar) {
            f(kVar);
            return this;
        }

        @Override // c.b.d.i1.a
        public i1.a mergeFrom(i1 i1Var) {
            if (i1Var instanceof q2) {
                g((q2) i1Var);
                return this;
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public List<Long> f5489a;

        /* renamed from: b  reason: collision with root package name */
        public List<Integer> f5490b;

        /* renamed from: c  reason: collision with root package name */
        public List<Long> f5491c;

        /* renamed from: d  reason: collision with root package name */
        public List<j> f5492d;

        /* renamed from: e  reason: collision with root package name */
        public List<q2> f5493e;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public c f5494a;

            public a a(int i) {
                c cVar = this.f5494a;
                if (cVar.f5490b == null) {
                    cVar.f5490b = new ArrayList();
                }
                this.f5494a.f5490b.add(Integer.valueOf(i));
                return this;
            }

            public a b(long j) {
                c cVar = this.f5494a;
                if (cVar.f5491c == null) {
                    cVar.f5491c = new ArrayList();
                }
                this.f5494a.f5491c.add(Long.valueOf(j));
                return this;
            }

            public a c(j jVar) {
                c cVar = this.f5494a;
                if (cVar.f5492d == null) {
                    cVar.f5492d = new ArrayList();
                }
                this.f5494a.f5492d.add(jVar);
                return this;
            }

            public a d(long j) {
                c cVar = this.f5494a;
                if (cVar.f5489a == null) {
                    cVar.f5489a = new ArrayList();
                }
                this.f5494a.f5489a.add(Long.valueOf(j));
                return this;
            }

            public c e() {
                List<Long> unmodifiableList;
                List<Integer> unmodifiableList2;
                List<Long> unmodifiableList3;
                List<j> unmodifiableList4;
                List<q2> unmodifiableList5;
                c cVar = this.f5494a;
                List<Long> list = cVar.f5489a;
                if (list == null) {
                    unmodifiableList = Collections.emptyList();
                } else {
                    unmodifiableList = Collections.unmodifiableList(list);
                }
                cVar.f5489a = unmodifiableList;
                c cVar2 = this.f5494a;
                List<Integer> list2 = cVar2.f5490b;
                if (list2 == null) {
                    unmodifiableList2 = Collections.emptyList();
                } else {
                    unmodifiableList2 = Collections.unmodifiableList(list2);
                }
                cVar2.f5490b = unmodifiableList2;
                c cVar3 = this.f5494a;
                List<Long> list3 = cVar3.f5491c;
                if (list3 == null) {
                    unmodifiableList3 = Collections.emptyList();
                } else {
                    unmodifiableList3 = Collections.unmodifiableList(list3);
                }
                cVar3.f5491c = unmodifiableList3;
                c cVar4 = this.f5494a;
                List<j> list4 = cVar4.f5492d;
                if (list4 == null) {
                    unmodifiableList4 = Collections.emptyList();
                } else {
                    unmodifiableList4 = Collections.unmodifiableList(list4);
                }
                cVar4.f5492d = unmodifiableList4;
                c cVar5 = this.f5494a;
                List<q2> list5 = cVar5.f5493e;
                if (list5 == null) {
                    unmodifiableList5 = Collections.emptyList();
                } else {
                    unmodifiableList5 = Collections.unmodifiableList(list5);
                }
                cVar5.f5493e = unmodifiableList5;
                c cVar6 = this.f5494a;
                this.f5494a = null;
                return cVar6;
            }

            public a f(c cVar) {
                if (!cVar.f5489a.isEmpty()) {
                    c cVar2 = this.f5494a;
                    if (cVar2.f5489a == null) {
                        cVar2.f5489a = new ArrayList();
                    }
                    this.f5494a.f5489a.addAll(cVar.f5489a);
                }
                if (!cVar.f5490b.isEmpty()) {
                    c cVar3 = this.f5494a;
                    if (cVar3.f5490b == null) {
                        cVar3.f5490b = new ArrayList();
                    }
                    this.f5494a.f5490b.addAll(cVar.f5490b);
                }
                if (!cVar.f5491c.isEmpty()) {
                    c cVar4 = this.f5494a;
                    if (cVar4.f5491c == null) {
                        cVar4.f5491c = new ArrayList();
                    }
                    this.f5494a.f5491c.addAll(cVar.f5491c);
                }
                if (!cVar.f5492d.isEmpty()) {
                    c cVar5 = this.f5494a;
                    if (cVar5.f5492d == null) {
                        cVar5.f5492d = new ArrayList();
                    }
                    this.f5494a.f5492d.addAll(cVar.f5492d);
                }
                if (!cVar.f5493e.isEmpty()) {
                    c cVar6 = this.f5494a;
                    if (cVar6.f5493e == null) {
                        cVar6.f5493e = new ArrayList();
                    }
                    this.f5494a.f5493e.addAll(cVar.f5493e);
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

        public static void a(c cVar, int i, y2 y2Var) {
            if (cVar != null) {
                n nVar = (n) y2Var;
                if (nVar != null) {
                    for (j jVar : cVar.f5492d) {
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
            aVar.f5494a = new c(null);
            return aVar;
        }

        public final Object[] b() {
            return new Object[]{this.f5489a, this.f5490b, this.f5491c, this.f5492d, this.f5493e};
        }

        public void d(int i, y2 y2Var) {
            n nVar = (n) y2Var;
            nVar.g(i, this.f5489a, false);
            nVar.c(i, this.f5490b, false);
            nVar.d(i, this.f5491c, false);
            nVar.a(i, this.f5492d);
            for (int i2 = 0; i2 < this.f5493e.size(); i2++) {
                nVar.f5437a.r0(i, 3);
                this.f5493e.get(i2).f(nVar);
                nVar.f5437a.r0(i, 4);
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

    public static final class d extends c<q2> {
        @Override // c.b.d.w1
        public Object parsePartialFrom(k kVar, z zVar) {
            b b2 = q2.b();
            try {
                b2.f(kVar);
                return b2.build();
            } catch (o0 e2) {
                e2.f5447b = b2.build();
                throw e2;
            } catch (IOException e3) {
                o0 o0Var = new o0(e3);
                o0Var.f5447b = b2.build();
                throw o0Var;
            }
        }
    }

    public q2() {
        this.f5484b = null;
        this.f5485c = null;
    }

    public q2(Map<Integer, c> map, Map<Integer, c> map2) {
        this.f5484b = map;
        this.f5485c = map2;
    }

    public static b b() {
        b bVar = new b();
        bVar.f5486b = Collections.emptyMap();
        bVar.f5487c = 0;
        bVar.f5488d = null;
        return bVar;
    }

    public static b c(q2 q2Var) {
        b b2 = b();
        b2.g(q2Var);
        return b2;
    }

    public int a() {
        int i = 0;
        for (Map.Entry<Integer, c> entry : this.f5484b.entrySet()) {
            int intValue = entry.getKey().intValue();
            int i2 = 0;
            for (j jVar : entry.getValue().f5492d) {
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
        for (Map.Entry<Integer, c> entry : this.f5484b.entrySet()) {
            int intValue = entry.getKey().intValue();
            for (j jVar : entry.getValue().f5492d) {
                mVar.o0(intValue, jVar);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q2) && this.f5484b.equals(((q2) obj).f5484b);
    }

    public void f(y2 y2Var) {
        if (((n) y2Var) != null) {
            for (Map.Entry<Integer, c> entry : this.f5484b.entrySet()) {
                entry.getValue().d(entry.getKey().intValue(), y2Var);
            }
            return;
        }
        throw null;
    }

    @Override // c.b.d.j1
    public i1 getDefaultInstanceForType() {
        return f5482d;
    }

    @Override // c.b.d.i1
    public w1 getParserForType() {
        return f5483e;
    }

    @Override // c.b.d.i1
    public int getSerializedSize() {
        int i = 0;
        for (Map.Entry<Integer, c> entry : this.f5484b.entrySet()) {
            c value = entry.getValue();
            int intValue = entry.getKey().intValue();
            int i2 = 0;
            for (Long l : value.f5489a) {
                i2 += m.Q(intValue, l.longValue());
            }
            for (Integer num : value.f5490b) {
                i2 += m.k(intValue, num.intValue());
            }
            for (Long l2 : value.f5491c) {
                i2 += m.m(intValue, l2.longValue());
            }
            for (j jVar : value.f5492d) {
                i2 += m.f(intValue, jVar);
            }
            for (q2 q2Var : value.f5493e) {
                i2 += m.r(q2Var) + (m.N(intValue) * 2);
            }
            i += i2;
        }
        return i;
    }

    public int hashCode() {
        return this.f5484b.hashCode();
    }

    @Override // c.b.d.j1
    public boolean isInitialized() {
        return true;
    }

    @Override // c.b.d.i1
    public i1.a newBuilderForType() {
        return b();
    }

    @Override // c.b.d.i1
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

    @Override // c.b.d.i1
    public j toByteString() {
        try {
            j.e p = j.p(getSerializedSize());
            writeTo(p.f5325a);
            return p.a();
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e2);
        }
    }

    public String toString() {
        if (j2.i() != null) {
            try {
                StringBuilder sb = new StringBuilder();
                j2.c.e(this, j2.a(sb));
                return sb.toString();
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            throw null;
        }
    }

    @Override // c.b.d.i1
    public void writeTo(m mVar) {
        for (Map.Entry<Integer, c> entry : this.f5484b.entrySet()) {
            c value = entry.getValue();
            int intValue = entry.getKey().intValue();
            for (Long l : value.f5489a) {
                mVar.u0(intValue, l.longValue());
            }
            for (Integer num : value.f5490b) {
                mVar.d0(intValue, num.intValue());
            }
            for (Long l2 : value.f5491c) {
                mVar.f0(intValue, l2.longValue());
            }
            for (j jVar : value.f5492d) {
                mVar.a0(intValue, jVar);
            }
            for (q2 q2Var : value.f5493e) {
                mVar.h0(intValue, q2Var);
            }
        }
    }
}
