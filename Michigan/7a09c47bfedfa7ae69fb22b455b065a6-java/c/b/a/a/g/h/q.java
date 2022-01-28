package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class q extends t1<q, a> implements d3 {
    public static volatile j3<q> zzbk;
    public static final q zzqz;
    public int zzbm;
    public int zzoj;
    public long zzqv;
    public long zzqw;
    public long zzqx;
    public long zzqy;

    public static final class a extends t1.a<q, a> implements d3 {
        public a(g gVar) {
            super(q.zzqz);
        }
    }

    public enum b implements w1 {
        FORMAT_UNKNOWN(0),
        FORMAT_LUMINANCE(1),
        FORMAT_RGB8(2),
        FORMAT_MONOCHROME(3);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f4005b;

        /* access modifiers changed from: public */
        b(int i) {
            this.f4005b = i;
        }

        public static b b(int i) {
            if (i == 0) {
                return FORMAT_UNKNOWN;
            }
            if (i == 1) {
                return FORMAT_LUMINANCE;
            }
            if (i == 2) {
                return FORMAT_RGB8;
            }
            if (i != 3) {
                return null;
            }
            return FORMAT_MONOCHROME;
        }

        @Override // c.b.a.a.g.h.w1
        public final int h() {
            return this.f4005b;
        }

        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f4005b + " name=" + name() + '>';
        }
    }

    static {
        q qVar = new q();
        zzqz = qVar;
        t1.zzyb.put(q.class, qVar);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.t1$b, c.b.a.a.g.h.j3<c.b.a.a.g.h.q>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<q> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new q();
            case 2:
                return new a(null);
            case 3:
                return new o3(zzqz, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0004\u0005ဂ\u0003", new Object[]{"zzbm", "zzoj", c0.f3848a, "zzqv", "zzqw", "zzqy", "zzqx"});
            case 4:
                return zzqz;
            case 5:
                j3<q> j3Var2 = zzbk;
                j3<q> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (q.class) {
                        j3<q> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzqz);
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
