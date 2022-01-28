package c.b.a.b.k0;

import android.view.View;
import com.google.android.material.tabs.TabLayout;

public class b implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f3059a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TabLayout.i f3060b;

    public b(TabLayout.i iVar, View view) {
        this.f3060b = iVar;
        this.f3059a = view;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.f3059a.getVisibility() == 0) {
            this.f3060b.h(this.f3059a);
        }
    }
}
