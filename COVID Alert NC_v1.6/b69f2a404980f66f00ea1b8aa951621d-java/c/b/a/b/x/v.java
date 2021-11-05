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

public class v extends RecyclerView.g<a> {

    /* renamed from: a  reason: collision with root package name */
    public final a f3289a;

    /* renamed from: b  reason: collision with root package name */
    public final d<?> f3290b;

    /* renamed from: c  reason: collision with root package name */
    public final g.f f3291c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3292d;

    public static class a extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f3293a;

        /* renamed from: b  reason: collision with root package name */
        public final MaterialCalendarGridView f3294b;

        public a(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(f.month_title);
            this.f3293a = textView;
            m.U(textView, true);
            this.f3294b = (MaterialCalendarGridView) linearLayout.findViewById(f.month_grid);
            if (!z) {
                this.f3293a.setVisibility(8);
            }
        }
    }

    public v(Context context, d<?> dVar, a aVar, g.f fVar) {
        s sVar = aVar.f3218b;
        s sVar2 = aVar.f3219c;
        s sVar3 = aVar.f3220d;
        if (sVar.compareTo(sVar3) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (sVar3.compareTo(sVar2) <= 0) {
            this.f3292d = (g.d(context) * t.f) + (o.f(context) ? context.getResources().getDimensionPixelSize(d.mtrl_calendar_day_height) : 0);
            this.f3289a = aVar;
            this.f3290b = dVar;
            this.f3291c = fVar;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    public s a(int i) {
        return this.f3289a.f3218b.v(i);
    }

    public int b(s sVar) {
        return this.f3289a.f3218b.w(sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f3289a.g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i) {
        return this.f3289a.f3218b.v(i).f3279b.getTimeInMillis();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$d0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(a aVar, int i) {
        a aVar2 = aVar;
        s v = this.f3289a.f3218b.v(i);
        aVar2.f3293a.setText(v.f3280c);
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aVar2.f3294b.findViewById(f.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !v.equals(materialCalendarGridView.getAdapter().f3283b)) {
            t tVar = new t(v, this.f3290b, this.f3289a);
            materialCalendarGridView.setNumColumns(v.f);
            materialCalendarGridView.setAdapter((ListAdapter) tVar);
        } else {
            materialCalendarGridView.getAdapter().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new u(this, materialCalendarGridView));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$d0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.g
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(h.mtrl_calendar_month_labeled, viewGroup, false);
        if (!o.f(viewGroup.getContext())) {
            return new a(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.p(-1, this.f3292d));
        return new a(linearLayout, true);
    }
}
