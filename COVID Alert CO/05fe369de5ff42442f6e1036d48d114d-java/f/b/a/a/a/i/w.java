package f.b.a.a.a.i;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import e.i.a.j;
import e.i.a.k;
import e.i.a.o;
import e.i.b.a;
import f.b.b.a.l;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Objects;

public final class w {
    public static k a(Context context, String str, String str2, PendingIntent pendingIntent, l<PendingIntent> lVar) {
        k kVar = new k(context, "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID");
        kVar.r.icon = R.drawable.ic_exposure_notification;
        kVar.n = a.b(context, R.color.notification_color);
        kVar.f1225e = k.b(str);
        kVar.f1226f = k.b(str2);
        j jVar = new j();
        jVar.b = k.b(str2);
        kVar.d(jVar);
        kVar.f1228h = 2;
        kVar.f1227g = pendingIntent;
        kVar.c(8, true);
        kVar.c(16, true);
        kVar.o = -1;
        if (lVar.b()) {
            kVar.r.deleteIntent = lVar.a();
        }
        return kVar;
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
        String string = context.getString(i2);
        String string2 = context.getString(i3);
        b(context);
        new o(context).a(0, a(context, string, string2, PendingIntent.getActivity(context, 0, intent, 134217728), l.c(PendingIntent.getBroadcast(context, 0, intent2, 268435456))).a());
    }

    public void d(Context context, int i2, int i3) {
        b(context);
        PendingIntent activity = PendingIntent.getActivity(context, 0, v.a(context), 0);
        String string = context.getString(i2);
        f.b.a.a.a.i.e0.a aVar = b0.a;
        new o(context).a(1, a(context, string, context.getString(i3, context.getString(R.string.health_authority_name)), activity, f.b.b.a.a.b).a());
    }
}
