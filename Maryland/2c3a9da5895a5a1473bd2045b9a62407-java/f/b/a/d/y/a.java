package f.b.a.d.y;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

public class a extends b {
    public static float c(float f2) {
        return (float) (1.0d - Math.cos((((double) f2) * 3.141592653589793d) / 2.0d));
    }

    @Override // f.b.a.d.y.b
    public void b(TabLayout tabLayout, View view, View view2, float f2, Drawable drawable) {
        float f3;
        float f4;
        RectF a = b.a(tabLayout, view);
        RectF a2 = b.a(tabLayout, view2);
        if (a.left < a2.left) {
            f4 = c(f2);
            f3 = (float) Math.sin((((double) f2) * 3.141592653589793d) / 2.0d);
        } else {
            f4 = (float) Math.sin((((double) f2) * 3.141592653589793d) / 2.0d);
            f3 = c(f2);
        }
        drawable.setBounds(f.b.a.d.a.a.a((int) a.left, (int) a2.left, f4), drawable.getBounds().top, f.b.a.d.a.a.a((int) a.right, (int) a2.right, f3), drawable.getBounds().bottom);
    }
}
