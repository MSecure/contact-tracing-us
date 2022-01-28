package f.b.a.e.w;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;

public class o implements View.OnClickListener {
    public final /* synthetic */ View.OnClickListener b;
    public final /* synthetic */ Snackbar c;

    public o(Snackbar snackbar, View.OnClickListener onClickListener) {
        this.c = snackbar;
        this.b = onClickListener;
    }

    public void onClick(View view) {
        this.b.onClick(view);
        this.c.b(1);
    }
}
