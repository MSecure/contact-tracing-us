package e.o.a;

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
import e.j.b.a;
import e.o.a.e0;
import e.r.f0;
import e.r.g0;
import e.r.h;
import e.r.h0;
import e.r.l;
import e.r.s;
import e.r.z;
import e.s.a.b;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class m implements ComponentCallbacks, View.OnCreateContextMenuListener, l, h0, e.r.g, e.w.c {
    public static final Object V = new Object();
    public boolean A;
    public boolean B;
    public boolean D;
    public ViewGroup E;
    public View F;
    public boolean G;
    public d I;
    public boolean J;
    public float K;
    public LayoutInflater L;
    public boolean M;
    public y0 P;
    public Bundle c;

    /* renamed from: d */
    public SparseArray<Parcelable> f1809d;

    /* renamed from: e */
    public Bundle f1810e;

    /* renamed from: g */
    public Bundle f1812g;

    /* renamed from: h */
    public m f1813h;

    /* renamed from: j */
    public int f1815j;

    /* renamed from: l */
    public boolean f1817l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public e0 s;
    public b0<?> t;
    public m v;
    public int w;
    public int x;
    public String y;
    public boolean z;
    public int b = -1;

    /* renamed from: f */
    public String f1811f = UUID.randomUUID().toString();

    /* renamed from: i */
    public String f1814i = null;

    /* renamed from: k */
    public Boolean f1816k = null;
    public e0 u = new f0();
    public boolean C = true;
    public boolean H = true;
    public h.b N = h.b.RESUMED;
    public s<l> Q = new s<>();
    public final AtomicInteger T = new AtomicInteger();
    public final ArrayList<f> U = new ArrayList<>();
    public e.r.m O = new e.r.m(this);
    public e.w.b S = new e.w.b(this);
    public f0.b R = null;

    /* loaded from: classes.dex */
    public class a implements Runnable {
    }

    /* loaded from: classes.dex */
    public class b extends x {
        public b() {
            m.this = r1;
        }

        @Override // e.o.a.x
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

        @Override // e.o.a.x
        public boolean g() {
            return m.this.F != null;
        }
    }

    /* loaded from: classes.dex */
    public class c implements e.c.a.c.a<Void, ActivityResultRegistry> {
        public c() {
            m.this = r1;
        }

        @Override // e.c.a.c.a
        public ActivityResultRegistry a(Void r3) {
            m mVar = m.this;
            b0<?> b0Var = mVar.t;
            if (b0Var instanceof e.a.e.d) {
                return ((e.a.e.d) b0Var).f();
            }
            return mVar.u0().f7j;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public View a;
        public Animator b;
        public boolean c;

        /* renamed from: d */
        public int f1818d;

        /* renamed from: e */
        public int f1819e;

        /* renamed from: f */
        public int f1820f;

        /* renamed from: g */
        public int f1821g;

        /* renamed from: h */
        public int f1822h;

        /* renamed from: i */
        public ArrayList<String> f1823i;

        /* renamed from: j */
        public ArrayList<String> f1824j;

        /* renamed from: k */
        public Object f1825k;

        /* renamed from: l */
        public Object f1826l;
        public Object m;
        public float n = 1.0f;
        public View o = null;
        public g p;
        public boolean q;

        public d() {
            Object obj = m.V;
            this.f1825k = obj;
            this.f1826l = obj;
            this.m = obj;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends RuntimeException {
        public e(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {
        public f() {
        }

        public f(a aVar) {
        }

        public abstract void a();
    }

    /* loaded from: classes.dex */
    public interface g {
    }

    public Object A() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1826l;
        if (obj != V) {
            return obj;
        }
        q();
        return null;
    }

    public void A0(Bundle bundle) {
        e0 e0Var = this.s;
        if (e0Var != null) {
            if (e0Var == null ? false : e0Var.T()) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.f1812g = bundle;
    }

    public final Resources B() {
        return v0().getResources();
    }

    public void B0(View view) {
        f().o = null;
    }

    public Object C() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1825k;
        if (obj != V) {
            return obj;
        }
        n();
        return null;
    }

    public void C0(boolean z) {
        f().q = z;
    }

    public Object D() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Objects.requireNonNull(dVar);
        return null;
    }

    public void D0(g gVar) {
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

    public Object E() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.m;
        if (obj != V) {
            return obj;
        }
        D();
        return null;
    }

    public void E0(boolean z) {
        if (this.I != null) {
            f().c = z;
        }
    }

    public final String F(int i2) {
        return B().getString(i2);
    }

    public void F0(Intent intent) {
        b0<?> b0Var = this.t;
        if (b0Var != null) {
            Context context = b0Var.c;
            Object obj = e.j.b.a.a;
            a.C0036a.b(context, intent, null);
            return;
        }
        throw new IllegalStateException(f.a.a.a.a.w("Fragment ", this, " not attached to Activity"));
    }

    public final String G(int i2, Object... objArr) {
        return B().getString(i2, objArr);
    }

    public void G0() {
        if (this.I != null) {
            Objects.requireNonNull(f());
        }
    }

    public l H() {
        y0 y0Var = this.P;
        if (y0Var != null) {
            return y0Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public final boolean I() {
        return this.t != null && this.f1817l;
    }

    public final boolean J() {
        return this.r > 0;
    }

    public boolean K() {
        d dVar = this.I;
        return false;
    }

    public final boolean L() {
        m mVar = this.v;
        return mVar != null && (mVar.m || mVar.L());
    }

    @Deprecated
    public void M() {
        this.D = true;
    }

    @Deprecated
    public void N(int i2, int i3, Intent intent) {
        if (e0.P(2)) {
            String str = "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent;
        }
    }

    @Deprecated
    public void O(Activity activity) {
        this.D = true;
    }

    public void P(Context context) {
        this.D = true;
        b0<?> b0Var = this.t;
        Activity activity = b0Var == null ? null : b0Var.b;
        if (activity != null) {
            this.D = false;
            O(activity);
        }
    }

    @Deprecated
    public void Q() {
    }

    public boolean R() {
        return false;
    }

    public void S(Bundle bundle) {
        Parcelable parcelable;
        boolean z = true;
        this.D = true;
        if (!(bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null)) {
            this.u.e0(parcelable);
            this.u.m();
        }
        e0 e0Var = this.u;
        if (e0Var.p < 1) {
            z = false;
        }
        if (!z) {
            e0Var.m();
        }
    }

    public Animation T() {
        return null;
    }

    public Animator U() {
        return null;
    }

    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void W() {
        this.D = true;
    }

    public void X() {
        this.D = true;
    }

    public void Y() {
        this.D = true;
    }

    public LayoutInflater Z(Bundle bundle) {
        return u();
    }

    @Override // e.r.l
    public h a() {
        return this.O;
    }

    public void a0() {
    }

    public x b() {
        return new b();
    }

    @Deprecated
    public void b0() {
        this.D = true;
    }

    public void c0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.D = true;
        b0<?> b0Var = this.t;
        if ((b0Var == null ? null : b0Var.b) != null) {
            this.D = false;
            b0();
        }
    }

    @Override // e.w.c
    public final e.w.a d() {
        return this.S.b;
    }

    public void d0() {
    }

    public void e0() {
        this.D = true;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final d f() {
        if (this.I == null) {
            this.I = new d();
        }
        return this.I;
    }

    public void f0() {
    }

    public final r g() {
        b0<?> b0Var = this.t;
        if (b0Var == null) {
            return null;
        }
        return (r) b0Var.b;
    }

    public void g0(boolean z) {
    }

    public View h() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        return dVar.a;
    }

    @Deprecated
    public void h0() {
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return super.hashCode();
    }

    @Override // e.r.h0
    public g0 i() {
        if (this.s == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        } else if (v() != 1) {
            h0 h0Var = this.s.J;
            g0 g0Var = h0Var.f1793e.get(this.f1811f);
            if (g0Var != null) {
                return g0Var;
            }
            g0 g0Var2 = new g0();
            h0Var.f1793e.put(this.f1811f, g0Var2);
            return g0Var2;
        } else {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
    }

    public void i0() {
        this.D = true;
    }

    public final e0 j() {
        if (this.t != null) {
            return this.u;
        }
        throw new IllegalStateException(f.a.a.a.a.w("Fragment ", this, " has not been attached yet."));
    }

    public void j0(Bundle bundle) {
    }

    public Context k() {
        b0<?> b0Var = this.t;
        if (b0Var == null) {
            return null;
        }
        return b0Var.c;
    }

    public void k0() {
        this.D = true;
    }

    @Override // e.r.g
    public f0.b l() {
        if (this.s != null) {
            if (this.R == null) {
                Application application = null;
                Context applicationContext = v0().getApplicationContext();
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
                if (application == null && e0.P(3)) {
                    StringBuilder h2 = f.a.a.a.a.h("Could not find Application instance from Context ");
                    h2.append(v0().getApplicationContext());
                    h2.append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
                    h2.toString();
                }
                this.R = new z(application, this, this.f1812g);
            }
            return this.R;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void l0() {
        this.D = true;
    }

    public int m() {
        d dVar = this.I;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1818d;
    }

    public void m0(View view, Bundle bundle) {
    }

    public Object n() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Objects.requireNonNull(dVar);
        return null;
    }

    public void n0(Bundle bundle) {
        this.D = true;
    }

    public void o() {
        d dVar = this.I;
        if (dVar != null) {
            Objects.requireNonNull(dVar);
        }
    }

    public void o0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.u.W();
        boolean z = true;
        this.q = true;
        this.P = new y0(this, i());
        View V2 = V(layoutInflater, viewGroup, bundle);
        this.F = V2;
        if (V2 != null) {
            this.P.e();
            this.F.setTag(R$id.view_tree_lifecycle_owner, this.P);
            this.F.setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this.P);
            this.F.setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this.P);
            this.Q.l(this.P);
            return;
        }
        if (this.P.f1887e == null) {
            z = false;
        }
        if (!z) {
            this.P = null;
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.D = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        u0().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.D = true;
    }

    public int p() {
        d dVar = this.I;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1819e;
    }

    public void p0() {
        this.u.w(1);
        if (this.F != null) {
            y0 y0Var = this.P;
            y0Var.e();
            if (y0Var.f1887e.b.compareTo(h.b.CREATED) >= 0) {
                this.P.b(h.a.ON_DESTROY);
            }
        }
        this.b = 1;
        this.D = false;
        X();
        if (this.D) {
            b.C0054b bVar = ((e.s.a.b) e.s.a.a.b(this)).b;
            int h2 = bVar.c.h();
            for (int i2 = 0; i2 < h2; i2++) {
                Objects.requireNonNull(bVar.c.i(i2));
            }
            this.q = false;
            return;
        }
        throw new c1(f.a.a.a.a.w("Fragment ", this, " did not call through to super.onDestroyView()"));
    }

    public Object q() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Objects.requireNonNull(dVar);
        return null;
    }

    public LayoutInflater q0(Bundle bundle) {
        LayoutInflater Z = Z(bundle);
        this.L = Z;
        return Z;
    }

    public void r() {
        d dVar = this.I;
        if (dVar != null) {
            Objects.requireNonNull(dVar);
        }
    }

    public void r0() {
        onLowMemory();
        this.u.p();
    }

    public final Object s() {
        b0<?> b0Var = this.t;
        if (b0Var == null) {
            return null;
        }
        return b0Var.j();
    }

    public boolean s0(Menu menu) {
        if (!this.z) {
            return false | this.u.v(menu);
        }
        return false;
    }

    public final LayoutInflater t() {
        LayoutInflater layoutInflater = this.L;
        return layoutInflater == null ? q0(null) : layoutInflater;
    }

    public final <I, O> e.a.e.c<I> t0(e.a.e.f.a<I, O> aVar, e.a.e.b<O> bVar) {
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
        throw new IllegalStateException(f.a.a.a.a.w("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f1811f);
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

    @Deprecated
    public LayoutInflater u() {
        b0<?> b0Var = this.t;
        if (b0Var != null) {
            LayoutInflater k2 = b0Var.k();
            k2.setFactory2(this.u.f1775f);
            return k2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public final r u0() {
        r g2 = g();
        if (g2 != null) {
            return g2;
        }
        throw new IllegalStateException(f.a.a.a.a.w("Fragment ", this, " not attached to an activity."));
    }

    public final int v() {
        h.b bVar = this.N;
        return (bVar == h.b.INITIALIZED || this.v == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.v.v());
    }

    public final Context v0() {
        Context k2 = k();
        if (k2 != null) {
            return k2;
        }
        throw new IllegalStateException(f.a.a.a.a.w("Fragment ", this, " not attached to a context."));
    }

    public final e0 w() {
        e0 e0Var = this.s;
        if (e0Var != null) {
            return e0Var;
        }
        throw new IllegalStateException(f.a.a.a.a.w("Fragment ", this, " not associated with a fragment manager."));
    }

    public final View w0() {
        View view = this.F;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(f.a.a.a.a.w("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public boolean x() {
        d dVar = this.I;
        if (dVar == null) {
            return false;
        }
        return dVar.c;
    }

    public void x0(View view) {
        f().a = view;
    }

    public int y() {
        d dVar = this.I;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1820f;
    }

    public void y0(int i2, int i3, int i4, int i5) {
        if (this.I != null || i2 != 0 || i3 != 0 || i4 != 0 || i5 != 0) {
            f().f1818d = i2;
            f().f1819e = i3;
            f().f1820f = i4;
            f().f1821g = i5;
        }
    }

    public int z() {
        d dVar = this.I;
        if (dVar == null) {
            return 0;
        }
        return dVar.f1821g;
    }

    public void z0(Animator animator) {
        f().b = animator;
    }
}
