package e.m.a;

import android.graphics.Rect;
import android.view.View;

public class i implements Runnable {
    public final /* synthetic */ x0 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Rect f1616d;

    public i(d dVar, x0 x0Var, View view, Rect rect) {
        this.b = x0Var;
        this.c = view;
        this.f1616d = rect;
    }

    public void run() {
        this.b.j(this.c, this.f1616d);
    }
}
