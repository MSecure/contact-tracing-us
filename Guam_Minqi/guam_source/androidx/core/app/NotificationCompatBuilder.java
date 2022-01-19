package androidx.core.app;

import android.app.Notification;
import android.app.Person;
import android.app.RemoteInput;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotificationCompatBuilder {
    public final List<Bundle> mActionExtrasList = new ArrayList();
    public RemoteViews mBigContentView;
    public final Notification.Builder mBuilder;
    public final NotificationCompat$Builder mBuilderCompat;
    public RemoteViews mContentView;
    public final Bundle mExtras = new Bundle();
    public int mGroupAlertBehavior;
    public RemoteViews mHeadsUpContentView;

    public NotificationCompatBuilder(NotificationCompat$Builder notificationCompat$Builder) {
        List<String> list;
        Bundle bundle;
        this.mBuilderCompat = notificationCompat$Builder;
        if (Build.VERSION.SDK_INT >= 26) {
            this.mBuilder = new Notification.Builder(notificationCompat$Builder.mContext, notificationCompat$Builder.mChannelId);
        } else {
            this.mBuilder = new Notification.Builder(notificationCompat$Builder.mContext);
        }
        Notification notification = notificationCompat$Builder.mNotification;
        this.mBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(notificationCompat$Builder.mContentTitle).setContentText(notificationCompat$Builder.mContentText).setContentInfo(null).setContentIntent(notificationCompat$Builder.mContentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) == 0 ? false : true).setLargeIcon((Bitmap) null).setNumber(0).setProgress(0, 0, false);
        this.mBuilder.setSubText(null).setUsesChronometer(false).setPriority(notificationCompat$Builder.mPriority);
        Iterator<NotificationCompat$Action> it = notificationCompat$Builder.mActions.iterator();
        while (it.hasNext()) {
            NotificationCompat$Action next = it.next();
            IconCompat iconCompat = next.getIconCompat();
            Notification.Action.Builder builder = new Notification.Action.Builder(iconCompat != null ? iconCompat.toIcon() : null, next.title, next.actionIntent);
            RemoteInput[] remoteInputArr = next.mRemoteInputs;
            if (remoteInputArr != null) {
                int length = remoteInputArr.length;
                RemoteInput[] remoteInputArr2 = new RemoteInput[length];
                if (remoteInputArr.length <= 0) {
                    for (int i = 0; i < length; i++) {
                        builder.addRemoteInput(remoteInputArr2[i]);
                    }
                } else {
                    RemoteInput remoteInput = remoteInputArr[0];
                    throw null;
                }
            }
            if (next.mExtras != null) {
                bundle = new Bundle(next.mExtras);
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", next.mAllowGeneratedReplies);
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(next.mAllowGeneratedReplies);
            }
            bundle.putInt("android.support.action.semanticAction", next.mSemanticAction);
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(next.mSemanticAction);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setContextual(next.mIsContextual);
            }
            bundle.putBoolean("android.support.action.showsUserInterface", next.mShowsUserInterface);
            builder.addExtras(bundle);
            this.mBuilder.addAction(builder.build());
        }
        Bundle bundle2 = notificationCompat$Builder.mExtras;
        if (bundle2 != null) {
            this.mExtras.putAll(bundle2);
        }
        this.mContentView = null;
        this.mBigContentView = null;
        this.mBuilder.setShowWhen(notificationCompat$Builder.mShowWhen);
        this.mBuilder.setLocalOnly(notificationCompat$Builder.mLocalOnly).setGroup(null).setGroupSummary(false).setSortKey(null);
        this.mGroupAlertBehavior = notificationCompat$Builder.mGroupAlertBehavior;
        this.mBuilder.setCategory(null).setColor(notificationCompat$Builder.mColor).setVisibility(notificationCompat$Builder.mVisibility).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        if (Build.VERSION.SDK_INT < 28) {
            list = combineLists(getPeople(notificationCompat$Builder.mPersonList), notificationCompat$Builder.mPeople);
        } else {
            list = notificationCompat$Builder.mPeople;
        }
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                this.mBuilder.addPerson(str);
            }
        }
        this.mHeadsUpContentView = null;
        if (notificationCompat$Builder.mInvisibleActions.size() > 0) {
            if (notificationCompat$Builder.mExtras == null) {
                notificationCompat$Builder.mExtras = new Bundle();
            }
            Bundle bundle3 = notificationCompat$Builder.mExtras.getBundle("android.car.EXTENSIONS");
            bundle3 = bundle3 == null ? new Bundle() : bundle3;
            Bundle bundle4 = new Bundle(bundle3);
            Bundle bundle5 = new Bundle();
            for (int i2 = 0; i2 < notificationCompat$Builder.mInvisibleActions.size(); i2++) {
                bundle5.putBundle(Integer.toString(i2), NotificationCompatJellybean.getBundleForAction(notificationCompat$Builder.mInvisibleActions.get(i2)));
            }
            bundle3.putBundle("invisible_actions", bundle5);
            bundle4.putBundle("invisible_actions", bundle5);
            if (notificationCompat$Builder.mExtras == null) {
                notificationCompat$Builder.mExtras = new Bundle();
            }
            notificationCompat$Builder.mExtras.putBundle("android.car.EXTENSIONS", bundle3);
            this.mExtras.putBundle("android.car.EXTENSIONS", bundle4);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.mBuilder.setExtras(notificationCompat$Builder.mExtras).setRemoteInputHistory(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.mBuilder.setBadgeIconType(notificationCompat$Builder.mBadgeIcon).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0).setGroupAlertBehavior(notificationCompat$Builder.mGroupAlertBehavior);
            if (!TextUtils.isEmpty(notificationCompat$Builder.mChannelId)) {
                this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Iterator<Person> it2 = notificationCompat$Builder.mPersonList.iterator();
            while (it2.hasNext()) {
                Person next2 = it2.next();
                Notification.Builder builder2 = this.mBuilder;
                if (next2 != null) {
                    builder2.addPerson(new Person.Builder().setName(null).setIcon(null).setUri(null).setKey(null).setBot(false).setImportant(false).build());
                } else {
                    throw null;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.mBuilder.setAllowSystemGeneratedContextualActions(notificationCompat$Builder.mAllowSystemGeneratedContextualActions);
            this.mBuilder.setBubbleMetadata(null);
        }
    }

    public static List<String> combineLists(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list2.size() + list.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    public static List<String> getPeople(List<Person> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Person person : list) {
            if (person != null) {
                arrayList.add("");
            } else {
                throw null;
            }
        }
        return arrayList;
    }

    public final void removeSoundAndVibration(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i = notification.defaults & -2;
        notification.defaults = i;
        notification.defaults = i & -3;
    }
}
