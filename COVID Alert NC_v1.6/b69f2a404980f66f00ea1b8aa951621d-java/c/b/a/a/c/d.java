package c.b.a.a.c;

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
import android.widget.ProgressBar;
import b.b.k.i;
import b.i.d.f;
import b.i.d.g;
import b.l.d.q;
import c.b.a.a.b.b;
import c.b.a.a.c.k.o.j;
import c.b.a.a.c.l.e;
import c.b.a.a.c.l.t;
import c.b.a.a.c.l.u;
import c.b.a.a.c.n.c;

public class d extends e {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f2289c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final d f2290d = new d();

    @SuppressLint({"HandlerLeak"})
    public class a extends c.b.a.a.e.a.d {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2291a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f2291a = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                int c2 = d.this.c(this.f2291a);
                PendingIntent pendingIntent = null;
                if (d.this == null) {
                    throw null;
                } else if (g.d(c2)) {
                    d dVar = d.this;
                    Context context = this.f2291a;
                    Intent a2 = dVar.a(context, c2, "n");
                    if (a2 != null) {
                        pendingIntent = PendingIntent.getActivity(context, 0, a2, 134217728);
                    }
                    dVar.h(context, c2, pendingIntent);
                }
            }
        }
    }

    public static Dialog e(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(c.b.a.a.c.l.d.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        g(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public static Dialog f(Context context, int i, e eVar, DialogInterface.OnCancelListener onCancelListener) {
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
        builder.setMessage(c.b.a.a.c.l.d.c(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String string = context.getResources().getString(i != 1 ? i != 2 ? i != 3 ? 17039370 : b.common_google_play_services_enable_button : b.common_google_play_services_update_button : b.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, eVar);
        }
        String d2 = c.b.a.a.c.l.d.d(context, i);
        if (d2 != null) {
            builder.setTitle(d2);
        }
        return builder.create();
    }

    public static void g(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof b.l.d.d) {
            q supportFragmentManager = ((b.l.d.d) activity).getSupportFragmentManager();
            j jVar = new j();
            i.j.t(dialog, "Cannot display null dialog");
            dialog.setOnCancelListener(null);
            dialog.setOnDismissListener(null);
            jVar.f2299b = dialog;
            if (onCancelListener != null) {
                jVar.f2300c = onCancelListener;
            }
            jVar.show(supportFragmentManager, str);
            return;
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        b bVar = new b();
        i.j.t(dialog, "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        bVar.f2284b = dialog;
        if (onCancelListener != null) {
            bVar.f2285c = onCancelListener;
        }
        bVar.show(fragmentManager, str);
    }

    @Override // c.b.a.a.c.e
    public Intent a(Context context, int i, String str) {
        return super.a(context, i, str);
    }

    @Override // c.b.a.a.c.e
    public int b(Context context, int i) {
        return super.b(context, i);
    }

    public int c(Context context) {
        return b(context, e.f2293a);
    }

    public boolean d(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog f = f(activity, i, new t(super.a(activity, i, "d"), activity, i2), onCancelListener);
        if (f == null) {
            return false;
        }
        g(activity, f, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    @TargetApi(20)
    public final void h(Context context, int i, PendingIntent pendingIntent) {
        int i2;
        String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i), null);
        new IllegalArgumentException();
        if (i == 18) {
            new a(context).sendEmptyMessageDelayed(1, 120000);
        } else if (pendingIntent != null) {
            String e2 = i == 6 ? c.b.a.a.c.l.d.e(context, "common_google_play_services_resolution_required_title") : c.b.a.a.c.l.d.d(context, i);
            if (e2 == null) {
                e2 = context.getResources().getString(b.common_google_play_services_notification_ticker);
            }
            String f = (i == 6 || i == 19) ? c.b.a.a.c.l.d.f(context, "common_google_play_services_resolution_required_text", c.b.a.a.c.l.d.a(context)) : c.b.a.a.c.l.d.c(context, i);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            g gVar = new g(context, null);
            gVar.j = true;
            gVar.d(16, true);
            gVar.f987d = g.b(e2);
            f fVar = new f();
            fVar.a(f);
            gVar.e(fVar);
            if (c.v1(context)) {
                gVar.s.icon = context.getApplicationInfo().icon;
                gVar.g = 2;
                if (c.w1(context)) {
                    gVar.f985b.add(new b.i.d.e(c.b.a.a.b.a.common_full_open_on_phone, resources.getString(b.common_open_on_phone), pendingIntent));
                } else {
                    gVar.f = pendingIntent;
                }
            } else {
                gVar.s.icon = 17301642;
                gVar.s.tickerText = g.b(resources.getString(b.common_google_play_services_notification_ticker));
                gVar.s.when = System.currentTimeMillis();
                gVar.f = pendingIntent;
                gVar.c(f);
            }
            if (c.n1()) {
                if (c.n1()) {
                    synchronized (f2289c) {
                    }
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                    String b2 = c.b.a.a.c.l.d.b(context);
                    if (notificationChannel == null) {
                        notificationChannel = new NotificationChannel("com.google.android.gms.availability", b2, 4);
                    } else {
                        if (!b2.contentEquals(notificationChannel.getName())) {
                            notificationChannel.setName(b2);
                        }
                        gVar.o = "com.google.android.gms.availability";
                    }
                    notificationManager.createNotificationChannel(notificationChannel);
                    gVar.o = "com.google.android.gms.availability";
                } else {
                    throw new IllegalStateException();
                }
            }
            Notification a2 = gVar.a();
            if (i == 1 || i == 2 || i == 3) {
                i2 = 10436;
                g.f2296b.set(false);
            } else {
                i2 = 39789;
            }
            notificationManager.notify(i2, a2);
        }
    }

    public final boolean i(Activity activity, j jVar, int i, DialogInterface.OnCancelListener onCancelListener) {
        Dialog f = f(activity, i, new u(super.a(activity, i, "d"), jVar, 2), onCancelListener);
        if (f == null) {
            return false;
        }
        g(activity, f, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }
}
