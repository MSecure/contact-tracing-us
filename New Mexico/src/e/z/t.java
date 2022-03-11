package e.z;

import android.view.View;
/* loaded from: classes.dex */
public class t extends y {

    /* renamed from: e  reason: collision with root package name */
    public static boolean f2143e = true;

    @Override // e.z.y
    public void a(View view) {
    }

    @Override // e.z.y
    public float b(View view) {
        if (f2143e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f2143e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // e.z.y
    public void c(View view) {
    }

    @Override // e.z.y
    public void e(View view, float f2) {
        if (f2143e) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f2143e = false;
            }
        }
        view.setAlpha(f2);
    }
}
