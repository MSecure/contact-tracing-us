package f.b.a.a.a.r;

import android.content.DialogInterface;
import java.util.Objects;

public final /* synthetic */ class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ q3 b;
    public final /* synthetic */ f3 c;

    public /* synthetic */ f(q3 q3Var, f3 f3Var) {
        this.b = q3Var;
        this.c = f3Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        q3 q3Var = this.b;
        f3 f3Var = this.c;
        Objects.requireNonNull(q3Var);
        dialogInterface.cancel();
        q3Var.c0.f384g = -1;
        f3Var.a.b();
    }
}
