package e.a0.b;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public final class c extends ViewPager2.e {
    public final List<ViewPager2.e> a;

    public c(int i2) {
        this.a = new ArrayList(i2);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int i2) {
        try {
            for (ViewPager2.e eVar : this.a) {
                eVar.a(i2);
            }
        } catch (ConcurrentModificationException e2) {
            d(e2);
            throw null;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void b(int i2, float f2, int i3) {
        try {
            for (ViewPager2.e eVar : this.a) {
                eVar.b(i2, f2, i3);
            }
        } catch (ConcurrentModificationException e2) {
            d(e2);
            throw null;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void c(int i2) {
        try {
            for (ViewPager2.e eVar : this.a) {
                eVar.c(i2);
            }
        } catch (ConcurrentModificationException e2) {
            d(e2);
            throw null;
        }
    }

    public final void d(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
