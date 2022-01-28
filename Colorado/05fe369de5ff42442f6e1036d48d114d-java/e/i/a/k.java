package e.i.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Objects;

public class k {
    public Context a;
    public ArrayList<i> b = new ArrayList<>();
    public ArrayList<p> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<i> f1224d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f1225e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f1226f;

    /* renamed from: g  reason: collision with root package name */
    public PendingIntent f1227g;

    /* renamed from: h  reason: collision with root package name */
    public int f1228h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1229i = true;

    /* renamed from: j  reason: collision with root package name */
    public l f1230j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f1231k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1232l = false;
    public Bundle m;
    public int n = 0;
    public int o = 0;
    public String p;
    public boolean q;
    public Notification r;
    @Deprecated
    public ArrayList<String> s;

    public k(Context context, String str) {
        Notification notification = new Notification();
        this.r = notification;
        this.a = context;
        this.p = str;
        notification.when = System.currentTimeMillis();
        this.r.audioStreamType = -1;
        this.f1228h = 0;
        this.s = new ArrayList<>();
        this.q = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public Notification a() {
        Bundle bundle;
        m mVar = new m(this);
        l lVar = mVar.b.f1230j;
        if (lVar != null) {
            new Notification.BigTextStyle(mVar.a).setBigContentTitle(null).bigText(((j) lVar).b);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26 && i2 < 24) {
            mVar.a.setExtras(mVar.f1233d);
        }
        Notification build = mVar.a.build();
        Objects.requireNonNull(mVar.b);
        if (lVar != null) {
            Objects.requireNonNull(mVar.b.f1230j);
        }
        if (!(lVar == null || (bundle = build.extras) == null)) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", j.class.getName());
            bundle.putCharSequence("android.bigText", ((j) lVar).b);
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

    public k d(l lVar) {
        if (this.f1230j != lVar) {
            this.f1230j = lVar;
            if (lVar.a != this) {
                lVar.a = this;
                d(lVar);
            }
        }
        return this;
    }
}
