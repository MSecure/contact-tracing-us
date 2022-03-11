package f.d.a.f;

import android.view.View;
import android.view.WindowInsets;
import j.k.b.e;
/* loaded from: classes.dex */
public final class c implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ int[] a;
    public final /* synthetic */ a b;

    public c(int[] iArr, a aVar) {
        this.a = iArr;
        this.b = aVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        int[] iArr = this.a;
        for (int i2 : iArr) {
            if (i2 != 3) {
                if (i2 != 5) {
                    if (i2 == 48) {
                        e.b(view, "v");
                        int i3 = this.b.b;
                        e.b(windowInsets, "insets");
                        view.setPadding(view.getPaddingLeft(), windowInsets.getSystemWindowInsetTop() + i3, view.getPaddingRight(), view.getPaddingBottom());
                    } else if (i2 == 80) {
                        e.b(view, "v");
                        int i4 = this.b.f4043d;
                        e.b(windowInsets, "insets");
                        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsets.getSystemWindowInsetBottom() + i4);
                    } else if (i2 != 8388611) {
                        if (i2 != 8388613) {
                        }
                    }
                }
                e.b(view, "v");
                int i5 = this.b.c;
                e.b(windowInsets, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), windowInsets.getSystemWindowInsetRight() + i5, view.getPaddingBottom());
            }
            e.b(view, "v");
            int i6 = this.b.a;
            e.b(windowInsets, "insets");
            view.setPadding(windowInsets.getSystemWindowInsetLeft() + i6, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
        return windowInsets;
    }
}
