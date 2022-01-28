package c.b.a.a.c.l;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;

public abstract class e implements DialogInterface.OnClickListener {
    public abstract void a();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            a();
        } catch (ActivityNotFoundException unused) {
        } finally {
            dialogInterface.dismiss();
        }
    }
}
