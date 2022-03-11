package f.b.a.d.l;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import f.b.a.d.l.i;
import java.util.Iterator;

public class w implements AdapterView.OnItemClickListener {
    public final /* synthetic */ MaterialCalendarGridView b;
    public final /* synthetic */ x c;

    public w(x xVar, MaterialCalendarGridView materialCalendarGridView) {
        this.c = xVar;
        this.b = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        v a = this.b.getAdapter();
        if (i2 >= a.b() && i2 <= a.d()) {
            i.f fVar = this.c.f2654f;
            long longValue = this.b.getAdapter().getItem(i2).longValue();
            i.d dVar = (i.d) fVar;
            if (i.this.Z.f2618d.f(longValue)) {
                i.this.Y.i(longValue);
                Iterator<y<S>> it = i.this.W.iterator();
                while (it.hasNext()) {
                    it.next().b(i.this.Y.a());
                }
                i.this.e0.getAdapter().a.b();
                RecyclerView recyclerView = i.this.d0;
                if (recyclerView != null) {
                    recyclerView.getAdapter().a.b();
                }
            }
        }
    }
}
