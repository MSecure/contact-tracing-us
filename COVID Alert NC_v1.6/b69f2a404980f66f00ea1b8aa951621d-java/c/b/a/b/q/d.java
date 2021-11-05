package c.b.a.b.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

public class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3181a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f3182b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f3183c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f3184d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f3185e;

    public d(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        this.f3185e = bottomAppBar;
        this.f3182b = actionMenuView;
        this.f3183c = i;
        this.f3184d = z;
    }

    public void onAnimationCancel(Animator animator) {
        this.f3181a = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f3181a) {
            BottomAppBar.x(this.f3185e, this.f3182b, this.f3183c, this.f3184d);
        }
    }
}
