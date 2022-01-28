package c.b.a.b.n;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.i.l.w.d;
import com.google.android.material.appbar.AppBarLayout;

public class d implements b.i.l.w.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f3138a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f3139b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f3140c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f3141d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f3142e;

    public d(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
        this.f3142e = baseBehavior;
        this.f3138a = coordinatorLayout;
        this.f3139b = appBarLayout;
        this.f3140c = view;
        this.f3141d = i;
    }

    @Override // b.i.l.w.d
    public boolean a(View view, d.a aVar) {
        this.f3142e.K(this.f3138a, this.f3139b, this.f3140c, this.f3141d, new int[]{0, 0});
        return true;
    }
}
