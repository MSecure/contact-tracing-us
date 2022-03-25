package e.m.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import e.i.e.a;
import e.m.a.c1;

public class f extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ c1.d c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f1602d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d f1603e;

    public f(d dVar, ViewGroup viewGroup, View view, c1.d dVar2, a aVar) {
        this.f1603e = dVar;
        this.a = viewGroup;
        this.b = view;
        this.c = dVar2;
        this.f1602d = aVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.b);
        this.f1603e.j(this.c, this.f1602d);
    }
}
