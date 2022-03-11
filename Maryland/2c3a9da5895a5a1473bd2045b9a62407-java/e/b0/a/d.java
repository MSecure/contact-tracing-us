package e.b0.a;

import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class d extends ViewPager2.e {
    public final /* synthetic */ FragmentStateAdapter.b a;

    public d(FragmentStateAdapter.b bVar) {
        this.a = bVar;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int i2) {
        this.a.b(false);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void c(int i2) {
        this.a.b(false);
    }
}
