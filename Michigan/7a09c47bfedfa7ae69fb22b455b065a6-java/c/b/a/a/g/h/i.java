package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class i extends t1<i, a> implements d3 {
    public static volatile j3<i> zzbk;
    public static final a2<Integer, d0> zzoh = new w();
    public static final i zzoi;
    public x1 zzog = v1.f4048e;

    public static final class a extends t1.a<i, a> implements d3 {
        public a(g gVar) {
            super(i.zzoi);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [c.b.a.a.g.h.a2<java.lang.Integer, c.b.a.a.g.h.d0>, c.b.a.a.g.h.w] */
    static {
        i iVar = new i();
        zzoi = iVar;
        t1.zzyb.put(i.class, iVar);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.t1$b, c.b.a.a.g.h.j3<c.b.a.a.g.h.i>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<i> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new i();
            case 2:
                return new a(null);
            case 3:
                return new o3(zzoi, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzog", e0.f3866a});
            case 4:
                return zzoi;
            case 5:
                j3<i> j3Var2 = zzbk;
                j3<i> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (i.class) {
                        j3<i> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzoi);
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
