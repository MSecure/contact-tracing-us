package e.j.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import e.f.f;
import e.j.b.b.c;
import e.j.b.b.d;
import e.j.b.b.h;
import e.j.g.b;
import e.j.g.g;
import e.j.g.i;
import e.j.g.j;
import e.j.g.m;
import e.j.g.o;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public class e {
    public static final l a;
    public static final f<String, Typeface> b;

    /* loaded from: classes.dex */
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
                if (g.f1575d != null) {
                    lVar = new g();
                }
            }
            lVar = new f();
        }
        a = lVar;
        b = new f<>(16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
        if (r0.equals(r4) == false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static Typeface a(Context context, c cVar, Resources resources, int i2, int i3, h.c cVar2, Handler handler, boolean z) {
        Typeface typeface;
        Typeface typeface2;
        if (cVar instanceof e.j.b.b.f) {
            e.j.b.b.f fVar = (e.j.b.b.f) cVar;
            String str = fVar.f1569d;
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
            e.j.g.e eVar = fVar.a;
            e.j.g.c cVar3 = new e.j.g.c(aVar, c);
            if (z2) {
                f<String, Typeface> fVar2 = j.a;
                String str2 = eVar.f1592e + "-" + i3;
                Typeface a2 = j.a.a(str2);
                if (a2 != null) {
                    cVar3.b.post(new e.j.g.a(cVar3, cVar3.a, a2));
                    typeface = a2;
                } else if (i4 == -1) {
                    j.a a3 = j.a(str2, context, eVar, i3);
                    cVar3.a(a3);
                    typeface = a3.a;
                } else {
                    try {
                        try {
                            try {
                                j.a aVar2 = (j.a) j.b.submit(new e.j.g.f(str2, context, eVar, i3)).get((long) i4, TimeUnit.MILLISECONDS);
                                cVar3.a(aVar2);
                                typeface = aVar2.a;
                            } catch (TimeoutException unused) {
                                throw new InterruptedException("timeout");
                            }
                        } catch (InterruptedException e2) {
                            throw e2;
                        } catch (ExecutionException e3) {
                            throw new RuntimeException(e3);
                        }
                    } catch (InterruptedException unused2) {
                        cVar3.b.post(new b(cVar3, cVar3.a, -3));
                    }
                }
            } else {
                f<String, Typeface> fVar3 = j.a;
                String str3 = eVar.f1592e + "-" + i3;
                Typeface a4 = j.a.a(str3);
                if (a4 != null) {
                    cVar3.b.post(new e.j.g.a(cVar3, cVar3.a, a4));
                    typeface = a4;
                } else {
                    g gVar = new g(cVar3);
                    synchronized (j.c) {
                        e.f.h<String, ArrayList<e.j.i.a<j.a>>> hVar = j.f1595d;
                        ArrayList<e.j.i.a<j.a>> orDefault = hVar.getOrDefault(str3, null);
                        if (orDefault != null) {
                            orDefault.add(gVar);
                        } else {
                            ArrayList<e.j.i.a<j.a>> arrayList = new ArrayList<>();
                            arrayList.add(gVar);
                            hVar.put(str3, arrayList);
                            j.b.execute(new o(Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler(), new e.j.g.h(str3, context, eVar, i3), new i(str3)));
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
