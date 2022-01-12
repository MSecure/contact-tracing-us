package com.google.android.gms.common.internal;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class zab implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            zae zae = (zae) this;
            Intent intent = zae.zaa;
            if (intent != null) {
                zae.zab.startActivityForResult(intent, zae.zac);
            }
        } catch (ActivityNotFoundException e) {
            String str = "Failed to start resolution intent.";
            if (Build.FINGERPRINT.contains("generic")) {
                str = str.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
            }
            Log.e("DialogRedirect", str, e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
