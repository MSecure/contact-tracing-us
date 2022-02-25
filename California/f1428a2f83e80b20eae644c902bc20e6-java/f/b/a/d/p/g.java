package f.b.a.d.p;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.b.a.d.u.b;
import java.util.ArrayList;

public class g extends d {
    public g(FloatingActionButton floatingActionButton, b bVar) {
        super(floatingActionButton, bVar);
    }

    @Override // f.b.a.d.p.d
    public float c() {
        return this.s.getElevation();
    }

    @Override // f.b.a.d.p.d
    public void d(Rect rect) {
        if (FloatingActionButton.this.f531k) {
            super.d(rect);
            return;
        }
        int i2 = 0;
        if (!r()) {
            i2 = (0 - this.s.getSizeDimension()) / 2;
        }
        rect.set(i2, i2, i2, i2);
    }

    @Override // f.b.a.d.p.d
    public void g() {
    }

    @Override // f.b.a.d.p.d
    public void h() {
        t();
        throw null;
    }

    @Override // f.b.a.d.p.d
    public void i(int[] iArr) {
        FloatingActionButton floatingActionButton;
        if (Build.VERSION.SDK_INT == 21) {
            float f2 = 0.0f;
            if (this.s.isEnabled()) {
                this.s.setElevation(this.f2656d);
                if (this.s.isPressed()) {
                    floatingActionButton = this.s;
                    f2 = this.f2658f;
                } else if (this.s.isFocused() || this.s.isHovered()) {
                    floatingActionButton = this.s;
                    f2 = this.f2657e;
                }
                floatingActionButton.setTranslationZ(f2);
            }
            this.s.setElevation(0.0f);
            floatingActionButton = this.s;
            floatingActionButton.setTranslationZ(f2);
        }
    }

    @Override // f.b.a.d.p.d
    public void j(float f2, float f3, float f4) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 21) {
            this.s.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(d.A, u(f2, f4));
            stateListAnimator.addState(d.B, u(f2, f3));
            stateListAnimator.addState(d.C, u(f2, f3));
            stateListAnimator.addState(d.D, u(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.s, "elevation", f2).setDuration(0L));
            if (i2 >= 22 && i2 <= 24) {
                FloatingActionButton floatingActionButton = this.s;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(d.z);
            stateListAnimator.addState(d.E, animatorSet);
            stateListAnimator.addState(d.F, u(0.0f, 0.0f));
            this.s.setStateListAnimator(stateListAnimator);
        }
        if (p()) {
            t();
            throw null;
        }
    }

    @Override // f.b.a.d.p.d
    public boolean m() {
        return false;
    }

    @Override // f.b.a.d.p.d
    public void o(ColorStateList colorStateList) {
    }

    @Override // f.b.a.d.p.d
    public boolean p() {
        return FloatingActionButton.this.f531k || !r();
    }

    @Override // f.b.a.d.p.d
    public void s() {
    }

    public final Animator u(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.s, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(d.z);
        return animatorSet;
    }
}
