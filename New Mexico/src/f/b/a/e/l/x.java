package f.b.a.e.l;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import e.j.j.u;
import e.j.j.v;
import f.b.a.e.l.i;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class x extends RecyclerView.e<a> {
    public final Context c;

    /* renamed from: d */
    public final a f2955d;

    /* renamed from: e */
    public final f<?> f2956e;

    /* renamed from: f */
    public final i.f f2957f;

    /* renamed from: g */
    public final int f2958g;

    /* loaded from: classes.dex */
    public static class a extends RecyclerView.b0 {
        public final TextView t;
        public final MaterialCalendarGridView u;

        public a(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
            this.t = textView;
            AtomicInteger atomicInteger = v.a;
            new u(androidx.core.R$id.tag_accessibility_heading, Boolean.class, 28).e(textView, Boolean.TRUE);
            this.u = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (!z) {
                textView.setVisibility(8);
            }
        }
    }

    public x(Context context, f<?> fVar, a aVar, i.f fVar2) {
        u uVar = aVar.b;
        u uVar2 = aVar.c;
        u uVar3 = aVar.f2922e;
        if (uVar.compareTo(uVar3) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (uVar3.compareTo(uVar2) <= 0) {
            int i2 = v.f2951g;
            int i3 = i.h0;
            Resources resources = context.getResources();
            int i4 = R$dimen.mtrl_calendar_day_height;
            int dimensionPixelSize = i2 * resources.getDimensionPixelSize(i4);
            int dimensionPixelSize2 = q.N0(context) ? context.getResources().getDimensionPixelSize(i4) : 0;
            this.c = context;
            this.f2958g = dimensionPixelSize + dimensionPixelSize2;
            this.f2955d = aVar;
            this.f2956e = fVar;
            this.f2957f = fVar2;
            if (!this.a.a()) {
                this.b = true;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int a() {
        return this.f2955d.f2924g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public long b(int i2) {
        return this.f2955d.b.v(i2).b.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void e(RecyclerView.b0 b0Var, int i2) {
        a aVar = (a) b0Var;
        u v = this.f2955d.b.v(i2);
        aVar.t.setText(v.u(aVar.a.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aVar.u.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !v.equals(materialCalendarGridView.getAdapter().b)) {
            v vVar = new v(v, this.f2956e, this.f2955d);
            materialCalendarGridView.setNumColumns(v.f2947e);
            materialCalendarGridView.setAdapter((ListAdapter) vVar);
        } else {
            materialCalendarGridView.invalidate();
            v a2 = materialCalendarGridView.getAdapter();
            for (Long l2 : a2.f2952d) {
                a2.f(materialCalendarGridView, l2.longValue());
            }
            f<?> fVar = a2.c;
            if (fVar != null) {
                for (Long l3 : fVar.m()) {
                    a2.f(materialCalendarGridView, l3.longValue());
                }
                a2.f2952d = a2.c.m();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new w(this, materialCalendarGridView));
    }

    public RecyclerView.b0 g(ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!q.N0(viewGroup.getContext())) {
            return new a(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.n(-1, this.f2958g));
        return new a(linearLayout, true);
    }

    public u m(int i2) {
        return this.f2955d.b.v(i2);
    }

    public int n(u uVar) {
        return this.f2955d.b.w(uVar);
    }
}
