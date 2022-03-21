package f.b.a.c.b.l.l;

import android.os.Handler;
import f.b.a.c.b.l.l.c;

public final class o implements c.a {
    public final /* synthetic */ e a;

    public o(e eVar) {
        this.a = eVar;
    }

    @Override // f.b.a.c.b.l.l.c.a
    public final void a(boolean z) {
        Handler handler = this.a.f2421j;
        handler.sendMessage(handler.obtainMessage(1, Boolean.valueOf(z)));
    }
}
