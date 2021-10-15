package c.b.a.b.x;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import c.b.a.b.x.g;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import java.util.Iterator;

public class u implements AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f4621b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ v f4622c;

    public u(v vVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f4622c = vVar;
        this.f4621b = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        t a2 = this.f4621b.getAdapter();
        if (i >= a2.a() && i <= a2.c()) {
            g.f fVar = this.f4622c.f4625c;
            long longValue = this.f4621b.getAdapter().getItem(i).longValue();
            g.d dVar = (g.d) fVar;
            if (g.this.f4576e.f4542e.k(longValue)) {
                g.this.f4575d.n(longValue);
                Iterator<w<S>> it = g.this.f4629b.iterator();
                while (it.hasNext()) {
                    it.next().a(g.this.f4575d.b());
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
