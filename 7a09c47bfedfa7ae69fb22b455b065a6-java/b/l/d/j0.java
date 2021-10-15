package b.l.d;

import androidx.fragment.app.Fragment;
import b.i.h.a;
import b.l.d.p0;
import b.l.d.z;

public class j0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p0.a f2050b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Fragment f2051c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f2052d;

    public j0(p0.a aVar, Fragment fragment, a aVar2) {
        this.f2050b = aVar;
        this.f2051c = fragment;
        this.f2052d = aVar2;
    }

    public void run() {
        ((z.d) this.f2050b).a(this.f2051c, this.f2052d);
    }
}
