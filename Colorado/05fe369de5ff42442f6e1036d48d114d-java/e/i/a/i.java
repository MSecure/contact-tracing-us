package e.i.a;

import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;

public class i {
    public final Bundle a;
    public IconCompat b;
    public final q[] c;

    /* renamed from: d  reason: collision with root package name */
    public final q[] f1216d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1217e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1218f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1219g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1220h;
    @Deprecated

    /* renamed from: i  reason: collision with root package name */
    public int f1221i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f1222j;

    /* renamed from: k  reason: collision with root package name */
    public PendingIntent f1223k;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    public i(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
        int i3;
        int i4;
        Icon icon;
        StringBuilder sb;
        IconCompat b2 = i2 == 0 ? null : IconCompat.b(null, "", i2);
        Bundle bundle = new Bundle();
        this.f1218f = true;
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
                    } catch (IllegalAccessException unused) {
                        sb = new StringBuilder();
                    } catch (InvocationTargetException unused2) {
                        sb = new StringBuilder();
                    } catch (NoSuchMethodException unused3) {
                        sb = new StringBuilder();
                    }
                }
            }
            if (i3 == 2) {
                this.f1221i = b2.c();
            }
        }
        this.f1222j = k.b(charSequence);
        this.f1223k = pendingIntent;
        this.a = bundle;
        this.c = null;
        this.f1216d = null;
        this.f1217e = true;
        this.f1219g = 0;
        this.f1218f = true;
        this.f1220h = false;
        sb.append("Unable to get icon type ");
        sb.append(icon);
        sb.toString();
        i3 = -1;
        if (i3 == 2) {
        }
        this.f1222j = k.b(charSequence);
        this.f1223k = pendingIntent;
        this.a = bundle;
        this.c = null;
        this.f1216d = null;
        this.f1217e = true;
        this.f1219g = 0;
        this.f1218f = true;
        this.f1220h = false;
    }

    public IconCompat a() {
        int i2;
        if (this.b == null && (i2 = this.f1221i) != 0) {
            this.b = IconCompat.b(null, "", i2);
        }
        return this.b;
    }
}
