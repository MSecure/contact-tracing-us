package f.b.a.e.l;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;

public class f0 extends RecyclerView.e<a> {
    public final i<?> c;

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
        return this.c.Z.f2881f;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$b0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void e(a aVar, int i2) {
        a aVar2 = aVar;
        int i3 = this.c.Z.b.f2904d + i2;
        String string = aVar2.t.getContext().getString(R$string.mtrl_picker_navigate_to_year_description);
        aVar2.t.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i3)));
        aVar2.t.setContentDescription(String.format(string, Integer.valueOf(i3)));
        c cVar = this.c.c0;
        Calendar f2 = d0.f();
        b bVar = f2.get(1) == i3 ? cVar.f2893f : cVar.f2891d;
        for (Long l2 : this.c.Y.m()) {
            f2.setTimeInMillis(l2.longValue());
            if (f2.get(1) == i3) {
                bVar = cVar.f2892e;
            }
        }
        bVar.b(aVar2.t);
        aVar2.t.setOnClickListener(new e0(this, i3));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$b0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public a g(ViewGroup viewGroup, int i2) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }

    public int m(int i2) {
        return i2 - this.c.Z.b.f2904d;
    }
}
