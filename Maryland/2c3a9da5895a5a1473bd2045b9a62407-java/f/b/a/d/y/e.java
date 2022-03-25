package f.b.a.d.y;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import f.b.a.a.a.l.l0;
import gov.md.covid19.exposurenotifications.R;
import java.lang.ref.WeakReference;

public final class e {
    public final TabLayout a;
    public final ViewPager2 b;
    public RecyclerView.e<?> c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2924d;

    /* renamed from: e  reason: collision with root package name */
    public c f2925e;

    /* renamed from: f  reason: collision with root package name */
    public TabLayout.d f2926f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView.g f2927g;

    public class a extends RecyclerView.g {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void a() {
            e.this.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void b(int i2, int i3) {
            e.this.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void c(int i2, int i3, Object obj) {
            e.this.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void d(int i2, int i3) {
            e.this.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void e(int i2, int i3) {
            e.this.a();
        }
    }

    public interface b {
    }

    public static class c extends ViewPager2.e {
        public final WeakReference<TabLayout> a;
        public int b = 0;
        public int c = 0;

        public c(TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void a(int i2) {
            this.b = this.c;
            this.c = i2;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void b(int i2, float f2, int i3) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null) {
                int i4 = this.c;
                boolean z = false;
                boolean z2 = i4 != 2 || this.b == 1;
                if (!(i4 == 2 && this.b == 0)) {
                    z = true;
                }
                tabLayout.l(i2, f2, z2, z);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void c(int i2) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i2 && i2 < tabLayout.getTabCount()) {
                int i3 = this.c;
                tabLayout.j(tabLayout.g(i2), i3 == 0 || (i3 == 2 && this.b == 0));
            }
        }
    }

    public static class d implements TabLayout.d {
        public final ViewPager2 a;
        public final boolean b;

        public d(ViewPager2 viewPager2, boolean z) {
            this.a = viewPager2;
            this.b = z;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
            ViewPager2 viewPager2 = this.a;
            int i2 = gVar.f590d;
            boolean z = this.b;
            if (!viewPager2.o.a.m) {
                viewPager2.c(i2, z);
                return;
            }
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    public e(TabLayout tabLayout, ViewPager2 viewPager2, b bVar) {
        this.a = tabLayout;
        this.b = viewPager2;
    }

    public void a() {
        int min;
        int i2;
        this.a.i();
        RecyclerView.e<?> eVar = this.c;
        if (eVar != null) {
            int c2 = eVar.c();
            for (int i3 = 0; i3 < c2; i3++) {
                TabLayout.g h2 = this.a.h();
                int i4 = l0.d0;
                if (i3 == 0) {
                    h2.a(R.drawable.ic_bell);
                    i2 = R.string.home_tab_exposures_text;
                } else if (i3 == 1) {
                    h2.a(R.drawable.ic_flag);
                    i2 = R.string.home_tab_notify_text;
                } else if (i3 != 2) {
                    this.a.a(h2, false);
                } else {
                    h2.a(R.drawable.ic_cog);
                    i2 = R.string.home_tab_settings_text;
                }
                h2.c(i2);
                this.a.a(h2, false);
            }
            if (c2 > 0 && (min = Math.min(this.b.getCurrentItem(), this.a.getTabCount() - 1)) != this.a.getSelectedTabPosition()) {
                TabLayout tabLayout = this.a;
                tabLayout.j(tabLayout.g(min), true);
            }
        }
    }
}
