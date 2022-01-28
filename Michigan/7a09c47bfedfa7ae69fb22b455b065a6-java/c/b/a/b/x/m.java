package c.b.a.b.x;

import android.view.View;

public class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v f4595b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f4596c;

    public m(g gVar, v vVar) {
        this.f4596c = gVar;
        this.f4595b = vVar;
    }

    public void onClick(View view) {
        int k1 = this.f4596c.e().k1() - 1;
        if (k1 >= 0) {
            this.f4596c.g(this.f4595b.a(k1));
        }
    }
}
