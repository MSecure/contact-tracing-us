package e.b0.b;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import f.b.a.a.a.l.l0;
import f.b.a.a.a.l.y;
import java.util.Locale;
import java.util.Objects;

public final class e extends ViewPager2.e {
    public final LinearLayoutManager a;
    public ViewPager2.g b;

    public e(LinearLayoutManager linearLayoutManager) {
        this.a = linearLayoutManager;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int i2) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void b(int i2, float f2, int i3) {
        if (this.b != null) {
            float f3 = -f2;
            for (int i4 = 0; i4 < this.a.z(); i4++) {
                View y = this.a.y(i4);
                if (y != null) {
                    float S = ((float) (this.a.S(y) - i2)) + f3;
                    Objects.requireNonNull((y) this.b);
                    int i5 = l0.d0;
                    float f4 = 0.0f;
                    if (S <= -1.0f || S >= 1.0f) {
                        y.setAlpha(0.0f);
                    } else if (S == 0.0f) {
                        y.setAlpha(1.0f);
                    } else {
                        y.setAlpha(1.0f - Math.abs(S));
                        f4 = ((float) y.getWidth()) * (-S);
                    }
                    y.setTranslationX(f4);
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i4), Integer.valueOf(this.a.z())));
                }
            }
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void c(int i2) {
    }
}
