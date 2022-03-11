package f.b.a.f.a.b;

import f.b.a.c.b.o.b;
import f.b.a.f.a.e.a;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public final class c3 {
    public static final a b = new a("VerifySliceTaskHandler");
    public final d0 a;

    public c3(d0 d0Var) {
        this.a = d0Var;
    }

    public final void a(b3 b3Var) {
        File s = this.a.s(b3Var.b, b3Var.c, b3Var.f3197d, b3Var.f3198e);
        if (s.exists()) {
            try {
                File r = this.a.r(b3Var.b, b3Var.c, b3Var.f3197d, b3Var.f3198e);
                if (r.exists()) {
                    try {
                        if (b.I1(a3.a(s, r)).equals(b3Var.f3199f)) {
                            b.d("Verification of slice %s of pack %s successful.", b3Var.f3198e, b3Var.b);
                            File t = this.a.t(b3Var.b, b3Var.c, b3Var.f3197d, b3Var.f3198e);
                            if (!t.exists()) {
                                t.mkdirs();
                            }
                            if (!s.renameTo(t)) {
                                throw new z0(String.format("Failed to move slice %s after verification.", b3Var.f3198e), b3Var.a);
                            }
                            return;
                        }
                        throw new z0(String.format("Verification failed for slice %s.", b3Var.f3198e), b3Var.a);
                    } catch (IOException e2) {
                        throw new z0(String.format("Could not digest file during verification for slice %s.", b3Var.f3198e), e2, b3Var.a);
                    } catch (NoSuchAlgorithmException e3) {
                        throw new z0("SHA256 algorithm not supported.", e3, b3Var.a);
                    }
                } else {
                    throw new z0(String.format("Cannot find metadata files for slice %s.", b3Var.f3198e), b3Var.a);
                }
            } catch (IOException e4) {
                throw new z0(String.format("Could not reconstruct slice archive during verification for slice %s.", b3Var.f3198e), e4, b3Var.a);
            }
        } else {
            throw new z0(String.format("Cannot find unverified files for slice %s.", b3Var.f3198e), b3Var.a);
        }
    }
}
