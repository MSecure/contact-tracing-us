package f.b.a.a.a.k;

import android.text.format.DateUtils;
import e.p.r;
import f.b.a.a.a.y.l0;
import gov.md.covid19.exposurenotifications.R;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class f implements r {
    public final /* synthetic */ n a;

    public /* synthetic */ f(n nVar) {
        this.a = nVar;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        n nVar = this.a;
        List list = (List) obj;
        Objects.requireNonNull(nVar);
        if (list.size() > 0) {
            nVar.a0.m.setVisibility(0);
            nVar.a0.q.setVisibility(0);
            CharSequence relativeDateTimeString = DateUtils.getRelativeDateTimeString(nVar.n0(), ((l0) list.get(0)).a().E(), 86400000, 0, 0);
            nVar.a0.m.setText(nVar.A(R.string.recent_check_last_checked, relativeDateTimeString));
        }
    }
}
