package c.b.a.b.k0;

import android.view.View;
import com.google.android.material.tabs.TabLayout;

public class b implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f4352a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TabLayout.i f4353b;

    public b(TabLayout.i iVar, View view) {
        this.f4353b = iVar;
        this.f4352a = view;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.f4352a.getVisibility() == 0) {
            this.f4353b.h(this.f4352a);
        }
    }
}
