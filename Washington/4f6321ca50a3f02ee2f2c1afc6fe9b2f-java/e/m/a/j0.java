package e.m.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment$5;
import e.i.i.l;
import e.m.a.l;
import e.m.a.z0;
import e.p.c0;
import e.p.d0;
import e.p.g;
import e.p.k;
import e.u.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class j0 {
    public final b0 a;
    public final k0 b;
    public final l c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1612d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f1613e = -1;

    /* renamed from: f  reason: collision with root package name */
    public e.i.e.a f1614f;

    /* renamed from: g  reason: collision with root package name */
    public e.i.e.a f1615g;

    /* renamed from: h  reason: collision with root package name */
    public e.i.e.a f1616h;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View b;

        public a(j0 j0Var, View view) {
            this.b = view;
        }

        public void onViewAttachedToWindow(View view) {
            this.b.removeOnAttachStateChangeListener(this);
            View view2 = this.b;
            AtomicInteger atomicInteger = l.a;
            view2.requestApplyInsets();
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public j0(b0 b0Var, k0 k0Var, l lVar) {
        this.a = b0Var;
        this.b = k0Var;
        this.c = lVar;
    }

    public j0(b0 b0Var, k0 k0Var, l lVar, i0 i0Var) {
        this.a = b0Var;
        this.b = k0Var;
        this.c = lVar;
        lVar.f1617d = null;
        lVar.f1618e = null;
        lVar.r = 0;
        lVar.o = false;
        lVar.f1625l = false;
        l lVar2 = lVar.f1621h;
        lVar.f1622i = lVar2 != null ? lVar2.f1619f : null;
        lVar.f1621h = null;
        Bundle bundle = i0Var.n;
        lVar.c = bundle == null ? new Bundle() : bundle;
    }

    public j0(b0 b0Var, k0 k0Var, ClassLoader classLoader, y yVar, i0 i0Var) {
        this.a = b0Var;
        this.b = k0Var;
        l a2 = yVar.a(classLoader, i0Var.b);
        this.c = a2;
        Bundle bundle = i0Var.f1610k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a2.s0(i0Var.f1610k);
        a2.f1619f = i0Var.c;
        a2.n = i0Var.f1603d;
        a2.p = true;
        a2.w = i0Var.f1604e;
        a2.x = i0Var.f1605f;
        a2.y = i0Var.f1606g;
        a2.B = i0Var.f1607h;
        a2.m = i0Var.f1608i;
        a2.A = i0Var.f1609j;
        a2.z = i0Var.f1611l;
        a2.O = g.b.values()[i0Var.m];
        Bundle bundle2 = i0Var.n;
        a2.c = bundle2 == null ? new Bundle() : bundle2;
        if (c0.Q(2)) {
            String str = "Instantiated fragment " + a2;
        }
    }

    public void a() {
        if (c0.Q(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto ACTIVITY_CREATED: ");
            h2.append(this.c);
            h2.toString();
        }
        l lVar = this.c;
        Bundle bundle = lVar.c;
        lVar.u.Z();
        lVar.b = 3;
        lVar.D = false;
        lVar.H();
        if (lVar.D) {
            if (c0.Q(3)) {
                String str = "moveto RESTORE_VIEW_STATE: " + lVar;
            }
            View view = lVar.F;
            if (view != null) {
                Bundle bundle2 = lVar.c;
                SparseArray<Parcelable> sparseArray = lVar.f1617d;
                if (sparseArray != null) {
                    view.restoreHierarchyState(sparseArray);
                    lVar.f1617d = null;
                }
                if (lVar.F != null) {
                    lVar.Q.c.a(lVar.f1618e);
                    lVar.f1618e = null;
                }
                lVar.D = false;
                lVar.h0(bundle2);
                if (!lVar.D) {
                    throw new c1(f.a.a.a.a.s("Fragment ", lVar, " did not call through to super.onViewStateRestored()"));
                } else if (lVar.F != null) {
                    lVar.Q.d(g.a.ON_CREATE);
                }
            }
            lVar.c = null;
            c0 c0Var = lVar.u;
            c0Var.B = false;
            c0Var.C = false;
            c0Var.J.f1599h = false;
            c0Var.x(4);
            b0 b0Var = this.a;
            l lVar2 = this.c;
            b0Var.a(lVar2, lVar2.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.s("Fragment ", lVar, " did not call through to super.onActivityCreated()"));
    }

    public void b() {
        if (c0.Q(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto ATTACHED: ");
            h2.append(this.c);
            h2.toString();
        }
        l lVar = this.c;
        l lVar2 = lVar.f1621h;
        j0 j0Var = null;
        if (lVar2 != null) {
            j0 i2 = this.b.i(lVar2.f1619f);
            if (i2 != null) {
                l lVar3 = this.c;
                lVar3.f1622i = lVar3.f1621h.f1619f;
                lVar3.f1621h = null;
                j0Var = i2;
            } else {
                StringBuilder h3 = f.a.a.a.a.h("Fragment ");
                h3.append(this.c);
                h3.append(" declared target fragment ");
                h3.append(this.c.f1621h);
                h3.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(h3.toString());
            }
        } else {
            String str = lVar.f1622i;
            if (str != null && (j0Var = this.b.i(str)) == null) {
                StringBuilder h4 = f.a.a.a.a.h("Fragment ");
                h4.append(this.c);
                h4.append(" declared target fragment ");
                throw new IllegalStateException(f.a.a.a.a.e(h4, this.c.f1622i, " that does not belong to this FragmentManager!"));
            }
        }
        if (j0Var != null && (c0.L || j0Var.c.b < 1)) {
            j0Var.j();
        }
        l lVar4 = this.c;
        c0 c0Var = lVar4.s;
        lVar4.t = c0Var.q;
        lVar4.v = c0Var.s;
        this.a.g(lVar4, false);
        l lVar5 = this.c;
        Iterator<l.d> it = lVar5.U.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        lVar5.U.clear();
        lVar5.u.c(lVar5.t, lVar5.e(), lVar5);
        lVar5.b = 0;
        lVar5.D = false;
        lVar5.K(lVar5.t.c);
        if (lVar5.D) {
            c0 c0Var2 = lVar5.s;
            Iterator<h0> it2 = c0Var2.o.iterator();
            while (it2.hasNext()) {
                it2.next().d(c0Var2, lVar5);
            }
            c0 c0Var3 = lVar5.u;
            c0Var3.B = false;
            c0Var3.C = false;
            c0Var3.J.f1599h = false;
            c0Var3.x(0);
            this.a.b(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.s("Fragment ", lVar5, " did not call through to super.onAttach()"));
    }

    public int c() {
        l lVar;
        ViewGroup viewGroup;
        z0.d dVar;
        l lVar2 = this.c;
        if (lVar2.s == null) {
            return lVar2.b;
        }
        int i2 = this.f1613e;
        if (lVar2.n) {
            i2 = lVar2.o ? Math.max(i2, 2) : i2 < 4 ? Math.min(i2, lVar2.b) : Math.min(i2, 1);
        }
        if (!this.c.f1625l) {
            i2 = Math.min(i2, 1);
        }
        z0.d.b bVar = null;
        if (c0.L && (viewGroup = (lVar = this.c).E) != null && (dVar = z0.e(viewGroup, lVar.t().O()).c.get(this.c)) != null && !dVar.f1697d.b()) {
            bVar = dVar.b;
        }
        if (bVar == z0.d.b.ADDING) {
            i2 = Math.min(i2, 6);
        } else if (bVar == z0.d.b.REMOVING) {
            i2 = Math.max(i2, 3);
        } else {
            l lVar3 = this.c;
            if (lVar3.m) {
                i2 = lVar3.E() ? Math.min(i2, 1) : Math.min(i2, -1);
            }
        }
        l lVar4 = this.c;
        if (lVar4.G && lVar4.b < 5) {
            i2 = Math.min(i2, 4);
        }
        int ordinal = this.c.O.ordinal();
        if (ordinal == 2) {
            return Math.min(i2, 1);
        }
        if (ordinal != 3) {
            return ordinal != 4 ? Math.min(i2, -1) : i2;
        }
        return Math.min(i2, 5);
    }

    public void d() {
        if (c0.Q(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto CREATED: ");
            h2.append(this.c);
            h2.toString();
        }
        l lVar = this.c;
        if (!lVar.N) {
            this.a.h(lVar, lVar.c, false);
            l lVar2 = this.c;
            Bundle bundle = lVar2.c;
            lVar2.u.Z();
            lVar2.b = 1;
            lVar2.D = false;
            lVar2.P.a(new Fragment$5(lVar2));
            lVar2.T.a(bundle);
            lVar2.N(bundle);
            lVar2.N = true;
            if (lVar2.D) {
                lVar2.P.e(g.a.ON_CREATE);
                b0 b0Var = this.a;
                l lVar3 = this.c;
                b0Var.c(lVar3, lVar3.c, false);
                return;
            }
            throw new c1(f.a.a.a.a.s("Fragment ", lVar2, " did not call through to super.onCreate()"));
        }
        lVar.p0(lVar.c);
        this.c.b = 1;
    }

    public void e() {
        String str;
        if (!this.c.n) {
            if (c0.Q(3)) {
                StringBuilder h2 = f.a.a.a.a.h("moveto CREATE_VIEW: ");
                h2.append(this.c);
                h2.toString();
            }
            l lVar = this.c;
            LayoutInflater T = lVar.T(lVar.c);
            lVar.M = T;
            ViewGroup viewGroup = null;
            l lVar2 = this.c;
            ViewGroup viewGroup2 = lVar2.E;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i2 = lVar2.x;
                if (i2 != 0) {
                    if (i2 != -1) {
                        viewGroup = (ViewGroup) lVar2.s.r.f(i2);
                        if (viewGroup == null) {
                            l lVar3 = this.c;
                            if (!lVar3.p) {
                                try {
                                    str = lVar3.v().getResourceName(this.c.x);
                                } catch (Resources.NotFoundException unused) {
                                    str = "unknown";
                                }
                                StringBuilder h3 = f.a.a.a.a.h("No view found for id 0x");
                                h3.append(Integer.toHexString(this.c.x));
                                h3.append(" (");
                                h3.append(str);
                                h3.append(") for fragment ");
                                h3.append(this.c);
                                throw new IllegalArgumentException(h3.toString());
                            }
                        }
                    } else {
                        StringBuilder h4 = f.a.a.a.a.h("Cannot create fragment ");
                        h4.append(this.c);
                        h4.append(" for a container view with no id");
                        throw new IllegalArgumentException(h4.toString());
                    }
                }
            }
            l lVar4 = this.c;
            lVar4.E = viewGroup;
            lVar4.i0(T, viewGroup, lVar4.c);
            View view = this.c.F;
            if (view != null) {
                boolean z = false;
                view.setSaveFromParentEnabled(false);
                l lVar5 = this.c;
                lVar5.F.setTag(R$id.fragment_container_view_tag, lVar5);
                if (viewGroup != null) {
                    viewGroup.addView(this.c.F, this.b.f(this.c));
                }
                l lVar6 = this.c;
                if (lVar6.z) {
                    lVar6.F.setVisibility(8);
                }
                View view2 = this.c.F;
                AtomicInteger atomicInteger = e.i.i.l.a;
                if (view2.isAttachedToWindow()) {
                    this.c.F.requestApplyInsets();
                } else {
                    View view3 = this.c.F;
                    view3.addOnAttachStateChangeListener(new a(this, view3));
                }
                l lVar7 = this.c;
                lVar7.g0(lVar7.F, lVar7.c);
                lVar7.u.x(2);
                b0 b0Var = this.a;
                l lVar8 = this.c;
                b0Var.m(lVar8, lVar8.F, lVar8.c, false);
                int visibility = this.c.F.getVisibility();
                if (c0.L) {
                    this.c.f().f1632j = visibility;
                    l lVar9 = this.c;
                    if (lVar9.E != null && visibility == 0) {
                        lVar9.f().f1633k = lVar9.F.findFocus();
                        this.c.F.setVisibility(4);
                    }
                } else {
                    l lVar10 = this.c;
                    if (visibility == 0 && lVar10.E != null) {
                        z = true;
                    }
                    lVar10.J = z;
                }
            }
            this.c.b = 2;
        }
    }

    public void f() {
        l d2;
        boolean z;
        if (c0.Q(3)) {
            StringBuilder h2 = f.a.a.a.a.h("movefrom CREATED: ");
            h2.append(this.c);
            h2.toString();
        }
        l lVar = this.c;
        boolean z2 = lVar.m && !lVar.E();
        if (z2 || this.b.c.d(this.c)) {
            z<?> zVar = this.c.t;
            if (zVar instanceof d0) {
                z = this.b.c.f1598g;
            } else {
                Context context = zVar.c;
                z = context instanceof Activity ? !((Activity) context).isChangingConfigurations() : true;
            }
            if (z2 || z) {
                g0 g0Var = this.b.c;
                l lVar2 = this.c;
                Objects.requireNonNull(g0Var);
                if (c0.Q(3)) {
                    String str = "Clearing non-config state for " + lVar2;
                }
                g0 g0Var2 = g0Var.f1595d.get(lVar2.f1619f);
                if (g0Var2 != null) {
                    g0Var2.a();
                    g0Var.f1595d.remove(lVar2.f1619f);
                }
                c0 c0Var = g0Var.f1596e.get(lVar2.f1619f);
                if (c0Var != null) {
                    c0Var.a();
                    g0Var.f1596e.remove(lVar2.f1619f);
                }
            }
            l lVar3 = this.c;
            lVar3.u.p();
            lVar3.P.e(g.a.ON_DESTROY);
            lVar3.b = 0;
            lVar3.D = false;
            lVar3.N = false;
            lVar3.D = true;
            this.a.d(this.c, false);
            Iterator it = ((ArrayList) this.b.g()).iterator();
            while (it.hasNext()) {
                j0 j0Var = (j0) it.next();
                if (j0Var != null) {
                    l lVar4 = j0Var.c;
                    if (this.c.f1619f.equals(lVar4.f1622i)) {
                        lVar4.f1621h = this.c;
                        lVar4.f1622i = null;
                    }
                }
            }
            l lVar5 = this.c;
            String str2 = lVar5.f1622i;
            if (str2 != null) {
                lVar5.f1621h = this.b.d(str2);
            }
            this.b.l(this);
            return;
        }
        String str3 = this.c.f1622i;
        if (!(str3 == null || (d2 = this.b.d(str3)) == null || !d2.B)) {
            this.c.f1621h = d2;
        }
        this.c.b = 0;
    }

    public void g() {
        this.c.j0();
        this.a.n(this.c, false);
        l lVar = this.c;
        lVar.E = null;
        lVar.F = null;
        lVar.Q = null;
        lVar.R.l(null);
        this.c.o = false;
    }

    public void h() {
        if (c0.Q(3)) {
            StringBuilder h2 = f.a.a.a.a.h("movefrom ATTACHED: ");
            h2.append(this.c);
            h2.toString();
        }
        l lVar = this.c;
        lVar.b = -1;
        lVar.D = false;
        lVar.S();
        lVar.M = null;
        if (lVar.D) {
            c0 c0Var = lVar.u;
            if (!c0Var.D) {
                c0Var.p();
                lVar.u = new e0();
            }
            this.a.e(this.c, false);
            l lVar2 = this.c;
            lVar2.b = -1;
            lVar2.t = null;
            lVar2.v = null;
            lVar2.s = null;
            if ((lVar2.m && !lVar2.E()) || this.b.c.d(this.c)) {
                if (c0.Q(3)) {
                    StringBuilder h3 = f.a.a.a.a.h("initState called for fragment: ");
                    h3.append(this.c);
                    h3.toString();
                }
                l lVar3 = this.c;
                Objects.requireNonNull(lVar3);
                lVar3.P = new k(lVar3);
                lVar3.T = new b(lVar3);
                lVar3.f1619f = UUID.randomUUID().toString();
                lVar3.f1625l = false;
                lVar3.m = false;
                lVar3.n = false;
                lVar3.o = false;
                lVar3.p = false;
                lVar3.r = 0;
                lVar3.s = null;
                lVar3.u = new e0();
                lVar3.t = null;
                lVar3.w = 0;
                lVar3.x = 0;
                lVar3.y = null;
                lVar3.z = false;
                lVar3.A = false;
                return;
            }
            return;
        }
        throw new c1(f.a.a.a.a.s("Fragment ", lVar, " did not call through to super.onDetach()"));
    }

    public void i() {
        l lVar = this.c;
        if (lVar.n && lVar.o && !lVar.q) {
            if (c0.Q(3)) {
                StringBuilder h2 = f.a.a.a.a.h("moveto CREATE_VIEW: ");
                h2.append(this.c);
                h2.toString();
            }
            l lVar2 = this.c;
            LayoutInflater T = lVar2.T(lVar2.c);
            lVar2.M = T;
            lVar2.i0(T, null, this.c.c);
            View view = this.c.F;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                l lVar3 = this.c;
                lVar3.F.setTag(R$id.fragment_container_view_tag, lVar3);
                l lVar4 = this.c;
                if (lVar4.z) {
                    lVar4.F.setVisibility(8);
                }
                l lVar5 = this.c;
                lVar5.g0(lVar5.F, lVar5.c);
                lVar5.u.x(2);
                b0 b0Var = this.a;
                l lVar6 = this.c;
                b0Var.m(lVar6, lVar6.F, lVar6.c, false);
                this.c.b = 2;
            }
        }
    }

    public void j() {
        ViewGroup viewGroup;
        z0.d.b bVar = z0.d.b.NONE;
        if (!this.f1612d) {
            boolean z = false;
            boolean z2 = true;
            try {
                while (true) {
                    int c2 = c();
                    l lVar = this.c;
                    int i2 = lVar.b;
                    if (c2 == i2) {
                        if (c0.L && lVar.K) {
                            if (!(lVar.F == null || lVar.E == null)) {
                                e.i.e.a aVar = this.f1615g;
                                if (aVar != null) {
                                    aVar.a();
                                }
                                l lVar2 = this.c;
                                z0 e2 = z0.e(lVar2.E, lVar2.t().O());
                                e.i.e.a aVar2 = new e.i.e.a();
                                this.f1615g = aVar2;
                                if (this.c.z) {
                                    e2.a(z0.d.c.GONE, bVar, this, aVar2);
                                } else {
                                    e2.a(z0.d.c.VISIBLE, bVar, this, aVar2);
                                }
                            }
                            l lVar3 = this.c;
                            lVar3.K = z;
                            boolean z3 = lVar3.z;
                            lVar3.U();
                        }
                        this.f1612d = z;
                        return;
                    } else if (c2 > i2) {
                        int i3 = i2 + 1;
                        e.i.e.a aVar3 = this.f1616h;
                        if (aVar3 != null) {
                            aVar3.a();
                        }
                        switch (i3) {
                            case 0:
                                b();
                                continue;
                            case 1:
                                d();
                                continue;
                            case 2:
                                i();
                                e();
                                continue;
                            case 3:
                                a();
                                continue;
                            case 4:
                                l lVar4 = this.c;
                                View view = lVar4.F;
                                if (!(view == null || lVar4.E == null)) {
                                    if (view.getParent() == null) {
                                        int f2 = this.b.f(this.c);
                                        l lVar5 = this.c;
                                        lVar5.E.addView(lVar5.F, f2);
                                    }
                                    l lVar6 = this.c;
                                    z0 e3 = z0.e(lVar6.E, lVar6.t().O());
                                    e.i.e.a aVar4 = this.f1615g;
                                    if (aVar4 != null) {
                                        aVar4.a();
                                    }
                                    this.f1614f = new e.i.e.a();
                                    l.b bVar2 = this.c.I;
                                    e3.a(z0.d.c.b(bVar2 == null ? 0 : bVar2.f1632j), z0.d.b.ADDING, this, this.f1614f);
                                }
                                this.c.b = 4;
                                continue;
                            case 5:
                                p();
                                continue;
                            case 6:
                                this.c.b = 6;
                                continue;
                            case 7:
                                m();
                                continue;
                            default:
                                continue;
                        }
                    } else {
                        int i4 = i2 - 1;
                        e.i.e.a aVar5 = this.f1614f;
                        if (aVar5 != null) {
                            aVar5.a();
                        }
                        switch (i4) {
                            case -1:
                                h();
                                continue;
                            case 0:
                                f();
                                continue;
                            case 1:
                                this.c.b = z2 ? 1 : 0;
                                continue;
                            case 2:
                                g();
                                this.c.b = 2;
                                continue;
                            case 3:
                                if (c0.Q(3)) {
                                    String str = "movefrom ACTIVITY_CREATED: " + this.c;
                                }
                                l lVar7 = this.c;
                                if (lVar7.F != null && lVar7.f1617d == null) {
                                    o();
                                }
                                l lVar8 = this.c;
                                if (!(lVar8.F == null || (viewGroup = lVar8.E) == null || this.f1613e <= -1)) {
                                    z0 e4 = z0.e(viewGroup, lVar8.t().O());
                                    e.i.e.a aVar6 = this.f1615g;
                                    if (aVar6 != null) {
                                        aVar6.a();
                                    }
                                    e.i.e.a aVar7 = new e.i.e.a();
                                    this.f1616h = aVar7;
                                    e4.a(z0.d.c.REMOVED, z0.d.b.REMOVING, this, aVar7);
                                }
                                this.c.b = 3;
                                continue;
                            case 4:
                                q();
                                continue;
                            case 5:
                                this.c.b = 5;
                                continue;
                            case 6:
                                k();
                                continue;
                            default:
                                continue;
                        }
                    }
                }
            } finally {
                this.f1612d = z;
            }
        } else if (c0.Q(2)) {
            StringBuilder h2 = f.a.a.a.a.h("Ignoring re-entrant call to moveToExpectedState() for ");
            h2.append(this.c);
            h2.toString();
        }
    }

    public void k() {
        if (c0.Q(3)) {
            StringBuilder h2 = f.a.a.a.a.h("movefrom RESUMED: ");
            h2.append(this.c);
            h2.toString();
        }
        l lVar = this.c;
        lVar.u.x(5);
        if (lVar.F != null) {
            lVar.Q.d(g.a.ON_PAUSE);
        }
        lVar.P.e(g.a.ON_PAUSE);
        lVar.b = 6;
        lVar.D = false;
        lVar.Y();
        if (lVar.D) {
            this.a.f(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.s("Fragment ", lVar, " did not call through to super.onPause()"));
    }

    public void l(ClassLoader classLoader) {
        Bundle bundle = this.c.c;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            l lVar = this.c;
            lVar.f1617d = lVar.c.getSparseParcelableArray("android:view_state");
            l lVar2 = this.c;
            lVar2.f1618e = lVar2.c.getBundle("android:view_registry_state");
            l lVar3 = this.c;
            lVar3.f1622i = lVar3.c.getString("android:target_state");
            l lVar4 = this.c;
            if (lVar4.f1622i != null) {
                lVar4.f1623j = lVar4.c.getInt("android:target_req_state", 0);
            }
            l lVar5 = this.c;
            Objects.requireNonNull(lVar5);
            lVar5.H = lVar5.c.getBoolean("android:user_visible_hint", true);
            l lVar6 = this.c;
            if (!lVar6.H) {
                lVar6.G = true;
            }
        }
    }

    public void m() {
        if (c0.Q(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto RESUMED: ");
            h2.append(this.c);
            h2.toString();
        }
        l lVar = this.c;
        lVar.u.Z();
        lVar.u.D(true);
        lVar.b = 7;
        lVar.D = false;
        lVar.c0();
        if (lVar.D) {
            k kVar = lVar.P;
            g.a aVar = g.a.ON_RESUME;
            kVar.e(aVar);
            if (lVar.F != null) {
                lVar.Q.d(aVar);
            }
            c0 c0Var = lVar.u;
            c0Var.B = false;
            c0Var.C = false;
            c0Var.J.f1599h = false;
            c0Var.x(7);
            this.a.i(this.c, false);
            l lVar2 = this.c;
            lVar2.c = null;
            lVar2.f1617d = null;
            lVar2.f1618e = null;
            return;
        }
        throw new c1(f.a.a.a.a.s("Fragment ", lVar, " did not call through to super.onResume()"));
    }

    public final Bundle n() {
        Bundle bundle = new Bundle();
        l lVar = this.c;
        lVar.d0(bundle);
        lVar.T.b(bundle);
        Parcelable h0 = lVar.u.h0();
        if (h0 != null) {
            bundle.putParcelable("android:support:fragments", h0);
        }
        this.a.j(this.c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.c.F != null) {
            o();
        }
        if (this.c.f1617d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.c.f1617d);
        }
        if (this.c.f1618e != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.c.f1618e);
        }
        if (!this.c.H) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.c.H);
        }
        return bundle;
    }

    public void o() {
        if (this.c.F != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.c.F.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.c.f1617d = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.c.Q.c.b(bundle);
            if (!bundle.isEmpty()) {
                this.c.f1618e = bundle;
            }
        }
    }

    public void p() {
        if (c0.Q(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto STARTED: ");
            h2.append(this.c);
            h2.toString();
        }
        l lVar = this.c;
        lVar.u.Z();
        lVar.u.D(true);
        lVar.b = 5;
        lVar.D = false;
        lVar.e0();
        if (lVar.D) {
            k kVar = lVar.P;
            g.a aVar = g.a.ON_START;
            kVar.e(aVar);
            if (lVar.F != null) {
                lVar.Q.d(aVar);
            }
            c0 c0Var = lVar.u;
            c0Var.B = false;
            c0Var.C = false;
            c0Var.J.f1599h = false;
            c0Var.x(5);
            this.a.k(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.s("Fragment ", lVar, " did not call through to super.onStart()"));
    }

    public void q() {
        if (c0.Q(3)) {
            StringBuilder h2 = f.a.a.a.a.h("movefrom STARTED: ");
            h2.append(this.c);
            h2.toString();
        }
        l lVar = this.c;
        c0 c0Var = lVar.u;
        c0Var.C = true;
        c0Var.J.f1599h = true;
        c0Var.x(4);
        if (lVar.F != null) {
            lVar.Q.d(g.a.ON_STOP);
        }
        lVar.P.e(g.a.ON_STOP);
        lVar.b = 4;
        lVar.D = false;
        lVar.f0();
        if (lVar.D) {
            this.a.l(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.s("Fragment ", lVar, " did not call through to super.onStop()"));
    }
}
