package androidx.fragment.app;

import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransition;

public final class FragmentAnim$2 implements Animation.AnimationListener {
    public final /* synthetic */ FragmentTransition.Callback val$callback;
    public final /* synthetic */ ViewGroup val$container;
    public final /* synthetic */ Fragment val$fragment;
    public final /* synthetic */ CancellationSignal val$signal;

    public FragmentAnim$2(ViewGroup viewGroup, Fragment fragment, FragmentTransition.Callback callback, CancellationSignal cancellationSignal) {
        this.val$container = viewGroup;
        this.val$fragment = fragment;
        this.val$callback = callback;
        this.val$signal = cancellationSignal;
    }

    public void onAnimationEnd(Animation animation) {
        this.val$container.post(new Runnable() {
            /* class androidx.fragment.app.FragmentAnim$2.AnonymousClass1 */

            public void run() {
                if (FragmentAnim$2.this.val$fragment.getAnimatingAway() != null) {
                    FragmentAnim$2.this.val$fragment.setAnimatingAway(null);
                    FragmentAnim$2 fragmentAnim$2 = FragmentAnim$2.this;
                    ((FragmentManager.AnonymousClass2) fragmentAnim$2.val$callback).onComplete(fragmentAnim$2.val$fragment, fragmentAnim$2.val$signal);
                }
            }
        });
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
