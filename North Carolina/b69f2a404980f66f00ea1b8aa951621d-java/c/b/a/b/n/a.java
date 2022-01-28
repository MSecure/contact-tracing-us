package c.b.a.b.n;

import android.view.View;
import b.i.l.j;
import b.i.l.m;
import b.i.l.v;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Objects;

public class a implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f3133a;

    public a(AppBarLayout appBarLayout) {
        this.f3133a = appBarLayout;
    }

    @Override // b.i.l.j
    public v a(View view, v vVar) {
        AppBarLayout appBarLayout = this.f3133a;
        v vVar2 = null;
        if (appBarLayout != null) {
            if (m.l(appBarLayout)) {
                vVar2 = vVar;
            }
            if (!Objects.equals(appBarLayout.h, vVar2)) {
                appBarLayout.h = vVar2;
                appBarLayout.g();
                appBarLayout.requestLayout();
            }
            return vVar;
        }
        throw null;
    }
}
