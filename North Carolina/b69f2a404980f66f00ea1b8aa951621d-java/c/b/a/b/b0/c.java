package c.b.a.b.b0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.b.a.b.b0.e;

public class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2902a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f2903b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e.f f2904c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f2905d;

    public c(e eVar, boolean z, e.f fVar) {
        this.f2905d = eVar;
        this.f2903b = z;
        this.f2904c = fVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f2902a = true;
    }

    public void onAnimationEnd(Animator animator) {
        e eVar = this.f2905d;
        eVar.p = 0;
        eVar.k = null;
        if (!this.f2902a) {
            eVar.t.b(this.f2903b ? 8 : 4, this.f2903b);
            e.f fVar = this.f2904c;
            if (fVar != null) {
                b bVar = (b) fVar;
                bVar.f2900a.a(bVar.f2901b);
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f2905d.t.b(0, this.f2903b);
        e eVar = this.f2905d;
        eVar.p = 1;
        eVar.k = animator;
        this.f2902a = false;
    }
}
