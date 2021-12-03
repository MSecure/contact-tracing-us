package f.b.a.a.a.s;

import android.content.DialogInterface;
import java.util.Objects;

public final /* synthetic */ class q4 implements DialogInterface.OnClickListener {
    public final /* synthetic */ q6 b;
    public final /* synthetic */ z4 c;

    public /* synthetic */ q4(q6 q6Var, z4 z4Var) {
        this.b = q6Var;
        this.c = z4Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        q6 q6Var = this.b;
        z4 z4Var = this.c;
        Objects.requireNonNull(q6Var);
        dialogInterface.cancel();
        q6Var.b0.f402g = -1;
        z4Var.a.b();
    }
}
