package c.b.a.b.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f4531a;

    public a(c cVar) {
        this.f4531a = cVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f4531a.b();
    }

    public void onAnimationStart(Animator animator) {
        this.f4531a.a();
    }
}
