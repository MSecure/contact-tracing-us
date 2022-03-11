package f.b.a.e.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.b.a.e.p.d;
/* loaded from: classes.dex */
public class b extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ d.g c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ d f2968d;

    public b(d dVar, boolean z, d.g gVar) {
        this.f2968d = dVar;
        this.b = z;
        this.c = gVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        d dVar = this.f2968d;
        dVar.n = 0;
        dVar.f2973h = null;
        if (!this.a) {
            FloatingActionButton floatingActionButton = dVar.r;
            boolean z = this.b;
            floatingActionButton.b(z ? 8 : 4, z);
            d.g gVar = this.c;
            if (gVar != null) {
                a aVar = (a) gVar;
                aVar.a.a(aVar.b);
            }
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f2968d.r.b(0, this.b);
        d dVar = this.f2968d;
        dVar.n = 1;
        dVar.f2973h = animator;
        this.a = false;
    }
}
