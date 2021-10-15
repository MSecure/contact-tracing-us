package c.b.a.b.m;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import c.a.a.a.a;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public long f4425a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f4426b = 300;

    /* renamed from: c  reason: collision with root package name */
    public TimeInterpolator f4427c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f4428d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f4429e = 1;

    public h(long j, long j2) {
        this.f4425a = j;
        this.f4426b = j2;
    }

    public h(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f4425a = j;
        this.f4426b = j2;
        this.f4427c = timeInterpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(this.f4425a);
        animator.setDuration(this.f4426b);
        animator.setInterpolator(b());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.f4428d);
            valueAnimator.setRepeatMode(this.f4429e);
        }
    }

    public TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.f4427c;
        return timeInterpolator != null ? timeInterpolator : a.f4411b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f4425a == hVar.f4425a && this.f4426b == hVar.f4426b && this.f4428d == hVar.f4428d && this.f4429e == hVar.f4429e) {
            return b().getClass().equals(hVar.b().getClass());
        }
        return false;
    }

    public int hashCode() {
        long j = this.f4425a;
        long j2 = this.f4426b;
        return ((((b().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31)) * 31) + this.f4428d) * 31) + this.f4429e;
    }

    public String toString() {
        StringBuilder g2 = a.g('\n');
        g2.append(h.class.getName());
        g2.append('{');
        g2.append(Integer.toHexString(System.identityHashCode(this)));
        g2.append(" delay: ");
        g2.append(this.f4425a);
        g2.append(" duration: ");
        g2.append(this.f4426b);
        g2.append(" interpolator: ");
        g2.append(b().getClass());
        g2.append(" repeatCount: ");
        g2.append(this.f4428d);
        g2.append(" repeatMode: ");
        g2.append(this.f4429e);
        g2.append("}\n");
        return g2.toString();
    }
}
