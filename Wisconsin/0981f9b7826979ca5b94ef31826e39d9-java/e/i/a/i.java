package e.i.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Objects;

public class i {
    public Context a;
    public ArrayList<g> b = new ArrayList<>();
    public ArrayList<n> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<g> f1399d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f1400e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f1401f;

    /* renamed from: g  reason: collision with root package name */
    public PendingIntent f1402g;

    /* renamed from: h  reason: collision with root package name */
    public int f1403h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1404i = true;

    /* renamed from: j  reason: collision with root package name */
    public j f1405j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1406k = false;

    /* renamed from: l  reason: collision with root package name */
    public Bundle f1407l;
    public int m = 0;
    public int n = 0;
    public String o;
    public boolean p;
    public Notification q;
    @Deprecated
    public ArrayList<String> r;

    public i(Context context, String str) {
        Notification notification = new Notification();
        this.q = notification;
        this.a = context;
        this.o = str;
        notification.when = System.currentTimeMillis();
        this.q.audioStreamType = -1;
        this.f1403h = 0;
        this.r = new ArrayList<>();
        this.p = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public Notification a() {
        Bundle bundle;
        k kVar = new k(this);
        j jVar = kVar.b.f1405j;
        if (jVar != null) {
            new Notification.BigTextStyle(kVar.a).setBigContentTitle(null).bigText(((h) jVar).b);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26 && i2 < 24) {
            kVar.a.setExtras(kVar.f1408d);
        }
        Notification build = kVar.a.build();
        Objects.requireNonNull(kVar.b);
        if (jVar != null) {
            Objects.requireNonNull(kVar.b.f1405j);
        }
        if (!(jVar == null || (bundle = build.extras) == null)) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", h.class.getName());
            bundle.putCharSequence("android.bigText", ((h) jVar).b);
        }
        return build;
    }

    public final void c(int i2, boolean z) {
        Notification notification;
        int i3;
        if (z) {
            notification = this.q;
            i3 = i2 | notification.flags;
        } else {
            notification = this.q;
            i3 = (~i2) & notification.flags;
        }
        notification.flags = i3;
    }

    public i d(j jVar) {
        if (this.f1405j != jVar) {
            this.f1405j = jVar;
            if (jVar.a != this) {
                jVar.a = this;
                d(jVar);
            }
        }
        return this;
    }
}
