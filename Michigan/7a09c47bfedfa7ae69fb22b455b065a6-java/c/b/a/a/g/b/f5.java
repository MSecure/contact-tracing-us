package c.b.a.a.g.b;

import java.io.IOException;

public final /* synthetic */ class f5 implements n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f3267a = new f5();

    public final Object a(byte[] bArr) {
        z0 z0Var = (z0) r4.zzbir.g(4, null, null);
        try {
            p2.f3390c.b(z0Var).h(z0Var, bArr, 0, bArr.length, new u());
            p2.f3390c.b(z0Var).i(z0Var);
            if (z0Var.zzex == 0) {
                boolean z = true;
                byte byteValue = ((Byte) z0Var.g(1, null, null)).byteValue();
                if (byteValue != 1) {
                    if (byteValue == 0) {
                        z = false;
                    } else {
                        z = p2.f3390c.b(z0Var).f(z0Var);
                        z0Var.g(2, z ? z0Var : null, null);
                    }
                }
                if (z) {
                    return (r4) z0Var;
                }
                throw new f1(new g3().getMessage());
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof f1) {
                throw ((f1) e2.getCause());
            }
            throw new f1(e2.getMessage());
        } catch (IndexOutOfBoundsException unused) {
            throw f1.a();
        }
    }
}
