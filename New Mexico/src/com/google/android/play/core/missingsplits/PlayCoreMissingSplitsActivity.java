package com.google.android.play.core.missingsplits;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import f.b.a.f.a.e.a;
import f.b.a.f.a.e.n;
/* loaded from: classes.dex */
public class PlayCoreMissingSplitsActivity extends Activity implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        if (i2 == -1) {
            String packageName = getPackageName();
            StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 66);
            sb.append("market://details?id=");
            sb.append(packageName);
            sb.append("&referrer=utm_source%3Dplay.core.missingsplits");
            try {
                startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(sb.toString())).setPackage("com.android.vending"));
            } catch (ActivityNotFoundException unused) {
                String name = getClass().getName();
                int myUid = Process.myUid();
                int myPid = Process.myPid();
                StringBuilder sb2 = new StringBuilder(39);
                sb2.append("UID: [");
                sb2.append(myUid);
                sb2.append("]  PID: [");
                sb2.append(myPid);
                sb2.append("] ");
                String valueOf = String.valueOf(sb2.toString());
                String concat = name.length() != 0 ? valueOf.concat(name) : new String(valueOf);
                Object[] objArr = {packageName};
                if (Log.isLoggable("PlayCore", 6)) {
                    a.f(concat, "Couldn't start missing splits activity for %s", objArr);
                }
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AlertDialog.Builder neutralButton = new AlertDialog.Builder(this).setTitle("Installation failed").setCancelable(false).setNeutralButton("Close", this);
        if (n.b(this)) {
            String charSequence = getApplicationInfo().loadLabel(getPackageManager()).toString();
            StringBuilder sb = new StringBuilder(String.valueOf(charSequence).length() + 91);
            sb.append("The app ");
            sb.append(charSequence);
            sb.append(" is missing required components and must be reinstalled from the Google Play Store.");
            neutralButton.setMessage(sb.toString()).setPositiveButton("Reinstall", this);
        } else {
            String charSequence2 = getApplicationInfo().loadLabel(getPackageManager()).toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(charSequence2).length() + 87);
            sb2.append("The app ");
            sb2.append(charSequence2);
            sb2.append(" is missing required components and must be reinstalled from an official store.");
            neutralButton.setMessage(sb2.toString());
        }
        neutralButton.create().show();
    }
}
