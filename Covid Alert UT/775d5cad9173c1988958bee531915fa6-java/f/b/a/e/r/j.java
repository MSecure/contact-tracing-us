package f.b.a.e.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import e.z.a.a.b;
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
        List<b> list = lVar.f3003g;
        if (!(list == null || lVar.f3004h)) {
            for (b bVar : list) {
                Objects.requireNonNull(bVar);
            }
        }
    }
}
