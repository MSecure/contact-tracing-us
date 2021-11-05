package b.l.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class r extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1344a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f1345b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Fragment f1346c;

    public r(q qVar, ViewGroup viewGroup, View view, Fragment fragment) {
        this.f1344a = viewGroup;
        this.f1345b = view;
        this.f1346c = fragment;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1344a.endViewTransition(this.f1345b);
        animator.removeListener(this);
        Fragment fragment = this.f1346c;
        View view = fragment.mView;
        if (view != null && fragment.mHidden) {
            view.setVisibility(8);
        }
    }
}
