package e.i.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Objects;

public class j {
    public Context a;
    public ArrayList<h> b = new ArrayList<>();
    public ArrayList<o> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<h> f1463d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f1464e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f1465f;

    /* renamed from: g  reason: collision with root package name */
    public PendingIntent f1466g;

    /* renamed from: h  reason: collision with root package name */
    public int f1467h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1468i = true;

    /* renamed from: j  reason: collision with root package name */
    public k f1469j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f1470k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1471l = false;
    public Bundle m;
    public int n = 0;
    public int o = 0;
    public String p;
    public boolean q;
    public Notification r;
    @Deprecated
    public ArrayList<String> s;

    public j(Context context, String str) {
        Notification notification = new Notification();
        this.r = notification;
        this.a = context;
        this.p = str;
        notification.when = System.currentTimeMillis();
        this.r.audioStreamType = -1;
        this.f1467h = 0;
        this.s = new ArrayList<>();
        this.q = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public Notification a() {
        Bundle bundle;
        l lVar = new l(this);
        k kVar = lVar.b.f1469j;
        if (kVar != null) {
            new Notification.BigTextStyle(lVar.a).setBigContentTitle(null).bigText(((i) kVar).b);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26 && i2 < 24) {
            lVar.a.setExtras(lVar.f1472d);
        }
        Notification build = lVar.a.build();
        Objects.requireNonNull(lVar.b);
        if (kVar != null) {
            Objects.requireNonNull(lVar.b.f1469j);
        }
        if (!(kVar == null || (bundle = build.extras) == null)) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", "androidx.core.app.NotificationCompat$BigTextStyle");
        }
        return build;
    }

    public final void c(int i2, boolean z) {
        Notification notification;
        int i3;
        if (z) {
            notification = this.r;
            i3 = i2 | notification.flags;
        } else {
            notification = this.r;
            i3 = (~i2) & notification.flags;
        }
        notification.flags = i3;
    }

    public j d(k kVar) {
        if (this.f1469j != kVar) {
            this.f1469j = kVar;
            if (kVar.a != this) {
                kVar.a = this;
                d(kVar);
            }
        }
        return this;
    }
}
