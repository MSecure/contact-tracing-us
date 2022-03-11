package f.d.a.e.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.aboutlibraries.R$id;
import com.mikepenz.aboutlibraries.R$layout;
/* loaded from: classes.dex */
public final class e extends f.d.b.q.a<a> {

    /* loaded from: classes.dex */
    public static final class a extends RecyclerView.b0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            j.k.b.e.c(view, "headerView");
        }
    }

    @Override // f.d.b.k
    public int h() {
        return R$id.loader_item_id;
    }

    @Override // f.d.b.q.a
    public int k() {
        return R$layout.listloader_opensource;
    }

    @Override // f.d.b.q.a
    public a l(View view) {
        j.k.b.e.c(view, "v");
        return new a(view);
    }
}
