package c.b.a.a.c;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import b.l.d.c;
import b.l.d.q;

public class j extends c {

    /* renamed from: b  reason: collision with root package name */
    public Dialog f2299b;

    /* renamed from: c  reason: collision with root package name */
    public DialogInterface.OnCancelListener f2300c;

    @Override // b.l.d.c
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f2300c;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // b.l.d.c
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f2299b == null) {
            setShowsDialog(false);
        }
        return this.f2299b;
    }

    @Override // b.l.d.c
    public void show(q qVar, String str) {
        super.show(qVar, str);
    }
}
