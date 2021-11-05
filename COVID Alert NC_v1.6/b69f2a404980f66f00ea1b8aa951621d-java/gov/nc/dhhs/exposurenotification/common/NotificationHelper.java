package gov.nc.dhhs.exposurenotification.common;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import b.i.d.f;
import b.i.d.g;
import b.i.d.k;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.home.ExposureNotificationActivity;
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

    public static void showGetTestedNotification(Context context) {
        createNotificationChannel(context);
        Intent intent = new Intent(context, ExposureNotificationActivity.class);
        intent.setAction("com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION");
        intent.setFlags(268468224);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
        g gVar = new g(context, "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID");
        gVar.s.icon = R.drawable.ic_notification;
        gVar.l = context.getColor(R.color.notification_color);
        gVar.c(context.getString(R.string.notification_message));
        f fVar = new f();
        fVar.a(context.getString(R.string.get_tested_notification));
        gVar.e(fVar);
        gVar.g = 2;
        gVar.f = activity;
        gVar.d(8, true);
        gVar.d(16, true);
        gVar.m = -1;
        new k(context).a(1, gVar.a());
    }

    public static void showPossibleExposureNotification(Context context) {
        createNotificationChannel(context);
        Intent intent = new Intent(context, ExposureNotificationActivity.class);
        intent.setAction("com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION");
        intent.setFlags(268468224);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
        g gVar = new g(context, "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID");
        gVar.s.icon = R.drawable.ic_notification;
        gVar.l = context.getColor(R.color.notification_color);
        gVar.f987d = g.b(context.getString(R.string.notification_title));
        gVar.c(context.getString(R.string.notification_message));
        f fVar = new f();
        fVar.a(context.getString(R.string.notification_message));
        gVar.e(fVar);
        gVar.g = 2;
        gVar.f = activity;
        gVar.d(8, true);
        gVar.d(16, true);
        gVar.m = -1;
        new k(context).a(0, gVar.a());
    }

    public static void showUpdateNotification(Context context) {
        createNotificationChannel(context);
        PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=gov.nc.dhhs.exposurenotification")), 0);
        g gVar = new g(context, "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID");
        gVar.s.icon = R.drawable.ic_notification;
        gVar.l = context.getColor(R.color.notification_color);
        gVar.c(context.getString(R.string.update_now_text));
        f fVar = new f();
        fVar.a(context.getString(R.string.update_now_text));
        gVar.e(fVar);
        gVar.g = 2;
        gVar.f = activity;
        gVar.d(8, true);
        gVar.d(16, true);
        gVar.m = -1;
        new k(context).a(2, gVar.a());
    }
}
