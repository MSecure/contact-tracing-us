package c.b.a.b.x;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import c.b.a.b.x.g;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import java.util.Iterator;

public class u implements AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f3287b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ v f3288c;

    public u(v vVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f3288c = vVar;
        this.f3287b = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        t a2 = this.f3287b.getAdapter();
        if (i >= a2.a() && i <= a2.c()) {
            g.f fVar = this.f3288c.f3291c;
            long longValue = this.f3287b.getAdapter().getItem(i).longValue();
            g.d dVar = (g.d) fVar;
            if (g.this.f3249e.f3221e.i(longValue)) {
                g.this.f3248d.l(longValue);
                Iterator<w<S>> it = g.this.f3295b.iterator();
                while (it.hasNext()) {
                    it.next().a(g.this.f3248d.b());
                }
                g.this.j.getAdapter().notifyDataSetChanged();
                RecyclerView recyclerView = g.this.i;
                if (recyclerView != null) {
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }
}
