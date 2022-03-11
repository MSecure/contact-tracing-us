package f.b.a.a.a.s;

import androidx.core.widget.NestedScrollView;

public final /* synthetic */ class c implements NestedScrollView.b {
    public final /* synthetic */ y a;

    public /* synthetic */ c(y yVar) {
        this.a = yVar;
    }

    @Override // androidx.core.widget.NestedScrollView.b
    public final void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        y yVar = this.a;
        if (yVar.f0.getChildAt(0).getBottom() <= yVar.f0.getScrollY() + yVar.f0.getHeight()) {
            yVar.A0(true);
        } else {
            yVar.A0(false);
        }
    }
}
