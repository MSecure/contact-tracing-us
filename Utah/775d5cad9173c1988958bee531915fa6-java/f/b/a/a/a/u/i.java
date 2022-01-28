package f.b.a.a.a.u;

import android.view.View;
import f.b.a.a.a.d0.a5;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.s.w;
import java.util.Objects;

public final /* synthetic */ class i implements w.a {
    public final /* synthetic */ r a;
    public final /* synthetic */ View b;

    public /* synthetic */ i(r rVar, View view) {
        this.a = rVar;
        this.b = view;
    }

    @Override // f.b.a.a.a.s.w.a
    public final void a(Object obj, Object obj2) {
        r rVar = this.a;
        View view = this.b;
        Boolean bool = (Boolean) obj2;
        Objects.requireNonNull(rVar);
        rVar.M0(view, a5.a((h0) obj) ? false : !bool.booleanValue());
        rVar.c0.f2401e.setOnClickListener(new h(rVar));
    }
}
