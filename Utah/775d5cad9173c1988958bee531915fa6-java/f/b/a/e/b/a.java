package f.b.a.e.b;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import com.google.android.material.appbar.AppBarLayout;
import f.b.a.e.v.g;
import java.util.Objects;

public class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ g a;
    public final /* synthetic */ AppBarLayout b;

    public a(AppBarLayout appBarLayout, g gVar) {
        this.b = appBarLayout;
        this.a = gVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.p(floatValue);
        Drawable drawable = this.b.p;
        if (drawable instanceof g) {
            ((g) drawable).p(floatValue);
        }
        Objects.requireNonNull(this.b);
        throw null;
    }
}
