package f.b.a.a.a.k;

import android.view.View;
import android.widget.TextView;
import java.util.Objects;

public final /* synthetic */ class i implements View.OnClickListener {
    public final /* synthetic */ n b;

    public /* synthetic */ i(n nVar) {
        this.b = nVar;
    }

    public final void onClick(View view) {
        n nVar = this.b;
        Objects.requireNonNull(nVar);
        nVar.z0(((TextView) view).getText().toString());
    }
}
