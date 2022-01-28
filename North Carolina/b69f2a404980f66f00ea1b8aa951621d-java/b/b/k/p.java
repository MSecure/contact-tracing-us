package b.b.k;

import android.app.Dialog;
import android.os.Bundle;
import b.l.d.c;

public class p extends c {
    @Override // b.l.d.c
    public Dialog onCreateDialog(Bundle bundle) {
        return new o(getContext(), getTheme());
    }

    @Override // b.l.d.c
    public void setupDialog(Dialog dialog, int i) {
        if (dialog instanceof o) {
            o oVar = (o) dialog;
            if (!(i == 1 || i == 2)) {
                if (i == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            oVar.c(1);
            return;
        }
        super.setupDialog(dialog, i);
    }
}
