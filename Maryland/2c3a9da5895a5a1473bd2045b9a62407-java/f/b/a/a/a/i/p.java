package f.b.a.a.a.i;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import e.z.a;

public final class p implements a {
    public final ConstraintLayout a;
    public final RelativeLayout b;
    public final Button c;

    /* renamed from: d  reason: collision with root package name */
    public final NestedScrollView f2125d;

    public p(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, Button button, NestedScrollView nestedScrollView) {
        this.a = constraintLayout;
        this.b = relativeLayout;
        this.c = button;
        this.f2125d = nestedScrollView;
    }

    @Override // e.z.a
    public View a() {
        return this.a;
    }
}
