package f.b.a.d.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import e.x.a.a.b;
import java.util.List;

public class k extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    public k(l lVar) {
        this.a = lVar;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        boolean unused = k.super.setVisible(false, false);
        l lVar = this.a;
        List<b> list = lVar.f2834g;
        if (!(list == null || lVar.f2835h)) {
            for (b bVar : list) {
                bVar.a(lVar);
            }
        }
    }
}
