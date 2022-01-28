package b.b.p.i;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.view.menu.ExpandedMenuView;
import b.b.g;
import b.b.k.e;
import b.b.p.i.m;
import b.b.p.i.n;
import java.util.ArrayList;

public class e implements m, AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public Context f530b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f531c;

    /* renamed from: d  reason: collision with root package name */
    public g f532d;

    /* renamed from: e  reason: collision with root package name */
    public ExpandedMenuView f533e;
    public int f;
    public int g = 0;
    public int h;
    public m.a i;
    public a j;

    public class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public int f534b = -1;

        public a() {
            a();
        }

        public void a() {
            g gVar = e.this.f532d;
            i iVar = gVar.w;
            if (iVar != null) {
                gVar.i();
                ArrayList<i> arrayList = gVar.j;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    if (arrayList.get(i) == iVar) {
                        this.f534b = i;
                        return;
                    }
                }
            }
            this.f534b = -1;
        }

        /* renamed from: b */
        public i getItem(int i) {
            g gVar = e.this.f532d;
            gVar.i();
            ArrayList<i> arrayList = gVar.j;
            int i2 = i + e.this.f;
            int i3 = this.f534b;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return arrayList.get(i2);
        }

        public int getCount() {
            g gVar = e.this.f532d;
            gVar.i();
            int size = gVar.j.size() - e.this.f;
            return this.f534b < 0 ? size : size - 1;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f531c.inflate(eVar.h, viewGroup, false);
            }
            ((n.a) view).e(getItem(i), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i2) {
        this.h = i2;
        this.f530b = context;
        this.f531c = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.j == null) {
            this.j = new a();
        }
        return this.j;
    }

    @Override // b.b.p.i.m
    public void b(g gVar, boolean z) {
        m.a aVar = this.i;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    @Override // b.b.p.i.m
    public boolean d() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Override // b.b.p.i.m
    public void e(Context context, g gVar) {
        a aVar;
        LayoutInflater layoutInflater;
        if (this.g != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.g);
            this.f530b = contextThemeWrapper;
            layoutInflater = LayoutInflater.from(contextThemeWrapper);
        } else {
            if (this.f530b != null) {
                this.f530b = context;
                if (this.f531c == null) {
                    layoutInflater = LayoutInflater.from(context);
                }
            }
            this.f532d = gVar;
            aVar = this.j;
            if (aVar == null) {
                aVar.notifyDataSetChanged();
                return;
            }
            return;
        }
        this.f531c = layoutInflater;
        this.f532d = gVar;
        aVar = this.j;
        if (aVar == null) {
        }
    }

    @Override // b.b.p.i.m
    public boolean f(g gVar, i iVar) {
        return false;
    }

    @Override // b.b.p.i.m
    public boolean g(g gVar, i iVar) {
        return false;
    }

    @Override // b.b.p.i.m
    public void h(m.a aVar) {
        this.i = aVar;
    }

    @Override // b.b.p.i.m
    public boolean i(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        h hVar = new h(rVar);
        g gVar = hVar.f545b;
        e.a aVar = new e.a(gVar.f540a);
        e eVar = new e(aVar.f365a.f27a, g.abc_list_menu_item_layout);
        hVar.f547d = eVar;
        eVar.i = hVar;
        g gVar2 = hVar.f545b;
        gVar2.b(eVar, gVar2.f540a);
        ListAdapter a2 = hVar.f547d.a();
        AlertController.b bVar = aVar.f365a;
        bVar.q = a2;
        bVar.r = hVar;
        View view = gVar.o;
        if (view != null) {
            bVar.g = view;
        } else {
            bVar.f30d = gVar.n;
            bVar.f = gVar.m;
        }
        aVar.f365a.p = hVar;
        b.b.k.e a3 = aVar.a();
        hVar.f546c = a3;
        a3.setOnDismissListener(hVar);
        WindowManager.LayoutParams attributes = hVar.f546c.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        hVar.f546c.show();
        m.a aVar2 = this.i;
        if (aVar2 == null) {
            return true;
        }
        aVar2.c(rVar);
        return true;
    }

    @Override // b.b.p.i.m
    public void j(boolean z) {
        a aVar = this.j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f532d.s(this.j.getItem(i2), this, 0);
    }
}
