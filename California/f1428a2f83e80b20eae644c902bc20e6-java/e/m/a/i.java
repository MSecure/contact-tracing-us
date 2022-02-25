package e.m.a;

import android.graphics.Rect;
import android.view.View;

public class i implements Runnable {
    public final /* synthetic */ u0 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Rect f1603d;

    public i(d dVar, u0 u0Var, View view, Rect rect) {
        this.b = u0Var;
        this.c = view;
        this.f1603d = rect;
    }

    public void run() {
        this.b.j(this.c, this.f1603d);
    }
}
