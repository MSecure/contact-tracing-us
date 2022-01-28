package c.b.a.b.x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.i.l.m;
import c.b.a.b.d;
import c.b.a.b.f;
import c.b.a.b.h;
import c.b.a.b.x.g;
import com.google.android.material.datepicker.MaterialCalendarGridView;

public class v extends RecyclerView.e<a> {

    /* renamed from: a  reason: collision with root package name */
    public final a f4623a;

    /* renamed from: b  reason: collision with root package name */
    public final d<?> f4624b;

    /* renamed from: c  reason: collision with root package name */
    public final g.f f4625c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4626d;

    public static class a extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f4627a;

        /* renamed from: b  reason: collision with root package name */
        public final MaterialCalendarGridView f4628b;

        public a(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(f.month_title);
            this.f4627a = textView;
            m.V(textView, true);
            this.f4628b = (MaterialCalendarGridView) linearLayout.findViewById(f.month_grid);
            if (!z) {
                this.f4627a.setVisibility(8);
            }
        }
    }

    public v(Context context, d<?> dVar, a aVar, g.f fVar) {
        s sVar = aVar.f4539b;
        s sVar2 = aVar.f4540c;
        s sVar3 = aVar.f4541d;
        if (sVar.compareTo(sVar3) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (sVar3.compareTo(sVar2) <= 0) {
            this.f4626d = (g.d(context) * t.f4616f) + (o.f(context) ? context.getResources().getDimensionPixelSize(d.mtrl_calendar_day_height) : 0);
            this.f4623a = aVar;
            this.f4624b = dVar;
            this.f4625c = fVar;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    public s a(int i) {
        return this.f4623a.f4539b.B(i);
    }

    public int b(s sVar) {
        return this.f4623a.f4539b.D(sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.f4623a.f4544g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public long getItemId(int i) {
        return this.f4623a.f4539b.B(i).f4610b.getTimeInMillis();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(a aVar, int i) {
        a aVar2 = aVar;
        s B = this.f4623a.f4539b.B(i);
        aVar2.f4627a.setText(B.f4611c);
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aVar2.f4628b.findViewById(f.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !B.equals(materialCalendarGridView.getAdapter().f4617b)) {
            t tVar = new t(B, this.f4624b, this.f4623a);
            materialCalendarGridView.setNumColumns(B.f4614f);
            materialCalendarGridView.setAdapter((ListAdapter) tVar);
        } else {
            materialCalendarGridView.getAdapter().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new u(this, materialCalendarGridView));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(h.mtrl_calendar_month_labeled, viewGroup, false);
        if (!o.f(viewGroup.getContext())) {
            return new a(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.n(-1, this.f4626d));
        return new a(linearLayout, true);
    }
}
