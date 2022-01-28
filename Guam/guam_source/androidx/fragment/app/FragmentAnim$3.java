package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransition;

public final class FragmentAnim$3 extends AnimatorListenerAdapter {
    public final /* synthetic */ FragmentTransition.Callback val$callback;
    public final /* synthetic */ ViewGroup val$container;
    public final /* synthetic */ Fragment val$fragment;
    public final /* synthetic */ CancellationSignal val$signal;
    public final /* synthetic */ View val$viewToAnimate;

    public FragmentAnim$3(ViewGroup viewGroup, View view, Fragment fragment, FragmentTransition.Callback callback, CancellationSignal cancellationSignal) {
        this.val$container = viewGroup;
        this.val$viewToAnimate = view;
        this.val$fragment = fragment;
        this.val$callback = callback;
        this.val$signal = cancellationSignal;
    }

    public void onAnimationEnd(Animator animator) {
        Animator animator2;
        this.val$container.endViewTransition(this.val$viewToAnimate);
        Fragment.AnimationInfo animationInfo = this.val$fragment.mAnimationInfo;
        if (animationInfo == null) {
            animator2 = null;
        } else {
            animator2 = animationInfo.mAnimator;
        }
        this.val$fragment.setAnimator(null);
        if (animator2 != null && this.val$container.indexOfChild(this.val$viewToAnimate) < 0) {
            ((FragmentManager.AnonymousClass2) this.val$callback).onComplete(this.val$fragment, this.val$signal);
        }
    }
}
