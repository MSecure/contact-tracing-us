package e.n.a;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.runtime.R$id;
import e.i.b.a;
import e.n.a.e0;
import e.q.f0;
import e.q.g0;
import e.q.h;
import e.q.h0;
import e.q.l;
import e.q.s;
import e.q.z;
import e.r.a.b;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class m implements ComponentCallbacks, View.OnCreateContextMenuListener, l, h0, e.q.g, e.v.c {
    public static final Object V = new Object();
    public boolean A;
    public boolean B;
    public boolean C = true;
    public boolean D;
    public ViewGroup E;
    public View F;
    public boolean G;
    public boolean H = true;
    public d I;
    public boolean J;
    public float K;
    public LayoutInflater L;
    public boolean M;
    public h.b N = h.b.RESUMED;
    public e.q.m O = new e.q.m(this);
    public y0 P;
    public s<l> Q = new s<>();
    public f0.b R = null;
    public e.v.b S = new e.v.b(this);
    public final AtomicInteger T = new AtomicInteger();
    public final ArrayList<f> U = new ArrayList<>();
    public int b = -1;
    public Bundle c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Parcelable> f1724d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f1725e;

    /* renamed from: f  reason: collision with root package name */
    public String f1726f = UUID.randomUUID().toString();

    /* renamed from: g  reason: collision with root package name */
    public Bundle f1727g;

    /* renamed from: h  reason: collision with root package name */
    public m f1728h;

    /* renamed from: i  reason: collision with root package name */
    public String f1729i = null;

    /* renamed from: j  reason: collision with root package name */
    public int f1730j;

    /* renamed from: k  reason: collision with root package name */
    public Boolean f1731k = null;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1732l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public e0 s;
    public b0<?> t;
    public e0 u = new f0();
    public m v;
    public int w;
    public int x;
    public String y;
    public boolean z;

    public class a implements Runnable {
    }

    public class b extends x {
        public b() {
        }

        @Override // e.n.a.x
        public View e(int i2) {
            View view = m.this.F;
            if (view != null) {
                return view.findViewById(i2);
            }
            StringBuilder h2 = f.a.a.a.a.h("Fragment ");
            h2.append(m.this);
            h2.append(" does not have a view");
            throw new IllegalStateException(h2.toString());
        }

        @Override // e.n.a.x
        public boolean g() {
            return m.this.F != null;
        }
    }

    public class c implements e.c.a.c.a<Void, ActivityResultRegistry> {
        public c() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.c.a.c.a
        public ActivityResultRegistry a(Void r3) {
            m mVar = m.this;
            b0<?> b0Var = mVar.t;
            if (b0Var instanceof e.a.e.d) {
                return ((e.a.e.d) b0Var).f();
            }
            return mVar.s0().f7j;
        }
    }

    public static class d {
        public View a;
        public Animator b;
        public boolean c;

        /* renamed from: d  reason: collision with root package name */
        public int f1733d;

        /* renamed from: e  reason: collision with root package name */
        public int f1734e;

        /* renamed from: f  reason: collision with root package name */
        public int f1735f;

        /* renamed from: g  reason: collision with root package name */
        public int f1736g;

        /* renamed from: h  reason: collision with root package name */
        public int f1737h;

        /* renamed from: i  reason: collision with root package name */
        public ArrayList<String> f1738i;

        /* renamed from: j  reason: collision with root package name */
        public ArrayList<String> f1739j;

        /* renamed from: k  reason: collision with root package name */
        public Object f1740k;

        /* renamed from: l  reason: collision with root package name */
        public Object f1741l;
        public Object m;
        public float n = 1.0f;
        public View o = null;
        public g p;
        public boolean q;

        public d() {
            Object obj = m.V;
            this.f1740k = obj;
            this.f1741l = obj;
            this.m = obj;
        }
    }

    public static class e extends RuntimeException {
        public e(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static abstract class f {
        public f() {
        }

        public f(a aVar) {
        }

        public abstract void a();
    }

    public interface g {
    }

    public final Resources A() {
        return t0().getResources();
    }

    public void A0(boolean z2) {
        f().q = z2;
    }

    public Object B() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1740k;
        if (obj != V) {
            return obj;
        }
        m();
        return null;
    }

    public void B0(g gVar) {
        f();
        g gVar2 = this.I.p;
        if (gVar != gVar2) {
            if (gVar != null && gVar2 != null) {
                throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
            } else if (gVar != null) {
                ((e0.n) gVar).c++;
            }
        }
    }

    public Object C() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Objects.requireNonNull(dVar);
        return null;
    }

    public void C0(boolean z2) {
        if (this.I != null) {
            f().c = z2;
        }
    }

    public Object D() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.m;
        if (obj != V) {
            return obj;
        }
        C();
        return null;
    }

    public void D0(Intent intent) {
        b0<?> b0Var = this.t;
        if (b0Var != null) {
            Context context = b0Var.c;
            Object obj = e.i.b.a.a;
            a.C0033a.b(context, intent, null);
            return;
        }
        throw new IllegalStateException(f.a.a.a.a.v("Fragment ", this, " not attached to Activity"));
    }

    public final String E(int i2) {
        return A().getString(i2);
    }

    public void E0() {
        if (this.I != null) {
            Objects.requireNonNull(f());
        }
    }

    public final String F(int i2, Object... objArr) {
        return A().getString(i2, objArr);
    }

    public l G() {
        y0 y0Var = this.P;
        if (y0Var != null) {
            return y0Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public final boolean H() {
        return this.r > 0;
    }

    public boolean I() {
        d dVar = this.I;
        return false;
    }

    public final boolean J() {
        m mVar = this.v;
        return mVar != null && (mVar.m || mVar.J());
    }

    @Deprecated
    public void K() {
        this.D = true;
    }

    @Deprecated
    public void L(int i2, int i3, Intent intent) {
        if (e0.O(2)) {
            String str = "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent;
        }
    }

    @Deprecated
    public void M(Activity activity) {
        this.D = true;
    }

    public void N(Context context) {
        this.D = true;
        b0<?> b0Var = this.t;
        Activity activity = b0Var == null ? null : b0Var.b;
        if (activity != null) {
            this.D = false;
            M(activity);
        }
    }

    @Deprecated
    public void O() {
    }

    public boolean P() {
        return false;
    }

    public void Q(Bundle bundle) {
        Parcelable parcelable;
        boolean z2 = true;
        this.D = true;
        if (!(bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null)) {
            this.u.d0(parcelable);
            this.u.m();
        }
        e0 e0Var = this.u;
        if (e0Var.p < 1) {
            z2 = false;
        }
        if (!z2) {
            e0Var.m();
        }
    }

    public Animation R() {
        return null;
    }

    public Animator S() {
        return null;
    }

    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void U() {
        this.D = true;
    }

    public void V() {
        this.D = true;
    }

    public void W() {
        this.D = true;
    }

    public LayoutInflater X(Bundle bundle) {
        return t();
    }

    public void Y() {
    }

    @Deprecated
    public void Z() {
        this.D = true;
    }

    @Override // e.q.l
    public h a() {
        return this.O;
    }

    public void a0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.D = true;
        b0<?> b0Var = this.t;
        if ((b0Var == null ? null : b0Var.b) != null) {
            this.D = false;
            Z();
        }
    }

    public x b() {
        return new b();
    }

    public void b0() {
    }

    public void c0() {
        this.D = true;
    }

    @Override // e.v.c
    public final e.v.a d() {
        return this.S.b;
    }

    public void d0() {
    }

    public void e0(boolean z2) {
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final d f() {
        if (this.I == null) {
            this.I = new d();
        }
        return this.I;
    }

    @Deprecated
    public void f0() {
    }

    public View g() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        return dVar.a;
    }

    public void g0() {
        this.D = true;
    }

    public final e0 h() {
        if (this.t != null) {
            return this.u;
        }
        throw new IllegalStateException(f.a.a.a.a.v("Fragment ", this, " has not been attached yet."));
    }

    public void h0(Bundle bundle) {
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @Override // e.q.h0
    public g0 i() {
        if (this.s == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        } else if (u() != 1) {
            h0 h0Var = this.s.J;
            g0 g0Var = h0Var.f1708e.get(this.f1726f);
            if (g0Var != null) {
                return g0Var;
            }
            g0 g0Var2 = new g0();
            h0Var.f1708e.put(this.f1726f, g0Var2);
            return g0Var2;
        } else {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
    }

    public void i0() {
        this.D = true;
    }

    public Context j() {
        b0<?> b0Var = this.t;
        if (b0Var == null) {
            return null;
        }
        return b0Var.c;
    }

    public void j0() {
        this.D = true;
    }

    public int k() {
        d dVar = this.I;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1733d;
    }

    public void k0(View view, Bundle bundle) {
    }

    @Override // e.q.g
    public f0.b l() {
        if (this.s != null) {
            if (this.R == null) {
                Application application = null;
                Context applicationContext = t0().getApplicationContext();
                while (true) {
                    if (!(applicationContext instanceof ContextWrapper)) {
                        break;
                    } else if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                        break;
                    } else {
                        applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                    }
                }
                if (application == null && e0.O(3)) {
                    StringBuilder h2 = f.a.a.a.a.h("Could not find Application instance from Context ");
                    h2.append(t0().getApplicationContext());
                    h2.append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
                    h2.toString();
                }
                this.R = new z(application, this, this.f1727g);
            }
            return this.R;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void l0(Bundle bundle) {
        this.D = true;
    }

    public Object m() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Objects.requireNonNull(dVar);
        return null;
    }

    public void m0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.u.V();
        boolean z2 = true;
        this.q = true;
        this.P = new y0(this, i());
        View T2 = T(layoutInflater, viewGroup, bundle);
        this.F = T2;
        if (T2 != null) {
            this.P.e();
            this.F.setTag(R$id.view_tree_lifecycle_owner, this.P);
            this.F.setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this.P);
            this.F.setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this.P);
            this.Q.l(this.P);
            return;
        }
        if (this.P.f1802e == null) {
            z2 = false;
        }
        if (!z2) {
            this.P = null;
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public void n() {
        d dVar = this.I;
        if (dVar != null) {
            Objects.requireNonNull(dVar);
        }
    }

    public void n0() {
        this.u.w(1);
        if (this.F != null) {
            y0 y0Var = this.P;
            y0Var.e();
            if (y0Var.f1802e.b.compareTo(h.b.CREATED) >= 0) {
                this.P.b(h.a.ON_DESTROY);
            }
        }
        this.b = 1;
        this.D = false;
        V();
        if (this.D) {
            b.C0050b bVar = ((e.r.a.b) e.r.a.a.b(this)).b;
            int h2 = bVar.c.h();
            for (int i2 = 0; i2 < h2; i2++) {
                Objects.requireNonNull(bVar.c.i(i2));
            }
            this.q = false;
            return;
        }
        throw new c1(f.a.a.a.a.v("Fragment ", this, " did not call through to super.onDestroyView()"));
    }

    public int o() {
        d dVar = this.I;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1734e;
    }

    public LayoutInflater o0(Bundle bundle) {
        LayoutInflater X = X(bundle);
        this.L = X;
        return X;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.D = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        s0().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.D = true;
    }

    public Object p() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Objects.requireNonNull(dVar);
        return null;
    }

    public void p0() {
        onLowMemory();
        this.u.p();
    }

    public void q() {
        d dVar = this.I;
        if (dVar != null) {
            Objects.requireNonNull(dVar);
        }
    }

    public boolean q0(Menu menu) {
        if (!this.z) {
            return false | this.u.v(menu);
        }
        return false;
    }

    public final Object r() {
        b0<?> b0Var = this.t;
        if (b0Var == null) {
            return null;
        }
        return b0Var.j();
    }

    public final <I, O> e.a.e.c<I> r0(e.a.e.f.a<I, O> aVar, e.a.e.b<O> bVar) {
        c cVar = new c();
        if (this.b <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            n nVar = new n(this, cVar, atomicReference, aVar, bVar);
            if (this.b >= 0) {
                nVar.a();
            } else {
                this.U.add(nVar);
            }
            return new o(this, atomicReference, aVar);
        }
        throw new IllegalStateException(f.a.a.a.a.v("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
    }

    public final LayoutInflater s() {
        LayoutInflater layoutInflater = this.L;
        return layoutInflater == null ? o0(null) : layoutInflater;
    }

    public final r s0() {
        r rVar;
        b0<?> b0Var = this.t;
        if (b0Var == null) {
            rVar = null;
        } else {
            rVar = (r) b0Var.b;
        }
        if (rVar != null) {
            return rVar;
        }
        throw new IllegalStateException(f.a.a.a.a.v("Fragment ", this, " not attached to an activity."));
    }

    @Deprecated
    public LayoutInflater t() {
        b0<?> b0Var = this.t;
        if (b0Var != null) {
            LayoutInflater k2 = b0Var.k();
            k2.setFactory2(this.u.f1690f);
            return k2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public final Context t0() {
        Context j2 = j();
        if (j2 != null) {
            return j2;
        }
        throw new IllegalStateException(f.a.a.a.a.v("Fragment ", this, " not attached to a context."));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f1726f);
        if (this.w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.w));
        }
        if (this.y != null) {
            sb.append(" tag=");
            sb.append(this.y);
        }
        sb.append(")");
        return sb.toString();
    }

    public final int u() {
        h.b bVar = this.N;
        return (bVar == h.b.INITIALIZED || this.v == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.v.u());
    }

    public final View u0() {
        View view = this.F;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(f.a.a.a.a.v("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public final e0 v() {
        e0 e0Var = this.s;
        if (e0Var != null) {
            return e0Var;
        }
        throw new IllegalStateException(f.a.a.a.a.v("Fragment ", this, " not associated with a fragment manager."));
    }

    public void v0(View view) {
        f().a = view;
    }

    public boolean w() {
        d dVar = this.I;
        if (dVar == null) {
            return false;
        }
        return dVar.c;
    }

    public void w0(int i2, int i3, int i4, int i5) {
        if (this.I != null || i2 != 0 || i3 != 0 || i4 != 0 || i5 != 0) {
            f().f1733d = i2;
            f().f1734e = i3;
            f().f1735f = i4;
            f().f1736g = i5;
        }
    }

    public int x() {
        d dVar = this.I;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1735f;
    }

    public void x0(Animator animator) {
        f().b = animator;
    }

    public int y() {
        d dVar = this.I;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1736g;
    }

    public void y0(Bundle bundle) {
        e0 e0Var = this.s;
        if (e0Var != null) {
            if (e0Var == null ? false : e0Var.S()) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.f1727g = bundle;
    }

    public Object z() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1741l;
        if (obj != V) {
            return obj;
        }
        p();
        return null;
    }

    public void z0(View view) {
        f().o = null;
    }
}
