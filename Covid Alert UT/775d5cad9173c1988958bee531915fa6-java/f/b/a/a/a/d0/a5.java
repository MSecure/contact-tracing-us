package f.b.a.a.a.d0;

import android.text.TextUtils;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.s.d0.a;
import java.util.Objects;
import l.b.a.e;
import l.b.a.f;
import l.b.a.r;
import l.b.a.t;

public final class a5 {
    public static final a a = a.e("DiagnosisEntityHelper");

    public static boolean a(h0 h0Var) {
        return h0Var != null && h0.c.SHARED.equals(h0Var.m());
    }

    public static boolean b(h0 h0Var) {
        return !TextUtils.isEmpty(h0Var.p()) && !TextUtils.isEmpty(h0Var.j());
    }

    public static boolean c(f.b.a.a.a.s.e0.a aVar, long j2) {
        e c = aVar.c();
        r rVar = r.f4386g;
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
