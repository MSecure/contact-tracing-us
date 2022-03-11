package e.o.a;

import android.view.ViewGroup;
import android.view.animation.Animation;
import e.o.a.e0;
import e.o.a.t0;
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ m b;
    public final /* synthetic */ t0.a c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e.j.f.a f1868d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t.this.b.h() != null) {
                t.this.b.x0(null);
                t tVar = t.this;
                ((e0.d) tVar.c).a(tVar.b, tVar.f1868d);
            }
        }
    }

    public t(ViewGroup viewGroup, m mVar, t0.a aVar, e.j.f.a aVar2) {
        this.a = viewGroup;
        this.b = mVar;
        this.c = aVar;
        this.f1868d = aVar2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.a.post(new a());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
