package c.b.a.b.l0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f4363a;

    public b(a aVar) {
        this.f4363a = aVar;
    }

    public void onAnimationStart(Animator animator) {
        this.f4363a.f4384a.setEndIconVisible(true);
    }
}
