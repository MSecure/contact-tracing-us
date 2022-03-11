package e.b.e.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import e.b.e.i.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    public g b;
    public int c = -1;

    /* renamed from: d */
    public boolean f848d;

    /* renamed from: e */
    public final boolean f849e;

    /* renamed from: f */
    public final LayoutInflater f850f;

    /* renamed from: g */
    public final int f851g;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f849e = z;
        this.f850f = layoutInflater;
        this.b = gVar;
        this.f851g = i2;
        a();
    }

    public void a() {
        g gVar = this.b;
        i iVar = gVar.v;
        if (iVar != null) {
            gVar.i();
            ArrayList<i> arrayList = gVar.f858j;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayList.get(i2) == iVar) {
                    this.c = i2;
                    return;
                }
            }
        }
        this.c = -1;
    }

    /* renamed from: b */
    public i getItem(int i2) {
        ArrayList<i> arrayList;
        if (this.f849e) {
            g gVar = this.b;
            gVar.i();
            arrayList = gVar.f858j;
        } else {
            arrayList = this.b.l();
        }
        int i3 = this.c;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return arrayList.get(i2);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<i> arrayList;
        if (this.f849e) {
            g gVar = this.b;
            gVar.i();
            arrayList = gVar.f858j;
        } else {
            arrayList = this.b.l();
        }
        int i2 = this.c;
        int size = arrayList.size();
        return i2 < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return (long) i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f850f.inflate(this.f851g, viewGroup, false);
        }
        int i3 = getItem(i2).b;
        int i4 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.b.m() && i3 != (i4 >= 0 ? getItem(i4).b : i3));
        n.a aVar = (n.a) view;
        if (this.f848d) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i2), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
