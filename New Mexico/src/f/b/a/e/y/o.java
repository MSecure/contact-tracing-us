package f.b.a.e.y;

import android.view.View;
import android.widget.AdapterView;
import e.b.f.o0;
/* loaded from: classes.dex */
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
            o0 o0Var = pVar.f3154f;
            obj = !o0Var.c() ? null : o0Var.f1004d.getSelectedItem();
        } else {
            obj = pVar.getAdapter().getItem(i2);
        }
        p.a(this.b, obj);
        AdapterView.OnItemClickListener onItemClickListener = this.b.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i2 < 0) {
                o0 o0Var2 = this.b.f3154f;
                view = !o0Var2.c() ? null : o0Var2.f1004d.getSelectedView();
                o0 o0Var3 = this.b.f3154f;
                i2 = !o0Var3.c() ? -1 : o0Var3.f1004d.getSelectedItemPosition();
                o0 o0Var4 = this.b.f3154f;
                j2 = !o0Var4.c() ? Long.MIN_VALUE : o0Var4.f1004d.getSelectedItemId();
            }
            onItemClickListener.onItemClick(this.b.f3154f.f1004d, view, i2, j2);
        }
        this.b.f3154f.dismiss();
    }
}
