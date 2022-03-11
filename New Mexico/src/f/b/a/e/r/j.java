package f.b.a.e.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import e.a0.a.a.b;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class j extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    public j(l lVar) {
        this.a = lVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        l lVar = this.a;
        List<b> list = lVar.f3045g;
        if (!(list == null || lVar.f3046h)) {
            for (b bVar : list) {
                Objects.requireNonNull(bVar);
            }
        }
    }
}
