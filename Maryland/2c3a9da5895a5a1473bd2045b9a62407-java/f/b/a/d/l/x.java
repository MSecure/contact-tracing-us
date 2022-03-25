package f.b.a.d.l;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
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
import e.i.i.m;
import e.i.i.q;
import f.b.a.d.l.i;
import java.util.concurrent.atomic.AtomicInteger;

public class x extends RecyclerView.e<a> {
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final a f2752d;

    /* renamed from: e  reason: collision with root package name */
    public final f<?> f2753e;

    /* renamed from: f  reason: collision with root package name */
    public final i.f f2754f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2755g;

    public static class a extends RecyclerView.b0 {
        public final TextView t;
        public final MaterialCalendarGridView u;

        public a(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
            this.t = textView;
            AtomicInteger atomicInteger = m.a;
            q qVar = new q(androidx.core.R$id.tag_accessibility_heading, Boolean.class, 28);
            Boolean bool = Boolean.TRUE;
            if (Build.VERSION.SDK_INT >= 28) {
                qVar.d(textView, bool);
            } else if (qVar.e(qVar.c(textView), bool)) {
                e.i.i.a f2 = m.f(textView);
                m.r(textView, f2 == null ? new e.i.i.a() : f2);
                textView.setTag(qVar.a, bool);
                m.k(textView, qVar.f1484d);
            }
            this.u = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (!z) {
                textView.setVisibility(8);
            }
        }
    }

    public x(Context context, f<?> fVar, a aVar, i.f fVar2) {
        u uVar = aVar.b;
        u uVar2 = aVar.c;
        u uVar3 = aVar.f2719e;
        if (uVar.compareTo(uVar3) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (uVar3.compareTo(uVar2) <= 0) {
            int i2 = v.f2748g;
            int i3 = i.i0;
            Resources resources = context.getResources();
            int i4 = R$dimen.mtrl_calendar_day_height;
            int dimensionPixelSize = i2 * resources.getDimensionPixelSize(i4);
            int dimensionPixelSize2 = q.D0(context) ? context.getResources().getDimensionPixelSize(i4) : 0;
            this.c = context;
            this.f2755g = dimensionPixelSize + dimensionPixelSize2;
            this.f2752d = aVar;
            this.f2753e = fVar;
            this.f2754f = fVar2;
            o(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int c() {
        return this.f2752d.f2721g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public long d(int i2) {
        return this.f2752d.b.v(i2).b.getTimeInMillis();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$b0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void g(a aVar, int i2) {
        a aVar2 = aVar;
        u v = this.f2752d.b.v(i2);
        aVar2.t.setText(v.u(aVar2.a.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aVar2.u.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !v.equals(materialCalendarGridView.getAdapter().b)) {
            v vVar = new v(v, this.f2753e, this.f2752d);
            materialCalendarGridView.setNumColumns(v.f2744e);
            materialCalendarGridView.setAdapter((ListAdapter) vVar);
        } else {
            materialCalendarGridView.invalidate();
            v a2 = materialCalendarGridView.getAdapter();
            for (Long l2 : a2.f2749d) {
                a2.f(materialCalendarGridView, l2.longValue());
            }
            f<?> fVar = a2.c;
            if (fVar != null) {
                for (Long l3 : fVar.m()) {
                    a2.f(materialCalendarGridView, l3.longValue());
                }
                a2.f2749d = a2.c.m();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new w(this, materialCalendarGridView));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$b0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public a i(ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!q.D0(viewGroup.getContext())) {
            return new a(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.n(-1, this.f2755g));
        return new a(linearLayout, true);
    }

    public u p(int i2) {
        return this.f2752d.b.v(i2);
    }

    public int q(u uVar) {
        return this.f2752d.b.w(uVar);
    }
}
