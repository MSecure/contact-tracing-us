package e.m.a;

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
import e.m.a.e0;
import e.p.f0;
import e.p.g0;
import e.p.h;
import e.p.h0;
import e.p.l;
import e.p.s;
import e.p.z;
import e.q.a.b;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class m implements ComponentCallbacks, View.OnCreateContextMenuListener, l, h0, e.p.g, e.u.c {
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
    public e.p.m O = new e.p.m(this);
    public y0 P;
    public s<l> Q = new s<>();
    public f0.b R;
    public e.u.b S = new e.u.b(this);
    public final AtomicInteger T = new AtomicInteger();
    public final ArrayList<f> U = new ArrayList<>();
    public int b = -1;
    public Bundle c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Parcelable> f1451d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f1452e;

    /* renamed from: f  reason: collision with root package name */
    public String f1453f = UUID.randomUUID().toString();

    /* renamed from: g  reason: collision with root package name */
    public Bundle f1454g;

    /* renamed from: h  reason: collision with root package name */
    public m f1455h;

    /* renamed from: i  reason: collision with root package name */
    public String f1456i = null;

    /* renamed from: j  reason: collision with root package name */
    public int f1457j;

    /* renamed from: k  reason: collision with root package name */
    public Boolean f1458k = null;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1459l;
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

        @Override // e.m.a.x
        public View e(int i2) {
            View view = m.this.F;
            if (view != null) {
                return view.findViewById(i2);
            }
            StringBuilder i3 = f.a.a.a.a.i("Fragment ");
            i3.append(m.this);
            i3.append(" does not have a view");
            throw new IllegalStateException(i3.toString());
        }

        @Override // e.m.a.x
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
            return mVar.o0().f7j;
        }
    }

    public static class d {
        public View a;
        public Animator b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f1460d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f1461e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f1462f;

        /* renamed from: g  reason: collision with root package name */
        public Object f1463g;

        /* renamed from: h  reason: collision with root package name */
        public Object f1464h;

        /* renamed from: i  reason: collision with root package name */
        public Object f1465i;

        /* renamed from: j  reason: collision with root package name */
        public float f1466j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public View f1467k = null;

        /* renamed from: l  reason: collision with root package name */
        public g f1468l;
        public boolean m;

        public d() {
            Object obj = m.V;
            this.f1463g = obj;
            this.f1464h = obj;
            this.f1465i = obj;
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

    public final String A(int i2) {
        return w().getString(i2);
    }

    public final String B(int i2, Object... objArr) {
        return w().getString(i2, objArr);
    }

    public l C() {
        y0 y0Var = this.P;
        if (y0Var != null) {
            return y0Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public final boolean D() {
        return this.r > 0;
    }

    public boolean E() {
        d dVar = this.I;
        return false;
    }

    public final boolean F() {
        m mVar = this.v;
        return mVar != null && (mVar.m || mVar.F());
    }

    @Deprecated
    public void G() {
        this.D = true;
    }

    @Deprecated
    public void H(int i2, int i3, Intent intent) {
        if (e0.O(2)) {
            String str = "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent;
        }
    }

    @Deprecated
    public void I(Activity activity) {
        this.D = true;
    }

    public void J(Context context) {
        this.D = true;
        b0<?> b0Var = this.t;
        Activity activity = b0Var == null ? null : b0Var.b;
        if (activity != null) {
            this.D = false;
            I(activity);
        }
    }

    @Deprecated
    public void K() {
    }

    public boolean L() {
        return false;
    }

    public void M(Bundle bundle) {
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

    public Animation N() {
        return null;
    }

    public Animator O() {
        return null;
    }

    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void Q() {
        this.D = true;
    }

    public void R() {
        this.D = true;
    }

    public void S() {
        this.D = true;
    }

    public LayoutInflater T(Bundle bundle) {
        return r();
    }

    public void U() {
    }

    @Deprecated
    public void V() {
        this.D = true;
    }

    public void W(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.D = true;
        b0<?> b0Var = this.t;
        if ((b0Var == null ? null : b0Var.b) != null) {
            this.D = false;
            V();
        }
    }

    public void X() {
    }

    public void Y() {
        this.D = true;
    }

    public void Z() {
    }

    @Override // e.p.l
    public h a() {
        return this.O;
    }

    public void a0(boolean z2) {
    }

    public x b() {
        return new b();
    }

    @Deprecated
    public void b0() {
    }

    public void c0() {
        this.D = true;
    }

    @Override // e.u.c
    public final e.u.a d() {
        return this.S.b;
    }

    public void d0(Bundle bundle) {
    }

    public void e0() {
        this.D = true;
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

    public void f0() {
        this.D = true;
    }

    public View g() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        return dVar.a;
    }

    public void g0(View view, Bundle bundle) {
    }

    public final e0 h() {
        if (this.t != null) {
            return this.u;
        }
        throw new IllegalStateException(f.a.a.a.a.x("Fragment ", this, " has not been attached yet."));
    }

    public void h0(Bundle bundle) {
        this.D = true;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @Override // e.p.h0
    public g0 i() {
        if (this.s == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        } else if (s() != 1) {
            h0 h0Var = this.s.J;
            g0 g0Var = h0Var.f1435e.get(this.f1453f);
            if (g0Var != null) {
                return g0Var;
            }
            g0 g0Var2 = new g0();
            h0Var.f1435e.put(this.f1453f, g0Var2);
            return g0Var2;
        } else {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
    }

    public void i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.u.V();
        boolean z2 = true;
        this.q = true;
        this.P = new y0();
        View P2 = P(layoutInflater, viewGroup, bundle);
        this.F = P2;
        if (P2 != null) {
            y0 y0Var = this.P;
            if (y0Var.b == null) {
                y0Var.b = new e.p.m(y0Var);
                y0Var.c = new e.u.b(y0Var);
            }
            this.F.setTag(R$id.view_tree_lifecycle_owner, this.P);
            this.F.setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this);
            this.F.setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this.P);
            this.Q.l(this.P);
            return;
        }
        if (this.P.b == null) {
            z2 = false;
        }
        if (!z2) {
            this.P = null;
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public Context j() {
        b0<?> b0Var = this.t;
        if (b0Var == null) {
            return null;
        }
        return b0Var.c;
    }

    public void j0() {
        this.u.w(1);
        if (this.F != null) {
            if (((e.p.m) this.P.a()).b.compareTo(h.b.CREATED) >= 0) {
                this.P.b(h.a.ON_DESTROY);
            }
        }
        this.b = 1;
        this.D = false;
        R();
        if (this.D) {
            b.C0044b bVar = ((e.q.a.b) e.q.a.a.b(this)).b;
            int h2 = bVar.c.h();
            for (int i2 = 0; i2 < h2; i2++) {
                Objects.requireNonNull(bVar.c.i(i2));
            }
            this.q = false;
            return;
        }
        throw new c1(f.a.a.a.a.x("Fragment ", this, " did not call through to super.onDestroyView()"));
    }

    public Object k() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Objects.requireNonNull(dVar);
        return null;
    }

    public LayoutInflater k0(Bundle bundle) {
        LayoutInflater T2 = T(bundle);
        this.L = T2;
        return T2;
    }

    @Override // e.p.g
    public f0.b l() {
        if (this.s != null) {
            if (this.R == null) {
                Application application = null;
                Context applicationContext = p0().getApplicationContext();
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
                    StringBuilder i2 = f.a.a.a.a.i("Could not find Application instance from Context ");
                    i2.append(p0().getApplicationContext());
                    i2.append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
                    i2.toString();
                }
                this.R = new z(application, this, this.f1454g);
            }
            return this.R;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void l0() {
        onLowMemory();
        this.u.p();
    }

    public void m() {
        d dVar = this.I;
        if (dVar != null) {
            Objects.requireNonNull(dVar);
        }
    }

    public boolean m0(Menu menu) {
        if (!this.z) {
            return false | this.u.v(menu);
        }
        return false;
    }

    public Object n() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Objects.requireNonNull(dVar);
        return null;
    }

    public final <I, O> e.a.e.c<I> n0(e.a.e.f.a<I, O> aVar, e.a.e.b<O> bVar) {
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
        throw new IllegalStateException(f.a.a.a.a.x("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
    }

    public void o() {
        d dVar = this.I;
        if (dVar != null) {
            Objects.requireNonNull(dVar);
        }
    }

    public final r o0() {
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
        throw new IllegalStateException(f.a.a.a.a.x("Fragment ", this, " not attached to an activity."));
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.D = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        o0().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.D = true;
    }

    public final Object p() {
        b0<?> b0Var = this.t;
        if (b0Var == null) {
            return null;
        }
        return b0Var.j();
    }

    public final Context p0() {
        Context j2 = j();
        if (j2 != null) {
            return j2;
        }
        throw new IllegalStateException(f.a.a.a.a.x("Fragment ", this, " not attached to a context."));
    }

    public final LayoutInflater q() {
        LayoutInflater layoutInflater = this.L;
        return layoutInflater == null ? k0(null) : layoutInflater;
    }

    public final View q0() {
        View view = this.F;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(f.a.a.a.a.x("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    @Deprecated
    public LayoutInflater r() {
        b0<?> b0Var = this.t;
        if (b0Var != null) {
            LayoutInflater k2 = b0Var.k();
            k2.setFactory2(this.u.f1417f);
            return k2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void r0(View view) {
        f().a = view;
    }

    public final int s() {
        h.b bVar = this.N;
        return (bVar == h.b.INITIALIZED || this.v == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.v.s());
    }

    public void s0(Animator animator) {
        f().b = animator;
    }

    public int t() {
        d dVar = this.I;
        if (dVar == null) {
            return 0;
        }
        return dVar.c;
    }

    public void t0(Bundle bundle) {
        e0 e0Var = this.s;
        if (e0Var != null) {
            if (e0Var == null ? false : e0Var.S()) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.f1454g = bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f1453f);
        sb.append(")");
        if (this.w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.w));
        }
        if (this.y != null) {
            sb.append(" ");
            sb.append(this.y);
        }
        sb.append('}');
        return sb.toString();
    }

    public final e0 u() {
        e0 e0Var = this.s;
        if (e0Var != null) {
            return e0Var;
        }
        throw new IllegalStateException(f.a.a.a.a.x("Fragment ", this, " not associated with a fragment manager."));
    }

    public void u0(View view) {
        f().f1467k = null;
    }

    public Object v() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1464h;
        if (obj != V) {
            return obj;
        }
        n();
        return null;
    }

    public void v0(boolean z2) {
        f().m = z2;
    }

    public final Resources w() {
        return p0().getResources();
    }

    public void w0(int i2) {
        if (this.I != null || i2 != 0) {
            f().c = i2;
        }
    }

    public Object x() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1463g;
        if (obj != V) {
            return obj;
        }
        k();
        return null;
    }

    public void x0(g gVar) {
        f();
        g gVar2 = this.I.f1468l;
        if (gVar != gVar2) {
            if (gVar != null && gVar2 != null) {
                throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
            } else if (gVar != null) {
                ((e0.n) gVar).c++;
            }
        }
    }

    public Object y() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Objects.requireNonNull(dVar);
        return null;
    }

    public void y0(Intent intent) {
        b0<?> b0Var = this.t;
        if (b0Var != null) {
            Context context = b0Var.c;
            Object obj = e.i.b.a.a;
            context.startActivity(intent, null);
            return;
        }
        throw new IllegalStateException(f.a.a.a.a.x("Fragment ", this, " not attached to Activity"));
    }

    public Object z() {
        d dVar = this.I;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f1465i;
        if (obj != V) {
            return obj;
        }
        y();
        return null;
    }

    public void z0() {
        if (this.I != null) {
            Objects.requireNonNull(f());
        }
    }
}
