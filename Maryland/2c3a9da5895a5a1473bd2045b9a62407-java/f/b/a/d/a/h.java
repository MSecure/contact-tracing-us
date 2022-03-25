package f.b.a.d.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

public class h {
    public long a = 0;
    public long b = 300;
    public TimeInterpolator c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f2655d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f2656e = 1;

    public h(long j2, long j3) {
        this.a = j2;
        this.b = j3;
    }

    public h(long j2, long j3, TimeInterpolator timeInterpolator) {
        this.a = j2;
        this.b = j3;
        this.c = timeInterpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(this.a);
        animator.setDuration(this.b);
        animator.setInterpolator(b());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.f2655d);
            valueAnimator.setRepeatMode(this.f2656e);
        }
    }

    public TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.c;
        return timeInterpolator != null ? timeInterpolator : a.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.a == hVar.a && this.b == hVar.b && this.f2655d == hVar.f2655d && this.f2656e == hVar.f2656e) {
            return b().getClass().equals(hVar.b().getClass());
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.b;
        return ((((b().getClass().hashCode() + (((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31)) * 31) + this.f2655d) * 31) + this.f2656e;
    }

    public String toString() {
        return '\n' + h.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + this.a + " duration: " + this.b + " interpolator: " + b().getClass() + " repeatCount: " + this.f2655d + " repeatMode: " + this.f2656e + "}\n";
    }
}
