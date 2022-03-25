package f.b.a.a.a.i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import e.z.a;

public final class m implements a {
    public final LinearLayout a;
    public final TabLayout b;
    public final ViewPager2 c;

    public m(LinearLayout linearLayout, TabLayout tabLayout, ViewPager2 viewPager2) {
        this.a = linearLayout;
        this.b = tabLayout;
        this.c = viewPager2;
    }

    @Override // e.z.a
    public View a() {
        return this.a;
    }
}
