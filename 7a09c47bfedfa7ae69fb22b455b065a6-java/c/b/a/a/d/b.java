package c.b.a.a.d;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;

public class b extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public Dialog f2921b;

    /* renamed from: c  reason: collision with root package name */
    public DialogInterface.OnCancelListener f2922c;

    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f2922c;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f2921b == null) {
            setShowsDialog(false);
        }
        return this.f2921b;
    }

    @Override // android.app.DialogFragment
    public void show(@RecentlyNonNull FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
