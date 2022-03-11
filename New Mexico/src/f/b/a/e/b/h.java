package f.b.a.e.b;

import android.view.View;
import e.j.j.v;
/* loaded from: classes.dex */
public class h {
    public final View a;
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f2890d;

    /* renamed from: e  reason: collision with root package name */
    public int f2891e;

    public h(View view) {
        this.a = view;
    }

    public void a() {
        View view = this.a;
        v.o(view, this.f2890d - (view.getTop() - this.b));
        View view2 = this.a;
        v.n(view2, this.f2891e - (view2.getLeft() - this.c));
    }
}
