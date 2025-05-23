package b.m.a.a;

import android.view.animation.Interpolator;

public abstract class d implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f1378a;

    /* renamed from: b  reason: collision with root package name */
    public final float f1379b;

    public d(float[] fArr) {
        this.f1378a = fArr;
        this.f1379b = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f1378a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f), fArr.length - 2);
        float f2 = this.f1379b;
        float f3 = (f - (((float) min) * f2)) / f2;
        float[] fArr2 = this.f1378a;
        return ((fArr2[min + 1] - fArr2[min]) * f3) + fArr2[min];
    }
}
