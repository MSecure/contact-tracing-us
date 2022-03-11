package k;
/* loaded from: classes.dex */
public final class p {
    public static o a;
    public static long b;

    public static void a(o oVar) {
        if (oVar.f4592f != null || oVar.f4593g != null) {
            throw new IllegalArgumentException();
        } else if (!oVar.f4590d) {
            synchronized (p.class) {
                long j2 = b + 8192;
                if (j2 <= 65536) {
                    b = j2;
                    oVar.f4592f = a;
                    oVar.c = 0;
                    oVar.b = 0;
                    a = oVar;
                }
            }
        }
    }

    public static o b() {
        synchronized (p.class) {
            o oVar = a;
            if (oVar == null) {
                return new o();
            }
            a = oVar.f4592f;
            oVar.f4592f = null;
            b -= 8192;
            return oVar;
        }
    }
}
