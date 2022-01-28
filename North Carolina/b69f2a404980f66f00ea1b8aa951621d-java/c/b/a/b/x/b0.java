package c.b.a.b.x;

import android.view.View;
import c.b.a.b.x.g;

public class b0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3233b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c0 f3234c;

    public b0(c0 c0Var, int i) {
        this.f3234c = c0Var;
        this.f3233b = i;
    }

    public void onClick(View view) {
        s q = s.q(this.f3233b, this.f3234c.f3240a.f.f3281d);
        a aVar = this.f3234c.f3240a.f3249e;
        if (q.compareTo(aVar.f3218b) < 0) {
            q = aVar.f3218b;
        } else if (q.compareTo(aVar.f3219c) > 0) {
            q = aVar.f3219c;
        }
        this.f3234c.f3240a.g(q);
        this.f3234c.f3240a.h(g.e.DAY);
    }
}
