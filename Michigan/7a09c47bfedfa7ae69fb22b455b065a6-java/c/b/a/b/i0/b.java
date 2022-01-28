package c.b.a.b.i0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4322a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f4323b;

    public b(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.f4323b = baseTransientBottomBar;
        this.f4322a = i;
    }

    public void onAnimationEnd(Animator animator) {
        this.f4323b.c(this.f4322a);
    }
}
