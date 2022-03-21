package e.m.a;

import android.animation.Animator;
import android.view.animation.Animation;

public class s {
    public final Animation a;
    public final Animator b;

    public s(Animator animator) {
        this.a = null;
        this.b = animator;
    }

    public s(Animation animation) {
        this.a = animation;
        this.b = null;
        if (animation == null) {
            throw new IllegalStateException("Animation cannot be null");
        }
    }
}
