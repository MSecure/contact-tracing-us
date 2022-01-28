package c.b.a.b.b0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import c.b.a.b.g0.b;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class h extends e {
    public h(FloatingActionButton floatingActionButton, b bVar) {
        super(floatingActionButton, bVar);
    }

    @Override // c.b.a.b.b0.e
    public float c() {
        return this.t.getElevation();
    }

    @Override // c.b.a.b.b0.e
    public void d(Rect rect) {
        if (FloatingActionButton.this.k) {
            super.d(rect);
            return;
        }
        int i = 0;
        if (!r()) {
            i = (0 - this.t.getSizeDimension()) / 2;
        }
        rect.set(i, i, i, i);
    }

    @Override // c.b.a.b.b0.e
    public void g() {
    }

    @Override // c.b.a.b.b0.e
    public void h() {
        t();
    }

    @Override // c.b.a.b.b0.e
    public void i(int[] iArr) {
    }

    @Override // c.b.a.b.b0.e
    public void j(float f2, float f3, float f4) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(e.B, u(f2, f4));
        stateListAnimator.addState(e.C, u(f2, f3));
        stateListAnimator.addState(e.D, u(f2, f3));
        stateListAnimator.addState(e.E, u(f2, f3));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.t, "elevation", f2).setDuration(0L));
        if (Build.VERSION.SDK_INT <= 24) {
            FloatingActionButton floatingActionButton = this.t;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.t, View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(e.A);
        stateListAnimator.addState(e.F, animatorSet);
        stateListAnimator.addState(e.G, u(0.0f, 0.0f));
        this.t.setStateListAnimator(stateListAnimator);
        if (p()) {
            t();
        }
    }

    @Override // c.b.a.b.b0.e
    public boolean m() {
        return false;
    }

    @Override // c.b.a.b.b0.e
    public void o(ColorStateList colorStateList) {
    }

    @Override // c.b.a.b.b0.e
    public boolean p() {
        return FloatingActionButton.this.k || !r();
    }

    @Override // c.b.a.b.b0.e
    public void s() {
    }

    public final Animator u(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.t, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.t, View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(e.A);
        return animatorSet;
    }
}
