package f.b.a.e.x;

import android.view.View;
import android.widget.AdapterView;
import e.b.f.k0;

public class o implements AdapterView.OnItemClickListener {
    public final /* synthetic */ p b;

    public o(p pVar) {
        this.b = pVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Object obj;
        p pVar = this.b;
        if (i2 < 0) {
            k0 k0Var = pVar.f3048e;
            obj = !k0Var.c() ? null : k0Var.f902d.getSelectedItem();
        } else {
            obj = pVar.getAdapter().getItem(i2);
        }
        p.a(this.b, obj);
        AdapterView.OnItemClickListener onItemClickListener = this.b.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i2 < 0) {
                k0 k0Var2 = this.b.f3048e;
                view = !k0Var2.c() ? null : k0Var2.f902d.getSelectedView();
                k0 k0Var3 = this.b.f3048e;
                i2 = !k0Var3.c() ? -1 : k0Var3.f902d.getSelectedItemPosition();
                k0 k0Var4 = this.b.f3048e;
                j2 = !k0Var4.c() ? Long.MIN_VALUE : k0Var4.f902d.getSelectedItemId();
            }
            onItemClickListener.onItemClick(this.b.f3048e.f902d, view, i2, j2);
        }
        this.b.f3048e.dismiss();
    }
}
