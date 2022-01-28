package c.b.a.a.g.e;

import c.b.a.a.d.k.o.e;
import com.google.android.gms.common.api.Status;

public final class ea extends ha<e<Status>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Status f3552a;

    public ea(Status status) {
        this.f3552a = status;
    }

    @Override // c.b.a.a.d.k.o.k.b
    public final /* synthetic */ void notifyListener(Object obj) {
        e eVar = (e) obj;
        if (this.f3552a.t()) {
            eVar.setResult(this.f3552a);
        } else {
            eVar.setFailedResult(this.f3552a);
        }
    }
}
