package c.b.a.b.n;

import android.view.View;
import b.i.l.j;
import b.i.l.m;
import b.i.l.v;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.Objects;

public class f implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CollapsingToolbarLayout f3145a;

    public f(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.f3145a = collapsingToolbarLayout;
    }

    @Override // b.i.l.j
    public v a(View view, v vVar) {
        CollapsingToolbarLayout collapsingToolbarLayout = this.f3145a;
        v vVar2 = null;
        if (collapsingToolbarLayout != null) {
            if (m.l(collapsingToolbarLayout)) {
                vVar2 = vVar;
            }
            if (!Objects.equals(collapsingToolbarLayout.x, vVar2)) {
                collapsingToolbarLayout.x = vVar2;
                collapsingToolbarLayout.requestLayout();
            }
            return vVar.a();
        }
        throw null;
    }
}
