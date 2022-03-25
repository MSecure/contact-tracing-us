package e.b0.a;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class a implements View.OnLayoutChangeListener {
    public final /* synthetic */ FrameLayout a;
    public final /* synthetic */ f b;
    public final /* synthetic */ FragmentStateAdapter c;

    public a(FragmentStateAdapter fragmentStateAdapter, FrameLayout frameLayout, f fVar) {
        this.c = fragmentStateAdapter;
        this.a = frameLayout;
        this.b = fVar;
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (this.a.getParent() != null) {
            this.a.removeOnLayoutChangeListener(this);
            this.c.u(this.b);
        }
    }
}
