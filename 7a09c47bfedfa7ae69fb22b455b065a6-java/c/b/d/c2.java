package c.b.d;

import c.b.d.a;
import c.b.d.a.AbstractC0106a;
import c.b.d.k1;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class c2<MType extends a, BType extends a.AbstractC0106a, IType extends k1> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public a.b f5234a;

    /* renamed from: b  reason: collision with root package name */
    public List<MType> f5235b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5236c;

    /* renamed from: d  reason: collision with root package name */
    public List<g2<MType, BType, IType>> f5237d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5238e;

    /* renamed from: f  reason: collision with root package name */
    public b<MType, BType, IType> f5239f;

    /* renamed from: g  reason: collision with root package name */
    public a<MType, BType, IType> f5240g;
    public c<MType, BType, IType> h;

    public static class a<MType extends a, BType extends a.AbstractC0106a, IType extends k1> extends AbstractList<BType> implements List<BType> {

        /* renamed from: b  reason: collision with root package name */
        public c2<MType, BType, IType> f5241b;

        public a(c2<MType, BType, IType> c2Var) {
            this.f5241b = c2Var;
        }

        public void a() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.List, java.util.AbstractList
        public Object get(int i) {
            return this.f5241b.k(i);
        }

        public int size() {
            return this.f5241b.m();
        }
    }

    public static class b<MType extends a, BType extends a.AbstractC0106a, IType extends k1> extends AbstractList<MType> implements List<MType> {

        /* renamed from: b  reason: collision with root package name */
        public c2<MType, BType, IType> f5242b;

        public b(c2<MType, BType, IType> c2Var) {
            this.f5242b = c2Var;
        }

        public void a() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.List, java.util.AbstractList
        public Object get(int i) {
            return this.f5242b.n(i, false);
        }

        public int size() {
            return this.f5242b.m();
        }
    }

    public static class c<MType extends a, BType extends a.AbstractC0106a, IType extends k1> extends AbstractList<IType> implements List<IType> {

        /* renamed from: b  reason: collision with root package name */
        public c2<MType, BType, IType> f5243b;

        public c(c2<MType, BType, IType> c2Var) {
            this.f5243b = c2Var;
        }

        public void a() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.List, java.util.AbstractList
        public Object get(int i) {
            return this.f5243b.p(i);
        }

        public int size() {
            return this.f5243b.m();
        }
    }

    public c2(List<MType> list, boolean z, a.b bVar, boolean z2) {
        this.f5235b = list;
        this.f5236c = z;
        this.f5234a = bVar;
        this.f5238e = z2;
    }

    @Override // c.b.d.a.b
    public void a() {
        t();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: c.b.d.c2<MType extends c.b.d.a, BType extends c.b.d.a$a, IType extends c.b.d.k1> */
    /* JADX WARN: Multi-variable type inference failed */
    public c2<MType, BType, IType> b(Iterable<? extends MType> iterable) {
        Iterator<? extends MType> it = iterable.iterator();
        while (it.hasNext()) {
            n0.a((a) it.next());
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
            List<MType> list = this.f5235b;
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
        g2<MType, BType, IType> g2Var = new g2<>(mtype, this, this.f5238e);
        this.f5235b.add(i, null);
        this.f5237d.add(i, g2Var);
        t();
        r();
        return g2Var.d();
    }

    public BType d(MType mtype) {
        j();
        i();
        g2<MType, BType, IType> g2Var = new g2<>(mtype, this, this.f5238e);
        this.f5235b.add(null);
        this.f5237d.add(g2Var);
        t();
        r();
        return g2Var.d();
    }

    public c2<MType, BType, IType> e(int i, MType mtype) {
        n0.a(mtype);
        j();
        this.f5235b.add(i, mtype);
        List<g2<MType, BType, IType>> list = this.f5237d;
        if (list != null) {
            list.add(i, null);
        }
        t();
        r();
        return this;
    }

    public c2<MType, BType, IType> f(MType mtype) {
        n0.a(mtype);
        j();
        this.f5235b.add(mtype);
        List<g2<MType, BType, IType>> list = this.f5237d;
        if (list != null) {
            list.add(null);
        }
        t();
        r();
        return this;
    }

    public List<MType> g() {
        boolean z;
        this.f5238e = true;
        if (!this.f5236c && this.f5237d == null) {
            return this.f5235b;
        }
        if (!this.f5236c) {
            int i = 0;
            while (true) {
                if (i >= this.f5235b.size()) {
                    z = true;
                    break;
                }
                MType mtype = this.f5235b.get(i);
                g2<MType, BType, IType> g2Var = this.f5237d.get(i);
                if (!(g2Var == null || g2Var.b() == mtype)) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                return this.f5235b;
            }
        }
        j();
        for (int i2 = 0; i2 < this.f5235b.size(); i2++) {
            this.f5235b.set(i2, n(i2, true));
        }
        List<MType> unmodifiableList = Collections.unmodifiableList(this.f5235b);
        this.f5235b = unmodifiableList;
        this.f5236c = false;
        return unmodifiableList;
    }

    public void h() {
        this.f5235b = Collections.emptyList();
        this.f5236c = false;
        List<g2<MType, BType, IType>> list = this.f5237d;
        if (list != null) {
            for (g2<MType, BType, IType> g2Var : list) {
                if (g2Var != null) {
                    g2Var.f5288a = null;
                }
            }
            this.f5237d = null;
        }
        t();
        r();
    }

    public final void i() {
        if (this.f5237d == null) {
            this.f5237d = new ArrayList(this.f5235b.size());
            for (int i = 0; i < this.f5235b.size(); i++) {
                this.f5237d.add(null);
            }
        }
    }

    public final void j() {
        if (!this.f5236c) {
            this.f5235b = new ArrayList(this.f5235b);
            this.f5236c = true;
        }
    }

    public BType k(int i) {
        i();
        g2<MType, BType, IType> g2Var = this.f5237d.get(i);
        if (g2Var == null) {
            g2<MType, BType, IType> g2Var2 = new g2<>(this.f5235b.get(i), this, this.f5238e);
            this.f5237d.set(i, g2Var2);
            g2Var = g2Var2;
        }
        return g2Var.d();
    }

    public List<BType> l() {
        if (this.f5240g == null) {
            this.f5240g = new a<>(this);
        }
        return this.f5240g;
    }

    public int m() {
        return this.f5235b.size();
    }

    public final MType n(int i, boolean z) {
        g2<MType, BType, IType> g2Var;
        List<g2<MType, BType, IType>> list = this.f5237d;
        return (list == null || (g2Var = list.get(i)) == null) ? this.f5235b.get(i) : z ? g2Var.b() : g2Var.e();
    }

    public List<MType> o() {
        if (this.f5239f == null) {
            this.f5239f = new b<>(this);
        }
        return this.f5239f;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [c.b.d.k1, IType extends c.b.d.k1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [BType extends c.b.d.a$a, IType extends c.b.d.k1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [MType extends c.b.d.a, IType extends c.b.d.k1] */
    public IType p(int i) {
        g2<MType, BType, IType> g2Var;
        List<g2<MType, BType, IType>> list = this.f5237d;
        if (list == null || (g2Var = list.get(i)) == null) {
            return this.f5235b.get(i);
        }
        BType btype = g2Var.f5289b;
        return btype != 0 ? btype : g2Var.f5290c;
    }

    public List<IType> q() {
        if (this.h == null) {
            this.h = new c<>(this);
        }
        return this.h;
    }

    public final void r() {
        b<MType, BType, IType> bVar = this.f5239f;
        if (bVar != null) {
            bVar.a();
        }
        a<MType, BType, IType> aVar = this.f5240g;
        if (aVar != null) {
            aVar.a();
        }
        c<MType, BType, IType> cVar = this.h;
        if (cVar != null) {
            cVar.a();
        }
    }

    public boolean s() {
        return this.f5235b.isEmpty();
    }

    public final void t() {
        a.b bVar;
        if (this.f5238e && (bVar = this.f5234a) != null) {
            bVar.a();
            this.f5238e = false;
        }
    }

    public void u(int i) {
        g2<MType, BType, IType> remove;
        j();
        this.f5235b.remove(i);
        List<g2<MType, BType, IType>> list = this.f5237d;
        if (!(list == null || (remove = list.remove(i)) == null)) {
            remove.f5288a = null;
        }
        t();
        r();
    }

    public c2<MType, BType, IType> v(int i, MType mtype) {
        g2<MType, BType, IType> g2Var;
        n0.a(mtype);
        j();
        this.f5235b.set(i, mtype);
        List<g2<MType, BType, IType>> list = this.f5237d;
        if (!(list == null || (g2Var = list.set(i, null)) == null)) {
            g2Var.f5288a = null;
        }
        t();
        r();
        return this;
    }
}
