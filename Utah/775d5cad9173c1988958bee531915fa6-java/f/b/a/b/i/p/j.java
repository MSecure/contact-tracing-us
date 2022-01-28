package f.b.a.b.i.p;

import android.content.Context;
import i.a.a;

public final class j implements Object<i> {
    public final a<Context> a;
    public final a<f.b.a.b.i.u.a> b;
    public final a<f.b.a.b.i.u.a> c;

    public j(a<Context> aVar, a<f.b.a.b.i.u.a> aVar2, a<f.b.a.b.i.u.a> aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    public Object get() {
        return new i(this.a.get(), this.b.get(), this.c.get());
    }
}
