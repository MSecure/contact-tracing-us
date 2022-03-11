package f.b.a.c.b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import e.m.a.f0;

public class k extends e.m.a.k {
    public Dialog n0;
    public DialogInterface.OnCancelListener o0;

    @Override // e.m.a.k
    public void B0(@RecentlyNonNull f0 f0Var, String str) {
        super.B0(f0Var, str);
    }

    @Override // e.m.a.k
    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.o0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // e.m.a.k
    public Dialog z0(Bundle bundle) {
        Dialog dialog = this.n0;
        if (dialog == null) {
            this.e0 = false;
        }
        return dialog;
    }
}
