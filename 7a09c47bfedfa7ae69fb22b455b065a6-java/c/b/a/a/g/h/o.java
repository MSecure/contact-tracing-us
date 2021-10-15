package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class o extends t1<o, a> implements d3 {
    public static volatile j3<o> zzbk;
    public static final o zzqq;
    public int zzbm;
    public float zzqk;
    public float zzql;
    public float zzqm;
    public float zzqn;
    public float zzqo;
    public float zzqp;

    public static final class a extends t1.a<o, a> implements d3 {
        public a(g gVar) {
            super(o.zzqq);
        }
    }

    static {
        o oVar = new o();
        zzqq = oVar;
        t1.zzyb.put(o.class, oVar);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.t1$b, c.b.a.a.g.h.j3<c.b.a.a.g.h.o>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<o> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new o();
            case 2:
                return new a(null);
            case 3:
                return new o3(zzqq, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005", new Object[]{"zzbm", "zzqk", "zzql", "zzqm", "zzqn", "zzqo", "zzqp"});
            case 4:
                return zzqq;
            case 5:
                j3<o> j3Var2 = zzbk;
                j3<o> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (o.class) {
                        j3<o> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzqq);
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
