package b.b.k;

import android.view.View;
import b.i.l.m;
import b.i.l.v;

public class j implements b.i.l.j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f552a;

    public j(i iVar) {
        this.f552a = iVar;
    }

    @Override // b.i.l.j
    public v a(View view, v vVar) {
        int d2 = vVar.d();
        int O = this.f552a.O(vVar, null);
        if (d2 != O) {
            vVar = vVar.h(vVar.b(), O, vVar.c(), vVar.a());
        }
        return m.J(view, vVar);
    }
}
