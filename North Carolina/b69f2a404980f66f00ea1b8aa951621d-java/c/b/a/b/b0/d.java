package c.b.a.b.b0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.b.a.b.b0.e;

public class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f2906a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e.f f2907b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f2908c;

    public d(e eVar, boolean z, e.f fVar) {
        this.f2908c = eVar;
        this.f2906a = z;
        this.f2907b = fVar;
    }

    public void onAnimationEnd(Animator animator) {
        e eVar = this.f2908c;
        eVar.p = 0;
        eVar.k = null;
        e.f fVar = this.f2907b;
        if (fVar != null) {
            b bVar = (b) fVar;
            bVar.f2900a.b(bVar.f2901b);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f2908c.t.b(0, this.f2906a);
        e eVar = this.f2908c;
        eVar.p = 2;
        eVar.k = animator;
    }
}
