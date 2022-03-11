package f.b.a.d.b;

import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import e.i.i.w.d;

public class d implements e.i.i.w.d {
    public final /* synthetic */ AppBarLayout a;
    public final /* synthetic */ boolean b;

    public d(AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout, boolean z) {
        this.a = appBarLayout;
        this.b = z;
    }

    @Override // e.i.i.w.d
    public boolean a(View view, d.a aVar) {
        this.a.setExpanded(this.b);
        return true;
    }
}
