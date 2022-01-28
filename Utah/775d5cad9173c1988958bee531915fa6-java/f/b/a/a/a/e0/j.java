package f.b.a.a.a.e0;

import android.content.DialogInterface;

public final /* synthetic */ class j implements DialogInterface.OnClickListener {
    public final /* synthetic */ d0 b;

    public /* synthetic */ j(d0 d0Var) {
        this.b = d0Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.b.X = false;
        dialogInterface.cancel();
    }
}
