package e.m.a;

import android.view.ViewGroup;
import android.view.animation.Animation;
import e.m.a.f0;
import e.m.a.v0;

public class t implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ l b;
    public final /* synthetic */ v0.a c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e.i.e.a f1688d;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (t.this.b.h() != null) {
                t.this.b.q0(null);
                t tVar = t.this;
                ((f0.d) tVar.c).a(tVar.b, tVar.f1688d);
            }
        }
    }

    public t(ViewGroup viewGroup, l lVar, v0.a aVar, e.i.e.a aVar2) {
        this.a = viewGroup;
        this.b = lVar;
        this.c = aVar;
        this.f1688d = aVar2;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.post(new a());
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
