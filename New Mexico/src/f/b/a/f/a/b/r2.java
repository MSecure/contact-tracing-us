package f.b.a.f.a.b;

import f.b.a.c.b.o.b;
import f.b.a.f.a.e.a;
import f.b.a.f.a.e.r;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
/* loaded from: classes.dex */
public final class r2 {
    public static final a c = new a("PatchSliceTaskHandler");
    public final d0 a;
    public final r<v3> b;

    public r2(d0 d0Var, r<v3> rVar) {
        this.a = d0Var;
        this.b = rVar;
    }

    public final void a(q2 q2Var) {
        File n = this.a.n(q2Var.b, q2Var.c, q2Var.f3279d);
        File file = new File(this.a.o(q2Var.b, q2Var.c, q2Var.f3279d), q2Var.f3283h);
        try {
            InputStream inputStream = q2Var.f3285j;
            if (q2Var.f3282g == 2) {
                inputStream = new GZIPInputStream(inputStream, 8192);
            }
            g0 g0Var = new g0(n, file);
            File s = this.a.s(q2Var.b, q2Var.f3280e, q2Var.f3281f, q2Var.f3283h);
            if (!s.exists()) {
                s.mkdirs();
            }
            y2 y2Var = new y2(this.a, q2Var.b, q2Var.f3280e, q2Var.f3281f, q2Var.f3283h);
            b.B1(g0Var, inputStream, new c1(s, y2Var), q2Var.f3284i);
            y2Var.h(0);
            inputStream.close();
            c.d("Patching and extraction finished for slice %s of pack %s.", q2Var.f3283h, q2Var.b);
            this.b.a().a(q2Var.a, q2Var.b, q2Var.f3283h, 0);
            try {
                q2Var.f3285j.close();
            } catch (IOException unused) {
                c.e("Could not close file for slice %s of pack %s.", q2Var.f3283h, q2Var.b);
            }
        } catch (IOException e2) {
            c.b("IOException during patching %s.", e2.getMessage());
            throw new z0(String.format("Error patching slice %s of pack %s.", q2Var.f3283h, q2Var.b), e2, q2Var.a);
        }
    }
}
