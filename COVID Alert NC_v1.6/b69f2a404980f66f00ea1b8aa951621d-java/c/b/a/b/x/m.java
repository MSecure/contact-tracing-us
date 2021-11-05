package c.b.a.b.x;

import android.view.View;

public class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v f3266b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f3267c;

    public m(g gVar, v vVar) {
        this.f3267c = gVar;
        this.f3266b = vVar;
    }

    public void onClick(View view) {
        int k1 = this.f3267c.e().k1() - 1;
        if (k1 >= 0) {
            this.f3267c.g(this.f3266b.a(k1));
        }
    }
}
