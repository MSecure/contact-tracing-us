package e.n.b;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import e.c0.w;
import java.util.Map;

public final class a extends w {
    public final Map<String, i.a.a<b<? extends ListenableWorker>>> b;

    public a(Map<String, i.a.a<b<? extends ListenableWorker>>> map) {
        this.b = map;
    }

    @Override // e.c0.w
    public ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
        i.a.a<b<? extends ListenableWorker>> aVar = this.b.get(str);
        if (aVar == null) {
            return null;
        }
        return aVar.get().a(context, workerParameters);
    }
}
