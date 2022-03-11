package f.b.a.a.a.e0;

import android.text.TextUtils;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.t.p0.a;
import java.util.Objects;
import l.b.a.e;
import l.b.a.f;
import l.b.a.r;
import l.b.a.t;
/* loaded from: classes.dex */
public final class o5 {
    public static final a a = a.e("DiagnosisEntityHelper");

    public static boolean a(j0 j0Var) {
        return j0Var != null && j0.c.SHARED.equals(j0Var.m());
    }

    public static boolean b(j0 j0Var) {
        return !TextUtils.isEmpty(j0Var.p()) && !TextUtils.isEmpty(j0Var.j());
    }

    public static boolean c(f.b.a.a.a.t.q0.a aVar, long j2) {
        e c = aVar.c();
        r rVar = r.f4641g;
        Objects.requireNonNull(c);
        if (j2 < f.E(t.I(c, rVar)).A(rVar).L(-14).w().G()) {
            return false;
        }
        if (j2 <= aVar.a()) {
            return true;
        }
        return false;
    }
}
