package b.b.k;

import android.view.View;
import b.i.l.m;
import b.i.l.v;

public class j implements b.i.l.j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f396a;

    public j(i iVar) {
        this.f396a = iVar;
    }

    @Override // b.i.l.j
    public v a(View view, v vVar) {
        int e2 = vVar.e();
        int O = this.f396a.O(vVar, null);
        if (e2 != O) {
            vVar = vVar.i(vVar.c(), O, vVar.d(), vVar.b());
        }
        return m.I(view, vVar);
    }
}
