package f.b.a.a.a.r;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import f.b.a.a.a.y.c0;
import gov.md.covid19.exposurenotifications.R;
import java.util.Collections;
import java.util.List;
import l.b.a.u.c;
import l.b.a.u.k;

public class f3 extends RecyclerView.e<b> {
    public List<c0> c = Collections.emptyList();

    /* renamed from: d  reason: collision with root package name */
    public NotifyHomeViewModel f2248d;

    /* renamed from: e  reason: collision with root package name */
    public final c f2249e = c.c(k.MEDIUM);

    /* renamed from: f  reason: collision with root package name */
    public final a f2250f;

    public interface a {
    }

    public class b extends RecyclerView.b0 {
        public final View t;
        public final TextView u;
        public final TextView v;
        public final ViewSwitcher w;
        public final View x;

        public b(View view) {
            super(view);
            this.t = view;
            this.u = (TextView) view.findViewById(R.id.diagnosis_type);
            this.v = (TextView) view.findViewById(R.id.diagnosis_date);
            this.w = (ViewSwitcher) view.findViewById(R.id.diagnosis_status);
            this.x = view.findViewById(R.id.horizontal_divider_view);
        }
    }

    public f3(a aVar, NotifyHomeViewModel notifyHomeViewModel) {
        this.f2250f = aVar;
        this.f2248d = notifyHomeViewModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int c() {
        return this.c.size();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$b0, int] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0092  */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void g(b bVar, int i2) {
        TextView textView;
        String str;
        b bVar2 = bVar;
        c0 c0Var = this.c.get(i2);
        boolean z = i2 == c() - 1;
        bVar2.t.setOnClickListener(new b(bVar2, c0Var));
        c0.d l2 = c0Var.l();
        int i3 = R.string.test_result_type_confirmed;
        if (l2 == null) {
            str = "Unknown TestResult=null";
        } else {
            int ordinal = l2.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    textView = bVar2.u;
                    i3 = R.string.test_result_type_likely;
                } else if (ordinal != 2) {
                    str = "Unknown TestResult=" + l2;
                } else {
                    textView = bVar2.u;
                    i3 = R.string.test_result_type_negative;
                }
                textView.setText(i3);
                if (c0Var.i() != null) {
                    bVar2.v.setText(f3.this.f2249e.b(c0Var.i()));
                    bVar2.v.setVisibility(0);
                } else {
                    bVar2.v.setVisibility(8);
                    bVar2.v.setText("");
                }
                if (z) {
                    bVar2.x.setVisibility(8);
                } else {
                    bVar2.x.setVisibility(0);
                }
                bVar2.w.setDisplayedChild(!c0.c.SHARED.equals(c0Var.k()));
            }
            textView = bVar2.u;
            textView.setText(i3);
            if (c0Var.i() != null) {
            }
            if (z) {
            }
            bVar2.w.setDisplayedChild(!c0.c.SHARED.equals(c0Var.k()));
        }
        Log.e("DiagnosisEntityAdapter", str);
        textView = bVar2.u;
        textView.setText(i3);
        if (c0Var.i() != null) {
        }
        if (z) {
        }
        bVar2.w.setDisplayedChild(!c0.c.SHARED.equals(c0Var.k()));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$b0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public b i(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_diagnosis_entity, viewGroup, false));
    }
}
