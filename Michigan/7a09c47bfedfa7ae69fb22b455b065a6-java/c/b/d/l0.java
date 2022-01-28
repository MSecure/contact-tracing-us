package c.b.d;

import b.x.t;
import c.b.d.a;
import c.b.d.f0;
import c.b.d.f1;
import c.b.d.i1;
import c.b.d.k0;
import c.b.d.n0;
import c.b.d.q0;
import c.b.d.q2;
import c.b.d.s;
import c.b.d.u;
import c.b.d.x2;
import c.b.d.z0;
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

public abstract class l0 extends a implements Serializable {
    public static boolean alwaysUseFieldBuilders = false;
    public static final long serialVersionUID = 1;
    public q2 unknownFields;

    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.b f5367a;

        public a(l0 l0Var, a.b bVar) {
            this.f5367a = bVar;
        }

        @Override // c.b.d.a.b
        public void a() {
            this.f5367a.a();
        }
    }

    public static abstract class b<BuilderType extends b<BuilderType>> extends a.AbstractC0106a<BuilderType> {
        public c builderParent;
        public boolean isClean;
        public b<BuilderType>.a meAsParent;
        public q2 unknownFields;

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
            this.unknownFields = q2.f5482d;
            this.builderParent = cVar;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private Map<s.g, Object> getAllFieldsMutable() {
            List list;
            TreeMap treeMap = new TreeMap();
            List<s.g> p = internalGetFieldAccessorTable().f5375a.p();
            int i = 0;
            while (i < p.size()) {
                s.g gVar = p.get(i);
                s.k kVar = gVar.j;
                if (kVar != null) {
                    i += kVar.f5856f - 1;
                    if (!hasOneof(kVar)) {
                        i++;
                    } else {
                        gVar = getOneofFieldDescriptor(kVar);
                    }
                } else {
                    if (gVar.e()) {
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

        private BuilderType setUnknownFieldsInternal(q2 q2Var) {
            this.unknownFields = q2Var;
            onChanged();
            return this;
        }

        @Override // c.b.d.f1.a
        public BuilderType addRepeatedField(s.g gVar, Object obj) {
            f.b(internalGetFieldAccessorTable(), gVar).c(this, obj);
            return this;
        }

        @Override // c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public BuilderType clear() {
            this.unknownFields = q2.f5482d;
            onChanged();
            return this;
        }

        @Override // c.b.d.f1.a
        public BuilderType clearField(s.g gVar) {
            f.b(internalGetFieldAccessorTable(), gVar).m(this);
            return this;
        }

        @Override // c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public BuilderType clearOneof(s.k kVar) {
            l0.invokeOrDie(f.a(internalGetFieldAccessorTable(), kVar).f5385d, this, new Object[0]);
            return this;
        }

        @Override // c.b.d.b.a, c.b.d.b.a, c.b.d.b.a, java.lang.Object, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public BuilderType clone() {
            BuilderType buildertype = (BuilderType) ((b) getDefaultInstanceForType().newBuilderForType());
            buildertype.mergeFrom(buildPartial());
            return buildertype;
        }

        @Override // c.b.d.a.AbstractC0106a
        public void dispose() {
            this.builderParent = null;
        }

        @Override // c.b.d.k1
        public Map<s.g, Object> getAllFields() {
            return Collections.unmodifiableMap(getAllFieldsMutable());
        }

        @Override // c.b.d.k1, c.b.d.f1.a
        public s.b getDescriptorForType() {
            return internalGetFieldAccessorTable().f5375a;
        }

        @Override // c.b.d.k1
        public Object getField(s.g gVar) {
            Object j = f.b(internalGetFieldAccessorTable(), gVar).j(this);
            return gVar.e() ? Collections.unmodifiableList((List) j) : j;
        }

        @Override // c.b.d.a.AbstractC0106a
        public f1.a getFieldBuilder(s.g gVar) {
            return f.b(internalGetFieldAccessorTable(), gVar).d(this);
        }

        @Override // c.b.d.a.AbstractC0106a
        public s.g getOneofFieldDescriptor(s.k kVar) {
            f.c a2 = f.a(internalGetFieldAccessorTable(), kVar);
            int a3 = ((n0.c) l0.invokeOrDie(a2.f5384c, this, new Object[0])).a();
            if (a3 > 0) {
                return a2.f5382a.n(a3);
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

        @Override // c.b.d.a.AbstractC0106a
        public f1.a getRepeatedFieldBuilder(s.g gVar, int i) {
            return f.b(internalGetFieldAccessorTable(), gVar).l(this, i);
        }

        public int getRepeatedFieldCount(s.g gVar) {
            return f.b(internalGetFieldAccessorTable(), gVar).h(this);
        }

        @Override // c.b.d.k1
        public final q2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // c.b.d.k1
        public boolean hasField(s.g gVar) {
            return f.b(internalGetFieldAccessorTable(), gVar).n(this);
        }

        @Override // c.b.d.a.AbstractC0106a
        public boolean hasOneof(s.k kVar) {
            return ((n0.c) l0.invokeOrDie(f.a(internalGetFieldAccessorTable(), kVar).f5384c, this, new Object[0])).a() != 0;
        }

        public abstract f internalGetFieldAccessorTable();

        public z0 internalGetMapField(int i) {
            StringBuilder h = c.a.a.a.a.h("No map fields found in ");
            h.append(getClass().getName());
            throw new RuntimeException(h.toString());
        }

        public z0 internalGetMutableMapField(int i) {
            StringBuilder h = c.a.a.a.a.h("No map fields found in ");
            h.append(getClass().getName());
            throw new RuntimeException(h.toString());
        }

        public boolean isClean() {
            return this.isClean;
        }

        @Override // c.b.d.j1
        public boolean isInitialized() {
            for (s.g gVar : getDescriptorForType().p()) {
                if (gVar.y() && !hasField(gVar)) {
                    return false;
                }
                if (gVar.f5823g.f5835b == s.g.a.MESSAGE) {
                    if (gVar.e()) {
                        for (f1 f1Var : (List) getField(gVar)) {
                            if (!f1Var.isInitialized()) {
                                return false;
                            }
                        }
                        continue;
                    } else if (hasField(gVar) && !((f1) getField(gVar)).isInitialized()) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override // c.b.d.a.AbstractC0106a
        public void markClean() {
            this.isClean = true;
        }

        @Override // c.b.d.a.AbstractC0106a, c.b.d.a.AbstractC0106a
        public BuilderType mergeUnknownFields(q2 q2Var) {
            q2.b c2 = q2.c(this.unknownFields);
            c2.g(q2Var);
            return setUnknownFields(c2.build());
        }

        @Override // c.b.d.f1.a
        public f1.a newBuilderForField(s.g gVar) {
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

        @Override // c.b.d.f1.a
        public BuilderType setField(s.g gVar, Object obj) {
            f.b(internalGetFieldAccessorTable(), gVar).i(this, obj);
            return this;
        }

        public BuilderType setRepeatedField(s.g gVar, int i, Object obj) {
            f.b(internalGetFieldAccessorTable(), gVar).o(this, i, obj);
            return this;
        }

        @Override // c.b.d.f1.a
        public BuilderType setUnknownFields(q2 q2Var) {
            return setUnknownFieldsInternal(q2Var);
        }

        public BuilderType setUnknownFieldsProto3(q2 q2Var) {
            return setUnknownFieldsInternal(q2Var);
        }
    }

    public interface c extends a.b {
    }

    public static abstract class d<MessageType extends e, BuilderType extends d<MessageType, BuilderType>> extends b<BuilderType> implements Object<MessageType> {

        /* renamed from: b  reason: collision with root package name */
        public f0.b<s.g> f5369b;

        public d() {
        }

        public d(c cVar) {
            super(cVar);
        }

        /* renamed from: a */
        public BuilderType addRepeatedField(s.g gVar, Object obj) {
            List list;
            if (!gVar.s()) {
                return (BuilderType) ((d) super.addRepeatedField(gVar, obj));
            }
            i(gVar);
            d();
            f0.b<s.g> bVar = this.f5369b;
            bVar.a();
            if (gVar.e()) {
                bVar.f5268d = bVar.f5268d || (obj instanceof i1.a);
                f0.b.j(gVar.g(), obj);
                Object f2 = f0.b.f(gVar, bVar.b(gVar));
                if (f2 == null) {
                    list = new ArrayList();
                    bVar.f5265a.put(gVar, list);
                } else {
                    list = (List) f2;
                }
                list.add(obj);
                onChanged();
                return this;
            }
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }

        /* renamed from: b */
        public BuilderType clear() {
            this.f5369b = null;
            return (BuilderType) ((d) super.clear());
        }

        /* renamed from: c */
        public BuilderType clearField(s.g gVar) {
            if (!gVar.s()) {
                return (BuilderType) ((d) super.clearField(gVar));
            }
            i(gVar);
            d();
            f0.b<s.g> bVar = this.f5369b;
            bVar.a();
            bVar.f5265a.remove(gVar);
            if (bVar.f5265a.isEmpty()) {
                bVar.f5266b = false;
            }
            onChanged();
            return this;
        }

        public final void d() {
            if (this.f5369b == null) {
                this.f5369b = f0.A();
            }
        }

        public boolean e() {
            f0.b<s.g> bVar = this.f5369b;
            if (bVar == null) {
                return true;
            }
            int i = 0;
            while (true) {
                if (i >= bVar.f5265a.e()) {
                    for (Map.Entry<T, Object> entry : bVar.f5265a.f()) {
                        if (!f0.u(entry)) {
                        }
                    }
                    return true;
                } else if (!f0.u(bVar.f5265a.d(i))) {
                    break;
                } else {
                    i++;
                }
            }
            return false;
        }

        public final void f(e eVar) {
            if (eVar.f5370b != null) {
                d();
                f0.b<s.g> bVar = this.f5369b;
                f0<s.g> f0Var = eVar.f5370b;
                bVar.a();
                for (int i = 0; i < f0Var.f5262a.e(); i++) {
                    bVar.d(f0Var.f5262a.d(i));
                }
                for (Object obj : f0Var.f5262a.f()) {
                    bVar.d((Map.Entry) obj);
                }
                onChanged();
            }
        }

        /* renamed from: g */
        public BuilderType setField(s.g gVar, Object obj) {
            if (!gVar.s()) {
                return (BuilderType) ((d) super.setField(gVar, obj));
            }
            i(gVar);
            d();
            this.f5369b.h(gVar, obj);
            onChanged();
            return this;
        }

        @Override // c.b.d.l0.b, c.b.d.k1
        public Map<s.g, Object> getAllFields() {
            h2<T, Object> h2Var;
            Map allFieldsMutable = getAllFieldsMutable();
            f0.b<s.g> bVar = this.f5369b;
            if (bVar != null) {
                if (bVar.f5266b) {
                    h2Var = f0.d(bVar.f5265a, false);
                    if (bVar.f5265a.f5298e) {
                        h2Var.h();
                    } else {
                        f0.b.g(h2Var);
                    }
                } else {
                    h2<T, Object> h2Var2 = bVar.f5265a;
                    if (!h2Var2.f5298e) {
                        h2Var2 = (h2<T, Object>) Collections.unmodifiableMap(h2Var2);
                    }
                    h2Var = h2Var2;
                }
                allFieldsMutable.putAll(h2Var);
            }
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // c.b.d.l0.b, c.b.d.k1
        public Object getField(s.g gVar) {
            if (!gVar.s()) {
                return super.getField(gVar);
            }
            i(gVar);
            f0.b<s.g> bVar = this.f5369b;
            Object f2 = bVar == null ? null : f0.b.f(gVar, bVar.b(gVar));
            if (f2 == null) {
                return gVar.f5823g.f5835b == s.g.a.MESSAGE ? u.a(gVar.p()) : gVar.m();
            }
            return f2;
        }

        @Override // c.b.d.l0.b, c.b.d.a.AbstractC0106a
        public f1.a getFieldBuilder(s.g gVar) {
            if (!gVar.s()) {
                return super.getFieldBuilder(gVar);
            }
            i(gVar);
            if (gVar.f5823g.f5835b == s.g.a.MESSAGE) {
                d();
                Object b2 = this.f5369b.b(gVar);
                if (b2 == null) {
                    u.b bVar = new u.b(gVar.p());
                    this.f5369b.h(gVar, bVar);
                    onChanged();
                    return bVar;
                } else if (b2 instanceof f1.a) {
                    return (f1.a) b2;
                } else {
                    if (b2 instanceof f1) {
                        f1.a builder = ((f1) b2).toBuilder();
                        this.f5369b.h(gVar, builder);
                        onChanged();
                        return builder;
                    }
                    throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
                }
            } else {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }
        }

        @Override // c.b.d.l0.b
        public Object getRepeatedField(s.g gVar, int i) {
            if (!gVar.s()) {
                return super.getRepeatedField(gVar, i);
            }
            i(gVar);
            f0.b<s.g> bVar = this.f5369b;
            if (bVar != null) {
                if (bVar.f5268d) {
                    bVar.a();
                }
                return f0.b.e(bVar.c(gVar, i));
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // c.b.d.l0.b, c.b.d.a.AbstractC0106a
        public f1.a getRepeatedFieldBuilder(s.g gVar, int i) {
            if (!gVar.s()) {
                return super.getRepeatedFieldBuilder(gVar, i);
            }
            i(gVar);
            d();
            if (gVar.f5823g.f5835b == s.g.a.MESSAGE) {
                Object c2 = this.f5369b.c(gVar, i);
                if (c2 instanceof f1.a) {
                    return (f1.a) c2;
                }
                if (c2 instanceof f1) {
                    f1.a builder = ((f1) c2).toBuilder();
                    this.f5369b.i(gVar, i, builder);
                    onChanged();
                    return builder;
                }
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        }

        @Override // c.b.d.l0.b
        public int getRepeatedFieldCount(s.g gVar) {
            if (!gVar.s()) {
                return super.getRepeatedFieldCount(gVar);
            }
            i(gVar);
            f0.b<s.g> bVar = this.f5369b;
            if (bVar == null) {
                return 0;
            }
            if (bVar == null) {
                throw null;
            } else if (gVar.e()) {
                Object f2 = f0.b.f(gVar, bVar.b(gVar));
                if (f2 == null) {
                    return 0;
                }
                return ((List) f2).size();
            } else {
                throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
            }
        }

        /* renamed from: h */
        public BuilderType setRepeatedField(s.g gVar, int i, Object obj) {
            if (!gVar.s()) {
                return (BuilderType) ((d) super.setRepeatedField(gVar, i, obj));
            }
            i(gVar);
            d();
            this.f5369b.i(gVar, i, obj);
            onChanged();
            return this;
        }

        @Override // c.b.d.l0.b, c.b.d.k1
        public boolean hasField(s.g gVar) {
            if (!gVar.s()) {
                return super.hasField(gVar);
            }
            i(gVar);
            f0.b<s.g> bVar = this.f5369b;
            if (bVar == null) {
                return false;
            }
            if (bVar == null) {
                throw null;
            } else if (!gVar.e()) {
                return bVar.f5265a.get(gVar) != null;
            } else {
                throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
            }
        }

        public final void i(s.g gVar) {
            if (gVar.h != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        @Override // c.b.d.l0.b, c.b.d.j1
        public boolean isInitialized() {
            return super.isInitialized() && e();
        }

        @Override // c.b.d.l0.b, c.b.d.f1.a
        public f1.a newBuilderForField(s.g gVar) {
            if (gVar.s()) {
                return new u.b(gVar.p());
            }
            return super.newBuilderForField(gVar);
        }
    }

    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final s.b f5375a;

        /* renamed from: b  reason: collision with root package name */
        public final a[] f5376b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f5377c;

        /* renamed from: d  reason: collision with root package name */
        public final c[] f5378d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f5379e = false;

        public interface a {
            int a(l0 l0Var);

            Object b(l0 l0Var);

            void c(b bVar, Object obj);

            f1.a d(b bVar);

            Object e(l0 l0Var);

            boolean f(l0 l0Var);

            f1.a g();

            int h(b bVar);

            void i(b bVar, Object obj);

            Object j(b bVar);

            Object k(l0 l0Var, int i);

            f1.a l(b bVar, int i);

            void m(b bVar);

            boolean n(b bVar);

            void o(b bVar, int i, Object obj);

            Object p(b bVar, int i);
        }

        public static class b implements a {

            /* renamed from: a  reason: collision with root package name */
            public final s.g f5380a;

            /* renamed from: b  reason: collision with root package name */
            public final f1 f5381b;

            /* JADX WARN: Incorrect args count in method signature: (Lc/b/d/s$g;Ljava/lang/String;Ljava/lang/Class<+Lc/b/d/l0;>;Ljava/lang/Class<+Lc/b/d/l0$b;>;)V */
            public b(s.g gVar, Class cls) {
                this.f5380a = gVar;
                this.f5381b = ((z0.b) r((l0) l0.invokeOrDie(l0.getMethodOrDie(cls, "getDefaultInstance", new Class[0]), null, new Object[0])).f5950e).f5951a;
            }

            @Override // c.b.d.l0.f.a
            public int a(l0 l0Var) {
                return l0Var.internalGetMapField(this.f5380a.f5819c.f5594d).d().size();
            }

            @Override // c.b.d.l0.f.a
            public Object b(l0 l0Var) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < l0Var.internalGetMapField(this.f5380a.f5819c.f5594d).d().size(); i++) {
                    arrayList.add(l0Var.internalGetMapField(this.f5380a.f5819c.f5594d).d().get(i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // c.b.d.l0.f.a
            public void c(b bVar, Object obj) {
                bVar.internalGetMutableMapField(this.f5380a.f5819c.f5594d).f().add(q((f1) obj));
            }

            @Override // c.b.d.l0.f.a
            public f1.a d(b bVar) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // c.b.d.l0.f.a
            public Object e(l0 l0Var) {
                return b(l0Var);
            }

            @Override // c.b.d.l0.f.a
            public boolean f(l0 l0Var) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // c.b.d.l0.f.a
            public f1.a g() {
                return this.f5381b.newBuilderForType();
            }

            @Override // c.b.d.l0.f.a
            public int h(b bVar) {
                return bVar.internalGetMapField(this.f5380a.f5819c.f5594d).d().size();
            }

            @Override // c.b.d.l0.f.a
            public void i(b bVar, Object obj) {
                bVar.internalGetMutableMapField(this.f5380a.f5819c.f5594d).f().clear();
                for (Object obj2 : (List) obj) {
                    c(bVar, obj2);
                }
            }

            @Override // c.b.d.l0.f.a
            public Object j(b bVar) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < bVar.internalGetMapField(this.f5380a.f5819c.f5594d).d().size(); i++) {
                    arrayList.add(bVar.internalGetMapField(this.f5380a.f5819c.f5594d).d().get(i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // c.b.d.l0.f.a
            public Object k(l0 l0Var, int i) {
                return l0Var.internalGetMapField(this.f5380a.f5819c.f5594d).d().get(i);
            }

            @Override // c.b.d.l0.f.a
            public f1.a l(b bVar, int i) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // c.b.d.l0.f.a
            public void m(b bVar) {
                bVar.internalGetMutableMapField(this.f5380a.f5819c.f5594d).f().clear();
            }

            @Override // c.b.d.l0.f.a
            public boolean n(b bVar) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // c.b.d.l0.f.a
            public void o(b bVar, int i, Object obj) {
                bVar.internalGetMutableMapField(this.f5380a.f5819c.f5594d).f().set(i, q((f1) obj));
            }

            @Override // c.b.d.l0.f.a
            public Object p(b bVar, int i) {
                return bVar.internalGetMapField(this.f5380a.f5819c.f5594d).d().get(i);
            }

            public final f1 q(f1 f1Var) {
                if (f1Var == null) {
                    return null;
                }
                return this.f5381b.getClass().isInstance(f1Var) ? f1Var : this.f5381b.toBuilder().mergeFrom(f1Var).build();
            }

            public final z0<?, ?> r(l0 l0Var) {
                return l0Var.internalGetMapField(this.f5380a.f5819c.f5594d);
            }
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public final s.b f5382a;

            /* renamed from: b  reason: collision with root package name */
            public final Method f5383b;

            /* renamed from: c  reason: collision with root package name */
            public final Method f5384c;

            /* renamed from: d  reason: collision with root package name */
            public final Method f5385d;

            public c(s.b bVar, String str, Class<? extends l0> cls, Class<? extends b> cls2) {
                this.f5382a = bVar;
                this.f5383b = l0.getMethodOrDie(cls, c.a.a.a.a.c("get", str, "Case"), new Class[0]);
                this.f5384c = l0.getMethodOrDie(cls2, c.a.a.a.a.c("get", str, "Case"), new Class[0]);
                this.f5385d = l0.getMethodOrDie(cls2, c.a.a.a.a.q("clear", str), new Class[0]);
            }
        }

        public static final class d extends e {

            /* renamed from: c  reason: collision with root package name */
            public s.e f5386c;

            /* renamed from: d  reason: collision with root package name */
            public final Method f5387d = l0.getMethodOrDie(this.f5391a, "valueOf", new Class[]{s.f.class});

            /* renamed from: e  reason: collision with root package name */
            public final Method f5388e = l0.getMethodOrDie(this.f5391a, "getValueDescriptor", new Class[0]);

            /* renamed from: f  reason: collision with root package name */
            public boolean f5389f;

            /* renamed from: g  reason: collision with root package name */
            public Method f5390g;
            public Method h;
            public Method i;
            public Method j;

            public d(s.g gVar, String str, Class<? extends l0> cls, Class<? extends b> cls2) {
                super(gVar, str, cls, cls2);
                this.f5386c = gVar.n();
                boolean s = gVar.f5821e.s();
                this.f5389f = s;
                if (s) {
                    this.f5390g = l0.getMethodOrDie(cls, c.a.a.a.a.c("get", str, "Value"), new Class[]{Integer.TYPE});
                    this.h = l0.getMethodOrDie(cls2, c.a.a.a.a.c("get", str, "Value"), new Class[]{Integer.TYPE});
                    String c2 = c.a.a.a.a.c("set", str, "Value");
                    Class cls3 = Integer.TYPE;
                    this.i = l0.getMethodOrDie(cls2, c2, new Class[]{cls3, cls3});
                    this.j = l0.getMethodOrDie(cls2, c.a.a.a.a.c("add", str, "Value"), new Class[]{Integer.TYPE});
                }
            }

            @Override // c.b.d.l0.f.e, c.b.d.l0.f.a
            public Object b(l0 l0Var) {
                ArrayList arrayList = new ArrayList();
                int a2 = a(l0Var);
                for (int i2 = 0; i2 < a2; i2++) {
                    arrayList.add(k(l0Var, i2));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // c.b.d.l0.f.e, c.b.d.l0.f.a
            public void c(b bVar, Object obj) {
                if (this.f5389f) {
                    l0.invokeOrDie(this.j, bVar, new Object[]{Integer.valueOf(((s.f) obj).f5814b.f5568d)});
                    return;
                }
                super.c(bVar, l0.invokeOrDie(this.f5387d, null, new Object[]{obj}));
            }

            @Override // c.b.d.l0.f.e, c.b.d.l0.f.a
            public Object j(b bVar) {
                ArrayList arrayList = new ArrayList();
                int h2 = h(bVar);
                for (int i2 = 0; i2 < h2; i2++) {
                    arrayList.add(p(bVar, i2));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // c.b.d.l0.f.e, c.b.d.l0.f.a
            public Object k(l0 l0Var, int i2) {
                if (!this.f5389f) {
                    return l0.invokeOrDie(this.f5388e, super.k(l0Var, i2), new Object[0]);
                }
                return this.f5386c.m(((Integer) l0.invokeOrDie(this.f5390g, l0Var, new Object[]{Integer.valueOf(i2)})).intValue());
            }

            @Override // c.b.d.l0.f.e, c.b.d.l0.f.a
            public void o(b bVar, int i2, Object obj) {
                if (this.f5389f) {
                    l0.invokeOrDie(this.i, bVar, new Object[]{Integer.valueOf(i2), Integer.valueOf(((s.f) obj).f5814b.f5568d)});
                    return;
                }
                super.o(bVar, i2, l0.invokeOrDie(this.f5387d, null, new Object[]{obj}));
            }

            @Override // c.b.d.l0.f.e, c.b.d.l0.f.a
            public Object p(b bVar, int i2) {
                if (!this.f5389f) {
                    return l0.invokeOrDie(this.f5388e, super.p(bVar, i2), new Object[0]);
                }
                return this.f5386c.m(((Integer) l0.invokeOrDie(this.h, bVar, new Object[]{Integer.valueOf(i2)})).intValue());
            }
        }

        public static class e implements a {

            /* renamed from: a  reason: collision with root package name */
            public final Class f5391a;

            /* renamed from: b  reason: collision with root package name */
            public final a f5392b;

            public interface a {
            }

            public static final class b implements a {

                /* renamed from: a  reason: collision with root package name */
                public final Method f5393a;

                /* renamed from: b  reason: collision with root package name */
                public final Method f5394b;

                /* renamed from: c  reason: collision with root package name */
                public final Method f5395c;

                /* renamed from: d  reason: collision with root package name */
                public final Method f5396d;

                /* renamed from: e  reason: collision with root package name */
                public final Method f5397e;

                /* renamed from: f  reason: collision with root package name */
                public final Method f5398f;

                /* renamed from: g  reason: collision with root package name */
                public final Method f5399g;
                public final Method h;
                public final Method i;

                /* JADX WARN: Incorrect args count in method signature: (Lc/b/d/s$g;Ljava/lang/String;Ljava/lang/Class<+Lc/b/d/l0;>;Ljava/lang/Class<+Lc/b/d/l0$b;>;)V */
                public b(String str, Class cls, Class cls2) {
                    this.f5393a = l0.getMethodOrDie(cls, c.a.a.a.a.c("get", str, "List"), new Class[0]);
                    this.f5394b = l0.getMethodOrDie(cls2, c.a.a.a.a.c("get", str, "List"), new Class[0]);
                    this.f5395c = l0.getMethodOrDie(cls, c.a.a.a.a.q("get", str), new Class[]{Integer.TYPE});
                    this.f5396d = l0.getMethodOrDie(cls2, c.a.a.a.a.q("get", str), new Class[]{Integer.TYPE});
                    Class<?> returnType = this.f5395c.getReturnType();
                    this.f5397e = l0.getMethodOrDie(cls2, c.a.a.a.a.q("set", str), new Class[]{Integer.TYPE, returnType});
                    this.f5398f = l0.getMethodOrDie(cls2, c.a.a.a.a.q("add", str), new Class[]{returnType});
                    this.f5399g = l0.getMethodOrDie(cls, c.a.a.a.a.c("get", str, "Count"), new Class[0]);
                    this.h = l0.getMethodOrDie(cls2, c.a.a.a.a.c("get", str, "Count"), new Class[0]);
                    this.i = l0.getMethodOrDie(cls2, c.a.a.a.a.q("clear", str), new Class[0]);
                }
            }

            public e(s.g gVar, String str, Class<? extends l0> cls, Class<? extends b> cls2) {
                b bVar = new b(str, cls, cls2);
                this.f5391a = bVar.f5395c.getReturnType();
                this.f5392b = bVar;
            }

            @Override // c.b.d.l0.f.a
            public int a(l0 l0Var) {
                return ((Integer) l0.invokeOrDie(((b) this.f5392b).f5399g, l0Var, new Object[0])).intValue();
            }

            @Override // c.b.d.l0.f.a
            public Object b(l0 l0Var) {
                return l0.invokeOrDie(((b) this.f5392b).f5393a, l0Var, new Object[0]);
            }

            @Override // c.b.d.l0.f.a
            public void c(b bVar, Object obj) {
                l0.invokeOrDie(((b) this.f5392b).f5398f, bVar, new Object[]{obj});
            }

            @Override // c.b.d.l0.f.a
            public f1.a d(b bVar) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // c.b.d.l0.f.a
            public Object e(l0 l0Var) {
                return b(l0Var);
            }

            @Override // c.b.d.l0.f.a
            public boolean f(l0 l0Var) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // c.b.d.l0.f.a
            public f1.a g() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // c.b.d.l0.f.a
            public int h(b bVar) {
                return ((Integer) l0.invokeOrDie(((b) this.f5392b).h, bVar, new Object[0])).intValue();
            }

            @Override // c.b.d.l0.f.a
            public void i(b bVar, Object obj) {
                l0.invokeOrDie(((b) this.f5392b).i, bVar, new Object[0]);
                for (Object obj2 : (List) obj) {
                    c(bVar, obj2);
                }
            }

            @Override // c.b.d.l0.f.a
            public Object j(b bVar) {
                return l0.invokeOrDie(((b) this.f5392b).f5394b, bVar, new Object[0]);
            }

            @Override // c.b.d.l0.f.a
            public Object k(l0 l0Var, int i) {
                return l0.invokeOrDie(((b) this.f5392b).f5395c, l0Var, new Object[]{Integer.valueOf(i)});
            }

            @Override // c.b.d.l0.f.a
            public f1.a l(b bVar, int i) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // c.b.d.l0.f.a
            public void m(b bVar) {
                l0.invokeOrDie(((b) this.f5392b).i, bVar, new Object[0]);
            }

            @Override // c.b.d.l0.f.a
            public boolean n(b bVar) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // c.b.d.l0.f.a
            public void o(b bVar, int i, Object obj) {
                l0.invokeOrDie(((b) this.f5392b).f5397e, bVar, new Object[]{Integer.valueOf(i), obj});
            }

            @Override // c.b.d.l0.f.a
            public Object p(b bVar, int i) {
                return l0.invokeOrDie(((b) this.f5392b).f5396d, bVar, new Object[]{Integer.valueOf(i)});
            }
        }

        /* renamed from: c.b.d.l0$f$f  reason: collision with other inner class name */
        public static final class C0109f extends e {

            /* renamed from: c  reason: collision with root package name */
            public final Method f5400c = l0.getMethodOrDie(this.f5391a, "newBuilder", new Class[0]);

            /* renamed from: d  reason: collision with root package name */
            public final Method f5401d;

            public C0109f(s.g gVar, String str, Class<? extends l0> cls, Class<? extends b> cls2) {
                super(gVar, str, cls, cls2);
                this.f5401d = l0.getMethodOrDie(cls2, c.a.a.a.a.c("get", str, "Builder"), new Class[]{Integer.TYPE});
            }

            @Override // c.b.d.l0.f.e, c.b.d.l0.f.a
            public void c(b bVar, Object obj) {
                super.c(bVar, q(obj));
            }

            @Override // c.b.d.l0.f.e, c.b.d.l0.f.a
            public f1.a g() {
                return (f1.a) l0.invokeOrDie(this.f5400c, null, new Object[0]);
            }

            @Override // c.b.d.l0.f.e, c.b.d.l0.f.a
            public f1.a l(b bVar, int i) {
                return (f1.a) l0.invokeOrDie(this.f5401d, bVar, new Object[]{Integer.valueOf(i)});
            }

            @Override // c.b.d.l0.f.e, c.b.d.l0.f.a
            public void o(b bVar, int i, Object obj) {
                super.o(bVar, i, q(obj));
            }

            public final Object q(Object obj) {
                return this.f5391a.isInstance(obj) ? obj : ((f1.a) l0.invokeOrDie(this.f5400c, null, new Object[0])).mergeFrom((f1) obj).build();
            }
        }

        public static final class g extends h {

            /* renamed from: f  reason: collision with root package name */
            public s.e f5402f;

            /* renamed from: g  reason: collision with root package name */
            public Method f5403g = l0.getMethodOrDie(this.f5404a, "valueOf", new Class[]{s.f.class});
            public Method h = l0.getMethodOrDie(this.f5404a, "getValueDescriptor", new Class[0]);
            public boolean i;
            public Method j;
            public Method k;
            public Method l;

            public g(s.g gVar, String str, Class<? extends l0> cls, Class<? extends b> cls2, String str2) {
                super(gVar, str, cls, cls2, str2);
                this.f5402f = gVar.n();
                boolean s = gVar.f5821e.s();
                this.i = s;
                if (s) {
                    this.j = l0.getMethodOrDie(cls, c.a.a.a.a.c("get", str, "Value"), new Class[0]);
                    this.k = l0.getMethodOrDie(cls2, c.a.a.a.a.c("get", str, "Value"), new Class[0]);
                    this.l = l0.getMethodOrDie(cls2, c.a.a.a.a.c("set", str, "Value"), new Class[]{Integer.TYPE});
                }
            }

            @Override // c.b.d.l0.f.h, c.b.d.l0.f.a
            public Object b(l0 l0Var) {
                if (!this.i) {
                    return l0.invokeOrDie(this.h, super.b(l0Var), new Object[0]);
                }
                return this.f5402f.m(((Integer) l0.invokeOrDie(this.j, l0Var, new Object[0])).intValue());
            }

            @Override // c.b.d.l0.f.h, c.b.d.l0.f.a
            public void i(b bVar, Object obj) {
                if (this.i) {
                    l0.invokeOrDie(this.l, bVar, new Object[]{Integer.valueOf(((s.f) obj).f5814b.f5568d)});
                    return;
                }
                super.i(bVar, l0.invokeOrDie(this.f5403g, null, new Object[]{obj}));
            }

            @Override // c.b.d.l0.f.h, c.b.d.l0.f.a
            public Object j(b bVar) {
                if (!this.i) {
                    return l0.invokeOrDie(this.h, super.j(bVar), new Object[0]);
                }
                return this.f5402f.m(((Integer) l0.invokeOrDie(this.k, bVar, new Object[0])).intValue());
            }
        }

        public static class h implements a {

            /* renamed from: a  reason: collision with root package name */
            public final Class<?> f5404a;

            /* renamed from: b  reason: collision with root package name */
            public final s.g f5405b;

            /* renamed from: c  reason: collision with root package name */
            public final boolean f5406c;

            /* renamed from: d  reason: collision with root package name */
            public final boolean f5407d;

            /* renamed from: e  reason: collision with root package name */
            public final a f5408e;

            public interface a {
            }

            public static final class b implements a {

                /* renamed from: a  reason: collision with root package name */
                public final Method f5409a;

                /* renamed from: b  reason: collision with root package name */
                public final Method f5410b;

                /* renamed from: c  reason: collision with root package name */
                public final Method f5411c;

                /* renamed from: d  reason: collision with root package name */
                public final Method f5412d;

                /* renamed from: e  reason: collision with root package name */
                public final Method f5413e;

                /* renamed from: f  reason: collision with root package name */
                public final Method f5414f;

                /* renamed from: g  reason: collision with root package name */
                public final Method f5415g;
                public final Method h;

                /* JADX WARN: Incorrect args count in method signature: (Lc/b/d/s$g;Ljava/lang/String;Ljava/lang/Class<+Lc/b/d/l0;>;Ljava/lang/Class<+Lc/b/d/l0$b;>;Ljava/lang/String;ZZ)V */
                public b(String str, Class cls, Class cls2, String str2, boolean z, boolean z2) {
                    this.f5409a = l0.getMethodOrDie(cls, c.a.a.a.a.q("get", str), new Class[0]);
                    this.f5410b = l0.getMethodOrDie(cls2, c.a.a.a.a.q("get", str), new Class[0]);
                    this.f5411c = l0.getMethodOrDie(cls2, c.a.a.a.a.q("set", str), new Class[]{this.f5409a.getReturnType()});
                    Method method = null;
                    this.f5412d = z2 ? l0.getMethodOrDie(cls, c.a.a.a.a.q("has", str), new Class[0]) : null;
                    this.f5413e = z2 ? l0.getMethodOrDie(cls2, c.a.a.a.a.q("has", str), new Class[0]) : null;
                    this.f5414f = l0.getMethodOrDie(cls2, c.a.a.a.a.q("clear", str), new Class[0]);
                    this.f5415g = z ? l0.getMethodOrDie(cls, c.a.a.a.a.c("get", str2, "Case"), new Class[0]) : null;
                    this.h = z ? l0.getMethodOrDie(cls2, c.a.a.a.a.c("get", str2, "Case"), new Class[0]) : method;
                }
            }

            public h(s.g gVar, String str, Class<? extends l0> cls, Class<? extends b> cls2, String str2) {
                this.f5406c = gVar.j != null;
                boolean z = (gVar.f5821e.p() == s.h.a.PROTO2) || (!this.f5406c && gVar.f5823g.f5835b == s.g.a.MESSAGE);
                this.f5407d = z;
                b bVar = new b(str, cls, cls2, str2, this.f5406c, z);
                this.f5405b = gVar;
                this.f5404a = bVar.f5409a.getReturnType();
                this.f5408e = bVar;
            }

            @Override // c.b.d.l0.f.a
            public int a(l0 l0Var) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // c.b.d.l0.f.a
            public Object b(l0 l0Var) {
                return l0.invokeOrDie(((b) this.f5408e).f5409a, l0Var, new Object[0]);
            }

            @Override // c.b.d.l0.f.a
            public void c(b bVar, Object obj) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // c.b.d.l0.f.a
            public f1.a d(b bVar) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // c.b.d.l0.f.a
            public Object e(l0 l0Var) {
                return b(l0Var);
            }

            @Override // c.b.d.l0.f.a
            public boolean f(l0 l0Var) {
                if (this.f5407d) {
                    return ((Boolean) l0.invokeOrDie(((b) this.f5408e).f5412d, l0Var, new Object[0])).booleanValue();
                }
                if (this.f5406c) {
                    return ((n0.c) l0.invokeOrDie(((b) this.f5408e).f5415g, l0Var, new Object[0])).a() == this.f5405b.f5819c.f5594d;
                }
                return !b(l0Var).equals(this.f5405b.m());
            }

            @Override // c.b.d.l0.f.a
            public f1.a g() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // c.b.d.l0.f.a
            public int h(b bVar) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // c.b.d.l0.f.a
            public void i(b bVar, Object obj) {
                l0.invokeOrDie(((b) this.f5408e).f5411c, bVar, new Object[]{obj});
            }

            @Override // c.b.d.l0.f.a
            public Object j(b bVar) {
                return l0.invokeOrDie(((b) this.f5408e).f5410b, bVar, new Object[0]);
            }

            @Override // c.b.d.l0.f.a
            public Object k(l0 l0Var, int i) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // c.b.d.l0.f.a
            public f1.a l(b bVar, int i) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // c.b.d.l0.f.a
            public void m(b bVar) {
                l0.invokeOrDie(((b) this.f5408e).f5414f, bVar, new Object[0]);
            }

            @Override // c.b.d.l0.f.a
            public boolean n(b bVar) {
                if (this.f5407d) {
                    return ((Boolean) l0.invokeOrDie(((b) this.f5408e).f5413e, bVar, new Object[0])).booleanValue();
                }
                if (this.f5406c) {
                    return ((n0.c) l0.invokeOrDie(((b) this.f5408e).h, bVar, new Object[0])).a() == this.f5405b.f5819c.f5594d;
                }
                return !j(bVar).equals(this.f5405b.m());
            }

            @Override // c.b.d.l0.f.a
            public void o(b bVar, int i, Object obj) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }

            @Override // c.b.d.l0.f.a
            public Object p(b bVar, int i) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }
        }

        public static final class i extends h {

            /* renamed from: f  reason: collision with root package name */
            public final Method f5416f = l0.getMethodOrDie(this.f5404a, "newBuilder", new Class[0]);

            /* renamed from: g  reason: collision with root package name */
            public final Method f5417g;

            public i(s.g gVar, String str, Class<? extends l0> cls, Class<? extends b> cls2, String str2) {
                super(gVar, str, cls, cls2, str2);
                this.f5417g = l0.getMethodOrDie(cls2, c.a.a.a.a.c("get", str, "Builder"), new Class[0]);
            }

            @Override // c.b.d.l0.f.h, c.b.d.l0.f.a
            public f1.a d(b bVar) {
                return (f1.a) l0.invokeOrDie(this.f5417g, bVar, new Object[0]);
            }

            @Override // c.b.d.l0.f.h, c.b.d.l0.f.a
            public f1.a g() {
                return (f1.a) l0.invokeOrDie(this.f5416f, null, new Object[0]);
            }

            @Override // c.b.d.l0.f.h, c.b.d.l0.f.a
            public void i(b bVar, Object obj) {
                if (!this.f5404a.isInstance(obj)) {
                    obj = ((f1.a) l0.invokeOrDie(this.f5416f, null, new Object[0])).mergeFrom((f1) obj).buildPartial();
                }
                super.i(bVar, obj);
            }
        }

        public static final class j extends h {

            /* renamed from: f  reason: collision with root package name */
            public final Method f5418f;

            /* renamed from: g  reason: collision with root package name */
            public final Method f5419g;

            public j(s.g gVar, String str, Class<? extends l0> cls, Class<? extends b> cls2, String str2) {
                super(gVar, str, cls, cls2, str2);
                this.f5418f = l0.getMethodOrDie(cls, c.a.a.a.a.c("get", str, "Bytes"), new Class[0]);
                l0.getMethodOrDie(cls2, c.a.a.a.a.c("get", str, "Bytes"), new Class[0]);
                this.f5419g = l0.getMethodOrDie(cls2, c.a.a.a.a.c("set", str, "Bytes"), new Class[]{j.class});
            }

            @Override // c.b.d.l0.f.h, c.b.d.l0.f.a
            public Object e(l0 l0Var) {
                return l0.invokeOrDie(this.f5418f, l0Var, new Object[0]);
            }

            @Override // c.b.d.l0.f.h, c.b.d.l0.f.a
            public void i(b bVar, Object obj) {
                if (obj instanceof j) {
                    l0.invokeOrDie(this.f5419g, bVar, new Object[]{obj});
                    return;
                }
                super.i(bVar, obj);
            }
        }

        public f(s.b bVar, String[] strArr) {
            this.f5375a = bVar;
            this.f5377c = strArr;
            this.f5376b = new a[bVar.p().size()];
            this.f5378d = new c[Collections.unmodifiableList(Arrays.asList(bVar.h)).size()];
        }

        public static c a(f fVar, s.k kVar) {
            if (fVar == null) {
                throw null;
            } else if (kVar.f5855e == fVar.f5375a) {
                return fVar.f5378d[kVar.f5851a];
            } else {
                throw new IllegalArgumentException("OneofDescriptor does not match message type.");
            }
        }

        public static a b(f fVar, s.g gVar) {
            if (fVar == null) {
                throw null;
            } else if (gVar.h != fVar.f5375a) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            } else if (!gVar.s()) {
                return fVar.f5376b[gVar.f5818b];
            } else {
                throw new IllegalArgumentException("This type does not have extensions.");
            }
        }

        public f c(Class<? extends l0> cls, Class<? extends b> cls2) {
            if (this.f5379e) {
                return this;
            }
            synchronized (this) {
                if (this.f5379e) {
                    return this;
                }
                int length = this.f5376b.length;
                int i2 = 0;
                while (true) {
                    String str = null;
                    if (i2 >= length) {
                        break;
                    }
                    s.g gVar = this.f5375a.p().get(i2);
                    if (gVar.j != null) {
                        str = this.f5377c[gVar.j.f5851a + length];
                    }
                    if (gVar.e()) {
                        if (gVar.f5823g.f5835b == s.g.a.MESSAGE) {
                            if (gVar.t()) {
                                a[] aVarArr = this.f5376b;
                                String str2 = this.f5377c[i2];
                                aVarArr[i2] = new b(gVar, cls);
                            } else {
                                this.f5376b[i2] = new C0109f(gVar, this.f5377c[i2], cls, cls2);
                            }
                        } else if (gVar.f5823g.f5835b == s.g.a.ENUM) {
                            this.f5376b[i2] = new d(gVar, this.f5377c[i2], cls, cls2);
                        } else {
                            this.f5376b[i2] = new e(gVar, this.f5377c[i2], cls, cls2);
                        }
                    } else if (gVar.f5823g.f5835b == s.g.a.MESSAGE) {
                        this.f5376b[i2] = new i(gVar, this.f5377c[i2], cls, cls2, str);
                    } else if (gVar.f5823g.f5835b == s.g.a.ENUM) {
                        this.f5376b[i2] = new g(gVar, this.f5377c[i2], cls, cls2, str);
                    } else {
                        s.g.a aVar = gVar.f5823g.f5835b;
                        s.g.a aVar2 = s.g.a.STRING;
                        if (aVar == s.g.a.STRING) {
                            this.f5376b[i2] = new j(gVar, this.f5377c[i2], cls, cls2, str);
                        } else {
                            this.f5376b[i2] = new h(gVar, this.f5377c[i2], cls, cls2, str);
                        }
                    }
                    i2++;
                }
                int length2 = this.f5378d.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    this.f5378d[i3] = new c(this.f5375a, this.f5377c[i3 + length], cls, cls2);
                }
                this.f5379e = true;
                this.f5377c = null;
                return this;
            }
        }
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public static final g f5420a = new g();
    }

    public l0() {
        this.unknownFields = q2.f5482d;
    }

    public l0(b<?> bVar) {
        this.unknownFields = bVar.getUnknownFields();
    }

    public static boolean canUseUnsafe() {
        return v2.h && v2.f5900g;
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

    public static n0.a emptyBooleanList() {
        return g.f5273e;
    }

    public static n0.b emptyDoubleList() {
        return t.f5865e;
    }

    public static n0.e emptyFloatList() {
        return h0.f5292e;
    }

    public static n0.f emptyIntList() {
        return m0.f5433e;
    }

    public static n0.g emptyLongList() {
        return v0.f5889e;
    }

    public static void enableAlwaysUseFieldBuildersForTesting() {
        setAlwaysUseFieldBuildersForTesting(true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Map<s.g, Object> getAllFieldsMutable(boolean z) {
        List list;
        TreeMap treeMap = new TreeMap();
        List<s.g> p = internalGetFieldAccessorTable().f5375a.p();
        int i = 0;
        while (i < p.size()) {
            s.g gVar = p.get(i);
            s.k kVar = gVar.j;
            if (kVar != null) {
                i += kVar.f5856f - 1;
                if (!hasOneof(kVar)) {
                    i++;
                } else {
                    gVar = getOneofFieldDescriptor(kVar);
                    list = (z || gVar.f5823g.f5835b != s.g.a.STRING) ? getField(gVar) : getFieldRaw(gVar);
                }
            } else {
                if (gVar.e()) {
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
            StringBuilder h = c.a.a.a.a.h("Generated message class \"");
            h.append(cls.getName());
            h.append("\" missing method \"");
            h.append(str);
            h.append("\".");
            throw new RuntimeException(h.toString(), e2);
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

    public static <V> void maybeSerializeBooleanEntryTo(m mVar, Map<Boolean, V> map, x0<Boolean, V> x0Var, int i, boolean z) {
        if (!map.containsKey(Boolean.valueOf(z))) {
            return;
        }
        if (x0Var != null) {
            throw null;
        }
        throw null;
    }

    public static n0.a mutableCopy(n0.a aVar) {
        int size = aVar.size();
        return ((g) aVar).i(size == 0 ? 10 : size * 2);
    }

    public static n0.b mutableCopy(n0.b bVar) {
        int size = bVar.size();
        return ((t) bVar).i(size == 0 ? 10 : size * 2);
    }

    public static n0.e mutableCopy(n0.e eVar) {
        int size = eVar.size();
        return ((h0) eVar).i(size == 0 ? 10 : size * 2);
    }

    public static n0.f mutableCopy(n0.f fVar) {
        int size = fVar.size();
        return ((m0) fVar).i(size == 0 ? 10 : size * 2);
    }

    public static n0.g mutableCopy(n0.g gVar) {
        int size = gVar.size();
        return ((v0) gVar).i(size == 0 ? 10 : size * 2);
    }

    public static n0.a newBooleanList() {
        return new g();
    }

    public static n0.b newDoubleList() {
        return new t();
    }

    public static n0.e newFloatList() {
        return new h0();
    }

    public static n0.f newIntList() {
        return new m0();
    }

    public static n0.g newLongList() {
        return new v0();
    }

    public static <M extends f1> M parseDelimitedWithIOException(w1<M> w1Var, InputStream inputStream) {
        try {
            return w1Var.parseDelimitedFrom(inputStream);
        } catch (o0 e2) {
            throw e2.j();
        }
    }

    public static <M extends f1> M parseDelimitedWithIOException(w1<M> w1Var, InputStream inputStream, z zVar) {
        try {
            return w1Var.parseDelimitedFrom(inputStream, zVar);
        } catch (o0 e2) {
            throw e2.j();
        }
    }

    public static <M extends f1> M parseWithIOException(w1<M> w1Var, k kVar) {
        try {
            return w1Var.parseFrom(kVar);
        } catch (o0 e2) {
            throw e2.j();
        }
    }

    public static <M extends f1> M parseWithIOException(w1<M> w1Var, k kVar, z zVar) {
        try {
            return w1Var.parseFrom(kVar, zVar);
        } catch (o0 e2) {
            throw e2.j();
        }
    }

    public static <M extends f1> M parseWithIOException(w1<M> w1Var, InputStream inputStream) {
        try {
            return w1Var.parseFrom(inputStream);
        } catch (o0 e2) {
            throw e2.j();
        }
    }

    public static <M extends f1> M parseWithIOException(w1<M> w1Var, InputStream inputStream, z zVar) {
        try {
            return w1Var.parseFrom(inputStream, zVar);
        } catch (o0 e2) {
            throw e2.j();
        }
    }

    public static <V> void serializeBooleanMapTo(m mVar, z0<Boolean, V> z0Var, x0<Boolean, V> x0Var, int i) {
        Map<Boolean, V> e2 = z0Var.e();
        if (mVar != null) {
            serializeMapTo(mVar, e2, x0Var, i);
            return;
        }
        throw null;
    }

    public static <V> void serializeIntegerMapTo(m mVar, z0<Integer, V> z0Var, x0<Integer, V> x0Var, int i) {
        Map<Integer, V> e2 = z0Var.e();
        if (mVar != null) {
            serializeMapTo(mVar, e2, x0Var, i);
            return;
        }
        throw null;
    }

    public static <V> void serializeLongMapTo(m mVar, z0<Long, V> z0Var, x0<Long, V> x0Var, int i) {
        Map<Long, V> e2 = z0Var.e();
        if (mVar != null) {
            serializeMapTo(mVar, e2, x0Var, i);
            return;
        }
        throw null;
    }

    public static <K, V> void serializeMapTo(m mVar, Map<K, V> map, x0<K, V> x0Var, int i) {
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        if (it.hasNext()) {
            it.next();
            if (x0Var != null) {
                throw null;
            }
            throw null;
        }
    }

    public static <V> void serializeStringMapTo(m mVar, z0<String, V> z0Var, x0<String, V> x0Var, int i) {
        Map<String, V> e2 = z0Var.e();
        if (mVar != null) {
            serializeMapTo(mVar, e2, x0Var, i);
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

    @Override // c.b.d.k1
    public Map<s.g, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable(false));
    }

    public Map<s.g, Object> getAllFieldsRaw() {
        return Collections.unmodifiableMap(getAllFieldsMutable(true));
    }

    @Override // c.b.d.k1
    public s.b getDescriptorForType() {
        return internalGetFieldAccessorTable().f5375a;
    }

    @Override // c.b.d.k1
    public Object getField(s.g gVar) {
        return f.b(internalGetFieldAccessorTable(), gVar).b(this);
    }

    public Object getFieldRaw(s.g gVar) {
        return f.b(internalGetFieldAccessorTable(), gVar).e(this);
    }

    @Override // c.b.d.a
    public s.g getOneofFieldDescriptor(s.k kVar) {
        f.c a2 = f.a(internalGetFieldAccessorTable(), kVar);
        int a3 = ((n0.c) invokeOrDie(a2.f5383b, this, new Object[0])).a();
        if (a3 > 0) {
            return a2.f5382a.n(a3);
        }
        return null;
    }

    @Override // c.b.d.i1
    public w1<? extends l0> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public Object getRepeatedField(s.g gVar, int i) {
        return f.b(internalGetFieldAccessorTable(), gVar).k(this, i);
    }

    public int getRepeatedFieldCount(s.g gVar) {
        return f.b(internalGetFieldAccessorTable(), gVar).a(this);
    }

    @Override // c.b.d.a, c.b.d.i1
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int L1 = t.L1(this, getAllFieldsRaw());
        this.memoizedSize = L1;
        return L1;
    }

    @Override // c.b.d.k1
    public q2 getUnknownFields() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // c.b.d.k1
    public boolean hasField(s.g gVar) {
        return f.b(internalGetFieldAccessorTable(), gVar).f(this);
    }

    @Override // c.b.d.a
    public boolean hasOneof(s.k kVar) {
        return ((n0.c) invokeOrDie(f.a(internalGetFieldAccessorTable(), kVar).f5383b, this, new Object[0])).a() != 0;
    }

    public abstract f internalGetFieldAccessorTable();

    public z0 internalGetMapField(int i) {
        StringBuilder h = c.a.a.a.a.h("No map fields found in ");
        h.append(getClass().getName());
        throw new RuntimeException(h.toString());
    }

    @Override // c.b.d.a, c.b.d.j1
    public boolean isInitialized() {
        for (s.g gVar : getDescriptorForType().p()) {
            if (gVar.y() && !hasField(gVar)) {
                return false;
            }
            if (gVar.f5823g.f5835b == s.g.a.MESSAGE) {
                if (gVar.e()) {
                    for (f1 f1Var : (List) getField(gVar)) {
                        if (!f1Var.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (hasField(gVar) && !((f1) getField(gVar)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void makeExtensionsImmutable() {
    }

    public void mergeFromAndMakeImmutableInternal(k kVar, z zVar) {
        d2 b2 = z1.f5964c.b(this);
        try {
            l lVar = kVar.f5339d;
            if (lVar == null) {
                lVar = new l(kVar);
            }
            b2.h(this, lVar, zVar);
            b2.g(this);
        } catch (o0 e2) {
            e2.f5447b = this;
            throw e2;
        } catch (IOException e3) {
            o0 o0Var = new o0(e3);
            o0Var.f5447b = this;
            throw o0Var;
        }
    }

    @Override // c.b.d.a
    public f1.a newBuilderForType(a.b bVar) {
        return newBuilderForType((c) new a(this, bVar));
    }

    public abstract f1.a newBuilderForType(c cVar);

    public Object newInstance(g gVar) {
        throw new UnsupportedOperationException("This method must be overridden by the subclass.");
    }

    public boolean parseUnknownField(k kVar, q2.b bVar, z zVar, int i) {
        return kVar.f5340e ? kVar.J(i) : bVar.e(i, kVar);
    }

    public boolean parseUnknownFieldProto3(k kVar, q2.b bVar, z zVar, int i) {
        return parseUnknownField(kVar, bVar, zVar, i);
    }

    public Object writeReplace() {
        return new k0.f(this);
    }

    @Override // c.b.d.a, c.b.d.i1
    public void writeTo(m mVar) {
        t.u3(this, getAllFieldsRaw(), mVar, false);
    }

    public static abstract class e<MessageType extends e> extends l0 implements Object<MessageType> {

        /* renamed from: b  reason: collision with root package name */
        public final f0<s.g> f5370b;

        public class a {

            /* renamed from: a  reason: collision with root package name */
            public final Iterator<Map.Entry<s.g, Object>> f5371a;

            /* renamed from: b  reason: collision with root package name */
            public Map.Entry<s.g, Object> f5372b;

            /* renamed from: c  reason: collision with root package name */
            public final boolean f5373c;

            public a(boolean z, a aVar) {
                Iterator<Map.Entry<s.g, Object>> w = e.this.f5370b.w();
                this.f5371a = w;
                if (w.hasNext()) {
                    this.f5372b = this.f5371a.next();
                }
                this.f5373c = z;
            }

            public void a(int i, m mVar) {
                while (true) {
                    Map.Entry<s.g, Object> entry = this.f5372b;
                    if (entry != null && entry.getKey().f5819c.f5594d < i) {
                        s.g key = this.f5372b.getKey();
                        if (!this.f5373c || key.j() != x2.c.MESSAGE || key.e()) {
                            f0.F(key, this.f5372b.getValue(), mVar);
                        } else {
                            Map.Entry<s.g, Object> entry2 = this.f5372b;
                            if (entry2 instanceof q0.b) {
                                mVar.o0(key.f5819c.f5594d, ((q0.b) entry2).f5480b.getValue().b());
                            } else {
                                mVar.n0(key.f5819c.f5594d, (f1) entry2.getValue());
                            }
                        }
                        this.f5372b = this.f5371a.hasNext() ? this.f5371a.next() : null;
                    } else {
                        return;
                    }
                }
            }
        }

        public e() {
            this.f5370b = new f0<>();
        }

        public boolean a() {
            return this.f5370b.t();
        }

        public int b() {
            return this.f5370b.p();
        }

        public Map<s.g, Object> c() {
            return this.f5370b.j();
        }

        public e<MessageType>.a d() {
            return new a(false, null);
        }

        public final void e(s.g gVar) {
            if (gVar.h != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        @Override // c.b.d.l0, c.b.d.k1
        public Map<s.g, Object> getAllFields() {
            Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(c());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // c.b.d.l0
        public Map<s.g, Object> getAllFieldsRaw() {
            Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(c());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // c.b.d.l0, c.b.d.k1
        public Object getField(s.g gVar) {
            if (!gVar.s()) {
                return l0.super.getField(gVar);
            }
            e(gVar);
            Object k = this.f5370b.k(gVar);
            if (k != null) {
                return k;
            }
            if (gVar.e()) {
                return Collections.emptyList();
            }
            return gVar.f5823g.f5835b == s.g.a.MESSAGE ? u.a(gVar.p()) : gVar.m();
        }

        @Override // c.b.d.l0
        public Object getRepeatedField(s.g gVar, int i) {
            if (!gVar.s()) {
                return l0.super.getRepeatedField(gVar, i);
            }
            e(gVar);
            return this.f5370b.n(gVar, i);
        }

        @Override // c.b.d.l0
        public int getRepeatedFieldCount(s.g gVar) {
            if (!gVar.s()) {
                return l0.super.getRepeatedFieldCount(gVar);
            }
            e(gVar);
            return this.f5370b.o(gVar);
        }

        @Override // c.b.d.l0, c.b.d.k1
        public boolean hasField(s.g gVar) {
            if (!gVar.s()) {
                return l0.super.hasField(gVar);
            }
            e(gVar);
            return this.f5370b.r(gVar);
        }

        @Override // c.b.d.l0, c.b.d.a, c.b.d.j1
        public boolean isInitialized() {
            return l0.super.isInitialized() && a();
        }

        @Override // c.b.d.l0
        public void makeExtensionsImmutable() {
            this.f5370b.x();
        }

        @Override // c.b.d.l0
        public boolean parseUnknownField(k kVar, q2.b bVar, z zVar, int i) {
            if (kVar.f5340e) {
                bVar = null;
            }
            return t.g2(kVar, bVar, zVar, getDescriptorForType(), new m1(this.f5370b), i);
        }

        @Override // c.b.d.l0
        public boolean parseUnknownFieldProto3(k kVar, q2.b bVar, z zVar, int i) {
            return parseUnknownField(kVar, bVar, zVar, i);
        }

        public e(d<MessageType, ?> dVar) {
            super(dVar);
            f0<s.g> f0Var;
            f0.b<s.g> bVar = dVar.f5369b;
            if (bVar == null) {
                f0Var = f0.f5261d;
            } else if (bVar.f5265a.isEmpty()) {
                f0Var = f0.f5261d;
            } else {
                bVar.f5267c = false;
                h2<T, Object> h2Var = bVar.f5265a;
                if (bVar.f5268d) {
                    h2Var = f0.d(h2Var, false);
                    f0.b.g(h2Var);
                }
                f0<s.g> f0Var2 = new f0<>(h2Var, null);
                f0Var2.f5264c = bVar.f5266b;
                f0Var = f0Var2;
            }
            this.f5370b = f0Var;
        }
    }
}
