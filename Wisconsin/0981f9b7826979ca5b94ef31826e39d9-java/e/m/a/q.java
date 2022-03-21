package e.m.a;

import android.view.ViewGroup;
import android.view.animation.Animation;
import e.m.a.c0;
import e.m.a.s0;

public class q implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ l b;
    public final /* synthetic */ s0.a c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e.i.e.a f1661d;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (q.this.b.i() != null) {
                q.this.b.q0(null);
                q qVar = q.this;
                ((c0.d) qVar.c).a(qVar.b, qVar.f1661d);
            }
        }
    }

    public q(ViewGroup viewGroup, l lVar, s0.a aVar, e.i.e.a aVar2) {
        this.a = viewGroup;
        this.b = lVar;
        this.c = aVar;
        this.f1661d = aVar2;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.post(new a());
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
