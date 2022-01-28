package c.b.a.b.n;

import android.view.View;
import b.i.l.w.d;
import com.google.android.material.appbar.AppBarLayout;

public class d implements b.i.l.w.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f4444a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f4445b;

    public d(AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout, boolean z) {
        this.f4444a = appBarLayout;
        this.f4445b = z;
    }

    @Override // b.i.l.w.d
    public boolean a(View view, d.a aVar) {
        this.f4444a.setExpanded(this.f4445b);
        return true;
    }
}
