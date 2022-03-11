package e.z;

import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class w extends v {

    /* renamed from: i */
    public static boolean f2147i;

    @Override // e.z.y
    public void f(View view, int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i2);
        } else if (f2147i) {
            try {
                view.setTransitionVisibility(i2);
            } catch (NoSuchMethodError unused) {
                f2147i = false;
            }
        }
    }
}
