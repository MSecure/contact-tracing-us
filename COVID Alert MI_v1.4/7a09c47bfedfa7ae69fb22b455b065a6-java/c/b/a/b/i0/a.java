package c.b.a.b.i0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f4321a;

    public a(BaseTransientBottomBar baseTransientBottomBar) {
        this.f4321a = baseTransientBottomBar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f4321a.d();
    }
}
