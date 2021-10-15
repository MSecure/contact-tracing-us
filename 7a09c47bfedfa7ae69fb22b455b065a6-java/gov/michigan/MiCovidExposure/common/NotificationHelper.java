package gov.michigan.MiCovidExposure.common;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import b.i.d.g;
import b.i.d.h;
import b.i.d.l;
import gov.michigan.MiCovidExposure.R;
import gov.michigan.MiCovidExposure.home.ExposureNotificationActivity;
import java.util.Objects;

public final class NotificationHelper {
    public static final String EXPOSURE_NOTIFICATION_CHANNEL_ID = "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID";

    public static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID", context.getString(R.string.notification_channel_name), 4);
            notificationChannel.setDescription(context.getString(R.string.notification_channel_description));
            ((NotificationManager) Objects.requireNonNull((NotificationManager) context.getSystemService(NotificationManager.class))).createNotificationChannel(notificationChannel);
        }
    }

    public static void showPossibleExposureNotification(Context context) {
        createNotificationChannel(context);
        Intent intent = new Intent(context, ExposureNotificationActivity.class);
        intent.setAction("com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION");
        intent.setFlags(268468224);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
        h hVar = new h(context, "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID");
        hVar.s.icon = R.drawable.ic_notification;
        hVar.l = context.getColor(R.color.notification_color);
        hVar.f1676d = h.b(context.getString(R.string.notification_title));
        hVar.f1677e = h.b(context.getString(R.string.notification_message));
        g gVar = new g();
        gVar.f1672c = h.b(context.getString(R.string.notification_message));
        hVar.d(gVar);
        hVar.f1679g = 2;
        hVar.f1678f = activity;
        boolean z = true;
        hVar.c(8, true);
        hVar.c(16, true);
        hVar.m = -1;
        l lVar = new l(context);
        Notification a2 = hVar.a();
        Bundle bundle = a2.extras;
        if (bundle == null || !bundle.getBoolean("android.support.useSideChannel")) {
            z = false;
        }
        if (z) {
            l.a aVar = new l.a(lVar.f1695a.getPackageName(), 0, null, a2);
            synchronized (l.f1693f) {
                if (l.f1694g == null) {
                    l.f1694g = new l.c(lVar.f1695a.getApplicationContext());
                }
                l.f1694g.f1705c.obtainMessage(0, aVar).sendToTarget();
            }
            lVar.f1696b.cancel(null, 0);
            return;
        }
        lVar.f1696b.notify(null, 0, a2);
    }
}
