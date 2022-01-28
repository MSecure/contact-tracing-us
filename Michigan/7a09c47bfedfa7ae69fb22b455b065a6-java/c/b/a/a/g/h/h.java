package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class h extends t1<h, a> implements d3 {
    public static volatile j3<h> zzbk;
    public static final h zzof;
    public int zzbm;
    public String zzod = "";
    public String zzoe = "";

    static {
        h hVar = new h();
        zzof = hVar;
        t1.zzyb.put(h.class, hVar);
    }

    public static void k(h hVar, String str) {
        if (hVar != null) {
            str.getClass();
            hVar.zzbm |= 1;
            hVar.zzod = str;
            return;
        }
        throw null;
    }

    public static void l(h hVar, String str) {
        if (hVar != null) {
            str.getClass();
            hVar.zzbm |= 2;
            hVar.zzoe = str;
            return;
        }
        throw null;
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.t1$b, c.b.a.a.g.h.j3<c.b.a.a.g.h.h>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<h> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new h();
            case 2:
                return new a(null);
            case 3:
                return new o3(zzof, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzbm", "zzod", "zzoe"});
            case 4:
                return zzof;
            case 5:
                j3<h> j3Var2 = zzbk;
                j3<h> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (h.class) {
                        j3<h> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzof);
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

    public static final class a extends t1.a<h, a> implements d3 {
        public a() {
            super(h.zzof);
        }

        public a(g gVar) {
            super(h.zzof);
        }
    }
}
