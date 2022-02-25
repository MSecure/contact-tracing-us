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
    public boolean f1682d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1683e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1684f = true;

    public t(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.b = viewGroup;
        this.c = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    public boolean getTransformation(long j2, Transformation transformation) {
        this.f1684f = true;
        if (this.f1682d) {
            return !this.f1683e;
        }
        if (!super.getTransformation(j2, transformation)) {
            this.f1682d = true;
            k.a(this.b, this);
        }
        return true;
    }

    public boolean getTransformation(long j2, Transformation transformation, float f2) {
        this.f1684f = true;
        if (this.f1682d) {
            return !this.f1683e;
        }
        if (!super.getTransformation(j2, transformation, f2)) {
            this.f1682d = true;
            k.a(this.b, this);
        }
        return true;
    }

    public void run() {
        if (this.f1682d || !this.f1684f) {
            this.b.endViewTransition(this.c);
            this.f1683e = true;
            return;
        }
        this.f1684f = false;
        this.b.post(this);
    }
}
