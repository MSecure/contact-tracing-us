package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class u extends t1<u, a> implements d3 {
    public static volatile j3<u> zzbk;
    public static final u zzrs;
    public int zzbm;
    public k zzro;
    public int zzrp;
    public o zzrq;
    public j zzrr;

    public static final class a extends t1.a<u, a> implements d3 {
        public a(g gVar) {
            super(u.zzrs);
        }
    }

    static {
        u uVar = new u();
        zzrs = uVar;
        t1.zzyb.put(u.class, uVar);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.t1$b, c.b.a.a.g.h.j3<c.b.a.a.g.h.u>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<u> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new u();
            case 2:
                return new a(null);
            case 3:
                return new o3(zzrs, "\u0001\u0004\u0000\u0001\u0001\u0011\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002င\u0001\u0010ဉ\u0002\u0011ဉ\u0003", new Object[]{"zzbm", "zzro", "zzrp", "zzrq", "zzrr"});
            case 4:
                return zzrs;
            case 5:
                j3<u> j3Var2 = zzbk;
                j3<u> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (u.class) {
                        j3<u> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzrs);
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
