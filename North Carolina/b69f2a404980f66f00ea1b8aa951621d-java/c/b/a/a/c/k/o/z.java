package c.b.a.a.c.k.o;

import android.os.Handler;
import c.b.a.a.c.k.o.c;

public final class z implements c.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f2412a;

    public z(g gVar) {
        this.f2412a = gVar;
    }

    @Override // c.b.a.a.c.k.o.c.a
    public final void a(boolean z) {
        Handler handler = this.f2412a.m;
        handler.sendMessage(handler.obtainMessage(1, Boolean.valueOf(z)));
    }
}
