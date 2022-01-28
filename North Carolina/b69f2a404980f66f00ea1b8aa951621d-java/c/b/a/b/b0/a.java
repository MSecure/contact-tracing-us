package c.b.a.b.b0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2897a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f2898b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExtendedFloatingActionButton.c f2899c = null;

    public a(ExtendedFloatingActionButton extendedFloatingActionButton, i iVar) {
        this.f2898b = iVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f2897a = true;
        this.f2898b.c();
    }

    public void onAnimationEnd(Animator animator) {
        this.f2898b.b();
        if (!this.f2897a) {
            this.f2898b.e(null);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f2898b.onAnimationStart(animator);
        this.f2897a = false;
    }
}
