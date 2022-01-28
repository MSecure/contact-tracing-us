package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class p extends t1<p, a> implements d3 {
    public static volatile j3<p> zzbk;
    public static final p zzqu;
    public int zzbm;
    public q zzqr;
    public s zzqs;
    public z1<m> zzqt = m3.f3947e;

    public static final class a extends t1.a<p, a> implements d3 {
        public a(g gVar) {
            super(p.zzqu);
        }
    }

    static {
        p pVar = new p();
        zzqu = pVar;
        t1.zzyb.put(p.class, pVar);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.t1$b, c.b.a.a.g.h.j3<c.b.a.a.g.h.p>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<p> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new p();
            case 2:
                return new a(null);
            case 3:
                return new o3(zzqu, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b", new Object[]{"zzbm", "zzqr", "zzqs", "zzqt", m.class});
            case 4:
                return zzqu;
            case 5:
                j3<p> j3Var2 = zzbk;
                j3<p> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (p.class) {
                        j3<p> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzqu);
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
