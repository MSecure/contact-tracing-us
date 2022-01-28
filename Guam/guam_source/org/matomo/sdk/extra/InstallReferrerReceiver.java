package org.matomo.sdk.extra;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Collections;
import java.util.List;
import org.matomo.sdk.Matomo;
import timber.log.Timber;

public class InstallReferrerReceiver extends BroadcastReceiver {
    public static final List<String> RESPONSIBILITIES = Collections.singletonList("com.android.vending.INSTALL_REFERRER");
    public static final String TAG = Matomo.tag(InstallReferrerReceiver.class);

    public static void lambda$onReceive$0(Context context, String str, BroadcastReceiver.PendingResult pendingResult) {
        Matomo.getInstance(context.getApplicationContext()).mBasePreferences.edit().putString("referrer.extras", str).apply();
        Timber.tag(TAG).d("Stored Google Play referrer extras: %s", str);
        pendingResult.finish();
    }

    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        Timber.tag(TAG).d(intent.toString(), new Object[0]);
        if (intent.getAction() == null || !RESPONSIBILITIES.contains(intent.getAction())) {
            Timber.tag(TAG).w("Got called outside our responsibilities: %s", intent.getAction());
        } else if (intent.getBooleanExtra("forwarded", false)) {
            Timber.tag(TAG).d("Dropping forwarded intent", new Object[0]);
        } else {
            if (intent.getAction().equals("com.android.vending.INSTALL_REFERRER") && (stringExtra = intent.getStringExtra("referrer")) != null) {
                new Thread(new Runnable(context, stringExtra, goAsync()) {
                    /* class org.matomo.sdk.extra.$$Lambda$InstallReferrerReceiver$7uguWBD_uSFMSG33eM06q40XaAI */
                    public final /* synthetic */ Context f$0;
                    public final /* synthetic */ String f$1;
                    public final /* synthetic */ BroadcastReceiver.PendingResult f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        InstallReferrerReceiver.lambda$onReceive$0(this.f$0, this.f$1, this.f$2);
                    }
                }).start();
            }
            intent.setComponent(null);
            intent.setPackage(context.getPackageName());
            intent.putExtra("forwarded", true);
            context.sendBroadcast(intent);
        }
    }
}
