package c.b.a.b.x;

import android.view.View;
import c.b.a.b.x.g;

public class b0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4558b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c0 f4559c;

    public b0(c0 c0Var, int i) {
        this.f4559c = c0Var;
        this.f4558b = i;
    }

    public void onClick(View view) {
        s t = s.t(this.f4558b, this.f4559c.f4567a.f4577f.f4612d);
        a aVar = this.f4559c.f4567a.f4576e;
        if (t.compareTo(aVar.f4539b) < 0) {
            t = aVar.f4539b;
        } else if (t.compareTo(aVar.f4540c) > 0) {
            t = aVar.f4540c;
        }
        this.f4559c.f4567a.g(t);
        this.f4559c.f4567a.h(g.e.DAY);
    }
}
