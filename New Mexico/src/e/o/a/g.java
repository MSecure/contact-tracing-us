package e.o.a;

import android.view.View;
import android.view.ViewGroup;
import e.j.f.a;
import e.o.a.c;
/* loaded from: classes.dex */
public class g implements a.AbstractC0038a {
    public final /* synthetic */ View a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ c.b c;

    public g(c cVar, View view, ViewGroup viewGroup, c.b bVar) {
        this.a = view;
        this.b = viewGroup;
        this.c = bVar;
    }

    @Override // e.j.f.a.AbstractC0038a
    public void a() {
        this.a.clearAnimation();
        this.b.endViewTransition(this.a);
        this.c.a();
    }
}
