package e.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.biometric.R$attr;
import androidx.biometric.R$color;
import androidx.biometric.R$id;
import androidx.biometric.R$layout;
import androidx.biometric.R$string;
import e.b.a.g;
import e.b.a.m;
import e.o.a.l;
import e.o.a.r;
import e.r.f0;
import e.r.s;
/* loaded from: classes.dex */
public class x extends l {
    public final Handler m0 = new Handler(Looper.getMainLooper());
    public final Runnable n0 = new a();
    public u o0;
    public int p0;
    public int q0;
    public ImageView r0;
    public TextView s0;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            x.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            x xVar = x.this;
            Context k2 = xVar.k();
            if (k2 != null) {
                xVar.o0.m(1);
                xVar.o0.l(k2.getString(R$string.fingerprint_dialog_touch_sensor));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener {
        public b() {
            x.this = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            x.this.o0.n(true);
        }
    }

    @Override // e.o.a.l
    public Dialog I0(Bundle bundle) {
        g.a aVar = new g.a(v0());
        CharSequence j2 = this.o0.j();
        AlertController.b bVar = aVar.a;
        bVar.f31d = j2;
        View inflate = LayoutInflater.from(bVar.a).inflate(R$layout.fingerprint_dialog_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R$id.fingerprint_subtitle);
        if (textView != null) {
            this.o0.i();
            if (TextUtils.isEmpty(null)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText((CharSequence) null);
            }
        }
        TextView textView2 = (TextView) inflate.findViewById(R$id.fingerprint_description);
        if (textView2 != null) {
            this.o0.g();
            if (TextUtils.isEmpty(null)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText((CharSequence) null);
            }
        }
        this.r0 = (ImageView) inflate.findViewById(R$id.fingerprint_icon);
        this.s0 = (TextView) inflate.findViewById(R$id.fingerprint_error);
        CharSequence F = m.e.N0(this.o0.c()) ? F(R$string.confirm_device_credential_password) : this.o0.h();
        b bVar2 = new b();
        AlertController.b bVar3 = aVar.a;
        bVar3.f36i = F;
        bVar3.f37j = bVar2;
        bVar3.r = inflate;
        bVar3.q = 0;
        g a2 = aVar.a();
        a2.setCanceledOnTouchOutside(false);
        return a2;
    }

    public final int L0(int i2) {
        Context k2 = k();
        r g2 = g();
        if (k2 == null || g2 == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        k2.getTheme().resolveAttribute(i2, typedValue, true);
        TypedArray obtainStyledAttributes = g2.obtainStyledAttributes(typedValue.data, new int[]{i2});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    @Override // e.o.a.l, e.o.a.m
    public void S(Bundle bundle) {
        int a2;
        super.S(bundle);
        r g2 = g();
        if (g2 != null) {
            u uVar = (u) new f0(g2).a(u.class);
            this.o0 = uVar;
            if (uVar.y == null) {
                uVar.y = new s<>();
            }
            uVar.y.f(this, new y(this));
            u uVar2 = this.o0;
            if (uVar2.z == null) {
                uVar2.z = new s<>();
            }
            uVar2.z.f(this, new z(this));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            a2 = L0(R$attr.colorError);
        } else {
            Context k2 = k();
            a2 = k2 != null ? e.j.b.a.a(k2, R$color.biometric_error_color) : 0;
        }
        this.p0 = a2;
        this.q0 = L0(16842808);
    }

    @Override // e.o.a.m
    public void e0() {
        this.D = true;
        this.m0.removeCallbacksAndMessages(null);
    }

    @Override // e.o.a.m
    public void i0() {
        this.D = true;
        u uVar = this.o0;
        uVar.x = 0;
        uVar.m(1);
        this.o0.l(F(R$string.fingerprint_dialog_touch_sensor));
    }

    @Override // e.o.a.l, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        u uVar = this.o0;
        if (uVar.w == null) {
            uVar.w = new s<>();
        }
        u.o(uVar.w, Boolean.TRUE);
    }
}
