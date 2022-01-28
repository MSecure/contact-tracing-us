package c.b.a.a.e.c;

import c.b.a.a.c.k.o.e;
import com.google.android.gms.common.api.Status;

public final class ea extends ha<e<Status>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Status f2567a;

    public ea(Status status) {
        this.f2567a = status;
    }

    @Override // c.b.a.a.c.k.o.k.b
    public final /* synthetic */ void notifyListener(Object obj) {
        e eVar = (e) obj;
        if (this.f2567a.p()) {
            eVar.setResult(this.f2567a);
        } else {
            eVar.setFailedResult(this.f2567a);
        }
    }
}
