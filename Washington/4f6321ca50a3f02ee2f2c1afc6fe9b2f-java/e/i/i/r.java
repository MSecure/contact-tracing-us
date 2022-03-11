package e.i.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import e.b.a.w;
import java.lang.ref.WeakReference;

public final class r {
    public WeakReference<View> a;
    public int b = -1;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ s a;
        public final /* synthetic */ View b;

        public a(r rVar, s sVar, View view) {
            this.a = sVar;
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
        public final /* synthetic */ u a;
        public final /* synthetic */ View b;

        public b(r rVar, u uVar, View view) {
            this.a = uVar;
            this.b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((View) w.this.f695d.getParent()).invalidate();
        }
    }

    public r(View view) {
        this.a = new WeakReference<>(view);
    }

    public r a(float f2) {
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

    public r c(long j2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public r d(s sVar) {
        View view = this.a.get();
        if (view != null) {
            e(view, sVar);
        }
        return this;
    }

    public final void e(View view, s sVar) {
        if (sVar != null) {
            view.animate().setListener(new a(this, sVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public r f(u uVar) {
        View view = this.a.get();
        if (view != null) {
            b bVar = null;
            if (uVar != null) {
                bVar = new b(this, uVar, view);
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }

    public r g(float f2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }
}
