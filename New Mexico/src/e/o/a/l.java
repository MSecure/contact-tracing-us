package e.o.a;

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
import e.o.a.e0;
import e.o.a.m;
import e.r.t;
/* loaded from: classes.dex */
public class l extends m implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public Handler W;
    public boolean f0;
    public Dialog h0;
    public boolean i0;
    public boolean j0;
    public boolean k0;
    public Runnable X = new a();
    public DialogInterface.OnCancelListener Y = new b();
    public DialogInterface.OnDismissListener Z = new c();
    public int a0 = 0;
    public int b0 = 0;
    public boolean c0 = true;
    public boolean d0 = true;
    public int e0 = -1;
    public t<e.r.l> g0 = new d();
    public boolean l0 = false;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            l.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = l.this;
            lVar.Z.onDismiss(lVar.h0);
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
            l.this = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            l lVar = l.this;
            Dialog dialog = lVar.h0;
            if (dialog != null) {
                lVar.onCancel(dialog);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
            l.this = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            l lVar = l.this;
            Dialog dialog = lVar.h0;
            if (dialog != null) {
                lVar.onDismiss(dialog);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements t<e.r.l> {
        public d() {
            l.this = r1;
        }

        @Override // e.r.t
        public void a(e.r.l lVar) {
            if (lVar != null) {
                l lVar2 = l.this;
                if (lVar2.d0) {
                    View w0 = lVar2.w0();
                    if (w0.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    } else if (l.this.h0 != null) {
                        if (e0.P(3)) {
                            String str = "DialogFragment " + this + " setting the content view on " + l.this.h0;
                        }
                        l.this.h0.setContentView(w0);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends x {
        public final /* synthetic */ x a;

        public e(x xVar) {
            l.this = r1;
            this.a = xVar;
        }

        @Override // e.o.a.x
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

        @Override // e.o.a.x
        public boolean g() {
            return this.a.g() || l.this.l0;
        }
    }

    public final void H0(boolean z, boolean z2) {
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
                e0 w = w();
                int i2 = this.e0;
                if (i2 >= 0) {
                    w.A(new e0.m(null, i2, 1), false);
                    this.e0 = -1;
                    return;
                }
                throw new IllegalArgumentException(f.a.a.a.a.u("Bad id: ", i2));
            }
            a aVar = new a(w());
            aVar.o(this);
            if (z) {
                aVar.e();
            } else {
                aVar.d();
            }
        }
    }

    public Dialog I0(Bundle bundle) {
        if (e0.P(3)) {
            String str = "onCreateDialog called for DialogFragment " + this;
        }
        return new Dialog(v0(), this.b0);
    }

    public final Dialog J0() {
        Dialog dialog = this.h0;
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void K0(e0 e0Var, String str) {
        this.j0 = false;
        this.k0 = true;
        a aVar = new a(e0Var);
        aVar.f(0, this, str, 1);
        aVar.d();
    }

    @Override // e.o.a.m
    public void P(Context context) {
        super.P(context);
        this.Q.g(this.g0);
        if (!this.k0) {
            this.j0 = false;
        }
    }

    @Override // e.o.a.m
    public void S(Bundle bundle) {
        super.S(bundle);
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

    @Override // e.o.a.m
    public void X() {
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

    @Override // e.o.a.m
    public void Y() {
        this.D = true;
        if (!this.k0 && !this.j0) {
            this.j0 = true;
        }
        this.Q.k(this.g0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0044 A[Catch: all -> 0x0069, TryCatch #0 {all -> 0x0069, blocks: (B:10:0x0018, B:12:0x0024, B:18:0x002e, B:20:0x0034, B:21:0x0039, B:22:0x003c, B:24:0x0044, B:25:0x004b, B:26:0x0063), top: B:42:0x0018 }] */
    @Override // e.o.a.m
    /* Code decompiled incorrectly, please refer to instructions dump */
    public LayoutInflater Z(Bundle bundle) {
        Context k2;
        LayoutInflater u = u();
        boolean z = this.d0;
        if (!z || this.f0) {
            if (e0.P(2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                boolean z2 = this.d0;
            }
            return u;
        }
        if (z && !this.l0) {
            try {
                this.f0 = true;
                Dialog I0 = I0(bundle);
                this.h0 = I0;
                if (this.d0) {
                    int i2 = this.a0;
                    if (!(i2 == 1 || i2 == 2)) {
                        if (i2 == 3) {
                            Window window = I0.getWindow();
                            if (window != null) {
                                window.addFlags(24);
                            }
                        } else {
                            k2 = k();
                            if (k2 instanceof Activity) {
                                this.h0.setOwnerActivity((Activity) k2);
                            }
                            this.h0.setCancelable(this.c0);
                            this.h0.setOnCancelListener(this.Y);
                            this.h0.setOnDismissListener(this.Z);
                            this.l0 = true;
                        }
                    }
                    I0.requestWindowFeature(1);
                    k2 = k();
                    if (k2 instanceof Activity) {
                    }
                    this.h0.setCancelable(this.c0);
                    this.h0.setOnCancelListener(this.Y);
                    this.h0.setOnDismissListener(this.Z);
                    this.l0 = true;
                } else {
                    this.h0 = null;
                }
            } finally {
                this.f0 = false;
            }
        }
        if (e0.P(2)) {
            String str2 = "get layout inflater for DialogFragment " + this + " from dialog context";
        }
        Dialog dialog = this.h0;
        return dialog != null ? u.cloneInContext(dialog.getContext()) : u;
    }

    @Override // e.o.a.m
    public x b() {
        return new e(new m.b());
    }

    @Override // e.o.a.m
    public void j0(Bundle bundle) {
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

    @Override // e.o.a.m
    public void k0() {
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

    @Override // e.o.a.m
    public void l0() {
        this.D = true;
        Dialog dialog = this.h0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // e.o.a.m
    public void n0(Bundle bundle) {
        Bundle bundle2;
        this.D = true;
        if (this.h0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.h0.onRestoreInstanceState(bundle2);
        }
    }

    @Override // e.o.a.m
    public void o0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.o0(layoutInflater, viewGroup, bundle);
        if (this.F == null && this.h0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.h0.onRestoreInstanceState(bundle2);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.i0) {
            if (e0.P(3)) {
                String str = "onDismiss called for DialogFragment " + this;
            }
            H0(true, true);
        }
    }
}
