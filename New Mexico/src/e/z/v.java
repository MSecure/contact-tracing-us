package e.z;

import android.view.View;
/* loaded from: classes.dex */
public class v extends u {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f2146h = true;

    @Override // e.z.y
    public void d(View view, int i2, int i3, int i4, int i5) {
        if (f2146h) {
            try {
                view.setLeftTopRightBottom(i2, i3, i4, i5);
            } catch (NoSuchMethodError unused) {
                f2146h = false;
            }
        }
    }
}
