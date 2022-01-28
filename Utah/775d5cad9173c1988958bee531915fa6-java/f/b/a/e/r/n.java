package f.b.a.e.r;

import android.animation.Animator;

public abstract class n<T extends Animator> {
    public o a;
    public final float[] b;
    public final int[] c;

    public n(int i2) {
        this.b = new float[(i2 * 2)];
        this.c = new int[i2];
    }

    public abstract void a();

    public float b(int i2, int i3, int i4) {
        return ((float) (i2 - i3)) / ((float) i4);
    }

    public abstract void c();
}
