package f.b.a.a.a.t;

import android.content.DialogInterface;

public final /* synthetic */ class h implements DialogInterface.OnClickListener {
    public final /* synthetic */ b0 b;

    public /* synthetic */ h(b0 b0Var) {
        this.b = b0Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.b.Y = false;
        dialogInterface.cancel();
    }
}
