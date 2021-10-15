package c.b.a.b.b0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.b.a.b.b0.e;

public class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4163a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f4164b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e.f f4165c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f4166d;

    public c(e eVar, boolean z, e.f fVar) {
        this.f4166d = eVar;
        this.f4164b = z;
        this.f4165c = fVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f4163a = true;
    }

    public void onAnimationEnd(Animator animator) {
        e eVar = this.f4166d;
        eVar.p = 0;
        eVar.k = null;
        if (!this.f4163a) {
            eVar.t.b(this.f4164b ? 8 : 4, this.f4164b);
            e.f fVar = this.f4165c;
            if (fVar != null) {
                b bVar = (b) fVar;
                bVar.f4161a.a(bVar.f4162b);
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f4166d.t.b(0, this.f4164b);
        e eVar = this.f4166d;
        eVar.p = 1;
        eVar.k = animator;
        this.f4163a = false;
    }
}
