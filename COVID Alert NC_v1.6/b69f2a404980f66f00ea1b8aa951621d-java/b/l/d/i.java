package b.l.d;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import b.i.l.k;

public class i extends AnimationSet implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final ViewGroup f1302b;

    /* renamed from: c  reason: collision with root package name */
    public final View f1303c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1304d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1305e;
    public boolean f = true;

    public i(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f1302b = viewGroup;
        this.f1303c = view;
        addAnimation(animation);
        this.f1302b.post(this);
    }

    public boolean getTransformation(long j, Transformation transformation) {
        this.f = true;
        if (this.f1304d) {
            return !this.f1305e;
        }
        if (!super.getTransformation(j, transformation)) {
            this.f1304d = true;
            k.a(this.f1302b, this);
        }
        return true;
    }

    public boolean getTransformation(long j, Transformation transformation, float f2) {
        this.f = true;
        if (this.f1304d) {
            return !this.f1305e;
        }
        if (!super.getTransformation(j, transformation, f2)) {
            this.f1304d = true;
            k.a(this.f1302b, this);
        }
        return true;
    }

    public void run() {
        if (this.f1304d || !this.f) {
            this.f1302b.endViewTransition(this.f1303c);
            this.f1305e = true;
            return;
        }
        this.f = false;
        this.f1302b.post(this);
    }
}
