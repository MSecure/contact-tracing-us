package e.i.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import e.b.a.w;
import java.lang.ref.WeakReference;

public final class s {
    public WeakReference<View> a;
    public int b = -1;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ t a;
        public final /* synthetic */ View b;

        public a(s sVar, t tVar, View view) {
            this.a = tVar;
            this.b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.a.c(this.b);
        }

        public void onAnimationEnd(Animator animator) {
            this.a.a(this.b);
        }

        public void onAnimationStart(Animator animator) {
            this.a.b(this.b);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ v a;
        public final /* synthetic */ View b;

        public b(s sVar, v vVar, View view) {
            this.a = vVar;
            this.b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((View) w.this.f699d.getParent()).invalidate();
        }
    }

    public s(View view) {
        this.a = new WeakReference<>(view);
    }

    public s a(float f2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public void b() {
        View view = this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public s c(long j2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public s d(t tVar) {
        View view = this.a.get();
        if (view != null) {
            e(view, tVar);
        }
        return this;
    }

    public final void e(View view, t tVar) {
        if (tVar != null) {
            view.animate().setListener(new a(this, tVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public s f(v vVar) {
        View view = this.a.get();
        if (view != null) {
            b bVar = null;
            if (vVar != null) {
                bVar = new b(this, vVar, view);
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }

    public s g(float f2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }
}
