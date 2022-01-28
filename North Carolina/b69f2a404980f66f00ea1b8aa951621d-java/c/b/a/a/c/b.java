package c.b.a.a.c;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

public class b extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public Dialog f2284b;

    /* renamed from: c  reason: collision with root package name */
    public DialogInterface.OnCancelListener f2285c;

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f2285c;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f2284b == null) {
            setShowsDialog(false);
        }
        return this.f2284b;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
