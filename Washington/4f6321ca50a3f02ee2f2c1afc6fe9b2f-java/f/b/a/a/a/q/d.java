package f.b.a.a.a.q;

import androidx.core.widget.NestedScrollView;

public final /* synthetic */ class d implements NestedScrollView.b {
    public final /* synthetic */ y a;

    public /* synthetic */ d(y yVar) {
        this.a = yVar;
    }

    @Override // androidx.core.widget.NestedScrollView.b
    public final void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        y yVar = this.a;
        if (yVar.d0.getChildAt(0).getBottom() <= yVar.d0.getScrollY() + yVar.d0.getHeight()) {
            yVar.A0(true);
        } else {
            yVar.A0(false);
        }
    }
}
