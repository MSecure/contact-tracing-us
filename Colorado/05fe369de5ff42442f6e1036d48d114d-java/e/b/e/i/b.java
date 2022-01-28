package e.b.e.i;

import android.content.Context;
import android.view.LayoutInflater;
import e.b.e.i.m;

public abstract class b implements m {
    public Context b;
    public Context c;

    /* renamed from: d  reason: collision with root package name */
    public g f754d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f755e;

    /* renamed from: f  reason: collision with root package name */
    public m.a f756f;

    /* renamed from: g  reason: collision with root package name */
    public int f757g;

    /* renamed from: h  reason: collision with root package name */
    public int f758h;

    /* renamed from: i  reason: collision with root package name */
    public n f759i;

    public b(Context context, int i2, int i3) {
        this.b = context;
        this.f755e = LayoutInflater.from(context);
        this.f757g = i2;
        this.f758h = i3;
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
        this.f756f = aVar;
    }
}
