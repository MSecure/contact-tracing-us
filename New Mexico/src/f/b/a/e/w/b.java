package f.b.a.e.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;
/* loaded from: classes.dex */
public class b extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ BaseTransientBottomBar b;

    public b(BaseTransientBottomBar baseTransientBottomBar, int i2) {
        this.b = baseTransientBottomBar;
        this.a = i2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.b.d(this.a);
    }
}
