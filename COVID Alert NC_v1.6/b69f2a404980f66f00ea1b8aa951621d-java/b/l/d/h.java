package b.l.d;

import android.animation.Animator;
import android.view.animation.Animation;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final Animation f1290a;

    /* renamed from: b  reason: collision with root package name */
    public final Animator f1291b;

    public h(Animator animator) {
        this.f1290a = null;
        this.f1291b = animator;
    }

    public h(Animation animation) {
        this.f1290a = animation;
        this.f1291b = null;
        if (animation == null) {
            throw new IllegalStateException("Animation cannot be null");
        }
    }
}
