package e.b.e.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import e.b.e.i.n;
import java.util.ArrayList;

public class f extends BaseAdapter {
    public g b;
    public int c = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f786d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f787e;

    /* renamed from: f  reason: collision with root package name */
    public final LayoutInflater f788f;

    /* renamed from: g  reason: collision with root package name */
    public final int f789g;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f787e = z;
        this.f788f = layoutInflater;
        this.b = gVar;
        this.f789g = i2;
        a();
    }

    public void a() {
        g gVar = this.b;
        i iVar = gVar.v;
        if (iVar != null) {
            gVar.i();
            ArrayList<i> arrayList = gVar.f796j;
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
        if (this.f787e) {
            g gVar = this.b;
            gVar.i();
            arrayList = gVar.f796j;
        } else {
            arrayList = this.b.l();
        }
        int i3 = this.c;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return arrayList.get(i2);
    }

    public int getCount() {
        ArrayList<i> arrayList;
        if (this.f787e) {
            g gVar = this.b;
            gVar.i();
            arrayList = gVar.f796j;
        } else {
            arrayList = this.b.l();
        }
        int i2 = this.c;
        int size = arrayList.size();
        return i2 < 0 ? size : size - 1;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f788f.inflate(this.f789g, viewGroup, false);
        }
        int i3 = getItem(i2).b;
        int i4 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.b.m() && i3 != (i4 >= 0 ? getItem(i4).b : i3));
        n.a aVar = (n.a) view;
        if (this.f786d) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i2), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
