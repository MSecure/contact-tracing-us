package b.l.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import b.i.h.a;
import b.l.d.p0;
import b.l.d.z;

public class p extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2091a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f2092b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Fragment f2093c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ p0.a f2094d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f2095e;

    public p(ViewGroup viewGroup, View view, Fragment fragment, p0.a aVar, a aVar2) {
        this.f2091a = viewGroup;
        this.f2092b = view;
        this.f2093c = fragment;
        this.f2094d = aVar;
        this.f2095e = aVar2;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2091a.endViewTransition(this.f2092b);
        Animator animator2 = this.f2093c.getAnimator();
        this.f2093c.setAnimator(null);
        if (animator2 != null && this.f2091a.indexOfChild(this.f2092b) < 0) {
            ((z.d) this.f2094d).a(this.f2093c, this.f2095e);
        }
    }
}
