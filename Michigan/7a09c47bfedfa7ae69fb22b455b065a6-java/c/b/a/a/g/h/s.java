package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class s extends t1<s, a> implements d3 {
    public static volatile j3<s> zzbk;
    public static final s zzrk;
    public int zzbm;
    public long zzpi;
    public long zzpj;

    public static final class a extends t1.a<s, a> implements d3 {
        public a(g gVar) {
            super(s.zzrk);
        }
    }

    static {
        s sVar = new s();
        zzrk = sVar;
        t1.zzyb.put(s.class, sVar);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.t1$b, c.b.a.a.g.h.j3<c.b.a.a.g.h.s>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<s> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new s();
            case 2:
                return new a(null);
            case 3:
                return new o3(zzrk, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001", new Object[]{"zzbm", "zzpi", "zzpj"});
            case 4:
                return zzrk;
            case 5:
                j3<s> j3Var2 = zzbk;
                j3<s> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (s.class) {
                        j3<s> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzrk);
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
