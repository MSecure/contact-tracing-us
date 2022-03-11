package f.b.a.a.a.p;

import android.util.Log;
import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker;
import f.b.a.a.a.u.u;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class x implements g {
    public final /* synthetic */ StateUpdatedWorker a;

    public /* synthetic */ x(StateUpdatedWorker stateUpdatedWorker) {
        this.a = stateUpdatedWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        StateUpdatedWorker stateUpdatedWorker = this.a;
        Exception exc = (Exception) obj;
        Objects.requireNonNull(stateUpdatedWorker);
        Log.e("StateUpdatedWorker", "Failure to update app state (tokens, etc) from exposure summary.", exc);
        stateUpdatedWorker.o.k(u.d.TASK_STATE_UPDATED, exc);
        return new ListenableWorker.a.C0003a();
    }
}
