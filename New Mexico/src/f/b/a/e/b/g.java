package f.b.a.e.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
public class g<V extends View> extends CoordinatorLayout.c<V> {
    public h a;
    public int b = 0;

    public g() {
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int B() {
        h hVar = this.a;
        if (hVar != null) {
            return hVar.f2890d;
        }
        return 0;
    }

    public void C(CoordinatorLayout coordinatorLayout, V v, int i2) {
        coordinatorLayout.r(v, i2);
    }

    public boolean D(int i2) {
        h hVar = this.a;
        if (hVar == null) {
            this.b = i2;
            return false;
        } else if (hVar.f2890d == i2) {
            return false;
        } else {
            hVar.f2890d = i2;
            hVar.a();
            return true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i2) {
        C(coordinatorLayout, v, i2);
        if (this.a == null) {
            this.a = new h(v);
        }
        h hVar = this.a;
        hVar.b = hVar.a.getTop();
        hVar.c = hVar.a.getLeft();
        this.a.a();
        int i3 = this.b;
        if (i3 == 0) {
            return true;
        }
        h hVar2 = this.a;
        if (hVar2.f2890d != i3) {
            hVar2.f2890d = i3;
            hVar2.a();
        }
        this.b = 0;
        return true;
    }
}
