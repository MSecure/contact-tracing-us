package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import f.b.a.c.b.a;
import f.b.a.c.b.d;
import f.b.a.c.b.l.l.e;
import java.util.Objects;

@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    public static final /* synthetic */ int c = 0;
    public int b = 0;

    public void onActivityResult(@RecentlyNonNull int i2, @RecentlyNonNull int i3, @RecentlyNonNull Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.b = 0;
            setResult(i3, intent);
            if (booleanExtra) {
                e a = e.a(this);
                if (i3 == -1) {
                    Handler handler = a.f2413j;
                    handler.sendMessage(handler.obtainMessage(3));
                } else if (i3 == 0) {
                    a aVar = new a(13, null);
                    int intExtra = getIntent().getIntExtra("failing_client_id", -1);
                    if (!a.b(aVar, intExtra)) {
                        Handler handler2 = a.f2413j;
                        handler2.sendMessage(handler2.obtainMessage(5, intExtra, 0, aVar));
                    }
                }
            }
        } else if (i2 == 2) {
            this.b = 0;
            setResult(i3, intent);
        }
        finish();
    }

    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        this.b = 0;
        setResult(0);
        finish();
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        if (bundle != null) {
            this.b = bundle.getInt("resolution");
        }
        if (this.b != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                str = "Activity started without extras";
            } else {
                PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
                Integer num = (Integer) extras.get("error_code");
                if (pendingIntent == null && num == null) {
                    str = "Activity started without resolution";
                } else if (pendingIntent != null) {
                    try {
                        startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                        this.b = 1;
                        return;
                    } catch (ActivityNotFoundException e2) {
                        if (extras.getBoolean("notify_manager", true)) {
                            e a = e.a(this);
                            a aVar = new a(22, null);
                            int intExtra = getIntent().getIntExtra("failing_client_id", -1);
                            if (!a.b(aVar, intExtra)) {
                                Handler handler = a.f2413j;
                                handler.sendMessage(handler.obtainMessage(5, intExtra, 0, aVar));
                            }
                        } else {
                            String valueOf = String.valueOf(pendingIntent);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 36);
                            sb.append("Activity not found while launching ");
                            sb.append(valueOf);
                            sb.append(".");
                            String sb2 = sb.toString();
                            if (Build.FINGERPRINT.contains("generic")) {
                                sb2 = String.valueOf(sb2).concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                            }
                            Log.e("GoogleApiActivity", sb2, e2);
                        }
                        this.b = 1;
                    } catch (IntentSender.SendIntentException e3) {
                        Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e3);
                    }
                } else {
                    Objects.requireNonNull(num, "null reference");
                    int intValue = num.intValue();
                    Object obj = d.c;
                    d.f2398d.c(this, intValue, 2, this);
                    this.b = 1;
                    return;
                }
            }
            Log.e("GoogleApiActivity", str);
            finish();
        }
    }

    public void onSaveInstanceState(@RecentlyNonNull Bundle bundle) {
        bundle.putInt("resolution", this.b);
        super.onSaveInstanceState(bundle);
    }
}
