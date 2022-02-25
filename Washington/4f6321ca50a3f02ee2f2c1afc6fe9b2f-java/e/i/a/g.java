package e.i.a;

import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;

public class g {
    public final Bundle a;
    public IconCompat b;
    public final o[] c;

    /* renamed from: d  reason: collision with root package name */
    public final o[] f1391d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1392e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1393f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1394g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1395h;
    @Deprecated

    /* renamed from: i  reason: collision with root package name */
    public int f1396i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f1397j;

    /* renamed from: k  reason: collision with root package name */
    public PendingIntent f1398k;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    public g(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
        int i3;
        int i4;
        Icon icon;
        StringBuilder sb;
        Throwable e2;
        IconCompat b2 = i2 == 0 ? null : IconCompat.b(null, "", i2);
        Bundle bundle = new Bundle();
        this.f1393f = true;
        this.b = b2;
        if (b2 != null) {
            i3 = b2.a;
            if (i3 == -1 && (i4 = Build.VERSION.SDK_INT) >= 23) {
                icon = (Icon) b2.b;
                if (i4 >= 28) {
                    i3 = icon.getType();
                } else {
                    try {
                        i3 = ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
                    } catch (IllegalAccessException e3) {
                        e2 = e3;
                        sb = new StringBuilder();
                    } catch (InvocationTargetException e4) {
                        e2 = e4;
                        sb = new StringBuilder();
                    } catch (NoSuchMethodException e5) {
                        e2 = e5;
                        sb = new StringBuilder();
                    }
                }
            }
            if (i3 == 2) {
                this.f1396i = b2.c();
            }
        }
        this.f1397j = i.b(charSequence);
        this.f1398k = pendingIntent;
        this.a = bundle;
        this.c = null;
        this.f1391d = null;
        this.f1392e = true;
        this.f1394g = 0;
        this.f1393f = true;
        this.f1395h = false;
        sb.append("Unable to get icon type ");
        sb.append(icon);
        Log.e("IconCompat", sb.toString(), e2);
        i3 = -1;
        if (i3 == 2) {
        }
        this.f1397j = i.b(charSequence);
        this.f1398k = pendingIntent;
        this.a = bundle;
        this.c = null;
        this.f1391d = null;
        this.f1392e = true;
        this.f1394g = 0;
        this.f1393f = true;
        this.f1395h = false;
    }

    public IconCompat a() {
        int i2;
        if (this.b == null && (i2 = this.f1396i) != 0) {
            this.b = IconCompat.b(null, "", i2);
        }
        return this.b;
    }
}
