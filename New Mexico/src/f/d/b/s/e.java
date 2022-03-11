package f.d.b.s;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.fastadapter.R$id;
import f.d.b.b;
import f.d.b.k;
import f.d.b.r.a;
import f.d.b.r.c;
import java.util.Objects;
/* loaded from: classes.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ c b;
    public final /* synthetic */ RecyclerView.b0 c;

    public e(c cVar, RecyclerView.b0 b0Var) {
        this.b = cVar;
        this.c = b0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int o;
        View view2;
        Object tag = this.c.a.getTag(R$id.fastadapter_item_adapter);
        k kVar = null;
        if (!(tag instanceof b)) {
            tag = null;
        }
        b bVar = (b) tag;
        if (bVar != null && (o = bVar.o(this.c)) != -1) {
            RecyclerView.b0 b0Var = this.c;
            Object tag2 = (b0Var == null || (view2 = b0Var.a) == null) ? null : view2.getTag(R$id.fastadapter_item);
            if (tag2 instanceof k) {
                kVar = tag2;
            }
            k kVar2 = kVar;
            if (kVar2 != null) {
                c cVar = this.b;
                Objects.requireNonNull(cVar, "null cannot be cast to non-null type com.mikepenz.fastadapter.listeners.ClickEventHook<Item>");
                j.k.b.e.b(view, "v");
                ((a) cVar).c(view, o, bVar, kVar2);
            }
        }
    }
}
