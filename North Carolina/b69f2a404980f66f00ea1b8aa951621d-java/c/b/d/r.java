package c.b.d;

import androidx.recyclerview.widget.RecyclerView;
import c.b.d.a;
import c.b.d.e1;
import c.b.d.h1;
import c.b.d.k0;
import c.b.d.m0;
import c.b.d.p2;
import c.b.d.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class r {
    public static final k0.f A;
    public static final s.b B;
    public static final k0.f C;
    public static final s.b D;
    public static final k0.f E;
    public static final s.b F;
    public static final k0.f G;
    public static final s.b H;
    public static final k0.f I;
    public static final s.b J;
    public static final k0.f K;
    public static final s.b L;
    public static final k0.f M;
    public static final s.b N;
    public static final k0.f O;
    public static final s.b P;
    public static final k0.f Q;
    public static final s.b R;
    public static final k0.f S;
    public static final s.b T;
    public static final k0.f U;
    public static final s.b V;
    public static final k0.f W;
    public static final s.b X;
    public static final s.b Y;
    public static s.h Z;

    /* renamed from: a  reason: collision with root package name */
    public static final s.b f4061a;

    /* renamed from: b  reason: collision with root package name */
    public static final s.b f4062b;

    /* renamed from: c  reason: collision with root package name */
    public static final k0.f f4063c;

    /* renamed from: d  reason: collision with root package name */
    public static final s.b f4064d;

    /* renamed from: e  reason: collision with root package name */
    public static final k0.f f4065e;
    public static final s.b f;
    public static final k0.f g;
    public static final s.b h;
    public static final k0.f i;
    public static final s.b j;
    public static final k0.f k;
    public static final s.b l;
    public static final k0.f m;
    public static final s.b n;
    public static final k0.f o;
    public static final s.b p;
    public static final k0.f q;
    public static final s.b r;
    public static final k0.f s;
    public static final s.b t;
    public static final k0.f u;
    public static final s.b v;
    public static final k0.f w;
    public static final s.b x;
    public static final k0.f y;
    public static final s.b z;

    public static final class b extends k0 implements j1 {
        public static final b n = new b();
        @Deprecated
        public static final v1<b> o = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f4066b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f4067c;

        /* renamed from: d  reason: collision with root package name */
        public List<h> f4068d;

        /* renamed from: e  reason: collision with root package name */
        public List<h> f4069e;
        public List<b> f;
        public List<c> g;
        public List<c> h;
        public List<o> i;
        public l j;
        public List<d> k;
        public s0 l;
        public byte m;

        public static class a extends c<b> {
            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                Object obj;
                List list;
                b bVar = new b();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            switch (G) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    j n = kVar.n();
                                    bVar.f4066b = 1 | bVar.f4066b;
                                    bVar.f4067c = n;
                                    break;
                                case 18:
                                    if (!z2 || !true) {
                                        bVar.f4068d = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = bVar.f4068d;
                                    obj = h.o;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 26:
                                    if (!z2 || !true) {
                                        bVar.f = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = bVar.f;
                                    obj = b.o;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 34:
                                    if (!z2 || !true) {
                                        bVar.g = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = bVar.g;
                                    obj = c.j;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 42:
                                    if (!z2 || !true) {
                                        bVar.h = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = bVar.h;
                                    obj = c.h;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 50:
                                    if (!z2 || !true) {
                                        bVar.f4069e = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = bVar.f4069e;
                                    obj = h.o;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 58:
                                    l.b j = (bVar.f4066b & 2) != 0 ? bVar.j.toBuilder() : null;
                                    l lVar = (l) kVar.w(l.k, zVar);
                                    bVar.j = lVar;
                                    if (j != null) {
                                        j.o(lVar);
                                        bVar.j = j.buildPartial();
                                    }
                                    bVar.f4066b |= 2;
                                    break;
                                case 66:
                                    if (!z2 || !true) {
                                        bVar.i = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = bVar.i;
                                    obj = o.g;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 74:
                                    if (!z2 || !true) {
                                        bVar.k = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = bVar.k;
                                    obj = d.g;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 82:
                                    j n2 = kVar.n();
                                    if (!z2 || !true) {
                                        bVar.l = new r0(10);
                                        z2 |= true;
                                    }
                                    bVar.l.l(n2);
                                    break;
                                default:
                                    if (bVar.parseUnknownField(kVar, b2, zVar, G)) {
                                        break;
                                    }
                                    z = true;
                                    break;
                            }
                        } catch (n0 e2) {
                            e2.f4007b = bVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = bVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                bVar.f4068d = Collections.unmodifiableList(bVar.f4068d);
                            }
                            if (z2 && true) {
                                bVar.f = Collections.unmodifiableList(bVar.f);
                            }
                            if (z2 && true) {
                                bVar.g = Collections.unmodifiableList(bVar.g);
                            }
                            if (z2 && true) {
                                bVar.h = Collections.unmodifiableList(bVar.h);
                            }
                            if (z2 && true) {
                                bVar.f4069e = Collections.unmodifiableList(bVar.f4069e);
                            }
                            if (z2 && true) {
                                bVar.i = Collections.unmodifiableList(bVar.i);
                            }
                            if (z2 && true) {
                                bVar.k = Collections.unmodifiableList(bVar.k);
                            }
                            if (z2 && true) {
                                bVar.l = bVar.l.b();
                            }
                            bVar.unknownFields = b2.build();
                            bVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        bVar.f4068d = Collections.unmodifiableList(bVar.f4068d);
                    }
                    if (z2 && true) {
                        bVar.f = Collections.unmodifiableList(bVar.f);
                    }
                    if (z2 && true) {
                        bVar.g = Collections.unmodifiableList(bVar.g);
                    }
                    if (z2 && true) {
                        bVar.h = Collections.unmodifiableList(bVar.h);
                    }
                    if (z2 && true) {
                        bVar.f4069e = Collections.unmodifiableList(bVar.f4069e);
                    }
                    if (z2 && true) {
                        bVar.i = Collections.unmodifiableList(bVar.i);
                    }
                    if (z2 && true) {
                        bVar.k = Collections.unmodifiableList(bVar.k);
                    }
                    if (z2 && true) {
                        bVar.l = bVar.l.b();
                    }
                    bVar.unknownFields = b2.build();
                    bVar.makeExtensionsImmutable();
                    return bVar;
                }
                throw null;
            }
        }

        /* renamed from: c.b.d.r$b$b  reason: collision with other inner class name */
        public static final class C0102b extends k0.b<C0102b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f4070b;

            /* renamed from: c  reason: collision with root package name */
            public Object f4071c = "";

            /* renamed from: d  reason: collision with root package name */
            public List<h> f4072d = Collections.emptyList();

            /* renamed from: e  reason: collision with root package name */
            public b2<h, h.b, Object> f4073e;
            public List<h> f = Collections.emptyList();
            public b2<h, h.b, Object> g;
            public List<b> h = Collections.emptyList();
            public b2<b, C0102b, Object> i;
            public List<c> j = Collections.emptyList();
            public b2<c, c.b, Object> k;
            public List<c> l = Collections.emptyList();
            public b2<c, c.C0103b, Object> m;
            public List<o> n = Collections.emptyList();
            public b2<o, o.b, Object> o;
            public l p;
            public f2<l, l.b, Object> q;
            public List<d> r = Collections.emptyList();
            public b2<d, d.C0104b, Object> s;
            public s0 t = r0.f4261e;

            public C0102b() {
                maybeForceBuilderInitialization();
            }

            public C0102b(a aVar) {
                maybeForceBuilderInitialization();
            }

            /* renamed from: a */
            public b build() {
                b b2 = buildPartial();
                if (b2.isInitialized()) {
                    return b2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) b2);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public C0102b m9addRepeatedField(s.g gVar, Object obj) {
                return (C0102b) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: b */
            public b buildPartial() {
                List<h> list;
                List<h> list2;
                List<b> list3;
                List<c> list4;
                List<c> list5;
                List<o> list6;
                List<d> list7;
                b bVar = new b(this, null);
                int i2 = this.f4070b;
                int i3 = (i2 & 1) != 0 ? 1 : 0;
                bVar.f4067c = this.f4071c;
                b2<h, h.b, Object> b2Var = this.f4073e;
                if (b2Var == null) {
                    if ((this.f4070b & 2) != 0) {
                        this.f4072d = Collections.unmodifiableList(this.f4072d);
                        this.f4070b &= -3;
                    }
                    list = this.f4072d;
                } else {
                    list = b2Var.g();
                }
                bVar.f4068d = list;
                b2<h, h.b, Object> b2Var2 = this.g;
                if (b2Var2 == null) {
                    if ((this.f4070b & 4) != 0) {
                        this.f = Collections.unmodifiableList(this.f);
                        this.f4070b &= -5;
                    }
                    list2 = this.f;
                } else {
                    list2 = b2Var2.g();
                }
                bVar.f4069e = list2;
                b2<b, C0102b, Object> b2Var3 = this.i;
                if (b2Var3 == null) {
                    if ((this.f4070b & 8) != 0) {
                        this.h = Collections.unmodifiableList(this.h);
                        this.f4070b &= -9;
                    }
                    list3 = this.h;
                } else {
                    list3 = b2Var3.g();
                }
                bVar.f = list3;
                b2<c, c.b, Object> b2Var4 = this.k;
                if (b2Var4 == null) {
                    if ((this.f4070b & 16) != 0) {
                        this.j = Collections.unmodifiableList(this.j);
                        this.f4070b &= -17;
                    }
                    list4 = this.j;
                } else {
                    list4 = b2Var4.g();
                }
                bVar.g = list4;
                b2<c, c.C0103b, Object> b2Var5 = this.m;
                if (b2Var5 == null) {
                    if ((this.f4070b & 32) != 0) {
                        this.l = Collections.unmodifiableList(this.l);
                        this.f4070b &= -33;
                    }
                    list5 = this.l;
                } else {
                    list5 = b2Var5.g();
                }
                bVar.h = list5;
                b2<o, o.b, Object> b2Var6 = this.o;
                if (b2Var6 == null) {
                    if ((this.f4070b & 64) != 0) {
                        this.n = Collections.unmodifiableList(this.n);
                        this.f4070b &= -65;
                    }
                    list6 = this.n;
                } else {
                    list6 = b2Var6.g();
                }
                bVar.i = list6;
                if ((i2 & RecyclerView.d0.FLAG_IGNORE) != 0) {
                    f2<l, l.b, Object> f2Var = this.q;
                    bVar.j = f2Var == null ? this.p : f2Var.b();
                    i3 |= 2;
                }
                b2<d, d.C0104b, Object> b2Var7 = this.s;
                if (b2Var7 == null) {
                    if ((this.f4070b & RecyclerView.d0.FLAG_TMP_DETACHED) != 0) {
                        this.r = Collections.unmodifiableList(this.r);
                        this.f4070b &= -257;
                    }
                    list7 = this.r;
                } else {
                    list7 = b2Var7.g();
                }
                bVar.k = list7;
                if ((this.f4070b & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                    this.t = this.t.b();
                    this.f4070b &= -513;
                }
                bVar.l = this.t;
                bVar.f4066b = i3;
                onBuilt();
                return bVar;
            }

            public C0102b c() {
                super.clear();
                this.f4071c = "";
                this.f4070b &= -2;
                b2<h, h.b, Object> b2Var = this.f4073e;
                if (b2Var == null) {
                    this.f4072d = Collections.emptyList();
                    this.f4070b &= -3;
                } else {
                    b2Var.h();
                }
                b2<h, h.b, Object> b2Var2 = this.g;
                if (b2Var2 == null) {
                    this.f = Collections.emptyList();
                    this.f4070b &= -5;
                } else {
                    b2Var2.h();
                }
                b2<b, C0102b, Object> b2Var3 = this.i;
                if (b2Var3 == null) {
                    this.h = Collections.emptyList();
                    this.f4070b &= -9;
                } else {
                    b2Var3.h();
                }
                b2<c, c.b, Object> b2Var4 = this.k;
                if (b2Var4 == null) {
                    this.j = Collections.emptyList();
                    this.f4070b &= -17;
                } else {
                    b2Var4.h();
                }
                b2<c, c.C0103b, Object> b2Var5 = this.m;
                if (b2Var5 == null) {
                    this.l = Collections.emptyList();
                    this.f4070b &= -33;
                } else {
                    b2Var5.h();
                }
                b2<o, o.b, Object> b2Var6 = this.o;
                if (b2Var6 == null) {
                    this.n = Collections.emptyList();
                    this.f4070b &= -65;
                } else {
                    b2Var6.h();
                }
                f2<l, l.b, Object> f2Var = this.q;
                if (f2Var == null) {
                    this.p = null;
                } else {
                    f2Var.c();
                }
                this.f4070b &= -129;
                b2<d, d.C0104b, Object> b2Var7 = this.s;
                if (b2Var7 == null) {
                    this.r = Collections.emptyList();
                    this.f4070b &= -257;
                } else {
                    b2Var7.h();
                }
                this.t = r0.f4261e;
                this.f4070b &= -513;
                return this;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public C0102b m10clearField(s.g gVar) {
                return (C0102b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public C0102b clearOneof(s.k kVar) {
                return (C0102b) super.clearOneof(kVar);
            }

            /* renamed from: d */
            public C0102b clone() {
                return (C0102b) super.clone();
            }

            public final void e() {
                if ((this.f4070b & 32) == 0) {
                    this.l = new ArrayList(this.l);
                    this.f4070b |= 32;
                }
            }

            public final b2<c, c.b, Object> f() {
                if (this.k == null) {
                    this.k = new b2<>(this.j, (this.f4070b & 16) != 0, getParentForChildren(), isClean());
                    this.j = null;
                }
                return this.k;
            }

            public final b2<h, h.b, Object> g() {
                if (this.g == null) {
                    this.g = new b2<>(this.f, (this.f4070b & 4) != 0, getParentForChildren(), isClean());
                    this.f = null;
                }
                return this.g;
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return b.n;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.f4064d;
            }

            public final b2<c, c.C0103b, Object> h() {
                if (this.m == null) {
                    this.m = new b2<>(this.l, (this.f4070b & 32) != 0, getParentForChildren(), isClean());
                    this.l = null;
                }
                return this.m;
            }

            public final b2<h, h.b, Object> i() {
                if (this.f4073e == null) {
                    this.f4073e = new b2<>(this.f4072d, (this.f4070b & 2) != 0, getParentForChildren(), isClean());
                    this.f4072d = null;
                }
                return this.f4073e;
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.f4065e;
                fVar.c(b.class, C0102b.class);
                return fVar;
            }

            @Override // c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                l lVar;
                o oVar;
                c cVar;
                c cVar2;
                b bVar;
                h hVar;
                h hVar2;
                int i2 = 0;
                while (true) {
                    b2<h, h.b, Object> b2Var = this.f4073e;
                    if (i2 < (b2Var == null ? this.f4072d.size() : b2Var.m())) {
                        b2<h, h.b, Object> b2Var2 = this.f4073e;
                        if (b2Var2 == null) {
                            hVar2 = this.f4072d.get(i2);
                        } else {
                            hVar2 = b2Var2.n(i2, false);
                        }
                        if (!hVar2.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else {
                        int i3 = 0;
                        while (true) {
                            b2<h, h.b, Object> b2Var3 = this.g;
                            if (i3 < (b2Var3 == null ? this.f.size() : b2Var3.m())) {
                                b2<h, h.b, Object> b2Var4 = this.g;
                                if (b2Var4 == null) {
                                    hVar = this.f.get(i3);
                                } else {
                                    hVar = b2Var4.n(i3, false);
                                }
                                if (!hVar.isInitialized()) {
                                    return false;
                                }
                                i3++;
                            } else {
                                int i4 = 0;
                                while (true) {
                                    b2<b, C0102b, Object> b2Var5 = this.i;
                                    if (i4 < (b2Var5 == null ? this.h.size() : b2Var5.m())) {
                                        b2<b, C0102b, Object> b2Var6 = this.i;
                                        if (b2Var6 == null) {
                                            bVar = this.h.get(i4);
                                        } else {
                                            bVar = b2Var6.n(i4, false);
                                        }
                                        if (!bVar.isInitialized()) {
                                            return false;
                                        }
                                        i4++;
                                    } else {
                                        int i5 = 0;
                                        while (true) {
                                            b2<c, c.b, Object> b2Var7 = this.k;
                                            if (i5 < (b2Var7 == null ? this.j.size() : b2Var7.m())) {
                                                b2<c, c.b, Object> b2Var8 = this.k;
                                                if (b2Var8 == null) {
                                                    cVar2 = this.j.get(i5);
                                                } else {
                                                    cVar2 = b2Var8.n(i5, false);
                                                }
                                                if (!cVar2.isInitialized()) {
                                                    return false;
                                                }
                                                i5++;
                                            } else {
                                                int i6 = 0;
                                                while (true) {
                                                    b2<c, c.C0103b, Object> b2Var9 = this.m;
                                                    if (i6 < (b2Var9 == null ? this.l.size() : b2Var9.m())) {
                                                        b2<c, c.C0103b, Object> b2Var10 = this.m;
                                                        if (b2Var10 == null) {
                                                            cVar = this.l.get(i6);
                                                        } else {
                                                            cVar = b2Var10.n(i6, false);
                                                        }
                                                        if (!cVar.isInitialized()) {
                                                            return false;
                                                        }
                                                        i6++;
                                                    } else {
                                                        int i7 = 0;
                                                        while (true) {
                                                            b2<o, o.b, Object> b2Var11 = this.o;
                                                            if (i7 < (b2Var11 == null ? this.n.size() : b2Var11.m())) {
                                                                b2<o, o.b, Object> b2Var12 = this.o;
                                                                if (b2Var12 == null) {
                                                                    oVar = this.n.get(i7);
                                                                } else {
                                                                    oVar = b2Var12.n(i7, false);
                                                                }
                                                                if (!oVar.isInitialized()) {
                                                                    return false;
                                                                }
                                                                i7++;
                                                            } else {
                                                                if ((this.f4070b & RecyclerView.d0.FLAG_IGNORE) != 0) {
                                                                    f2<l, l.b, Object> f2Var = this.q;
                                                                    if (f2Var == null) {
                                                                        lVar = this.p;
                                                                        if (lVar == null) {
                                                                            lVar = l.j;
                                                                        }
                                                                    } else {
                                                                        lVar = f2Var.e();
                                                                    }
                                                                    if (!lVar.isInitialized()) {
                                                                        return false;
                                                                    }
                                                                }
                                                                return true;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            public final b2<b, C0102b, Object> j() {
                if (this.i == null) {
                    this.i = new b2<>(this.h, (this.f4070b & 8) != 0, getParentForChildren(), isClean());
                    this.h = null;
                }
                return this.i;
            }

            public final b2<o, o.b, Object> k() {
                if (this.o == null) {
                    this.o = new b2<>(this.n, (this.f4070b & 64) != 0, getParentForChildren(), isClean());
                    this.n = null;
                }
                return this.o;
            }

            public final b2<d, d.C0104b, Object> l() {
                if (this.s == null) {
                    this.s = new b2<>(this.r, (this.f4070b & RecyclerView.d0.FLAG_TMP_DETACHED) != 0, getParentForChildren(), isClean());
                    this.r = null;
                }
                return this.s;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            /* renamed from: m */
            public C0102b mergeFrom(k kVar, z zVar) {
                Throwable th;
                b bVar;
                b bVar2 = null;
                try {
                    b parsePartialFrom = b.o.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        n(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    bVar = (b) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    bVar2 = bVar;
                    if (bVar2 != null) {
                    }
                    throw th;
                }
            }

            public final void maybeForceBuilderInitialization() {
                l lVar;
                if (k0.alwaysUseFieldBuilders) {
                    i();
                    g();
                    j();
                    f();
                    h();
                    k();
                    f2<l, l.b, Object> f2Var = this.q;
                    if (f2Var == null) {
                        if (f2Var == null) {
                            lVar = this.p;
                            if (lVar == null) {
                                lVar = l.j;
                            }
                        } else {
                            lVar = f2Var.e();
                        }
                        this.q = new f2<>(lVar, getParentForChildren(), isClean());
                        this.p = null;
                    }
                    l();
                }
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof b) {
                    n((b) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public C0102b mergeUnknownFields(p2 p2Var) {
                return (C0102b) super.mergeUnknownFields(p2Var);
            }

            public C0102b n(b bVar) {
                l lVar;
                l lVar2;
                if (bVar == b.n) {
                    return this;
                }
                if (bVar.h()) {
                    this.f4070b |= 1;
                    this.f4071c = bVar.f4067c;
                    onChanged();
                }
                b2<d, d.C0104b, Object> b2Var = null;
                if (this.f4073e == null) {
                    if (!bVar.f4068d.isEmpty()) {
                        if (this.f4072d.isEmpty()) {
                            this.f4072d = bVar.f4068d;
                            this.f4070b &= -3;
                        } else {
                            if ((this.f4070b & 2) == 0) {
                                this.f4072d = new ArrayList(this.f4072d);
                                this.f4070b |= 2;
                            }
                            this.f4072d.addAll(bVar.f4068d);
                        }
                        onChanged();
                    }
                } else if (!bVar.f4068d.isEmpty()) {
                    if (this.f4073e.s()) {
                        this.f4073e.f3831a = null;
                        this.f4073e = null;
                        this.f4072d = bVar.f4068d;
                        this.f4070b &= -3;
                        this.f4073e = k0.alwaysUseFieldBuilders ? i() : null;
                    } else {
                        this.f4073e.b(bVar.f4068d);
                    }
                }
                if (this.g == null) {
                    if (!bVar.f4069e.isEmpty()) {
                        if (this.f.isEmpty()) {
                            this.f = bVar.f4069e;
                            this.f4070b &= -5;
                        } else {
                            if ((this.f4070b & 4) == 0) {
                                this.f = new ArrayList(this.f);
                                this.f4070b |= 4;
                            }
                            this.f.addAll(bVar.f4069e);
                        }
                        onChanged();
                    }
                } else if (!bVar.f4069e.isEmpty()) {
                    if (this.g.s()) {
                        this.g.f3831a = null;
                        this.g = null;
                        this.f = bVar.f4069e;
                        this.f4070b &= -5;
                        this.g = k0.alwaysUseFieldBuilders ? g() : null;
                    } else {
                        this.g.b(bVar.f4069e);
                    }
                }
                if (this.i == null) {
                    if (!bVar.f.isEmpty()) {
                        if (this.h.isEmpty()) {
                            this.h = bVar.f;
                            this.f4070b &= -9;
                        } else {
                            if ((this.f4070b & 8) == 0) {
                                this.h = new ArrayList(this.h);
                                this.f4070b |= 8;
                            }
                            this.h.addAll(bVar.f);
                        }
                        onChanged();
                    }
                } else if (!bVar.f.isEmpty()) {
                    if (this.i.s()) {
                        this.i.f3831a = null;
                        this.i = null;
                        this.h = bVar.f;
                        this.f4070b &= -9;
                        this.i = k0.alwaysUseFieldBuilders ? j() : null;
                    } else {
                        this.i.b(bVar.f);
                    }
                }
                if (this.k == null) {
                    if (!bVar.g.isEmpty()) {
                        if (this.j.isEmpty()) {
                            this.j = bVar.g;
                            this.f4070b &= -17;
                        } else {
                            if ((this.f4070b & 16) == 0) {
                                this.j = new ArrayList(this.j);
                                this.f4070b |= 16;
                            }
                            this.j.addAll(bVar.g);
                        }
                        onChanged();
                    }
                } else if (!bVar.g.isEmpty()) {
                    if (this.k.s()) {
                        this.k.f3831a = null;
                        this.k = null;
                        this.j = bVar.g;
                        this.f4070b &= -17;
                        this.k = k0.alwaysUseFieldBuilders ? f() : null;
                    } else {
                        this.k.b(bVar.g);
                    }
                }
                if (this.m == null) {
                    if (!bVar.h.isEmpty()) {
                        if (this.l.isEmpty()) {
                            this.l = bVar.h;
                            this.f4070b &= -33;
                        } else {
                            e();
                            this.l.addAll(bVar.h);
                        }
                        onChanged();
                    }
                } else if (!bVar.h.isEmpty()) {
                    if (this.m.s()) {
                        this.m.f3831a = null;
                        this.m = null;
                        this.l = bVar.h;
                        this.f4070b &= -33;
                        this.m = k0.alwaysUseFieldBuilders ? h() : null;
                    } else {
                        this.m.b(bVar.h);
                    }
                }
                if (this.o == null) {
                    if (!bVar.i.isEmpty()) {
                        if (this.n.isEmpty()) {
                            this.n = bVar.i;
                            this.f4070b &= -65;
                        } else {
                            if ((this.f4070b & 64) == 0) {
                                this.n = new ArrayList(this.n);
                                this.f4070b |= 64;
                            }
                            this.n.addAll(bVar.i);
                        }
                        onChanged();
                    }
                } else if (!bVar.i.isEmpty()) {
                    if (this.o.s()) {
                        this.o.f3831a = null;
                        this.o = null;
                        this.n = bVar.i;
                        this.f4070b &= -65;
                        this.o = k0.alwaysUseFieldBuilders ? k() : null;
                    } else {
                        this.o.b(bVar.i);
                    }
                }
                if (bVar.i()) {
                    l g2 = bVar.g();
                    f2<l, l.b, Object> f2Var = this.q;
                    if (f2Var == null) {
                        if (!((this.f4070b & RecyclerView.d0.FLAG_IGNORE) == 0 || (lVar = this.p) == null || lVar == (lVar2 = l.j))) {
                            l.b j2 = lVar2.toBuilder();
                            j2.o(lVar);
                            j2.o(g2);
                            g2 = j2.buildPartial();
                        }
                        this.p = g2;
                        onChanged();
                    } else {
                        f2Var.f(g2);
                    }
                    this.f4070b |= RecyclerView.d0.FLAG_IGNORE;
                }
                if (this.s == null) {
                    if (!bVar.k.isEmpty()) {
                        if (this.r.isEmpty()) {
                            this.r = bVar.k;
                            this.f4070b &= -257;
                        } else {
                            if ((this.f4070b & RecyclerView.d0.FLAG_TMP_DETACHED) == 0) {
                                this.r = new ArrayList(this.r);
                                this.f4070b |= RecyclerView.d0.FLAG_TMP_DETACHED;
                            }
                            this.r.addAll(bVar.k);
                        }
                        onChanged();
                    }
                } else if (!bVar.k.isEmpty()) {
                    if (this.s.s()) {
                        this.s.f3831a = null;
                        this.s = null;
                        this.r = bVar.k;
                        this.f4070b &= -257;
                        if (k0.alwaysUseFieldBuilders) {
                            b2Var = l();
                        }
                        this.s = b2Var;
                    } else {
                        this.s.b(bVar.k);
                    }
                }
                if (!bVar.l.isEmpty()) {
                    if (this.t.isEmpty()) {
                        this.t = bVar.l;
                        this.f4070b &= -513;
                    } else {
                        if ((this.f4070b & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0) {
                            this.t = new r0(this.t);
                            this.f4070b |= RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN;
                        }
                        this.t.addAll(bVar.l);
                    }
                    onChanged();
                }
                o(bVar.unknownFields);
                onChanged();
                return this;
            }

            public final C0102b o(p2 p2Var) {
                return (C0102b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public C0102b m17setField(s.g gVar, Object obj) {
                return (C0102b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public C0102b m18setRepeatedField(s.g gVar, int i2, Object obj) {
                return (C0102b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public C0102b m19setUnknownFields(p2 p2Var) {
                return (C0102b) super.setUnknownFields(p2Var);
            }

            public C0102b(k0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public C0102b addRepeatedField(s.g gVar, Object obj) {
                return (C0102b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public C0102b clearField(s.g gVar) {
                return (C0102b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public C0102b m12clearOneof(s.k kVar) {
                return (C0102b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m13getDefaultInstanceForType() {
                return b.n;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m14mergeFrom(e1 e1Var) {
                if (e1Var instanceof b) {
                    n((b) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public C0102b m16mergeUnknownFields(p2 p2Var) {
                return (C0102b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public C0102b setField(s.g gVar, Object obj) {
                return (C0102b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            public C0102b setRepeatedField(s.g gVar, int i2, Object obj) {
                return (C0102b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public C0102b setUnknownFields(p2 p2Var) {
                return (C0102b) super.setUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public C0102b m11clearOneof(s.k kVar) {
                return (C0102b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public C0102b m15mergeUnknownFields(p2 p2Var) {
                return (C0102b) super.mergeUnknownFields(p2Var);
            }
        }

        public static final class c extends k0 implements j1 {
            public static final c g = new c();
            @Deprecated
            public static final v1<c> h = new a();

            /* renamed from: b  reason: collision with root package name */
            public int f4074b;

            /* renamed from: c  reason: collision with root package name */
            public int f4075c;

            /* renamed from: d  reason: collision with root package name */
            public int f4076d;

            /* renamed from: e  reason: collision with root package name */
            public g f4077e;
            public byte f = -1;

            public static class a extends c<c> {
                @Override // c.b.d.v1
                public Object parsePartialFrom(k kVar, z zVar) {
                    c cVar = new c();
                    if (zVar != null) {
                        p2.b b2 = p2.b();
                        boolean z = false;
                        while (!z) {
                            try {
                                int G = kVar.G();
                                if (G != 0) {
                                    if (G == 8) {
                                        cVar.f4074b |= 1;
                                        cVar.f4075c = kVar.u();
                                    } else if (G == 16) {
                                        cVar.f4074b |= 2;
                                        cVar.f4076d = kVar.u();
                                    } else if (G == 26) {
                                        g.b f = (cVar.f4074b & 4) != 0 ? cVar.f4077e.toBuilder() : null;
                                        g gVar = (g) kVar.w(g.f, zVar);
                                        cVar.f4077e = gVar;
                                        if (f != null) {
                                            f.o(gVar);
                                            cVar.f4077e = f.buildPartial();
                                        }
                                        cVar.f4074b |= 4;
                                    } else if (!cVar.parseUnknownField(kVar, b2, zVar, G)) {
                                    }
                                }
                                z = true;
                            } catch (n0 e2) {
                                e2.f4007b = cVar;
                                throw e2;
                            } catch (IOException e3) {
                                n0 n0Var = new n0(e3);
                                n0Var.f4007b = cVar;
                                throw n0Var;
                            } catch (Throwable th) {
                                cVar.unknownFields = b2.build();
                                cVar.makeExtensionsImmutable();
                                throw th;
                            }
                        }
                        cVar.unknownFields = b2.build();
                        cVar.makeExtensionsImmutable();
                        return cVar;
                    }
                    throw null;
                }
            }

            /* renamed from: c.b.d.r$b$c$b  reason: collision with other inner class name */
            public static final class C0103b extends k0.b<C0103b> implements Object {

                /* renamed from: b  reason: collision with root package name */
                public int f4078b;

                /* renamed from: c  reason: collision with root package name */
                public int f4079c;

                /* renamed from: d  reason: collision with root package name */
                public int f4080d;

                /* renamed from: e  reason: collision with root package name */
                public g f4081e;
                public f2<g, g.b, Object> f;

                public C0103b() {
                    maybeForceBuilderInitialization();
                }

                public C0103b(a aVar) {
                    maybeForceBuilderInitialization();
                }

                /* renamed from: a */
                public c build() {
                    c b2 = buildPartial();
                    if (b2.isInitialized()) {
                        return b2;
                    }
                    throw a.AbstractC0097a.newUninitializedMessageException((e1) b2);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: addRepeatedField  reason: collision with other method in class */
                public C0103b m22addRepeatedField(s.g gVar, Object obj) {
                    return (C0103b) super.addRepeatedField(gVar, obj);
                }

                /* renamed from: b */
                public c buildPartial() {
                    int i;
                    c cVar = new c(this, null);
                    int i2 = this.f4078b;
                    if ((i2 & 1) != 0) {
                        cVar.f4075c = this.f4079c;
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((i2 & 2) != 0) {
                        cVar.f4076d = this.f4080d;
                        i |= 2;
                    }
                    if ((i2 & 4) != 0) {
                        f2<g, g.b, Object> f2Var = this.f;
                        cVar.f4077e = f2Var == null ? this.f4081e : f2Var.b();
                        i |= 4;
                    }
                    cVar.f4074b = i;
                    onBuilt();
                    return cVar;
                }

                public C0103b c() {
                    super.clear();
                    this.f4079c = 0;
                    int i = this.f4078b & -2;
                    this.f4078b = i;
                    this.f4080d = 0;
                    this.f4078b = i & -3;
                    f2<g, g.b, Object> f2Var = this.f;
                    if (f2Var == null) {
                        this.f4081e = null;
                    } else {
                        f2Var.c();
                    }
                    this.f4078b &= -5;
                    return this;
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: clearField  reason: collision with other method in class */
                public C0103b m23clearField(s.g gVar) {
                    return (C0103b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public C0103b clearOneof(s.k kVar) {
                    return (C0103b) super.clearOneof(kVar);
                }

                /* renamed from: d */
                public C0103b clone() {
                    return (C0103b) super.clone();
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
                /* renamed from: e */
                public C0103b mergeFrom(k kVar, z zVar) {
                    Throwable th;
                    c cVar;
                    c cVar2 = null;
                    try {
                        c parsePartialFrom = c.h.parsePartialFrom(kVar, zVar);
                        if (parsePartialFrom != null) {
                            f(parsePartialFrom);
                        }
                        return this;
                    } catch (n0 e2) {
                        cVar = (c) e2.f4007b;
                        throw e2.j();
                    } catch (Throwable th2) {
                        th = th2;
                        cVar2 = cVar;
                        if (cVar2 != null) {
                        }
                        throw th;
                    }
                }

                public C0103b f(c cVar) {
                    g gVar;
                    g gVar2;
                    if (cVar == c.g) {
                        return this;
                    }
                    if (cVar.d()) {
                        int i = cVar.f4075c;
                        this.f4078b |= 1;
                        this.f4079c = i;
                        onChanged();
                    }
                    if (cVar.b()) {
                        int i2 = cVar.f4076d;
                        this.f4078b |= 2;
                        this.f4080d = i2;
                        onChanged();
                    }
                    if (cVar.c()) {
                        g a2 = cVar.a();
                        f2<g, g.b, Object> f2Var = this.f;
                        if (f2Var == null) {
                            if (!((this.f4078b & 4) == 0 || (gVar = this.f4081e) == null || gVar == (gVar2 = g.f4124e))) {
                                g.b f2 = gVar2.toBuilder();
                                f2.o(gVar);
                                f2.o(a2);
                                a2 = f2.buildPartial();
                            }
                            this.f4081e = a2;
                            onChanged();
                        } else {
                            f2Var.f(a2);
                        }
                        this.f4078b |= 4;
                    }
                    g(cVar.unknownFields);
                    onChanged();
                    return this;
                }

                public final C0103b g(p2 p2Var) {
                    return (C0103b) super.mergeUnknownFields(p2Var);
                }

                @Override // c.b.d.j1, c.b.d.i1
                public e1 getDefaultInstanceForType() {
                    return c.g;
                }

                @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
                public s.b getDescriptorForType() {
                    return r.f;
                }

                @Override // c.b.d.k0.b
                public k0.f internalGetFieldAccessorTable() {
                    k0.f fVar = r.g;
                    fVar.c(c.class, C0103b.class);
                    return fVar;
                }

                @Override // c.b.d.k0.b, c.b.d.i1
                public final boolean isInitialized() {
                    g gVar;
                    if ((this.f4078b & 4) != 0) {
                        f2<g, g.b, Object> f2Var = this.f;
                        if (f2Var == null) {
                            gVar = this.f4081e;
                            if (gVar == null) {
                                gVar = g.f4124e;
                            }
                        } else {
                            gVar = f2Var.e();
                        }
                        if (!gVar.isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }

                public final void maybeForceBuilderInitialization() {
                    f2<g, g.b, Object> f2Var;
                    g gVar;
                    if (k0.alwaysUseFieldBuilders && (f2Var = this.f) == null) {
                        if (f2Var == null) {
                            gVar = this.f4081e;
                            if (gVar == null) {
                                gVar = g.f4124e;
                            }
                        } else {
                            gVar = f2Var.e();
                        }
                        this.f = new f2<>(gVar, getParentForChildren(), isClean());
                        this.f4081e = null;
                    }
                }

                @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public a.AbstractC0097a mergeFrom(e1 e1Var) {
                    if (e1Var instanceof c) {
                        f((c) e1Var);
                    } else {
                        super.mergeFrom(e1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public C0103b mergeUnknownFields(p2 p2Var) {
                    return (C0103b) super.mergeUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: setField  reason: collision with other method in class */
                public C0103b m30setField(s.g gVar, Object obj) {
                    return (C0103b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b
                /* renamed from: setRepeatedField  reason: collision with other method in class */
                public C0103b m31setRepeatedField(s.g gVar, int i, Object obj) {
                    return (C0103b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: setUnknownFields  reason: collision with other method in class */
                public C0103b m32setUnknownFields(p2 p2Var) {
                    return (C0103b) super.setUnknownFields(p2Var);
                }

                public C0103b(k0.c cVar, a aVar) {
                    super(cVar);
                    maybeForceBuilderInitialization();
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public C0103b addRepeatedField(s.g gVar, Object obj) {
                    return (C0103b) super.addRepeatedField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public C0103b clearField(s.g gVar) {
                    return (C0103b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public C0103b m25clearOneof(s.k kVar) {
                    return (C0103b) super.clearOneof(kVar);
                }

                @Override // c.b.d.j1, c.b.d.i1
                /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
                public h1 m26getDefaultInstanceForType() {
                    return c.g;
                }

                @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeFrom  reason: collision with other method in class */
                public e1.a m27mergeFrom(e1 e1Var) {
                    if (e1Var instanceof c) {
                        f((c) e1Var);
                    } else {
                        super.mergeFrom(e1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public C0103b m29mergeUnknownFields(p2 p2Var) {
                    return (C0103b) super.mergeUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public C0103b setField(s.g gVar, Object obj) {
                    return (C0103b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b
                public C0103b setRepeatedField(s.g gVar, int i, Object obj) {
                    return (C0103b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public C0103b setUnknownFields(p2 p2Var) {
                    return (C0103b) super.setUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public C0103b m24clearOneof(s.k kVar) {
                    return (C0103b) super.clearOneof(kVar);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public C0103b m28mergeUnknownFields(p2 p2Var) {
                    return (C0103b) super.mergeUnknownFields(p2Var);
                }
            }

            public c() {
            }

            public c(k0.b bVar, a aVar) {
                super(bVar);
            }

            public g a() {
                g gVar = this.f4077e;
                return gVar == null ? g.f4124e : gVar;
            }

            public boolean b() {
                return (this.f4074b & 2) != 0;
            }

            public boolean c() {
                return (this.f4074b & 4) != 0;
            }

            public boolean d() {
                return (this.f4074b & 1) != 0;
            }

            /* renamed from: e */
            public C0103b toBuilder() {
                if (this == g) {
                    return new C0103b(null);
                }
                C0103b bVar = new C0103b(null);
                bVar.f(this);
                return bVar;
            }

            @Override // c.b.d.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return super.equals(obj);
                }
                c cVar = (c) obj;
                if (d() != cVar.d()) {
                    return false;
                }
                if ((d() && this.f4075c != cVar.f4075c) || b() != cVar.b()) {
                    return false;
                }
                if ((!b() || this.f4076d == cVar.f4076d) && c() == cVar.c()) {
                    return (!c() || a().equals(cVar.a())) && this.unknownFields.equals(cVar.unknownFields);
                }
                return false;
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return g;
            }

            @Override // c.b.d.k0, c.b.d.h1
            public v1<c> getParserForType() {
                return h;
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.f4074b & 1) != 0) {
                    i2 = 0 + m.s(1, this.f4075c);
                }
                if ((this.f4074b & 2) != 0) {
                    i2 += m.s(2, this.f4076d);
                }
                if ((this.f4074b & 4) != 0) {
                    i2 += m.z(3, a());
                }
                int serializedSize = this.unknownFields.getSerializedSize() + i2;
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // c.b.d.k0, c.b.d.j1
            public final p2 getUnknownFields() {
                return this.unknownFields;
            }

            @Override // c.b.d.a
            public int hashCode() {
                int i = this.memoizedHashCode;
                if (i != 0) {
                    return i;
                }
                int hashCode = r.f.hashCode() + 779;
                if (d()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + this.f4075c;
                }
                if (b()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f4076d;
                }
                if (c()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + a().hashCode();
                }
                int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // c.b.d.k0
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.g;
                fVar.c(c.class, C0103b.class);
                return fVar;
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
            public final boolean isInitialized() {
                byte b2 = this.f;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                if (!c() || a().isInitialized()) {
                    this.f = 1;
                    return true;
                }
                this.f = 0;
                return false;
            }

            @Override // c.b.d.e1, c.b.d.h1
            public e1.a newBuilderForType() {
                return g.toBuilder();
            }

            @Override // c.b.d.k0
            public Object newInstance(k0.g gVar) {
                return new c();
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
            public void writeTo(m mVar) {
                if ((this.f4074b & 1) != 0) {
                    mVar.i0(1, this.f4075c);
                }
                if ((this.f4074b & 2) != 0) {
                    mVar.i0(2, this.f4076d);
                }
                if ((this.f4074b & 4) != 0) {
                    mVar.k0(3, a());
                }
                this.unknownFields.writeTo(mVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m20getDefaultInstanceForType() {
                return g;
            }

            @Override // c.b.d.k0
            public e1.a newBuilderForType(k0.c cVar) {
                return new C0103b(cVar, null);
            }

            @Override // c.b.d.e1, c.b.d.h1
            /* renamed from: newBuilderForType  reason: collision with other method in class */
            public h1.a m21newBuilderForType() {
                return g.toBuilder();
            }
        }

        public static final class d extends k0 implements j1 {
            public static final d f = new d();
            @Deprecated
            public static final v1<d> g = new a();

            /* renamed from: b  reason: collision with root package name */
            public int f4082b;

            /* renamed from: c  reason: collision with root package name */
            public int f4083c;

            /* renamed from: d  reason: collision with root package name */
            public int f4084d;

            /* renamed from: e  reason: collision with root package name */
            public byte f4085e = -1;

            public static class a extends c<d> {
                @Override // c.b.d.v1
                public Object parsePartialFrom(k kVar, z zVar) {
                    d dVar = new d();
                    if (zVar != null) {
                        p2.b b2 = p2.b();
                        boolean z = false;
                        while (!z) {
                            try {
                                int G = kVar.G();
                                if (G != 0) {
                                    if (G == 8) {
                                        dVar.f4082b |= 1;
                                        dVar.f4083c = kVar.u();
                                    } else if (G == 16) {
                                        dVar.f4082b |= 2;
                                        dVar.f4084d = kVar.u();
                                    } else if (!dVar.parseUnknownField(kVar, b2, zVar, G)) {
                                    }
                                }
                                z = true;
                            } catch (n0 e2) {
                                e2.f4007b = dVar;
                                throw e2;
                            } catch (IOException e3) {
                                n0 n0Var = new n0(e3);
                                n0Var.f4007b = dVar;
                                throw n0Var;
                            } catch (Throwable th) {
                                dVar.unknownFields = b2.build();
                                dVar.makeExtensionsImmutable();
                                throw th;
                            }
                        }
                        dVar.unknownFields = b2.build();
                        dVar.makeExtensionsImmutable();
                        return dVar;
                    }
                    throw null;
                }
            }

            /* renamed from: c.b.d.r$b$d$b  reason: collision with other inner class name */
            public static final class C0104b extends k0.b<C0104b> implements Object {

                /* renamed from: b  reason: collision with root package name */
                public int f4086b;

                /* renamed from: c  reason: collision with root package name */
                public int f4087c;

                /* renamed from: d  reason: collision with root package name */
                public int f4088d;

                public C0104b() {
                }

                public C0104b(a aVar) {
                }

                /* renamed from: a */
                public d buildPartial() {
                    int i;
                    d dVar = new d(this, null);
                    int i2 = this.f4086b;
                    if ((i2 & 1) != 0) {
                        dVar.f4083c = this.f4087c;
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((i2 & 2) != 0) {
                        dVar.f4084d = this.f4088d;
                        i |= 2;
                    }
                    dVar.f4082b = i;
                    onBuilt();
                    return dVar;
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: addRepeatedField  reason: collision with other method in class */
                public C0104b m35addRepeatedField(s.g gVar, Object obj) {
                    return (C0104b) super.addRepeatedField(gVar, obj);
                }

                public C0104b b() {
                    super.clear();
                    this.f4087c = 0;
                    int i = this.f4086b & -2;
                    this.f4086b = i;
                    this.f4088d = 0;
                    this.f4086b = i & -3;
                    return this;
                }

                @Override // c.b.d.h1.a, c.b.d.e1.a
                public e1 build() {
                    d a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
                }

                /* renamed from: c */
                public C0104b clone() {
                    return (C0104b) super.clone();
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: clearField  reason: collision with other method in class */
                public C0104b m37clearField(s.g gVar) {
                    return (C0104b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public C0104b clearOneof(s.k kVar) {
                    return (C0104b) super.clearOneof(kVar);
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
                public C0104b d(k kVar, z zVar) {
                    Throwable th;
                    d dVar;
                    d dVar2 = null;
                    try {
                        d parsePartialFrom = d.g.parsePartialFrom(kVar, zVar);
                        if (parsePartialFrom != null) {
                            e(parsePartialFrom);
                        }
                        return this;
                    } catch (n0 e2) {
                        dVar = (d) e2.f4007b;
                        throw e2.j();
                    } catch (Throwable th2) {
                        th = th2;
                        dVar2 = dVar;
                        if (dVar2 != null) {
                        }
                        throw th;
                    }
                }

                public C0104b e(d dVar) {
                    if (dVar == d.f) {
                        return this;
                    }
                    if (dVar.b()) {
                        int i = dVar.f4083c;
                        this.f4086b |= 1;
                        this.f4087c = i;
                        onChanged();
                    }
                    if (dVar.a()) {
                        int i2 = dVar.f4084d;
                        this.f4086b |= 2;
                        this.f4088d = i2;
                        onChanged();
                    }
                    f(dVar.unknownFields);
                    onChanged();
                    return this;
                }

                public final C0104b f(p2 p2Var) {
                    return (C0104b) super.mergeUnknownFields(p2Var);
                }

                @Override // c.b.d.j1, c.b.d.i1
                public e1 getDefaultInstanceForType() {
                    return d.f;
                }

                @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
                public s.b getDescriptorForType() {
                    return r.h;
                }

                @Override // c.b.d.k0.b
                public k0.f internalGetFieldAccessorTable() {
                    k0.f fVar = r.i;
                    fVar.c(d.class, C0104b.class);
                    return fVar;
                }

                @Override // c.b.d.k0.b, c.b.d.i1
                public final boolean isInitialized() {
                    return true;
                }

                @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public a.AbstractC0097a mergeFrom(e1 e1Var) {
                    if (e1Var instanceof d) {
                        e((d) e1Var);
                    } else {
                        super.mergeFrom(e1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public C0104b mergeUnknownFields(p2 p2Var) {
                    return (C0104b) super.mergeUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: setField  reason: collision with other method in class */
                public C0104b m44setField(s.g gVar, Object obj) {
                    return (C0104b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b
                /* renamed from: setRepeatedField  reason: collision with other method in class */
                public C0104b m45setRepeatedField(s.g gVar, int i, Object obj) {
                    return (C0104b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: setUnknownFields  reason: collision with other method in class */
                public C0104b m46setUnknownFields(p2 p2Var) {
                    return (C0104b) super.setUnknownFields(p2Var);
                }

                public C0104b(k0.c cVar, a aVar) {
                    super(cVar);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public C0104b addRepeatedField(s.g gVar, Object obj) {
                    return (C0104b) super.addRepeatedField(gVar, obj);
                }

                @Override // c.b.d.h1.a, c.b.d.e1.a
                /* renamed from: build  reason: collision with other method in class */
                public h1 m36build() {
                    d a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public C0104b clearField(s.g gVar) {
                    return (C0104b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public C0104b m39clearOneof(s.k kVar) {
                    return (C0104b) super.clearOneof(kVar);
                }

                @Override // c.b.d.j1, c.b.d.i1
                /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
                public h1 m40getDefaultInstanceForType() {
                    return d.f;
                }

                @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeFrom  reason: collision with other method in class */
                public e1.a m41mergeFrom(e1 e1Var) {
                    if (e1Var instanceof d) {
                        e((d) e1Var);
                    } else {
                        super.mergeFrom(e1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public C0104b m43mergeUnknownFields(p2 p2Var) {
                    return (C0104b) super.mergeUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public C0104b setField(s.g gVar, Object obj) {
                    return (C0104b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b
                public C0104b setRepeatedField(s.g gVar, int i, Object obj) {
                    return (C0104b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public C0104b setUnknownFields(p2 p2Var) {
                    return (C0104b) super.setUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public C0104b m38clearOneof(s.k kVar) {
                    return (C0104b) super.clearOneof(kVar);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public C0104b m42mergeUnknownFields(p2 p2Var) {
                    return (C0104b) super.mergeUnknownFields(p2Var);
                }
            }

            public d() {
            }

            public d(k0.b bVar, a aVar) {
                super(bVar);
            }

            public boolean a() {
                return (this.f4082b & 2) != 0;
            }

            public boolean b() {
                return (this.f4082b & 1) != 0;
            }

            /* renamed from: c */
            public C0104b toBuilder() {
                if (this == f) {
                    return new C0104b(null);
                }
                C0104b bVar = new C0104b(null);
                bVar.e(this);
                return bVar;
            }

            @Override // c.b.d.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return super.equals(obj);
                }
                d dVar = (d) obj;
                if (b() != dVar.b()) {
                    return false;
                }
                if ((!b() || this.f4083c == dVar.f4083c) && a() == dVar.a()) {
                    return (!a() || this.f4084d == dVar.f4084d) && this.unknownFields.equals(dVar.unknownFields);
                }
                return false;
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return f;
            }

            @Override // c.b.d.k0, c.b.d.h1
            public v1<d> getParserForType() {
                return g;
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.f4082b & 1) != 0) {
                    i2 = 0 + m.s(1, this.f4083c);
                }
                if ((this.f4082b & 2) != 0) {
                    i2 += m.s(2, this.f4084d);
                }
                int serializedSize = this.unknownFields.getSerializedSize() + i2;
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // c.b.d.k0, c.b.d.j1
            public final p2 getUnknownFields() {
                return this.unknownFields;
            }

            @Override // c.b.d.a
            public int hashCode() {
                int i = this.memoizedHashCode;
                if (i != 0) {
                    return i;
                }
                int hashCode = r.h.hashCode() + 779;
                if (b()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + this.f4083c;
                }
                if (a()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f4084d;
                }
                int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // c.b.d.k0
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.i;
                fVar.c(d.class, C0104b.class);
                return fVar;
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
            public final boolean isInitialized() {
                byte b2 = this.f4085e;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.f4085e = 1;
                return true;
            }

            @Override // c.b.d.e1, c.b.d.h1
            public e1.a newBuilderForType() {
                return f.toBuilder();
            }

            @Override // c.b.d.k0
            public Object newInstance(k0.g gVar) {
                return new d();
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
            public void writeTo(m mVar) {
                if ((this.f4082b & 1) != 0) {
                    mVar.i0(1, this.f4083c);
                }
                if ((this.f4082b & 2) != 0) {
                    mVar.i0(2, this.f4084d);
                }
                this.unknownFields.writeTo(mVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m33getDefaultInstanceForType() {
                return f;
            }

            @Override // c.b.d.k0
            public e1.a newBuilderForType(k0.c cVar) {
                return new C0104b(cVar, null);
            }

            @Override // c.b.d.e1, c.b.d.h1
            /* renamed from: newBuilderForType  reason: collision with other method in class */
            public h1.a m34newBuilderForType() {
                return f.toBuilder();
            }
        }

        public b() {
            this.m = -1;
            this.f4067c = "";
            this.f4068d = Collections.emptyList();
            this.f4069e = Collections.emptyList();
            this.f = Collections.emptyList();
            this.g = Collections.emptyList();
            this.h = Collections.emptyList();
            this.i = Collections.emptyList();
            this.k = Collections.emptyList();
            this.l = r0.f4261e;
        }

        public b(k0.b bVar, a aVar) {
            super(bVar);
            this.m = -1;
        }

        public int a() {
            return this.g.size();
        }

        public int b() {
            return this.f4069e.size();
        }

        public int c() {
            return this.f4068d.size();
        }

        public String d() {
            Object obj = this.f4067c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.f4067c = u;
            }
            return u;
        }

        public int e() {
            return this.f.size();
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return super.equals(obj);
            }
            b bVar = (b) obj;
            if (h() != bVar.h()) {
                return false;
            }
            if ((!h() || d().equals(bVar.d())) && this.f4068d.equals(bVar.f4068d) && this.f4069e.equals(bVar.f4069e) && this.f.equals(bVar.f) && this.g.equals(bVar.g) && this.h.equals(bVar.h) && this.i.equals(bVar.i) && i() == bVar.i()) {
                return (!i() || g().equals(bVar.g())) && this.k.equals(bVar.k) && this.l.equals(bVar.l) && this.unknownFields.equals(bVar.unknownFields);
            }
            return false;
        }

        public int f() {
            return this.i.size();
        }

        public l g() {
            l lVar = this.j;
            return lVar == null ? l.j : lVar;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return n;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<b> getParserForType() {
            return o;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeStringSize = (this.f4066b & 1) != 0 ? k0.computeStringSize(1, this.f4067c) + 0 : 0;
            for (int i3 = 0; i3 < this.f4068d.size(); i3++) {
                computeStringSize += m.z(2, this.f4068d.get(i3));
            }
            for (int i4 = 0; i4 < this.f.size(); i4++) {
                computeStringSize += m.z(3, this.f.get(i4));
            }
            for (int i5 = 0; i5 < this.g.size(); i5++) {
                computeStringSize += m.z(4, this.g.get(i5));
            }
            for (int i6 = 0; i6 < this.h.size(); i6++) {
                computeStringSize += m.z(5, this.h.get(i6));
            }
            for (int i7 = 0; i7 < this.f4069e.size(); i7++) {
                computeStringSize += m.z(6, this.f4069e.get(i7));
            }
            if ((this.f4066b & 2) != 0) {
                computeStringSize += m.z(7, g());
            }
            for (int i8 = 0; i8 < this.i.size(); i8++) {
                computeStringSize += m.z(8, this.i.get(i8));
            }
            for (int i9 = 0; i9 < this.k.size(); i9++) {
                computeStringSize += m.z(9, this.k.get(i9));
            }
            int i10 = 0;
            for (int i11 = 0; i11 < this.l.size(); i11++) {
                i10 += k0.computeStringSizeNoTag(this.l.f(i11));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + (this.l.size() * 1) + computeStringSize + i10;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean h() {
            return (this.f4066b & 1) != 0;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.f4064d.hashCode() + 779;
            if (h()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + d().hashCode();
            }
            if (c() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f4068d.hashCode();
            }
            if (b() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 6, 53) + this.f4069e.hashCode();
            }
            if (e() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + this.f.hashCode();
            }
            if (a() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 4, 53) + this.g.hashCode();
            }
            if (this.h.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 5, 53) + this.h.hashCode();
            }
            if (f() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 8, 53) + this.i.hashCode();
            }
            if (i()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 7, 53) + g().hashCode();
            }
            if (this.k.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 9, 53) + this.k.hashCode();
            }
            if (this.l.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 10, 53) + this.l.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public boolean i() {
            return (this.f4066b & 2) != 0;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.f4065e;
            fVar.c(b.class, C0102b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.m;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < c(); i2++) {
                if (!this.f4068d.get(i2).isInitialized()) {
                    this.m = 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < b(); i3++) {
                if (!this.f4069e.get(i3).isInitialized()) {
                    this.m = 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < e(); i4++) {
                if (!this.f.get(i4).isInitialized()) {
                    this.m = 0;
                    return false;
                }
            }
            for (int i5 = 0; i5 < a(); i5++) {
                if (!this.g.get(i5).isInitialized()) {
                    this.m = 0;
                    return false;
                }
            }
            for (int i6 = 0; i6 < this.h.size(); i6++) {
                if (!this.h.get(i6).isInitialized()) {
                    this.m = 0;
                    return false;
                }
            }
            for (int i7 = 0; i7 < f(); i7++) {
                if (!this.i.get(i7).isInitialized()) {
                    this.m = 0;
                    return false;
                }
            }
            if (!i() || g().isInitialized()) {
                this.m = 1;
                return true;
            }
            this.m = 0;
            return false;
        }

        /* renamed from: j */
        public C0102b toBuilder() {
            if (this == n) {
                return new C0102b(null);
            }
            C0102b bVar = new C0102b(null);
            bVar.n(this);
            return bVar;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return n.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new b();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            if ((this.f4066b & 1) != 0) {
                k0.writeString(mVar, 1, this.f4067c);
            }
            for (int i2 = 0; i2 < this.f4068d.size(); i2++) {
                mVar.k0(2, this.f4068d.get(i2));
            }
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                mVar.k0(3, this.f.get(i3));
            }
            for (int i4 = 0; i4 < this.g.size(); i4++) {
                mVar.k0(4, this.g.get(i4));
            }
            for (int i5 = 0; i5 < this.h.size(); i5++) {
                mVar.k0(5, this.h.get(i5));
            }
            for (int i6 = 0; i6 < this.f4069e.size(); i6++) {
                mVar.k0(6, this.f4069e.get(i6));
            }
            if ((this.f4066b & 2) != 0) {
                mVar.k0(7, g());
            }
            for (int i7 = 0; i7 < this.i.size(); i7++) {
                mVar.k0(8, this.i.get(i7));
            }
            for (int i8 = 0; i8 < this.k.size(); i8++) {
                mVar.k0(9, this.k.get(i8));
            }
            for (int i9 = 0; i9 < this.l.size(); i9++) {
                k0.writeString(mVar, 10, this.l.f(i9));
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m7getDefaultInstanceForType() {
            return n;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new C0102b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m8newBuilderForType() {
            return n.toBuilder();
        }
    }

    public static final class c extends k0 implements j1 {
        public static final c i = new c();
        @Deprecated
        public static final v1<c> j = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f4089b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f4090c;

        /* renamed from: d  reason: collision with root package name */
        public List<e> f4091d;

        /* renamed from: e  reason: collision with root package name */
        public d f4092e;
        public List<C0105c> f;
        public s0 g;
        public byte h;

        public static class a extends c<c> {
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                Object obj;
                List list;
                c cVar = new c();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G != 10) {
                                    if (G == 18) {
                                        if (!z2 || !true) {
                                            cVar.f4091d = new ArrayList();
                                            z2 |= true;
                                        }
                                        list = cVar.f4091d;
                                        obj = e.h;
                                    } else if (G == 26) {
                                        d.b h = (cVar.f4089b & 2) != 0 ? cVar.f4092e.toBuilder() : null;
                                        d dVar = (d) kVar.w(d.i, zVar);
                                        cVar.f4092e = dVar;
                                        if (h != null) {
                                            h.o(dVar);
                                            cVar.f4092e = h.buildPartial();
                                        }
                                        cVar.f4089b |= 2;
                                    } else if (G == 34) {
                                        if (!z2 || !true) {
                                            cVar.f = new ArrayList();
                                            z2 |= true;
                                        }
                                        list = cVar.f;
                                        obj = C0105c.g;
                                    } else if (G == 42) {
                                        j n = kVar.n();
                                        if (!z2 || !true) {
                                            cVar.g = new r0(10);
                                            z2 |= true;
                                        }
                                        cVar.g.l(n);
                                    } else if (!cVar.parseUnknownField(kVar, b2, zVar, G)) {
                                    }
                                    list.add(kVar.w(obj, zVar));
                                } else {
                                    j n2 = kVar.n();
                                    cVar.f4089b = 1 | cVar.f4089b;
                                    cVar.f4090c = n2;
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = cVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = cVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                cVar.f4091d = Collections.unmodifiableList(cVar.f4091d);
                            }
                            if (z2 && true) {
                                cVar.f = Collections.unmodifiableList(cVar.f);
                            }
                            if (z2 && true) {
                                cVar.g = cVar.g.b();
                            }
                            cVar.unknownFields = b2.build();
                            cVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        cVar.f4091d = Collections.unmodifiableList(cVar.f4091d);
                    }
                    if (z2 && true) {
                        cVar.f = Collections.unmodifiableList(cVar.f);
                    }
                    if (z2 && true) {
                        cVar.g = cVar.g.b();
                    }
                    cVar.unknownFields = b2.build();
                    cVar.makeExtensionsImmutable();
                    return cVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f4093b;

            /* renamed from: c  reason: collision with root package name */
            public Object f4094c = "";

            /* renamed from: d  reason: collision with root package name */
            public List<e> f4095d = Collections.emptyList();

            /* renamed from: e  reason: collision with root package name */
            public b2<e, e.b, Object> f4096e;
            public d f;
            public f2<d, d.b, Object> g;
            public List<C0105c> h = Collections.emptyList();
            public b2<C0105c, C0105c.b, Object> i;
            public s0 j = r0.f4261e;

            public b() {
                maybeForceBuilderInitialization();
            }

            public b(a aVar) {
                maybeForceBuilderInitialization();
            }

            /* renamed from: a */
            public c buildPartial() {
                List<e> list;
                List<C0105c> list2;
                c cVar = new c(this, null);
                int i2 = this.f4093b;
                int i3 = (i2 & 1) != 0 ? 1 : 0;
                cVar.f4090c = this.f4094c;
                b2<e, e.b, Object> b2Var = this.f4096e;
                if (b2Var == null) {
                    if ((this.f4093b & 2) != 0) {
                        this.f4095d = Collections.unmodifiableList(this.f4095d);
                        this.f4093b &= -3;
                    }
                    list = this.f4095d;
                } else {
                    list = b2Var.g();
                }
                cVar.f4091d = list;
                if ((i2 & 4) != 0) {
                    f2<d, d.b, Object> f2Var = this.g;
                    cVar.f4092e = f2Var == null ? this.f : f2Var.b();
                    i3 |= 2;
                }
                b2<C0105c, C0105c.b, Object> b2Var2 = this.i;
                if (b2Var2 == null) {
                    if ((this.f4093b & 8) != 0) {
                        this.h = Collections.unmodifiableList(this.h);
                        this.f4093b &= -9;
                    }
                    list2 = this.h;
                } else {
                    list2 = b2Var2.g();
                }
                cVar.f = list2;
                if ((this.f4093b & 16) != 0) {
                    this.j = this.j.b();
                    this.f4093b &= -17;
                }
                cVar.g = this.j;
                cVar.f4089b = i3;
                onBuilt();
                return cVar;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m49addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            public b b() {
                super.clear();
                this.f4094c = "";
                this.f4093b &= -2;
                b2<e, e.b, Object> b2Var = this.f4096e;
                if (b2Var == null) {
                    this.f4095d = Collections.emptyList();
                    this.f4093b &= -3;
                } else {
                    b2Var.h();
                }
                f2<d, d.b, Object> f2Var = this.g;
                if (f2Var == null) {
                    this.f = null;
                } else {
                    f2Var.c();
                }
                this.f4093b &= -5;
                b2<C0105c, C0105c.b, Object> b2Var2 = this.i;
                if (b2Var2 == null) {
                    this.h = Collections.emptyList();
                    this.f4093b &= -9;
                } else {
                    b2Var2.h();
                }
                this.j = r0.f4261e;
                this.f4093b &= -17;
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                c a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
            }

            /* renamed from: c */
            public b clone() {
                return (b) super.clone();
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m51clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            public final b2<C0105c, C0105c.b, Object> d() {
                if (this.i == null) {
                    this.i = new b2<>(this.h, (this.f4093b & 8) != 0, getParentForChildren(), isClean());
                    this.h = null;
                }
                return this.i;
            }

            public final b2<e, e.b, Object> e() {
                if (this.f4096e == null) {
                    this.f4096e = new b2<>(this.f4095d, (this.f4093b & 2) != 0, getParentForChildren(), isClean());
                    this.f4095d = null;
                }
                return this.f4096e;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b f(k kVar, z zVar) {
                Throwable th;
                c cVar;
                c cVar2 = null;
                try {
                    c parsePartialFrom = c.j.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        g(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    cVar = (c) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    cVar2 = cVar;
                    if (cVar2 != null) {
                    }
                    throw th;
                }
            }

            public b g(c cVar) {
                d dVar;
                d dVar2;
                if (cVar == c.i) {
                    return this;
                }
                if (cVar.d()) {
                    this.f4093b |= 1;
                    this.f4094c = cVar.f4090c;
                    onChanged();
                }
                b2<C0105c, C0105c.b, Object> b2Var = null;
                if (this.f4096e == null) {
                    if (!cVar.f4091d.isEmpty()) {
                        if (this.f4095d.isEmpty()) {
                            this.f4095d = cVar.f4091d;
                            this.f4093b &= -3;
                        } else {
                            if ((this.f4093b & 2) == 0) {
                                this.f4095d = new ArrayList(this.f4095d);
                                this.f4093b |= 2;
                            }
                            this.f4095d.addAll(cVar.f4091d);
                        }
                        onChanged();
                    }
                } else if (!cVar.f4091d.isEmpty()) {
                    if (this.f4096e.s()) {
                        this.f4096e.f3831a = null;
                        this.f4096e = null;
                        this.f4095d = cVar.f4091d;
                        this.f4093b &= -3;
                        this.f4096e = k0.alwaysUseFieldBuilders ? e() : null;
                    } else {
                        this.f4096e.b(cVar.f4091d);
                    }
                }
                if (cVar.e()) {
                    d b2 = cVar.b();
                    f2<d, d.b, Object> f2Var = this.g;
                    if (f2Var == null) {
                        if (!((this.f4093b & 4) == 0 || (dVar = this.f) == null || dVar == (dVar2 = d.h))) {
                            d.b h2 = dVar2.toBuilder();
                            h2.o(dVar);
                            h2.o(b2);
                            b2 = h2.buildPartial();
                        }
                        this.f = b2;
                        onChanged();
                    } else {
                        f2Var.f(b2);
                    }
                    this.f4093b |= 4;
                }
                if (this.i == null) {
                    if (!cVar.f.isEmpty()) {
                        if (this.h.isEmpty()) {
                            this.h = cVar.f;
                            this.f4093b &= -9;
                        } else {
                            if ((this.f4093b & 8) == 0) {
                                this.h = new ArrayList(this.h);
                                this.f4093b |= 8;
                            }
                            this.h.addAll(cVar.f);
                        }
                        onChanged();
                    }
                } else if (!cVar.f.isEmpty()) {
                    if (this.i.s()) {
                        this.i.f3831a = null;
                        this.i = null;
                        this.h = cVar.f;
                        this.f4093b &= -9;
                        if (k0.alwaysUseFieldBuilders) {
                            b2Var = d();
                        }
                        this.i = b2Var;
                    } else {
                        this.i.b(cVar.f);
                    }
                }
                if (!cVar.g.isEmpty()) {
                    if (this.j.isEmpty()) {
                        this.j = cVar.g;
                        this.f4093b &= -17;
                    } else {
                        if ((this.f4093b & 16) == 0) {
                            this.j = new r0(this.j);
                            this.f4093b |= 16;
                        }
                        this.j.addAll(cVar.g);
                    }
                    onChanged();
                }
                h(cVar.unknownFields);
                onChanged();
                return this;
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return c.i;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.p;
            }

            public final b h(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.q;
                fVar.c(c.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                d dVar;
                e eVar;
                int i2 = 0;
                while (true) {
                    b2<e, e.b, Object> b2Var = this.f4096e;
                    if (i2 < (b2Var == null ? this.f4095d.size() : b2Var.m())) {
                        b2<e, e.b, Object> b2Var2 = this.f4096e;
                        if (b2Var2 == null) {
                            eVar = this.f4095d.get(i2);
                        } else {
                            eVar = b2Var2.n(i2, false);
                        }
                        if (!eVar.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else {
                        if ((this.f4093b & 4) != 0) {
                            f2<d, d.b, Object> f2Var = this.g;
                            if (f2Var == null) {
                                dVar = this.f;
                                if (dVar == null) {
                                    dVar = d.h;
                                }
                            } else {
                                dVar = f2Var.e();
                            }
                            if (!dVar.isInitialized()) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }

            public final void maybeForceBuilderInitialization() {
                d dVar;
                if (k0.alwaysUseFieldBuilders) {
                    e();
                    f2<d, d.b, Object> f2Var = this.g;
                    if (f2Var == null) {
                        if (f2Var == null) {
                            dVar = this.f;
                            if (dVar == null) {
                                dVar = d.h;
                            }
                        } else {
                            dVar = f2Var.e();
                        }
                        this.g = new f2<>(dVar, getParentForChildren(), isClean());
                        this.f = null;
                    }
                    d();
                }
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof c) {
                    g((c) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m58setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m59setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m60setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m50build() {
                c a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m53clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m54getDefaultInstanceForType() {
                return c.i;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m55mergeFrom(e1 e1Var) {
                if (e1Var instanceof c) {
                    g((c) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m57mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            public b setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m52clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m56mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }
        }

        /* renamed from: c.b.d.r$c$c  reason: collision with other inner class name */
        public static final class C0105c extends k0 implements j1 {
            public static final C0105c f = new C0105c();
            @Deprecated
            public static final v1<C0105c> g = new a();

            /* renamed from: b  reason: collision with root package name */
            public int f4097b;

            /* renamed from: c  reason: collision with root package name */
            public int f4098c;

            /* renamed from: d  reason: collision with root package name */
            public int f4099d;

            /* renamed from: e  reason: collision with root package name */
            public byte f4100e = -1;

            /* renamed from: c.b.d.r$c$c$a */
            public static class a extends c<C0105c> {
                @Override // c.b.d.v1
                public Object parsePartialFrom(k kVar, z zVar) {
                    C0105c cVar = new C0105c();
                    if (zVar != null) {
                        p2.b b2 = p2.b();
                        boolean z = false;
                        while (!z) {
                            try {
                                int G = kVar.G();
                                if (G != 0) {
                                    if (G == 8) {
                                        cVar.f4097b |= 1;
                                        cVar.f4098c = kVar.u();
                                    } else if (G == 16) {
                                        cVar.f4097b |= 2;
                                        cVar.f4099d = kVar.u();
                                    } else if (!cVar.parseUnknownField(kVar, b2, zVar, G)) {
                                    }
                                }
                                z = true;
                            } catch (n0 e2) {
                                e2.f4007b = cVar;
                                throw e2;
                            } catch (IOException e3) {
                                n0 n0Var = new n0(e3);
                                n0Var.f4007b = cVar;
                                throw n0Var;
                            } catch (Throwable th) {
                                cVar.unknownFields = b2.build();
                                cVar.makeExtensionsImmutable();
                                throw th;
                            }
                        }
                        cVar.unknownFields = b2.build();
                        cVar.makeExtensionsImmutable();
                        return cVar;
                    }
                    throw null;
                }
            }

            /* renamed from: c.b.d.r$c$c$b */
            public static final class b extends k0.b<b> implements Object {

                /* renamed from: b  reason: collision with root package name */
                public int f4101b;

                /* renamed from: c  reason: collision with root package name */
                public int f4102c;

                /* renamed from: d  reason: collision with root package name */
                public int f4103d;

                public b() {
                }

                public b(a aVar) {
                }

                /* renamed from: a */
                public C0105c buildPartial() {
                    int i;
                    C0105c cVar = new C0105c(this, null);
                    int i2 = this.f4101b;
                    if ((i2 & 1) != 0) {
                        cVar.f4098c = this.f4102c;
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((i2 & 2) != 0) {
                        cVar.f4099d = this.f4103d;
                        i |= 2;
                    }
                    cVar.f4097b = i;
                    onBuilt();
                    return cVar;
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: addRepeatedField  reason: collision with other method in class */
                public b m63addRepeatedField(s.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                public b b() {
                    super.clear();
                    this.f4102c = 0;
                    int i = this.f4101b & -2;
                    this.f4101b = i;
                    this.f4103d = 0;
                    this.f4101b = i & -3;
                    return this;
                }

                @Override // c.b.d.h1.a, c.b.d.e1.a
                public e1 build() {
                    C0105c a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
                }

                /* renamed from: c */
                public b clone() {
                    return (b) super.clone();
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: clearField  reason: collision with other method in class */
                public b m65clearField(s.g gVar) {
                    return (b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public b clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
                public b d(k kVar, z zVar) {
                    Throwable th;
                    C0105c cVar;
                    C0105c cVar2 = null;
                    try {
                        C0105c parsePartialFrom = C0105c.g.parsePartialFrom(kVar, zVar);
                        if (parsePartialFrom != null) {
                            e(parsePartialFrom);
                        }
                        return this;
                    } catch (n0 e2) {
                        cVar = (C0105c) e2.f4007b;
                        throw e2.j();
                    } catch (Throwable th2) {
                        th = th2;
                        cVar2 = cVar;
                        if (cVar2 != null) {
                        }
                        throw th;
                    }
                }

                public b e(C0105c cVar) {
                    if (cVar == C0105c.f) {
                        return this;
                    }
                    if (cVar.b()) {
                        int i = cVar.f4098c;
                        this.f4101b |= 1;
                        this.f4102c = i;
                        onChanged();
                    }
                    if (cVar.a()) {
                        int i2 = cVar.f4099d;
                        this.f4101b |= 2;
                        this.f4103d = i2;
                        onChanged();
                    }
                    f(cVar.unknownFields);
                    onChanged();
                    return this;
                }

                public final b f(p2 p2Var) {
                    return (b) super.mergeUnknownFields(p2Var);
                }

                @Override // c.b.d.j1, c.b.d.i1
                public e1 getDefaultInstanceForType() {
                    return C0105c.f;
                }

                @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
                public s.b getDescriptorForType() {
                    return r.r;
                }

                @Override // c.b.d.k0.b
                public k0.f internalGetFieldAccessorTable() {
                    k0.f fVar = r.s;
                    fVar.c(C0105c.class, b.class);
                    return fVar;
                }

                @Override // c.b.d.k0.b, c.b.d.i1
                public final boolean isInitialized() {
                    return true;
                }

                @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public a.AbstractC0097a mergeFrom(e1 e1Var) {
                    if (e1Var instanceof C0105c) {
                        e((C0105c) e1Var);
                    } else {
                        super.mergeFrom(e1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public b mergeUnknownFields(p2 p2Var) {
                    return (b) super.mergeUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: setField  reason: collision with other method in class */
                public b m72setField(s.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b
                /* renamed from: setRepeatedField  reason: collision with other method in class */
                public b m73setRepeatedField(s.g gVar, int i, Object obj) {
                    return (b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: setUnknownFields  reason: collision with other method in class */
                public b m74setUnknownFields(p2 p2Var) {
                    return (b) super.setUnknownFields(p2Var);
                }

                public b(k0.c cVar, a aVar) {
                    super(cVar);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public b addRepeatedField(s.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                @Override // c.b.d.h1.a, c.b.d.e1.a
                /* renamed from: build  reason: collision with other method in class */
                public h1 m64build() {
                    C0105c a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public b clearField(s.g gVar) {
                    return (b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public b m67clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                @Override // c.b.d.j1, c.b.d.i1
                /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
                public h1 m68getDefaultInstanceForType() {
                    return C0105c.f;
                }

                @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeFrom  reason: collision with other method in class */
                public e1.a m69mergeFrom(e1 e1Var) {
                    if (e1Var instanceof C0105c) {
                        e((C0105c) e1Var);
                    } else {
                        super.mergeFrom(e1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public b m71mergeUnknownFields(p2 p2Var) {
                    return (b) super.mergeUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public b setField(s.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b
                public b setRepeatedField(s.g gVar, int i, Object obj) {
                    return (b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public b setUnknownFields(p2 p2Var) {
                    return (b) super.setUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public b m66clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public b m70mergeUnknownFields(p2 p2Var) {
                    return (b) super.mergeUnknownFields(p2Var);
                }
            }

            public C0105c() {
            }

            public C0105c(k0.b bVar, a aVar) {
                super(bVar);
            }

            public boolean a() {
                return (this.f4097b & 2) != 0;
            }

            public boolean b() {
                return (this.f4097b & 1) != 0;
            }

            /* renamed from: c */
            public b toBuilder() {
                if (this == f) {
                    return new b(null);
                }
                b bVar = new b(null);
                bVar.e(this);
                return bVar;
            }

            @Override // c.b.d.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof C0105c)) {
                    return super.equals(obj);
                }
                C0105c cVar = (C0105c) obj;
                if (b() != cVar.b()) {
                    return false;
                }
                if ((!b() || this.f4098c == cVar.f4098c) && a() == cVar.a()) {
                    return (!a() || this.f4099d == cVar.f4099d) && this.unknownFields.equals(cVar.unknownFields);
                }
                return false;
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return f;
            }

            @Override // c.b.d.k0, c.b.d.h1
            public v1<C0105c> getParserForType() {
                return g;
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.f4097b & 1) != 0) {
                    i2 = 0 + m.s(1, this.f4098c);
                }
                if ((this.f4097b & 2) != 0) {
                    i2 += m.s(2, this.f4099d);
                }
                int serializedSize = this.unknownFields.getSerializedSize() + i2;
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // c.b.d.k0, c.b.d.j1
            public final p2 getUnknownFields() {
                return this.unknownFields;
            }

            @Override // c.b.d.a
            public int hashCode() {
                int i = this.memoizedHashCode;
                if (i != 0) {
                    return i;
                }
                int hashCode = r.r.hashCode() + 779;
                if (b()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + this.f4098c;
                }
                if (a()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f4099d;
                }
                int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // c.b.d.k0
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.s;
                fVar.c(C0105c.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
            public final boolean isInitialized() {
                byte b2 = this.f4100e;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.f4100e = 1;
                return true;
            }

            @Override // c.b.d.e1, c.b.d.h1
            public e1.a newBuilderForType() {
                return f.toBuilder();
            }

            @Override // c.b.d.k0
            public Object newInstance(k0.g gVar) {
                return new C0105c();
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
            public void writeTo(m mVar) {
                if ((this.f4097b & 1) != 0) {
                    mVar.i0(1, this.f4098c);
                }
                if ((this.f4097b & 2) != 0) {
                    mVar.i0(2, this.f4099d);
                }
                this.unknownFields.writeTo(mVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m61getDefaultInstanceForType() {
                return f;
            }

            @Override // c.b.d.k0
            public e1.a newBuilderForType(k0.c cVar) {
                return new b(cVar, null);
            }

            @Override // c.b.d.e1, c.b.d.h1
            /* renamed from: newBuilderForType  reason: collision with other method in class */
            public h1.a m62newBuilderForType() {
                return f.toBuilder();
            }
        }

        public c() {
            this.h = -1;
            this.f4090c = "";
            this.f4091d = Collections.emptyList();
            this.f = Collections.emptyList();
            this.g = r0.f4261e;
        }

        public c(k0.b bVar, a aVar) {
            super(bVar);
            this.h = -1;
        }

        public String a() {
            Object obj = this.f4090c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.f4090c = u;
            }
            return u;
        }

        public d b() {
            d dVar = this.f4092e;
            return dVar == null ? d.h : dVar;
        }

        public int c() {
            return this.f4091d.size();
        }

        public boolean d() {
            return (this.f4089b & 1) != 0;
        }

        public boolean e() {
            return (this.f4089b & 2) != 0;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return super.equals(obj);
            }
            c cVar = (c) obj;
            if (d() != cVar.d()) {
                return false;
            }
            if ((!d() || a().equals(cVar.a())) && this.f4091d.equals(cVar.f4091d) && e() == cVar.e()) {
                return (!e() || b().equals(cVar.b())) && this.f.equals(cVar.f) && this.g.equals(cVar.g) && this.unknownFields.equals(cVar.unknownFields);
            }
            return false;
        }

        /* renamed from: f */
        public b toBuilder() {
            if (this == i) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.g(this);
            return bVar;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return i;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<c> getParserForType() {
            return j;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeStringSize = (this.f4089b & 1) != 0 ? k0.computeStringSize(1, this.f4090c) + 0 : 0;
            for (int i3 = 0; i3 < this.f4091d.size(); i3++) {
                computeStringSize += m.z(2, this.f4091d.get(i3));
            }
            if ((this.f4089b & 2) != 0) {
                computeStringSize += m.z(3, b());
            }
            for (int i4 = 0; i4 < this.f.size(); i4++) {
                computeStringSize += m.z(4, this.f.get(i4));
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.g.size(); i6++) {
                i5 += k0.computeStringSizeNoTag(this.g.f(i6));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + (this.g.size() * 1) + computeStringSize + i5;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.p.hashCode() + 779;
            if (d()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + a().hashCode();
            }
            if (c() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f4091d.hashCode();
            }
            if (e()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + b().hashCode();
            }
            if (this.f.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 4, 53) + this.f.hashCode();
            }
            if (this.g.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 5, 53) + this.g.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.q;
            fVar.c(c.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.h;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < c(); i2++) {
                if (!this.f4091d.get(i2).isInitialized()) {
                    this.h = 0;
                    return false;
                }
            }
            if (!e() || b().isInitialized()) {
                this.h = 1;
                return true;
            }
            this.h = 0;
            return false;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return i.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new c();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            if ((this.f4089b & 1) != 0) {
                k0.writeString(mVar, 1, this.f4090c);
            }
            for (int i2 = 0; i2 < this.f4091d.size(); i2++) {
                mVar.k0(2, this.f4091d.get(i2));
            }
            if ((this.f4089b & 2) != 0) {
                mVar.k0(3, b());
            }
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                mVar.k0(4, this.f.get(i3));
            }
            for (int i4 = 0; i4 < this.g.size(); i4++) {
                k0.writeString(mVar, 5, this.g.f(i4));
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m47getDefaultInstanceForType() {
            return i;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m48newBuilderForType() {
            return i.toBuilder();
        }
    }

    public static final class d extends k0.e<d> implements Object {
        public static final d h = new d();
        @Deprecated
        public static final v1<d> i = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f4104c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4105d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4106e;
        public List<t> f;
        public byte g;

        public static class a extends c<d> {
            /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                d dVar = new d();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 16) {
                                    dVar.f4104c |= 1;
                                    dVar.f4105d = kVar.m();
                                } else if (G == 24) {
                                    dVar.f4104c |= 2;
                                    dVar.f4106e = kVar.m();
                                } else if (G == 7994) {
                                    if (!z2 || !true) {
                                        dVar.f = new ArrayList();
                                        z2 |= true;
                                    }
                                    dVar.f.add(kVar.w(t.l, zVar));
                                } else if (!dVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = dVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = dVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                dVar.f = Collections.unmodifiableList(dVar.f);
                            }
                            dVar.unknownFields = b2.build();
                            dVar.f3942b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        dVar.f = Collections.unmodifiableList(dVar.f);
                    }
                    dVar.unknownFields = b2.build();
                    dVar.f3942b.x();
                    return dVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.d<d, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f4107c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f4108d;

            /* renamed from: e  reason: collision with root package name */
            public boolean f4109e;
            public List<t> f = Collections.emptyList();
            public b2<t, t.b, Object> g;

            public b() {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public k0.b m77addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                d j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public k0.b m79clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return d.h;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.H;
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b h(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.I;
                fVar.c(d.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.d, c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                t tVar;
                int i = 0;
                while (true) {
                    b2<t, t.b, Object> b2Var = this.g;
                    if (i < (b2Var == null ? this.f.size() : b2Var.m())) {
                        b2<t, t.b, Object> b2Var2 = this.g;
                        if (b2Var2 == null) {
                            tVar = this.f.get(i);
                        } else {
                            tVar = b2Var2.n(i, false);
                        }
                        if (!tVar.isInitialized()) {
                            return false;
                        }
                        i++;
                    } else if (!e()) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }

            /* renamed from: j */
            public d buildPartial() {
                int i;
                List<t> list;
                d dVar = new d(this, null);
                int i2 = this.f4107c;
                if ((i2 & 1) != 0) {
                    dVar.f4105d = this.f4108d;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    dVar.f4106e = this.f4109e;
                    i |= 2;
                }
                b2<t, t.b, Object> b2Var = this.g;
                if (b2Var == null) {
                    if ((this.f4107c & 4) != 0) {
                        this.f = Collections.unmodifiableList(this.f);
                        this.f4107c &= -5;
                    }
                    list = this.f;
                } else {
                    list = b2Var.g();
                }
                dVar.f = list;
                dVar.f4104c = i;
                onBuilt();
                return dVar;
            }

            public b k() {
                super.clear();
                this.f4108d = false;
                int i = this.f4107c & -2;
                this.f4107c = i;
                this.f4109e = false;
                this.f4107c = i & -3;
                b2<t, t.b, Object> b2Var = this.g;
                if (b2Var == null) {
                    this.f = Collections.emptyList();
                    this.f4107c &= -5;
                } else {
                    b2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final b2<t, t.b, Object> m() {
                if (this.g == null) {
                    this.g = new b2<>(this.f, (this.f4107c & 4) != 0, getParentForChildren(), isClean());
                    this.f = null;
                }
                return this.g;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof d) {
                    o((d) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b n(k kVar, z zVar) {
                Throwable th;
                d dVar;
                d dVar2 = null;
                try {
                    d parsePartialFrom = d.i.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        o(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    dVar = (d) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    dVar2 = dVar;
                    if (dVar2 != null) {
                    }
                    throw th;
                }
            }

            public b o(d dVar) {
                if (dVar == d.h) {
                    return this;
                }
                if (dVar.f()) {
                    boolean z = dVar.f4105d;
                    this.f4107c |= 1;
                    this.f4108d = z;
                    onChanged();
                }
                if (dVar.g()) {
                    boolean z2 = dVar.f4106e;
                    this.f4107c |= 2;
                    this.f4109e = z2;
                    onChanged();
                }
                if (this.g == null) {
                    if (!dVar.f.isEmpty()) {
                        if (this.f.isEmpty()) {
                            this.f = dVar.f;
                            this.f4107c &= -5;
                        } else {
                            if ((this.f4107c & 4) == 0) {
                                this.f = new ArrayList(this.f);
                                this.f4107c |= 4;
                            }
                            this.f.addAll(dVar.f);
                        }
                        onChanged();
                    }
                } else if (!dVar.f.isEmpty()) {
                    if (this.g.s()) {
                        b2<t, t.b, Object> b2Var = null;
                        this.g.f3831a = null;
                        this.g = null;
                        this.f = dVar.f;
                        this.f4107c &= -5;
                        if (k0.alwaysUseFieldBuilders) {
                            b2Var = m();
                        }
                        this.g = b2Var;
                    } else {
                        this.g.b(dVar.f);
                    }
                }
                f(dVar);
                p(dVar.unknownFields);
                onChanged();
                return this;
            }

            public final b p(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public k0.b m86setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public k0.b m87setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public k0.b m88setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(a aVar) {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m78build() {
                d j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public k0.b m81clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m82getDefaultInstanceForType() {
                return d.h;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m83mergeFrom(e1 e1Var) {
                if (e1Var instanceof d) {
                    o((d) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public k0.b m85mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            public e1.a setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public e1.a m80clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public e1.a m84mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public d() {
            this.g = -1;
            this.f = Collections.emptyList();
        }

        public d(k0.d dVar, a aVar) {
            super(dVar);
            this.g = -1;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return super.equals(obj);
            }
            d dVar = (d) obj;
            if (f() != dVar.f()) {
                return false;
            }
            if ((!f() || this.f4105d == dVar.f4105d) && g() == dVar.g()) {
                return (!g() || this.f4106e == dVar.f4106e) && this.f.equals(dVar.f) && this.unknownFields.equals(dVar.unknownFields) && c().equals(dVar.c());
            }
            return false;
        }

        public boolean f() {
            return (this.f4104c & 1) != 0;
        }

        public boolean g() {
            return (this.f4104c & 2) != 0;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return h;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<d> getParserForType() {
            return i;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int c2 = (this.f4104c & 1) != 0 ? m.c(2, this.f4105d) + 0 : 0;
            if ((2 & this.f4104c) != 0) {
                c2 += m.c(3, this.f4106e);
            }
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                c2 += m.z(b.r.h.MAX_BIND_PARAMETER_CNT, this.f.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + c2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        /* renamed from: h */
        public b toBuilder() {
            if (this == h) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.o(this);
            return bVar;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.H.hashCode() + 779;
            if (f()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + m0.c(this.f4105d);
            }
            if (g()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + m0.c(this.f4106e);
            }
            if (this.f.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.r.h.MAX_BIND_PARAMETER_CNT, 53) + this.f.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.I;
            fVar.c(d.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.k0.e, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.g;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                if (!this.f.get(i2).isInitialized()) {
                    this.g = 0;
                    return false;
                }
            }
            if (!a()) {
                this.g = 0;
                return false;
            }
            this.g = 1;
            return true;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return h.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new d();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            k0.e<MessageType>.a d2 = d();
            if ((this.f4104c & 1) != 0) {
                mVar.Y(2, this.f4105d);
            }
            if ((this.f4104c & 2) != 0) {
                mVar.Y(3, this.f4106e);
            }
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                mVar.k0(b.r.h.MAX_BIND_PARAMETER_CNT, this.f.get(i2));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m75getDefaultInstanceForType() {
            return h;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m76newBuilderForType() {
            return h.toBuilder();
        }
    }

    public static final class e extends k0 implements j1 {
        public static final e g = new e();
        @Deprecated
        public static final v1<e> h = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f4110b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f4111c;

        /* renamed from: d  reason: collision with root package name */
        public int f4112d;

        /* renamed from: e  reason: collision with root package name */
        public f f4113e;
        public byte f;

        public static class a extends c<e> {
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                e eVar = new e();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 10) {
                                    j n = kVar.n();
                                    eVar.f4110b = 1 | eVar.f4110b;
                                    eVar.f4111c = n;
                                } else if (G == 16) {
                                    eVar.f4110b |= 2;
                                    eVar.f4112d = kVar.u();
                                } else if (G == 26) {
                                    f.b g = (eVar.f4110b & 4) != 0 ? eVar.f4113e.toBuilder() : null;
                                    f fVar = (f) kVar.w(f.h, zVar);
                                    eVar.f4113e = fVar;
                                    if (g != null) {
                                        g.o(fVar);
                                        eVar.f4113e = g.buildPartial();
                                    }
                                    eVar.f4110b |= 4;
                                } else if (!eVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = eVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = eVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            eVar.unknownFields = b2.build();
                            eVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    eVar.unknownFields = b2.build();
                    eVar.makeExtensionsImmutable();
                    return eVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f4114b;

            /* renamed from: c  reason: collision with root package name */
            public Object f4115c = "";

            /* renamed from: d  reason: collision with root package name */
            public int f4116d;

            /* renamed from: e  reason: collision with root package name */
            public f f4117e;
            public f2<f, f.b, Object> f;

            public b() {
                maybeForceBuilderInitialization();
            }

            public b(a aVar) {
                maybeForceBuilderInitialization();
            }

            /* renamed from: a */
            public e build() {
                e b2 = buildPartial();
                if (b2.isInitialized()) {
                    return b2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) b2);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m91addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: b */
            public e buildPartial() {
                e eVar = new e(this, null);
                int i = this.f4114b;
                int i2 = (i & 1) != 0 ? 1 : 0;
                eVar.f4111c = this.f4115c;
                if ((i & 2) != 0) {
                    eVar.f4112d = this.f4116d;
                    i2 |= 2;
                }
                if ((i & 4) != 0) {
                    f2<f, f.b, Object> f2Var = this.f;
                    eVar.f4113e = f2Var == null ? this.f4117e : f2Var.b();
                    i2 |= 4;
                }
                eVar.f4110b = i2;
                onBuilt();
                return eVar;
            }

            public b c() {
                super.clear();
                this.f4115c = "";
                int i = this.f4114b & -2;
                this.f4114b = i;
                this.f4116d = 0;
                this.f4114b = i & -3;
                f2<f, f.b, Object> f2Var = this.f;
                if (f2Var == null) {
                    this.f4117e = null;
                } else {
                    f2Var.c();
                }
                this.f4114b &= -5;
                return this;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m92clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* renamed from: d */
            public b clone() {
                return (b) super.clone();
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b e(k kVar, z zVar) {
                Throwable th;
                e eVar;
                e eVar2 = null;
                try {
                    e parsePartialFrom = e.h.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        f(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    eVar = (e) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    eVar2 = eVar;
                    if (eVar2 != null) {
                    }
                    throw th;
                }
            }

            public b f(e eVar) {
                f fVar;
                f fVar2;
                if (eVar == e.g) {
                    return this;
                }
                if (eVar.c()) {
                    this.f4114b |= 1;
                    this.f4115c = eVar.f4111c;
                    onChanged();
                }
                if (eVar.d()) {
                    int i = eVar.f4112d;
                    this.f4114b |= 2;
                    this.f4116d = i;
                    onChanged();
                }
                if (eVar.e()) {
                    f b2 = eVar.b();
                    f2<f, f.b, Object> f2Var = this.f;
                    if (f2Var == null) {
                        if (!((this.f4114b & 4) == 0 || (fVar = this.f4117e) == null || fVar == (fVar2 = f.g))) {
                            f.b g = fVar2.toBuilder();
                            g.o(fVar);
                            g.o(b2);
                            b2 = g.buildPartial();
                        }
                        this.f4117e = b2;
                        onChanged();
                    } else {
                        f2Var.f(b2);
                    }
                    this.f4114b |= 4;
                }
                g(eVar.unknownFields);
                onChanged();
                return this;
            }

            public final b g(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return e.g;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.t;
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.u;
                fVar.c(e.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                f fVar;
                if ((this.f4114b & 4) != 0) {
                    f2<f, f.b, Object> f2Var = this.f;
                    if (f2Var == null) {
                        fVar = this.f4117e;
                        if (fVar == null) {
                            fVar = f.g;
                        }
                    } else {
                        fVar = f2Var.e();
                    }
                    if (!fVar.isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public final void maybeForceBuilderInitialization() {
                f2<f, f.b, Object> f2Var;
                f fVar;
                if (k0.alwaysUseFieldBuilders && (f2Var = this.f) == null) {
                    if (f2Var == null) {
                        fVar = this.f4117e;
                        if (fVar == null) {
                            fVar = f.g;
                        }
                    } else {
                        fVar = f2Var.e();
                    }
                    this.f = new f2<>(fVar, getParentForChildren(), isClean());
                    this.f4117e = null;
                }
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof e) {
                    f((e) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m99setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m100setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m101setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m94clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m95getDefaultInstanceForType() {
                return e.g;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m96mergeFrom(e1 e1Var) {
                if (e1Var instanceof e) {
                    f((e) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m98mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            public b setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m93clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m97mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }
        }

        public e() {
            this.f = -1;
            this.f4111c = "";
        }

        public e(k0.b bVar, a aVar) {
            super(bVar);
            this.f = -1;
        }

        public String a() {
            Object obj = this.f4111c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.f4111c = u;
            }
            return u;
        }

        public f b() {
            f fVar = this.f4113e;
            return fVar == null ? f.g : fVar;
        }

        public boolean c() {
            return (this.f4110b & 1) != 0;
        }

        public boolean d() {
            return (this.f4110b & 2) != 0;
        }

        public boolean e() {
            return (this.f4110b & 4) != 0;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof e)) {
                return super.equals(obj);
            }
            e eVar = (e) obj;
            if (c() != eVar.c()) {
                return false;
            }
            if ((c() && !a().equals(eVar.a())) || d() != eVar.d()) {
                return false;
            }
            if ((!d() || this.f4112d == eVar.f4112d) && e() == eVar.e()) {
                return (!e() || b().equals(eVar.b())) && this.unknownFields.equals(eVar.unknownFields);
            }
            return false;
        }

        /* renamed from: f */
        public b toBuilder() {
            if (this == g) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.f(this);
            return bVar;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return g;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<e> getParserForType() {
            return h;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.f4110b & 1) != 0) {
                i2 = 0 + k0.computeStringSize(1, this.f4111c);
            }
            if ((this.f4110b & 2) != 0) {
                i2 += m.s(2, this.f4112d);
            }
            if ((this.f4110b & 4) != 0) {
                i2 += m.z(3, b());
            }
            int serializedSize = this.unknownFields.getSerializedSize() + i2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = r.t.hashCode() + 779;
            if (c()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + a().hashCode();
            }
            if (d()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f4112d;
            }
            if (e()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + b().hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.u;
            fVar.c(e.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!e() || b().isInitialized()) {
                this.f = 1;
                return true;
            }
            this.f = 0;
            return false;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return g.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new e();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            if ((this.f4110b & 1) != 0) {
                k0.writeString(mVar, 1, this.f4111c);
            }
            if ((this.f4110b & 2) != 0) {
                mVar.i0(2, this.f4112d);
            }
            if ((this.f4110b & 4) != 0) {
                mVar.k0(3, b());
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m89getDefaultInstanceForType() {
            return g;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m90newBuilderForType() {
            return g.toBuilder();
        }
    }

    public static final class f extends k0.e<f> implements Object {
        public static final f g = new f();
        @Deprecated
        public static final v1<f> h = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f4118c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4119d;

        /* renamed from: e  reason: collision with root package name */
        public List<t> f4120e;
        public byte f;

        public static class a extends c<f> {
            /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                f fVar = new f();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 8) {
                                    fVar.f4118c |= 1;
                                    fVar.f4119d = kVar.m();
                                } else if (G == 7994) {
                                    if (!z2 || !true) {
                                        fVar.f4120e = new ArrayList();
                                        z2 |= true;
                                    }
                                    fVar.f4120e.add(kVar.w(t.l, zVar));
                                } else if (!fVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = fVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = fVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                fVar.f4120e = Collections.unmodifiableList(fVar.f4120e);
                            }
                            fVar.unknownFields = b2.build();
                            fVar.f3942b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        fVar.f4120e = Collections.unmodifiableList(fVar.f4120e);
                    }
                    fVar.unknownFields = b2.build();
                    fVar.f3942b.x();
                    return fVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.d<f, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f4121c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f4122d;

            /* renamed from: e  reason: collision with root package name */
            public List<t> f4123e = Collections.emptyList();
            public b2<t, t.b, Object> f;

            public b() {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public k0.b m104addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                f j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public k0.b m106clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return f.g;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.J;
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b h(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.K;
                fVar.c(f.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.d, c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                t tVar;
                int i = 0;
                while (true) {
                    b2<t, t.b, Object> b2Var = this.f;
                    if (i < (b2Var == null ? this.f4123e.size() : b2Var.m())) {
                        b2<t, t.b, Object> b2Var2 = this.f;
                        if (b2Var2 == null) {
                            tVar = this.f4123e.get(i);
                        } else {
                            tVar = b2Var2.n(i, false);
                        }
                        if (!tVar.isInitialized()) {
                            return false;
                        }
                        i++;
                    } else if (!e()) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }

            /* renamed from: j */
            public f buildPartial() {
                List<t> list;
                f fVar = new f(this, null);
                int i = 1;
                if ((this.f4121c & 1) != 0) {
                    fVar.f4119d = this.f4122d;
                } else {
                    i = 0;
                }
                b2<t, t.b, Object> b2Var = this.f;
                if (b2Var == null) {
                    if ((this.f4121c & 2) != 0) {
                        this.f4123e = Collections.unmodifiableList(this.f4123e);
                        this.f4121c &= -3;
                    }
                    list = this.f4123e;
                } else {
                    list = b2Var.g();
                }
                fVar.f4120e = list;
                fVar.f4118c = i;
                onBuilt();
                return fVar;
            }

            public b k() {
                super.clear();
                this.f4122d = false;
                this.f4121c &= -2;
                b2<t, t.b, Object> b2Var = this.f;
                if (b2Var == null) {
                    this.f4123e = Collections.emptyList();
                    this.f4121c &= -3;
                } else {
                    b2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final b2<t, t.b, Object> m() {
                if (this.f == null) {
                    this.f = new b2<>(this.f4123e, (this.f4121c & 2) != 0, getParentForChildren(), isClean());
                    this.f4123e = null;
                }
                return this.f;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof f) {
                    o((f) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b n(k kVar, z zVar) {
                Throwable th;
                f fVar;
                f fVar2 = null;
                try {
                    f parsePartialFrom = f.h.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        o(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    fVar = (f) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    fVar2 = fVar;
                    if (fVar2 != null) {
                    }
                    throw th;
                }
            }

            public b o(f fVar) {
                if (fVar == f.g) {
                    return this;
                }
                if (fVar.f()) {
                    boolean z = fVar.f4119d;
                    this.f4121c |= 1;
                    this.f4122d = z;
                    onChanged();
                }
                if (this.f == null) {
                    if (!fVar.f4120e.isEmpty()) {
                        if (this.f4123e.isEmpty()) {
                            this.f4123e = fVar.f4120e;
                            this.f4121c &= -3;
                        } else {
                            if ((this.f4121c & 2) == 0) {
                                this.f4123e = new ArrayList(this.f4123e);
                                this.f4121c |= 2;
                            }
                            this.f4123e.addAll(fVar.f4120e);
                        }
                        onChanged();
                    }
                } else if (!fVar.f4120e.isEmpty()) {
                    if (this.f.s()) {
                        b2<t, t.b, Object> b2Var = null;
                        this.f.f3831a = null;
                        this.f = null;
                        this.f4123e = fVar.f4120e;
                        this.f4121c &= -3;
                        if (k0.alwaysUseFieldBuilders) {
                            b2Var = m();
                        }
                        this.f = b2Var;
                    } else {
                        this.f.b(fVar.f4120e);
                    }
                }
                f(fVar);
                p(fVar.unknownFields);
                onChanged();
                return this;
            }

            public final b p(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public k0.b m113setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public k0.b m114setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public k0.b m115setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(a aVar) {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m105build() {
                f j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public k0.b m108clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m109getDefaultInstanceForType() {
                return f.g;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m110mergeFrom(e1 e1Var) {
                if (e1Var instanceof f) {
                    o((f) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public k0.b m112mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            public e1.a setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public e1.a m107clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public e1.a m111mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public f() {
            this.f = -1;
            this.f4120e = Collections.emptyList();
        }

        public f(k0.d dVar, a aVar) {
            super(dVar);
            this.f = -1;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof f)) {
                return super.equals(obj);
            }
            f fVar = (f) obj;
            if (f() != fVar.f()) {
                return false;
            }
            return (!f() || this.f4119d == fVar.f4119d) && this.f4120e.equals(fVar.f4120e) && this.unknownFields.equals(fVar.unknownFields) && c().equals(fVar.c());
        }

        public boolean f() {
            return (this.f4118c & 1) != 0;
        }

        /* renamed from: g */
        public b toBuilder() {
            if (this == g) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.o(this);
            return bVar;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return g;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<f> getParserForType() {
            return h;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int c2 = (this.f4118c & 1) != 0 ? m.c(1, this.f4119d) + 0 : 0;
            for (int i2 = 0; i2 < this.f4120e.size(); i2++) {
                c2 += m.z(b.r.h.MAX_BIND_PARAMETER_CNT, this.f4120e.get(i2));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + c2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = r.J.hashCode() + 779;
            if (f()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + m0.c(this.f4119d);
            }
            if (this.f4120e.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.r.h.MAX_BIND_PARAMETER_CNT, 53) + this.f4120e.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.K;
            fVar.c(f.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.k0.e, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.f4120e.size(); i++) {
                if (!this.f4120e.get(i).isInitialized()) {
                    this.f = 0;
                    return false;
                }
            }
            if (!a()) {
                this.f = 0;
                return false;
            }
            this.f = 1;
            return true;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return g.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new f();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            k0.e<MessageType>.a d2 = d();
            if ((this.f4118c & 1) != 0) {
                mVar.Y(1, this.f4119d);
            }
            for (int i = 0; i < this.f4120e.size(); i++) {
                mVar.k0(b.r.h.MAX_BIND_PARAMETER_CNT, this.f4120e.get(i));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m102getDefaultInstanceForType() {
            return g;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m103newBuilderForType() {
            return g.toBuilder();
        }
    }

    public static final class g extends k0.e<g> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public static final g f4124e = new g();
        @Deprecated
        public static final v1<g> f = new a();

        /* renamed from: c  reason: collision with root package name */
        public List<t> f4125c;

        /* renamed from: d  reason: collision with root package name */
        public byte f4126d;

        public static class a extends c<g> {
            /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                g gVar = new g();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 7994) {
                                    if (!z2 || !true) {
                                        gVar.f4125c = new ArrayList();
                                        z2 |= true;
                                    }
                                    gVar.f4125c.add(kVar.w(t.l, zVar));
                                } else if (!gVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = gVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = gVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                gVar.f4125c = Collections.unmodifiableList(gVar.f4125c);
                            }
                            gVar.unknownFields = b2.build();
                            gVar.f3942b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        gVar.f4125c = Collections.unmodifiableList(gVar.f4125c);
                    }
                    gVar.unknownFields = b2.build();
                    gVar.f3942b.x();
                    return gVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.d<g, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f4127c;

            /* renamed from: d  reason: collision with root package name */
            public List<t> f4128d = Collections.emptyList();

            /* renamed from: e  reason: collision with root package name */
            public b2<t, t.b, Object> f4129e;

            public b() {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public k0.b m118addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                g j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public k0.b m120clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return g.f4124e;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.j;
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b h(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.k;
                fVar.c(g.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.d, c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                t tVar;
                int i = 0;
                while (true) {
                    b2<t, t.b, Object> b2Var = this.f4129e;
                    if (i < (b2Var == null ? this.f4128d.size() : b2Var.m())) {
                        b2<t, t.b, Object> b2Var2 = this.f4129e;
                        if (b2Var2 == null) {
                            tVar = this.f4128d.get(i);
                        } else {
                            tVar = b2Var2.n(i, false);
                        }
                        if (!tVar.isInitialized()) {
                            return false;
                        }
                        i++;
                    } else if (!e()) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }

            /* renamed from: j */
            public g buildPartial() {
                List<t> list;
                g gVar = new g(this, null);
                int i = this.f4127c;
                b2<t, t.b, Object> b2Var = this.f4129e;
                if (b2Var == null) {
                    if ((i & 1) != 0) {
                        this.f4128d = Collections.unmodifiableList(this.f4128d);
                        this.f4127c &= -2;
                    }
                    list = this.f4128d;
                } else {
                    list = b2Var.g();
                }
                gVar.f4125c = list;
                onBuilt();
                return gVar;
            }

            public b k() {
                super.clear();
                b2<t, t.b, Object> b2Var = this.f4129e;
                if (b2Var == null) {
                    this.f4128d = Collections.emptyList();
                    this.f4127c &= -2;
                } else {
                    b2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final b2<t, t.b, Object> m() {
                if (this.f4129e == null) {
                    List<t> list = this.f4128d;
                    boolean z = true;
                    if ((this.f4127c & 1) == 0) {
                        z = false;
                    }
                    this.f4129e = new b2<>(list, z, getParentForChildren(), isClean());
                    this.f4128d = null;
                }
                return this.f4129e;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof g) {
                    o((g) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b n(k kVar, z zVar) {
                Throwable th;
                g gVar;
                g gVar2 = null;
                try {
                    g parsePartialFrom = g.f.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        o(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    gVar = (g) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    gVar2 = gVar;
                    if (gVar2 != null) {
                    }
                    throw th;
                }
            }

            public b o(g gVar) {
                if (gVar == g.f4124e) {
                    return this;
                }
                if (this.f4129e == null) {
                    if (!gVar.f4125c.isEmpty()) {
                        if (this.f4128d.isEmpty()) {
                            this.f4128d = gVar.f4125c;
                            this.f4127c &= -2;
                        } else {
                            if ((this.f4127c & 1) == 0) {
                                this.f4128d = new ArrayList(this.f4128d);
                                this.f4127c |= 1;
                            }
                            this.f4128d.addAll(gVar.f4125c);
                        }
                        onChanged();
                    }
                } else if (!gVar.f4125c.isEmpty()) {
                    if (this.f4129e.s()) {
                        b2<t, t.b, Object> b2Var = null;
                        this.f4129e.f3831a = null;
                        this.f4129e = null;
                        this.f4128d = gVar.f4125c;
                        this.f4127c &= -2;
                        if (k0.alwaysUseFieldBuilders) {
                            b2Var = m();
                        }
                        this.f4129e = b2Var;
                    } else {
                        this.f4129e.b(gVar.f4125c);
                    }
                }
                f(gVar);
                p(gVar.unknownFields);
                onChanged();
                return this;
            }

            public final b p(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public k0.b m127setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public k0.b m128setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public k0.b m129setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(a aVar) {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m119build() {
                g j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public k0.b m122clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m123getDefaultInstanceForType() {
                return g.f4124e;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m124mergeFrom(e1 e1Var) {
                if (e1Var instanceof g) {
                    o((g) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public k0.b m126mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            public e1.a setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public e1.a m121clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public e1.a m125mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public g() {
            this.f4126d = -1;
            this.f4125c = Collections.emptyList();
        }

        public g(k0.d dVar, a aVar) {
            super(dVar);
            this.f4126d = -1;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof g)) {
                return super.equals(obj);
            }
            g gVar = (g) obj;
            if (this.f4125c.equals(gVar.f4125c) && this.unknownFields.equals(gVar.unknownFields) && c().equals(gVar.c())) {
                return true;
            }
            return false;
        }

        /* renamed from: f */
        public b toBuilder() {
            if (this == f4124e) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.o(this);
            return bVar;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return f4124e;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<g> getParserForType() {
            return f;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f4125c.size(); i3++) {
                i2 += m.z(b.r.h.MAX_BIND_PARAMETER_CNT, this.f4125c.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + i2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = r.j.hashCode() + 779;
            if (this.f4125c.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.r.h.MAX_BIND_PARAMETER_CNT, 53) + this.f4125c.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.k;
            fVar.c(g.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.k0.e, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.f4126d;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.f4125c.size(); i++) {
                if (!this.f4125c.get(i).isInitialized()) {
                    this.f4126d = 0;
                    return false;
                }
            }
            if (!a()) {
                this.f4126d = 0;
                return false;
            }
            this.f4126d = 1;
            return true;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return f4124e.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new g();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            k0.e<MessageType>.a d2 = d();
            for (int i = 0; i < this.f4125c.size(); i++) {
                mVar.k0(b.r.h.MAX_BIND_PARAMETER_CNT, this.f4125c.get(i));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m116getDefaultInstanceForType() {
            return f4124e;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m117newBuilderForType() {
            return f4124e.toBuilder();
        }
    }

    public static final class h extends k0 implements j1 {
        public static final h n = new h();
        @Deprecated
        public static final v1<h> o = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f4130b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f4131c;

        /* renamed from: d  reason: collision with root package name */
        public int f4132d;

        /* renamed from: e  reason: collision with root package name */
        public int f4133e;
        public int f;
        public volatile Object g;
        public volatile Object h;
        public volatile Object i;
        public int j;
        public volatile Object k;
        public i l;
        public byte m;

        public static class a extends c<h> {
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                h hVar = new h();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            switch (G) {
                                case 0:
                                    break;
                                case 10:
                                    j n = kVar.n();
                                    hVar.f4130b = 1 | hVar.f4130b;
                                    hVar.f4131c = n;
                                    continue;
                                case 18:
                                    j n2 = kVar.n();
                                    hVar.f4130b |= 32;
                                    hVar.h = n2;
                                    continue;
                                case 24:
                                    hVar.f4130b |= 2;
                                    hVar.f4132d = kVar.u();
                                    continue;
                                case 32:
                                    int p = kVar.p();
                                    if (c.b(p) == null) {
                                        b2.h(4, p);
                                        continue;
                                    } else {
                                        hVar.f4130b |= 4;
                                        hVar.f4133e = p;
                                    }
                                case 40:
                                    int p2 = kVar.p();
                                    if (d.b(p2) == null) {
                                        b2.h(5, p2);
                                        continue;
                                    } else {
                                        hVar.f4130b |= 8;
                                        hVar.f = p2;
                                    }
                                case 50:
                                    j n3 = kVar.n();
                                    hVar.f4130b |= 16;
                                    hVar.g = n3;
                                    continue;
                                case 58:
                                    j n4 = kVar.n();
                                    hVar.f4130b |= 64;
                                    hVar.i = n4;
                                    continue;
                                case 66:
                                    i.b l = (hVar.f4130b & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0 ? hVar.l.toBuilder() : null;
                                    i iVar = (i) kVar.w(i.m, zVar);
                                    hVar.l = iVar;
                                    if (l != null) {
                                        l.o(iVar);
                                        hVar.l = l.buildPartial();
                                    }
                                    hVar.f4130b |= RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN;
                                    continue;
                                case 72:
                                    hVar.f4130b |= RecyclerView.d0.FLAG_IGNORE;
                                    hVar.j = kVar.u();
                                    continue;
                                case 82:
                                    j n5 = kVar.n();
                                    hVar.f4130b |= RecyclerView.d0.FLAG_TMP_DETACHED;
                                    hVar.k = n5;
                                    continue;
                                default:
                                    if (hVar.parseUnknownField(kVar, b2, zVar, G)) {
                                        continue;
                                    }
                                    break;
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = hVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = hVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            hVar.unknownFields = b2.build();
                            hVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    hVar.unknownFields = b2.build();
                    hVar.makeExtensionsImmutable();
                    return hVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f4134b;

            /* renamed from: c  reason: collision with root package name */
            public Object f4135c = "";

            /* renamed from: d  reason: collision with root package name */
            public int f4136d;

            /* renamed from: e  reason: collision with root package name */
            public int f4137e = 1;
            public int f = 1;
            public Object g = "";
            public Object h = "";
            public Object i = "";
            public int j;
            public Object k = "";
            public i l;
            public f2<i, i.b, Object> m;

            public b() {
                maybeForceBuilderInitialization();
            }

            public b(a aVar) {
                maybeForceBuilderInitialization();
            }

            /* renamed from: a */
            public h buildPartial() {
                h hVar = new h(this, null);
                int i2 = this.f4134b;
                int i3 = (i2 & 1) != 0 ? 1 : 0;
                hVar.f4131c = this.f4135c;
                if ((i2 & 2) != 0) {
                    hVar.f4132d = this.f4136d;
                    i3 |= 2;
                }
                if ((i2 & 4) != 0) {
                    i3 |= 4;
                }
                hVar.f4133e = this.f4137e;
                if ((i2 & 8) != 0) {
                    i3 |= 8;
                }
                hVar.f = this.f;
                if ((i2 & 16) != 0) {
                    i3 |= 16;
                }
                hVar.g = this.g;
                if ((i2 & 32) != 0) {
                    i3 |= 32;
                }
                hVar.h = this.h;
                if ((i2 & 64) != 0) {
                    i3 |= 64;
                }
                hVar.i = this.i;
                if ((i2 & RecyclerView.d0.FLAG_IGNORE) != 0) {
                    hVar.j = this.j;
                    i3 |= RecyclerView.d0.FLAG_IGNORE;
                }
                if ((i2 & RecyclerView.d0.FLAG_TMP_DETACHED) != 0) {
                    i3 |= RecyclerView.d0.FLAG_TMP_DETACHED;
                }
                hVar.k = this.k;
                if ((i2 & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                    f2<i, i.b, Object> f2Var = this.m;
                    hVar.l = f2Var == null ? this.l : f2Var.b();
                    i3 |= RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN;
                }
                hVar.f4130b = i3;
                onBuilt();
                return hVar;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m132addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            public b b() {
                super.clear();
                this.f4135c = "";
                int i2 = this.f4134b & -2;
                this.f4134b = i2;
                this.f4136d = 0;
                int i3 = i2 & -3;
                this.f4134b = i3;
                this.f4137e = 1;
                int i4 = i3 & -5;
                this.f4134b = i4;
                this.f = 1;
                int i5 = i4 & -9;
                this.f4134b = i5;
                this.g = "";
                int i6 = i5 & -17;
                this.f4134b = i6;
                this.h = "";
                int i7 = i6 & -33;
                this.f4134b = i7;
                this.i = "";
                int i8 = i7 & -65;
                this.f4134b = i8;
                this.j = 0;
                int i9 = i8 & -129;
                this.f4134b = i9;
                this.k = "";
                this.f4134b = i9 & -257;
                f2<i, i.b, Object> f2Var = this.m;
                if (f2Var == null) {
                    this.l = null;
                } else {
                    f2Var.c();
                }
                this.f4134b &= -513;
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                h a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
            }

            /* renamed from: c */
            public b clone() {
                return (b) super.clone();
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m134clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b d(k kVar, z zVar) {
                Throwable th;
                h hVar;
                h hVar2 = null;
                try {
                    h parsePartialFrom = h.o.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        e(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    hVar = (h) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    hVar2 = hVar;
                    if (hVar2 != null) {
                    }
                    throw th;
                }
            }

            public b e(h hVar) {
                i iVar;
                i iVar2;
                if (hVar == h.n) {
                    return this;
                }
                if (hVar.l()) {
                    this.f4134b |= 1;
                    this.f4135c = hVar.f4131c;
                    onChanged();
                }
                if (hVar.m()) {
                    int i2 = hVar.f4132d;
                    this.f4134b |= 2;
                    this.f4136d = i2;
                    onChanged();
                }
                if (hVar.k()) {
                    c d2 = hVar.d();
                    this.f4134b |= 4;
                    this.f4137e = d2.f4141b;
                    onChanged();
                }
                if (hVar.p()) {
                    d b2 = d.b(hVar.f);
                    if (b2 == null) {
                        b2 = d.TYPE_DOUBLE;
                    }
                    this.f4134b |= 8;
                    this.f = b2.f4145b;
                    onChanged();
                }
                if (hVar.q()) {
                    this.f4134b |= 16;
                    this.g = hVar.g;
                    onChanged();
                }
                if (hVar.i()) {
                    this.f4134b |= 32;
                    this.h = hVar.h;
                    onChanged();
                }
                if (hVar.h()) {
                    this.f4134b |= 64;
                    this.i = hVar.i;
                    onChanged();
                }
                if (hVar.n()) {
                    int i3 = hVar.j;
                    this.f4134b |= RecyclerView.d0.FLAG_IGNORE;
                    this.j = i3;
                    onChanged();
                }
                if (hVar.j()) {
                    this.f4134b |= RecyclerView.d0.FLAG_TMP_DETACHED;
                    this.k = hVar.k;
                    onChanged();
                }
                if (hVar.o()) {
                    i f2 = hVar.f();
                    f2<i, i.b, Object> f2Var = this.m;
                    if (f2Var == null) {
                        if (!((this.f4134b & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0 || (iVar = this.l) == null || iVar == (iVar2 = i.l))) {
                            i.b l2 = iVar2.toBuilder();
                            l2.o(iVar);
                            l2.o(f2);
                            f2 = l2.buildPartial();
                        }
                        this.l = f2;
                        onChanged();
                    } else {
                        f2Var.f(f2);
                    }
                    this.f4134b |= RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN;
                }
                f(hVar.unknownFields);
                onChanged();
                return this;
            }

            public final b f(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return h.n;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.l;
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.m;
                fVar.c(h.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                i iVar;
                if ((this.f4134b & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                    f2<i, i.b, Object> f2Var = this.m;
                    if (f2Var == null) {
                        iVar = this.l;
                        if (iVar == null) {
                            iVar = i.l;
                        }
                    } else {
                        iVar = f2Var.e();
                    }
                    if (!iVar.isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public final void maybeForceBuilderInitialization() {
                f2<i, i.b, Object> f2Var;
                i iVar;
                if (k0.alwaysUseFieldBuilders && (f2Var = this.m) == null) {
                    if (f2Var == null) {
                        iVar = this.l;
                        if (iVar == null) {
                            iVar = i.l;
                        }
                    } else {
                        iVar = f2Var.e();
                    }
                    this.m = new f2<>(iVar, getParentForChildren(), isClean());
                    this.l = null;
                }
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof h) {
                    e((h) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m141setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m142setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m143setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m133build() {
                h a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m136clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m137getDefaultInstanceForType() {
                return h.n;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m138mergeFrom(e1 e1Var) {
                if (e1Var instanceof h) {
                    e((h) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m140mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            public b setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m135clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m139mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }
        }

        public enum c implements Object {
            LABEL_OPTIONAL(1),
            LABEL_REQUIRED(2),
            LABEL_REPEATED(3);
            

            /* renamed from: b  reason: collision with root package name */
            public final int f4141b;

            /* access modifiers changed from: public */
            static {
                values();
            }

            /* access modifiers changed from: public */
            c(int i) {
                this.f4141b = i;
            }

            public static c b(int i) {
                if (i == 1) {
                    return LABEL_OPTIONAL;
                }
                if (i == 2) {
                    return LABEL_REQUIRED;
                }
                if (i != 3) {
                    return null;
                }
                return LABEL_REPEATED;
            }

            public final int a() {
                return this.f4141b;
            }
        }

        public enum d implements Object {
            TYPE_DOUBLE(1),
            TYPE_FLOAT(2),
            TYPE_INT64(3),
            TYPE_UINT64(4),
            TYPE_INT32(5),
            TYPE_FIXED64(6),
            TYPE_FIXED32(7),
            TYPE_BOOL(8),
            TYPE_STRING(9),
            TYPE_GROUP(10),
            TYPE_MESSAGE(11),
            TYPE_BYTES(12),
            TYPE_UINT32(13),
            TYPE_ENUM(14),
            TYPE_SFIXED32(15),
            TYPE_SFIXED64(16),
            TYPE_SINT32(17),
            TYPE_SINT64(18);
            

            /* renamed from: b  reason: collision with root package name */
            public final int f4145b;

            /* access modifiers changed from: public */
            static {
                values();
            }

            /* access modifiers changed from: public */
            d(int i) {
                this.f4145b = i;
            }

            public static d b(int i) {
                switch (i) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            public final int a() {
                return this.f4145b;
            }
        }

        public h() {
            this.m = -1;
            this.f4131c = "";
            this.f4133e = 1;
            this.f = 1;
            this.g = "";
            this.h = "";
            this.i = "";
            this.k = "";
        }

        public h(k0.b bVar, a aVar) {
            super(bVar);
            this.m = -1;
        }

        public String a() {
            Object obj = this.i;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.i = u;
            }
            return u;
        }

        public String b() {
            Object obj = this.h;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.h = u;
            }
            return u;
        }

        public String c() {
            Object obj = this.k;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.k = u;
            }
            return u;
        }

        public c d() {
            c b2 = c.b(this.f4133e);
            return b2 == null ? c.LABEL_OPTIONAL : b2;
        }

        public String e() {
            Object obj = this.f4131c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.f4131c = u;
            }
            return u;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof h)) {
                return super.equals(obj);
            }
            h hVar = (h) obj;
            if (l() != hVar.l()) {
                return false;
            }
            if ((l() && !e().equals(hVar.e())) || m() != hVar.m()) {
                return false;
            }
            if ((m() && this.f4132d != hVar.f4132d) || k() != hVar.k()) {
                return false;
            }
            if ((k() && this.f4133e != hVar.f4133e) || p() != hVar.p()) {
                return false;
            }
            if ((p() && this.f != hVar.f) || q() != hVar.q()) {
                return false;
            }
            if ((q() && !g().equals(hVar.g())) || i() != hVar.i()) {
                return false;
            }
            if ((i() && !b().equals(hVar.b())) || h() != hVar.h()) {
                return false;
            }
            if ((h() && !a().equals(hVar.a())) || n() != hVar.n()) {
                return false;
            }
            if ((n() && this.j != hVar.j) || j() != hVar.j()) {
                return false;
            }
            if ((!j() || c().equals(hVar.c())) && o() == hVar.o()) {
                return (!o() || f().equals(hVar.f())) && this.unknownFields.equals(hVar.unknownFields);
            }
            return false;
        }

        public i f() {
            i iVar = this.l;
            return iVar == null ? i.l : iVar;
        }

        public String g() {
            Object obj = this.g;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.g = u;
            }
            return u;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return n;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<h> getParserForType() {
            return o;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.f4130b & 1) != 0) {
                i3 = 0 + k0.computeStringSize(1, this.f4131c);
            }
            if ((this.f4130b & 32) != 0) {
                i3 += k0.computeStringSize(2, this.h);
            }
            if ((this.f4130b & 2) != 0) {
                i3 += m.s(3, this.f4132d);
            }
            if ((this.f4130b & 4) != 0) {
                i3 += m.j(4, this.f4133e);
            }
            if ((this.f4130b & 8) != 0) {
                i3 += m.j(5, this.f);
            }
            if ((this.f4130b & 16) != 0) {
                i3 += k0.computeStringSize(6, this.g);
            }
            if ((this.f4130b & 64) != 0) {
                i3 += k0.computeStringSize(7, this.i);
            }
            if ((this.f4130b & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                i3 += m.z(8, f());
            }
            if ((this.f4130b & RecyclerView.d0.FLAG_IGNORE) != 0) {
                i3 += m.s(9, this.j);
            }
            if ((this.f4130b & RecyclerView.d0.FLAG_TMP_DETACHED) != 0) {
                i3 += k0.computeStringSize(10, this.k);
            }
            int serializedSize = this.unknownFields.getSerializedSize() + i3;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean h() {
            return (this.f4130b & 64) != 0;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.l.hashCode() + 779;
            if (l()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + e().hashCode();
            }
            if (m()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + this.f4132d;
            }
            if (k()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 4, 53) + this.f4133e;
            }
            if (p()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 5, 53) + this.f;
            }
            if (q()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 6, 53) + g().hashCode();
            }
            if (i()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + b().hashCode();
            }
            if (h()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 7, 53) + a().hashCode();
            }
            if (n()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 9, 53) + this.j;
            }
            if (j()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 10, 53) + c().hashCode();
            }
            if (o()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 8, 53) + f().hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public boolean i() {
            return (this.f4130b & 32) != 0;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.m;
            fVar.c(h.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.m;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!o() || f().isInitialized()) {
                this.m = 1;
                return true;
            }
            this.m = 0;
            return false;
        }

        public boolean j() {
            return (this.f4130b & RecyclerView.d0.FLAG_TMP_DETACHED) != 0;
        }

        public boolean k() {
            return (this.f4130b & 4) != 0;
        }

        public boolean l() {
            return (this.f4130b & 1) != 0;
        }

        public boolean m() {
            return (this.f4130b & 2) != 0;
        }

        public boolean n() {
            return (this.f4130b & RecyclerView.d0.FLAG_IGNORE) != 0;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return n.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new h();
        }

        public boolean o() {
            return (this.f4130b & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0;
        }

        public boolean p() {
            return (this.f4130b & 8) != 0;
        }

        public boolean q() {
            return (this.f4130b & 16) != 0;
        }

        /* renamed from: r */
        public b toBuilder() {
            if (this == n) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.e(this);
            return bVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            if ((this.f4130b & 1) != 0) {
                k0.writeString(mVar, 1, this.f4131c);
            }
            if ((this.f4130b & 32) != 0) {
                k0.writeString(mVar, 2, this.h);
            }
            if ((this.f4130b & 2) != 0) {
                mVar.i0(3, this.f4132d);
            }
            if ((this.f4130b & 4) != 0) {
                mVar.i0(4, this.f4133e);
            }
            if ((this.f4130b & 8) != 0) {
                mVar.i0(5, this.f);
            }
            if ((this.f4130b & 16) != 0) {
                k0.writeString(mVar, 6, this.g);
            }
            if ((this.f4130b & 64) != 0) {
                k0.writeString(mVar, 7, this.i);
            }
            if ((this.f4130b & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                mVar.k0(8, f());
            }
            if ((this.f4130b & RecyclerView.d0.FLAG_IGNORE) != 0) {
                mVar.i0(9, this.j);
            }
            if ((this.f4130b & RecyclerView.d0.FLAG_TMP_DETACHED) != 0) {
                k0.writeString(mVar, 10, this.k);
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m130getDefaultInstanceForType() {
            return n;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m131newBuilderForType() {
            return n.toBuilder();
        }
    }

    public static final class i extends k0.e<i> implements Object {
        public static final i l = new i();
        @Deprecated
        public static final v1<i> m = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f4146c;

        /* renamed from: d  reason: collision with root package name */
        public int f4147d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4148e;
        public int f;
        public boolean g;
        public boolean h;
        public boolean i;
        public List<t> j;
        public byte k;

        public static class a extends c<i> {
            /* JADX DEBUG: Multi-variable search result rejected for r4v16, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                i iVar = new i();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 8) {
                                    int p = kVar.p();
                                    if (c.b(p) == null) {
                                        b2.h(1, p);
                                    } else {
                                        iVar.f4146c = 1 | iVar.f4146c;
                                        iVar.f4147d = p;
                                    }
                                } else if (G == 16) {
                                    iVar.f4146c |= 2;
                                    iVar.f4148e = kVar.m();
                                } else if (G == 24) {
                                    iVar.f4146c |= 16;
                                    iVar.h = kVar.m();
                                } else if (G == 40) {
                                    iVar.f4146c |= 8;
                                    iVar.g = kVar.m();
                                } else if (G == 48) {
                                    int p2 = kVar.p();
                                    if (d.b(p2) == null) {
                                        b2.h(6, p2);
                                    } else {
                                        iVar.f4146c |= 4;
                                        iVar.f = p2;
                                    }
                                } else if (G == 80) {
                                    iVar.f4146c |= 32;
                                    iVar.i = kVar.m();
                                } else if (G == 7994) {
                                    if (!z2 || !true) {
                                        iVar.j = new ArrayList();
                                        z2 |= true;
                                    }
                                    iVar.j.add(kVar.w(t.l, zVar));
                                } else if (!iVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = iVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = iVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                iVar.j = Collections.unmodifiableList(iVar.j);
                            }
                            iVar.unknownFields = b2.build();
                            iVar.f3942b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        iVar.j = Collections.unmodifiableList(iVar.j);
                    }
                    iVar.unknownFields = b2.build();
                    iVar.f3942b.x();
                    return iVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.d<i, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f4149c;

            /* renamed from: d  reason: collision with root package name */
            public int f4150d = 0;

            /* renamed from: e  reason: collision with root package name */
            public boolean f4151e;
            public int f = 0;
            public boolean g;
            public boolean h;
            public boolean i;
            public List<t> j = Collections.emptyList();
            public b2<t, t.b, Object> k;

            public b() {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public k0.b m146addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                i j2 = buildPartial();
                if (j2.isInitialized()) {
                    return j2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j2);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public k0.b m148clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return i.l;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.D;
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b h(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.E;
                fVar.c(i.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.d, c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                t tVar;
                int i2 = 0;
                while (true) {
                    b2<t, t.b, Object> b2Var = this.k;
                    if (i2 < (b2Var == null ? this.j.size() : b2Var.m())) {
                        b2<t, t.b, Object> b2Var2 = this.k;
                        if (b2Var2 == null) {
                            tVar = this.j.get(i2);
                        } else {
                            tVar = b2Var2.n(i2, false);
                        }
                        if (!tVar.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else if (!e()) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }

            /* renamed from: j */
            public i buildPartial() {
                List<t> list;
                i iVar = new i(this, null);
                int i2 = this.f4149c;
                int i3 = (i2 & 1) != 0 ? 1 : 0;
                iVar.f4147d = this.f4150d;
                if ((i2 & 2) != 0) {
                    iVar.f4148e = this.f4151e;
                    i3 |= 2;
                }
                if ((i2 & 4) != 0) {
                    i3 |= 4;
                }
                iVar.f = this.f;
                if ((i2 & 8) != 0) {
                    iVar.g = this.g;
                    i3 |= 8;
                }
                if ((i2 & 16) != 0) {
                    iVar.h = this.h;
                    i3 |= 16;
                }
                if ((i2 & 32) != 0) {
                    iVar.i = this.i;
                    i3 |= 32;
                }
                b2<t, t.b, Object> b2Var = this.k;
                if (b2Var == null) {
                    if ((this.f4149c & 64) != 0) {
                        this.j = Collections.unmodifiableList(this.j);
                        this.f4149c &= -65;
                    }
                    list = this.j;
                } else {
                    list = b2Var.g();
                }
                iVar.j = list;
                iVar.f4146c = i3;
                onBuilt();
                return iVar;
            }

            public b k() {
                super.clear();
                this.f4150d = 0;
                int i2 = this.f4149c & -2;
                this.f4149c = i2;
                this.f4151e = false;
                int i3 = i2 & -3;
                this.f4149c = i3;
                this.f = 0;
                int i4 = i3 & -5;
                this.f4149c = i4;
                this.g = false;
                int i5 = i4 & -9;
                this.f4149c = i5;
                this.h = false;
                int i6 = i5 & -17;
                this.f4149c = i6;
                this.i = false;
                this.f4149c = i6 & -33;
                b2<t, t.b, Object> b2Var = this.k;
                if (b2Var == null) {
                    this.j = Collections.emptyList();
                    this.f4149c &= -65;
                } else {
                    b2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final b2<t, t.b, Object> m() {
                if (this.k == null) {
                    this.k = new b2<>(this.j, (this.f4149c & 64) != 0, getParentForChildren(), isClean());
                    this.j = null;
                }
                return this.k;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof i) {
                    o((i) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b n(k kVar, z zVar) {
                Throwable th;
                i iVar;
                i iVar2 = null;
                try {
                    i parsePartialFrom = i.m.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        o(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    iVar = (i) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    iVar2 = iVar;
                    if (iVar2 != null) {
                    }
                    throw th;
                }
            }

            public b o(i iVar) {
                if (iVar == i.l) {
                    return this;
                }
                if (iVar.f()) {
                    c b2 = c.b(iVar.f4147d);
                    if (b2 == null) {
                        b2 = c.STRING;
                    }
                    this.f4149c |= 1;
                    this.f4150d = b2.f4155b;
                    onChanged();
                }
                if (iVar.j()) {
                    boolean z = iVar.f4148e;
                    this.f4149c |= 2;
                    this.f4151e = z;
                    onChanged();
                }
                if (iVar.h()) {
                    d b3 = d.b(iVar.f);
                    if (b3 == null) {
                        b3 = d.JS_NORMAL;
                    }
                    this.f4149c |= 4;
                    this.f = b3.f4159b;
                    onChanged();
                }
                if (iVar.i()) {
                    boolean z2 = iVar.g;
                    this.f4149c |= 8;
                    this.g = z2;
                    onChanged();
                }
                if (iVar.g()) {
                    boolean z3 = iVar.h;
                    this.f4149c |= 16;
                    this.h = z3;
                    onChanged();
                }
                if (iVar.k()) {
                    boolean z4 = iVar.i;
                    this.f4149c |= 32;
                    this.i = z4;
                    onChanged();
                }
                if (this.k == null) {
                    if (!iVar.j.isEmpty()) {
                        if (this.j.isEmpty()) {
                            this.j = iVar.j;
                            this.f4149c &= -65;
                        } else {
                            if ((this.f4149c & 64) == 0) {
                                this.j = new ArrayList(this.j);
                                this.f4149c |= 64;
                            }
                            this.j.addAll(iVar.j);
                        }
                        onChanged();
                    }
                } else if (!iVar.j.isEmpty()) {
                    if (this.k.s()) {
                        b2<t, t.b, Object> b2Var = null;
                        this.k.f3831a = null;
                        this.k = null;
                        this.j = iVar.j;
                        this.f4149c &= -65;
                        if (k0.alwaysUseFieldBuilders) {
                            b2Var = m();
                        }
                        this.k = b2Var;
                    } else {
                        this.k.b(iVar.j);
                    }
                }
                f(iVar);
                p(iVar.unknownFields);
                onChanged();
                return this;
            }

            public final b p(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public k0.b m155setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public k0.b m156setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public k0.b m157setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(a aVar) {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m147build() {
                i j2 = buildPartial();
                if (j2.isInitialized()) {
                    return j2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j2);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public k0.b m150clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m151getDefaultInstanceForType() {
                return i.l;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m152mergeFrom(e1 e1Var) {
                if (e1Var instanceof i) {
                    o((i) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public k0.b m154mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            public e1.a setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public e1.a m149clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public e1.a m153mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public enum c implements Object {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);
            

            /* renamed from: b  reason: collision with root package name */
            public final int f4155b;

            /* access modifiers changed from: public */
            static {
                values();
            }

            /* access modifiers changed from: public */
            c(int i) {
                this.f4155b = i;
            }

            public static c b(int i) {
                if (i == 0) {
                    return STRING;
                }
                if (i == 1) {
                    return CORD;
                }
                if (i != 2) {
                    return null;
                }
                return STRING_PIECE;
            }

            public final int a() {
                return this.f4155b;
            }
        }

        public enum d implements Object {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);
            

            /* renamed from: b  reason: collision with root package name */
            public final int f4159b;

            /* access modifiers changed from: public */
            static {
                values();
            }

            /* access modifiers changed from: public */
            d(int i) {
                this.f4159b = i;
            }

            public static d b(int i) {
                if (i == 0) {
                    return JS_NORMAL;
                }
                if (i == 1) {
                    return JS_STRING;
                }
                if (i != 2) {
                    return null;
                }
                return JS_NUMBER;
            }

            public final int a() {
                return this.f4159b;
            }
        }

        public i() {
            this.k = -1;
            this.f4147d = 0;
            this.f = 0;
            this.j = Collections.emptyList();
        }

        public i(k0.d dVar, a aVar) {
            super(dVar);
            this.k = -1;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof i)) {
                return super.equals(obj);
            }
            i iVar = (i) obj;
            if (f() != iVar.f()) {
                return false;
            }
            if ((f() && this.f4147d != iVar.f4147d) || j() != iVar.j()) {
                return false;
            }
            if ((j() && this.f4148e != iVar.f4148e) || h() != iVar.h()) {
                return false;
            }
            if ((h() && this.f != iVar.f) || i() != iVar.i()) {
                return false;
            }
            if ((i() && this.g != iVar.g) || g() != iVar.g()) {
                return false;
            }
            if ((!g() || this.h == iVar.h) && k() == iVar.k()) {
                return (!k() || this.i == iVar.i) && this.j.equals(iVar.j) && this.unknownFields.equals(iVar.unknownFields) && c().equals(iVar.c());
            }
            return false;
        }

        public boolean f() {
            return (this.f4146c & 1) != 0;
        }

        public boolean g() {
            return (this.f4146c & 16) != 0;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return l;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<i> getParserForType() {
            return m;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int j2 = (this.f4146c & 1) != 0 ? m.j(1, this.f4147d) + 0 : 0;
            if ((this.f4146c & 2) != 0) {
                j2 += m.c(2, this.f4148e);
            }
            if ((this.f4146c & 16) != 0) {
                j2 += m.c(3, this.h);
            }
            if ((this.f4146c & 8) != 0) {
                j2 += m.c(5, this.g);
            }
            if ((this.f4146c & 4) != 0) {
                j2 += m.j(6, this.f);
            }
            if ((this.f4146c & 32) != 0) {
                j2 += m.c(10, this.i);
            }
            for (int i3 = 0; i3 < this.j.size(); i3++) {
                j2 += m.z(b.r.h.MAX_BIND_PARAMETER_CNT, this.j.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + j2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean h() {
            return (this.f4146c & 4) != 0;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.D.hashCode() + 779;
            if (f()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + this.f4147d;
            }
            if (j()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + m0.c(this.f4148e);
            }
            if (h()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 6, 53) + this.f;
            }
            if (i()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 5, 53) + m0.c(this.g);
            }
            if (g()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + m0.c(this.h);
            }
            if (k()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 10, 53) + m0.c(this.i);
            }
            if (this.j.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.r.h.MAX_BIND_PARAMETER_CNT, 53) + this.j.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public boolean i() {
            return (this.f4146c & 8) != 0;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.E;
            fVar.c(i.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.k0.e, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.k;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                if (!this.j.get(i2).isInitialized()) {
                    this.k = 0;
                    return false;
                }
            }
            if (!a()) {
                this.k = 0;
                return false;
            }
            this.k = 1;
            return true;
        }

        public boolean j() {
            return (this.f4146c & 2) != 0;
        }

        public boolean k() {
            return (this.f4146c & 32) != 0;
        }

        /* renamed from: l */
        public b toBuilder() {
            if (this == l) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.o(this);
            return bVar;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return l.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new i();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            k0.e<MessageType>.a d2 = d();
            if ((this.f4146c & 1) != 0) {
                mVar.i0(1, this.f4147d);
            }
            if ((this.f4146c & 2) != 0) {
                mVar.Y(2, this.f4148e);
            }
            if ((this.f4146c & 16) != 0) {
                mVar.Y(3, this.h);
            }
            if ((this.f4146c & 8) != 0) {
                mVar.Y(5, this.g);
            }
            if ((this.f4146c & 4) != 0) {
                mVar.i0(6, this.f);
            }
            if ((this.f4146c & 32) != 0) {
                mVar.Y(10, this.i);
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                mVar.k0(b.r.h.MAX_BIND_PARAMETER_CNT, this.j.get(i2));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m144getDefaultInstanceForType() {
            return l;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m145newBuilderForType() {
            return l.toBuilder();
        }
    }

    public static final class j extends k0 implements j1 {
        public static final j p = new j();
        @Deprecated
        public static final v1<j> q = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f4160b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f4161c;

        /* renamed from: d  reason: collision with root package name */
        public volatile Object f4162d;

        /* renamed from: e  reason: collision with root package name */
        public s0 f4163e;
        public m0.f f;
        public m0.f g;
        public List<b> h;
        public List<c> i;
        public List<q> j;
        public List<h> k;
        public k l;
        public s m;
        public volatile Object n;
        public byte o;

        public static class a extends c<j> {
            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                Object obj;
                List list;
                m0.f fVar;
                int i;
                j jVar = new j();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            switch (G) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    j n = kVar.n();
                                    jVar.f4160b = 1 | jVar.f4160b;
                                    jVar.f4161c = n;
                                    break;
                                case 18:
                                    j n2 = kVar.n();
                                    jVar.f4160b |= 2;
                                    jVar.f4162d = n2;
                                    break;
                                case 26:
                                    j n3 = kVar.n();
                                    if (!z2 || !true) {
                                        jVar.f4163e = new r0(10);
                                        z2 |= true;
                                    }
                                    jVar.f4163e.l(n3);
                                    break;
                                case 34:
                                    if (!z2 || !true) {
                                        jVar.h = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = jVar.h;
                                    obj = b.o;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 42:
                                    if (!z2 || !true) {
                                        jVar.i = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = jVar.i;
                                    obj = c.j;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 50:
                                    if (!z2 || !true) {
                                        jVar.j = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = jVar.j;
                                    obj = q.h;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 58:
                                    if (!z2 || !true) {
                                        jVar.k = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = jVar.k;
                                    obj = h.o;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 66:
                                    k.b J = (jVar.f4160b & 4) != 0 ? jVar.l.toBuilder() : null;
                                    k kVar2 = (k) kVar.w(k.A, zVar);
                                    jVar.l = kVar2;
                                    if (J != null) {
                                        J.o(kVar2);
                                        jVar.l = J.buildPartial();
                                    }
                                    jVar.f4160b |= 4;
                                    break;
                                case 74:
                                    s.b a2 = (jVar.f4160b & 8) != 0 ? jVar.m.toBuilder() : null;
                                    s sVar = (s) kVar.w(s.f4231e, zVar);
                                    jVar.m = sVar;
                                    if (a2 != null) {
                                        a2.f(sVar);
                                        jVar.m = a2.buildPartial();
                                    }
                                    jVar.f4160b |= 8;
                                    break;
                                case 80:
                                    if (!z2 || !true) {
                                        jVar.f = k0.newIntList();
                                        z2 |= true;
                                    }
                                    fVar = jVar.f;
                                    ((l0) fVar).c(kVar.u());
                                    break;
                                case 82:
                                    i = kVar.l(kVar.y());
                                    if ((!z2 || !true) && kVar.d() > 0) {
                                        jVar.f = k0.newIntList();
                                        z2 |= true;
                                    }
                                    while (kVar.d() > 0) {
                                        ((l0) jVar.f).c(kVar.u());
                                    }
                                    kVar.k(i);
                                    break;
                                case 88:
                                    if (!z2 || !true) {
                                        jVar.g = k0.newIntList();
                                        z2 |= true;
                                    }
                                    fVar = jVar.g;
                                    ((l0) fVar).c(kVar.u());
                                    break;
                                case 90:
                                    i = kVar.l(kVar.y());
                                    if ((!z2 || !true) && kVar.d() > 0) {
                                        jVar.g = k0.newIntList();
                                        z2 |= true;
                                    }
                                    while (kVar.d() > 0) {
                                        ((l0) jVar.g).c(kVar.u());
                                    }
                                    kVar.k(i);
                                    break;
                                case 98:
                                    j n4 = kVar.n();
                                    jVar.f4160b |= 16;
                                    jVar.n = n4;
                                    break;
                                default:
                                    if (jVar.parseUnknownField(kVar, b2, zVar, G)) {
                                        break;
                                    }
                                    z = true;
                                    break;
                            }
                        } catch (n0 e2) {
                            e2.f4007b = jVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = jVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                jVar.f4163e = jVar.f4163e.b();
                            }
                            if (z2 && true) {
                                jVar.h = Collections.unmodifiableList(jVar.h);
                            }
                            if (z2 && true) {
                                jVar.i = Collections.unmodifiableList(jVar.i);
                            }
                            if (z2 && true) {
                                jVar.j = Collections.unmodifiableList(jVar.j);
                            }
                            if (z2 && true) {
                                jVar.k = Collections.unmodifiableList(jVar.k);
                            }
                            if (z2 && true) {
                                jVar.f.d();
                            }
                            if (z2 && true) {
                                jVar.g.d();
                            }
                            jVar.unknownFields = b2.build();
                            jVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        jVar.f4163e = jVar.f4163e.b();
                    }
                    if (z2 && true) {
                        jVar.h = Collections.unmodifiableList(jVar.h);
                    }
                    if (z2 && true) {
                        jVar.i = Collections.unmodifiableList(jVar.i);
                    }
                    if (z2 && true) {
                        jVar.j = Collections.unmodifiableList(jVar.j);
                    }
                    if (z2 && true) {
                        jVar.k = Collections.unmodifiableList(jVar.k);
                    }
                    if (z2 && true) {
                        jVar.f.d();
                    }
                    if (z2 && true) {
                        jVar.g.d();
                    }
                    jVar.unknownFields = b2.build();
                    jVar.makeExtensionsImmutable();
                    return jVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f4164b;

            /* renamed from: c  reason: collision with root package name */
            public Object f4165c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f4166d = "";

            /* renamed from: e  reason: collision with root package name */
            public s0 f4167e = r0.f4261e;
            public m0.f f = k0.emptyIntList();
            public m0.f g = k0.emptyIntList();
            public List<b> h = Collections.emptyList();
            public b2<b, b.C0102b, Object> i;
            public List<c> j = Collections.emptyList();
            public b2<c, c.b, Object> k;
            public List<q> l = Collections.emptyList();
            public b2<q, q.b, Object> m;
            public List<h> n = Collections.emptyList();
            public b2<h, h.b, Object> o;
            public k p;
            public f2<k, k.b, Object> q;
            public s r;
            public f2<s, s.b, Object> s;
            public Object t = "";

            public b() {
                maybeForceBuilderInitialization();
            }

            public b(a aVar) {
                maybeForceBuilderInitialization();
            }

            /* renamed from: a */
            public j build() {
                j b2 = buildPartial();
                if (b2.isInitialized()) {
                    return b2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) b2);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m160addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: b */
            public j buildPartial() {
                List<b> list;
                List<c> list2;
                List<q> list3;
                List<h> list4;
                j jVar = new j(this, null);
                int i2 = this.f4164b;
                int i3 = (i2 & 1) != 0 ? 1 : 0;
                jVar.f4161c = this.f4165c;
                if ((i2 & 2) != 0) {
                    i3 |= 2;
                }
                jVar.f4162d = this.f4166d;
                if ((this.f4164b & 4) != 0) {
                    this.f4167e = this.f4167e.b();
                    this.f4164b &= -5;
                }
                jVar.f4163e = this.f4167e;
                if ((this.f4164b & 8) != 0) {
                    this.f.d();
                    this.f4164b &= -9;
                }
                jVar.f = this.f;
                if ((this.f4164b & 16) != 0) {
                    this.g.d();
                    this.f4164b &= -17;
                }
                jVar.g = this.g;
                b2<b, b.C0102b, Object> b2Var = this.i;
                if (b2Var == null) {
                    if ((this.f4164b & 32) != 0) {
                        this.h = Collections.unmodifiableList(this.h);
                        this.f4164b &= -33;
                    }
                    list = this.h;
                } else {
                    list = b2Var.g();
                }
                jVar.h = list;
                b2<c, c.b, Object> b2Var2 = this.k;
                if (b2Var2 == null) {
                    if ((this.f4164b & 64) != 0) {
                        this.j = Collections.unmodifiableList(this.j);
                        this.f4164b &= -65;
                    }
                    list2 = this.j;
                } else {
                    list2 = b2Var2.g();
                }
                jVar.i = list2;
                b2<q, q.b, Object> b2Var3 = this.m;
                if (b2Var3 == null) {
                    if ((this.f4164b & RecyclerView.d0.FLAG_IGNORE) != 0) {
                        this.l = Collections.unmodifiableList(this.l);
                        this.f4164b &= -129;
                    }
                    list3 = this.l;
                } else {
                    list3 = b2Var3.g();
                }
                jVar.j = list3;
                b2<h, h.b, Object> b2Var4 = this.o;
                if (b2Var4 == null) {
                    if ((this.f4164b & RecyclerView.d0.FLAG_TMP_DETACHED) != 0) {
                        this.n = Collections.unmodifiableList(this.n);
                        this.f4164b &= -257;
                    }
                    list4 = this.n;
                } else {
                    list4 = b2Var4.g();
                }
                jVar.k = list4;
                if ((i2 & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                    f2<k, k.b, Object> f2Var = this.q;
                    jVar.l = f2Var == null ? this.p : f2Var.b();
                    i3 |= 4;
                }
                if ((i2 & 1024) != 0) {
                    f2<s, s.b, Object> f2Var2 = this.s;
                    jVar.m = f2Var2 == null ? this.r : f2Var2.b();
                    i3 |= 8;
                }
                if ((i2 & 2048) != 0) {
                    i3 |= 16;
                }
                jVar.n = this.t;
                jVar.f4160b = i3;
                onBuilt();
                return jVar;
            }

            public b c() {
                super.clear();
                this.f4165c = "";
                int i2 = this.f4164b & -2;
                this.f4164b = i2;
                this.f4166d = "";
                int i3 = i2 & -3;
                this.f4164b = i3;
                this.f4167e = r0.f4261e;
                this.f4164b = i3 & -5;
                this.f = k0.emptyIntList();
                this.f4164b &= -9;
                this.g = k0.emptyIntList();
                this.f4164b &= -17;
                b2<b, b.C0102b, Object> b2Var = this.i;
                if (b2Var == null) {
                    this.h = Collections.emptyList();
                    this.f4164b &= -33;
                } else {
                    b2Var.h();
                }
                b2<c, c.b, Object> b2Var2 = this.k;
                if (b2Var2 == null) {
                    this.j = Collections.emptyList();
                    this.f4164b &= -65;
                } else {
                    b2Var2.h();
                }
                b2<q, q.b, Object> b2Var3 = this.m;
                if (b2Var3 == null) {
                    this.l = Collections.emptyList();
                    this.f4164b &= -129;
                } else {
                    b2Var3.h();
                }
                b2<h, h.b, Object> b2Var4 = this.o;
                if (b2Var4 == null) {
                    this.n = Collections.emptyList();
                    this.f4164b &= -257;
                } else {
                    b2Var4.h();
                }
                f2<k, k.b, Object> f2Var = this.q;
                if (f2Var == null) {
                    this.p = null;
                } else {
                    f2Var.c();
                }
                this.f4164b &= -513;
                f2<s, s.b, Object> f2Var2 = this.s;
                if (f2Var2 == null) {
                    this.r = null;
                } else {
                    f2Var2.c();
                }
                int i4 = this.f4164b & -1025;
                this.f4164b = i4;
                this.t = "";
                this.f4164b = i4 & -2049;
                return this;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m161clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* renamed from: d */
            public b clone() {
                return (b) super.clone();
            }

            public final void e() {
                if ((this.f4164b & 32) == 0) {
                    this.h = new ArrayList(this.h);
                    this.f4164b |= 32;
                }
            }

            public final b2<c, c.b, Object> f() {
                if (this.k == null) {
                    this.k = new b2<>(this.j, (this.f4164b & 64) != 0, getParentForChildren(), isClean());
                    this.j = null;
                }
                return this.k;
            }

            public final b2<h, h.b, Object> g() {
                if (this.o == null) {
                    this.o = new b2<>(this.n, (this.f4164b & RecyclerView.d0.FLAG_TMP_DETACHED) != 0, getParentForChildren(), isClean());
                    this.n = null;
                }
                return this.o;
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return j.p;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.f4062b;
            }

            public final b2<b, b.C0102b, Object> h() {
                if (this.i == null) {
                    this.i = new b2<>(this.h, (this.f4164b & 32) != 0, getParentForChildren(), isClean());
                    this.h = null;
                }
                return this.i;
            }

            public final b2<q, q.b, Object> i() {
                if (this.m == null) {
                    this.m = new b2<>(this.l, (this.f4164b & RecyclerView.d0.FLAG_IGNORE) != 0, getParentForChildren(), isClean());
                    this.l = null;
                }
                return this.m;
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.f4063c;
                fVar.c(j.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                k kVar;
                h hVar;
                q qVar;
                c cVar;
                b bVar;
                int i2 = 0;
                while (true) {
                    b2<b, b.C0102b, Object> b2Var = this.i;
                    if (i2 < (b2Var == null ? this.h.size() : b2Var.m())) {
                        b2<b, b.C0102b, Object> b2Var2 = this.i;
                        if (b2Var2 == null) {
                            bVar = this.h.get(i2);
                        } else {
                            bVar = b2Var2.n(i2, false);
                        }
                        if (!bVar.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else {
                        int i3 = 0;
                        while (true) {
                            b2<c, c.b, Object> b2Var3 = this.k;
                            if (i3 < (b2Var3 == null ? this.j.size() : b2Var3.m())) {
                                b2<c, c.b, Object> b2Var4 = this.k;
                                if (b2Var4 == null) {
                                    cVar = this.j.get(i3);
                                } else {
                                    cVar = b2Var4.n(i3, false);
                                }
                                if (!cVar.isInitialized()) {
                                    return false;
                                }
                                i3++;
                            } else {
                                int i4 = 0;
                                while (true) {
                                    b2<q, q.b, Object> b2Var5 = this.m;
                                    if (i4 < (b2Var5 == null ? this.l.size() : b2Var5.m())) {
                                        b2<q, q.b, Object> b2Var6 = this.m;
                                        if (b2Var6 == null) {
                                            qVar = this.l.get(i4);
                                        } else {
                                            qVar = b2Var6.n(i4, false);
                                        }
                                        if (!qVar.isInitialized()) {
                                            return false;
                                        }
                                        i4++;
                                    } else {
                                        int i5 = 0;
                                        while (true) {
                                            b2<h, h.b, Object> b2Var7 = this.o;
                                            if (i5 < (b2Var7 == null ? this.n.size() : b2Var7.m())) {
                                                b2<h, h.b, Object> b2Var8 = this.o;
                                                if (b2Var8 == null) {
                                                    hVar = this.n.get(i5);
                                                } else {
                                                    hVar = b2Var8.n(i5, false);
                                                }
                                                if (!hVar.isInitialized()) {
                                                    return false;
                                                }
                                                i5++;
                                            } else {
                                                if ((this.f4164b & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                                                    f2<k, k.b, Object> f2Var = this.q;
                                                    if (f2Var == null) {
                                                        kVar = this.p;
                                                        if (kVar == null) {
                                                            kVar = k.z;
                                                        }
                                                    } else {
                                                        kVar = f2Var.e();
                                                    }
                                                    if (!kVar.isInitialized()) {
                                                        return false;
                                                    }
                                                }
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b j(k kVar, z zVar) {
                Throwable th;
                j jVar;
                j jVar2 = null;
                try {
                    j parsePartialFrom = j.q.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        k(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    jVar = (j) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    jVar2 = jVar;
                    if (jVar2 != null) {
                    }
                    throw th;
                }
            }

            public b k(j jVar) {
                s sVar;
                s sVar2;
                k kVar;
                k kVar2;
                if (jVar == j.p) {
                    return this;
                }
                if (jVar.j()) {
                    this.f4164b |= 1;
                    this.f4165c = jVar.f4161c;
                    onChanged();
                }
                if (jVar.l()) {
                    this.f4164b |= 2;
                    this.f4166d = jVar.f4162d;
                    onChanged();
                }
                if (!jVar.f4163e.isEmpty()) {
                    if (this.f4167e.isEmpty()) {
                        this.f4167e = jVar.f4163e;
                        this.f4164b &= -5;
                    } else {
                        if ((this.f4164b & 4) == 0) {
                            this.f4167e = new r0(this.f4167e);
                            this.f4164b |= 4;
                        }
                        this.f4167e.addAll(jVar.f4163e);
                    }
                    onChanged();
                }
                if (!jVar.f.isEmpty()) {
                    if (this.f.isEmpty()) {
                        this.f = jVar.f;
                        this.f4164b &= -9;
                    } else {
                        if ((this.f4164b & 8) == 0) {
                            this.f = k0.mutableCopy(this.f);
                            this.f4164b |= 8;
                        }
                        this.f.addAll(jVar.f);
                    }
                    onChanged();
                }
                if (!jVar.g.isEmpty()) {
                    if (this.g.isEmpty()) {
                        this.g = jVar.g;
                        this.f4164b &= -17;
                    } else {
                        if ((this.f4164b & 16) == 0) {
                            this.g = k0.mutableCopy(this.g);
                            this.f4164b |= 16;
                        }
                        this.g.addAll(jVar.g);
                    }
                    onChanged();
                }
                b2<h, h.b, Object> b2Var = null;
                if (this.i == null) {
                    if (!jVar.h.isEmpty()) {
                        if (this.h.isEmpty()) {
                            this.h = jVar.h;
                            this.f4164b &= -33;
                        } else {
                            e();
                            this.h.addAll(jVar.h);
                        }
                        onChanged();
                    }
                } else if (!jVar.h.isEmpty()) {
                    if (this.i.s()) {
                        this.i.f3831a = null;
                        this.i = null;
                        this.h = jVar.h;
                        this.f4164b &= -33;
                        this.i = k0.alwaysUseFieldBuilders ? h() : null;
                    } else {
                        this.i.b(jVar.h);
                    }
                }
                if (this.k == null) {
                    if (!jVar.i.isEmpty()) {
                        if (this.j.isEmpty()) {
                            this.j = jVar.i;
                            this.f4164b &= -65;
                        } else {
                            if ((this.f4164b & 64) == 0) {
                                this.j = new ArrayList(this.j);
                                this.f4164b |= 64;
                            }
                            this.j.addAll(jVar.i);
                        }
                        onChanged();
                    }
                } else if (!jVar.i.isEmpty()) {
                    if (this.k.s()) {
                        this.k.f3831a = null;
                        this.k = null;
                        this.j = jVar.i;
                        this.f4164b &= -65;
                        this.k = k0.alwaysUseFieldBuilders ? f() : null;
                    } else {
                        this.k.b(jVar.i);
                    }
                }
                if (this.m == null) {
                    if (!jVar.j.isEmpty()) {
                        if (this.l.isEmpty()) {
                            this.l = jVar.j;
                            this.f4164b &= -129;
                        } else {
                            if ((this.f4164b & RecyclerView.d0.FLAG_IGNORE) == 0) {
                                this.l = new ArrayList(this.l);
                                this.f4164b |= RecyclerView.d0.FLAG_IGNORE;
                            }
                            this.l.addAll(jVar.j);
                        }
                        onChanged();
                    }
                } else if (!jVar.j.isEmpty()) {
                    if (this.m.s()) {
                        this.m.f3831a = null;
                        this.m = null;
                        this.l = jVar.j;
                        this.f4164b &= -129;
                        this.m = k0.alwaysUseFieldBuilders ? i() : null;
                    } else {
                        this.m.b(jVar.j);
                    }
                }
                if (this.o == null) {
                    if (!jVar.k.isEmpty()) {
                        if (this.n.isEmpty()) {
                            this.n = jVar.k;
                            this.f4164b &= -257;
                        } else {
                            if ((this.f4164b & RecyclerView.d0.FLAG_TMP_DETACHED) == 0) {
                                this.n = new ArrayList(this.n);
                                this.f4164b |= RecyclerView.d0.FLAG_TMP_DETACHED;
                            }
                            this.n.addAll(jVar.k);
                        }
                        onChanged();
                    }
                } else if (!jVar.k.isEmpty()) {
                    if (this.o.s()) {
                        this.o.f3831a = null;
                        this.o = null;
                        this.n = jVar.k;
                        this.f4164b &= -257;
                        if (k0.alwaysUseFieldBuilders) {
                            b2Var = g();
                        }
                        this.o = b2Var;
                    } else {
                        this.o.b(jVar.k);
                    }
                }
                if (jVar.k()) {
                    k e2 = jVar.e();
                    f2<k, k.b, Object> f2Var = this.q;
                    if (f2Var == null) {
                        if (!((this.f4164b & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0 || (kVar = this.p) == null || kVar == (kVar2 = k.z))) {
                            k.b J = kVar2.toBuilder();
                            J.o(kVar);
                            J.o(e2);
                            e2 = J.buildPartial();
                        }
                        this.p = e2;
                        onChanged();
                    } else {
                        f2Var.f(e2);
                    }
                    this.f4164b |= RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN;
                }
                if (jVar.m()) {
                    s h2 = jVar.h();
                    f2<s, s.b, Object> f2Var2 = this.s;
                    if (f2Var2 == null) {
                        if (!((this.f4164b & 1024) == 0 || (sVar = this.r) == null || sVar == (sVar2 = s.f4230d))) {
                            s.b a2 = sVar2.toBuilder();
                            a2.f(sVar);
                            a2.f(h2);
                            h2 = a2.buildPartial();
                        }
                        this.r = h2;
                        onChanged();
                    } else {
                        f2Var2.f(h2);
                    }
                    this.f4164b |= 1024;
                }
                if (jVar.n()) {
                    this.f4164b |= 2048;
                    this.t = jVar.n;
                    onChanged();
                }
                l(jVar.unknownFields);
                onChanged();
                return this;
            }

            public final b l(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            public final void maybeForceBuilderInitialization() {
                s sVar;
                k kVar;
                if (k0.alwaysUseFieldBuilders) {
                    h();
                    f();
                    i();
                    g();
                    f2<k, k.b, Object> f2Var = this.q;
                    if (f2Var == null) {
                        if (f2Var == null) {
                            kVar = this.p;
                            if (kVar == null) {
                                kVar = k.z;
                            }
                        } else {
                            kVar = f2Var.e();
                        }
                        this.q = new f2<>(kVar, getParentForChildren(), isClean());
                        this.p = null;
                    }
                    f2<s, s.b, Object> f2Var2 = this.s;
                    if (f2Var2 == null) {
                        if (f2Var2 == null) {
                            sVar = this.r;
                            if (sVar == null) {
                                sVar = s.f4230d;
                            }
                        } else {
                            sVar = f2Var2.e();
                        }
                        this.s = new f2<>(sVar, getParentForChildren(), isClean());
                        this.r = null;
                    }
                }
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof j) {
                    k((j) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m168setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m169setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m170setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m163clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m164getDefaultInstanceForType() {
                return j.p;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m165mergeFrom(e1 e1Var) {
                if (e1Var instanceof j) {
                    k((j) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m167mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            public b setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m162clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m166mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }
        }

        public j() {
            this.o = -1;
            this.f4161c = "";
            this.f4162d = "";
            this.f4163e = r0.f4261e;
            this.f = k0.emptyIntList();
            this.g = k0.emptyIntList();
            this.h = Collections.emptyList();
            this.i = Collections.emptyList();
            this.j = Collections.emptyList();
            this.k = Collections.emptyList();
            this.n = "";
        }

        public j(k0.b bVar, a aVar) {
            super(bVar);
            this.o = -1;
        }

        public int a() {
            return this.i.size();
        }

        public int b() {
            return this.k.size();
        }

        public int c() {
            return this.h.size();
        }

        public String d() {
            Object obj = this.f4161c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.f4161c = u;
            }
            return u;
        }

        public k e() {
            k kVar = this.l;
            return kVar == null ? k.z : kVar;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof j)) {
                return super.equals(obj);
            }
            j jVar = (j) obj;
            if (j() != jVar.j()) {
                return false;
            }
            if ((j() && !d().equals(jVar.d())) || l() != jVar.l()) {
                return false;
            }
            if ((l() && !f().equals(jVar.f())) || !this.f4163e.equals(jVar.f4163e) || !this.f.equals(jVar.f) || !this.g.equals(jVar.g) || !this.h.equals(jVar.h) || !this.i.equals(jVar.i) || !this.j.equals(jVar.j) || !this.k.equals(jVar.k) || k() != jVar.k()) {
                return false;
            }
            if ((k() && !e().equals(jVar.e())) || m() != jVar.m()) {
                return false;
            }
            if ((!m() || h().equals(jVar.h())) && n() == jVar.n()) {
                return (!n() || i().equals(jVar.i())) && this.unknownFields.equals(jVar.unknownFields);
            }
            return false;
        }

        public String f() {
            Object obj = this.f4162d;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.f4162d = u;
            }
            return u;
        }

        public int g() {
            return this.j.size();
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return p;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<j> getParserForType() {
            return q;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeStringSize = (this.f4160b & 1) != 0 ? k0.computeStringSize(1, this.f4161c) + 0 : 0;
            if ((this.f4160b & 2) != 0) {
                computeStringSize += k0.computeStringSize(2, this.f4162d);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.f4163e.size(); i4++) {
                i3 += k0.computeStringSizeNoTag(this.f4163e.f(i4));
            }
            int size = (this.f4163e.size() * 1) + computeStringSize + i3;
            for (int i5 = 0; i5 < this.h.size(); i5++) {
                size += m.z(4, this.h.get(i5));
            }
            for (int i6 = 0; i6 < this.i.size(); i6++) {
                size += m.z(5, this.i.get(i6));
            }
            for (int i7 = 0; i7 < this.j.size(); i7++) {
                size += m.z(6, this.j.get(i7));
            }
            for (int i8 = 0; i8 < this.k.size(); i8++) {
                size += m.z(7, this.k.get(i8));
            }
            if ((this.f4160b & 4) != 0) {
                size += m.z(8, e());
            }
            if ((this.f4160b & 8) != 0) {
                size += m.z(9, h());
            }
            int i9 = 0;
            for (int i10 = 0; i10 < this.f.size(); i10++) {
                i9 += m.t(((l0) this.f).h(i10));
            }
            int size2 = (this.f.size() * 1) + size + i9;
            int i11 = 0;
            for (int i12 = 0; i12 < this.g.size(); i12++) {
                i11 += m.t(((l0) this.g).h(i12));
            }
            int size3 = (this.g.size() * 1) + size2 + i11;
            if ((this.f4160b & 16) != 0) {
                size3 += k0.computeStringSize(12, this.n);
            }
            int serializedSize = this.unknownFields.getSerializedSize() + size3;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        public s h() {
            s sVar = this.m;
            return sVar == null ? s.f4230d : sVar;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.f4062b.hashCode() + 779;
            if (j()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + d().hashCode();
            }
            if (l()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + f().hashCode();
            }
            if (this.f4163e.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + this.f4163e.hashCode();
            }
            if (this.f.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 10, 53) + this.f.hashCode();
            }
            if (this.g.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 11, 53) + this.g.hashCode();
            }
            if (c() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 4, 53) + this.h.hashCode();
            }
            if (a() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 5, 53) + this.i.hashCode();
            }
            if (g() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 6, 53) + this.j.hashCode();
            }
            if (b() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 7, 53) + this.k.hashCode();
            }
            if (k()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 8, 53) + e().hashCode();
            }
            if (m()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 9, 53) + h().hashCode();
            }
            if (n()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 12, 53) + i().hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public String i() {
            Object obj = this.n;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.n = u;
            }
            return u;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.f4063c;
            fVar.c(j.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.o;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < c(); i2++) {
                if (!this.h.get(i2).isInitialized()) {
                    this.o = 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < a(); i3++) {
                if (!this.i.get(i3).isInitialized()) {
                    this.o = 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < g(); i4++) {
                if (!this.j.get(i4).isInitialized()) {
                    this.o = 0;
                    return false;
                }
            }
            for (int i5 = 0; i5 < b(); i5++) {
                if (!this.k.get(i5).isInitialized()) {
                    this.o = 0;
                    return false;
                }
            }
            if (!k() || e().isInitialized()) {
                this.o = 1;
                return true;
            }
            this.o = 0;
            return false;
        }

        public boolean j() {
            return (this.f4160b & 1) != 0;
        }

        public boolean k() {
            return (this.f4160b & 4) != 0;
        }

        public boolean l() {
            return (this.f4160b & 2) != 0;
        }

        public boolean m() {
            return (this.f4160b & 8) != 0;
        }

        public boolean n() {
            return (this.f4160b & 16) != 0;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return p.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new j();
        }

        /* renamed from: o */
        public b toBuilder() {
            if (this == p) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.k(this);
            return bVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            if ((this.f4160b & 1) != 0) {
                k0.writeString(mVar, 1, this.f4161c);
            }
            if ((this.f4160b & 2) != 0) {
                k0.writeString(mVar, 2, this.f4162d);
            }
            for (int i2 = 0; i2 < this.f4163e.size(); i2++) {
                k0.writeString(mVar, 3, this.f4163e.f(i2));
            }
            for (int i3 = 0; i3 < this.h.size(); i3++) {
                mVar.k0(4, this.h.get(i3));
            }
            for (int i4 = 0; i4 < this.i.size(); i4++) {
                mVar.k0(5, this.i.get(i4));
            }
            for (int i5 = 0; i5 < this.j.size(); i5++) {
                mVar.k0(6, this.j.get(i5));
            }
            for (int i6 = 0; i6 < this.k.size(); i6++) {
                mVar.k0(7, this.k.get(i6));
            }
            if ((this.f4160b & 4) != 0) {
                mVar.k0(8, e());
            }
            if ((this.f4160b & 8) != 0) {
                mVar.k0(9, h());
            }
            for (int i7 = 0; i7 < this.f.size(); i7++) {
                mVar.i0(10, ((l0) this.f).h(i7));
            }
            for (int i8 = 0; i8 < this.g.size(); i8++) {
                mVar.i0(11, ((l0) this.g).h(i8));
            }
            if ((this.f4160b & 16) != 0) {
                k0.writeString(mVar, 12, this.n);
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m158getDefaultInstanceForType() {
            return p;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m159newBuilderForType() {
            return p.toBuilder();
        }
    }

    public static final class k extends k0.e<k> implements Object {
        @Deprecated
        public static final v1<k> A = new a();
        public static final k z = new k();

        /* renamed from: c  reason: collision with root package name */
        public int f4168c;

        /* renamed from: d  reason: collision with root package name */
        public volatile Object f4169d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Object f4170e;
        public boolean f;
        public boolean g;
        public boolean h;
        public int i;
        public volatile Object j;
        public boolean k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public volatile Object q;
        public volatile Object r;
        public volatile Object s;
        public volatile Object t;
        public volatile Object u;
        public volatile Object v;
        public volatile Object w;
        public List<t> x;
        public byte y;

        public static class a extends c<k> {
            /* JADX DEBUG: Multi-variable search result rejected for r5v40, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                k kVar2 = new k();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            switch (G) {
                                case 0:
                                    break;
                                case 10:
                                    j n = kVar.n();
                                    kVar2.f4168c = 1 | kVar2.f4168c;
                                    kVar2.f4169d = n;
                                    continue;
                                case 66:
                                    j n2 = kVar.n();
                                    kVar2.f4168c |= 2;
                                    kVar2.f4170e = n2;
                                    continue;
                                case 72:
                                    int p = kVar.p();
                                    if (c.b(p) == null) {
                                        b2.h(9, p);
                                        continue;
                                    } else {
                                        kVar2.f4168c |= 32;
                                        kVar2.i = p;
                                    }
                                case 80:
                                    kVar2.f4168c |= 4;
                                    kVar2.f = kVar.m();
                                    continue;
                                case 90:
                                    j n3 = kVar.n();
                                    kVar2.f4168c |= 64;
                                    kVar2.j = n3;
                                    continue;
                                case RecyclerView.d0.FLAG_IGNORE:
                                    kVar2.f4168c |= RecyclerView.d0.FLAG_IGNORE;
                                    kVar2.k = kVar.m();
                                    continue;
                                case 136:
                                    kVar2.f4168c |= RecyclerView.d0.FLAG_TMP_DETACHED;
                                    kVar2.l = kVar.m();
                                    continue;
                                case 144:
                                    kVar2.f4168c |= RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN;
                                    kVar2.m = kVar.m();
                                    continue;
                                case 160:
                                    kVar2.f4168c |= 8;
                                    kVar2.g = kVar.m();
                                    continue;
                                case 184:
                                    kVar2.f4168c |= 2048;
                                    kVar2.o = kVar.m();
                                    continue;
                                case 216:
                                    kVar2.f4168c |= 16;
                                    kVar2.h = kVar.m();
                                    continue;
                                case 248:
                                    kVar2.f4168c |= 4096;
                                    kVar2.p = kVar.m();
                                    continue;
                                case 290:
                                    j n4 = kVar.n();
                                    kVar2.f4168c |= RecyclerView.d0.FLAG_BOUNCED_FROM_HIDDEN_LIST;
                                    kVar2.q = n4;
                                    continue;
                                case 298:
                                    j n5 = kVar.n();
                                    kVar2.f4168c |= 16384;
                                    kVar2.r = n5;
                                    continue;
                                case 314:
                                    j n6 = kVar.n();
                                    kVar2.f4168c |= 32768;
                                    kVar2.s = n6;
                                    continue;
                                case 322:
                                    j n7 = kVar.n();
                                    kVar2.f4168c |= 65536;
                                    kVar2.t = n7;
                                    continue;
                                case 330:
                                    j n8 = kVar.n();
                                    kVar2.f4168c |= 131072;
                                    kVar2.u = n8;
                                    continue;
                                case 336:
                                    kVar2.f4168c |= 1024;
                                    kVar2.n = kVar.m();
                                    continue;
                                case 354:
                                    j n9 = kVar.n();
                                    kVar2.f4168c |= 262144;
                                    kVar2.v = n9;
                                    continue;
                                case 362:
                                    j n10 = kVar.n();
                                    kVar2.f4168c |= 524288;
                                    kVar2.w = n10;
                                    continue;
                                case 7994:
                                    if (!z2 || !true) {
                                        kVar2.x = new ArrayList();
                                        z2 |= true;
                                    }
                                    kVar2.x.add(kVar.w(t.l, zVar));
                                    continue;
                                default:
                                    if (kVar2.parseUnknownField(kVar, b2, zVar, G)) {
                                        continue;
                                    }
                                    break;
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = kVar2;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = kVar2;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                kVar2.x = Collections.unmodifiableList(kVar2.x);
                            }
                            kVar2.unknownFields = b2.build();
                            kVar2.f3942b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        kVar2.x = Collections.unmodifiableList(kVar2.x);
                    }
                    kVar2.unknownFields = b2.build();
                    kVar2.f3942b.x();
                    return kVar2;
                }
                throw null;
            }
        }

        public static final class b extends k0.d<k, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f4171c;

            /* renamed from: d  reason: collision with root package name */
            public Object f4172d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f4173e = "";
            public boolean f;
            public boolean g;
            public boolean h;
            public int i = 1;
            public Object j = "";
            public boolean k;
            public boolean l;
            public boolean m;
            public boolean n;
            public boolean o;
            public boolean p;
            public Object q = "";
            public Object r = "";
            public Object s = "";
            public Object t = "";
            public Object u = "";
            public Object v = "";
            public Object w = "";
            public List<t> x = Collections.emptyList();
            public b2<t, t.b, Object> y;

            public b() {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public k0.b m173addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                k j2 = buildPartial();
                if (j2.isInitialized()) {
                    return j2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j2);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public k0.b m175clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return k.z;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.z;
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b h(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.A;
                fVar.c(k.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.d, c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                t tVar;
                int i2 = 0;
                while (true) {
                    b2<t, t.b, Object> b2Var = this.y;
                    if (i2 < (b2Var == null ? this.x.size() : b2Var.m())) {
                        b2<t, t.b, Object> b2Var2 = this.y;
                        if (b2Var2 == null) {
                            tVar = this.x.get(i2);
                        } else {
                            tVar = b2Var2.n(i2, false);
                        }
                        if (!tVar.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else if (!e()) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }

            /* renamed from: j */
            public k buildPartial() {
                List<t> list;
                k kVar = new k(this, null);
                int i2 = this.f4171c;
                int i3 = (i2 & 1) != 0 ? 1 : 0;
                kVar.f4169d = this.f4172d;
                if ((i2 & 2) != 0) {
                    i3 |= 2;
                }
                kVar.f4170e = this.f4173e;
                if ((i2 & 4) != 0) {
                    kVar.f = this.f;
                    i3 |= 4;
                }
                if ((i2 & 8) != 0) {
                    kVar.g = this.g;
                    i3 |= 8;
                }
                if ((i2 & 16) != 0) {
                    kVar.h = this.h;
                    i3 |= 16;
                }
                if ((i2 & 32) != 0) {
                    i3 |= 32;
                }
                kVar.i = this.i;
                if ((i2 & 64) != 0) {
                    i3 |= 64;
                }
                kVar.j = this.j;
                if ((i2 & RecyclerView.d0.FLAG_IGNORE) != 0) {
                    kVar.k = this.k;
                    i3 |= RecyclerView.d0.FLAG_IGNORE;
                }
                if ((i2 & RecyclerView.d0.FLAG_TMP_DETACHED) != 0) {
                    kVar.l = this.l;
                    i3 |= RecyclerView.d0.FLAG_TMP_DETACHED;
                }
                if ((i2 & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                    kVar.m = this.m;
                    i3 |= RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN;
                }
                if ((i2 & 1024) != 0) {
                    kVar.n = this.n;
                    i3 |= 1024;
                }
                if ((i2 & 2048) != 0) {
                    kVar.o = this.o;
                    i3 |= 2048;
                }
                if ((i2 & 4096) != 0) {
                    kVar.p = this.p;
                    i3 |= 4096;
                }
                if ((i2 & RecyclerView.d0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != 0) {
                    i3 |= RecyclerView.d0.FLAG_BOUNCED_FROM_HIDDEN_LIST;
                }
                kVar.q = this.q;
                if ((i2 & 16384) != 0) {
                    i3 |= 16384;
                }
                kVar.r = this.r;
                if ((i2 & 32768) != 0) {
                    i3 |= 32768;
                }
                kVar.s = this.s;
                if ((i2 & 65536) != 0) {
                    i3 |= 65536;
                }
                kVar.t = this.t;
                if ((i2 & 131072) != 0) {
                    i3 |= 131072;
                }
                kVar.u = this.u;
                if ((i2 & 262144) != 0) {
                    i3 |= 262144;
                }
                kVar.v = this.v;
                if ((i2 & 524288) != 0) {
                    i3 |= 524288;
                }
                kVar.w = this.w;
                b2<t, t.b, Object> b2Var = this.y;
                if (b2Var == null) {
                    if ((this.f4171c & 1048576) != 0) {
                        this.x = Collections.unmodifiableList(this.x);
                        this.f4171c &= -1048577;
                    }
                    list = this.x;
                } else {
                    list = b2Var.g();
                }
                kVar.x = list;
                kVar.f4168c = i3;
                onBuilt();
                return kVar;
            }

            public b k() {
                super.clear();
                this.f4172d = "";
                int i2 = this.f4171c & -2;
                this.f4171c = i2;
                this.f4173e = "";
                int i3 = i2 & -3;
                this.f4171c = i3;
                this.f = false;
                int i4 = i3 & -5;
                this.f4171c = i4;
                this.g = false;
                int i5 = i4 & -9;
                this.f4171c = i5;
                this.h = false;
                int i6 = i5 & -17;
                this.f4171c = i6;
                this.i = 1;
                int i7 = i6 & -33;
                this.f4171c = i7;
                this.j = "";
                int i8 = i7 & -65;
                this.f4171c = i8;
                this.k = false;
                int i9 = i8 & -129;
                this.f4171c = i9;
                this.l = false;
                int i10 = i9 & -257;
                this.f4171c = i10;
                this.m = false;
                int i11 = i10 & -513;
                this.f4171c = i11;
                this.n = false;
                int i12 = i11 & -1025;
                this.f4171c = i12;
                this.o = false;
                int i13 = i12 & -2049;
                this.f4171c = i13;
                this.p = false;
                int i14 = i13 & -4097;
                this.f4171c = i14;
                this.q = "";
                int i15 = i14 & -8193;
                this.f4171c = i15;
                this.r = "";
                int i16 = i15 & -16385;
                this.f4171c = i16;
                this.s = "";
                int i17 = i16 & -32769;
                this.f4171c = i17;
                this.t = "";
                int i18 = i17 & -65537;
                this.f4171c = i18;
                this.u = "";
                int i19 = i18 & -131073;
                this.f4171c = i19;
                this.v = "";
                int i20 = i19 & -262145;
                this.f4171c = i20;
                this.w = "";
                this.f4171c = -524289 & i20;
                b2<t, t.b, Object> b2Var = this.y;
                if (b2Var == null) {
                    this.x = Collections.emptyList();
                    this.f4171c &= -1048577;
                } else {
                    b2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final b2<t, t.b, Object> m() {
                if (this.y == null) {
                    this.y = new b2<>(this.x, (this.f4171c & 1048576) != 0, getParentForChildren(), isClean());
                    this.x = null;
                }
                return this.y;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof k) {
                    o((k) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b n(k kVar, z zVar) {
                Throwable th;
                k kVar2;
                k kVar3 = null;
                try {
                    k parsePartialFrom = k.A.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        o(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    kVar2 = (k) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    kVar3 = kVar2;
                    if (kVar3 != null) {
                    }
                    throw th;
                }
            }

            public b o(k kVar) {
                if (kVar == k.z) {
                    return this;
                }
                if (kVar.y()) {
                    this.f4171c |= 1;
                    this.f4172d = kVar.f4169d;
                    onChanged();
                }
                if (kVar.x()) {
                    this.f4171c |= 2;
                    this.f4173e = kVar.f4170e;
                    onChanged();
                }
                if (kVar.w()) {
                    boolean z = kVar.f;
                    this.f4171c |= 4;
                    this.f = z;
                    onChanged();
                }
                if (kVar.u()) {
                    boolean z2 = kVar.g;
                    this.f4171c |= 8;
                    this.g = z2;
                    onChanged();
                }
                if (kVar.z()) {
                    boolean z3 = kVar.h;
                    this.f4171c |= 16;
                    this.h = z3;
                    onChanged();
                }
                if (kVar.B()) {
                    c b2 = c.b(kVar.i);
                    if (b2 == null) {
                        b2 = c.SPEED;
                    }
                    this.f4171c |= 32;
                    this.i = b2.f4177b;
                    onChanged();
                }
                if (kVar.t()) {
                    this.f4171c |= 64;
                    this.j = kVar.j;
                    onChanged();
                }
                if (kVar.q()) {
                    boolean z4 = kVar.k;
                    this.f4171c |= RecyclerView.d0.FLAG_IGNORE;
                    this.k = z4;
                    onChanged();
                }
                if (kVar.v()) {
                    boolean z5 = kVar.l;
                    this.f4171c |= RecyclerView.d0.FLAG_TMP_DETACHED;
                    this.l = z5;
                    onChanged();
                }
                if (kVar.G()) {
                    boolean z6 = kVar.m;
                    this.f4171c |= RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN;
                    this.m = z6;
                    onChanged();
                }
                if (kVar.D()) {
                    boolean z7 = kVar.n;
                    this.f4171c |= 1024;
                    this.n = z7;
                    onChanged();
                }
                if (kVar.s()) {
                    boolean z8 = kVar.o;
                    this.f4171c |= 2048;
                    this.o = z8;
                    onChanged();
                }
                if (kVar.p()) {
                    boolean z9 = kVar.p;
                    this.f4171c |= 4096;
                    this.p = z9;
                    onChanged();
                }
                if (kVar.A()) {
                    this.f4171c |= RecyclerView.d0.FLAG_BOUNCED_FROM_HIDDEN_LIST;
                    this.q = kVar.q;
                    onChanged();
                }
                if (kVar.r()) {
                    this.f4171c |= 16384;
                    this.r = kVar.r;
                    onChanged();
                }
                if (kVar.I()) {
                    this.f4171c |= 32768;
                    this.s = kVar.s;
                    onChanged();
                }
                if (kVar.C()) {
                    this.f4171c |= 65536;
                    this.t = kVar.t;
                    onChanged();
                }
                if (kVar.F()) {
                    this.f4171c |= 131072;
                    this.u = kVar.u;
                    onChanged();
                }
                if (kVar.E()) {
                    this.f4171c |= 262144;
                    this.v = kVar.v;
                    onChanged();
                }
                if (kVar.H()) {
                    this.f4171c |= 524288;
                    this.w = kVar.w;
                    onChanged();
                }
                if (this.y == null) {
                    if (!kVar.x.isEmpty()) {
                        if (this.x.isEmpty()) {
                            this.x = kVar.x;
                            this.f4171c &= -1048577;
                        } else {
                            if ((this.f4171c & 1048576) == 0) {
                                this.x = new ArrayList(this.x);
                                this.f4171c |= 1048576;
                            }
                            this.x.addAll(kVar.x);
                        }
                        onChanged();
                    }
                } else if (!kVar.x.isEmpty()) {
                    if (this.y.s()) {
                        b2<t, t.b, Object> b2Var = null;
                        this.y.f3831a = null;
                        this.y = null;
                        this.x = kVar.x;
                        this.f4171c &= -1048577;
                        if (k0.alwaysUseFieldBuilders) {
                            b2Var = m();
                        }
                        this.y = b2Var;
                    } else {
                        this.y.b(kVar.x);
                    }
                }
                f(kVar);
                p(kVar.unknownFields);
                onChanged();
                return this;
            }

            public final b p(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public k0.b m182setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public k0.b m183setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public k0.b m184setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(a aVar) {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m174build() {
                k j2 = buildPartial();
                if (j2.isInitialized()) {
                    return j2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j2);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public k0.b m177clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m178getDefaultInstanceForType() {
                return k.z;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m179mergeFrom(e1 e1Var) {
                if (e1Var instanceof k) {
                    o((k) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public k0.b m181mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            public e1.a setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public e1.a m176clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public e1.a m180mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public enum c implements Object {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);
            

            /* renamed from: b  reason: collision with root package name */
            public final int f4177b;

            /* access modifiers changed from: public */
            static {
                values();
            }

            /* access modifiers changed from: public */
            c(int i) {
                this.f4177b = i;
            }

            public static c b(int i) {
                if (i == 1) {
                    return SPEED;
                }
                if (i == 2) {
                    return CODE_SIZE;
                }
                if (i != 3) {
                    return null;
                }
                return LITE_RUNTIME;
            }

            public final int a() {
                return this.f4177b;
            }
        }

        public k() {
            this.y = -1;
            this.f4169d = "";
            this.f4170e = "";
            this.i = 1;
            this.j = "";
            this.q = "";
            this.r = "";
            this.s = "";
            this.t = "";
            this.u = "";
            this.v = "";
            this.w = "";
            this.x = Collections.emptyList();
        }

        public k(k0.d dVar, a aVar) {
            super(dVar);
            this.y = -1;
        }

        public boolean A() {
            return (this.f4168c & RecyclerView.d0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != 0;
        }

        public boolean B() {
            return (this.f4168c & 32) != 0;
        }

        public boolean C() {
            return (this.f4168c & 65536) != 0;
        }

        public boolean D() {
            return (this.f4168c & 1024) != 0;
        }

        public boolean E() {
            return (this.f4168c & 262144) != 0;
        }

        public boolean F() {
            return (this.f4168c & 131072) != 0;
        }

        public boolean G() {
            return (this.f4168c & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0;
        }

        public boolean H() {
            return (this.f4168c & 524288) != 0;
        }

        public boolean I() {
            return (this.f4168c & 32768) != 0;
        }

        /* renamed from: J */
        public b toBuilder() {
            if (this == z) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.o(this);
            return bVar;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof k)) {
                return super.equals(obj);
            }
            k kVar = (k) obj;
            if (y() != kVar.y()) {
                return false;
            }
            if ((y() && !i().equals(kVar.i())) || x() != kVar.x()) {
                return false;
            }
            if ((x() && !h().equals(kVar.h())) || w() != kVar.w()) {
                return false;
            }
            if ((w() && this.f != kVar.f) || u() != kVar.u()) {
                return false;
            }
            if ((u() && this.g != kVar.g) || z() != kVar.z()) {
                return false;
            }
            if ((z() && this.h != kVar.h) || B() != kVar.B()) {
                return false;
            }
            if ((B() && this.i != kVar.i) || t() != kVar.t()) {
                return false;
            }
            if ((t() && !g().equals(kVar.g())) || q() != kVar.q()) {
                return false;
            }
            if ((q() && this.k != kVar.k) || v() != kVar.v()) {
                return false;
            }
            if ((v() && this.l != kVar.l) || G() != kVar.G()) {
                return false;
            }
            if ((G() && this.m != kVar.m) || D() != kVar.D()) {
                return false;
            }
            if ((D() && this.n != kVar.n) || s() != kVar.s()) {
                return false;
            }
            if ((s() && this.o != kVar.o) || p() != kVar.p()) {
                return false;
            }
            if ((p() && this.p != kVar.p) || A() != kVar.A()) {
                return false;
            }
            if ((A() && !j().equals(kVar.j())) || r() != kVar.r()) {
                return false;
            }
            if ((r() && !f().equals(kVar.f())) || I() != kVar.I()) {
                return false;
            }
            if ((I() && !o().equals(kVar.o())) || C() != kVar.C()) {
                return false;
            }
            if ((C() && !k().equals(kVar.k())) || F() != kVar.F()) {
                return false;
            }
            if ((F() && !m().equals(kVar.m())) || E() != kVar.E()) {
                return false;
            }
            if ((!E() || l().equals(kVar.l())) && H() == kVar.H()) {
                return (!H() || n().equals(kVar.n())) && this.x.equals(kVar.x) && this.unknownFields.equals(kVar.unknownFields) && c().equals(kVar.c());
            }
            return false;
        }

        public String f() {
            Object obj = this.r;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u2 = jVar.u();
            if (jVar.o()) {
                this.r = u2;
            }
            return u2;
        }

        public String g() {
            Object obj = this.j;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u2 = jVar.u();
            if (jVar.o()) {
                this.j = u2;
            }
            return u2;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return z;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<k> getParserForType() {
            return A;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeStringSize = (this.f4168c & 1) != 0 ? k0.computeStringSize(1, this.f4169d) + 0 : 0;
            if ((this.f4168c & 2) != 0) {
                computeStringSize += k0.computeStringSize(8, this.f4170e);
            }
            if ((this.f4168c & 32) != 0) {
                computeStringSize += m.j(9, this.i);
            }
            if ((this.f4168c & 4) != 0) {
                computeStringSize += m.c(10, this.f);
            }
            if ((this.f4168c & 64) != 0) {
                computeStringSize += k0.computeStringSize(11, this.j);
            }
            if ((this.f4168c & RecyclerView.d0.FLAG_IGNORE) != 0) {
                computeStringSize += m.c(16, this.k);
            }
            if ((this.f4168c & RecyclerView.d0.FLAG_TMP_DETACHED) != 0) {
                computeStringSize += m.c(17, this.l);
            }
            if ((this.f4168c & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                computeStringSize += m.c(18, this.m);
            }
            if ((this.f4168c & 8) != 0) {
                computeStringSize += m.c(20, this.g);
            }
            if ((this.f4168c & 2048) != 0) {
                computeStringSize += m.c(23, this.o);
            }
            if ((this.f4168c & 16) != 0) {
                computeStringSize += m.c(27, this.h);
            }
            if ((this.f4168c & 4096) != 0) {
                computeStringSize += m.c(31, this.p);
            }
            if ((this.f4168c & RecyclerView.d0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != 0) {
                computeStringSize += k0.computeStringSize(36, this.q);
            }
            if ((this.f4168c & 16384) != 0) {
                computeStringSize += k0.computeStringSize(37, this.r);
            }
            if ((this.f4168c & 32768) != 0) {
                computeStringSize += k0.computeStringSize(39, this.s);
            }
            if ((this.f4168c & 65536) != 0) {
                computeStringSize += k0.computeStringSize(40, this.t);
            }
            if ((this.f4168c & 131072) != 0) {
                computeStringSize += k0.computeStringSize(41, this.u);
            }
            if ((this.f4168c & 1024) != 0) {
                computeStringSize += m.c(42, this.n);
            }
            if ((this.f4168c & 262144) != 0) {
                computeStringSize += k0.computeStringSize(44, this.v);
            }
            if ((this.f4168c & 524288) != 0) {
                computeStringSize += k0.computeStringSize(45, this.w);
            }
            for (int i3 = 0; i3 < this.x.size(); i3++) {
                computeStringSize += m.z(b.r.h.MAX_BIND_PARAMETER_CNT, this.x.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + computeStringSize;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        public String h() {
            Object obj = this.f4170e;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u2 = jVar.u();
            if (jVar.o()) {
                this.f4170e = u2;
            }
            return u2;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.z.hashCode() + 779;
            if (y()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + i().hashCode();
            }
            if (x()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 8, 53) + h().hashCode();
            }
            if (w()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 10, 53) + m0.c(this.f);
            }
            if (u()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 20, 53) + m0.c(this.g);
            }
            if (z()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 27, 53) + m0.c(this.h);
            }
            if (B()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 9, 53) + this.i;
            }
            if (t()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 11, 53) + g().hashCode();
            }
            if (q()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 16, 53) + m0.c(this.k);
            }
            if (v()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 17, 53) + m0.c(this.l);
            }
            if (G()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 18, 53) + m0.c(this.m);
            }
            if (D()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 42, 53) + m0.c(this.n);
            }
            if (s()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 23, 53) + m0.c(this.o);
            }
            if (p()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 31, 53) + m0.c(this.p);
            }
            if (A()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 36, 53) + j().hashCode();
            }
            if (r()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 37, 53) + f().hashCode();
            }
            if (I()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 39, 53) + o().hashCode();
            }
            if (C()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 40, 53) + k().hashCode();
            }
            if (F()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 41, 53) + m().hashCode();
            }
            if (E()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 44, 53) + l().hashCode();
            }
            if (H()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 45, 53) + n().hashCode();
            }
            if (this.x.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.r.h.MAX_BIND_PARAMETER_CNT, 53) + this.x.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public String i() {
            Object obj = this.f4169d;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u2 = jVar.u();
            if (jVar.o()) {
                this.f4169d = u2;
            }
            return u2;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.A;
            fVar.c(k.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.k0.e, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.y;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.x.size(); i2++) {
                if (!this.x.get(i2).isInitialized()) {
                    this.y = 0;
                    return false;
                }
            }
            if (!a()) {
                this.y = 0;
                return false;
            }
            this.y = 1;
            return true;
        }

        public String j() {
            Object obj = this.q;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u2 = jVar.u();
            if (jVar.o()) {
                this.q = u2;
            }
            return u2;
        }

        public String k() {
            Object obj = this.t;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u2 = jVar.u();
            if (jVar.o()) {
                this.t = u2;
            }
            return u2;
        }

        public String l() {
            Object obj = this.v;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u2 = jVar.u();
            if (jVar.o()) {
                this.v = u2;
            }
            return u2;
        }

        public String m() {
            Object obj = this.u;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u2 = jVar.u();
            if (jVar.o()) {
                this.u = u2;
            }
            return u2;
        }

        public String n() {
            Object obj = this.w;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u2 = jVar.u();
            if (jVar.o()) {
                this.w = u2;
            }
            return u2;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return z.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new k();
        }

        public String o() {
            Object obj = this.s;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u2 = jVar.u();
            if (jVar.o()) {
                this.s = u2;
            }
            return u2;
        }

        public boolean p() {
            return (this.f4168c & 4096) != 0;
        }

        public boolean q() {
            return (this.f4168c & RecyclerView.d0.FLAG_IGNORE) != 0;
        }

        public boolean r() {
            return (this.f4168c & 16384) != 0;
        }

        public boolean s() {
            return (this.f4168c & 2048) != 0;
        }

        public boolean t() {
            return (this.f4168c & 64) != 0;
        }

        @Deprecated
        public boolean u() {
            return (this.f4168c & 8) != 0;
        }

        public boolean v() {
            return (this.f4168c & RecyclerView.d0.FLAG_TMP_DETACHED) != 0;
        }

        public boolean w() {
            return (this.f4168c & 4) != 0;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            k0.e<MessageType>.a d2 = d();
            if ((this.f4168c & 1) != 0) {
                k0.writeString(mVar, 1, this.f4169d);
            }
            if ((this.f4168c & 2) != 0) {
                k0.writeString(mVar, 8, this.f4170e);
            }
            if ((this.f4168c & 32) != 0) {
                mVar.i0(9, this.i);
            }
            if ((this.f4168c & 4) != 0) {
                mVar.Y(10, this.f);
            }
            if ((this.f4168c & 64) != 0) {
                k0.writeString(mVar, 11, this.j);
            }
            if ((this.f4168c & RecyclerView.d0.FLAG_IGNORE) != 0) {
                mVar.Y(16, this.k);
            }
            if ((this.f4168c & RecyclerView.d0.FLAG_TMP_DETACHED) != 0) {
                mVar.Y(17, this.l);
            }
            if ((this.f4168c & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                mVar.Y(18, this.m);
            }
            if ((this.f4168c & 8) != 0) {
                mVar.Y(20, this.g);
            }
            if ((this.f4168c & 2048) != 0) {
                mVar.Y(23, this.o);
            }
            if ((this.f4168c & 16) != 0) {
                mVar.Y(27, this.h);
            }
            if ((this.f4168c & 4096) != 0) {
                mVar.Y(31, this.p);
            }
            if ((this.f4168c & RecyclerView.d0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != 0) {
                k0.writeString(mVar, 36, this.q);
            }
            if ((this.f4168c & 16384) != 0) {
                k0.writeString(mVar, 37, this.r);
            }
            if ((this.f4168c & 32768) != 0) {
                k0.writeString(mVar, 39, this.s);
            }
            if ((this.f4168c & 65536) != 0) {
                k0.writeString(mVar, 40, this.t);
            }
            if ((this.f4168c & 131072) != 0) {
                k0.writeString(mVar, 41, this.u);
            }
            if ((this.f4168c & 1024) != 0) {
                mVar.Y(42, this.n);
            }
            if ((this.f4168c & 262144) != 0) {
                k0.writeString(mVar, 44, this.v);
            }
            if ((this.f4168c & 524288) != 0) {
                k0.writeString(mVar, 45, this.w);
            }
            for (int i2 = 0; i2 < this.x.size(); i2++) {
                mVar.k0(b.r.h.MAX_BIND_PARAMETER_CNT, this.x.get(i2));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        public boolean x() {
            return (this.f4168c & 2) != 0;
        }

        public boolean y() {
            return (this.f4168c & 1) != 0;
        }

        public boolean z() {
            return (this.f4168c & 16) != 0;
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m171getDefaultInstanceForType() {
            return z;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m172newBuilderForType() {
            return z.toBuilder();
        }
    }

    public static final class l extends k0.e<l> implements Object {
        public static final l j = new l();
        @Deprecated
        public static final v1<l> k = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f4178c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4179d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4180e;
        public boolean f;
        public boolean g;
        public List<t> h;
        public byte i;

        public static class a extends c<l> {
            /* JADX DEBUG: Multi-variable search result rejected for r5v14, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                l lVar = new l();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 8) {
                                    lVar.f4178c |= 1;
                                    lVar.f4179d = kVar.m();
                                } else if (G == 16) {
                                    lVar.f4178c |= 2;
                                    lVar.f4180e = kVar.m();
                                } else if (G == 24) {
                                    lVar.f4178c |= 4;
                                    lVar.f = kVar.m();
                                } else if (G == 56) {
                                    lVar.f4178c |= 8;
                                    lVar.g = kVar.m();
                                } else if (G == 7994) {
                                    if (!z2 || !true) {
                                        lVar.h = new ArrayList();
                                        z2 |= true;
                                    }
                                    lVar.h.add(kVar.w(t.l, zVar));
                                } else if (!lVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = lVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = lVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                lVar.h = Collections.unmodifiableList(lVar.h);
                            }
                            lVar.unknownFields = b2.build();
                            lVar.f3942b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        lVar.h = Collections.unmodifiableList(lVar.h);
                    }
                    lVar.unknownFields = b2.build();
                    lVar.f3942b.x();
                    return lVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.d<l, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f4181c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f4182d;

            /* renamed from: e  reason: collision with root package name */
            public boolean f4183e;
            public boolean f;
            public boolean g;
            public List<t> h = Collections.emptyList();
            public b2<t, t.b, Object> i;

            public b() {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public k0.b m187addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                l j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public k0.b m189clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return l.j;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.B;
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b h(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.C;
                fVar.c(l.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.d, c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                t tVar;
                int i2 = 0;
                while (true) {
                    b2<t, t.b, Object> b2Var = this.i;
                    if (i2 < (b2Var == null ? this.h.size() : b2Var.m())) {
                        b2<t, t.b, Object> b2Var2 = this.i;
                        if (b2Var2 == null) {
                            tVar = this.h.get(i2);
                        } else {
                            tVar = b2Var2.n(i2, false);
                        }
                        if (!tVar.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else if (!e()) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }

            /* renamed from: j */
            public l buildPartial() {
                int i2;
                List<t> list;
                l lVar = new l(this, null);
                int i3 = this.f4181c;
                if ((i3 & 1) != 0) {
                    lVar.f4179d = this.f4182d;
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if ((i3 & 2) != 0) {
                    lVar.f4180e = this.f4183e;
                    i2 |= 2;
                }
                if ((i3 & 4) != 0) {
                    lVar.f = this.f;
                    i2 |= 4;
                }
                if ((i3 & 8) != 0) {
                    lVar.g = this.g;
                    i2 |= 8;
                }
                b2<t, t.b, Object> b2Var = this.i;
                if (b2Var == null) {
                    if ((this.f4181c & 16) != 0) {
                        this.h = Collections.unmodifiableList(this.h);
                        this.f4181c &= -17;
                    }
                    list = this.h;
                } else {
                    list = b2Var.g();
                }
                lVar.h = list;
                lVar.f4178c = i2;
                onBuilt();
                return lVar;
            }

            public b k() {
                super.clear();
                this.f4182d = false;
                int i2 = this.f4181c & -2;
                this.f4181c = i2;
                this.f4183e = false;
                int i3 = i2 & -3;
                this.f4181c = i3;
                this.f = false;
                int i4 = i3 & -5;
                this.f4181c = i4;
                this.g = false;
                this.f4181c = i4 & -9;
                b2<t, t.b, Object> b2Var = this.i;
                if (b2Var == null) {
                    this.h = Collections.emptyList();
                    this.f4181c &= -17;
                } else {
                    b2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final b2<t, t.b, Object> m() {
                if (this.i == null) {
                    this.i = new b2<>(this.h, (this.f4181c & 16) != 0, getParentForChildren(), isClean());
                    this.h = null;
                }
                return this.i;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof l) {
                    o((l) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b n(k kVar, z zVar) {
                Throwable th;
                l lVar;
                l lVar2 = null;
                try {
                    l parsePartialFrom = l.k.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        o(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    lVar = (l) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    lVar2 = lVar;
                    if (lVar2 != null) {
                    }
                    throw th;
                }
            }

            public b o(l lVar) {
                if (lVar == l.j) {
                    return this;
                }
                if (lVar.h()) {
                    boolean z = lVar.f4179d;
                    this.f4181c |= 1;
                    this.f4182d = z;
                    onChanged();
                }
                if (lVar.i()) {
                    boolean z2 = lVar.f4180e;
                    this.f4181c |= 2;
                    this.f4183e = z2;
                    onChanged();
                }
                if (lVar.f()) {
                    boolean z3 = lVar.f;
                    this.f4181c |= 4;
                    this.f = z3;
                    onChanged();
                }
                if (lVar.g()) {
                    boolean z4 = lVar.g;
                    this.f4181c |= 8;
                    this.g = z4;
                    onChanged();
                }
                if (this.i == null) {
                    if (!lVar.h.isEmpty()) {
                        if (this.h.isEmpty()) {
                            this.h = lVar.h;
                            this.f4181c &= -17;
                        } else {
                            if ((this.f4181c & 16) == 0) {
                                this.h = new ArrayList(this.h);
                                this.f4181c |= 16;
                            }
                            this.h.addAll(lVar.h);
                        }
                        onChanged();
                    }
                } else if (!lVar.h.isEmpty()) {
                    if (this.i.s()) {
                        b2<t, t.b, Object> b2Var = null;
                        this.i.f3831a = null;
                        this.i = null;
                        this.h = lVar.h;
                        this.f4181c &= -17;
                        if (k0.alwaysUseFieldBuilders) {
                            b2Var = m();
                        }
                        this.i = b2Var;
                    } else {
                        this.i.b(lVar.h);
                    }
                }
                f(lVar);
                p(lVar.unknownFields);
                onChanged();
                return this;
            }

            public final b p(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public k0.b m196setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public k0.b m197setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public k0.b m198setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(a aVar) {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m188build() {
                l j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public k0.b m191clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m192getDefaultInstanceForType() {
                return l.j;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m193mergeFrom(e1 e1Var) {
                if (e1Var instanceof l) {
                    o((l) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public k0.b m195mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            public e1.a setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public e1.a m190clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public e1.a m194mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public l() {
            this.i = -1;
            this.h = Collections.emptyList();
        }

        public l(k0.d dVar, a aVar) {
            super(dVar);
            this.i = -1;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof l)) {
                return super.equals(obj);
            }
            l lVar = (l) obj;
            if (h() != lVar.h()) {
                return false;
            }
            if ((h() && this.f4179d != lVar.f4179d) || i() != lVar.i()) {
                return false;
            }
            if ((i() && this.f4180e != lVar.f4180e) || f() != lVar.f()) {
                return false;
            }
            if ((!f() || this.f == lVar.f) && g() == lVar.g()) {
                return (!g() || this.g == lVar.g) && this.h.equals(lVar.h) && this.unknownFields.equals(lVar.unknownFields) && c().equals(lVar.c());
            }
            return false;
        }

        public boolean f() {
            return (this.f4178c & 4) != 0;
        }

        public boolean g() {
            return (this.f4178c & 8) != 0;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return j;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<l> getParserForType() {
            return k;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int c2 = (this.f4178c & 1) != 0 ? m.c(1, this.f4179d) + 0 : 0;
            if ((this.f4178c & 2) != 0) {
                c2 += m.c(2, this.f4180e);
            }
            if ((this.f4178c & 4) != 0) {
                c2 += m.c(3, this.f);
            }
            if ((this.f4178c & 8) != 0) {
                c2 += m.c(7, this.g);
            }
            for (int i3 = 0; i3 < this.h.size(); i3++) {
                c2 += m.z(b.r.h.MAX_BIND_PARAMETER_CNT, this.h.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + c2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean h() {
            return (this.f4178c & 1) != 0;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.B.hashCode() + 779;
            if (h()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + m0.c(this.f4179d);
            }
            if (i()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + m0.c(this.f4180e);
            }
            if (f()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + m0.c(this.f);
            }
            if (g()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 7, 53) + m0.c(this.g);
            }
            if (this.h.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.r.h.MAX_BIND_PARAMETER_CNT, 53) + this.h.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public boolean i() {
            return (this.f4178c & 2) != 0;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.C;
            fVar.c(l.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.k0.e, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.i;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                if (!this.h.get(i2).isInitialized()) {
                    this.i = 0;
                    return false;
                }
            }
            if (!a()) {
                this.i = 0;
                return false;
            }
            this.i = 1;
            return true;
        }

        /* renamed from: j */
        public b toBuilder() {
            if (this == j) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.o(this);
            return bVar;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return j.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new l();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            k0.e<MessageType>.a d2 = d();
            if ((this.f4178c & 1) != 0) {
                mVar.Y(1, this.f4179d);
            }
            if ((this.f4178c & 2) != 0) {
                mVar.Y(2, this.f4180e);
            }
            if ((this.f4178c & 4) != 0) {
                mVar.Y(3, this.f);
            }
            if ((this.f4178c & 8) != 0) {
                mVar.Y(7, this.g);
            }
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                mVar.k0(b.r.h.MAX_BIND_PARAMETER_CNT, this.h.get(i2));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m185getDefaultInstanceForType() {
            return j;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m186newBuilderForType() {
            return j.toBuilder();
        }
    }

    public static final class m extends k0 implements j1 {
        public static final m j = new m();
        @Deprecated
        public static final v1<m> k = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f4184b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f4185c;

        /* renamed from: d  reason: collision with root package name */
        public volatile Object f4186d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Object f4187e;
        public n f;
        public boolean g;
        public boolean h;
        public byte i;

        public static class a extends c<m> {
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                m mVar = new m();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 10) {
                                    j n = kVar.n();
                                    mVar.f4184b = 1 | mVar.f4184b;
                                    mVar.f4185c = n;
                                } else if (G == 18) {
                                    j n2 = kVar.n();
                                    mVar.f4184b |= 2;
                                    mVar.f4186d = n2;
                                } else if (G == 26) {
                                    j n3 = kVar.n();
                                    mVar.f4184b |= 4;
                                    mVar.f4187e = n3;
                                } else if (G == 34) {
                                    n.b h = (mVar.f4184b & 8) != 0 ? mVar.f.toBuilder() : null;
                                    n nVar = (n) kVar.w(n.i, zVar);
                                    mVar.f = nVar;
                                    if (h != null) {
                                        h.o(nVar);
                                        mVar.f = h.buildPartial();
                                    }
                                    mVar.f4184b |= 8;
                                } else if (G == 40) {
                                    mVar.f4184b |= 16;
                                    mVar.g = kVar.m();
                                } else if (G == 48) {
                                    mVar.f4184b |= 32;
                                    mVar.h = kVar.m();
                                } else if (!mVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = mVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = mVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            mVar.unknownFields = b2.build();
                            mVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    mVar.unknownFields = b2.build();
                    mVar.makeExtensionsImmutable();
                    return mVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f4188b;

            /* renamed from: c  reason: collision with root package name */
            public Object f4189c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f4190d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f4191e = "";
            public n f;
            public f2<n, n.b, Object> g;
            public boolean h;
            public boolean i;

            public b() {
                maybeForceBuilderInitialization();
            }

            public b(a aVar) {
                maybeForceBuilderInitialization();
            }

            /* renamed from: a */
            public m buildPartial() {
                m mVar = new m(this, null);
                int i2 = this.f4188b;
                int i3 = (i2 & 1) != 0 ? 1 : 0;
                mVar.f4185c = this.f4189c;
                if ((i2 & 2) != 0) {
                    i3 |= 2;
                }
                mVar.f4186d = this.f4190d;
                if ((i2 & 4) != 0) {
                    i3 |= 4;
                }
                mVar.f4187e = this.f4191e;
                if ((i2 & 8) != 0) {
                    f2<n, n.b, Object> f2Var = this.g;
                    mVar.f = f2Var == null ? this.f : f2Var.b();
                    i3 |= 8;
                }
                if ((i2 & 16) != 0) {
                    mVar.g = this.h;
                    i3 |= 16;
                }
                if ((i2 & 32) != 0) {
                    mVar.h = this.i;
                    i3 |= 32;
                }
                mVar.f4184b = i3;
                onBuilt();
                return mVar;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m201addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            public b b() {
                super.clear();
                this.f4189c = "";
                int i2 = this.f4188b & -2;
                this.f4188b = i2;
                this.f4190d = "";
                int i3 = i2 & -3;
                this.f4188b = i3;
                this.f4191e = "";
                this.f4188b = i3 & -5;
                f2<n, n.b, Object> f2Var = this.g;
                if (f2Var == null) {
                    this.f = null;
                } else {
                    f2Var.c();
                }
                int i4 = this.f4188b & -9;
                this.f4188b = i4;
                this.h = false;
                int i5 = i4 & -17;
                this.f4188b = i5;
                this.i = false;
                this.f4188b = i5 & -33;
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                m a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
            }

            /* renamed from: c */
            public b clone() {
                return (b) super.clone();
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m203clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b d(k kVar, z zVar) {
                Throwable th;
                m mVar;
                m mVar2 = null;
                try {
                    m parsePartialFrom = m.k.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        e(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    mVar = (m) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    mVar2 = mVar;
                    if (mVar2 != null) {
                    }
                    throw th;
                }
            }

            public b e(m mVar) {
                n nVar;
                n nVar2;
                if (mVar == m.j) {
                    return this;
                }
                if (mVar.g()) {
                    this.f4188b |= 1;
                    this.f4189c = mVar.f4185c;
                    onChanged();
                }
                if (mVar.f()) {
                    this.f4188b |= 2;
                    this.f4190d = mVar.f4186d;
                    onChanged();
                }
                if (mVar.i()) {
                    this.f4188b |= 4;
                    this.f4191e = mVar.f4187e;
                    onChanged();
                }
                if (mVar.h()) {
                    n c2 = mVar.c();
                    f2<n, n.b, Object> f2Var = this.g;
                    if (f2Var == null) {
                        if (!((this.f4188b & 8) == 0 || (nVar = this.f) == null || nVar == (nVar2 = n.h))) {
                            n.b h2 = nVar2.toBuilder();
                            h2.o(nVar);
                            h2.o(c2);
                            c2 = h2.buildPartial();
                        }
                        this.f = c2;
                        onChanged();
                    } else {
                        f2Var.f(c2);
                    }
                    this.f4188b |= 8;
                }
                if (mVar.e()) {
                    boolean z = mVar.g;
                    this.f4188b |= 16;
                    this.h = z;
                    onChanged();
                }
                if (mVar.j()) {
                    boolean z2 = mVar.h;
                    this.f4188b |= 32;
                    this.i = z2;
                    onChanged();
                }
                f(mVar.unknownFields);
                onChanged();
                return this;
            }

            public final b f(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return m.j;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.x;
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.y;
                fVar.c(m.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                n nVar;
                if ((this.f4188b & 8) != 0) {
                    f2<n, n.b, Object> f2Var = this.g;
                    if (f2Var == null) {
                        nVar = this.f;
                        if (nVar == null) {
                            nVar = n.h;
                        }
                    } else {
                        nVar = f2Var.e();
                    }
                    if (!nVar.isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public final void maybeForceBuilderInitialization() {
                f2<n, n.b, Object> f2Var;
                n nVar;
                if (k0.alwaysUseFieldBuilders && (f2Var = this.g) == null) {
                    if (f2Var == null) {
                        nVar = this.f;
                        if (nVar == null) {
                            nVar = n.h;
                        }
                    } else {
                        nVar = f2Var.e();
                    }
                    this.g = new f2<>(nVar, getParentForChildren(), isClean());
                    this.f = null;
                }
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof m) {
                    e((m) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m210setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m211setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m212setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m202build() {
                m a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m205clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m206getDefaultInstanceForType() {
                return m.j;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m207mergeFrom(e1 e1Var) {
                if (e1Var instanceof m) {
                    e((m) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m209mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            public b setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m204clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m208mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }
        }

        public m() {
            this.i = -1;
            this.f4185c = "";
            this.f4186d = "";
            this.f4187e = "";
        }

        public m(k0.b bVar, a aVar) {
            super(bVar);
            this.i = -1;
        }

        public String a() {
            Object obj = this.f4186d;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.f4186d = u;
            }
            return u;
        }

        public String b() {
            Object obj = this.f4185c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.f4185c = u;
            }
            return u;
        }

        public n c() {
            n nVar = this.f;
            return nVar == null ? n.h : nVar;
        }

        public String d() {
            Object obj = this.f4187e;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.f4187e = u;
            }
            return u;
        }

        public boolean e() {
            return (this.f4184b & 16) != 0;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof m)) {
                return super.equals(obj);
            }
            m mVar = (m) obj;
            if (g() != mVar.g()) {
                return false;
            }
            if ((g() && !b().equals(mVar.b())) || f() != mVar.f()) {
                return false;
            }
            if ((f() && !a().equals(mVar.a())) || i() != mVar.i()) {
                return false;
            }
            if ((i() && !d().equals(mVar.d())) || h() != mVar.h()) {
                return false;
            }
            if ((h() && !c().equals(mVar.c())) || e() != mVar.e()) {
                return false;
            }
            if ((!e() || this.g == mVar.g) && j() == mVar.j()) {
                return (!j() || this.h == mVar.h) && this.unknownFields.equals(mVar.unknownFields);
            }
            return false;
        }

        public boolean f() {
            return (this.f4184b & 2) != 0;
        }

        public boolean g() {
            return (this.f4184b & 1) != 0;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return j;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<m> getParserForType() {
            return k;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.f4184b & 1) != 0) {
                i3 = 0 + k0.computeStringSize(1, this.f4185c);
            }
            if ((this.f4184b & 2) != 0) {
                i3 += k0.computeStringSize(2, this.f4186d);
            }
            if ((this.f4184b & 4) != 0) {
                i3 += k0.computeStringSize(3, this.f4187e);
            }
            if ((this.f4184b & 8) != 0) {
                i3 += m.z(4, c());
            }
            if ((this.f4184b & 16) != 0) {
                i3 += m.c(5, this.g);
            }
            if ((this.f4184b & 32) != 0) {
                i3 += m.c(6, this.h);
            }
            int serializedSize = this.unknownFields.getSerializedSize() + i3;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean h() {
            return (this.f4184b & 8) != 0;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.x.hashCode() + 779;
            if (g()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + b().hashCode();
            }
            if (f()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + a().hashCode();
            }
            if (i()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + d().hashCode();
            }
            if (h()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 4, 53) + c().hashCode();
            }
            if (e()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 5, 53) + m0.c(this.g);
            }
            if (j()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 6, 53) + m0.c(this.h);
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public boolean i() {
            return (this.f4184b & 4) != 0;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.y;
            fVar.c(m.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.i;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!h() || c().isInitialized()) {
                this.i = 1;
                return true;
            }
            this.i = 0;
            return false;
        }

        public boolean j() {
            return (this.f4184b & 32) != 0;
        }

        /* renamed from: k */
        public b toBuilder() {
            if (this == j) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.e(this);
            return bVar;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return j.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new m();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            if ((this.f4184b & 1) != 0) {
                k0.writeString(mVar, 1, this.f4185c);
            }
            if ((this.f4184b & 2) != 0) {
                k0.writeString(mVar, 2, this.f4186d);
            }
            if ((this.f4184b & 4) != 0) {
                k0.writeString(mVar, 3, this.f4187e);
            }
            if ((this.f4184b & 8) != 0) {
                mVar.k0(4, c());
            }
            if ((this.f4184b & 16) != 0) {
                mVar.Y(5, this.g);
            }
            if ((this.f4184b & 32) != 0) {
                mVar.Y(6, this.h);
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m199getDefaultInstanceForType() {
            return j;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m200newBuilderForType() {
            return j.toBuilder();
        }
    }

    public static final class n extends k0.e<n> implements Object {
        public static final n h = new n();
        @Deprecated
        public static final v1<n> i = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f4192c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4193d;

        /* renamed from: e  reason: collision with root package name */
        public int f4194e;
        public List<t> f;
        public byte g;

        public static class a extends c<n> {
            /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                n nVar = new n();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 264) {
                                    nVar.f4192c |= 1;
                                    nVar.f4193d = kVar.m();
                                } else if (G == 272) {
                                    int p = kVar.p();
                                    if (c.b(p) == null) {
                                        b2.h(34, p);
                                    } else {
                                        nVar.f4192c |= 2;
                                        nVar.f4194e = p;
                                    }
                                } else if (G == 7994) {
                                    if (!z2 || !true) {
                                        nVar.f = new ArrayList();
                                        z2 |= true;
                                    }
                                    nVar.f.add(kVar.w(t.l, zVar));
                                } else if (!nVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = nVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = nVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                nVar.f = Collections.unmodifiableList(nVar.f);
                            }
                            nVar.unknownFields = b2.build();
                            nVar.f3942b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        nVar.f = Collections.unmodifiableList(nVar.f);
                    }
                    nVar.unknownFields = b2.build();
                    nVar.f3942b.x();
                    return nVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.d<n, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f4195c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f4196d;

            /* renamed from: e  reason: collision with root package name */
            public int f4197e = 0;
            public List<t> f = Collections.emptyList();
            public b2<t, t.b, Object> g;

            public b() {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public k0.b m215addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                n j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public k0.b m217clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return n.h;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.N;
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b h(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.O;
                fVar.c(n.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.d, c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                t tVar;
                int i = 0;
                while (true) {
                    b2<t, t.b, Object> b2Var = this.g;
                    if (i < (b2Var == null ? this.f.size() : b2Var.m())) {
                        b2<t, t.b, Object> b2Var2 = this.g;
                        if (b2Var2 == null) {
                            tVar = this.f.get(i);
                        } else {
                            tVar = b2Var2.n(i, false);
                        }
                        if (!tVar.isInitialized()) {
                            return false;
                        }
                        i++;
                    } else if (!e()) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }

            /* renamed from: j */
            public n buildPartial() {
                int i;
                List<t> list;
                n nVar = new n(this, null);
                int i2 = this.f4195c;
                if ((i2 & 1) != 0) {
                    nVar.f4193d = this.f4196d;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    i |= 2;
                }
                nVar.f4194e = this.f4197e;
                b2<t, t.b, Object> b2Var = this.g;
                if (b2Var == null) {
                    if ((this.f4195c & 4) != 0) {
                        this.f = Collections.unmodifiableList(this.f);
                        this.f4195c &= -5;
                    }
                    list = this.f;
                } else {
                    list = b2Var.g();
                }
                nVar.f = list;
                nVar.f4192c = i;
                onBuilt();
                return nVar;
            }

            public b k() {
                super.clear();
                this.f4196d = false;
                int i = this.f4195c & -2;
                this.f4195c = i;
                this.f4197e = 0;
                this.f4195c = i & -3;
                b2<t, t.b, Object> b2Var = this.g;
                if (b2Var == null) {
                    this.f = Collections.emptyList();
                    this.f4195c &= -5;
                } else {
                    b2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final b2<t, t.b, Object> m() {
                if (this.g == null) {
                    this.g = new b2<>(this.f, (this.f4195c & 4) != 0, getParentForChildren(), isClean());
                    this.f = null;
                }
                return this.g;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof n) {
                    o((n) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b n(k kVar, z zVar) {
                Throwable th;
                n nVar;
                n nVar2 = null;
                try {
                    n parsePartialFrom = n.i.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        o(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    nVar = (n) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    nVar2 = nVar;
                    if (nVar2 != null) {
                    }
                    throw th;
                }
            }

            public b o(n nVar) {
                if (nVar == n.h) {
                    return this;
                }
                if (nVar.f()) {
                    boolean z = nVar.f4193d;
                    this.f4195c |= 1;
                    this.f4196d = z;
                    onChanged();
                }
                if (nVar.g()) {
                    c b2 = c.b(nVar.f4194e);
                    if (b2 == null) {
                        b2 = c.IDEMPOTENCY_UNKNOWN;
                    }
                    this.f4195c |= 2;
                    this.f4197e = b2.f4201b;
                    onChanged();
                }
                if (this.g == null) {
                    if (!nVar.f.isEmpty()) {
                        if (this.f.isEmpty()) {
                            this.f = nVar.f;
                            this.f4195c &= -5;
                        } else {
                            if ((this.f4195c & 4) == 0) {
                                this.f = new ArrayList(this.f);
                                this.f4195c |= 4;
                            }
                            this.f.addAll(nVar.f);
                        }
                        onChanged();
                    }
                } else if (!nVar.f.isEmpty()) {
                    if (this.g.s()) {
                        b2<t, t.b, Object> b2Var = null;
                        this.g.f3831a = null;
                        this.g = null;
                        this.f = nVar.f;
                        this.f4195c &= -5;
                        if (k0.alwaysUseFieldBuilders) {
                            b2Var = m();
                        }
                        this.g = b2Var;
                    } else {
                        this.g.b(nVar.f);
                    }
                }
                f(nVar);
                p(nVar.unknownFields);
                onChanged();
                return this;
            }

            public final b p(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public k0.b m224setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public k0.b m225setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public k0.b m226setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(a aVar) {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m216build() {
                n j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public k0.b m219clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m220getDefaultInstanceForType() {
                return n.h;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m221mergeFrom(e1 e1Var) {
                if (e1Var instanceof n) {
                    o((n) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public k0.b m223mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            public e1.a setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public e1.a m218clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public e1.a m222mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public enum c implements Object {
            IDEMPOTENCY_UNKNOWN(0),
            NO_SIDE_EFFECTS(1),
            IDEMPOTENT(2);
            

            /* renamed from: b  reason: collision with root package name */
            public final int f4201b;

            /* access modifiers changed from: public */
            static {
                values();
            }

            /* access modifiers changed from: public */
            c(int i) {
                this.f4201b = i;
            }

            public static c b(int i) {
                if (i == 0) {
                    return IDEMPOTENCY_UNKNOWN;
                }
                if (i == 1) {
                    return NO_SIDE_EFFECTS;
                }
                if (i != 2) {
                    return null;
                }
                return IDEMPOTENT;
            }

            public final int a() {
                return this.f4201b;
            }
        }

        public n() {
            this.g = -1;
            this.f4194e = 0;
            this.f = Collections.emptyList();
        }

        public n(k0.d dVar, a aVar) {
            super(dVar);
            this.g = -1;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof n)) {
                return super.equals(obj);
            }
            n nVar = (n) obj;
            if (f() != nVar.f()) {
                return false;
            }
            if ((!f() || this.f4193d == nVar.f4193d) && g() == nVar.g()) {
                return (!g() || this.f4194e == nVar.f4194e) && this.f.equals(nVar.f) && this.unknownFields.equals(nVar.unknownFields) && c().equals(nVar.c());
            }
            return false;
        }

        public boolean f() {
            return (this.f4192c & 1) != 0;
        }

        public boolean g() {
            return (this.f4192c & 2) != 0;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return h;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<n> getParserForType() {
            return i;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int c2 = (this.f4192c & 1) != 0 ? m.c(33, this.f4193d) + 0 : 0;
            if ((this.f4192c & 2) != 0) {
                c2 += m.j(34, this.f4194e);
            }
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                c2 += m.z(b.r.h.MAX_BIND_PARAMETER_CNT, this.f.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + c2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        /* renamed from: h */
        public b toBuilder() {
            if (this == h) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.o(this);
            return bVar;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.N.hashCode() + 779;
            if (f()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 33, 53) + m0.c(this.f4193d);
            }
            if (g()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 34, 53) + this.f4194e;
            }
            if (this.f.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.r.h.MAX_BIND_PARAMETER_CNT, 53) + this.f.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.O;
            fVar.c(n.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.k0.e, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.g;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                if (!this.f.get(i2).isInitialized()) {
                    this.g = 0;
                    return false;
                }
            }
            if (!a()) {
                this.g = 0;
                return false;
            }
            this.g = 1;
            return true;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return h.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new n();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            k0.e<MessageType>.a d2 = d();
            if ((this.f4192c & 1) != 0) {
                mVar.Y(33, this.f4193d);
            }
            if ((this.f4192c & 2) != 0) {
                mVar.i0(34, this.f4194e);
            }
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                mVar.k0(b.r.h.MAX_BIND_PARAMETER_CNT, this.f.get(i2));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m213getDefaultInstanceForType() {
            return h;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m214newBuilderForType() {
            return h.toBuilder();
        }
    }

    public static final class o extends k0 implements j1 {
        public static final o f = new o();
        @Deprecated
        public static final v1<o> g = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f4202b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f4203c;

        /* renamed from: d  reason: collision with root package name */
        public p f4204d;

        /* renamed from: e  reason: collision with root package name */
        public byte f4205e;

        public static class a extends c<o> {
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                o oVar = new o();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 10) {
                                    j n = kVar.n();
                                    oVar.f4202b = 1 | oVar.f4202b;
                                    oVar.f4203c = n;
                                } else if (G == 18) {
                                    p.b f = (oVar.f4202b & 2) != 0 ? oVar.f4204d.toBuilder() : null;
                                    p pVar = (p) kVar.w(p.f, zVar);
                                    oVar.f4204d = pVar;
                                    if (f != null) {
                                        f.o(pVar);
                                        oVar.f4204d = f.buildPartial();
                                    }
                                    oVar.f4202b |= 2;
                                } else if (!oVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = oVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = oVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            oVar.unknownFields = b2.build();
                            oVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    oVar.unknownFields = b2.build();
                    oVar.makeExtensionsImmutable();
                    return oVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f4206b;

            /* renamed from: c  reason: collision with root package name */
            public Object f4207c = "";

            /* renamed from: d  reason: collision with root package name */
            public p f4208d;

            /* renamed from: e  reason: collision with root package name */
            public f2<p, p.b, Object> f4209e;

            public b() {
                maybeForceBuilderInitialization();
            }

            public b(a aVar) {
                maybeForceBuilderInitialization();
            }

            /* renamed from: a */
            public o buildPartial() {
                o oVar = new o(this, null);
                int i = this.f4206b;
                int i2 = (i & 1) != 0 ? 1 : 0;
                oVar.f4203c = this.f4207c;
                if ((i & 2) != 0) {
                    f2<p, p.b, Object> f2Var = this.f4209e;
                    oVar.f4204d = f2Var == null ? this.f4208d : f2Var.b();
                    i2 |= 2;
                }
                oVar.f4202b = i2;
                onBuilt();
                return oVar;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m229addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            public b b() {
                super.clear();
                this.f4207c = "";
                this.f4206b &= -2;
                f2<p, p.b, Object> f2Var = this.f4209e;
                if (f2Var == null) {
                    this.f4208d = null;
                } else {
                    f2Var.c();
                }
                this.f4206b &= -3;
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                o a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
            }

            /* renamed from: c */
            public b clone() {
                return (b) super.clone();
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m231clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b d(k kVar, z zVar) {
                Throwable th;
                o oVar;
                o oVar2 = null;
                try {
                    o parsePartialFrom = o.g.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        e(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    oVar = (o) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    oVar2 = oVar;
                    if (oVar2 != null) {
                    }
                    throw th;
                }
            }

            public b e(o oVar) {
                p pVar;
                p pVar2;
                if (oVar == o.f) {
                    return this;
                }
                if (oVar.c()) {
                    this.f4206b |= 1;
                    this.f4207c = oVar.f4203c;
                    onChanged();
                }
                if (oVar.d()) {
                    p b2 = oVar.b();
                    f2<p, p.b, Object> f2Var = this.f4209e;
                    if (f2Var == null) {
                        if (!((this.f4206b & 2) == 0 || (pVar = this.f4208d) == null || pVar == (pVar2 = p.f4210e))) {
                            p.b f = pVar2.toBuilder();
                            f.o(pVar);
                            f.o(b2);
                            b2 = f.buildPartial();
                        }
                        this.f4208d = b2;
                        onChanged();
                    } else {
                        f2Var.f(b2);
                    }
                    this.f4206b |= 2;
                }
                f(oVar.unknownFields);
                onChanged();
                return this;
            }

            public final b f(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return o.f;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.n;
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.o;
                fVar.c(o.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                p pVar;
                if ((this.f4206b & 2) != 0) {
                    f2<p, p.b, Object> f2Var = this.f4209e;
                    if (f2Var == null) {
                        pVar = this.f4208d;
                        if (pVar == null) {
                            pVar = p.f4210e;
                        }
                    } else {
                        pVar = f2Var.e();
                    }
                    if (!pVar.isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public final void maybeForceBuilderInitialization() {
                f2<p, p.b, Object> f2Var;
                p pVar;
                if (k0.alwaysUseFieldBuilders && (f2Var = this.f4209e) == null) {
                    if (f2Var == null) {
                        pVar = this.f4208d;
                        if (pVar == null) {
                            pVar = p.f4210e;
                        }
                    } else {
                        pVar = f2Var.e();
                    }
                    this.f4209e = new f2<>(pVar, getParentForChildren(), isClean());
                    this.f4208d = null;
                }
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof o) {
                    e((o) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m238setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m239setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m240setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m230build() {
                o a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m233clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m234getDefaultInstanceForType() {
                return o.f;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m235mergeFrom(e1 e1Var) {
                if (e1Var instanceof o) {
                    e((o) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m237mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            public b setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m232clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m236mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }
        }

        public o() {
            this.f4205e = -1;
            this.f4203c = "";
        }

        public o(k0.b bVar, a aVar) {
            super(bVar);
            this.f4205e = -1;
        }

        public String a() {
            Object obj = this.f4203c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.f4203c = u;
            }
            return u;
        }

        public p b() {
            p pVar = this.f4204d;
            return pVar == null ? p.f4210e : pVar;
        }

        public boolean c() {
            return (this.f4202b & 1) != 0;
        }

        public boolean d() {
            return (this.f4202b & 2) != 0;
        }

        /* renamed from: e */
        public b toBuilder() {
            if (this == f) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.e(this);
            return bVar;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof o)) {
                return super.equals(obj);
            }
            o oVar = (o) obj;
            if (c() != oVar.c()) {
                return false;
            }
            if ((!c() || a().equals(oVar.a())) && d() == oVar.d()) {
                return (!d() || b().equals(oVar.b())) && this.unknownFields.equals(oVar.unknownFields);
            }
            return false;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return f;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<o> getParserForType() {
            return g;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.f4202b & 1) != 0) {
                i2 = 0 + k0.computeStringSize(1, this.f4203c);
            }
            if ((this.f4202b & 2) != 0) {
                i2 += m.z(2, b());
            }
            int serializedSize = this.unknownFields.getSerializedSize() + i2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = r.n.hashCode() + 779;
            if (c()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + a().hashCode();
            }
            if (d()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + b().hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.o;
            fVar.c(o.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.f4205e;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!d() || b().isInitialized()) {
                this.f4205e = 1;
                return true;
            }
            this.f4205e = 0;
            return false;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return f.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new o();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            if ((this.f4202b & 1) != 0) {
                k0.writeString(mVar, 1, this.f4203c);
            }
            if ((this.f4202b & 2) != 0) {
                mVar.k0(2, b());
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m227getDefaultInstanceForType() {
            return f;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m228newBuilderForType() {
            return f.toBuilder();
        }
    }

    public static final class p extends k0.e<p> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public static final p f4210e = new p();
        @Deprecated
        public static final v1<p> f = new a();

        /* renamed from: c  reason: collision with root package name */
        public List<t> f4211c;

        /* renamed from: d  reason: collision with root package name */
        public byte f4212d;

        public static class a extends c<p> {
            /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                p pVar = new p();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 7994) {
                                    if (!z2 || !true) {
                                        pVar.f4211c = new ArrayList();
                                        z2 |= true;
                                    }
                                    pVar.f4211c.add(kVar.w(t.l, zVar));
                                } else if (!pVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = pVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = pVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                pVar.f4211c = Collections.unmodifiableList(pVar.f4211c);
                            }
                            pVar.unknownFields = b2.build();
                            pVar.f3942b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        pVar.f4211c = Collections.unmodifiableList(pVar.f4211c);
                    }
                    pVar.unknownFields = b2.build();
                    pVar.f3942b.x();
                    return pVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.d<p, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f4213c;

            /* renamed from: d  reason: collision with root package name */
            public List<t> f4214d = Collections.emptyList();

            /* renamed from: e  reason: collision with root package name */
            public b2<t, t.b, Object> f4215e;

            public b() {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public k0.b m243addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                p j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public k0.b m245clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return p.f4210e;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.F;
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b h(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.G;
                fVar.c(p.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.d, c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                t tVar;
                int i = 0;
                while (true) {
                    b2<t, t.b, Object> b2Var = this.f4215e;
                    if (i < (b2Var == null ? this.f4214d.size() : b2Var.m())) {
                        b2<t, t.b, Object> b2Var2 = this.f4215e;
                        if (b2Var2 == null) {
                            tVar = this.f4214d.get(i);
                        } else {
                            tVar = b2Var2.n(i, false);
                        }
                        if (!tVar.isInitialized()) {
                            return false;
                        }
                        i++;
                    } else if (!e()) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }

            /* renamed from: j */
            public p buildPartial() {
                List<t> list;
                p pVar = new p(this, null);
                int i = this.f4213c;
                b2<t, t.b, Object> b2Var = this.f4215e;
                if (b2Var == null) {
                    if ((i & 1) != 0) {
                        this.f4214d = Collections.unmodifiableList(this.f4214d);
                        this.f4213c &= -2;
                    }
                    list = this.f4214d;
                } else {
                    list = b2Var.g();
                }
                pVar.f4211c = list;
                onBuilt();
                return pVar;
            }

            public b k() {
                super.clear();
                b2<t, t.b, Object> b2Var = this.f4215e;
                if (b2Var == null) {
                    this.f4214d = Collections.emptyList();
                    this.f4213c &= -2;
                } else {
                    b2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final b2<t, t.b, Object> m() {
                if (this.f4215e == null) {
                    List<t> list = this.f4214d;
                    boolean z = true;
                    if ((this.f4213c & 1) == 0) {
                        z = false;
                    }
                    this.f4215e = new b2<>(list, z, getParentForChildren(), isClean());
                    this.f4214d = null;
                }
                return this.f4215e;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof p) {
                    o((p) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b n(k kVar, z zVar) {
                Throwable th;
                p pVar;
                p pVar2 = null;
                try {
                    p parsePartialFrom = p.f.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        o(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    pVar = (p) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    pVar2 = pVar;
                    if (pVar2 != null) {
                    }
                    throw th;
                }
            }

            public b o(p pVar) {
                if (pVar == p.f4210e) {
                    return this;
                }
                if (this.f4215e == null) {
                    if (!pVar.f4211c.isEmpty()) {
                        if (this.f4214d.isEmpty()) {
                            this.f4214d = pVar.f4211c;
                            this.f4213c &= -2;
                        } else {
                            if ((this.f4213c & 1) == 0) {
                                this.f4214d = new ArrayList(this.f4214d);
                                this.f4213c |= 1;
                            }
                            this.f4214d.addAll(pVar.f4211c);
                        }
                        onChanged();
                    }
                } else if (!pVar.f4211c.isEmpty()) {
                    if (this.f4215e.s()) {
                        b2<t, t.b, Object> b2Var = null;
                        this.f4215e.f3831a = null;
                        this.f4215e = null;
                        this.f4214d = pVar.f4211c;
                        this.f4213c &= -2;
                        if (k0.alwaysUseFieldBuilders) {
                            b2Var = m();
                        }
                        this.f4215e = b2Var;
                    } else {
                        this.f4215e.b(pVar.f4211c);
                    }
                }
                f(pVar);
                p(pVar.unknownFields);
                onChanged();
                return this;
            }

            public final b p(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public k0.b m252setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public k0.b m253setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public k0.b m254setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(a aVar) {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m244build() {
                p j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public k0.b m247clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m248getDefaultInstanceForType() {
                return p.f4210e;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m249mergeFrom(e1 e1Var) {
                if (e1Var instanceof p) {
                    o((p) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public k0.b m251mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            public e1.a setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public e1.a m246clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public e1.a m250mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public p() {
            this.f4212d = -1;
            this.f4211c = Collections.emptyList();
        }

        public p(k0.d dVar, a aVar) {
            super(dVar);
            this.f4212d = -1;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof p)) {
                return super.equals(obj);
            }
            p pVar = (p) obj;
            if (this.f4211c.equals(pVar.f4211c) && this.unknownFields.equals(pVar.unknownFields) && c().equals(pVar.c())) {
                return true;
            }
            return false;
        }

        /* renamed from: f */
        public b toBuilder() {
            if (this == f4210e) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.o(this);
            return bVar;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return f4210e;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<p> getParserForType() {
            return f;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f4211c.size(); i3++) {
                i2 += m.z(b.r.h.MAX_BIND_PARAMETER_CNT, this.f4211c.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + i2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = r.F.hashCode() + 779;
            if (this.f4211c.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.r.h.MAX_BIND_PARAMETER_CNT, 53) + this.f4211c.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.G;
            fVar.c(p.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.k0.e, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.f4212d;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.f4211c.size(); i++) {
                if (!this.f4211c.get(i).isInitialized()) {
                    this.f4212d = 0;
                    return false;
                }
            }
            if (!a()) {
                this.f4212d = 0;
                return false;
            }
            this.f4212d = 1;
            return true;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return f4210e.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new p();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            k0.e<MessageType>.a d2 = d();
            for (int i = 0; i < this.f4211c.size(); i++) {
                mVar.k0(b.r.h.MAX_BIND_PARAMETER_CNT, this.f4211c.get(i));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m241getDefaultInstanceForType() {
            return f4210e;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m242newBuilderForType() {
            return f4210e.toBuilder();
        }
    }

    public static final class q extends k0 implements j1 {
        public static final q g = new q();
        @Deprecated
        public static final v1<q> h = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f4216b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f4217c;

        /* renamed from: d  reason: collision with root package name */
        public List<m> f4218d;

        /* renamed from: e  reason: collision with root package name */
        public C0106r f4219e;
        public byte f;

        public static class a extends c<q> {
            /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: java.util.List<c.b.d.r$m> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                q qVar = new q();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 10) {
                                    j n = kVar.n();
                                    qVar.f4216b = 1 | qVar.f4216b;
                                    qVar.f4217c = n;
                                } else if (G == 18) {
                                    if (!z2 || !true) {
                                        qVar.f4218d = new ArrayList();
                                        z2 |= true;
                                    }
                                    qVar.f4218d.add(kVar.w(m.k, zVar));
                                } else if (G == 26) {
                                    C0106r.b g = (qVar.f4216b & 2) != 0 ? qVar.f4219e.toBuilder() : null;
                                    C0106r rVar = (C0106r) kVar.w(C0106r.h, zVar);
                                    qVar.f4219e = rVar;
                                    if (g != null) {
                                        g.o(rVar);
                                        qVar.f4219e = g.buildPartial();
                                    }
                                    qVar.f4216b |= 2;
                                } else if (!qVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = qVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = qVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                qVar.f4218d = Collections.unmodifiableList(qVar.f4218d);
                            }
                            qVar.unknownFields = b2.build();
                            qVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        qVar.f4218d = Collections.unmodifiableList(qVar.f4218d);
                    }
                    qVar.unknownFields = b2.build();
                    qVar.makeExtensionsImmutable();
                    return qVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f4220b;

            /* renamed from: c  reason: collision with root package name */
            public Object f4221c = "";

            /* renamed from: d  reason: collision with root package name */
            public List<m> f4222d = Collections.emptyList();

            /* renamed from: e  reason: collision with root package name */
            public b2<m, m.b, Object> f4223e;
            public C0106r f;
            public f2<C0106r, C0106r.b, Object> g;

            public b() {
                maybeForceBuilderInitialization();
            }

            public b(a aVar) {
                maybeForceBuilderInitialization();
            }

            /* renamed from: a */
            public q buildPartial() {
                List<m> list;
                q qVar = new q(this, null);
                int i = this.f4220b;
                int i2 = (i & 1) != 0 ? 1 : 0;
                qVar.f4217c = this.f4221c;
                b2<m, m.b, Object> b2Var = this.f4223e;
                if (b2Var == null) {
                    if ((this.f4220b & 2) != 0) {
                        this.f4222d = Collections.unmodifiableList(this.f4222d);
                        this.f4220b &= -3;
                    }
                    list = this.f4222d;
                } else {
                    list = b2Var.g();
                }
                qVar.f4218d = list;
                if ((i & 4) != 0) {
                    f2<C0106r, C0106r.b, Object> f2Var = this.g;
                    qVar.f4219e = f2Var == null ? this.f : f2Var.b();
                    i2 |= 2;
                }
                qVar.f4216b = i2;
                onBuilt();
                return qVar;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m257addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            public b b() {
                super.clear();
                this.f4221c = "";
                this.f4220b &= -2;
                b2<m, m.b, Object> b2Var = this.f4223e;
                if (b2Var == null) {
                    this.f4222d = Collections.emptyList();
                    this.f4220b &= -3;
                } else {
                    b2Var.h();
                }
                f2<C0106r, C0106r.b, Object> f2Var = this.g;
                if (f2Var == null) {
                    this.f = null;
                } else {
                    f2Var.c();
                }
                this.f4220b &= -5;
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                q a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
            }

            /* renamed from: c */
            public b clone() {
                return (b) super.clone();
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m259clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            public final b2<m, m.b, Object> d() {
                if (this.f4223e == null) {
                    this.f4223e = new b2<>(this.f4222d, (this.f4220b & 2) != 0, getParentForChildren(), isClean());
                    this.f4222d = null;
                }
                return this.f4223e;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b e(k kVar, z zVar) {
                Throwable th;
                q qVar;
                q qVar2 = null;
                try {
                    q parsePartialFrom = q.h.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        f(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    qVar = (q) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    qVar2 = qVar;
                    if (qVar2 != null) {
                    }
                    throw th;
                }
            }

            public b f(q qVar) {
                C0106r rVar;
                C0106r rVar2;
                if (qVar == q.g) {
                    return this;
                }
                if (qVar.d()) {
                    this.f4220b |= 1;
                    this.f4221c = qVar.f4217c;
                    onChanged();
                }
                if (this.f4223e == null) {
                    if (!qVar.f4218d.isEmpty()) {
                        if (this.f4222d.isEmpty()) {
                            this.f4222d = qVar.f4218d;
                            this.f4220b &= -3;
                        } else {
                            if ((this.f4220b & 2) == 0) {
                                this.f4222d = new ArrayList(this.f4222d);
                                this.f4220b |= 2;
                            }
                            this.f4222d.addAll(qVar.f4218d);
                        }
                        onChanged();
                    }
                } else if (!qVar.f4218d.isEmpty()) {
                    if (this.f4223e.s()) {
                        b2<m, m.b, Object> b2Var = null;
                        this.f4223e.f3831a = null;
                        this.f4223e = null;
                        this.f4222d = qVar.f4218d;
                        this.f4220b &= -3;
                        if (k0.alwaysUseFieldBuilders) {
                            b2Var = d();
                        }
                        this.f4223e = b2Var;
                    } else {
                        this.f4223e.b(qVar.f4218d);
                    }
                }
                if (qVar.e()) {
                    C0106r c2 = qVar.c();
                    f2<C0106r, C0106r.b, Object> f2Var = this.g;
                    if (f2Var == null) {
                        if (!((this.f4220b & 4) == 0 || (rVar = this.f) == null || rVar == (rVar2 = C0106r.g))) {
                            C0106r.b g2 = rVar2.toBuilder();
                            g2.o(rVar);
                            g2.o(c2);
                            c2 = g2.buildPartial();
                        }
                        this.f = c2;
                        onChanged();
                    } else {
                        f2Var.f(c2);
                    }
                    this.f4220b |= 4;
                }
                g(qVar.unknownFields);
                onChanged();
                return this;
            }

            public final b g(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return q.g;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.v;
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.w;
                fVar.c(q.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                C0106r rVar;
                m mVar;
                int i = 0;
                while (true) {
                    b2<m, m.b, Object> b2Var = this.f4223e;
                    if (i < (b2Var == null ? this.f4222d.size() : b2Var.m())) {
                        b2<m, m.b, Object> b2Var2 = this.f4223e;
                        if (b2Var2 == null) {
                            mVar = this.f4222d.get(i);
                        } else {
                            mVar = b2Var2.n(i, false);
                        }
                        if (!mVar.isInitialized()) {
                            return false;
                        }
                        i++;
                    } else {
                        if ((this.f4220b & 4) != 0) {
                            f2<C0106r, C0106r.b, Object> f2Var = this.g;
                            if (f2Var == null) {
                                rVar = this.f;
                                if (rVar == null) {
                                    rVar = C0106r.g;
                                }
                            } else {
                                rVar = f2Var.e();
                            }
                            if (!rVar.isInitialized()) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }

            public final void maybeForceBuilderInitialization() {
                C0106r rVar;
                if (k0.alwaysUseFieldBuilders) {
                    d();
                    f2<C0106r, C0106r.b, Object> f2Var = this.g;
                    if (f2Var == null) {
                        if (f2Var == null) {
                            rVar = this.f;
                            if (rVar == null) {
                                rVar = C0106r.g;
                            }
                        } else {
                            rVar = f2Var.e();
                        }
                        this.g = new f2<>(rVar, getParentForChildren(), isClean());
                        this.f = null;
                    }
                }
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof q) {
                    f((q) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m266setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m267setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m268setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m258build() {
                q a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m261clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m262getDefaultInstanceForType() {
                return q.g;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m263mergeFrom(e1 e1Var) {
                if (e1Var instanceof q) {
                    f((q) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m265mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            public b setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m260clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m264mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }
        }

        public q() {
            this.f = -1;
            this.f4217c = "";
            this.f4218d = Collections.emptyList();
        }

        public q(k0.b bVar, a aVar) {
            super(bVar);
            this.f = -1;
        }

        public int a() {
            return this.f4218d.size();
        }

        public String b() {
            Object obj = this.f4217c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.f4217c = u;
            }
            return u;
        }

        public C0106r c() {
            C0106r rVar = this.f4219e;
            return rVar == null ? C0106r.g : rVar;
        }

        public boolean d() {
            return (this.f4216b & 1) != 0;
        }

        public boolean e() {
            return (this.f4216b & 2) != 0;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof q)) {
                return super.equals(obj);
            }
            q qVar = (q) obj;
            if (d() != qVar.d()) {
                return false;
            }
            if ((!d() || b().equals(qVar.b())) && this.f4218d.equals(qVar.f4218d) && e() == qVar.e()) {
                return (!e() || c().equals(qVar.c())) && this.unknownFields.equals(qVar.unknownFields);
            }
            return false;
        }

        /* renamed from: f */
        public b toBuilder() {
            if (this == g) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.f(this);
            return bVar;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return g;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<q> getParserForType() {
            return h;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.f4216b & 1) != 0 ? k0.computeStringSize(1, this.f4217c) + 0 : 0;
            for (int i2 = 0; i2 < this.f4218d.size(); i2++) {
                computeStringSize += m.z(2, this.f4218d.get(i2));
            }
            if ((this.f4216b & 2) != 0) {
                computeStringSize += m.z(3, c());
            }
            int serializedSize = this.unknownFields.getSerializedSize() + computeStringSize;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = r.v.hashCode() + 779;
            if (d()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + b().hashCode();
            }
            if (a() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f4218d.hashCode();
            }
            if (e()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + c().hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.w;
            fVar.c(q.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < a(); i++) {
                if (!this.f4218d.get(i).isInitialized()) {
                    this.f = 0;
                    return false;
                }
            }
            if (!e() || c().isInitialized()) {
                this.f = 1;
                return true;
            }
            this.f = 0;
            return false;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return g.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new q();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            if ((this.f4216b & 1) != 0) {
                k0.writeString(mVar, 1, this.f4217c);
            }
            for (int i = 0; i < this.f4218d.size(); i++) {
                mVar.k0(2, this.f4218d.get(i));
            }
            if ((this.f4216b & 2) != 0) {
                mVar.k0(3, c());
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m255getDefaultInstanceForType() {
            return g;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m256newBuilderForType() {
            return g.toBuilder();
        }
    }

    /* renamed from: c.b.d.r$r  reason: collision with other inner class name */
    public static final class C0106r extends k0.e<C0106r> implements Object {
        public static final C0106r g = new C0106r();
        @Deprecated
        public static final v1<C0106r> h = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f4224c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4225d;

        /* renamed from: e  reason: collision with root package name */
        public List<t> f4226e;
        public byte f;

        /* renamed from: c.b.d.r$r$a */
        public static class a extends c<C0106r> {
            /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                C0106r rVar = new C0106r();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 264) {
                                    rVar.f4224c |= 1;
                                    rVar.f4225d = kVar.m();
                                } else if (G == 7994) {
                                    if (!z2 || !true) {
                                        rVar.f4226e = new ArrayList();
                                        z2 |= true;
                                    }
                                    rVar.f4226e.add(kVar.w(t.l, zVar));
                                } else if (!rVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = rVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = rVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                rVar.f4226e = Collections.unmodifiableList(rVar.f4226e);
                            }
                            rVar.unknownFields = b2.build();
                            rVar.f3942b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        rVar.f4226e = Collections.unmodifiableList(rVar.f4226e);
                    }
                    rVar.unknownFields = b2.build();
                    rVar.f3942b.x();
                    return rVar;
                }
                throw null;
            }
        }

        /* renamed from: c.b.d.r$r$b */
        public static final class b extends k0.d<C0106r, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f4227c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f4228d;

            /* renamed from: e  reason: collision with root package name */
            public List<t> f4229e = Collections.emptyList();
            public b2<t, t.b, Object> f;

            public b() {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public k0.b m271addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                C0106r j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public k0.b m273clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return C0106r.g;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.L;
            }

            /* Return type fixed from 'c.b.d.k0$d' to match base method */
            @Override // c.b.d.k0.d
            public b h(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.M;
                fVar.c(C0106r.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.d, c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                t tVar;
                int i = 0;
                while (true) {
                    b2<t, t.b, Object> b2Var = this.f;
                    if (i < (b2Var == null ? this.f4229e.size() : b2Var.m())) {
                        b2<t, t.b, Object> b2Var2 = this.f;
                        if (b2Var2 == null) {
                            tVar = this.f4229e.get(i);
                        } else {
                            tVar = b2Var2.n(i, false);
                        }
                        if (!tVar.isInitialized()) {
                            return false;
                        }
                        i++;
                    } else if (!e()) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }

            /* renamed from: j */
            public C0106r buildPartial() {
                List<t> list;
                C0106r rVar = new C0106r(this, null);
                int i = 1;
                if ((this.f4227c & 1) != 0) {
                    rVar.f4225d = this.f4228d;
                } else {
                    i = 0;
                }
                b2<t, t.b, Object> b2Var = this.f;
                if (b2Var == null) {
                    if ((this.f4227c & 2) != 0) {
                        this.f4229e = Collections.unmodifiableList(this.f4229e);
                        this.f4227c &= -3;
                    }
                    list = this.f4229e;
                } else {
                    list = b2Var.g();
                }
                rVar.f4226e = list;
                rVar.f4224c = i;
                onBuilt();
                return rVar;
            }

            public b k() {
                super.clear();
                this.f4228d = false;
                this.f4227c &= -2;
                b2<t, t.b, Object> b2Var = this.f;
                if (b2Var == null) {
                    this.f4229e = Collections.emptyList();
                    this.f4227c &= -3;
                } else {
                    b2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final b2<t, t.b, Object> m() {
                if (this.f == null) {
                    this.f = new b2<>(this.f4229e, (this.f4227c & 2) != 0, getParentForChildren(), isClean());
                    this.f4229e = null;
                }
                return this.f;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof C0106r) {
                    o((C0106r) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b n(k kVar, z zVar) {
                Throwable th;
                C0106r rVar;
                C0106r rVar2 = null;
                try {
                    C0106r parsePartialFrom = C0106r.h.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        o(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    rVar = (C0106r) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    rVar2 = rVar;
                    if (rVar2 != null) {
                    }
                    throw th;
                }
            }

            public b o(C0106r rVar) {
                if (rVar == C0106r.g) {
                    return this;
                }
                if (rVar.f()) {
                    boolean z = rVar.f4225d;
                    this.f4227c |= 1;
                    this.f4228d = z;
                    onChanged();
                }
                if (this.f == null) {
                    if (!rVar.f4226e.isEmpty()) {
                        if (this.f4229e.isEmpty()) {
                            this.f4229e = rVar.f4226e;
                            this.f4227c &= -3;
                        } else {
                            if ((this.f4227c & 2) == 0) {
                                this.f4229e = new ArrayList(this.f4229e);
                                this.f4227c |= 2;
                            }
                            this.f4229e.addAll(rVar.f4226e);
                        }
                        onChanged();
                    }
                } else if (!rVar.f4226e.isEmpty()) {
                    if (this.f.s()) {
                        b2<t, t.b, Object> b2Var = null;
                        this.f.f3831a = null;
                        this.f = null;
                        this.f4229e = rVar.f4226e;
                        this.f4227c &= -3;
                        if (k0.alwaysUseFieldBuilders) {
                            b2Var = m();
                        }
                        this.f = b2Var;
                    } else {
                        this.f.b(rVar.f4226e);
                    }
                }
                f(rVar);
                p(rVar.unknownFields);
                onChanged();
                return this;
            }

            public final b p(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public k0.b m280setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public k0.b m281setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public k0.b m282setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(a aVar) {
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m272build() {
                C0106r j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) j);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public k0.b m275clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m276getDefaultInstanceForType() {
                return C0106r.g;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m277mergeFrom(e1 e1Var) {
                if (e1Var instanceof C0106r) {
                    o((C0106r) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public k0.b m279mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k0.d, c.b.d.k0.d, c.b.d.k0.b, c.b.d.k0.b
            public e1.a setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public e1.a setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public e1.a m274clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public e1.a m278mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                if (k0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public C0106r() {
            this.f = -1;
            this.f4226e = Collections.emptyList();
        }

        public C0106r(k0.d dVar, a aVar) {
            super(dVar);
            this.f = -1;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0106r)) {
                return super.equals(obj);
            }
            C0106r rVar = (C0106r) obj;
            if (f() != rVar.f()) {
                return false;
            }
            return (!f() || this.f4225d == rVar.f4225d) && this.f4226e.equals(rVar.f4226e) && this.unknownFields.equals(rVar.unknownFields) && c().equals(rVar.c());
        }

        public boolean f() {
            return (this.f4224c & 1) != 0;
        }

        /* renamed from: g */
        public b toBuilder() {
            if (this == g) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.o(this);
            return bVar;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return g;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<C0106r> getParserForType() {
            return h;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int c2 = (this.f4224c & 1) != 0 ? m.c(33, this.f4225d) + 0 : 0;
            for (int i2 = 0; i2 < this.f4226e.size(); i2++) {
                c2 += m.z(b.r.h.MAX_BIND_PARAMETER_CNT, this.f4226e.get(i2));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + c2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = r.L.hashCode() + 779;
            if (f()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 33, 53) + m0.c(this.f4225d);
            }
            if (this.f4226e.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.r.h.MAX_BIND_PARAMETER_CNT, 53) + this.f4226e.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.M;
            fVar.c(C0106r.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.k0.e, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.f4226e.size(); i++) {
                if (!this.f4226e.get(i).isInitialized()) {
                    this.f = 0;
                    return false;
                }
            }
            if (!a()) {
                this.f = 0;
                return false;
            }
            this.f = 1;
            return true;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return g.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new C0106r();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            k0.e<MessageType>.a d2 = d();
            if ((this.f4224c & 1) != 0) {
                mVar.Y(33, this.f4225d);
            }
            for (int i = 0; i < this.f4226e.size(); i++) {
                mVar.k0(b.r.h.MAX_BIND_PARAMETER_CNT, this.f4226e.get(i));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m269getDefaultInstanceForType() {
            return g;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m270newBuilderForType() {
            return g.toBuilder();
        }
    }

    public static final class s extends k0 implements j1 {

        /* renamed from: d  reason: collision with root package name */
        public static final s f4230d = new s();
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public static final v1<s> f4231e = new a();

        /* renamed from: b  reason: collision with root package name */
        public List<c> f4232b;

        /* renamed from: c  reason: collision with root package name */
        public byte f4233c;

        public static class a extends c<s> {
            /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List<c.b.d.r$s$c> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                s sVar = new s();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 10) {
                                    if (!z2 || !true) {
                                        sVar.f4232b = new ArrayList();
                                        z2 |= true;
                                    }
                                    sVar.f4232b.add(kVar.w(c.l, zVar));
                                } else if (!sVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = sVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = sVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                sVar.f4232b = Collections.unmodifiableList(sVar.f4232b);
                            }
                            sVar.unknownFields = b2.build();
                            sVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        sVar.f4232b = Collections.unmodifiableList(sVar.f4232b);
                    }
                    sVar.unknownFields = b2.build();
                    sVar.makeExtensionsImmutable();
                    return sVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f4234b;

            /* renamed from: c  reason: collision with root package name */
            public List<c> f4235c = Collections.emptyList();

            /* renamed from: d  reason: collision with root package name */
            public b2<c, c.b, Object> f4236d;

            public b() {
                if (k0.alwaysUseFieldBuilders) {
                    d();
                }
            }

            /* renamed from: a */
            public s buildPartial() {
                List<c> list;
                s sVar = new s(this, null);
                int i = this.f4234b;
                b2<c, c.b, Object> b2Var = this.f4236d;
                if (b2Var == null) {
                    if ((i & 1) != 0) {
                        this.f4235c = Collections.unmodifiableList(this.f4235c);
                        this.f4234b &= -2;
                    }
                    list = this.f4235c;
                } else {
                    list = b2Var.g();
                }
                sVar.f4232b = list;
                onBuilt();
                return sVar;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m285addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            public b b() {
                super.clear();
                b2<c, c.b, Object> b2Var = this.f4236d;
                if (b2Var == null) {
                    this.f4235c = Collections.emptyList();
                    this.f4234b &= -2;
                } else {
                    b2Var.h();
                }
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                s a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
            }

            /* renamed from: c */
            public b clone() {
                return (b) super.clone();
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m287clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            public final b2<c, c.b, Object> d() {
                if (this.f4236d == null) {
                    List<c> list = this.f4235c;
                    boolean z = true;
                    if ((this.f4234b & 1) == 0) {
                        z = false;
                    }
                    this.f4236d = new b2<>(list, z, getParentForChildren(), isClean());
                    this.f4235c = null;
                }
                return this.f4236d;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b e(k kVar, z zVar) {
                Throwable th;
                s sVar;
                s sVar2 = null;
                try {
                    s parsePartialFrom = s.f4231e.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        f(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    sVar = (s) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    sVar2 = sVar;
                    if (sVar2 != null) {
                    }
                    throw th;
                }
            }

            public b f(s sVar) {
                if (sVar == s.f4230d) {
                    return this;
                }
                if (this.f4236d == null) {
                    if (!sVar.f4232b.isEmpty()) {
                        if (this.f4235c.isEmpty()) {
                            this.f4235c = sVar.f4232b;
                            this.f4234b &= -2;
                        } else {
                            if ((this.f4234b & 1) == 0) {
                                this.f4235c = new ArrayList(this.f4235c);
                                this.f4234b |= 1;
                            }
                            this.f4235c.addAll(sVar.f4232b);
                        }
                        onChanged();
                    }
                } else if (!sVar.f4232b.isEmpty()) {
                    if (this.f4236d.s()) {
                        b2<c, c.b, Object> b2Var = null;
                        this.f4236d.f3831a = null;
                        this.f4236d = null;
                        this.f4235c = sVar.f4232b;
                        this.f4234b &= -2;
                        if (k0.alwaysUseFieldBuilders) {
                            b2Var = d();
                        }
                        this.f4236d = b2Var;
                    } else {
                        this.f4236d.b(sVar.f4232b);
                    }
                }
                g(sVar.unknownFields);
                onChanged();
                return this;
            }

            public final b g(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return s.f4230d;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.T;
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.U;
                fVar.c(s.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                return true;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof s) {
                    f((s) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m294setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m295setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m296setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(a aVar) {
                if (k0.alwaysUseFieldBuilders) {
                    d();
                }
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m286build() {
                s a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m289clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m290getDefaultInstanceForType() {
                return s.f4230d;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m291mergeFrom(e1 e1Var) {
                if (e1Var instanceof s) {
                    f((s) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m293mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            public b setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m288clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m292mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                if (k0.alwaysUseFieldBuilders) {
                    d();
                }
            }
        }

        public static final class c extends k0 implements j1 {
            public static final c k = new c();
            @Deprecated
            public static final v1<c> l = new a();

            /* renamed from: b  reason: collision with root package name */
            public int f4237b;

            /* renamed from: c  reason: collision with root package name */
            public m0.f f4238c;

            /* renamed from: d  reason: collision with root package name */
            public int f4239d;

            /* renamed from: e  reason: collision with root package name */
            public m0.f f4240e;
            public int f;
            public volatile Object g;
            public volatile Object h;
            public s0 i;
            public byte j;

            public static class a extends c<c> {
                @Override // c.b.d.v1
                public Object parsePartialFrom(k kVar, z zVar) {
                    m0.f fVar;
                    int i;
                    c cVar = new c();
                    if (zVar != null) {
                        p2.b b2 = p2.b();
                        boolean z = false;
                        boolean z2 = false;
                        while (!z) {
                            try {
                                int G = kVar.G();
                                if (G != 0) {
                                    if (G != 8) {
                                        if (G == 10) {
                                            i = kVar.l(kVar.y());
                                            if ((!z2 || !true) && kVar.d() > 0) {
                                                cVar.f4238c = k0.newIntList();
                                                z2 |= true;
                                            }
                                            while (kVar.d() > 0) {
                                                ((l0) cVar.f4238c).c(kVar.u());
                                            }
                                        } else if (G == 16) {
                                            if (!z2 || !true) {
                                                cVar.f4240e = k0.newIntList();
                                                z2 |= true;
                                            }
                                            fVar = cVar.f4240e;
                                        } else if (G == 18) {
                                            i = kVar.l(kVar.y());
                                            if ((!z2 || !true) && kVar.d() > 0) {
                                                cVar.f4240e = k0.newIntList();
                                                z2 |= true;
                                            }
                                            while (kVar.d() > 0) {
                                                ((l0) cVar.f4240e).c(kVar.u());
                                            }
                                        } else if (G == 26) {
                                            j n = kVar.n();
                                            cVar.f4237b |= 1;
                                            cVar.g = n;
                                        } else if (G == 34) {
                                            j n2 = kVar.n();
                                            cVar.f4237b |= 2;
                                            cVar.h = n2;
                                        } else if (G == 50) {
                                            j n3 = kVar.n();
                                            if (!z2 || !true) {
                                                cVar.i = new r0(10);
                                                z2 |= true;
                                            }
                                            cVar.i.l(n3);
                                        } else if (!cVar.parseUnknownField(kVar, b2, zVar, G)) {
                                        }
                                        kVar.k(i);
                                    } else {
                                        if (!z2 || !true) {
                                            cVar.f4238c = k0.newIntList();
                                            z2 |= true;
                                        }
                                        fVar = cVar.f4238c;
                                    }
                                    ((l0) fVar).c(kVar.u());
                                }
                                z = true;
                            } catch (n0 e2) {
                                e2.f4007b = cVar;
                                throw e2;
                            } catch (IOException e3) {
                                n0 n0Var = new n0(e3);
                                n0Var.f4007b = cVar;
                                throw n0Var;
                            } catch (Throwable th) {
                                if (z2 && true) {
                                    cVar.f4238c.d();
                                }
                                if (z2 && true) {
                                    cVar.f4240e.d();
                                }
                                if (z2 && true) {
                                    cVar.i = cVar.i.b();
                                }
                                cVar.unknownFields = b2.build();
                                cVar.makeExtensionsImmutable();
                                throw th;
                            }
                        }
                        if (z2 && true) {
                            cVar.f4238c.d();
                        }
                        if (z2 && true) {
                            cVar.f4240e.d();
                        }
                        if (z2 && true) {
                            cVar.i = cVar.i.b();
                        }
                        cVar.unknownFields = b2.build();
                        cVar.makeExtensionsImmutable();
                        return cVar;
                    }
                    throw null;
                }
            }

            public static final class b extends k0.b<b> implements Object {

                /* renamed from: b  reason: collision with root package name */
                public int f4241b;

                /* renamed from: c  reason: collision with root package name */
                public m0.f f4242c = k0.emptyIntList();

                /* renamed from: d  reason: collision with root package name */
                public m0.f f4243d = k0.emptyIntList();

                /* renamed from: e  reason: collision with root package name */
                public Object f4244e = "";
                public Object f = "";
                public s0 g = r0.f4261e;

                public b() {
                }

                public b(a aVar) {
                }

                /* renamed from: a */
                public c buildPartial() {
                    c cVar = new c(this, null);
                    int i = this.f4241b;
                    if ((i & 1) != 0) {
                        this.f4242c.d();
                        this.f4241b &= -2;
                    }
                    cVar.f4238c = this.f4242c;
                    if ((this.f4241b & 2) != 0) {
                        this.f4243d.d();
                        this.f4241b &= -3;
                    }
                    cVar.f4240e = this.f4243d;
                    int i2 = (i & 4) != 0 ? 1 : 0;
                    cVar.g = this.f4244e;
                    if ((i & 8) != 0) {
                        i2 |= 2;
                    }
                    cVar.h = this.f;
                    if ((this.f4241b & 16) != 0) {
                        this.g = this.g.b();
                        this.f4241b &= -17;
                    }
                    cVar.i = this.g;
                    cVar.f4237b = i2;
                    onBuilt();
                    return cVar;
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: addRepeatedField  reason: collision with other method in class */
                public b m299addRepeatedField(s.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                public b b() {
                    super.clear();
                    this.f4242c = k0.emptyIntList();
                    this.f4241b &= -2;
                    this.f4243d = k0.emptyIntList();
                    int i = this.f4241b & -3;
                    this.f4241b = i;
                    this.f4244e = "";
                    int i2 = i & -5;
                    this.f4241b = i2;
                    this.f = "";
                    int i3 = i2 & -9;
                    this.f4241b = i3;
                    this.g = r0.f4261e;
                    this.f4241b = i3 & -17;
                    return this;
                }

                @Override // c.b.d.h1.a, c.b.d.e1.a
                public e1 build() {
                    c a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
                }

                /* renamed from: c */
                public b clone() {
                    return (b) super.clone();
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: clearField  reason: collision with other method in class */
                public b m301clearField(s.g gVar) {
                    return (b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public b clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
                public b d(k kVar, z zVar) {
                    Throwable th;
                    c cVar;
                    c cVar2 = null;
                    try {
                        c parsePartialFrom = c.l.parsePartialFrom(kVar, zVar);
                        if (parsePartialFrom != null) {
                            e(parsePartialFrom);
                        }
                        return this;
                    } catch (n0 e2) {
                        cVar = (c) e2.f4007b;
                        throw e2.j();
                    } catch (Throwable th2) {
                        th = th2;
                        cVar2 = cVar;
                        if (cVar2 != null) {
                        }
                        throw th;
                    }
                }

                public b e(c cVar) {
                    if (cVar == c.k) {
                        return this;
                    }
                    if (!cVar.f4238c.isEmpty()) {
                        if (this.f4242c.isEmpty()) {
                            this.f4242c = cVar.f4238c;
                            this.f4241b &= -2;
                        } else {
                            if ((this.f4241b & 1) == 0) {
                                this.f4242c = k0.mutableCopy(this.f4242c);
                                this.f4241b |= 1;
                            }
                            this.f4242c.addAll(cVar.f4238c);
                        }
                        onChanged();
                    }
                    if (!cVar.f4240e.isEmpty()) {
                        if (this.f4243d.isEmpty()) {
                            this.f4243d = cVar.f4240e;
                            this.f4241b &= -3;
                        } else {
                            if ((this.f4241b & 2) == 0) {
                                this.f4243d = k0.mutableCopy(this.f4243d);
                                this.f4241b |= 2;
                            }
                            this.f4243d.addAll(cVar.f4240e);
                        }
                        onChanged();
                    }
                    if (cVar.c()) {
                        this.f4241b |= 4;
                        this.f4244e = cVar.g;
                        onChanged();
                    }
                    if (cVar.d()) {
                        this.f4241b |= 8;
                        this.f = cVar.h;
                        onChanged();
                    }
                    if (!cVar.i.isEmpty()) {
                        if (this.g.isEmpty()) {
                            this.g = cVar.i;
                            this.f4241b &= -17;
                        } else {
                            if ((this.f4241b & 16) == 0) {
                                this.g = new r0(this.g);
                                this.f4241b |= 16;
                            }
                            this.g.addAll(cVar.i);
                        }
                        onChanged();
                    }
                    f(cVar.unknownFields);
                    onChanged();
                    return this;
                }

                public final b f(p2 p2Var) {
                    return (b) super.mergeUnknownFields(p2Var);
                }

                @Override // c.b.d.j1, c.b.d.i1
                public e1 getDefaultInstanceForType() {
                    return c.k;
                }

                @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
                public s.b getDescriptorForType() {
                    return r.V;
                }

                @Override // c.b.d.k0.b
                public k0.f internalGetFieldAccessorTable() {
                    k0.f fVar = r.W;
                    fVar.c(c.class, b.class);
                    return fVar;
                }

                @Override // c.b.d.k0.b, c.b.d.i1
                public final boolean isInitialized() {
                    return true;
                }

                @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public a.AbstractC0097a mergeFrom(e1 e1Var) {
                    if (e1Var instanceof c) {
                        e((c) e1Var);
                    } else {
                        super.mergeFrom(e1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public b mergeUnknownFields(p2 p2Var) {
                    return (b) super.mergeUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: setField  reason: collision with other method in class */
                public b m308setField(s.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b
                /* renamed from: setRepeatedField  reason: collision with other method in class */
                public b m309setRepeatedField(s.g gVar, int i, Object obj) {
                    return (b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: setUnknownFields  reason: collision with other method in class */
                public b m310setUnknownFields(p2 p2Var) {
                    return (b) super.setUnknownFields(p2Var);
                }

                public b(k0.c cVar, a aVar) {
                    super(cVar);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public b addRepeatedField(s.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                @Override // c.b.d.h1.a, c.b.d.e1.a
                /* renamed from: build  reason: collision with other method in class */
                public h1 m300build() {
                    c a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public b clearField(s.g gVar) {
                    return (b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public b m303clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                @Override // c.b.d.j1, c.b.d.i1
                /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
                public h1 m304getDefaultInstanceForType() {
                    return c.k;
                }

                @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeFrom  reason: collision with other method in class */
                public e1.a m305mergeFrom(e1 e1Var) {
                    if (e1Var instanceof c) {
                        e((c) e1Var);
                    } else {
                        super.mergeFrom(e1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public b m307mergeUnknownFields(p2 p2Var) {
                    return (b) super.mergeUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public b setField(s.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b
                public b setRepeatedField(s.g gVar, int i, Object obj) {
                    return (b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public b setUnknownFields(p2 p2Var) {
                    return (b) super.setUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public b m302clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public b m306mergeUnknownFields(p2 p2Var) {
                    return (b) super.mergeUnknownFields(p2Var);
                }
            }

            public c() {
                this.f4239d = -1;
                this.f = -1;
                this.j = -1;
                this.f4238c = k0.emptyIntList();
                this.f4240e = k0.emptyIntList();
                this.g = "";
                this.h = "";
                this.i = r0.f4261e;
            }

            public c(k0.b bVar, a aVar) {
                super(bVar);
                this.f4239d = -1;
                this.f = -1;
                this.j = -1;
            }

            public String a() {
                Object obj = this.g;
                if (obj instanceof String) {
                    return (String) obj;
                }
                j jVar = (j) obj;
                String u = jVar.u();
                if (jVar.o()) {
                    this.g = u;
                }
                return u;
            }

            public String b() {
                Object obj = this.h;
                if (obj instanceof String) {
                    return (String) obj;
                }
                j jVar = (j) obj;
                String u = jVar.u();
                if (jVar.o()) {
                    this.h = u;
                }
                return u;
            }

            public boolean c() {
                return (this.f4237b & 1) != 0;
            }

            public boolean d() {
                return (this.f4237b & 2) != 0;
            }

            /* renamed from: e */
            public b toBuilder() {
                if (this == k) {
                    return new b(null);
                }
                b bVar = new b(null);
                bVar.e(this);
                return bVar;
            }

            @Override // c.b.d.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return super.equals(obj);
                }
                c cVar = (c) obj;
                if (!this.f4238c.equals(cVar.f4238c) || !this.f4240e.equals(cVar.f4240e) || c() != cVar.c()) {
                    return false;
                }
                if ((c() && !a().equals(cVar.a())) || d() != cVar.d()) {
                    return false;
                }
                if ((!d() || b().equals(cVar.b())) && this.i.equals(cVar.i) && this.unknownFields.equals(cVar.unknownFields)) {
                    return true;
                }
                return false;
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return k;
            }

            @Override // c.b.d.k0, c.b.d.h1
            public v1<c> getParserForType() {
                return l;
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
            public int getSerializedSize() {
                int i2 = this.memoizedSize;
                if (i2 != -1) {
                    return i2;
                }
                int i3 = 0;
                for (int i4 = 0; i4 < this.f4238c.size(); i4++) {
                    i3 += m.t(((l0) this.f4238c).h(i4));
                }
                int i5 = 0 + i3;
                if (!this.f4238c.isEmpty()) {
                    i5 = i5 + 1 + m.t(i3);
                }
                this.f4239d = i3;
                int i6 = 0;
                for (int i7 = 0; i7 < this.f4240e.size(); i7++) {
                    i6 += m.t(((l0) this.f4240e).h(i7));
                }
                int i8 = i5 + i6;
                if (!this.f4240e.isEmpty()) {
                    i8 = i8 + 1 + m.t(i6);
                }
                this.f = i6;
                if ((this.f4237b & 1) != 0) {
                    i8 += k0.computeStringSize(3, this.g);
                }
                if ((this.f4237b & 2) != 0) {
                    i8 += k0.computeStringSize(4, this.h);
                }
                int i9 = 0;
                for (int i10 = 0; i10 < this.i.size(); i10++) {
                    i9 += k0.computeStringSizeNoTag(this.i.f(i10));
                }
                int serializedSize = this.unknownFields.getSerializedSize() + (this.i.size() * 1) + i8 + i9;
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // c.b.d.k0, c.b.d.j1
            public final p2 getUnknownFields() {
                return this.unknownFields;
            }

            @Override // c.b.d.a
            public int hashCode() {
                int i2 = this.memoizedHashCode;
                if (i2 != 0) {
                    return i2;
                }
                int hashCode = r.V.hashCode() + 779;
                if (this.f4238c.size() > 0) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + this.f4238c.hashCode();
                }
                if (this.f4240e.size() > 0) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f4240e.hashCode();
                }
                if (c()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + a().hashCode();
                }
                if (d()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 4, 53) + b().hashCode();
                }
                if (this.i.size() > 0) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 6, 53) + this.i.hashCode();
                }
                int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // c.b.d.k0
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.W;
                fVar.c(c.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
            public final boolean isInitialized() {
                byte b2 = this.j;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.j = 1;
                return true;
            }

            @Override // c.b.d.e1, c.b.d.h1
            public e1.a newBuilderForType() {
                return k.toBuilder();
            }

            @Override // c.b.d.k0
            public Object newInstance(k0.g gVar) {
                return new c();
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
            public void writeTo(m mVar) {
                getSerializedSize();
                if (this.f4238c.size() > 0) {
                    mVar.t0(10);
                    mVar.t0(this.f4239d);
                }
                for (int i2 = 0; i2 < this.f4238c.size(); i2++) {
                    mVar.j0(((l0) this.f4238c).h(i2));
                }
                if (this.f4240e.size() > 0) {
                    mVar.t0(18);
                    mVar.t0(this.f);
                }
                for (int i3 = 0; i3 < this.f4240e.size(); i3++) {
                    mVar.j0(((l0) this.f4240e).h(i3));
                }
                if ((this.f4237b & 1) != 0) {
                    k0.writeString(mVar, 3, this.g);
                }
                if ((this.f4237b & 2) != 0) {
                    k0.writeString(mVar, 4, this.h);
                }
                for (int i4 = 0; i4 < this.i.size(); i4++) {
                    k0.writeString(mVar, 6, this.i.f(i4));
                }
                this.unknownFields.writeTo(mVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m297getDefaultInstanceForType() {
                return k;
            }

            @Override // c.b.d.k0
            public e1.a newBuilderForType(k0.c cVar) {
                return new b(cVar, null);
            }

            @Override // c.b.d.e1, c.b.d.h1
            /* renamed from: newBuilderForType  reason: collision with other method in class */
            public h1.a m298newBuilderForType() {
                return k.toBuilder();
            }
        }

        public s() {
            this.f4233c = -1;
            this.f4232b = Collections.emptyList();
        }

        public s(k0.b bVar, a aVar) {
            super(bVar);
            this.f4233c = -1;
        }

        /* renamed from: a */
        public b toBuilder() {
            if (this == f4230d) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.f(this);
            return bVar;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof s)) {
                return super.equals(obj);
            }
            s sVar = (s) obj;
            if (this.f4232b.equals(sVar.f4232b) && this.unknownFields.equals(sVar.unknownFields)) {
                return true;
            }
            return false;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return f4230d;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<s> getParserForType() {
            return f4231e;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f4232b.size(); i3++) {
                i2 += m.z(1, this.f4232b.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + i2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = r.T.hashCode() + 779;
            if (this.f4232b.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + this.f4232b.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.U;
            fVar.c(s.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.f4233c;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.f4233c = 1;
            return true;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return f4230d.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new s();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            for (int i = 0; i < this.f4232b.size(); i++) {
                mVar.k0(1, this.f4232b.get(i));
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m283getDefaultInstanceForType() {
            return f4230d;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m284newBuilderForType() {
            return f4230d.toBuilder();
        }
    }

    public static final class t extends k0 implements j1 {
        public static final t k = new t();
        @Deprecated
        public static final v1<t> l = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f4245b;

        /* renamed from: c  reason: collision with root package name */
        public List<c> f4246c;

        /* renamed from: d  reason: collision with root package name */
        public volatile Object f4247d;

        /* renamed from: e  reason: collision with root package name */
        public long f4248e;
        public long f;
        public double g;
        public j h;
        public volatile Object i;
        public byte j;

        public static class a extends c<t> {
            /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List<c.b.d.r$t$c> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.v1
            public Object parsePartialFrom(k kVar, z zVar) {
                t tVar = new t();
                if (zVar != null) {
                    p2.b b2 = p2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 18) {
                                    if (!z2 || !true) {
                                        tVar.f4246c = new ArrayList();
                                        z2 |= true;
                                    }
                                    tVar.f4246c.add(kVar.w(c.g, zVar));
                                } else if (G == 26) {
                                    j n = kVar.n();
                                    tVar.f4245b |= 1;
                                    tVar.f4247d = n;
                                } else if (G == 32) {
                                    tVar.f4245b |= 2;
                                    tVar.f4248e = kVar.I();
                                } else if (G == 40) {
                                    tVar.f4245b |= 4;
                                    tVar.f = kVar.v();
                                } else if (G == 49) {
                                    tVar.f4245b |= 8;
                                    tVar.g = kVar.o();
                                } else if (G == 58) {
                                    tVar.f4245b |= 16;
                                    tVar.h = kVar.n();
                                } else if (G == 66) {
                                    j n2 = kVar.n();
                                    tVar.f4245b = 32 | tVar.f4245b;
                                    tVar.i = n2;
                                } else if (!tVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (n0 e2) {
                            e2.f4007b = tVar;
                            throw e2;
                        } catch (IOException e3) {
                            n0 n0Var = new n0(e3);
                            n0Var.f4007b = tVar;
                            throw n0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                tVar.f4246c = Collections.unmodifiableList(tVar.f4246c);
                            }
                            tVar.unknownFields = b2.build();
                            tVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        tVar.f4246c = Collections.unmodifiableList(tVar.f4246c);
                    }
                    tVar.unknownFields = b2.build();
                    tVar.makeExtensionsImmutable();
                    return tVar;
                }
                throw null;
            }
        }

        public static final class b extends k0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f4249b;

            /* renamed from: c  reason: collision with root package name */
            public List<c> f4250c = Collections.emptyList();

            /* renamed from: d  reason: collision with root package name */
            public b2<c, c.b, Object> f4251d;

            /* renamed from: e  reason: collision with root package name */
            public Object f4252e = "";
            public long f;
            public long g;
            public double h;
            public j i = j.f3914c;
            public Object j = "";

            public b() {
                if (k0.alwaysUseFieldBuilders) {
                    d();
                }
            }

            /* renamed from: a */
            public t buildPartial() {
                List<c> list;
                t tVar = new t(this, null);
                int i2 = this.f4249b;
                b2<c, c.b, Object> b2Var = this.f4251d;
                if (b2Var == null) {
                    if ((i2 & 1) != 0) {
                        this.f4250c = Collections.unmodifiableList(this.f4250c);
                        this.f4249b &= -2;
                    }
                    list = this.f4250c;
                } else {
                    list = b2Var.g();
                }
                tVar.f4246c = list;
                int i3 = (i2 & 2) != 0 ? 1 : 0;
                tVar.f4247d = this.f4252e;
                if ((i2 & 4) != 0) {
                    tVar.f4248e = this.f;
                    i3 |= 2;
                }
                if ((i2 & 8) != 0) {
                    tVar.f = this.g;
                    i3 |= 4;
                }
                if ((i2 & 16) != 0) {
                    tVar.g = this.h;
                    i3 |= 8;
                }
                if ((i2 & 32) != 0) {
                    i3 |= 16;
                }
                tVar.h = this.i;
                if ((i2 & 64) != 0) {
                    i3 |= 32;
                }
                tVar.i = this.j;
                tVar.f4245b = i3;
                onBuilt();
                return tVar;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m313addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            public b b() {
                super.clear();
                b2<c, c.b, Object> b2Var = this.f4251d;
                if (b2Var == null) {
                    this.f4250c = Collections.emptyList();
                    this.f4249b &= -2;
                } else {
                    b2Var.h();
                }
                this.f4252e = "";
                int i2 = this.f4249b & -3;
                this.f4249b = i2;
                this.f = 0;
                int i3 = i2 & -5;
                this.f4249b = i3;
                this.g = 0;
                int i4 = i3 & -9;
                this.f4249b = i4;
                this.h = 0.0d;
                int i5 = i4 & -17;
                this.f4249b = i5;
                this.i = j.f3914c;
                int i6 = i5 & -33;
                this.f4249b = i6;
                this.j = "";
                this.f4249b = i6 & -65;
                return this;
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            public e1 build() {
                t a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
            }

            /* renamed from: c */
            public b clone() {
                return (b) super.clone();
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m315clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            public final b2<c, c.b, Object> d() {
                if (this.f4251d == null) {
                    List<c> list = this.f4250c;
                    boolean z = true;
                    if ((this.f4249b & 1) == 0) {
                        z = false;
                    }
                    this.f4251d = new b2<>(list, z, getParentForChildren(), isClean());
                    this.f4250c = null;
                }
                return this.f4251d;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b e(k kVar, z zVar) {
                Throwable th;
                t tVar;
                t tVar2 = null;
                try {
                    t parsePartialFrom = t.l.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        f(parsePartialFrom);
                    }
                    return this;
                } catch (n0 e2) {
                    tVar = (t) e2.f4007b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    tVar2 = tVar;
                    if (tVar2 != null) {
                    }
                    throw th;
                }
            }

            public b f(t tVar) {
                if (tVar == t.k) {
                    return this;
                }
                if (this.f4251d == null) {
                    if (!tVar.f4246c.isEmpty()) {
                        if (this.f4250c.isEmpty()) {
                            this.f4250c = tVar.f4246c;
                            this.f4249b &= -2;
                        } else {
                            if ((this.f4249b & 1) == 0) {
                                this.f4250c = new ArrayList(this.f4250c);
                                this.f4249b |= 1;
                            }
                            this.f4250c.addAll(tVar.f4246c);
                        }
                        onChanged();
                    }
                } else if (!tVar.f4246c.isEmpty()) {
                    if (this.f4251d.s()) {
                        this.f4251d.f3831a = null;
                        this.f4251d = null;
                        this.f4250c = tVar.f4246c;
                        this.f4249b &= -2;
                        this.f4251d = k0.alwaysUseFieldBuilders ? d() : null;
                    } else {
                        this.f4251d.b(tVar.f4246c);
                    }
                }
                if (tVar.e()) {
                    this.f4249b |= 2;
                    this.f4252e = tVar.f4247d;
                    onChanged();
                }
                if (tVar.g()) {
                    long j2 = tVar.f4248e;
                    this.f4249b |= 4;
                    this.f = j2;
                    onChanged();
                }
                if (tVar.f()) {
                    long j3 = tVar.f;
                    this.f4249b |= 8;
                    this.g = j3;
                    onChanged();
                }
                if (tVar.d()) {
                    double d2 = tVar.g;
                    this.f4249b |= 16;
                    this.h = d2;
                    onChanged();
                }
                if (tVar.h()) {
                    j jVar = tVar.h;
                    if (jVar != null) {
                        this.f4249b |= 32;
                        this.i = jVar;
                        onChanged();
                    } else {
                        throw null;
                    }
                }
                if (tVar.c()) {
                    this.f4249b |= 64;
                    this.j = tVar.i;
                    onChanged();
                }
                g(tVar.unknownFields);
                onChanged();
                return this;
            }

            public final b g(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return t.k;
            }

            @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
            public s.b getDescriptorForType() {
                return r.P;
            }

            @Override // c.b.d.k0.b
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.Q;
                fVar.c(t.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0.b, c.b.d.i1
            public final boolean isInitialized() {
                c cVar;
                int i2 = 0;
                while (true) {
                    b2<c, c.b, Object> b2Var = this.f4251d;
                    if (i2 >= (b2Var == null ? this.f4250c.size() : b2Var.m())) {
                        return true;
                    }
                    b2<c, c.b, Object> b2Var2 = this.f4251d;
                    if (b2Var2 == null) {
                        cVar = this.f4250c.get(i2);
                    } else {
                        cVar = b2Var2.n(i2, false);
                    }
                    if (!cVar.isInitialized()) {
                        return false;
                    }
                    i2++;
                }
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public a.AbstractC0097a mergeFrom(e1 e1Var) {
                if (e1Var instanceof t) {
                    f((t) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            public b mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m322setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m323setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m324setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            public b(a aVar) {
                if (k0.alwaysUseFieldBuilders) {
                    d();
                }
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.h1.a, c.b.d.e1.a
            /* renamed from: build  reason: collision with other method in class */
            public h1 m314build() {
                t a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m317clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m318getDefaultInstanceForType() {
                return t.k;
            }

            @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public e1.a m319mergeFrom(e1 e1Var) {
                if (e1Var instanceof t) {
                    f((t) e1Var);
                } else {
                    super.mergeFrom(e1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.k0$b' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m321mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b
            public b setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
            public b setUnknownFields(p2 p2Var) {
                return (b) super.setUnknownFields(p2Var);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m316clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.e1$a' to match base method */
            @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m320mergeUnknownFields(p2 p2Var) {
                return (b) super.mergeUnknownFields(p2Var);
            }

            public b(k0.c cVar, a aVar) {
                super(cVar);
                if (k0.alwaysUseFieldBuilders) {
                    d();
                }
            }
        }

        public static final class c extends k0 implements j1 {
            public static final c f = new c();
            @Deprecated
            public static final v1<c> g = new a();

            /* renamed from: b  reason: collision with root package name */
            public int f4253b;

            /* renamed from: c  reason: collision with root package name */
            public volatile Object f4254c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f4255d;

            /* renamed from: e  reason: collision with root package name */
            public byte f4256e;

            public static class a extends c<c> {
                @Override // c.b.d.v1
                public Object parsePartialFrom(k kVar, z zVar) {
                    c cVar = new c();
                    if (zVar != null) {
                        p2.b b2 = p2.b();
                        boolean z = false;
                        while (!z) {
                            try {
                                int G = kVar.G();
                                if (G != 0) {
                                    if (G == 10) {
                                        j n = kVar.n();
                                        cVar.f4253b = 1 | cVar.f4253b;
                                        cVar.f4254c = n;
                                    } else if (G == 16) {
                                        cVar.f4253b |= 2;
                                        cVar.f4255d = kVar.m();
                                    } else if (!cVar.parseUnknownField(kVar, b2, zVar, G)) {
                                    }
                                }
                                z = true;
                            } catch (n0 e2) {
                                e2.f4007b = cVar;
                                throw e2;
                            } catch (IOException e3) {
                                n0 n0Var = new n0(e3);
                                n0Var.f4007b = cVar;
                                throw n0Var;
                            } catch (Throwable th) {
                                cVar.unknownFields = b2.build();
                                cVar.makeExtensionsImmutable();
                                throw th;
                            }
                        }
                        cVar.unknownFields = b2.build();
                        cVar.makeExtensionsImmutable();
                        return cVar;
                    }
                    throw null;
                }
            }

            public static final class b extends k0.b<b> implements Object {

                /* renamed from: b  reason: collision with root package name */
                public int f4257b;

                /* renamed from: c  reason: collision with root package name */
                public Object f4258c = "";

                /* renamed from: d  reason: collision with root package name */
                public boolean f4259d;

                public b() {
                }

                public b(a aVar) {
                }

                /* renamed from: a */
                public c buildPartial() {
                    c cVar = new c(this, null);
                    int i = this.f4257b;
                    int i2 = (i & 1) != 0 ? 1 : 0;
                    cVar.f4254c = this.f4258c;
                    if ((i & 2) != 0) {
                        cVar.f4255d = this.f4259d;
                        i2 |= 2;
                    }
                    cVar.f4253b = i2;
                    onBuilt();
                    return cVar;
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: addRepeatedField  reason: collision with other method in class */
                public b m327addRepeatedField(s.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                public b b() {
                    super.clear();
                    this.f4258c = "";
                    int i = this.f4257b & -2;
                    this.f4257b = i;
                    this.f4259d = false;
                    this.f4257b = i & -3;
                    return this;
                }

                @Override // c.b.d.h1.a, c.b.d.e1.a
                public e1 build() {
                    c a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
                }

                /* renamed from: c */
                public b clone() {
                    return (b) super.clone();
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: clearField  reason: collision with other method in class */
                public b m329clearField(s.g gVar) {
                    return (b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public b clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
                public b d(k kVar, z zVar) {
                    Throwable th;
                    c cVar;
                    c cVar2 = null;
                    try {
                        c parsePartialFrom = c.g.parsePartialFrom(kVar, zVar);
                        if (parsePartialFrom != null) {
                            e(parsePartialFrom);
                        }
                        return this;
                    } catch (n0 e2) {
                        cVar = (c) e2.f4007b;
                        throw e2.j();
                    } catch (Throwable th2) {
                        th = th2;
                        cVar2 = cVar;
                        if (cVar2 != null) {
                        }
                        throw th;
                    }
                }

                public b e(c cVar) {
                    if (cVar == c.f) {
                        return this;
                    }
                    if (cVar.c()) {
                        this.f4257b |= 1;
                        this.f4258c = cVar.f4254c;
                        onChanged();
                    }
                    if (cVar.b()) {
                        boolean z = cVar.f4255d;
                        this.f4257b |= 2;
                        this.f4259d = z;
                        onChanged();
                    }
                    f(cVar.unknownFields);
                    onChanged();
                    return this;
                }

                public final b f(p2 p2Var) {
                    return (b) super.mergeUnknownFields(p2Var);
                }

                @Override // c.b.d.j1, c.b.d.i1
                public e1 getDefaultInstanceForType() {
                    return c.f;
                }

                @Override // c.b.d.k0.b, c.b.d.e1.a, c.b.d.j1
                public s.b getDescriptorForType() {
                    return r.R;
                }

                @Override // c.b.d.k0.b
                public k0.f internalGetFieldAccessorTable() {
                    k0.f fVar = r.S;
                    fVar.c(c.class, b.class);
                    return fVar;
                }

                @Override // c.b.d.k0.b, c.b.d.i1
                public final boolean isInitialized() {
                    if (!((this.f4257b & 1) != 0)) {
                        return false;
                    }
                    return (this.f4257b & 2) != 0;
                }

                @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public a.AbstractC0097a mergeFrom(e1 e1Var) {
                    if (e1Var instanceof c) {
                        e((c) e1Var);
                    } else {
                        super.mergeFrom(e1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                public b mergeUnknownFields(p2 p2Var) {
                    return (b) super.mergeUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: setField  reason: collision with other method in class */
                public b m336setField(s.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b
                /* renamed from: setRepeatedField  reason: collision with other method in class */
                public b m337setRepeatedField(s.g gVar, int i, Object obj) {
                    return (b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                /* renamed from: setUnknownFields  reason: collision with other method in class */
                public b m338setUnknownFields(p2 p2Var) {
                    return (b) super.setUnknownFields(p2Var);
                }

                public b(k0.c cVar, a aVar) {
                    super(cVar);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public b addRepeatedField(s.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                @Override // c.b.d.h1.a, c.b.d.e1.a
                /* renamed from: build  reason: collision with other method in class */
                public h1 m328build() {
                    c a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0097a.newUninitializedMessageException((e1) a2);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public b clearField(s.g gVar) {
                    return (b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public b m331clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                @Override // c.b.d.j1, c.b.d.i1
                /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
                public h1 m332getDefaultInstanceForType() {
                    return c.f;
                }

                @Override // c.b.d.e1.a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeFrom  reason: collision with other method in class */
                public e1.a m333mergeFrom(e1 e1Var) {
                    if (e1Var instanceof c) {
                        e((c) e1Var);
                    } else {
                        super.mergeFrom(e1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.k0$b' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public b m335mergeUnknownFields(p2 p2Var) {
                    return (b) super.mergeUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public b setField(s.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b
                public b setRepeatedField(s.g gVar, int i, Object obj) {
                    return (b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.e1.a
                public b setUnknownFields(p2 p2Var) {
                    return (b) super.setUnknownFields(p2Var);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public b m330clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                /* Return type fixed from 'c.b.d.e1$a' to match base method */
                @Override // c.b.d.k0.b, c.b.d.k0.b, c.b.d.k0.b, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public b m334mergeUnknownFields(p2 p2Var) {
                    return (b) super.mergeUnknownFields(p2Var);
                }
            }

            public c() {
                this.f4256e = -1;
                this.f4254c = "";
            }

            public c(k0.b bVar, a aVar) {
                super(bVar);
                this.f4256e = -1;
            }

            public String a() {
                Object obj = this.f4254c;
                if (obj instanceof String) {
                    return (String) obj;
                }
                j jVar = (j) obj;
                String u = jVar.u();
                if (jVar.o()) {
                    this.f4254c = u;
                }
                return u;
            }

            public boolean b() {
                return (this.f4253b & 2) != 0;
            }

            public boolean c() {
                return (this.f4253b & 1) != 0;
            }

            /* renamed from: d */
            public b toBuilder() {
                if (this == f) {
                    return new b(null);
                }
                b bVar = new b(null);
                bVar.e(this);
                return bVar;
            }

            @Override // c.b.d.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return super.equals(obj);
                }
                c cVar = (c) obj;
                if (c() != cVar.c()) {
                    return false;
                }
                if ((!c() || a().equals(cVar.a())) && b() == cVar.b()) {
                    return (!b() || this.f4255d == cVar.f4255d) && this.unknownFields.equals(cVar.unknownFields);
                }
                return false;
            }

            @Override // c.b.d.j1, c.b.d.i1
            public e1 getDefaultInstanceForType() {
                return f;
            }

            @Override // c.b.d.k0, c.b.d.h1
            public v1<c> getParserForType() {
                return g;
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.f4253b & 1) != 0) {
                    i2 = 0 + k0.computeStringSize(1, this.f4254c);
                }
                if ((this.f4253b & 2) != 0) {
                    i2 += m.c(2, this.f4255d);
                }
                int serializedSize = this.unknownFields.getSerializedSize() + i2;
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // c.b.d.k0, c.b.d.j1
            public final p2 getUnknownFields() {
                return this.unknownFields;
            }

            @Override // c.b.d.a
            public int hashCode() {
                int i = this.memoizedHashCode;
                if (i != 0) {
                    return i;
                }
                int hashCode = r.R.hashCode() + 779;
                if (c()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + a().hashCode();
                }
                if (b()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + m0.c(this.f4255d);
                }
                int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // c.b.d.k0
            public k0.f internalGetFieldAccessorTable() {
                k0.f fVar = r.S;
                fVar.c(c.class, b.class);
                return fVar;
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
            public final boolean isInitialized() {
                byte b2 = this.f4256e;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                if (!c()) {
                    this.f4256e = 0;
                    return false;
                } else if (!b()) {
                    this.f4256e = 0;
                    return false;
                } else {
                    this.f4256e = 1;
                    return true;
                }
            }

            @Override // c.b.d.e1, c.b.d.h1
            public e1.a newBuilderForType() {
                return f.toBuilder();
            }

            @Override // c.b.d.k0
            public Object newInstance(k0.g gVar) {
                return new c();
            }

            @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
            public void writeTo(m mVar) {
                if ((this.f4253b & 1) != 0) {
                    k0.writeString(mVar, 1, this.f4254c);
                }
                if ((this.f4253b & 2) != 0) {
                    mVar.Y(2, this.f4255d);
                }
                this.unknownFields.writeTo(mVar);
            }

            @Override // c.b.d.j1, c.b.d.i1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public h1 m325getDefaultInstanceForType() {
                return f;
            }

            @Override // c.b.d.k0
            public e1.a newBuilderForType(k0.c cVar) {
                return new b(cVar, null);
            }

            @Override // c.b.d.e1, c.b.d.h1
            /* renamed from: newBuilderForType  reason: collision with other method in class */
            public h1.a m326newBuilderForType() {
                return f.toBuilder();
            }
        }

        public t() {
            this.j = -1;
            this.f4246c = Collections.emptyList();
            this.f4247d = "";
            this.h = j.f3914c;
            this.i = "";
        }

        public t(k0.b bVar, a aVar) {
            super(bVar);
            this.j = -1;
        }

        public String a() {
            Object obj = this.i;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.i = u;
            }
            return u;
        }

        public String b() {
            Object obj = this.f4247d;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String u = jVar.u();
            if (jVar.o()) {
                this.f4247d = u;
            }
            return u;
        }

        public boolean c() {
            return (this.f4245b & 32) != 0;
        }

        public boolean d() {
            return (this.f4245b & 8) != 0;
        }

        public boolean e() {
            return (this.f4245b & 1) != 0;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof t)) {
                return super.equals(obj);
            }
            t tVar = (t) obj;
            if (!this.f4246c.equals(tVar.f4246c) || e() != tVar.e()) {
                return false;
            }
            if ((e() && !b().equals(tVar.b())) || g() != tVar.g()) {
                return false;
            }
            if ((g() && this.f4248e != tVar.f4248e) || f() != tVar.f()) {
                return false;
            }
            if ((f() && this.f != tVar.f) || d() != tVar.d()) {
                return false;
            }
            if ((d() && Double.doubleToLongBits(this.g) != Double.doubleToLongBits(tVar.g)) || h() != tVar.h()) {
                return false;
            }
            if ((h() && !this.h.equals(tVar.h)) || c() != tVar.c()) {
                return false;
            }
            if ((!c() || a().equals(tVar.a())) && this.unknownFields.equals(tVar.unknownFields)) {
                return true;
            }
            return false;
        }

        public boolean f() {
            return (this.f4245b & 4) != 0;
        }

        public boolean g() {
            return (this.f4245b & 2) != 0;
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return k;
        }

        @Override // c.b.d.k0, c.b.d.h1
        public v1<t> getParserForType() {
            return l;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.f4246c.size(); i4++) {
                i3 += m.z(2, this.f4246c.get(i4));
            }
            if ((this.f4245b & 1) != 0) {
                i3 += k0.computeStringSize(3, this.f4247d);
            }
            if ((this.f4245b & 2) != 0) {
                i3 += m.Q(4, this.f4248e);
            }
            if ((this.f4245b & 4) != 0) {
                i3 += m.u(5, this.f);
            }
            if ((this.f4245b & 8) != 0) {
                i3 += m.h(6, this.g);
            }
            if ((this.f4245b & 16) != 0) {
                i3 += m.f(7, this.h);
            }
            if ((this.f4245b & 32) != 0) {
                i3 += k0.computeStringSize(8, this.i);
            }
            int serializedSize = this.unknownFields.getSerializedSize() + i3;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.k0, c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean h() {
            return (this.f4245b & 16) != 0;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.P.hashCode() + 779;
            if (this.f4246c.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f4246c.hashCode();
            }
            if (e()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + b().hashCode();
            }
            if (g()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 4, 53) + m0.e(this.f4248e);
            }
            if (f()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 5, 53) + m0.e(this.f);
            }
            if (d()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 6, 53) + m0.e(Double.doubleToLongBits(this.g));
            }
            if (h()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 7, 53) + this.h.hashCode();
            }
            if (c()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 8, 53) + a().hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        /* renamed from: i */
        public b toBuilder() {
            if (this == k) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.f(this);
            return bVar;
        }

        @Override // c.b.d.k0
        public k0.f internalGetFieldAccessorTable() {
            k0.f fVar = r.Q;
            fVar.c(t.class, b.class);
            return fVar;
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
        public final boolean isInitialized() {
            byte b2 = this.j;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.f4246c.size(); i2++) {
                if (!this.f4246c.get(i2).isInitialized()) {
                    this.j = 0;
                    return false;
                }
            }
            this.j = 1;
            return true;
        }

        @Override // c.b.d.e1, c.b.d.h1
        public e1.a newBuilderForType() {
            return k.toBuilder();
        }

        @Override // c.b.d.k0
        public Object newInstance(k0.g gVar) {
            return new t();
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.h1
        public void writeTo(m mVar) {
            for (int i2 = 0; i2 < this.f4246c.size(); i2++) {
                mVar.k0(2, this.f4246c.get(i2));
            }
            if ((this.f4245b & 1) != 0) {
                k0.writeString(mVar, 3, this.f4247d);
            }
            if ((this.f4245b & 2) != 0) {
                mVar.u0(4, this.f4248e);
            }
            if ((this.f4245b & 4) != 0) {
                mVar.u0(5, this.f);
            }
            if ((this.f4245b & 8) != 0) {
                mVar.c0(6, this.g);
            }
            if ((this.f4245b & 16) != 0) {
                mVar.a0(7, this.h);
            }
            if ((this.f4245b & 32) != 0) {
                k0.writeString(mVar, 8, this.i);
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m311getDefaultInstanceForType() {
            return k;
        }

        @Override // c.b.d.k0
        public e1.a newBuilderForType(k0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.e1, c.b.d.h1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public h1.a m312newBuilderForType() {
            return k.toBuilder();
        }
    }

    static {
        s.h o2 = s.h.o(new String[]{"\n google/protobuf/descriptor.proto\u0012\u000fgoogle.protobuf\"G\n\u0011FileDescriptorSet\u00122\n\u0004file\u0018\u0001 \u0003(\u000b2$.google.protobuf.FileDescriptorProto\"Û\u0003\n\u0013FileDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007package\u0018\u0002 \u0001(\t\u0012\u0012\n\ndependency\u0018\u0003 \u0003(\t\u0012\u0019\n\u0011public_dependency\u0018\n \u0003(\u0005\u0012\u0017\n\u000fweak_dependency\u0018\u000b \u0003(\u0005\u00126\n\fmessage_type\u0018\u0004 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0005 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u00128\n\u0007service\u0018\u0006 \u0003(\u000b2'.google.protobuf.ServiceDescriptorProto\u00128\n\textension\u0018\u0007 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u0012-\n\u0007options\u0018\b \u0001(\u000b2\u001c.google.protobuf.FileOptions\u00129\n\u0010source_code_info\u0018\t \u0001(\u000b2\u001f.google.protobuf.SourceCodeInfo\u0012\u000e\n\u0006syntax\u0018\f \u0001(\t\"©\u0005\n\u000fDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00124\n\u0005field\u0018\u0002 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00128\n\textension\u0018\u0006 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00125\n\u000bnested_type\u0018\u0003 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0004 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u0012H\n\u000fextension_range\u0018\u0005 \u0003(\u000b2/.google.protobuf.DescriptorProto.ExtensionRange\u00129\n\noneof_decl\u0018\b \u0003(\u000b2%.google.protobuf.OneofDescriptorProto\u00120\n\u0007options\u0018\u0007 \u0001(\u000b2\u001f.google.protobuf.MessageOptions\u0012F\n\u000ereserved_range\u0018\t \u0003(\u000b2..google.protobuf.DescriptorProto.ReservedRange\u0012\u0015\n\rreserved_name\u0018\n \u0003(\t\u001ae\n\u000eExtensionRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\u00127\n\u0007options\u0018\u0003 \u0001(\u000b2&.google.protobuf.ExtensionRangeOptions\u001a+\n\rReservedRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"g\n\u0015ExtensionRangeOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"¼\u0005\n\u0014FieldDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0003 \u0001(\u0005\u0012:\n\u0005label\u0018\u0004 \u0001(\u000e2+.google.protobuf.FieldDescriptorProto.Label\u00128\n\u0004type\u0018\u0005 \u0001(\u000e2*.google.protobuf.FieldDescriptorProto.Type\u0012\u0011\n\ttype_name\u0018\u0006 \u0001(\t\u0012\u0010\n\bextendee\u0018\u0002 \u0001(\t\u0012\u0015\n\rdefault_value\u0018\u0007 \u0001(\t\u0012\u0013\n\u000boneof_index\u0018\t \u0001(\u0005\u0012\u0011\n\tjson_name\u0018\n \u0001(\t\u0012.\n\u0007options\u0018\b \u0001(\u000b2\u001d.google.protobuf.FieldOptions\"¶\u0002\n\u0004Type\u0012\u000f\n\u000bTYPE_DOUBLE\u0010\u0001\u0012\u000e\n\nTYPE_FLOAT\u0010\u0002\u0012\u000e\n\nTYPE_INT64\u0010\u0003\u0012\u000f\n\u000bTYPE_UINT64\u0010\u0004\u0012\u000e\n\nTYPE_INT32\u0010\u0005\u0012\u0010\n\fTYPE_FIXED64\u0010\u0006\u0012\u0010\n\fTYPE_FIXED32\u0010\u0007\u0012\r\n\tTYPE_BOOL\u0010\b\u0012\u000f\n\u000bTYPE_STRING\u0010\t\u0012\u000e\n\nTYPE_GROUP\u0010\n\u0012\u0010\n\fTYPE_MESSAGE\u0010\u000b\u0012\u000e\n\nTYPE_BYTES\u0010\f\u0012\u000f\n\u000bTYPE_UINT32\u0010\r\u0012\r\n\tTYPE_ENUM\u0010\u000e\u0012\u0011\n\rTYPE_SFIXED32\u0010\u000f\u0012\u0011\n\rTYPE_SFIXED64\u0010\u0010\u0012\u000f\n\u000bTYPE_SINT32\u0010\u0011\u0012\u000f\n\u000bTYPE_SINT64\u0010\u0012\"C\n\u0005Label\u0012\u0012\n\u000eLABEL_OPTIONAL\u0010\u0001\u0012\u0012\n\u000eLABEL_REQUIRED\u0010\u0002\u0012\u0012\n\u000eLABEL_REPEATED\u0010\u0003\"T\n\u0014OneofDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012.\n\u0007options\u0018\u0002 \u0001(\u000b2\u001d.google.protobuf.OneofOptions\"¤\u0002\n\u0013EnumDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00128\n\u0005value\u0018\u0002 \u0003(\u000b2).google.protobuf.EnumValueDescriptorProto\u0012-\n\u0007options\u0018\u0003 \u0001(\u000b2\u001c.google.protobuf.EnumOptions\u0012N\n\u000ereserved_range\u0018\u0004 \u0003(\u000b26.google.protobuf.EnumDescriptorProto.EnumReservedRange\u0012\u0015\n\rreserved_name\u0018\u0005 \u0003(\t\u001a/\n\u0011EnumReservedRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"l\n\u0018EnumValueDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\u0005\u00122\n\u0007options\u0018\u0003 \u0001(\u000b2!.google.protobuf.EnumValueOptions\"\u0001\n\u0016ServiceDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00126\n\u0006method\u0018\u0002 \u0003(\u000b2&.google.protobuf.MethodDescriptorProto\u00120\n\u0007options\u0018\u0003 \u0001(\u000b2\u001f.google.protobuf.ServiceOptions\"Á\u0001\n\u0015MethodDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0012\n\ninput_type\u0018\u0002 \u0001(\t\u0012\u0013\n\u000boutput_type\u0018\u0003 \u0001(\t\u0012/\n\u0007options\u0018\u0004 \u0001(\u000b2\u001e.google.protobuf.MethodOptions\u0012\u001f\n\u0010client_streaming\u0018\u0005 \u0001(\b:\u0005false\u0012\u001f\n\u0010server_streaming\u0018\u0006 \u0001(\b:\u0005false\"¦\u0006\n\u000bFileOptions\u0012\u0014\n\fjava_package\u0018\u0001 \u0001(\t\u0012\u001c\n\u0014java_outer_classname\u0018\b \u0001(\t\u0012\"\n\u0013java_multiple_files\u0018\n \u0001(\b:\u0005false\u0012)\n\u001djava_generate_equals_and_hash\u0018\u0014 \u0001(\bB\u0002\u0018\u0001\u0012%\n\u0016java_string_check_utf8\u0018\u001b \u0001(\b:\u0005false\u0012F\n\foptimize_for\u0018\t \u0001(\u000e2).google.protobuf.FileOptions.OptimizeMode:\u0005SPEED\u0012\u0012\n\ngo_package\u0018\u000b \u0001(\t\u0012\"\n\u0013cc_generic_services\u0018\u0010 \u0001(\b:\u0005false\u0012$\n\u0015java_generic_services\u0018\u0011 \u0001(\b:\u0005false\u0012\"\n\u0013py_generic_services\u0018\u0012 \u0001(\b:\u0005false\u0012#\n\u0014php_generic_services\u0018* \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0017 \u0001(\b:\u0005false\u0012\u001f\n\u0010cc_enable_arenas\u0018\u001f \u0001(\b:\u0005false\u0012\u0019\n\u0011objc_class_prefix\u0018$ \u0001(\t\u0012\u0018\n\u0010csharp_namespace\u0018% \u0001(\t\u0012\u0014\n\fswift_prefix\u0018' \u0001(\t\u0012\u0018\n\u0010php_class_prefix\u0018( \u0001(\t\u0012\u0015\n\rphp_namespace\u0018) \u0001(\t\u0012\u001e\n\u0016php_metadata_namespace\u0018, \u0001(\t\u0012\u0014\n\fruby_package\u0018- \u0001(\t\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\u0012\t\n\u0005SPEED\u0010\u0001\u0012\r\n\tCODE_SIZE\u0010\u0002\u0012\u0010\n\fLITE_RUNTIME\u0010\u0003*\t\bè\u0007\u0010\u0002J\u0004\b&\u0010'\"ò\u0001\n\u000eMessageOptions\u0012&\n\u0017message_set_wire_format\u0018\u0001 \u0001(\b:\u0005false\u0012.\n\u001fno_standard_descriptor_accessor\u0018\u0002 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0011\n\tmap_entry\u0018\u0007 \u0001(\b\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002J\u0004\b\b\u0010\tJ\u0004\b\t\u0010\n\"\u0003\n\fFieldOptions\u0012:\n\u0005ctype\u0018\u0001 \u0001(\u000e2#.google.protobuf.FieldOptions.CType:\u0006STRING\u0012\u000e\n\u0006packed\u0018\u0002 \u0001(\b\u0012?\n\u0006jstype\u0018\u0006 \u0001(\u000e2$.google.protobuf.FieldOptions.JSType:\tJS_NORMAL\u0012\u0013\n\u0004lazy\u0018\u0005 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0013\n\u0004weak\u0018\n \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"/\n\u0005CType\u0012\n\n\u0006STRING\u0010\u0000\u0012\b\n\u0004CORD\u0010\u0001\u0012\u0010\n\fSTRING_PIECE\u0010\u0002\"5\n\u0006JSType\u0012\r\n\tJS_NORMAL\u0010\u0000\u0012\r\n\tJS_STRING\u0010\u0001\u0012\r\n\tJS_NUMBER\u0010\u0002*\t\bè\u0007\u0010\u0002J\u0004\b\u0004\u0010\u0005\"^\n\fOneofOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"\u0001\n\u000bEnumOptions\u0012\u0013\n\u000ballow_alias\u0018\u0002 \u0001(\b\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002J\u0004\b\u0005\u0010\u0006\"}\n\u0010EnumValueOptions\u0012\u0019\n\ndeprecated\u0018\u0001 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"{\n\u000eServiceOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"­\u0002\n\rMethodOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012_\n\u0011idempotency_level\u0018\" \u0001(\u000e2/.google.protobuf.MethodOptions.IdempotencyLevel:\u0013IDEMPOTENCY_UNKNOWN\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"P\n\u0010IdempotencyLevel\u0012\u0017\n\u0013IDEMPOTENCY_UNKNOWN\u0010\u0000\u0012\u0013\n\u000fNO_SIDE_EFFECTS\u0010\u0001\u0012\u000e\n\nIDEMPOTENT\u0010\u0002*\t\bè\u0007\u0010\u0002\"\u0002\n\u0013UninterpretedOption\u0012;\n\u0004name\u0018\u0002 \u0003(\u000b2-.google.protobuf.UninterpretedOption.NamePart\u0012\u0018\n\u0010identifier_value\u0018\u0003 \u0001(\t\u0012\u001a\n\u0012positive_int_value\u0018\u0004 \u0001(\u0004\u0012\u001a\n\u0012negative_int_value\u0018\u0005 \u0001(\u0003\u0012\u0014\n\fdouble_value\u0018\u0006 \u0001(\u0001\u0012\u0014\n\fstring_value\u0018\u0007 \u0001(\f\u0012\u0017\n\u000faggregate_value\u0018\b \u0001(\t\u001a3\n\bNamePart\u0012\u0011\n\tname_part\u0018\u0001 \u0002(\t\u0012\u0014\n\fis_extension\u0018\u0002 \u0002(\b\"Õ\u0001\n\u000eSourceCodeInfo\u0012:\n\blocation\u0018\u0001 \u0003(\u000b2(.google.protobuf.SourceCodeInfo.Location\u001a\u0001\n\bLocation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0010\n\u0004span\u0018\u0002 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0018\n\u0010leading_comments\u0018\u0003 \u0001(\t\u0012\u0019\n\u0011trailing_comments\u0018\u0004 \u0001(\t\u0012!\n\u0019leading_detached_comments\u0018\u0006 \u0003(\t\"§\u0001\n\u0011GeneratedCodeInfo\u0012A\n\nannotation\u0018\u0001 \u0003(\u000b2-.google.protobuf.GeneratedCodeInfo.Annotation\u001aO\n\nAnnotation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0013\n\u000bsource_file\u0018\u0002 \u0001(\t\u0012\r\n\u0005begin\u0018\u0003 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0004 \u0001(\u0005B\u0001\n\u0013com.google.protobufB\u0010DescriptorProtosH\u0001Z>github.com/golang/protobuf/protoc-gen-go/descriptor;descriptorø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001aGoogle.Protobuf.Reflection"}, new s.h[0]);
        Z = o2;
        s.b bVar = o2.k().get(0);
        f4061a = bVar;
        k0.f.a[] aVarArr = new k0.f.a[bVar.n().size()];
        k0.f.c[] cVarArr = new k0.f.c[Collections.unmodifiableList(Arrays.asList(bVar.h)).size()];
        s.b bVar2 = Z.k().get(1);
        f4062b = bVar2;
        f4063c = new k0.f(bVar2, new String[]{"Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo", "Syntax"});
        s.b bVar3 = Z.k().get(2);
        f4064d = bVar3;
        f4065e = new k0.f(bVar3, new String[]{"Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "OneofDecl", "Options", "ReservedRange", "ReservedName"});
        s.b bVar4 = f4064d.o().get(0);
        f = bVar4;
        g = new k0.f(bVar4, new String[]{"Start", "End", "Options"});
        s.b bVar5 = f4064d.o().get(1);
        h = bVar5;
        i = new k0.f(bVar5, new String[]{"Start", "End"});
        s.b bVar6 = Z.k().get(3);
        j = bVar6;
        k = new k0.f(bVar6, new String[]{"UninterpretedOption"});
        s.b bVar7 = Z.k().get(4);
        l = bVar7;
        m = new k0.f(bVar7, new String[]{"Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "OneofIndex", "JsonName", "Options"});
        s.b bVar8 = Z.k().get(5);
        n = bVar8;
        o = new k0.f(bVar8, new String[]{"Name", "Options"});
        s.b bVar9 = Z.k().get(6);
        p = bVar9;
        q = new k0.f(bVar9, new String[]{"Name", "Value", "Options", "ReservedRange", "ReservedName"});
        s.b bVar10 = p.o().get(0);
        r = bVar10;
        s = new k0.f(bVar10, new String[]{"Start", "End"});
        s.b bVar11 = Z.k().get(7);
        t = bVar11;
        u = new k0.f(bVar11, new String[]{"Name", "Number", "Options"});
        s.b bVar12 = Z.k().get(8);
        v = bVar12;
        w = new k0.f(bVar12, new String[]{"Name", "Method", "Options"});
        s.b bVar13 = Z.k().get(9);
        x = bVar13;
        y = new k0.f(bVar13, new String[]{"Name", "InputType", "OutputType", "Options", "ClientStreaming", "ServerStreaming"});
        s.b bVar14 = Z.k().get(10);
        z = bVar14;
        A = new k0.f(bVar14, new String[]{"JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "JavaStringCheckUtf8", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "PhpGenericServices", "Deprecated", "CcEnableArenas", "ObjcClassPrefix", "CsharpNamespace", "SwiftPrefix", "PhpClassPrefix", "PhpNamespace", "PhpMetadataNamespace", "RubyPackage", "UninterpretedOption"});
        s.b bVar15 = Z.k().get(11);
        B = bVar15;
        C = new k0.f(bVar15, new String[]{"MessageSetWireFormat", "NoStandardDescriptorAccessor", "Deprecated", "MapEntry", "UninterpretedOption"});
        s.b bVar16 = Z.k().get(12);
        D = bVar16;
        E = new k0.f(bVar16, new String[]{"Ctype", "Packed", "Jstype", "Lazy", "Deprecated", "Weak", "UninterpretedOption"});
        s.b bVar17 = Z.k().get(13);
        F = bVar17;
        G = new k0.f(bVar17, new String[]{"UninterpretedOption"});
        s.b bVar18 = Z.k().get(14);
        H = bVar18;
        I = new k0.f(bVar18, new String[]{"AllowAlias", "Deprecated", "UninterpretedOption"});
        s.b bVar19 = Z.k().get(15);
        J = bVar19;
        K = new k0.f(bVar19, new String[]{"Deprecated", "UninterpretedOption"});
        s.b bVar20 = Z.k().get(16);
        L = bVar20;
        M = new k0.f(bVar20, new String[]{"Deprecated", "UninterpretedOption"});
        s.b bVar21 = Z.k().get(17);
        N = bVar21;
        O = new k0.f(bVar21, new String[]{"Deprecated", "IdempotencyLevel", "UninterpretedOption"});
        s.b bVar22 = Z.k().get(18);
        P = bVar22;
        Q = new k0.f(bVar22, new String[]{"Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"});
        s.b bVar23 = P.o().get(0);
        R = bVar23;
        S = new k0.f(bVar23, new String[]{"NamePart", "IsExtension"});
        s.b bVar24 = Z.k().get(19);
        T = bVar24;
        U = new k0.f(bVar24, new String[]{"Location"});
        s.b bVar25 = T.o().get(0);
        V = bVar25;
        W = new k0.f(bVar25, new String[]{"Path", "Span", "LeadingComments", "TrailingComments", "LeadingDetachedComments"});
        s.b bVar26 = Z.k().get(20);
        X = bVar26;
        k0.f.a[] aVarArr2 = new k0.f.a[bVar26.n().size()];
        k0.f.c[] cVarArr2 = new k0.f.c[Collections.unmodifiableList(Arrays.asList(bVar26.h)).size()];
        s.b bVar27 = X.o().get(0);
        Y = bVar27;
        k0.f.a[] aVarArr3 = new k0.f.a[bVar27.n().size()];
        k0.f.c[] cVarArr3 = new k0.f.c[Collections.unmodifiableList(Arrays.asList(bVar27.h)).size()];
    }
}
