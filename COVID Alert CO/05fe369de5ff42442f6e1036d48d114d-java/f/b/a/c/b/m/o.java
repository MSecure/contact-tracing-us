package f.b.a.c.b.m;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;

public abstract class o implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface dialogInterface, int i2) {
        try {
            q qVar = (q) this;
            Intent intent = qVar.b;
            if (intent != null) {
                qVar.c.startActivityForResult(intent, qVar.f2657d);
            }
        } catch (ActivityNotFoundException unused) {
            if (Build.FINGERPRINT.contains("generic")) {
                "Failed to start resolution intent.".concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
