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
import e.m.a.c0;
import e.m.a.l;
import e.p.j;
import e.p.r;

public class k extends l implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
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
    public r<j> g0 = new d();
    public Dialog h0;
    public boolean i0;
    public boolean j0;
    public boolean k0;
    public boolean l0 = false;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            k kVar = k.this;
            kVar.Z.onDismiss(kVar.h0);
        }
    }

    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            k kVar = k.this;
            Dialog dialog = kVar.h0;
            if (dialog != null) {
                kVar.onCancel(dialog);
            }
        }
    }

    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            k kVar = k.this;
            Dialog dialog = kVar.h0;
            if (dialog != null) {
                kVar.onDismiss(dialog);
            }
        }
    }

    public class d implements r<j> {
        public d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.p.r
        public void a(j jVar) {
            if (jVar != null) {
                k kVar = k.this;
                if (kVar.d0) {
                    View o0 = kVar.o0();
                    if (o0.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    } else if (k.this.h0 != null) {
                        if (c0.Q(3)) {
                            String str = "DialogFragment " + this + " setting the content view on " + k.this.h0;
                        }
                        k.this.h0.setContentView(o0);
                    }
                }
            }
        }
    }

    public class e extends v {
        public final /* synthetic */ v a;

        public e(v vVar) {
            this.a = vVar;
        }

        @Override // e.m.a.v
        public View f(int i2) {
            Dialog dialog = k.this.h0;
            View findViewById = dialog != null ? dialog.findViewById(i2) : null;
            if (findViewById != null) {
                return findViewById;
            }
            if (this.a.g()) {
                return this.a.f(i2);
            }
            return null;
        }

        @Override // e.m.a.v
        public boolean g() {
            return k.this.l0 || this.a.g();
        }
    }

    public final Dialog A0() {
        Dialog dialog = this.h0;
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void B0(c0 c0Var, String str) {
        this.j0 = false;
        this.k0 = true;
        a aVar = new a(c0Var);
        aVar.e(0, this, str, 1);
        aVar.c();
    }

    @Override // e.m.a.l
    public void K(Context context) {
        super.K(context);
        this.R.g(this.g0);
        if (!this.k0) {
            this.j0 = false;
        }
    }

    @Override // e.m.a.l
    public void N(Bundle bundle) {
        super.N(bundle);
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

    @Override // e.m.a.l
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

    @Override // e.m.a.l
    public void S() {
        this.D = true;
        if (!this.k0 && !this.j0) {
            this.j0 = true;
        }
        this.R.k(this.g0);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[Catch:{ all -> 0x0069 }] */
    @Override // e.m.a.l
    public LayoutInflater T(Bundle bundle) {
        Context l2;
        LayoutInflater r = r();
        boolean z = this.d0;
        if (!z || this.f0) {
            if (c0.Q(2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                boolean z2 = this.d0;
            }
            return r;
        }
        if (z && !this.l0) {
            try {
                this.f0 = true;
                Dialog z0 = z0(bundle);
                this.h0 = z0;
                if (this.d0) {
                    int i2 = this.a0;
                    if (!(i2 == 1 || i2 == 2)) {
                        if (i2 != 3) {
                            l2 = l();
                            if (l2 instanceof Activity) {
                                this.h0.setOwnerActivity((Activity) l2);
                            }
                            this.h0.setCancelable(this.c0);
                            this.h0.setOnCancelListener(this.Y);
                            this.h0.setOnDismissListener(this.Z);
                            this.l0 = true;
                        } else {
                            Window window = z0.getWindow();
                            if (window != null) {
                                window.addFlags(24);
                            }
                        }
                    }
                    z0.requestWindowFeature(1);
                    l2 = l();
                    if (l2 instanceof Activity) {
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
        if (c0.Q(2)) {
            String str2 = "get layout inflater for DialogFragment " + this + " from dialog context";
        }
        Dialog dialog = this.h0;
        return dialog != null ? r.cloneInContext(dialog.getContext()) : r;
    }

    @Override // e.m.a.l
    public void d0(Bundle bundle) {
        Dialog dialog = this.h0;
        if (dialog != null) {
            bundle.putBundle("android:savedDialogState", dialog.onSaveInstanceState());
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

    @Override // e.m.a.l
    public v e() {
        return new e(new l.a());
    }

    @Override // e.m.a.l
    public void e0() {
        this.D = true;
        Dialog dialog = this.h0;
        if (dialog != null) {
            this.i0 = false;
            dialog.show();
        }
    }

    @Override // e.m.a.l
    public void f0() {
        this.D = true;
        Dialog dialog = this.h0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // e.m.a.l
    public void h0(Bundle bundle) {
        Bundle bundle2;
        this.D = true;
        if (this.h0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.h0.onRestoreInstanceState(bundle2);
        }
    }

    @Override // e.m.a.l
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
            if (c0.Q(3)) {
                String str = "onDismiss called for DialogFragment " + this;
            }
            y0(true, true);
        }
    }

    public final void y0(boolean z, boolean z2) {
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
                c0 t = t();
                int i2 = this.e0;
                if (i2 >= 0) {
                    t.B(new c0.n(null, i2, 1), false);
                    this.e0 = -1;
                    return;
                }
                throw new IllegalArgumentException(f.a.a.a.a.q("Bad id: ", i2));
            }
            a aVar = new a(t());
            aVar.o(this);
            if (z) {
                aVar.h(true);
            } else {
                aVar.c();
            }
        }
    }

    public Dialog z0(Bundle bundle) {
        if (c0.Q(3)) {
            String str = "onCreateDialog called for DialogFragment " + this;
        }
        return new Dialog(n0(), this.b0);
    }
}
