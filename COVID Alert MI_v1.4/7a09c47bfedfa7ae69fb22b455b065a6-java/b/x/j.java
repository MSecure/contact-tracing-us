package b.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import b.e.a;

public class j extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f2699a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f2700b;

    public j(i iVar, a aVar) {
        this.f2700b = iVar;
        this.f2699a = aVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2699a.remove(animator);
        this.f2700b.x.remove(animator);
    }

    public void onAnimationStart(Animator animator) {
        this.f2700b.x.add(animator);
    }
}
