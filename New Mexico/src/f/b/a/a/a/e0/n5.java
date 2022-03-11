package f.b.a.a.a.e0;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.o.a.r;
import f.b.a.a.a.e0.n5;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.t.m0;
import f.b.a.a.a.u.r0;
import f.b.a.a.a.x.z0;
import f.b.a.c.b.o.b;
import gov.nm.covid19.exposurenotifications.R;
import java.text.DateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class n5 extends RecyclerView.e<b> {
    public final NotifyHomeViewModel c;

    /* renamed from: d */
    public final a f2231d;

    /* renamed from: e */
    public List<j0> f2232e = Collections.emptyList();

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public class b extends RecyclerView.b0 {
        public final View t;
        public final View u;
        public final r0 v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(r0 r0Var) {
            super(r0Var.a);
            n5.this = r1;
            LinearLayout linearLayout = r0Var.a;
            this.t = linearLayout;
            this.v = r0Var;
            this.u = linearLayout.findViewById(R.id.horizontal_divider_view);
        }
    }

    public n5(a aVar, NotifyHomeViewModel notifyHomeViewModel) {
        this.f2231d = aVar;
        this.c = notifyHomeViewModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int a() {
        return this.f2232e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void e(RecyclerView.b0 b0Var, int i2) {
        int i3;
        Resources resources;
        b bVar = (b) b0Var;
        j0 j0Var = this.f2232e.get(i2);
        int i4 = 0;
        boolean z = i2 == a() - 1;
        bVar.t.setOnClickListener(new View.OnClickListener(j0Var) { // from class: f.b.a.a.a.e0.c
            public final /* synthetic */ j0 c;

            {
                this.c = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n5.b bVar2 = n5.b.this;
                j0 j0Var2 = this.c;
                c7 c7Var = ((f5) n5.this.f2231d).a;
                c7Var.v0();
                Bundle bundle = new Bundle();
                bundle.putLong("ShareDiagnosisFragment.EXTRA_DIAGNOSIS_ID", j0Var2.e());
                bundle.putString("ShareDiagnosisFragment.EXTRA_STEP", (j0.c.SHARED.equals(j0Var2.m()) ? ShareDiagnosisViewModel.b.VIEW : ShareDiagnosisViewModel.b.UPLOAD).name());
                l6 l6Var = new l6();
                l6Var.A0(bundle);
                r u0 = c7Var.u0();
                b.o(u0 instanceof z0);
                ((z0) u0).B(l6Var);
            }
        });
        j0.d n = j0Var.n();
        TextView textView = bVar.v.c;
        f.b.a.a.a.t.p0.a aVar = o5.a;
        int i5 = R.string.test_result_type_confirmed;
        if (n == null) {
            o5.a.c("Unknown TestResult=null");
        } else {
            int ordinal = n.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    i5 = R.string.test_result_type_likely;
                } else if (ordinal == 2) {
                    i5 = R.string.test_result_type_negative;
                } else if (ordinal != 3) {
                    f.b.a.a.a.t.p0.a aVar2 = o5.a;
                    aVar2.c("Unknown TestResult=" + n);
                }
            }
        }
        textView.setText(i5);
        if (j0.c.SHARED.equals(j0Var.m())) {
            resources = bVar.t.getResources();
            i3 = R.string.positive_test_result_status_shared;
        } else {
            resources = bVar.t.getResources();
            i3 = R.string.positive_test_result_status_not_shared;
        }
        String string = resources.getString(i3);
        long i6 = j0Var.i();
        Locale locale = bVar.t.getResources().getConfiguration().locale;
        f.b.a.a.a.t.p0.a aVar3 = m0.a;
        DateFormat dateInstance = DateFormat.getDateInstance(1, locale);
        dateInstance.setTimeZone(TimeZone.getTimeZone("UTC"));
        bVar.v.b.setText(bVar.t.getResources().getString(R.string.diagnosis_subtitle_template, string, dateInstance.format(Long.valueOf(i6))));
        View view = bVar.u;
        if (z) {
            i4 = 8;
        }
        view.setVisibility(i4);
    }

    public RecyclerView.b0 g(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_diagnosis_entity, viewGroup, false);
        int i3 = R.id.diagnosis_shared_date;
        TextView textView = (TextView) inflate.findViewById(R.id.diagnosis_shared_date);
        if (textView != null) {
            i3 = R.id.diagnosis_type;
            TextView textView2 = (TextView) inflate.findViewById(R.id.diagnosis_type);
            if (textView2 != null) {
                return new b(new r0((LinearLayout) inflate, textView, textView2));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }
}
