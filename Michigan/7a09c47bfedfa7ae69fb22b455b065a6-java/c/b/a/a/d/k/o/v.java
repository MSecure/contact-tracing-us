package c.b.a.a.d.k.o;

import android.os.Handler;
import c.b.a.a.d.k.o.c;

public final class v implements c.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f3054a;

    public v(g gVar) {
        this.f3054a = gVar;
    }

    @Override // c.b.a.a.d.k.o.c.a
    public final void a(boolean z) {
        Handler handler = this.f3054a.m;
        handler.sendMessage(handler.obtainMessage(1, Boolean.valueOf(z)));
    }
}
