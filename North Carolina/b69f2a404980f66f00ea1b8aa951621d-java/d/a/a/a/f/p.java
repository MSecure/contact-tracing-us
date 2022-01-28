package d.a.a.a.f;

import c.b.b.a.e;
import gov.nc.dhhs.exposurenotification.nearby.StateUpdatedWorker;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class p implements e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StateUpdatedWorker f4660a;

    public /* synthetic */ p(StateUpdatedWorker stateUpdatedWorker) {
        this.f4660a = stateUpdatedWorker;
    }

    @Override // c.b.b.a.e
    public final Object a(Object obj) {
        return Boolean.valueOf(this.f4660a.getDailySummaryScore((List) obj));
    }
}
