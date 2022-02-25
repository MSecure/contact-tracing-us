package e.m.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import e.m.a.z0;

public class e implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ z0.d c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e.i.e.a f1585d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d f1586e;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            e eVar = e.this;
            eVar.a.endViewTransition(eVar.b);
            e eVar2 = e.this;
            eVar2.f1586e.j(eVar2.c, eVar2.f1585d);
        }
    }

    public e(d dVar, ViewGroup viewGroup, View view, z0.d dVar2, e.i.e.a aVar) {
        this.f1586e = dVar;
        this.a = viewGroup;
        this.b = view;
        this.c = dVar2;
        this.f1585d = aVar;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.post(new a());
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
