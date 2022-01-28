package c.b.d;

import c.b.d.a;
import c.b.d.a.AbstractC0097a;
import c.b.d.j1;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class b2<MType extends a, BType extends a.AbstractC0097a, IType extends j1> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public a.b f3831a;

    /* renamed from: b  reason: collision with root package name */
    public List<MType> f3832b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3833c;

    /* renamed from: d  reason: collision with root package name */
    public List<f2<MType, BType, IType>> f3834d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3835e;
    public b<MType, BType, IType> f;
    public a<MType, BType, IType> g;
    public c<MType, BType, IType> h;

    public static class a<MType extends a, BType extends a.AbstractC0097a, IType extends j1> extends AbstractList<BType> implements List<BType> {

        /* renamed from: b  reason: collision with root package name */
        public b2<MType, BType, IType> f3836b;

        public a(b2<MType, BType, IType> b2Var) {
            this.f3836b = b2Var;
        }

        public void a() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.List, java.util.AbstractList
        public Object get(int i) {
            return this.f3836b.k(i);
        }

        public int size() {
            return this.f3836b.m();
        }
    }

    public static class b<MType extends a, BType extends a.AbstractC0097a, IType extends j1> extends AbstractList<MType> implements List<MType> {

        /* renamed from: b  reason: collision with root package name */
        public b2<MType, BType, IType> f3837b;

        public b(b2<MType, BType, IType> b2Var) {
            this.f3837b = b2Var;
        }

        public void a() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.List, java.util.AbstractList
        public Object get(int i) {
            return this.f3837b.n(i, false);
        }

        public int size() {
            return this.f3837b.m();
        }
    }

    public static class c<MType extends a, BType extends a.AbstractC0097a, IType extends j1> extends AbstractList<IType> implements List<IType> {

        /* renamed from: b  reason: collision with root package name */
        public b2<MType, BType, IType> f3838b;

        public c(b2<MType, BType, IType> b2Var) {
            this.f3838b = b2Var;
        }

        public void a() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.List, java.util.AbstractList
        public Object get(int i) {
            return this.f3838b.p(i);
        }

        public int size() {
            return this.f3838b.m();
        }
    }

    public b2(List<MType> list, boolean z, a.b bVar, boolean z2) {
        this.f3832b = list;
        this.f3833c = z;
        this.f3831a = bVar;
        this.f3835e = z2;
    }

    @Override // c.b.d.a.b
    public void a() {
        t();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: c.b.d.b2<MType extends c.b.d.a, BType extends c.b.d.a$a, IType extends c.b.d.j1> */
    /* JADX WARN: Multi-variable type inference failed */
    public b2<MType, BType, IType> b(Iterable<? extends MType> iterable) {
        Iterator<? extends MType> it = iterable.iterator();
        while (it.hasNext()) {
            m0.a((a) it.next());
        }
        int i = -1;
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() == 0) {
                return this;
            }
            i = collection.size();
        }
        j();
        if (i >= 0) {
            List<MType> list = this.f3832b;
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + i);
            }
        }
        Iterator<? extends MType> it2 = iterable.iterator();
        while (it2.hasNext()) {
            f((a) it2.next());
        }
        t();
        r();
        return this;
    }

    public BType c(int i, MType mtype) {
        j();
        i();
        f2<MType, BType, IType> f2Var = new f2<>(mtype, this, this.f3835e);
        this.f3832b.add(i, null);
        this.f3834d.add(i, f2Var);
        t();
        r();
        return f2Var.d();
    }

    public BType d(MType mtype) {
        j();
        i();
        f2<MType, BType, IType> f2Var = new f2<>(mtype, this, this.f3835e);
        this.f3832b.add(null);
        this.f3834d.add(f2Var);
        t();
        r();
        return f2Var.d();
    }

    public b2<MType, BType, IType> e(int i, MType mtype) {
        m0.a(mtype);
        j();
        this.f3832b.add(i, mtype);
        List<f2<MType, BType, IType>> list = this.f3834d;
        if (list != null) {
            list.add(i, null);
        }
        t();
        r();
        return this;
    }

    public b2<MType, BType, IType> f(MType mtype) {
        m0.a(mtype);
        j();
        this.f3832b.add(mtype);
        List<f2<MType, BType, IType>> list = this.f3834d;
        if (list != null) {
            list.add(null);
        }
        t();
        r();
        return this;
    }

    public List<MType> g() {
        boolean z;
        this.f3835e = true;
        if (!this.f3833c && this.f3834d == null) {
            return this.f3832b;
        }
        if (!this.f3833c) {
            int i = 0;
            while (true) {
                if (i >= this.f3832b.size()) {
                    z = true;
                    break;
                }
                MType mtype = this.f3832b.get(i);
                f2<MType, BType, IType> f2Var = this.f3834d.get(i);
                if (!(f2Var == null || f2Var.b() == mtype)) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                return this.f3832b;
            }
        }
        j();
        for (int i2 = 0; i2 < this.f3832b.size(); i2++) {
            this.f3832b.set(i2, n(i2, true));
        }
        List<MType> unmodifiableList = Collections.unmodifiableList(this.f3832b);
        this.f3832b = unmodifiableList;
        this.f3833c = false;
        return unmodifiableList;
    }

    public void h() {
        this.f3832b = Collections.emptyList();
        this.f3833c = false;
        List<f2<MType, BType, IType>> list = this.f3834d;
        if (list != null) {
            for (f2<MType, BType, IType> f2Var : list) {
                if (f2Var != null) {
                    f2Var.f3866a = null;
                }
            }
            this.f3834d = null;
        }
        t();
        r();
    }

    public final void i() {
        if (this.f3834d == null) {
            this.f3834d = new ArrayList(this.f3832b.size());
            for (int i = 0; i < this.f3832b.size(); i++) {
                this.f3834d.add(null);
            }
        }
    }

    public final void j() {
        if (!this.f3833c) {
            this.f3832b = new ArrayList(this.f3832b);
            this.f3833c = true;
        }
    }

    public BType k(int i) {
        i();
        f2<MType, BType, IType> f2Var = this.f3834d.get(i);
        if (f2Var == null) {
            f2<MType, BType, IType> f2Var2 = new f2<>(this.f3832b.get(i), this, this.f3835e);
            this.f3834d.set(i, f2Var2);
            f2Var = f2Var2;
        }
        return f2Var.d();
    }

    public List<BType> l() {
        if (this.g == null) {
            this.g = new a<>(this);
        }
        return this.g;
    }

    public int m() {
        return this.f3832b.size();
    }

    public final MType n(int i, boolean z) {
        f2<MType, BType, IType> f2Var;
        List<f2<MType, BType, IType>> list = this.f3834d;
        return (list == null || (f2Var = list.get(i)) == null) ? this.f3832b.get(i) : z ? f2Var.b() : f2Var.e();
    }

    public List<MType> o() {
        if (this.f == null) {
            this.f = new b<>(this);
        }
        return this.f;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [c.b.d.j1, IType extends c.b.d.j1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [BType extends c.b.d.a$a, IType extends c.b.d.j1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [MType extends c.b.d.a, IType extends c.b.d.j1] */
    public IType p(int i) {
        f2<MType, BType, IType> f2Var;
        List<f2<MType, BType, IType>> list = this.f3834d;
        if (list == null || (f2Var = list.get(i)) == null) {
            return this.f3832b.get(i);
        }
        BType btype = f2Var.f3867b;
        return btype != 0 ? btype : f2Var.f3868c;
    }

    public List<IType> q() {
        if (this.h == null) {
            this.h = new c<>(this);
        }
        return this.h;
    }

    public final void r() {
        b<MType, BType, IType> bVar = this.f;
        if (bVar != null) {
            bVar.a();
        }
        a<MType, BType, IType> aVar = this.g;
        if (aVar != null) {
            aVar.a();
        }
        c<MType, BType, IType> cVar = this.h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public boolean s() {
        return this.f3832b.isEmpty();
    }

    public final void t() {
        a.b bVar;
        if (this.f3835e && (bVar = this.f3831a) != null) {
            bVar.a();
            this.f3835e = false;
        }
    }

    public void u(int i) {
        f2<MType, BType, IType> remove;
        j();
        this.f3832b.remove(i);
        List<f2<MType, BType, IType>> list = this.f3834d;
        if (!(list == null || (remove = list.remove(i)) == null)) {
            remove.f3866a = null;
        }
        t();
        r();
    }

    public b2<MType, BType, IType> v(int i, MType mtype) {
        f2<MType, BType, IType> f2Var;
        m0.a(mtype);
        j();
        this.f3832b.set(i, mtype);
        List<f2<MType, BType, IType>> list = this.f3834d;
        if (!(list == null || (f2Var = list.set(i, null)) == null)) {
            f2Var.f3866a = null;
        }
        t();
        r();
        return this;
    }
}
