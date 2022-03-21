package f.b.a.d.e;

import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

public class e implements Runnable {
    public final /* synthetic */ ActionMenuView b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f2592d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f2593e;

    public e(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i2, boolean z) {
        this.f2593e = bottomAppBar;
        this.b = actionMenuView;
        this.c = i2;
        this.f2592d = z;
    }

    public void run() {
        ActionMenuView actionMenuView = this.b;
        actionMenuView.setTranslationX((float) this.f2593e.A(actionMenuView, this.c, this.f2592d));
    }
}
