package e.m.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import e.m.a.a1;
import e.m.a.c;

public class d extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a1.d f1413d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ c.b f1414e;

    public d(c cVar, ViewGroup viewGroup, View view, boolean z, a1.d dVar, c.b bVar) {
        this.a = viewGroup;
        this.b = view;
        this.c = z;
        this.f1413d = dVar;
        this.f1414e = bVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.b);
        if (this.c) {
            this.f1413d.a.a(this.b);
        }
        this.f1414e.a();
    }
}
