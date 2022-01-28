package b.x;

import android.annotation.SuppressLint;
import android.view.View;

public class z extends y {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f2731f = true;

    @Override // b.x.c0
    @SuppressLint({"NewApi"})
    public void d(View view, int i, int i2, int i3, int i4) {
        if (f2731f) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                f2731f = false;
            }
        }
    }
}
