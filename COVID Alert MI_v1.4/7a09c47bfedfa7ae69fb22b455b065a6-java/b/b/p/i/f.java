package b.b.p.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import b.b.p.i.n;
import java.util.ArrayList;

public class f extends BaseAdapter {

    /* renamed from: b  reason: collision with root package name */
    public g f716b;

    /* renamed from: c  reason: collision with root package name */
    public int f717c = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f718d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f719e;

    /* renamed from: f  reason: collision with root package name */
    public final LayoutInflater f720f;

    /* renamed from: g  reason: collision with root package name */
    public final int f721g;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.f719e = z;
        this.f720f = layoutInflater;
        this.f716b = gVar;
        this.f721g = i;
        a();
    }

    public void a() {
        g gVar = this.f716b;
        i iVar = gVar.w;
        if (iVar != null) {
            gVar.i();
            ArrayList<i> arrayList = gVar.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i) == iVar) {
                    this.f717c = i;
                    return;
                }
            }
        }
        this.f717c = -1;
    }

    /* renamed from: b */
    public i getItem(int i) {
        ArrayList<i> arrayList;
        if (this.f719e) {
            g gVar = this.f716b;
            gVar.i();
            arrayList = gVar.j;
        } else {
            arrayList = this.f716b.l();
        }
        int i2 = this.f717c;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return arrayList.get(i);
    }

    public int getCount() {
        ArrayList<i> arrayList;
        if (this.f719e) {
            g gVar = this.f716b;
            gVar.i();
            arrayList = gVar.j;
        } else {
            arrayList = this.f716b.l();
        }
        int i = this.f717c;
        int size = arrayList.size();
        return i < 0 ? size : size - 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f720f.inflate(this.f721g, viewGroup, false);
        }
        int i2 = getItem(i).f733b;
        int i3 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f716b.m() && i2 != (i3 >= 0 ? getItem(i3).f733b : i2));
        n.a aVar = (n.a) view;
        if (this.f718d) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
