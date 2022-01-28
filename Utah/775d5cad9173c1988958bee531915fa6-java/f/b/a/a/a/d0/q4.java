package f.b.a.a.a.d0;

import android.content.DialogInterface;
import java.util.Objects;

public final /* synthetic */ class q4 implements DialogInterface.OnClickListener {
    public final /* synthetic */ o6 b;
    public final /* synthetic */ z4 c;

    public /* synthetic */ q4(o6 o6Var, z4 z4Var) {
        this.b = o6Var;
        this.c = z4Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        o6 o6Var = this.b;
        z4 z4Var = this.c;
        Objects.requireNonNull(o6Var);
        dialogInterface.cancel();
        o6Var.c0.f398g = -1;
        z4Var.a.b();
    }
}
