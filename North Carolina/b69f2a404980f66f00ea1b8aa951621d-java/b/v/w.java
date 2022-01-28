package b.v;

import android.annotation.SuppressLint;
import android.view.View;

public class w extends b0 {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f1834c = true;

    @Override // b.v.b0
    public void a(View view) {
    }

    @Override // b.v.b0
    @SuppressLint({"NewApi"})
    public float b(View view) {
        if (f1834c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f1834c = false;
            }
        }
        return view.getAlpha();
    }

    @Override // b.v.b0
    public void c(View view) {
    }

    @Override // b.v.b0
    @SuppressLint({"NewApi"})
    public void e(View view, float f) {
        if (f1834c) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                f1834c = false;
            }
        }
        view.setAlpha(f);
    }
}
