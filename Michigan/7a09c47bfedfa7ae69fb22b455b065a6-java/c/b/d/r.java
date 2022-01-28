package c.b.d;

import androidx.recyclerview.widget.RecyclerView;
import c.b.d.a;
import c.b.d.f1;
import c.b.d.i1;
import c.b.d.l0;
import c.b.d.n0;
import c.b.d.q2;
import c.b.d.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class r {
    public static final l0.f A;
    public static final s.b B;
    public static final l0.f C;
    public static final s.b D;
    public static final l0.f E;
    public static final s.b F;
    public static final l0.f G;
    public static final s.b H;
    public static final l0.f I;
    public static final s.b J;
    public static final l0.f K;
    public static final s.b L;
    public static final l0.f M;
    public static final s.b N;
    public static final l0.f O;
    public static final s.b P;
    public static final l0.f Q;
    public static final s.b R;
    public static final l0.f S;
    public static final s.b T;
    public static final l0.f U;
    public static final s.b V;
    public static final l0.f W;
    public static final s.b X;
    public static final s.b Y;
    public static s.h Z;

    /* renamed from: a  reason: collision with root package name */
    public static final s.b f5495a;

    /* renamed from: b  reason: collision with root package name */
    public static final s.b f5496b;

    /* renamed from: c  reason: collision with root package name */
    public static final l0.f f5497c;

    /* renamed from: d  reason: collision with root package name */
    public static final s.b f5498d;

    /* renamed from: e  reason: collision with root package name */
    public static final l0.f f5499e;

    /* renamed from: f  reason: collision with root package name */
    public static final s.b f5500f;

    /* renamed from: g  reason: collision with root package name */
    public static final l0.f f5501g;
    public static final s.b h;
    public static final l0.f i;
    public static final s.b j;
    public static final l0.f k;
    public static final s.b l;
    public static final l0.f m;
    public static final s.b n;
    public static final l0.f o;
    public static final s.b p;
    public static final l0.f q;
    public static final s.b r;
    public static final l0.f s;
    public static final s.b t;
    public static final l0.f u;
    public static final s.b v;
    public static final l0.f w;
    public static final s.b x;
    public static final l0.f y;
    public static final s.b z;

    public static final class b extends l0 implements k1 {
        public static final b n = new b();
        @Deprecated
        public static final w1<b> o = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f5502b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f5503c;

        /* renamed from: d  reason: collision with root package name */
        public List<h> f5504d;

        /* renamed from: e  reason: collision with root package name */
        public List<h> f5505e;

        /* renamed from: f  reason: collision with root package name */
        public List<b> f5506f;

        /* renamed from: g  reason: collision with root package name */
        public List<c> f5507g;
        public List<c> h;
        public List<o> i;
        public l j;
        public List<d> k;
        public t0 l;
        public byte m;

        public static class a extends c<b> {
            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                Object obj;
                List list;
                b bVar = new b();
                if (zVar != null) {
                    q2.b b2 = q2.b();
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
                                    bVar.f5502b = 1 | bVar.f5502b;
                                    bVar.f5503c = n;
                                    break;
                                case 18:
                                    if (!z2 || !true) {
                                        bVar.f5504d = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = bVar.f5504d;
                                    obj = h.o;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 26:
                                    if (!z2 || !true) {
                                        bVar.f5506f = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = bVar.f5506f;
                                    obj = b.o;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 34:
                                    if (!z2 || !true) {
                                        bVar.f5507g = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = bVar.f5507g;
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
                                        bVar.f5505e = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = bVar.f5505e;
                                    obj = h.o;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 58:
                                    l.b j = (bVar.f5502b & 2) != 0 ? bVar.j.toBuilder() : null;
                                    l lVar = (l) kVar.w(l.k, zVar);
                                    bVar.j = lVar;
                                    if (j != null) {
                                        j.o(lVar);
                                        bVar.j = j.buildPartial();
                                    }
                                    bVar.f5502b |= 2;
                                    break;
                                case 66:
                                    if (!z2 || !true) {
                                        bVar.i = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = bVar.i;
                                    obj = o.f5700g;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 74:
                                    if (!z2 || !true) {
                                        bVar.k = new ArrayList();
                                        z2 |= true;
                                    }
                                    list = bVar.k;
                                    obj = d.f5526g;
                                    list.add(kVar.w(obj, zVar));
                                    break;
                                case 82:
                                    j n2 = kVar.n();
                                    if (!z2 || !true) {
                                        bVar.l = new s0(10);
                                        z2 |= true;
                                    }
                                    bVar.l.D(n2);
                                    break;
                                default:
                                    if (bVar.parseUnknownField(kVar, b2, zVar, G)) {
                                        break;
                                    }
                                    z = true;
                                    break;
                            }
                        } catch (o0 e2) {
                            e2.f5447b = bVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = bVar;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                bVar.f5504d = Collections.unmodifiableList(bVar.f5504d);
                            }
                            if (z2 && true) {
                                bVar.f5506f = Collections.unmodifiableList(bVar.f5506f);
                            }
                            if (z2 && true) {
                                bVar.f5507g = Collections.unmodifiableList(bVar.f5507g);
                            }
                            if (z2 && true) {
                                bVar.h = Collections.unmodifiableList(bVar.h);
                            }
                            if (z2 && true) {
                                bVar.f5505e = Collections.unmodifiableList(bVar.f5505e);
                            }
                            if (z2 && true) {
                                bVar.i = Collections.unmodifiableList(bVar.i);
                            }
                            if (z2 && true) {
                                bVar.k = Collections.unmodifiableList(bVar.k);
                            }
                            if (z2 && true) {
                                bVar.l = bVar.l.d();
                            }
                            bVar.unknownFields = b2.build();
                            bVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        bVar.f5504d = Collections.unmodifiableList(bVar.f5504d);
                    }
                    if (z2 && true) {
                        bVar.f5506f = Collections.unmodifiableList(bVar.f5506f);
                    }
                    if (z2 && true) {
                        bVar.f5507g = Collections.unmodifiableList(bVar.f5507g);
                    }
                    if (z2 && true) {
                        bVar.h = Collections.unmodifiableList(bVar.h);
                    }
                    if (z2 && true) {
                        bVar.f5505e = Collections.unmodifiableList(bVar.f5505e);
                    }
                    if (z2 && true) {
                        bVar.i = Collections.unmodifiableList(bVar.i);
                    }
                    if (z2 && true) {
                        bVar.k = Collections.unmodifiableList(bVar.k);
                    }
                    if (z2 && true) {
                        bVar.l = bVar.l.d();
                    }
                    bVar.unknownFields = b2.build();
                    bVar.makeExtensionsImmutable();
                    return bVar;
                }
                throw null;
            }
        }

        /* renamed from: c.b.d.r$b$b  reason: collision with other inner class name */
        public static final class C0111b extends l0.b<C0111b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f5508b;

            /* renamed from: c  reason: collision with root package name */
            public Object f5509c = "";

            /* renamed from: d  reason: collision with root package name */
            public List<h> f5510d = Collections.emptyList();

            /* renamed from: e  reason: collision with root package name */
            public c2<h, h.b, Object> f5511e;

            /* renamed from: f  reason: collision with root package name */
            public List<h> f5512f = Collections.emptyList();

            /* renamed from: g  reason: collision with root package name */
            public c2<h, h.b, Object> f5513g;
            public List<b> h = Collections.emptyList();
            public c2<b, C0111b, Object> i;
            public List<c> j = Collections.emptyList();
            public c2<c, c.b, Object> k;
            public List<c> l = Collections.emptyList();
            public c2<c, c.C0112b, Object> m;
            public List<o> n = Collections.emptyList();
            public c2<o, o.b, Object> o;
            public l p;
            public g2<l, l.b, Object> q;
            public List<d> r = Collections.emptyList();
            public c2<d, d.C0113b, Object> s;
            public t0 t = s0.f5863e;

            public C0111b() {
                maybeForceBuilderInitialization();
            }

            public C0111b(a aVar) {
                maybeForceBuilderInitialization();
            }

            /* renamed from: a */
            public b build() {
                b b2 = buildPartial();
                if (b2.isInitialized()) {
                    return b2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) b2);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public C0111b m9addRepeatedField(s.g gVar, Object obj) {
                return (C0111b) super.addRepeatedField(gVar, obj);
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
                int i2 = this.f5508b;
                int i3 = (i2 & 1) != 0 ? 1 : 0;
                bVar.f5503c = this.f5509c;
                c2<h, h.b, Object> c2Var = this.f5511e;
                if (c2Var == null) {
                    if ((this.f5508b & 2) != 0) {
                        this.f5510d = Collections.unmodifiableList(this.f5510d);
                        this.f5508b &= -3;
                    }
                    list = this.f5510d;
                } else {
                    list = c2Var.g();
                }
                bVar.f5504d = list;
                c2<h, h.b, Object> c2Var2 = this.f5513g;
                if (c2Var2 == null) {
                    if ((this.f5508b & 4) != 0) {
                        this.f5512f = Collections.unmodifiableList(this.f5512f);
                        this.f5508b &= -5;
                    }
                    list2 = this.f5512f;
                } else {
                    list2 = c2Var2.g();
                }
                bVar.f5505e = list2;
                c2<b, C0111b, Object> c2Var3 = this.i;
                if (c2Var3 == null) {
                    if ((this.f5508b & 8) != 0) {
                        this.h = Collections.unmodifiableList(this.h);
                        this.f5508b &= -9;
                    }
                    list3 = this.h;
                } else {
                    list3 = c2Var3.g();
                }
                bVar.f5506f = list3;
                c2<c, c.b, Object> c2Var4 = this.k;
                if (c2Var4 == null) {
                    if ((this.f5508b & 16) != 0) {
                        this.j = Collections.unmodifiableList(this.j);
                        this.f5508b &= -17;
                    }
                    list4 = this.j;
                } else {
                    list4 = c2Var4.g();
                }
                bVar.f5507g = list4;
                c2<c, c.C0112b, Object> c2Var5 = this.m;
                if (c2Var5 == null) {
                    if ((this.f5508b & 32) != 0) {
                        this.l = Collections.unmodifiableList(this.l);
                        this.f5508b &= -33;
                    }
                    list5 = this.l;
                } else {
                    list5 = c2Var5.g();
                }
                bVar.h = list5;
                c2<o, o.b, Object> c2Var6 = this.o;
                if (c2Var6 == null) {
                    if ((this.f5508b & 64) != 0) {
                        this.n = Collections.unmodifiableList(this.n);
                        this.f5508b &= -65;
                    }
                    list6 = this.n;
                } else {
                    list6 = c2Var6.g();
                }
                bVar.i = list6;
                if ((i2 & RecyclerView.a0.FLAG_IGNORE) != 0) {
                    g2<l, l.b, Object> g2Var = this.q;
                    bVar.j = g2Var == null ? this.p : g2Var.b();
                    i3 |= 2;
                }
                c2<d, d.C0113b, Object> c2Var7 = this.s;
                if (c2Var7 == null) {
                    if ((this.f5508b & RecyclerView.a0.FLAG_TMP_DETACHED) != 0) {
                        this.r = Collections.unmodifiableList(this.r);
                        this.f5508b &= -257;
                    }
                    list7 = this.r;
                } else {
                    list7 = c2Var7.g();
                }
                bVar.k = list7;
                if ((this.f5508b & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                    this.t = this.t.d();
                    this.f5508b &= -513;
                }
                bVar.l = this.t;
                bVar.f5502b = i3;
                onBuilt();
                return bVar;
            }

            public C0111b c() {
                super.clear();
                this.f5509c = "";
                this.f5508b &= -2;
                c2<h, h.b, Object> c2Var = this.f5511e;
                if (c2Var == null) {
                    this.f5510d = Collections.emptyList();
                    this.f5508b &= -3;
                } else {
                    c2Var.h();
                }
                c2<h, h.b, Object> c2Var2 = this.f5513g;
                if (c2Var2 == null) {
                    this.f5512f = Collections.emptyList();
                    this.f5508b &= -5;
                } else {
                    c2Var2.h();
                }
                c2<b, C0111b, Object> c2Var3 = this.i;
                if (c2Var3 == null) {
                    this.h = Collections.emptyList();
                    this.f5508b &= -9;
                } else {
                    c2Var3.h();
                }
                c2<c, c.b, Object> c2Var4 = this.k;
                if (c2Var4 == null) {
                    this.j = Collections.emptyList();
                    this.f5508b &= -17;
                } else {
                    c2Var4.h();
                }
                c2<c, c.C0112b, Object> c2Var5 = this.m;
                if (c2Var5 == null) {
                    this.l = Collections.emptyList();
                    this.f5508b &= -33;
                } else {
                    c2Var5.h();
                }
                c2<o, o.b, Object> c2Var6 = this.o;
                if (c2Var6 == null) {
                    this.n = Collections.emptyList();
                    this.f5508b &= -65;
                } else {
                    c2Var6.h();
                }
                g2<l, l.b, Object> g2Var = this.q;
                if (g2Var == null) {
                    this.p = null;
                } else {
                    g2Var.c();
                }
                this.f5508b &= -129;
                c2<d, d.C0113b, Object> c2Var7 = this.s;
                if (c2Var7 == null) {
                    this.r = Collections.emptyList();
                    this.f5508b &= -257;
                } else {
                    c2Var7.h();
                }
                this.t = s0.f5863e;
                this.f5508b &= -513;
                return this;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public C0111b m10clearField(s.g gVar) {
                return (C0111b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public C0111b clearOneof(s.k kVar) {
                return (C0111b) super.clearOneof(kVar);
            }

            /* renamed from: d */
            public C0111b clone() {
                return (C0111b) super.clone();
            }

            public final void e() {
                if ((this.f5508b & 32) == 0) {
                    this.l = new ArrayList(this.l);
                    this.f5508b |= 32;
                }
            }

            public final c2<c, c.b, Object> f() {
                if (this.k == null) {
                    this.k = new c2<>(this.j, (this.f5508b & 16) != 0, getParentForChildren(), isClean());
                    this.j = null;
                }
                return this.k;
            }

            public final c2<h, h.b, Object> g() {
                if (this.f5513g == null) {
                    this.f5513g = new c2<>(this.f5512f, (this.f5508b & 4) != 0, getParentForChildren(), isClean());
                    this.f5512f = null;
                }
                return this.f5513g;
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return b.n;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.f5498d;
            }

            public final c2<c, c.C0112b, Object> h() {
                if (this.m == null) {
                    this.m = new c2<>(this.l, (this.f5508b & 32) != 0, getParentForChildren(), isClean());
                    this.l = null;
                }
                return this.m;
            }

            public final c2<h, h.b, Object> i() {
                if (this.f5511e == null) {
                    this.f5511e = new c2<>(this.f5510d, (this.f5508b & 2) != 0, getParentForChildren(), isClean());
                    this.f5510d = null;
                }
                return this.f5511e;
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.f5499e;
                fVar.c(b.class, C0111b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.j1
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
                    c2<h, h.b, Object> c2Var = this.f5511e;
                    if (i2 < (c2Var == null ? this.f5510d.size() : c2Var.m())) {
                        c2<h, h.b, Object> c2Var2 = this.f5511e;
                        if (c2Var2 == null) {
                            hVar2 = this.f5510d.get(i2);
                        } else {
                            hVar2 = c2Var2.n(i2, false);
                        }
                        if (!hVar2.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else {
                        int i3 = 0;
                        while (true) {
                            c2<h, h.b, Object> c2Var3 = this.f5513g;
                            if (i3 < (c2Var3 == null ? this.f5512f.size() : c2Var3.m())) {
                                c2<h, h.b, Object> c2Var4 = this.f5513g;
                                if (c2Var4 == null) {
                                    hVar = this.f5512f.get(i3);
                                } else {
                                    hVar = c2Var4.n(i3, false);
                                }
                                if (!hVar.isInitialized()) {
                                    return false;
                                }
                                i3++;
                            } else {
                                int i4 = 0;
                                while (true) {
                                    c2<b, C0111b, Object> c2Var5 = this.i;
                                    if (i4 < (c2Var5 == null ? this.h.size() : c2Var5.m())) {
                                        c2<b, C0111b, Object> c2Var6 = this.i;
                                        if (c2Var6 == null) {
                                            bVar = this.h.get(i4);
                                        } else {
                                            bVar = c2Var6.n(i4, false);
                                        }
                                        if (!bVar.isInitialized()) {
                                            return false;
                                        }
                                        i4++;
                                    } else {
                                        int i5 = 0;
                                        while (true) {
                                            c2<c, c.b, Object> c2Var7 = this.k;
                                            if (i5 < (c2Var7 == null ? this.j.size() : c2Var7.m())) {
                                                c2<c, c.b, Object> c2Var8 = this.k;
                                                if (c2Var8 == null) {
                                                    cVar2 = this.j.get(i5);
                                                } else {
                                                    cVar2 = c2Var8.n(i5, false);
                                                }
                                                if (!cVar2.isInitialized()) {
                                                    return false;
                                                }
                                                i5++;
                                            } else {
                                                int i6 = 0;
                                                while (true) {
                                                    c2<c, c.C0112b, Object> c2Var9 = this.m;
                                                    if (i6 < (c2Var9 == null ? this.l.size() : c2Var9.m())) {
                                                        c2<c, c.C0112b, Object> c2Var10 = this.m;
                                                        if (c2Var10 == null) {
                                                            cVar = this.l.get(i6);
                                                        } else {
                                                            cVar = c2Var10.n(i6, false);
                                                        }
                                                        if (!cVar.isInitialized()) {
                                                            return false;
                                                        }
                                                        i6++;
                                                    } else {
                                                        int i7 = 0;
                                                        while (true) {
                                                            c2<o, o.b, Object> c2Var11 = this.o;
                                                            if (i7 < (c2Var11 == null ? this.n.size() : c2Var11.m())) {
                                                                c2<o, o.b, Object> c2Var12 = this.o;
                                                                if (c2Var12 == null) {
                                                                    oVar = this.n.get(i7);
                                                                } else {
                                                                    oVar = c2Var12.n(i7, false);
                                                                }
                                                                if (!oVar.isInitialized()) {
                                                                    return false;
                                                                }
                                                                i7++;
                                                            } else {
                                                                if ((this.f5508b & RecyclerView.a0.FLAG_IGNORE) != 0) {
                                                                    g2<l, l.b, Object> g2Var = this.q;
                                                                    if (g2Var == null) {
                                                                        lVar = this.p;
                                                                        if (lVar == null) {
                                                                            lVar = l.j;
                                                                        }
                                                                    } else {
                                                                        lVar = g2Var.e();
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

            public final c2<b, C0111b, Object> j() {
                if (this.i == null) {
                    this.i = new c2<>(this.h, (this.f5508b & 8) != 0, getParentForChildren(), isClean());
                    this.h = null;
                }
                return this.i;
            }

            public final c2<o, o.b, Object> k() {
                if (this.o == null) {
                    this.o = new c2<>(this.n, (this.f5508b & 64) != 0, getParentForChildren(), isClean());
                    this.n = null;
                }
                return this.o;
            }

            public final c2<d, d.C0113b, Object> l() {
                if (this.s == null) {
                    this.s = new c2<>(this.r, (this.f5508b & RecyclerView.a0.FLAG_TMP_DETACHED) != 0, getParentForChildren(), isClean());
                    this.r = null;
                }
                return this.s;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            /* renamed from: m */
            public C0111b mergeFrom(k kVar, z zVar) {
                Throwable th;
                b bVar;
                b bVar2 = null;
                try {
                    b parsePartialFrom = b.o.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        n(parsePartialFrom);
                    }
                    return this;
                } catch (o0 e2) {
                    bVar = (b) e2.f5447b;
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
                if (l0.alwaysUseFieldBuilders) {
                    i();
                    g();
                    j();
                    f();
                    h();
                    k();
                    g2<l, l.b, Object> g2Var = this.q;
                    if (g2Var == null) {
                        if (g2Var == null) {
                            lVar = this.p;
                            if (lVar == null) {
                                lVar = l.j;
                            }
                        } else {
                            lVar = g2Var.e();
                        }
                        this.q = new g2<>(lVar, getParentForChildren(), isClean());
                        this.p = null;
                    }
                    l();
                }
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof b) {
                    n((b) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public C0111b mergeUnknownFields(q2 q2Var) {
                return (C0111b) super.mergeUnknownFields(q2Var);
            }

            public C0111b n(b bVar) {
                l lVar;
                l lVar2;
                if (bVar == b.n) {
                    return this;
                }
                if (bVar.h()) {
                    this.f5508b |= 1;
                    this.f5509c = bVar.f5503c;
                    onChanged();
                }
                c2<d, d.C0113b, Object> c2Var = null;
                if (this.f5511e == null) {
                    if (!bVar.f5504d.isEmpty()) {
                        if (this.f5510d.isEmpty()) {
                            this.f5510d = bVar.f5504d;
                            this.f5508b &= -3;
                        } else {
                            if ((this.f5508b & 2) == 0) {
                                this.f5510d = new ArrayList(this.f5510d);
                                this.f5508b |= 2;
                            }
                            this.f5510d.addAll(bVar.f5504d);
                        }
                        onChanged();
                    }
                } else if (!bVar.f5504d.isEmpty()) {
                    if (this.f5511e.s()) {
                        this.f5511e.f5234a = null;
                        this.f5511e = null;
                        this.f5510d = bVar.f5504d;
                        this.f5508b &= -3;
                        this.f5511e = l0.alwaysUseFieldBuilders ? i() : null;
                    } else {
                        this.f5511e.b(bVar.f5504d);
                    }
                }
                if (this.f5513g == null) {
                    if (!bVar.f5505e.isEmpty()) {
                        if (this.f5512f.isEmpty()) {
                            this.f5512f = bVar.f5505e;
                            this.f5508b &= -5;
                        } else {
                            if ((this.f5508b & 4) == 0) {
                                this.f5512f = new ArrayList(this.f5512f);
                                this.f5508b |= 4;
                            }
                            this.f5512f.addAll(bVar.f5505e);
                        }
                        onChanged();
                    }
                } else if (!bVar.f5505e.isEmpty()) {
                    if (this.f5513g.s()) {
                        this.f5513g.f5234a = null;
                        this.f5513g = null;
                        this.f5512f = bVar.f5505e;
                        this.f5508b &= -5;
                        this.f5513g = l0.alwaysUseFieldBuilders ? g() : null;
                    } else {
                        this.f5513g.b(bVar.f5505e);
                    }
                }
                if (this.i == null) {
                    if (!bVar.f5506f.isEmpty()) {
                        if (this.h.isEmpty()) {
                            this.h = bVar.f5506f;
                            this.f5508b &= -9;
                        } else {
                            if ((this.f5508b & 8) == 0) {
                                this.h = new ArrayList(this.h);
                                this.f5508b |= 8;
                            }
                            this.h.addAll(bVar.f5506f);
                        }
                        onChanged();
                    }
                } else if (!bVar.f5506f.isEmpty()) {
                    if (this.i.s()) {
                        this.i.f5234a = null;
                        this.i = null;
                        this.h = bVar.f5506f;
                        this.f5508b &= -9;
                        this.i = l0.alwaysUseFieldBuilders ? j() : null;
                    } else {
                        this.i.b(bVar.f5506f);
                    }
                }
                if (this.k == null) {
                    if (!bVar.f5507g.isEmpty()) {
                        if (this.j.isEmpty()) {
                            this.j = bVar.f5507g;
                            this.f5508b &= -17;
                        } else {
                            if ((this.f5508b & 16) == 0) {
                                this.j = new ArrayList(this.j);
                                this.f5508b |= 16;
                            }
                            this.j.addAll(bVar.f5507g);
                        }
                        onChanged();
                    }
                } else if (!bVar.f5507g.isEmpty()) {
                    if (this.k.s()) {
                        this.k.f5234a = null;
                        this.k = null;
                        this.j = bVar.f5507g;
                        this.f5508b &= -17;
                        this.k = l0.alwaysUseFieldBuilders ? f() : null;
                    } else {
                        this.k.b(bVar.f5507g);
                    }
                }
                if (this.m == null) {
                    if (!bVar.h.isEmpty()) {
                        if (this.l.isEmpty()) {
                            this.l = bVar.h;
                            this.f5508b &= -33;
                        } else {
                            e();
                            this.l.addAll(bVar.h);
                        }
                        onChanged();
                    }
                } else if (!bVar.h.isEmpty()) {
                    if (this.m.s()) {
                        this.m.f5234a = null;
                        this.m = null;
                        this.l = bVar.h;
                        this.f5508b &= -33;
                        this.m = l0.alwaysUseFieldBuilders ? h() : null;
                    } else {
                        this.m.b(bVar.h);
                    }
                }
                if (this.o == null) {
                    if (!bVar.i.isEmpty()) {
                        if (this.n.isEmpty()) {
                            this.n = bVar.i;
                            this.f5508b &= -65;
                        } else {
                            if ((this.f5508b & 64) == 0) {
                                this.n = new ArrayList(this.n);
                                this.f5508b |= 64;
                            }
                            this.n.addAll(bVar.i);
                        }
                        onChanged();
                    }
                } else if (!bVar.i.isEmpty()) {
                    if (this.o.s()) {
                        this.o.f5234a = null;
                        this.o = null;
                        this.n = bVar.i;
                        this.f5508b &= -65;
                        this.o = l0.alwaysUseFieldBuilders ? k() : null;
                    } else {
                        this.o.b(bVar.i);
                    }
                }
                if (bVar.i()) {
                    l g2 = bVar.g();
                    g2<l, l.b, Object> g2Var = this.q;
                    if (g2Var == null) {
                        if (!((this.f5508b & RecyclerView.a0.FLAG_IGNORE) == 0 || (lVar = this.p) == null || lVar == (lVar2 = l.j))) {
                            l.b j2 = lVar2.toBuilder();
                            j2.o(lVar);
                            j2.o(g2);
                            g2 = j2.buildPartial();
                        }
                        this.p = g2;
                        onChanged();
                    } else {
                        g2Var.f(g2);
                    }
                    this.f5508b |= RecyclerView.a0.FLAG_IGNORE;
                }
                if (this.s == null) {
                    if (!bVar.k.isEmpty()) {
                        if (this.r.isEmpty()) {
                            this.r = bVar.k;
                            this.f5508b &= -257;
                        } else {
                            if ((this.f5508b & RecyclerView.a0.FLAG_TMP_DETACHED) == 0) {
                                this.r = new ArrayList(this.r);
                                this.f5508b |= RecyclerView.a0.FLAG_TMP_DETACHED;
                            }
                            this.r.addAll(bVar.k);
                        }
                        onChanged();
                    }
                } else if (!bVar.k.isEmpty()) {
                    if (this.s.s()) {
                        this.s.f5234a = null;
                        this.s = null;
                        this.r = bVar.k;
                        this.f5508b &= -257;
                        if (l0.alwaysUseFieldBuilders) {
                            c2Var = l();
                        }
                        this.s = c2Var;
                    } else {
                        this.s.b(bVar.k);
                    }
                }
                if (!bVar.l.isEmpty()) {
                    if (this.t.isEmpty()) {
                        this.t = bVar.l;
                        this.f5508b &= -513;
                    } else {
                        if ((this.f5508b & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0) {
                            this.t = new s0(this.t);
                            this.f5508b |= RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN;
                        }
                        this.t.addAll(bVar.l);
                    }
                    onChanged();
                }
                o(bVar.unknownFields);
                onChanged();
                return this;
            }

            public final C0111b o(q2 q2Var) {
                return (C0111b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public C0111b m17setField(s.g gVar, Object obj) {
                return (C0111b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public C0111b m18setRepeatedField(s.g gVar, int i2, Object obj) {
                return (C0111b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public C0111b m19setUnknownFields(q2 q2Var) {
                return (C0111b) super.setUnknownFields(q2Var);
            }

            public C0111b(l0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public C0111b addRepeatedField(s.g gVar, Object obj) {
                return (C0111b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public C0111b clearField(s.g gVar) {
                return (C0111b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public C0111b m12clearOneof(s.k kVar) {
                return (C0111b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m13getDefaultInstanceForType() {
                return b.n;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m14mergeFrom(f1 f1Var) {
                if (f1Var instanceof b) {
                    n((b) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public C0111b m16mergeUnknownFields(q2 q2Var) {
                return (C0111b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public C0111b setField(s.g gVar, Object obj) {
                return (C0111b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            public C0111b setRepeatedField(s.g gVar, int i2, Object obj) {
                return (C0111b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public C0111b setUnknownFields(q2 q2Var) {
                return (C0111b) super.setUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public C0111b m11clearOneof(s.k kVar) {
                return (C0111b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public C0111b m15mergeUnknownFields(q2 q2Var) {
                return (C0111b) super.mergeUnknownFields(q2Var);
            }
        }

        public static final class c extends l0 implements k1 {

            /* renamed from: g  reason: collision with root package name */
            public static final c f5514g = new c();
            @Deprecated
            public static final w1<c> h = new a();

            /* renamed from: b  reason: collision with root package name */
            public int f5515b;

            /* renamed from: c  reason: collision with root package name */
            public int f5516c;

            /* renamed from: d  reason: collision with root package name */
            public int f5517d;

            /* renamed from: e  reason: collision with root package name */
            public g f5518e;

            /* renamed from: f  reason: collision with root package name */
            public byte f5519f = -1;

            public static class a extends c<c> {
                @Override // c.b.d.w1
                public Object parsePartialFrom(k kVar, z zVar) {
                    c cVar = new c();
                    if (zVar != null) {
                        q2.b b2 = q2.b();
                        boolean z = false;
                        while (!z) {
                            try {
                                int G = kVar.G();
                                if (G != 0) {
                                    if (G == 8) {
                                        cVar.f5515b |= 1;
                                        cVar.f5516c = kVar.u();
                                    } else if (G == 16) {
                                        cVar.f5515b |= 2;
                                        cVar.f5517d = kVar.u();
                                    } else if (G == 26) {
                                        g.b f2 = (cVar.f5515b & 4) != 0 ? cVar.f5518e.toBuilder() : null;
                                        g gVar = (g) kVar.w(g.f5586f, zVar);
                                        cVar.f5518e = gVar;
                                        if (f2 != null) {
                                            f2.o(gVar);
                                            cVar.f5518e = f2.buildPartial();
                                        }
                                        cVar.f5515b |= 4;
                                    } else if (!cVar.parseUnknownField(kVar, b2, zVar, G)) {
                                    }
                                }
                                z = true;
                            } catch (o0 e2) {
                                e2.f5447b = cVar;
                                throw e2;
                            } catch (IOException e3) {
                                o0 o0Var = new o0(e3);
                                o0Var.f5447b = cVar;
                                throw o0Var;
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
            public static final class C0112b extends l0.b<C0112b> implements Object {

                /* renamed from: b  reason: collision with root package name */
                public int f5520b;

                /* renamed from: c  reason: collision with root package name */
                public int f5521c;

                /* renamed from: d  reason: collision with root package name */
                public int f5522d;

                /* renamed from: e  reason: collision with root package name */
                public g f5523e;

                /* renamed from: f  reason: collision with root package name */
                public g2<g, g.b, Object> f5524f;

                public C0112b() {
                    maybeForceBuilderInitialization();
                }

                public C0112b(a aVar) {
                    maybeForceBuilderInitialization();
                }

                /* renamed from: a */
                public c build() {
                    c b2 = buildPartial();
                    if (b2.isInitialized()) {
                        return b2;
                    }
                    throw a.AbstractC0106a.newUninitializedMessageException((f1) b2);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: addRepeatedField  reason: collision with other method in class */
                public C0112b m22addRepeatedField(s.g gVar, Object obj) {
                    return (C0112b) super.addRepeatedField(gVar, obj);
                }

                /* renamed from: b */
                public c buildPartial() {
                    int i;
                    c cVar = new c(this, null);
                    int i2 = this.f5520b;
                    if ((i2 & 1) != 0) {
                        cVar.f5516c = this.f5521c;
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((i2 & 2) != 0) {
                        cVar.f5517d = this.f5522d;
                        i |= 2;
                    }
                    if ((i2 & 4) != 0) {
                        g2<g, g.b, Object> g2Var = this.f5524f;
                        cVar.f5518e = g2Var == null ? this.f5523e : g2Var.b();
                        i |= 4;
                    }
                    cVar.f5515b = i;
                    onBuilt();
                    return cVar;
                }

                public C0112b c() {
                    super.clear();
                    this.f5521c = 0;
                    int i = this.f5520b & -2;
                    this.f5520b = i;
                    this.f5522d = 0;
                    this.f5520b = i & -3;
                    g2<g, g.b, Object> g2Var = this.f5524f;
                    if (g2Var == null) {
                        this.f5523e = null;
                    } else {
                        g2Var.c();
                    }
                    this.f5520b &= -5;
                    return this;
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: clearField  reason: collision with other method in class */
                public C0112b m23clearField(s.g gVar) {
                    return (C0112b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                public C0112b clearOneof(s.k kVar) {
                    return (C0112b) super.clearOneof(kVar);
                }

                /* renamed from: d */
                public C0112b clone() {
                    return (C0112b) super.clone();
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
                /* renamed from: e */
                public C0112b mergeFrom(k kVar, z zVar) {
                    Throwable th;
                    c cVar;
                    c cVar2 = null;
                    try {
                        c parsePartialFrom = c.h.parsePartialFrom(kVar, zVar);
                        if (parsePartialFrom != null) {
                            f(parsePartialFrom);
                        }
                        return this;
                    } catch (o0 e2) {
                        cVar = (c) e2.f5447b;
                        throw e2.j();
                    } catch (Throwable th2) {
                        th = th2;
                        cVar2 = cVar;
                        if (cVar2 != null) {
                        }
                        throw th;
                    }
                }

                public C0112b f(c cVar) {
                    g gVar;
                    g gVar2;
                    if (cVar == c.f5514g) {
                        return this;
                    }
                    if (cVar.d()) {
                        int i = cVar.f5516c;
                        this.f5520b |= 1;
                        this.f5521c = i;
                        onChanged();
                    }
                    if (cVar.b()) {
                        int i2 = cVar.f5517d;
                        this.f5520b |= 2;
                        this.f5522d = i2;
                        onChanged();
                    }
                    if (cVar.c()) {
                        g a2 = cVar.a();
                        g2<g, g.b, Object> g2Var = this.f5524f;
                        if (g2Var == null) {
                            if (!((this.f5520b & 4) == 0 || (gVar = this.f5523e) == null || gVar == (gVar2 = g.f5585e))) {
                                g.b f2 = gVar2.toBuilder();
                                f2.o(gVar);
                                f2.o(a2);
                                a2 = f2.buildPartial();
                            }
                            this.f5523e = a2;
                            onChanged();
                        } else {
                            g2Var.f(a2);
                        }
                        this.f5520b |= 4;
                    }
                    g(cVar.unknownFields);
                    onChanged();
                    return this;
                }

                public final C0112b g(q2 q2Var) {
                    return (C0112b) super.mergeUnknownFields(q2Var);
                }

                @Override // c.b.d.k1, c.b.d.j1
                public f1 getDefaultInstanceForType() {
                    return c.f5514g;
                }

                @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
                public s.b getDescriptorForType() {
                    return r.f5500f;
                }

                @Override // c.b.d.l0.b
                public l0.f internalGetFieldAccessorTable() {
                    l0.f fVar = r.f5501g;
                    fVar.c(c.class, C0112b.class);
                    return fVar;
                }

                @Override // c.b.d.l0.b, c.b.d.j1
                public final boolean isInitialized() {
                    g gVar;
                    if ((this.f5520b & 4) != 0) {
                        g2<g, g.b, Object> g2Var = this.f5524f;
                        if (g2Var == null) {
                            gVar = this.f5523e;
                            if (gVar == null) {
                                gVar = g.f5585e;
                            }
                        } else {
                            gVar = g2Var.e();
                        }
                        if (!gVar.isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }

                public final void maybeForceBuilderInitialization() {
                    g2<g, g.b, Object> g2Var;
                    g gVar;
                    if (l0.alwaysUseFieldBuilders && (g2Var = this.f5524f) == null) {
                        if (g2Var == null) {
                            gVar = this.f5523e;
                            if (gVar == null) {
                                gVar = g.f5585e;
                            }
                        } else {
                            gVar = g2Var.e();
                        }
                        this.f5524f = new g2<>(gVar, getParentForChildren(), isClean());
                        this.f5523e = null;
                    }
                }

                @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                public a.AbstractC0106a mergeFrom(f1 f1Var) {
                    if (f1Var instanceof c) {
                        f((c) f1Var);
                    } else {
                        super.mergeFrom(f1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                public C0112b mergeUnknownFields(q2 q2Var) {
                    return (C0112b) super.mergeUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: setField  reason: collision with other method in class */
                public C0112b m30setField(s.g gVar, Object obj) {
                    return (C0112b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b
                /* renamed from: setRepeatedField  reason: collision with other method in class */
                public C0112b m31setRepeatedField(s.g gVar, int i, Object obj) {
                    return (C0112b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: setUnknownFields  reason: collision with other method in class */
                public C0112b m32setUnknownFields(q2 q2Var) {
                    return (C0112b) super.setUnknownFields(q2Var);
                }

                public C0112b(l0.c cVar, a aVar) {
                    super(cVar);
                    maybeForceBuilderInitialization();
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public C0112b addRepeatedField(s.g gVar, Object obj) {
                    return (C0112b) super.addRepeatedField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public C0112b clearField(s.g gVar) {
                    return (C0112b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public C0112b m25clearOneof(s.k kVar) {
                    return (C0112b) super.clearOneof(kVar);
                }

                @Override // c.b.d.k1, c.b.d.j1
                /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
                public i1 m26getDefaultInstanceForType() {
                    return c.f5514g;
                }

                @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeFrom  reason: collision with other method in class */
                public f1.a m27mergeFrom(f1 f1Var) {
                    if (f1Var instanceof c) {
                        f((c) f1Var);
                    } else {
                        super.mergeFrom(f1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public C0112b m29mergeUnknownFields(q2 q2Var) {
                    return (C0112b) super.mergeUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public C0112b setField(s.g gVar, Object obj) {
                    return (C0112b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b
                public C0112b setRepeatedField(s.g gVar, int i, Object obj) {
                    return (C0112b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public C0112b setUnknownFields(q2 q2Var) {
                    return (C0112b) super.setUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public C0112b m24clearOneof(s.k kVar) {
                    return (C0112b) super.clearOneof(kVar);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public C0112b m28mergeUnknownFields(q2 q2Var) {
                    return (C0112b) super.mergeUnknownFields(q2Var);
                }
            }

            public c() {
            }

            public c(l0.b bVar, a aVar) {
                super(bVar);
            }

            public g a() {
                g gVar = this.f5518e;
                return gVar == null ? g.f5585e : gVar;
            }

            public boolean b() {
                return (this.f5515b & 2) != 0;
            }

            public boolean c() {
                return (this.f5515b & 4) != 0;
            }

            public boolean d() {
                return (this.f5515b & 1) != 0;
            }

            /* renamed from: e */
            public C0112b toBuilder() {
                if (this == f5514g) {
                    return new C0112b(null);
                }
                C0112b bVar = new C0112b(null);
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
                if ((d() && this.f5516c != cVar.f5516c) || b() != cVar.b()) {
                    return false;
                }
                if ((!b() || this.f5517d == cVar.f5517d) && c() == cVar.c()) {
                    return (!c() || a().equals(cVar.a())) && this.unknownFields.equals(cVar.unknownFields);
                }
                return false;
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return f5514g;
            }

            @Override // c.b.d.l0, c.b.d.i1
            public w1<c> getParserForType() {
                return h;
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.f5515b & 1) != 0) {
                    i2 = 0 + m.s(1, this.f5516c);
                }
                if ((this.f5515b & 2) != 0) {
                    i2 += m.s(2, this.f5517d);
                }
                if ((this.f5515b & 4) != 0) {
                    i2 += m.z(3, a());
                }
                int serializedSize = this.unknownFields.getSerializedSize() + i2;
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // c.b.d.l0, c.b.d.k1
            public final q2 getUnknownFields() {
                return this.unknownFields;
            }

            @Override // c.b.d.a
            public int hashCode() {
                int i = this.memoizedHashCode;
                if (i != 0) {
                    return i;
                }
                int hashCode = r.f5500f.hashCode() + 779;
                if (d()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + this.f5516c;
                }
                if (b()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f5517d;
                }
                if (c()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + a().hashCode();
                }
                int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // c.b.d.l0
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.f5501g;
                fVar.c(c.class, C0112b.class);
                return fVar;
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
            public final boolean isInitialized() {
                byte b2 = this.f5519f;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                if (!c() || a().isInitialized()) {
                    this.f5519f = 1;
                    return true;
                }
                this.f5519f = 0;
                return false;
            }

            @Override // c.b.d.f1, c.b.d.i1
            public f1.a newBuilderForType() {
                return f5514g.toBuilder();
            }

            @Override // c.b.d.l0
            public Object newInstance(l0.g gVar) {
                return new c();
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
            public void writeTo(m mVar) {
                if ((this.f5515b & 1) != 0) {
                    mVar.i0(1, this.f5516c);
                }
                if ((this.f5515b & 2) != 0) {
                    mVar.i0(2, this.f5517d);
                }
                if ((this.f5515b & 4) != 0) {
                    mVar.k0(3, a());
                }
                this.unknownFields.writeTo(mVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m20getDefaultInstanceForType() {
                return f5514g;
            }

            @Override // c.b.d.l0
            public f1.a newBuilderForType(l0.c cVar) {
                return new C0112b(cVar, null);
            }

            @Override // c.b.d.f1, c.b.d.i1
            /* renamed from: newBuilderForType  reason: collision with other method in class */
            public i1.a m21newBuilderForType() {
                return f5514g.toBuilder();
            }
        }

        public static final class d extends l0 implements k1 {

            /* renamed from: f  reason: collision with root package name */
            public static final d f5525f = new d();
            @Deprecated

            /* renamed from: g  reason: collision with root package name */
            public static final w1<d> f5526g = new a();

            /* renamed from: b  reason: collision with root package name */
            public int f5527b;

            /* renamed from: c  reason: collision with root package name */
            public int f5528c;

            /* renamed from: d  reason: collision with root package name */
            public int f5529d;

            /* renamed from: e  reason: collision with root package name */
            public byte f5530e = -1;

            public static class a extends c<d> {
                @Override // c.b.d.w1
                public Object parsePartialFrom(k kVar, z zVar) {
                    d dVar = new d();
                    if (zVar != null) {
                        q2.b b2 = q2.b();
                        boolean z = false;
                        while (!z) {
                            try {
                                int G = kVar.G();
                                if (G != 0) {
                                    if (G == 8) {
                                        dVar.f5527b |= 1;
                                        dVar.f5528c = kVar.u();
                                    } else if (G == 16) {
                                        dVar.f5527b |= 2;
                                        dVar.f5529d = kVar.u();
                                    } else if (!dVar.parseUnknownField(kVar, b2, zVar, G)) {
                                    }
                                }
                                z = true;
                            } catch (o0 e2) {
                                e2.f5447b = dVar;
                                throw e2;
                            } catch (IOException e3) {
                                o0 o0Var = new o0(e3);
                                o0Var.f5447b = dVar;
                                throw o0Var;
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
            public static final class C0113b extends l0.b<C0113b> implements Object {

                /* renamed from: b  reason: collision with root package name */
                public int f5531b;

                /* renamed from: c  reason: collision with root package name */
                public int f5532c;

                /* renamed from: d  reason: collision with root package name */
                public int f5533d;

                public C0113b() {
                }

                public C0113b(a aVar) {
                }

                /* renamed from: a */
                public d buildPartial() {
                    int i;
                    d dVar = new d(this, null);
                    int i2 = this.f5531b;
                    if ((i2 & 1) != 0) {
                        dVar.f5528c = this.f5532c;
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((i2 & 2) != 0) {
                        dVar.f5529d = this.f5533d;
                        i |= 2;
                    }
                    dVar.f5527b = i;
                    onBuilt();
                    return dVar;
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: addRepeatedField  reason: collision with other method in class */
                public C0113b m35addRepeatedField(s.g gVar, Object obj) {
                    return (C0113b) super.addRepeatedField(gVar, obj);
                }

                public C0113b b() {
                    super.clear();
                    this.f5532c = 0;
                    int i = this.f5531b & -2;
                    this.f5531b = i;
                    this.f5533d = 0;
                    this.f5531b = i & -3;
                    return this;
                }

                @Override // c.b.d.i1.a, c.b.d.f1.a
                public f1 build() {
                    d a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
                }

                /* renamed from: c */
                public C0113b clone() {
                    return (C0113b) super.clone();
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: clearField  reason: collision with other method in class */
                public C0113b m37clearField(s.g gVar) {
                    return (C0113b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                public C0113b clearOneof(s.k kVar) {
                    return (C0113b) super.clearOneof(kVar);
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
                public C0113b d(k kVar, z zVar) {
                    Throwable th;
                    d dVar;
                    d dVar2 = null;
                    try {
                        d parsePartialFrom = d.f5526g.parsePartialFrom(kVar, zVar);
                        if (parsePartialFrom != null) {
                            e(parsePartialFrom);
                        }
                        return this;
                    } catch (o0 e2) {
                        dVar = (d) e2.f5447b;
                        throw e2.j();
                    } catch (Throwable th2) {
                        th = th2;
                        dVar2 = dVar;
                        if (dVar2 != null) {
                        }
                        throw th;
                    }
                }

                public C0113b e(d dVar) {
                    if (dVar == d.f5525f) {
                        return this;
                    }
                    if (dVar.b()) {
                        int i = dVar.f5528c;
                        this.f5531b |= 1;
                        this.f5532c = i;
                        onChanged();
                    }
                    if (dVar.a()) {
                        int i2 = dVar.f5529d;
                        this.f5531b |= 2;
                        this.f5533d = i2;
                        onChanged();
                    }
                    f(dVar.unknownFields);
                    onChanged();
                    return this;
                }

                public final C0113b f(q2 q2Var) {
                    return (C0113b) super.mergeUnknownFields(q2Var);
                }

                @Override // c.b.d.k1, c.b.d.j1
                public f1 getDefaultInstanceForType() {
                    return d.f5525f;
                }

                @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
                public s.b getDescriptorForType() {
                    return r.h;
                }

                @Override // c.b.d.l0.b
                public l0.f internalGetFieldAccessorTable() {
                    l0.f fVar = r.i;
                    fVar.c(d.class, C0113b.class);
                    return fVar;
                }

                @Override // c.b.d.l0.b, c.b.d.j1
                public final boolean isInitialized() {
                    return true;
                }

                @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                public a.AbstractC0106a mergeFrom(f1 f1Var) {
                    if (f1Var instanceof d) {
                        e((d) f1Var);
                    } else {
                        super.mergeFrom(f1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                public C0113b mergeUnknownFields(q2 q2Var) {
                    return (C0113b) super.mergeUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: setField  reason: collision with other method in class */
                public C0113b m44setField(s.g gVar, Object obj) {
                    return (C0113b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b
                /* renamed from: setRepeatedField  reason: collision with other method in class */
                public C0113b m45setRepeatedField(s.g gVar, int i, Object obj) {
                    return (C0113b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: setUnknownFields  reason: collision with other method in class */
                public C0113b m46setUnknownFields(q2 q2Var) {
                    return (C0113b) super.setUnknownFields(q2Var);
                }

                public C0113b(l0.c cVar, a aVar) {
                    super(cVar);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public C0113b addRepeatedField(s.g gVar, Object obj) {
                    return (C0113b) super.addRepeatedField(gVar, obj);
                }

                @Override // c.b.d.i1.a, c.b.d.f1.a
                /* renamed from: build  reason: collision with other method in class */
                public i1 m36build() {
                    d a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public C0113b clearField(s.g gVar) {
                    return (C0113b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public C0113b m39clearOneof(s.k kVar) {
                    return (C0113b) super.clearOneof(kVar);
                }

                @Override // c.b.d.k1, c.b.d.j1
                /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
                public i1 m40getDefaultInstanceForType() {
                    return d.f5525f;
                }

                @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeFrom  reason: collision with other method in class */
                public f1.a m41mergeFrom(f1 f1Var) {
                    if (f1Var instanceof d) {
                        e((d) f1Var);
                    } else {
                        super.mergeFrom(f1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public C0113b m43mergeUnknownFields(q2 q2Var) {
                    return (C0113b) super.mergeUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public C0113b setField(s.g gVar, Object obj) {
                    return (C0113b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b
                public C0113b setRepeatedField(s.g gVar, int i, Object obj) {
                    return (C0113b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public C0113b setUnknownFields(q2 q2Var) {
                    return (C0113b) super.setUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public C0113b m38clearOneof(s.k kVar) {
                    return (C0113b) super.clearOneof(kVar);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public C0113b m42mergeUnknownFields(q2 q2Var) {
                    return (C0113b) super.mergeUnknownFields(q2Var);
                }
            }

            public d() {
            }

            public d(l0.b bVar, a aVar) {
                super(bVar);
            }

            public boolean a() {
                return (this.f5527b & 2) != 0;
            }

            public boolean b() {
                return (this.f5527b & 1) != 0;
            }

            /* renamed from: c */
            public C0113b toBuilder() {
                if (this == f5525f) {
                    return new C0113b(null);
                }
                C0113b bVar = new C0113b(null);
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
                if ((!b() || this.f5528c == dVar.f5528c) && a() == dVar.a()) {
                    return (!a() || this.f5529d == dVar.f5529d) && this.unknownFields.equals(dVar.unknownFields);
                }
                return false;
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return f5525f;
            }

            @Override // c.b.d.l0, c.b.d.i1
            public w1<d> getParserForType() {
                return f5526g;
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.f5527b & 1) != 0) {
                    i2 = 0 + m.s(1, this.f5528c);
                }
                if ((this.f5527b & 2) != 0) {
                    i2 += m.s(2, this.f5529d);
                }
                int serializedSize = this.unknownFields.getSerializedSize() + i2;
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // c.b.d.l0, c.b.d.k1
            public final q2 getUnknownFields() {
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
                    hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + this.f5528c;
                }
                if (a()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f5529d;
                }
                int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // c.b.d.l0
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.i;
                fVar.c(d.class, C0113b.class);
                return fVar;
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
            public final boolean isInitialized() {
                byte b2 = this.f5530e;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.f5530e = 1;
                return true;
            }

            @Override // c.b.d.f1, c.b.d.i1
            public f1.a newBuilderForType() {
                return f5525f.toBuilder();
            }

            @Override // c.b.d.l0
            public Object newInstance(l0.g gVar) {
                return new d();
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
            public void writeTo(m mVar) {
                if ((this.f5527b & 1) != 0) {
                    mVar.i0(1, this.f5528c);
                }
                if ((this.f5527b & 2) != 0) {
                    mVar.i0(2, this.f5529d);
                }
                this.unknownFields.writeTo(mVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m33getDefaultInstanceForType() {
                return f5525f;
            }

            @Override // c.b.d.l0
            public f1.a newBuilderForType(l0.c cVar) {
                return new C0113b(cVar, null);
            }

            @Override // c.b.d.f1, c.b.d.i1
            /* renamed from: newBuilderForType  reason: collision with other method in class */
            public i1.a m34newBuilderForType() {
                return f5525f.toBuilder();
            }
        }

        public b() {
            this.m = -1;
            this.f5503c = "";
            this.f5504d = Collections.emptyList();
            this.f5505e = Collections.emptyList();
            this.f5506f = Collections.emptyList();
            this.f5507g = Collections.emptyList();
            this.h = Collections.emptyList();
            this.i = Collections.emptyList();
            this.k = Collections.emptyList();
            this.l = s0.f5863e;
        }

        public b(l0.b bVar, a aVar) {
            super(bVar);
            this.m = -1;
        }

        public int a() {
            return this.f5507g.size();
        }

        public int b() {
            return this.f5505e.size();
        }

        public int c() {
            return this.f5504d.size();
        }

        public String d() {
            Object obj = this.f5503c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.f5503c = z;
            }
            return z;
        }

        public int e() {
            return this.f5506f.size();
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
            if ((!h() || d().equals(bVar.d())) && this.f5504d.equals(bVar.f5504d) && this.f5505e.equals(bVar.f5505e) && this.f5506f.equals(bVar.f5506f) && this.f5507g.equals(bVar.f5507g) && this.h.equals(bVar.h) && this.i.equals(bVar.i) && i() == bVar.i()) {
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

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return n;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<b> getParserForType() {
            return o;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeStringSize = (this.f5502b & 1) != 0 ? l0.computeStringSize(1, this.f5503c) + 0 : 0;
            for (int i3 = 0; i3 < this.f5504d.size(); i3++) {
                computeStringSize += m.z(2, this.f5504d.get(i3));
            }
            for (int i4 = 0; i4 < this.f5506f.size(); i4++) {
                computeStringSize += m.z(3, this.f5506f.get(i4));
            }
            for (int i5 = 0; i5 < this.f5507g.size(); i5++) {
                computeStringSize += m.z(4, this.f5507g.get(i5));
            }
            for (int i6 = 0; i6 < this.h.size(); i6++) {
                computeStringSize += m.z(5, this.h.get(i6));
            }
            for (int i7 = 0; i7 < this.f5505e.size(); i7++) {
                computeStringSize += m.z(6, this.f5505e.get(i7));
            }
            if ((this.f5502b & 2) != 0) {
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
                i10 += l0.computeStringSizeNoTag(this.l.b(i11));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + (this.l.size() * 1) + computeStringSize + i10;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean h() {
            return (this.f5502b & 1) != 0;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.f5498d.hashCode() + 779;
            if (h()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + d().hashCode();
            }
            if (c() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f5504d.hashCode();
            }
            if (b() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 6, 53) + this.f5505e.hashCode();
            }
            if (e() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + this.f5506f.hashCode();
            }
            if (a() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 4, 53) + this.f5507g.hashCode();
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
            return (this.f5502b & 2) != 0;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.f5499e;
            fVar.c(b.class, C0111b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
        public final boolean isInitialized() {
            byte b2 = this.m;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < c(); i2++) {
                if (!this.f5504d.get(i2).isInitialized()) {
                    this.m = 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < b(); i3++) {
                if (!this.f5505e.get(i3).isInitialized()) {
                    this.m = 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < e(); i4++) {
                if (!this.f5506f.get(i4).isInitialized()) {
                    this.m = 0;
                    return false;
                }
            }
            for (int i5 = 0; i5 < a(); i5++) {
                if (!this.f5507g.get(i5).isInitialized()) {
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
        public C0111b toBuilder() {
            if (this == n) {
                return new C0111b(null);
            }
            C0111b bVar = new C0111b(null);
            bVar.n(this);
            return bVar;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return n.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new b();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            if ((this.f5502b & 1) != 0) {
                l0.writeString(mVar, 1, this.f5503c);
            }
            for (int i2 = 0; i2 < this.f5504d.size(); i2++) {
                mVar.k0(2, this.f5504d.get(i2));
            }
            for (int i3 = 0; i3 < this.f5506f.size(); i3++) {
                mVar.k0(3, this.f5506f.get(i3));
            }
            for (int i4 = 0; i4 < this.f5507g.size(); i4++) {
                mVar.k0(4, this.f5507g.get(i4));
            }
            for (int i5 = 0; i5 < this.h.size(); i5++) {
                mVar.k0(5, this.h.get(i5));
            }
            for (int i6 = 0; i6 < this.f5505e.size(); i6++) {
                mVar.k0(6, this.f5505e.get(i6));
            }
            if ((this.f5502b & 2) != 0) {
                mVar.k0(7, g());
            }
            for (int i7 = 0; i7 < this.i.size(); i7++) {
                mVar.k0(8, this.i.get(i7));
            }
            for (int i8 = 0; i8 < this.k.size(); i8++) {
                mVar.k0(9, this.k.get(i8));
            }
            for (int i9 = 0; i9 < this.l.size(); i9++) {
                l0.writeString(mVar, 10, this.l.b(i9));
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m7getDefaultInstanceForType() {
            return n;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new C0111b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m8newBuilderForType() {
            return n.toBuilder();
        }
    }

    public static final class c extends l0 implements k1 {
        public static final c i = new c();
        @Deprecated
        public static final w1<c> j = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f5534b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f5535c;

        /* renamed from: d  reason: collision with root package name */
        public List<e> f5536d;

        /* renamed from: e  reason: collision with root package name */
        public d f5537e;

        /* renamed from: f  reason: collision with root package name */
        public List<C0114c> f5538f;

        /* renamed from: g  reason: collision with root package name */
        public t0 f5539g;
        public byte h;

        public static class a extends c<c> {
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                Object obj;
                List list;
                c cVar = new c();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G != 10) {
                                    if (G == 18) {
                                        if (!z2 || !true) {
                                            cVar.f5536d = new ArrayList();
                                            z2 |= true;
                                        }
                                        list = cVar.f5536d;
                                        obj = e.h;
                                    } else if (G == 26) {
                                        d.b h = (cVar.f5534b & 2) != 0 ? cVar.f5537e.toBuilder() : null;
                                        d dVar = (d) kVar.w(d.i, zVar);
                                        cVar.f5537e = dVar;
                                        if (h != null) {
                                            h.o(dVar);
                                            cVar.f5537e = h.buildPartial();
                                        }
                                        cVar.f5534b |= 2;
                                    } else if (G == 34) {
                                        if (!z2 || !true) {
                                            cVar.f5538f = new ArrayList();
                                            z2 |= true;
                                        }
                                        list = cVar.f5538f;
                                        obj = C0114c.f5547g;
                                    } else if (G == 42) {
                                        j n = kVar.n();
                                        if (!z2 || !true) {
                                            cVar.f5539g = new s0(10);
                                            z2 |= true;
                                        }
                                        cVar.f5539g.D(n);
                                    } else if (!cVar.parseUnknownField(kVar, b2, zVar, G)) {
                                    }
                                    list.add(kVar.w(obj, zVar));
                                } else {
                                    j n2 = kVar.n();
                                    cVar.f5534b = 1 | cVar.f5534b;
                                    cVar.f5535c = n2;
                                }
                            }
                            z = true;
                        } catch (o0 e2) {
                            e2.f5447b = cVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = cVar;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                cVar.f5536d = Collections.unmodifiableList(cVar.f5536d);
                            }
                            if (z2 && true) {
                                cVar.f5538f = Collections.unmodifiableList(cVar.f5538f);
                            }
                            if (z2 && true) {
                                cVar.f5539g = cVar.f5539g.d();
                            }
                            cVar.unknownFields = b2.build();
                            cVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        cVar.f5536d = Collections.unmodifiableList(cVar.f5536d);
                    }
                    if (z2 && true) {
                        cVar.f5538f = Collections.unmodifiableList(cVar.f5538f);
                    }
                    if (z2 && true) {
                        cVar.f5539g = cVar.f5539g.d();
                    }
                    cVar.unknownFields = b2.build();
                    cVar.makeExtensionsImmutable();
                    return cVar;
                }
                throw null;
            }
        }

        public static final class b extends l0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f5540b;

            /* renamed from: c  reason: collision with root package name */
            public Object f5541c = "";

            /* renamed from: d  reason: collision with root package name */
            public List<e> f5542d = Collections.emptyList();

            /* renamed from: e  reason: collision with root package name */
            public c2<e, e.b, Object> f5543e;

            /* renamed from: f  reason: collision with root package name */
            public d f5544f;

            /* renamed from: g  reason: collision with root package name */
            public g2<d, d.b, Object> f5545g;
            public List<C0114c> h = Collections.emptyList();
            public c2<C0114c, C0114c.b, Object> i;
            public t0 j = s0.f5863e;

            public b() {
                maybeForceBuilderInitialization();
            }

            public b(a aVar) {
                maybeForceBuilderInitialization();
            }

            /* renamed from: a */
            public c buildPartial() {
                List<e> list;
                List<C0114c> list2;
                c cVar = new c(this, null);
                int i2 = this.f5540b;
                int i3 = (i2 & 1) != 0 ? 1 : 0;
                cVar.f5535c = this.f5541c;
                c2<e, e.b, Object> c2Var = this.f5543e;
                if (c2Var == null) {
                    if ((this.f5540b & 2) != 0) {
                        this.f5542d = Collections.unmodifiableList(this.f5542d);
                        this.f5540b &= -3;
                    }
                    list = this.f5542d;
                } else {
                    list = c2Var.g();
                }
                cVar.f5536d = list;
                if ((i2 & 4) != 0) {
                    g2<d, d.b, Object> g2Var = this.f5545g;
                    cVar.f5537e = g2Var == null ? this.f5544f : g2Var.b();
                    i3 |= 2;
                }
                c2<C0114c, C0114c.b, Object> c2Var2 = this.i;
                if (c2Var2 == null) {
                    if ((this.f5540b & 8) != 0) {
                        this.h = Collections.unmodifiableList(this.h);
                        this.f5540b &= -9;
                    }
                    list2 = this.h;
                } else {
                    list2 = c2Var2.g();
                }
                cVar.f5538f = list2;
                if ((this.f5540b & 16) != 0) {
                    this.j = this.j.d();
                    this.f5540b &= -17;
                }
                cVar.f5539g = this.j;
                cVar.f5534b = i3;
                onBuilt();
                return cVar;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m49addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            public b b() {
                super.clear();
                this.f5541c = "";
                this.f5540b &= -2;
                c2<e, e.b, Object> c2Var = this.f5543e;
                if (c2Var == null) {
                    this.f5542d = Collections.emptyList();
                    this.f5540b &= -3;
                } else {
                    c2Var.h();
                }
                g2<d, d.b, Object> g2Var = this.f5545g;
                if (g2Var == null) {
                    this.f5544f = null;
                } else {
                    g2Var.c();
                }
                this.f5540b &= -5;
                c2<C0114c, C0114c.b, Object> c2Var2 = this.i;
                if (c2Var2 == null) {
                    this.h = Collections.emptyList();
                    this.f5540b &= -9;
                } else {
                    c2Var2.h();
                }
                this.j = s0.f5863e;
                this.f5540b &= -17;
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                c a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
            }

            /* renamed from: c */
            public b clone() {
                return (b) super.clone();
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m51clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            public final c2<C0114c, C0114c.b, Object> d() {
                if (this.i == null) {
                    this.i = new c2<>(this.h, (this.f5540b & 8) != 0, getParentForChildren(), isClean());
                    this.h = null;
                }
                return this.i;
            }

            public final c2<e, e.b, Object> e() {
                if (this.f5543e == null) {
                    this.f5543e = new c2<>(this.f5542d, (this.f5540b & 2) != 0, getParentForChildren(), isClean());
                    this.f5542d = null;
                }
                return this.f5543e;
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
                } catch (o0 e2) {
                    cVar = (c) e2.f5447b;
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
                    this.f5540b |= 1;
                    this.f5541c = cVar.f5535c;
                    onChanged();
                }
                c2<C0114c, C0114c.b, Object> c2Var = null;
                if (this.f5543e == null) {
                    if (!cVar.f5536d.isEmpty()) {
                        if (this.f5542d.isEmpty()) {
                            this.f5542d = cVar.f5536d;
                            this.f5540b &= -3;
                        } else {
                            if ((this.f5540b & 2) == 0) {
                                this.f5542d = new ArrayList(this.f5542d);
                                this.f5540b |= 2;
                            }
                            this.f5542d.addAll(cVar.f5536d);
                        }
                        onChanged();
                    }
                } else if (!cVar.f5536d.isEmpty()) {
                    if (this.f5543e.s()) {
                        this.f5543e.f5234a = null;
                        this.f5543e = null;
                        this.f5542d = cVar.f5536d;
                        this.f5540b &= -3;
                        this.f5543e = l0.alwaysUseFieldBuilders ? e() : null;
                    } else {
                        this.f5543e.b(cVar.f5536d);
                    }
                }
                if (cVar.e()) {
                    d b2 = cVar.b();
                    g2<d, d.b, Object> g2Var = this.f5545g;
                    if (g2Var == null) {
                        if (!((this.f5540b & 4) == 0 || (dVar = this.f5544f) == null || dVar == (dVar2 = d.h))) {
                            d.b h2 = dVar2.toBuilder();
                            h2.o(dVar);
                            h2.o(b2);
                            b2 = h2.buildPartial();
                        }
                        this.f5544f = b2;
                        onChanged();
                    } else {
                        g2Var.f(b2);
                    }
                    this.f5540b |= 4;
                }
                if (this.i == null) {
                    if (!cVar.f5538f.isEmpty()) {
                        if (this.h.isEmpty()) {
                            this.h = cVar.f5538f;
                            this.f5540b &= -9;
                        } else {
                            if ((this.f5540b & 8) == 0) {
                                this.h = new ArrayList(this.h);
                                this.f5540b |= 8;
                            }
                            this.h.addAll(cVar.f5538f);
                        }
                        onChanged();
                    }
                } else if (!cVar.f5538f.isEmpty()) {
                    if (this.i.s()) {
                        this.i.f5234a = null;
                        this.i = null;
                        this.h = cVar.f5538f;
                        this.f5540b &= -9;
                        if (l0.alwaysUseFieldBuilders) {
                            c2Var = d();
                        }
                        this.i = c2Var;
                    } else {
                        this.i.b(cVar.f5538f);
                    }
                }
                if (!cVar.f5539g.isEmpty()) {
                    if (this.j.isEmpty()) {
                        this.j = cVar.f5539g;
                        this.f5540b &= -17;
                    } else {
                        if ((this.f5540b & 16) == 0) {
                            this.j = new s0(this.j);
                            this.f5540b |= 16;
                        }
                        this.j.addAll(cVar.f5539g);
                    }
                    onChanged();
                }
                h(cVar.unknownFields);
                onChanged();
                return this;
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return c.i;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.p;
            }

            public final b h(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.q;
                fVar.c(c.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.j1
            public final boolean isInitialized() {
                d dVar;
                e eVar;
                int i2 = 0;
                while (true) {
                    c2<e, e.b, Object> c2Var = this.f5543e;
                    if (i2 < (c2Var == null ? this.f5542d.size() : c2Var.m())) {
                        c2<e, e.b, Object> c2Var2 = this.f5543e;
                        if (c2Var2 == null) {
                            eVar = this.f5542d.get(i2);
                        } else {
                            eVar = c2Var2.n(i2, false);
                        }
                        if (!eVar.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else {
                        if ((this.f5540b & 4) != 0) {
                            g2<d, d.b, Object> g2Var = this.f5545g;
                            if (g2Var == null) {
                                dVar = this.f5544f;
                                if (dVar == null) {
                                    dVar = d.h;
                                }
                            } else {
                                dVar = g2Var.e();
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
                if (l0.alwaysUseFieldBuilders) {
                    e();
                    g2<d, d.b, Object> g2Var = this.f5545g;
                    if (g2Var == null) {
                        if (g2Var == null) {
                            dVar = this.f5544f;
                            if (dVar == null) {
                                dVar = d.h;
                            }
                        } else {
                            dVar = g2Var.e();
                        }
                        this.f5545g = new g2<>(dVar, getParentForChildren(), isClean());
                        this.f5544f = null;
                    }
                    d();
                }
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof c) {
                    g((c) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m58setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m59setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m60setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m50build() {
                c a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m53clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m54getDefaultInstanceForType() {
                return c.i;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m55mergeFrom(f1 f1Var) {
                if (f1Var instanceof c) {
                    g((c) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m57mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            public b setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m52clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m56mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }
        }

        /* renamed from: c.b.d.r$c$c  reason: collision with other inner class name */
        public static final class C0114c extends l0 implements k1 {

            /* renamed from: f  reason: collision with root package name */
            public static final C0114c f5546f = new C0114c();
            @Deprecated

            /* renamed from: g  reason: collision with root package name */
            public static final w1<C0114c> f5547g = new a();

            /* renamed from: b  reason: collision with root package name */
            public int f5548b;

            /* renamed from: c  reason: collision with root package name */
            public int f5549c;

            /* renamed from: d  reason: collision with root package name */
            public int f5550d;

            /* renamed from: e  reason: collision with root package name */
            public byte f5551e = -1;

            /* renamed from: c.b.d.r$c$c$a */
            public static class a extends c<C0114c> {
                @Override // c.b.d.w1
                public Object parsePartialFrom(k kVar, z zVar) {
                    C0114c cVar = new C0114c();
                    if (zVar != null) {
                        q2.b b2 = q2.b();
                        boolean z = false;
                        while (!z) {
                            try {
                                int G = kVar.G();
                                if (G != 0) {
                                    if (G == 8) {
                                        cVar.f5548b |= 1;
                                        cVar.f5549c = kVar.u();
                                    } else if (G == 16) {
                                        cVar.f5548b |= 2;
                                        cVar.f5550d = kVar.u();
                                    } else if (!cVar.parseUnknownField(kVar, b2, zVar, G)) {
                                    }
                                }
                                z = true;
                            } catch (o0 e2) {
                                e2.f5447b = cVar;
                                throw e2;
                            } catch (IOException e3) {
                                o0 o0Var = new o0(e3);
                                o0Var.f5447b = cVar;
                                throw o0Var;
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
            public static final class b extends l0.b<b> implements Object {

                /* renamed from: b  reason: collision with root package name */
                public int f5552b;

                /* renamed from: c  reason: collision with root package name */
                public int f5553c;

                /* renamed from: d  reason: collision with root package name */
                public int f5554d;

                public b() {
                }

                public b(a aVar) {
                }

                /* renamed from: a */
                public C0114c buildPartial() {
                    int i;
                    C0114c cVar = new C0114c(this, null);
                    int i2 = this.f5552b;
                    if ((i2 & 1) != 0) {
                        cVar.f5549c = this.f5553c;
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((i2 & 2) != 0) {
                        cVar.f5550d = this.f5554d;
                        i |= 2;
                    }
                    cVar.f5548b = i;
                    onBuilt();
                    return cVar;
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: addRepeatedField  reason: collision with other method in class */
                public b m63addRepeatedField(s.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                public b b() {
                    super.clear();
                    this.f5553c = 0;
                    int i = this.f5552b & -2;
                    this.f5552b = i;
                    this.f5554d = 0;
                    this.f5552b = i & -3;
                    return this;
                }

                @Override // c.b.d.i1.a, c.b.d.f1.a
                public f1 build() {
                    C0114c a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
                }

                /* renamed from: c */
                public b clone() {
                    return (b) super.clone();
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: clearField  reason: collision with other method in class */
                public b m65clearField(s.g gVar) {
                    return (b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                public b clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
                public b d(k kVar, z zVar) {
                    Throwable th;
                    C0114c cVar;
                    C0114c cVar2 = null;
                    try {
                        C0114c parsePartialFrom = C0114c.f5547g.parsePartialFrom(kVar, zVar);
                        if (parsePartialFrom != null) {
                            e(parsePartialFrom);
                        }
                        return this;
                    } catch (o0 e2) {
                        cVar = (C0114c) e2.f5447b;
                        throw e2.j();
                    } catch (Throwable th2) {
                        th = th2;
                        cVar2 = cVar;
                        if (cVar2 != null) {
                        }
                        throw th;
                    }
                }

                public b e(C0114c cVar) {
                    if (cVar == C0114c.f5546f) {
                        return this;
                    }
                    if (cVar.b()) {
                        int i = cVar.f5549c;
                        this.f5552b |= 1;
                        this.f5553c = i;
                        onChanged();
                    }
                    if (cVar.a()) {
                        int i2 = cVar.f5550d;
                        this.f5552b |= 2;
                        this.f5554d = i2;
                        onChanged();
                    }
                    f(cVar.unknownFields);
                    onChanged();
                    return this;
                }

                public final b f(q2 q2Var) {
                    return (b) super.mergeUnknownFields(q2Var);
                }

                @Override // c.b.d.k1, c.b.d.j1
                public f1 getDefaultInstanceForType() {
                    return C0114c.f5546f;
                }

                @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
                public s.b getDescriptorForType() {
                    return r.r;
                }

                @Override // c.b.d.l0.b
                public l0.f internalGetFieldAccessorTable() {
                    l0.f fVar = r.s;
                    fVar.c(C0114c.class, b.class);
                    return fVar;
                }

                @Override // c.b.d.l0.b, c.b.d.j1
                public final boolean isInitialized() {
                    return true;
                }

                @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                public a.AbstractC0106a mergeFrom(f1 f1Var) {
                    if (f1Var instanceof C0114c) {
                        e((C0114c) f1Var);
                    } else {
                        super.mergeFrom(f1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                public b mergeUnknownFields(q2 q2Var) {
                    return (b) super.mergeUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: setField  reason: collision with other method in class */
                public b m72setField(s.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b
                /* renamed from: setRepeatedField  reason: collision with other method in class */
                public b m73setRepeatedField(s.g gVar, int i, Object obj) {
                    return (b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: setUnknownFields  reason: collision with other method in class */
                public b m74setUnknownFields(q2 q2Var) {
                    return (b) super.setUnknownFields(q2Var);
                }

                public b(l0.c cVar, a aVar) {
                    super(cVar);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public b addRepeatedField(s.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                @Override // c.b.d.i1.a, c.b.d.f1.a
                /* renamed from: build  reason: collision with other method in class */
                public i1 m64build() {
                    C0114c a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public b clearField(s.g gVar) {
                    return (b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public b m67clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                @Override // c.b.d.k1, c.b.d.j1
                /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
                public i1 m68getDefaultInstanceForType() {
                    return C0114c.f5546f;
                }

                @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeFrom  reason: collision with other method in class */
                public f1.a m69mergeFrom(f1 f1Var) {
                    if (f1Var instanceof C0114c) {
                        e((C0114c) f1Var);
                    } else {
                        super.mergeFrom(f1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public b m71mergeUnknownFields(q2 q2Var) {
                    return (b) super.mergeUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public b setField(s.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b
                public b setRepeatedField(s.g gVar, int i, Object obj) {
                    return (b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public b setUnknownFields(q2 q2Var) {
                    return (b) super.setUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public b m66clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public b m70mergeUnknownFields(q2 q2Var) {
                    return (b) super.mergeUnknownFields(q2Var);
                }
            }

            public C0114c() {
            }

            public C0114c(l0.b bVar, a aVar) {
                super(bVar);
            }

            public boolean a() {
                return (this.f5548b & 2) != 0;
            }

            public boolean b() {
                return (this.f5548b & 1) != 0;
            }

            /* renamed from: c */
            public b toBuilder() {
                if (this == f5546f) {
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
                if (!(obj instanceof C0114c)) {
                    return super.equals(obj);
                }
                C0114c cVar = (C0114c) obj;
                if (b() != cVar.b()) {
                    return false;
                }
                if ((!b() || this.f5549c == cVar.f5549c) && a() == cVar.a()) {
                    return (!a() || this.f5550d == cVar.f5550d) && this.unknownFields.equals(cVar.unknownFields);
                }
                return false;
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return f5546f;
            }

            @Override // c.b.d.l0, c.b.d.i1
            public w1<C0114c> getParserForType() {
                return f5547g;
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.f5548b & 1) != 0) {
                    i2 = 0 + m.s(1, this.f5549c);
                }
                if ((this.f5548b & 2) != 0) {
                    i2 += m.s(2, this.f5550d);
                }
                int serializedSize = this.unknownFields.getSerializedSize() + i2;
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // c.b.d.l0, c.b.d.k1
            public final q2 getUnknownFields() {
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
                    hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + this.f5549c;
                }
                if (a()) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f5550d;
                }
                int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // c.b.d.l0
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.s;
                fVar.c(C0114c.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
            public final boolean isInitialized() {
                byte b2 = this.f5551e;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.f5551e = 1;
                return true;
            }

            @Override // c.b.d.f1, c.b.d.i1
            public f1.a newBuilderForType() {
                return f5546f.toBuilder();
            }

            @Override // c.b.d.l0
            public Object newInstance(l0.g gVar) {
                return new C0114c();
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
            public void writeTo(m mVar) {
                if ((this.f5548b & 1) != 0) {
                    mVar.i0(1, this.f5549c);
                }
                if ((this.f5548b & 2) != 0) {
                    mVar.i0(2, this.f5550d);
                }
                this.unknownFields.writeTo(mVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m61getDefaultInstanceForType() {
                return f5546f;
            }

            @Override // c.b.d.l0
            public f1.a newBuilderForType(l0.c cVar) {
                return new b(cVar, null);
            }

            @Override // c.b.d.f1, c.b.d.i1
            /* renamed from: newBuilderForType  reason: collision with other method in class */
            public i1.a m62newBuilderForType() {
                return f5546f.toBuilder();
            }
        }

        public c() {
            this.h = -1;
            this.f5535c = "";
            this.f5536d = Collections.emptyList();
            this.f5538f = Collections.emptyList();
            this.f5539g = s0.f5863e;
        }

        public c(l0.b bVar, a aVar) {
            super(bVar);
            this.h = -1;
        }

        public String a() {
            Object obj = this.f5535c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.f5535c = z;
            }
            return z;
        }

        public d b() {
            d dVar = this.f5537e;
            return dVar == null ? d.h : dVar;
        }

        public int c() {
            return this.f5536d.size();
        }

        public boolean d() {
            return (this.f5534b & 1) != 0;
        }

        public boolean e() {
            return (this.f5534b & 2) != 0;
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
            if ((!d() || a().equals(cVar.a())) && this.f5536d.equals(cVar.f5536d) && e() == cVar.e()) {
                return (!e() || b().equals(cVar.b())) && this.f5538f.equals(cVar.f5538f) && this.f5539g.equals(cVar.f5539g) && this.unknownFields.equals(cVar.unknownFields);
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

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return i;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<c> getParserForType() {
            return j;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeStringSize = (this.f5534b & 1) != 0 ? l0.computeStringSize(1, this.f5535c) + 0 : 0;
            for (int i3 = 0; i3 < this.f5536d.size(); i3++) {
                computeStringSize += m.z(2, this.f5536d.get(i3));
            }
            if ((this.f5534b & 2) != 0) {
                computeStringSize += m.z(3, b());
            }
            for (int i4 = 0; i4 < this.f5538f.size(); i4++) {
                computeStringSize += m.z(4, this.f5538f.get(i4));
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.f5539g.size(); i6++) {
                i5 += l0.computeStringSizeNoTag(this.f5539g.b(i6));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + (this.f5539g.size() * 1) + computeStringSize + i5;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
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
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f5536d.hashCode();
            }
            if (e()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + b().hashCode();
            }
            if (this.f5538f.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 4, 53) + this.f5538f.hashCode();
            }
            if (this.f5539g.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 5, 53) + this.f5539g.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.q;
            fVar.c(c.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
        public final boolean isInitialized() {
            byte b2 = this.h;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < c(); i2++) {
                if (!this.f5536d.get(i2).isInitialized()) {
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

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return i.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new c();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            if ((this.f5534b & 1) != 0) {
                l0.writeString(mVar, 1, this.f5535c);
            }
            for (int i2 = 0; i2 < this.f5536d.size(); i2++) {
                mVar.k0(2, this.f5536d.get(i2));
            }
            if ((this.f5534b & 2) != 0) {
                mVar.k0(3, b());
            }
            for (int i3 = 0; i3 < this.f5538f.size(); i3++) {
                mVar.k0(4, this.f5538f.get(i3));
            }
            for (int i4 = 0; i4 < this.f5539g.size(); i4++) {
                l0.writeString(mVar, 5, this.f5539g.b(i4));
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m47getDefaultInstanceForType() {
            return i;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m48newBuilderForType() {
            return i.toBuilder();
        }
    }

    public static final class d extends l0.e<d> implements Object {
        public static final d h = new d();
        @Deprecated
        public static final w1<d> i = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f5555c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5556d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5557e;

        /* renamed from: f  reason: collision with root package name */
        public List<t> f5558f;

        /* renamed from: g  reason: collision with root package name */
        public byte f5559g;

        public static class a extends c<d> {
            /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                d dVar = new d();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 16) {
                                    dVar.f5555c |= 1;
                                    dVar.f5556d = kVar.m();
                                } else if (G == 24) {
                                    dVar.f5555c |= 2;
                                    dVar.f5557e = kVar.m();
                                } else if (G == 7994) {
                                    if (!z2 || !true) {
                                        dVar.f5558f = new ArrayList();
                                        z2 |= true;
                                    }
                                    dVar.f5558f.add(kVar.w(t.l, zVar));
                                } else if (!dVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (o0 e2) {
                            e2.f5447b = dVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = dVar;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                dVar.f5558f = Collections.unmodifiableList(dVar.f5558f);
                            }
                            dVar.unknownFields = b2.build();
                            dVar.f5370b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        dVar.f5558f = Collections.unmodifiableList(dVar.f5558f);
                    }
                    dVar.unknownFields = b2.build();
                    dVar.f5370b.x();
                    return dVar;
                }
                throw null;
            }
        }

        public static final class b extends l0.d<d, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f5560c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f5561d;

            /* renamed from: e  reason: collision with root package name */
            public boolean f5562e;

            /* renamed from: f  reason: collision with root package name */
            public List<t> f5563f = Collections.emptyList();

            /* renamed from: g  reason: collision with root package name */
            public c2<t, t.b, Object> f5564g;

            public b() {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public l0.b m77addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                d j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public l0.b m79clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return d.h;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.H;
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b h(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.I;
                fVar.c(d.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.d, c.b.d.j1
            public final boolean isInitialized() {
                t tVar;
                int i = 0;
                while (true) {
                    c2<t, t.b, Object> c2Var = this.f5564g;
                    if (i < (c2Var == null ? this.f5563f.size() : c2Var.m())) {
                        c2<t, t.b, Object> c2Var2 = this.f5564g;
                        if (c2Var2 == null) {
                            tVar = this.f5563f.get(i);
                        } else {
                            tVar = c2Var2.n(i, false);
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
                int i2 = this.f5560c;
                if ((i2 & 1) != 0) {
                    dVar.f5556d = this.f5561d;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    dVar.f5557e = this.f5562e;
                    i |= 2;
                }
                c2<t, t.b, Object> c2Var = this.f5564g;
                if (c2Var == null) {
                    if ((this.f5560c & 4) != 0) {
                        this.f5563f = Collections.unmodifiableList(this.f5563f);
                        this.f5560c &= -5;
                    }
                    list = this.f5563f;
                } else {
                    list = c2Var.g();
                }
                dVar.f5558f = list;
                dVar.f5555c = i;
                onBuilt();
                return dVar;
            }

            public b k() {
                super.clear();
                this.f5561d = false;
                int i = this.f5560c & -2;
                this.f5560c = i;
                this.f5562e = false;
                this.f5560c = i & -3;
                c2<t, t.b, Object> c2Var = this.f5564g;
                if (c2Var == null) {
                    this.f5563f = Collections.emptyList();
                    this.f5560c &= -5;
                } else {
                    c2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final c2<t, t.b, Object> m() {
                if (this.f5564g == null) {
                    this.f5564g = new c2<>(this.f5563f, (this.f5560c & 4) != 0, getParentForChildren(), isClean());
                    this.f5563f = null;
                }
                return this.f5564g;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof d) {
                    o((d) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
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
                } catch (o0 e2) {
                    dVar = (d) e2.f5447b;
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
                    boolean z = dVar.f5556d;
                    this.f5560c |= 1;
                    this.f5561d = z;
                    onChanged();
                }
                if (dVar.g()) {
                    boolean z2 = dVar.f5557e;
                    this.f5560c |= 2;
                    this.f5562e = z2;
                    onChanged();
                }
                if (this.f5564g == null) {
                    if (!dVar.f5558f.isEmpty()) {
                        if (this.f5563f.isEmpty()) {
                            this.f5563f = dVar.f5558f;
                            this.f5560c &= -5;
                        } else {
                            if ((this.f5560c & 4) == 0) {
                                this.f5563f = new ArrayList(this.f5563f);
                                this.f5560c |= 4;
                            }
                            this.f5563f.addAll(dVar.f5558f);
                        }
                        onChanged();
                    }
                } else if (!dVar.f5558f.isEmpty()) {
                    if (this.f5564g.s()) {
                        c2<t, t.b, Object> c2Var = null;
                        this.f5564g.f5234a = null;
                        this.f5564g = null;
                        this.f5563f = dVar.f5558f;
                        this.f5560c &= -5;
                        if (l0.alwaysUseFieldBuilders) {
                            c2Var = m();
                        }
                        this.f5564g = c2Var;
                    } else {
                        this.f5564g.b(dVar.f5558f);
                    }
                }
                f(dVar);
                q(dVar.unknownFields);
                onChanged();
                return this;
            }

            public final b q(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public l0.b m86setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public l0.b m87setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public l0.b m88setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(a aVar) {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m78build() {
                d j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public l0.b m81clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m82getDefaultInstanceForType() {
                return d.h;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m83mergeFrom(f1 f1Var) {
                if (f1Var instanceof d) {
                    o((d) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public l0.b m85mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            public f1.a setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public f1.a setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public f1.a m80clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public f1.a m84mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public d() {
            this.f5559g = -1;
            this.f5558f = Collections.emptyList();
        }

        public d(l0.d dVar, a aVar) {
            super(dVar);
            this.f5559g = -1;
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
            if ((!f() || this.f5556d == dVar.f5556d) && g() == dVar.g()) {
                return (!g() || this.f5557e == dVar.f5557e) && this.f5558f.equals(dVar.f5558f) && this.unknownFields.equals(dVar.unknownFields) && c().equals(dVar.c());
            }
            return false;
        }

        public boolean f() {
            return (this.f5555c & 1) != 0;
        }

        public boolean g() {
            return (this.f5555c & 2) != 0;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return h;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<d> getParserForType() {
            return i;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int c2 = (this.f5555c & 1) != 0 ? m.c(2, this.f5556d) + 0 : 0;
            if ((2 & this.f5555c) != 0) {
                c2 += m.c(3, this.f5557e);
            }
            for (int i3 = 0; i3 < this.f5558f.size(); i3++) {
                c2 += m.z(b.s.h.MAX_BIND_PARAMETER_CNT, this.f5558f.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + c2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
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
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + n0.c(this.f5556d);
            }
            if (g()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + n0.c(this.f5557e);
            }
            if (this.f5558f.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.s.h.MAX_BIND_PARAMETER_CNT, 53) + this.f5558f.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.I;
            fVar.c(d.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.l0.e, c.b.d.j1
        public final boolean isInitialized() {
            byte b2 = this.f5559g;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.f5558f.size(); i2++) {
                if (!this.f5558f.get(i2).isInitialized()) {
                    this.f5559g = 0;
                    return false;
                }
            }
            if (!a()) {
                this.f5559g = 0;
                return false;
            }
            this.f5559g = 1;
            return true;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return h.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new d();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            l0.e<MessageType>.a d2 = d();
            if ((this.f5555c & 1) != 0) {
                mVar.Y(2, this.f5556d);
            }
            if ((this.f5555c & 2) != 0) {
                mVar.Y(3, this.f5557e);
            }
            for (int i2 = 0; i2 < this.f5558f.size(); i2++) {
                mVar.k0(b.s.h.MAX_BIND_PARAMETER_CNT, this.f5558f.get(i2));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m75getDefaultInstanceForType() {
            return h;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m76newBuilderForType() {
            return h.toBuilder();
        }
    }

    public static final class e extends l0 implements k1 {

        /* renamed from: g  reason: collision with root package name */
        public static final e f5565g = new e();
        @Deprecated
        public static final w1<e> h = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f5566b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f5567c;

        /* renamed from: d  reason: collision with root package name */
        public int f5568d;

        /* renamed from: e  reason: collision with root package name */
        public f f5569e;

        /* renamed from: f  reason: collision with root package name */
        public byte f5570f;

        public static class a extends c<e> {
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                e eVar = new e();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 10) {
                                    j n = kVar.n();
                                    eVar.f5566b = 1 | eVar.f5566b;
                                    eVar.f5567c = n;
                                } else if (G == 16) {
                                    eVar.f5566b |= 2;
                                    eVar.f5568d = kVar.u();
                                } else if (G == 26) {
                                    f.b g2 = (eVar.f5566b & 4) != 0 ? eVar.f5569e.toBuilder() : null;
                                    f fVar = (f) kVar.w(f.h, zVar);
                                    eVar.f5569e = fVar;
                                    if (g2 != null) {
                                        g2.o(fVar);
                                        eVar.f5569e = g2.buildPartial();
                                    }
                                    eVar.f5566b |= 4;
                                } else if (!eVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (o0 e2) {
                            e2.f5447b = eVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = eVar;
                            throw o0Var;
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

        public static final class b extends l0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f5571b;

            /* renamed from: c  reason: collision with root package name */
            public Object f5572c = "";

            /* renamed from: d  reason: collision with root package name */
            public int f5573d;

            /* renamed from: e  reason: collision with root package name */
            public f f5574e;

            /* renamed from: f  reason: collision with root package name */
            public g2<f, f.b, Object> f5575f;

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
                throw a.AbstractC0106a.newUninitializedMessageException((f1) b2);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m91addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: b */
            public e buildPartial() {
                e eVar = new e(this, null);
                int i = this.f5571b;
                int i2 = (i & 1) != 0 ? 1 : 0;
                eVar.f5567c = this.f5572c;
                if ((i & 2) != 0) {
                    eVar.f5568d = this.f5573d;
                    i2 |= 2;
                }
                if ((i & 4) != 0) {
                    g2<f, f.b, Object> g2Var = this.f5575f;
                    eVar.f5569e = g2Var == null ? this.f5574e : g2Var.b();
                    i2 |= 4;
                }
                eVar.f5566b = i2;
                onBuilt();
                return eVar;
            }

            public b c() {
                super.clear();
                this.f5572c = "";
                int i = this.f5571b & -2;
                this.f5571b = i;
                this.f5573d = 0;
                this.f5571b = i & -3;
                g2<f, f.b, Object> g2Var = this.f5575f;
                if (g2Var == null) {
                    this.f5574e = null;
                } else {
                    g2Var.c();
                }
                this.f5571b &= -5;
                return this;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m92clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
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
                } catch (o0 e2) {
                    eVar = (e) e2.f5447b;
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
                if (eVar == e.f5565g) {
                    return this;
                }
                if (eVar.c()) {
                    this.f5571b |= 1;
                    this.f5572c = eVar.f5567c;
                    onChanged();
                }
                if (eVar.d()) {
                    int i = eVar.f5568d;
                    this.f5571b |= 2;
                    this.f5573d = i;
                    onChanged();
                }
                if (eVar.e()) {
                    f b2 = eVar.b();
                    g2<f, f.b, Object> g2Var = this.f5575f;
                    if (g2Var == null) {
                        if (!((this.f5571b & 4) == 0 || (fVar = this.f5574e) == null || fVar == (fVar2 = f.f5576g))) {
                            f.b g2 = fVar2.toBuilder();
                            g2.o(fVar);
                            g2.o(b2);
                            b2 = g2.buildPartial();
                        }
                        this.f5574e = b2;
                        onChanged();
                    } else {
                        g2Var.f(b2);
                    }
                    this.f5571b |= 4;
                }
                g(eVar.unknownFields);
                onChanged();
                return this;
            }

            public final b g(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return e.f5565g;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.t;
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.u;
                fVar.c(e.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.j1
            public final boolean isInitialized() {
                f fVar;
                if ((this.f5571b & 4) != 0) {
                    g2<f, f.b, Object> g2Var = this.f5575f;
                    if (g2Var == null) {
                        fVar = this.f5574e;
                        if (fVar == null) {
                            fVar = f.f5576g;
                        }
                    } else {
                        fVar = g2Var.e();
                    }
                    if (!fVar.isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public final void maybeForceBuilderInitialization() {
                g2<f, f.b, Object> g2Var;
                f fVar;
                if (l0.alwaysUseFieldBuilders && (g2Var = this.f5575f) == null) {
                    if (g2Var == null) {
                        fVar = this.f5574e;
                        if (fVar == null) {
                            fVar = f.f5576g;
                        }
                    } else {
                        fVar = g2Var.e();
                    }
                    this.f5575f = new g2<>(fVar, getParentForChildren(), isClean());
                    this.f5574e = null;
                }
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof e) {
                    f((e) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m99setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m100setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m101setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m94clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m95getDefaultInstanceForType() {
                return e.f5565g;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m96mergeFrom(f1 f1Var) {
                if (f1Var instanceof e) {
                    f((e) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m98mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            public b setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m93clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m97mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }
        }

        public e() {
            this.f5570f = -1;
            this.f5567c = "";
        }

        public e(l0.b bVar, a aVar) {
            super(bVar);
            this.f5570f = -1;
        }

        public String a() {
            Object obj = this.f5567c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.f5567c = z;
            }
            return z;
        }

        public f b() {
            f fVar = this.f5569e;
            return fVar == null ? f.f5576g : fVar;
        }

        public boolean c() {
            return (this.f5566b & 1) != 0;
        }

        public boolean d() {
            return (this.f5566b & 2) != 0;
        }

        public boolean e() {
            return (this.f5566b & 4) != 0;
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
            if ((!d() || this.f5568d == eVar.f5568d) && e() == eVar.e()) {
                return (!e() || b().equals(eVar.b())) && this.unknownFields.equals(eVar.unknownFields);
            }
            return false;
        }

        /* renamed from: f */
        public b toBuilder() {
            if (this == f5565g) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.f(this);
            return bVar;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return f5565g;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<e> getParserForType() {
            return h;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.f5566b & 1) != 0) {
                i2 = 0 + l0.computeStringSize(1, this.f5567c);
            }
            if ((this.f5566b & 2) != 0) {
                i2 += m.s(2, this.f5568d);
            }
            if ((this.f5566b & 4) != 0) {
                i2 += m.z(3, b());
            }
            int serializedSize = this.unknownFields.getSerializedSize() + i2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
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
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f5568d;
            }
            if (e()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + b().hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.u;
            fVar.c(e.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
        public final boolean isInitialized() {
            byte b2 = this.f5570f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!e() || b().isInitialized()) {
                this.f5570f = 1;
                return true;
            }
            this.f5570f = 0;
            return false;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return f5565g.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new e();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            if ((this.f5566b & 1) != 0) {
                l0.writeString(mVar, 1, this.f5567c);
            }
            if ((this.f5566b & 2) != 0) {
                mVar.i0(2, this.f5568d);
            }
            if ((this.f5566b & 4) != 0) {
                mVar.k0(3, b());
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m89getDefaultInstanceForType() {
            return f5565g;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m90newBuilderForType() {
            return f5565g.toBuilder();
        }
    }

    public static final class f extends l0.e<f> implements Object {

        /* renamed from: g  reason: collision with root package name */
        public static final f f5576g = new f();
        @Deprecated
        public static final w1<f> h = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f5577c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5578d;

        /* renamed from: e  reason: collision with root package name */
        public List<t> f5579e;

        /* renamed from: f  reason: collision with root package name */
        public byte f5580f;

        public static class a extends c<f> {
            /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                f fVar = new f();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 8) {
                                    fVar.f5577c |= 1;
                                    fVar.f5578d = kVar.m();
                                } else if (G == 7994) {
                                    if (!z2 || !true) {
                                        fVar.f5579e = new ArrayList();
                                        z2 |= true;
                                    }
                                    fVar.f5579e.add(kVar.w(t.l, zVar));
                                } else if (!fVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (o0 e2) {
                            e2.f5447b = fVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = fVar;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                fVar.f5579e = Collections.unmodifiableList(fVar.f5579e);
                            }
                            fVar.unknownFields = b2.build();
                            fVar.f5370b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        fVar.f5579e = Collections.unmodifiableList(fVar.f5579e);
                    }
                    fVar.unknownFields = b2.build();
                    fVar.f5370b.x();
                    return fVar;
                }
                throw null;
            }
        }

        public static final class b extends l0.d<f, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f5581c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f5582d;

            /* renamed from: e  reason: collision with root package name */
            public List<t> f5583e = Collections.emptyList();

            /* renamed from: f  reason: collision with root package name */
            public c2<t, t.b, Object> f5584f;

            public b() {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public l0.b m104addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                f j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public l0.b m106clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return f.f5576g;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.J;
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b h(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.K;
                fVar.c(f.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.d, c.b.d.j1
            public final boolean isInitialized() {
                t tVar;
                int i = 0;
                while (true) {
                    c2<t, t.b, Object> c2Var = this.f5584f;
                    if (i < (c2Var == null ? this.f5583e.size() : c2Var.m())) {
                        c2<t, t.b, Object> c2Var2 = this.f5584f;
                        if (c2Var2 == null) {
                            tVar = this.f5583e.get(i);
                        } else {
                            tVar = c2Var2.n(i, false);
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
                if ((this.f5581c & 1) != 0) {
                    fVar.f5578d = this.f5582d;
                } else {
                    i = 0;
                }
                c2<t, t.b, Object> c2Var = this.f5584f;
                if (c2Var == null) {
                    if ((this.f5581c & 2) != 0) {
                        this.f5583e = Collections.unmodifiableList(this.f5583e);
                        this.f5581c &= -3;
                    }
                    list = this.f5583e;
                } else {
                    list = c2Var.g();
                }
                fVar.f5579e = list;
                fVar.f5577c = i;
                onBuilt();
                return fVar;
            }

            public b k() {
                super.clear();
                this.f5582d = false;
                this.f5581c &= -2;
                c2<t, t.b, Object> c2Var = this.f5584f;
                if (c2Var == null) {
                    this.f5583e = Collections.emptyList();
                    this.f5581c &= -3;
                } else {
                    c2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final c2<t, t.b, Object> m() {
                if (this.f5584f == null) {
                    this.f5584f = new c2<>(this.f5583e, (this.f5581c & 2) != 0, getParentForChildren(), isClean());
                    this.f5583e = null;
                }
                return this.f5584f;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof f) {
                    o((f) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
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
                } catch (o0 e2) {
                    fVar = (f) e2.f5447b;
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
                if (fVar == f.f5576g) {
                    return this;
                }
                if (fVar.f()) {
                    boolean z = fVar.f5578d;
                    this.f5581c |= 1;
                    this.f5582d = z;
                    onChanged();
                }
                if (this.f5584f == null) {
                    if (!fVar.f5579e.isEmpty()) {
                        if (this.f5583e.isEmpty()) {
                            this.f5583e = fVar.f5579e;
                            this.f5581c &= -3;
                        } else {
                            if ((this.f5581c & 2) == 0) {
                                this.f5583e = new ArrayList(this.f5583e);
                                this.f5581c |= 2;
                            }
                            this.f5583e.addAll(fVar.f5579e);
                        }
                        onChanged();
                    }
                } else if (!fVar.f5579e.isEmpty()) {
                    if (this.f5584f.s()) {
                        c2<t, t.b, Object> c2Var = null;
                        this.f5584f.f5234a = null;
                        this.f5584f = null;
                        this.f5583e = fVar.f5579e;
                        this.f5581c &= -3;
                        if (l0.alwaysUseFieldBuilders) {
                            c2Var = m();
                        }
                        this.f5584f = c2Var;
                    } else {
                        this.f5584f.b(fVar.f5579e);
                    }
                }
                f(fVar);
                q(fVar.unknownFields);
                onChanged();
                return this;
            }

            public final b q(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public l0.b m113setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public l0.b m114setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public l0.b m115setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(a aVar) {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m105build() {
                f j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public l0.b m108clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m109getDefaultInstanceForType() {
                return f.f5576g;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m110mergeFrom(f1 f1Var) {
                if (f1Var instanceof f) {
                    o((f) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public l0.b m112mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            public f1.a setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public f1.a setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public f1.a m107clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public f1.a m111mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public f() {
            this.f5580f = -1;
            this.f5579e = Collections.emptyList();
        }

        public f(l0.d dVar, a aVar) {
            super(dVar);
            this.f5580f = -1;
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
            return (!f() || this.f5578d == fVar.f5578d) && this.f5579e.equals(fVar.f5579e) && this.unknownFields.equals(fVar.unknownFields) && c().equals(fVar.c());
        }

        public boolean f() {
            return (this.f5577c & 1) != 0;
        }

        /* renamed from: g */
        public b toBuilder() {
            if (this == f5576g) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.o(this);
            return bVar;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return f5576g;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<f> getParserForType() {
            return h;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int c2 = (this.f5577c & 1) != 0 ? m.c(1, this.f5578d) + 0 : 0;
            for (int i2 = 0; i2 < this.f5579e.size(); i2++) {
                c2 += m.z(b.s.h.MAX_BIND_PARAMETER_CNT, this.f5579e.get(i2));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + c2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
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
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + n0.c(this.f5578d);
            }
            if (this.f5579e.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.s.h.MAX_BIND_PARAMETER_CNT, 53) + this.f5579e.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.K;
            fVar.c(f.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.l0.e, c.b.d.j1
        public final boolean isInitialized() {
            byte b2 = this.f5580f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.f5579e.size(); i++) {
                if (!this.f5579e.get(i).isInitialized()) {
                    this.f5580f = 0;
                    return false;
                }
            }
            if (!a()) {
                this.f5580f = 0;
                return false;
            }
            this.f5580f = 1;
            return true;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return f5576g.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new f();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            l0.e<MessageType>.a d2 = d();
            if ((this.f5577c & 1) != 0) {
                mVar.Y(1, this.f5578d);
            }
            for (int i = 0; i < this.f5579e.size(); i++) {
                mVar.k0(b.s.h.MAX_BIND_PARAMETER_CNT, this.f5579e.get(i));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m102getDefaultInstanceForType() {
            return f5576g;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m103newBuilderForType() {
            return f5576g.toBuilder();
        }
    }

    public static final class g extends l0.e<g> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public static final g f5585e = new g();
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        public static final w1<g> f5586f = new a();

        /* renamed from: c  reason: collision with root package name */
        public List<t> f5587c;

        /* renamed from: d  reason: collision with root package name */
        public byte f5588d;

        public static class a extends c<g> {
            /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                g gVar = new g();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 7994) {
                                    if (!z2 || !true) {
                                        gVar.f5587c = new ArrayList();
                                        z2 |= true;
                                    }
                                    gVar.f5587c.add(kVar.w(t.l, zVar));
                                } else if (!gVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (o0 e2) {
                            e2.f5447b = gVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = gVar;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                gVar.f5587c = Collections.unmodifiableList(gVar.f5587c);
                            }
                            gVar.unknownFields = b2.build();
                            gVar.f5370b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        gVar.f5587c = Collections.unmodifiableList(gVar.f5587c);
                    }
                    gVar.unknownFields = b2.build();
                    gVar.f5370b.x();
                    return gVar;
                }
                throw null;
            }
        }

        public static final class b extends l0.d<g, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f5589c;

            /* renamed from: d  reason: collision with root package name */
            public List<t> f5590d = Collections.emptyList();

            /* renamed from: e  reason: collision with root package name */
            public c2<t, t.b, Object> f5591e;

            public b() {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public l0.b m118addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                g j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public l0.b m120clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return g.f5585e;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.j;
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b h(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.k;
                fVar.c(g.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.d, c.b.d.j1
            public final boolean isInitialized() {
                t tVar;
                int i = 0;
                while (true) {
                    c2<t, t.b, Object> c2Var = this.f5591e;
                    if (i < (c2Var == null ? this.f5590d.size() : c2Var.m())) {
                        c2<t, t.b, Object> c2Var2 = this.f5591e;
                        if (c2Var2 == null) {
                            tVar = this.f5590d.get(i);
                        } else {
                            tVar = c2Var2.n(i, false);
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
                int i = this.f5589c;
                c2<t, t.b, Object> c2Var = this.f5591e;
                if (c2Var == null) {
                    if ((i & 1) != 0) {
                        this.f5590d = Collections.unmodifiableList(this.f5590d);
                        this.f5589c &= -2;
                    }
                    list = this.f5590d;
                } else {
                    list = c2Var.g();
                }
                gVar.f5587c = list;
                onBuilt();
                return gVar;
            }

            public b k() {
                super.clear();
                c2<t, t.b, Object> c2Var = this.f5591e;
                if (c2Var == null) {
                    this.f5590d = Collections.emptyList();
                    this.f5589c &= -2;
                } else {
                    c2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final c2<t, t.b, Object> m() {
                if (this.f5591e == null) {
                    List<t> list = this.f5590d;
                    boolean z = true;
                    if ((this.f5589c & 1) == 0) {
                        z = false;
                    }
                    this.f5591e = new c2<>(list, z, getParentForChildren(), isClean());
                    this.f5590d = null;
                }
                return this.f5591e;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof g) {
                    o((g) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b n(k kVar, z zVar) {
                Throwable th;
                g gVar;
                g gVar2 = null;
                try {
                    g parsePartialFrom = g.f5586f.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        o(parsePartialFrom);
                    }
                    return this;
                } catch (o0 e2) {
                    gVar = (g) e2.f5447b;
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
                if (gVar == g.f5585e) {
                    return this;
                }
                if (this.f5591e == null) {
                    if (!gVar.f5587c.isEmpty()) {
                        if (this.f5590d.isEmpty()) {
                            this.f5590d = gVar.f5587c;
                            this.f5589c &= -2;
                        } else {
                            if ((this.f5589c & 1) == 0) {
                                this.f5590d = new ArrayList(this.f5590d);
                                this.f5589c |= 1;
                            }
                            this.f5590d.addAll(gVar.f5587c);
                        }
                        onChanged();
                    }
                } else if (!gVar.f5587c.isEmpty()) {
                    if (this.f5591e.s()) {
                        c2<t, t.b, Object> c2Var = null;
                        this.f5591e.f5234a = null;
                        this.f5591e = null;
                        this.f5590d = gVar.f5587c;
                        this.f5589c &= -2;
                        if (l0.alwaysUseFieldBuilders) {
                            c2Var = m();
                        }
                        this.f5591e = c2Var;
                    } else {
                        this.f5591e.b(gVar.f5587c);
                    }
                }
                f(gVar);
                q(gVar.unknownFields);
                onChanged();
                return this;
            }

            public final b q(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public l0.b m127setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public l0.b m128setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public l0.b m129setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(a aVar) {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m119build() {
                g j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public l0.b m122clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m123getDefaultInstanceForType() {
                return g.f5585e;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m124mergeFrom(f1 f1Var) {
                if (f1Var instanceof g) {
                    o((g) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public l0.b m126mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            public f1.a setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public f1.a setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public f1.a m121clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public f1.a m125mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public g() {
            this.f5588d = -1;
            this.f5587c = Collections.emptyList();
        }

        public g(l0.d dVar, a aVar) {
            super(dVar);
            this.f5588d = -1;
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
            if (this.f5587c.equals(gVar.f5587c) && this.unknownFields.equals(gVar.unknownFields) && c().equals(gVar.c())) {
                return true;
            }
            return false;
        }

        /* renamed from: f */
        public b toBuilder() {
            if (this == f5585e) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.o(this);
            return bVar;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return f5585e;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<g> getParserForType() {
            return f5586f;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f5587c.size(); i3++) {
                i2 += m.z(b.s.h.MAX_BIND_PARAMETER_CNT, this.f5587c.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + i2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = r.j.hashCode() + 779;
            if (this.f5587c.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.s.h.MAX_BIND_PARAMETER_CNT, 53) + this.f5587c.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.k;
            fVar.c(g.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.l0.e, c.b.d.j1
        public final boolean isInitialized() {
            byte b2 = this.f5588d;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.f5587c.size(); i++) {
                if (!this.f5587c.get(i).isInitialized()) {
                    this.f5588d = 0;
                    return false;
                }
            }
            if (!a()) {
                this.f5588d = 0;
                return false;
            }
            this.f5588d = 1;
            return true;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return f5585e.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new g();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            l0.e<MessageType>.a d2 = d();
            for (int i = 0; i < this.f5587c.size(); i++) {
                mVar.k0(b.s.h.MAX_BIND_PARAMETER_CNT, this.f5587c.get(i));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m116getDefaultInstanceForType() {
            return f5585e;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m117newBuilderForType() {
            return f5585e.toBuilder();
        }
    }

    public static final class h extends l0 implements k1 {
        public static final h n = new h();
        @Deprecated
        public static final w1<h> o = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f5592b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f5593c;

        /* renamed from: d  reason: collision with root package name */
        public int f5594d;

        /* renamed from: e  reason: collision with root package name */
        public int f5595e;

        /* renamed from: f  reason: collision with root package name */
        public int f5596f;

        /* renamed from: g  reason: collision with root package name */
        public volatile Object f5597g;
        public volatile Object h;
        public volatile Object i;
        public int j;
        public volatile Object k;
        public i l;
        public byte m;

        public static class a extends c<h> {
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                h hVar = new h();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            switch (G) {
                                case 0:
                                    break;
                                case 10:
                                    j n = kVar.n();
                                    hVar.f5592b = 1 | hVar.f5592b;
                                    hVar.f5593c = n;
                                    continue;
                                case 18:
                                    j n2 = kVar.n();
                                    hVar.f5592b |= 32;
                                    hVar.h = n2;
                                    continue;
                                case 24:
                                    hVar.f5592b |= 2;
                                    hVar.f5594d = kVar.u();
                                    continue;
                                case 32:
                                    int p = kVar.p();
                                    if (c.b(p) == null) {
                                        b2.h(4, p);
                                        continue;
                                    } else {
                                        hVar.f5592b |= 4;
                                        hVar.f5595e = p;
                                    }
                                case 40:
                                    int p2 = kVar.p();
                                    if (d.b(p2) == null) {
                                        b2.h(5, p2);
                                        continue;
                                    } else {
                                        hVar.f5592b |= 8;
                                        hVar.f5596f = p2;
                                    }
                                case 50:
                                    j n3 = kVar.n();
                                    hVar.f5592b |= 16;
                                    hVar.f5597g = n3;
                                    continue;
                                case 58:
                                    j n4 = kVar.n();
                                    hVar.f5592b |= 64;
                                    hVar.i = n4;
                                    continue;
                                case 66:
                                    i.b l = (hVar.f5592b & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0 ? hVar.l.toBuilder() : null;
                                    i iVar = (i) kVar.w(i.m, zVar);
                                    hVar.l = iVar;
                                    if (l != null) {
                                        l.o(iVar);
                                        hVar.l = l.buildPartial();
                                    }
                                    hVar.f5592b |= RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN;
                                    continue;
                                case 72:
                                    hVar.f5592b |= RecyclerView.a0.FLAG_IGNORE;
                                    hVar.j = kVar.u();
                                    continue;
                                case 82:
                                    j n5 = kVar.n();
                                    hVar.f5592b |= RecyclerView.a0.FLAG_TMP_DETACHED;
                                    hVar.k = n5;
                                    continue;
                                default:
                                    if (hVar.parseUnknownField(kVar, b2, zVar, G)) {
                                        continue;
                                    }
                                    break;
                            }
                            z = true;
                        } catch (o0 e2) {
                            e2.f5447b = hVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = hVar;
                            throw o0Var;
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

        public static final class b extends l0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f5598b;

            /* renamed from: c  reason: collision with root package name */
            public Object f5599c = "";

            /* renamed from: d  reason: collision with root package name */
            public int f5600d;

            /* renamed from: e  reason: collision with root package name */
            public int f5601e = 1;

            /* renamed from: f  reason: collision with root package name */
            public int f5602f = 1;

            /* renamed from: g  reason: collision with root package name */
            public Object f5603g = "";
            public Object h = "";
            public Object i = "";
            public int j;
            public Object k = "";
            public i l;
            public g2<i, i.b, Object> m;

            public b() {
                maybeForceBuilderInitialization();
            }

            public b(a aVar) {
                maybeForceBuilderInitialization();
            }

            /* renamed from: a */
            public h buildPartial() {
                h hVar = new h(this, null);
                int i2 = this.f5598b;
                int i3 = (i2 & 1) != 0 ? 1 : 0;
                hVar.f5593c = this.f5599c;
                if ((i2 & 2) != 0) {
                    hVar.f5594d = this.f5600d;
                    i3 |= 2;
                }
                if ((i2 & 4) != 0) {
                    i3 |= 4;
                }
                hVar.f5595e = this.f5601e;
                if ((i2 & 8) != 0) {
                    i3 |= 8;
                }
                hVar.f5596f = this.f5602f;
                if ((i2 & 16) != 0) {
                    i3 |= 16;
                }
                hVar.f5597g = this.f5603g;
                if ((i2 & 32) != 0) {
                    i3 |= 32;
                }
                hVar.h = this.h;
                if ((i2 & 64) != 0) {
                    i3 |= 64;
                }
                hVar.i = this.i;
                if ((i2 & RecyclerView.a0.FLAG_IGNORE) != 0) {
                    hVar.j = this.j;
                    i3 |= RecyclerView.a0.FLAG_IGNORE;
                }
                if ((i2 & RecyclerView.a0.FLAG_TMP_DETACHED) != 0) {
                    i3 |= RecyclerView.a0.FLAG_TMP_DETACHED;
                }
                hVar.k = this.k;
                if ((i2 & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                    g2<i, i.b, Object> g2Var = this.m;
                    hVar.l = g2Var == null ? this.l : g2Var.b();
                    i3 |= RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN;
                }
                hVar.f5592b = i3;
                onBuilt();
                return hVar;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m132addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            public b b() {
                super.clear();
                this.f5599c = "";
                int i2 = this.f5598b & -2;
                this.f5598b = i2;
                this.f5600d = 0;
                int i3 = i2 & -3;
                this.f5598b = i3;
                this.f5601e = 1;
                int i4 = i3 & -5;
                this.f5598b = i4;
                this.f5602f = 1;
                int i5 = i4 & -9;
                this.f5598b = i5;
                this.f5603g = "";
                int i6 = i5 & -17;
                this.f5598b = i6;
                this.h = "";
                int i7 = i6 & -33;
                this.f5598b = i7;
                this.i = "";
                int i8 = i7 & -65;
                this.f5598b = i8;
                this.j = 0;
                int i9 = i8 & -129;
                this.f5598b = i9;
                this.k = "";
                this.f5598b = i9 & -257;
                g2<i, i.b, Object> g2Var = this.m;
                if (g2Var == null) {
                    this.l = null;
                } else {
                    g2Var.c();
                }
                this.f5598b &= -513;
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                h a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
            }

            /* renamed from: c */
            public b clone() {
                return (b) super.clone();
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m134clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
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
                } catch (o0 e2) {
                    hVar = (h) e2.f5447b;
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
                    this.f5598b |= 1;
                    this.f5599c = hVar.f5593c;
                    onChanged();
                }
                if (hVar.m()) {
                    int i2 = hVar.f5594d;
                    this.f5598b |= 2;
                    this.f5600d = i2;
                    onChanged();
                }
                if (hVar.k()) {
                    c d2 = hVar.d();
                    this.f5598b |= 4;
                    this.f5601e = d2.f5608b;
                    onChanged();
                }
                if (hVar.p()) {
                    d b2 = d.b(hVar.f5596f);
                    if (b2 == null) {
                        b2 = d.TYPE_DOUBLE;
                    }
                    this.f5598b |= 8;
                    this.f5602f = b2.f5614b;
                    onChanged();
                }
                if (hVar.q()) {
                    this.f5598b |= 16;
                    this.f5603g = hVar.f5597g;
                    onChanged();
                }
                if (hVar.i()) {
                    this.f5598b |= 32;
                    this.h = hVar.h;
                    onChanged();
                }
                if (hVar.h()) {
                    this.f5598b |= 64;
                    this.i = hVar.i;
                    onChanged();
                }
                if (hVar.n()) {
                    int i3 = hVar.j;
                    this.f5598b |= RecyclerView.a0.FLAG_IGNORE;
                    this.j = i3;
                    onChanged();
                }
                if (hVar.j()) {
                    this.f5598b |= RecyclerView.a0.FLAG_TMP_DETACHED;
                    this.k = hVar.k;
                    onChanged();
                }
                if (hVar.o()) {
                    i f2 = hVar.f();
                    g2<i, i.b, Object> g2Var = this.m;
                    if (g2Var == null) {
                        if (!((this.f5598b & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0 || (iVar = this.l) == null || iVar == (iVar2 = i.l))) {
                            i.b l2 = iVar2.toBuilder();
                            l2.o(iVar);
                            l2.o(f2);
                            f2 = l2.buildPartial();
                        }
                        this.l = f2;
                        onChanged();
                    } else {
                        g2Var.f(f2);
                    }
                    this.f5598b |= RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN;
                }
                f(hVar.unknownFields);
                onChanged();
                return this;
            }

            public final b f(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return h.n;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.l;
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.m;
                fVar.c(h.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.j1
            public final boolean isInitialized() {
                i iVar;
                if ((this.f5598b & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                    g2<i, i.b, Object> g2Var = this.m;
                    if (g2Var == null) {
                        iVar = this.l;
                        if (iVar == null) {
                            iVar = i.l;
                        }
                    } else {
                        iVar = g2Var.e();
                    }
                    if (!iVar.isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public final void maybeForceBuilderInitialization() {
                g2<i, i.b, Object> g2Var;
                i iVar;
                if (l0.alwaysUseFieldBuilders && (g2Var = this.m) == null) {
                    if (g2Var == null) {
                        iVar = this.l;
                        if (iVar == null) {
                            iVar = i.l;
                        }
                    } else {
                        iVar = g2Var.e();
                    }
                    this.m = new g2<>(iVar, getParentForChildren(), isClean());
                    this.l = null;
                }
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof h) {
                    e((h) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m141setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m142setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m143setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m133build() {
                h a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m136clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m137getDefaultInstanceForType() {
                return h.n;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m138mergeFrom(f1 f1Var) {
                if (f1Var instanceof h) {
                    e((h) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m140mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            public b setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m135clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m139mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }
        }

        public enum c implements Object {
            LABEL_OPTIONAL(1),
            LABEL_REQUIRED(2),
            LABEL_REPEATED(3);
            

            /* renamed from: b  reason: collision with root package name */
            public final int f5608b;

            /* access modifiers changed from: public */
            static {
                values();
            }

            /* access modifiers changed from: public */
            c(int i) {
                this.f5608b = i;
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
                return this.f5608b;
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
            public final int f5614b;

            /* access modifiers changed from: public */
            static {
                values();
            }

            /* access modifiers changed from: public */
            d(int i) {
                this.f5614b = i;
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
                return this.f5614b;
            }
        }

        public h() {
            this.m = -1;
            this.f5593c = "";
            this.f5595e = 1;
            this.f5596f = 1;
            this.f5597g = "";
            this.h = "";
            this.i = "";
            this.k = "";
        }

        public h(l0.b bVar, a aVar) {
            super(bVar);
            this.m = -1;
        }

        public String a() {
            Object obj = this.i;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.i = z;
            }
            return z;
        }

        public String b() {
            Object obj = this.h;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.h = z;
            }
            return z;
        }

        public String c() {
            Object obj = this.k;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.k = z;
            }
            return z;
        }

        public c d() {
            c b2 = c.b(this.f5595e);
            return b2 == null ? c.LABEL_OPTIONAL : b2;
        }

        public String e() {
            Object obj = this.f5593c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.f5593c = z;
            }
            return z;
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
            if ((m() && this.f5594d != hVar.f5594d) || k() != hVar.k()) {
                return false;
            }
            if ((k() && this.f5595e != hVar.f5595e) || p() != hVar.p()) {
                return false;
            }
            if ((p() && this.f5596f != hVar.f5596f) || q() != hVar.q()) {
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
            Object obj = this.f5597g;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.f5597g = z;
            }
            return z;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return n;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<h> getParserForType() {
            return o;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.f5592b & 1) != 0) {
                i3 = 0 + l0.computeStringSize(1, this.f5593c);
            }
            if ((this.f5592b & 32) != 0) {
                i3 += l0.computeStringSize(2, this.h);
            }
            if ((this.f5592b & 2) != 0) {
                i3 += m.s(3, this.f5594d);
            }
            if ((this.f5592b & 4) != 0) {
                i3 += m.j(4, this.f5595e);
            }
            if ((this.f5592b & 8) != 0) {
                i3 += m.j(5, this.f5596f);
            }
            if ((this.f5592b & 16) != 0) {
                i3 += l0.computeStringSize(6, this.f5597g);
            }
            if ((this.f5592b & 64) != 0) {
                i3 += l0.computeStringSize(7, this.i);
            }
            if ((this.f5592b & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                i3 += m.z(8, f());
            }
            if ((this.f5592b & RecyclerView.a0.FLAG_IGNORE) != 0) {
                i3 += m.s(9, this.j);
            }
            if ((this.f5592b & RecyclerView.a0.FLAG_TMP_DETACHED) != 0) {
                i3 += l0.computeStringSize(10, this.k);
            }
            int serializedSize = this.unknownFields.getSerializedSize() + i3;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean h() {
            return (this.f5592b & 64) != 0;
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
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + this.f5594d;
            }
            if (k()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 4, 53) + this.f5595e;
            }
            if (p()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 5, 53) + this.f5596f;
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
            return (this.f5592b & 32) != 0;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.m;
            fVar.c(h.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
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
            return (this.f5592b & RecyclerView.a0.FLAG_TMP_DETACHED) != 0;
        }

        public boolean k() {
            return (this.f5592b & 4) != 0;
        }

        public boolean l() {
            return (this.f5592b & 1) != 0;
        }

        public boolean m() {
            return (this.f5592b & 2) != 0;
        }

        public boolean n() {
            return (this.f5592b & RecyclerView.a0.FLAG_IGNORE) != 0;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return n.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new h();
        }

        public boolean o() {
            return (this.f5592b & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0;
        }

        public boolean p() {
            return (this.f5592b & 8) != 0;
        }

        public boolean q() {
            return (this.f5592b & 16) != 0;
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

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            if ((this.f5592b & 1) != 0) {
                l0.writeString(mVar, 1, this.f5593c);
            }
            if ((this.f5592b & 32) != 0) {
                l0.writeString(mVar, 2, this.h);
            }
            if ((this.f5592b & 2) != 0) {
                mVar.i0(3, this.f5594d);
            }
            if ((this.f5592b & 4) != 0) {
                mVar.i0(4, this.f5595e);
            }
            if ((this.f5592b & 8) != 0) {
                mVar.i0(5, this.f5596f);
            }
            if ((this.f5592b & 16) != 0) {
                l0.writeString(mVar, 6, this.f5597g);
            }
            if ((this.f5592b & 64) != 0) {
                l0.writeString(mVar, 7, this.i);
            }
            if ((this.f5592b & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                mVar.k0(8, f());
            }
            if ((this.f5592b & RecyclerView.a0.FLAG_IGNORE) != 0) {
                mVar.i0(9, this.j);
            }
            if ((this.f5592b & RecyclerView.a0.FLAG_TMP_DETACHED) != 0) {
                l0.writeString(mVar, 10, this.k);
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m130getDefaultInstanceForType() {
            return n;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m131newBuilderForType() {
            return n.toBuilder();
        }
    }

    public static final class i extends l0.e<i> implements Object {
        public static final i l = new i();
        @Deprecated
        public static final w1<i> m = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f5615c;

        /* renamed from: d  reason: collision with root package name */
        public int f5616d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5617e;

        /* renamed from: f  reason: collision with root package name */
        public int f5618f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5619g;
        public boolean h;
        public boolean i;
        public List<t> j;
        public byte k;

        public static class a extends c<i> {
            /* JADX DEBUG: Multi-variable search result rejected for r4v16, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                i iVar = new i();
                if (zVar != null) {
                    q2.b b2 = q2.b();
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
                                        iVar.f5615c = 1 | iVar.f5615c;
                                        iVar.f5616d = p;
                                    }
                                } else if (G == 16) {
                                    iVar.f5615c |= 2;
                                    iVar.f5617e = kVar.m();
                                } else if (G == 24) {
                                    iVar.f5615c |= 16;
                                    iVar.h = kVar.m();
                                } else if (G == 40) {
                                    iVar.f5615c |= 8;
                                    iVar.f5619g = kVar.m();
                                } else if (G == 48) {
                                    int p2 = kVar.p();
                                    if (d.b(p2) == null) {
                                        b2.h(6, p2);
                                    } else {
                                        iVar.f5615c |= 4;
                                        iVar.f5618f = p2;
                                    }
                                } else if (G == 80) {
                                    iVar.f5615c |= 32;
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
                        } catch (o0 e2) {
                            e2.f5447b = iVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = iVar;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                iVar.j = Collections.unmodifiableList(iVar.j);
                            }
                            iVar.unknownFields = b2.build();
                            iVar.f5370b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        iVar.j = Collections.unmodifiableList(iVar.j);
                    }
                    iVar.unknownFields = b2.build();
                    iVar.f5370b.x();
                    return iVar;
                }
                throw null;
            }
        }

        public static final class b extends l0.d<i, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f5620c;

            /* renamed from: d  reason: collision with root package name */
            public int f5621d = 0;

            /* renamed from: e  reason: collision with root package name */
            public boolean f5622e;

            /* renamed from: f  reason: collision with root package name */
            public int f5623f = 0;

            /* renamed from: g  reason: collision with root package name */
            public boolean f5624g;
            public boolean h;
            public boolean i;
            public List<t> j = Collections.emptyList();
            public c2<t, t.b, Object> k;

            public b() {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public l0.b m146addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                i j2 = buildPartial();
                if (j2.isInitialized()) {
                    return j2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j2);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public l0.b m148clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return i.l;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.D;
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b h(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.E;
                fVar.c(i.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.d, c.b.d.j1
            public final boolean isInitialized() {
                t tVar;
                int i2 = 0;
                while (true) {
                    c2<t, t.b, Object> c2Var = this.k;
                    if (i2 < (c2Var == null ? this.j.size() : c2Var.m())) {
                        c2<t, t.b, Object> c2Var2 = this.k;
                        if (c2Var2 == null) {
                            tVar = this.j.get(i2);
                        } else {
                            tVar = c2Var2.n(i2, false);
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
                int i2 = this.f5620c;
                int i3 = (i2 & 1) != 0 ? 1 : 0;
                iVar.f5616d = this.f5621d;
                if ((i2 & 2) != 0) {
                    iVar.f5617e = this.f5622e;
                    i3 |= 2;
                }
                if ((i2 & 4) != 0) {
                    i3 |= 4;
                }
                iVar.f5618f = this.f5623f;
                if ((i2 & 8) != 0) {
                    iVar.f5619g = this.f5624g;
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
                c2<t, t.b, Object> c2Var = this.k;
                if (c2Var == null) {
                    if ((this.f5620c & 64) != 0) {
                        this.j = Collections.unmodifiableList(this.j);
                        this.f5620c &= -65;
                    }
                    list = this.j;
                } else {
                    list = c2Var.g();
                }
                iVar.j = list;
                iVar.f5615c = i3;
                onBuilt();
                return iVar;
            }

            public b k() {
                super.clear();
                this.f5621d = 0;
                int i2 = this.f5620c & -2;
                this.f5620c = i2;
                this.f5622e = false;
                int i3 = i2 & -3;
                this.f5620c = i3;
                this.f5623f = 0;
                int i4 = i3 & -5;
                this.f5620c = i4;
                this.f5624g = false;
                int i5 = i4 & -9;
                this.f5620c = i5;
                this.h = false;
                int i6 = i5 & -17;
                this.f5620c = i6;
                this.i = false;
                this.f5620c = i6 & -33;
                c2<t, t.b, Object> c2Var = this.k;
                if (c2Var == null) {
                    this.j = Collections.emptyList();
                    this.f5620c &= -65;
                } else {
                    c2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final c2<t, t.b, Object> m() {
                if (this.k == null) {
                    this.k = new c2<>(this.j, (this.f5620c & 64) != 0, getParentForChildren(), isClean());
                    this.j = null;
                }
                return this.k;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof i) {
                    o((i) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
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
                } catch (o0 e2) {
                    iVar = (i) e2.f5447b;
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
                    c b2 = c.b(iVar.f5616d);
                    if (b2 == null) {
                        b2 = c.STRING;
                    }
                    this.f5620c |= 1;
                    this.f5621d = b2.f5629b;
                    onChanged();
                }
                if (iVar.j()) {
                    boolean z = iVar.f5617e;
                    this.f5620c |= 2;
                    this.f5622e = z;
                    onChanged();
                }
                if (iVar.h()) {
                    d b3 = d.b(iVar.f5618f);
                    if (b3 == null) {
                        b3 = d.JS_NORMAL;
                    }
                    this.f5620c |= 4;
                    this.f5623f = b3.f5634b;
                    onChanged();
                }
                if (iVar.i()) {
                    boolean z2 = iVar.f5619g;
                    this.f5620c |= 8;
                    this.f5624g = z2;
                    onChanged();
                }
                if (iVar.g()) {
                    boolean z3 = iVar.h;
                    this.f5620c |= 16;
                    this.h = z3;
                    onChanged();
                }
                if (iVar.k()) {
                    boolean z4 = iVar.i;
                    this.f5620c |= 32;
                    this.i = z4;
                    onChanged();
                }
                if (this.k == null) {
                    if (!iVar.j.isEmpty()) {
                        if (this.j.isEmpty()) {
                            this.j = iVar.j;
                            this.f5620c &= -65;
                        } else {
                            if ((this.f5620c & 64) == 0) {
                                this.j = new ArrayList(this.j);
                                this.f5620c |= 64;
                            }
                            this.j.addAll(iVar.j);
                        }
                        onChanged();
                    }
                } else if (!iVar.j.isEmpty()) {
                    if (this.k.s()) {
                        c2<t, t.b, Object> c2Var = null;
                        this.k.f5234a = null;
                        this.k = null;
                        this.j = iVar.j;
                        this.f5620c &= -65;
                        if (l0.alwaysUseFieldBuilders) {
                            c2Var = m();
                        }
                        this.k = c2Var;
                    } else {
                        this.k.b(iVar.j);
                    }
                }
                f(iVar);
                q(iVar.unknownFields);
                onChanged();
                return this;
            }

            public final b q(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public l0.b m155setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public l0.b m156setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public l0.b m157setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(a aVar) {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m147build() {
                i j2 = buildPartial();
                if (j2.isInitialized()) {
                    return j2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j2);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public l0.b m150clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m151getDefaultInstanceForType() {
                return i.l;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m152mergeFrom(f1 f1Var) {
                if (f1Var instanceof i) {
                    o((i) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public l0.b m154mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            public f1.a setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public f1.a setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public f1.a m149clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public f1.a m153mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public enum c implements Object {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);
            

            /* renamed from: b  reason: collision with root package name */
            public final int f5629b;

            /* access modifiers changed from: public */
            static {
                values();
            }

            /* access modifiers changed from: public */
            c(int i) {
                this.f5629b = i;
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
                return this.f5629b;
            }
        }

        public enum d implements Object {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);
            

            /* renamed from: b  reason: collision with root package name */
            public final int f5634b;

            /* access modifiers changed from: public */
            static {
                values();
            }

            /* access modifiers changed from: public */
            d(int i) {
                this.f5634b = i;
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
                return this.f5634b;
            }
        }

        public i() {
            this.k = -1;
            this.f5616d = 0;
            this.f5618f = 0;
            this.j = Collections.emptyList();
        }

        public i(l0.d dVar, a aVar) {
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
            if ((f() && this.f5616d != iVar.f5616d) || j() != iVar.j()) {
                return false;
            }
            if ((j() && this.f5617e != iVar.f5617e) || h() != iVar.h()) {
                return false;
            }
            if ((h() && this.f5618f != iVar.f5618f) || i() != iVar.i()) {
                return false;
            }
            if ((i() && this.f5619g != iVar.f5619g) || g() != iVar.g()) {
                return false;
            }
            if ((!g() || this.h == iVar.h) && k() == iVar.k()) {
                return (!k() || this.i == iVar.i) && this.j.equals(iVar.j) && this.unknownFields.equals(iVar.unknownFields) && c().equals(iVar.c());
            }
            return false;
        }

        public boolean f() {
            return (this.f5615c & 1) != 0;
        }

        public boolean g() {
            return (this.f5615c & 16) != 0;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return l;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<i> getParserForType() {
            return m;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int j2 = (this.f5615c & 1) != 0 ? m.j(1, this.f5616d) + 0 : 0;
            if ((this.f5615c & 2) != 0) {
                j2 += m.c(2, this.f5617e);
            }
            if ((this.f5615c & 16) != 0) {
                j2 += m.c(3, this.h);
            }
            if ((this.f5615c & 8) != 0) {
                j2 += m.c(5, this.f5619g);
            }
            if ((this.f5615c & 4) != 0) {
                j2 += m.j(6, this.f5618f);
            }
            if ((this.f5615c & 32) != 0) {
                j2 += m.c(10, this.i);
            }
            for (int i3 = 0; i3 < this.j.size(); i3++) {
                j2 += m.z(b.s.h.MAX_BIND_PARAMETER_CNT, this.j.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + j2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean h() {
            return (this.f5615c & 4) != 0;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.D.hashCode() + 779;
            if (f()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + this.f5616d;
            }
            if (j()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + n0.c(this.f5617e);
            }
            if (h()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 6, 53) + this.f5618f;
            }
            if (i()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 5, 53) + n0.c(this.f5619g);
            }
            if (g()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + n0.c(this.h);
            }
            if (k()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 10, 53) + n0.c(this.i);
            }
            if (this.j.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.s.h.MAX_BIND_PARAMETER_CNT, 53) + this.j.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public boolean i() {
            return (this.f5615c & 8) != 0;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.E;
            fVar.c(i.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.l0.e, c.b.d.j1
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
            return (this.f5615c & 2) != 0;
        }

        public boolean k() {
            return (this.f5615c & 32) != 0;
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

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return l.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new i();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            l0.e<MessageType>.a d2 = d();
            if ((this.f5615c & 1) != 0) {
                mVar.i0(1, this.f5616d);
            }
            if ((this.f5615c & 2) != 0) {
                mVar.Y(2, this.f5617e);
            }
            if ((this.f5615c & 16) != 0) {
                mVar.Y(3, this.h);
            }
            if ((this.f5615c & 8) != 0) {
                mVar.Y(5, this.f5619g);
            }
            if ((this.f5615c & 4) != 0) {
                mVar.i0(6, this.f5618f);
            }
            if ((this.f5615c & 32) != 0) {
                mVar.Y(10, this.i);
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                mVar.k0(b.s.h.MAX_BIND_PARAMETER_CNT, this.j.get(i2));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m144getDefaultInstanceForType() {
            return l;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m145newBuilderForType() {
            return l.toBuilder();
        }
    }

    public static final class j extends l0 implements k1 {
        public static final j p = new j();
        @Deprecated
        public static final w1<j> q = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f5635b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f5636c;

        /* renamed from: d  reason: collision with root package name */
        public volatile Object f5637d;

        /* renamed from: e  reason: collision with root package name */
        public t0 f5638e;

        /* renamed from: f  reason: collision with root package name */
        public n0.f f5639f;

        /* renamed from: g  reason: collision with root package name */
        public n0.f f5640g;
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
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                Object obj;
                List list;
                n0.f fVar;
                int i;
                j jVar = new j();
                if (zVar != null) {
                    q2.b b2 = q2.b();
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
                                    jVar.f5635b = 1 | jVar.f5635b;
                                    jVar.f5636c = n;
                                    break;
                                case 18:
                                    j n2 = kVar.n();
                                    jVar.f5635b |= 2;
                                    jVar.f5637d = n2;
                                    break;
                                case 26:
                                    j n3 = kVar.n();
                                    if (!z2 || !true) {
                                        jVar.f5638e = new s0(10);
                                        z2 |= true;
                                    }
                                    jVar.f5638e.D(n3);
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
                                    k.b J = (jVar.f5635b & 4) != 0 ? jVar.l.toBuilder() : null;
                                    k kVar2 = (k) kVar.w(k.A, zVar);
                                    jVar.l = kVar2;
                                    if (J != null) {
                                        J.o(kVar2);
                                        jVar.l = J.buildPartial();
                                    }
                                    jVar.f5635b |= 4;
                                    break;
                                case 74:
                                    s.b a2 = (jVar.f5635b & 8) != 0 ? jVar.m.toBuilder() : null;
                                    s sVar = (s) kVar.w(s.f5738e, zVar);
                                    jVar.m = sVar;
                                    if (a2 != null) {
                                        a2.f(sVar);
                                        jVar.m = a2.buildPartial();
                                    }
                                    jVar.f5635b |= 8;
                                    break;
                                case 80:
                                    if (!z2 || !true) {
                                        jVar.f5639f = l0.newIntList();
                                        z2 |= true;
                                    }
                                    fVar = jVar.f5639f;
                                    ((m0) fVar).c(kVar.u());
                                    break;
                                case 82:
                                    i = kVar.l(kVar.y());
                                    if ((!z2 || !true) && kVar.d() > 0) {
                                        jVar.f5639f = l0.newIntList();
                                        z2 |= true;
                                    }
                                    while (kVar.d() > 0) {
                                        ((m0) jVar.f5639f).c(kVar.u());
                                    }
                                    kVar.k(i);
                                    break;
                                case 88:
                                    if (!z2 || !true) {
                                        jVar.f5640g = l0.newIntList();
                                        z2 |= true;
                                    }
                                    fVar = jVar.f5640g;
                                    ((m0) fVar).c(kVar.u());
                                    break;
                                case 90:
                                    i = kVar.l(kVar.y());
                                    if ((!z2 || !true) && kVar.d() > 0) {
                                        jVar.f5640g = l0.newIntList();
                                        z2 |= true;
                                    }
                                    while (kVar.d() > 0) {
                                        ((m0) jVar.f5640g).c(kVar.u());
                                    }
                                    kVar.k(i);
                                    break;
                                case 98:
                                    j n4 = kVar.n();
                                    jVar.f5635b |= 16;
                                    jVar.n = n4;
                                    break;
                                default:
                                    if (jVar.parseUnknownField(kVar, b2, zVar, G)) {
                                        break;
                                    }
                                    z = true;
                                    break;
                            }
                        } catch (o0 e2) {
                            e2.f5447b = jVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = jVar;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                jVar.f5638e = jVar.f5638e.d();
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
                                jVar.f5639f.f();
                            }
                            if (z2 && true) {
                                jVar.f5640g.f();
                            }
                            jVar.unknownFields = b2.build();
                            jVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        jVar.f5638e = jVar.f5638e.d();
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
                        jVar.f5639f.f();
                    }
                    if (z2 && true) {
                        jVar.f5640g.f();
                    }
                    jVar.unknownFields = b2.build();
                    jVar.makeExtensionsImmutable();
                    return jVar;
                }
                throw null;
            }
        }

        public static final class b extends l0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f5641b;

            /* renamed from: c  reason: collision with root package name */
            public Object f5642c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f5643d = "";

            /* renamed from: e  reason: collision with root package name */
            public t0 f5644e = s0.f5863e;

            /* renamed from: f  reason: collision with root package name */
            public n0.f f5645f = l0.emptyIntList();

            /* renamed from: g  reason: collision with root package name */
            public n0.f f5646g = l0.emptyIntList();
            public List<b> h = Collections.emptyList();
            public c2<b, b.C0111b, Object> i;
            public List<c> j = Collections.emptyList();
            public c2<c, c.b, Object> k;
            public List<q> l = Collections.emptyList();
            public c2<q, q.b, Object> m;
            public List<h> n = Collections.emptyList();
            public c2<h, h.b, Object> o;
            public k p;
            public g2<k, k.b, Object> q;
            public s r;
            public g2<s, s.b, Object> s;
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
                throw a.AbstractC0106a.newUninitializedMessageException((f1) b2);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
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
                int i2 = this.f5641b;
                int i3 = (i2 & 1) != 0 ? 1 : 0;
                jVar.f5636c = this.f5642c;
                if ((i2 & 2) != 0) {
                    i3 |= 2;
                }
                jVar.f5637d = this.f5643d;
                if ((this.f5641b & 4) != 0) {
                    this.f5644e = this.f5644e.d();
                    this.f5641b &= -5;
                }
                jVar.f5638e = this.f5644e;
                if ((this.f5641b & 8) != 0) {
                    this.f5645f.f();
                    this.f5641b &= -9;
                }
                jVar.f5639f = this.f5645f;
                if ((this.f5641b & 16) != 0) {
                    this.f5646g.f();
                    this.f5641b &= -17;
                }
                jVar.f5640g = this.f5646g;
                c2<b, b.C0111b, Object> c2Var = this.i;
                if (c2Var == null) {
                    if ((this.f5641b & 32) != 0) {
                        this.h = Collections.unmodifiableList(this.h);
                        this.f5641b &= -33;
                    }
                    list = this.h;
                } else {
                    list = c2Var.g();
                }
                jVar.h = list;
                c2<c, c.b, Object> c2Var2 = this.k;
                if (c2Var2 == null) {
                    if ((this.f5641b & 64) != 0) {
                        this.j = Collections.unmodifiableList(this.j);
                        this.f5641b &= -65;
                    }
                    list2 = this.j;
                } else {
                    list2 = c2Var2.g();
                }
                jVar.i = list2;
                c2<q, q.b, Object> c2Var3 = this.m;
                if (c2Var3 == null) {
                    if ((this.f5641b & RecyclerView.a0.FLAG_IGNORE) != 0) {
                        this.l = Collections.unmodifiableList(this.l);
                        this.f5641b &= -129;
                    }
                    list3 = this.l;
                } else {
                    list3 = c2Var3.g();
                }
                jVar.j = list3;
                c2<h, h.b, Object> c2Var4 = this.o;
                if (c2Var4 == null) {
                    if ((this.f5641b & RecyclerView.a0.FLAG_TMP_DETACHED) != 0) {
                        this.n = Collections.unmodifiableList(this.n);
                        this.f5641b &= -257;
                    }
                    list4 = this.n;
                } else {
                    list4 = c2Var4.g();
                }
                jVar.k = list4;
                if ((i2 & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                    g2<k, k.b, Object> g2Var = this.q;
                    jVar.l = g2Var == null ? this.p : g2Var.b();
                    i3 |= 4;
                }
                if ((i2 & 1024) != 0) {
                    g2<s, s.b, Object> g2Var2 = this.s;
                    jVar.m = g2Var2 == null ? this.r : g2Var2.b();
                    i3 |= 8;
                }
                if ((i2 & 2048) != 0) {
                    i3 |= 16;
                }
                jVar.n = this.t;
                jVar.f5635b = i3;
                onBuilt();
                return jVar;
            }

            public b c() {
                super.clear();
                this.f5642c = "";
                int i2 = this.f5641b & -2;
                this.f5641b = i2;
                this.f5643d = "";
                int i3 = i2 & -3;
                this.f5641b = i3;
                this.f5644e = s0.f5863e;
                this.f5641b = i3 & -5;
                this.f5645f = l0.emptyIntList();
                this.f5641b &= -9;
                this.f5646g = l0.emptyIntList();
                this.f5641b &= -17;
                c2<b, b.C0111b, Object> c2Var = this.i;
                if (c2Var == null) {
                    this.h = Collections.emptyList();
                    this.f5641b &= -33;
                } else {
                    c2Var.h();
                }
                c2<c, c.b, Object> c2Var2 = this.k;
                if (c2Var2 == null) {
                    this.j = Collections.emptyList();
                    this.f5641b &= -65;
                } else {
                    c2Var2.h();
                }
                c2<q, q.b, Object> c2Var3 = this.m;
                if (c2Var3 == null) {
                    this.l = Collections.emptyList();
                    this.f5641b &= -129;
                } else {
                    c2Var3.h();
                }
                c2<h, h.b, Object> c2Var4 = this.o;
                if (c2Var4 == null) {
                    this.n = Collections.emptyList();
                    this.f5641b &= -257;
                } else {
                    c2Var4.h();
                }
                g2<k, k.b, Object> g2Var = this.q;
                if (g2Var == null) {
                    this.p = null;
                } else {
                    g2Var.c();
                }
                this.f5641b &= -513;
                g2<s, s.b, Object> g2Var2 = this.s;
                if (g2Var2 == null) {
                    this.r = null;
                } else {
                    g2Var2.c();
                }
                int i4 = this.f5641b & -1025;
                this.f5641b = i4;
                this.t = "";
                this.f5641b = i4 & -2049;
                return this;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m161clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* renamed from: d */
            public b clone() {
                return (b) super.clone();
            }

            public final void e() {
                if ((this.f5641b & 32) == 0) {
                    this.h = new ArrayList(this.h);
                    this.f5641b |= 32;
                }
            }

            public final c2<c, c.b, Object> f() {
                if (this.k == null) {
                    this.k = new c2<>(this.j, (this.f5641b & 64) != 0, getParentForChildren(), isClean());
                    this.j = null;
                }
                return this.k;
            }

            public final c2<h, h.b, Object> g() {
                if (this.o == null) {
                    this.o = new c2<>(this.n, (this.f5641b & RecyclerView.a0.FLAG_TMP_DETACHED) != 0, getParentForChildren(), isClean());
                    this.n = null;
                }
                return this.o;
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return j.p;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.f5496b;
            }

            public final c2<b, b.C0111b, Object> h() {
                if (this.i == null) {
                    this.i = new c2<>(this.h, (this.f5641b & 32) != 0, getParentForChildren(), isClean());
                    this.h = null;
                }
                return this.i;
            }

            public final c2<q, q.b, Object> i() {
                if (this.m == null) {
                    this.m = new c2<>(this.l, (this.f5641b & RecyclerView.a0.FLAG_IGNORE) != 0, getParentForChildren(), isClean());
                    this.l = null;
                }
                return this.m;
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.f5497c;
                fVar.c(j.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.j1
            public final boolean isInitialized() {
                k kVar;
                h hVar;
                q qVar;
                c cVar;
                b bVar;
                int i2 = 0;
                while (true) {
                    c2<b, b.C0111b, Object> c2Var = this.i;
                    if (i2 < (c2Var == null ? this.h.size() : c2Var.m())) {
                        c2<b, b.C0111b, Object> c2Var2 = this.i;
                        if (c2Var2 == null) {
                            bVar = this.h.get(i2);
                        } else {
                            bVar = c2Var2.n(i2, false);
                        }
                        if (!bVar.isInitialized()) {
                            return false;
                        }
                        i2++;
                    } else {
                        int i3 = 0;
                        while (true) {
                            c2<c, c.b, Object> c2Var3 = this.k;
                            if (i3 < (c2Var3 == null ? this.j.size() : c2Var3.m())) {
                                c2<c, c.b, Object> c2Var4 = this.k;
                                if (c2Var4 == null) {
                                    cVar = this.j.get(i3);
                                } else {
                                    cVar = c2Var4.n(i3, false);
                                }
                                if (!cVar.isInitialized()) {
                                    return false;
                                }
                                i3++;
                            } else {
                                int i4 = 0;
                                while (true) {
                                    c2<q, q.b, Object> c2Var5 = this.m;
                                    if (i4 < (c2Var5 == null ? this.l.size() : c2Var5.m())) {
                                        c2<q, q.b, Object> c2Var6 = this.m;
                                        if (c2Var6 == null) {
                                            qVar = this.l.get(i4);
                                        } else {
                                            qVar = c2Var6.n(i4, false);
                                        }
                                        if (!qVar.isInitialized()) {
                                            return false;
                                        }
                                        i4++;
                                    } else {
                                        int i5 = 0;
                                        while (true) {
                                            c2<h, h.b, Object> c2Var7 = this.o;
                                            if (i5 < (c2Var7 == null ? this.n.size() : c2Var7.m())) {
                                                c2<h, h.b, Object> c2Var8 = this.o;
                                                if (c2Var8 == null) {
                                                    hVar = this.n.get(i5);
                                                } else {
                                                    hVar = c2Var8.n(i5, false);
                                                }
                                                if (!hVar.isInitialized()) {
                                                    return false;
                                                }
                                                i5++;
                                            } else {
                                                if ((this.f5641b & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                                                    g2<k, k.b, Object> g2Var = this.q;
                                                    if (g2Var == null) {
                                                        kVar = this.p;
                                                        if (kVar == null) {
                                                            kVar = k.z;
                                                        }
                                                    } else {
                                                        kVar = g2Var.e();
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
                } catch (o0 e2) {
                    jVar = (j) e2.f5447b;
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
                    this.f5641b |= 1;
                    this.f5642c = jVar.f5636c;
                    onChanged();
                }
                if (jVar.l()) {
                    this.f5641b |= 2;
                    this.f5643d = jVar.f5637d;
                    onChanged();
                }
                if (!jVar.f5638e.isEmpty()) {
                    if (this.f5644e.isEmpty()) {
                        this.f5644e = jVar.f5638e;
                        this.f5641b &= -5;
                    } else {
                        if ((this.f5641b & 4) == 0) {
                            this.f5644e = new s0(this.f5644e);
                            this.f5641b |= 4;
                        }
                        this.f5644e.addAll(jVar.f5638e);
                    }
                    onChanged();
                }
                if (!jVar.f5639f.isEmpty()) {
                    if (this.f5645f.isEmpty()) {
                        this.f5645f = jVar.f5639f;
                        this.f5641b &= -9;
                    } else {
                        if ((this.f5641b & 8) == 0) {
                            this.f5645f = l0.mutableCopy(this.f5645f);
                            this.f5641b |= 8;
                        }
                        this.f5645f.addAll(jVar.f5639f);
                    }
                    onChanged();
                }
                if (!jVar.f5640g.isEmpty()) {
                    if (this.f5646g.isEmpty()) {
                        this.f5646g = jVar.f5640g;
                        this.f5641b &= -17;
                    } else {
                        if ((this.f5641b & 16) == 0) {
                            this.f5646g = l0.mutableCopy(this.f5646g);
                            this.f5641b |= 16;
                        }
                        this.f5646g.addAll(jVar.f5640g);
                    }
                    onChanged();
                }
                c2<h, h.b, Object> c2Var = null;
                if (this.i == null) {
                    if (!jVar.h.isEmpty()) {
                        if (this.h.isEmpty()) {
                            this.h = jVar.h;
                            this.f5641b &= -33;
                        } else {
                            e();
                            this.h.addAll(jVar.h);
                        }
                        onChanged();
                    }
                } else if (!jVar.h.isEmpty()) {
                    if (this.i.s()) {
                        this.i.f5234a = null;
                        this.i = null;
                        this.h = jVar.h;
                        this.f5641b &= -33;
                        this.i = l0.alwaysUseFieldBuilders ? h() : null;
                    } else {
                        this.i.b(jVar.h);
                    }
                }
                if (this.k == null) {
                    if (!jVar.i.isEmpty()) {
                        if (this.j.isEmpty()) {
                            this.j = jVar.i;
                            this.f5641b &= -65;
                        } else {
                            if ((this.f5641b & 64) == 0) {
                                this.j = new ArrayList(this.j);
                                this.f5641b |= 64;
                            }
                            this.j.addAll(jVar.i);
                        }
                        onChanged();
                    }
                } else if (!jVar.i.isEmpty()) {
                    if (this.k.s()) {
                        this.k.f5234a = null;
                        this.k = null;
                        this.j = jVar.i;
                        this.f5641b &= -65;
                        this.k = l0.alwaysUseFieldBuilders ? f() : null;
                    } else {
                        this.k.b(jVar.i);
                    }
                }
                if (this.m == null) {
                    if (!jVar.j.isEmpty()) {
                        if (this.l.isEmpty()) {
                            this.l = jVar.j;
                            this.f5641b &= -129;
                        } else {
                            if ((this.f5641b & RecyclerView.a0.FLAG_IGNORE) == 0) {
                                this.l = new ArrayList(this.l);
                                this.f5641b |= RecyclerView.a0.FLAG_IGNORE;
                            }
                            this.l.addAll(jVar.j);
                        }
                        onChanged();
                    }
                } else if (!jVar.j.isEmpty()) {
                    if (this.m.s()) {
                        this.m.f5234a = null;
                        this.m = null;
                        this.l = jVar.j;
                        this.f5641b &= -129;
                        this.m = l0.alwaysUseFieldBuilders ? i() : null;
                    } else {
                        this.m.b(jVar.j);
                    }
                }
                if (this.o == null) {
                    if (!jVar.k.isEmpty()) {
                        if (this.n.isEmpty()) {
                            this.n = jVar.k;
                            this.f5641b &= -257;
                        } else {
                            if ((this.f5641b & RecyclerView.a0.FLAG_TMP_DETACHED) == 0) {
                                this.n = new ArrayList(this.n);
                                this.f5641b |= RecyclerView.a0.FLAG_TMP_DETACHED;
                            }
                            this.n.addAll(jVar.k);
                        }
                        onChanged();
                    }
                } else if (!jVar.k.isEmpty()) {
                    if (this.o.s()) {
                        this.o.f5234a = null;
                        this.o = null;
                        this.n = jVar.k;
                        this.f5641b &= -257;
                        if (l0.alwaysUseFieldBuilders) {
                            c2Var = g();
                        }
                        this.o = c2Var;
                    } else {
                        this.o.b(jVar.k);
                    }
                }
                if (jVar.k()) {
                    k e2 = jVar.e();
                    g2<k, k.b, Object> g2Var = this.q;
                    if (g2Var == null) {
                        if (!((this.f5641b & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0 || (kVar = this.p) == null || kVar == (kVar2 = k.z))) {
                            k.b J = kVar2.toBuilder();
                            J.o(kVar);
                            J.o(e2);
                            e2 = J.buildPartial();
                        }
                        this.p = e2;
                        onChanged();
                    } else {
                        g2Var.f(e2);
                    }
                    this.f5641b |= RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN;
                }
                if (jVar.m()) {
                    s h2 = jVar.h();
                    g2<s, s.b, Object> g2Var2 = this.s;
                    if (g2Var2 == null) {
                        if (!((this.f5641b & 1024) == 0 || (sVar = this.r) == null || sVar == (sVar2 = s.f5737d))) {
                            s.b a2 = sVar2.toBuilder();
                            a2.f(sVar);
                            a2.f(h2);
                            h2 = a2.buildPartial();
                        }
                        this.r = h2;
                        onChanged();
                    } else {
                        g2Var2.f(h2);
                    }
                    this.f5641b |= 1024;
                }
                if (jVar.n()) {
                    this.f5641b |= 2048;
                    this.t = jVar.n;
                    onChanged();
                }
                l(jVar.unknownFields);
                onChanged();
                return this;
            }

            public final b l(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            public final void maybeForceBuilderInitialization() {
                s sVar;
                k kVar;
                if (l0.alwaysUseFieldBuilders) {
                    h();
                    f();
                    i();
                    g();
                    g2<k, k.b, Object> g2Var = this.q;
                    if (g2Var == null) {
                        if (g2Var == null) {
                            kVar = this.p;
                            if (kVar == null) {
                                kVar = k.z;
                            }
                        } else {
                            kVar = g2Var.e();
                        }
                        this.q = new g2<>(kVar, getParentForChildren(), isClean());
                        this.p = null;
                    }
                    g2<s, s.b, Object> g2Var2 = this.s;
                    if (g2Var2 == null) {
                        if (g2Var2 == null) {
                            sVar = this.r;
                            if (sVar == null) {
                                sVar = s.f5737d;
                            }
                        } else {
                            sVar = g2Var2.e();
                        }
                        this.s = new g2<>(sVar, getParentForChildren(), isClean());
                        this.r = null;
                    }
                }
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof j) {
                    k((j) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m168setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m169setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m170setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m163clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m164getDefaultInstanceForType() {
                return j.p;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m165mergeFrom(f1 f1Var) {
                if (f1Var instanceof j) {
                    k((j) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m167mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            public b setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m162clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m166mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }
        }

        public j() {
            this.o = -1;
            this.f5636c = "";
            this.f5637d = "";
            this.f5638e = s0.f5863e;
            this.f5639f = l0.emptyIntList();
            this.f5640g = l0.emptyIntList();
            this.h = Collections.emptyList();
            this.i = Collections.emptyList();
            this.j = Collections.emptyList();
            this.k = Collections.emptyList();
            this.n = "";
        }

        public j(l0.b bVar, a aVar) {
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
            Object obj = this.f5636c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.f5636c = z;
            }
            return z;
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
            if ((l() && !f().equals(jVar.f())) || !this.f5638e.equals(jVar.f5638e) || !this.f5639f.equals(jVar.f5639f) || !this.f5640g.equals(jVar.f5640g) || !this.h.equals(jVar.h) || !this.i.equals(jVar.i) || !this.j.equals(jVar.j) || !this.k.equals(jVar.k) || k() != jVar.k()) {
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
            Object obj = this.f5637d;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.f5637d = z;
            }
            return z;
        }

        public int g() {
            return this.j.size();
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return p;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<j> getParserForType() {
            return q;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeStringSize = (this.f5635b & 1) != 0 ? l0.computeStringSize(1, this.f5636c) + 0 : 0;
            if ((this.f5635b & 2) != 0) {
                computeStringSize += l0.computeStringSize(2, this.f5637d);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.f5638e.size(); i4++) {
                i3 += l0.computeStringSizeNoTag(this.f5638e.b(i4));
            }
            int size = (this.f5638e.size() * 1) + computeStringSize + i3;
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
            if ((this.f5635b & 4) != 0) {
                size += m.z(8, e());
            }
            if ((this.f5635b & 8) != 0) {
                size += m.z(9, h());
            }
            int i9 = 0;
            for (int i10 = 0; i10 < this.f5639f.size(); i10++) {
                i9 += m.t(((m0) this.f5639f).g(i10));
            }
            int size2 = (this.f5639f.size() * 1) + size + i9;
            int i11 = 0;
            for (int i12 = 0; i12 < this.f5640g.size(); i12++) {
                i11 += m.t(((m0) this.f5640g).g(i12));
            }
            int size3 = (this.f5640g.size() * 1) + size2 + i11;
            if ((this.f5635b & 16) != 0) {
                size3 += l0.computeStringSize(12, this.n);
            }
            int serializedSize = this.unknownFields.getSerializedSize() + size3;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
            return this.unknownFields;
        }

        public s h() {
            s sVar = this.m;
            return sVar == null ? s.f5737d : sVar;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.f5496b.hashCode() + 779;
            if (j()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + d().hashCode();
            }
            if (l()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + f().hashCode();
            }
            if (this.f5638e.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + this.f5638e.hashCode();
            }
            if (this.f5639f.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 10, 53) + this.f5639f.hashCode();
            }
            if (this.f5640g.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 11, 53) + this.f5640g.hashCode();
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
            String z = jVar.z();
            if (jVar.o()) {
                this.n = z;
            }
            return z;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.f5497c;
            fVar.c(j.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
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
            return (this.f5635b & 1) != 0;
        }

        public boolean k() {
            return (this.f5635b & 4) != 0;
        }

        public boolean l() {
            return (this.f5635b & 2) != 0;
        }

        public boolean m() {
            return (this.f5635b & 8) != 0;
        }

        public boolean n() {
            return (this.f5635b & 16) != 0;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return p.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
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

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            if ((this.f5635b & 1) != 0) {
                l0.writeString(mVar, 1, this.f5636c);
            }
            if ((this.f5635b & 2) != 0) {
                l0.writeString(mVar, 2, this.f5637d);
            }
            for (int i2 = 0; i2 < this.f5638e.size(); i2++) {
                l0.writeString(mVar, 3, this.f5638e.b(i2));
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
            if ((this.f5635b & 4) != 0) {
                mVar.k0(8, e());
            }
            if ((this.f5635b & 8) != 0) {
                mVar.k0(9, h());
            }
            for (int i7 = 0; i7 < this.f5639f.size(); i7++) {
                mVar.i0(10, ((m0) this.f5639f).g(i7));
            }
            for (int i8 = 0; i8 < this.f5640g.size(); i8++) {
                mVar.i0(11, ((m0) this.f5640g).g(i8));
            }
            if ((this.f5635b & 16) != 0) {
                l0.writeString(mVar, 12, this.n);
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m158getDefaultInstanceForType() {
            return p;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m159newBuilderForType() {
            return p.toBuilder();
        }
    }

    public static final class k extends l0.e<k> implements Object {
        @Deprecated
        public static final w1<k> A = new a();
        public static final k z = new k();

        /* renamed from: c  reason: collision with root package name */
        public int f5647c;

        /* renamed from: d  reason: collision with root package name */
        public volatile Object f5648d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Object f5649e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f5650f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5651g;
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
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                k kVar2 = new k();
                if (zVar != null) {
                    q2.b b2 = q2.b();
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
                                    kVar2.f5647c = 1 | kVar2.f5647c;
                                    kVar2.f5648d = n;
                                    continue;
                                case 66:
                                    j n2 = kVar.n();
                                    kVar2.f5647c |= 2;
                                    kVar2.f5649e = n2;
                                    continue;
                                case 72:
                                    int p = kVar.p();
                                    if (c.b(p) == null) {
                                        b2.h(9, p);
                                        continue;
                                    } else {
                                        kVar2.f5647c |= 32;
                                        kVar2.i = p;
                                    }
                                case 80:
                                    kVar2.f5647c |= 4;
                                    kVar2.f5650f = kVar.m();
                                    continue;
                                case 90:
                                    j n3 = kVar.n();
                                    kVar2.f5647c |= 64;
                                    kVar2.j = n3;
                                    continue;
                                case RecyclerView.a0.FLAG_IGNORE:
                                    kVar2.f5647c |= RecyclerView.a0.FLAG_IGNORE;
                                    kVar2.k = kVar.m();
                                    continue;
                                case 136:
                                    kVar2.f5647c |= RecyclerView.a0.FLAG_TMP_DETACHED;
                                    kVar2.l = kVar.m();
                                    continue;
                                case 144:
                                    kVar2.f5647c |= RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN;
                                    kVar2.m = kVar.m();
                                    continue;
                                case 160:
                                    kVar2.f5647c |= 8;
                                    kVar2.f5651g = kVar.m();
                                    continue;
                                case 184:
                                    kVar2.f5647c |= 2048;
                                    kVar2.o = kVar.m();
                                    continue;
                                case 216:
                                    kVar2.f5647c |= 16;
                                    kVar2.h = kVar.m();
                                    continue;
                                case 248:
                                    kVar2.f5647c |= 4096;
                                    kVar2.p = kVar.m();
                                    continue;
                                case 290:
                                    j n4 = kVar.n();
                                    kVar2.f5647c |= RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST;
                                    kVar2.q = n4;
                                    continue;
                                case 298:
                                    j n5 = kVar.n();
                                    kVar2.f5647c |= 16384;
                                    kVar2.r = n5;
                                    continue;
                                case 314:
                                    j n6 = kVar.n();
                                    kVar2.f5647c |= 32768;
                                    kVar2.s = n6;
                                    continue;
                                case 322:
                                    j n7 = kVar.n();
                                    kVar2.f5647c |= 65536;
                                    kVar2.t = n7;
                                    continue;
                                case 330:
                                    j n8 = kVar.n();
                                    kVar2.f5647c |= 131072;
                                    kVar2.u = n8;
                                    continue;
                                case 336:
                                    kVar2.f5647c |= 1024;
                                    kVar2.n = kVar.m();
                                    continue;
                                case 354:
                                    j n9 = kVar.n();
                                    kVar2.f5647c |= 262144;
                                    kVar2.v = n9;
                                    continue;
                                case 362:
                                    j n10 = kVar.n();
                                    kVar2.f5647c |= 524288;
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
                        } catch (o0 e2) {
                            e2.f5447b = kVar2;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = kVar2;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                kVar2.x = Collections.unmodifiableList(kVar2.x);
                            }
                            kVar2.unknownFields = b2.build();
                            kVar2.f5370b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        kVar2.x = Collections.unmodifiableList(kVar2.x);
                    }
                    kVar2.unknownFields = b2.build();
                    kVar2.f5370b.x();
                    return kVar2;
                }
                throw null;
            }
        }

        public static final class b extends l0.d<k, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f5652c;

            /* renamed from: d  reason: collision with root package name */
            public Object f5653d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f5654e = "";

            /* renamed from: f  reason: collision with root package name */
            public boolean f5655f;

            /* renamed from: g  reason: collision with root package name */
            public boolean f5656g;
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
            public c2<t, t.b, Object> y;

            public b() {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public l0.b m173addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                k j2 = buildPartial();
                if (j2.isInitialized()) {
                    return j2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j2);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public l0.b m175clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return k.z;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.z;
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b h(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.A;
                fVar.c(k.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.d, c.b.d.j1
            public final boolean isInitialized() {
                t tVar;
                int i2 = 0;
                while (true) {
                    c2<t, t.b, Object> c2Var = this.y;
                    if (i2 < (c2Var == null ? this.x.size() : c2Var.m())) {
                        c2<t, t.b, Object> c2Var2 = this.y;
                        if (c2Var2 == null) {
                            tVar = this.x.get(i2);
                        } else {
                            tVar = c2Var2.n(i2, false);
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
                int i2 = this.f5652c;
                int i3 = (i2 & 1) != 0 ? 1 : 0;
                kVar.f5648d = this.f5653d;
                if ((i2 & 2) != 0) {
                    i3 |= 2;
                }
                kVar.f5649e = this.f5654e;
                if ((i2 & 4) != 0) {
                    kVar.f5650f = this.f5655f;
                    i3 |= 4;
                }
                if ((i2 & 8) != 0) {
                    kVar.f5651g = this.f5656g;
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
                if ((i2 & RecyclerView.a0.FLAG_IGNORE) != 0) {
                    kVar.k = this.k;
                    i3 |= RecyclerView.a0.FLAG_IGNORE;
                }
                if ((i2 & RecyclerView.a0.FLAG_TMP_DETACHED) != 0) {
                    kVar.l = this.l;
                    i3 |= RecyclerView.a0.FLAG_TMP_DETACHED;
                }
                if ((i2 & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                    kVar.m = this.m;
                    i3 |= RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN;
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
                if ((i2 & RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != 0) {
                    i3 |= RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST;
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
                c2<t, t.b, Object> c2Var = this.y;
                if (c2Var == null) {
                    if ((this.f5652c & 1048576) != 0) {
                        this.x = Collections.unmodifiableList(this.x);
                        this.f5652c &= -1048577;
                    }
                    list = this.x;
                } else {
                    list = c2Var.g();
                }
                kVar.x = list;
                kVar.f5647c = i3;
                onBuilt();
                return kVar;
            }

            public b k() {
                super.clear();
                this.f5653d = "";
                int i2 = this.f5652c & -2;
                this.f5652c = i2;
                this.f5654e = "";
                int i3 = i2 & -3;
                this.f5652c = i3;
                this.f5655f = false;
                int i4 = i3 & -5;
                this.f5652c = i4;
                this.f5656g = false;
                int i5 = i4 & -9;
                this.f5652c = i5;
                this.h = false;
                int i6 = i5 & -17;
                this.f5652c = i6;
                this.i = 1;
                int i7 = i6 & -33;
                this.f5652c = i7;
                this.j = "";
                int i8 = i7 & -65;
                this.f5652c = i8;
                this.k = false;
                int i9 = i8 & -129;
                this.f5652c = i9;
                this.l = false;
                int i10 = i9 & -257;
                this.f5652c = i10;
                this.m = false;
                int i11 = i10 & -513;
                this.f5652c = i11;
                this.n = false;
                int i12 = i11 & -1025;
                this.f5652c = i12;
                this.o = false;
                int i13 = i12 & -2049;
                this.f5652c = i13;
                this.p = false;
                int i14 = i13 & -4097;
                this.f5652c = i14;
                this.q = "";
                int i15 = i14 & -8193;
                this.f5652c = i15;
                this.r = "";
                int i16 = i15 & -16385;
                this.f5652c = i16;
                this.s = "";
                int i17 = i16 & -32769;
                this.f5652c = i17;
                this.t = "";
                int i18 = i17 & -65537;
                this.f5652c = i18;
                this.u = "";
                int i19 = i18 & -131073;
                this.f5652c = i19;
                this.v = "";
                int i20 = i19 & -262145;
                this.f5652c = i20;
                this.w = "";
                this.f5652c = -524289 & i20;
                c2<t, t.b, Object> c2Var = this.y;
                if (c2Var == null) {
                    this.x = Collections.emptyList();
                    this.f5652c &= -1048577;
                } else {
                    c2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final c2<t, t.b, Object> m() {
                if (this.y == null) {
                    this.y = new c2<>(this.x, (this.f5652c & 1048576) != 0, getParentForChildren(), isClean());
                    this.x = null;
                }
                return this.y;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof k) {
                    o((k) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
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
                } catch (o0 e2) {
                    kVar2 = (k) e2.f5447b;
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
                    this.f5652c |= 1;
                    this.f5653d = kVar.f5648d;
                    onChanged();
                }
                if (kVar.x()) {
                    this.f5652c |= 2;
                    this.f5654e = kVar.f5649e;
                    onChanged();
                }
                if (kVar.w()) {
                    boolean z = kVar.f5650f;
                    this.f5652c |= 4;
                    this.f5655f = z;
                    onChanged();
                }
                if (kVar.u()) {
                    boolean z2 = kVar.f5651g;
                    this.f5652c |= 8;
                    this.f5656g = z2;
                    onChanged();
                }
                if (kVar.z()) {
                    boolean z3 = kVar.h;
                    this.f5652c |= 16;
                    this.h = z3;
                    onChanged();
                }
                if (kVar.B()) {
                    c b2 = c.b(kVar.i);
                    if (b2 == null) {
                        b2 = c.SPEED;
                    }
                    this.f5652c |= 32;
                    this.i = b2.f5661b;
                    onChanged();
                }
                if (kVar.t()) {
                    this.f5652c |= 64;
                    this.j = kVar.j;
                    onChanged();
                }
                if (kVar.q()) {
                    boolean z4 = kVar.k;
                    this.f5652c |= RecyclerView.a0.FLAG_IGNORE;
                    this.k = z4;
                    onChanged();
                }
                if (kVar.v()) {
                    boolean z5 = kVar.l;
                    this.f5652c |= RecyclerView.a0.FLAG_TMP_DETACHED;
                    this.l = z5;
                    onChanged();
                }
                if (kVar.G()) {
                    boolean z6 = kVar.m;
                    this.f5652c |= RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN;
                    this.m = z6;
                    onChanged();
                }
                if (kVar.D()) {
                    boolean z7 = kVar.n;
                    this.f5652c |= 1024;
                    this.n = z7;
                    onChanged();
                }
                if (kVar.s()) {
                    boolean z8 = kVar.o;
                    this.f5652c |= 2048;
                    this.o = z8;
                    onChanged();
                }
                if (kVar.p()) {
                    boolean z9 = kVar.p;
                    this.f5652c |= 4096;
                    this.p = z9;
                    onChanged();
                }
                if (kVar.A()) {
                    this.f5652c |= RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST;
                    this.q = kVar.q;
                    onChanged();
                }
                if (kVar.r()) {
                    this.f5652c |= 16384;
                    this.r = kVar.r;
                    onChanged();
                }
                if (kVar.I()) {
                    this.f5652c |= 32768;
                    this.s = kVar.s;
                    onChanged();
                }
                if (kVar.C()) {
                    this.f5652c |= 65536;
                    this.t = kVar.t;
                    onChanged();
                }
                if (kVar.F()) {
                    this.f5652c |= 131072;
                    this.u = kVar.u;
                    onChanged();
                }
                if (kVar.E()) {
                    this.f5652c |= 262144;
                    this.v = kVar.v;
                    onChanged();
                }
                if (kVar.H()) {
                    this.f5652c |= 524288;
                    this.w = kVar.w;
                    onChanged();
                }
                if (this.y == null) {
                    if (!kVar.x.isEmpty()) {
                        if (this.x.isEmpty()) {
                            this.x = kVar.x;
                            this.f5652c &= -1048577;
                        } else {
                            if ((this.f5652c & 1048576) == 0) {
                                this.x = new ArrayList(this.x);
                                this.f5652c |= 1048576;
                            }
                            this.x.addAll(kVar.x);
                        }
                        onChanged();
                    }
                } else if (!kVar.x.isEmpty()) {
                    if (this.y.s()) {
                        c2<t, t.b, Object> c2Var = null;
                        this.y.f5234a = null;
                        this.y = null;
                        this.x = kVar.x;
                        this.f5652c &= -1048577;
                        if (l0.alwaysUseFieldBuilders) {
                            c2Var = m();
                        }
                        this.y = c2Var;
                    } else {
                        this.y.b(kVar.x);
                    }
                }
                f(kVar);
                q(kVar.unknownFields);
                onChanged();
                return this;
            }

            public final b q(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public l0.b m182setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public l0.b m183setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public l0.b m184setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(a aVar) {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m174build() {
                k j2 = buildPartial();
                if (j2.isInitialized()) {
                    return j2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j2);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public l0.b m177clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m178getDefaultInstanceForType() {
                return k.z;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m179mergeFrom(f1 f1Var) {
                if (f1Var instanceof k) {
                    o((k) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public l0.b m181mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            public f1.a setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public f1.a setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public f1.a m176clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public f1.a m180mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public enum c implements Object {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);
            

            /* renamed from: b  reason: collision with root package name */
            public final int f5661b;

            /* access modifiers changed from: public */
            static {
                values();
            }

            /* access modifiers changed from: public */
            c(int i) {
                this.f5661b = i;
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
                return this.f5661b;
            }
        }

        public k() {
            this.y = -1;
            this.f5648d = "";
            this.f5649e = "";
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

        public k(l0.d dVar, a aVar) {
            super(dVar);
            this.y = -1;
        }

        public boolean A() {
            return (this.f5647c & RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != 0;
        }

        public boolean B() {
            return (this.f5647c & 32) != 0;
        }

        public boolean C() {
            return (this.f5647c & 65536) != 0;
        }

        public boolean D() {
            return (this.f5647c & 1024) != 0;
        }

        public boolean E() {
            return (this.f5647c & 262144) != 0;
        }

        public boolean F() {
            return (this.f5647c & 131072) != 0;
        }

        public boolean G() {
            return (this.f5647c & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0;
        }

        public boolean H() {
            return (this.f5647c & 524288) != 0;
        }

        public boolean I() {
            return (this.f5647c & 32768) != 0;
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
            if ((w() && this.f5650f != kVar.f5650f) || u() != kVar.u()) {
                return false;
            }
            if ((u() && this.f5651g != kVar.f5651g) || z() != kVar.z()) {
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
            String z2 = jVar.z();
            if (jVar.o()) {
                this.r = z2;
            }
            return z2;
        }

        public String g() {
            Object obj = this.j;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z2 = jVar.z();
            if (jVar.o()) {
                this.j = z2;
            }
            return z2;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return z;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<k> getParserForType() {
            return A;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeStringSize = (this.f5647c & 1) != 0 ? l0.computeStringSize(1, this.f5648d) + 0 : 0;
            if ((this.f5647c & 2) != 0) {
                computeStringSize += l0.computeStringSize(8, this.f5649e);
            }
            if ((this.f5647c & 32) != 0) {
                computeStringSize += m.j(9, this.i);
            }
            if ((this.f5647c & 4) != 0) {
                computeStringSize += m.c(10, this.f5650f);
            }
            if ((this.f5647c & 64) != 0) {
                computeStringSize += l0.computeStringSize(11, this.j);
            }
            if ((this.f5647c & RecyclerView.a0.FLAG_IGNORE) != 0) {
                computeStringSize += m.c(16, this.k);
            }
            if ((this.f5647c & RecyclerView.a0.FLAG_TMP_DETACHED) != 0) {
                computeStringSize += m.c(17, this.l);
            }
            if ((this.f5647c & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                computeStringSize += m.c(18, this.m);
            }
            if ((this.f5647c & 8) != 0) {
                computeStringSize += m.c(20, this.f5651g);
            }
            if ((this.f5647c & 2048) != 0) {
                computeStringSize += m.c(23, this.o);
            }
            if ((this.f5647c & 16) != 0) {
                computeStringSize += m.c(27, this.h);
            }
            if ((this.f5647c & 4096) != 0) {
                computeStringSize += m.c(31, this.p);
            }
            if ((this.f5647c & RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != 0) {
                computeStringSize += l0.computeStringSize(36, this.q);
            }
            if ((this.f5647c & 16384) != 0) {
                computeStringSize += l0.computeStringSize(37, this.r);
            }
            if ((this.f5647c & 32768) != 0) {
                computeStringSize += l0.computeStringSize(39, this.s);
            }
            if ((this.f5647c & 65536) != 0) {
                computeStringSize += l0.computeStringSize(40, this.t);
            }
            if ((this.f5647c & 131072) != 0) {
                computeStringSize += l0.computeStringSize(41, this.u);
            }
            if ((this.f5647c & 1024) != 0) {
                computeStringSize += m.c(42, this.n);
            }
            if ((this.f5647c & 262144) != 0) {
                computeStringSize += l0.computeStringSize(44, this.v);
            }
            if ((this.f5647c & 524288) != 0) {
                computeStringSize += l0.computeStringSize(45, this.w);
            }
            for (int i3 = 0; i3 < this.x.size(); i3++) {
                computeStringSize += m.z(b.s.h.MAX_BIND_PARAMETER_CNT, this.x.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + computeStringSize;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
            return this.unknownFields;
        }

        public String h() {
            Object obj = this.f5649e;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z2 = jVar.z();
            if (jVar.o()) {
                this.f5649e = z2;
            }
            return z2;
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
                hashCode = c.a.a.a.a.a(hashCode, 37, 10, 53) + n0.c(this.f5650f);
            }
            if (u()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 20, 53) + n0.c(this.f5651g);
            }
            if (z()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 27, 53) + n0.c(this.h);
            }
            if (B()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 9, 53) + this.i;
            }
            if (t()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 11, 53) + g().hashCode();
            }
            if (q()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 16, 53) + n0.c(this.k);
            }
            if (v()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 17, 53) + n0.c(this.l);
            }
            if (G()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 18, 53) + n0.c(this.m);
            }
            if (D()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 42, 53) + n0.c(this.n);
            }
            if (s()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 23, 53) + n0.c(this.o);
            }
            if (p()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 31, 53) + n0.c(this.p);
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
                hashCode = c.a.a.a.a.a(hashCode, 37, b.s.h.MAX_BIND_PARAMETER_CNT, 53) + this.x.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public String i() {
            Object obj = this.f5648d;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z2 = jVar.z();
            if (jVar.o()) {
                this.f5648d = z2;
            }
            return z2;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.A;
            fVar.c(k.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.l0.e, c.b.d.j1
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
            String z2 = jVar.z();
            if (jVar.o()) {
                this.q = z2;
            }
            return z2;
        }

        public String k() {
            Object obj = this.t;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z2 = jVar.z();
            if (jVar.o()) {
                this.t = z2;
            }
            return z2;
        }

        public String l() {
            Object obj = this.v;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z2 = jVar.z();
            if (jVar.o()) {
                this.v = z2;
            }
            return z2;
        }

        public String m() {
            Object obj = this.u;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z2 = jVar.z();
            if (jVar.o()) {
                this.u = z2;
            }
            return z2;
        }

        public String n() {
            Object obj = this.w;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z2 = jVar.z();
            if (jVar.o()) {
                this.w = z2;
            }
            return z2;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return z.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new k();
        }

        public String o() {
            Object obj = this.s;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z2 = jVar.z();
            if (jVar.o()) {
                this.s = z2;
            }
            return z2;
        }

        public boolean p() {
            return (this.f5647c & 4096) != 0;
        }

        public boolean q() {
            return (this.f5647c & RecyclerView.a0.FLAG_IGNORE) != 0;
        }

        public boolean r() {
            return (this.f5647c & 16384) != 0;
        }

        public boolean s() {
            return (this.f5647c & 2048) != 0;
        }

        public boolean t() {
            return (this.f5647c & 64) != 0;
        }

        @Deprecated
        public boolean u() {
            return (this.f5647c & 8) != 0;
        }

        public boolean v() {
            return (this.f5647c & RecyclerView.a0.FLAG_TMP_DETACHED) != 0;
        }

        public boolean w() {
            return (this.f5647c & 4) != 0;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            l0.e<MessageType>.a d2 = d();
            if ((this.f5647c & 1) != 0) {
                l0.writeString(mVar, 1, this.f5648d);
            }
            if ((this.f5647c & 2) != 0) {
                l0.writeString(mVar, 8, this.f5649e);
            }
            if ((this.f5647c & 32) != 0) {
                mVar.i0(9, this.i);
            }
            if ((this.f5647c & 4) != 0) {
                mVar.Y(10, this.f5650f);
            }
            if ((this.f5647c & 64) != 0) {
                l0.writeString(mVar, 11, this.j);
            }
            if ((this.f5647c & RecyclerView.a0.FLAG_IGNORE) != 0) {
                mVar.Y(16, this.k);
            }
            if ((this.f5647c & RecyclerView.a0.FLAG_TMP_DETACHED) != 0) {
                mVar.Y(17, this.l);
            }
            if ((this.f5647c & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0) {
                mVar.Y(18, this.m);
            }
            if ((this.f5647c & 8) != 0) {
                mVar.Y(20, this.f5651g);
            }
            if ((this.f5647c & 2048) != 0) {
                mVar.Y(23, this.o);
            }
            if ((this.f5647c & 16) != 0) {
                mVar.Y(27, this.h);
            }
            if ((this.f5647c & 4096) != 0) {
                mVar.Y(31, this.p);
            }
            if ((this.f5647c & RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != 0) {
                l0.writeString(mVar, 36, this.q);
            }
            if ((this.f5647c & 16384) != 0) {
                l0.writeString(mVar, 37, this.r);
            }
            if ((this.f5647c & 32768) != 0) {
                l0.writeString(mVar, 39, this.s);
            }
            if ((this.f5647c & 65536) != 0) {
                l0.writeString(mVar, 40, this.t);
            }
            if ((this.f5647c & 131072) != 0) {
                l0.writeString(mVar, 41, this.u);
            }
            if ((this.f5647c & 1024) != 0) {
                mVar.Y(42, this.n);
            }
            if ((this.f5647c & 262144) != 0) {
                l0.writeString(mVar, 44, this.v);
            }
            if ((this.f5647c & 524288) != 0) {
                l0.writeString(mVar, 45, this.w);
            }
            for (int i2 = 0; i2 < this.x.size(); i2++) {
                mVar.k0(b.s.h.MAX_BIND_PARAMETER_CNT, this.x.get(i2));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        public boolean x() {
            return (this.f5647c & 2) != 0;
        }

        public boolean y() {
            return (this.f5647c & 1) != 0;
        }

        public boolean z() {
            return (this.f5647c & 16) != 0;
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m171getDefaultInstanceForType() {
            return z;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m172newBuilderForType() {
            return z.toBuilder();
        }
    }

    public static final class l extends l0.e<l> implements Object {
        public static final l j = new l();
        @Deprecated
        public static final w1<l> k = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f5662c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5663d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5664e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f5665f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5666g;
        public List<t> h;
        public byte i;

        public static class a extends c<l> {
            /* JADX DEBUG: Multi-variable search result rejected for r5v14, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                l lVar = new l();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 8) {
                                    lVar.f5662c |= 1;
                                    lVar.f5663d = kVar.m();
                                } else if (G == 16) {
                                    lVar.f5662c |= 2;
                                    lVar.f5664e = kVar.m();
                                } else if (G == 24) {
                                    lVar.f5662c |= 4;
                                    lVar.f5665f = kVar.m();
                                } else if (G == 56) {
                                    lVar.f5662c |= 8;
                                    lVar.f5666g = kVar.m();
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
                        } catch (o0 e2) {
                            e2.f5447b = lVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = lVar;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                lVar.h = Collections.unmodifiableList(lVar.h);
                            }
                            lVar.unknownFields = b2.build();
                            lVar.f5370b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        lVar.h = Collections.unmodifiableList(lVar.h);
                    }
                    lVar.unknownFields = b2.build();
                    lVar.f5370b.x();
                    return lVar;
                }
                throw null;
            }
        }

        public static final class b extends l0.d<l, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f5667c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f5668d;

            /* renamed from: e  reason: collision with root package name */
            public boolean f5669e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f5670f;

            /* renamed from: g  reason: collision with root package name */
            public boolean f5671g;
            public List<t> h = Collections.emptyList();
            public c2<t, t.b, Object> i;

            public b() {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public l0.b m187addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                l j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public l0.b m189clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return l.j;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.B;
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b h(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.C;
                fVar.c(l.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.d, c.b.d.j1
            public final boolean isInitialized() {
                t tVar;
                int i2 = 0;
                while (true) {
                    c2<t, t.b, Object> c2Var = this.i;
                    if (i2 < (c2Var == null ? this.h.size() : c2Var.m())) {
                        c2<t, t.b, Object> c2Var2 = this.i;
                        if (c2Var2 == null) {
                            tVar = this.h.get(i2);
                        } else {
                            tVar = c2Var2.n(i2, false);
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
                int i3 = this.f5667c;
                if ((i3 & 1) != 0) {
                    lVar.f5663d = this.f5668d;
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if ((i3 & 2) != 0) {
                    lVar.f5664e = this.f5669e;
                    i2 |= 2;
                }
                if ((i3 & 4) != 0) {
                    lVar.f5665f = this.f5670f;
                    i2 |= 4;
                }
                if ((i3 & 8) != 0) {
                    lVar.f5666g = this.f5671g;
                    i2 |= 8;
                }
                c2<t, t.b, Object> c2Var = this.i;
                if (c2Var == null) {
                    if ((this.f5667c & 16) != 0) {
                        this.h = Collections.unmodifiableList(this.h);
                        this.f5667c &= -17;
                    }
                    list = this.h;
                } else {
                    list = c2Var.g();
                }
                lVar.h = list;
                lVar.f5662c = i2;
                onBuilt();
                return lVar;
            }

            public b k() {
                super.clear();
                this.f5668d = false;
                int i2 = this.f5667c & -2;
                this.f5667c = i2;
                this.f5669e = false;
                int i3 = i2 & -3;
                this.f5667c = i3;
                this.f5670f = false;
                int i4 = i3 & -5;
                this.f5667c = i4;
                this.f5671g = false;
                this.f5667c = i4 & -9;
                c2<t, t.b, Object> c2Var = this.i;
                if (c2Var == null) {
                    this.h = Collections.emptyList();
                    this.f5667c &= -17;
                } else {
                    c2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final c2<t, t.b, Object> m() {
                if (this.i == null) {
                    this.i = new c2<>(this.h, (this.f5667c & 16) != 0, getParentForChildren(), isClean());
                    this.h = null;
                }
                return this.i;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof l) {
                    o((l) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
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
                } catch (o0 e2) {
                    lVar = (l) e2.f5447b;
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
                    boolean z = lVar.f5663d;
                    this.f5667c |= 1;
                    this.f5668d = z;
                    onChanged();
                }
                if (lVar.i()) {
                    boolean z2 = lVar.f5664e;
                    this.f5667c |= 2;
                    this.f5669e = z2;
                    onChanged();
                }
                if (lVar.f()) {
                    boolean z3 = lVar.f5665f;
                    this.f5667c |= 4;
                    this.f5670f = z3;
                    onChanged();
                }
                if (lVar.g()) {
                    boolean z4 = lVar.f5666g;
                    this.f5667c |= 8;
                    this.f5671g = z4;
                    onChanged();
                }
                if (this.i == null) {
                    if (!lVar.h.isEmpty()) {
                        if (this.h.isEmpty()) {
                            this.h = lVar.h;
                            this.f5667c &= -17;
                        } else {
                            if ((this.f5667c & 16) == 0) {
                                this.h = new ArrayList(this.h);
                                this.f5667c |= 16;
                            }
                            this.h.addAll(lVar.h);
                        }
                        onChanged();
                    }
                } else if (!lVar.h.isEmpty()) {
                    if (this.i.s()) {
                        c2<t, t.b, Object> c2Var = null;
                        this.i.f5234a = null;
                        this.i = null;
                        this.h = lVar.h;
                        this.f5667c &= -17;
                        if (l0.alwaysUseFieldBuilders) {
                            c2Var = m();
                        }
                        this.i = c2Var;
                    } else {
                        this.i.b(lVar.h);
                    }
                }
                f(lVar);
                q(lVar.unknownFields);
                onChanged();
                return this;
            }

            public final b q(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public l0.b m196setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public l0.b m197setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public l0.b m198setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(a aVar) {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m188build() {
                l j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public l0.b m191clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m192getDefaultInstanceForType() {
                return l.j;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m193mergeFrom(f1 f1Var) {
                if (f1Var instanceof l) {
                    o((l) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public l0.b m195mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            public f1.a setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public f1.a setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public f1.a m190clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public f1.a m194mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public l() {
            this.i = -1;
            this.h = Collections.emptyList();
        }

        public l(l0.d dVar, a aVar) {
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
            if ((h() && this.f5663d != lVar.f5663d) || i() != lVar.i()) {
                return false;
            }
            if ((i() && this.f5664e != lVar.f5664e) || f() != lVar.f()) {
                return false;
            }
            if ((!f() || this.f5665f == lVar.f5665f) && g() == lVar.g()) {
                return (!g() || this.f5666g == lVar.f5666g) && this.h.equals(lVar.h) && this.unknownFields.equals(lVar.unknownFields) && c().equals(lVar.c());
            }
            return false;
        }

        public boolean f() {
            return (this.f5662c & 4) != 0;
        }

        public boolean g() {
            return (this.f5662c & 8) != 0;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return j;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<l> getParserForType() {
            return k;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int c2 = (this.f5662c & 1) != 0 ? m.c(1, this.f5663d) + 0 : 0;
            if ((this.f5662c & 2) != 0) {
                c2 += m.c(2, this.f5664e);
            }
            if ((this.f5662c & 4) != 0) {
                c2 += m.c(3, this.f5665f);
            }
            if ((this.f5662c & 8) != 0) {
                c2 += m.c(7, this.f5666g);
            }
            for (int i3 = 0; i3 < this.h.size(); i3++) {
                c2 += m.z(b.s.h.MAX_BIND_PARAMETER_CNT, this.h.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + c2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean h() {
            return (this.f5662c & 1) != 0;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.B.hashCode() + 779;
            if (h()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + n0.c(this.f5663d);
            }
            if (i()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + n0.c(this.f5664e);
            }
            if (f()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + n0.c(this.f5665f);
            }
            if (g()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 7, 53) + n0.c(this.f5666g);
            }
            if (this.h.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.s.h.MAX_BIND_PARAMETER_CNT, 53) + this.h.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public boolean i() {
            return (this.f5662c & 2) != 0;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.C;
            fVar.c(l.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.l0.e, c.b.d.j1
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

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return j.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new l();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            l0.e<MessageType>.a d2 = d();
            if ((this.f5662c & 1) != 0) {
                mVar.Y(1, this.f5663d);
            }
            if ((this.f5662c & 2) != 0) {
                mVar.Y(2, this.f5664e);
            }
            if ((this.f5662c & 4) != 0) {
                mVar.Y(3, this.f5665f);
            }
            if ((this.f5662c & 8) != 0) {
                mVar.Y(7, this.f5666g);
            }
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                mVar.k0(b.s.h.MAX_BIND_PARAMETER_CNT, this.h.get(i2));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m185getDefaultInstanceForType() {
            return j;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m186newBuilderForType() {
            return j.toBuilder();
        }
    }

    public static final class m extends l0 implements k1 {
        public static final m j = new m();
        @Deprecated
        public static final w1<m> k = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f5672b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f5673c;

        /* renamed from: d  reason: collision with root package name */
        public volatile Object f5674d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Object f5675e;

        /* renamed from: f  reason: collision with root package name */
        public n f5676f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5677g;
        public boolean h;
        public byte i;

        public static class a extends c<m> {
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                m mVar = new m();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 10) {
                                    j n = kVar.n();
                                    mVar.f5672b = 1 | mVar.f5672b;
                                    mVar.f5673c = n;
                                } else if (G == 18) {
                                    j n2 = kVar.n();
                                    mVar.f5672b |= 2;
                                    mVar.f5674d = n2;
                                } else if (G == 26) {
                                    j n3 = kVar.n();
                                    mVar.f5672b |= 4;
                                    mVar.f5675e = n3;
                                } else if (G == 34) {
                                    n.b h = (mVar.f5672b & 8) != 0 ? mVar.f5676f.toBuilder() : null;
                                    n nVar = (n) kVar.w(n.i, zVar);
                                    mVar.f5676f = nVar;
                                    if (h != null) {
                                        h.o(nVar);
                                        mVar.f5676f = h.buildPartial();
                                    }
                                    mVar.f5672b |= 8;
                                } else if (G == 40) {
                                    mVar.f5672b |= 16;
                                    mVar.f5677g = kVar.m();
                                } else if (G == 48) {
                                    mVar.f5672b |= 32;
                                    mVar.h = kVar.m();
                                } else if (!mVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (o0 e2) {
                            e2.f5447b = mVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = mVar;
                            throw o0Var;
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

        public static final class b extends l0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f5678b;

            /* renamed from: c  reason: collision with root package name */
            public Object f5679c = "";

            /* renamed from: d  reason: collision with root package name */
            public Object f5680d = "";

            /* renamed from: e  reason: collision with root package name */
            public Object f5681e = "";

            /* renamed from: f  reason: collision with root package name */
            public n f5682f;

            /* renamed from: g  reason: collision with root package name */
            public g2<n, n.b, Object> f5683g;
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
                int i2 = this.f5678b;
                int i3 = (i2 & 1) != 0 ? 1 : 0;
                mVar.f5673c = this.f5679c;
                if ((i2 & 2) != 0) {
                    i3 |= 2;
                }
                mVar.f5674d = this.f5680d;
                if ((i2 & 4) != 0) {
                    i3 |= 4;
                }
                mVar.f5675e = this.f5681e;
                if ((i2 & 8) != 0) {
                    g2<n, n.b, Object> g2Var = this.f5683g;
                    mVar.f5676f = g2Var == null ? this.f5682f : g2Var.b();
                    i3 |= 8;
                }
                if ((i2 & 16) != 0) {
                    mVar.f5677g = this.h;
                    i3 |= 16;
                }
                if ((i2 & 32) != 0) {
                    mVar.h = this.i;
                    i3 |= 32;
                }
                mVar.f5672b = i3;
                onBuilt();
                return mVar;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m201addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            public b b() {
                super.clear();
                this.f5679c = "";
                int i2 = this.f5678b & -2;
                this.f5678b = i2;
                this.f5680d = "";
                int i3 = i2 & -3;
                this.f5678b = i3;
                this.f5681e = "";
                this.f5678b = i3 & -5;
                g2<n, n.b, Object> g2Var = this.f5683g;
                if (g2Var == null) {
                    this.f5682f = null;
                } else {
                    g2Var.c();
                }
                int i4 = this.f5678b & -9;
                this.f5678b = i4;
                this.h = false;
                int i5 = i4 & -17;
                this.f5678b = i5;
                this.i = false;
                this.f5678b = i5 & -33;
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                m a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
            }

            /* renamed from: c */
            public b clone() {
                return (b) super.clone();
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m203clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
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
                } catch (o0 e2) {
                    mVar = (m) e2.f5447b;
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
                    this.f5678b |= 1;
                    this.f5679c = mVar.f5673c;
                    onChanged();
                }
                if (mVar.f()) {
                    this.f5678b |= 2;
                    this.f5680d = mVar.f5674d;
                    onChanged();
                }
                if (mVar.i()) {
                    this.f5678b |= 4;
                    this.f5681e = mVar.f5675e;
                    onChanged();
                }
                if (mVar.h()) {
                    n c2 = mVar.c();
                    g2<n, n.b, Object> g2Var = this.f5683g;
                    if (g2Var == null) {
                        if (!((this.f5678b & 8) == 0 || (nVar = this.f5682f) == null || nVar == (nVar2 = n.h))) {
                            n.b h2 = nVar2.toBuilder();
                            h2.o(nVar);
                            h2.o(c2);
                            c2 = h2.buildPartial();
                        }
                        this.f5682f = c2;
                        onChanged();
                    } else {
                        g2Var.f(c2);
                    }
                    this.f5678b |= 8;
                }
                if (mVar.e()) {
                    boolean z = mVar.f5677g;
                    this.f5678b |= 16;
                    this.h = z;
                    onChanged();
                }
                if (mVar.j()) {
                    boolean z2 = mVar.h;
                    this.f5678b |= 32;
                    this.i = z2;
                    onChanged();
                }
                f(mVar.unknownFields);
                onChanged();
                return this;
            }

            public final b f(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return m.j;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.x;
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.y;
                fVar.c(m.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.j1
            public final boolean isInitialized() {
                n nVar;
                if ((this.f5678b & 8) != 0) {
                    g2<n, n.b, Object> g2Var = this.f5683g;
                    if (g2Var == null) {
                        nVar = this.f5682f;
                        if (nVar == null) {
                            nVar = n.h;
                        }
                    } else {
                        nVar = g2Var.e();
                    }
                    if (!nVar.isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public final void maybeForceBuilderInitialization() {
                g2<n, n.b, Object> g2Var;
                n nVar;
                if (l0.alwaysUseFieldBuilders && (g2Var = this.f5683g) == null) {
                    if (g2Var == null) {
                        nVar = this.f5682f;
                        if (nVar == null) {
                            nVar = n.h;
                        }
                    } else {
                        nVar = g2Var.e();
                    }
                    this.f5683g = new g2<>(nVar, getParentForChildren(), isClean());
                    this.f5682f = null;
                }
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof m) {
                    e((m) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m210setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m211setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m212setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m202build() {
                m a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m205clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m206getDefaultInstanceForType() {
                return m.j;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m207mergeFrom(f1 f1Var) {
                if (f1Var instanceof m) {
                    e((m) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m209mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            public b setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m204clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m208mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }
        }

        public m() {
            this.i = -1;
            this.f5673c = "";
            this.f5674d = "";
            this.f5675e = "";
        }

        public m(l0.b bVar, a aVar) {
            super(bVar);
            this.i = -1;
        }

        public String a() {
            Object obj = this.f5674d;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.f5674d = z;
            }
            return z;
        }

        public String b() {
            Object obj = this.f5673c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.f5673c = z;
            }
            return z;
        }

        public n c() {
            n nVar = this.f5676f;
            return nVar == null ? n.h : nVar;
        }

        public String d() {
            Object obj = this.f5675e;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.f5675e = z;
            }
            return z;
        }

        public boolean e() {
            return (this.f5672b & 16) != 0;
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
            if ((!e() || this.f5677g == mVar.f5677g) && j() == mVar.j()) {
                return (!j() || this.h == mVar.h) && this.unknownFields.equals(mVar.unknownFields);
            }
            return false;
        }

        public boolean f() {
            return (this.f5672b & 2) != 0;
        }

        public boolean g() {
            return (this.f5672b & 1) != 0;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return j;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<m> getParserForType() {
            return k;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.f5672b & 1) != 0) {
                i3 = 0 + l0.computeStringSize(1, this.f5673c);
            }
            if ((this.f5672b & 2) != 0) {
                i3 += l0.computeStringSize(2, this.f5674d);
            }
            if ((this.f5672b & 4) != 0) {
                i3 += l0.computeStringSize(3, this.f5675e);
            }
            if ((this.f5672b & 8) != 0) {
                i3 += m.z(4, c());
            }
            if ((this.f5672b & 16) != 0) {
                i3 += m.c(5, this.f5677g);
            }
            if ((this.f5672b & 32) != 0) {
                i3 += m.c(6, this.h);
            }
            int serializedSize = this.unknownFields.getSerializedSize() + i3;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean h() {
            return (this.f5672b & 8) != 0;
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
                hashCode = c.a.a.a.a.a(hashCode, 37, 5, 53) + n0.c(this.f5677g);
            }
            if (j()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 6, 53) + n0.c(this.h);
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public boolean i() {
            return (this.f5672b & 4) != 0;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.y;
            fVar.c(m.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
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
            return (this.f5672b & 32) != 0;
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

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return j.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new m();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            if ((this.f5672b & 1) != 0) {
                l0.writeString(mVar, 1, this.f5673c);
            }
            if ((this.f5672b & 2) != 0) {
                l0.writeString(mVar, 2, this.f5674d);
            }
            if ((this.f5672b & 4) != 0) {
                l0.writeString(mVar, 3, this.f5675e);
            }
            if ((this.f5672b & 8) != 0) {
                mVar.k0(4, c());
            }
            if ((this.f5672b & 16) != 0) {
                mVar.Y(5, this.f5677g);
            }
            if ((this.f5672b & 32) != 0) {
                mVar.Y(6, this.h);
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m199getDefaultInstanceForType() {
            return j;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m200newBuilderForType() {
            return j.toBuilder();
        }
    }

    public static final class n extends l0.e<n> implements Object {
        public static final n h = new n();
        @Deprecated
        public static final w1<n> i = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f5684c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5685d;

        /* renamed from: e  reason: collision with root package name */
        public int f5686e;

        /* renamed from: f  reason: collision with root package name */
        public List<t> f5687f;

        /* renamed from: g  reason: collision with root package name */
        public byte f5688g;

        public static class a extends c<n> {
            /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                n nVar = new n();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 264) {
                                    nVar.f5684c |= 1;
                                    nVar.f5685d = kVar.m();
                                } else if (G == 272) {
                                    int p = kVar.p();
                                    if (c.b(p) == null) {
                                        b2.h(34, p);
                                    } else {
                                        nVar.f5684c |= 2;
                                        nVar.f5686e = p;
                                    }
                                } else if (G == 7994) {
                                    if (!z2 || !true) {
                                        nVar.f5687f = new ArrayList();
                                        z2 |= true;
                                    }
                                    nVar.f5687f.add(kVar.w(t.l, zVar));
                                } else if (!nVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (o0 e2) {
                            e2.f5447b = nVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = nVar;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                nVar.f5687f = Collections.unmodifiableList(nVar.f5687f);
                            }
                            nVar.unknownFields = b2.build();
                            nVar.f5370b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        nVar.f5687f = Collections.unmodifiableList(nVar.f5687f);
                    }
                    nVar.unknownFields = b2.build();
                    nVar.f5370b.x();
                    return nVar;
                }
                throw null;
            }
        }

        public static final class b extends l0.d<n, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f5689c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f5690d;

            /* renamed from: e  reason: collision with root package name */
            public int f5691e = 0;

            /* renamed from: f  reason: collision with root package name */
            public List<t> f5692f = Collections.emptyList();

            /* renamed from: g  reason: collision with root package name */
            public c2<t, t.b, Object> f5693g;

            public b() {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public l0.b m215addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                n j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public l0.b m217clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return n.h;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.N;
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b h(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.O;
                fVar.c(n.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.d, c.b.d.j1
            public final boolean isInitialized() {
                t tVar;
                int i = 0;
                while (true) {
                    c2<t, t.b, Object> c2Var = this.f5693g;
                    if (i < (c2Var == null ? this.f5692f.size() : c2Var.m())) {
                        c2<t, t.b, Object> c2Var2 = this.f5693g;
                        if (c2Var2 == null) {
                            tVar = this.f5692f.get(i);
                        } else {
                            tVar = c2Var2.n(i, false);
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
                int i2 = this.f5689c;
                if ((i2 & 1) != 0) {
                    nVar.f5685d = this.f5690d;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    i |= 2;
                }
                nVar.f5686e = this.f5691e;
                c2<t, t.b, Object> c2Var = this.f5693g;
                if (c2Var == null) {
                    if ((this.f5689c & 4) != 0) {
                        this.f5692f = Collections.unmodifiableList(this.f5692f);
                        this.f5689c &= -5;
                    }
                    list = this.f5692f;
                } else {
                    list = c2Var.g();
                }
                nVar.f5687f = list;
                nVar.f5684c = i;
                onBuilt();
                return nVar;
            }

            public b k() {
                super.clear();
                this.f5690d = false;
                int i = this.f5689c & -2;
                this.f5689c = i;
                this.f5691e = 0;
                this.f5689c = i & -3;
                c2<t, t.b, Object> c2Var = this.f5693g;
                if (c2Var == null) {
                    this.f5692f = Collections.emptyList();
                    this.f5689c &= -5;
                } else {
                    c2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final c2<t, t.b, Object> m() {
                if (this.f5693g == null) {
                    this.f5693g = new c2<>(this.f5692f, (this.f5689c & 4) != 0, getParentForChildren(), isClean());
                    this.f5692f = null;
                }
                return this.f5693g;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof n) {
                    o((n) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
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
                } catch (o0 e2) {
                    nVar = (n) e2.f5447b;
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
                    boolean z = nVar.f5685d;
                    this.f5689c |= 1;
                    this.f5690d = z;
                    onChanged();
                }
                if (nVar.g()) {
                    c b2 = c.b(nVar.f5686e);
                    if (b2 == null) {
                        b2 = c.IDEMPOTENCY_UNKNOWN;
                    }
                    this.f5689c |= 2;
                    this.f5691e = b2.f5698b;
                    onChanged();
                }
                if (this.f5693g == null) {
                    if (!nVar.f5687f.isEmpty()) {
                        if (this.f5692f.isEmpty()) {
                            this.f5692f = nVar.f5687f;
                            this.f5689c &= -5;
                        } else {
                            if ((this.f5689c & 4) == 0) {
                                this.f5692f = new ArrayList(this.f5692f);
                                this.f5689c |= 4;
                            }
                            this.f5692f.addAll(nVar.f5687f);
                        }
                        onChanged();
                    }
                } else if (!nVar.f5687f.isEmpty()) {
                    if (this.f5693g.s()) {
                        c2<t, t.b, Object> c2Var = null;
                        this.f5693g.f5234a = null;
                        this.f5693g = null;
                        this.f5692f = nVar.f5687f;
                        this.f5689c &= -5;
                        if (l0.alwaysUseFieldBuilders) {
                            c2Var = m();
                        }
                        this.f5693g = c2Var;
                    } else {
                        this.f5693g.b(nVar.f5687f);
                    }
                }
                f(nVar);
                q(nVar.unknownFields);
                onChanged();
                return this;
            }

            public final b q(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public l0.b m224setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public l0.b m225setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public l0.b m226setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(a aVar) {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m216build() {
                n j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public l0.b m219clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m220getDefaultInstanceForType() {
                return n.h;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m221mergeFrom(f1 f1Var) {
                if (f1Var instanceof n) {
                    o((n) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public l0.b m223mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            public f1.a setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public f1.a setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public f1.a m218clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public f1.a m222mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public enum c implements Object {
            IDEMPOTENCY_UNKNOWN(0),
            NO_SIDE_EFFECTS(1),
            IDEMPOTENT(2);
            

            /* renamed from: b  reason: collision with root package name */
            public final int f5698b;

            /* access modifiers changed from: public */
            static {
                values();
            }

            /* access modifiers changed from: public */
            c(int i) {
                this.f5698b = i;
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
                return this.f5698b;
            }
        }

        public n() {
            this.f5688g = -1;
            this.f5686e = 0;
            this.f5687f = Collections.emptyList();
        }

        public n(l0.d dVar, a aVar) {
            super(dVar);
            this.f5688g = -1;
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
            if ((!f() || this.f5685d == nVar.f5685d) && g() == nVar.g()) {
                return (!g() || this.f5686e == nVar.f5686e) && this.f5687f.equals(nVar.f5687f) && this.unknownFields.equals(nVar.unknownFields) && c().equals(nVar.c());
            }
            return false;
        }

        public boolean f() {
            return (this.f5684c & 1) != 0;
        }

        public boolean g() {
            return (this.f5684c & 2) != 0;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return h;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<n> getParserForType() {
            return i;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int c2 = (this.f5684c & 1) != 0 ? m.c(33, this.f5685d) + 0 : 0;
            if ((this.f5684c & 2) != 0) {
                c2 += m.j(34, this.f5686e);
            }
            for (int i3 = 0; i3 < this.f5687f.size(); i3++) {
                c2 += m.z(b.s.h.MAX_BIND_PARAMETER_CNT, this.f5687f.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + c2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
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
                hashCode = c.a.a.a.a.a(hashCode, 37, 33, 53) + n0.c(this.f5685d);
            }
            if (g()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 34, 53) + this.f5686e;
            }
            if (this.f5687f.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.s.h.MAX_BIND_PARAMETER_CNT, 53) + this.f5687f.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.O;
            fVar.c(n.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.l0.e, c.b.d.j1
        public final boolean isInitialized() {
            byte b2 = this.f5688g;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.f5687f.size(); i2++) {
                if (!this.f5687f.get(i2).isInitialized()) {
                    this.f5688g = 0;
                    return false;
                }
            }
            if (!a()) {
                this.f5688g = 0;
                return false;
            }
            this.f5688g = 1;
            return true;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return h.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new n();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            l0.e<MessageType>.a d2 = d();
            if ((this.f5684c & 1) != 0) {
                mVar.Y(33, this.f5685d);
            }
            if ((this.f5684c & 2) != 0) {
                mVar.i0(34, this.f5686e);
            }
            for (int i2 = 0; i2 < this.f5687f.size(); i2++) {
                mVar.k0(b.s.h.MAX_BIND_PARAMETER_CNT, this.f5687f.get(i2));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m213getDefaultInstanceForType() {
            return h;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m214newBuilderForType() {
            return h.toBuilder();
        }
    }

    public static final class o extends l0 implements k1 {

        /* renamed from: f  reason: collision with root package name */
        public static final o f5699f = new o();
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        public static final w1<o> f5700g = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f5701b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f5702c;

        /* renamed from: d  reason: collision with root package name */
        public p f5703d;

        /* renamed from: e  reason: collision with root package name */
        public byte f5704e;

        public static class a extends c<o> {
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                o oVar = new o();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 10) {
                                    j n = kVar.n();
                                    oVar.f5701b = 1 | oVar.f5701b;
                                    oVar.f5702c = n;
                                } else if (G == 18) {
                                    p.b f2 = (oVar.f5701b & 2) != 0 ? oVar.f5703d.toBuilder() : null;
                                    p pVar = (p) kVar.w(p.f5710f, zVar);
                                    oVar.f5703d = pVar;
                                    if (f2 != null) {
                                        f2.o(pVar);
                                        oVar.f5703d = f2.buildPartial();
                                    }
                                    oVar.f5701b |= 2;
                                } else if (!oVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (o0 e2) {
                            e2.f5447b = oVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = oVar;
                            throw o0Var;
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

        public static final class b extends l0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f5705b;

            /* renamed from: c  reason: collision with root package name */
            public Object f5706c = "";

            /* renamed from: d  reason: collision with root package name */
            public p f5707d;

            /* renamed from: e  reason: collision with root package name */
            public g2<p, p.b, Object> f5708e;

            public b() {
                maybeForceBuilderInitialization();
            }

            public b(a aVar) {
                maybeForceBuilderInitialization();
            }

            /* renamed from: a */
            public o buildPartial() {
                o oVar = new o(this, null);
                int i = this.f5705b;
                int i2 = (i & 1) != 0 ? 1 : 0;
                oVar.f5702c = this.f5706c;
                if ((i & 2) != 0) {
                    g2<p, p.b, Object> g2Var = this.f5708e;
                    oVar.f5703d = g2Var == null ? this.f5707d : g2Var.b();
                    i2 |= 2;
                }
                oVar.f5701b = i2;
                onBuilt();
                return oVar;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m229addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            public b b() {
                super.clear();
                this.f5706c = "";
                this.f5705b &= -2;
                g2<p, p.b, Object> g2Var = this.f5708e;
                if (g2Var == null) {
                    this.f5707d = null;
                } else {
                    g2Var.c();
                }
                this.f5705b &= -3;
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                o a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
            }

            /* renamed from: c */
            public b clone() {
                return (b) super.clone();
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m231clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b d(k kVar, z zVar) {
                Throwable th;
                o oVar;
                o oVar2 = null;
                try {
                    o parsePartialFrom = o.f5700g.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        e(parsePartialFrom);
                    }
                    return this;
                } catch (o0 e2) {
                    oVar = (o) e2.f5447b;
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
                if (oVar == o.f5699f) {
                    return this;
                }
                if (oVar.c()) {
                    this.f5705b |= 1;
                    this.f5706c = oVar.f5702c;
                    onChanged();
                }
                if (oVar.d()) {
                    p b2 = oVar.b();
                    g2<p, p.b, Object> g2Var = this.f5708e;
                    if (g2Var == null) {
                        if (!((this.f5705b & 2) == 0 || (pVar = this.f5707d) == null || pVar == (pVar2 = p.f5709e))) {
                            p.b f2 = pVar2.toBuilder();
                            f2.o(pVar);
                            f2.o(b2);
                            b2 = f2.buildPartial();
                        }
                        this.f5707d = b2;
                        onChanged();
                    } else {
                        g2Var.f(b2);
                    }
                    this.f5705b |= 2;
                }
                f(oVar.unknownFields);
                onChanged();
                return this;
            }

            public final b f(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return o.f5699f;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.n;
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.o;
                fVar.c(o.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.j1
            public final boolean isInitialized() {
                p pVar;
                if ((this.f5705b & 2) != 0) {
                    g2<p, p.b, Object> g2Var = this.f5708e;
                    if (g2Var == null) {
                        pVar = this.f5707d;
                        if (pVar == null) {
                            pVar = p.f5709e;
                        }
                    } else {
                        pVar = g2Var.e();
                    }
                    if (!pVar.isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public final void maybeForceBuilderInitialization() {
                g2<p, p.b, Object> g2Var;
                p pVar;
                if (l0.alwaysUseFieldBuilders && (g2Var = this.f5708e) == null) {
                    if (g2Var == null) {
                        pVar = this.f5707d;
                        if (pVar == null) {
                            pVar = p.f5709e;
                        }
                    } else {
                        pVar = g2Var.e();
                    }
                    this.f5708e = new g2<>(pVar, getParentForChildren(), isClean());
                    this.f5707d = null;
                }
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof o) {
                    e((o) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m238setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m239setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m240setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m230build() {
                o a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m233clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m234getDefaultInstanceForType() {
                return o.f5699f;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m235mergeFrom(f1 f1Var) {
                if (f1Var instanceof o) {
                    e((o) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m237mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            public b setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m232clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m236mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }
        }

        public o() {
            this.f5704e = -1;
            this.f5702c = "";
        }

        public o(l0.b bVar, a aVar) {
            super(bVar);
            this.f5704e = -1;
        }

        public String a() {
            Object obj = this.f5702c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.f5702c = z;
            }
            return z;
        }

        public p b() {
            p pVar = this.f5703d;
            return pVar == null ? p.f5709e : pVar;
        }

        public boolean c() {
            return (this.f5701b & 1) != 0;
        }

        public boolean d() {
            return (this.f5701b & 2) != 0;
        }

        /* renamed from: e */
        public b toBuilder() {
            if (this == f5699f) {
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

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return f5699f;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<o> getParserForType() {
            return f5700g;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.f5701b & 1) != 0) {
                i2 = 0 + l0.computeStringSize(1, this.f5702c);
            }
            if ((this.f5701b & 2) != 0) {
                i2 += m.z(2, b());
            }
            int serializedSize = this.unknownFields.getSerializedSize() + i2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
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

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.o;
            fVar.c(o.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
        public final boolean isInitialized() {
            byte b2 = this.f5704e;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!d() || b().isInitialized()) {
                this.f5704e = 1;
                return true;
            }
            this.f5704e = 0;
            return false;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return f5699f.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new o();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            if ((this.f5701b & 1) != 0) {
                l0.writeString(mVar, 1, this.f5702c);
            }
            if ((this.f5701b & 2) != 0) {
                mVar.k0(2, b());
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m227getDefaultInstanceForType() {
            return f5699f;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m228newBuilderForType() {
            return f5699f.toBuilder();
        }
    }

    public static final class p extends l0.e<p> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public static final p f5709e = new p();
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        public static final w1<p> f5710f = new a();

        /* renamed from: c  reason: collision with root package name */
        public List<t> f5711c;

        /* renamed from: d  reason: collision with root package name */
        public byte f5712d;

        public static class a extends c<p> {
            /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                p pVar = new p();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 7994) {
                                    if (!z2 || !true) {
                                        pVar.f5711c = new ArrayList();
                                        z2 |= true;
                                    }
                                    pVar.f5711c.add(kVar.w(t.l, zVar));
                                } else if (!pVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (o0 e2) {
                            e2.f5447b = pVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = pVar;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                pVar.f5711c = Collections.unmodifiableList(pVar.f5711c);
                            }
                            pVar.unknownFields = b2.build();
                            pVar.f5370b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        pVar.f5711c = Collections.unmodifiableList(pVar.f5711c);
                    }
                    pVar.unknownFields = b2.build();
                    pVar.f5370b.x();
                    return pVar;
                }
                throw null;
            }
        }

        public static final class b extends l0.d<p, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f5713c;

            /* renamed from: d  reason: collision with root package name */
            public List<t> f5714d = Collections.emptyList();

            /* renamed from: e  reason: collision with root package name */
            public c2<t, t.b, Object> f5715e;

            public b() {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public l0.b m243addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                p j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public l0.b m245clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return p.f5709e;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.F;
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b h(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.G;
                fVar.c(p.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.d, c.b.d.j1
            public final boolean isInitialized() {
                t tVar;
                int i = 0;
                while (true) {
                    c2<t, t.b, Object> c2Var = this.f5715e;
                    if (i < (c2Var == null ? this.f5714d.size() : c2Var.m())) {
                        c2<t, t.b, Object> c2Var2 = this.f5715e;
                        if (c2Var2 == null) {
                            tVar = this.f5714d.get(i);
                        } else {
                            tVar = c2Var2.n(i, false);
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
                int i = this.f5713c;
                c2<t, t.b, Object> c2Var = this.f5715e;
                if (c2Var == null) {
                    if ((i & 1) != 0) {
                        this.f5714d = Collections.unmodifiableList(this.f5714d);
                        this.f5713c &= -2;
                    }
                    list = this.f5714d;
                } else {
                    list = c2Var.g();
                }
                pVar.f5711c = list;
                onBuilt();
                return pVar;
            }

            public b k() {
                super.clear();
                c2<t, t.b, Object> c2Var = this.f5715e;
                if (c2Var == null) {
                    this.f5714d = Collections.emptyList();
                    this.f5713c &= -2;
                } else {
                    c2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final c2<t, t.b, Object> m() {
                if (this.f5715e == null) {
                    List<t> list = this.f5714d;
                    boolean z = true;
                    if ((this.f5713c & 1) == 0) {
                        z = false;
                    }
                    this.f5715e = new c2<>(list, z, getParentForChildren(), isClean());
                    this.f5714d = null;
                }
                return this.f5715e;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof p) {
                    o((p) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b n(k kVar, z zVar) {
                Throwable th;
                p pVar;
                p pVar2 = null;
                try {
                    p parsePartialFrom = p.f5710f.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        o(parsePartialFrom);
                    }
                    return this;
                } catch (o0 e2) {
                    pVar = (p) e2.f5447b;
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
                if (pVar == p.f5709e) {
                    return this;
                }
                if (this.f5715e == null) {
                    if (!pVar.f5711c.isEmpty()) {
                        if (this.f5714d.isEmpty()) {
                            this.f5714d = pVar.f5711c;
                            this.f5713c &= -2;
                        } else {
                            if ((this.f5713c & 1) == 0) {
                                this.f5714d = new ArrayList(this.f5714d);
                                this.f5713c |= 1;
                            }
                            this.f5714d.addAll(pVar.f5711c);
                        }
                        onChanged();
                    }
                } else if (!pVar.f5711c.isEmpty()) {
                    if (this.f5715e.s()) {
                        c2<t, t.b, Object> c2Var = null;
                        this.f5715e.f5234a = null;
                        this.f5715e = null;
                        this.f5714d = pVar.f5711c;
                        this.f5713c &= -2;
                        if (l0.alwaysUseFieldBuilders) {
                            c2Var = m();
                        }
                        this.f5715e = c2Var;
                    } else {
                        this.f5715e.b(pVar.f5711c);
                    }
                }
                f(pVar);
                q(pVar.unknownFields);
                onChanged();
                return this;
            }

            public final b q(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public l0.b m252setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public l0.b m253setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public l0.b m254setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(a aVar) {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m244build() {
                p j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public l0.b m247clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m248getDefaultInstanceForType() {
                return p.f5709e;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m249mergeFrom(f1 f1Var) {
                if (f1Var instanceof p) {
                    o((p) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public l0.b m251mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            public f1.a setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public f1.a setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public f1.a m246clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public f1.a m250mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public p() {
            this.f5712d = -1;
            this.f5711c = Collections.emptyList();
        }

        public p(l0.d dVar, a aVar) {
            super(dVar);
            this.f5712d = -1;
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
            if (this.f5711c.equals(pVar.f5711c) && this.unknownFields.equals(pVar.unknownFields) && c().equals(pVar.c())) {
                return true;
            }
            return false;
        }

        /* renamed from: f */
        public b toBuilder() {
            if (this == f5709e) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.o(this);
            return bVar;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return f5709e;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<p> getParserForType() {
            return f5710f;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f5711c.size(); i3++) {
                i2 += m.z(b.s.h.MAX_BIND_PARAMETER_CNT, this.f5711c.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + i2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = r.F.hashCode() + 779;
            if (this.f5711c.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.s.h.MAX_BIND_PARAMETER_CNT, 53) + this.f5711c.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.G;
            fVar.c(p.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.l0.e, c.b.d.j1
        public final boolean isInitialized() {
            byte b2 = this.f5712d;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.f5711c.size(); i++) {
                if (!this.f5711c.get(i).isInitialized()) {
                    this.f5712d = 0;
                    return false;
                }
            }
            if (!a()) {
                this.f5712d = 0;
                return false;
            }
            this.f5712d = 1;
            return true;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return f5709e.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new p();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            l0.e<MessageType>.a d2 = d();
            for (int i = 0; i < this.f5711c.size(); i++) {
                mVar.k0(b.s.h.MAX_BIND_PARAMETER_CNT, this.f5711c.get(i));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m241getDefaultInstanceForType() {
            return f5709e;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m242newBuilderForType() {
            return f5709e.toBuilder();
        }
    }

    public static final class q extends l0 implements k1 {

        /* renamed from: g  reason: collision with root package name */
        public static final q f5716g = new q();
        @Deprecated
        public static final w1<q> h = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f5717b;

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f5718c;

        /* renamed from: d  reason: collision with root package name */
        public List<m> f5719d;

        /* renamed from: e  reason: collision with root package name */
        public C0115r f5720e;

        /* renamed from: f  reason: collision with root package name */
        public byte f5721f;

        public static class a extends c<q> {
            /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: java.util.List<c.b.d.r$m> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                q qVar = new q();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 10) {
                                    j n = kVar.n();
                                    qVar.f5717b = 1 | qVar.f5717b;
                                    qVar.f5718c = n;
                                } else if (G == 18) {
                                    if (!z2 || !true) {
                                        qVar.f5719d = new ArrayList();
                                        z2 |= true;
                                    }
                                    qVar.f5719d.add(kVar.w(m.k, zVar));
                                } else if (G == 26) {
                                    C0115r.b g2 = (qVar.f5717b & 2) != 0 ? qVar.f5720e.toBuilder() : null;
                                    C0115r rVar = (C0115r) kVar.w(C0115r.h, zVar);
                                    qVar.f5720e = rVar;
                                    if (g2 != null) {
                                        g2.o(rVar);
                                        qVar.f5720e = g2.buildPartial();
                                    }
                                    qVar.f5717b |= 2;
                                } else if (!qVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (o0 e2) {
                            e2.f5447b = qVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = qVar;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                qVar.f5719d = Collections.unmodifiableList(qVar.f5719d);
                            }
                            qVar.unknownFields = b2.build();
                            qVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        qVar.f5719d = Collections.unmodifiableList(qVar.f5719d);
                    }
                    qVar.unknownFields = b2.build();
                    qVar.makeExtensionsImmutable();
                    return qVar;
                }
                throw null;
            }
        }

        public static final class b extends l0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f5722b;

            /* renamed from: c  reason: collision with root package name */
            public Object f5723c = "";

            /* renamed from: d  reason: collision with root package name */
            public List<m> f5724d = Collections.emptyList();

            /* renamed from: e  reason: collision with root package name */
            public c2<m, m.b, Object> f5725e;

            /* renamed from: f  reason: collision with root package name */
            public C0115r f5726f;

            /* renamed from: g  reason: collision with root package name */
            public g2<C0115r, C0115r.b, Object> f5727g;

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
                int i = this.f5722b;
                int i2 = (i & 1) != 0 ? 1 : 0;
                qVar.f5718c = this.f5723c;
                c2<m, m.b, Object> c2Var = this.f5725e;
                if (c2Var == null) {
                    if ((this.f5722b & 2) != 0) {
                        this.f5724d = Collections.unmodifiableList(this.f5724d);
                        this.f5722b &= -3;
                    }
                    list = this.f5724d;
                } else {
                    list = c2Var.g();
                }
                qVar.f5719d = list;
                if ((i & 4) != 0) {
                    g2<C0115r, C0115r.b, Object> g2Var = this.f5727g;
                    qVar.f5720e = g2Var == null ? this.f5726f : g2Var.b();
                    i2 |= 2;
                }
                qVar.f5717b = i2;
                onBuilt();
                return qVar;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m257addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            public b b() {
                super.clear();
                this.f5723c = "";
                this.f5722b &= -2;
                c2<m, m.b, Object> c2Var = this.f5725e;
                if (c2Var == null) {
                    this.f5724d = Collections.emptyList();
                    this.f5722b &= -3;
                } else {
                    c2Var.h();
                }
                g2<C0115r, C0115r.b, Object> g2Var = this.f5727g;
                if (g2Var == null) {
                    this.f5726f = null;
                } else {
                    g2Var.c();
                }
                this.f5722b &= -5;
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                q a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
            }

            /* renamed from: c */
            public b clone() {
                return (b) super.clone();
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m259clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            public final c2<m, m.b, Object> d() {
                if (this.f5725e == null) {
                    this.f5725e = new c2<>(this.f5724d, (this.f5722b & 2) != 0, getParentForChildren(), isClean());
                    this.f5724d = null;
                }
                return this.f5725e;
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
                } catch (o0 e2) {
                    qVar = (q) e2.f5447b;
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
                C0115r rVar;
                C0115r rVar2;
                if (qVar == q.f5716g) {
                    return this;
                }
                if (qVar.d()) {
                    this.f5722b |= 1;
                    this.f5723c = qVar.f5718c;
                    onChanged();
                }
                if (this.f5725e == null) {
                    if (!qVar.f5719d.isEmpty()) {
                        if (this.f5724d.isEmpty()) {
                            this.f5724d = qVar.f5719d;
                            this.f5722b &= -3;
                        } else {
                            if ((this.f5722b & 2) == 0) {
                                this.f5724d = new ArrayList(this.f5724d);
                                this.f5722b |= 2;
                            }
                            this.f5724d.addAll(qVar.f5719d);
                        }
                        onChanged();
                    }
                } else if (!qVar.f5719d.isEmpty()) {
                    if (this.f5725e.s()) {
                        c2<m, m.b, Object> c2Var = null;
                        this.f5725e.f5234a = null;
                        this.f5725e = null;
                        this.f5724d = qVar.f5719d;
                        this.f5722b &= -3;
                        if (l0.alwaysUseFieldBuilders) {
                            c2Var = d();
                        }
                        this.f5725e = c2Var;
                    } else {
                        this.f5725e.b(qVar.f5719d);
                    }
                }
                if (qVar.e()) {
                    C0115r c2 = qVar.c();
                    g2<C0115r, C0115r.b, Object> g2Var = this.f5727g;
                    if (g2Var == null) {
                        if (!((this.f5722b & 4) == 0 || (rVar = this.f5726f) == null || rVar == (rVar2 = C0115r.f5728g))) {
                            C0115r.b g2 = rVar2.toBuilder();
                            g2.o(rVar);
                            g2.o(c2);
                            c2 = g2.buildPartial();
                        }
                        this.f5726f = c2;
                        onChanged();
                    } else {
                        g2Var.f(c2);
                    }
                    this.f5722b |= 4;
                }
                g(qVar.unknownFields);
                onChanged();
                return this;
            }

            public final b g(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return q.f5716g;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.v;
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.w;
                fVar.c(q.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.j1
            public final boolean isInitialized() {
                C0115r rVar;
                m mVar;
                int i = 0;
                while (true) {
                    c2<m, m.b, Object> c2Var = this.f5725e;
                    if (i < (c2Var == null ? this.f5724d.size() : c2Var.m())) {
                        c2<m, m.b, Object> c2Var2 = this.f5725e;
                        if (c2Var2 == null) {
                            mVar = this.f5724d.get(i);
                        } else {
                            mVar = c2Var2.n(i, false);
                        }
                        if (!mVar.isInitialized()) {
                            return false;
                        }
                        i++;
                    } else {
                        if ((this.f5722b & 4) != 0) {
                            g2<C0115r, C0115r.b, Object> g2Var = this.f5727g;
                            if (g2Var == null) {
                                rVar = this.f5726f;
                                if (rVar == null) {
                                    rVar = C0115r.f5728g;
                                }
                            } else {
                                rVar = g2Var.e();
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
                C0115r rVar;
                if (l0.alwaysUseFieldBuilders) {
                    d();
                    g2<C0115r, C0115r.b, Object> g2Var = this.f5727g;
                    if (g2Var == null) {
                        if (g2Var == null) {
                            rVar = this.f5726f;
                            if (rVar == null) {
                                rVar = C0115r.f5728g;
                            }
                        } else {
                            rVar = g2Var.e();
                        }
                        this.f5727g = new g2<>(rVar, getParentForChildren(), isClean());
                        this.f5726f = null;
                    }
                }
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof q) {
                    f((q) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m266setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m267setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m268setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m258build() {
                q a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m261clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m262getDefaultInstanceForType() {
                return q.f5716g;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m263mergeFrom(f1 f1Var) {
                if (f1Var instanceof q) {
                    f((q) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m265mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            public b setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m260clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m264mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }
        }

        public q() {
            this.f5721f = -1;
            this.f5718c = "";
            this.f5719d = Collections.emptyList();
        }

        public q(l0.b bVar, a aVar) {
            super(bVar);
            this.f5721f = -1;
        }

        public int a() {
            return this.f5719d.size();
        }

        public String b() {
            Object obj = this.f5718c;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.f5718c = z;
            }
            return z;
        }

        public C0115r c() {
            C0115r rVar = this.f5720e;
            return rVar == null ? C0115r.f5728g : rVar;
        }

        public boolean d() {
            return (this.f5717b & 1) != 0;
        }

        public boolean e() {
            return (this.f5717b & 2) != 0;
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
            if ((!d() || b().equals(qVar.b())) && this.f5719d.equals(qVar.f5719d) && e() == qVar.e()) {
                return (!e() || c().equals(qVar.c())) && this.unknownFields.equals(qVar.unknownFields);
            }
            return false;
        }

        /* renamed from: f */
        public b toBuilder() {
            if (this == f5716g) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.f(this);
            return bVar;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return f5716g;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<q> getParserForType() {
            return h;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.f5717b & 1) != 0 ? l0.computeStringSize(1, this.f5718c) + 0 : 0;
            for (int i2 = 0; i2 < this.f5719d.size(); i2++) {
                computeStringSize += m.z(2, this.f5719d.get(i2));
            }
            if ((this.f5717b & 2) != 0) {
                computeStringSize += m.z(3, c());
            }
            int serializedSize = this.unknownFields.getSerializedSize() + computeStringSize;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
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
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f5719d.hashCode();
            }
            if (e()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + c().hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.w;
            fVar.c(q.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
        public final boolean isInitialized() {
            byte b2 = this.f5721f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < a(); i++) {
                if (!this.f5719d.get(i).isInitialized()) {
                    this.f5721f = 0;
                    return false;
                }
            }
            if (!e() || c().isInitialized()) {
                this.f5721f = 1;
                return true;
            }
            this.f5721f = 0;
            return false;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return f5716g.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new q();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            if ((this.f5717b & 1) != 0) {
                l0.writeString(mVar, 1, this.f5718c);
            }
            for (int i = 0; i < this.f5719d.size(); i++) {
                mVar.k0(2, this.f5719d.get(i));
            }
            if ((this.f5717b & 2) != 0) {
                mVar.k0(3, c());
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m255getDefaultInstanceForType() {
            return f5716g;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m256newBuilderForType() {
            return f5716g.toBuilder();
        }
    }

    /* renamed from: c.b.d.r$r  reason: collision with other inner class name */
    public static final class C0115r extends l0.e<C0115r> implements Object {

        /* renamed from: g  reason: collision with root package name */
        public static final C0115r f5728g = new C0115r();
        @Deprecated
        public static final w1<C0115r> h = new a();

        /* renamed from: c  reason: collision with root package name */
        public int f5729c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5730d;

        /* renamed from: e  reason: collision with root package name */
        public List<t> f5731e;

        /* renamed from: f  reason: collision with root package name */
        public byte f5732f;

        /* renamed from: c.b.d.r$r$a */
        public static class a extends c<C0115r> {
            /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: java.util.List<c.b.d.r$t> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                C0115r rVar = new C0115r();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 264) {
                                    rVar.f5729c |= 1;
                                    rVar.f5730d = kVar.m();
                                } else if (G == 7994) {
                                    if (!z2 || !true) {
                                        rVar.f5731e = new ArrayList();
                                        z2 |= true;
                                    }
                                    rVar.f5731e.add(kVar.w(t.l, zVar));
                                } else if (!rVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (o0 e2) {
                            e2.f5447b = rVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = rVar;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                rVar.f5731e = Collections.unmodifiableList(rVar.f5731e);
                            }
                            rVar.unknownFields = b2.build();
                            rVar.f5370b.x();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        rVar.f5731e = Collections.unmodifiableList(rVar.f5731e);
                    }
                    rVar.unknownFields = b2.build();
                    rVar.f5370b.x();
                    return rVar;
                }
                throw null;
            }
        }

        /* renamed from: c.b.d.r$r$b */
        public static final class b extends l0.d<C0115r, b> implements Object {

            /* renamed from: c  reason: collision with root package name */
            public int f5733c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f5734d;

            /* renamed from: e  reason: collision with root package name */
            public List<t> f5735e = Collections.emptyList();

            /* renamed from: f  reason: collision with root package name */
            public c2<t, t.b, Object> f5736f;

            public b() {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b a(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public l0.b m271addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public /* bridge */ /* synthetic */ b b() {
                k();
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                C0115r j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b c(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public l0.b m273clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b g(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return C0115r.f5728g;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.L;
            }

            /* Return type fixed from 'c.b.d.l0$d' to match base method */
            @Override // c.b.d.l0.d
            public b h(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.M;
                fVar.c(C0115r.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.d, c.b.d.j1
            public final boolean isInitialized() {
                t tVar;
                int i = 0;
                while (true) {
                    c2<t, t.b, Object> c2Var = this.f5736f;
                    if (i < (c2Var == null ? this.f5735e.size() : c2Var.m())) {
                        c2<t, t.b, Object> c2Var2 = this.f5736f;
                        if (c2Var2 == null) {
                            tVar = this.f5735e.get(i);
                        } else {
                            tVar = c2Var2.n(i, false);
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
            public C0115r buildPartial() {
                List<t> list;
                C0115r rVar = new C0115r(this, null);
                int i = 1;
                if ((this.f5733c & 1) != 0) {
                    rVar.f5730d = this.f5734d;
                } else {
                    i = 0;
                }
                c2<t, t.b, Object> c2Var = this.f5736f;
                if (c2Var == null) {
                    if ((this.f5733c & 2) != 0) {
                        this.f5735e = Collections.unmodifiableList(this.f5735e);
                        this.f5733c &= -3;
                    }
                    list = this.f5735e;
                } else {
                    list = c2Var.g();
                }
                rVar.f5731e = list;
                rVar.f5729c = i;
                onBuilt();
                return rVar;
            }

            public b k() {
                super.clear();
                this.f5734d = false;
                this.f5733c &= -2;
                c2<t, t.b, Object> c2Var = this.f5736f;
                if (c2Var == null) {
                    this.f5735e = Collections.emptyList();
                    this.f5733c &= -3;
                } else {
                    c2Var.h();
                }
                return this;
            }

            /* renamed from: l */
            public b clone() {
                return (b) super.clone();
            }

            public final c2<t, t.b, Object> m() {
                if (this.f5736f == null) {
                    this.f5736f = new c2<>(this.f5735e, (this.f5733c & 2) != 0, getParentForChildren(), isClean());
                    this.f5735e = null;
                }
                return this.f5736f;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof C0115r) {
                    o((C0115r) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b n(k kVar, z zVar) {
                Throwable th;
                C0115r rVar;
                C0115r rVar2 = null;
                try {
                    C0115r parsePartialFrom = C0115r.h.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        o(parsePartialFrom);
                    }
                    return this;
                } catch (o0 e2) {
                    rVar = (C0115r) e2.f5447b;
                    throw e2.j();
                } catch (Throwable th2) {
                    th = th2;
                    rVar2 = rVar;
                    if (rVar2 != null) {
                    }
                    throw th;
                }
            }

            public b o(C0115r rVar) {
                if (rVar == C0115r.f5728g) {
                    return this;
                }
                if (rVar.f()) {
                    boolean z = rVar.f5730d;
                    this.f5733c |= 1;
                    this.f5734d = z;
                    onChanged();
                }
                if (this.f5736f == null) {
                    if (!rVar.f5731e.isEmpty()) {
                        if (this.f5735e.isEmpty()) {
                            this.f5735e = rVar.f5731e;
                            this.f5733c &= -3;
                        } else {
                            if ((this.f5733c & 2) == 0) {
                                this.f5735e = new ArrayList(this.f5735e);
                                this.f5733c |= 2;
                            }
                            this.f5735e.addAll(rVar.f5731e);
                        }
                        onChanged();
                    }
                } else if (!rVar.f5731e.isEmpty()) {
                    if (this.f5736f.s()) {
                        c2<t, t.b, Object> c2Var = null;
                        this.f5736f.f5234a = null;
                        this.f5736f = null;
                        this.f5735e = rVar.f5731e;
                        this.f5733c &= -3;
                        if (l0.alwaysUseFieldBuilders) {
                            c2Var = m();
                        }
                        this.f5736f = c2Var;
                    } else {
                        this.f5736f.b(rVar.f5731e);
                    }
                }
                f(rVar);
                q(rVar.unknownFields);
                onChanged();
                return this;
            }

            public final b q(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public l0.b m280setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public l0.b m281setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public l0.b m282setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(a aVar) {
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m272build() {
                C0115r j = buildPartial();
                if (j.isInitialized()) {
                    return j;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) j);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public l0.b m275clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m276getDefaultInstanceForType() {
                return C0115r.f5728g;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m277mergeFrom(f1 f1Var) {
                if (f1Var instanceof C0115r) {
                    o((C0115r) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public l0.b m279mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d, c.b.d.f1.a
            public f1.a setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.d, c.b.d.l0.d
            public f1.a setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public f1.a setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public f1.a m274clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public f1.a m278mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                if (l0.alwaysUseFieldBuilders) {
                    m();
                }
            }
        }

        public C0115r() {
            this.f5732f = -1;
            this.f5731e = Collections.emptyList();
        }

        public C0115r(l0.d dVar, a aVar) {
            super(dVar);
            this.f5732f = -1;
        }

        @Override // c.b.d.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0115r)) {
                return super.equals(obj);
            }
            C0115r rVar = (C0115r) obj;
            if (f() != rVar.f()) {
                return false;
            }
            return (!f() || this.f5730d == rVar.f5730d) && this.f5731e.equals(rVar.f5731e) && this.unknownFields.equals(rVar.unknownFields) && c().equals(rVar.c());
        }

        public boolean f() {
            return (this.f5729c & 1) != 0;
        }

        /* renamed from: g */
        public b toBuilder() {
            if (this == f5728g) {
                return new b(null);
            }
            b bVar = new b(null);
            bVar.o(this);
            return bVar;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return f5728g;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<C0115r> getParserForType() {
            return h;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int c2 = (this.f5729c & 1) != 0 ? m.c(33, this.f5730d) + 0 : 0;
            for (int i2 = 0; i2 < this.f5731e.size(); i2++) {
                c2 += m.z(b.s.h.MAX_BIND_PARAMETER_CNT, this.f5731e.get(i2));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + b() + c2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
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
                hashCode = c.a.a.a.a.a(hashCode, 37, 33, 53) + n0.c(this.f5730d);
            }
            if (this.f5731e.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, b.s.h.MAX_BIND_PARAMETER_CNT, 53) + this.f5731e.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (a.hashFields(hashCode, c()) * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.M;
            fVar.c(C0115r.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.l0.e, c.b.d.j1
        public final boolean isInitialized() {
            byte b2 = this.f5732f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.f5731e.size(); i++) {
                if (!this.f5731e.get(i).isInitialized()) {
                    this.f5732f = 0;
                    return false;
                }
            }
            if (!a()) {
                this.f5732f = 0;
                return false;
            }
            this.f5732f = 1;
            return true;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return f5728g.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new C0115r();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            l0.e<MessageType>.a d2 = d();
            if ((this.f5729c & 1) != 0) {
                mVar.Y(33, this.f5730d);
            }
            for (int i = 0; i < this.f5731e.size(); i++) {
                mVar.k0(b.s.h.MAX_BIND_PARAMETER_CNT, this.f5731e.get(i));
            }
            d2.a(536870912, mVar);
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m269getDefaultInstanceForType() {
            return f5728g;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m270newBuilderForType() {
            return f5728g.toBuilder();
        }
    }

    public static final class s extends l0 implements k1 {

        /* renamed from: d  reason: collision with root package name */
        public static final s f5737d = new s();
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public static final w1<s> f5738e = new a();

        /* renamed from: b  reason: collision with root package name */
        public List<c> f5739b;

        /* renamed from: c  reason: collision with root package name */
        public byte f5740c;

        public static class a extends c<s> {
            /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List<c.b.d.r$s$c> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                s sVar = new s();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 10) {
                                    if (!z2 || !true) {
                                        sVar.f5739b = new ArrayList();
                                        z2 |= true;
                                    }
                                    sVar.f5739b.add(kVar.w(c.l, zVar));
                                } else if (!sVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (o0 e2) {
                            e2.f5447b = sVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = sVar;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                sVar.f5739b = Collections.unmodifiableList(sVar.f5739b);
                            }
                            sVar.unknownFields = b2.build();
                            sVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        sVar.f5739b = Collections.unmodifiableList(sVar.f5739b);
                    }
                    sVar.unknownFields = b2.build();
                    sVar.makeExtensionsImmutable();
                    return sVar;
                }
                throw null;
            }
        }

        public static final class b extends l0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f5741b;

            /* renamed from: c  reason: collision with root package name */
            public List<c> f5742c = Collections.emptyList();

            /* renamed from: d  reason: collision with root package name */
            public c2<c, c.b, Object> f5743d;

            public b() {
                if (l0.alwaysUseFieldBuilders) {
                    d();
                }
            }

            /* renamed from: a */
            public s buildPartial() {
                List<c> list;
                s sVar = new s(this, null);
                int i = this.f5741b;
                c2<c, c.b, Object> c2Var = this.f5743d;
                if (c2Var == null) {
                    if ((i & 1) != 0) {
                        this.f5742c = Collections.unmodifiableList(this.f5742c);
                        this.f5741b &= -2;
                    }
                    list = this.f5742c;
                } else {
                    list = c2Var.g();
                }
                sVar.f5739b = list;
                onBuilt();
                return sVar;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m285addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            public b b() {
                super.clear();
                c2<c, c.b, Object> c2Var = this.f5743d;
                if (c2Var == null) {
                    this.f5742c = Collections.emptyList();
                    this.f5741b &= -2;
                } else {
                    c2Var.h();
                }
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                s a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
            }

            /* renamed from: c */
            public b clone() {
                return (b) super.clone();
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m287clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            public final c2<c, c.b, Object> d() {
                if (this.f5743d == null) {
                    List<c> list = this.f5742c;
                    boolean z = true;
                    if ((this.f5741b & 1) == 0) {
                        z = false;
                    }
                    this.f5743d = new c2<>(list, z, getParentForChildren(), isClean());
                    this.f5742c = null;
                }
                return this.f5743d;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
            public b e(k kVar, z zVar) {
                Throwable th;
                s sVar;
                s sVar2 = null;
                try {
                    s parsePartialFrom = s.f5738e.parsePartialFrom(kVar, zVar);
                    if (parsePartialFrom != null) {
                        f(parsePartialFrom);
                    }
                    return this;
                } catch (o0 e2) {
                    sVar = (s) e2.f5447b;
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
                if (sVar == s.f5737d) {
                    return this;
                }
                if (this.f5743d == null) {
                    if (!sVar.f5739b.isEmpty()) {
                        if (this.f5742c.isEmpty()) {
                            this.f5742c = sVar.f5739b;
                            this.f5741b &= -2;
                        } else {
                            if ((this.f5741b & 1) == 0) {
                                this.f5742c = new ArrayList(this.f5742c);
                                this.f5741b |= 1;
                            }
                            this.f5742c.addAll(sVar.f5739b);
                        }
                        onChanged();
                    }
                } else if (!sVar.f5739b.isEmpty()) {
                    if (this.f5743d.s()) {
                        c2<c, c.b, Object> c2Var = null;
                        this.f5743d.f5234a = null;
                        this.f5743d = null;
                        this.f5742c = sVar.f5739b;
                        this.f5741b &= -2;
                        if (l0.alwaysUseFieldBuilders) {
                            c2Var = d();
                        }
                        this.f5743d = c2Var;
                    } else {
                        this.f5743d.b(sVar.f5739b);
                    }
                }
                g(sVar.unknownFields);
                onChanged();
                return this;
            }

            public final b g(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return s.f5737d;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.T;
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.U;
                fVar.c(s.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.j1
            public final boolean isInitialized() {
                return true;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof s) {
                    f((s) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m294setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m295setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m296setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(a aVar) {
                if (l0.alwaysUseFieldBuilders) {
                    d();
                }
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m286build() {
                s a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m289clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m290getDefaultInstanceForType() {
                return s.f5737d;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m291mergeFrom(f1 f1Var) {
                if (f1Var instanceof s) {
                    f((s) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m293mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            public b setRepeatedField(s.g gVar, int i, Object obj) {
                return (b) super.setRepeatedField(gVar, i, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m288clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m292mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                if (l0.alwaysUseFieldBuilders) {
                    d();
                }
            }
        }

        public static final class c extends l0 implements k1 {
            public static final c k = new c();
            @Deprecated
            public static final w1<c> l = new a();

            /* renamed from: b  reason: collision with root package name */
            public int f5744b;

            /* renamed from: c  reason: collision with root package name */
            public n0.f f5745c;

            /* renamed from: d  reason: collision with root package name */
            public int f5746d;

            /* renamed from: e  reason: collision with root package name */
            public n0.f f5747e;

            /* renamed from: f  reason: collision with root package name */
            public int f5748f;

            /* renamed from: g  reason: collision with root package name */
            public volatile Object f5749g;
            public volatile Object h;
            public t0 i;
            public byte j;

            public static class a extends c<c> {
                @Override // c.b.d.w1
                public Object parsePartialFrom(k kVar, z zVar) {
                    n0.f fVar;
                    int i;
                    c cVar = new c();
                    if (zVar != null) {
                        q2.b b2 = q2.b();
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
                                                cVar.f5745c = l0.newIntList();
                                                z2 |= true;
                                            }
                                            while (kVar.d() > 0) {
                                                ((m0) cVar.f5745c).c(kVar.u());
                                            }
                                        } else if (G == 16) {
                                            if (!z2 || !true) {
                                                cVar.f5747e = l0.newIntList();
                                                z2 |= true;
                                            }
                                            fVar = cVar.f5747e;
                                        } else if (G == 18) {
                                            i = kVar.l(kVar.y());
                                            if ((!z2 || !true) && kVar.d() > 0) {
                                                cVar.f5747e = l0.newIntList();
                                                z2 |= true;
                                            }
                                            while (kVar.d() > 0) {
                                                ((m0) cVar.f5747e).c(kVar.u());
                                            }
                                        } else if (G == 26) {
                                            j n = kVar.n();
                                            cVar.f5744b |= 1;
                                            cVar.f5749g = n;
                                        } else if (G == 34) {
                                            j n2 = kVar.n();
                                            cVar.f5744b |= 2;
                                            cVar.h = n2;
                                        } else if (G == 50) {
                                            j n3 = kVar.n();
                                            if (!z2 || !true) {
                                                cVar.i = new s0(10);
                                                z2 |= true;
                                            }
                                            cVar.i.D(n3);
                                        } else if (!cVar.parseUnknownField(kVar, b2, zVar, G)) {
                                        }
                                        kVar.k(i);
                                    } else {
                                        if (!z2 || !true) {
                                            cVar.f5745c = l0.newIntList();
                                            z2 |= true;
                                        }
                                        fVar = cVar.f5745c;
                                    }
                                    ((m0) fVar).c(kVar.u());
                                }
                                z = true;
                            } catch (o0 e2) {
                                e2.f5447b = cVar;
                                throw e2;
                            } catch (IOException e3) {
                                o0 o0Var = new o0(e3);
                                o0Var.f5447b = cVar;
                                throw o0Var;
                            } catch (Throwable th) {
                                if (z2 && true) {
                                    cVar.f5745c.f();
                                }
                                if (z2 && true) {
                                    cVar.f5747e.f();
                                }
                                if (z2 && true) {
                                    cVar.i = cVar.i.d();
                                }
                                cVar.unknownFields = b2.build();
                                cVar.makeExtensionsImmutable();
                                throw th;
                            }
                        }
                        if (z2 && true) {
                            cVar.f5745c.f();
                        }
                        if (z2 && true) {
                            cVar.f5747e.f();
                        }
                        if (z2 && true) {
                            cVar.i = cVar.i.d();
                        }
                        cVar.unknownFields = b2.build();
                        cVar.makeExtensionsImmutable();
                        return cVar;
                    }
                    throw null;
                }
            }

            public static final class b extends l0.b<b> implements Object {

                /* renamed from: b  reason: collision with root package name */
                public int f5750b;

                /* renamed from: c  reason: collision with root package name */
                public n0.f f5751c = l0.emptyIntList();

                /* renamed from: d  reason: collision with root package name */
                public n0.f f5752d = l0.emptyIntList();

                /* renamed from: e  reason: collision with root package name */
                public Object f5753e = "";

                /* renamed from: f  reason: collision with root package name */
                public Object f5754f = "";

                /* renamed from: g  reason: collision with root package name */
                public t0 f5755g = s0.f5863e;

                public b() {
                }

                public b(a aVar) {
                }

                /* renamed from: a */
                public c buildPartial() {
                    c cVar = new c(this, null);
                    int i = this.f5750b;
                    if ((i & 1) != 0) {
                        this.f5751c.f();
                        this.f5750b &= -2;
                    }
                    cVar.f5745c = this.f5751c;
                    if ((this.f5750b & 2) != 0) {
                        this.f5752d.f();
                        this.f5750b &= -3;
                    }
                    cVar.f5747e = this.f5752d;
                    int i2 = (i & 4) != 0 ? 1 : 0;
                    cVar.f5749g = this.f5753e;
                    if ((i & 8) != 0) {
                        i2 |= 2;
                    }
                    cVar.h = this.f5754f;
                    if ((this.f5750b & 16) != 0) {
                        this.f5755g = this.f5755g.d();
                        this.f5750b &= -17;
                    }
                    cVar.i = this.f5755g;
                    cVar.f5744b = i2;
                    onBuilt();
                    return cVar;
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: addRepeatedField  reason: collision with other method in class */
                public b m299addRepeatedField(s.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                public b b() {
                    super.clear();
                    this.f5751c = l0.emptyIntList();
                    this.f5750b &= -2;
                    this.f5752d = l0.emptyIntList();
                    int i = this.f5750b & -3;
                    this.f5750b = i;
                    this.f5753e = "";
                    int i2 = i & -5;
                    this.f5750b = i2;
                    this.f5754f = "";
                    int i3 = i2 & -9;
                    this.f5750b = i3;
                    this.f5755g = s0.f5863e;
                    this.f5750b = i3 & -17;
                    return this;
                }

                @Override // c.b.d.i1.a, c.b.d.f1.a
                public f1 build() {
                    c a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
                }

                /* renamed from: c */
                public b clone() {
                    return (b) super.clone();
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: clearField  reason: collision with other method in class */
                public b m301clearField(s.g gVar) {
                    return (b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
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
                    } catch (o0 e2) {
                        cVar = (c) e2.f5447b;
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
                    if (!cVar.f5745c.isEmpty()) {
                        if (this.f5751c.isEmpty()) {
                            this.f5751c = cVar.f5745c;
                            this.f5750b &= -2;
                        } else {
                            if ((this.f5750b & 1) == 0) {
                                this.f5751c = l0.mutableCopy(this.f5751c);
                                this.f5750b |= 1;
                            }
                            this.f5751c.addAll(cVar.f5745c);
                        }
                        onChanged();
                    }
                    if (!cVar.f5747e.isEmpty()) {
                        if (this.f5752d.isEmpty()) {
                            this.f5752d = cVar.f5747e;
                            this.f5750b &= -3;
                        } else {
                            if ((this.f5750b & 2) == 0) {
                                this.f5752d = l0.mutableCopy(this.f5752d);
                                this.f5750b |= 2;
                            }
                            this.f5752d.addAll(cVar.f5747e);
                        }
                        onChanged();
                    }
                    if (cVar.c()) {
                        this.f5750b |= 4;
                        this.f5753e = cVar.f5749g;
                        onChanged();
                    }
                    if (cVar.d()) {
                        this.f5750b |= 8;
                        this.f5754f = cVar.h;
                        onChanged();
                    }
                    if (!cVar.i.isEmpty()) {
                        if (this.f5755g.isEmpty()) {
                            this.f5755g = cVar.i;
                            this.f5750b &= -17;
                        } else {
                            if ((this.f5750b & 16) == 0) {
                                this.f5755g = new s0(this.f5755g);
                                this.f5750b |= 16;
                            }
                            this.f5755g.addAll(cVar.i);
                        }
                        onChanged();
                    }
                    f(cVar.unknownFields);
                    onChanged();
                    return this;
                }

                public final b f(q2 q2Var) {
                    return (b) super.mergeUnknownFields(q2Var);
                }

                @Override // c.b.d.k1, c.b.d.j1
                public f1 getDefaultInstanceForType() {
                    return c.k;
                }

                @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
                public s.b getDescriptorForType() {
                    return r.V;
                }

                @Override // c.b.d.l0.b
                public l0.f internalGetFieldAccessorTable() {
                    l0.f fVar = r.W;
                    fVar.c(c.class, b.class);
                    return fVar;
                }

                @Override // c.b.d.l0.b, c.b.d.j1
                public final boolean isInitialized() {
                    return true;
                }

                @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                public a.AbstractC0106a mergeFrom(f1 f1Var) {
                    if (f1Var instanceof c) {
                        e((c) f1Var);
                    } else {
                        super.mergeFrom(f1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                public b mergeUnknownFields(q2 q2Var) {
                    return (b) super.mergeUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: setField  reason: collision with other method in class */
                public b m308setField(s.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b
                /* renamed from: setRepeatedField  reason: collision with other method in class */
                public b m309setRepeatedField(s.g gVar, int i, Object obj) {
                    return (b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: setUnknownFields  reason: collision with other method in class */
                public b m310setUnknownFields(q2 q2Var) {
                    return (b) super.setUnknownFields(q2Var);
                }

                public b(l0.c cVar, a aVar) {
                    super(cVar);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public b addRepeatedField(s.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                @Override // c.b.d.i1.a, c.b.d.f1.a
                /* renamed from: build  reason: collision with other method in class */
                public i1 m300build() {
                    c a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public b clearField(s.g gVar) {
                    return (b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public b m303clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                @Override // c.b.d.k1, c.b.d.j1
                /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
                public i1 m304getDefaultInstanceForType() {
                    return c.k;
                }

                @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeFrom  reason: collision with other method in class */
                public f1.a m305mergeFrom(f1 f1Var) {
                    if (f1Var instanceof c) {
                        e((c) f1Var);
                    } else {
                        super.mergeFrom(f1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public b m307mergeUnknownFields(q2 q2Var) {
                    return (b) super.mergeUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public b setField(s.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b
                public b setRepeatedField(s.g gVar, int i, Object obj) {
                    return (b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public b setUnknownFields(q2 q2Var) {
                    return (b) super.setUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public b m302clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public b m306mergeUnknownFields(q2 q2Var) {
                    return (b) super.mergeUnknownFields(q2Var);
                }
            }

            public c() {
                this.f5746d = -1;
                this.f5748f = -1;
                this.j = -1;
                this.f5745c = l0.emptyIntList();
                this.f5747e = l0.emptyIntList();
                this.f5749g = "";
                this.h = "";
                this.i = s0.f5863e;
            }

            public c(l0.b bVar, a aVar) {
                super(bVar);
                this.f5746d = -1;
                this.f5748f = -1;
                this.j = -1;
            }

            public String a() {
                Object obj = this.f5749g;
                if (obj instanceof String) {
                    return (String) obj;
                }
                j jVar = (j) obj;
                String z = jVar.z();
                if (jVar.o()) {
                    this.f5749g = z;
                }
                return z;
            }

            public String b() {
                Object obj = this.h;
                if (obj instanceof String) {
                    return (String) obj;
                }
                j jVar = (j) obj;
                String z = jVar.z();
                if (jVar.o()) {
                    this.h = z;
                }
                return z;
            }

            public boolean c() {
                return (this.f5744b & 1) != 0;
            }

            public boolean d() {
                return (this.f5744b & 2) != 0;
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
                if (!this.f5745c.equals(cVar.f5745c) || !this.f5747e.equals(cVar.f5747e) || c() != cVar.c()) {
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

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return k;
            }

            @Override // c.b.d.l0, c.b.d.i1
            public w1<c> getParserForType() {
                return l;
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
            public int getSerializedSize() {
                int i2 = this.memoizedSize;
                if (i2 != -1) {
                    return i2;
                }
                int i3 = 0;
                for (int i4 = 0; i4 < this.f5745c.size(); i4++) {
                    i3 += m.t(((m0) this.f5745c).g(i4));
                }
                int i5 = 0 + i3;
                if (!this.f5745c.isEmpty()) {
                    i5 = i5 + 1 + m.t(i3);
                }
                this.f5746d = i3;
                int i6 = 0;
                for (int i7 = 0; i7 < this.f5747e.size(); i7++) {
                    i6 += m.t(((m0) this.f5747e).g(i7));
                }
                int i8 = i5 + i6;
                if (!this.f5747e.isEmpty()) {
                    i8 = i8 + 1 + m.t(i6);
                }
                this.f5748f = i6;
                if ((this.f5744b & 1) != 0) {
                    i8 += l0.computeStringSize(3, this.f5749g);
                }
                if ((this.f5744b & 2) != 0) {
                    i8 += l0.computeStringSize(4, this.h);
                }
                int i9 = 0;
                for (int i10 = 0; i10 < this.i.size(); i10++) {
                    i9 += l0.computeStringSizeNoTag(this.i.b(i10));
                }
                int serializedSize = this.unknownFields.getSerializedSize() + (this.i.size() * 1) + i8 + i9;
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // c.b.d.l0, c.b.d.k1
            public final q2 getUnknownFields() {
                return this.unknownFields;
            }

            @Override // c.b.d.a
            public int hashCode() {
                int i2 = this.memoizedHashCode;
                if (i2 != 0) {
                    return i2;
                }
                int hashCode = r.V.hashCode() + 779;
                if (this.f5745c.size() > 0) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + this.f5745c.hashCode();
                }
                if (this.f5747e.size() > 0) {
                    hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f5747e.hashCode();
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

            @Override // c.b.d.l0
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.W;
                fVar.c(c.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
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

            @Override // c.b.d.f1, c.b.d.i1
            public f1.a newBuilderForType() {
                return k.toBuilder();
            }

            @Override // c.b.d.l0
            public Object newInstance(l0.g gVar) {
                return new c();
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
            public void writeTo(m mVar) {
                getSerializedSize();
                if (this.f5745c.size() > 0) {
                    mVar.t0(10);
                    mVar.t0(this.f5746d);
                }
                for (int i2 = 0; i2 < this.f5745c.size(); i2++) {
                    mVar.j0(((m0) this.f5745c).g(i2));
                }
                if (this.f5747e.size() > 0) {
                    mVar.t0(18);
                    mVar.t0(this.f5748f);
                }
                for (int i3 = 0; i3 < this.f5747e.size(); i3++) {
                    mVar.j0(((m0) this.f5747e).g(i3));
                }
                if ((this.f5744b & 1) != 0) {
                    l0.writeString(mVar, 3, this.f5749g);
                }
                if ((this.f5744b & 2) != 0) {
                    l0.writeString(mVar, 4, this.h);
                }
                for (int i4 = 0; i4 < this.i.size(); i4++) {
                    l0.writeString(mVar, 6, this.i.b(i4));
                }
                this.unknownFields.writeTo(mVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m297getDefaultInstanceForType() {
                return k;
            }

            @Override // c.b.d.l0
            public f1.a newBuilderForType(l0.c cVar) {
                return new b(cVar, null);
            }

            @Override // c.b.d.f1, c.b.d.i1
            /* renamed from: newBuilderForType  reason: collision with other method in class */
            public i1.a m298newBuilderForType() {
                return k.toBuilder();
            }
        }

        public s() {
            this.f5740c = -1;
            this.f5739b = Collections.emptyList();
        }

        public s(l0.b bVar, a aVar) {
            super(bVar);
            this.f5740c = -1;
        }

        /* renamed from: a */
        public b toBuilder() {
            if (this == f5737d) {
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
            if (this.f5739b.equals(sVar.f5739b) && this.unknownFields.equals(sVar.unknownFields)) {
                return true;
            }
            return false;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return f5737d;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<s> getParserForType() {
            return f5738e;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f5739b.size(); i3++) {
                i2 += m.z(1, this.f5739b.get(i3));
            }
            int serializedSize = this.unknownFields.getSerializedSize() + i2;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i = this.memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = r.T.hashCode() + 779;
            if (this.f5739b.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 1, 53) + this.f5739b.hashCode();
            }
            int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.U;
            fVar.c(s.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
        public final boolean isInitialized() {
            byte b2 = this.f5740c;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.f5740c = 1;
            return true;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return f5737d.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new s();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            for (int i = 0; i < this.f5739b.size(); i++) {
                mVar.k0(1, this.f5739b.get(i));
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m283getDefaultInstanceForType() {
            return f5737d;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m284newBuilderForType() {
            return f5737d.toBuilder();
        }
    }

    public static final class t extends l0 implements k1 {
        public static final t k = new t();
        @Deprecated
        public static final w1<t> l = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f5756b;

        /* renamed from: c  reason: collision with root package name */
        public List<c> f5757c;

        /* renamed from: d  reason: collision with root package name */
        public volatile Object f5758d;

        /* renamed from: e  reason: collision with root package name */
        public long f5759e;

        /* renamed from: f  reason: collision with root package name */
        public long f5760f;

        /* renamed from: g  reason: collision with root package name */
        public double f5761g;
        public j h;
        public volatile Object i;
        public byte j;

        public static class a extends c<t> {
            /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.List<c.b.d.r$t$c> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.b.d.w1
            public Object parsePartialFrom(k kVar, z zVar) {
                t tVar = new t();
                if (zVar != null) {
                    q2.b b2 = q2.b();
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int G = kVar.G();
                            if (G != 0) {
                                if (G == 18) {
                                    if (!z2 || !true) {
                                        tVar.f5757c = new ArrayList();
                                        z2 |= true;
                                    }
                                    tVar.f5757c.add(kVar.w(c.f5769g, zVar));
                                } else if (G == 26) {
                                    j n = kVar.n();
                                    tVar.f5756b |= 1;
                                    tVar.f5758d = n;
                                } else if (G == 32) {
                                    tVar.f5756b |= 2;
                                    tVar.f5759e = kVar.I();
                                } else if (G == 40) {
                                    tVar.f5756b |= 4;
                                    tVar.f5760f = kVar.v();
                                } else if (G == 49) {
                                    tVar.f5756b |= 8;
                                    tVar.f5761g = kVar.o();
                                } else if (G == 58) {
                                    tVar.f5756b |= 16;
                                    tVar.h = kVar.n();
                                } else if (G == 66) {
                                    j n2 = kVar.n();
                                    tVar.f5756b = 32 | tVar.f5756b;
                                    tVar.i = n2;
                                } else if (!tVar.parseUnknownField(kVar, b2, zVar, G)) {
                                }
                            }
                            z = true;
                        } catch (o0 e2) {
                            e2.f5447b = tVar;
                            throw e2;
                        } catch (IOException e3) {
                            o0 o0Var = new o0(e3);
                            o0Var.f5447b = tVar;
                            throw o0Var;
                        } catch (Throwable th) {
                            if (z2 && true) {
                                tVar.f5757c = Collections.unmodifiableList(tVar.f5757c);
                            }
                            tVar.unknownFields = b2.build();
                            tVar.makeExtensionsImmutable();
                            throw th;
                        }
                    }
                    if (z2 && true) {
                        tVar.f5757c = Collections.unmodifiableList(tVar.f5757c);
                    }
                    tVar.unknownFields = b2.build();
                    tVar.makeExtensionsImmutable();
                    return tVar;
                }
                throw null;
            }
        }

        public static final class b extends l0.b<b> implements Object {

            /* renamed from: b  reason: collision with root package name */
            public int f5762b;

            /* renamed from: c  reason: collision with root package name */
            public List<c> f5763c = Collections.emptyList();

            /* renamed from: d  reason: collision with root package name */
            public c2<c, c.b, Object> f5764d;

            /* renamed from: e  reason: collision with root package name */
            public Object f5765e = "";

            /* renamed from: f  reason: collision with root package name */
            public long f5766f;

            /* renamed from: g  reason: collision with root package name */
            public long f5767g;
            public double h;
            public j i = j.f5320c;
            public Object j = "";

            public b() {
                if (l0.alwaysUseFieldBuilders) {
                    d();
                }
            }

            /* renamed from: a */
            public t buildPartial() {
                List<c> list;
                t tVar = new t(this, null);
                int i2 = this.f5762b;
                c2<c, c.b, Object> c2Var = this.f5764d;
                if (c2Var == null) {
                    if ((i2 & 1) != 0) {
                        this.f5763c = Collections.unmodifiableList(this.f5763c);
                        this.f5762b &= -2;
                    }
                    list = this.f5763c;
                } else {
                    list = c2Var.g();
                }
                tVar.f5757c = list;
                int i3 = (i2 & 2) != 0 ? 1 : 0;
                tVar.f5758d = this.f5765e;
                if ((i2 & 4) != 0) {
                    tVar.f5759e = this.f5766f;
                    i3 |= 2;
                }
                if ((i2 & 8) != 0) {
                    tVar.f5760f = this.f5767g;
                    i3 |= 4;
                }
                if ((i2 & 16) != 0) {
                    tVar.f5761g = this.h;
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
                tVar.f5756b = i3;
                onBuilt();
                return tVar;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: addRepeatedField  reason: collision with other method in class */
            public b m313addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            public b b() {
                super.clear();
                c2<c, c.b, Object> c2Var = this.f5764d;
                if (c2Var == null) {
                    this.f5763c = Collections.emptyList();
                    this.f5762b &= -2;
                } else {
                    c2Var.h();
                }
                this.f5765e = "";
                int i2 = this.f5762b & -3;
                this.f5762b = i2;
                this.f5766f = 0;
                int i3 = i2 & -5;
                this.f5762b = i3;
                this.f5767g = 0;
                int i4 = i3 & -9;
                this.f5762b = i4;
                this.h = 0.0d;
                int i5 = i4 & -17;
                this.f5762b = i5;
                this.i = j.f5320c;
                int i6 = i5 & -33;
                this.f5762b = i6;
                this.j = "";
                this.f5762b = i6 & -65;
                return this;
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            public f1 build() {
                t a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
            }

            /* renamed from: c */
            public b clone() {
                return (b) super.clone();
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: clearField  reason: collision with other method in class */
            public b m315clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            public final c2<c, c.b, Object> d() {
                if (this.f5764d == null) {
                    List<c> list = this.f5763c;
                    boolean z = true;
                    if ((this.f5762b & 1) == 0) {
                        z = false;
                    }
                    this.f5764d = new c2<>(list, z, getParentForChildren(), isClean());
                    this.f5763c = null;
                }
                return this.f5764d;
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
                } catch (o0 e2) {
                    tVar = (t) e2.f5447b;
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
                if (this.f5764d == null) {
                    if (!tVar.f5757c.isEmpty()) {
                        if (this.f5763c.isEmpty()) {
                            this.f5763c = tVar.f5757c;
                            this.f5762b &= -2;
                        } else {
                            if ((this.f5762b & 1) == 0) {
                                this.f5763c = new ArrayList(this.f5763c);
                                this.f5762b |= 1;
                            }
                            this.f5763c.addAll(tVar.f5757c);
                        }
                        onChanged();
                    }
                } else if (!tVar.f5757c.isEmpty()) {
                    if (this.f5764d.s()) {
                        this.f5764d.f5234a = null;
                        this.f5764d = null;
                        this.f5763c = tVar.f5757c;
                        this.f5762b &= -2;
                        this.f5764d = l0.alwaysUseFieldBuilders ? d() : null;
                    } else {
                        this.f5764d.b(tVar.f5757c);
                    }
                }
                if (tVar.e()) {
                    this.f5762b |= 2;
                    this.f5765e = tVar.f5758d;
                    onChanged();
                }
                if (tVar.g()) {
                    long j2 = tVar.f5759e;
                    this.f5762b |= 4;
                    this.f5766f = j2;
                    onChanged();
                }
                if (tVar.f()) {
                    long j3 = tVar.f5760f;
                    this.f5762b |= 8;
                    this.f5767g = j3;
                    onChanged();
                }
                if (tVar.d()) {
                    double d2 = tVar.f5761g;
                    this.f5762b |= 16;
                    this.h = d2;
                    onChanged();
                }
                if (tVar.h()) {
                    j jVar = tVar.h;
                    if (jVar != null) {
                        this.f5762b |= 32;
                        this.i = jVar;
                        onChanged();
                    } else {
                        throw null;
                    }
                }
                if (tVar.c()) {
                    this.f5762b |= 64;
                    this.j = tVar.i;
                    onChanged();
                }
                g(tVar.unknownFields);
                onChanged();
                return this;
            }

            public final b g(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return t.k;
            }

            @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
            public s.b getDescriptorForType() {
                return r.P;
            }

            @Override // c.b.d.l0.b
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.Q;
                fVar.c(t.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0.b, c.b.d.j1
            public final boolean isInitialized() {
                c cVar;
                int i2 = 0;
                while (true) {
                    c2<c, c.b, Object> c2Var = this.f5764d;
                    if (i2 >= (c2Var == null ? this.f5763c.size() : c2Var.m())) {
                        return true;
                    }
                    c2<c, c.b, Object> c2Var2 = this.f5764d;
                    if (c2Var2 == null) {
                        cVar = this.f5763c.get(i2);
                    } else {
                        cVar = c2Var2.n(i2, false);
                    }
                    if (!cVar.isInitialized()) {
                        return false;
                    }
                    i2++;
                }
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public a.AbstractC0106a mergeFrom(f1 f1Var) {
                if (f1Var instanceof t) {
                    f((t) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.a$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            public b mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setField  reason: collision with other method in class */
            public b m322setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            /* renamed from: setRepeatedField  reason: collision with other method in class */
            public b m323setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            /* renamed from: setUnknownFields  reason: collision with other method in class */
            public b m324setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            public b(a aVar) {
                if (l0.alwaysUseFieldBuilders) {
                    d();
                }
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b addRepeatedField(s.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // c.b.d.i1.a, c.b.d.f1.a
            /* renamed from: build  reason: collision with other method in class */
            public i1 m314build() {
                t a2 = buildPartial();
                if (a2.isInitialized()) {
                    return a2;
                }
                throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b clearField(s.g gVar) {
                return (b) super.clearField(gVar);
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m317clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m318getDefaultInstanceForType() {
                return t.k;
            }

            @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeFrom  reason: collision with other method in class */
            public f1.a m319mergeFrom(f1 f1Var) {
                if (f1Var instanceof t) {
                    f((t) f1Var);
                } else {
                    super.mergeFrom(f1Var);
                }
                return this;
            }

            /* Return type fixed from 'c.b.d.l0$b' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m321mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setField(s.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b
            public b setRepeatedField(s.g gVar, int i2, Object obj) {
                return (b) super.setRepeatedField(gVar, i2, obj);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
            public b setUnknownFields(q2 q2Var) {
                return (b) super.setUnknownFields(q2Var);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: clearOneof  reason: collision with other method in class */
            public b m316clearOneof(s.k kVar) {
                return (b) super.clearOneof(kVar);
            }

            /* Return type fixed from 'c.b.d.f1$a' to match base method */
            @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
            /* renamed from: mergeUnknownFields  reason: collision with other method in class */
            public b m320mergeUnknownFields(q2 q2Var) {
                return (b) super.mergeUnknownFields(q2Var);
            }

            public b(l0.c cVar, a aVar) {
                super(cVar);
                if (l0.alwaysUseFieldBuilders) {
                    d();
                }
            }
        }

        public static final class c extends l0 implements k1 {

            /* renamed from: f  reason: collision with root package name */
            public static final c f5768f = new c();
            @Deprecated

            /* renamed from: g  reason: collision with root package name */
            public static final w1<c> f5769g = new a();

            /* renamed from: b  reason: collision with root package name */
            public int f5770b;

            /* renamed from: c  reason: collision with root package name */
            public volatile Object f5771c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f5772d;

            /* renamed from: e  reason: collision with root package name */
            public byte f5773e;

            public static class a extends c<c> {
                @Override // c.b.d.w1
                public Object parsePartialFrom(k kVar, z zVar) {
                    c cVar = new c();
                    if (zVar != null) {
                        q2.b b2 = q2.b();
                        boolean z = false;
                        while (!z) {
                            try {
                                int G = kVar.G();
                                if (G != 0) {
                                    if (G == 10) {
                                        j n = kVar.n();
                                        cVar.f5770b = 1 | cVar.f5770b;
                                        cVar.f5771c = n;
                                    } else if (G == 16) {
                                        cVar.f5770b |= 2;
                                        cVar.f5772d = kVar.m();
                                    } else if (!cVar.parseUnknownField(kVar, b2, zVar, G)) {
                                    }
                                }
                                z = true;
                            } catch (o0 e2) {
                                e2.f5447b = cVar;
                                throw e2;
                            } catch (IOException e3) {
                                o0 o0Var = new o0(e3);
                                o0Var.f5447b = cVar;
                                throw o0Var;
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

            public static final class b extends l0.b<b> implements Object {

                /* renamed from: b  reason: collision with root package name */
                public int f5774b;

                /* renamed from: c  reason: collision with root package name */
                public Object f5775c = "";

                /* renamed from: d  reason: collision with root package name */
                public boolean f5776d;

                public b() {
                }

                public b(a aVar) {
                }

                /* renamed from: a */
                public c buildPartial() {
                    c cVar = new c(this, null);
                    int i = this.f5774b;
                    int i2 = (i & 1) != 0 ? 1 : 0;
                    cVar.f5771c = this.f5775c;
                    if ((i & 2) != 0) {
                        cVar.f5772d = this.f5776d;
                        i2 |= 2;
                    }
                    cVar.f5770b = i2;
                    onBuilt();
                    return cVar;
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: addRepeatedField  reason: collision with other method in class */
                public b m327addRepeatedField(s.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                public b b() {
                    super.clear();
                    this.f5775c = "";
                    int i = this.f5774b & -2;
                    this.f5774b = i;
                    this.f5776d = false;
                    this.f5774b = i & -3;
                    return this;
                }

                @Override // c.b.d.i1.a, c.b.d.f1.a
                public f1 build() {
                    c a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
                }

                /* renamed from: c */
                public b clone() {
                    return (b) super.clone();
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: clearField  reason: collision with other method in class */
                public b m329clearField(s.g gVar) {
                    return (b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                public b clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x001f  */
                public b d(k kVar, z zVar) {
                    Throwable th;
                    c cVar;
                    c cVar2 = null;
                    try {
                        c parsePartialFrom = c.f5769g.parsePartialFrom(kVar, zVar);
                        if (parsePartialFrom != null) {
                            e(parsePartialFrom);
                        }
                        return this;
                    } catch (o0 e2) {
                        cVar = (c) e2.f5447b;
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
                    if (cVar == c.f5768f) {
                        return this;
                    }
                    if (cVar.c()) {
                        this.f5774b |= 1;
                        this.f5775c = cVar.f5771c;
                        onChanged();
                    }
                    if (cVar.b()) {
                        boolean z = cVar.f5772d;
                        this.f5774b |= 2;
                        this.f5776d = z;
                        onChanged();
                    }
                    f(cVar.unknownFields);
                    onChanged();
                    return this;
                }

                public final b f(q2 q2Var) {
                    return (b) super.mergeUnknownFields(q2Var);
                }

                @Override // c.b.d.k1, c.b.d.j1
                public f1 getDefaultInstanceForType() {
                    return c.f5768f;
                }

                @Override // c.b.d.l0.b, c.b.d.k1, c.b.d.f1.a
                public s.b getDescriptorForType() {
                    return r.R;
                }

                @Override // c.b.d.l0.b
                public l0.f internalGetFieldAccessorTable() {
                    l0.f fVar = r.S;
                    fVar.c(c.class, b.class);
                    return fVar;
                }

                @Override // c.b.d.l0.b, c.b.d.j1
                public final boolean isInitialized() {
                    if (!((this.f5774b & 1) != 0)) {
                        return false;
                    }
                    return (this.f5774b & 2) != 0;
                }

                @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                public a.AbstractC0106a mergeFrom(f1 f1Var) {
                    if (f1Var instanceof c) {
                        e((c) f1Var);
                    } else {
                        super.mergeFrom(f1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.a$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                public b mergeUnknownFields(q2 q2Var) {
                    return (b) super.mergeUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: setField  reason: collision with other method in class */
                public b m336setField(s.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b
                /* renamed from: setRepeatedField  reason: collision with other method in class */
                public b m337setRepeatedField(s.g gVar, int i, Object obj) {
                    return (b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                /* renamed from: setUnknownFields  reason: collision with other method in class */
                public b m338setUnknownFields(q2 q2Var) {
                    return (b) super.setUnknownFields(q2Var);
                }

                public b(l0.c cVar, a aVar) {
                    super(cVar);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public b addRepeatedField(s.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                @Override // c.b.d.i1.a, c.b.d.f1.a
                /* renamed from: build  reason: collision with other method in class */
                public i1 m328build() {
                    c a2 = buildPartial();
                    if (a2.isInitialized()) {
                        return a2;
                    }
                    throw a.AbstractC0106a.newUninitializedMessageException((f1) a2);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public b clearField(s.g gVar) {
                    return (b) super.clearField(gVar);
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public b m331clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                @Override // c.b.d.k1, c.b.d.j1
                /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
                public i1 m332getDefaultInstanceForType() {
                    return c.f5768f;
                }

                @Override // c.b.d.f1.a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeFrom  reason: collision with other method in class */
                public f1.a m333mergeFrom(f1 f1Var) {
                    if (f1Var instanceof c) {
                        e((c) f1Var);
                    } else {
                        super.mergeFrom(f1Var);
                    }
                    return this;
                }

                /* Return type fixed from 'c.b.d.l0$b' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public b m335mergeUnknownFields(q2 q2Var) {
                    return (b) super.mergeUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public b setField(s.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b
                public b setRepeatedField(s.g gVar, int i, Object obj) {
                    return (b) super.setRepeatedField(gVar, i, obj);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.f1.a
                public b setUnknownFields(q2 q2Var) {
                    return (b) super.setUnknownFields(q2Var);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: clearOneof  reason: collision with other method in class */
                public b m330clearOneof(s.k kVar) {
                    return (b) super.clearOneof(kVar);
                }

                /* Return type fixed from 'c.b.d.f1$a' to match base method */
                @Override // c.b.d.l0.b, c.b.d.l0.b, c.b.d.l0.b, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
                /* renamed from: mergeUnknownFields  reason: collision with other method in class */
                public b m334mergeUnknownFields(q2 q2Var) {
                    return (b) super.mergeUnknownFields(q2Var);
                }
            }

            public c() {
                this.f5773e = -1;
                this.f5771c = "";
            }

            public c(l0.b bVar, a aVar) {
                super(bVar);
                this.f5773e = -1;
            }

            public String a() {
                Object obj = this.f5771c;
                if (obj instanceof String) {
                    return (String) obj;
                }
                j jVar = (j) obj;
                String z = jVar.z();
                if (jVar.o()) {
                    this.f5771c = z;
                }
                return z;
            }

            public boolean b() {
                return (this.f5770b & 2) != 0;
            }

            public boolean c() {
                return (this.f5770b & 1) != 0;
            }

            /* renamed from: d */
            public b toBuilder() {
                if (this == f5768f) {
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
                    return (!b() || this.f5772d == cVar.f5772d) && this.unknownFields.equals(cVar.unknownFields);
                }
                return false;
            }

            @Override // c.b.d.k1, c.b.d.j1
            public f1 getDefaultInstanceForType() {
                return f5768f;
            }

            @Override // c.b.d.l0, c.b.d.i1
            public w1<c> getParserForType() {
                return f5769g;
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.f5770b & 1) != 0) {
                    i2 = 0 + l0.computeStringSize(1, this.f5771c);
                }
                if ((this.f5770b & 2) != 0) {
                    i2 += m.c(2, this.f5772d);
                }
                int serializedSize = this.unknownFields.getSerializedSize() + i2;
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // c.b.d.l0, c.b.d.k1
            public final q2 getUnknownFields() {
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
                    hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + n0.c(this.f5772d);
                }
                int hashCode2 = this.unknownFields.hashCode() + (hashCode * 29);
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // c.b.d.l0
            public l0.f internalGetFieldAccessorTable() {
                l0.f fVar = r.S;
                fVar.c(c.class, b.class);
                return fVar;
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
            public final boolean isInitialized() {
                byte b2 = this.f5773e;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                if (!c()) {
                    this.f5773e = 0;
                    return false;
                } else if (!b()) {
                    this.f5773e = 0;
                    return false;
                } else {
                    this.f5773e = 1;
                    return true;
                }
            }

            @Override // c.b.d.f1, c.b.d.i1
            public f1.a newBuilderForType() {
                return f5768f.toBuilder();
            }

            @Override // c.b.d.l0
            public Object newInstance(l0.g gVar) {
                return new c();
            }

            @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
            public void writeTo(m mVar) {
                if ((this.f5770b & 1) != 0) {
                    l0.writeString(mVar, 1, this.f5771c);
                }
                if ((this.f5770b & 2) != 0) {
                    mVar.Y(2, this.f5772d);
                }
                this.unknownFields.writeTo(mVar);
            }

            @Override // c.b.d.k1, c.b.d.j1
            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public i1 m325getDefaultInstanceForType() {
                return f5768f;
            }

            @Override // c.b.d.l0
            public f1.a newBuilderForType(l0.c cVar) {
                return new b(cVar, null);
            }

            @Override // c.b.d.f1, c.b.d.i1
            /* renamed from: newBuilderForType  reason: collision with other method in class */
            public i1.a m326newBuilderForType() {
                return f5768f.toBuilder();
            }
        }

        public t() {
            this.j = -1;
            this.f5757c = Collections.emptyList();
            this.f5758d = "";
            this.h = j.f5320c;
            this.i = "";
        }

        public t(l0.b bVar, a aVar) {
            super(bVar);
            this.j = -1;
        }

        public String a() {
            Object obj = this.i;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.i = z;
            }
            return z;
        }

        public String b() {
            Object obj = this.f5758d;
            if (obj instanceof String) {
                return (String) obj;
            }
            j jVar = (j) obj;
            String z = jVar.z();
            if (jVar.o()) {
                this.f5758d = z;
            }
            return z;
        }

        public boolean c() {
            return (this.f5756b & 32) != 0;
        }

        public boolean d() {
            return (this.f5756b & 8) != 0;
        }

        public boolean e() {
            return (this.f5756b & 1) != 0;
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
            if (!this.f5757c.equals(tVar.f5757c) || e() != tVar.e()) {
                return false;
            }
            if ((e() && !b().equals(tVar.b())) || g() != tVar.g()) {
                return false;
            }
            if ((g() && this.f5759e != tVar.f5759e) || f() != tVar.f()) {
                return false;
            }
            if ((f() && this.f5760f != tVar.f5760f) || d() != tVar.d()) {
                return false;
            }
            if ((d() && Double.doubleToLongBits(this.f5761g) != Double.doubleToLongBits(tVar.f5761g)) || h() != tVar.h()) {
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
            return (this.f5756b & 4) != 0;
        }

        public boolean g() {
            return (this.f5756b & 2) != 0;
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return k;
        }

        @Override // c.b.d.l0, c.b.d.i1
        public w1<t> getParserForType() {
            return l;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public int getSerializedSize() {
            int i2 = this.memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.f5757c.size(); i4++) {
                i3 += m.z(2, this.f5757c.get(i4));
            }
            if ((this.f5756b & 1) != 0) {
                i3 += l0.computeStringSize(3, this.f5758d);
            }
            if ((this.f5756b & 2) != 0) {
                i3 += m.Q(4, this.f5759e);
            }
            if ((this.f5756b & 4) != 0) {
                i3 += m.u(5, this.f5760f);
            }
            if ((this.f5756b & 8) != 0) {
                i3 += m.h(6, this.f5761g);
            }
            if ((this.f5756b & 16) != 0) {
                i3 += m.f(7, this.h);
            }
            if ((this.f5756b & 32) != 0) {
                i3 += l0.computeStringSize(8, this.i);
            }
            int serializedSize = this.unknownFields.getSerializedSize() + i3;
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // c.b.d.l0, c.b.d.k1
        public final q2 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean h() {
            return (this.f5756b & 16) != 0;
        }

        @Override // c.b.d.a
        public int hashCode() {
            int i2 = this.memoizedHashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = r.P.hashCode() + 779;
            if (this.f5757c.size() > 0) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 2, 53) + this.f5757c.hashCode();
            }
            if (e()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 3, 53) + b().hashCode();
            }
            if (g()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 4, 53) + n0.e(this.f5759e);
            }
            if (f()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 5, 53) + n0.e(this.f5760f);
            }
            if (d()) {
                hashCode = c.a.a.a.a.a(hashCode, 37, 6, 53) + n0.e(Double.doubleToLongBits(this.f5761g));
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

        @Override // c.b.d.l0
        public l0.f internalGetFieldAccessorTable() {
            l0.f fVar = r.Q;
            fVar.c(t.class, b.class);
            return fVar;
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
        public final boolean isInitialized() {
            byte b2 = this.j;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.f5757c.size(); i2++) {
                if (!this.f5757c.get(i2).isInitialized()) {
                    this.j = 0;
                    return false;
                }
            }
            this.j = 1;
            return true;
        }

        @Override // c.b.d.f1, c.b.d.i1
        public f1.a newBuilderForType() {
            return k.toBuilder();
        }

        @Override // c.b.d.l0
        public Object newInstance(l0.g gVar) {
            return new t();
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.i1
        public void writeTo(m mVar) {
            for (int i2 = 0; i2 < this.f5757c.size(); i2++) {
                mVar.k0(2, this.f5757c.get(i2));
            }
            if ((this.f5756b & 1) != 0) {
                l0.writeString(mVar, 3, this.f5758d);
            }
            if ((this.f5756b & 2) != 0) {
                mVar.u0(4, this.f5759e);
            }
            if ((this.f5756b & 4) != 0) {
                mVar.u0(5, this.f5760f);
            }
            if ((this.f5756b & 8) != 0) {
                mVar.c0(6, this.f5761g);
            }
            if ((this.f5756b & 16) != 0) {
                mVar.a0(7, this.h);
            }
            if ((this.f5756b & 32) != 0) {
                l0.writeString(mVar, 8, this.i);
            }
            this.unknownFields.writeTo(mVar);
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m311getDefaultInstanceForType() {
            return k;
        }

        @Override // c.b.d.l0
        public f1.a newBuilderForType(l0.c cVar) {
            return new b(cVar, null);
        }

        @Override // c.b.d.f1, c.b.d.i1
        /* renamed from: newBuilderForType  reason: collision with other method in class */
        public i1.a m312newBuilderForType() {
            return k.toBuilder();
        }
    }

    static {
        s.h r2 = s.h.r(new String[]{"\n google/protobuf/descriptor.proto\u0012\u000fgoogle.protobuf\"G\n\u0011FileDescriptorSet\u00122\n\u0004file\u0018\u0001 \u0003(\u000b2$.google.protobuf.FileDescriptorProto\"Û\u0003\n\u0013FileDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007package\u0018\u0002 \u0001(\t\u0012\u0012\n\ndependency\u0018\u0003 \u0003(\t\u0012\u0019\n\u0011public_dependency\u0018\n \u0003(\u0005\u0012\u0017\n\u000fweak_dependency\u0018\u000b \u0003(\u0005\u00126\n\fmessage_type\u0018\u0004 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0005 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u00128\n\u0007service\u0018\u0006 \u0003(\u000b2'.google.protobuf.ServiceDescriptorProto\u00128\n\textension\u0018\u0007 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u0012-\n\u0007options\u0018\b \u0001(\u000b2\u001c.google.protobuf.FileOptions\u00129\n\u0010source_code_info\u0018\t \u0001(\u000b2\u001f.google.protobuf.SourceCodeInfo\u0012\u000e\n\u0006syntax\u0018\f \u0001(\t\"©\u0005\n\u000fDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00124\n\u0005field\u0018\u0002 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00128\n\textension\u0018\u0006 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00125\n\u000bnested_type\u0018\u0003 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0004 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u0012H\n\u000fextension_range\u0018\u0005 \u0003(\u000b2/.google.protobuf.DescriptorProto.ExtensionRange\u00129\n\noneof_decl\u0018\b \u0003(\u000b2%.google.protobuf.OneofDescriptorProto\u00120\n\u0007options\u0018\u0007 \u0001(\u000b2\u001f.google.protobuf.MessageOptions\u0012F\n\u000ereserved_range\u0018\t \u0003(\u000b2..google.protobuf.DescriptorProto.ReservedRange\u0012\u0015\n\rreserved_name\u0018\n \u0003(\t\u001ae\n\u000eExtensionRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\u00127\n\u0007options\u0018\u0003 \u0001(\u000b2&.google.protobuf.ExtensionRangeOptions\u001a+\n\rReservedRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"g\n\u0015ExtensionRangeOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"¼\u0005\n\u0014FieldDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0003 \u0001(\u0005\u0012:\n\u0005label\u0018\u0004 \u0001(\u000e2+.google.protobuf.FieldDescriptorProto.Label\u00128\n\u0004type\u0018\u0005 \u0001(\u000e2*.google.protobuf.FieldDescriptorProto.Type\u0012\u0011\n\ttype_name\u0018\u0006 \u0001(\t\u0012\u0010\n\bextendee\u0018\u0002 \u0001(\t\u0012\u0015\n\rdefault_value\u0018\u0007 \u0001(\t\u0012\u0013\n\u000boneof_index\u0018\t \u0001(\u0005\u0012\u0011\n\tjson_name\u0018\n \u0001(\t\u0012.\n\u0007options\u0018\b \u0001(\u000b2\u001d.google.protobuf.FieldOptions\"¶\u0002\n\u0004Type\u0012\u000f\n\u000bTYPE_DOUBLE\u0010\u0001\u0012\u000e\n\nTYPE_FLOAT\u0010\u0002\u0012\u000e\n\nTYPE_INT64\u0010\u0003\u0012\u000f\n\u000bTYPE_UINT64\u0010\u0004\u0012\u000e\n\nTYPE_INT32\u0010\u0005\u0012\u0010\n\fTYPE_FIXED64\u0010\u0006\u0012\u0010\n\fTYPE_FIXED32\u0010\u0007\u0012\r\n\tTYPE_BOOL\u0010\b\u0012\u000f\n\u000bTYPE_STRING\u0010\t\u0012\u000e\n\nTYPE_GROUP\u0010\n\u0012\u0010\n\fTYPE_MESSAGE\u0010\u000b\u0012\u000e\n\nTYPE_BYTES\u0010\f\u0012\u000f\n\u000bTYPE_UINT32\u0010\r\u0012\r\n\tTYPE_ENUM\u0010\u000e\u0012\u0011\n\rTYPE_SFIXED32\u0010\u000f\u0012\u0011\n\rTYPE_SFIXED64\u0010\u0010\u0012\u000f\n\u000bTYPE_SINT32\u0010\u0011\u0012\u000f\n\u000bTYPE_SINT64\u0010\u0012\"C\n\u0005Label\u0012\u0012\n\u000eLABEL_OPTIONAL\u0010\u0001\u0012\u0012\n\u000eLABEL_REQUIRED\u0010\u0002\u0012\u0012\n\u000eLABEL_REPEATED\u0010\u0003\"T\n\u0014OneofDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012.\n\u0007options\u0018\u0002 \u0001(\u000b2\u001d.google.protobuf.OneofOptions\"¤\u0002\n\u0013EnumDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00128\n\u0005value\u0018\u0002 \u0003(\u000b2).google.protobuf.EnumValueDescriptorProto\u0012-\n\u0007options\u0018\u0003 \u0001(\u000b2\u001c.google.protobuf.EnumOptions\u0012N\n\u000ereserved_range\u0018\u0004 \u0003(\u000b26.google.protobuf.EnumDescriptorProto.EnumReservedRange\u0012\u0015\n\rreserved_name\u0018\u0005 \u0003(\t\u001a/\n\u0011EnumReservedRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"l\n\u0018EnumValueDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\u0005\u00122\n\u0007options\u0018\u0003 \u0001(\u000b2!.google.protobuf.EnumValueOptions\"\u0001\n\u0016ServiceDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00126\n\u0006method\u0018\u0002 \u0003(\u000b2&.google.protobuf.MethodDescriptorProto\u00120\n\u0007options\u0018\u0003 \u0001(\u000b2\u001f.google.protobuf.ServiceOptions\"Á\u0001\n\u0015MethodDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0012\n\ninput_type\u0018\u0002 \u0001(\t\u0012\u0013\n\u000boutput_type\u0018\u0003 \u0001(\t\u0012/\n\u0007options\u0018\u0004 \u0001(\u000b2\u001e.google.protobuf.MethodOptions\u0012\u001f\n\u0010client_streaming\u0018\u0005 \u0001(\b:\u0005false\u0012\u001f\n\u0010server_streaming\u0018\u0006 \u0001(\b:\u0005false\"¦\u0006\n\u000bFileOptions\u0012\u0014\n\fjava_package\u0018\u0001 \u0001(\t\u0012\u001c\n\u0014java_outer_classname\u0018\b \u0001(\t\u0012\"\n\u0013java_multiple_files\u0018\n \u0001(\b:\u0005false\u0012)\n\u001djava_generate_equals_and_hash\u0018\u0014 \u0001(\bB\u0002\u0018\u0001\u0012%\n\u0016java_string_check_utf8\u0018\u001b \u0001(\b:\u0005false\u0012F\n\foptimize_for\u0018\t \u0001(\u000e2).google.protobuf.FileOptions.OptimizeMode:\u0005SPEED\u0012\u0012\n\ngo_package\u0018\u000b \u0001(\t\u0012\"\n\u0013cc_generic_services\u0018\u0010 \u0001(\b:\u0005false\u0012$\n\u0015java_generic_services\u0018\u0011 \u0001(\b:\u0005false\u0012\"\n\u0013py_generic_services\u0018\u0012 \u0001(\b:\u0005false\u0012#\n\u0014php_generic_services\u0018* \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0017 \u0001(\b:\u0005false\u0012\u001f\n\u0010cc_enable_arenas\u0018\u001f \u0001(\b:\u0005false\u0012\u0019\n\u0011objc_class_prefix\u0018$ \u0001(\t\u0012\u0018\n\u0010csharp_namespace\u0018% \u0001(\t\u0012\u0014\n\fswift_prefix\u0018' \u0001(\t\u0012\u0018\n\u0010php_class_prefix\u0018( \u0001(\t\u0012\u0015\n\rphp_namespace\u0018) \u0001(\t\u0012\u001e\n\u0016php_metadata_namespace\u0018, \u0001(\t\u0012\u0014\n\fruby_package\u0018- \u0001(\t\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\u0012\t\n\u0005SPEED\u0010\u0001\u0012\r\n\tCODE_SIZE\u0010\u0002\u0012\u0010\n\fLITE_RUNTIME\u0010\u0003*\t\bè\u0007\u0010\u0002J\u0004\b&\u0010'\"ò\u0001\n\u000eMessageOptions\u0012&\n\u0017message_set_wire_format\u0018\u0001 \u0001(\b:\u0005false\u0012.\n\u001fno_standard_descriptor_accessor\u0018\u0002 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0011\n\tmap_entry\u0018\u0007 \u0001(\b\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002J\u0004\b\b\u0010\tJ\u0004\b\t\u0010\n\"\u0003\n\fFieldOptions\u0012:\n\u0005ctype\u0018\u0001 \u0001(\u000e2#.google.protobuf.FieldOptions.CType:\u0006STRING\u0012\u000e\n\u0006packed\u0018\u0002 \u0001(\b\u0012?\n\u0006jstype\u0018\u0006 \u0001(\u000e2$.google.protobuf.FieldOptions.JSType:\tJS_NORMAL\u0012\u0013\n\u0004lazy\u0018\u0005 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0013\n\u0004weak\u0018\n \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"/\n\u0005CType\u0012\n\n\u0006STRING\u0010\u0000\u0012\b\n\u0004CORD\u0010\u0001\u0012\u0010\n\fSTRING_PIECE\u0010\u0002\"5\n\u0006JSType\u0012\r\n\tJS_NORMAL\u0010\u0000\u0012\r\n\tJS_STRING\u0010\u0001\u0012\r\n\tJS_NUMBER\u0010\u0002*\t\bè\u0007\u0010\u0002J\u0004\b\u0004\u0010\u0005\"^\n\fOneofOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"\u0001\n\u000bEnumOptions\u0012\u0013\n\u000ballow_alias\u0018\u0002 \u0001(\b\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002J\u0004\b\u0005\u0010\u0006\"}\n\u0010EnumValueOptions\u0012\u0019\n\ndeprecated\u0018\u0001 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"{\n\u000eServiceOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"­\u0002\n\rMethodOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012_\n\u0011idempotency_level\u0018\" \u0001(\u000e2/.google.protobuf.MethodOptions.IdempotencyLevel:\u0013IDEMPOTENCY_UNKNOWN\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"P\n\u0010IdempotencyLevel\u0012\u0017\n\u0013IDEMPOTENCY_UNKNOWN\u0010\u0000\u0012\u0013\n\u000fNO_SIDE_EFFECTS\u0010\u0001\u0012\u000e\n\nIDEMPOTENT\u0010\u0002*\t\bè\u0007\u0010\u0002\"\u0002\n\u0013UninterpretedOption\u0012;\n\u0004name\u0018\u0002 \u0003(\u000b2-.google.protobuf.UninterpretedOption.NamePart\u0012\u0018\n\u0010identifier_value\u0018\u0003 \u0001(\t\u0012\u001a\n\u0012positive_int_value\u0018\u0004 \u0001(\u0004\u0012\u001a\n\u0012negative_int_value\u0018\u0005 \u0001(\u0003\u0012\u0014\n\fdouble_value\u0018\u0006 \u0001(\u0001\u0012\u0014\n\fstring_value\u0018\u0007 \u0001(\f\u0012\u0017\n\u000faggregate_value\u0018\b \u0001(\t\u001a3\n\bNamePart\u0012\u0011\n\tname_part\u0018\u0001 \u0002(\t\u0012\u0014\n\fis_extension\u0018\u0002 \u0002(\b\"Õ\u0001\n\u000eSourceCodeInfo\u0012:\n\blocation\u0018\u0001 \u0003(\u000b2(.google.protobuf.SourceCodeInfo.Location\u001a\u0001\n\bLocation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0010\n\u0004span\u0018\u0002 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0018\n\u0010leading_comments\u0018\u0003 \u0001(\t\u0012\u0019\n\u0011trailing_comments\u0018\u0004 \u0001(\t\u0012!\n\u0019leading_detached_comments\u0018\u0006 \u0003(\t\"§\u0001\n\u0011GeneratedCodeInfo\u0012A\n\nannotation\u0018\u0001 \u0003(\u000b2-.google.protobuf.GeneratedCodeInfo.Annotation\u001aO\n\nAnnotation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0013\n\u000bsource_file\u0018\u0002 \u0001(\t\u0012\r\n\u0005begin\u0018\u0003 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0004 \u0001(\u0005B\u0001\n\u0013com.google.protobufB\u0010DescriptorProtosH\u0001Z>github.com/golang/protobuf/protoc-gen-go/descriptor;descriptorø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001aGoogle.Protobuf.Reflection"}, new s.h[0]);
        Z = r2;
        s.b bVar = r2.m().get(0);
        f5495a = bVar;
        l0.f.a[] aVarArr = new l0.f.a[bVar.p().size()];
        l0.f.c[] cVarArr = new l0.f.c[Collections.unmodifiableList(Arrays.asList(bVar.h)).size()];
        s.b bVar2 = Z.m().get(1);
        f5496b = bVar2;
        f5497c = new l0.f(bVar2, new String[]{"Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo", "Syntax"});
        s.b bVar3 = Z.m().get(2);
        f5498d = bVar3;
        f5499e = new l0.f(bVar3, new String[]{"Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "OneofDecl", "Options", "ReservedRange", "ReservedName"});
        s.b bVar4 = f5498d.r().get(0);
        f5500f = bVar4;
        f5501g = new l0.f(bVar4, new String[]{"Start", "End", "Options"});
        s.b bVar5 = f5498d.r().get(1);
        h = bVar5;
        i = new l0.f(bVar5, new String[]{"Start", "End"});
        s.b bVar6 = Z.m().get(3);
        j = bVar6;
        k = new l0.f(bVar6, new String[]{"UninterpretedOption"});
        s.b bVar7 = Z.m().get(4);
        l = bVar7;
        m = new l0.f(bVar7, new String[]{"Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "OneofIndex", "JsonName", "Options"});
        s.b bVar8 = Z.m().get(5);
        n = bVar8;
        o = new l0.f(bVar8, new String[]{"Name", "Options"});
        s.b bVar9 = Z.m().get(6);
        p = bVar9;
        q = new l0.f(bVar9, new String[]{"Name", "Value", "Options", "ReservedRange", "ReservedName"});
        s.b bVar10 = p.r().get(0);
        r = bVar10;
        s = new l0.f(bVar10, new String[]{"Start", "End"});
        s.b bVar11 = Z.m().get(7);
        t = bVar11;
        u = new l0.f(bVar11, new String[]{"Name", "Number", "Options"});
        s.b bVar12 = Z.m().get(8);
        v = bVar12;
        w = new l0.f(bVar12, new String[]{"Name", "Method", "Options"});
        s.b bVar13 = Z.m().get(9);
        x = bVar13;
        y = new l0.f(bVar13, new String[]{"Name", "InputType", "OutputType", "Options", "ClientStreaming", "ServerStreaming"});
        s.b bVar14 = Z.m().get(10);
        z = bVar14;
        A = new l0.f(bVar14, new String[]{"JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "JavaStringCheckUtf8", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "PhpGenericServices", "Deprecated", "CcEnableArenas", "ObjcClassPrefix", "CsharpNamespace", "SwiftPrefix", "PhpClassPrefix", "PhpNamespace", "PhpMetadataNamespace", "RubyPackage", "UninterpretedOption"});
        s.b bVar15 = Z.m().get(11);
        B = bVar15;
        C = new l0.f(bVar15, new String[]{"MessageSetWireFormat", "NoStandardDescriptorAccessor", "Deprecated", "MapEntry", "UninterpretedOption"});
        s.b bVar16 = Z.m().get(12);
        D = bVar16;
        E = new l0.f(bVar16, new String[]{"Ctype", "Packed", "Jstype", "Lazy", "Deprecated", "Weak", "UninterpretedOption"});
        s.b bVar17 = Z.m().get(13);
        F = bVar17;
        G = new l0.f(bVar17, new String[]{"UninterpretedOption"});
        s.b bVar18 = Z.m().get(14);
        H = bVar18;
        I = new l0.f(bVar18, new String[]{"AllowAlias", "Deprecated", "UninterpretedOption"});
        s.b bVar19 = Z.m().get(15);
        J = bVar19;
        K = new l0.f(bVar19, new String[]{"Deprecated", "UninterpretedOption"});
        s.b bVar20 = Z.m().get(16);
        L = bVar20;
        M = new l0.f(bVar20, new String[]{"Deprecated", "UninterpretedOption"});
        s.b bVar21 = Z.m().get(17);
        N = bVar21;
        O = new l0.f(bVar21, new String[]{"Deprecated", "IdempotencyLevel", "UninterpretedOption"});
        s.b bVar22 = Z.m().get(18);
        P = bVar22;
        Q = new l0.f(bVar22, new String[]{"Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"});
        s.b bVar23 = P.r().get(0);
        R = bVar23;
        S = new l0.f(bVar23, new String[]{"NamePart", "IsExtension"});
        s.b bVar24 = Z.m().get(19);
        T = bVar24;
        U = new l0.f(bVar24, new String[]{"Location"});
        s.b bVar25 = T.r().get(0);
        V = bVar25;
        W = new l0.f(bVar25, new String[]{"Path", "Span", "LeadingComments", "TrailingComments", "LeadingDetachedComments"});
        s.b bVar26 = Z.m().get(20);
        X = bVar26;
        l0.f.a[] aVarArr2 = new l0.f.a[bVar26.p().size()];
        l0.f.c[] cVarArr2 = new l0.f.c[Collections.unmodifiableList(Arrays.asList(bVar26.h)).size()];
        s.b bVar27 = X.r().get(0);
        Y = bVar27;
        l0.f.a[] aVarArr3 = new l0.f.a[bVar27.p().size()];
        l0.f.c[] cVarArr3 = new l0.f.c[Collections.unmodifiableList(Arrays.asList(bVar27.h)).size()];
    }
}
