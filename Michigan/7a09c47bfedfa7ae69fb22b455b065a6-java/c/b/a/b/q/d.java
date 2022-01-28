package c.b.a.b.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

public class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4493a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f4494b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4495c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f4496d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f4497e;

    public d(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        this.f4497e = bottomAppBar;
        this.f4494b = actionMenuView;
        this.f4495c = i;
        this.f4496d = z;
    }

    public void onAnimationCancel(Animator animator) {
        this.f4493a = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f4493a) {
            BottomAppBar.y(this.f4497e, this.f4494b, this.f4495c, this.f4496d);
            BottomAppBar bottomAppBar = this.f4497e;
            int i = bottomAppBar.W;
            if (i != 0) {
                bottomAppBar.getMenu().clear();
                bottomAppBar.n(i);
                this.f4497e.W = 0;
            }
        }
    }
}
