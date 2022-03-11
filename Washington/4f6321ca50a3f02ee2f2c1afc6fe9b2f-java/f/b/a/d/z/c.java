package f.b.a.d.z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ a a;

    public c(a aVar) {
        this.a = aVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.a.setEndIconVisible(false);
    }
}
