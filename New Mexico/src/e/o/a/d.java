package e.o.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import e.o.a.a1;
import e.o.a.c;
/* loaded from: classes.dex */
public class d extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a1.d f1771d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ c.b f1772e;

    public d(c cVar, ViewGroup viewGroup, View view, boolean z, a1.d dVar, c.b bVar) {
        this.a = viewGroup;
        this.b = view;
        this.c = z;
        this.f1771d = dVar;
        this.f1772e = bVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.b);
        if (this.c) {
            this.f1771d.a.a(this.b);
        }
        this.f1772e.a();
    }
}
