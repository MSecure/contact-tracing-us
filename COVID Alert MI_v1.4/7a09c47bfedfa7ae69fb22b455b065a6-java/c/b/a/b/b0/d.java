package c.b.a.b.b0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.b.a.b.b0.e;

public class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f4167a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e.f f4168b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f4169c;

    public d(e eVar, boolean z, e.f fVar) {
        this.f4169c = eVar;
        this.f4167a = z;
        this.f4168b = fVar;
    }

    public void onAnimationEnd(Animator animator) {
        e eVar = this.f4169c;
        eVar.p = 0;
        eVar.k = null;
        e.f fVar = this.f4168b;
        if (fVar != null) {
            b bVar = (b) fVar;
            bVar.f4161a.b(bVar.f4162b);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f4169c.t.b(0, this.f4167a);
        e eVar = this.f4169c;
        eVar.p = 2;
        eVar.k = animator;
    }
}
