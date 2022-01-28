package c.b.a.b.l0;

import android.view.View;
import android.widget.AdapterView;
import b.b.q.k0;

public class o implements AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f3100b;

    public o(p pVar) {
        this.f3100b = pVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object obj;
        p pVar = this.f3100b;
        if (i < 0) {
            k0 k0Var = pVar.f3101e;
            obj = !k0Var.c() ? null : k0Var.f670d.getSelectedItem();
        } else {
            obj = pVar.getAdapter().getItem(i);
        }
        p.a(this.f3100b, obj);
        AdapterView.OnItemClickListener onItemClickListener = this.f3100b.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i < 0) {
                k0 k0Var2 = this.f3100b.f3101e;
                view = !k0Var2.c() ? null : k0Var2.f670d.getSelectedView();
                k0 k0Var3 = this.f3100b.f3101e;
                i = !k0Var3.c() ? -1 : k0Var3.f670d.getSelectedItemPosition();
                k0 k0Var4 = this.f3100b.f3101e;
                j = !k0Var4.c() ? Long.MIN_VALUE : k0Var4.f670d.getSelectedItemId();
            }
            onItemClickListener.onItemClick(this.f3100b.f3101e.f670d, view, i, j);
        }
        this.f3100b.f3101e.dismiss();
    }
}
