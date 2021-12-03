package f.b.a.a.a.s;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import e.i.a.i;
import e.i.a.j;
import e.i.a.n;
import e.i.b.a;
import f.b.b.a.l;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;

public final class v {
    public static j a(Context context, String str, String str2, PendingIntent pendingIntent, l<PendingIntent> lVar) {
        j jVar = new j(context, "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID");
        jVar.r.icon = R.drawable.ic_exposure_notification;
        jVar.n = a.a(context, R.color.notification_color);
        jVar.f1464e = j.b(str);
        jVar.f1465f = j.b(str2);
        i iVar = new i();
        iVar.b = j.b(str2);
        jVar.d(iVar);
        jVar.f1467h = 2;
        jVar.f1466g = pendingIntent;
        jVar.c(8, true);
        jVar.c(16, true);
        jVar.o = -1;
        if (lVar.b()) {
            jVar.r.deleteIntent = lVar.a();
        }
        return jVar;
    }

    public final void b(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID", context.getString(R.string.notification_channel_name), 4);
            notificationChannel.setDescription(context.getString(R.string.notification_channel_description));
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            Objects.requireNonNull(notificationManager);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void c(Context context, int i2, int i3, Intent intent, Intent intent2) {
        PendingIntent pendingIntent;
        int i4;
        String string = context.getString(i2);
        String string2 = context.getString(i3);
        b(context);
        if (Build.VERSION.SDK_INT >= 23) {
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 201326592);
            i4 = 335544320;
        } else {
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 134217728);
            i4 = 268435456;
        }
        new n(context).a(0, a(context, string, string2, pendingIntent, l.c(PendingIntent.getBroadcast(context, 0, intent2, i4))).a());
    }

    public void d(Context context, int i2, int i3) {
        b(context);
        Intent a = u.a(context);
        PendingIntent activity = Build.VERSION.SDK_INT >= 23 ? PendingIntent.getActivity(context, 0, a, 67108864) : PendingIntent.getActivity(context, 0, a, 0);
        String string = context.getString(i2);
        f.b.a.a.a.s.d0.a aVar = a0.a;
        new n(context).a(1, a(context, string, context.getString(i3, context.getString(R.string.health_authority_name)), activity, f.b.b.a.a.b).a());
    }
}
