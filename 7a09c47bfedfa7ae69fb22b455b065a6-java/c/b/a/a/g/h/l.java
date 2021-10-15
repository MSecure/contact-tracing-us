package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class l extends t1<l, b> implements d3 {
    public static volatile j3<l> zzbk;
    public static final l zzox;
    public int zzbm;
    public String zzop = "";
    public boolean zzoq;
    public int zzor;
    public long zzos;
    public long zzot;
    public long zzou;
    public String zzov = "";
    public boolean zzow;

    public enum a implements w1 {
        REASON_UNKNOWN(0),
        REASON_MISSING(1),
        REASON_UPGRADE(2),
        REASON_INVALID(3);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f3934b;

        /* access modifiers changed from: public */
        a(int i) {
            this.f3934b = i;
        }

        public static a b(int i) {
            if (i == 0) {
                return REASON_UNKNOWN;
            }
            if (i == 1) {
                return REASON_MISSING;
            }
            if (i == 2) {
                return REASON_UPGRADE;
            }
            if (i != 3) {
                return null;
            }
            return REASON_INVALID;
        }

        @Override // c.b.a.a.g.h.w1
        public final int h() {
            return this.f3934b;
        }

        public final String toString() {
            return "<" + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f3934b + " name=" + name() + '>';
        }
    }

    public static final class b extends t1.a<l, b> implements d3 {
        public b(g gVar) {
            super(l.zzox);
        }
    }

    static {
        l lVar = new l();
        zzox = lVar;
        t1.zzyb.put(l.class, lVar);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.j3<c.b.a.a.g.h.l>, c.b.a.a.g.h.t1$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<l> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new l();
            case 2:
                return new b(null);
            case 3:
                return new o3(zzox, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဌ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဈ\u0006\bဇ\u0007", new Object[]{"zzbm", "zzop", "zzoq", "zzor", x.f4061a, "zzos", "zzot", "zzou", "zzov", "zzow"});
            case 4:
                return zzox;
            case 5:
                j3<l> j3Var2 = zzbk;
                j3<l> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (l.class) {
                        j3<l> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzox);
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
