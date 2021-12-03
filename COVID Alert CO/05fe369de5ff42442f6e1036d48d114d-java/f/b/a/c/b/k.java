package f.b.a.c.b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import e.m.a.e0;
import e.m.a.l;

public class k extends l {
    public Dialog m0;
    public DialogInterface.OnCancelListener n0;

    @Override // e.m.a.l
    public Dialog B0(Bundle bundle) {
        Dialog dialog = this.m0;
        if (dialog == null) {
            this.d0 = false;
        }
        return dialog;
    }

    @Override // e.m.a.l
    public void D0(@RecentlyNonNull e0 e0Var, String str) {
        super.D0(e0Var, str);
    }

    @Override // e.m.a.l
    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.n0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
