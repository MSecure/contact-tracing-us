package org.pathcheck.covidsafepaths.exposurenotifications.common;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.ForegroundInfo;
import com.horcrux.svg.R;
import java.util.Objects;
import org.pathcheck.covidsafepaths.MainActivity;

public final class NotificationHelper {
    public static final Integer BACKGROUND_WORKER_NOTIFICATION_ID = 1;
    public static final Integer EXPOSURE_NOTIFICATION_ID = 0;

    public static ForegroundInfo createWorkerNotification(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("EXPOSURE_CHECK_NOTIFICATION_CHANNEL_ID", context.getString(R.string.background_worker_channel_name), 4);
            notificationChannel.setDescription(context.getString(R.string.background_worker_channel_description));
            ((NotificationManager) Objects.requireNonNull((NotificationManager) context.getSystemService(NotificationManager.class))).createNotificationChannel(notificationChannel);
        }
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(context, "EXPOSURE_CHECK_NOTIFICATION_CHANNEL_ID");
        notificationCompat$Builder.mNotification.icon = R.drawable.ic_notification;
        notificationCompat$Builder.mColor = context.getResources().getColor(R.color.colorPrimary, context.getTheme());
        notificationCompat$Builder.setContentTitle(context.getString(R.string.background_worker_notification_title));
        notificationCompat$Builder.setFlag(2, true);
        return new ForegroundInfo(BACKGROUND_WORKER_NOTIFICATION_ID.intValue(), notificationCompat$Builder.build());
    }

    public static void showPossibleExposureNotification(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("EXPOSURE_NOTIFICATION_CHANNEL_ID", context.getString(R.string.exposure_notification_channel_name), 4);
            notificationChannel.setDescription(context.getString(R.string.exposure_notification_channel_description));
            ((NotificationManager) Objects.requireNonNull((NotificationManager) context.getSystemService(NotificationManager.class))).createNotificationChannel(notificationChannel);
        }
        Intent intent = new Intent(context, MainActivity.class);
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("pathcheck://exposureHistory"));
        intent.setFlags(603979776);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(context, "EXPOSURE_NOTIFICATION_CHANNEL_ID");
        notificationCompat$Builder.mNotification.icon = R.drawable.ic_notification;
        notificationCompat$Builder.mColor = context.getResources().getColor(R.color.colorPrimary, context.getTheme());
        notificationCompat$Builder.setContentTitle(context.getString(R.string.exposure_notification_title));
        notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(context.getString(R.string.exposure_notification_message));
        NotificationCompat$BigTextStyle notificationCompat$BigTextStyle = new NotificationCompat$BigTextStyle();
        notificationCompat$BigTextStyle.mBigText = NotificationCompat$Builder.limitCharSequenceLength(context.getString(R.string.exposure_notification_message));
        notificationCompat$Builder.setStyle(notificationCompat$BigTextStyle);
        notificationCompat$Builder.mPriority = 2;
        notificationCompat$Builder.mContentIntent = activity;
        boolean z = true;
        notificationCompat$Builder.setFlag(8, true);
        notificationCompat$Builder.setFlag(16, true);
        notificationCompat$Builder.mVisibility = -1;
        NotificationManagerCompat notificationManagerCompat = new NotificationManagerCompat(context);
        int intValue = EXPOSURE_NOTIFICATION_ID.intValue();
        Notification build = notificationCompat$Builder.build();
        Bundle bundle = build.extras;
        if (bundle == null || !bundle.getBoolean("android.support.useSideChannel")) {
            z = false;
        }
        if (z) {
            NotificationManagerCompat.NotifyTask notifyTask = new NotificationManagerCompat.NotifyTask(notificationManagerCompat.mContext.getPackageName(), intValue, null, build);
            synchronized (NotificationManagerCompat.sLock) {
                if (NotificationManagerCompat.sSideChannelManager == null) {
                    NotificationManagerCompat.sSideChannelManager = new NotificationManagerCompat.SideChannelManager(notificationManagerCompat.mContext.getApplicationContext());
                }
                NotificationManagerCompat.sSideChannelManager.mHandler.obtainMessage(0, notifyTask).sendToTarget();
            }
            notificationManagerCompat.mNotificationManager.cancel(null, intValue);
            return;
        }
        notificationManagerCompat.mNotificationManager.notify(null, intValue, build);
    }
}
