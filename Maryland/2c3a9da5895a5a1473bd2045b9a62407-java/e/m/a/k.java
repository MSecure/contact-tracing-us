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
import e.m.a.f0;
import e.m.a.l;
import e.p.j;
import e.p.r;

public class k extends l implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public Handler X;
    public Runnable Y = new a();
    public DialogInterface.OnCancelListener Z = new b();
    public DialogInterface.OnDismissListener a0 = new c();
    public int b0 = 0;
    public int c0 = 0;
    public boolean d0 = true;
    public boolean e0 = true;
    public int f0 = -1;
    public boolean g0;
    public r<j> h0 = new d();
    public Dialog i0;
    public boolean j0;
    public boolean k0;
    public boolean l0;
    public boolean m0 = false;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            k kVar = k.this;
            kVar.a0.onDismiss(kVar.i0);
        }
    }

    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            k kVar = k.this;
            Dialog dialog = kVar.i0;
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
            Dialog dialog = kVar.i0;
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
                if (kVar.e0) {
                    View o0 = kVar.o0();
                    if (o0.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    } else if (k.this.i0 != null) {
                        if (f0.Q(3)) {
                            String str = "DialogFragment " + this + " setting the content view on " + k.this.i0;
                        }
                        k.this.i0.setContentView(o0);
                    }
                }
            }
        }
    }

    public class e extends y {
        public final /* synthetic */ y a;

        public e(y yVar) {
            this.a = yVar;
        }

        @Override // e.m.a.y
        public View e(int i2) {
            Dialog dialog = k.this.i0;
            View findViewById = dialog != null ? dialog.findViewById(i2) : null;
            if (findViewById != null) {
                return findViewById;
            }
            if (this.a.g()) {
                return this.a.e(i2);
            }
            return null;
        }

        @Override // e.m.a.y
        public boolean g() {
            return k.this.m0 || this.a.g();
        }
    }

    public final Dialog A0() {
        Dialog dialog = this.i0;
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void B0(f0 f0Var, String str) {
        this.k0 = false;
        this.l0 = true;
        a aVar = new a(f0Var);
        aVar.e(0, this, str, 1);
        aVar.c();
    }

    @Override // e.m.a.l
    public void K(Context context) {
        super.K(context);
        this.R.g(this.h0);
        if (!this.l0) {
            this.k0 = false;
        }
    }

    @Override // e.m.a.l
    public void N(Bundle bundle) {
        super.N(bundle);
        this.X = new Handler();
        this.e0 = this.x == 0;
        if (bundle != null) {
            this.b0 = bundle.getInt("android:style", 0);
            this.c0 = bundle.getInt("android:theme", 0);
            this.d0 = bundle.getBoolean("android:cancelable", true);
            this.e0 = bundle.getBoolean("android:showsDialog", this.e0);
            this.f0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        Dialog dialog = this.i0;
        if (dialog != null) {
            this.j0 = true;
            dialog.setOnDismissListener(null);
            this.i0.dismiss();
            if (!this.k0) {
                onDismiss(this.i0);
            }
            this.i0 = null;
            this.m0 = false;
        }
    }

    @Override // e.m.a.l
    public void S() {
        this.D = true;
        if (!this.l0 && !this.k0) {
            this.k0 = true;
        }
        this.R.k(this.h0);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[Catch:{ all -> 0x0069 }] */
    @Override // e.m.a.l
    public LayoutInflater T(Bundle bundle) {
        Context k2;
        LayoutInflater r = r();
        boolean z = this.e0;
        if (!z || this.g0) {
            if (f0.Q(2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                boolean z2 = this.e0;
            }
            return r;
        }
        if (z && !this.m0) {
            try {
                this.g0 = true;
                Dialog z0 = z0(bundle);
                this.i0 = z0;
                if (this.e0) {
                    int i2 = this.b0;
                    if (!(i2 == 1 || i2 == 2)) {
                        if (i2 != 3) {
                            k2 = k();
                            if (k2 instanceof Activity) {
                                this.i0.setOwnerActivity((Activity) k2);
                            }
                            this.i0.setCancelable(this.d0);
                            this.i0.setOnCancelListener(this.Z);
                            this.i0.setOnDismissListener(this.a0);
                            this.m0 = true;
                        } else {
                            Window window = z0.getWindow();
                            if (window != null) {
                                window.addFlags(24);
                            }
                        }
                    }
                    z0.requestWindowFeature(1);
                    k2 = k();
                    if (k2 instanceof Activity) {
                    }
                    this.i0.setCancelable(this.d0);
                    this.i0.setOnCancelListener(this.Z);
                    this.i0.setOnDismissListener(this.a0);
                    this.m0 = true;
                } else {
                    this.i0 = null;
                }
                this.g0 = false;
            } catch (Throwable th) {
                this.g0 = false;
                throw th;
            }
        }
        if (f0.Q(2)) {
            String str2 = "get layout inflater for DialogFragment " + this + " from dialog context";
        }
        Dialog dialog = this.i0;
        return dialog != null ? r.cloneInContext(dialog.getContext()) : r;
    }

    @Override // e.m.a.l
    public y b() {
        return new e(new l.b());
    }

    @Override // e.m.a.l
    public void d0(Bundle bundle) {
        Dialog dialog = this.i0;
        if (dialog != null) {
            bundle.putBundle("android:savedDialogState", dialog.onSaveInstanceState());
        }
        int i2 = this.b0;
        if (i2 != 0) {
            bundle.putInt("android:style", i2);
        }
        int i3 = this.c0;
        if (i3 != 0) {
            bundle.putInt("android:theme", i3);
        }
        boolean z = this.d0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.e0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i4 = this.f0;
        if (i4 != -1) {
            bundle.putInt("android:backStackId", i4);
        }
    }

    @Override // e.m.a.l
    public void e0() {
        this.D = true;
        Dialog dialog = this.i0;
        if (dialog != null) {
            this.j0 = false;
            dialog.show();
        }
    }

    @Override // e.m.a.l
    public void f0() {
        this.D = true;
        Dialog dialog = this.i0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // e.m.a.l
    public void h0(Bundle bundle) {
        Bundle bundle2;
        this.D = true;
        if (this.i0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.i0.onRestoreInstanceState(bundle2);
        }
    }

    @Override // e.m.a.l
    public void i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.i0(layoutInflater, viewGroup, bundle);
        if (this.F == null && this.i0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.i0.onRestoreInstanceState(bundle2);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.j0) {
            if (f0.Q(3)) {
                String str = "onDismiss called for DialogFragment " + this;
            }
            y0(true, true);
        }
    }

    public final void y0(boolean z, boolean z2) {
        if (!this.k0) {
            this.k0 = true;
            this.l0 = false;
            Dialog dialog = this.i0;
            if (dialog != null) {
                dialog.setOnDismissListener(null);
                this.i0.dismiss();
                if (!z2) {
                    if (Looper.myLooper() == this.X.getLooper()) {
                        onDismiss(this.i0);
                    } else {
                        this.X.post(this.Y);
                    }
                }
            }
            this.j0 = true;
            if (this.f0 >= 0) {
                f0 t = t();
                int i2 = this.f0;
                if (i2 >= 0) {
                    t.B(new f0.n(null, i2, 1), false);
                    this.f0 = -1;
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
        if (f0.Q(3)) {
            String str = "onCreateDialog called for DialogFragment " + this;
        }
        return new Dialog(n0(), this.c0);
    }
}
