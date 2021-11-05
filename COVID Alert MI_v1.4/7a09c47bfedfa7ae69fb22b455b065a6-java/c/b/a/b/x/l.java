package c.b.a.b.x;

import android.view.View;

public class l implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v f4593b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f4594c;

    public l(g gVar, v vVar) {
        this.f4594c = gVar;
        this.f4593b = vVar;
    }

    public void onClick(View view) {
        int i1 = this.f4594c.e().i1() + 1;
        if (i1 < this.f4594c.j.getAdapter().getItemCount()) {
            this.f4594c.g(this.f4593b.a(i1));
        }
    }
}
