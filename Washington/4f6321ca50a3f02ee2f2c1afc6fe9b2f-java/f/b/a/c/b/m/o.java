package f.b.a.c.b.m;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public abstract class o implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface dialogInterface, int i2) {
        try {
            q qVar = (q) this;
            Intent intent = qVar.b;
            if (intent != null) {
                qVar.c.startActivityForResult(intent, qVar.f2488d);
            }
        } catch (ActivityNotFoundException e2) {
            String str = "Failed to start resolution intent.";
            if (Build.FINGERPRINT.contains("generic")) {
                str = str.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
            }
            Log.e("DialogRedirect", str, e2);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
