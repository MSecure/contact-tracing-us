package androidx.fragment.app;

import android.animation.Animator;
import android.view.animation.Animation;

public class FragmentAnim$AnimationOrAnimator {
    public final Animation animation;
    public final Animator animator;

    public FragmentAnim$AnimationOrAnimator(Animation animation2) {
        this.animation = animation2;
        this.animator = null;
        if (animation2 == null) {
            throw new IllegalStateException("Animation cannot be null");
        }
    }

    public FragmentAnim$AnimationOrAnimator(Animator animator2) {
        this.animation = null;
        this.animator = animator2;
    }
}
