package b.l.d;

import androidx.fragment.app.Fragment;
import b.i.h.a;
import b.l.d.g0;
import b.l.d.q;

public final class a0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g0.a f1245b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Fragment f1246c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f1247d;

    public a0(g0.a aVar, Fragment fragment, a aVar2) {
        this.f1245b = aVar;
        this.f1246c = fragment;
        this.f1247d = aVar2;
    }

    public void run() {
        ((q.b) this.f1245b).a(this.f1246c, this.f1247d);
    }
}
