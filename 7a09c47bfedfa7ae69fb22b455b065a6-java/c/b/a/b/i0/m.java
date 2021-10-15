package c.b.a.b.i0;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import c.b.a.b.m.a;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f4338b;

    public m(BaseTransientBottomBar baseTransientBottomBar) {
        this.f4338b = baseTransientBottomBar;
    }

    public void run() {
        BaseTransientBottomBar.i iVar = this.f4338b.f6103c;
        if (iVar != null) {
            iVar.setVisibility(0);
            if (this.f4338b.f6103c.getAnimationMode() == 1) {
                BaseTransientBottomBar baseTransientBottomBar = this.f4338b;
                if (baseTransientBottomBar != null) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setInterpolator(a.f4410a);
                    ofFloat.addUpdateListener(new c(baseTransientBottomBar));
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
                    ofFloat2.setInterpolator(a.f4413d);
                    ofFloat2.addUpdateListener(new d(baseTransientBottomBar));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ofFloat, ofFloat2);
                    animatorSet.setDuration(150L);
                    animatorSet.addListener(new a(baseTransientBottomBar));
                    animatorSet.start();
                    return;
                }
                throw null;
            }
            BaseTransientBottomBar baseTransientBottomBar2 = this.f4338b;
            int b2 = baseTransientBottomBar2.b();
            baseTransientBottomBar2.f6103c.setTranslationY((float) b2);
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(b2, 0);
            valueAnimator.setInterpolator(a.f4411b);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new e(baseTransientBottomBar2));
            valueAnimator.addUpdateListener(new f(baseTransientBottomBar2, b2));
            valueAnimator.start();
        }
    }
}
