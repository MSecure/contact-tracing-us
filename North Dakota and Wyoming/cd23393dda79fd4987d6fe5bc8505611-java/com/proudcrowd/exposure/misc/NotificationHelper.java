package com.proudcrowd.exposure.misc;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.activity.MainActivity;
import java.util.Objects;

public final class NotificationHelper {
    public static final String ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION = "com.proudcrowd.exposure.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION";
    private static final String EXPOSURE_NOTIFICATION_CHANNEL_ID = "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID";

    public static void showPossibleExposureNotification(Context context) {
        createNotificationChannel(context);
        Intent intent = new Intent(context, MainActivity.class);
        intent.setAction(ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION);
        intent.setFlags(268468224);
        NotificationManagerCompat.from(context).notify(0, new NotificationCompat.Builder(context, EXPOSURE_NOTIFICATION_CHANNEL_ID).setSmallIcon(R.drawable.ic_notification).setContentTitle(context.getString(R.string.notification_title)).setContentText(context.getString(R.string.notification_message)).setStyle(new NotificationCompat.BigTextStyle().bigText(context.getString(R.string.notification_message))).setPriority(2).setContentIntent(PendingIntent.getActivity(context, 0, intent, 0)).setOnlyAlertOnce(true).setAutoCancel(true).setVisibility(-1).build());
    }

    private static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(EXPOSURE_NOTIFICATION_CHANNEL_ID, context.getString(R.string.notification_channel_name), 4);
            notificationChannel.setDescription(context.getString(R.string.notification_channel_description));
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            Objects.requireNonNull(notificationManager);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private NotificationHelper() {
    }
}
