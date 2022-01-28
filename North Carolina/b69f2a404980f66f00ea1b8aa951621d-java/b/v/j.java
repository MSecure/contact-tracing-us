package b.v;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import b.e.a;

public class j extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f1810a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f1811b;

    public j(i iVar, a aVar) {
        this.f1811b = iVar;
        this.f1810a = aVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1810a.remove(animator);
        this.f1811b.x.remove(animator);
    }

    public void onAnimationStart(Animator animator) {
        this.f1811b.x.add(animator);
    }
}
