package b.i.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import b.b.k.u;
import java.lang.ref.WeakReference;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<View> f1171a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f1172b = null;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f1173c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f1174d = -1;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f1175a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f1176b;

        public a(r rVar, s sVar, View view) {
            this.f1175a = sVar;
            this.f1176b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f1175a.c(this.f1176b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f1175a.a(this.f1176b);
        }

        public void onAnimationStart(Animator animator) {
            this.f1175a.b(this.f1176b);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ u f1177a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f1178b;

        public b(r rVar, u uVar, View view) {
            this.f1177a = uVar;
            this.f1178b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((View) u.this.f438d.getParent()).invalidate();
        }
    }

    public r(View view) {
        this.f1171a = new WeakReference<>(view);
    }

    public r a(float f) {
        View view = this.f1171a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public void b() {
        View view = this.f1171a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public r c(long j) {
        View view = this.f1171a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public r d(s sVar) {
        View view = this.f1171a.get();
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
        View view = this.f1171a.get();
        if (view != null) {
            b bVar = null;
            if (uVar != null) {
                bVar = new b(this, uVar, view);
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }

    public r g(float f) {
        View view = this.f1171a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }
}
