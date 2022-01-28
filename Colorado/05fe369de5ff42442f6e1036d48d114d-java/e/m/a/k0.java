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
import android.view.ViewParent;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment$5;
import e.i.i.m;
import e.m.a.a1;
import e.m.a.m;
import e.p.g0;
import e.p.h;
import e.p.h0;
import e.u.b;
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
    public boolean f1449d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f1450e = -1;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View b;

        public a(k0 k0Var, View view) {
            this.b = view;
        }

        public void onViewAttachedToWindow(View view) {
            this.b.removeOnAttachStateChangeListener(this);
            View view2 = this.b;
            AtomicInteger atomicInteger = m.a;
            view2.requestApplyInsets();
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
        mVar.f1451d = null;
        mVar.f1452e = null;
        mVar.r = 0;
        mVar.o = false;
        mVar.f1459l = false;
        m mVar2 = mVar.f1455h;
        mVar.f1456i = mVar2 != null ? mVar2.f1453f : null;
        mVar.f1455h = null;
        Bundle bundle = j0Var.n;
        mVar.c = bundle == null ? new Bundle() : bundle;
    }

    public k0(d0 d0Var, l0 l0Var, ClassLoader classLoader, a0 a0Var, j0 j0Var) {
        this.a = d0Var;
        this.b = l0Var;
        m a2 = a0Var.a(classLoader, j0Var.b);
        this.c = a2;
        Bundle bundle = j0Var.f1447k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a2.t0(j0Var.f1447k);
        a2.f1453f = j0Var.c;
        a2.n = j0Var.f1440d;
        a2.p = true;
        a2.w = j0Var.f1441e;
        a2.x = j0Var.f1442f;
        a2.y = j0Var.f1443g;
        a2.B = j0Var.f1444h;
        a2.m = j0Var.f1445i;
        a2.A = j0Var.f1446j;
        a2.z = j0Var.f1448l;
        a2.N = h.b.values()[j0Var.m];
        Bundle bundle2 = j0Var.n;
        a2.c = bundle2 == null ? new Bundle() : bundle2;
        if (e0.O(2)) {
            String str = "Instantiated fragment " + a2;
        }
    }

    public void a() {
        if (e0.O(3)) {
            StringBuilder i2 = f.a.a.a.a.i("moveto ACTIVITY_CREATED: ");
            i2.append(this.c);
            i2.toString();
        }
        m mVar = this.c;
        Bundle bundle = mVar.c;
        mVar.u.V();
        mVar.b = 3;
        mVar.D = false;
        mVar.G();
        if (mVar.D) {
            if (e0.O(3)) {
                String str = "moveto RESTORE_VIEW_STATE: " + mVar;
            }
            View view = mVar.F;
            if (view != null) {
                Bundle bundle2 = mVar.c;
                SparseArray<Parcelable> sparseArray = mVar.f1451d;
                if (sparseArray != null) {
                    view.restoreHierarchyState(sparseArray);
                    mVar.f1451d = null;
                }
                if (mVar.F != null) {
                    mVar.P.c.a(mVar.f1452e);
                    mVar.f1452e = null;
                }
                mVar.D = false;
                mVar.h0(bundle2);
                if (!mVar.D) {
                    throw new c1(f.a.a.a.a.x("Fragment ", mVar, " did not call through to super.onViewStateRestored()"));
                } else if (mVar.F != null) {
                    mVar.P.b(h.a.ON_CREATE);
                }
            }
            mVar.c = null;
            e0 e0Var = mVar.u;
            e0Var.B = false;
            e0Var.C = false;
            e0Var.J.f1438h = false;
            e0Var.w(4);
            d0 d0Var = this.a;
            m mVar2 = this.c;
            d0Var.a(mVar2, mVar2.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.x("Fragment ", mVar, " did not call through to super.onActivityCreated()"));
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
            StringBuilder i2 = f.a.a.a.a.i("moveto ATTACHED: ");
            i2.append(this.c);
            i2.toString();
        }
        m mVar = this.c;
        m mVar2 = mVar.f1455h;
        k0 k0Var = null;
        if (mVar2 != null) {
            k0 h2 = this.b.h(mVar2.f1453f);
            if (h2 != null) {
                m mVar3 = this.c;
                mVar3.f1456i = mVar3.f1455h.f1453f;
                mVar3.f1455h = null;
                k0Var = h2;
            } else {
                StringBuilder i3 = f.a.a.a.a.i("Fragment ");
                i3.append(this.c);
                i3.append(" declared target fragment ");
                i3.append(this.c.f1455h);
                i3.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(i3.toString());
            }
        } else {
            String str = mVar.f1456i;
            if (str != null && (k0Var = this.b.h(str)) == null) {
                StringBuilder i4 = f.a.a.a.a.i("Fragment ");
                i4.append(this.c);
                i4.append(" declared target fragment ");
                throw new IllegalStateException(f.a.a.a.a.f(i4, this.c.f1456i, " that does not belong to this FragmentManager!"));
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
        mVar5.J(mVar5.t.c);
        if (mVar5.D) {
            e0 e0Var2 = mVar5.s;
            Iterator<i0> it2 = e0Var2.o.iterator();
            while (it2.hasNext()) {
                it2.next().b(e0Var2, mVar5);
            }
            e0 e0Var3 = mVar5.u;
            e0Var3.B = false;
            e0Var3.C = false;
            e0Var3.J.f1438h = false;
            e0Var3.w(0);
            this.a.b(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.x("Fragment ", mVar5, " did not call through to super.onAttach()"));
    }

    public int d() {
        a1.d dVar;
        a1.d.b bVar;
        m mVar = this.c;
        if (mVar.s == null) {
            return mVar.b;
        }
        int i2 = this.f1450e;
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
                i2 = Math.max(this.f1450e, 2);
                View view = this.c.F;
                if (view != null && view.getParent() == null) {
                    i2 = Math.min(i2, 2);
                }
            } else {
                i2 = this.f1450e < 4 ? Math.min(i2, mVar2.b) : Math.min(i2, 1);
            }
        }
        if (!this.c.f1459l) {
            i2 = Math.min(i2, 1);
        }
        m mVar3 = this.c;
        ViewGroup viewGroup = mVar3.E;
        a1.d.b bVar2 = null;
        if (viewGroup != null) {
            a1 f2 = a1.f(viewGroup, mVar3.u().M());
            Objects.requireNonNull(f2);
            a1.d d2 = f2.d(this.c);
            if (d2 != null) {
                bVar = d2.b;
            } else {
                m mVar4 = this.c;
                Iterator<a1.d> it = f2.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (dVar.c.equals(mVar4) && !dVar.f1391f) {
                        break;
                    }
                }
                if (dVar != null) {
                    bVar = dVar.b;
                }
            }
            bVar2 = bVar;
        }
        if (bVar2 == a1.d.b.ADDING) {
            i2 = Math.min(i2, 6);
        } else if (bVar2 == a1.d.b.REMOVING) {
            i2 = Math.max(i2, 3);
        } else {
            m mVar5 = this.c;
            if (mVar5.m) {
                i2 = mVar5.D() ? Math.min(i2, 1) : Math.min(i2, -1);
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
            StringBuilder i2 = f.a.a.a.a.i("moveto CREATED: ");
            i2.append(this.c);
            i2.toString();
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
            mVar2.M(bundle);
            mVar2.M = true;
            if (mVar2.D) {
                mVar2.O.e(h.a.ON_CREATE);
                d0 d0Var = this.a;
                m mVar3 = this.c;
                d0Var.c(mVar3, mVar3.c, false);
                return;
            }
            throw new c1(f.a.a.a.a.x("Fragment ", mVar2, " did not call through to super.onCreate()"));
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
                StringBuilder i2 = f.a.a.a.a.i("moveto CREATE_VIEW: ");
                i2.append(this.c);
                i2.toString();
            }
            m mVar = this.c;
            LayoutInflater k0 = mVar.k0(mVar.c);
            ViewGroup viewGroup = null;
            m mVar2 = this.c;
            ViewGroup viewGroup2 = mVar2.E;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i3 = mVar2.x;
                if (i3 != 0) {
                    if (i3 != -1) {
                        viewGroup = (ViewGroup) mVar2.s.r.e(i3);
                        if (viewGroup == null) {
                            m mVar3 = this.c;
                            if (!mVar3.p) {
                                try {
                                    str = mVar3.w().getResourceName(this.c.x);
                                } catch (Resources.NotFoundException unused) {
                                    str = "unknown";
                                }
                                StringBuilder i4 = f.a.a.a.a.i("No view found for id 0x");
                                i4.append(Integer.toHexString(this.c.x));
                                i4.append(" (");
                                i4.append(str);
                                i4.append(") for fragment ");
                                i4.append(this.c);
                                throw new IllegalArgumentException(i4.toString());
                            }
                        }
                    } else {
                        StringBuilder i5 = f.a.a.a.a.i("Cannot create fragment ");
                        i5.append(this.c);
                        i5.append(" for a container view with no id");
                        throw new IllegalArgumentException(i5.toString());
                    }
                }
            }
            m mVar4 = this.c;
            mVar4.E = viewGroup;
            mVar4.i0(k0, viewGroup, mVar4.c);
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
                AtomicInteger atomicInteger = e.i.i.m.a;
                if (view2.isAttachedToWindow()) {
                    this.c.F.requestApplyInsets();
                } else {
                    View view3 = this.c.F;
                    view3.addOnAttachStateChangeListener(new a(this, view3));
                }
                m mVar7 = this.c;
                mVar7.g0(mVar7.F, mVar7.c);
                mVar7.u.w(2);
                d0 d0Var = this.a;
                m mVar8 = this.c;
                d0Var.m(mVar8, mVar8.F, mVar8.c, false);
                int visibility = this.c.F.getVisibility();
                this.c.f().f1466j = this.c.F.getAlpha();
                m mVar9 = this.c;
                if (mVar9.E != null && visibility == 0) {
                    View findFocus = mVar9.F.findFocus();
                    if (findFocus != null) {
                        this.c.f().f1467k = findFocus;
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
            StringBuilder i2 = f.a.a.a.a.i("movefrom CREATED: ");
            i2.append(this.c);
            i2.toString();
        }
        m mVar = this.c;
        boolean z = true;
        boolean z2 = mVar.m && !mVar.D();
        if (z2 || this.b.c.d(this.c)) {
            b0<?> b0Var = this.c.t;
            if (b0Var instanceof h0) {
                z = this.b.c.f1437g;
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
                h0 h0Var2 = h0Var.f1434d.get(mVar2.f1453f);
                if (h0Var2 != null) {
                    h0Var2.a();
                    h0Var.f1434d.remove(mVar2.f1453f);
                }
                g0 g0Var = h0Var.f1435e.get(mVar2.f1453f);
                if (g0Var != null) {
                    g0Var.a();
                    h0Var.f1435e.remove(mVar2.f1453f);
                }
            }
            m mVar3 = this.c;
            mVar3.u.o();
            mVar3.O.e(h.a.ON_DESTROY);
            mVar3.b = 0;
            mVar3.D = false;
            mVar3.M = false;
            mVar3.Q();
            if (mVar3.D) {
                this.a.d(this.c, false);
                Iterator it = ((ArrayList) this.b.f()).iterator();
                while (it.hasNext()) {
                    k0 k0Var = (k0) it.next();
                    if (k0Var != null) {
                        m mVar4 = k0Var.c;
                        if (this.c.f1453f.equals(mVar4.f1456i)) {
                            mVar4.f1455h = this.c;
                            mVar4.f1456i = null;
                        }
                    }
                }
                m mVar5 = this.c;
                String str2 = mVar5.f1456i;
                if (str2 != null) {
                    mVar5.f1455h = this.b.d(str2);
                }
                this.b.k(this);
                return;
            }
            throw new c1(f.a.a.a.a.x("Fragment ", mVar3, " did not call through to super.onDestroy()"));
        }
        String str3 = this.c.f1456i;
        if (!(str3 == null || (d2 = this.b.d(str3)) == null || !d2.B)) {
            this.c.f1455h = d2;
        }
        this.c.b = 0;
    }

    public void h() {
        View view;
        if (e0.O(3)) {
            StringBuilder i2 = f.a.a.a.a.i("movefrom CREATE_VIEW: ");
            i2.append(this.c);
            i2.toString();
        }
        m mVar = this.c;
        ViewGroup viewGroup = mVar.E;
        if (!(viewGroup == null || (view = mVar.F) == null)) {
            viewGroup.removeView(view);
        }
        this.c.j0();
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
            StringBuilder i2 = f.a.a.a.a.i("movefrom ATTACHED: ");
            i2.append(this.c);
            i2.toString();
        }
        m mVar = this.c;
        mVar.b = -1;
        mVar.D = false;
        mVar.S();
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
            if ((mVar2.m && !mVar2.D()) || this.b.c.d(this.c)) {
                if (e0.O(3)) {
                    StringBuilder i3 = f.a.a.a.a.i("initState called for fragment: ");
                    i3.append(this.c);
                    i3.toString();
                }
                m mVar3 = this.c;
                Objects.requireNonNull(mVar3);
                mVar3.O = new e.p.m(mVar3);
                mVar3.S = new b(mVar3);
                mVar3.f1453f = UUID.randomUUID().toString();
                mVar3.f1459l = false;
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
        throw new c1(f.a.a.a.a.x("Fragment ", mVar, " did not call through to super.onDetach()"));
    }

    public void j() {
        m mVar = this.c;
        if (mVar.n && mVar.o && !mVar.q) {
            if (e0.O(3)) {
                StringBuilder i2 = f.a.a.a.a.i("moveto CREATE_VIEW: ");
                i2.append(this.c);
                i2.toString();
            }
            m mVar2 = this.c;
            mVar2.i0(mVar2.k0(mVar2.c), null, this.c.c);
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
                mVar5.g0(mVar5.F, mVar5.c);
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
        if (!this.f1449d) {
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
                                a1 f2 = a1.f(viewGroup, mVar.u().M());
                                if (this.c.z) {
                                    Objects.requireNonNull(f2);
                                    if (e0.O(2)) {
                                        String str = "SpecialEffectsController: Enqueuing hide operation for fragment " + this.c;
                                    }
                                    f2.a(a1.d.c.GONE, bVar, this);
                                } else {
                                    Objects.requireNonNull(f2);
                                    if (e0.O(2)) {
                                        String str2 = "SpecialEffectsController: Enqueuing show operation for fragment " + this.c;
                                    }
                                    f2.a(a1.d.c.VISIBLE, bVar, this);
                                }
                            }
                            m mVar2 = this.c;
                            mVar2.J = z;
                            boolean z3 = mVar2.z;
                            mVar2.U();
                        }
                        this.f1449d = z;
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
                                    a1 f3 = a1.f(viewGroup3, mVar.u().M());
                                    a1.d.c b2 = a1.d.c.b(this.c.F.getVisibility());
                                    Objects.requireNonNull(f3);
                                    if (e0.O(2)) {
                                        String str3 = "SpecialEffectsController: Enqueuing add operation for fragment " + this.c;
                                    }
                                    f3.a(b2, a1.d.b.ADDING, this);
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
                                m mVar3 = this.c;
                                if (mVar3.F != null && mVar3.f1451d == null) {
                                    o();
                                }
                                m mVar4 = this.c;
                                if (!(mVar4.F == null || (viewGroup2 = mVar4.E) == null)) {
                                    a1 f4 = a1.f(viewGroup2, mVar4.u().M());
                                    Objects.requireNonNull(f4);
                                    if (e0.O(2)) {
                                        String str5 = "SpecialEffectsController: Enqueuing remove operation for fragment " + this.c;
                                    }
                                    f4.a(a1.d.c.REMOVED, a1.d.b.REMOVING, this);
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
                this.f1449d = z;
            }
        } else if (e0.O(2)) {
            StringBuilder i3 = f.a.a.a.a.i("Ignoring re-entrant call to moveToExpectedState() for ");
            i3.append(this.c);
            i3.toString();
        }
    }

    public void l() {
        if (e0.O(3)) {
            StringBuilder i2 = f.a.a.a.a.i("movefrom RESUMED: ");
            i2.append(this.c);
            i2.toString();
        }
        m mVar = this.c;
        mVar.u.w(5);
        if (mVar.F != null) {
            mVar.P.b(h.a.ON_PAUSE);
        }
        mVar.O.e(h.a.ON_PAUSE);
        mVar.b = 6;
        mVar.D = false;
        mVar.Y();
        if (mVar.D) {
            this.a.f(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.x("Fragment ", mVar, " did not call through to super.onPause()"));
    }

    public void m(ClassLoader classLoader) {
        Bundle bundle = this.c.c;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            m mVar = this.c;
            mVar.f1451d = mVar.c.getSparseParcelableArray("android:view_state");
            m mVar2 = this.c;
            mVar2.f1452e = mVar2.c.getBundle("android:view_registry_state");
            m mVar3 = this.c;
            mVar3.f1456i = mVar3.c.getString("android:target_state");
            m mVar4 = this.c;
            if (mVar4.f1456i != null) {
                mVar4.f1457j = mVar4.c.getInt("android:target_req_state", 0);
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
            StringBuilder i2 = f.a.a.a.a.i("moveto RESUMED: ");
            i2.append(this.c);
            i2.toString();
        }
        m mVar = this.c;
        m.d dVar = mVar.I;
        View view = dVar == null ? null : dVar.f1467k;
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
        this.c.u0(null);
        m mVar2 = this.c;
        mVar2.u.V();
        mVar2.u.C(true);
        mVar2.b = 7;
        mVar2.D = false;
        mVar2.c0();
        if (mVar2.D) {
            e.p.m mVar3 = mVar2.O;
            h.a aVar = h.a.ON_RESUME;
            mVar3.e(aVar);
            if (mVar2.F != null) {
                mVar2.P.b(aVar);
            }
            e0 e0Var = mVar2.u;
            e0Var.B = false;
            e0Var.C = false;
            e0Var.J.f1438h = false;
            e0Var.w(7);
            this.a.i(this.c, false);
            m mVar4 = this.c;
            mVar4.c = null;
            mVar4.f1451d = null;
            mVar4.f1452e = null;
            return;
        }
        throw new c1(f.a.a.a.a.x("Fragment ", mVar2, " did not call through to super.onResume()"));
    }

    public void o() {
        if (this.c.F != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.c.F.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.c.f1451d = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.c.P.c.b(bundle);
            if (!bundle.isEmpty()) {
                this.c.f1452e = bundle;
            }
        }
    }

    public void p() {
        if (e0.O(3)) {
            StringBuilder i2 = f.a.a.a.a.i("moveto STARTED: ");
            i2.append(this.c);
            i2.toString();
        }
        m mVar = this.c;
        mVar.u.V();
        mVar.u.C(true);
        mVar.b = 5;
        mVar.D = false;
        mVar.e0();
        if (mVar.D) {
            e.p.m mVar2 = mVar.O;
            h.a aVar = h.a.ON_START;
            mVar2.e(aVar);
            if (mVar.F != null) {
                mVar.P.b(aVar);
            }
            e0 e0Var = mVar.u;
            e0Var.B = false;
            e0Var.C = false;
            e0Var.J.f1438h = false;
            e0Var.w(5);
            this.a.k(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.x("Fragment ", mVar, " did not call through to super.onStart()"));
    }

    public void q() {
        if (e0.O(3)) {
            StringBuilder i2 = f.a.a.a.a.i("movefrom STARTED: ");
            i2.append(this.c);
            i2.toString();
        }
        m mVar = this.c;
        e0 e0Var = mVar.u;
        e0Var.C = true;
        e0Var.J.f1438h = true;
        e0Var.w(4);
        if (mVar.F != null) {
            mVar.P.b(h.a.ON_STOP);
        }
        mVar.O.e(h.a.ON_STOP);
        mVar.b = 4;
        mVar.D = false;
        mVar.f0();
        if (mVar.D) {
            this.a.l(this.c, false);
            return;
        }
        throw new c1(f.a.a.a.a.x("Fragment ", mVar, " did not call through to super.onStop()"));
    }
}
