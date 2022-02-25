package e.i.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import e.e.f;
import e.e.h;
import e.i.b.b.b;
import e.i.b.b.e;
import e.i.b.b.g;
import e.i.f.a;
import e.i.f.c;
import e.i.f.e;
import e.i.f.f;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;

public class d {
    public static final k a;
    public static final f<String, Typeface> b = new f<>(16);

    static {
        k kVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            kVar = new i();
        } else if (i2 >= 28) {
            kVar = new h();
        } else if (i2 >= 26) {
            kVar = new g();
        } else {
            if (i2 >= 24) {
                Method method = f.f1427d;
                if (method == null) {
                    Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
                }
                if (method != null) {
                    kVar = new f();
                }
            }
            kVar = new e();
        }
        a = kVar;
    }

    public static Typeface a(Context context, b bVar, Resources resources, int i2, int i3, g gVar, Handler handler, boolean z) {
        Typeface typeface;
        if (bVar instanceof e) {
            e eVar = (e) bVar;
            boolean z2 = true;
            if (!z ? gVar != null : eVar.c != 0) {
                z2 = false;
            }
            int i4 = z ? eVar.b : -1;
            a aVar = eVar.a;
            f<String, Typeface> fVar = e.i.f.e.a;
            String str = aVar.f1443e + "-" + i3;
            typeface = e.i.f.e.a.a(str);
            if (typeface != null) {
                if (gVar != null) {
                    gVar.d(typeface);
                }
            } else if (!z2 || i4 != -1) {
                e.i.f.b bVar2 = new e.i.f.b(context, aVar, i3, str);
                typeface = null;
                if (z2) {
                    try {
                        typeface = ((e.d) e.i.f.e.b.b(bVar2, i4)).a;
                    } catch (InterruptedException unused) {
                    }
                } else {
                    c cVar = gVar == null ? null : new c(gVar, handler);
                    synchronized (e.i.f.e.c) {
                        h<String, ArrayList<f.c<e.d>>> hVar = e.i.f.e.f1445d;
                        ArrayList<f.c<e.d>> orDefault = hVar.getOrDefault(str, null);
                        if (orDefault == null) {
                            if (cVar != null) {
                                ArrayList<f.c<e.d>> arrayList = new ArrayList<>();
                                arrayList.add(cVar);
                                hVar.put(str, arrayList);
                            }
                            e.i.f.f fVar2 = e.i.f.e.b;
                            e.i.f.d dVar = new e.i.f.d(str);
                            Objects.requireNonNull(fVar2);
                            fVar2.a(new e.i.f.g(fVar2, bVar2, new Handler(), dVar));
                        } else if (cVar != null) {
                            orDefault.add(cVar);
                        }
                    }
                }
            } else {
                e.d b2 = e.i.f.e.b(context, aVar, i3);
                if (gVar != null) {
                    int i5 = b2.b;
                    if (i5 == 0) {
                        gVar.b(b2.a, handler);
                    } else {
                        gVar.a(i5, handler);
                    }
                }
                typeface = b2.a;
            }
        } else {
            typeface = a.a(context, (e.i.b.b.c) bVar, resources, i3);
            if (gVar != null) {
                if (typeface != null) {
                    gVar.b(typeface, handler);
                } else {
                    gVar.a(-3, handler);
                }
            }
        }
        if (typeface != null) {
            b.b(c(resources, i2, i3), typeface);
        }
        return typeface;
    }

    public static Typeface b(Context context, Resources resources, int i2, String str, int i3) {
        Typeface d2 = a.d(context, resources, i2, str, i3);
        if (d2 != null) {
            b.b(c(resources, i2, i3), d2);
        }
        return d2;
    }

    public static String c(Resources resources, int i2, int i3) {
        return resources.getResourcePackageName(i2) + "-" + i2 + "-" + i3;
    }
}
