package e.j.a;

import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class h {
    public final Bundle a;
    public IconCompat b;
    public final p[] c;

    /* renamed from: d  reason: collision with root package name */
    public final p[] f1539d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1540e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1541f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1542g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1543h;
    @Deprecated

    /* renamed from: i  reason: collision with root package name */
    public int f1544i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f1545j;

    /* renamed from: k  reason: collision with root package name */
    public PendingIntent f1546k;

    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public h(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
        int i3;
        StringBuilder sb;
        IconCompat b = i2 == 0 ? null : IconCompat.b(null, "", i2);
        Bundle bundle = new Bundle();
        this.f1541f = true;
        this.b = b;
        if (b != null) {
            int i4 = b.a;
            if (i4 == -1 && (i3 = Build.VERSION.SDK_INT) >= 23) {
                Icon icon = (Icon) b.b;
                if (i3 >= 28) {
                    i4 = icon.getType();
                } else {
                    try {
                        i4 = ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
                    } catch (IllegalAccessException unused) {
                        sb = new StringBuilder();
                        sb.append("Unable to get icon type ");
                        sb.append(icon);
                        sb.toString();
                        i4 = -1;
                        if (i4 == 2) {
                        }
                        this.f1545j = j.b(charSequence);
                        this.f1546k = pendingIntent;
                        this.a = bundle;
                        this.c = null;
                        this.f1539d = null;
                        this.f1540e = true;
                        this.f1542g = 0;
                        this.f1541f = true;
                        this.f1543h = false;
                    } catch (NoSuchMethodException unused2) {
                        sb = new StringBuilder();
                        sb.append("Unable to get icon type ");
                        sb.append(icon);
                        sb.toString();
                        i4 = -1;
                        if (i4 == 2) {
                        }
                        this.f1545j = j.b(charSequence);
                        this.f1546k = pendingIntent;
                        this.a = bundle;
                        this.c = null;
                        this.f1539d = null;
                        this.f1540e = true;
                        this.f1542g = 0;
                        this.f1541f = true;
                        this.f1543h = false;
                    } catch (InvocationTargetException unused3) {
                        sb = new StringBuilder();
                        sb.append("Unable to get icon type ");
                        sb.append(icon);
                        sb.toString();
                        i4 = -1;
                        if (i4 == 2) {
                        }
                        this.f1545j = j.b(charSequence);
                        this.f1546k = pendingIntent;
                        this.a = bundle;
                        this.c = null;
                        this.f1539d = null;
                        this.f1540e = true;
                        this.f1542g = 0;
                        this.f1541f = true;
                        this.f1543h = false;
                    }
                }
            }
            if (i4 == 2) {
                this.f1544i = b.c();
            }
        }
        this.f1545j = j.b(charSequence);
        this.f1546k = pendingIntent;
        this.a = bundle;
        this.c = null;
        this.f1539d = null;
        this.f1540e = true;
        this.f1542g = 0;
        this.f1541f = true;
        this.f1543h = false;
    }

    public IconCompat a() {
        int i2;
        if (this.b == null && (i2 = this.f1544i) != 0) {
            this.b = IconCompat.b(null, "", i2);
        }
        return this.b;
    }
}
