package c.b.d;

import c.b.d.a;
import c.b.d.e1;
import c.b.d.f0;
import c.b.d.h1;
import c.b.d.j0;
import c.b.d.m0;
import c.b.d.p0;
import c.b.d.p2;
import c.b.d.s;
import c.b.d.u;
import c.b.d.w2;
import c.b.d.y0;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class k0 extends a implements Serializable {
    public static boolean alwaysUseFieldBuilders = false;
    public static final long serialVersionUID = 1;
    public p2 unknownFields;

    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.b f3939a;

        public a(k0 k0Var, a.b bVar) {
            this.f3939a = bVar;
        }

        @Override // c.b.d.a.b
        public void a() {
            this.f3939a.a();
        }
    }

    public static abstract class b<BuilderType extends b<BuilderType>> extends a.AbstractC0097a<BuilderType> {
        public c builderParent;
        public boolean isClean;
        public b<BuilderType>.a meAsParent;
        public p2 unknownFields;

        public class a implements c {
            public a(a aVar) {
            }

            @Override // c.b.d.a.b
            public void a() {
                b.this.onChanged();
            }
        }

        public b() {
            this(null);
        }

        public b(c cVar) {
            this.unknownFields = p2.f4026d;
            this.builderParent = cVar;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private Map<s.g, Object> getAllFieldsMutable() {
            List list;
            TreeMap treeMap = new TreeMap();
            List<s.g> n = internalGetFieldAccessorTable().f3947a.n();
            int i = 0;
            while (i < n.size()) {
                s.g gVar = n.get(i);
                s.k kVar = gVar.j;
                if (kVar != null) {
                    i += kVar.f - 1;
                    if (!hasOneof(kVar)) {
                        i++;
                    } else {
                        gVar = getOneofFieldDescriptor(kVar);
                    }
                } else {
                    if (gVar.c()) {
                        List list2 = (List) getField(gVar);
                        boolean isEmpty = list2.isEmpty();
                        list = list2;
                        if (isEmpty) {
                        }
                        treeMap.put(gVar, list == 1 ? 1 : 0);
                    } else if (!hasField(gVar)) {
                    }
                    i++;
                }
                list = getField(gVar);
                treeMap.put(gVar, list == 1 ? 1 : 0);
                i++;
            }
            return treeMap;
        }

        private BuilderType setUnknownFieldsInternal(p2 p2Var) {
            this.unknownFields = p2Var;
            onChanged();
            return this;
        }

        @Override // c.b.d.e1.a
        public BuilderType addRepeatedField(s.g gVar, Object obj) {
            f.b(internalGetFieldAccessorTable(), gVar).c(this, obj);
            return this;
        }

        @Override // c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public BuilderType clear() {
            this.unknownFields = p2.f4026d;
            onChanged();
            return this;
        }

        @Override // c.b.d.e1.a
        public BuilderType clearField(s.g gVar) {
            f.b(internalGetFieldAccessorTable(), gVar).m(this);
            return this;
        }

        @Override // c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public BuilderType clearOneof(s.k kVar) {
            k0.invokeOrDie(f.a(internalGetFieldAccessorTable(), kVar).f3957d, this, new Object[0]);
            return this;
        }

        @Override // c.b.d.b.a, c.b.d.b.a, c.b.d.b.a, java.lang.Object, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public BuilderType clone() {
            BuilderType buildertype = (BuilderType) ((b) getDefaultInstanceForType().newBuilderForType());
            buildertype.mergeFrom(buildPartial());
            return buildertype;
        }

        @Override // c.b.d.a.AbstractC0097a
        public void dispose() {
            this.builderParent = null;
        }

        @Override // c.b.d.j1
        public Map<s.g, Object> getAllFields() {
            return Collections.unmodifiableMap(getAllFieldsMutable());
        }

        @Override // c.b.d.e1.a, c.b.d.j1
        public s.b getDescriptorForType() {
            return internalGetFieldAccessorTable().f3947a;
        }

        @Override // c.b.d.j1
        public Object getField(s.g gVar) {
            Object j = f.b(internalGetFieldAccessorTable(), gVar).j(this);
            return gVar.c() ? Collections.unmodifiableList((List) j) : j;
        }

        @Override // c.b.d.a.AbstractC0097a
        public e1.a getFieldBuilder(s.g gVar) {
            return f.b(internalGetFieldAccessorTable(), gVar).d(this);
        }

        @Override // c.b.d.a.AbstractC0097a
        public s.g getOneofFieldDescriptor(s.k kVar) {
            f.c a2 = f.a(internalGetFieldAccessorTable(), kVar);
            int a3 = ((m0.c) k0.invokeOrDie(a2.f3956c, this, new Object[0])).a();
            if (a3 > 0) {
                return a2.f3954a.l(a3);
            }
            return null;
        }

        public c getParentForChildren() {
            if (this.meAsParent == null) {
                this.meAsParent = new a(null);
            }
            return this.meAsParent;
        }

        public Object getRepeatedField(s.g gVar, int i) {
            return f.b(internalGetFieldAccessorTable(), gVar).p(this, i);
        }

        @Override // c.b.d.a.AbstractC0097a
        public e1.a getRepeatedFieldBuilder(s.g gVar, int i) {
            return f.b(internalGetFieldAccessorTable(), gVar).l(this, i);
        }

        public int getRepeatedFieldCount(s.g gVar) {
            return f.b(internalGetFieldAccessorTable(), gVar).h(this);
        }

        @Override // c.b.d.j1
        public final p2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // c.b.d.j1
        public boolean hasField(s.g gVar) {
            return f.b(internalGetFieldAccessorTable(), gVar).n(this);
        }

        @Override // c.b.d.a.AbstractC0097a
        public boolean hasOneof(s.k kVar) {
            return ((m0.c) k0.invokeOrDie(f.a(internalGetFieldAccessorTable(), kVar).f3956c, this, new Object[0])).a() != 0;
        }

        public abstract f internalGetFieldAccessorTable();

        public y0 internalGetMapField(int i) {
            StringBuilder g = c.a.a.a.a.g("No map fields found in ");
            g.append(getClass().getName());
            throw new RuntimeException(g.toString());
        }

        public y0 internalGetMutableMapField(int i) {
            StringBuilder g = c.a.a.a.a.g("No map fields found in ");
            g.append(getClass().getName());
            throw new RuntimeException(g.toString());
        }

        public boolean isClean() {
            return this.isClean;
        }

        @Override // c.b.d.i1
        public boolean isInitialized() {
            for (s.g gVar : getDescriptorForType().n()) {
                if (gVar.t() && !hasField(gVar)) {
                    return false;
                }
                if (gVar.g.f4303b == s.g.a.MESSAGE) {
                    if (gVar.c()) {
                        for (e1 e1Var : (List) getField(gVar)) {
                            if (!e1Var.isInitialized()) {
                                return false;
                            }
                        }
                        continue;
                    } else if (hasField(gVar) && !((e1) getField(gVar)).isInitialized()) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override // c.b.d.a.AbstractC0097a
        public void markClean() {
            this.isClean = true;
        }

        @Override // c.b.d.a.AbstractC0097a, c.b.d.a.AbstractC0097a
        public BuilderType mergeUnknownFields(p2 p2Var) {
            p2.b c2 = p2.c(this.unknownFields);
            c2.g(p2Var);
            return setUnknownFields(c2.build());
        }

        @Override // c.b.d.e1.a
        public e1.a newBuilderForField(s.g gVar) {
            return f.b(internalGetFieldAccessorTable(), gVar).g();
        }

        public void onBuilt() {
            if (this.builderParent != null) {
                markClean();
            }
        }

        public final void onChanged() {
            c cVar;
            if (this.isClean && (cVar = this.builderParent) != null) {
                cVar.a();
                this.isClean = false;
            }
        }

        @Override // c.b.d.e1.a
        public BuilderType setField(s.g gVar, Object obj) {
            f.b(internalGetFieldAccessorTable(), gVar).i(this, obj);
            return this;
        }

        public BuilderType setRepeatedField(s.g gVar, int i, Object obj) {
            f.b(internalGetFieldAccessorTable(), gVar).o(this, i, obj);
            return this;
        }

        @Override // c.b.d.e1.a
        public BuilderType setUnknownFields(p2 p2Var) {
            return setUnknownFieldsInternal(p2Var);
        }

        public BuilderType setUnknownFieldsProto3(p2 p2Var) {
            return setUnknownFieldsInternal(p2Var);
        }
    }

    public interface c extends a.b {
    }

    public static abstract class d<MessageType extends e, BuilderType extends d<MessageType, BuilderType>> extends b<BuilderType> implements Object<MessageType> {

        /* renamed from: b  reason: collision with root package name */
        public f0.b<s.g> f3941b;

        public d() {
        }

        public d(c cVar) {
            super(cVar);
        }

        /* renamed from: a */
        public BuilderType addRepeatedField(s.g gVar, Object obj) {
            List list;
            if (!gVar.p()) {
                return (BuilderType) ((d) super.addRepeatedField(gVar, obj));
            }
            i(gVar);
            d();
            f0.b<s.g> bVar = this.f3941b;
            bVar.a();
            if (gVar.c()) {
                bVar.f3865d = bVar.f3865d || (obj instanceof h1.a);
                f0.b.j(gVar.e(), obj);
                Object f = f0.b.f(gVar, bVar.b(gVar));
                if (f == null) {
                    list = new ArrayList();
                    bVar.f3862a.put(gVar, list);
                } else {
                    list = (List) f;
                }
                list.add(obj);
                onChanged();
                return this;
            }
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }

        /* renamed from: b */
        public BuilderType clear() {
            this.f3941b = null;
            return (BuilderType) ((d) super.clear());
        }

        /* renamed from: c */
        public BuilderType clearField(s.g gVar) {
            if (!gVar.p()) {
                return (BuilderType) ((d) super.clearField(gVar));
            }
            i(gVar);
            d();
            f0.b<s.g> bVar = this.f3941b;
            bVar.a();
            bVar.f3862a.remove(gVar);
            if (bVar.f3862a.isEmpty()) {
                bVar.f3863b = false;
            }
            onChanged();
            return this;
        }

        public final void d() {
            if (this.f3941b == null) {
                this.f3941b = f0.A();
            }
        }

        public boolean e() {
            f0.b<s.g> bVar = this.f3941b;
            if (bVar == null) {
                return true;
            }
            int i = 0;
            while (true) {
                if (i >= bVar.f3862a.e()) {
                    for (Map.Entry<T, Object> entry : bVar.f3862a.f()) {
                        if (!f0.u(entry)) {
                        }
                    }
                    return true;
                } else if (!f0.u(bVar.f3862a.d(i))) {
                    break;
                } else {
                    i++;
                }
            }
            return false;
        }

        public final void f(e eVar) {
            if (eVar.f3942b != null) {
                d();
                f0.b<s.g> bVar = this.f3941b;
                f0<s.g> f0Var = eVar.f3942b;
                bVar.a();
                for (int i = 0; i < f0Var.f3859a.e(); i++) {
                    bVar.d(f0Var.f3859a.d(i));
                }
                for (Object obj : f0Var.f3859a.f()) {
                    bVar.d((Map.Entry) obj);
                }
                onChanged();
            }
        }

        /* renamed from: g */
        public BuilderType setField(s.g gVar, Object obj) {
            if (!gVar.p()) {
                return (BuilderType) ((d) super.setField(gVar, obj));
            }
            i(gVar);
            d();
            this.f3941b.h(gVar, obj);
            onChanged();
            return this;
        }

        @Override // c.b.d.k0.b, c.b.d.j1
        public Map<s.g, Object> getAllFields() {
            g2<T, Object> g2Var;
            Map allFieldsMutable = getAllFieldsMutable();
            f0.b<s.g> bVar = this.f3941b;
            if (bVar != null) {
                if (bVar.f3863b) {
                    g2Var = f0.d(bVar.f3862a, false);
                    if (bVar.f3862a.f3884e) {
                        g2Var.h();
                    } else {
                        f0.b.g(g2Var);
                    }
                } else {
                    g2<T, Object> g2Var2 = bVar.f3862a;
                    if (!g2Var2.f3884e) {
                        g2Var2 = (g2<T, Object>) Collections.unmodifiableMap(g2Var2);
                    }
                    g2Var = g2Var2;
                }
                allFieldsMutable.putAll(g2Var);
            }
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // c.b.d.k0.b, c.b.d.j1
        public Object getField(s.g gVar) {
            if (!gVar.p()) {
                return super.getField(gVar);
            }
            i(gVar);
            f0.b<s.g> bVar = this.f3941b;
            Object f = bVar == null ? null : f0.b.f(gVar, bVar.b(gVar));
            if (f == null) {
                return gVar.g.f4303b == s.g.a.MESSAGE ? u.a(gVar.n()) : gVar.k();
            }
            return f;
        }

        @Override // c.b.d.k0.b, c.b.d.a.AbstractC0097a
        public e1.a getFieldBuilder(s.g gVar) {
            if (!gVar.p()) {
                return super.getFieldBuilder(gVar);
            }
            i(gVar);
            if (gVar.g.f4303b == s.g.a.MESSAGE) {
                d();
                Object b2 = this.f3941b.b(gVar);
                if (b2 == null) {
                    u.b bVar = new u.b(gVar.n());
                    this.f3941b.h(gVar, bVar);
                    onChanged();
                    return bVar;
                } else if (b2 instanceof e1.a) {
                    return (e1.a) b2;
                } else {
                    if (b2 instanceof e1) {
                        e1.a builder = ((e1) b2).toBuilder();
                        this.f3941b.h(gVar, builder);
                        onChanged();
                        return builder;
                    }
                    throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
                }
            } else {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }
        }

        @Override // c.b.d.k0.b
        public Object getRepeatedField(s.g gVar, int i) {
            if (!gVar.p()) {
                return super.getRepeatedField(gVar, i);
            }
            i(gVar);
            f0.b<s.g> bVar = this.f3941b;
            if (bVar != null) {
                if (bVar.f3865d) {
                    bVar.a();
                }
                return f0.b.e(bVar.c(gVar, i));
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // c.b.d.k0.b, c.b.d.a.AbstractC0097a
        public e1.a getRepeatedFieldBuilder(s.g gVar, int i) {
            if (!gVar.p()) {
                return super.getRepeatedFieldBuilder(gVar, i);
            }
            i(gVar);
            d();
            if (gVar.g.f4303b == s.g.a.MESSAGE) {
                Object c2 = this.f3941b.c(gVar, i);
                if (c2 instanceof e1.a) {
                    return (e1.a) c2;
                }
                if (c2 instanceof e1) {
                    e1.a builder = ((e1) c2).toBuilder();
                    this.f3941b.i(gVar, i, builder);
                    onChanged();
                    return builder;
                }
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        }

        @Override // c.b.d.k0.b
        public int getRepeatedFieldCount(s.g gVar) {
            if (!gVar.p()) {
                return super.getRepeatedFieldCount(gVar);
            }
            i(gVar);
            f0.b<s.g> bVar = this.f3941b;
            if (bVar == null) {
                return 0;
            }
            if (bVar == null) {
                throw null;
            } else if (gVar.c()) {
                Object f = f0.b.f(gVar, bVar.b(gVar));
                if (f == null) {
                    return 0;
                }
                return ((List) f).size();
            } else {
                throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
            }
        }

        /* renamed from: h */
        public BuilderType setRepeatedField(s.g gVar, int i, Object obj) {
            if (!gVar.p()) {
                return (BuilderType) ((d) super.setRepeatedField(gVar, i, obj));
            }
            i(gVar);
            d();
            this.f3941b.i(gVar, i, obj);
            onChanged();
            return this;
        }

        @Override // c.b.d.k0.b, c.b.d.j1
        public boolean hasField(s.g gVar) {
            if (!gVar.p()) {
                return super.hasField(gVar);
            }
            i(gVar);
            f0.b<s.g> bVar = this.f3941b;
            if (bVar == null) {
                return false;
            }
            if (bVar == null) {
                throw null;
            } else if (!gVar.c()) {
                return bVar.f3862a.get(gVar) != null;
            } else {
                throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
            }
        }

        public final void i(s.g gVar) {
            if (gVar.h != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        @Override // c.b.d.k0.b, c.b.d.i1
        public boolean isInitialized() {
            return super.isInitialized() && e();
        }

        @Override // c.b.d.k0.b, c.b.d.e1.a
        public e1.a newBuilderForField(s.g gVar) {
            if (gVar.p()) {
                return new u.b(gVar.n());
            }
            return super.newBuilderForField(gVar);
        }
    }

    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final s.b f3947a;

        /* renamed from: b  reason: collision with root package name */
        public final a[] f3948b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f3949c;

        /* renamed from: d  reason: collision with root package name */
        public final c[] f3950d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f3951e = false;

        public interface a {
            int a(k0 k0Var);

            Object b(k0 k0Var);

            void c(b bVar, Object obj);

            e1.a d(b bVar);

            Object e(k0 k0Var);

            boolean f(k0 k0Var);

            e1.a g();

            int h(b bVar);

            void i(b bVar, Object obj);

            Object j(b bVar);

            Object k(k0 k0Var, int i);

            e1.a l(b bVar, int i);

            void m(b bVar);

            boolean n(b bVar);

            void o(b bVar, int i, Object obj);

            Object p(b bVar, int i);
        }

        public static class b implements a {

            /* renamed from: a  reason: collision with root package name */
            public final s.g f3952a;

            /* renamed from: b  reason: collision with root package name */
            public final e1 f3953b;

            /* JADX WARN: Incorrect args count in method signature: (Lc/b/d/s$g;Ljava/lang/String;Ljava/lang/Class<+Lc/b/d/k0;>;Ljava/lang/Class<+Lc/b/d/k0$b;>;)V */
            public b(s.g gVar, Class cls) {
                this.f3952a = gVar;
                this.f3953b = ((y0.b) r((k0) k0.invokeOrDie(k0.getMethodOrDie(cls, "getDefaultInstance", new Class[0]), null, new Object[0])).f4397e).f4398a;
            }

            @Override // c.b.d.k0.f.a
            public int a(k0 k0Var) {
                return k0Var.internalGetMapField(this.f3952a.f4293c.f4132d).d().size();
            }

            @Override // c.b.d.k0.f.a
            public Object b(k0 k0Var) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < k0Var.internalGetMapField(this.f3952a.f4293c.f4132d).d().size(); i++) {
                    arrayList.add(k0Var.internalGetMapField(this.f3952a.f4293c.f4132d).d().get(i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // c.b.d.k0.f.a
            public void c(b bVar, Object obj) {
                bVar.internalGetMutableMapField(this.f3952a.f4293c.f4132d).f().add(q((e1) obj));
            }

            @Override // c.b.d.k0.f.a
            public e1.a d(b bVar) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // c.b.d.k0.f.a
            public Object e(k0 k0Var) {
                return b(k0Var);
            }

            @Override // c.b.d.k0.f.a
            public boolean f(k0 k0Var) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // c.b.d.k0.f.a
            public e1.a g() {
                return this.f3953b.newBuilderForType();
            }

            @Override // c.b.d.k0.f.a
            public int h(b bVar) {
                return bVar.internalGetMapField(this.f3952a.f4293c.f4132d).d().size();
            }

            @Override // c.b.d.k0.f.a
            public void i(b bVar, Object obj) {
                bVar.internalGetMutableMapField(this.f3952a.f4293c.f4132d).f().clear();
                for (Object obj2 : (List) obj) {
                    c(bVar, obj2);
                }
            }

            @Override // c.b.d.k0.f.a
            public Object j(b bVar) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < bVar.internalGetMapField(this.f3952a.f4293c.f4132d).d().size(); i++) {
                    arrayList.add(bVar.internalGetMapField(this.f3952a.f4293c.f4132d).d().get(i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // c.b.d.k0.f.a
            public Object k(k0 k0Var, int i) {
                return k0Var.internalGetMapField(this.f3952a.f4293c.f4132d).d().get(i);
            }

            @Override // c.b.d.k0.f.a
            public e1.a l(b bVar, int i) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // c.b.d.k0.f.a
            public void m(b bVar) {
                bVar.internalGetMutableMapField(this.f3952a.f4293c.f4132d).f().clear();
            }

            @Override // c.b.d.k0.f.a
            public boolean n(b bVar) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // c.b.d.k0.f.a
            public void o(b bVar, int i, Object obj) {
                bVar.internalGetMutableMapField(this.f3952a.f4293c.f4132d).f().set(i, q((e1) obj));
            }

            @Override // c.b.d.k0.f.a
            public Object p(b bVar, int i) {
                return bVar.internalGetMapField(this.f3952a.f4293c.f4132d).d().get(i);
            }

            public final e1 q(e1 e1Var) {
                if (e1Var == null) {
                    return null;
                }
                return this.f3953b.getClass().isInstance(e1Var) ? e1Var : this.f3953b.toBuilder().mergeFrom(e1Var).build();
            }

            public final y0<?, ?> r(k0 k0Var) {
                return k0Var.internalGetMapField(this.f3952a.f4293c.f4132d);
            }
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public final s.b f3954a;

            /* renamed from: b  reason: collision with root package name */
            public final Method f3955b;

            /* renamed from: c  reason: collision with root package name */
            public final Method f3956c;

            /* renamed from: d  reason: collision with root package name */
            public final Method f3957d;

            public c(s.b bVar, String str, Class<? extends k0> cls, Class<? extends b> cls2) {
                this.f3954a = bVar;
                this.f3955b = k0.getMethodOrDie(cls, c.a.a.a.a.p("get", str, "Case"), new Class[0]);
                this.f3956c = k0.getMethodOrDie(cls2, c.a.a.a.a.p("get", str, "Case"), new Class[0]);
                this.f3957d = k0.getMethodOrDie(cls2, c.a.a.a.a.o("clear", str), new Class[0]);
            }
        }

        public static final class d extends e {

            /* renamed from: c  reason: collision with root package name */
            public s.e f3958c;

            /* renamed from: d  reason: collision with root package name */
            public final Method f3959d = k0.getMethodOrDie(this.f3961a, "valueOf", new Class[]{s.f.class});

            /* renamed from: e  reason: collision with root package name */
            public final Method f3960e = k0.getMethodOrDie(this.f3961a, "getValueDescriptor", new Class[0]);
            public boolean f;
            public Method g;
            public Method h;
            public Method i;
            public Method j;

            public d(s.g gVar, String str, Class<? extends k0> cls, Class<? extends b> cls2) {
                super(gVar, str, cls, cls2);
                this.f3958c = gVar.l();
                boolean p = gVar.f4295e.p();
                this.f = p;
                if (p) {
                    this.g = k0.getMethodOrDie(cls, c.a.a.a.a.p("get", str, "Value"), new Class[]{Integer.TYPE});
                    this.h = k0.getMethodOrDie(cls2, c.a.a.a.a.p("get", str, "Value"), new Class[]{Integer.TYPE});
                    String p2 = c.a.a.a.a.p("set", str, "Value");
                    Class cls3 = Integer.TYPE;
                    this.i = k0.getMethodOrDie(cls2, p2, new Class[]{cls3, cls3});
                    this.j = k0.getMethodOrDie(cls2, c.a.a.a.a.p("add", str, "Value"), new Class[]{Integer.TYPE});
                }
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.e
            public Object b(k0 k0Var) {
                ArrayList arrayList = new ArrayList();
                int a2 = a(k0Var);
                for (int i2 = 0; i2 < a2; i2++) {
                    arrayList.add(k(k0Var, i2));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.e
            public void c(b bVar, Object obj) {
                if (this.f) {
                    k0.invokeOrDie(this.j, bVar, new Object[]{Integer.valueOf(((s.f) obj).f4288b.f4112d)});
                    return;
                }
                super.c(bVar, k0.invokeOrDie(this.f3959d, null, new Object[]{obj}));
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.e
            public Object j(b bVar) {
                ArrayList arrayList = new ArrayList();
                int h2 = h(bVar);
                for (int i2 = 0; i2 < h2; i2++) {
                    arrayList.add(p(bVar, i2));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.e
            public Object k(k0 k0Var, int i2) {
                if (!this.f) {
                    return k0.invokeOrDie(this.f3960e, super.k(k0Var, i2), new Object[0]);
                }
                return this.f3958c.k(((Integer) k0.invokeOrDie(this.g, k0Var, new Object[]{Integer.valueOf(i2)})).intValue());
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.e
            public void o(b bVar, int i2, Object obj) {
                if (this.f) {
                    k0.invokeOrDie(this.i, bVar, new Object[]{Integer.valueOf(i2), Integer.valueOf(((s.f) obj).f4288b.f4112d)});
                    return;
                }
                super.o(bVar, i2, k0.invokeOrDie(this.f3959d, null, new Object[]{obj}));
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.e
            public Object p(b bVar, int i2) {
                if (!this.f) {
                    return k0.invokeOrDie(this.f3960e, super.p(bVar, i2), new Object[0]);
                }
                return this.f3958c.k(((Integer) k0.invokeOrDie(this.h, bVar, new Object[]{Integer.valueOf(i2)})).intValue());
            }
        }

        public static class e implements a {

            /* renamed from: a  reason: collision with root package name */
            public final Class f3961a;

            /* renamed from: b  reason: collision with root package name */
            public final a f3962b;

            public interface a {
            }

            public static final class b implements a {

                /* renamed from: a  reason: collision with root package name */
                public final Method f3963a;

                /* renamed from: b  reason: collision with root package name */
                public final Method f3964b;

                /* renamed from: c  reason: collision with root package name */
                public final Method f3965c;

                /* renamed from: d  reason: collision with root package name */
                public final Method f3966d;

                /* renamed from: e  reason: collision with root package name */
                public final Method f3967e;
                public final Method f;
                public final Method g;
                public final Method h;
                public final Method i;

                /* JADX WARN: Incorrect args count in method signature: (Lc/b/d/s$g;Ljava/lang/String;Ljava/lang/Class<+Lc/b/d/k0;>;Ljava/lang/Class<+Lc/b/d/k0$b;>;)V */
                public b(String str, Class cls, Class cls2) {
                    this.f3963a = k0.getMethodOrDie(cls, c.a.a.a.a.p("get", str, "List"), new Class[0]);
                    this.f3964b = k0.getMethodOrDie(cls2, c.a.a.a.a.p("get", str, "List"), new Class[0]);
                    this.f3965c = k0.getMethodOrDie(cls, c.a.a.a.a.o("get", str), new Class[]{Integer.TYPE});
                    this.f3966d = k0.getMethodOrDie(cls2, c.a.a.a.a.o("get", str), new Class[]{Integer.TYPE});
                    Class<?> returnType = this.f3965c.getReturnType();
                    this.f3967e = k0.getMethodOrDie(cls2, c.a.a.a.a.o("set", str), new Class[]{Integer.TYPE, returnType});
                    this.f = k0.getMethodOrDie(cls2, c.a.a.a.a.o("add", str), new Class[]{returnType});
                    this.g = k0.getMethodOrDie(cls, c.a.a.a.a.p("get", str, "Count"), new Class[0]);
                    this.h = k0.getMethodOrDie(cls2, c.a.a.a.a.p("get", str, "Count"), new Class[0]);
                    this.i = k0.getMethodOrDie(cls2, c.a.a.a.a.o("clear", str), new Class[0]);
                }
            }

            public e(s.g gVar, String str, Class<? extends k0> cls, Class<? extends b> cls2) {
                b bVar = new b(str, cls, cls2);
                this.f3961a = bVar.f3965c.getReturnType();
                this.f3962b = bVar;
            }

            @Override // c.b.d.k0.f.a
            public int a(k0 k0Var) {
                return ((Integer) k0.invokeOrDie(((b) this.f3962b).g, k0Var, new Object[0])).intValue();
            }

            @Override // c.b.d.k0.f.a
            public Object b(k0 k0Var) {
                return k0.invokeOrDie(((b) this.f3962b).f3963a, k0Var, new Object[0]);
            }

            @Override // c.b.d.k0.f.a
            public void c(b bVar, Object obj) {
                k0.invokeOrDie(((b) this.f3962b).f, bVar, new Object[]{obj});
            }

            @Override // c.b.d.k0.f.a
            public e1.a d(b bVar) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // c.b.d.k0.f.a
            public Object e(k0 k0Var) {
                return b(k0Var);
            }

            @Override // c.b.d.k0.f.a
            public boolean f(k0 k0Var) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // c.b.d.k0.f.a
            public e1.a g() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // c.b.d.k0.f.a
            public int h(b bVar) {
                return ((Integer) k0.invokeOrDie(((b) this.f3962b).h, bVar, new Object[0])).intValue();
            }

            @Override // c.b.d.k0.f.a
            public void i(b bVar, Object obj) {
                k0.invokeOrDie(((b) this.f3962b).i, bVar, new Object[0]);
                for (Object obj2 : (List) obj) {
                    c(bVar, obj2);
                }
            }

            @Override // c.b.d.k0.f.a
            public Object j(b bVar) {
                return k0.invokeOrDie(((b) this.f3962b).f3964b, bVar, new Object[0]);
            }

            @Override // c.b.d.k0.f.a
            public Object k(k0 k0Var, int i) {
                return k0.invokeOrDie(((b) this.f3962b).f3965c, k0Var, new Object[]{Integer.valueOf(i)});
            }

            @Override // c.b.d.k0.f.a
            public e1.a l(b bVar, int i) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // c.b.d.k0.f.a
            public void m(b bVar) {
                k0.invokeOrDie(((b) this.f3962b).i, bVar, new Object[0]);
            }

            @Override // c.b.d.k0.f.a
            public boolean n(b bVar) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // c.b.d.k0.f.a
            public void o(b bVar, int i, Object obj) {
                k0.invokeOrDie(((b) this.f3962b).f3967e, bVar, new Object[]{Integer.valueOf(i), obj});
            }

            @Override // c.b.d.k0.f.a
            public Object p(b bVar, int i) {
                return k0.invokeOrDie(((b) this.f3962b).f3966d, bVar, new Object[]{Integer.valueOf(i)});
            }
        }

        /* renamed from: c.b.d.k0$f$f  reason: collision with other inner class name */
        public static final class C0100f extends e {

            /* renamed from: c  reason: collision with root package name */
            public final Method f3968c = k0.getMethodOrDie(this.f3961a, "newBuilder", new Class[0]);

            /* renamed from: d  reason: collision with root package name */
            public final Method f3969d;

            public C0100f(s.g gVar, String str, Class<? extends k0> cls, Class<? extends b> cls2) {
                super(gVar, str, cls, cls2);
                this.f3969d = k0.getMethodOrDie(cls2, c.a.a.a.a.p("get", str, "Builder"), new Class[]{Integer.TYPE});
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.e
            public void c(b bVar, Object obj) {
                super.c(bVar, q(obj));
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.e
            public e1.a g() {
                return (e1.a) k0.invokeOrDie(this.f3968c, null, new Object[0]);
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.e
            public e1.a l(b bVar, int i) {
                return (e1.a) k0.invokeOrDie(this.f3969d, bVar, new Object[]{Integer.valueOf(i)});
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.e
            public void o(b bVar, int i, Object obj) {
                super.o(bVar, i, q(obj));
            }

            public final Object q(Object obj) {
                return this.f3961a.isInstance(obj) ? obj : ((e1.a) k0.invokeOrDie(this.f3968c, null, new Object[0])).mergeFrom((e1) obj).build();
            }
        }

        public static final class g extends h {
            public s.e f;
            public Method g = k0.getMethodOrDie(this.f3970a, "valueOf", new Class[]{s.f.class});
            public Method h = k0.getMethodOrDie(this.f3970a, "getValueDescriptor", new Class[0]);
            public boolean i;
            public Method j;
            public Method k;
            public Method l;

            public g(s.g gVar, String str, Class<? extends k0> cls, Class<? extends b> cls2, String str2) {
                super(gVar, str, cls, cls2, str2);
                this.f = gVar.l();
                boolean p = gVar.f4295e.p();
                this.i = p;
                if (p) {
                    this.j = k0.getMethodOrDie(cls, c.a.a.a.a.p("get", str, "Value"), new Class[0]);
                    this.k = k0.getMethodOrDie(cls2, c.a.a.a.a.p("get", str, "Value"), new Class[0]);
                    this.l = k0.getMethodOrDie(cls2, c.a.a.a.a.p("set", str, "Value"), new Class[]{Integer.TYPE});
                }
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.h
            public Object b(k0 k0Var) {
                if (!this.i) {
                    return k0.invokeOrDie(this.h, super.b(k0Var), new Object[0]);
                }
                return this.f.k(((Integer) k0.invokeOrDie(this.j, k0Var, new Object[0])).intValue());
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.h
            public void i(b bVar, Object obj) {
                if (this.i) {
                    k0.invokeOrDie(this.l, bVar, new Object[]{Integer.valueOf(((s.f) obj).f4288b.f4112d)});
                    return;
                }
                super.i(bVar, k0.invokeOrDie(this.g, null, new Object[]{obj}));
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.h
            public Object j(b bVar) {
                if (!this.i) {
                    return k0.invokeOrDie(this.h, super.j(bVar), new Object[0]);
                }
                return this.f.k(((Integer) k0.invokeOrDie(this.k, bVar, new Object[0])).intValue());
            }
        }

        public static class h implements a {

            /* renamed from: a  reason: collision with root package name */
            public final Class<?> f3970a;

            /* renamed from: b  reason: collision with root package name */
            public final s.g f3971b;

            /* renamed from: c  reason: collision with root package name */
            public final boolean f3972c;

            /* renamed from: d  reason: collision with root package name */
            public final boolean f3973d;

            /* renamed from: e  reason: collision with root package name */
            public final a f3974e;

            public interface a {
            }

            public static final class b implements a {

                /* renamed from: a  reason: collision with root package name */
                public final Method f3975a;

                /* renamed from: b  reason: collision with root package name */
                public final Method f3976b;

                /* renamed from: c  reason: collision with root package name */
                public final Method f3977c;

                /* renamed from: d  reason: collision with root package name */
                public final Method f3978d;

                /* renamed from: e  reason: collision with root package name */
                public final Method f3979e;
                public final Method f;
                public final Method g;
                public final Method h;

                /* JADX WARN: Incorrect args count in method signature: (Lc/b/d/s$g;Ljava/lang/String;Ljava/lang/Class<+Lc/b/d/k0;>;Ljava/lang/Class<+Lc/b/d/k0$b;>;Ljava/lang/String;ZZ)V */
                public b(String str, Class cls, Class cls2, String str2, boolean z, boolean z2) {
                    this.f3975a = k0.getMethodOrDie(cls, c.a.a.a.a.o("get", str), new Class[0]);
                    this.f3976b = k0.getMethodOrDie(cls2, c.a.a.a.a.o("get", str), new Class[0]);
                    this.f3977c = k0.getMethodOrDie(cls2, c.a.a.a.a.o("set", str), new Class[]{this.f3975a.getReturnType()});
                    Method method = null;
                    this.f3978d = z2 ? k0.getMethodOrDie(cls, c.a.a.a.a.o("has", str), new Class[0]) : null;
                    this.f3979e = z2 ? k0.getMethodOrDie(cls2, c.a.a.a.a.o("has", str), new Class[0]) : null;
                    this.f = k0.getMethodOrDie(cls2, c.a.a.a.a.o("clear", str), new Class[0]);
                    this.g = z ? k0.getMethodOrDie(cls, c.a.a.a.a.p("get", str2, "Case"), new Class[0]) : null;
                    this.h = z ? k0.getMethodOrDie(cls2, c.a.a.a.a.p("get", str2, "Case"), new Class[0]) : method;
                }
            }

            public h(s.g gVar, String str, Class<? extends k0> cls, Class<? extends b> cls2, String str2) {
                this.f3972c = gVar.j != null;
                boolean z = (gVar.f4295e.n() == s.h.a.PROTO2) || (!this.f3972c && gVar.g.f4303b == s.g.a.MESSAGE);
                this.f3973d = z;
                b bVar = new b(str, cls, cls2, str2, this.f3972c, z);
                this.f3971b = gVar;
                this.f3970a = bVar.f3975a.getReturnType();
                this.f3974e = bVar;
            }

            @Override // c.b.d.k0.f.a
            public int a(k0 k0Var) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // c.b.d.k0.f.a
            public Object b(k0 k0Var) {
                return k0.invokeOrDie(((b) this.f3974e).f3975a, k0Var, new Object[0]);
            }

            @Override // c.b.d.k0.f.a
            public void c(b bVar, Object obj) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // c.b.d.k0.f.a
            public e1.a d(b bVar) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // c.b.d.k0.f.a
            public Object e(k0 k0Var) {
                return b(k0Var);
            }

            @Override // c.b.d.k0.f.a
            public boolean f(k0 k0Var) {
                if (this.f3973d) {
                    return ((Boolean) k0.invokeOrDie(((b) this.f3974e).f3978d, k0Var, new Object[0])).booleanValue();
                }
                if (this.f3972c) {
                    return ((m0.c) k0.invokeOrDie(((b) this.f3974e).g, k0Var, new Object[0])).a() == this.f3971b.f4293c.f4132d;
                }
                return !b(k0Var).equals(this.f3971b.k());
            }

            @Override // c.b.d.k0.f.a
            public e1.a g() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // c.b.d.k0.f.a
            public int h(b bVar) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // c.b.d.k0.f.a
            public void i(b bVar, Object obj) {
                k0.invokeOrDie(((b) this.f3974e).f3977c, bVar, new Object[]{obj});
            }

            @Override // c.b.d.k0.f.a
            public Object j(b bVar) {
                return k0.invokeOrDie(((b) this.f3974e).f3976b, bVar, new Object[0]);
            }

            @Override // c.b.d.k0.f.a
            public Object k(k0 k0Var, int i) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // c.b.d.k0.f.a
            public e1.a l(b bVar, int i) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // c.b.d.k0.f.a
            public void m(b bVar) {
                k0.invokeOrDie(((b) this.f3974e).f, bVar, new Object[0]);
            }

            @Override // c.b.d.k0.f.a
            public boolean n(b bVar) {
                if (this.f3973d) {
                    return ((Boolean) k0.invokeOrDie(((b) this.f3974e).f3979e, bVar, new Object[0])).booleanValue();
                }
                if (this.f3972c) {
                    return ((m0.c) k0.invokeOrDie(((b) this.f3974e).h, bVar, new Object[0])).a() == this.f3971b.f4293c.f4132d;
                }
                return !j(bVar).equals(this.f3971b.k());
            }

            @Override // c.b.d.k0.f.a
            public void o(b bVar, int i, Object obj) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }

            @Override // c.b.d.k0.f.a
            public Object p(b bVar, int i) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }
        }

        public static final class i extends h {
            public final Method f = k0.getMethodOrDie(this.f3970a, "newBuilder", new Class[0]);
            public final Method g;

            public i(s.g gVar, String str, Class<? extends k0> cls, Class<? extends b> cls2, String str2) {
                super(gVar, str, cls, cls2, str2);
                this.g = k0.getMethodOrDie(cls2, c.a.a.a.a.p("get", str, "Builder"), new Class[0]);
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.h
            public e1.a d(b bVar) {
                return (e1.a) k0.invokeOrDie(this.g, bVar, new Object[0]);
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.h
            public e1.a g() {
                return (e1.a) k0.invokeOrDie(this.f, null, new Object[0]);
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.h
            public void i(b bVar, Object obj) {
                if (!this.f3970a.isInstance(obj)) {
                    obj = ((e1.a) k0.invokeOrDie(this.f, null, new Object[0])).mergeFrom((e1) obj).buildPartial();
                }
                super.i(bVar, obj);
            }
        }

        public static final class j extends h {
            public final Method f;
            public final Method g;

            public j(s.g gVar, String str, Class<? extends k0> cls, Class<? extends b> cls2, String str2) {
                super(gVar, str, cls, cls2, str2);
                this.f = k0.getMethodOrDie(cls, c.a.a.a.a.p("get", str, "Bytes"), new Class[0]);
                k0.getMethodOrDie(cls2, c.a.a.a.a.p("get", str, "Bytes"), new Class[0]);
                this.g = k0.getMethodOrDie(cls2, c.a.a.a.a.p("set", str, "Bytes"), new Class[]{j.class});
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.h
            public Object e(k0 k0Var) {
                return k0.invokeOrDie(this.f, k0Var, new Object[0]);
            }

            @Override // c.b.d.k0.f.a, c.b.d.k0.f.h
            public void i(b bVar, Object obj) {
                if (obj instanceof j) {
                    k0.invokeOrDie(this.g, bVar, new Object[]{obj});
                    return;
                }
                super.i(bVar, obj);
            }
        }

        public f(s.b bVar, String[] strArr) {
            this.f3947a = bVar;
            this.f3949c = strArr;
            this.f3948b = new a[bVar.n().size()];
            this.f3950d = new c[Collections.unmodifiableList(Arrays.asList(bVar.h)).size()];
        }

        public static c a(f fVar, s.k kVar) {
            if (fVar == null) {
                throw null;
            } else if (kVar.f4320e == fVar.f3947a) {
                return fVar.f3950d[kVar.f4316a];
            } else {
                throw new IllegalArgumentException("OneofDescriptor does not match message type.");
            }
        }

        public static a b(f fVar, s.g gVar) {
            if (fVar == null) {
                throw null;
            } else if (gVar.h != fVar.f3947a) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            } else if (!gVar.p()) {
                return fVar.f3948b[gVar.f4292b];
            } else {
                throw new IllegalArgumentException("This type does not have extensions.");
            }
        }

        public f c(Class<? extends k0> cls, Class<? extends b> cls2) {
            if (this.f3951e) {
                return this;
            }
            synchronized (this) {
                if (this.f3951e) {
                    return this;
                }
                int length = this.f3948b.length;
                int i2 = 0;
                while (true) {
                    String str = null;
                    if (i2 >= length) {
                        break;
                    }
                    s.g gVar = this.f3947a.n().get(i2);
                    if (gVar.j != null) {
                        str = this.f3949c[gVar.j.f4316a + length];
                    }
                    if (gVar.c()) {
                        if (gVar.g.f4303b == s.g.a.MESSAGE) {
                            if (gVar.q()) {
                                a[] aVarArr = this.f3948b;
                                String str2 = this.f3949c[i2];
                                aVarArr[i2] = new b(gVar, cls);
                            } else {
                                this.f3948b[i2] = new C0100f(gVar, this.f3949c[i2], cls, cls2);
                            }
                        } else if (gVar.g.f4303b == s.g.a.ENUM) {
                            this.f3948b[i2] = new d(gVar, this.f3949c[i2], cls, cls2);
                        } else {
                            this.f3948b[i2] = new e(gVar, this.f3949c[i2], cls, cls2);
                        }
                    } else if (gVar.g.f4303b == s.g.a.MESSAGE) {
                        this.f3948b[i2] = new i(gVar, this.f3949c[i2], cls, cls2, str);
                    } else if (gVar.g.f4303b == s.g.a.ENUM) {
                        this.f3948b[i2] = new g(gVar, this.f3949c[i2], cls, cls2, str);
                    } else {
                        s.g.a aVar = gVar.g.f4303b;
                        s.g.a aVar2 = s.g.a.STRING;
                        if (aVar == s.g.a.STRING) {
                            this.f3948b[i2] = new j(gVar, this.f3949c[i2], cls, cls2, str);
                        } else {
                            this.f3948b[i2] = new h(gVar, this.f3949c[i2], cls, cls2, str);
                        }
                    }
                    i2++;
                }
                int length2 = this.f3950d.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    this.f3950d[i3] = new c(this.f3947a, this.f3949c[i3 + length], cls, cls2);
                }
                this.f3951e = true;
                this.f3949c = null;
                return this;
            }
        }
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public static final g f3980a = new g();
    }

    public k0() {
        this.unknownFields = p2.f4026d;
    }

    public k0(b<?> bVar) {
        this.unknownFields = bVar.getUnknownFields();
    }

    public static boolean canUseUnsafe() {
        return u2.h && u2.g;
    }

    public static <MessageType extends e<MessageType>, T> v<MessageType, T> checkNotLite(w<MessageType, T> wVar) {
        if (wVar != null) {
            throw new IllegalArgumentException("Expected non-lite extension.");
        }
        throw null;
    }

    public static int computeStringSize(int i, Object obj) {
        return obj instanceof String ? m.L(i, (String) obj) : m.f(i, (j) obj);
    }

    public static int computeStringSizeNoTag(Object obj) {
        return obj instanceof String ? m.M((String) obj) : m.g((j) obj);
    }

    public static m0.a emptyBooleanList() {
        return g.f3870e;
    }

    public static m0.b emptyDoubleList() {
        return t.f4325e;
    }

    public static m0.e emptyFloatList() {
        return h0.f3895e;
    }

    public static m0.f emptyIntList() {
        return l0.f3987e;
    }

    public static m0.g emptyLongList() {
        return u0.f4348e;
    }

    public static void enableAlwaysUseFieldBuildersForTesting() {
        setAlwaysUseFieldBuildersForTesting(true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Map<s.g, Object> getAllFieldsMutable(boolean z) {
        List list;
        TreeMap treeMap = new TreeMap();
        List<s.g> n = internalGetFieldAccessorTable().f3947a.n();
        int i = 0;
        while (i < n.size()) {
            s.g gVar = n.get(i);
            s.k kVar = gVar.j;
            if (kVar != null) {
                i += kVar.f - 1;
                if (!hasOneof(kVar)) {
                    i++;
                } else {
                    gVar = getOneofFieldDescriptor(kVar);
                    list = (z || gVar.g.f4303b != s.g.a.STRING) ? getField(gVar) : getFieldRaw(gVar);
                }
            } else {
                if (gVar.c()) {
                    List list2 = (List) getField(gVar);
                    boolean isEmpty = list2.isEmpty();
                    list = list2;
                    if (isEmpty) {
                    }
                } else {
                    if (!hasField(gVar)) {
                    }
                    if (z) {
                    }
                }
                i++;
            }
            treeMap.put(gVar, list == 1 ? 1 : 0);
            i++;
        }
        return treeMap;
    }

    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            StringBuilder g2 = c.a.a.a.a.g("Generated message class \"");
            g2.append(cls.getName());
            g2.append("\" missing method \"");
            g2.append(str);
            g2.append("\".");
            throw new RuntimeException(g2.toString(), e2);
        }
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static <V> void maybeSerializeBooleanEntryTo(m mVar, Map<Boolean, V> map, w0<Boolean, V> w0Var, int i, boolean z) {
        if (!map.containsKey(Boolean.valueOf(z))) {
            return;
        }
        if (w0Var != null) {
            throw null;
        }
        throw null;
    }

    public static m0.a mutableCopy(m0.a aVar) {
        int size = aVar.size();
        return ((g) aVar).g(size == 0 ? 10 : size * 2);
    }

    public static m0.b mutableCopy(m0.b bVar) {
        int size = bVar.size();
        return ((t) bVar).g(size == 0 ? 10 : size * 2);
    }

    public static m0.e mutableCopy(m0.e eVar) {
        int size = eVar.size();
        return ((h0) eVar).g(size == 0 ? 10 : size * 2);
    }

    public static m0.f mutableCopy(m0.f fVar) {
        int size = fVar.size();
        return ((l0) fVar).g(size == 0 ? 10 : size * 2);
    }

    public static m0.g mutableCopy(m0.g gVar) {
        int size = gVar.size();
        return ((u0) gVar).g(size == 0 ? 10 : size * 2);
    }

    public static m0.a newBooleanList() {
        return new g();
    }

    public static m0.b newDoubleList() {
        return new t();
    }

    public static m0.e newFloatList() {
        return new h0();
    }

    public static m0.f newIntList() {
        return new l0();
    }

    public static m0.g newLongList() {
        return new u0();
    }

    public static <M extends e1> M parseDelimitedWithIOException(v1<M> v1Var, InputStream inputStream) {
        try {
            return v1Var.parseDelimitedFrom(inputStream);
        } catch (n0 e2) {
            throw e2.j();
        }
    }

    public static <M extends e1> M parseDelimitedWithIOException(v1<M> v1Var, InputStream inputStream, z zVar) {
        try {
            return v1Var.parseDelimitedFrom(inputStream, zVar);
        } catch (n0 e2) {
            throw e2.j();
        }
    }

    public static <M extends e1> M parseWithIOException(v1<M> v1Var, k kVar) {
        try {
            return v1Var.parseFrom(kVar);
        } catch (n0 e2) {
            throw e2.j();
        }
    }

    public static <M extends e1> M parseWithIOException(v1<M> v1Var, k kVar, z zVar) {
        try {
            return v1Var.parseFrom(kVar, zVar);
        } catch (n0 e2) {
            throw e2.j();
        }
    }

    public static <M extends e1> M parseWithIOException(v1<M> v1Var, InputStream inputStream) {
        try {
            return v1Var.parseFrom(inputStream);
        } catch (n0 e2) {
            throw e2.j();
        }
    }

    public static <M extends e1> M parseWithIOException(v1<M> v1Var, InputStream inputStream, z zVar) {
        try {
            return v1Var.parseFrom(inputStream, zVar);
        } catch (n0 e2) {
            throw e2.j();
        }
    }

    public static <V> void serializeBooleanMapTo(m mVar, y0<Boolean, V> y0Var, w0<Boolean, V> w0Var, int i) {
        Map<Boolean, V> e2 = y0Var.e();
        if (mVar != null) {
            serializeMapTo(mVar, e2, w0Var, i);
            return;
        }
        throw null;
    }

    public static <V> void serializeIntegerMapTo(m mVar, y0<Integer, V> y0Var, w0<Integer, V> w0Var, int i) {
        Map<Integer, V> e2 = y0Var.e();
        if (mVar != null) {
            serializeMapTo(mVar, e2, w0Var, i);
            return;
        }
        throw null;
    }

    public static <V> void serializeLongMapTo(m mVar, y0<Long, V> y0Var, w0<Long, V> w0Var, int i) {
        Map<Long, V> e2 = y0Var.e();
        if (mVar != null) {
            serializeMapTo(mVar, e2, w0Var, i);
            return;
        }
        throw null;
    }

    public static <K, V> void serializeMapTo(m mVar, Map<K, V> map, w0<K, V> w0Var, int i) {
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        if (it.hasNext()) {
            it.next();
            if (w0Var != null) {
                throw null;
            }
            throw null;
        }
    }

    public static <V> void serializeStringMapTo(m mVar, y0<String, V> y0Var, w0<String, V> w0Var, int i) {
        Map<String, V> e2 = y0Var.e();
        if (mVar != null) {
            serializeMapTo(mVar, e2, w0Var, i);
            return;
        }
        throw null;
    }

    public static void setAlwaysUseFieldBuildersForTesting(boolean z) {
        alwaysUseFieldBuilders = z;
    }

    public static void writeString(m mVar, int i, Object obj) {
        if (obj instanceof String) {
            mVar.p0(i, (String) obj);
        } else {
            mVar.a0(i, (j) obj);
        }
    }

    public static void writeStringNoTag(m mVar, Object obj) {
        if (obj instanceof String) {
            mVar.q0((String) obj);
        } else {
            mVar.b0((j) obj);
        }
    }

    @Override // c.b.d.j1
    public Map<s.g, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable(false));
    }

    public Map<s.g, Object> getAllFieldsRaw() {
        return Collections.unmodifiableMap(getAllFieldsMutable(true));
    }

    @Override // c.b.d.j1
    public s.b getDescriptorForType() {
        return internalGetFieldAccessorTable().f3947a;
    }

    @Override // c.b.d.j1
    public Object getField(s.g gVar) {
        return f.b(internalGetFieldAccessorTable(), gVar).b(this);
    }

    public Object getFieldRaw(s.g gVar) {
        return f.b(internalGetFieldAccessorTable(), gVar).e(this);
    }

    @Override // c.b.d.a
    public s.g getOneofFieldDescriptor(s.k kVar) {
        f.c a2 = f.a(internalGetFieldAccessorTable(), kVar);
        int a3 = ((m0.c) invokeOrDie(a2.f3955b, this, new Object[0])).a();
        if (a3 > 0) {
            return a2.f3954a.l(a3);
        }
        return null;
    }

    @Override // c.b.d.h1
    public v1<? extends k0> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public Object getRepeatedField(s.g gVar, int i) {
        return f.b(internalGetFieldAccessorTable(), gVar).k(this, i);
    }

    public int getRepeatedFieldCount(s.g gVar) {
        return f.b(internalGetFieldAccessorTable(), gVar).a(this);
    }

    @Override // c.b.d.a, c.b.d.h1
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i1 = c.b.a.a.c.n.c.i1(this, getAllFieldsRaw());
        this.memoizedSize = i1;
        return i1;
    }

    @Override // c.b.d.j1
    public p2 getUnknownFields() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // c.b.d.j1
    public boolean hasField(s.g gVar) {
        return f.b(internalGetFieldAccessorTable(), gVar).f(this);
    }

    @Override // c.b.d.a
    public boolean hasOneof(s.k kVar) {
        return ((m0.c) invokeOrDie(f.a(internalGetFieldAccessorTable(), kVar).f3955b, this, new Object[0])).a() != 0;
    }

    public abstract f internalGetFieldAccessorTable();

    public y0 internalGetMapField(int i) {
        StringBuilder g2 = c.a.a.a.a.g("No map fields found in ");
        g2.append(getClass().getName());
        throw new RuntimeException(g2.toString());
    }

    @Override // c.b.d.a, c.b.d.i1
    public boolean isInitialized() {
        for (s.g gVar : getDescriptorForType().n()) {
            if (gVar.t() && !hasField(gVar)) {
                return false;
            }
            if (gVar.g.f4303b == s.g.a.MESSAGE) {
                if (gVar.c()) {
                    for (e1 e1Var : (List) getField(gVar)) {
                        if (!e1Var.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (hasField(gVar) && !((e1) getField(gVar)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void makeExtensionsImmutable() {
    }

    public void mergeFromAndMakeImmutableInternal(k kVar, z zVar) {
        c2 b2 = y1.f4411c.b(this);
        try {
            l lVar = kVar.f3937d;
            if (lVar == null) {
                lVar = new l(kVar);
            }
            b2.h(this, lVar, zVar);
            b2.f(this);
        } catch (n0 e2) {
            e2.f4007b = this;
            throw e2;
        } catch (IOException e3) {
            n0 n0Var = new n0(e3);
            n0Var.f4007b = this;
            throw n0Var;
        }
    }

    @Override // c.b.d.a
    public e1.a newBuilderForType(a.b bVar) {
        return newBuilderForType((c) new a(this, bVar));
    }

    public abstract e1.a newBuilderForType(c cVar);

    public Object newInstance(g gVar) {
        throw new UnsupportedOperationException("This method must be overridden by the subclass.");
    }

    public boolean parseUnknownField(k kVar, p2.b bVar, z zVar, int i) {
        return kVar.f3938e ? kVar.J(i) : bVar.e(i, kVar);
    }

    public boolean parseUnknownFieldProto3(k kVar, p2.b bVar, z zVar, int i) {
        return parseUnknownField(kVar, bVar, zVar, i);
    }

    public Object writeReplace() {
        return new j0.f(this);
    }

    @Override // c.b.d.a, c.b.d.h1
    public void writeTo(m mVar) {
        c.b.a.a.c.n.c.A2(this, getAllFieldsRaw(), mVar, false);
    }

    public static abstract class e<MessageType extends e> extends k0 implements Object<MessageType> {

        /* renamed from: b  reason: collision with root package name */
        public final f0<s.g> f3942b;

        public class a {

            /* renamed from: a  reason: collision with root package name */
            public final Iterator<Map.Entry<s.g, Object>> f3943a;

            /* renamed from: b  reason: collision with root package name */
            public Map.Entry<s.g, Object> f3944b;

            /* renamed from: c  reason: collision with root package name */
            public final boolean f3945c;

            public a(boolean z, a aVar) {
                Iterator<Map.Entry<s.g, Object>> w = e.this.f3942b.w();
                this.f3943a = w;
                if (w.hasNext()) {
                    this.f3944b = this.f3943a.next();
                }
                this.f3945c = z;
            }

            public void a(int i, m mVar) {
                while (true) {
                    Map.Entry<s.g, Object> entry = this.f3944b;
                    if (entry != null && entry.getKey().f4293c.f4132d < i) {
                        s.g key = this.f3944b.getKey();
                        if (!this.f3945c || key.h() != w2.c.MESSAGE || key.c()) {
                            f0.F(key, this.f3944b.getValue(), mVar);
                        } else {
                            Map.Entry<s.g, Object> entry2 = this.f3944b;
                            if (entry2 instanceof p0.b) {
                                mVar.o0(key.f4293c.f4132d, ((p0.b) entry2).f4024b.getValue().b());
                            } else {
                                mVar.n0(key.f4293c.f4132d, (e1) entry2.getValue());
                            }
                        }
                        this.f3944b = this.f3943a.hasNext() ? this.f3943a.next() : null;
                    } else {
                        return;
                    }
                }
            }
        }

        public e() {
            this.f3942b = new f0<>();
        }

        public boolean a() {
            return this.f3942b.t();
        }

        public int b() {
            return this.f3942b.p();
        }

        public Map<s.g, Object> c() {
            return this.f3942b.j();
        }

        public e<MessageType>.a d() {
            return new a(false, null);
        }

        public final void e(s.g gVar) {
            if (gVar.h != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        @Override // c.b.d.k0, c.b.d.j1
        public Map<s.g, Object> getAllFields() {
            Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(c());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // c.b.d.k0
        public Map<s.g, Object> getAllFieldsRaw() {
            Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(c());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // c.b.d.k0, c.b.d.j1
        public Object getField(s.g gVar) {
            if (!gVar.p()) {
                return k0.super.getField(gVar);
            }
            e(gVar);
            Object k = this.f3942b.k(gVar);
            if (k != null) {
                return k;
            }
            if (gVar.c()) {
                return Collections.emptyList();
            }
            return gVar.g.f4303b == s.g.a.MESSAGE ? u.a(gVar.n()) : gVar.k();
        }

        @Override // c.b.d.k0
        public Object getRepeatedField(s.g gVar, int i) {
            if (!gVar.p()) {
                return k0.super.getRepeatedField(gVar, i);
            }
            e(gVar);
            return this.f3942b.n(gVar, i);
        }

        @Override // c.b.d.k0
        public int getRepeatedFieldCount(s.g gVar) {
            if (!gVar.p()) {
                return k0.super.getRepeatedFieldCount(gVar);
            }
            e(gVar);
            return this.f3942b.o(gVar);
        }

        @Override // c.b.d.k0, c.b.d.j1
        public boolean hasField(s.g gVar) {
            if (!gVar.p()) {
                return k0.super.hasField(gVar);
            }
            e(gVar);
            return this.f3942b.r(gVar);
        }

        @Override // c.b.d.k0, c.b.d.a, c.b.d.i1
        public boolean isInitialized() {
            return k0.super.isInitialized() && a();
        }

        @Override // c.b.d.k0
        public void makeExtensionsImmutable() {
            this.f3942b.x();
        }

        @Override // c.b.d.k0
        public boolean parseUnknownField(k kVar, p2.b bVar, z zVar, int i) {
            if (kVar.f3938e) {
                bVar = null;
            }
            return c.b.a.a.c.n.c.D1(kVar, bVar, zVar, getDescriptorForType(), new l1(this.f3942b), i);
        }

        @Override // c.b.d.k0
        public boolean parseUnknownFieldProto3(k kVar, p2.b bVar, z zVar, int i) {
            return parseUnknownField(kVar, bVar, zVar, i);
        }

        public e(d<MessageType, ?> dVar) {
            super(dVar);
            f0<s.g> f0Var;
            f0.b<s.g> bVar = dVar.f3941b;
            if (bVar == null) {
                f0Var = f0.f3858d;
            } else if (bVar.f3862a.isEmpty()) {
                f0Var = f0.f3858d;
            } else {
                bVar.f3864c = false;
                g2<T, Object> g2Var = bVar.f3862a;
                if (bVar.f3865d) {
                    g2Var = f0.d(g2Var, false);
                    f0.b.g(g2Var);
                }
                f0<s.g> f0Var2 = new f0<>(g2Var, null);
                f0Var2.f3861c = bVar.f3863b;
                f0Var = f0Var2;
            }
            this.f3942b = f0Var;
        }
    }
}
