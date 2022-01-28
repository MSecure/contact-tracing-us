package c.b.a.a.d.m;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import b.x.t;
import c.b.a.a.d.m.g;

public final class g0 implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f0 f3123a;

    public g0(f0 f0Var, e0 e0Var) {
        this.f3123a = f0Var;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f3123a.f3110c) {
                g.a aVar = (g.a) message.obj;
                h0 h0Var = this.f3123a.f3110c.get(aVar);
                if (h0Var != null && h0Var.f3124a.isEmpty()) {
                    if (h0Var.f3126c) {
                        h0Var.f3130g.f3112e.removeMessages(1, h0Var.f3128e);
                        f0 f0Var = h0Var.f3130g;
                        f0Var.f3113f.a(f0Var.f3111d, h0Var);
                        h0Var.f3126c = false;
                        h0Var.f3125b = 2;
                    }
                    this.f3123a.f3110c.remove(aVar);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.f3123a.f3110c) {
                g.a aVar2 = (g.a) message.obj;
                h0 h0Var2 = this.f3123a.f3110c.get(aVar2);
                if (h0Var2 != null && h0Var2.f3125b == 3) {
                    String.valueOf(aVar2).length();
                    new Exception();
                    ComponentName componentName = h0Var2.f3129f;
                    if (componentName == null) {
                        componentName = aVar2.f3120c;
                    }
                    if (componentName == null) {
                        String str = aVar2.f3119b;
                        t.C(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    h0Var2.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
    }
}
