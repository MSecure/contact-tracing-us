package f.b.a.e.l;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes.dex */
public class f0 extends RecyclerView.e<a> {
    public final i<?> c;

    /* loaded from: classes.dex */
    public static class a extends RecyclerView.b0 {
        public final TextView t;

        public a(TextView textView) {
            super(textView);
            this.t = textView;
        }
    }

    public f0(i<?> iVar) {
        this.c = iVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int a() {
        return this.c.Z.f2923f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void e(RecyclerView.b0 b0Var, int i2) {
        a aVar = (a) b0Var;
        int i3 = this.c.Z.b.f2946d + i2;
        String string = aVar.t.getContext().getString(R$string.mtrl_picker_navigate_to_year_description);
        aVar.t.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i3)));
        aVar.t.setContentDescription(String.format(string, Integer.valueOf(i3)));
        c cVar = this.c.c0;
        Calendar f2 = d0.f();
        b bVar = f2.get(1) == i3 ? cVar.f2935f : cVar.f2933d;
        for (Long l2 : this.c.Y.m()) {
            f2.setTimeInMillis(l2.longValue());
            if (f2.get(1) == i3) {
                bVar = cVar.f2934e;
            }
        }
        bVar.b(aVar.t);
        aVar.t.setOnClickListener(new e0(this, i3));
    }

    public RecyclerView.b0 g(ViewGroup viewGroup, int i2) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }

    public int m(int i2) {
        return i2 - this.c.Z.b.f2946d;
    }
}
