package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class k extends t1<k, a> implements d3 {
    public static volatile j3<k> zzbk;
    public static final k zzoo;
    public z1<t> zzon = m3.f3947e;

    public static final class a extends t1.a<k, a> implements d3 {
        public a(g gVar) {
            super(k.zzoo);
        }
    }

    static {
        k kVar = new k();
        zzoo = kVar;
        t1.zzyb.put(k.class, kVar);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.j3<c.b.a.a.g.h.k>, c.b.a.a.g.h.t1$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<k> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new k();
            case 2:
                return new a(null);
            case 3:
                return new o3(zzoo, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzon", t.class});
            case 4:
                return zzoo;
            case 5:
                j3<k> j3Var2 = zzbk;
                j3<k> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (k.class) {
                        j3<k> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzoo);
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
