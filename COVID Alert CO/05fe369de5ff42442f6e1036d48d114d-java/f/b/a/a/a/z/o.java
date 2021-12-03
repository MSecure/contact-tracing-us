package f.b.a.a.a.z;

import android.content.DialogInterface;

public final /* synthetic */ class o implements DialogInterface.OnClickListener {
    public final /* synthetic */ p0 b;

    public /* synthetic */ o(p0 p0Var) {
        this.b = p0Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.b.d0 = false;
        dialogInterface.cancel();
    }
}
