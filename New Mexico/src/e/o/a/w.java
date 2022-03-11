package e.o.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import e.j.j.q;
/* loaded from: classes.dex */
public class w extends AnimationSet implements Runnable {
    public final ViewGroup b;
    public final View c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1881d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1882e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1883f = true;

    public w(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.b = viewGroup;
        this.c = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public boolean getTransformation(long j2, Transformation transformation) {
        this.f1883f = true;
        if (this.f1881d) {
            return !this.f1882e;
        }
        if (!super.getTransformation(j2, transformation)) {
            this.f1881d = true;
            q.a(this.b, this);
        }
        return true;
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j2, Transformation transformation, float f2) {
        this.f1883f = true;
        if (this.f1881d) {
            return !this.f1882e;
        }
        if (!super.getTransformation(j2, transformation, f2)) {
            this.f1881d = true;
            q.a(this.b, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1881d || !this.f1883f) {
            this.b.endViewTransition(this.c);
            this.f1882e = true;
            return;
        }
        this.f1883f = false;
        this.b.post(this);
    }
}
