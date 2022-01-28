package b.l.d;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.e.a;

public class n0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f2074b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Fragment f2075c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f2076d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f2077e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f2078f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ r0 f2079g;
    public final /* synthetic */ Rect h;

    public n0(Fragment fragment, Fragment fragment2, boolean z, a aVar, View view, r0 r0Var, Rect rect) {
        this.f2074b = fragment;
        this.f2075c = fragment2;
        this.f2076d = z;
        this.f2077e = aVar;
        this.f2078f = view;
        this.f2079g = r0Var;
        this.h = rect;
    }

    public void run() {
        p0.c(this.f2074b, this.f2075c, this.f2076d, this.f2077e, false);
        View view = this.f2078f;
        if (view != null) {
            this.f2079g.j(view, this.h);
        }
    }
}
