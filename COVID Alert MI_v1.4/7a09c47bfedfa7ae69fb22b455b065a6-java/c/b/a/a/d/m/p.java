package c.b.a.a.d.m;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.os.Build;

public abstract class p implements DialogInterface.OnClickListener {
    public abstract void a();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            a();
        } catch (ActivityNotFoundException unused) {
            if (Build.FINGERPRINT.contains("generic")) {
                "Failed to start resolution intent.".concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
