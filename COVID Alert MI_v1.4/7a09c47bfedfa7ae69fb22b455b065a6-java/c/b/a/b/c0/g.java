package c.b.a.b.c0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<b> f4202a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public b f4203b = null;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f4204c = null;

    /* renamed from: d  reason: collision with root package name */
    public final Animator.AnimatorListener f4205d = new a();

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            g gVar = g.this;
            if (gVar.f4204c == animator) {
                gVar.f4204c = null;
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f4207a;

        /* renamed from: b  reason: collision with root package name */
        public final ValueAnimator f4208b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.f4207a = iArr;
            this.f4208b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f4205d);
        this.f4202a.add(bVar);
    }
}
