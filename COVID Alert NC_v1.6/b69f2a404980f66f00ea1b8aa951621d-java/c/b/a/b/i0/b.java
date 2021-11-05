package c.b.a.b.i0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3029a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f3030b;

    public b(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.f3030b = baseTransientBottomBar;
        this.f3029a = i;
    }

    public void onAnimationEnd(Animator animator) {
        this.f3030b.c(this.f3029a);
    }
}
