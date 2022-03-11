package f.b.a.c.b;

import android.app.Activity;
import android.app.AlertDialog;
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
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$string;
import e.b.a.m;
import e.e.h;
import e.i.a.i;
import e.i.a.j;
import e.i.a.k;
import e.m.a.f0;
import e.m.a.r;
import f.b.a.c.b.m.p;
import f.b.a.c.b.m.q;
import f.b.a.c.b.o.b;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class d extends e {
    public static final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final d f2486d = new d();

    public class a extends f.b.a.c.e.a.d {
        public final Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.a = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            int i2 = message.what;
            boolean z = true;
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i2);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int b2 = d.this.b(this.a, e.a);
            Objects.requireNonNull(d.this);
            AtomicBoolean atomicBoolean = i.a;
            if (!(b2 == 1 || b2 == 2 || b2 == 3 || b2 == 9)) {
                z = false;
            }
            if (z) {
                d dVar = d.this;
                Context context = this.a;
                Intent a2 = dVar.a(context, b2, "n");
                dVar.d(context, b2, a2 == null ? null : PendingIntent.getActivity(context, 0, a2, 134217728));
            }
        }
    }

    @Override // f.b.a.c.b.e
    @RecentlyNullable
    public Intent a(Context context, @RecentlyNonNull int i2, String str) {
        return super.a(context, i2, str);
    }

    @Override // f.b.a.c.b.e
    @RecentlyNonNull
    public int b(@RecentlyNonNull Context context, @RecentlyNonNull int i2) {
        return super.b(context, i2);
    }

    @RecentlyNonNull
    public boolean c(@RecentlyNonNull Activity activity, @RecentlyNonNull int i2, @RecentlyNonNull int i3, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialog;
        q qVar = new q(super.a(activity, i2, "d"), activity, i3);
        if (i2 == 0) {
            alertDialog = null;
        } else {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
            if (builder == null) {
                builder = new AlertDialog.Builder(activity);
            }
            builder.setMessage(p.e(activity, i2));
            builder.setOnCancelListener(onCancelListener);
            String string = activity.getResources().getString(i2 != 1 ? i2 != 2 ? i2 != 3 ? 17039370 : R$string.common_google_play_services_enable_button : R$string.common_google_play_services_update_button : R$string.common_google_play_services_install_button);
            if (string != null) {
                builder.setPositiveButton(string, qVar);
            }
            String a2 = p.a(activity, i2);
            if (a2 != null) {
                builder.setTitle(a2);
            }
            Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i2)), new IllegalArgumentException());
            alertDialog = builder.create();
        }
        if (alertDialog == null) {
            return false;
        }
        if (activity instanceof r) {
            f0 o = ((r) activity).o();
            k kVar = new k();
            m.h.p(alertDialog, "Cannot display null dialog");
            alertDialog.setOnCancelListener(null);
            alertDialog.setOnDismissListener(null);
            kVar.n0 = alertDialog;
            kVar.o0 = onCancelListener;
            kVar.B0(o, "GooglePlayServicesErrorDialog");
        } else {
            FragmentManager fragmentManager = activity.getFragmentManager();
            b bVar = new b();
            m.h.p(alertDialog, "Cannot display null dialog");
            alertDialog.setOnCancelListener(null);
            alertDialog.setOnDismissListener(null);
            bVar.b = alertDialog;
            bVar.c = onCancelListener;
            bVar.show(fragmentManager, "GooglePlayServicesErrorDialog");
        }
        return true;
    }

    public final void d(Context context, int i2, PendingIntent pendingIntent) {
        int i3;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i2), null), new IllegalArgumentException());
        if (i2 == 18) {
            new a(context).sendEmptyMessageDelayed(1, 120000);
        } else if (pendingIntent != null) {
            String b = i2 == 6 ? p.b(context, "common_google_play_services_resolution_required_title") : p.a(context, i2);
            if (b == null) {
                b = context.getResources().getString(R$string.common_google_play_services_notification_ticker);
            }
            String c2 = (i2 == 6 || i2 == 19) ? p.c(context, "common_google_play_services_resolution_required_text", p.d(context)) : p.e(context, i2);
            Resources resources = context.getResources();
            Object systemService = context.getSystemService("notification");
            Objects.requireNonNull(systemService, "null reference");
            NotificationManager notificationManager = (NotificationManager) systemService;
            k kVar = new k(context, null);
            kVar.f1420k = true;
            kVar.c(16, true);
            kVar.f1414e = k.b(b);
            j jVar = new j();
            jVar.b = k.b(c2);
            kVar.d(jVar);
            if (b.k1(context)) {
                kVar.q.icon = context.getApplicationInfo().icon;
                kVar.f1417h = 2;
                if (b.l1(context)) {
                    kVar.b.add(new i(R$drawable.common_full_open_on_phone, resources.getString(R$string.common_open_on_phone), pendingIntent));
                } else {
                    kVar.f1416g = pendingIntent;
                }
            } else {
                kVar.q.icon = 17301642;
                kVar.q.tickerText = k.b(resources.getString(R$string.common_google_play_services_notification_ticker));
                kVar.q.when = System.currentTimeMillis();
                kVar.f1416g = pendingIntent;
                kVar.f1415f = k.b(c2);
            }
            if (b.e1()) {
                if (b.e1()) {
                    synchronized (c) {
                    }
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                    h<String, String> hVar = p.a;
                    String string = context.getResources().getString(R$string.common_google_play_services_notification_channel_name);
                    if (notificationChannel == null) {
                        notificationChannel = new NotificationChannel("com.google.android.gms.availability", string, 4);
                    } else {
                        if (!string.contentEquals(notificationChannel.getName())) {
                            notificationChannel.setName(string);
                        }
                        kVar.o = "com.google.android.gms.availability";
                    }
                    notificationManager.createNotificationChannel(notificationChannel);
                    kVar.o = "com.google.android.gms.availability";
                } else {
                    throw new IllegalStateException();
                }
            }
            Notification a2 = kVar.a();
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                i3 = 10436;
                i.a.set(false);
            } else {
                i3 = 39789;
            }
            notificationManager.notify(i3, a2);
        } else if (i2 == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }
}
