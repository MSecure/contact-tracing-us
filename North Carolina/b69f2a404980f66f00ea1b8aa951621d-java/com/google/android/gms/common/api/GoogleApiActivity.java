package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import c.b.a.a.c.a;
import c.b.a.a.c.d;
import c.b.a.a.c.k.o.g;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    public int f4428b = 0;

    public static PendingIntent a(Context context, PendingIntent pendingIntent, int i) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", true);
        return PendingIntent.getActivity(context, 0, intent, 134217728);
    }

    public static Intent b(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f4428b = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                g c2 = g.c(this);
                if (i2 == -1) {
                    Handler handler = c2.m;
                    handler.sendMessage(handler.obtainMessage(3));
                } else if (i2 == 0) {
                    a aVar = new a(13, null);
                    int intExtra = getIntent().getIntExtra("failing_client_id", -1);
                    if (!c2.f(aVar, intExtra)) {
                        Handler handler2 = c2.m;
                        handler2.sendMessage(handler2.obtainMessage(5, intExtra, 0, aVar));
                    }
                }
            }
        } else if (i == 2) {
            this.f4428b = 0;
            setResult(i2, intent);
        }
        finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f4428b = 0;
        setResult(0);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f4428b = bundle.getInt("resolution");
        }
        if (this.f4428b != 1) {
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
                    this.f4428b = 1;
                } catch (IntentSender.SendIntentException unused) {
                    finish();
                }
            } else {
                d.f2290d.d(this, num.intValue(), 2, this);
                this.f4428b = 1;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f4428b);
        super.onSaveInstanceState(bundle);
    }
}
