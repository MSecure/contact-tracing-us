package e.m.a;

import androidx.activity.result.ActivityResultRegistry;
import e.a.e.d;
import e.c.a.c.a;

public class m implements a<Void, ActivityResultRegistry> {
    public final /* synthetic */ l a;

    public m(l lVar) {
        this.a = lVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // e.c.a.c.a
    public ActivityResultRegistry a(Void r3) {
        l lVar = this.a;
        c0<?> c0Var = lVar.t;
        if (c0Var instanceof d) {
            return ((d) c0Var).f();
        }
        return lVar.m0().f7j;
    }
}
