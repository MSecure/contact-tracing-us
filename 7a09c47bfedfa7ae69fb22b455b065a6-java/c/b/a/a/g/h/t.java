package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class t extends t1<t, a> implements d3 {
    public static volatile j3<t> zzbk;
    public static final t zzrn;
    public int zzbm;
    public int zzrl;
    public int zzrm;

    public static final class a extends t1.a<t, a> implements d3 {
        public a(g gVar) {
            super(t.zzrn);
        }
    }

    static {
        t tVar = new t();
        zzrn = tVar;
        t1.zzyb.put(t.class, tVar);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.t1$b, c.b.a.a.g.h.j3<c.b.a.a.g.h.t>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<t> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new t();
            case 2:
                return new a(null);
            case 3:
                return new o3(zzrn, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzbm", "zzrl", "zzrm"});
            case 4:
                return zzrn;
            case 5:
                j3<t> j3Var2 = zzbk;
                j3<t> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (t.class) {
                        j3<t> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzrn);
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
