package e.n.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import e.n.a.c;

public class f implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ c.b c;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            f fVar = f.this;
            fVar.a.endViewTransition(fVar.b);
            f.this.c.a();
        }
    }

    public f(c cVar, ViewGroup viewGroup, View view, c.b bVar) {
        this.a = viewGroup;
        this.b = view;
        this.c = bVar;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.post(new a());
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
