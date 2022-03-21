package f.b.a.c.b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import e.m.a.c0;

public class k extends e.m.a.k {
    public Dialog m0;
    public DialogInterface.OnCancelListener n0;

    @Override // e.m.a.k
    public void B0(@RecentlyNonNull c0 c0Var, String str) {
        super.B0(c0Var, str);
    }

    @Override // e.m.a.k
    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.n0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // e.m.a.k
    public Dialog z0(Bundle bundle) {
        Dialog dialog = this.m0;
        if (dialog == null) {
            this.d0 = false;
        }
        return dialog;
    }
}
