package e.n.a;

import android.animation.Animator;
import android.view.animation.Animation;

public class v {
    public final Animation a;
    public final Animator b;

    public v(Animator animator) {
        this.a = null;
        this.b = animator;
    }

    public v(Animation animation) {
        this.a = animation;
        this.b = null;
    }
}
