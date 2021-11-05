package c.b.a.b.n;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class j<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    public k f3154a;

    /* renamed from: b  reason: collision with root package name */
    public int f3155b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f3156c = 0;

    public j() {
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int B() {
        k kVar = this.f3154a;
        if (kVar != null) {
            return kVar.f3160d;
        }
        return 0;
    }

    public void C(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.q(v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i) {
        C(coordinatorLayout, v, i);
        if (this.f3154a == null) {
            this.f3154a = new k(v);
        }
        k kVar = this.f3154a;
        kVar.f3158b = kVar.f3157a.getTop();
        kVar.f3159c = kVar.f3157a.getLeft();
        this.f3154a.a();
        int i2 = this.f3155b;
        if (i2 != 0) {
            this.f3154a.b(i2);
            this.f3155b = 0;
        }
        int i3 = this.f3156c;
        if (i3 == 0) {
            return true;
        }
        k kVar2 = this.f3154a;
        if (kVar2.g && kVar2.f3161e != i3) {
            kVar2.f3161e = i3;
            kVar2.a();
        }
        this.f3156c = 0;
        return true;
    }
}
