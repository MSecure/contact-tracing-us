package f.b.a.d.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import e.x.a.a.b;
import java.util.List;
import java.util.Objects;

public class j extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    public j(l lVar) {
        this.a = lVar;
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        l lVar = this.a;
        List<b> list = lVar.f2834g;
        if (!(list == null || lVar.f2835h)) {
            for (b bVar : list) {
                Objects.requireNonNull(bVar);
            }
        }
    }
}
