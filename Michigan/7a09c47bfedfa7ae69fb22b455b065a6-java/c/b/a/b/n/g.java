package c.b.a.b.n;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class g<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    public h f4457a;

    /* renamed from: b  reason: collision with root package name */
    public int f4458b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f4459c = 0;

    public g() {
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int B() {
        h hVar = this.f4457a;
        if (hVar != null) {
            return hVar.f4463d;
        }
        return 0;
    }

    public void C(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.q(v, i);
    }

    public boolean D(int i) {
        h hVar = this.f4457a;
        if (hVar == null) {
            this.f4458b = i;
            return false;
        } else if (!hVar.f4465f || hVar.f4463d == i) {
            return false;
        } else {
            hVar.f4463d = i;
            hVar.a();
            return true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i) {
        C(coordinatorLayout, v, i);
        if (this.f4457a == null) {
            this.f4457a = new h(v);
        }
        h hVar = this.f4457a;
        hVar.f4461b = hVar.f4460a.getTop();
        hVar.f4462c = hVar.f4460a.getLeft();
        this.f4457a.a();
        int i2 = this.f4458b;
        if (i2 != 0) {
            h hVar2 = this.f4457a;
            if (hVar2.f4465f && hVar2.f4463d != i2) {
                hVar2.f4463d = i2;
                hVar2.a();
            }
            this.f4458b = 0;
        }
        int i3 = this.f4459c;
        if (i3 == 0) {
            return true;
        }
        h hVar3 = this.f4457a;
        if (hVar3.f4466g && hVar3.f4464e != i3) {
            hVar3.f4464e = i3;
            hVar3.a();
        }
        this.f4459c = 0;
        return true;
    }
}
