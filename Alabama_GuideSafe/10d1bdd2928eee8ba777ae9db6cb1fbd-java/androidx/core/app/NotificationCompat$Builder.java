package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class NotificationCompat$Builder {
    public ArrayList<NotificationCompat$Action> mActions = new ArrayList<>();
    public boolean mAllowSystemGeneratedContextualActions;
    public int mBadgeIcon = 0;
    public String mChannelId;
    public int mColor = 0;
    public PendingIntent mContentIntent;
    public CharSequence mContentText;
    public CharSequence mContentTitle;
    public RemoteViews mContentView;
    public Context mContext;
    public Bundle mExtras;
    public int mGroupAlertBehavior = 0;
    public ArrayList<NotificationCompat$Action> mInvisibleActions = new ArrayList<>();
    public boolean mLocalOnly = false;
    public Notification mNotification;
    @Deprecated
    public ArrayList<String> mPeople;
    public int mPriority;
    public boolean mShowWhen = true;
    public NotificationCompat$Style mStyle;
    public int mVisibility = 0;

    public NotificationCompat$Builder(Context context, String str) {
        Notification notification = new Notification();
        this.mNotification = notification;
        this.mContext = context;
        this.mChannelId = str;
        notification.when = System.currentTimeMillis();
        this.mNotification.audioStreamType = -1;
        this.mPriority = 0;
        this.mPeople = new ArrayList<>();
        this.mAllowSystemGeneratedContextualActions = true;
    }

    public static CharSequence limitCharSequenceLength(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public Notification build() {
        Notification notification;
        NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
        NotificationCompat$Style notificationCompat$Style = notificationCompatBuilder.mBuilderCompat.mStyle;
        if (notificationCompat$Style != null) {
            NotificationCompat$BigTextStyle notificationCompat$BigTextStyle = (NotificationCompat$BigTextStyle) notificationCompat$Style;
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationCompatBuilder.mBuilder).setBigContentTitle(null).bigText(notificationCompat$BigTextStyle.mBigText);
            if (notificationCompat$BigTextStyle.mSummaryTextSet) {
                bigText.setSummaryText(null);
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            notification = notificationCompatBuilder.mBuilder.build();
        } else if (i >= 24) {
            notification = notificationCompatBuilder.mBuilder.build();
            if (notificationCompatBuilder.mGroupAlertBehavior != 0) {
                if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || notificationCompatBuilder.mGroupAlertBehavior != 2)) {
                    notificationCompatBuilder.removeSoundAndVibration(notification);
                }
                if (notification.getGroup() != null && (notification.flags & 512) == 0 && notificationCompatBuilder.mGroupAlertBehavior == 1) {
                    notificationCompatBuilder.removeSoundAndVibration(notification);
                }
            }
        } else {
            notificationCompatBuilder.mBuilder.setExtras(notificationCompatBuilder.mExtras);
            notification = notificationCompatBuilder.mBuilder.build();
            RemoteViews remoteViews = notificationCompatBuilder.mContentView;
            if (remoteViews != null) {
                notification.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = notificationCompatBuilder.mBigContentView;
            if (remoteViews2 != null) {
                notification.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = notificationCompatBuilder.mHeadsUpContentView;
            if (remoteViews3 != null) {
                notification.headsUpContentView = remoteViews3;
            }
            if (notificationCompatBuilder.mGroupAlertBehavior != 0) {
                if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || notificationCompatBuilder.mGroupAlertBehavior != 2)) {
                    notificationCompatBuilder.removeSoundAndVibration(notification);
                }
                if (notification.getGroup() != null && (notification.flags & 512) == 0 && notificationCompatBuilder.mGroupAlertBehavior == 1) {
                    notificationCompatBuilder.removeSoundAndVibration(notification);
                }
            }
        }
        RemoteViews remoteViews4 = notificationCompatBuilder.mBuilderCompat.mContentView;
        if (remoteViews4 != null) {
            notification.contentView = remoteViews4;
        }
        if (notificationCompat$Style == null || notificationCompatBuilder.mBuilderCompat.mStyle != null) {
            if (notificationCompat$Style != null) {
                Bundle bundle = notification.extras;
            }
            return notification;
        }
        throw null;
    }

    public NotificationCompat$Builder setContentTitle(CharSequence charSequence) {
        this.mContentTitle = limitCharSequenceLength(charSequence);
        return this;
    }

    public final void setFlag(int i, boolean z) {
        if (z) {
            Notification notification = this.mNotification;
            notification.flags = i | notification.flags;
            return;
        }
        Notification notification2 = this.mNotification;
        notification2.flags = (~i) & notification2.flags;
    }

    public NotificationCompat$Builder setStyle(NotificationCompat$Style notificationCompat$Style) {
        if (this.mStyle != notificationCompat$Style) {
            this.mStyle = notificationCompat$Style;
            if (notificationCompat$Style.mBuilder != this) {
                notificationCompat$Style.mBuilder = this;
                setStyle(notificationCompat$Style);
            }
        }
        return this;
    }
}
