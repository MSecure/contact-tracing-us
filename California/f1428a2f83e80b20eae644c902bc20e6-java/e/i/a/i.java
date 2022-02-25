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
    public ArrayList<g> f1400d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f1401e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f1402f;

    /* renamed from: g  reason: collision with root package name */
    public PendingIntent f1403g;

    /* renamed from: h  reason: collision with root package name */
    public int f1404h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1405i = true;

    /* renamed from: j  reason: collision with root package name */
    public j f1406j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1407k = false;

    /* renamed from: l  reason: collision with root package name */
    public Bundle f1408l;
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
        this.f1404h = 0;
        this.r = new ArrayList<>();
        this.p = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public Notification a() {
        Bundle bundle;
        k kVar = new k(this);
        j jVar = kVar.b.f1406j;
        if (jVar != null) {
            new Notification.BigTextStyle(kVar.a).setBigContentTitle(null).bigText(((h) jVar).b);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26 && i2 < 24) {
            kVar.a.setExtras(kVar.f1409d);
        }
        Notification build = kVar.a.build();
        Objects.requireNonNull(kVar.b);
        if (jVar != null) {
            Objects.requireNonNull(kVar.b.f1406j);
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
        if (this.f1406j != jVar) {
            this.f1406j = jVar;
            if (jVar.a != this) {
                jVar.a = this;
                d(jVar);
            }
        }
        return this;
    }
}
