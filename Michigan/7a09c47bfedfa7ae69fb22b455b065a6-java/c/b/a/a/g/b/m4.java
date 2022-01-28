package c.b.a.a.g.b;

import c.b.a.a.g.b.z0;

public final class m4 extends z0<m4, a> implements g2 {
    public static final m4 zzbfc;
    public static volatile n2<m4> zzbg;
    public int zzbb;
    public int zzbfa = -1;
    public int zzbfb;

    public static final class a extends z0.a<m4, a> implements g2 {
        public a(o4 o4Var) {
            super(m4.zzbfc);
        }
    }

    public enum b implements c1 {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);
        
        public static final d1<b> x = new p4();

        /* renamed from: b  reason: collision with root package name */
        public final int f3355b;

        /* access modifiers changed from: public */
        b(int i) {
            this.f3355b = i;
        }

        @Override // c.b.a.a.g.b.c1
        public final int c() {
            return this.f3355b;
        }
    }

    public enum c implements c1 {
        NONE(-1),
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17);
        
        public static final d1<c> v = new q4();

        /* renamed from: b  reason: collision with root package name */
        public final int f3361b;

        /* access modifiers changed from: public */
        c(int i) {
            this.f3361b = i;
        }

        @Override // c.b.a.a.g.b.c1
        public final int c() {
            return this.f3361b;
        }
    }

    static {
        m4 m4Var = new m4();
        zzbfc = m4Var;
        z0.zzjr.put(m4.class, m4Var);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.b.z0$b, c.b.a.a.g.b.n2<c.b.a.a.g.b.m4>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.b.z0
    public final Object g(int i, Object obj, Object obj2) {
        n2<m4> n2Var;
        switch (o4.f3385a[i - 1]) {
            case 1:
                return new m4();
            case 2:
                return new a(null);
            case 3:
                return new r2(zzbfc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzbb", "zzbfa", c.v, "zzbfb", b.x});
            case 4:
                return zzbfc;
            case 5:
                n2<m4> n2Var2 = zzbg;
                n2<m4> n2Var3 = n2Var2;
                if (n2Var2 == null) {
                    synchronized (m4.class) {
                        n2<m4> n2Var4 = zzbg;
                        n2Var = n2Var4;
                        if (n2Var4 == null) {
                            ?? bVar = new z0.b(zzbfc);
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
