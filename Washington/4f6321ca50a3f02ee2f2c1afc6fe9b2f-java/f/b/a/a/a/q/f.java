package f.b.a.a.a.q;

import android.view.ViewTreeObserver;

public final /* synthetic */ class f implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ y b;

    public /* synthetic */ f(y yVar) {
        this.b = yVar;
    }

    public final void onGlobalLayout() {
        y yVar = this.b;
        if (yVar.d0.getMeasuredHeight() >= yVar.d0.getChildAt(0).getHeight()) {
            yVar.A0(true);
        }
    }
}
