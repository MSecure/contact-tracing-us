package f.b.c.k.w;

import f.b.a.c.b.o.b;
import f.b.c.k.s.v;
import java.util.Locale;

public final /* synthetic */ class e0 implements Runnable {
    public final f0 b;

    public e0(f0 f0Var) {
        this.b = f0Var;
    }

    public void run() {
        f0 f0Var = this.b;
        f0Var.c = null;
        b.b1(f0Var.a == v.UNKNOWN, "Timer should be canceled if we transitioned to a different state.", new Object[0]);
        f0Var.a(String.format(Locale.ENGLISH, "Backend didn't respond within %d seconds\n", 10));
        f0Var.b(v.OFFLINE);
    }
}
