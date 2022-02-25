package f.b.a.d.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import e.x.a.a.b;
import java.util.List;

public class h extends AnimatorListenerAdapter {
    public final /* synthetic */ i a;

    public h(i iVar) {
        this.a = iVar;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        boolean unused = h.super.setVisible(false, false);
        i iVar = this.a;
        b bVar = iVar.f2708h;
        if (bVar != null) {
            bVar.a(iVar);
        }
        List<b> list = iVar.f2707g;
        if (list != null) {
            for (b bVar2 : list) {
                bVar2.a(iVar);
            }
        }
    }
}
