package e.i.f;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import e.e.f;
import e.e.h;
import e.i.c.e;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class j {
    public static final f<String, Typeface> a = new f<>(16);
    public static final ExecutorService b;
    public static final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final h<String, ArrayList<e.i.h.a<a>>> f1510d = new h<>();

    public static final class a {
        public final Typeface a;
        public final int b;

        public a(int i2) {
            this.a = null;
            this.b = i2;
        }

        public a(Typeface typeface) {
            this.a = typeface;
            this.b = 0;
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new n("fonts-androidx", 10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        b = threadPoolExecutor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0046  */
    public static a a(String str, Context context, e eVar, int i2) {
        int i3;
        Typeface a2 = a.a(str);
        if (a2 != null) {
            return new a(a2);
        }
        try {
            k a3 = d.a(context, eVar, null);
            int i4 = a3.a;
            int i5 = 1;
            if (i4 == 0) {
                l[] lVarArr = a3.b;
                if (!(lVarArr == null || lVarArr.length == 0)) {
                    for (l lVar : lVarArr) {
                        int i6 = lVar.f1512e;
                        if (i6 != 0) {
                            if (i6 >= 0) {
                                i3 = i6;
                                if (i3 == 0) {
                                }
                            }
                        }
                    }
                    i5 = 0;
                }
                i3 = i5;
                if (i3 == 0) {
                }
            } else if (i4 == 1) {
                i3 = -2;
                if (i3 == 0) {
                    return new a(i3);
                }
                Typeface b2 = e.a.b(context, null, a3.b, i2);
                if (b2 == null) {
                    return new a(-3);
                }
                a.b(str, b2);
                return new a(b2);
            }
            i3 = -3;
            if (i3 == 0) {
            }
        } catch (PackageManager.NameNotFoundException unused) {
            return new a(-1);
        }
    }
}
