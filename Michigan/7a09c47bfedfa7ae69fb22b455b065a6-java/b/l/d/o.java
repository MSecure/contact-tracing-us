package b.l.d;

import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import b.l.d.p0;
import b.l.d.z;

public class o implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2080a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f2081b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p0.a f2082c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b.i.h.a f2083d;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (o.this.f2081b.getAnimatingAway() != null) {
                o.this.f2081b.setAnimatingAway(null);
                o oVar = o.this;
                ((z.d) oVar.f2082c).a(oVar.f2081b, oVar.f2083d);
            }
        }
    }

    public o(ViewGroup viewGroup, Fragment fragment, p0.a aVar, b.i.h.a aVar2) {
        this.f2080a = viewGroup;
        this.f2081b = fragment;
        this.f2082c = aVar;
        this.f2083d = aVar2;
    }

    public void onAnimationEnd(Animation animation) {
        this.f2080a.post(new a());
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
