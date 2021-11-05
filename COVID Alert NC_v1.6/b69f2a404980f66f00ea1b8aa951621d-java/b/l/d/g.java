package b.l.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import b.i.h.a;
import b.l.d.g0;
import b.l.d.q;

public final class g extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1277a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f1278b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Fragment f1279c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g0.a f1280d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1281e;

    public g(ViewGroup viewGroup, View view, Fragment fragment, g0.a aVar, a aVar2) {
        this.f1277a = viewGroup;
        this.f1278b = view;
        this.f1279c = fragment;
        this.f1280d = aVar;
        this.f1281e = aVar2;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1277a.endViewTransition(this.f1278b);
        Animator animator2 = this.f1279c.getAnimator();
        this.f1279c.setAnimator(null);
        if (animator2 != null && this.f1277a.indexOfChild(this.f1278b) < 0) {
            ((q.b) this.f1280d).a(this.f1279c, this.f1281e);
        }
    }
}
