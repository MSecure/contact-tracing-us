package f.b.a.d.y;

import android.view.View;
import com.google.android.material.tabs.TabLayout;

public class d implements View.OnLayoutChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ TabLayout.i b;

    public d(TabLayout.i iVar, View view) {
        this.b = iVar;
        this.a = view;
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (this.a.getVisibility() == 0) {
            TabLayout.i iVar = this.b;
            View view2 = this.a;
            int i10 = TabLayout.i.m;
            iVar.e(view2);
        }
    }
}
