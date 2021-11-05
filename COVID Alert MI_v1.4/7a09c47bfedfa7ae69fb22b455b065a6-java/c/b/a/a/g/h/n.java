package c.b.a.a.g.h;

import c.b.a.a.g.h.t1;

public final class n extends t1<n, b> implements d3 {
    public static volatile j3<n> zzbk;
    public static final n zzpv;
    public int zzbm;
    public float zzkp;
    public boolean zzkt;
    public int zzpr;
    public int zzps;
    public int zzpt;
    public boolean zzpu;

    public enum a implements w1 {
        CLASSIFICATION_UNKNOWN(0),
        CLASSIFICATION_NONE(1),
        CLASSIFICATION_ALL(2);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f3954b;

        /* access modifiers changed from: public */
        a(int i) {
            this.f3954b = i;
        }

        public static a b(int i) {
            if (i == 0) {
                return CLASSIFICATION_UNKNOWN;
            }
            if (i == 1) {
                return CLASSIFICATION_NONE;
            }
            if (i != 2) {
                return null;
            }
            return CLASSIFICATION_ALL;
        }

        @Override // c.b.a.a.g.h.w1
        public final int h() {
            return this.f3954b;
        }

        public final String toString() {
            return "<" + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f3954b + " name=" + name() + '>';
        }
    }

    public static final class b extends t1.a<n, b> implements d3 {
        public b(g gVar) {
            super(n.zzpv);
        }
    }

    public enum c implements w1 {
        LANDMARK_UNKNOWN(0),
        LANDMARK_NONE(1),
        LANDMARK_ALL(2),
        LANDMARK_CONTOUR(3);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f3960b;

        /* access modifiers changed from: public */
        c(int i) {
            this.f3960b = i;
        }

        public static c b(int i) {
            if (i == 0) {
                return LANDMARK_UNKNOWN;
            }
            if (i == 1) {
                return LANDMARK_NONE;
            }
            if (i == 2) {
                return LANDMARK_ALL;
            }
            if (i != 3) {
                return null;
            }
            return LANDMARK_CONTOUR;
        }

        @Override // c.b.a.a.g.h.w1
        public final int h() {
            return this.f3960b;
        }

        public final String toString() {
            return "<" + c.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f3960b + " name=" + name() + '>';
        }
    }

    public enum d implements w1 {
        MODE_UNKNOWN(0),
        MODE_ACCURATE(1),
        MODE_FAST(2),
        MODE_SELFIE(3);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f3966b;

        /* access modifiers changed from: public */
        d(int i) {
            this.f3966b = i;
        }

        public static d b(int i) {
            if (i == 0) {
                return MODE_UNKNOWN;
            }
            if (i == 1) {
                return MODE_ACCURATE;
            }
            if (i == 2) {
                return MODE_FAST;
            }
            if (i != 3) {
                return null;
            }
            return MODE_SELFIE;
        }

        @Override // c.b.a.a.g.h.w1
        public final int h() {
            return this.f3966b;
        }

        public final String toString() {
            return "<" + d.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f3966b + " name=" + name() + '>';
        }
    }

    static {
        n nVar = new n();
        zzpv = nVar;
        t1.zzyb.put(n.class, nVar);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [c.b.a.a.g.h.j3<c.b.a.a.g.h.n>, c.b.a.a.g.h.t1$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.t1
    public final Object g(int i, Object obj, Object obj2) {
        j3<n> j3Var;
        switch (g.f3894a[i - 1]) {
            case 1:
                return new n();
            case 2:
                return new b(null);
            case 3:
                return new o3(zzpv, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzbm", "zzpr", b0.f3841a, "zzps", a0.f3837a, "zzpt", z.f4073a, "zzkt", "zzpu", "zzkp"});
            case 4:
                return zzpv;
            case 5:
                j3<n> j3Var2 = zzbk;
                j3<n> j3Var3 = j3Var2;
                if (j3Var2 == null) {
                    synchronized (n.class) {
                        j3<n> j3Var4 = zzbk;
                        j3Var = j3Var4;
                        if (j3Var4 == null) {
                            ?? bVar = new t1.b(zzpv);
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
