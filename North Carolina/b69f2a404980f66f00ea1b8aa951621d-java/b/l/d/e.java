package b.l.d;

import android.view.View;
import androidx.fragment.app.Fragment;
import b.i.h.a;

public final class e implements a.AbstractC0020a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Fragment f1263a;

    public e(Fragment fragment) {
        this.f1263a = fragment;
    }

    public void a() {
        if (this.f1263a.getAnimatingAway() != null) {
            View animatingAway = this.f1263a.getAnimatingAway();
            this.f1263a.setAnimatingAway(null);
            animatingAway.clearAnimation();
        }
        this.f1263a.setAnimator(null);
    }
}
