package f.b.a.a.a.n0;

import f.b.a.a.a.n0.k;
import l.b.a.f;
/* loaded from: classes.dex */
public abstract class j0 {

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract j0 a();

        public abstract a b(long j2);

        public abstract a c(b bVar);

        public abstract a d(long j2);
    }

    /* loaded from: classes.dex */
    public enum b {
        UNSET,
        YES,
        NO,
        WITHHELD
    }

    /* loaded from: classes.dex */
    public enum c {
        NOT_ATTEMPTED,
        SHARED,
        NOT_SHARED
    }

    /* loaded from: classes.dex */
    public enum d {
        CONFIRMED,
        LIKELY,
        NEGATIVE,
        USER_REPORT;

        public static d a(String str) {
            String lowerCase = str.toLowerCase();
            lowerCase.hashCode();
            lowerCase.hashCode();
            char c = 65535;
            switch (lowerCase.hashCode()) {
                case -1618081418:
                    if (lowerCase.equals("user-report")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1102761116:
                    if (lowerCase.equals("likely")) {
                        c = 1;
                        break;
                    }
                    break;
                case -804109473:
                    if (lowerCase.equals("confirmed")) {
                        c = 2;
                        break;
                    }
                    break;
                case 921111605:
                    if (lowerCase.equals("negative")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return USER_REPORT;
                case 1:
                    return LIKELY;
                case 2:
                    return CONFIRMED;
                case 3:
                    return NEGATIVE;
                default:
                    throw new IllegalArgumentException(f.a.a.a.a.x("Unsupported test type ", str));
            }
        }

        public String b() {
            return this == USER_REPORT ? "user-report" : name().toLowerCase();
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        NOT_ATTEMPTED,
        TRAVELED,
        NOT_TRAVELED,
        NO_ANSWER
    }

    public static j0 a(long j2, long j3, c cVar, String str, String str2, String str3, d dVar, boolean z, f fVar, b bVar, String str4, e eVar, boolean z2, long j4, boolean z3) {
        k.b bVar2 = (k.b) q();
        bVar2.a = Long.valueOf(j2);
        bVar2.b = Long.valueOf(j3);
        bVar2.c = cVar;
        bVar2.f2358d = str;
        bVar2.f2359e = str2;
        bVar2.f2360f = str3;
        bVar2.f2361g = dVar;
        bVar2.f2363i = Boolean.valueOf(z);
        bVar2.f2362h = fVar;
        bVar2.c(bVar);
        bVar2.f2365k = str4;
        bVar2.f2366l = eVar;
        bVar2.m = Boolean.valueOf(z2);
        bVar2.n = Long.valueOf(j4);
        bVar2.o = Boolean.valueOf(z3);
        return bVar2.a();
    }

    public static a q() {
        k.b bVar = new k.b();
        bVar.a = 0L;
        bVar.b(0);
        bVar.g(false);
        bVar.c(b.UNSET);
        bVar.f2366l = e.NOT_ATTEMPTED;
        bVar.e(false);
        bVar.d(0);
        bVar.f(false);
        return bVar;
    }

    public abstract String b();

    public abstract long c();

    public abstract b d();

    public abstract long e();

    public abstract boolean f();

    public abstract boolean g();

    public abstract boolean h();

    public abstract long i();

    public abstract String j();

    public abstract f k();

    public abstract String l();

    public abstract c m();

    public abstract d n();

    public abstract e o();

    public abstract String p();

    public abstract a r();
}
