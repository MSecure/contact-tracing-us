package f.b.a.a.a.u;

import androidx.work.ListenableWorker;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import f.b.b.a.g;

public final /* synthetic */ class i implements g {
    public final /* synthetic */ SubmitPrivateAnalyticsWorker a;

    public /* synthetic */ i(SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker) {
        this.a = submitPrivateAnalyticsWorker;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        this.a.g();
        return new ListenableWorker.a.c();
    }
}
