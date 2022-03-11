package f.b.a.e.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import e.a0.a.a.b;
import java.util.List;
/* loaded from: classes.dex */
public class k extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    public k(l lVar) {
        this.a = lVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        boolean unused = k.super.setVisible(false, false);
        l lVar = this.a;
        List<b> list = lVar.f3045g;
        if (!(list == null || lVar.f3046h)) {
            for (b bVar : list) {
                bVar.a(lVar);
            }
        }
    }
}
