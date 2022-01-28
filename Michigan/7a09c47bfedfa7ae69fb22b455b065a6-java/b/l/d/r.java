package b.l.d;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import b.i.l.k;

public class r extends AnimationSet implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final ViewGroup f2119b;

    /* renamed from: c  reason: collision with root package name */
    public final View f2120c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2121d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2122e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2123f = true;

    public r(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f2119b = viewGroup;
        this.f2120c = view;
        addAnimation(animation);
        this.f2119b.post(this);
    }

    public boolean getTransformation(long j, Transformation transformation) {
        this.f2123f = true;
        if (this.f2121d) {
            return !this.f2122e;
        }
        if (!super.getTransformation(j, transformation)) {
            this.f2121d = true;
            k.a(this.f2119b, this);
        }
        return true;
    }

    public boolean getTransformation(long j, Transformation transformation, float f2) {
        this.f2123f = true;
        if (this.f2121d) {
            return !this.f2122e;
        }
        if (!super.getTransformation(j, transformation, f2)) {
            this.f2121d = true;
            k.a(this.f2119b, this);
        }
        return true;
    }

    public void run() {
        if (this.f2121d || !this.f2123f) {
            this.f2119b.endViewTransition(this.f2120c);
            this.f2122e = true;
            return;
        }
        this.f2123f = false;
        this.f2119b.post(this);
    }
}
