package e.m.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import e.i.i.k;

public class t extends AnimationSet implements Runnable {
    public final ViewGroup b;
    public final View c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1681d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1682e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1683f = true;

    public t(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.b = viewGroup;
        this.c = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    public boolean getTransformation(long j2, Transformation transformation) {
        this.f1683f = true;
        if (this.f1681d) {
            return !this.f1682e;
        }
        if (!super.getTransformation(j2, transformation)) {
            this.f1681d = true;
            k.a(this.b, this);
        }
        return true;
    }

    public boolean getTransformation(long j2, Transformation transformation, float f2) {
        this.f1683f = true;
        if (this.f1681d) {
            return !this.f1682e;
        }
        if (!super.getTransformation(j2, transformation, f2)) {
            this.f1681d = true;
            k.a(this.b, this);
        }
        return true;
    }

    public void run() {
        if (this.f1681d || !this.f1683f) {
            this.b.endViewTransition(this.c);
            this.f1682e = true;
            return;
        }
        this.f1683f = false;
        this.b.post(this);
    }
}
