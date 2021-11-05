package c.b.a.b.l0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f3069a;

    public c(a aVar) {
        this.f3069a = aVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f3069a.f3087a.setEndIconVisible(false);
    }
}
