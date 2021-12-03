package e.y;

import android.view.View;

public class t extends y {

    /* renamed from: e  reason: collision with root package name */
    public static boolean f2058e = true;

    @Override // e.y.y
    public void a(View view) {
    }

    @Override // e.y.y
    public float b(View view) {
        if (f2058e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f2058e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // e.y.y
    public void c(View view) {
    }

    @Override // e.y.y
    public void e(View view, float f2) {
        if (f2058e) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f2058e = false;
            }
        }
        view.setAlpha(f2);
    }
}
