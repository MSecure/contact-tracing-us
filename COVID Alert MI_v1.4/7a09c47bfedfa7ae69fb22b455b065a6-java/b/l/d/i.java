package b.l.d;

import android.graphics.Rect;
import android.view.View;

public class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ r0 f2032b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f2033c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Rect f2034d;

    public i(c cVar, r0 r0Var, View view, Rect rect) {
        this.f2032b = r0Var;
        this.f2033c = view;
        this.f2034d = rect;
    }

    public void run() {
        this.f2032b.j(this.f2033c, this.f2034d);
    }
}
