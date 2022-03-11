package f.b.a.d.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import e.x.a.a.b;
import java.util.List;
import java.util.Objects;

public class g extends AnimatorListenerAdapter {
    public final /* synthetic */ i a;

    public g(i iVar) {
        this.a = iVar;
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        i iVar = this.a;
        b bVar = iVar.f2716h;
        List<b> list = iVar.f2715g;
        if (list != null) {
            for (b bVar2 : list) {
                Objects.requireNonNull(bVar2);
            }
        }
    }
}
