package c.b.a.a.g.b;

import c.b.a.a.g.b.z0;

public final class l4 extends z0<l4, a> implements g2 {
    public static volatile n2<l4> zzbg;
    public static final l4 zztx;
    public int zzbb;
    public int zztu;
    public String zztv = "";
    public String zztw = "";

    public static final class a extends z0.a<l4, a> implements g2 {
        public a(o4 o4Var) {
            super(l4.zztx);
        }
    }

    static {
        l4 l4Var = new l4();
        zztx = l4Var;
        z0.zzjr.put(l4.class, l4Var);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.b.n2<c.b.a.a.g.b.l4>, c.b.a.a.g.b.z0$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.b.z0
    public final Object g(int i, Object obj, Object obj2) {
        n2<l4> n2Var;
        switch (o4.f3385a[i - 1]) {
            case 1:
                return new l4();
            case 2:
                return new a(null);
            case 3:
                return new r2(zztx, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\b\u0002", new Object[]{"zzbb", "zztu", "zztv", "zztw"});
            case 4:
                return zztx;
            case 5:
                n2<l4> n2Var2 = zzbg;
                n2<l4> n2Var3 = n2Var2;
                if (n2Var2 == null) {
                    synchronized (l4.class) {
                        n2<l4> n2Var4 = zzbg;
                        n2Var = n2Var4;
                        if (n2Var4 == null) {
                            ?? bVar = new z0.b(zztx);
                            zzbg = bVar;
                            n2Var = bVar;
                        }
                    }
                    n2Var3 = n2Var;
                }
                return n2Var3;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
