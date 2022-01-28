package b.i.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import b.e.f;
import b.i.e.b.b;
import b.i.e.b.c;
import b.i.e.b.e;
import b.i.e.b.g;

@SuppressLint({"NewApi"})
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final j f1054a;

    /* renamed from: b  reason: collision with root package name */
    public static final f<String, Typeface> f1055b = new f<>(16);

    static {
        j jVar;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            jVar = new i();
        } else if (i >= 28) {
            jVar = new h();
        } else if (i >= 26) {
            jVar = new g();
        } else {
            if (i >= 24) {
                if (f.f1062d != null) {
                    jVar = new f();
                }
            }
            jVar = new e();
        }
        f1054a = jVar;
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        if (context != null) {
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, b bVar, Resources resources, int i, int i2, g gVar, Handler handler, boolean z) {
        Typeface typeface;
        if (bVar instanceof e) {
            e eVar = (e) bVar;
            boolean z2 = false;
            if (!z ? gVar == null : eVar.f1037c == 0) {
                z2 = true;
            }
            typeface = b.i.i.b.c(context, eVar.f1035a, gVar, handler, z2, z ? eVar.f1036b : -1, i2);
        } else {
            typeface = f1054a.a(context, (c) bVar, resources, i2);
            if (gVar != null) {
                if (typeface != null) {
                    gVar.b(typeface, handler);
                } else {
                    gVar.a(-3, handler);
                }
            }
        }
        if (typeface != null) {
            f1055b.b(d(resources, i, i2), typeface);
        }
        return typeface;
    }

    public static Typeface c(Context context, Resources resources, int i, String str, int i2) {
        Typeface d2 = f1054a.d(context, resources, i, str, i2);
        if (d2 != null) {
            f1055b.b(d(resources, i, i2), d2);
        }
        return d2;
    }

    public static String d(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}
