package c.b.a.b.c0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<b> f2938a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public b f2939b = null;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f2940c = null;

    /* renamed from: d  reason: collision with root package name */
    public final Animator.AnimatorListener f2941d = new a();

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            f fVar = f.this;
            if (fVar.f2940c == animator) {
                fVar.f2940c = null;
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f2943a;

        /* renamed from: b  reason: collision with root package name */
        public final ValueAnimator f2944b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.f2943a = iArr;
            this.f2944b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f2941d);
        this.f2938a.add(bVar);
    }
}
