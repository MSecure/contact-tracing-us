package b.x;

import android.annotation.SuppressLint;
import android.view.View;

public class x extends c0 {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f2728c = true;

    @Override // b.x.c0
    public void a(View view) {
    }

    @Override // b.x.c0
    @SuppressLint({"NewApi"})
    public float b(View view) {
        if (f2728c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f2728c = false;
            }
        }
        return view.getAlpha();
    }

    @Override // b.x.c0
    public void c(View view) {
    }

    @Override // b.x.c0
    @SuppressLint({"NewApi"})
    public void e(View view, float f2) {
        if (f2728c) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f2728c = false;
            }
        }
        view.setAlpha(f2);
    }
}
