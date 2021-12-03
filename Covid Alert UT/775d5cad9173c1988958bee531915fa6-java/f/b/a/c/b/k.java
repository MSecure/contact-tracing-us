package f.b.a.c.b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import e.n.a.e0;
import e.n.a.l;

public class k extends l {
    public Dialog m0;
    public DialogInterface.OnCancelListener n0;

    @Override // e.n.a.l
    public Dialog G0(Bundle bundle) {
        Dialog dialog = this.m0;
        if (dialog == null) {
            this.d0 = false;
        }
        return dialog;
    }

    @Override // e.n.a.l
    public void I0(@RecentlyNonNull e0 e0Var, String str) {
        super.I0(e0Var, str);
    }

    @Override // e.n.a.l
    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.n0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
