package b.l.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import b.l.d.c;
import b.l.d.w0;

public class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2000a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f2001b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f2002c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ w0.d f2003d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ c.b f2004e;

    public d(c cVar, ViewGroup viewGroup, View view, boolean z, w0.d dVar, c.b bVar) {
        this.f2000a = viewGroup;
        this.f2001b = view;
        this.f2002c = z;
        this.f2003d = dVar;
        this.f2004e = bVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2000a.endViewTransition(this.f2001b);
        if (this.f2002c) {
            this.f2003d.f2155a.b(this.f2001b);
        }
        this.f2004e.a();
    }
}
