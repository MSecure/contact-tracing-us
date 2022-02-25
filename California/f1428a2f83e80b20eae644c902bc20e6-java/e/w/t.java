package e.w;

import android.view.View;

public class t extends y {

    /* renamed from: e  reason: collision with root package name */
    public static boolean f1933e = true;

    @Override // e.w.y
    public void a(View view) {
    }

    @Override // e.w.y
    public float b(View view) {
        if (f1933e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f1933e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // e.w.y
    public void c(View view) {
    }

    @Override // e.w.y
    public void e(View view, float f2) {
        if (f1933e) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f1933e = false;
            }
        }
        view.setAlpha(f2);
    }
}
