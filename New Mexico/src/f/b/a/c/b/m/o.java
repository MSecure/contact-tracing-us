package f.b.a.c.b.m;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
/* loaded from: classes.dex */
public abstract class o implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        try {
            q qVar = (q) this;
            Intent intent = qVar.b;
            if (intent != null) {
                qVar.c.startActivityForResult(intent, qVar.f2752d);
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
