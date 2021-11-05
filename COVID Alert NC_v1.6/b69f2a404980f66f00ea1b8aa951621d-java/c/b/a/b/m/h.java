package c.b.a.b.m;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import c.a.a.a.a;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public long f3123a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f3124b = 300;

    /* renamed from: c  reason: collision with root package name */
    public TimeInterpolator f3125c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f3126d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f3127e = 1;

    public h(long j, long j2) {
        this.f3123a = j;
        this.f3124b = j2;
    }

    public h(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f3123a = j;
        this.f3124b = j2;
        this.f3125c = timeInterpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(this.f3123a);
        animator.setDuration(this.f3124b);
        animator.setInterpolator(b());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.f3126d);
            valueAnimator.setRepeatMode(this.f3127e);
        }
    }

    public TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.f3125c;
        return timeInterpolator != null ? timeInterpolator : a.f3109b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f3123a == hVar.f3123a && this.f3124b == hVar.f3124b && this.f3126d == hVar.f3126d && this.f3127e == hVar.f3127e) {
            return b().getClass().equals(hVar.b().getClass());
        }
        return false;
    }

    public int hashCode() {
        long j = this.f3123a;
        long j2 = this.f3124b;
        return ((((b().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31)) * 31) + this.f3126d) * 31) + this.f3127e;
    }

    public String toString() {
        StringBuilder f = a.f('\n');
        f.append(h.class.getName());
        f.append('{');
        f.append(Integer.toHexString(System.identityHashCode(this)));
        f.append(" delay: ");
        f.append(this.f3123a);
        f.append(" duration: ");
        f.append(this.f3124b);
        f.append(" interpolator: ");
        f.append(b().getClass());
        f.append(" repeatCount: ");
        f.append(this.f3126d);
        f.append(" repeatMode: ");
        f.append(this.f3127e);
        f.append("}\n");
        return f.toString();
    }
}
