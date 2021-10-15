package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.d.a;
import c.b.a.a.d.d;
import c.b.a.a.d.k.o.g;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    public int f5976b = 0;

    @RecentlyNonNull
    public static PendingIntent a(@RecentlyNonNull Context context, @RecentlyNonNull PendingIntent pendingIntent, @RecentlyNonNull int i) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", true);
        return PendingIntent.getActivity(context, 0, intent, 134217728);
    }

    @RecentlyNonNull
    public static Intent b(@RecentlyNonNull Context context, @RecentlyNonNull PendingIntent pendingIntent, @RecentlyNonNull int i, @RecentlyNonNull boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    public void onActivityResult(@RecentlyNonNull int i, @RecentlyNonNull int i2, @RecentlyNonNull Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f5976b = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                g a2 = g.a(this);
                if (i2 == -1) {
                    Handler handler = a2.m;
                    handler.sendMessage(handler.obtainMessage(3));
                } else if (i2 == 0) {
                    a2.f(new a(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i == 2) {
            this.f5976b = 0;
            setResult(i2, intent);
        }
        finish();
    }

    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        this.f5976b = 0;
        setResult(0);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f5976b = bundle.getInt("resolution");
        }
        if (this.f5976b != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                finish();
            } else if (pendingIntent != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.f5976b = 1;
                } catch (ActivityNotFoundException unused) {
                    if (extras.getBoolean("notify_manager", true)) {
                        g.a(this).f(new a(22, null), getIntent().getIntExtra("failing_client_id", -1));
                    } else {
                        String valueOf = String.valueOf(pendingIntent);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 36);
                        sb.append("Activity not found while launching ");
                        sb.append(valueOf);
                        sb.append(".");
                        String sb2 = sb.toString();
                        if (Build.FINGERPRINT.contains("generic")) {
                            String.valueOf(sb2).concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                        }
                    }
                    this.f5976b = 1;
                    finish();
                } catch (IntentSender.SendIntentException unused2) {
                    finish();
                }
            } else {
                t.C(num);
                d.f2927d.d(this, num.intValue(), 2, this);
                this.f5976b = 1;
            }
        }
    }

    public void onSaveInstanceState(@RecentlyNonNull Bundle bundle) {
        bundle.putInt("resolution", this.f5976b);
        super.onSaveInstanceState(bundle);
    }
}
