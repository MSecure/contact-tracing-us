package b.l.d;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.e.a;

public final class e0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f1264b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Fragment f1265c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f1266d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1267e;
    public final /* synthetic */ View f;
    public final /* synthetic */ l0 g;
    public final /* synthetic */ Rect h;

    public e0(Fragment fragment, Fragment fragment2, boolean z, a aVar, View view, l0 l0Var, Rect rect) {
        this.f1264b = fragment;
        this.f1265c = fragment2;
        this.f1266d = z;
        this.f1267e = aVar;
        this.f = view;
        this.g = l0Var;
        this.h = rect;
    }

    public void run() {
        g0.c(this.f1264b, this.f1265c, this.f1266d, this.f1267e, false);
        View view = this.f;
        if (view != null) {
            this.g.j(view, this.h);
        }
    }
}
