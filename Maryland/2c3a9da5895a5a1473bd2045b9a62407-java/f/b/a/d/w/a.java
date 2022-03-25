package f.b.a.d.w;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.util.Objects;

public class a implements Runnable {
    public final /* synthetic */ BaseTransientBottomBar b;

    public a(BaseTransientBottomBar baseTransientBottomBar) {
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
                ofFloat.setInterpolator(f.b.a.d.a.a.a);
                ofFloat.addUpdateListener(new d(baseTransientBottomBar));
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
                ofFloat2.setInterpolator(f.b.a.d.a.a.f2653d);
                ofFloat2.addUpdateListener(new e(baseTransientBottomBar));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofFloat, ofFloat2);
                animatorSet.setDuration(150L);
                animatorSet.addListener(new b(baseTransientBottomBar));
                animatorSet.start();
                return;
            }
            BaseTransientBottomBar baseTransientBottomBar2 = this.b;
            int c = baseTransientBottomBar2.c();
            baseTransientBottomBar2.c.setTranslationY((float) c);
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(c, 0);
            valueAnimator.setInterpolator(f.b.a.d.a.a.b);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new f(baseTransientBottomBar2));
            valueAnimator.addUpdateListener(new g(baseTransientBottomBar2, c));
            valueAnimator.start();
        }
    }
}
