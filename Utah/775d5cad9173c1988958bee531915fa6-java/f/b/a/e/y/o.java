package f.b.a.e.y;

import android.view.View;
import android.widget.AdapterView;
import e.b.f.o0;

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
            o0 o0Var = pVar.f3112f;
            obj = !o0Var.c() ? null : o0Var.f940d.getSelectedItem();
        } else {
            obj = pVar.getAdapter().getItem(i2);
        }
        p.a(this.b, obj);
        AdapterView.OnItemClickListener onItemClickListener = this.b.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i2 < 0) {
                o0 o0Var2 = this.b.f3112f;
                view = !o0Var2.c() ? null : o0Var2.f940d.getSelectedView();
                o0 o0Var3 = this.b.f3112f;
                i2 = !o0Var3.c() ? -1 : o0Var3.f940d.getSelectedItemPosition();
                o0 o0Var4 = this.b.f3112f;
                j2 = !o0Var4.c() ? Long.MIN_VALUE : o0Var4.f940d.getSelectedItemId();
            }
            onItemClickListener.onItemClick(this.b.f3112f.f940d, view, i2, j2);
        }
        this.b.f3112f.dismiss();
    }
}
