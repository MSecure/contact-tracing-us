package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class r extends t1<r, a> implements d3 {
    public static volatile j3<r> zzbk;
    public static final r zzrj;
    public int zzbm;
    public String zzov = "";
    public String zzpd = "";
    public long zzrf;
    public h zzrg;
    public n zzrh;
    public i zzri;

    public static final class a extends t1.a<r, a> implements d3 {
        public a(g gVar) {
            super(r.zzrj);
        }
    }

    static {
        r rVar = new r();
        zzrj = rVar;
        t1.zzyb.put(r.class, rVar);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.t1$b, c.b.a.a.g.h.j3<c.b.a.a.g.h.r>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<r> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new r();
            case 2:
                return new a(null);
            case 3:
                return new o3(zzrj, "\u0001\u0006\u0000\u0001\u0001\u0011\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဉ\u0002\u0006ဈ\u0003\u0010ဉ\u0004\u0011ဉ\u0005", new Object[]{"zzbm", "zzpd", "zzrf", "zzrg", "zzov", "zzrh", "zzri"});
            case 4:
                return zzrj;
            case 5:
                j3<r> j3Var2 = zzbk;
                j3<r> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (r.class) {
                        j3<r> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzrj);
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
