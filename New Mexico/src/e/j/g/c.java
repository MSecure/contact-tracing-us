package e.j.g;

import android.os.Handler;
import e.j.g.j;
/* loaded from: classes.dex */
public class c {
    public final m a;
    public final Handler b;

    public c(m mVar, Handler handler) {
        this.a = mVar;
        this.b = handler;
    }

    public void a(j.a aVar) {
        int i2 = aVar.b;
        if (i2 == 0) {
            this.b.post(new a(this, this.a, aVar.a));
            return;
        }
        this.b.post(new b(this, this.a, i2));
    }
}
