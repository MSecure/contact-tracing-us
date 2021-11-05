package c.b.a.b.x;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.b.a.b.h;
import c.b.a.b.j;
import java.util.Calendar;
import java.util.Locale;

public class c0 extends RecyclerView.e<a> {

    /* renamed from: a  reason: collision with root package name */
    public final g<?> f4567a;

    public static class a extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f4568a;

        public a(TextView textView) {
            super(textView);
            this.f4568a = textView;
        }
    }

    public c0(g<?> gVar) {
        this.f4567a = gVar;
    }

    public int a(int i) {
        return i - this.f4567a.f4576e.f4539b.f4613e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.f4567a.f4576e.f4543f;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(a aVar, int i) {
        a aVar2 = aVar;
        int i2 = this.f4567a.f4576e.f4539b.f4613e + i;
        String string = aVar2.f4568a.getContext().getString(j.mtrl_picker_navigate_to_year_description);
        aVar2.f4568a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        aVar2.f4568a.setContentDescription(String.format(string, Integer.valueOf(i2)));
        c cVar = this.f4567a.h;
        Calendar f2 = a0.f();
        b bVar = f2.get(1) == i2 ? cVar.f4565f : cVar.f4563d;
        for (Long l : this.f4567a.f4575d.s()) {
            f2.setTimeInMillis(l.longValue());
            if (f2.get(1) == i2) {
                bVar = cVar.f4564e;
            }
        }
        bVar.b(aVar2.f4568a);
        aVar2.f4568a.setOnClickListener(new b0(this, i2));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(h.mtrl_calendar_year, viewGroup, false));
    }
}
