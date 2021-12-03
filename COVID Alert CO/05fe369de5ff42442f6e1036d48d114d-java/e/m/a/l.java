package e.m.a;

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
import e.m.a.e0;
import e.m.a.m;
import e.m.a.m0;
import e.p.t;

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
    public t<e.p.l> g0 = new d();
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

    public class d implements t<e.p.l> {
        public d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.p.t
        public void a(e.p.l lVar) {
            if (lVar != null) {
                l lVar2 = l.this;
                if (lVar2.d0) {
                    View q0 = lVar2.q0();
                    if (q0.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    } else if (l.this.h0 != null) {
                        if (e0.O(3)) {
                            String str = "DialogFragment " + this + " setting the content view on " + l.this.h0;
                        }
                        l.this.h0.setContentView(q0);
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

        @Override // e.m.a.x
        public View e(int i2) {
            Dialog dialog = l.this.h0;
            View findViewById = dialog != null ? dialog.findViewById(i2) : null;
            if (findViewById != null) {
                return findViewById;
            }
            if (this.a.g()) {
                return this.a.e(i2);
            }
            return null;
        }

        @Override // e.m.a.x
        public boolean g() {
            return l.this.l0 || this.a.g();
        }
    }

    public final void A0(boolean z, boolean z2) {
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
                e0 u = u();
                int i2 = this.e0;
                if (i2 >= 0) {
                    u.A(new e0.m(null, i2, 1), false);
                    this.e0 = -1;
                    return;
                }
                throw new IllegalArgumentException(f.a.a.a.a.v("Bad id: ", i2));
            }
            a aVar = new a(u());
            e0 e0Var = this.s;
            if (e0Var == null || e0Var == aVar.q) {
                aVar.b(new m0.a(3, this));
                if (z) {
                    aVar.h(true);
                } else {
                    aVar.d();
                }
            } else {
                StringBuilder i3 = f.a.a.a.a.i("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
                i3.append(toString());
                i3.append(" is already attached to a FragmentManager.");
                throw new IllegalStateException(i3.toString());
            }
        }
    }

    public Dialog B0(Bundle bundle) {
        if (e0.O(3)) {
            String str = "onCreateDialog called for DialogFragment " + this;
        }
        return new Dialog(p0(), this.b0);
    }

    public final Dialog C0() {
        Dialog dialog = this.h0;
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void D0(e0 e0Var, String str) {
        this.j0 = false;
        this.k0 = true;
        a aVar = new a(e0Var);
        aVar.e(0, this, str, 1);
        aVar.d();
    }

    @Override // e.m.a.m
    public void J(Context context) {
        super.J(context);
        this.Q.g(this.g0);
        if (!this.k0) {
            this.j0 = false;
        }
    }

    @Override // e.m.a.m
    public void M(Bundle bundle) {
        super.M(bundle);
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

    @Override // e.m.a.m
    public void R() {
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

    @Override // e.m.a.m
    public void S() {
        this.D = true;
        if (!this.k0 && !this.j0) {
            this.j0 = true;
        }
        this.Q.k(this.g0);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[Catch:{ all -> 0x0069 }] */
    @Override // e.m.a.m
    public LayoutInflater T(Bundle bundle) {
        Context j2;
        LayoutInflater r = r();
        boolean z = this.d0;
        if (!z || this.f0) {
            if (e0.O(2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                boolean z2 = this.d0;
            }
            return r;
        }
        if (z && !this.l0) {
            try {
                this.f0 = true;
                Dialog B0 = B0(bundle);
                this.h0 = B0;
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
                            Window window = B0.getWindow();
                            if (window != null) {
                                window.addFlags(24);
                            }
                        }
                    }
                    B0.requestWindowFeature(1);
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
        return dialog != null ? r.cloneInContext(dialog.getContext()) : r;
    }

    @Override // e.m.a.m
    public x b() {
        return new e(new m.b());
    }

    @Override // e.m.a.m
    public void d0(Bundle bundle) {
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

    @Override // e.m.a.m
    public void e0() {
        this.D = true;
        Dialog dialog = this.h0;
        if (dialog != null) {
            this.i0 = false;
            dialog.show();
        }
    }

    @Override // e.m.a.m
    public void f0() {
        this.D = true;
        Dialog dialog = this.h0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // e.m.a.m
    public void h0(Bundle bundle) {
        Bundle bundle2;
        this.D = true;
        if (this.h0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.h0.onRestoreInstanceState(bundle2);
        }
    }

    @Override // e.m.a.m
    public void i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.i0(layoutInflater, viewGroup, bundle);
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
            A0(true, true);
        }
    }
}
