package b.l.d;

import android.view.View;
import android.view.ViewGroup;
import b.i.h.a;
import b.l.d.c;

public class g implements a.AbstractC0030a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f2016a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2017b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c.b f2018c;

    public g(c cVar, View view, ViewGroup viewGroup, c.b bVar) {
        this.f2016a = view;
        this.f2017b = viewGroup;
        this.f2018c = bVar;
    }

    @Override // b.i.h.a.AbstractC0030a
    public void a() {
        this.f2016a.clearAnimation();
        this.f2017b.endViewTransition(this.f2016a);
        this.f2018c.a();
    }
}
