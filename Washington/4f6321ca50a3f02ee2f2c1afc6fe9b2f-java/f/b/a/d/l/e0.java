package f.b.a.d.l;

import android.view.View;
import f.b.a.d.l.i;

public class e0 implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ f0 c;

    public e0(f0 f0Var, int i2) {
        this.c = f0Var;
        this.b = i2;
    }

    public void onClick(View view) {
        u o = u.o(this.b, this.c.c.a0.c);
        a aVar = this.c.c.Z;
        if (o.compareTo(aVar.b) < 0) {
            o = aVar.b;
        } else if (o.compareTo(aVar.c) > 0) {
            o = aVar.c;
        }
        this.c.c.B0(o);
        this.c.c.C0(i.e.DAY);
    }
}
