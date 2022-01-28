package e.m.a;

import android.graphics.Rect;
import android.view.View;

public class i implements Runnable {
    public final /* synthetic */ v0 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Rect f1439d;

    public i(c cVar, v0 v0Var, View view, Rect rect) {
        this.b = v0Var;
        this.c = view;
        this.f1439d = rect;
    }

    public void run() {
        this.b.j(this.c, this.f1439d);
    }
}
