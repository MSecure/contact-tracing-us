package f.b.a.d.z;

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
            k0 k0Var = pVar.f2859e;
            obj = !k0Var.c() ? null : k0Var.f908d.getSelectedItem();
        } else {
            obj = pVar.getAdapter().getItem(i2);
        }
        p.a(this.b, obj);
        AdapterView.OnItemClickListener onItemClickListener = this.b.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i2 < 0) {
                k0 k0Var2 = this.b.f2859e;
                view = !k0Var2.c() ? null : k0Var2.f908d.getSelectedView();
                k0 k0Var3 = this.b.f2859e;
                i2 = !k0Var3.c() ? -1 : k0Var3.f908d.getSelectedItemPosition();
                k0 k0Var4 = this.b.f2859e;
                j2 = !k0Var4.c() ? Long.MIN_VALUE : k0Var4.f908d.getSelectedItemId();
            }
            onItemClickListener.onItemClick(this.b.f2859e.f908d, view, i2, j2);
        }
        this.b.f2859e.dismiss();
    }
}
