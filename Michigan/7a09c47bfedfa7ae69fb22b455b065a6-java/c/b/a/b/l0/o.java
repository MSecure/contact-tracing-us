package c.b.a.b.l0;

import android.view.View;
import android.widget.AdapterView;
import b.b.q.k0;

public class o implements AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f4399b;

    public o(p pVar) {
        this.f4399b = pVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object obj;
        p pVar = this.f4399b;
        if (i < 0) {
            k0 k0Var = pVar.f4400e;
            obj = !k0Var.c() ? null : k0Var.f879d.getSelectedItem();
        } else {
            obj = pVar.getAdapter().getItem(i);
        }
        p.a(this.f4399b, obj);
        AdapterView.OnItemClickListener onItemClickListener = this.f4399b.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i < 0) {
                k0 k0Var2 = this.f4399b.f4400e;
                view = !k0Var2.c() ? null : k0Var2.f879d.getSelectedView();
                k0 k0Var3 = this.f4399b.f4400e;
                i = !k0Var3.c() ? -1 : k0Var3.f879d.getSelectedItemPosition();
                k0 k0Var4 = this.f4399b.f4400e;
                j = !k0Var4.c() ? Long.MIN_VALUE : k0Var4.f879d.getSelectedItemId();
            }
            onItemClickListener.onItemClick(this.f4399b.f4400e.f879d, view, i, j);
        }
        this.f4399b.f4400e.dismiss();
    }
}
