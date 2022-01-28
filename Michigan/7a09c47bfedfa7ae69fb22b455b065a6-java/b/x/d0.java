package b.x;

import android.view.View;
import android.view.ViewGroup;

public class d0 extends l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2671a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f2672b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f2673c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e0 f2674d;

    public d0(e0 e0Var, ViewGroup viewGroup, View view, View view2) {
        this.f2674d = e0Var;
        this.f2671a = viewGroup;
        this.f2672b = view;
        this.f2673c = view2;
    }

    @Override // b.x.l, b.x.i.d
    public void a(i iVar) {
        this.f2671a.getOverlay().remove(this.f2672b);
    }

    @Override // b.x.l, b.x.i.d
    public void b(i iVar) {
        if (this.f2672b.getParent() == null) {
            this.f2671a.getOverlay().add(this.f2672b);
        } else {
            this.f2674d.d();
        }
    }

    @Override // b.x.i.d
    public void e(i iVar) {
        this.f2673c.setTag(f.save_overlay_view, null);
        this.f2671a.getOverlay().remove(this.f2672b);
        iVar.y(this);
    }
}
