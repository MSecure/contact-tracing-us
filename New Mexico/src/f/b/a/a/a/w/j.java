package f.b.a.a.a.w;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import f.b.a.a.a.n0.u0;
import f.b.a.a.a.t.m0;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
/*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
    java.lang.UnsupportedOperationException
    	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
    	at java.util.AbstractList.equals(AbstractList.java:519)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
    */
/* loaded from: classes.dex */
public class j extends RecyclerView.e<a> {
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final f.b.a.a.a.t.q0.a f2493d;

    /* renamed from: e  reason: collision with root package name */
    public List<u0> f2494e = Collections.emptyList();

    /* loaded from: classes.dex */
    public class a extends RecyclerView.b0 {
        public final TextView t;

        public a(View view) {
            super(view);
            this.t = (TextView) view.findViewById(R.id.exposure_check_timestamp);
        }
    }

    public j(Context context, f.b.a.a.a.t.q0.a aVar) {
        this.c = context;
        this.f2493d = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int a() {
        return this.f2494e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void e(RecyclerView.b0 b0Var, int i2) {
        a aVar = (a) b0Var;
        Objects.requireNonNull(aVar);
        aVar.t.setText(m0.a(this.f2494e.get(i2).a().G(), j.this.f2493d.c(), j.this.f2493d.b(), j.this.c));
    }

    public RecyclerView.b0 g(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_exposure_check, viewGroup, false));
    }
}
