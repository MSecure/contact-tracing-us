package c.b.a.b.x;

import android.view.View;

public class l implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v f3264b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f3265c;

    public l(g gVar, v vVar) {
        this.f3265c = gVar;
        this.f3264b = vVar;
    }

    public void onClick(View view) {
        int i1 = this.f3265c.e().i1() + 1;
        if (i1 < this.f3265c.j.getAdapter().getItemCount()) {
            this.f3265c.g(this.f3264b.a(i1));
        }
    }
}
