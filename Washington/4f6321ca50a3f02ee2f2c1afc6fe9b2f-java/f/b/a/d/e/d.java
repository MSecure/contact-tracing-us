package f.b.a.d.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;
import java.util.Objects;

public class d extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ ActionMenuView b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f2590d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f2591e;

    public d(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i2, boolean z) {
        this.f2591e = bottomAppBar;
        this.b = actionMenuView;
        this.c = i2;
        this.f2590d = z;
    }

    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.a) {
            BottomAppBar bottomAppBar = this.f2591e;
            int i2 = bottomAppBar.W;
            boolean z = i2 != 0;
            if (i2 != 0) {
                bottomAppBar.W = 0;
                bottomAppBar.getMenu().clear();
                bottomAppBar.n(i2);
            }
            BottomAppBar bottomAppBar2 = this.f2591e;
            ActionMenuView actionMenuView = this.b;
            int i3 = this.c;
            boolean z2 = this.f2590d;
            Objects.requireNonNull(bottomAppBar2);
            e eVar = new e(bottomAppBar2, actionMenuView, i3, z2);
            if (z) {
                actionMenuView.post(eVar);
            } else {
                eVar.run();
            }
        }
    }
}
