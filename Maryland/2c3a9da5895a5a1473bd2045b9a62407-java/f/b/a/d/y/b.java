package f.b.a.d.y;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import f.b.a.d.a.a;

public class b {
    public static RectF a(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.C || !(view instanceof TabLayout.i)) {
            return new RectF((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
        }
        TabLayout.i iVar = (TabLayout.i) view;
        int contentWidth = iVar.getContentWidth();
        int contentHeight = iVar.getContentHeight();
        int r0 = (int) f.b.a.c.b.o.b.r0(iVar.getContext(), 24);
        if (contentWidth < r0) {
            contentWidth = r0;
        }
        int right = (iVar.getRight() + iVar.getLeft()) / 2;
        int bottom = (iVar.getBottom() + iVar.getTop()) / 2;
        int i2 = contentWidth / 2;
        return new RectF((float) (right - i2), (float) (bottom - (contentHeight / 2)), (float) (i2 + right), (float) ((right / 2) + bottom));
    }

    public void b(TabLayout tabLayout, View view, View view2, float f2, Drawable drawable) {
        RectF a = a(tabLayout, view);
        RectF a2 = a(tabLayout, view2);
        drawable.setBounds(a.a((int) a.left, (int) a2.left, f2), drawable.getBounds().top, a.a((int) a.right, (int) a2.right, f2), drawable.getBounds().bottom);
    }
}
