package e.n.a;

import android.view.View;
import android.view.ViewGroup;
import e.i.e.a;
import e.n.a.c;

public class g implements a.AbstractC0034a {
    public final /* synthetic */ View a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ c.b c;

    public g(c cVar, View view, ViewGroup viewGroup, c.b bVar) {
        this.a = view;
        this.b = viewGroup;
        this.c = bVar;
    }

    @Override // e.i.e.a.AbstractC0034a
    public void a() {
        this.a.clearAnimation();
        this.b.endViewTransition(this.a);
        this.c.a();
    }
}
