package e.w;

import android.view.View;

public class v extends u {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f1968h = true;

    @Override // e.w.y
    public void d(View view, int i2, int i3, int i4, int i5) {
        if (f1968h) {
            try {
                view.setLeftTopRightBottom(i2, i3, i4, i5);
            } catch (NoSuchMethodError unused) {
                f1968h = false;
            }
        }
    }
}
