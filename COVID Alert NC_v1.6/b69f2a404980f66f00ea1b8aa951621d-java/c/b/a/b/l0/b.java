package c.b.a.b.l0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f3068a;

    public b(a aVar) {
        this.f3068a = aVar;
    }

    public void onAnimationStart(Animator animator) {
        this.f3068a.f3087a.setEndIconVisible(true);
    }
}
