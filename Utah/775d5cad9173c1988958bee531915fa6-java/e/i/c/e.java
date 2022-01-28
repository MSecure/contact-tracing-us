package e.i.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import e.e.f;
import e.i.b.b.c;
import e.i.b.b.d;
import e.i.b.b.h;
import e.i.f.b;
import e.i.f.g;
import e.i.f.i;
import e.i.f.j;
import e.i.f.m;
import e.i.f.o;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class e {
    public static final l a;
    public static final f<String, Typeface> b = new f<>(16);

    public static class a extends m {
        public h.c a;

        public a(h.c cVar) {
            this.a = cVar;
        }
    }

    static {
        l lVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            lVar = new j();
        } else if (i2 >= 28) {
            lVar = new i();
        } else if (i2 >= 26) {
            lVar = new h();
        } else {
            if (i2 >= 24) {
                if (g.f1491d != null) {
                    lVar = new g();
                }
            }
            lVar = new f();
        }
        a = lVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r0.equals(r4) == false) goto L_0x0028;
     */
    public static Typeface a(Context context, c cVar, Resources resources, int i2, int i3, h.c cVar2, Handler handler, boolean z) {
        Typeface typeface;
        Typeface typeface2;
        if (cVar instanceof e.i.b.b.f) {
            e.i.b.b.f fVar = (e.i.b.b.f) cVar;
            String str = fVar.f1485d;
            typeface = null;
            boolean z2 = false;
            if (str != null && !str.isEmpty()) {
                typeface2 = Typeface.create(str, 0);
                Typeface create = Typeface.create(Typeface.DEFAULT, 0);
                if (typeface2 != null) {
                }
            }
            typeface2 = null;
            if (typeface2 != null) {
                if (cVar2 != null) {
                    cVar2.b(typeface2, handler);
                }
                return typeface2;
            }
            if (!z ? cVar2 == null : fVar.c == 0) {
                z2 = true;
            }
            int i4 = z ? fVar.b : -1;
            Handler c = h.c.c(handler);
            a aVar = new a(cVar2);
            e.i.f.e eVar = fVar.a;
            e.i.f.c cVar3 = new e.i.f.c(aVar, c);
            if (z2) {
                f<String, Typeface> fVar2 = j.a;
                String str2 = eVar.f1507e + "-" + i3;
                Typeface a2 = j.a.a(str2);
                if (a2 != null) {
                    cVar3.b.post(new e.i.f.a(cVar3, cVar3.a, a2));
                    typeface = a2;
                } else if (i4 == -1) {
                    j.a a3 = j.a(str2, context, eVar, i3);
                    cVar3.a(a3);
                    typeface = a3.a;
                } else {
                    try {
                        try {
                            j.a aVar2 = (j.a) j.b.submit(new e.i.f.f(str2, context, eVar, i3)).get((long) i4, TimeUnit.MILLISECONDS);
                            cVar3.a(aVar2);
                            typeface = aVar2.a;
                        } catch (ExecutionException e2) {
                            throw new RuntimeException(e2);
                        } catch (InterruptedException e3) {
                            throw e3;
                        } catch (TimeoutException unused) {
                            throw new InterruptedException("timeout");
                        }
                    } catch (InterruptedException unused2) {
                        cVar3.b.post(new b(cVar3, cVar3.a, -3));
                    }
                }
            } else {
                f<String, Typeface> fVar3 = j.a;
                String str3 = eVar.f1507e + "-" + i3;
                Typeface a4 = j.a.a(str3);
                if (a4 != null) {
                    cVar3.b.post(new e.i.f.a(cVar3, cVar3.a, a4));
                    typeface = a4;
                } else {
                    g gVar = new g(cVar3);
                    synchronized (j.c) {
                        e.e.h<String, ArrayList<e.i.h.a<j.a>>> hVar = j.f1510d;
                        ArrayList<e.i.h.a<j.a>> orDefault = hVar.getOrDefault(str3, null);
                        if (orDefault != null) {
                            orDefault.add(gVar);
                        } else {
                            ArrayList<e.i.h.a<j.a>> arrayList = new ArrayList<>();
                            arrayList.add(gVar);
                            hVar.put(str3, arrayList);
                            j.b.execute(new o(Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler(), new e.i.f.h(str3, context, eVar, i3), new i(str3)));
                        }
                    }
                }
            }
        } else {
            typeface = a.a(context, (d) cVar, resources, i3);
            if (cVar2 != null) {
                if (typeface != null) {
                    cVar2.b(typeface, handler);
                } else {
                    cVar2.a(-3, handler);
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
