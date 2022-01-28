package f.b.a.a.a.s;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.i.b0;
import f.b.a.a.a.j.o0;
import gov.co.cdphe.exposurenotifications.R;
import java.text.DateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class z4 extends RecyclerView.e<b> {
    public final NotifyHomeViewModel c;

    /* renamed from: d  reason: collision with root package name */
    public final a f2400d;

    /* renamed from: e  reason: collision with root package name */
    public List<h0> f2401e = Collections.emptyList();

    public interface a {
    }

    public class b extends RecyclerView.b0 {
        public final View t;
        public final View u;
        public final o0 v;

        public b(o0 o0Var) {
            super(o0Var.a);
            LinearLayout linearLayout = o0Var.a;
            this.t = linearLayout;
            this.v = o0Var;
            this.u = linearLayout.findViewById(R.id.horizontal_divider_view);
        }
    }

    public z4(a aVar, NotifyHomeViewModel notifyHomeViewModel) {
        this.f2400d = aVar;
        this.c = notifyHomeViewModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int a() {
        return this.f2401e.size();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$b0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void e(b bVar, int i2) {
        int i3;
        Resources resources;
        b bVar2 = bVar;
        h0 h0Var = this.f2401e.get(i2);
        int i4 = 0;
        boolean z = i2 == a() - 1;
        bVar2.t.setOnClickListener(new c(bVar2, h0Var));
        h0.d n = h0Var.n();
        TextView textView = bVar2.v.c;
        f.b.a.a.a.i.e0.a aVar = a5.a;
        int i5 = R.string.test_result_type_confirmed;
        if (n == null) {
            a5.a.c("Unknown TestResult=null");
        } else {
            int ordinal = n.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    i5 = R.string.test_result_type_likely;
                } else if (ordinal == 2) {
                    i5 = R.string.test_result_type_negative;
                } else if (ordinal != 3) {
                    f.b.a.a.a.i.e0.a aVar2 = a5.a;
                    aVar2.c("Unknown TestResult=" + n);
                }
            }
        }
        textView.setText(i5);
        if (h0.c.SHARED.equals(h0Var.m())) {
            resources = bVar2.t.getResources();
            i3 = R.string.positive_test_result_status_shared;
        } else {
            resources = bVar2.t.getResources();
            i3 = R.string.positive_test_result_status_not_shared;
        }
        String string = resources.getString(i3);
        long i6 = h0Var.i();
        Locale locale = bVar2.t.getResources().getConfiguration().locale;
        f.b.a.a.a.i.e0.a aVar3 = b0.a;
        DateFormat dateInstance = DateFormat.getDateInstance(1, locale);
        dateInstance.setTimeZone(TimeZone.getTimeZone("UTC"));
        bVar2.v.b.setText(bVar2.t.getResources().getString(R.string.diagnosis_subtitle_template, string, dateInstance.format(Long.valueOf(i6))));
        View view = bVar2.u;
        if (z) {
            i4 = 8;
        }
        view.setVisibility(i4);
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$b0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public b g(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_diagnosis_entity, viewGroup, false);
        int i3 = R.id.diagnosis_shared_date;
        TextView textView = (TextView) inflate.findViewById(R.id.diagnosis_shared_date);
        if (textView != null) {
            i3 = R.id.diagnosis_type;
            TextView textView2 = (TextView) inflate.findViewById(R.id.diagnosis_type);
            if (textView2 != null) {
                return new b(new o0((LinearLayout) inflate, textView, textView2));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }
}
