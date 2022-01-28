package f.b.a.a.a.f0;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import java.util.Objects;

public final /* synthetic */ class g implements f.b.b.a.g {
    public final /* synthetic */ SubmitPrivateAnalyticsWorker a;

    public /* synthetic */ g(SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker) {
        this.a = submitPrivateAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker = this.a;
        Objects.requireNonNull(submitPrivateAnalyticsWorker);
        SubmitPrivateAnalyticsWorker.n.d("Failure to submit private analytics", (Exception) obj);
        submitPrivateAnalyticsWorker.g();
        return new ListenableWorker.a.C0003a();
    }
}
