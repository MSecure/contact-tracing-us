package f.d.a.e.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.aboutlibraries.R$id;
import com.mikepenz.aboutlibraries.R$layout;

public final class e extends f.d.b.q.a<a> {

    public static final class a extends RecyclerView.b0 {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            j.j.b.e.c(view, "headerView");
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

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$b0' to match base method */
    @Override // f.d.b.q.a
    public a l(View view) {
        j.j.b.e.c(view, "v");
        return new a(view);
    }
}
