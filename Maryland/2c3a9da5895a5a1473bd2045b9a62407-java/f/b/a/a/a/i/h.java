package f.b.a.a.a.i;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import e.z.a;

public final class h implements a {
    public final LinearLayout a;
    public final ImageButton b;
    public final RecyclerView c;

    public h(LinearLayout linearLayout, ImageButton imageButton, RecyclerView recyclerView) {
        this.a = linearLayout;
        this.b = imageButton;
        this.c = recyclerView;
    }

    @Override // e.z.a
    public View a() {
        return this.a;
    }
}
