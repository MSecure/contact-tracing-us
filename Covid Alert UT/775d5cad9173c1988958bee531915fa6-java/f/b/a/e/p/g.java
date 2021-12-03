package f.b.a.e.p;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.b.a.e.u.b;
import java.util.ArrayList;

public class g extends d {
    public g(FloatingActionButton floatingActionButton, b bVar) {
        super(floatingActionButton, bVar);
    }

    @Override // f.b.a.e.p.d
    public float e() {
        return this.q.getElevation();
    }

    @Override // f.b.a.e.p.d
    public void f(Rect rect) {
        if (FloatingActionButton.this.f569k) {
            super.f(rect);
            return;
        }
        int i2 = 0;
        if (!t()) {
            i2 = (0 - this.q.getSizeDimension()) / 2;
        }
        rect.set(i2, i2, i2, i2);
    }

    @Override // f.b.a.e.p.d
    public void i() {
    }

    @Override // f.b.a.e.p.d
    public void j() {
        v();
        throw null;
    }

    @Override // f.b.a.e.p.d
    public void k(int[] iArr) {
        FloatingActionButton floatingActionButton;
        if (Build.VERSION.SDK_INT == 21) {
            float f2 = 0.0f;
            if (this.q.isEnabled()) {
                this.q.setElevation(this.f2927d);
                if (this.q.isPressed()) {
                    floatingActionButton = this.q;
                    f2 = this.f2929f;
                } else if (this.q.isFocused() || this.q.isHovered()) {
                    floatingActionButton = this.q;
                    f2 = this.f2928e;
                }
                floatingActionButton.setTranslationZ(f2);
            }
            this.q.setElevation(0.0f);
            floatingActionButton = this.q;
            floatingActionButton.setTranslationZ(f2);
        }
    }

    @Override // f.b.a.e.p.d
    public void l(float f2, float f3, float f4) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 21) {
            this.q.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(d.y, w(f2, f4));
            stateListAnimator.addState(d.z, w(f2, f3));
            stateListAnimator.addState(d.A, w(f2, f3));
            stateListAnimator.addState(d.B, w(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.q, "elevation", f2).setDuration(0L));
            if (i2 >= 22 && i2 <= 24) {
                FloatingActionButton floatingActionButton = this.q;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.q, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(d.x);
            stateListAnimator.addState(d.C, animatorSet);
            stateListAnimator.addState(d.D, w(0.0f, 0.0f));
            this.q.setStateListAnimator(stateListAnimator);
        }
        if (r()) {
            v();
            throw null;
        }
    }

    @Override // f.b.a.e.p.d
    public boolean o() {
        return false;
    }

    @Override // f.b.a.e.p.d
    public void q(ColorStateList colorStateList) {
    }

    @Override // f.b.a.e.p.d
    public boolean r() {
        return FloatingActionButton.this.f569k || !t();
    }

    @Override // f.b.a.e.p.d
    public void u() {
    }

    public final Animator w(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.q, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.q, View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(d.x);
        return animatorSet;
    }
}
