package h.a.k1;

import h.a.l0;
import h.a.m0;

public final class e extends m0 {
    @Override // h.a.m0
    public l0 a(String str) {
        return d.forTarget(str);
    }

    @Override // h.a.m0
    public boolean b() {
        return true;
    }

    @Override // h.a.m0
    public int c() {
        boolean z = false;
        try {
            Class.forName("android.app.Application", false, e.class.getClassLoader());
            z = true;
        } catch (Exception unused) {
        }
        return z ? 8 : 3;
    }
}
