package e.b.e.i;

import android.content.Context;
import android.view.LayoutInflater;
import e.b.e.i.m;
/* loaded from: classes.dex */
public abstract class b implements m {
    public Context b;
    public Context c;

    /* renamed from: d  reason: collision with root package name */
    public g f826d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f827e;

    /* renamed from: f  reason: collision with root package name */
    public m.a f828f;

    /* renamed from: g  reason: collision with root package name */
    public int f829g;

    /* renamed from: h  reason: collision with root package name */
    public int f830h;

    /* renamed from: i  reason: collision with root package name */
    public n f831i;

    public b(Context context, int i2, int i3) {
        this.b = context;
        this.f827e = LayoutInflater.from(context);
        this.f829g = i2;
        this.f830h = i3;
    }

    @Override // e.b.e.i.m
    public boolean f(g gVar, i iVar) {
        return false;
    }

    @Override // e.b.e.i.m
    public boolean g(g gVar, i iVar) {
        return false;
    }

    @Override // e.b.e.i.m
    public void h(m.a aVar) {
        this.f828f = aVar;
    }
}
