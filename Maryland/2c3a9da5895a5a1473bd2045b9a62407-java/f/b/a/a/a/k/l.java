package f.b.a.a.a.k;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import f.b.a.a.a.y.l0;
import gov.md.covid19.exposurenotifications.R;
import java.util.Collections;
import java.util.List;

public class l extends RecyclerView.e<a> {
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public List<l0> f2157d = Collections.emptyList();

    public class a extends RecyclerView.b0 {
        public final TextView t;

        public a(View view) {
            super(view);
            this.t = (TextView) view.findViewById(R.id.exposure_check_timestamp);
        }
    }

    public l(Context context) {
        this.c = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int c() {
        return this.f2157d.size();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$b0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void g(a aVar, int i2) {
        a aVar2 = aVar;
        aVar2.t.setText(DateUtils.getRelativeDateTimeString(l.this.c, this.f2157d.get(i2).a().E(), 86400000, 172800000, 0));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$b0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public a i(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_exposure_check, viewGroup, false));
    }
}
