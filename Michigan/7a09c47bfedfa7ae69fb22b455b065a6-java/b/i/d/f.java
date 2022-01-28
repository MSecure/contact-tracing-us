package b.i.d;

import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f1665a;

    /* renamed from: b  reason: collision with root package name */
    public IconCompat f1666b;

    /* renamed from: c  reason: collision with root package name */
    public final m[] f1667c;

    /* renamed from: d  reason: collision with root package name */
    public final m[] f1668d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1669e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1670f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1671g;
    public final boolean h;
    @Deprecated
    public int i;
    public CharSequence j;
    public PendingIntent k;

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
    public f(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
        int i3;
        Icon icon;
        StringBuilder sb;
        IconCompat b2 = i2 == 0 ? null : IconCompat.b(null, "", i2);
        Bundle bundle = new Bundle();
        this.f1670f = true;
        this.f1666b = b2;
        if (b2 != null) {
            i3 = b2.f201a;
            if (i3 == -1) {
                int i4 = Build.VERSION.SDK_INT;
                icon = (Icon) b2.f202b;
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
                this.i = b2.c();
            }
        }
        this.j = h.b(charSequence);
        this.k = pendingIntent;
        this.f1665a = bundle;
        this.f1667c = null;
        this.f1668d = null;
        this.f1669e = true;
        this.f1671g = 0;
        this.f1670f = true;
        this.h = false;
        sb.append("Unable to get icon type ");
        sb.append(icon);
        sb.toString();
        i3 = -1;
        if (i3 == 2) {
        }
        this.j = h.b(charSequence);
        this.k = pendingIntent;
        this.f1665a = bundle;
        this.f1667c = null;
        this.f1668d = null;
        this.f1669e = true;
        this.f1671g = 0;
        this.f1670f = true;
        this.h = false;
    }

    public IconCompat a() {
        int i2;
        if (this.f1666b == null && (i2 = this.i) != 0) {
            this.f1666b = IconCompat.b(null, "", i2);
        }
        return this.f1666b;
    }
}
