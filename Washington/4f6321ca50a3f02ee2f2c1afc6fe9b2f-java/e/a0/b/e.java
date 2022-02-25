package e.a0.b;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import f.b.a.a.a.j.e0;
import f.b.a.a.a.j.r;
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
            for (int i4 = 0; i4 < this.a.y(); i4++) {
                View x = this.a.x(i4);
                if (x != null) {
                    float R = ((float) (this.a.R(x) - i2)) + f3;
                    Objects.requireNonNull((r) this.b);
                    int i5 = e0.b0;
                    float f4 = 0.0f;
                    if (R <= -1.0f || R >= 1.0f) {
                        x.setAlpha(0.0f);
                    } else if (R == 0.0f) {
                        x.setAlpha(1.0f);
                    } else {
                        x.setAlpha(1.0f - Math.abs(R));
                        f4 = ((float) x.getWidth()) * (-R);
                    }
                    x.setTranslationX(f4);
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i4), Integer.valueOf(this.a.y())));
                }
            }
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void c(int i2) {
    }
}
