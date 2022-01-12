package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$string;
import com.google.android.gms.common.internal.zac;
import com.google.android.gms.common.internal.zae;
import com.google.android.gms.internal.base.zap;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public class GoogleApiAvailability extends GoogleApiAvailabilityLight {
    public static final Object zaa = new Object();
    public static final GoogleApiAvailability zab = new GoogleApiAvailability();

    @SuppressLint({"HandlerLeak"})
    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public class zaa extends zap {
        public final Context zaa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public zaa(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.zaa = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int isGooglePlayServicesAvailable = GoogleApiAvailability.this.isGooglePlayServicesAvailable(this.zaa);
            PendingIntent pendingIntent = null;
            if (GoogleApiAvailability.this == null) {
                throw null;
            } else if (GooglePlayServicesUtilLight.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.this;
                Context context = this.zaa;
                Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(context, isGooglePlayServicesAvailable, "n");
                if (errorResolutionIntent != null) {
                    pendingIntent = PendingIntent.getActivity(context, 0, errorResolutionIntent, 134217728);
                }
                googleApiAvailability.zaa(context, isGooglePlayServicesAvailable, pendingIntent);
            }
        }
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @RecentlyNullable
    public Intent getErrorResolutionIntent(Context context, @RecentlyNonNull int i, String str) {
        return super.getErrorResolutionIntent(context, i, str);
    }

    @RecentlyNonNull
    public int isGooglePlayServicesAvailable(@RecentlyNonNull Context context) {
        return isGooglePlayServicesAvailable(context, GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @RecentlyNonNull
    public boolean showErrorDialogFragment(@RecentlyNonNull Activity activity, @RecentlyNonNull int i, @RecentlyNonNull int i2, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialog;
        String str;
        zae zae = new zae(super.getErrorResolutionIntent(activity, i, "d"), activity, i2);
        if (i == 0) {
            alertDialog = null;
        } else {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
            if (builder == null) {
                builder = new AlertDialog.Builder(activity);
            }
            builder.setMessage(zac.zac(activity, i));
            builder.setOnCancelListener(onCancelListener);
            Resources resources = activity.getResources();
            if (i == 1) {
                str = resources.getString(R$string.common_google_play_services_install_button);
            } else if (i == 2) {
                str = resources.getString(R$string.common_google_play_services_update_button);
            } else if (i != 3) {
                str = resources.getString(17039370);
            } else {
                str = resources.getString(R$string.common_google_play_services_enable_button);
            }
            if (str != null) {
                builder.setPositiveButton(str, zae);
            }
            String zaa2 = zac.zaa(activity, i);
            if (zaa2 != null) {
                builder.setTitle(zaa2);
            }
            Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i)), new IllegalArgumentException());
            alertDialog = builder.create();
        }
        if (alertDialog == null) {
            return false;
        }
        if (activity instanceof FragmentActivity) {
            FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
            ReactYogaConfigProvider.checkNotNull(alertDialog, "Cannot display null dialog");
            alertDialog.setOnCancelListener(null);
            alertDialog.setOnDismissListener(null);
            supportErrorDialogFragment.zaa = alertDialog;
            supportErrorDialogFragment.zab = onCancelListener;
            supportErrorDialogFragment.show(supportFragmentManager, "GooglePlayServicesErrorDialog");
        } else {
            android.app.FragmentManager fragmentManager = activity.getFragmentManager();
            ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
            ReactYogaConfigProvider.checkNotNull(alertDialog, "Cannot display null dialog");
            alertDialog.setOnCancelListener(null);
            alertDialog.setOnDismissListener(null);
            errorDialogFragment.zaa = alertDialog;
            errorDialogFragment.zab = onCancelListener;
            errorDialogFragment.show(fragmentManager, "GooglePlayServicesErrorDialog");
        }
        return true;
    }

    @TargetApi(20)
    public final void zaa(Context context, int i, PendingIntent pendingIntent) {
        String str;
        String str2;
        int i2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i), null), new IllegalArgumentException());
        if (i == 18) {
            new zaa(context).sendEmptyMessageDelayed(1, 120000);
        } else if (pendingIntent != null) {
            if (i == 6) {
                str = zac.zaa(context, "common_google_play_services_resolution_required_title");
            } else {
                str = zac.zaa(context, i);
            }
            if (str == null) {
                str = context.getResources().getString(R$string.common_google_play_services_notification_ticker);
            }
            if (i == 6 || i == 19) {
                str2 = zac.zaa(context, "common_google_play_services_resolution_required_text", zac.zab(context));
            } else {
                str2 = zac.zac(context, i);
            }
            Resources resources = context.getResources();
            Object systemService = context.getSystemService("notification");
            ReactYogaConfigProvider.checkNotNull(systemService);
            NotificationManager notificationManager = (NotificationManager) systemService;
            NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(context, null);
            notificationCompat$Builder.mLocalOnly = true;
            notificationCompat$Builder.setFlag(16, true);
            notificationCompat$Builder.setContentTitle(str);
            NotificationCompat$BigTextStyle notificationCompat$BigTextStyle = new NotificationCompat$BigTextStyle();
            notificationCompat$BigTextStyle.mBigText = NotificationCompat$Builder.limitCharSequenceLength(str2);
            notificationCompat$Builder.setStyle(notificationCompat$BigTextStyle);
            if (ReactYogaConfigProvider.isWearable(context)) {
                notificationCompat$Builder.mNotification.icon = context.getApplicationInfo().icon;
                notificationCompat$Builder.mPriority = 2;
                if (ReactYogaConfigProvider.isWearableWithoutPlayStore(context)) {
                    notificationCompat$Builder.mActions.add(new NotificationCompat$Action(R$drawable.common_full_open_on_phone, resources.getString(R$string.common_open_on_phone), pendingIntent));
                } else {
                    notificationCompat$Builder.mContentIntent = pendingIntent;
                }
            } else {
                notificationCompat$Builder.mNotification.icon = 17301642;
                String string = resources.getString(R$string.common_google_play_services_notification_ticker);
                notificationCompat$Builder.mNotification.tickerText = NotificationCompat$Builder.limitCharSequenceLength(string);
                notificationCompat$Builder.mNotification.when = System.currentTimeMillis();
                notificationCompat$Builder.mContentIntent = pendingIntent;
                notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(str2);
            }
            if (ReactYogaConfigProvider.isAtLeastO()) {
                if (ReactYogaConfigProvider.isAtLeastO()) {
                    synchronized (zaa) {
                    }
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                    String zaa2 = zac.zaa(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", zaa2, 4));
                    } else if (!zaa2.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(zaa2);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                    notificationCompat$Builder.mChannelId = "com.google.android.gms.availability";
                } else {
                    throw new IllegalStateException();
                }
            }
            Notification build = notificationCompat$Builder.build();
            if (i == 1 || i == 2 || i == 3) {
                i2 = 10436;
                GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
            } else {
                i2 = 39789;
            }
            notificationManager.notify(i2, build);
        } else if (i == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @RecentlyNonNull
    public int isGooglePlayServicesAvailable(@RecentlyNonNull Context context, @RecentlyNonNull int i) {
        return super.isGooglePlayServicesAvailable(context, i);
    }
}
