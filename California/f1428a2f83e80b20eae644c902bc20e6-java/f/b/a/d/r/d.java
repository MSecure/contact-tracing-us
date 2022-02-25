package f.b.a.d.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;

public class d extends AnimatorListenerAdapter {
    public final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        e eVar = this.a;
        if (eVar.m) {
            float[] fArr = eVar.b;
            if (fArr[0] == fArr[1]) {
                eVar.n.a(eVar.a);
                this.a.m = false;
                return;
            }
        }
        if (eVar.a.isVisible()) {
            e eVar2 = this.a;
            eVar2.l(0.0f);
            eVar2.m(0.0f);
            float f2 = eVar2.f2700i + 360.0f + 250.0f;
            float f3 = (float) 360;
            int i2 = (int) (f2 / f3);
            if (Math.signum(f2) * f3 < 0.0f && ((float) (i2 * 360)) != f2) {
                i2--;
            }
            eVar2.f2700i = f2 - ((float) (i2 * 360));
            eVar2.n();
            eVar2.a.invalidateSelf();
            int i3 = eVar2.i();
            eVar2.f2698g = i3;
            ObjectAnimator objectAnimator = eVar2.f2697f;
            int[] iArr = eVar2.a.f2711k;
            objectAnimator.setIntValues(iArr[i3], iArr[eVar2.i()]);
            eVar2.k(eVar2.a.f2711k[eVar2.f2698g]);
            this.a.g();
        }
    }
}
