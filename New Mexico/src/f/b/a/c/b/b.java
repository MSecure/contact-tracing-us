package f.b.a.c.b;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
/* loaded from: classes.dex */
public class b extends DialogFragment {
    public Dialog b;
    public DialogInterface.OnCancelListener c;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.c;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.b == null) {
            setShowsDialog(false);
        }
        return this.b;
    }

    @Override // android.app.DialogFragment
    public void show(@RecentlyNonNull FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
