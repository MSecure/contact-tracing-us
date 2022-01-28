package b.l.d;

import androidx.fragment.app.Fragment;
import b.i.h.a;
import b.l.d.p0;
import b.l.d.z;

public class l0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p0.a f2061b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Fragment f2062c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f2063d;

    public l0(p0.a aVar, Fragment fragment, a aVar2) {
        this.f2061b = aVar;
        this.f2062c = fragment;
        this.f2063d = aVar2;
    }

    public void run() {
        ((z.d) this.f2061b).a(this.f2062c, this.f2063d);
    }
}
