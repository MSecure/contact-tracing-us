package c.b.a.b.i0;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import c.b.a.b.m.a;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f3045b;

    public m(BaseTransientBottomBar baseTransientBottomBar) {
        this.f3045b = baseTransientBottomBar;
    }

    public void run() {
        BaseTransientBottomBar.i iVar = this.f3045b.f4516c;
        if (iVar != null) {
            iVar.setVisibility(0);
            if (this.f3045b.f4516c.getAnimationMode() == 1) {
                BaseTransientBottomBar baseTransientBottomBar = this.f3045b;
                if (baseTransientBottomBar != null) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setInterpolator(a.f3108a);
                    ofFloat.addUpdateListener(new c(baseTransientBottomBar));
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
                    ofFloat2.setInterpolator(a.f3111d);
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
            BaseTransientBottomBar baseTransientBottomBar2 = this.f3045b;
            int b2 = baseTransientBottomBar2.b();
            baseTransientBottomBar2.f4516c.setTranslationY((float) b2);
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(b2, 0);
            valueAnimator.setInterpolator(a.f3109b);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new e(baseTransientBottomBar2));
            valueAnimator.addUpdateListener(new f(baseTransientBottomBar2, b2));
            valueAnimator.start();
        }
    }
}
