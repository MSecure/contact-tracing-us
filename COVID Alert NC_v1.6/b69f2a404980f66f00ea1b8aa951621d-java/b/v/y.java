package b.v;

import android.annotation.SuppressLint;
import android.view.View;

public class y extends x {
    public static boolean f = true;

    @Override // b.v.b0
    @SuppressLint({"NewApi"})
    public void d(View view, int i, int i2, int i3, int i4) {
        if (f) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                f = false;
            }
        }
    }
}
