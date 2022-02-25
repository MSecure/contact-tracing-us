package f.b.a.d.b;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import e.i.i.w.d;

public class c implements d {
    public final /* synthetic */ CoordinatorLayout a;
    public final /* synthetic */ AppBarLayout b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2557d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f2558e;

    public c(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
        this.f2558e = baseBehavior;
        this.a = coordinatorLayout;
        this.b = appBarLayout;
        this.c = view;
        this.f2557d = i2;
    }

    @Override // e.i.i.w.d
    public boolean a(View view, d.a aVar) {
        this.f2558e.L(this.a, this.b, this.c, this.f2557d, new int[]{0, 0});
        return true;
    }
}
