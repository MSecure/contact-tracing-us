package e.m.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import e.i.e.a;
import e.m.a.z0;

public class f extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ z0.d c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f1587d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d f1588e;

    public f(d dVar, ViewGroup viewGroup, View view, z0.d dVar2, a aVar) {
        this.f1588e = dVar;
        this.a = viewGroup;
        this.b = view;
        this.c = dVar2;
        this.f1587d = aVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.b);
        this.f1588e.j(this.c, this.f1587d);
    }
}
