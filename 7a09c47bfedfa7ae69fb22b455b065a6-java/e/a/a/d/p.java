package e.a.a.d;

import c.b.b.a.e;
import gov.michigan.MiCovidExposure.nearby.StateUpdatedWorker;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class p implements e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StateUpdatedWorker f6272a;

    public /* synthetic */ p(StateUpdatedWorker stateUpdatedWorker) {
        this.f6272a = stateUpdatedWorker;
    }

    @Override // c.b.b.a.e
    public final Object a(Object obj) {
        return Boolean.valueOf(this.f6272a.getDailySummaryScore((List) obj));
    }
}
