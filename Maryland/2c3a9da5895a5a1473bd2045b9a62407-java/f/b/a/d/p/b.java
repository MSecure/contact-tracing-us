package f.b.a.d.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.b.a.d.p.d;

public class b extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ d.f c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ d f2763d;

    public b(d dVar, boolean z, d.f fVar) {
        this.f2763d = dVar;
        this.b = z;
        this.c = fVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    public void onAnimationEnd(Animator animator) {
        d dVar = this.f2763d;
        dVar.o = 0;
        dVar.f2770j = null;
        if (!this.a) {
            FloatingActionButton floatingActionButton = dVar.s;
            boolean z = this.b;
            floatingActionButton.b(z ? 8 : 4, z);
            d.f fVar = this.c;
            if (fVar != null) {
                a aVar = (a) fVar;
                aVar.a.a(aVar.b);
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f2763d.s.b(0, this.b);
        d dVar = this.f2763d;
        dVar.o = 1;
        dVar.f2770j = animator;
        this.a = false;
    }
}
