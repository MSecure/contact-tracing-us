package c.b.a.a.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
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
import android.util.TypedValue;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b.i.d.f;
import b.i.d.g;
import b.i.d.h;
import b.l.d.m;
import b.l.d.z;
import b.x.t;
import c.b.a.a.b.b;
import c.b.a.a.d.k.o.j;
import c.b.a.a.d.m.p;
import c.b.a.a.d.m.q;
import c.b.a.a.d.m.r;
import c.b.a.a.d.m.s;

public class d extends e {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f2926c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final d f2927d = new d();

    @SuppressLint({"HandlerLeak"})
    public class a extends c.b.a.a.g.a.d {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2928a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f2928a = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                int c2 = d.this.c(this.f2928a);
                PendingIntent pendingIntent = null;
                if (d.this == null) {
                    throw null;
                } else if (g.c(c2)) {
                    d dVar = d.this;
                    Context context = this.f2928a;
                    Intent a2 = dVar.a(context, c2, "n");
                    if (a2 != null) {
                        pendingIntent = PendingIntent.getActivity(context, 0, a2, 134217728);
                    }
                    dVar.g(context, c2, pendingIntent);
                }
            }
        }
    }

    public static Dialog e(Context context, int i, p pVar, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(q.f(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String string = context.getResources().getString(i != 1 ? i != 2 ? i != 3 ? 17039370 : b.common_google_play_services_enable_button : b.common_google_play_services_update_button : b.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, pVar);
        }
        String b2 = q.b(context, i);
        if (b2 != null) {
            builder.setTitle(b2);
        }
        String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i));
        new IllegalArgumentException();
        return builder.create();
    }

    public static void f(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof m) {
            z supportFragmentManager = ((m) activity).getSupportFragmentManager();
            j jVar = new j();
            t.D(dialog, "Cannot display null dialog");
            dialog.setOnCancelListener(null);
            dialog.setOnDismissListener(null);
            jVar.f2936b = dialog;
            if (onCancelListener != null) {
                jVar.f2937c = onCancelListener;
            }
            jVar.show(supportFragmentManager, str);
            return;
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        b bVar = new b();
        t.D(dialog, "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        bVar.f2921b = dialog;
        if (onCancelListener != null) {
            bVar.f2922c = onCancelListener;
        }
        bVar.show(fragmentManager, str);
    }

    @Override // c.b.a.a.d.e
    @RecentlyNullable
    public Intent a(Context context, @RecentlyNonNull int i, String str) {
        return super.a(context, i, str);
    }

    @Override // c.b.a.a.d.e
    @RecentlyNonNull
    public int b(@RecentlyNonNull Context context, @RecentlyNonNull int i) {
        return super.b(context, i);
    }

    @RecentlyNonNull
    public int c(@RecentlyNonNull Context context) {
        return b(context, e.f2930a);
    }

    @RecentlyNonNull
    public boolean d(@RecentlyNonNull Activity activity, @RecentlyNonNull int i, @RecentlyNonNull int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog e2 = e(activity, i, new r(super.a(activity, i, "d"), activity, i2), onCancelListener);
        if (e2 == null) {
            return false;
        }
        f(activity, e2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    @TargetApi(20)
    public final void g(Context context, int i, PendingIntent pendingIntent) {
        int i2;
        String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i), null);
        new IllegalArgumentException();
        if (i == 18) {
            new a(context).sendEmptyMessageDelayed(1, 120000);
        } else if (pendingIntent != null) {
            String c2 = i == 6 ? q.c(context, "common_google_play_services_resolution_required_title") : q.b(context, i);
            if (c2 == null) {
                c2 = context.getResources().getString(b.common_google_play_services_notification_ticker);
            }
            String d2 = (i == 6 || i == 19) ? q.d(context, "common_google_play_services_resolution_required_text", q.e(context)) : q.f(context, i);
            Resources resources = context.getResources();
            Object systemService = context.getSystemService("notification");
            t.C(systemService);
            NotificationManager notificationManager = (NotificationManager) systemService;
            h hVar = new h(context, null);
            hVar.j = true;
            hVar.c(16, true);
            hVar.f1676d = h.b(c2);
            g gVar = new g();
            gVar.f1672c = h.b(d2);
            hVar.d(gVar);
            if (t.Y1(context)) {
                hVar.s.icon = context.getApplicationInfo().icon;
                hVar.f1679g = 2;
                if (t.Z1(context)) {
                    hVar.f1674b.add(new f(c.b.a.a.b.a.common_full_open_on_phone, resources.getString(b.common_open_on_phone), pendingIntent));
                } else {
                    hVar.f1678f = pendingIntent;
                }
            } else {
                hVar.s.icon = 17301642;
                hVar.s.tickerText = h.b(resources.getString(b.common_google_play_services_notification_ticker));
                hVar.s.when = System.currentTimeMillis();
                hVar.f1678f = pendingIntent;
                hVar.f1677e = h.b(d2);
            }
            if (t.T1()) {
                if (t.T1()) {
                    synchronized (f2926c) {
                    }
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                    String a2 = q.a(context);
                    if (notificationChannel == null) {
                        notificationChannel = new NotificationChannel("com.google.android.gms.availability", a2, 4);
                    } else {
                        if (!a2.contentEquals(notificationChannel.getName())) {
                            notificationChannel.setName(a2);
                        }
                        hVar.o = "com.google.android.gms.availability";
                    }
                    notificationManager.createNotificationChannel(notificationChannel);
                    hVar.o = "com.google.android.gms.availability";
                } else {
                    throw new IllegalStateException();
                }
            }
            Notification a3 = hVar.a();
            if (i == 1 || i == 2 || i == 3) {
                i2 = 10436;
                g.f2933b.set(false);
            } else {
                i2 = 39789;
            }
            notificationManager.notify(i2, a3);
        }
    }

    @RecentlyNonNull
    public final boolean h(@RecentlyNonNull Activity activity, @RecentlyNonNull j jVar, @RecentlyNonNull int i, DialogInterface.OnCancelListener onCancelListener) {
        Dialog e2 = e(activity, i, new s(super.a(activity, i, "d"), jVar), onCancelListener);
        if (e2 == null) {
            return false;
        }
        f(activity, e2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }
}
