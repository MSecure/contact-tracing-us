package e.j.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Objects;
/* loaded from: classes.dex */
public class j {
    public Context a;

    /* renamed from: e */
    public CharSequence f1548e;

    /* renamed from: f */
    public CharSequence f1549f;

    /* renamed from: g */
    public PendingIntent f1550g;

    /* renamed from: j */
    public k f1553j;

    /* renamed from: k */
    public CharSequence f1554k;
    public Bundle m;
    public String p;
    public Notification r;
    public ArrayList<h> b = new ArrayList<>();
    public ArrayList<o> c = new ArrayList<>();

    /* renamed from: d */
    public ArrayList<h> f1547d = new ArrayList<>();

    /* renamed from: i */
    public boolean f1552i = true;

    /* renamed from: l */
    public boolean f1555l = false;
    public int n = 0;
    public int o = 0;

    /* renamed from: h */
    public int f1551h = 0;
    @Deprecated
    public ArrayList<String> s = new ArrayList<>();
    public boolean q = true;

    public j(Context context, String str) {
        Notification notification = new Notification();
        this.r = notification;
        this.a = context;
        this.p = str;
        notification.when = System.currentTimeMillis();
        this.r.audioStreamType = -1;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public Notification a() {
        Bundle bundle;
        l lVar = new l(this);
        k kVar = lVar.b.f1553j;
        if (kVar != null) {
            new Notification.BigTextStyle(lVar.a).setBigContentTitle(null).bigText(((i) kVar).b);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26 && i2 < 24) {
            lVar.a.setExtras(lVar.f1556d);
        }
        Notification build = lVar.a.build();
        Objects.requireNonNull(lVar.b);
        if (kVar != null) {
            Objects.requireNonNull(lVar.b.f1553j);
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
        if (this.f1553j != kVar) {
            this.f1553j = kVar;
            if (kVar.a != this) {
                kVar.a = this;
                d(kVar);
            }
        }
        return this;
    }
}
