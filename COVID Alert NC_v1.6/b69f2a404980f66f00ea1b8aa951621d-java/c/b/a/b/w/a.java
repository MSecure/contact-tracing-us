package c.b.a.b.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f3210a;

    public a(c cVar) {
        this.f3210a = cVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f3210a.b();
    }

    public void onAnimationStart(Animator animator) {
        this.f3210a.a();
    }
}
