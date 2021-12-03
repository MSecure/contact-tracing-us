package e.n.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment$5;
import e.i.i.v;
import e.n.a.a1;
import e.n.a.m;
import e.q.g0;
import e.q.h;
import e.q.h0;
import e.v.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class k0 {
    public final d0 a;
    public final l0 b;
    public final m c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1722d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f1723e = -1;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View b;

        public a(k0 k0Var, View view) {
            this.b = view;
        }

        public void onViewAttachedToWindow(View view) {
            this.b.removeOnAttachStateChangeListener(this);
            View view2 = this.b;
            AtomicInteger atomicInteger = v.a;
            v.h.c(view2);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public k0(d0 d0Var, l0 l0Var, m mVar) {
        this.a = d0Var;
        this.b = l0Var;
        this.c = mVar;
    }

    public k0(d0 d0Var, l0 l0Var, m mVar, j0 j0Var) {
        this.a = d0Var;
        this.b = l0Var;
        this.c = mVar;
        mVar.f1724d = null;
        mVar.f1725e = null;
        mVar.r = 0;
        mVar.o = false;
        mVar.f1732l = false;
        m mVar2 = mVar.f1728h;
        mVar.f1729i = mVar2 != null ? mVar2.f1726f : null;
        mVar.f1728h = null;
        Bundle bundle = j0Var.n;
        mVar.c = bundle == null ? new Bundle() : bundle;
    }

    public k0(d0 d0Var, l0 l0Var, ClassLoader classLoader, a0 a0Var, j0 j0Var) {
        this.a = d0Var;
        this.b = l0Var;
        m a2 = a0Var.a(classLoader, j0Var.b);
        this.c = a2;
        Bundle bundle = j0Var.f1720k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a2.y0(j0Var.f1720k);
        a2.f1726f = j0Var.c;
        a2.n = j0Var.f1713d;
        a2.p = true;
        a2.w = j0Var.f1714e;
        a2.x = j0Var.f1715f;
        a2.y = j0Var.f1716g;
        a2.B = j0Var.f1717h;
        a2.m = j0Var.f1718i;
        a2.A = j0Var.f1719j;
        a2.z = j0Var.f1721l;
        a2.N = h.b.values()[j0Var.m];
        Bundle bundle2 = j0Var.n;
        a2.c = bundle2 == null ? new Bundle() : bundle2;
        if (e0.O(2)) {
            String str = "Instantiated fragment " + a2;
        }
    }

    public void a() {
        if (e0.O(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto ACTIVITY_CREATED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        Bundle bundle = mVar.c;
        mVar.u.V();
        mVar.b = 3;
        mVar.D = false;
        mVar.K();
        if (mVar.D) {
            if (e0.O(3)) {
                String str = "moveto RESTORE_VIEW_STATE: " + mVar;
            }
            View view = mVar.F;
            if (view != null) {
                Bundle bundle2 = mVar.c;
                SparseArray<Parcelable> sparseArray = mVar.f1724d;
                if (sparseArray != null) {
                    view.restoreHierarchyState(sparseArray);
                    mVar.f1724d = null;
                }
                if (mVar.F != null) {
                    mVar.P.f1803f.a(mVar.f1725e);
                    mVar.f1725e = null;
                }
                mVar.D = false;
                mVar.l0(bundle2);
                if (!mVar.D) {
                    throw new c1(f.a.a.a.a.v("Fragment ", mVar, " did not call through to super.onViewStateRestored()"));
                } else if (mVar.F != null) {
                    mVar.P.b(h.a.ON_CREATE);
                }
            }
            mVar.c = null;
            e0 e0Var = mVar.u;
            e0Var.B = false;
            e0Var.C = false;
            e0Var.J.f1711h = false;
            e0Var.w(4);
            d0 d0Var = this.a;
            m mVar2 = this.c;
            d0Var.a(mVar2, mVar2.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.v("Fragment ", mVar, " did not call through to super.onActivityCreated()"));
    }

    public void b() {
        View view;
        View view2;
        l0 l0Var = this.b;
        m mVar = this.c;
        Objects.requireNonNull(l0Var);
        ViewGroup viewGroup = mVar.E;
        int i2 = -1;
        if (viewGroup != null) {
            int indexOf = l0Var.a.indexOf(mVar);
            int i3 = indexOf - 1;
            while (true) {
                if (i3 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= l0Var.a.size()) {
                            break;
                        }
                        m mVar2 = l0Var.a.get(indexOf);
                        if (mVar2.E == viewGroup && (view = mVar2.F) != null) {
                            i2 = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    m mVar3 = l0Var.a.get(i3);
                    if (mVar3.E == viewGroup && (view2 = mVar3.F) != null) {
                        i2 = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i3--;
                }
            }
        }
        m mVar4 = this.c;
        mVar4.E.addView(mVar4.F, i2);
    }

    public void c() {
        if (e0.O(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto ATTACHED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        m mVar2 = mVar.f1728h;
        k0 k0Var = null;
        if (mVar2 != null) {
            k0 h3 = this.b.h(mVar2.f1726f);
            if (h3 != null) {
                m mVar3 = this.c;
                mVar3.f1729i = mVar3.f1728h.f1726f;
                mVar3.f1728h = null;
                k0Var = h3;
            } else {
                StringBuilder h4 = f.a.a.a.a.h("Fragment ");
                h4.append(this.c);
                h4.append(" declared target fragment ");
                h4.append(this.c.f1728h);
                h4.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(h4.toString());
            }
        } else {
            String str = mVar.f1729i;
            if (str != null && (k0Var = this.b.h(str)) == null) {
                StringBuilder h5 = f.a.a.a.a.h("Fragment ");
                h5.append(this.c);
                h5.append(" declared target fragment ");
                throw new IllegalStateException(f.a.a.a.a.e(h5, this.c.f1729i, " that does not belong to this FragmentManager!"));
            }
        }
        if (k0Var != null) {
            k0Var.k();
        }
        m mVar4 = this.c;
        e0 e0Var = mVar4.s;
        mVar4.t = e0Var.q;
        mVar4.v = e0Var.s;
        this.a.g(mVar4, false);
        m mVar5 = this.c;
        Iterator<m.f> it = mVar5.U.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        mVar5.U.clear();
        mVar5.u.b(mVar5.t, mVar5.b(), mVar5);
        mVar5.b = 0;
        mVar5.D = false;
        mVar5.N(mVar5.t.c);
        if (mVar5.D) {
            e0 e0Var2 = mVar5.s;
            Iterator<i0> it2 = e0Var2.o.iterator();
            while (it2.hasNext()) {
                it2.next().b(e0Var2, mVar5);
            }
            e0 e0Var3 = mVar5.u;
            e0Var3.B = false;
            e0Var3.C = false;
            e0Var3.J.f1711h = false;
            e0Var3.w(0);
            this.a.b(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.v("Fragment ", mVar5, " did not call through to super.onAttach()"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [e.n.a.a1$d$b] */
    /* JADX WARN: Type inference failed for: r8v6, types: [e.n.a.a1$d$b] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public int d() {
        m mVar = this.c;
        if (mVar.s == null) {
            return mVar.b;
        }
        int i2 = this.f1723e;
        int ordinal = mVar.N.ordinal();
        if (ordinal == 1) {
            i2 = Math.min(i2, 0);
        } else if (ordinal == 2) {
            i2 = Math.min(i2, 1);
        } else if (ordinal == 3) {
            i2 = Math.min(i2, 5);
        } else if (ordinal != 4) {
            i2 = Math.min(i2, -1);
        }
        m mVar2 = this.c;
        if (mVar2.n) {
            if (mVar2.o) {
                i2 = Math.max(this.f1723e, 2);
                View view = this.c.F;
                if (view != null && view.getParent() == null) {
                    i2 = Math.min(i2, 2);
                }
            } else {
                i2 = this.f1723e < 4 ? Math.min(i2, mVar2.b) : Math.min(i2, 1);
            }
        }
        if (!this.c.f1732l) {
            i2 = Math.min(i2, 1);
        }
        m mVar3 = this.c;
        ViewGroup viewGroup = mVar3.E;
        a1.d dVar = null;
        if (viewGroup != null) {
            a1 g2 = a1.g(viewGroup, mVar3.v().M());
            Objects.requireNonNull(g2);
            a1.d d2 = g2.d(this.c);
            a1.d dVar2 = d2 != null ? d2.b : null;
            m mVar4 = this.c;
            Iterator<a1.d> it = g2.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a1.d next = it.next();
                if (next.c.equals(mVar4) && !next.f1663f) {
                    dVar = next;
                    break;
                }
            }
            dVar = (dVar == null || !(dVar2 == null || dVar2 == a1.d.b.NONE)) ? dVar2 : dVar.b;
        }
        if (dVar == a1.d.b.ADDING) {
            i2 = Math.min(i2, 6);
        } else if (dVar == a1.d.b.REMOVING) {
            i2 = Math.max(i2, 3);
        } else {
            m mVar5 = this.c;
            if (mVar5.m) {
                i2 = mVar5.H() ? Math.min(i2, 1) : Math.min(i2, -1);
            }
        }
        m mVar6 = this.c;
        if (mVar6.G && mVar6.b < 5) {
            i2 = Math.min(i2, 4);
        }
        if (e0.O(2)) {
            String str = "computeExpectedState() of " + i2 + " for " + this.c;
        }
        return i2;
    }

    public void e() {
        Parcelable parcelable;
        if (e0.O(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto CREATED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        if (!mVar.M) {
            this.a.h(mVar, mVar.c, false);
            m mVar2 = this.c;
            Bundle bundle = mVar2.c;
            mVar2.u.V();
            mVar2.b = 1;
            mVar2.D = false;
            mVar2.O.a(new Fragment$5(mVar2));
            mVar2.S.a(bundle);
            mVar2.Q(bundle);
            mVar2.M = true;
            if (mVar2.D) {
                mVar2.O.e(h.a.ON_CREATE);
                d0 d0Var = this.a;
                m mVar3 = this.c;
                d0Var.c(mVar3, mVar3.c, false);
                return;
            }
            throw new c1(f.a.a.a.a.v("Fragment ", mVar2, " did not call through to super.onCreate()"));
        }
        Bundle bundle2 = mVar.c;
        if (!(bundle2 == null || (parcelable = bundle2.getParcelable("android:support:fragments")) == null)) {
            mVar.u.d0(parcelable);
            mVar.u.m();
        }
        this.c.b = 1;
    }

    public void f() {
        String str;
        if (!this.c.n) {
            if (e0.O(3)) {
                StringBuilder h2 = f.a.a.a.a.h("moveto CREATE_VIEW: ");
                h2.append(this.c);
                h2.toString();
            }
            m mVar = this.c;
            LayoutInflater o0 = mVar.o0(mVar.c);
            ViewGroup viewGroup = null;
            m mVar2 = this.c;
            ViewGroup viewGroup2 = mVar2.E;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i2 = mVar2.x;
                if (i2 != 0) {
                    if (i2 != -1) {
                        viewGroup = (ViewGroup) mVar2.s.r.e(i2);
                        if (viewGroup == null) {
                            m mVar3 = this.c;
                            if (!mVar3.p) {
                                try {
                                    str = mVar3.A().getResourceName(this.c.x);
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
            m mVar4 = this.c;
            mVar4.E = viewGroup;
            mVar4.m0(o0, viewGroup, mVar4.c);
            View view = this.c.F;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                m mVar5 = this.c;
                mVar5.F.setTag(R$id.fragment_container_view_tag, mVar5);
                if (viewGroup != null) {
                    b();
                }
                m mVar6 = this.c;
                if (mVar6.z) {
                    mVar6.F.setVisibility(8);
                }
                View view2 = this.c.F;
                AtomicInteger atomicInteger = v.a;
                if (v.g.b(view2)) {
                    v.h.c(this.c.F);
                } else {
                    View view3 = this.c.F;
                    view3.addOnAttachStateChangeListener(new a(this, view3));
                }
                m mVar7 = this.c;
                mVar7.k0(mVar7.F, mVar7.c);
                mVar7.u.w(2);
                d0 d0Var = this.a;
                m mVar8 = this.c;
                d0Var.m(mVar8, mVar8.F, mVar8.c, false);
                int visibility = this.c.F.getVisibility();
                this.c.f().n = this.c.F.getAlpha();
                m mVar9 = this.c;
                if (mVar9.E != null && visibility == 0) {
                    View findFocus = mVar9.F.findFocus();
                    if (findFocus != null) {
                        this.c.f().o = findFocus;
                        if (e0.O(2)) {
                            String str2 = "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.c;
                        }
                    }
                    this.c.F.setAlpha(0.0f);
                }
            }
            this.c.b = 2;
        }
    }

    public void g() {
        m d2;
        if (e0.O(3)) {
            StringBuilder h2 = f.a.a.a.a.h("movefrom CREATED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        boolean z = true;
        boolean z2 = mVar.m && !mVar.H();
        if (z2 || this.b.c.d(this.c)) {
            b0<?> b0Var = this.c.t;
            if (b0Var instanceof h0) {
                z = this.b.c.f1710g;
            } else {
                Context context = b0Var.c;
                if (context instanceof Activity) {
                    z = true ^ ((Activity) context).isChangingConfigurations();
                }
            }
            if (z2 || z) {
                h0 h0Var = this.b.c;
                m mVar2 = this.c;
                Objects.requireNonNull(h0Var);
                if (e0.O(3)) {
                    String str = "Clearing non-config state for " + mVar2;
                }
                h0 h0Var2 = h0Var.f1707d.get(mVar2.f1726f);
                if (h0Var2 != null) {
                    h0Var2.a();
                    h0Var.f1707d.remove(mVar2.f1726f);
                }
                g0 g0Var = h0Var.f1708e.get(mVar2.f1726f);
                if (g0Var != null) {
                    g0Var.a();
                    h0Var.f1708e.remove(mVar2.f1726f);
                }
            }
            m mVar3 = this.c;
            mVar3.u.o();
            mVar3.O.e(h.a.ON_DESTROY);
            mVar3.b = 0;
            mVar3.D = false;
            mVar3.M = false;
            mVar3.U();
            if (mVar3.D) {
                this.a.d(this.c, false);
                Iterator it = ((ArrayList) this.b.f()).iterator();
                while (it.hasNext()) {
                    k0 k0Var = (k0) it.next();
                    if (k0Var != null) {
                        m mVar4 = k0Var.c;
                        if (this.c.f1726f.equals(mVar4.f1729i)) {
                            mVar4.f1728h = this.c;
                            mVar4.f1729i = null;
                        }
                    }
                }
                m mVar5 = this.c;
                String str2 = mVar5.f1729i;
                if (str2 != null) {
                    mVar5.f1728h = this.b.d(str2);
                }
                this.b.k(this);
                return;
            }
            throw new c1(f.a.a.a.a.v("Fragment ", mVar3, " did not call through to super.onDestroy()"));
        }
        String str3 = this.c.f1729i;
        if (!(str3 == null || (d2 = this.b.d(str3)) == null || !d2.B)) {
            this.c.f1728h = d2;
        }
        this.c.b = 0;
    }

    public void h() {
        View view;
        if (e0.O(3)) {
            StringBuilder h2 = f.a.a.a.a.h("movefrom CREATE_VIEW: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        ViewGroup viewGroup = mVar.E;
        if (!(viewGroup == null || (view = mVar.F) == null)) {
            viewGroup.removeView(view);
        }
        this.c.n0();
        this.a.n(this.c, false);
        m mVar2 = this.c;
        mVar2.E = null;
        mVar2.F = null;
        mVar2.P = null;
        mVar2.Q.l(null);
        this.c.o = false;
    }

    public void i() {
        if (e0.O(3)) {
            StringBuilder h2 = f.a.a.a.a.h("movefrom ATTACHED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        mVar.b = -1;
        mVar.D = false;
        mVar.W();
        mVar.L = null;
        if (mVar.D) {
            e0 e0Var = mVar.u;
            if (!e0Var.D) {
                e0Var.o();
                mVar.u = new f0();
            }
            this.a.e(this.c, false);
            m mVar2 = this.c;
            mVar2.b = -1;
            mVar2.t = null;
            mVar2.v = null;
            mVar2.s = null;
            if ((mVar2.m && !mVar2.H()) || this.b.c.d(this.c)) {
                if (e0.O(3)) {
                    StringBuilder h3 = f.a.a.a.a.h("initState called for fragment: ");
                    h3.append(this.c);
                    h3.toString();
                }
                m mVar3 = this.c;
                Objects.requireNonNull(mVar3);
                mVar3.O = new e.q.m(mVar3);
                mVar3.S = new b(mVar3);
                mVar3.R = null;
                mVar3.f1726f = UUID.randomUUID().toString();
                mVar3.f1732l = false;
                mVar3.m = false;
                mVar3.n = false;
                mVar3.o = false;
                mVar3.p = false;
                mVar3.r = 0;
                mVar3.s = null;
                mVar3.u = new f0();
                mVar3.t = null;
                mVar3.w = 0;
                mVar3.x = 0;
                mVar3.y = null;
                mVar3.z = false;
                mVar3.A = false;
                return;
            }
            return;
        }
        throw new c1(f.a.a.a.a.v("Fragment ", mVar, " did not call through to super.onDetach()"));
    }

    public void j() {
        m mVar = this.c;
        if (mVar.n && mVar.o && !mVar.q) {
            if (e0.O(3)) {
                StringBuilder h2 = f.a.a.a.a.h("moveto CREATE_VIEW: ");
                h2.append(this.c);
                h2.toString();
            }
            m mVar2 = this.c;
            mVar2.m0(mVar2.o0(mVar2.c), null, this.c.c);
            View view = this.c.F;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                m mVar3 = this.c;
                mVar3.F.setTag(R$id.fragment_container_view_tag, mVar3);
                m mVar4 = this.c;
                if (mVar4.z) {
                    mVar4.F.setVisibility(8);
                }
                m mVar5 = this.c;
                mVar5.k0(mVar5.F, mVar5.c);
                mVar5.u.w(2);
                d0 d0Var = this.a;
                m mVar6 = this.c;
                d0Var.m(mVar6, mVar6.F, mVar6.c, false);
                this.c.b = 2;
            }
        }
    }

    public void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        a1.d.b bVar = a1.d.b.NONE;
        if (!this.f1722d) {
            boolean z = false;
            boolean z2 = true;
            try {
                while (true) {
                    int d2 = d();
                    m mVar = this.c;
                    int i2 = mVar.b;
                    if (d2 == i2) {
                        if (mVar.J) {
                            if (!(mVar.F == null || (viewGroup = mVar.E) == null)) {
                                a1 g2 = a1.g(viewGroup, mVar.v().M());
                                if (this.c.z) {
                                    Objects.requireNonNull(g2);
                                    if (e0.O(2)) {
                                        String str = "SpecialEffectsController: Enqueuing hide operation for fragment " + this.c;
                                    }
                                    g2.a(a1.d.c.GONE, bVar, this);
                                } else {
                                    Objects.requireNonNull(g2);
                                    if (e0.O(2)) {
                                        String str2 = "SpecialEffectsController: Enqueuing show operation for fragment " + this.c;
                                    }
                                    g2.a(a1.d.c.VISIBLE, bVar, this);
                                }
                            }
                            m mVar2 = this.c;
                            e0 e0Var = mVar2.s;
                            if (e0Var != null && mVar2.f1732l && e0Var.P(mVar2)) {
                                e0Var.A = z2;
                            }
                            m mVar3 = this.c;
                            mVar3.J = z;
                            mVar3.Y();
                        }
                        this.f1722d = z;
                        return;
                    } else if (d2 > i2) {
                        switch (i2 + 1) {
                            case 0:
                                c();
                                continue;
                            case 1:
                                e();
                                continue;
                            case 2:
                                j();
                                f();
                                continue;
                            case 3:
                                a();
                                continue;
                            case 4:
                                if (!(mVar.F == null || (viewGroup3 = mVar.E) == null)) {
                                    a1 g3 = a1.g(viewGroup3, mVar.v().M());
                                    a1.d.c b2 = a1.d.c.b(this.c.F.getVisibility());
                                    Objects.requireNonNull(g3);
                                    if (e0.O(2)) {
                                        String str3 = "SpecialEffectsController: Enqueuing add operation for fragment " + this.c;
                                    }
                                    g3.a(b2, a1.d.b.ADDING, this);
                                }
                                this.c.b = 4;
                                continue;
                            case 5:
                                p();
                                continue;
                            case 6:
                                mVar.b = 6;
                                continue;
                            case 7:
                                n();
                                continue;
                            default:
                                continue;
                        }
                    } else {
                        switch (i2 - 1) {
                            case -1:
                                i();
                                continue;
                            case 0:
                                g();
                                continue;
                            case 1:
                                h();
                                this.c.b = z2 ? 1 : 0;
                                continue;
                            case 2:
                                mVar.o = z;
                                mVar.b = 2;
                                continue;
                            case 3:
                                if (e0.O(3)) {
                                    String str4 = "movefrom ACTIVITY_CREATED: " + this.c;
                                }
                                m mVar4 = this.c;
                                if (mVar4.F != null && mVar4.f1724d == null) {
                                    o();
                                }
                                m mVar5 = this.c;
                                if (!(mVar5.F == null || (viewGroup2 = mVar5.E) == null)) {
                                    a1 g4 = a1.g(viewGroup2, mVar5.v().M());
                                    Objects.requireNonNull(g4);
                                    if (e0.O(2)) {
                                        String str5 = "SpecialEffectsController: Enqueuing remove operation for fragment " + this.c;
                                    }
                                    g4.a(a1.d.c.REMOVED, a1.d.b.REMOVING, this);
                                }
                                this.c.b = 3;
                                continue;
                            case 4:
                                q();
                                continue;
                            case 5:
                                mVar.b = 5;
                                continue;
                            case 6:
                                l();
                                continue;
                            default:
                                continue;
                        }
                    }
                }
            } finally {
                this.f1722d = z;
            }
        } else if (e0.O(2)) {
            StringBuilder h2 = f.a.a.a.a.h("Ignoring re-entrant call to moveToExpectedState() for ");
            h2.append(this.c);
            h2.toString();
        }
    }

    public void l() {
        if (e0.O(3)) {
            StringBuilder h2 = f.a.a.a.a.h("movefrom RESUMED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        mVar.u.w(5);
        if (mVar.F != null) {
            mVar.P.b(h.a.ON_PAUSE);
        }
        mVar.O.e(h.a.ON_PAUSE);
        mVar.b = 6;
        mVar.D = false;
        mVar.c0();
        if (mVar.D) {
            this.a.f(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.v("Fragment ", mVar, " did not call through to super.onPause()"));
    }

    public void m(ClassLoader classLoader) {
        Bundle bundle = this.c.c;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            m mVar = this.c;
            mVar.f1724d = mVar.c.getSparseParcelableArray("android:view_state");
            m mVar2 = this.c;
            mVar2.f1725e = mVar2.c.getBundle("android:view_registry_state");
            m mVar3 = this.c;
            mVar3.f1729i = mVar3.c.getString("android:target_state");
            m mVar4 = this.c;
            if (mVar4.f1729i != null) {
                mVar4.f1730j = mVar4.c.getInt("android:target_req_state", 0);
            }
            m mVar5 = this.c;
            Objects.requireNonNull(mVar5);
            mVar5.H = mVar5.c.getBoolean("android:user_visible_hint", true);
            m mVar6 = this.c;
            if (!mVar6.H) {
                mVar6.G = true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
    public void n() {
        boolean z;
        if (e0.O(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto RESUMED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        m.d dVar = mVar.I;
        View view = dVar == null ? null : dVar.o;
        if (view != null) {
            if (view != mVar.F) {
                ViewParent parent = view.getParent();
                while (true) {
                    if (parent == null) {
                        z = false;
                        break;
                    } else if (parent == this.c.F) {
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (z) {
                    boolean requestFocus = view.requestFocus();
                    if (e0.O(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("requestFocus: Restoring focused view ");
                        sb.append(view);
                        sb.append(" ");
                        sb.append(requestFocus ? "succeeded" : "failed");
                        sb.append(" on Fragment ");
                        sb.append(this.c);
                        sb.append(" resulting in focused view ");
                        sb.append(this.c.F.findFocus());
                        sb.toString();
                    }
                }
            }
            z = true;
            if (z) {
            }
        }
        this.c.z0(null);
        m mVar2 = this.c;
        mVar2.u.V();
        mVar2.u.C(true);
        mVar2.b = 7;
        mVar2.D = false;
        mVar2.g0();
        if (mVar2.D) {
            e.q.m mVar3 = mVar2.O;
            h.a aVar = h.a.ON_RESUME;
            mVar3.e(aVar);
            if (mVar2.F != null) {
                mVar2.P.b(aVar);
            }
            e0 e0Var = mVar2.u;
            e0Var.B = false;
            e0Var.C = false;
            e0Var.J.f1711h = false;
            e0Var.w(7);
            this.a.i(this.c, false);
            m mVar4 = this.c;
            mVar4.c = null;
            mVar4.f1724d = null;
            mVar4.f1725e = null;
            return;
        }
        throw new c1(f.a.a.a.a.v("Fragment ", mVar2, " did not call through to super.onResume()"));
    }

    public void o() {
        if (this.c.F != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.c.F.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.c.f1724d = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.c.P.f1803f.b(bundle);
            if (!bundle.isEmpty()) {
                this.c.f1725e = bundle;
            }
        }
    }

    public void p() {
        if (e0.O(3)) {
            StringBuilder h2 = f.a.a.a.a.h("moveto STARTED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        mVar.u.V();
        mVar.u.C(true);
        mVar.b = 5;
        mVar.D = false;
        mVar.i0();
        if (mVar.D) {
            e.q.m mVar2 = mVar.O;
            h.a aVar = h.a.ON_START;
            mVar2.e(aVar);
            if (mVar.F != null) {
                mVar.P.b(aVar);
            }
            e0 e0Var = mVar.u;
            e0Var.B = false;
            e0Var.C = false;
            e0Var.J.f1711h = false;
            e0Var.w(5);
            this.a.k(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.v("Fragment ", mVar, " did not call through to super.onStart()"));
    }

    public void q() {
        if (e0.O(3)) {
            StringBuilder h2 = f.a.a.a.a.h("movefrom STARTED: ");
            h2.append(this.c);
            h2.toString();
        }
        m mVar = this.c;
        e0 e0Var = mVar.u;
        e0Var.C = true;
        e0Var.J.f1711h = true;
        e0Var.w(4);
        if (mVar.F != null) {
            mVar.P.b(h.a.ON_STOP);
        }
        mVar.O.e(h.a.ON_STOP);
        mVar.b = 4;
        mVar.D = false;
        mVar.j0();
        if (mVar.D) {
            this.a.l(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.v("Fragment ", mVar, " did not call through to super.onStop()"));
    }
}
