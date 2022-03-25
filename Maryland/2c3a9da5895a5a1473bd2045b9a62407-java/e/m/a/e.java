package e.m.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import e.m.a.c1;

public class e implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ c1.d c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e.i.e.a f1600d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d f1601e;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            e eVar = e.this;
            eVar.a.endViewTransition(eVar.b);
            e eVar2 = e.this;
            eVar2.f1601e.j(eVar2.c, eVar2.f1600d);
        }
    }

    public e(d dVar, ViewGroup viewGroup, View view, c1.d dVar2, e.i.e.a aVar) {
        this.f1601e = dVar;
        this.a = viewGroup;
        this.b = view;
        this.c = dVar2;
        this.f1600d = aVar;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.post(new a());
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
