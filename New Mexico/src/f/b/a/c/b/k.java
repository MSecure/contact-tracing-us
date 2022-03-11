package f.b.a.c.b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import e.o.a.e0;
import e.o.a.l;
/* loaded from: classes.dex */
public class k extends l {
    public Dialog m0;
    public DialogInterface.OnCancelListener n0;

    @Override // e.o.a.l
    public Dialog I0(Bundle bundle) {
        Dialog dialog = this.m0;
        if (dialog == null) {
            this.d0 = false;
        }
        return dialog;
    }

    @Override // e.o.a.l
    public void K0(@RecentlyNonNull e0 e0Var, String str) {
        super.K0(e0Var, str);
    }

    @Override // e.o.a.l, android.content.DialogInterface.OnCancelListener
    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.n0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
