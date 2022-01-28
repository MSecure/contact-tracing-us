package e.y;

import android.view.View;

public class v extends u {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f2061h = true;

    @Override // e.y.y
    public void d(View view, int i2, int i3, int i4, int i5) {
        if (f2061h) {
            try {
                view.setLeftTopRightBottom(i2, i3, i4, i5);
            } catch (NoSuchMethodError unused) {
                f2061h = false;
            }
        }
    }
}
