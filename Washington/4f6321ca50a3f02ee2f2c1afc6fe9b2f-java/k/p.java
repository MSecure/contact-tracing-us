package k;

public final class p {
    public static o a;
    public static long b;

    public static void a(o oVar) {
        if (oVar.f4021f != null || oVar.f4022g != null) {
            throw new IllegalArgumentException();
        } else if (!oVar.f4019d) {
            synchronized (p.class) {
                long j2 = b + 8192;
                if (j2 <= 65536) {
                    b = j2;
                    oVar.f4021f = a;
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
            a = oVar.f4021f;
            oVar.f4021f = null;
            b -= 8192;
            return oVar;
        }
    }
}
