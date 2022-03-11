package e.d;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.biometric.R$drawable;
import e.j.b.a;
import e.r.t;
/* loaded from: classes.dex */
public class y implements t<Integer> {
    public final /* synthetic */ x a;

    public y(x xVar) {
        this.a = xVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r1 == 1) goto L_0x0041;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r1 == 3) goto L_0x0041;
     */
    @Override // e.r.t
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void a(Integer num) {
        int i2;
        Integer num2 = num;
        x xVar = this.a;
        xVar.m0.removeCallbacks(xVar.n0);
        x xVar2 = this.a;
        int intValue = num2.intValue();
        boolean z = false;
        if (xVar2.r0 != null && Build.VERSION.SDK_INT >= 23) {
            int i3 = xVar2.o0.x;
            Context k2 = xVar2.k();
            Drawable drawable = null;
            if (k2 != null) {
                if (!(i3 == 0 && intValue == 1)) {
                    if (i3 == 1 && intValue == 2) {
                        i2 = R$drawable.fingerprint_dialog_error;
                        Object obj = a.a;
                        drawable = a.b.b(k2, i2);
                    } else {
                        if (i3 == 2) {
                        }
                        if (i3 == 1) {
                        }
                    }
                }
                i2 = R$drawable.fingerprint_dialog_fp_icon;
                Object obj2 = a.a;
                drawable = a.b.b(k2, i2);
            }
            if (drawable != null) {
                xVar2.r0.setImageDrawable(drawable);
                if ((!(i3 == 0 && intValue == 1) && ((i3 == 1 && intValue == 2) || (i3 == 2 && intValue == 1))) && (drawable instanceof AnimatedVectorDrawable)) {
                    ((AnimatedVectorDrawable) drawable).start();
                }
                xVar2.o0.x = intValue;
            }
        }
        x xVar3 = this.a;
        int intValue2 = num2.intValue();
        TextView textView = xVar3.s0;
        if (textView != null) {
            if (intValue2 == 2) {
                z = true;
            }
            textView.setTextColor(z ? xVar3.p0 : xVar3.q0);
        }
        x xVar4 = this.a;
        xVar4.m0.postDelayed(xVar4.n0, 2000);
    }
}
