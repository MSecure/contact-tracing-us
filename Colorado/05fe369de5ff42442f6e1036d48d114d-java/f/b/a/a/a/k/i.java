package f.b.a.a.a.k;

import android.view.View;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.i.x;
import f.b.a.a.a.s.a5;
import java.util.Objects;

public final /* synthetic */ class i implements x.a {
    public final /* synthetic */ r a;
    public final /* synthetic */ View b;

    public /* synthetic */ i(r rVar, View view) {
        this.a = rVar;
        this.b = view;
    }

    @Override // f.b.a.a.a.i.x.a
    public final void a(Object obj, Object obj2) {
        r rVar = this.a;
        View view = this.b;
        Boolean bool = (Boolean) obj2;
        Objects.requireNonNull(rVar);
        rVar.H0(view, a5.a((h0) obj) ? false : !bool.booleanValue());
        rVar.b0.f2206e.setOnClickListener(new h(rVar));
    }
}
