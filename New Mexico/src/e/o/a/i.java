package e.o.a;

import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public class i implements Runnable {
    public final /* synthetic */ v0 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Rect f1797d;

    public i(c cVar, v0 v0Var, View view, Rect rect) {
        this.b = v0Var;
        this.c = view;
        this.f1797d = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.j(this.c, this.f1797d);
    }
}
