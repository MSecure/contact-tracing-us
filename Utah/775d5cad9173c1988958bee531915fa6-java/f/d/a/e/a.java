package f.d.a.e;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mikepenz.aboutlibraries.R$id;
import com.mikepenz.aboutlibraries.R$layout;
import e.n.a.m;
import f.d.a.b;
import f.d.a.c;
import f.d.b.k;
import j.k.b.e;
import java.io.Serializable;
import java.util.Objects;

public class a extends m {
    public final c W = new c();

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        e.c(layoutInflater, "inflater");
        c cVar = this.W;
        Context context = layoutInflater.getContext();
        e.b(context, "inflater.context");
        Bundle bundle2 = this.f1727g;
        Objects.requireNonNull(cVar);
        e.c(context, "context");
        e.c(layoutInflater, "inflater");
        if (bundle2 == null) {
            return new View(context);
        }
        Serializable serializable = bundle2.getSerializable("data");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.mikepenz.aboutlibraries.LibsBuilder");
        cVar.c = (b) serializable;
        View inflate = layoutInflater.inflate(R$layout.fragment_opensource, viewGroup, false);
        e.b(inflate, "view");
        int id = inflate.getId();
        int i2 = R$id.cardListView;
        if (id == i2) {
            recyclerView = (RecyclerView) inflate;
        } else {
            View findViewById = inflate.findViewById(i2);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            recyclerView = (RecyclerView) findViewById;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        recyclerView.setItemAnimator(new e.t.a.c());
        f.d.b.p.a<k<?>> aVar = new f.d.b.p.a<>();
        cVar.b = aVar;
        e.c(aVar, "adapter");
        f.d.b.b<k<?>> bVar = new f.d.b.b<>();
        e.c(aVar, "adapter");
        bVar.c.add(0, aVar);
        aVar.f(bVar);
        int i3 = 0;
        for (T t : bVar.c) {
            int i4 = i3 + 1;
            if (i3 >= 0) {
                t.b(i3);
                i3 = i4;
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        bVar.m();
        cVar.a = bVar;
        recyclerView.setAdapter(bVar);
        if (cVar.c != null) {
            f.d.b.p.a<k<?>> aVar2 = cVar.b;
            if (aVar2 != null) {
                aVar2.e(new f.d.a.e.b.e());
                f.b.a.c.b.o.b.k0(recyclerView, 80, 8388611, 8388613);
                e.b(inflate, "view");
                return inflate;
            }
            e.e("itemAdapter");
            throw null;
        }
        e.e("builder");
        throw null;
    }

    @Override // e.n.a.m
    public void V() {
        c cVar = this.W;
        c.a aVar = cVar.f3770e;
        if (aVar != null) {
            aVar.cancel(true);
            cVar.f3770e = null;
        }
        this.D = true;
    }

    @Override // e.n.a.m
    public void k0(View view, Bundle bundle) {
        e.c(view, "view");
        c cVar = this.W;
        Objects.requireNonNull(cVar);
        e.c(view, "view");
        if (view.getContext() != null) {
            Context context = view.getContext();
            e.b(context, "view.context");
            Context applicationContext = context.getApplicationContext();
            e.b(applicationContext, "view.context.applicationContext");
            c.a aVar = new c.a(cVar, applicationContext);
            cVar.f3770e = aVar;
            if (cVar.c != null) {
                aVar.execute(new String[0]);
            }
        }
    }
}
