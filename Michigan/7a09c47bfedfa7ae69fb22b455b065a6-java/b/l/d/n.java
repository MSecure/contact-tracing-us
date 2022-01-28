package b.l.d;

import android.view.View;
import androidx.fragment.app.Fragment;
import b.i.h.a;

public class n implements a.AbstractC0030a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Fragment f2073a;

    public n(Fragment fragment) {
        this.f2073a = fragment;
    }

    @Override // b.i.h.a.AbstractC0030a
    public void a() {
        if (this.f2073a.getAnimatingAway() != null) {
            View animatingAway = this.f2073a.getAnimatingAway();
            this.f2073a.setAnimatingAway(null);
            animatingAway.clearAnimation();
        }
        this.f2073a.setAnimator(null);
    }
}
