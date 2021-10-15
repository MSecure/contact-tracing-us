package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class v extends t1<v, a> implements d3 {
    public static volatile j3<v> zzbk;
    public static final v zzrx;
    public int zzbm;
    public l zzrt;
    public r zzru;
    public p zzrv;
    public int zzrw;

    static {
        v vVar = new v();
        zzrx = vVar;
        t1.zzyb.put(v.class, vVar);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.t1$b, c.b.a.a.g.h.j3<c.b.a.a.g.h.v>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<v> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new v();
            case 2:
                return new a(null);
            case 3:
                return new o3(zzrx, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004င\u0003", new Object[]{"zzbm", "zzrt", "zzru", "zzrv", "zzrw"});
            case 4:
                return zzrx;
            case 5:
                j3<v> j3Var2 = zzbk;
                j3<v> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (v.class) {
                        j3<v> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzrx);
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

    public static final class a extends t1.a<v, a> implements d3 {
        public a() {
            super(v.zzrx);
        }

        public a(g gVar) {
            super(v.zzrx);
        }
    }
}
