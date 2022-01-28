package c.b.a.b.x;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.b.a.b.h;
import c.b.a.b.j;
import java.util.Calendar;
import java.util.Locale;

public class c0 extends RecyclerView.g<a> {

    /* renamed from: a  reason: collision with root package name */
    public final g<?> f3240a;

    public static class a extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f3241a;

        public a(TextView textView) {
            super(textView);
            this.f3241a = textView;
        }
    }

    public c0(g<?> gVar) {
        this.f3240a = gVar;
    }

    public int a(int i) {
        return i - this.f3240a.f3249e.f3218b.f3282e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f3240a.f3249e.f;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$d0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(a aVar, int i) {
        a aVar2 = aVar;
        int i2 = this.f3240a.f3249e.f3218b.f3282e + i;
        String string = aVar2.f3241a.getContext().getString(j.mtrl_picker_navigate_to_year_description);
        aVar2.f3241a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        aVar2.f3241a.setContentDescription(String.format(string, Integer.valueOf(i2)));
        c cVar = this.f3240a.h;
        Calendar f = a0.f();
        b bVar = f.get(1) == i2 ? cVar.f : cVar.f3238d;
        for (Long l : this.f3240a.f3248d.o()) {
            f.setTimeInMillis(l.longValue());
            if (f.get(1) == i2) {
                bVar = cVar.f3239e;
            }
        }
        bVar.b(aVar2.f3241a);
        aVar2.f3241a.setOnClickListener(new b0(this, i2));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$d0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.g
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(h.mtrl_calendar_year, viewGroup, false));
    }
}
