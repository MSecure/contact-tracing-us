package c.b.a.a.d;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import b.l.d.l;
import b.l.d.z;

public class j extends l {

    /* renamed from: b  reason: collision with root package name */
    public Dialog f2936b;

    /* renamed from: c  reason: collision with root package name */
    public DialogInterface.OnCancelListener f2937c;

    @Override // b.l.d.l
    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f2937c;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // b.l.d.l
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f2936b == null) {
            setShowsDialog(false);
        }
        return this.f2936b;
    }

    @Override // b.l.d.l
    public void show(@RecentlyNonNull z zVar, String str) {
        super.show(zVar, str);
    }
}
