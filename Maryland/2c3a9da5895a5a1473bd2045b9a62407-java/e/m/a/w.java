package e.m.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import e.i.i.l;

public class w extends AnimationSet implements Runnable {
    public final ViewGroup b;
    public final View c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1708d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1709e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1710f = true;

    public w(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.b = viewGroup;
        this.c = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    public boolean getTransformation(long j2, Transformation transformation) {
        this.f1710f = true;
        if (this.f1708d) {
            return !this.f1709e;
        }
        if (!super.getTransformation(j2, transformation)) {
            this.f1708d = true;
            l.a(this.b, this);
        }
        return true;
    }

    public boolean getTransformation(long j2, Transformation transformation, float f2) {
        this.f1710f = true;
        if (this.f1708d) {
            return !this.f1709e;
        }
        if (!super.getTransformation(j2, transformation, f2)) {
            this.f1708d = true;
            l.a(this.b, this);
        }
        return true;
    }

    public void run() {
        if (this.f1708d || !this.f1710f) {
            this.b.endViewTransition(this.c);
            this.f1709e = true;
            return;
        }
        this.f1710f = false;
        this.b.post(this);
    }
}
