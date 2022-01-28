package c.b.c.a.b0;

import c.b.c.a.g0.c;
import c.b.c.a.i0.g1;
import c.b.c.a.y;
import java.security.GeneralSecurityException;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4776a = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";

    /* renamed from: b  reason: collision with root package name */
    public static final String f4777b = "type.googleapis.com/google.crypto.tink.AesGcmKey";
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final g1 f4778c = g1.DEFAULT_INSTANCE;

    static {
        new c();
        new f();
        new e();
        new h();
        new j();
        new g();
        new k();
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() {
        c.a();
        y.i(new c(), true);
        y.i(new e(), true);
        y.i(new f(), true);
        y.i(new g(), true);
        y.i(new h(), true);
        y.i(new j(), true);
        y.i(new k(), true);
        y.j(new b());
    }
}
