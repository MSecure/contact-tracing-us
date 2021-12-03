package f.b.a.e.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.b.a.e.p.d;

public class b extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ d.g c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ d f2926d;

    public b(d dVar, boolean z, d.g gVar) {
        this.f2926d = dVar;
        this.b = z;
        this.c = gVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    public void onAnimationEnd(Animator animator) {
        d dVar = this.f2926d;
        dVar.m = 0;
        dVar.f2931h = null;
        if (!this.a) {
            FloatingActionButton floatingActionButton = dVar.q;
            boolean z = this.b;
            floatingActionButton.b(z ? 8 : 4, z);
            d.g gVar = this.c;
            if (gVar != null) {
                a aVar = (a) gVar;
                aVar.a.a(aVar.b);
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f2926d.q.b(0, this.b);
        d dVar = this.f2926d;
        dVar.m = 1;
        dVar.f2931h = animator;
        this.a = false;
    }
}
