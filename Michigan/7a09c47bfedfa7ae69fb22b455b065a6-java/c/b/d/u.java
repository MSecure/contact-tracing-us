package c.b.d;

import c.b.d.a;
import c.b.d.f1;
import c.b.d.i1;
import c.b.d.q2;
import c.b.d.s;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class u extends a {

    /* renamed from: b  reason: collision with root package name */
    public final s.b f5868b;

    /* renamed from: c  reason: collision with root package name */
    public final f0<s.g> f5869c;

    /* renamed from: d  reason: collision with root package name */
    public final s.g[] f5870d;

    /* renamed from: e  reason: collision with root package name */
    public final q2 f5871e;

    /* renamed from: f  reason: collision with root package name */
    public int f5872f = -1;

    public class a extends c<u> {
        public a() {
        }

        @Override // c.b.d.w1
        public Object parsePartialFrom(k kVar, z zVar) {
            b bVar = new b(u.this.f5868b);
            try {
                bVar.mergeFrom(kVar, zVar);
                return bVar.buildPartial();
            } catch (o0 e2) {
                e2.f5447b = bVar.buildPartial();
                throw e2;
            } catch (IOException e3) {
                o0 o0Var = new o0(e3);
                o0Var.f5447b = bVar.buildPartial();
                throw o0Var;
            }
        }
    }

    public static final class b extends a.AbstractC0106a<b> {

        /* renamed from: b  reason: collision with root package name */
        public final s.b f5874b;

        /* renamed from: c  reason: collision with root package name */
        public f0<s.g> f5875c = new f0<>();

        /* renamed from: d  reason: collision with root package name */
        public final s.g[] f5876d;

        /* renamed from: e  reason: collision with root package name */
        public q2 f5877e = q2.f5482d;

        public b(s.b bVar) {
            this.f5874b = bVar;
            this.f5876d = new s.g[bVar.f5788a.f()];
            if (bVar.s().f5666g) {
                i();
            }
        }

        /* renamed from: a */
        public u build() {
            if (isInitialized()) {
                return buildPartial();
            }
            s.b bVar = this.f5874b;
            f0<s.g> f0Var = this.f5875c;
            s.g[] gVarArr = this.f5876d;
            throw a.AbstractC0106a.newUninitializedMessageException((f1) new u(bVar, f0Var, (s.g[]) Arrays.copyOf(gVarArr, gVarArr.length), this.f5877e));
        }

        @Override // c.b.d.f1.a
        public f1.a addRepeatedField(s.g gVar, Object obj) {
            j(gVar);
            f();
            this.f5875c.a(gVar, obj);
            return this;
        }

        /* renamed from: b */
        public u buildPartial() {
            this.f5875c.x();
            s.b bVar = this.f5874b;
            f0<s.g> f0Var = this.f5875c;
            s.g[] gVarArr = this.f5876d;
            return new u(bVar, f0Var, (s.g[]) Arrays.copyOf(gVarArr, gVarArr.length), this.f5877e);
        }

        public b c() {
            f0<s.g> f0Var = this.f5875c;
            if (f0Var.f5263b) {
                this.f5875c = new f0<>();
            } else {
                f0Var.f5262a.clear();
                f0Var.f5264c = false;
            }
            if (this.f5874b.s().f5666g) {
                i();
            }
            this.f5877e = q2.f5482d;
            return this;
        }

        @Override // c.b.d.f1.a
        public /* bridge */ /* synthetic */ f1.a clearField(s.g gVar) {
            d(gVar);
            return this;
        }

        /* Return type fixed from 'c.b.d.a$a' to match base method */
        @Override // c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public b clearOneof(s.k kVar) {
            k(kVar);
            s.g gVar = this.f5876d[kVar.f5851a];
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
                int i = kVar.f5851a;
                s.g[] gVarArr = this.f5876d;
                if (gVarArr[i] == gVar) {
                    gVarArr[i] = null;
                }
            }
            this.f5875c.b(gVar);
            return this;
        }

        /* renamed from: e */
        public b clone() {
            b bVar = new b(this.f5874b);
            bVar.f5875c.y(this.f5875c);
            bVar.h(this.f5877e);
            s.g[] gVarArr = this.f5876d;
            System.arraycopy(gVarArr, 0, bVar.f5876d, 0, gVarArr.length);
            return bVar;
        }

        public final void f() {
            f0<s.g> f0Var = this.f5875c;
            if (f0Var.f5263b) {
                this.f5875c = f0Var.clone();
            }
        }

        /* renamed from: g */
        public b mergeFrom(f1 f1Var) {
            if (!(f1Var instanceof u)) {
                return (b) super.mergeFrom(f1Var);
            }
            u uVar = (u) f1Var;
            if (uVar.f5868b == this.f5874b) {
                f();
                this.f5875c.y(uVar.f5869c);
                h(uVar.f5871e);
                int i = 0;
                while (true) {
                    s.g[] gVarArr = this.f5876d;
                    if (i >= gVarArr.length) {
                        return this;
                    }
                    if (gVarArr[i] == null) {
                        gVarArr[i] = uVar.f5870d[i];
                    } else {
                        s.g[] gVarArr2 = uVar.f5870d;
                        if (!(gVarArr2[i] == null || gVarArr[i] == gVarArr2[i])) {
                            this.f5875c.b(gVarArr[i]);
                            this.f5876d[i] = uVar.f5870d[i];
                        }
                    }
                    i++;
                }
            } else {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
        }

        @Override // c.b.d.k1
        public Map<s.g, Object> getAllFields() {
            return this.f5875c.j();
        }

        @Override // c.b.d.k1, c.b.d.j1
        public f1 getDefaultInstanceForType() {
            return u.a(this.f5874b);
        }

        @Override // c.b.d.k1, c.b.d.f1.a
        public s.b getDescriptorForType() {
            return this.f5874b;
        }

        @Override // c.b.d.k1
        public Object getField(s.g gVar) {
            j(gVar);
            Object k = this.f5875c.k(gVar);
            if (k != null) {
                return k;
            }
            if (gVar.e()) {
                return Collections.emptyList();
            }
            return gVar.f5823g.f5835b == s.g.a.MESSAGE ? u.a(gVar.p()) : gVar.m();
        }

        @Override // c.b.d.a.AbstractC0106a
        public f1.a getFieldBuilder(s.g gVar) {
            throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
        }

        @Override // c.b.d.a.AbstractC0106a
        public s.g getOneofFieldDescriptor(s.k kVar) {
            k(kVar);
            return this.f5876d[kVar.f5851a];
        }

        @Override // c.b.d.a.AbstractC0106a
        public f1.a getRepeatedFieldBuilder(s.g gVar, int i) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a dynamic message type.");
        }

        @Override // c.b.d.k1
        public q2 getUnknownFields() {
            return this.f5877e;
        }

        public b h(q2 q2Var) {
            q2.b c2 = q2.c(this.f5877e);
            c2.g(q2Var);
            this.f5877e = c2.build();
            return this;
        }

        @Override // c.b.d.k1
        public boolean hasField(s.g gVar) {
            j(gVar);
            return this.f5875c.r(gVar);
        }

        @Override // c.b.d.a.AbstractC0106a
        public boolean hasOneof(s.k kVar) {
            k(kVar);
            return this.f5876d[kVar.f5851a] != null;
        }

        public final void i() {
            Object obj;
            f0<s.g> f0Var;
            for (s.g gVar : this.f5874b.p()) {
                if (gVar.f5823g.f5835b == s.g.a.MESSAGE) {
                    f0Var = this.f5875c;
                    obj = u.a(gVar.p());
                } else {
                    f0Var = this.f5875c;
                    obj = gVar.m();
                }
                f0Var.B(gVar, obj);
            }
        }

        @Override // c.b.d.j1
        public boolean isInitialized() {
            return u.b(this.f5874b, this.f5875c);
        }

        public final void j(s.g gVar) {
            if (gVar.h != this.f5874b) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        public final void k(s.k kVar) {
            if (kVar.f5855e != this.f5874b) {
                throw new IllegalArgumentException("OneofDescriptor does not match message type.");
            }
        }

        @Override // c.b.d.f1.a
        public f1.a newBuilderForField(s.g gVar) {
            j(gVar);
            if (gVar.f5823g.f5835b == s.g.a.MESSAGE) {
                return new b(gVar.p());
            }
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        @Override // c.b.d.f1.a
        public f1.a setField(s.g gVar, Object obj) {
            j(gVar);
            f();
            if (gVar.f5823g == s.g.b.ENUM) {
                if (gVar.e()) {
                    for (Object obj2 : (List) obj) {
                        n0.a(obj2);
                        if (!(obj2 instanceof s.f)) {
                            throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
                        }
                    }
                } else {
                    n0.a(obj);
                    if (!(obj instanceof s.f)) {
                        throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
                    }
                }
            }
            s.k kVar = gVar.j;
            if (kVar != null) {
                int i = kVar.f5851a;
                s.g gVar2 = this.f5876d[i];
                if (!(gVar2 == null || gVar2 == gVar)) {
                    this.f5875c.b(gVar2);
                }
                this.f5876d[i] = gVar;
            } else if (gVar.f5821e.p() == s.h.a.PROTO3 && !gVar.e() && gVar.f5823g.f5835b != s.g.a.MESSAGE && obj.equals(gVar.m())) {
                this.f5875c.b(gVar);
                return this;
            }
            this.f5875c.B(gVar, obj);
            return this;
        }

        @Override // c.b.d.f1.a
        public f1.a setUnknownFields(q2 q2Var) {
            this.f5877e = q2Var;
            return this;
        }

        @Override // c.b.d.k1, c.b.d.j1
        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public i1 m342getDefaultInstanceForType() {
            return u.a(this.f5874b);
        }

        /* Return type fixed from 'c.b.d.f1$a' to match base method */
        @Override // c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        /* renamed from: clearOneof  reason: collision with other method in class */
        public b m341clearOneof(s.k kVar) {
            k(kVar);
            s.g gVar = this.f5876d[kVar.f5851a];
            if (gVar != null) {
                d(gVar);
            }
            return this;
        }
    }

    public u(s.b bVar, f0<s.g> f0Var, s.g[] gVarArr, q2 q2Var) {
        this.f5868b = bVar;
        this.f5869c = f0Var;
        this.f5870d = gVarArr;
        this.f5871e = q2Var;
    }

    public static u a(s.b bVar) {
        return new u(bVar, f0.f5261d, new s.g[bVar.f5788a.f()], q2.f5482d);
    }

    public static boolean b(s.b bVar, f0<s.g> f0Var) {
        for (s.g gVar : bVar.p()) {
            if (gVar.y() && !f0Var.r(gVar)) {
                return false;
            }
        }
        return f0Var.t();
    }

    /* renamed from: c */
    public b newBuilderForType() {
        return new b(this.f5868b);
    }

    public final void d(s.g gVar) {
        if (gVar.h != this.f5868b) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }

    @Override // c.b.d.k1
    public Map<s.g, Object> getAllFields() {
        return this.f5869c.j();
    }

    @Override // c.b.d.k1, c.b.d.j1
    public f1 getDefaultInstanceForType() {
        return a(this.f5868b);
    }

    @Override // c.b.d.k1
    public s.b getDescriptorForType() {
        return this.f5868b;
    }

    @Override // c.b.d.k1
    public Object getField(s.g gVar) {
        d(gVar);
        Object k = this.f5869c.k(gVar);
        if (k != null) {
            return k;
        }
        if (gVar.e()) {
            return Collections.emptyList();
        }
        return gVar.f5823g.f5835b == s.g.a.MESSAGE ? a(gVar.p()) : gVar.m();
    }

    @Override // c.b.d.a
    public s.g getOneofFieldDescriptor(s.k kVar) {
        if (kVar.f5855e == this.f5868b) {
            return this.f5870d[kVar.f5851a];
        }
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
    }

    @Override // c.b.d.i1
    public w1<u> getParserForType() {
        return new a();
    }

    @Override // c.b.d.a, c.b.d.i1
    public int getSerializedSize() {
        int i;
        int i2;
        int i3 = this.f5872f;
        if (i3 != -1) {
            return i3;
        }
        if (this.f5868b.s().f5663d) {
            i2 = this.f5869c.l();
            i = this.f5871e.a();
        } else {
            i2 = this.f5869c.p();
            i = this.f5871e.getSerializedSize();
        }
        int i4 = i + i2;
        this.f5872f = i4;
        return i4;
    }

    @Override // c.b.d.k1
    public q2 getUnknownFields() {
        return this.f5871e;
    }

    @Override // c.b.d.k1
    public boolean hasField(s.g gVar) {
        d(gVar);
        return this.f5869c.r(gVar);
    }

    @Override // c.b.d.a
    public boolean hasOneof(s.k kVar) {
        if (kVar.f5855e == this.f5868b) {
            return this.f5870d[kVar.f5851a] != null;
        }
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
    }

    @Override // c.b.d.a, c.b.d.j1
    public boolean isInitialized() {
        return b(this.f5868b, this.f5869c);
    }

    @Override // c.b.d.f1, c.b.d.i1
    public f1.a toBuilder() {
        return newBuilderForType().mergeFrom(this);
    }

    @Override // c.b.d.a, c.b.d.i1
    public void writeTo(m mVar) {
        int i = 0;
        if (this.f5868b.s().f5663d) {
            f0<s.g> f0Var = this.f5869c;
            while (i < f0Var.f5262a.e()) {
                f0Var.G(f0Var.f5262a.d(i), mVar);
                i++;
            }
            for (Object obj : f0Var.f5262a.f()) {
                f0Var.G((Map.Entry) obj, mVar);
            }
            this.f5871e.e(mVar);
            return;
        }
        f0<s.g> f0Var2 = this.f5869c;
        while (i < f0Var2.f5262a.e()) {
            Map.Entry<T, Object> d2 = f0Var2.f5262a.d(i);
            f0.F(d2.getKey(), d2.getValue(), mVar);
            i++;
        }
        for (Map.Entry<T, Object> entry : f0Var2.f5262a.f()) {
            f0.F(entry.getKey(), entry.getValue(), mVar);
        }
        this.f5871e.writeTo(mVar);
    }

    @Override // c.b.d.k1, c.b.d.j1
    /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
    public i1 m339getDefaultInstanceForType() {
        return a(this.f5868b);
    }

    @Override // c.b.d.f1, c.b.d.i1
    /* renamed from: toBuilder  reason: collision with other method in class */
    public i1.a m340toBuilder() {
        return newBuilderForType().mergeFrom(this);
    }
}
