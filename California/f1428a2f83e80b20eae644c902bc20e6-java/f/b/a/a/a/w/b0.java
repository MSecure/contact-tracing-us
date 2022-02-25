package f.b.a.a.a.w;

import f.b.a.a.a.w.j;

public abstract class b0 {

    public static abstract class a {
        public abstract b0 a();

        public abstract a b(long j2);

        public abstract a c(b bVar);
    }

    public enum b {
        UNSET,
        YES,
        NO,
        WITHHELD
    }

    public enum c {
        NOT_ATTEMPTED,
        SHARED,
        NOT_SHARED
    }

    public enum d {
        CONFIRMED,
        LIKELY,
        NEGATIVE;

        public String a() {
            return name().toLowerCase();
        }
    }

    public enum e {
        NOT_ATTEMPTED,
        TRAVELED,
        NOT_TRAVELED,
        NO_ANSWER
    }

    public static b0 a(long j2, long j3, c cVar, String str, String str2, String str3, d dVar, boolean z, l.b.a.e eVar, b bVar, String str4, e eVar2, boolean z2) {
        j.b bVar2 = (j.b) o();
        bVar2.a = Long.valueOf(j2);
        bVar2.b = Long.valueOf(j3);
        bVar2.c = cVar;
        bVar2.f2269d = str;
        bVar2.f2270e = str2;
        bVar2.f2271f = str3;
        bVar2.f2272g = dVar;
        bVar2.f2274i = Boolean.valueOf(z);
        bVar2.f2273h = eVar;
        bVar2.c(bVar);
        bVar2.f2276k = str4;
        bVar2.f2277l = eVar2;
        bVar2.m = Boolean.valueOf(z2);
        return bVar2.a();
    }

    public static a o() {
        j.b bVar = new j.b();
        bVar.a = 0L;
        bVar.b(0);
        bVar.e(false);
        bVar.c(b.UNSET);
        bVar.f2277l = e.NOT_ATTEMPTED;
        bVar.d(false);
        return bVar;
    }

    public abstract String b();

    public abstract long c();

    public abstract b d();

    public abstract long e();

    public abstract boolean f();

    public abstract boolean g();

    public abstract String h();

    public abstract l.b.a.e i();

    public abstract String j();

    public abstract c k();

    public abstract d l();

    public abstract e m();

    public abstract String n();

    public abstract a p();
}
