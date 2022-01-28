package f.b.a.a.a.v;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import f.b.a.a.a.l0.q0;
import f.b.a.a.a.s.a0;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class i extends RecyclerView.e<a> {
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final f.b.a.a.a.s.e0.a f2445d;

    /* renamed from: e  reason: collision with root package name */
    public List<q0> f2446e = Collections.emptyList();

    public class a extends RecyclerView.b0 {
        public final TextView t;

        public a(View view) {
            super(view);
            this.t = (TextView) view.findViewById(R.id.exposure_check_timestamp);
        }
    }

    public i(Context context, f.b.a.a.a.s.e0.a aVar) {
        this.c = context;
        this.f2445d = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int a() {
        return this.f2446e.size();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$b0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void e(a aVar, int i2) {
        a aVar2 = aVar;
        Objects.requireNonNull(aVar2);
        aVar2.t.setText(a0.a(this.f2446e.get(i2).a().G(), i.this.f2445d.c(), i.this.f2445d.b(), i.this.c));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$b0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public a g(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_exposure_check, viewGroup, false));
    }
}
