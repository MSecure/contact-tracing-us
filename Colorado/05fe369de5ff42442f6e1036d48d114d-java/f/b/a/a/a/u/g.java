package f.b.a.a.a.u;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;

public final /* synthetic */ class g implements f.b.b.a.g {
    public final /* synthetic */ SubmitPrivateAnalyticsWorker a;

    public /* synthetic */ g(SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker) {
        this.a = submitPrivateAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        SubmitPrivateAnalyticsWorker.b bVar = (SubmitPrivateAnalyticsWorker.b) obj;
        this.a.g();
        return new ListenableWorker.a.c();
    }
}
