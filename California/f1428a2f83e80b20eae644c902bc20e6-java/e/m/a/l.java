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
import e.m.a.c0;
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
    public static final Object V = new Object();
    public boolean A;
    public boolean B;
    public boolean C = true;
    public boolean D;
    public ViewGroup E;
    public View F;
    public boolean G;
    public boolean H = true;
    public b I;
    public boolean J;
    public boolean K;
    public float L;
    public LayoutInflater M;
    public boolean N;
    public g.b O = g.b.RESUMED;
    public k P;
    public x0 Q;
    public q<j> R = new q<>();
    public b0.b S;
    public e.u.b T;
    public final ArrayList<d> U;
    public int b = -1;
    public Bundle c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Parcelable> f1618d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f1619e;

    /* renamed from: f  reason: collision with root package name */
    public String f1620f = UUID.randomUUID().toString();

    /* renamed from: g  reason: collision with root package name */
    public Bundle f1621g;

    /* renamed from: h  reason: collision with root package name */
    public l f1622h;

    /* renamed from: i  reason: collision with root package name */
    public String f1623i = null;

    /* renamed from: j  reason: collision with root package name */
    public int f1624j;

    /* renamed from: k  reason: collision with root package name */
    public Boolean f1625k = null;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1626l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public c0 s;
    public z<?> t;
    public c0 u = new e0();
    public l v;
    public int w;
    public int x;
    public String y;
    public boolean z;

    public class a extends v {
        public a() {
        }

        @Override // e.m.a.v
        public View f(int i2) {
            View view = l.this.F;
            if (view != null) {
                return view.findViewById(i2);
            }
            StringBuilder h2 = f.a.a.a.a.h("Fragment ");
            h2.append(l.this);
            h2.append(" does not have a view");
            throw new IllegalStateException(h2.toString());
        }

        @Override // e.m.a.v
        public boolean g() {
            return l.this.F != null;
        }
    }

    public static class b {
        public View a;
        public Animator b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f1627d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f1628e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f1629f;

        /* renamed from: g  reason: collision with root package name */
        public Object f1630g;

        /* renamed from: h  reason: collision with root package name */
        public Object f1631h;

        /* renamed from: i  reason: collision with root package name */
        public Object f1632i;

        /* renamed from: j  reason: collision with root package name */
        public int f1633j = 0;

        /* renamed from: k  reason: collision with root package name */
        public View f1634k = null;

        /* renamed from: l  reason: collision with root package name */
        public e f1635l;
        public boolean m;

        public b() {
            Object obj = l.V;
            this.f1630g = obj;
            this.f1631h = obj;
            this.f1632i = obj;
        }
    }

    public static class c extends RuntimeException {
        public c(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static abstract class d {
        public abstract void a();
    }

    public interface e {
    }

    public static class f implements Parcelable {
        public static final Parcelable.Creator<f> CREATOR = new a();
        public final Bundle b;

        public class a implements Parcelable.ClassLoaderCreator<f> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new f(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new f[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }
        }

        public f(Bundle bundle) {
            this.b = bundle;
        }

        public f(Parcel parcel, ClassLoader classLoader) {
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

    public l() {
        new AtomicInteger();
        this.U = new ArrayList<>();
        this.P = new k(this);
        this.T = new e.u.b(this);
    }

    public final String A(int i2, Object... objArr) {
        return v().getString(i2, objArr);
    }

    public j B() {
        x0 x0Var = this.Q;
        if (x0Var != null) {
            return x0Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public final boolean C() {
        return this.t != null && this.f1626l;
    }

    public boolean D() {
        b bVar = this.I;
        if (bVar == null) {
            return false;
        }
        return bVar.m;
    }

    public final boolean E() {
        return this.r > 0;
    }

    public boolean F() {
        b bVar = this.I;
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
        if (c0.Q(2)) {
            String str = "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent;
        }
    }

    @Deprecated
    public void J(Activity activity) {
        this.D = true;
    }

    public void K(Context context) {
        this.D = true;
        z<?> zVar = this.t;
        Activity activity = zVar == null ? null : zVar.b;
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
        c0 c0Var = this.u;
        if (c0Var.p < 1) {
            z2 = false;
        }
        if (!z2) {
            c0Var.n();
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
        z<?> zVar = this.t;
        if ((zVar == null ? null : zVar.b) != null) {
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
    public g a() {
        return this.P;
    }

    public void a0(boolean z2) {
    }

    @Deprecated
    public void b0() {
    }

    @Override // e.u.c
    public final e.u.a c() {
        return this.T.b;
    }

    public void c0() {
        this.D = true;
    }

    public void d0(Bundle bundle) {
    }

    public v e() {
        return new a();
    }

    public void e0() {
        this.D = true;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final b f() {
        if (this.I == null) {
            this.I = new b();
        }
        return this.I;
    }

    public void f0() {
        this.D = true;
    }

    public final o g() {
        z<?> zVar = this.t;
        if (zVar == null) {
            return null;
        }
        return (o) zVar.b;
    }

    public void g0(View view, Bundle bundle) {
    }

    @Override // e.p.d0
    public c0 h() {
        c0 c0Var = this.s;
        if (c0Var != null) {
            g0 g0Var = c0Var.J;
            c0 c0Var2 = g0Var.f1597e.get(this.f1620f);
            if (c0Var2 != null) {
                return c0Var2;
            }
            c0 c0Var3 = new c0();
            g0Var.f1597e.put(this.f1620f, c0Var3);
            return c0Var3;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void h0(Bundle bundle) {
        this.D = true;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public View i() {
        b bVar = this.I;
        if (bVar == null) {
            return null;
        }
        return bVar.a;
    }

    public void i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.u.Z();
        boolean z2 = true;
        this.q = true;
        this.Q = new x0();
        View Q2 = Q(layoutInflater, viewGroup, bundle);
        this.F = Q2;
        if (Q2 != null) {
            x0 x0Var = this.Q;
            if (x0Var.b == null) {
                x0Var.b = new k(x0Var);
                x0Var.c = new e.u.b(x0Var);
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

    public final c0 j() {
        if (this.t != null) {
            return this.u;
        }
        throw new IllegalStateException(f.a.a.a.a.s("Fragment ", this, " has not been attached yet."));
    }

    public void j0() {
        this.u.x(1);
        if (this.F != null) {
            this.Q.d(g.a.ON_DESTROY);
        }
        this.b = 1;
        this.D = false;
        R();
        if (this.D) {
            b.C0045b bVar = ((e.q.a.b) e.q.a.a.b(this)).b;
            int h2 = bVar.c.h();
            for (int i2 = 0; i2 < h2; i2++) {
                Objects.requireNonNull(bVar.c.i(i2));
            }
            this.q = false;
            return;
        }
        throw new c1(f.a.a.a.a.s("Fragment ", this, " did not call through to super.onDestroyView()"));
    }

    @Override // e.p.f
    public b0.b k() {
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
                if (application == null && c0.Q(3)) {
                    StringBuilder h2 = f.a.a.a.a.h("Could not find Application instance from Context ");
                    h2.append(n0().getApplicationContext());
                    h2.append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
                    h2.toString();
                }
                this.S = new v(application, this, this.f1621g);
            }
            return this.S;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void k0() {
        onLowMemory();
        this.u.q();
    }

    public Context l() {
        z<?> zVar = this.t;
        if (zVar == null) {
            return null;
        }
        return zVar.c;
    }

    public boolean l0(Menu menu) {
        if (!this.z) {
            return false | this.u.w(menu);
        }
        return false;
    }

    public Object m() {
        b bVar = this.I;
        if (bVar == null) {
            return null;
        }
        Objects.requireNonNull(bVar);
        return null;
    }

    public final o m0() {
        o g2 = g();
        if (g2 != null) {
            return g2;
        }
        throw new IllegalStateException(f.a.a.a.a.s("Fragment ", this, " not attached to an activity."));
    }

    public void n() {
        b bVar = this.I;
        if (bVar != null) {
            Objects.requireNonNull(bVar);
        }
    }

    public final Context n0() {
        Context l2 = l();
        if (l2 != null) {
            return l2;
        }
        throw new IllegalStateException(f.a.a.a.a.s("Fragment ", this, " not attached to a context."));
    }

    public Object o() {
        b bVar = this.I;
        if (bVar == null) {
            return null;
        }
        Objects.requireNonNull(bVar);
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
        b bVar = this.I;
        if (bVar != null) {
            Objects.requireNonNull(bVar);
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
        z<?> zVar = this.t;
        if (zVar == null) {
            return null;
        }
        return zVar.j();
    }

    public void q0(View view) {
        f().a = view;
    }

    @Deprecated
    public LayoutInflater r() {
        z<?> zVar = this.t;
        if (zVar != null) {
            LayoutInflater k2 = zVar.k();
            k2.setFactory2(this.u.f1573f);
            return k2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void r0(Animator animator) {
        f().b = animator;
    }

    public int s() {
        b bVar = this.I;
        if (bVar == null) {
            return 0;
        }
        return bVar.c;
    }

    public void s0(Bundle bundle) {
        c0 c0Var = this.s;
        if (c0Var != null) {
            if (c0Var == null ? false : c0Var.U()) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.f1621g = bundle;
    }

    public final c0 t() {
        c0 c0Var = this.s;
        if (c0Var != null) {
            return c0Var;
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
        sb.append(this.f1620f);
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
        b bVar = this.I;
        if (bVar == null) {
            return null;
        }
        Object obj = bVar.f1631h;
        if (obj != V) {
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

    public void v0(e eVar) {
        f();
        e eVar2 = this.I.f1635l;
        if (eVar != eVar2) {
            if (eVar != null && eVar2 != null) {
                throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
            } else if (eVar != null) {
                ((c0.o) eVar).c++;
            }
        }
    }

    public Object w() {
        b bVar = this.I;
        if (bVar == null) {
            return null;
        }
        Object obj = bVar.f1630g;
        if (obj != V) {
            return obj;
        }
        m();
        return null;
    }

    public void w0(Intent intent) {
        z<?> zVar = this.t;
        if (zVar != null) {
            Context context = zVar.c;
            Object obj = e.i.b.a.a;
            context.startActivity(intent, null);
            return;
        }
        throw new IllegalStateException(f.a.a.a.a.s("Fragment ", this, " not attached to Activity"));
    }

    public Object x() {
        b bVar = this.I;
        if (bVar == null) {
            return null;
        }
        Objects.requireNonNull(bVar);
        return null;
    }

    public void x0() {
        if (this.I != null) {
            Objects.requireNonNull(f());
        }
    }

    public Object y() {
        b bVar = this.I;
        if (bVar == null) {
            return null;
        }
        Object obj = bVar.f1632i;
        if (obj != V) {
            return obj;
        }
        x();
        return null;
    }

    public final String z(int i2) {
        return v().getString(i2);
    }
}
