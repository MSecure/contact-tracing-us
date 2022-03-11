package e.b.e.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.view.menu.ExpandedMenuView;
import e.b.a.g;
import e.b.e.i.m;
import e.b.e.i.n;
import java.util.ArrayList;
import java.util.Objects;
/* loaded from: classes.dex */
public class e implements m, AdapterView.OnItemClickListener {
    public Context b;
    public LayoutInflater c;

    /* renamed from: d */
    public g f843d;

    /* renamed from: e */
    public ExpandedMenuView f844e;

    /* renamed from: f */
    public int f845f;

    /* renamed from: g */
    public m.a f846g;

    /* renamed from: h */
    public a f847h;

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        public int b = -1;

        public a() {
            e.this = r1;
            a();
        }

        public void a() {
            g gVar = e.this.f843d;
            i iVar = gVar.v;
            if (iVar != null) {
                gVar.i();
                ArrayList<i> arrayList = gVar.f858j;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (arrayList.get(i2) == iVar) {
                        this.b = i2;
                        return;
                    }
                }
            }
            this.b = -1;
        }

        /* renamed from: b */
        public i getItem(int i2) {
            g gVar = e.this.f843d;
            gVar.i();
            ArrayList<i> arrayList = gVar.f858j;
            Objects.requireNonNull(e.this);
            int i3 = i2 + 0;
            int i4 = this.b;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return arrayList.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            g gVar = e.this.f843d;
            gVar.i();
            int size = gVar.f858j.size();
            Objects.requireNonNull(e.this);
            int i2 = size + 0;
            return this.b < 0 ? i2 : i2 - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return (long) i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.c.inflate(eVar.f845f, viewGroup, false);
            }
            ((n.a) view).d(getItem(i2), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i2) {
        this.f845f = i2;
        this.b = context;
        this.c = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f847h == null) {
            this.f847h = new a();
        }
        return this.f847h;
    }

    @Override // e.b.e.i.m
    public void b(g gVar, boolean z) {
        m.a aVar = this.f846g;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    @Override // e.b.e.i.m
    public boolean d() {
        return false;
    }

    @Override // e.b.e.i.m
    public void e(Context context, g gVar) {
        if (this.b != null) {
            this.b = context;
            if (this.c == null) {
                this.c = LayoutInflater.from(context);
            }
        }
        this.f843d = gVar;
        a aVar = this.f847h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // e.b.e.i.m
    public boolean f(g gVar, i iVar) {
        return false;
    }

    @Override // e.b.e.i.m
    public boolean g(g gVar, i iVar) {
        return false;
    }

    @Override // e.b.e.i.m
    public void h(m.a aVar) {
        this.f846g = aVar;
    }

    @Override // e.b.e.i.m
    public boolean i(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        h hVar = new h(rVar);
        g.a aVar = new g.a(rVar.a);
        e eVar = new e(aVar.a.a, R$layout.abc_list_menu_item_layout);
        hVar.f861d = eVar;
        eVar.f846g = hVar;
        g gVar = hVar.b;
        gVar.b(eVar, gVar.a);
        ListAdapter a2 = hVar.f861d.a();
        AlertController.b bVar = aVar.a;
        bVar.o = a2;
        bVar.p = hVar;
        View view = rVar.o;
        if (view != null) {
            bVar.f32e = view;
        } else {
            bVar.c = rVar.n;
            bVar.f31d = rVar.m;
        }
        bVar.n = hVar;
        g a3 = aVar.a();
        hVar.c = a3;
        a3.setOnDismissListener(hVar);
        WindowManager.LayoutParams attributes = hVar.c.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        hVar.c.show();
        m.a aVar2 = this.f846g;
        if (aVar2 == null) {
            return true;
        }
        aVar2.c(rVar);
        return true;
    }

    @Override // e.b.e.i.m
    public void j(boolean z) {
        a aVar = this.f847h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f843d.s(this.f847h.getItem(i2), this, 0);
    }
}
