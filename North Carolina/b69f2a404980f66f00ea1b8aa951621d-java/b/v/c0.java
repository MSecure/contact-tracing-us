package b.v;

import android.view.View;
import android.view.ViewGroup;

public class c0 extends l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1779a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f1780b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f1781c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ d0 f1782d;

    public c0(d0 d0Var, ViewGroup viewGroup, View view, View view2) {
        this.f1782d = d0Var;
        this.f1779a = viewGroup;
        this.f1780b = view;
        this.f1781c = view2;
    }

    @Override // b.v.l, b.v.i.d
    public void a(i iVar) {
        this.f1779a.getOverlay().remove(this.f1780b);
    }

    @Override // b.v.l, b.v.i.d
    public void b(i iVar) {
        if (this.f1780b.getParent() == null) {
            this.f1779a.getOverlay().add(this.f1780b);
        } else {
            this.f1782d.d();
        }
    }

    @Override // b.v.i.d
    public void e(i iVar) {
        this.f1781c.setTag(f.save_overlay_view, null);
        this.f1779a.getOverlay().remove(this.f1780b);
        iVar.w(this);
    }
}
