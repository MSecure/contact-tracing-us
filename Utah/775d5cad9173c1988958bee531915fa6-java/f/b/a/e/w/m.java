package f.b.a.e.w;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import f.b.a.e.a.a;
import java.util.Objects;

public class m implements Runnable {
    public final /* synthetic */ BaseTransientBottomBar b;

    public m(BaseTransientBottomBar baseTransientBottomBar) {
        this.b = baseTransientBottomBar;
    }

    public void run() {
        BaseTransientBottomBar.i iVar = this.b.c;
        if (iVar != null) {
            if (iVar.getParent() != null) {
                this.b.c.setVisibility(0);
            }
            if (this.b.c.getAnimationMode() == 1) {
                BaseTransientBottomBar baseTransientBottomBar = this.b;
                Objects.requireNonNull(baseTransientBottomBar);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setInterpolator(a.a);
                ofFloat.addUpdateListener(new c(baseTransientBottomBar));
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
                ofFloat2.setInterpolator(a.f2831d);
                ofFloat2.addUpdateListener(new d(baseTransientBottomBar));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofFloat, ofFloat2);
                animatorSet.setDuration(150L);
                animatorSet.addListener(new a(baseTransientBottomBar));
                animatorSet.start();
                return;
            }
            BaseTransientBottomBar baseTransientBottomBar2 = this.b;
            int c = baseTransientBottomBar2.c();
            baseTransientBottomBar2.c.setTranslationY((float) c);
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(c, 0);
            valueAnimator.setInterpolator(a.b);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new e(baseTransientBottomBar2));
            valueAnimator.addUpdateListener(new f(baseTransientBottomBar2, c));
            valueAnimator.start();
        }
    }
}
