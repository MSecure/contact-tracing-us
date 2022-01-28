package b.l.d;

import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import b.l.d.g0;
import b.l.d.q;

public final class f implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1268a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f1269b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g0.a f1270c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b.i.h.a f1271d;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (f.this.f1269b.getAnimatingAway() != null) {
                f.this.f1269b.setAnimatingAway(null);
                f fVar = f.this;
                ((q.b) fVar.f1270c).a(fVar.f1269b, fVar.f1271d);
            }
        }
    }

    public f(ViewGroup viewGroup, Fragment fragment, g0.a aVar, b.i.h.a aVar2) {
        this.f1268a = viewGroup;
        this.f1269b = fragment;
        this.f1270c = aVar;
        this.f1271d = aVar2;
    }

    public void onAnimationEnd(Animation animation) {
        this.f1268a.post(new a());
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
