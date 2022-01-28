package c.b.a.b.n;

import android.view.View;
import b.i.l.m;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final View f4460a;

    /* renamed from: b  reason: collision with root package name */
    public int f4461b;

    /* renamed from: c  reason: collision with root package name */
    public int f4462c;

    /* renamed from: d  reason: collision with root package name */
    public int f4463d;

    /* renamed from: e  reason: collision with root package name */
    public int f4464e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4465f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4466g = true;

    public h(View view) {
        this.f4460a = view;
    }

    public void a() {
        View view = this.f4460a;
        m.I(view, this.f4463d - (view.getTop() - this.f4461b));
        View view2 = this.f4460a;
        view2.offsetLeftAndRight(this.f4464e - (view2.getLeft() - this.f4462c));
    }
}
