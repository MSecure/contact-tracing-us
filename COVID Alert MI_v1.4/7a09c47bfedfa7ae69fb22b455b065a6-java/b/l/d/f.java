package b.l.d;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import b.l.d.c;

public class f implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2006a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f2007b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c.b f2008c;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            f fVar = f.this;
            fVar.f2006a.endViewTransition(fVar.f2007b);
            f.this.f2008c.a();
        }
    }

    public f(c cVar, ViewGroup viewGroup, View view, c.b bVar) {
        this.f2006a = viewGroup;
        this.f2007b = view;
        this.f2008c = bVar;
    }

    public void onAnimationEnd(Animation animation) {
        this.f2006a.post(new a());
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
