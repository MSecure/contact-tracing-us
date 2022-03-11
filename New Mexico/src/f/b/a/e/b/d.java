package f.b.a.e.b;

import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import e.j.j.c0.d;
/* loaded from: classes.dex */
public class d implements e.j.j.c0.d {
    public final /* synthetic */ AppBarLayout a;
    public final /* synthetic */ boolean b;

    public d(AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout, boolean z) {
        this.a = appBarLayout;
        this.b = z;
    }

    @Override // e.j.j.c0.d
    public boolean a(View view, d.a aVar) {
        this.a.setExpanded(this.b);
        return true;
    }
}
