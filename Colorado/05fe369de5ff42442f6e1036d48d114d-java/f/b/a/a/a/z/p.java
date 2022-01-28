package f.b.a.a.a.z;

import android.content.DialogInterface;

public final /* synthetic */ class p implements DialogInterface.OnClickListener {
    public final /* synthetic */ p0 b;

    public /* synthetic */ p(p0 p0Var) {
        this.b = p0Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.b.c0 = false;
        dialogInterface.cancel();
    }
}
