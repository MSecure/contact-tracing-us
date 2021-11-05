package c.b.a.b.n;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.view.View;
import c.b.a.b.b;
import c.b.a.b.g;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f3162a = {16843848};

    public static void a(View view, float f) {
        int integer = view.getResources().getInteger(g.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = (long) integer;
        stateListAnimator.addState(new int[]{16842766, b.state_liftable, -b.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, "elevation", f).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
