package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class m extends t1<m, a> implements d3 {
    public static volatile j3<m> zzbk;
    public static final m zzpl;
    public int zzbm;
    public String zzpd = "";
    public String zzpe = "";
    public z1<String> zzpf;
    public int zzpg;
    public String zzph;
    public long zzpi;
    public long zzpj;
    public z1<u> zzpk;

    public static final class a extends t1.a<m, a> implements d3 {
        public a(g gVar) {
            super(m.zzpl);
        }
    }

    public enum b implements w1 {
        RESULT_UNKNOWN(0),
        RESULT_SUCCESS(1),
        RESULT_FAIL(2),
        RESULT_SKIPPED(3);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f3940b;

        /* access modifiers changed from: public */
        b(int i) {
            this.f3940b = i;
        }

        public static b b(int i) {
            if (i == 0) {
                return RESULT_UNKNOWN;
            }
            if (i == 1) {
                return RESULT_SUCCESS;
            }
            if (i == 2) {
                return RESULT_FAIL;
            }
            if (i != 3) {
                return null;
            }
            return RESULT_SKIPPED;
        }

        @Override // c.b.a.a.g.h.w1
        public final int h() {
            return this.f3940b;
        }

        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f3940b + " name=" + name() + '>';
        }
    }

    static {
        m mVar = new m();
        zzpl = mVar;
        t1.zzyb.put(m.class, mVar);
    }

    public m() {
        m3<Object> m3Var = m3.f3947e;
        this.zzpf = m3Var;
        this.zzph = "";
        this.zzpk = m3Var;
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.j3<c.b.a.a.g.h.m>, c.b.a.a.g.h.t1$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<m> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new m();
            case 2:
                return new a(null);
            case 3:
                return new o3(zzpl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a\u0004ဌ\u0002\u0005ဈ\u0003\u0006ဂ\u0004\u0007ဂ\u0005\b\u001b", new Object[]{"zzbm", "zzpd", "zzpe", "zzpf", "zzpg", y.f4069a, "zzph", "zzpi", "zzpj", "zzpk", u.class});
            case 4:
                return zzpl;
            case 5:
                j3<m> j3Var2 = zzbk;
                j3<m> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (m.class) {
                        j3<m> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzpl);
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
