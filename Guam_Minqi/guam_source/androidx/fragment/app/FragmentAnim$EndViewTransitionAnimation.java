package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;

public class FragmentAnim$EndViewTransitionAnimation extends AnimationSet implements Runnable {
    public boolean mAnimating = true;
    public final View mChild;
    public boolean mEnded;
    public final ViewGroup mParent;
    public boolean mTransitionEnded;

    public FragmentAnim$EndViewTransitionAnimation(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.mParent = viewGroup;
        this.mChild = view;
        addAnimation(animation);
        this.mParent.post(this);
    }

    public boolean getTransformation(long j, Transformation transformation) {
        this.mAnimating = true;
        if (this.mEnded) {
            return !this.mTransitionEnded;
        }
        if (!super.getTransformation(j, transformation)) {
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        }
        return true;
    }

    public void run() {
        if (this.mEnded || !this.mAnimating) {
            this.mParent.endViewTransition(this.mChild);
            this.mTransitionEnded = true;
            return;
        }
        this.mAnimating = false;
        this.mParent.post(this);
    }

    public boolean getTransformation(long j, Transformation transformation, float f) {
        this.mAnimating = true;
        if (this.mEnded) {
            return !this.mTransitionEnded;
        }
        if (!super.getTransformation(j, transformation, f)) {
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        }
        return true;
    }
}
