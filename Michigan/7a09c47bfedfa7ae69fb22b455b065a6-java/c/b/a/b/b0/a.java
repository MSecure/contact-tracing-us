package c.b.a.b.b0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4158a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f4159b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExtendedFloatingActionButton.c f4160c = null;

    public a(ExtendedFloatingActionButton extendedFloatingActionButton, i iVar) {
        this.f4159b = iVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f4158a = true;
        this.f4159b.c();
    }

    public void onAnimationEnd(Animator animator) {
        this.f4159b.b();
        if (!this.f4158a) {
            this.f4159b.e(null);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f4159b.onAnimationStart(animator);
        this.f4158a = false;
    }
}
