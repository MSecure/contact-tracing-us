package e.n.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import e.i.i.q;

public class w extends AnimationSet implements Runnable {
    public final ViewGroup b;
    public final View c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1796d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1797e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1798f = true;

    public w(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.b = viewGroup;
        this.c = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    public boolean getTransformation(long j2, Transformation transformation) {
        this.f1798f = true;
        if (this.f1796d) {
            return !this.f1797e;
        }
        if (!super.getTransformation(j2, transformation)) {
            this.f1796d = true;
            q.a(this.b, this);
        }
        return true;
    }

    public boolean getTransformation(long j2, Transformation transformation, float f2) {
        this.f1798f = true;
        if (this.f1796d) {
            return !this.f1797e;
        }
        if (!super.getTransformation(j2, transformation, f2)) {
            this.f1796d = true;
            q.a(this.b, this);
        }
        return true;
    }

    public void run() {
        if (this.f1796d || !this.f1798f) {
            this.b.endViewTransition(this.c);
            this.f1797e = true;
            return;
        }
        this.f1798f = false;
        this.b.post(this);
    }
}
