package f.b.a.a.a.q;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker;
import f.b.a.a.a.v.p;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class y0 implements g {
    public final /* synthetic */ StateUpdatedWorker a;

    public /* synthetic */ y0(StateUpdatedWorker stateUpdatedWorker) {
        this.a = stateUpdatedWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        StateUpdatedWorker stateUpdatedWorker = this.a;
        Exception exc = (Exception) obj;
        Objects.requireNonNull(stateUpdatedWorker);
        StateUpdatedWorker.q.d("Failure to update app state (tokens, etc) from exposure summary.", exc);
        stateUpdatedWorker.n.k(p.d.TASK_STATE_UPDATED, exc);
        return new ListenableWorker.a.C0003a();
    }
}
