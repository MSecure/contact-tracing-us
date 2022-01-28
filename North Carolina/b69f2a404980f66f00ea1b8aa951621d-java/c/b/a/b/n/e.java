package c.b.a.b.n;

import android.view.View;
import b.i.l.w.d;
import com.google.android.material.appbar.AppBarLayout;

public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f3143a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f3144b;

    public e(AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout, boolean z) {
        this.f3143a = appBarLayout;
        this.f3144b = z;
    }

    @Override // b.i.l.w.d
    public boolean a(View view, d.a aVar) {
        this.f3143a.setExpanded(this.f3144b);
        return true;
    }
}
