package f.b.a.a.a.u;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class h implements g {
    public final /* synthetic */ SubmitPrivateAnalyticsWorker a;

    public /* synthetic */ h(SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker) {
        this.a = submitPrivateAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker = this.a;
        Objects.requireNonNull(submitPrivateAnalyticsWorker);
        SubmitPrivateAnalyticsWorker.f423l.d("Failure to submit private analytics", (Exception) obj);
        submitPrivateAnalyticsWorker.g();
        return new ListenableWorker.a.C0003a();
    }
}
