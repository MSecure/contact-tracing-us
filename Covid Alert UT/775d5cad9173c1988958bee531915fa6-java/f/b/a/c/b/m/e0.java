package f.b.a.c.b.m;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import f.b.a.c.b.m.g;
import java.util.Objects;

public final class e0 implements Handler.Callback {
    public final /* synthetic */ d0 a;

    public e0(d0 d0Var, c0 c0Var) {
        this.a = d0Var;
    }

    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            synchronized (this.a.c) {
                g.a aVar = (g.a) message.obj;
                f0 f0Var = this.a.c.get(aVar);
                if (f0Var != null && f0Var.a.isEmpty()) {
                    if (f0Var.c) {
                        f0Var.f2705g.f2689e.removeMessages(1, f0Var.f2703e);
                        d0 d0Var = f0Var.f2705g;
                        d0Var.f2690f.a(d0Var.f2688d, f0Var);
                        f0Var.c = false;
                        f0Var.b = 2;
                    }
                    this.a.c.remove(aVar);
                }
            }
            return true;
        } else if (i2 != 1) {
            return false;
        } else {
            synchronized (this.a.c) {
                g.a aVar2 = (g.a) message.obj;
                f0 f0Var2 = this.a.c.get(aVar2);
                if (f0Var2 != null && f0Var2.b == 3) {
                    String.valueOf(aVar2).length();
                    new Exception();
                    ComponentName componentName = f0Var2.f2704f;
                    if (componentName == null) {
                        Objects.requireNonNull(aVar2);
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = aVar2.b;
                        Objects.requireNonNull(str, "null reference");
                        componentName = new ComponentName(str, "unknown");
                    }
                    f0Var2.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
    }
}
