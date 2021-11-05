package c.b.d;

import c.b.d.a;
import c.b.d.e1;
import c.b.d.h1;
import c.b.d.p2;
import c.b.d.s;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class u extends a {

    /* renamed from: b  reason: collision with root package name */
    public final s.b f4339b;

    /* renamed from: c  reason: collision with root package name */
    public final f0<s.g> f4340c;

    /* renamed from: d  reason: collision with root package name */
    public final s.g[] f4341d;

    /* renamed from: e  reason: collision with root package name */
    public final p2 f4342e;
    public int f = -1;

    public class a extends c<u> {
        public a() {
        }

        @Override // c.b.d.v1
        public Object parsePartialFrom(k kVar, z zVar) {
            b bVar = new b(u.this.f4339b);
            try {
                bVar.mergeFrom(kVar, zVar);
                return bVar.buildPartial();
            } catch (n0 e2) {
                e2.f4007b = bVar.buildPartial();
                throw e2;
            } catch (IOException e3) {
                n0 n0Var = new n0(e3);
                n0Var.f4007b = bVar.buildPartial();
                throw n0Var;
            }
        }
    }

    public static final class b extends a.AbstractC0097a<b> {

        /* renamed from: b  reason: collision with root package name */
        public final s.b f4344b;

        /* renamed from: c  reason: collision with root package name */
        public f0<s.g> f4345c = new f0<>();

        /* renamed from: d  reason: collision with root package name */
        public final s.g[] f4346d;

        /* renamed from: e  reason: collision with root package name */
        public p2 f4347e = p2.f4026d;

        public b(s.b bVar) {
            this.f4344b = bVar;
            this.f4346d = new s.g[bVar.f4264a.f()];
            if (bVar.p().g) {
                i();
            }
        }

        /* renamed from: a */
        public u build() {
            if (isInitialized()) {
                return buildPartial();
            }
            s.b bVar = this.f4344b;
            f0<s.g> f0Var = this.f4345c;
            s.g[] gVarArr = this.f4346d;
            throw a.AbstractC0097a.newUninitializedMessageException((e1) new u(bVar, f0Var, (s.g[]) Arrays.copyOf(gVarArr, gVarArr.length), this.f4347e));
        }

        @Override // c.b.d.e1.a
        public e1.a addRepeatedField(s.g gVar, Object obj) {
            j(gVar);
            f();
            this.f4345c.a(gVar, obj);
            return this;
        }

        /* renamed from: b */
        public u buildPartial() {
            this.f4345c.x();
            s.b bVar = this.f4344b;
            f0<s.g> f0Var = this.f4345c;
            s.g[] gVarArr = this.f4346d;
            return new u(bVar, f0Var, (s.g[]) Arrays.copyOf(gVarArr, gVarArr.length), this.f4347e);
        }

        public b c() {
            f0<s.g> f0Var = this.f4345c;
            if (f0Var.f3860b) {
                this.f4345c = new f0<>();
            } else {
                f0Var.f3859a.clear();
                f0Var.f3861c = false;
            }
            if (this.f4344b.p().g) {
                i();
            }
            this.f4347e = p2.f4026d;
            return this;
        }

        @Override // c.b.d.e1.a
        public /* bridge */ /* synthetic */ e1.a clearField(s.g gVar) {
            d(gVar);
            return this;
        }

        /* Return type fixed from 'c.b.d.a$a' to match base method */
        @Override // c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public b clearOneof(s.k kVar) {
            k(kVar);
            s.g gVar = this.f4346d[kVar.f4316a];
            if (gVar != null) {
                d(gVar);
            }
            return this;
        }

        public b d(s.g gVar) {
            j(gVar);
            f();
            s.k kVar = gVar.j;
            if (kVar != null) {
                int i = kVar.f4316a;
                s.g[] gVarArr = this.f4346d;
                if (gVarArr[i] == gVar) {
                    gVarArr[i] = null;
                }
            }
            this.f4345c.b(gVar);
            return this;
        }

        /* renamed from: e */
        public b clone() {
            b bVar = new b(this.f4344b);
            bVar.f4345c.y(this.f4345c);
            bVar.h(this.f4347e);
            s.g[] gVarArr = this.f4346d;
            System.arraycopy(gVarArr, 0, bVar.f4346d, 0, gVarArr.length);
            return bVar;
        }

        public final void f() {
            f0<s.g> f0Var = this.f4345c;
            if (f0Var.f3860b) {
                this.f4345c = f0Var.clone();
            }
        }

        /* renamed from: g */
        public b mergeFrom(e1 e1Var) {
            if (!(e1Var instanceof u)) {
                return (b) super.mergeFrom(e1Var);
            }
            u uVar = (u) e1Var;
            if (uVar.f4339b == this.f4344b) {
                f();
                this.f4345c.y(uVar.f4340c);
                h(uVar.f4342e);
                int i = 0;
                while (true) {
                    s.g[] gVarArr = this.f4346d;
                    if (i >= gVarArr.length) {
                        return this;
                    }
                    if (gVarArr[i] == null) {
                        gVarArr[i] = uVar.f4341d[i];
                    } else {
                        s.g[] gVarArr2 = uVar.f4341d;
                        if (!(gVarArr2[i] == null || gVarArr[i] == gVarArr2[i])) {
                            this.f4345c.b(gVarArr[i]);
                            this.f4346d[i] = uVar.f4341d[i];
                        }
                    }
                    i++;
                }
            } else {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
        }

        @Override // c.b.d.j1
        public Map<s.g, Object> getAllFields() {
            return this.f4345c.j();
        }

        @Override // c.b.d.j1, c.b.d.i1
        public e1 getDefaultInstanceForType() {
            return u.a(this.f4344b);
        }

        @Override // c.b.d.e1.a, c.b.d.j1
        public s.b getDescriptorForType() {
            return this.f4344b;
        }

        @Override // c.b.d.j1
        public Object getField(s.g gVar) {
            j(gVar);
            Object k = this.f4345c.k(gVar);
            if (k != null) {
                return k;
            }
            if (gVar.c()) {
                return Collections.emptyList();
            }
            return gVar.g.f4303b == s.g.a.MESSAGE ? u.a(gVar.n()) : gVar.k();
        }

        @Override // c.b.d.a.AbstractC0097a
        public e1.a getFieldBuilder(s.g gVar) {
            throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
        }

        @Override // c.b.d.a.AbstractC0097a
        public s.g getOneofFieldDescriptor(s.k kVar) {
            k(kVar);
            return this.f4346d[kVar.f4316a];
        }

        @Override // c.b.d.a.AbstractC0097a
        public e1.a getRepeatedFieldBuilder(s.g gVar, int i) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a dynamic message type.");
        }

        @Override // c.b.d.j1
        public p2 getUnknownFields() {
            return this.f4347e;
        }

        public b h(p2 p2Var) {
            p2.b c2 = p2.c(this.f4347e);
            c2.g(p2Var);
            this.f4347e = c2.build();
            return this;
        }

        @Override // c.b.d.j1
        public boolean hasField(s.g gVar) {
            j(gVar);
            return this.f4345c.r(gVar);
        }

        @Override // c.b.d.a.AbstractC0097a
        public boolean hasOneof(s.k kVar) {
            k(kVar);
            return this.f4346d[kVar.f4316a] != null;
        }

        public final void i() {
            Object obj;
            f0<s.g> f0Var;
            for (s.g gVar : this.f4344b.n()) {
                if (gVar.g.f4303b == s.g.a.MESSAGE) {
                    f0Var = this.f4345c;
                    obj = u.a(gVar.n());
                } else {
                    f0Var = this.f4345c;
                    obj = gVar.k();
                }
                f0Var.B(gVar, obj);
            }
        }

        @Override // c.b.d.i1
        public boolean isInitialized() {
            return u.b(this.f4344b, this.f4345c);
        }

        public final void j(s.g gVar) {
            if (gVar.h != this.f4344b) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        public final void k(s.k kVar) {
            if (kVar.f4320e != this.f4344b) {
                throw new IllegalArgumentException("OneofDescriptor does not match message type.");
            }
        }

        @Override // c.b.d.e1.a
        public e1.a newBuilderForField(s.g gVar) {
            j(gVar);
            if (gVar.g.f4303b == s.g.a.MESSAGE) {
                return new b(gVar.n());
            }
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        @Override // c.b.d.e1.a
        public e1.a setField(s.g gVar, Object obj) {
            j(gVar);
            f();
            if (gVar.g == s.g.b.ENUM) {
                if (gVar.c()) {
                    for (Object obj2 : (List) obj) {
                        m0.a(obj2);
                        if (!(obj2 instanceof s.f)) {
                            throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
                        }
                    }
                } else {
                    m0.a(obj);
                    if (!(obj instanceof s.f)) {
                        throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
                    }
                }
            }
            s.k kVar = gVar.j;
            if (kVar != null) {
                int i = kVar.f4316a;
                s.g gVar2 = this.f4346d[i];
                if (!(gVar2 == null || gVar2 == gVar)) {
                    this.f4345c.b(gVar2);
                }
                this.f4346d[i] = gVar;
            } else if (gVar.f4295e.n() == s.h.a.PROTO3 && !gVar.c() && gVar.g.f4303b != s.g.a.MESSAGE && obj.equals(gVar.k())) {
                this.f4345c.b(gVar);
                return this;
            }
            this.f4345c.B(gVar, obj);
            return this;
        }

        @Override // c.b.d.e1.a
        public e1.a setUnknownFields(p2 p2Var) {
            this.f4347e = p2Var;
            return this;
        }

        @Override // c.b.d.j1, c.b.d.i1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public h1 m342getDefaultInstanceForType() {
            return u.a(this.f4344b);
        }

        /* Return type fixed from 'c.b.d.e1$a' to match base method */
        @Override // c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        /* renamed from: clearOneof  reason: collision with other method in class */
        public b m341clearOneof(s.k kVar) {
            k(kVar);
            s.g gVar = this.f4346d[kVar.f4316a];
            if (gVar != null) {
                d(gVar);
            }
            return this;
        }
    }

    public u(s.b bVar, f0<s.g> f0Var, s.g[] gVarArr, p2 p2Var) {
        this.f4339b = bVar;
        this.f4340c = f0Var;
        this.f4341d = gVarArr;
        this.f4342e = p2Var;
    }

    public static u a(s.b bVar) {
        return new u(bVar, f0.f3858d, new s.g[bVar.f4264a.f()], p2.f4026d);
    }

    public static boolean b(s.b bVar, f0<s.g> f0Var) {
        for (s.g gVar : bVar.n()) {
            if (gVar.t() && !f0Var.r(gVar)) {
                return false;
            }
        }
        return f0Var.t();
    }

    /* renamed from: c */
    public b newBuilderForType() {
        return new b(this.f4339b);
    }

    public final void d(s.g gVar) {
        if (gVar.h != this.f4339b) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }

    @Override // c.b.d.j1
    public Map<s.g, Object> getAllFields() {
        return this.f4340c.j();
    }

    @Override // c.b.d.j1, c.b.d.i1
    public e1 getDefaultInstanceForType() {
        return a(this.f4339b);
    }

    @Override // c.b.d.j1
    public s.b getDescriptorForType() {
        return this.f4339b;
    }

    @Override // c.b.d.j1
    public Object getField(s.g gVar) {
        d(gVar);
        Object k = this.f4340c.k(gVar);
        if (k != null) {
            return k;
        }
        if (gVar.c()) {
            return Collections.emptyList();
        }
        return gVar.g.f4303b == s.g.a.MESSAGE ? a(gVar.n()) : gVar.k();
    }

    @Override // c.b.d.a
    public s.g getOneofFieldDescriptor(s.k kVar) {
        if (kVar.f4320e == this.f4339b) {
            return this.f4341d[kVar.f4316a];
        }
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
    }

    @Override // c.b.d.h1
    public v1<u> getParserForType() {
        return new a();
    }

    @Override // c.b.d.a, c.b.d.h1
    public int getSerializedSize() {
        int i;
        int i2;
        int i3 = this.f;
        if (i3 != -1) {
            return i3;
        }
        if (this.f4339b.p().f4179d) {
            i2 = this.f4340c.l();
            i = this.f4342e.a();
        } else {
            i2 = this.f4340c.p();
            i = this.f4342e.getSerializedSize();
        }
        int i4 = i + i2;
        this.f = i4;
        return i4;
    }

    @Override // c.b.d.j1
    public p2 getUnknownFields() {
        return this.f4342e;
    }

    @Override // c.b.d.j1
    public boolean hasField(s.g gVar) {
        d(gVar);
        return this.f4340c.r(gVar);
    }

    @Override // c.b.d.a
    public boolean hasOneof(s.k kVar) {
        if (kVar.f4320e == this.f4339b) {
            return this.f4341d[kVar.f4316a] != null;
        }
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
    }

    @Override // c.b.d.a, c.b.d.i1
    public boolean isInitialized() {
        return b(this.f4339b, this.f4340c);
    }

    @Override // c.b.d.e1, c.b.d.h1
    public e1.a toBuilder() {
        return newBuilderForType().mergeFrom(this);
    }

    @Override // c.b.d.a, c.b.d.h1
    public void writeTo(m mVar) {
        int i = 0;
        if (this.f4339b.p().f4179d) {
            f0<s.g> f0Var = this.f4340c;
            while (i < f0Var.f3859a.e()) {
                f0Var.G(f0Var.f3859a.d(i), mVar);
                i++;
            }
            for (Object obj : f0Var.f3859a.f()) {
                f0Var.G((Map.Entry) obj, mVar);
            }
            this.f4342e.e(mVar);
            return;
        }
        f0<s.g> f0Var2 = this.f4340c;
        while (i < f0Var2.f3859a.e()) {
            Map.Entry<T, Object> d2 = f0Var2.f3859a.d(i);
            f0.F(d2.getKey(), d2.getValue(), mVar);
            i++;
        }
        for (Map.Entry<T, Object> entry : f0Var2.f3859a.f()) {
            f0.F(entry.getKey(), entry.getValue(), mVar);
        }
        this.f4342e.writeTo(mVar);
    }

    @Override // c.b.d.j1, c.b.d.i1
    /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
    public h1 m339getDefaultInstanceForType() {
        return a(this.f4339b);
    }

    @Override // c.b.d.e1, c.b.d.h1
    /* renamed from: toBuilder  reason: collision with other method in class */
    public h1.a m340toBuilder() {
        return newBuilderForType().mergeFrom(this);
    }
}
