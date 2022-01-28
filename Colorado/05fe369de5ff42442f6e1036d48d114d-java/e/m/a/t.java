package e.m.a;

import android.view.ViewGroup;
import android.view.animation.Animation;
import e.m.a.e0;
import e.m.a.t0;

public class t implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ m b;
    public final /* synthetic */ t0.a c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e.i.e.a f1510d;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (t.this.b.g() != null) {
                t.this.b.r0(null);
                t tVar = t.this;
                ((e0.d) tVar.c).a(tVar.b, tVar.f1510d);
            }
        }
    }

    public t(ViewGroup viewGroup, m mVar, t0.a aVar, e.i.e.a aVar2) {
        this.a = viewGroup;
        this.b = mVar;
        this.c = aVar;
        this.f1510d = aVar2;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.post(new a());
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
