package c.b.a.a.g.b;

import c.b.a.a.g.b.z0;

public final class r4 extends z0<r4, a> implements g2 {
    public static volatile n2<r4> zzbg;
    public static final r4 zzbir;
    public e1<b> zzbiq = q2.f3398d;

    public static final class a extends z0.a<r4, a> implements g2 {
        public a(s4 s4Var) {
            super(r4.zzbir);
        }
    }

    public static final class b extends z0<b, a> implements g2 {
        public static volatile n2<b> zzbg;
        public static final b zzbiv;
        public int zzbb;
        public String zzbis = "";
        public long zzbit;
        public long zzbiu;
        public int zzya;

        static {
            b bVar = new b();
            zzbiv = bVar;
            z0.zzjr.put(b.class, bVar);
        }

        public static void k(b bVar, String str) {
            if (str != null) {
                bVar.zzbb |= 2;
                bVar.zzbis = str;
                return;
            }
            throw null;
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.b.n2<c.b.a.a.g.b.r4$b>, c.b.a.a.g.b.z0$b] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // c.b.a.a.g.b.z0
        public final Object g(int i, Object obj, Object obj2) {
            n2<b> n2Var;
            switch (s4.f3413a[i - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a(null);
                case 3:
                    return new r2(zzbiv, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0002\u0003", new Object[]{"zzbb", "zzya", "zzbis", "zzbit", "zzbiu"});
                case 4:
                    return zzbiv;
                case 5:
                    n2<b> n2Var2 = zzbg;
                    n2<b> n2Var3 = n2Var2;
                    if (n2Var2 == null) {
                        synchronized (b.class) {
                            n2<b> n2Var4 = zzbg;
                            n2Var = n2Var4;
                            if (n2Var4 == null) {
                                ?? bVar = new z0.b(zzbiv);
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

        public static final class a extends z0.a<b, a> implements g2 {
            public a() {
                super(b.zzbiv);
            }

            public a(s4 s4Var) {
                super(b.zzbiv);
            }
        }
    }

    static {
        r4 r4Var = new r4();
        zzbir = r4Var;
        z0.zzjr.put(r4.class, r4Var);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.b.n2<c.b.a.a.g.b.r4>, c.b.a.a.g.b.z0$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.b.z0
    public final Object g(int i, Object obj, Object obj2) {
        n2<r4> n2Var;
        switch (s4.f3413a[i - 1]) {
            case 1:
                return new r4();
            case 2:
                return new a(null);
            case 3:
                return new r2(zzbir, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzbiq", b.class});
            case 4:
                return zzbir;
            case 5:
                n2<r4> n2Var2 = zzbg;
                n2<r4> n2Var3 = n2Var2;
                if (n2Var2 == null) {
                    synchronized (r4.class) {
                        n2<r4> n2Var4 = zzbg;
                        n2Var = n2Var4;
                        if (n2Var4 == null) {
                            ?? bVar = new z0.b(zzbir);
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
