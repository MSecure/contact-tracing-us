package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class j extends t1<j, a> implements d3 {
    public static volatile j3<j> zzbk;
    public static final j zzom;
    public int zzbm;
    public int zzoj;
    public int zzok;
    public String zzol = "";

    public static final class a extends t1.a<j, a> implements d3 {
        public a(g gVar) {
            super(j.zzom);
        }
    }

    static {
        j jVar = new j();
        zzom = jVar;
        t1.zzyb.put(j.class, jVar);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.t1$b, c.b.a.a.g.h.j3<c.b.a.a.g.h.j>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<j> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new j();
            case 2:
                return new a(null);
            case 3:
                return new o3(zzom, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002", new Object[]{"zzbm", "zzoj", e0.f3866a, "zzok", h0.f3901a, "zzol"});
            case 4:
                return zzom;
            case 5:
                j3<j> j3Var2 = zzbk;
                j3<j> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (j.class) {
                        j3<j> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzom);
                            zzbk = bVar;
                            j3Var = bVar;
                        }
                    }
                    j3Var3 = j3Var;
                }
                return j3Var3;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
