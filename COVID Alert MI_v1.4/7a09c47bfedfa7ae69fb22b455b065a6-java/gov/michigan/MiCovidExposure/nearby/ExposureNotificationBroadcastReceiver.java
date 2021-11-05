package gov.michigan.MiCovidExposure.nearby;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b.b0.e;
import b.b0.o;
import b.b0.y.k;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import java.util.HashMap;

public class ExposureNotificationBroadcastReceiver extends BroadcastReceiver {
    public static final String TAG = "ENBroadcastReceiver";

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        k b2 = k.b(context);
        if (ExposureNotificationClient.ACTION_EXPOSURE_STATE_UPDATED.equals(action) || ExposureNotificationClient.ACTION_EXPOSURE_NOT_FOUND.equals(action)) {
            String stringExtra = intent.getStringExtra(ExposureNotificationClient.EXTRA_TOKEN);
            o.a aVar = new o.a(StateUpdatedWorker.class);
            HashMap hashMap = new HashMap();
            hashMap.put(ExposureNotificationClient.EXTRA_TOKEN, stringExtra);
            e eVar = new e(hashMap);
            e.h(eVar);
            aVar.f1061c.f1238e = eVar;
            b2.a(aVar.a());
        }
    }
}
