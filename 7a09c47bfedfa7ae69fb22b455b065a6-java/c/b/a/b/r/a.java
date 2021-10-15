package c.b.a.b.r;

import android.animation.ValueAnimator;
import c.b.a.b.h0.g;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f4503a;

    public a(BottomSheetBehavior bottomSheetBehavior) {
        this.f4503a = bottomSheetBehavior;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        g gVar = this.f4503a.i;
        if (gVar != null) {
            gVar.s(floatValue);
        }
    }
}
