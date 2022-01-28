package c.b.a.b.n;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.i.l.w.d;
import com.google.android.material.appbar.AppBarLayout;

public class c implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f4439a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f4440b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f4441c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f4442d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f4443e;

    public c(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
        this.f4443e = baseBehavior;
        this.f4439a = coordinatorLayout;
        this.f4440b = appBarLayout;
        this.f4441c = view;
        this.f4442d = i;
    }

    @Override // b.i.l.w.d
    public boolean a(View view, d.a aVar) {
        this.f4443e.L(this.f4439a, this.f4440b, this.f4441c, this.f4442d, new int[]{0, 0});
        return true;
    }
}
