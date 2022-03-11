package f.b.a.e.l;

import android.view.View;
import f.b.a.e.l.i;
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    public final /* synthetic */ i b;

    public m(i iVar) {
        this.b = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar = this.b;
        i.e eVar = i.e.DAY;
        i.e eVar2 = iVar.b0;
        i.e eVar3 = i.e.YEAR;
        if (eVar2 == eVar3) {
            iVar.L0(eVar);
        } else if (eVar2 == eVar) {
            iVar.L0(eVar3);
        }
    }
}
