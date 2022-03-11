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
    public ArrayList<i> f1413d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f1414e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f1415f;

    /* renamed from: g  reason: collision with root package name */
    public PendingIntent f1416g;

    /* renamed from: h  reason: collision with root package name */
    public int f1417h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1418i = true;

    /* renamed from: j  reason: collision with root package name */
    public l f1419j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1420k = false;

    /* renamed from: l  reason: collision with root package name */
    public Bundle f1421l;
    public int m = 0;
    public int n = 0;
    public String o;
    public boolean p;
    public Notification q;
    @Deprecated
    public ArrayList<String> r;

    public k(Context context, String str) {
        Notification notification = new Notification();
        this.q = notification;
        this.a = context;
        this.o = str;
        notification.when = System.currentTimeMillis();
        this.q.audioStreamType = -1;
        this.f1417h = 0;
        this.r = new ArrayList<>();
        this.p = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public Notification a() {
        Bundle bundle;
        m mVar = new m(this);
        l lVar = mVar.b.f1419j;
        if (lVar != null) {
            new Notification.BigTextStyle(mVar.a).setBigContentTitle(null).bigText(((j) lVar).b);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26 && i2 < 24) {
            mVar.a.setExtras(mVar.f1422d);
        }
        Notification build = mVar.a.build();
        Objects.requireNonNull(mVar.b);
        if (lVar != null) {
            Objects.requireNonNull(mVar.b.f1419j);
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
            notification = this.q;
            i3 = i2 | notification.flags;
        } else {
            notification = this.q;
            i3 = (~i2) & notification.flags;
        }
        notification.flags = i3;
    }

    public k d(l lVar) {
        if (this.f1419j != lVar) {
            this.f1419j = lVar;
            if (lVar.a != this) {
                lVar.a = this;
                d(lVar);
            }
        }
        return this;
    }
}
