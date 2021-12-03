package e.i.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import e.b.a.w;
import java.lang.ref.WeakReference;

public final class x {
    public WeakReference<View> a;
    public int b = -1;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ y a;
        public final /* synthetic */ View b;

        public a(x xVar, y yVar, View view) {
            this.a = yVar;
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
        public final /* synthetic */ a0 a;
        public final /* synthetic */ View b;

        public b(x xVar, a0 a0Var, View view) {
            this.a = a0Var;
            this.b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((View) w.this.f697d.getParent()).invalidate();
        }
    }

    public x(View view) {
        this.a = new WeakReference<>(view);
    }

    public x a(float f2) {
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

    public x c(long j2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public x d(y yVar) {
        View view = this.a.get();
        if (view != null) {
            e(view, yVar);
        }
        return this;
    }

    public final void e(View view, y yVar) {
        if (yVar != null) {
            view.animate().setListener(new a(this, yVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public x f(a0 a0Var) {
        View view = this.a.get();
        if (view != null) {
            b bVar = null;
            if (a0Var != null) {
                bVar = new b(this, a0Var, view);
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }

    public x g(float f2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }
}
