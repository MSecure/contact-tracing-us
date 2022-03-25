package f.b.a.a.a.j;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import e.b.a.m;

public final /* synthetic */ class b implements View.OnClickListener {
    public final /* synthetic */ j b;

    public /* synthetic */ b(j jVar) {
        this.b = jVar;
    }

    public final void onClick(View view) {
        Context k2 = this.b.k();
        Intent K = m.h.K(k2);
        if (K != null) {
            k2.startActivity(K);
            return;
        }
        throw new UnsupportedOperationException("This device does not support storage management");
    }
}
