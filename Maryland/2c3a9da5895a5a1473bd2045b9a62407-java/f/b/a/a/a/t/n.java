package f.b.a.a.a.t;

import android.util.Log;
import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class n implements g {
    public final /* synthetic */ SubmitPrivateAnalyticsWorker a;

    public /* synthetic */ n(SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker) {
        this.a = submitPrivateAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker = this.a;
        Objects.requireNonNull(submitPrivateAnalyticsWorker);
        Log.e("PrioSubmitWorker", "Failure to submit private analytics", (Exception) obj);
        submitPrivateAnalyticsWorker.f407i.n(submitPrivateAnalyticsWorker.f408j.b());
        return new ListenableWorker.a.C0003a();
    }
}
