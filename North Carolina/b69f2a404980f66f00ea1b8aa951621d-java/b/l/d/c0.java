package b.l.d;

import androidx.fragment.app.Fragment;
import b.i.h.a;
import b.l.d.g0;
import b.l.d.q;

public final class c0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g0.a f1256b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Fragment f1257c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f1258d;

    public c0(g0.a aVar, Fragment fragment, a aVar2) {
        this.f1256b = aVar;
        this.f1257c = fragment;
        this.f1258d = aVar2;
    }

    public void run() {
        ((q.b) this.f1256b).a(this.f1257c, this.f1258d);
    }
}
