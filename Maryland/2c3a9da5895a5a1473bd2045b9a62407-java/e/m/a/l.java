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
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.runtime.R$id;
import e.m.a.f0;
import e.p.b0;
import e.p.c0;
import e.p.d0;
import e.p.g;
import e.p.j;
import e.p.k;
import e.p.q;
import e.p.v;
import e.q.a.b;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class l implements ComponentCallbacks, View.OnCreateContextMenuListener, j, d0, e.p.f, e.u.c {
    public static final Object W = new Object();
    public boolean A;
    public boolean B;
    public boolean C = true;
    public boolean D;
    public ViewGroup E;
    public View F;
    public boolean G;
    public boolean H = true;
    public c I;
    public boolean J;
    public boolean K;
    public float L;
    public LayoutInflater M;
    public boolean N;
    public g.b O = g.b.RESUMED;
    public k P = new k(this);
    public a1 Q;
    public q<j> R = new q<>();
    public b0.b S;
    public e.u.b T = new e.u.b(this);
    public final AtomicInteger U = new AtomicInteger();
    public final ArrayList<e> V = new ArrayList<>();
    public int b = -1;
    public Bundle c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Parcelable> f1629d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f1630e;

    /* renamed from: f  reason: collision with root package name */
    public String f1631f = UUID.randomUUID().toString();

    /* renamed from: g  reason: collision with root package name */
    public Bundle f1632g;

    /* renamed from: h  reason: collision with root package name */
    public l f1633h;

    /* renamed from: i  reason: collision with root package name */
    public String f1634i = null;

    /* renamed from: j  reason: collision with root package name */
    public int f1635j;

    /* renamed from: k  reason: collision with root package name */
    public Boolean f1636k = null;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1637l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public f0 s;
    public c0<?> t;
    public f0 u = new h0();
    public l v;
    public int w;
    public int x;
    public String y;
    public boolean z;

    public class a implements Runnable {
    }

    public class b extends y {
        public b() {
        }

        @Override // e.m.a.y
        public View e(int i2) {
            View view = l.this.F;
            if (view != null) {
                return view.findViewById(i2);
            }
            StringBuilder h2 = f.a.a.a.a.h("Fragment ");
            h2.append(l.this);
            h2.append(" does not have a view");
            throw new IllegalStateException(h2.toString());
        }

        @Override // e.m.a.y
        public boolean g() {
            return l.this.F != null;
        }
    }

    public static class c {
        public View a;
        public Animator b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f1638d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f1639e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f1640f;

        /* renamed from: g  reason: collision with root package name */
        public Object f1641g;

        /* renamed from: h  reason: collision with root package name */
        public Object f1642h;

        /* renamed from: i  reason: collision with root package name */
        public Object f1643i;

        /* renamed from: j  reason: collision with root package name */
        public int f1644j = 0;

        /* renamed from: k  reason: collision with root package name */
        public View f1645k = null;

        /* renamed from: l  reason: collision with root package name */
        public f f1646l;
        public boolean m;

        public c() {
            Object obj = l.W;
            this.f1641g = obj;
            this.f1642h = obj;
            this.f1643i = obj;
        }
    }

    public static class d extends RuntimeException {
        public d(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static abstract class e {
        public e() {
        }

        public e(a aVar) {
        }

        public abstract void a();
    }

    public interface f {
    }

    public static class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new a();
        public final Bundle b;

        public class a implements Parcelable.ClassLoaderCreator<g> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new g[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }
        }

        public g(Bundle bundle) {
            this.b = bundle;
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.b = readBundle;
            if (classLoader != null && readBundle != null) {
                readBundle.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeBundle(this.b);
        }
    }

    public final String A(int i2, Object... objArr) {
        return v().getString(i2, objArr);
    }

    public j B() {
        a1 a1Var = this.Q;
        if (a1Var != null) {
            return a1Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public final boolean C() {
        return this.t != null && this.f1637l;
    }

    public boolean D() {
        c cVar = this.I;
        if (cVar == null) {
            return false;
        }
        return cVar.m;
    }

    public final boolean E() {
        return this.r > 0;
    }

    public boolean F() {
        c cVar = this.I;
        return false;
    }

    public final boolean G() {
        l lVar = this.v;
        return lVar != null && (lVar.m || lVar.G());
    }

    @Deprecated
    public void H() {
        this.D = true;
    }

    @Deprecated
    public void I(int i2, int i3, Intent intent) {
        if (f0.Q(2)) {
            String str = "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent;
        }
    }

    @Deprecated
    public void J(Activity activity) {
        this.D = true;
    }

    public void K(Context context) {
        this.D = true;
        c0<?> c0Var = this.t;
        Activity activity = c0Var == null ? null : c0Var.b;
        if (activity != null) {
            this.D = false;
            J(activity);
        }
    }

    @Deprecated
    public void L() {
    }

    public boolean M() {
        return false;
    }

    public void N(Bundle bundle) {
        Parcelable parcelable;
        boolean z2 = true;
        this.D = true;
        if (!(bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null)) {
            this.u.g0(parcelable);
            this.u.n();
        }
        f0 f0Var = this.u;
        if (f0Var.p < 1) {
            z2 = false;
        }
        if (!z2) {
            f0Var.n();
        }
    }

    public Animation O() {
        return null;
    }

    public Animator P() {
        return null;
    }

    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
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
        c0<?> c0Var = this.t;
        if ((c0Var == null ? null : c0Var.b) != null) {
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

    @Override // e.p.j
    public e.p.g a() {
        return this.P;
    }

    public void a0(boolean z2) {
    }

    public y b() {
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
        return this.T.b;
    }

    public void d0(Bundle bundle) {
    }

    public void e0() {
        this.D = true;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final c f() {
        if (this.I == null) {
            this.I = new c();
        }
        return this.I;
    }

    public void f0() {
        this.D = true;
    }

    public final r g() {
        c0<?> c0Var = this.t;
        if (c0Var == null) {
            return null;
        }
        return (r) c0Var.b;
    }

    public void g0(View view, Bundle bundle) {
    }

    public View h() {
        c cVar = this.I;
        if (cVar == null) {
            return null;
        }
        return cVar.a;
    }

    public void h0(Bundle bundle) {
        this.D = true;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @Override // e.p.d0
    public c0 i() {
        f0 f0Var = this.s;
        if (f0Var != null) {
            j0 j0Var = f0Var.J;
            c0 c0Var = j0Var.f1625e.get(this.f1631f);
            if (c0Var != null) {
                return c0Var;
            }
            c0 c0Var2 = new c0();
            j0Var.f1625e.put(this.f1631f, c0Var2);
            return c0Var2;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.u.Z();
        boolean z2 = true;
        this.q = true;
        this.Q = new a1();
        View Q2 = Q(layoutInflater, viewGroup, bundle);
        this.F = Q2;
        if (Q2 != null) {
            a1 a1Var = this.Q;
            if (a1Var.b == null) {
                a1Var.b = new k(a1Var);
                a1Var.c = new e.u.b(a1Var);
            }
            this.F.setTag(R$id.view_tree_lifecycle_owner, this.Q);
            this.F.setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this);
            this.F.setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this.Q);
            this.R.l(this.Q);
            return;
        }
        if (this.Q.b == null) {
            z2 = false;
        }
        if (!z2) {
            this.Q = null;
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public final f0 j() {
        if (this.t != null) {
            return this.u;
        }
        throw new IllegalStateException(f.a.a.a.a.s("Fragment ", this, " has not been attached yet."));
    }

    public void j0() {
        this.u.x(1);
        if (this.F != null) {
            this.Q.b(g.a.ON_DESTROY);
        }
        this.b = 1;
        this.D = false;
        R();
        if (this.D) {
            b.C0049b bVar = ((e.q.a.b) e.q.a.a.b(this)).b;
            int h2 = bVar.c.h();
            for (int i2 = 0; i2 < h2; i2++) {
                Objects.requireNonNull(bVar.c.i(i2));
            }
            this.q = false;
            return;
        }
        throw new f1(f.a.a.a.a.s("Fragment ", this, " did not call through to super.onDestroyView()"));
    }

    public Context k() {
        c0<?> c0Var = this.t;
        if (c0Var == null) {
            return null;
        }
        return c0Var.c;
    }

    public void k0() {
        onLowMemory();
        this.u.q();
    }

    @Override // e.p.f
    public b0.b l() {
        if (this.s != null) {
            if (this.S == null) {
                Application application = null;
                Context applicationContext = n0().getApplicationContext();
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
                if (application == null && f0.Q(3)) {
                    StringBuilder h2 = f.a.a.a.a.h("Could not find Application instance from Context ");
                    h2.append(n0().getApplicationContext());
                    h2.append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
                    h2.toString();
                }
                this.S = new v(application, this, this.f1632g);
            }
            return this.S;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public boolean l0(Menu menu) {
        if (!this.z) {
            return false | this.u.w(menu);
        }
        return false;
    }

    public Object m() {
        c cVar = this.I;
        if (cVar == null) {
            return null;
        }
        Objects.requireNonNull(cVar);
        return null;
    }

    public final r m0() {
        r g2 = g();
        if (g2 != null) {
            return g2;
        }
        throw new IllegalStateException(f.a.a.a.a.s("Fragment ", this, " not attached to an activity."));
    }

    public void n() {
        c cVar = this.I;
        if (cVar != null) {
            Objects.requireNonNull(cVar);
        }
    }

    public final Context n0() {
        Context k2 = k();
        if (k2 != null) {
            return k2;
        }
        throw new IllegalStateException(f.a.a.a.a.s("Fragment ", this, " not attached to a context."));
    }

    public Object o() {
        c cVar = this.I;
        if (cVar == null) {
            return null;
        }
        Objects.requireNonNull(cVar);
        return null;
    }

    public final View o0() {
        View view = this.F;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(f.a.a.a.a.s("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.D = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        m0().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.D = true;
    }

    public void p() {
        c cVar = this.I;
        if (cVar != null) {
            Objects.requireNonNull(cVar);
        }
    }

    public void p0(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.u.g0(parcelable);
            this.u.n();
        }
    }

    public final Object q() {
        c0<?> c0Var = this.t;
        if (c0Var == null) {
            return null;
        }
        return c0Var.j();
    }

    public void q0(View view) {
        f().a = view;
    }

    @Deprecated
    public LayoutInflater r() {
        c0<?> c0Var = this.t;
        if (c0Var != null) {
            LayoutInflater k2 = c0Var.k();
            k2.setFactory2(this.u.f1606f);
            return k2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void r0(Animator animator) {
        f().b = animator;
    }

    public int s() {
        c cVar = this.I;
        if (cVar == null) {
            return 0;
        }
        return cVar.c;
    }

    public void s0(Bundle bundle) {
        f0 f0Var = this.s;
        if (f0Var != null) {
            if (f0Var == null ? false : f0Var.U()) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.f1632g = bundle;
    }

    public final f0 t() {
        f0 f0Var = this.s;
        if (f0Var != null) {
            return f0Var;
        }
        throw new IllegalStateException(f.a.a.a.a.s("Fragment ", this, " not associated with a fragment manager."));
    }

    public void t0(boolean z2) {
        f().m = z2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f1631f);
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

    public Object u() {
        c cVar = this.I;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.f1642h;
        if (obj != W) {
            return obj;
        }
        o();
        return null;
    }

    public void u0(int i2) {
        if (this.I != null || i2 != 0) {
            f().c = i2;
        }
    }

    public final Resources v() {
        return n0().getResources();
    }

    public void v0(f fVar) {
        f();
        f fVar2 = this.I.f1646l;
        if (fVar != fVar2) {
            if (fVar != null && fVar2 != null) {
                throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
            } else if (fVar != null) {
                ((f0.o) fVar).c++;
            }
        }
    }

    public Object w() {
        c cVar = this.I;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.f1641g;
        if (obj != W) {
            return obj;
        }
        m();
        return null;
    }

    public void w0(Intent intent) {
        c0<?> c0Var = this.t;
        if (c0Var != null) {
            Context context = c0Var.c;
            Object obj = e.i.b.a.a;
            context.startActivity(intent, null);
            return;
        }
        throw new IllegalStateException(f.a.a.a.a.s("Fragment ", this, " not attached to Activity"));
    }

    public Object x() {
        c cVar = this.I;
        if (cVar == null) {
            return null;
        }
        Objects.requireNonNull(cVar);
        return null;
    }

    public void x0() {
        if (this.I != null) {
            Objects.requireNonNull(f());
        }
    }

    public Object y() {
        c cVar = this.I;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.f1643i;
        if (obj != W) {
            return obj;
        }
        x();
        return null;
    }

    public final String z(int i2) {
        return v().getString(i2);
    }
}
