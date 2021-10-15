package c.b.a.b.l0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f4364a;

    public c(a aVar) {
        this.f4364a = aVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f4364a.f4384a.setEndIconVisible(false);
    }
}
