package e.n.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.runtime.R$id;
import e.n.a.e0;
import e.n.a.m;
import e.n.a.m0;
import e.q.t;

public class l extends m implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public Handler W;
    public Runnable X = new a();
    public DialogInterface.OnCancelListener Y = new b();
    public DialogInterface.OnDismissListener Z = new c();
    public int a0 = 0;
    public int b0 = 0;
    public boolean c0 = true;
    public boolean d0 = true;
    public int e0 = -1;
    public boolean f0;
    public t<e.q.l> g0 = new d();
    public Dialog h0;
    public boolean i0;
    public boolean j0;
    public boolean k0;
    public boolean l0 = false;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            l lVar = l.this;
            lVar.Z.onDismiss(lVar.h0);
        }
    }

    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            l lVar = l.this;
            Dialog dialog = lVar.h0;
            if (dialog != null) {
                lVar.onCancel(dialog);
            }
        }
    }

    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            l lVar = l.this;
            Dialog dialog = lVar.h0;
            if (dialog != null) {
                lVar.onDismiss(dialog);
            }
        }
    }

    public class d implements t<e.q.l> {
        public d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.q.t
        public void a(e.q.l lVar) {
            if (lVar != null) {
                l lVar2 = l.this;
                if (lVar2.d0) {
                    View u0 = lVar2.u0();
                    if (u0.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    } else if (l.this.h0 != null) {
                        if (e0.O(3)) {
                            String str = "DialogFragment " + this + " setting the content view on " + l.this.h0;
                        }
                        l.this.h0.setContentView(u0);
                    }
                }
            }
        }
    }

    public class e extends x {
        public final /* synthetic */ x a;

        public e(x xVar) {
            this.a = xVar;
        }

        @Override // e.n.a.x
        public View e(int i2) {
            if (this.a.g()) {
                return this.a.e(i2);
            }
            Dialog dialog = l.this.h0;
            if (dialog != null) {
                return dialog.findViewById(i2);
            }
            return null;
        }

        @Override // e.n.a.x
        public boolean g() {
            return this.a.g() || l.this.l0;
        }
    }

    public final void F0(boolean z, boolean z2) {
        if (!this.j0) {
            this.j0 = true;
            this.k0 = false;
            Dialog dialog = this.h0;
            if (dialog != null) {
                dialog.setOnDismissListener(null);
                this.h0.dismiss();
                if (!z2) {
                    if (Looper.myLooper() == this.W.getLooper()) {
                        onDismiss(this.h0);
                    } else {
                        this.W.post(this.X);
                    }
                }
            }
            this.i0 = true;
            if (this.e0 >= 0) {
                e0 v = v();
                int i2 = this.e0;
                if (i2 >= 0) {
                    v.A(new e0.m(null, i2, 1), false);
                    this.e0 = -1;
                    return;
                }
                throw new IllegalArgumentException(f.a.a.a.a.t("Bad id: ", i2));
            }
            a aVar = new a(v());
            e0 e0Var = this.s;
            if (e0Var == null || e0Var == aVar.q) {
                aVar.b(new m0.a(3, this));
                if (z) {
                    aVar.h(true);
                } else {
                    aVar.d();
                }
            } else {
                StringBuilder h2 = f.a.a.a.a.h("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
                h2.append(toString());
                h2.append(" is already attached to a FragmentManager.");
                throw new IllegalStateException(h2.toString());
            }
        }
    }

    public Dialog G0(Bundle bundle) {
        if (e0.O(3)) {
            String str = "onCreateDialog called for DialogFragment " + this;
        }
        return new Dialog(t0(), this.b0);
    }

    public final Dialog H0() {
        Dialog dialog = this.h0;
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void I0(e0 e0Var, String str) {
        this.j0 = false;
        this.k0 = true;
        a aVar = new a(e0Var);
        aVar.e(0, this, str, 1);
        aVar.d();
    }

    @Override // e.n.a.m
    public void N(Context context) {
        super.N(context);
        this.Q.g(this.g0);
        if (!this.k0) {
            this.j0 = false;
        }
    }

    @Override // e.n.a.m
    public void Q(Bundle bundle) {
        super.Q(bundle);
        this.W = new Handler();
        this.d0 = this.x == 0;
        if (bundle != null) {
            this.a0 = bundle.getInt("android:style", 0);
            this.b0 = bundle.getInt("android:theme", 0);
            this.c0 = bundle.getBoolean("android:cancelable", true);
            this.d0 = bundle.getBoolean("android:showsDialog", this.d0);
            this.e0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        Dialog dialog = this.h0;
        if (dialog != null) {
            this.i0 = true;
            dialog.setOnDismissListener(null);
            this.h0.dismiss();
            if (!this.j0) {
                onDismiss(this.h0);
            }
            this.h0 = null;
            this.l0 = false;
        }
    }

    @Override // e.n.a.m
    public void W() {
        this.D = true;
        if (!this.k0 && !this.j0) {
            this.j0 = true;
        }
        this.Q.k(this.g0);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[Catch:{ all -> 0x0069 }] */
    @Override // e.n.a.m
    public LayoutInflater X(Bundle bundle) {
        Context j2;
        LayoutInflater t = t();
        boolean z = this.d0;
        if (!z || this.f0) {
            if (e0.O(2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                boolean z2 = this.d0;
            }
            return t;
        }
        if (z && !this.l0) {
            try {
                this.f0 = true;
                Dialog G0 = G0(bundle);
                this.h0 = G0;
                if (this.d0) {
                    int i2 = this.a0;
                    if (!(i2 == 1 || i2 == 2)) {
                        if (i2 != 3) {
                            j2 = j();
                            if (j2 instanceof Activity) {
                                this.h0.setOwnerActivity((Activity) j2);
                            }
                            this.h0.setCancelable(this.c0);
                            this.h0.setOnCancelListener(this.Y);
                            this.h0.setOnDismissListener(this.Z);
                            this.l0 = true;
                        } else {
                            Window window = G0.getWindow();
                            if (window != null) {
                                window.addFlags(24);
                            }
                        }
                    }
                    G0.requestWindowFeature(1);
                    j2 = j();
                    if (j2 instanceof Activity) {
                    }
                    this.h0.setCancelable(this.c0);
                    this.h0.setOnCancelListener(this.Y);
                    this.h0.setOnDismissListener(this.Z);
                    this.l0 = true;
                } else {
                    this.h0 = null;
                }
                this.f0 = false;
            } catch (Throwable th) {
                this.f0 = false;
                throw th;
            }
        }
        if (e0.O(2)) {
            String str2 = "get layout inflater for DialogFragment " + this + " from dialog context";
        }
        Dialog dialog = this.h0;
        return dialog != null ? t.cloneInContext(dialog.getContext()) : t;
    }

    @Override // e.n.a.m
    public x b() {
        return new e(new m.b());
    }

    @Override // e.n.a.m
    public void h0(Bundle bundle) {
        Dialog dialog = this.h0;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i2 = this.a0;
        if (i2 != 0) {
            bundle.putInt("android:style", i2);
        }
        int i3 = this.b0;
        if (i3 != 0) {
            bundle.putInt("android:theme", i3);
        }
        boolean z = this.c0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.d0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i4 = this.e0;
        if (i4 != -1) {
            bundle.putInt("android:backStackId", i4);
        }
    }

    @Override // e.n.a.m
    public void i0() {
        this.D = true;
        Dialog dialog = this.h0;
        if (dialog != null) {
            this.i0 = false;
            dialog.show();
            View decorView = this.h0.getWindow().getDecorView();
            decorView.setTag(R$id.view_tree_lifecycle_owner, this);
            decorView.setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this);
            decorView.setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // e.n.a.m
    public void j0() {
        this.D = true;
        Dialog dialog = this.h0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // e.n.a.m
    public void l0(Bundle bundle) {
        Bundle bundle2;
        this.D = true;
        if (this.h0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.h0.onRestoreInstanceState(bundle2);
        }
    }

    @Override // e.n.a.m
    public void m0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.m0(layoutInflater, viewGroup, bundle);
        if (this.F == null && this.h0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.h0.onRestoreInstanceState(bundle2);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.i0) {
            if (e0.O(3)) {
                String str = "onDismiss called for DialogFragment " + this;
            }
            F0(true, true);
        }
    }
}
