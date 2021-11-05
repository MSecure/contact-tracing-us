package c.b.a.b.n;

import android.view.View;
import b.i.l.m;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public final View f3157a;

    /* renamed from: b  reason: collision with root package name */
    public int f3158b;

    /* renamed from: c  reason: collision with root package name */
    public int f3159c;

    /* renamed from: d  reason: collision with root package name */
    public int f3160d;

    /* renamed from: e  reason: collision with root package name */
    public int f3161e;
    public boolean f = true;
    public boolean g = true;

    public k(View view) {
        this.f3157a = view;
    }

    public void a() {
        View view = this.f3157a;
        m.H(view, this.f3160d - (view.getTop() - this.f3158b));
        View view2 = this.f3157a;
        view2.offsetLeftAndRight(this.f3161e - (view2.getLeft() - this.f3159c));
    }

    public boolean b(int i) {
        if (!this.f || this.f3160d == i) {
            return false;
        }
        this.f3160d = i;
        a();
        return true;
    }
}
