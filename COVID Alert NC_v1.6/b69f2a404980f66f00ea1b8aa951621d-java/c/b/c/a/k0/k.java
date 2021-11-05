package c.b.c.a.k0;

import c.b.c.a.i0.g1;
import c.b.c.a.y;
import java.security.GeneralSecurityException;

public final class k {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final g1 f3693a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final g1 f3694b;

    /* renamed from: c  reason: collision with root package name */
    public static final g1 f3695c;

    static {
        new b();
        new a();
        new d();
        new c();
        new g();
        new h();
        g1 g1Var = g1.DEFAULT_INSTANCE;
        f3693a = g1Var;
        f3694b = g1Var;
        f3695c = g1Var;
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() {
        y.h(new a(), new b(), true);
        y.h(new c(), new d(), true);
        y.h(new g(), new h(), true);
        y.h(new i(), new j(), true);
        y.j(new e());
        y.j(new f());
    }
}
